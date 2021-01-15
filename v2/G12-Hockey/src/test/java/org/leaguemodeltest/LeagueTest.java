package org.leaguemodeltest;

import org.junit.Test;
import org.leaguemodel.*;
import org.leaguemodel.interfaces.*;
import resources.MockData;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class LeagueTest {

    private String leagueName = "Test League";
    IConference testConference = new Conference("test conference", null);
    List<IConference> testConferenceList = new ArrayList<>();
    IPlayers testPlayer = new Players("Front", "testPlayer", true);
    List<IPlayers> testFreeAgentsList = new ArrayList<>();
    ITeam teamTest = new Team("Test 22", "AI", "Siddhant", null, null);

    @Test
    public void getLeagueNameTest() {
        ILeague league = new League(leagueName, null, null);
        assertEquals(leagueName, league.getLeagueName());
    }

    @Test
    public void setLeagueNameTest() {
        ILeague league = new League();
        league.setLeagueName(leagueName);
        assertEquals(leagueName, league.getLeagueName());
    }

    @Test
    public void getConferenceTest() {
        testConferenceList.add(testConference);
        ILeague league = new League(leagueName, testConferenceList, null);
        assertEquals(1, league.getConference().size());
    }

    @Test
    public void setConferenceTest() {
        testConferenceList.add(testConference);
        ILeague league = new League();
        league.setConference(testConferenceList);
        assertEquals(1, league.getConference().size());
    }

    @Test
    public void validateConferenceTest() {
        IValidationsInLeague testLeague = new ValidationsInLeague();
        TestData testObj = new TestData();
        assertEquals(testLeague.validateConference("Eastern Conference", testObj.getLeagueOne()), true);
        assertEquals(testLeague.validateConference("test conference", testObj.getLeagueOne()), false);
    }

    @Test
    public void validateDivisionsTest() {
        IValidationsInLeague testLeague = new ValidationsInLeague();
        TestData testObj = new TestData();
        assertEquals(testLeague.validateDivisions("Eastern Conference", "Atlantic", testObj.getLeagueOne()), true);
        assertEquals(testLeague.validateDivisions("Eastern Conference", "test division", testObj.getLeagueOne()), false);
    }

    @Test
    public void appendTeamTest() {
        ILoadSaveTeam testLeague = new LoadSaveTeamToDB();
        TestData testObj = new TestData();
        ILeague league = testLeague.appendTeam("Atlantic", "Eastern Conference", teamTest, testObj.getLeagueOne());
        ILeague leagueQuery = testLeague.appendTeam("Ontario", "Eastern Conference", teamTest, testObj.getLeagueOne());
        assertEquals(league.getConference().get(0).getDivisions().get(0).getTeams().size(), 2);
        assertNull(leagueQuery);
    }

    @Test
    public void validateConferenceListTest() {
        IValidationsInLeague testLeague = new ValidationsInLeague();
        TestData testObj = new TestData();
        assertEquals(testLeague.validateConferenceList(testObj.getLeagueOne()), false);
    }

    @Test
    public void validateDivisionListTest() {
        IValidationsInLeague testLeague = new ValidationsInLeague();
        TestData testObj = new TestData();
        assertEquals(testLeague.validateDivisionList(testObj.getLeagueOne()), false);
    }

    @Test
    public void validateTeamListTest() {
        IValidationsInLeague testLeague = new ValidationsInLeague();
        TestData testObj = new TestData();
        assertEquals(testLeague.validateTeamList(testObj.getLeagueOne()), false);
    }

    @Test
    public void validateCaptainTest() {
        IValidationsInLeague testLeague = new ValidationsInLeague();
        TestData testObj = new TestData();
        assertEquals(testLeague.validateCaptain(testObj.getLeagueOne()), false);
    }

    @Test
    public void insertTeamTest() {
        MockData mockData = new MockData();
        ILeagueGetSetDB testLeague = new MockData();
        ILoadSaveTeam iLoadSaveTeam = new MockData();
        iLoadSaveTeam.saveTeam(mockData.leagueOne, mockData);
        assertEquals(mockData.leagueOne.getLeagueName(), "Dalhousie Hockey League");
    }

    @Test
    public void loadTeamTest() {
        MockData mockData = new MockData();
        ILoadSaveTeam iLoadSaveTeam = new MockData();
        ILeague testLeague = mockData.leagueOne;
        iLoadSaveTeam.loadTeam("Dalhousie Hockey League","Team 12",testLeague, mockData);
        assertEquals(testLeague.getLeagueName(), "Dalhousie Hockey League");
    }
}