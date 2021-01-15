package org.leaguemodel;
import java.util.ArrayList;
import java.util.List;

//MockData Class
public class MockData implements ILeague {

	private Players playerOne = new Players("Forward","Player one",false);
	private Players playerTwo = new Players("Defense","Player two",false);
	private Players playerThree = new Players("Goalie","Player three",true);
	private ArrayList<Players> playerList  = new ArrayList<Players>();
	private ArrayList<Team> teamsList  = new ArrayList<Team>();
	private ArrayList<Divisions> divisionList  = new ArrayList<Divisions>();
	private ArrayList<Conference> conferenceList  = new ArrayList<Conference>();
	public Team teamOne = new Team();
	public Divisions divisionOne = new Divisions();
	public Conference conferenceOne = new Conference();
	public League leagueOne = new League();
	public ArrayList<FreeAgents> freeAgents = new ArrayList<FreeAgents>();
	
	public MockData() {
		playerList.add(playerOne);
		playerList.add(playerTwo);
		playerList.add(playerThree);
		Team teamOne  = new Team("Team 12","Mary Smith","Mister Fred",playerList);
		teamsList.add(teamOne);
		Divisions divisionOne  = new Divisions("Atlantic",teamsList);
		divisionList.add(divisionOne);
		Conference conferenceOne  = new Conference("Eastern Conference",divisionList);
		conferenceList.add(conferenceOne);
		leagueOne = new League("Dalhousie Hockey League",conferenceList,playerList);
		leagueOne.setFreeAgents(freeAgents);
	}

	public List getLeagueName(){
		List list = new ArrayList();
		list.add(leagueOne.getLeagueName());
		return list;
	}

	@Override
	public League getLeaguePlayerData(String leagueName, String teamName) {
		return leagueOne;
	}

	@Override
	public Boolean setLeagueTeamData(String leagueName, String conferenceName, String divisionName, String managerName, String coachName, String teamName) {
		return null;
	}

	@Override
	public Boolean setPlayerData(String playerName, String leagueName, String teamName, String position, Boolean captain) {
		return null;
	}

	public List getTeamName(String leagueName){
		List list = new ArrayList();
		list.add(leagueOne.getConference().get(0).getDivisions().get(0).getTeams().get(0).getTeamName());
		return list;
	}
}
