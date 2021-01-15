package org.leaguemodel.interfaces;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

public interface ILeagueGetSetDB {

    List<HashMap<String, Object>> getLeagueNameDB();

    List<HashMap<String, Object>> getTeamNameDB(String leagueName);

    void setLeagueTeamDataDB(List<Object> createLeagueList);

    void setPlayerDataDB(List<Object> playersList);

    void setGameplayConfigDB(List<Object> gameplayConfigList);

    void overwriteData();

    List<HashMap<String, Object>> getLeagueIDDB(String leagueName);

    List<HashMap<String, Object>> getConferencesDB(int leagueID);

    List<HashMap<String, Object>> getDivisionsDB(int conferenceID);

    List<HashMap<String, Object>> getTeamsDB(int divisionID);

    List<HashMap<String, Object>> getHeadCoachDB(int coachID);

    List<HashMap<String, Object>> getPlayersDB(int teamID);

    List<HashMap<String, Object>> getFreeAgentsDB();

    List<HashMap<String, Object>> getGameplayConfigDB(String leagueName);

    List<HashMap<String, Object>> getLeagueDate(String leagueName);

    List<HashMap<String, Object>> setLeagueDate(String leagueName, Date leagueDate);
}
