package org.leaguemodeltest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.leaguemodel.Conference;
import org.leaguemodel.FreeAgents;
import org.leaguemodel.League;
import org.leaguemodel.MockData;
import org.leaguemodel.Players;
import org.leaguemodel.Team;
import org.leaguemodel.ILeague;

//League Test Class
public class LeagueTest {

	private String leagueName = "Test League";
	Conference testConference = new Conference("test conference",null);
	ArrayList<Conference> testConferenceList = new ArrayList<Conference>();
	Players testPlayer = new Players("Front","testPlayer", true);
	ArrayList<Players> testFreeAgentsList = new ArrayList<Players>();
	Team teamTest  = new Team("Test 22","Siddhant","Vikram",null);
	
	@Test
	public void contructorTest()
	{
		League league = new League();
		assertNull(league.getLeagueName());
		assertNull(league.getFreeagent());
		assertNull(league.getConference());
	}
	
	@Test
	public void parameterizedConstructorTest()
	{
		League league = new League(leagueName,null, null);
		assertEquals(leagueName,league.getLeagueName());
		assertNull(league.getFreeagent());
		assertNull(league.getConference());
	}
	
	@Test
	public void getLeagueNameTest()
	{
		League league = new League(leagueName,null, null);
		assertEquals(leagueName,league.getLeagueName());
	}
	
	@Test
	public void setLeagueNameTest()
	{
		League league = new League();
		league.setLeagueName(leagueName);
		assertEquals(leagueName,league.getLeagueName());
	}
	
	@Test
	public void getConferenceTest()
	{
		testConferenceList.add(testConference);
		League league = new League(leagueName,testConferenceList,null);
		assertEquals(1,league.getConference().size());
	}
	
	@Test
	public void setConferenceTest()
	{
		testConferenceList.add(testConference);
		League league = new League();
		league.setConference(testConferenceList);
		assertEquals(1,league.getConference().size());
	}
	
	@Test
	public void getFreeAgentTest()
	{
		testFreeAgentsList.add(testPlayer);
		FreeAgents freeAgent = new FreeAgents();
		freeAgent.setPlayers(testFreeAgentsList);
		League league = new League(leagueName,null,testFreeAgentsList);
		assertEquals(1,league.getFreeagent().size());
	}
	
	@Test
	public void setFreeAgentTest()
	{
		testFreeAgentsList.add(testPlayer);
		FreeAgents freeAgent = new FreeAgents();
		freeAgent.setPlayers(testFreeAgentsList);
		League league = new League(leagueName,null,testFreeAgentsList);
		assertEquals(1,league.getFreeagent().size());
	}


	@Test
	public void validateConferenceTest() 
	{
		League testLeague = new League();
		TestData testObj = new TestData();
		assertEquals(testLeague.validateConference("Eastern Conference", testObj.getLeagueOne()),true);
		assertEquals(testLeague.validateConference("test conference", testObj.getLeagueOne()),false);
	}
	@Test
	public void validateDivisionsTest()
	{
		League testLeague = new League();
		TestData testObj = new TestData();
		assertEquals(testLeague.validateDivisions("Eastern Conference","Atlantic", testObj.getLeagueOne()),true);
		assertEquals(testLeague.validateDivisions("Eastern Conference","test division", testObj.getLeagueOne()),false);
	}
	@Test
	public void appendTeamTest()
	{
		League testLeague = new League();
		TestData testObj = new TestData();
		League league = testLeague.appendTeam("Atlantic","Eastern Conference",teamTest,testObj.getLeagueOne());
		League leagueQuery = testLeague.appendTeam("Ontario","Eastern Conference",teamTest,testObj.getLeagueOne());
		assertEquals(league.getConference().get(0).getDivisions().get(0).getTeams().size(),2);
		assertNull(leagueQuery);
	}
	@Test
	public void validateConferenceListTest()
	{
		League testLeague = new League();
		TestData testObj = new TestData();
		assertEquals(testLeague.validateConferenceList(testObj.getLeagueOne()), false);
	}
	@Test
	public void validateDivisionListTest()
	{
		League testLeague = new League();
		TestData testObj = new TestData();
		assertEquals(testLeague.validateDivisionList(testObj.getLeagueOne()), false);
	}
	@Test
	public void validateTeamListTest()
	{
		League testLeague = new League();
		TestData testObj = new TestData();
		assertEquals(testLeague.validateTeamList(testObj.getLeagueOne()), false);
	}
	@Test
	public void validateCaptainTest()
	{
		League testLeague = new League();
		TestData testObj = new TestData();
		assertEquals(testLeague.validateCaptain(testObj.getLeagueOne()), false);
	}

	@Test
	public void insertTeamTest()
	{
		MockData mockData = new MockData();
		League testLeague = new League();
		testLeague.insertTeam(mockData.leagueOne, mockData);
		assertEquals(mockData.leagueOne.getLeagueName(), "Dalhousie Hockey League");
	}

	public void loadTeamTest(){

		MockData mockData = new MockData();
		League testLeague = new League();
		testLeague.loadTeam("Dalhousie Hockey League","Team 12",testLeague, mockData);
		assertEquals(testLeague.getLeagueName(), "Dalhousie Hockey League");
	}
}