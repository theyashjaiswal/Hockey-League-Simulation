package org.leaguemodeltest;
import org.junit.Test;
import org.leaguemodel.Players;

import static org.junit.Assert.*;

//Players Test class
public class PlayersTest {
	
	private String playerName  = "User";
	private String playerPosition = "Front";
	private boolean isCaptain = true;
		
	@Test
	public void contructorTest()
	{
		Players testPlayer = new Players();
		assertNull(testPlayer.getPlayerName());
		assertNull(testPlayer.getPlayerPosition());
		assertFalse(testPlayer.isCaptain());
	}
		
	@Test	
	public void parameterizedConstructorTest()
	{
		Players testPlayer = new Players("Front","test", true);
		assertEquals("test", testPlayer.getPlayerName());
		assertEquals("Front", testPlayer.getPlayerPosition());
		assertTrue(testPlayer.isCaptain());
	}
	
	@Test
	public void getPlayerNameTest()
	{
		Players testPlayer = new Players();
		testPlayer.setPlayerName(playerName);
		assertEquals(playerName, testPlayer.getPlayerName());
	}
	
	@Test
	public void setPlayerNameTest()
	{
		Players testPlayer = new Players();
		testPlayer.setPlayerName(playerName);
		assertEquals(playerName, testPlayer.getPlayerName());
	}
	
	@Test
	public void getPlayerPositionTest()
	{
		Players testPlayer = new Players();
		testPlayer.setPlayerPosition(playerPosition);
		assertEquals(playerPosition, testPlayer.getPlayerPosition());
	}
	
	@Test
	public void setPlayerPositionTest()
	{
		Players testPlayer = new Players();
		testPlayer.setPlayerPosition(playerPosition);
		assertEquals(playerPosition, testPlayer.getPlayerPosition());
	}
	
	@Test
	public void isCaptainTest()
	{
		Players testPlayer = new Players();
		testPlayer.setIsCaptain(isCaptain);
		assertTrue(testPlayer.isCaptain());
	}
	
	@Test
	public void setIsCaptainTest()
	{
		Players testPlayer = new Players();
		testPlayer.setIsCaptain(isCaptain);
		assertTrue(testPlayer.isCaptain());
	}

}
