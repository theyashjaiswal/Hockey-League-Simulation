package org.statemachine;

import org.leaguemodel.*;
import org.leaguemodel.interfaces.*;
import org.leaguesimulation.*;
import org.leaguesimulation.interfaces.IPlayOffScoreboard;
import org.leaguesimulation.interfaces.IScoreboard;
import org.leaguesimulation.interfaces.ISeed;
import org.statemachine.interfaces.ILeagueDateDB;
import org.statemachine.interfaces.IStateMachine;
import org.statemachine.interfaces.ITrainingSystem;
import org.trading.TradeOffer;
import org.trading.interfaces.ITradeOffer;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LeagueSimulationStateMachine implements IStateMachine, ILeagueDateDB {

    ILeague league;
    Display display;
    Date currentDate;

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(LocalDate currentDate) {
        this.currentDate = Date.valueOf(currentDate);
    }

    public LeagueSimulationStateMachine() {
        display = new Display();
    }

    public LeagueSimulationStateMachine(ILeague league) {
        this.league = league;
        display = new Display();
    }

    @Override
    public void runStateMachine() {
        LeagueScoreboard leagueScoreboard = new LeagueScoreboard(league);
        leagueScoreboard.loadScoreboard();
        RegularSeasonScheduler regularSeasonScheduler = new RegularSeasonScheduler(leagueScoreboard);
        LeagueTimeline leagueTimeline = new LeagueTimeline(getLeagueStartDate(league));
        leagueTimeline.setCurrentDateFromDB(league.getLeagueName());
        LocalDate newSeasonDate = LocalDate.of(leagueTimeline.getCurrentDate().getYear(), Month.SEPTEMBER,30);
        leagueTimeline.setCurrentDate(newSeasonDate);
        List<Game> regularSeasonGames = regularSeasonScheduler.schedule(82);
        List<Game> playOffGames = new ArrayList<>();
        boolean stanleyCupWinnerNotDecided = true;
        PlayOffScheduler playOffScheduler = null;
        IScoreboard leaguePlayOff = null;
        int expectedNumberOfPlayOffMatches = 16*7;

        while (stanleyCupWinnerNotDecided){
            leagueTimeline.incrementDateByOne();
            display.printDate(leagueTimeline.getCurrentDate());
            if(!leagueTimeline.isRegularSeason() && playOffScheduler == null){
                leaguePlayOff = new LeaguePlayOff(leagueScoreboard);
                leaguePlayOff.loadScoreboard();
                seedLeaguePlayOff((ISeed) leaguePlayOff);
                initiateLeaguePlayOffTeamsScore((IPlayOffScoreboard) leaguePlayOff);
                playOffScheduler = new PlayOffScheduler(leaguePlayOff);
                playOffGames = playOffScheduler.schedule(7);
            }

            simulateRegularSeasonMatches(leagueTimeline, regularSeasonGames, (IScoreboard) leagueScoreboard);
            if(leagueTimeline.isTradePossible()){
                ITradeOffer tradeOffer = new TradeOffer();
                tradeOffer.generateTradeOffer((IScoreboard)leagueScoreboard, league);
            }

            if(playOffGames.size()>0){
                expectedNumberOfPlayOffMatches = simulatePlayOffMatches(leagueTimeline, playOffGames, expectedNumberOfPlayOffMatches);
            }

            if(regularSeasonGames.isEmpty() && playOffGames.isEmpty() && Objects.nonNull(playOffScheduler)){
                playOffGames = playOffScheduler.schedule(7);
                IPlayOffScoreboard leaguePlayOffScoreboard = (IPlayOffScoreboard) leaguePlayOff;

               if (Objects.isNull(leaguePlayOffScoreboard.getWinner())){
                   leaguePlayOffScoreboard.checkWinner();
               } else {
                   stanleyCupWinnerNotDecided = false;
                   display.printPlayOffSeason((IScoreboard) leaguePlayOffScoreboard);
                   display.printWinner(leaguePlayOffScoreboard.getWinner());
               }
            }

            IInjurySystem injurySystem = new InjurySystem();
            IAging aging = league.getGameplayConfig().getAging();
            IAgingSystem agingSystem = new AgingSystem();
            IPlayerReplacement playerReplacement = new PlayerReplacement();
            AgingEngine agingEngine = new AgingEngine(injurySystem, aging, agingSystem, playerReplacement);
            agingEngine.initAging(league, leagueTimeline.daysPassedInLeague());
            setCurrentDate(leagueTimeline.getCurrentDate());
        }

    }

    private void simulateRegularSeasonMatches(LeagueTimeline leagueTimeline, List<Game> regularSeasonGames, IScoreboard leagueScoreboard) {
        if(leagueTimeline.isRegularSeason()){
            int j = 0;
            int numberOfMatchesPerDay = calculateNumberOfRegularMatchesPerDay(leagueTimeline, regularSeasonGames);
            while(j<numberOfMatchesPerDay){
                IInjuries injuries = executeStatistics(regularSeasonGames);
                display.printGame(regularSeasonGames.get(0).getTeamOne().getTeam(), regularSeasonGames.get(0).getTeamTwo().getTeam());
                regularSeasonGames.get(0).executeGame(league.getGameplayConfig());
                executeInjurySystem(regularSeasonGames, injuries);
                regularSeasonGames.remove(0);
                j++;
            }
            if(regularSeasonGames.isEmpty()){
                display.printRegularSeason(leagueScoreboard);
            }
        }
    }

    private int simulatePlayOffMatches(LeagueTimeline leagueTimeline, List<Game> playOffGames, int expectedMatches){
        int j = 0;
        int numberOfMatchesPerDay = calculateNumberOfPlayOffMatchesPerDay(leagueTimeline, expectedMatches);
        while(j<numberOfMatchesPerDay && playOffGames.size()>0){
            IInjuries injuries = executeStatistics(playOffGames);
            playOffGames.get(0).executeGame(league.getGameplayConfig());
            executeInjurySystem(playOffGames, injuries);
            playOffGames.remove(0);
            expectedMatches--;
            j++;
        }
        return expectedMatches;
    }

    private void executeInjurySystem(List<Game> games, IInjuries injuries) {
        IInjurySystem iInjurySystem = new InjurySystem();
        iInjurySystem.checkTeamInjuries(games.get(0).getTeamOne().getTeam(), injuries);
        iInjurySystem.checkTeamInjuries(games.get(0).getTeamTwo().getTeam(), injuries);
        System.out.println(games.get(0).getTeamOne().getTeam().getPlayers().get(0).getNoOfDaysInjured() + " Injury Check!!");
    }

    private IInjuries executeStatistics(List<Game> games) {
        ITrainingSystem iTraining = new TrainingSystem();
        IInjuries injuries = league.getGameplayConfig().getInjuries();
        iTraining.CheckStatistics(injuries, games.get(0).getTeamOne().getTeam());
        iTraining.CheckStatistics(injuries, games.get(0).getTeamTwo().getTeam());
        System.out.println(games.get(0).getTeamOne().getTeam().getPlayers().get(0).getSkating() + " Stat Increased - Training Done!!");
        return injuries;
    }

    private int calculateNumberOfPlayOffMatchesPerDay(LeagueTimeline leagueTimeline, int expectedMatches){
        int numberOfMatchesPerDay = expectedMatches / leagueTimeline.daysLeftOfPlayOffSeason();
        return numberOfMatchesPerDay < 1 ? 1 : numberOfMatchesPerDay;
    }

    private void seedLeaguePlayOff(ISeed leaguePlayOff) {
        ISeed seedLeague = leaguePlayOff;
        seedLeague.seed(2);
    }

    private void initiateLeaguePlayOffTeamsScore(IPlayOffScoreboard leagueScoreboard) {
        IPlayOffScoreboard leaguePlayOffScoreboard = leagueScoreboard;
        leaguePlayOffScoreboard.initiateScoreToZero();
    }

    private int calculateNumberOfRegularMatchesPerDay(LeagueTimeline leagueTimeline, List<Game> regularSeasonGames) {
        int numberOfMatchesPerDay = regularSeasonGames.size() / leagueTimeline.daysLeftOfRegularSeason();
        return numberOfMatchesPerDay < 1 ? 1 : numberOfMatchesPerDay;
    }

    private LocalDate getLeagueStartDate(ILeague league){
        LeagueDateFromDB leagueDateFromDB = new LeagueDateFromDB(league.getLeagueName());
        return leagueDateFromDB.getLeagueDate();
    }
}
