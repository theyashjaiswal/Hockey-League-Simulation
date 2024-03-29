package org.leaguesimulation;

import org.junit.Before;
import org.junit.Test;
import org.leaguemodel.Conference;
import org.leaguemodel.Divisions;
import org.leaguemodel.Team;
import org.leaguemodel.interfaces.IConference;
import org.leaguemodel.interfaces.IDivisions;
import org.leaguemodel.interfaces.ITeam;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ConferenceScoreboardTest {

    IConference conference;
    IDivisions division;
    private ArrayList<ITeam> teams;
    private ArrayList<IDivisions> divisions;

    @Before
    public void setUp() {
        conference = new Conference();
        division = new Divisions();
        ITeam teamOne = new Team();
        ITeam teamTwo = new Team();
        teamOne.setTeamName("teamOne");
        teamTwo.setTeamName("teamTwo");
        teams = new ArrayList<>();
        teams.add(teamOne);
        teams.add(teamTwo);
        division.setTeams(teams);
        divisions = new ArrayList<>();
        divisions.add(division);
        conference.setDivisions(divisions);
    }

    @Test
    public void loadScoreboard() {
        ConferenceScoreboard conferenceScoreboard = new ConferenceScoreboard(conference);
        List<TeamOnScoreboard> scoreboard = conferenceScoreboard.loadScoreboard();
        assertEquals("teamOne", scoreboard.get(0).getTeam().getTeamName());
        assertEquals("teamTwo", scoreboard.get(1).getTeam().getTeamName());
    }

    @Test
    public void sort() {
        ConferenceScoreboard conferenceScoreboard = new ConferenceScoreboard(conference);
        List<TeamOnScoreboard> scoreboard = conferenceScoreboard.loadScoreboard();
        scoreboard.get(1).setScore(10);
        assertEquals(10, conferenceScoreboard.sort().get(0).getScore());
    }

    @Test
    public void getScoreboard() {
        ConferenceScoreboard conferenceScoreboard = new ConferenceScoreboard(conference);
        List<TeamOnScoreboard> scoreboard = conferenceScoreboard.loadScoreboard();
        assertEquals(scoreboard, conferenceScoreboard.getScoreboard());
    }
}
