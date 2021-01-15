package org.leaguemodeltest;

import junit.framework.TestCase;
import org.junit.Test;
import org.leaguemodel.Divisions;
import org.leaguemodel.HeadCoach;
import org.leaguemodel.Players;
import org.leaguemodel.Team;
import org.leaguemodel.interfaces.IDivisions;
import org.leaguemodel.interfaces.IHeadCoach;
import org.leaguemodel.interfaces.IPlayers;
import org.leaguemodel.interfaces.ITeam;

import java.util.ArrayList;
import java.util.List;

public class DivisonsTest extends TestCase {

    List<IPlayers> testPlayers = new ArrayList<>();
    List<ITeam> testTeamList = new ArrayList<>();
    IPlayers testPlayer = new Players("Front", "testPlayer", true);
    private String divisionName = "testdivision";
    private String teamName = "Team12";
    private String generalManager = "testManager";
    private String headCoach = "testCoach";

    @Test
    public void testParameterizedConstructor() {
        testPlayers.add(testPlayer);
        IHeadCoach headCoach = new HeadCoach();
        headCoach.setName("headcoach");
        headCoach.setChecking(2.4);
        headCoach.setSaving(3.1);
        headCoach.setShooting(1.2);
        headCoach.setSkating(0.5);
        ITeam testTeam = new Team(teamName, "AI", generalManager, headCoach, testPlayers);
        testTeamList.add(testTeam);
        IDivisions divison = new Divisions(divisionName, testTeamList);
        assertEquals(divisionName, divison.getDivisionName());
        assertEquals(1, divison.getTeams().size());
    }

    @Test
    public void testGetDivisionName() {
        IDivisions divison = new Divisions();
        divison.setDivisionName(divisionName);
        assertEquals(divisionName, divison.getDivisionName());
    }

    @Test
    public void testSetDivisionName() {
        IDivisions divison = new Divisions();
        divison.setDivisionName(divisionName);
        assertEquals(divisionName, divison.getDivisionName());
    }

    @Test
    public void testGetTeams() {
        testPlayers.add(testPlayer);
        IHeadCoach headCoach = new HeadCoach();
        headCoach.setName("headcoach");
        headCoach.setChecking(2.4);
        headCoach.setSaving(3.1);
        headCoach.setShooting(1.2);
        headCoach.setSkating(0.5);
        ITeam testTeam = new Team(teamName, "AI", generalManager, headCoach, testPlayers);
        testTeamList.add(testTeam);
        IDivisions divison = new Divisions();
        divison.setTeams(testTeamList);
        assertEquals(teamName, divison.getTeams().get(0).getTeamName());
        assertEquals(generalManager, divison.getTeams().get(0).getGeneralManager());
        assertEquals(1, divison.getTeams().get(0).getPlayers().size());
    }

    @Test
    public void testSetTeams() {
        testPlayers.add(testPlayer);
        IHeadCoach headCoach = new HeadCoach();
        headCoach.setName("HeadCoach");
        headCoach.setChecking(2.4);
        headCoach.setSaving(3.1);
        headCoach.setShooting(1.2);
        headCoach.setSkating(0.5);
        ITeam testTeam = new Team(teamName, "AI", generalManager, headCoach, testPlayers);
        testTeamList.add(testTeam);
        Divisions divison = new Divisions();
        divison.setTeams(testTeamList);
        assertEquals(teamName, divison.getTeams().get(0).getTeamName());
        assertEquals(generalManager, divison.getTeams().get(0).getGeneralManager());
        assertEquals(1, divison.getTeams().get(0).getPlayers().size());
    }
}
