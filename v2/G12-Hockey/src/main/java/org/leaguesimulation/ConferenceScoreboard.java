package org.leaguesimulation;

import org.leaguemodel.interfaces.IConference;
import org.leaguemodel.interfaces.IDivisions;
import org.leaguesimulation.interfaces.IConferenceScoreboard;
import org.leaguesimulation.interfaces.IScoreboard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConferenceScoreboard implements IScoreboard, IConferenceScoreboard {

    private IConference conference;
    private List<TeamOnScoreboard> scoreboard;
    private List<IScoreboard> divisionScoreboards;

    public List<TeamOnScoreboard> getScoreboard() {
        return scoreboard;
    }

    public ConferenceScoreboard(IConference conference) {
        this.conference = conference;
        scoreboard = new ArrayList<>();
        divisionScoreboards = new ArrayList<>();
    }

    @Override
    public List<TeamOnScoreboard> loadScoreboard() {
        for (IDivisions division : conference.getDivisions()) {
            IScoreboard divisionScoreboard = new DivisionScoreboard(division, conference.getConferenceName());
            scoreboard.addAll(divisionScoreboard.loadScoreboard());
            divisionScoreboards.add(divisionScoreboard);
        }
        return scoreboard;
    }

    @Override
    public List<TeamOnScoreboard> sort() {
        Collections.sort(scoreboard);
        return scoreboard;
    }

    @Override
    public List<IScoreboard> getDivisionScoreboards() {
        return divisionScoreboards;
    }
}
