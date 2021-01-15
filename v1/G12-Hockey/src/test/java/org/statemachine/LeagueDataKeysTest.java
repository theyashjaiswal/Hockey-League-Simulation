package org.statemachine;

import junit.framework.TestCase;

public class LeagueDataKeysTest extends TestCase {

    LeagueDataKeys leagueDataKeys = new LeagueDataKeys();

    public void testGetConferenceName() {
        assertEquals("conferenceName", leagueDataKeys.getConferenceName());
    }

    public void testGetDivisionName() {
        assertEquals("divisionName", leagueDataKeys.getDivisionName());
    }

    public void testGetTeamName() {
        assertEquals("teamName", leagueDataKeys.getTeamName());
    }

    public void testGetGeneralManager() {
        assertEquals("generalManager", leagueDataKeys.getGeneralManager());
    }

    public void testGetHeadCoach() {
        assertEquals("headCoach", leagueDataKeys.getHeadCoach());
    }

    public void testGetPlayerName() {
        assertEquals("playerName", leagueDataKeys.getPlayerName());
    }

    public void testGetPosition() {
        assertEquals("position", leagueDataKeys.getPosition());
    }

    public void testGetCaptain() {
        assertEquals("captain", leagueDataKeys.getCaptain());
    }

    public void testGetDivisions() {
        assertEquals("divisions", leagueDataKeys.getDivisions());
    }

    public void testGetTeams() {
        assertEquals("teams", leagueDataKeys.getTeams());
    }

    public void testGetPlayers() {
        assertEquals("players", leagueDataKeys.getPlayers());
    }

    public void testGetFreeAgents() {
        assertEquals("freeAgents", leagueDataKeys.getFreeAgents());
    }

    public void testGetLeagueName() {
        assertEquals("leagueName", leagueDataKeys.getLeagueName());
    }

    public void testGetConferences() {
        assertEquals("conferences", leagueDataKeys.getConferences());
    }
}