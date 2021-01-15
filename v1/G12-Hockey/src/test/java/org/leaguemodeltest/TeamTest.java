package org.leaguemodeltest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import java.util.ArrayList;
import org.junit.Test;
import org.leaguemodel.Players;
import org.leaguemodel.Team;

//Team Test Class
public class TeamTest {
	
	private String teamName  = "Team12";
	private String generalManager = "testManager";
	private String headCoach = "testCoach";
	ArrayList<Players> testPlayers = new ArrayList<Players>();
	Players testPlayer = new Players("Front","testPlayer", true);
	
	@Test
	public void constructorTest()
	{
		Team testTeam = new Team();
		assertNull(testTeam.getTeamName());
		assertNull(testTeam.getHeadCoach());
		assertNull(testTeam.getGeneralManager());
		assertNull(testTeam.getPlayers());
	}
	
	@Test
	public void paramertizedConstructorTest()
	{
		testPlayers.add(testPlayer);
		Team testTeam = new Team(teamName,generalManager,headCoach,testPlayers);
		assertEquals(teamName, testTeam.getTeamName());
		assertEquals(generalManager, testTeam.getGeneralManager());
		assertEquals(headCoach, testTeam.getHeadCoach());
		assertEquals(1, testTeam.getPlayers().size());
	}
	
	@Test
	public void getTeamNameTest()
	{
		Team testTeam = new Team();
		testTeam.setTeamName(teamName);
		assertEquals(teamName, testTeam.getTeamName());
	}
	
	@Test
	public void setTeamNameTest()
	{
		Team testTeam = new Team();
		testTeam.setTeamName(teamName);
		assertEquals(teamName, testTeam.getTeamName());
	}
	
	@Test
	public void getHeadCoachTest()
	{
		Team testTeam = new Team();
		testTeam.setHeadCoach(headCoach);
		assertEquals(headCoach,testTeam.getHeadCoach());
	}
	
	@Test
	public void setHeadCoachTest()
	{
		Team testTeam = new Team();
		testTeam.setHeadCoach(headCoach);
		assertEquals(headCoach,testTeam.getHeadCoach());
	}
	
	@Test
	public void setGeneralManagerTest()
	{
		Team testTeam = new Team();
		testTeam.setGeneralManager(generalManager);
		assertEquals(generalManager,testTeam.getGeneralManager());
	}
	
	@Test
	public void getGeneralManagerTest()
	{
		Team testTeam = new Team();
		testTeam.setGeneralManager(generalManager);
		assertEquals(generalManager,testTeam.getGeneralManager());
	}
	
	@Test
	public void setPlayersTest()
	{
		Team testTeam = new Team();
		testPlayers.add(testPlayer);
		testTeam.setPlayers(testPlayers);
		assertEquals(testPlayer.getPlayerName(), testTeam.getPlayers().get(0).getPlayerName());
		assertEquals(testPlayer.getPlayerPosition(), testTeam.getPlayers().get(0).getPlayerPosition());
		assertEquals(testPlayer.isCaptain(), testTeam.getPlayers().get(0).isCaptain());
	}
	
	@Test
	public void getPlayersTest()
	{
		Team testTeam = new Team();
		testPlayers.add(testPlayer);
		testTeam.setPlayers(testPlayers);
		assertEquals(testPlayer.getPlayerName(), testTeam.getPlayers().get(0).getPlayerName());
		assertEquals(testPlayer.getPlayerPosition(), testTeam.getPlayers().get(0).getPlayerPosition());
		assertEquals(testPlayer.isCaptain(), testTeam.getPlayers().get(0).isCaptain());
	}
	
	
	@Test
	public void validateTeamNameTest()
	{
		Team testTeam = new Team();
		TestData test = new TestData();
		assertEquals(testTeam.validateTeamName("Team 12", test.getLeagueOne()), true);
		assertEquals(testTeam.validateTeamName("Team 13", test.getLeagueOne()), false);
	} 
}