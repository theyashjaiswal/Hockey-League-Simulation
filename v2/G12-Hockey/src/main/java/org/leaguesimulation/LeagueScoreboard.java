package org.leaguesimulation;

import org.leaguemodel.interfaces.IConference;
import org.leaguemodel.interfaces.ILeague;
import org.leaguesimulation.interfaces.IConferenceScoreboard;
import org.leaguesimulation.interfaces.ILeagueScoreboard;
import org.leaguesimulation.interfaces.IScoreboard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeagueScoreboard implements IScoreboard, ILeagueScoreboard {

    private ILeague league;
    private List<TeamOnScoreboard> scoreboard;
    private List<IConferenceScoreboard> conferenceScoreboards;

    @Override
    public List<TeamOnScoreboard> getScoreboard() {
        return scoreboard;
    }

    public LeagueScoreboard(ILeague league) {
        this.league = league;
        scoreboard = new ArrayList<>();
        conferenceScoreboards = new ArrayList<>();
    }

    @Override
    public List<TeamOnScoreboard> loadScoreboard() {
        for (IConference conference : league.getConference()) {
            IScoreboard conferenceScoreboard = new ConferenceScoreboard(conference);
            scoreboard.addAll(conferenceScoreboard.loadScoreboard());
            conferenceScoreboards.add((IConferenceScoreboard) conferenceScoreboard);
        }
        return scoreboard;
    }

    @Override
    public List<TeamOnScoreboard> sort() {
        Collections.sort(scoreboard);
        return scoreboard;
    }

    @Override
    public List<IConferenceScoreboard> getConferenceScoreboards() {
        return conferenceScoreboards;
    }
}
