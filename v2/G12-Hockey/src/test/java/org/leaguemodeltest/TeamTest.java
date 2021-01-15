package org.leaguemodeltest;

import org.junit.Test;
import org.leaguemodel.HeadCoach;
import org.leaguemodel.Players;
import org.leaguemodel.Team;
import org.leaguemodel.ValidationsInLeague;
import org.leaguemodel.interfaces.IHeadCoach;
import org.leaguemodel.interfaces.IPlayers;
import org.leaguemodel.interfaces.ITeam;
import org.leaguemodel.interfaces.IValidationsInLeague;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TeamTest {

    private String teamName = "Team12";
    private String generalManager = "testManager";
    private String headCoach = "testCoach";
    ArrayList<IPlayers> testPlayers = new ArrayList<>();
    IPlayers testPlayer = new Players("Front", "testPlayer", true);

    @Test
    public void constructorTest() {
        ITeam testTeam = new Team();
        assertNull(testTeam.getTeamName());
        assertNull(testTeam.getHeadCoach());
        assertNull(testTeam.getGeneralManager());
        assertNull(testTeam.getPlayers());
    }

    @Test
    public void paramertizedConstructorTest() {
        testPlayers.add(testPlayer);
        IHeadCoach headCoach = new HeadCoach();
        headCoach.setName("headcoach");
        headCoach.setChecking(2.4);
        headCoach.setSaving(3.1);
        headCoach.setShooting(1.2);
        headCoach.setSkating(0.5);
        ITeam testTeam = new Team(teamName, "AI", generalManager, headCoach, testPlayers);
        assertEquals(teamName, testTeam.getTeamName());
        assertEquals(generalManager, testTeam.getGeneralManager());
        assertEquals(headCoach, testTeam.getHeadCoach());
        assertEquals(1, testTeam.getPlayers().size());
    }

    @Test
    public void getTeamNameTest() {
        ITeam testTeam = new Team();
        testTeam.setTeamName(teamName);
        assertEquals(teamName, testTeam.getTeamName());
    }

    @Test
    public void setTeamNameTest() {
        ITeam testTeam = new Team();
        testTeam.setTeamName(teamName);
        assertEquals(teamName, testTeam.getTeamName());
    }

    @Test
    public void getHeadCoachTest() {
        ITeam testTeam = new Team();
        IHeadCoach headCoach = new HeadCoach();
        headCoach.setName("headcoach");
        headCoach.setChecking(2.4);
        headCoach.setSaving(3.1);
        headCoach.setShooting(1.2);
        headCoach.setSkating(0.5);
        testTeam.setHeadCoach(headCoach);
        assertEquals(headCoach,testTeam.getHeadCoach());
    }

    @Test
    public void setHeadCoachTest() {
        ITeam testTeam = new Team();
        IHeadCoach headCoach = new HeadCoach();
        headCoach.setName("headcoach");
        headCoach.setChecking(2.4);
        headCoach.setSaving(3.1);
        headCoach.setShooting(1.2);
        headCoach.setSkating(0.5);
        testTeam.setHeadCoach(headCoach);
        assertEquals(headCoach,testTeam.getHeadCoach());
    }

    @Test
    public void setGeneralManagerTest() {
        ITeam testTeam = new Team();
        testTeam.setGeneralManager(generalManager);
        assertEquals(generalManager, testTeam.getGeneralManager());
    }

    @Test
    public void getGeneralManagerTest() {
        ITeam testTeam = new Team();
        testTeam.setGeneralManager(generalManager);
        assertEquals(generalManager, testTeam.getGeneralManager());
    }

    @Test
    public void setPlayersTest() {
        ITeam testTeam = new Team();
        testPlayers.add(testPlayer);
        testTeam.setPlayers(testPlayers);
        assertEquals(testPlayer.getPlayerName(), testTeam.getPlayers().get(0).getPlayerName());
        assertEquals(testPlayer.getPlayerPosition(), testTeam.getPlayers().get(0).getPlayerPosition());
        assertEquals(testPlayer.isCaptain(), testTeam.getPlayers().get(0).isCaptain());
    }

    @Test
    public void getPlayersTest() {
        ITeam testTeam = new Team();
        testPlayers.add(testPlayer);
        testTeam.setPlayers(testPlayers);
        assertEquals(testPlayer.getPlayerName(), testTeam.getPlayers().get(0).getPlayerName());
        assertEquals(testPlayer.getPlayerPosition(), testTeam.getPlayers().get(0).getPlayerPosition());
        assertEquals(testPlayer.isCaptain(), testTeam.getPlayers().get(0).isCaptain());
    }

    @Test
    public void validateTeamNameTest() {
        IValidationsInLeague testTeam = new ValidationsInLeague();
        TestData test = new TestData();
        assertEquals(testTeam.validateTeamName("Team 12", test.getLeagueOne()), true);
        assertEquals(testTeam.validateTeamName("Team 13", test.getLeagueOne()), false);
    }
}