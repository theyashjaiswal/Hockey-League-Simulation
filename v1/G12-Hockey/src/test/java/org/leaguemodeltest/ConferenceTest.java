package org.leaguemodeltest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;

import org.junit.Test;
import org.leaguemodel.Conference;
import org.leaguemodel.Divisions;
import org.leaguemodel.Players;
import org.leaguemodel.Team;

//Conference Test class
public class ConferenceTest {

	private String divisionName = "testdivision";
	private String conferenceName = "testconference";
	private String teamName  = "Team12";
	private String generalManager = "testManager";
	private String headCoach = "testCoach";
	ArrayList<Players> testPlayers = new ArrayList<Players>();
	ArrayList<Team> testTeamList = new ArrayList<Team>();
	ArrayList<Divisions> testDivisionList = new ArrayList<Divisions>();
	Players testPlayer = new Players("Front","testPlayer", true);

	@Test
	public void constructorTest()
	{
		Conference testConference = new Conference();
		assertNull(testConference.getConferenceName());
		assertNull(testConference.getDivisions());
	}
	
	@Test
	public void parameterizedConstructorTest()
	{
		testPlayers.add(testPlayer);
		Team testTeam = new Team(teamName,generalManager,headCoach,testPlayers);
		testTeamList.add(testTeam);
		Divisions divison = new Divisions(divisionName,testTeamList);
		testDivisionList.add(divison);
		Conference testConference = new Conference(conferenceName,testDivisionList);
		assertEquals(conferenceName,testConference.getConferenceName());
		assertEquals(1, testConference.getDivisions().size());
	}
	
	@Test
	public void getConferenceNameTest()
	{
		Conference testConference = new Conference();
		testConference.setConferenceName(conferenceName);
		assertEquals(conferenceName, testConference.getConferenceName());
	}
	
	@Test
	public void setConferenceNameTest()
	{
		Conference testConference = new Conference();
		testConference.setConferenceName(conferenceName);
		assertEquals(conferenceName, testConference.getConferenceName());
	}
	
	@Test
	public void setDivisionNameTest()
	{
		Conference testConference = new Conference();
		testConference.setConferenceName(conferenceName);
		assertEquals(conferenceName, testConference.getConferenceName());
	}
	
	@Test
	public void getDivisionTest()
	{
		testPlayers.add(testPlayer);
		Team testTeam = new Team(teamName,generalManager,headCoach,testPlayers);
		testTeamList.add(testTeam);
		Divisions divison = new Divisions(divisionName,testTeamList);
		testDivisionList.add(divison);
		Conference testConference = new Conference();
		testConference.setDivisions(testDivisionList);
		assertEquals(1, testConference.getDivisions().size());
	}
	
	@Test
	public void setDivisionTest()
	{
		testPlayers.add(testPlayer);
		Team testTeam = new Team(teamName,generalManager,headCoach,testPlayers);
		testTeamList.add(testTeam);
		Divisions divison = new Divisions(divisionName,testTeamList);
		testDivisionList.add(divison);
		Conference testConference = new Conference();
		testConference.setDivisions(testDivisionList);
		assertEquals(1, testConference.getDivisions().size());
	}
}
