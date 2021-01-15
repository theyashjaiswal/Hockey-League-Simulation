package org.leaguemodel;

import org.leaguemodel.interfaces.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LoadSaveTeamToDB implements ILoadSaveTeam {
    enum Database {
        average_retirement_age, maximum_age, random_win_chance, random_injury_chance, injury_days_low, injury_days_high,
        days_until_stat_increase_check, loss_point, random_trade_offer_chance, max_players_per_trade, random_acceptance_chance,
        league_id, conference_id, division_id, coach_id, team_name, manager_name, team_type, coach_name, conference_name, division_name,
        coach_shooting, coach_skating, coach_checking, coach_saving, team_id, player_name, position,
        age, is_captain, shooting, skating, checking, saving
    }
    public void saveTeam(ILeague league, ILeagueGetSetDB databaseObj) {
        overWriteData(databaseObj);
        String leagueName = league.getLeagueName();
        boolean isFreeAgent;
        boolean captain;
        String teamName;
        int noOfDaysInjured;
        for (int i = 0; i < league.getConference().size(); i++) {
            for (int j = 0; j < league.getConference().get(i).getDivisions().size(); j++) {
                for (int k = 0; k < league.getConference().get(i).getDivisions().get(j).getTeams().size(); k++) {
                    String conferenceName = league.getConference().get(i).getConferenceName();
                    String divisionName = league.getConference().get(i).getDivisions().get(j).getDivisionName();
                    String managerName = league.getConference().get(i).getDivisions().get(j).getTeams().get(k).getGeneralManager();
                    String headCoachName = league.getConference().get(i).getDivisions().get(j).getTeams().get(k).getHeadCoach().getName();
                    double headCoachSkating = league.getConference().get(i).getDivisions().get(j).getTeams().get(k).getHeadCoach().getSkating();
                    double headCoachShooting = league.getConference().get(i).getDivisions().get(j).getTeams().get(k).getHeadCoach().getShooting();
                    double headCoachSaving = league.getConference().get(i).getDivisions().get(j).getTeams().get(k).getHeadCoach().getSaving();
                    double headCoachChecking = league.getConference().get(i).getDivisions().get(j).getTeams().get(k).getHeadCoach().getChecking();
                    teamName = league.getConference().get(i).getDivisions().get(j).getTeams().get(k).getTeamName();
                    String teamType = league.getConference().get(i).getDivisions().get(j).getTeams().get(k).getTeamType();
                    List<Object> createLeagueList = new ArrayList<>();
                    createLeagueList.add(leagueName);
                    createLeagueList.add(conferenceName);
                    createLeagueList.add(divisionName);
                    createLeagueList.add(managerName);
                    createLeagueList.add(headCoachName);
                    createLeagueList.add(headCoachSkating);
                    createLeagueList.add(headCoachShooting);
                    createLeagueList.add(headCoachChecking);
                    createLeagueList.add(headCoachSaving);
                    createLeagueList.add(teamName);
                    createLeagueList.add(teamType);
                    databaseObj.setLeagueTeamDataDB(createLeagueList);
                    for (int l = 0; l < league.getConference().get(i).getDivisions().get(j).getTeams().get(k).getPlayers().size(); l++) {
                        String playerName = league.getConference().get(i).getDivisions().get(j).getTeams().get(k).getPlayers().get(l).getPlayerName();
                        String playerPosition = league.getConference().get(i).getDivisions().get(j).getTeams().get(k).getPlayers().get(l).getPlayerPosition();
                        captain = league.getConference().get(i).getDivisions().get(j).getTeams().get(k).getPlayers().get(l).isCaptain();
                        int playerSkating = league.getConference().get(i).getDivisions().get(j).getTeams().get(k).getPlayers().get(l).getSkating();
                        int playerAge = league.getConference().get(i).getDivisions().get(j).getTeams().get(k).getPlayers().get(l).getAge();
                        int playerShooting = league.getConference().get(i).getDivisions().get(j).getTeams().get(k).getPlayers().get(l).getShooting();
                        int playerChecking = league.getConference().get(i).getDivisions().get(j).getTeams().get(k).getPlayers().get(l).getChecking();
                        int playerSaving = league.getConference().get(i).getDivisions().get(j).getTeams().get(k).getPlayers().get(l).getSaving();
                        boolean isPlayerRetired = league.getConference().get(i).getDivisions().get(j).getTeams().get(k).getPlayers().get(l).isRetired();
                        isFreeAgent = false;
                        noOfDaysInjured = league.getConference().get(i).getDivisions().get(j).getTeams().get(k).getPlayers().get(l).getNoOfDaysInjured();
                        List<Object> playersList = new ArrayList<>();
                        playersList.add(playerName);
                        playersList.add(leagueName);
                        playersList.add(teamName);
                        playersList.add(playerPosition);
                        playersList.add(captain);
                        playersList.add(isPlayerRetired);
                        playersList.add(isFreeAgent);
                        playersList.add(playerAge);
                        playersList.add(playerSkating);
                        playersList.add(playerShooting);
                        playersList.add(playerChecking);
                        playersList.add(playerSaving);
                        playersList.add(noOfDaysInjured);
                        databaseObj.setPlayerDataDB(playersList);
                    }
                }
            }
        }
        for (int i = 0; i < league.getFreeAgents().size(); i++) {
            String playerName = league.getFreeAgents().get(i).getPlayerName();
            String playerPosition = league.getFreeAgents().get(i).getPlayerPosition();
            int playerSkating = league.getFreeAgents().get(i).getSkating();
            int playerChecking = league.getFreeAgents().get(i).getChecking();
            int playerShooting = league.getFreeAgents().get(i).getShooting();
            int playerSaving = league.getFreeAgents().get(i).getSaving();
            int playerAge = league.getFreeAgents().get(i).getAge();
            boolean isPlayerRetired = league.getFreeAgents().get(i).isRetired();
            isFreeAgent = true;
            captain = false;
            teamName = null;
            noOfDaysInjured = league.getFreeAgents().get(i).getNoOfDaysInjured();
            List<Object> playersList = new ArrayList<>();
            playersList.add(playerName);
            playersList.add(leagueName);
            playersList.add(teamName);
            playersList.add(playerPosition);
            playersList.add(captain);
            playersList.add(isPlayerRetired);
            playersList.add(isFreeAgent);
            playersList.add(playerAge);
            playersList.add(playerSkating);
            playersList.add(playerShooting);
            playersList.add(playerChecking);
            playersList.add(playerSaving);
            playersList.add(noOfDaysInjured);
            databaseObj.setPlayerDataDB(playersList);
        }
        insertGameConfig(league, databaseObj);
    }

    @Override
    public ILeague loadTeam(String leagueName, String teamName, ILeague league, ILeagueGetSetDB db) {

        List<IConference> conferenceList = new ArrayList<>();
        IConference conference = new Conference();
        IGameplayConfig gameplayConfig = new GameplayConfig();
        IAging aging = new Aging();
        List<HashMap<String, Object>> gameplayConf = db.getGameplayConfigDB(leagueName);

        int averageRetirementAge = (int) gameplayConf.get(0).get(Database.average_retirement_age.toString());
        int maximumAge = (int) gameplayConf.get(0).get(Database.maximum_age.toString());
        aging.setAverageRetirementAge(averageRetirementAge);
        aging.setMaximumAge(maximumAge);
        gameplayConfig.setAging(aging);

        IGameResolver gameResolver = new GameResolver();
        double randomWinChance = (double) gameplayConf.get(0).get(Database.random_win_chance.toString());
        gameResolver.setRandomWinChance(randomWinChance);
        gameplayConfig.setGameResolver(gameResolver);

        IInjuries injuries = new Injuries();
        double randomInjuryChance = (double) gameplayConf.get(0).get(Database.random_injury_chance.toString());
        int injuryDaysLow = (int) gameplayConf.get(0).get(Database.injury_days_low.toString());
        int injuryDaysHigh = (int) gameplayConf.get(0).get(Database.injury_days_high.toString());
        injuries.setRandomInjuryChance(randomInjuryChance);
        injuries.setInjuryDaysLow(injuryDaysLow);
        injuries.setInjuryDaysHigh(injuryDaysHigh);
        gameplayConfig.setInjuries(injuries);

        ITraining training = new Training();
        int daysUntilStatIncreaseCheck = (int) gameplayConf.get(0).get(Database.days_until_stat_increase_check.toString());
        training.setDaysUntilStatIncreaseCheck(daysUntilStatIncreaseCheck);
        gameplayConfig.setTraining(training);

        ITrading trading = new Trading();

        int lossPoint = (int) gameplayConf.get(0).get(Database.loss_point.toString());
        double randomTradeOfferChance = (double) gameplayConf.get(0).get(Database.random_trade_offer_chance.toString());
        int maxPlayersPerTrade = (int) gameplayConf.get(0).get(Database.max_players_per_trade.toString());
        double randomAcceptanceChance = (double) gameplayConf.get(0).get(Database.random_acceptance_chance.toString());
        trading.setLossPoint(lossPoint);
        trading.setMaxPlayersPerTrade(maxPlayersPerTrade);
        trading.setRandomAcceptanceChance(randomAcceptanceChance);
        trading.setRandomTradeOfferChance(randomTradeOfferChance);
        gameplayConfig.setTrading(trading);

        List<HashMap<String, Object>> leagueID = db.getLeagueIDDB(leagueName);
        List<HashMap<String, Object>> conferences = db.getConferencesDB((int) leagueID.get(0).get(Database.league_id.toString()));
        league.setLeagueName(leagueName);
        league.setConference(conferenceList);
        league.setGameplayConfig(gameplayConfig);
        for (int i = 0; i < conferences.size(); i++) {
            conference.setConferenceName((String) conferences.get(i).get(Database.conference_name.toString()));
            List<HashMap<String, Object>> divisions = db.getDivisionsDB((int) conferences.get(i).get(Database.conference_id.toString()));
            List<IDivisions> divisionList = new ArrayList<>();
            conferenceList.add(conference);
            conference.setDivisions(divisionList);
            for (int j = 0; j < divisions.size(); j++) {
                IDivisions division = new Divisions();
                division.setDivisionName((String) divisions.get(j).get(Database.division_name.toString()));
                List<HashMap<String, Object>> teams = db.getTeamsDB((int) divisions.get(j).get(Database.division_id.toString()));
                List<ITeam> teamList = new ArrayList<>();
                divisionList.add(division);
                division.setTeams(teamList);
                for (int k = 0; k < teams.size(); k++) {
                    ITeam team = new Team();
                    team.setTeamName((String) teams.get(k).get(Database.team_name.toString()));
                    team.setGeneralManager((String) teams.get(k).get(Database.manager_name.toString()));
                    team.setTeamType((String) teams.get(k).get(Database.team_type.toString()));
                    List<HashMap<String, Object>> headC = db.getHeadCoachDB((int) teams.get(k).get(Database.coach_id.toString()));
                    IHeadCoach headCoach = new HeadCoach();
                    headCoach.setName((String) headC.get(0).get(Database.coach_name.toString()));
                    headCoach.setShooting((Double) headC.get(0).get(Database.coach_shooting.toString()));
                    headCoach.setSkating((Double) headC.get(0).get(Database.coach_skating.toString()));
                    headCoach.setChecking((Double) headC.get(0).get(Database.coach_checking.toString()));
                    headCoach.setSaving((Double) headC.get(0).get(Database.coach_saving.toString()));
                    team.setHeadCoach(headCoach);
                    List<HashMap<String, Object>> players = db.getPlayersDB((int) teams.get(k).get(Database.team_id.toString()));
                    List<IPlayers> playerList = new ArrayList<>();
                    team.setPlayers(playerList);
                    teamList.add(team);
                    for (int l = 0; l < players.size(); l++) {
                        IPlayers player = new Players();
                        player.setPlayerName((String) players.get(l).get(Database.player_name.toString()));
                        player.setPlayerPosition((String) players.get(l).get(Database.position.toString()));
                        player.setAge((int) players.get(l).get(Database.age.toString()));
                        if ((int) players.get(l).get(Database.is_captain.toString()) == 1) {
                            player.setCaptain(true);
                        } else {
                            player.setCaptain(false);
                        }
                        player.setShooting((int) players.get(l).get(Database.shooting.toString()));
                        player.setSkating((int) players.get(l).get(Database.skating.toString()));
                        player.setChecking((int) players.get(l).get(Database.checking.toString()));
                        player.setSaving((int) players.get(l).get(Database.saving.toString()));
                        playerList.add(player);
                    }
                }
            }
        }
        List<IPlayers> freeAgentsArrayListLOM = new ArrayList<>();
        league.setFreeAgents(freeAgentsArrayListLOM);
        List<HashMap<String, Object>> freeAgents = db.getFreeAgentsDB();
        for (int i = 0; i < freeAgents.size(); i++) {
            IPlayers freeAgentsLOM = new FreeAgents();
            freeAgentsLOM.setPlayerName((String) freeAgents.get(i).get(Database.player_name.toString()));
            freeAgentsLOM.setPlayerPosition((String) freeAgents.get(i).get(Database.position.toString()));
            freeAgentsLOM.setAge((int) freeAgents.get(i).get(Database.age.toString()));
            freeAgentsLOM.setSkating((int) freeAgents.get(i).get(Database.skating.toString()));
            freeAgentsLOM.setShooting((int) freeAgents.get(i).get(Database.shooting.toString()));
            freeAgentsLOM.setChecking((int) freeAgents.get(i).get(Database.checking.toString()));
            freeAgentsLOM.setSaving((int) freeAgents.get(i).get(Database.saving.toString()));
            freeAgentsArrayListLOM.add(freeAgentsLOM);
        }
        return league;
    }

    @Override
    public ILeague appendTeam(String divisionName, String conferenceName, ITeam team, ILeague league) {
        for (int i = 0; i < league.getConference().size(); i++) {
            if (league.getConference().get(i).getConferenceName().equalsIgnoreCase(conferenceName)) {
                for (int j = 0; j < league.getConference().get(i).getDivisions().size(); j++) {
                    if (league.getConference().get(i).getDivisions().get(j).getDivisionName().equalsIgnoreCase(divisionName)) {
                        league.getConference().get(i).getDivisions().get(j).getTeams().add(team);
                        return league;
                    }
                }
            }
        }
        return null;
    }

    public void insertGameConfig(ILeague league, ILeagueGetSetDB databaseObj) {
        String leagueName = league.getLeagueName();
        int averageRetirmentAge = league.getGameplayConfig().getAging().getAverageRetirementAge();
        int maximumAge = league.getGameplayConfig().getAging().getMaximumAge();
        double randomWinChance = league.getGameplayConfig().getGameResolver().getRandomWinChance();
        double randomInjuryChance = league.getGameplayConfig().getInjuries().getRandomInjuryChance();
        int injuryDaysLow = league.getGameplayConfig().getInjuries().getInjuryDaysLow();
        int injuryDaysHigh = league.getGameplayConfig().getInjuries().getInjuryDaysHigh();
        int daysUntilStatIncreaseCheck = league.getGameplayConfig().getTraining().getDaysUntilStatIncreaseCheck();
        int lossPoint = league.getGameplayConfig().getTrading().getLossPoint();
        double randomTradeOfferChance = league.getGameplayConfig().getTrading().getRandomTradeOfferChance();
        int maxPlayersPerTrade = league.getGameplayConfig().getTrading().getMaxPlayersPerTrade();
        double randomAcceptanceChance = league.getGameplayConfig().getTrading().getRandomAcceptanceChance();
        List<Object> gameConfigList = new ArrayList<>();
        gameConfigList.add(leagueName);
        gameConfigList.add(averageRetirmentAge);
        gameConfigList.add(maximumAge);
        gameConfigList.add(randomWinChance);
        gameConfigList.add(randomInjuryChance);
        gameConfigList.add(injuryDaysLow);
        gameConfigList.add(injuryDaysHigh);
        gameConfigList.add(daysUntilStatIncreaseCheck);
        gameConfigList.add(lossPoint);
        gameConfigList.add(randomTradeOfferChance);
        gameConfigList.add(maxPlayersPerTrade);
        gameConfigList.add(randomAcceptanceChance);
        databaseObj.setGameplayConfigDB(gameConfigList);
    }

    public void overWriteData(ILeagueGetSetDB databaseObj) {
        databaseObj.overwriteData();
    }

}
