package org.leaguemodeltest;

import org.junit.Test;
import org.leaguemodel.*;
import org.leaguemodel.interfaces.*;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ConferenceTest {
    private String divisionName;
    private String conferenceName;
    private String teamName;
    private String generalManager;
    private String headCoach;
    ArrayList<IPlayers> testPlayers = new ArrayList<>();
    ArrayList<ITeam> testTeamList = new ArrayList<>();
    ArrayList<IDivisions> testDivisionList = new ArrayList<>();
    IPlayers testPlayer = new Players("Front", "testPlayer", true);

    @Test
    public void constructorTest() {
        IConference testConference = new Conference();
        assertNull(testConference.getConferenceName());
        assertNull(testConference.getDivisions());
    }

    @Test
    public void parameterizedConstructorTest() {
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
        testDivisionList.add(divison);
        IConference testConference = new Conference(conferenceName, testDivisionList);
        assertEquals(conferenceName, testConference.getConferenceName());
        assertEquals(1, testConference.getDivisions().size());
    }

    @Test
    public void getConferenceNameTest() {
        IConference testConference = new Conference();
        testConference.setConferenceName(conferenceName);
        assertEquals(conferenceName, testConference.getConferenceName());
    }

    @Test
    public void setConferenceNameTest() {
        IConference testConference = new Conference();
        testConference.setConferenceName(conferenceName);
        assertEquals(conferenceName, testConference.getConferenceName());
    }

    @Test
    public void setDivisionNameTest() {
        IConference testConference = new Conference();
        testConference.setConferenceName(conferenceName);
        assertEquals(conferenceName, testConference.getConferenceName());
    }

    @Test
    public void getDivisionTest() {
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
        testDivisionList.add(divison);
        IConference testConference = new Conference();
        testConference.setDivisions(testDivisionList);
        assertEquals(1, testConference.getDivisions().size());
    }

    @Test
    public void setDivisionTest() {
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
        testDivisionList.add(divison);
        IConference testConference = new Conference();
        testConference.setDivisions(testDivisionList);
        assertEquals(1, testConference.getDivisions().size());
    }
}
