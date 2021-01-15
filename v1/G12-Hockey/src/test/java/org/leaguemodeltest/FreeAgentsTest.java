package org.leaguemodeltest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;

import org.junit.Test;
import org.leaguemodel.FreeAgents;
import org.leaguemodel.Players;

//FreeAgent Test Class
public class FreeAgentsTest {

	ArrayList<Players> testPlayers = new ArrayList<Players>();
	Players testPlayer = new Players("Front","testPlayer", true);
	
	@Test
	public void constructorTest()
	{
		FreeAgents freeAgent = new FreeAgents();
		assertNull(freeAgent.getPlayers());
	}
	
	@Test
	public void paramertizedConstructorTest()
	{
		testPlayers.add(testPlayer);
		FreeAgents freeAgent = new FreeAgents(testPlayers);
		assertEquals(1, freeAgent.getPlayers().size());
	}
	
	@Test
	public void setPlayersTest()
	{
		testPlayers.add(testPlayer);
		FreeAgents freeAgent = new FreeAgents();
		freeAgent.setPlayers(testPlayers);
		assertEquals(1, freeAgent.getPlayers().size());	
	}
	
	@Test
	public void getPlayersTest()
	{
		testPlayers.add(testPlayer);
		FreeAgents freeAgent = new FreeAgents();
		freeAgent.setPlayers(testPlayers);
		assertEquals(1, freeAgent.getPlayers().size());
	}
	
}
