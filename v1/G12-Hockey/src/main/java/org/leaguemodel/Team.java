package org.leaguemodel;

import java.util.ArrayList;

//Team Model Class
public class Team {

	private String teamName;
	private String generalManager;
	private String headCoach;
	private ArrayList<Players> Players;
	
	public Team()
	{
		this.teamName = null;
		this.generalManager = null;
		this.headCoach = null;
		Players = null;
	}
	public Team(String teamName, String generalManager, String headCoach, ArrayList<Players> players) {

		this.teamName = teamName;
		this.generalManager = generalManager;
		this.headCoach = headCoach;
		Players = players;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getGeneralManager() {
		return generalManager;
	}

	public void setGeneralManager(String generalManager) {
		this.generalManager = generalManager;
	}

	public String getHeadCoach() {
		return headCoach;
	}

	public void setHeadCoach(String headCoach) {
		this.headCoach = headCoach;
	}

	public ArrayList<Players> getPlayers() {
		return Players;
	}

	public void setPlayers(ArrayList<Players> players) {
		Players = players;
	}
	
	public boolean validateTeamName(String teamName, League league)
	{
		for(int i = 0; i<league.getConference().size(); i++)
		{
			for(int j = 0; j<league.getConference().get(i).getDivisions().size(); j++)
			{
				for(int k = 0; k<league.getConference().get(i).getDivisions().get(j).getTeams().size();k++)
				{
					if(league.getConference().get(i).getDivisions().get(j).getTeams().get(k).getTeamName().equalsIgnoreCase(teamName))
					{
						return true;
					}
				}
			}
		}
		return false;
	}

}
