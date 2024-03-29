package org.leaguemodeltest;

import org.leaguemodel.*;
import org.leaguemodel.interfaces.*;
import java.util.ArrayList;

public class TestData {

    private IPlayers playerOne = new Players("Forward", "Player one", true);
    private IPlayers playerTwo = new Players("Defense", "Player two", false);
    private IPlayers playerThree = new Players("Goalie", "Player three", false);
    private ArrayList<IPlayers> playerList = new ArrayList<>();
    private ArrayList<ITeam> teamsList = new ArrayList<>();
    private ArrayList<IDivisions> divisionList = new ArrayList<>();
    private ArrayList<IConference> conferenceList = new ArrayList<>();
    public ITeam teamOne = new Team();
    public IDivisions divisionOne = new Divisions();
    public IConference conferenceOne = new Conference();
    private ILeague leagueOne = new League();

    public TestData() {
        playerList.add(playerOne);
        playerList.add(playerTwo);
        playerList.add(playerThree);
        IHeadCoach headCoach = new HeadCoach();
        headCoach.setName("headcoach");
        headCoach.setChecking(2.4);
        headCoach.setSaving(3.1);
        headCoach.setShooting(1.2);
        headCoach.setSkating(0.5);
        ITeam teamOne = new Team("Team 12", "AI", "Mary Smith", headCoach, playerList);
        teamsList.add(teamOne);
        IDivisions divisionOne = new Divisions("Atlantic", teamsList);
        divisionList.add(divisionOne);
        IConference conferenceOne = new Conference("Eastern Conference", divisionList);
        conferenceList.add(conferenceOne);
        leagueOne = new League("Dalhousie Hockey League", conferenceList, playerList);
    }

    public ILeague getLeagueOne() {
        return leagueOne;
    }
}

