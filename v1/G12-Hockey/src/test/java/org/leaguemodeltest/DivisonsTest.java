package org.leaguemodeltest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import java.util.ArrayList;
import org.junit.Test;
import org.leaguemodel.Divisions;
import org.leaguemodel.Players;
import org.leaguemodel.Team;

//Division Test Class
public class DivisonsTest {

	private String divisionName = "testdivision";
	private String teamName  = "Team12";
	private String generalManager = "testManager";
	private String headCoach = "testCoach";
	ArrayList<Players> testPlayers = new ArrayList<Players>();
	ArrayList<Team> testTeamList = new ArrayList<Team>();
	Players testPlayer = new Players("Front","testPlayer", true);
	
	@Test
	public void contructorTest()
	{
		Divisions divison = new Divisions();
		assertNull(divison.getDivisionName());
		assertNull(divison.getTeams());
	}
	
	@Test
	public void parameterizedConstructorTest()
	{
		testPlayers.add(testPlayer);
		Team testTeam = new Team(teamName,generalManager,headCoach,testPlayers);
		testTeamList.add(testTeam);
		Divisions divison = new Divisions(divisionName,testTeamList);
		assertEquals(divisionName,divison.getDivisionName());
		assertEquals(1, divison.getTeams().size());
	}
	
	@Test
	public void getDivisionNameTest()
	{
		Divisions divison = new Divisions();
		divison.setDivisionName(divisionName);
		assertEquals(divisionName, divison.getDivisionName());
	}
	
	@Test
	public void setDivisionNameTest()
	{
		Divisions divison = new Divisions();
		divison.setDivisionName(divisionName);
		assertEquals(divisionName, divison.getDivisionName());
	}
	
	@Test
	public void getTeamsTest()
	{
		testPlayers.add(testPlayer);
		Team testTeam = new Team(teamName,generalManager,headCoach,testPlayers);
		testTeamList.add(testTeam);
		Divisions divison = new Divisions();
		divison.setTeams(testTeamList);
		assertEquals(teamName, divison.getTeams().get(0).getTeamName());
		assertEquals(generalManager, divison.getTeams().get(0).getGeneralManager());
		assertEquals(headCoach, divison.getTeams().get(0).getHeadCoach());
		assertEquals(1, divison.getTeams().get(0).getPlayers().size());
	}
	
	@Test
	public void setTeamsTest()
	{
		testPlayers.add(testPlayer);
		Team testTeam = new Team(teamName,generalManager,headCoach,testPlayers);
		testTeamList.add(testTeam);
		Divisions divison = new Divisions();
		divison.setTeams(testTeamList);
		assertEquals(teamName, divison.getTeams().get(0).getTeamName());
		assertEquals(generalManager, divison.getTeams().get(0).getGeneralManager());
		assertEquals(headCoach, divison.getTeams().get(0).getHeadCoach());
		assertEquals(1, divison.getTeams().get(0).getPlayers().size());
	}
}
