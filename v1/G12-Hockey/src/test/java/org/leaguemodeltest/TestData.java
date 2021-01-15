package org.leaguemodeltest;
import java.util.ArrayList;

import org.leaguemodel.Conference;
import org.leaguemodel.Divisions;
import org.leaguemodel.League;
import org.leaguemodel.Players;
import org.leaguemodel.Team;

//Test Data class
public class TestData {

	private Players playerOne = new Players("Forward","Player one",true);
	private Players playerTwo = new Players("Defense","Player two",false);
	private Players playerThree = new Players("Goalie","Player three",false);
	private ArrayList<Players> playerList  = new ArrayList<Players>();
	private ArrayList<Team> teamsList  = new ArrayList<Team>();
	private ArrayList<Divisions> divisionList  = new ArrayList<Divisions>();
	private ArrayList<Conference> conferenceList  = new ArrayList<Conference>();
	public Team teamOne = new Team();
	public Divisions divisionOne = new Divisions();
	public Conference conferenceOne = new Conference();
	private League leagueOne = new League();
	

	public TestData() {
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
	}
	
	public League getLeagueOne() {
		return leagueOne;
	}
}

