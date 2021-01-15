package resources;

import org.leaguemodel.*;
import org.leaguemodel.interfaces.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MockData implements ILeague, ILeagueGetSetDB, ILoadSaveTeam {

    public IPlayers playerOne = new Players("Forward", "Player one", false);
    public IPlayers playerTwo = new Players("Defense", "Player two", false);
    public IPlayers playerThree = new Players("Goalie", "Player three", true);
    public List<IPlayers> playerList = new ArrayList<>();
    public List<ITeam> teamsList = new ArrayList<>();
    public List<IDivisions> divisionList = new ArrayList<>();
    public List<IConference> conferenceList = new ArrayList<>();
    public List<String> managersList = new ArrayList();
    public IHeadCoach headCoach = new HeadCoach();
    public ITeam teamOne = new Team();
    public Divisions divisionOne = new Divisions();
    public IConference conferenceOne = new Conference();
    public ILeague leagueOne = new League();
    public List<IPlayers> freeAgents = new ArrayList<>();
    public IGameplayConfig gameConfig = new GameplayConfig();

    public MockData() {
        playerList.add(playerOne);
        playerList.add(playerTwo);
        playerList.add(playerThree);

        headCoach.setName("HeadCoach");
        headCoach.setChecking(2.4);
        headCoach.setSaving(3.1);
        headCoach.setShooting(1.2);
        headCoach.setSkating(0.5);
        ITeam teamOne = new Team("Team 12", "AI", "Mary Smith", headCoach, playerList);
        teamsList.add(teamOne);
        IDivisions divisionOne = new Divisions("Atlantic", teamsList);
        divisionList.add(divisionOne);
        IConference conferenceOne = new Conference("Eastern Conference", divisionList);
        conferenceList.add(conferenceOne);
        leagueOne = new League("Dalhousie Hockey League", conferenceList, playerList);
        managersList.add("Siddhant");
        managersList.add("Vikram");
        managersList.add("Yash");
        managersList.add("Kethan");
        ICoach coachA = new Coach();
        coachA.setName("A");
        coachA.setChecking(2.4);
        coachA.setSaving(3.1);
        coachA.setShooting(1.2);
        coachA.setSkating(0.5);

        ICoach coachB = new Coach();
        coachB.setName("B");
        coachB.setChecking(1.3);
        coachB.setSaving(1.4);
        coachB.setShooting(8.2);
        coachB.setSkating(4.5);

        List<ICoach> coachList = new ArrayList<>();
        coachList.add(coachA);
        coachList.add(coachB);

        ITraining training = new Training();
        training.setDaysUntilStatIncreaseCheck(0);
        gameConfig.setTraining(training);
        IAging age = new Aging();
        age.setAverageRetirementAge(0);
        age.setMaximumAge(0);
        gameConfig.setAging(age);
        IGameResolver resolver = new GameResolver();
        resolver.setRandomWinChance(0.0);
        IInjuries injury = new Injuries();
        injury.setInjuryDaysHigh(0);
        injury.setInjuryDaysLow(0);
        injury.setRandomInjuryChance(0.0);
        ITrading trading = new Trading();
        trading.setLossPoint(0);
        trading.setMaxPlayersPerTrade(0);
        trading.setRandomAcceptanceChance(0.0);
        trading.setRandomTradeOfferChance(0.0);
        gameConfig.setInjuries(injury);
        gameConfig.setGameResolver(resolver);
        gameConfig.setTrading(trading);
        leagueOne.setGameplayConfig(gameConfig);

        IPlayers agent1 = new FreeAgents("defence", "A1", 20, 10, 30, 10, 20);
        IPlayers agent2 = new FreeAgents("goalie", "A2", 30, 10, 40, 10, 80);
        IPlayers agent3 = new FreeAgents("forward", "A3", 20, 10, 30, 10, 20);
        IPlayers agent4 = new FreeAgents("goalie", "A4", 20, 60, 40, 10, 80);
        IPlayers agent5 = new FreeAgents("defence", "A5", 10, 10, 30, 10, 20);
        IPlayers agent6 = new FreeAgents("goalie", "A6", 20, 10, 40, 10, 80);
        IPlayers agent7 = new FreeAgents("defence", "A7", 20, 10, 30, 10, 20);
        IPlayers agent8 = new FreeAgents("defence", "A8", 20, 70, 40, 10, 80);
        IPlayers agent9 = new FreeAgents("defence", "A9", 10, 10, 30, 10, 20);
        IPlayers agent10 = new FreeAgents("defence", "A10", 20, 10, 90, 10, 80);
        IPlayers agent11 = new FreeAgents("defence", "A11", 20, 10, 30, 10, 20);
        IPlayers agent12 = new FreeAgents("defence", "A12", 20, 10, 40, 60, 80);
        IPlayers agent13 = new FreeAgents("defence", "A13", 20, 30, 30, 10, 20);
        IPlayers agent14 = new FreeAgents("defence", "A14", 20, 10, 40, 10, 80);
        IPlayers agent15 = new FreeAgents("defence", "A15", 20, 10, 30, 10, 20);
        IPlayers agent16 = new FreeAgents("defence", "A16", 80, 10, 40, 10, 80);
        IPlayers agent17 = new FreeAgents("defence", "A17", 20, 10, 90, 10, 20);
        IPlayers agent18 = new FreeAgents("defence", "A18", 20, 10, 40, 10, 80);
        IPlayers agent19 = new FreeAgents("defence", "A19", 20, 10, 30, 10, 20);
        IPlayers agent20 = new FreeAgents("defence", "A20", 40, 10, 40, 10, 80);
        IPlayers agent21 = new FreeAgents("defence", "A21", 20, 10, 50, 10, 20);
        IPlayers agent22 = new FreeAgents("defence", "A22", 30, 10, 40, 10, 80);
        IPlayers agent23 = new FreeAgents("defence", "A23", 20, 10, 30, 10, 20);
        IPlayers agent24 = new FreeAgents("defence", "A24", 20, 00, 40, 10, 80);
        IPlayers agent25 = new FreeAgents("defence", "A25", 20, 30, 30, 10, 20);
        IPlayers agent26 = new FreeAgents("goalie", "A26", 20, 10, 40, 10, 80);
        freeAgents.add(agent1);
        freeAgents.add(agent2);
        freeAgents.add(agent3);
        freeAgents.add(agent4);
        freeAgents.add(agent5);
        freeAgents.add(agent6);
        freeAgents.add(agent7);
        freeAgents.add(agent8);
        freeAgents.add(agent9);
        freeAgents.add(agent10);
        freeAgents.add(agent11);
        freeAgents.add(agent12);
        freeAgents.add(agent13);
        freeAgents.add(agent14);
        freeAgents.add(agent15);
        freeAgents.add(agent16);
        freeAgents.add(agent17);
        freeAgents.add(agent18);
        freeAgents.add(agent19);
        freeAgents.add(agent20);
        freeAgents.add(agent21);
        freeAgents.add(agent22);
        freeAgents.add(agent23);
        freeAgents.add(agent24);
        freeAgents.add(agent25);
        freeAgents.add(agent26);

        leagueOne.setFreeAgents(freeAgents);
        leagueOne.setGeneralManagers(managersList);
        leagueOne.setCoaches(coachList);
        leagueOne.setFreeAgents(freeAgents);
    }

    public ArrayList<HashMap<String, Object>> getLeagueNameDB() {
        ArrayList<HashMap<String, Object>> list = new ArrayList();
        HashMap<String, Object> map = new HashMap<>();
        map.put("league_name", leagueOne.getLeagueName());
        list.add(map);
        return list;
    }

    public List<HashMap<String, Object>> getTeamNameDB(String leagueName) {
        ArrayList<HashMap<String, Object>> list = new ArrayList();
        HashMap<String, Object> map = new HashMap<>();
        map.put("team_name", leagueOne.getConference().get(0).getDivisions().get(0).getTeams().get(0).getTeamName());
        list.add(map);
        return list;
    }

    @Override
    public void setLeagueTeamDataDB(List<Object> createLeagueList) {
    }

    @Override
    public void setPlayerDataDB(List<Object> playersList) {

    }

    @Override
    public void setGameplayConfigDB(List<Object> gameplayConfigList) {

    }

    @Override
    public void overwriteData() {

    }

    @Override
    public List<HashMap<String, Object>> getLeagueIDDB(String leagueName) {
        return null;
    }

    @Override
    public List<HashMap<String, Object>> getConferencesDB(int leagueID) {
        return null;
    }

    @Override
    public List<HashMap<String, Object>> getDivisionsDB(int conferenceID) {
        return null;
    }

    @Override
    public List<HashMap<String, Object>> getTeamsDB(int divisionID) {
        return null;
    }

    @Override
    public List<HashMap<String, Object>> getHeadCoachDB(int coachID) {
        return null;
    }

    @Override
    public List<HashMap<String, Object>> getPlayersDB(int teamID) {
        return null;
    }

    @Override
    public List<HashMap<String, Object>> getFreeAgentsDB() {
        return null;
    }

    @Override
    public List<HashMap<String, Object>> getGameplayConfigDB(String leagueName) {
        ArrayList<HashMap<String, Object>> list = new ArrayList();
        HashMap<String, Object> map = new HashMap<>();
        map.put("average_retirement_age", gameConfig.getAging().getAverageRetirementAge());
        map.put("maximum_age", gameConfig.getAging().getMaximumAge());
        map.put("random_win_chance", gameConfig.getGameResolver().getRandomWinChance());
        map.put("random_injury_chance", gameConfig.getInjuries().getRandomInjuryChance());
        map.put("injury_days_low", gameConfig.getInjuries().getInjuryDaysLow());
        map.put("injury_days_high", gameConfig.getInjuries().getInjuryDaysLow());

        map.put("days_until_stat_increase_check", 205);
        map.put("loss_point", 2);
        map.put("random_trade_offer_chance", 0.5);
        map.put("max_players_per_trade", 5);
        map.put("random_acceptance_chance", 0.8);
        map.put("team_name", "team 12");
        map.put("conference_name", gameConfig.getAging().getAverageRetirementAge());
        map.put("conference_id", gameConfig.getAging().getAverageRetirementAge());
        map.put("division_name", gameConfig.getAging().getAverageRetirementAge());
        map.put("manager_name", gameConfig.getAging().getAverageRetirementAge());
        map.put("team_type", gameConfig.getAging().getAverageRetirementAge());
        map.put("coach_name", gameConfig.getAging().getAverageRetirementAge());
        map.put("coach_shooting", gameConfig.getAging().getAverageRetirementAge());
        map.put("coach_skating", gameConfig.getAging().getAverageRetirementAge());
        map.put("coach_checking", gameConfig.getAging().getMaximumAge());
        map.put("coach_saving", gameConfig.getGameResolver().getRandomWinChance());
        map.put("player_name", gameConfig.getAging().getAverageRetirementAge());
        map.put("position", gameConfig.getAging().getAverageRetirementAge());
        map.put("age", gameConfig.getAging().getAverageRetirementAge());
        map.put("is_captain", gameConfig.getAging().getAverageRetirementAge());
        map.put("league_id", 1);
        list.add(map);
        return list;
    }

    @Override
    public List<HashMap<String, Object>> getLeagueDate(String leagueName) {
        return null;
    }

    @Override
    public List<HashMap<String, Object>> setLeagueDate(String leagueName, Date leagueDate) {
        return null;
    }

    public void setPlayerData(List<Object> playerList) {
        IPlayers agent1 = new FreeAgents("defence", "A1", 20, 10, 30, 10, 20);
    }

    public List<HashMap<String, Object>> getTeamName(String leagueName) {
        ArrayList<HashMap<String, Object>> list = new ArrayList();
        HashMap<String, Object> map = new HashMap<>();
        map.put(leagueOne.getConference().get(0).getDivisions().get(0).getTeams().get(0).getTeamName(), null);
        list.add(map);
        return list;
    }

    @Override
    public void saveTeam(ILeague league, ILeagueGetSetDB databaseObj) {

    }

    @Override
    public ILeague loadTeam(String leagueName, String teamName, ILeague league, ILeagueGetSetDB db) {
        MockData mockData = new MockData();
        mockData.leagueOne.setLeagueName("Dalhousie Hockey League");
        return mockData.leagueOne;
    }

    @Override
    public ILeague appendTeam(String divisionName, String conferenceName, ITeam team, ILeague league) {
        return null;
    }

    @Override
    public String getLeagueName() {
        return leagueOne.getLeagueName();
    }

    @Override
    public void setLeagueName(String leagueName) {

    }

    @Override
    public IGameplayConfig getGameplayConfig() {
        return null;
    }

    @Override
    public void setGameplayConfig(IGameplayConfig gameplayConfig) {

    }

    @Override
    public List<IConference> getConference() {
        return null;
    }

    @Override
    public void setConference(List<IConference> conference) {

    }

    @Override
    public List<IPlayers> getFreeAgents() {
        return null;
    }

    @Override
    public void setFreeAgents(List<IPlayers> freeAgents) {

    }

    @Override
    public List<ICoach> getCoaches() {
        return leagueOne.getCoaches();
    }

    @Override
    public void setCoaches(List<ICoach> coaches) {

    }

    @Override
    public List<String> getGeneralManagers() {
        return managersList;
    }

    @Override
    public void setGeneralManagers(List<String> generalManagers) {

    }
}
