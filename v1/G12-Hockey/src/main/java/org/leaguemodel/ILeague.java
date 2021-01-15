package org.leaguemodel;

import java.util.List;

//League Interface
public interface ILeague {
	public League getLeaguePlayerData(String leagueName,String teamName);
	public Boolean setLeagueTeamData(String leagueName, String conferenceName, String divisionName, String managerName, String coachName,String teamName);
	public Boolean setPlayerData(String playerName,String leagueName, String teamName, String position, Boolean captain);
	public List getTeamName(String leagueName);
	public List getLeagueName();
}
