package org.leaguemodel;
import org.database.Database;

import java.util.ArrayList;

//League Model Class
public class League {

	private String leagueName;
	private ArrayList<Conference> conference;
	private ArrayList<Players> freeagent;
	private ArrayList<FreeAgents> freeAgents;
	
	public League()
	{
		this.leagueName = null;
		this.conference = null;
		this.freeagent = null;
	}
	
	public League(String leagueName, ArrayList<Conference> conference, ArrayList<Players> freeagent) {
		
		this.leagueName = leagueName;
		this.conference = conference;
		this.freeagent = freeagent;
	}

	public String getLeagueName() {
		return leagueName;
	}

	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}

	public ArrayList<Conference> getConference() {
		return conference;
	}

	public void setConference(ArrayList<Conference> conference) {
		this.conference = conference;
	}

	public ArrayList<Players> getFreeagent() {
		return freeagent;
	}

	public void setFreeagent(ArrayList<Players> freeagent) {
		this.freeagent = freeagent;
	}
	
	public ArrayList<FreeAgents> getFreeAgents() {
		return freeAgents;
	}

	public void setFreeAgents(ArrayList<FreeAgents> freeAgents) {
		this.freeAgents = freeAgents;
	}
	
	public boolean validateConference(String conferenceName, League league)
	{
		for(int i = 0; i<league.getConference().size();i++)
		{
			if(league.getConference().get(i).getConferenceName().equalsIgnoreCase(conferenceName))
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean validateDivisions(String conferenceName,String divisionName, League league)
	{
		for(int i = 0; i<league.getConference().size();i++)
		{
			if(league.getConference().get(i).getConferenceName().equalsIgnoreCase((conferenceName)))
				for(int j = 0; j<league.getConference().get(i).getDivisions().size();j++)
				{
					if(league.getConference().get(i).getDivisions().get(j).getDivisionName().equalsIgnoreCase(divisionName))
					{
						return true;
					}
				}
			}
			return false;
	}

	
	public boolean validateConferenceList(League league)
	{
		ArrayList<String> conferenceNames = new ArrayList<String>();
		for(int i = 0;i<league.getConference().size();i++)
		{
			if(conferenceNames.contains(league.getConference().get(i).getConferenceName()))
			{
				conferenceNames.clear();
				return true;
			}
			else
			{
				conferenceNames.add(league.getConference().get(i).getConferenceName());
			}
		}
		return false;
	}
	
	public boolean validateDivisionList(League league)
	{
		ArrayList<String> divisionNames = new ArrayList<String>();
		for(int i = 0;i<league.getConference().size();i++)
		{
			for(int j = 0; j<league.getConference().get(i).getDivisions().size();j++)
			{
				if(divisionNames.contains(league.getConference().get(i).getDivisions().get(j).getDivisionName()))
				{
					divisionNames.clear();
					return true;
				}
				else
				{
					divisionNames.add(league.getConference().get(i).getDivisions().get(j).getDivisionName());
				}
			}
			divisionNames.clear();
		}
		return false;
	}
	
	public boolean validateTeamList(League league)
	{
		ArrayList<String> teamNames = new ArrayList<String>();
		for(int i = 0;i<league.getConference().size();i++)
		{
			for(int j = 0; j<league.getConference().get(i).getDivisions().size();j++)
			{
				for(int k = 0; k<league.getConference().get(i).getDivisions().get(j).getTeams().size();k++)
				{
					if(teamNames.contains(league.getConference().get(i).getDivisions().get(j).getTeams().get(k).getTeamName()))
					{
						teamNames.clear();
						return true;
					}
					else
					{
						teamNames.add(league.getConference().get(i).getDivisions().get(j).getTeams().get(k).getTeamName());
					}
				}
			}
		}
		return false;
	}
	
	public boolean validateCaptain(League league)
	{
		int countCaptain = 0;
		for(int i = 0;i<league.getConference().size();i++)
		{
			for(int j = 0; j<league.getConference().get(i).getDivisions().size();j++)
			{
				for(int k = 0; k<league.getConference().get(i).getDivisions().get(j).getTeams().size();k++)
				{
					for(int m = 0; m<league.getConference().get(i).getDivisions().get(j).getTeams().get(k).getPlayers().size();m++)
					{
						if(league.getConference().get(i).getDivisions().get(j).getTeams().get(k).getPlayers().get(m).isCaptain())
						{
							countCaptain++;
						}
					}
					if(countCaptain!=1)
					{
						return true;
					}
					else
					{
						countCaptain = 0;
					}
				}
			}
		}
		return false;
	}
	
	public League appendTeam(String divisionName,String conferenceName, Team team, League league)
	{
		for(int i = 0;i<league.getConference().size();i++)
		{
			if(league.getConference().get(i).getConferenceName().equalsIgnoreCase(conferenceName))
			{
				for(int j = 0; j<league.getConference().get(i).getDivisions().size();j++)
				{
					if(league.getConference().get(i).getDivisions().get(j).getDivisionName().equalsIgnoreCase(divisionName))
					{
						league.getConference().get(i).getDivisions().get(j).getTeams().add(team);
						return league;
					}
				}
			}
		}
		return null;
	}

	public void insertTeam(League league,ILeague databaseObj){

		for(int i = 0; i<league.getConference().size();i++)
		{
			for(int j = 0; j<league.getConference().get(i).getDivisions().size();j++)
			{
				for(int k = 0; k<league.getConference().get(i).getDivisions().get(j).getTeams().size();k++)
				{
					String leagueName = league.getLeagueName();
					String ConferenceName = league.getConference().get(i).getConferenceName();
					String divisionName = league.getConference().get(i).getDivisions().get(j).getDivisionName();
					String managerName = league.getConference().get(i).getDivisions().get(j).getTeams().get(k).getGeneralManager();
					String coachName = league.getConference().get(i).getDivisions().get(j).getTeams().get(k).getHeadCoach();
					String teamName = league.getConference().get(i).getDivisions().get(j).getTeams().get(k).getTeamName();
					databaseObj.setLeagueTeamData(leagueName, ConferenceName ,divisionName,managerName,coachName,teamName);
					for(int l=0;l<league.getConference().get(i).getDivisions().get(j).getTeams().get(k).getPlayers().size();l++){
						String playerName = league.getConference().get(i).getDivisions().get(j).getTeams().get(k).getPlayers().get(l).getPlayerName();
						String playerPosition = league.getConference().get(i).getDivisions().get(j).getTeams().get(k).getPlayers().get(l).getPlayerPosition();
						boolean captain = league.getConference().get(i).getDivisions().get(j).getTeams().get(k).getPlayers().get(l).isCaptain();
						databaseObj.setPlayerData(playerName,leagueName,teamName,playerPosition,captain);
					}
				}
			}
		}
		for(int i=0; i<league.getFreeAgents().size();i++){
			String playerName = league.getFreeAgents().get(i).getPlayerName();
			String playerPosition = league.getFreeAgents().get(i).getPlayerPosition();
			boolean captain = league.getFreeAgents().get(i).isCaptain();
			databaseObj.setPlayerData(playerName,null,null,playerPosition,captain);
		}
	}

	public League loadTeam(String leagueName, String teamName,League league,ILeague db){
		league = db.getLeaguePlayerData(leagueName,teamName);
		return league;
	}



}
