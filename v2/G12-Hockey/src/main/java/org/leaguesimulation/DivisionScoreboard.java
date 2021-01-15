package org.leaguesimulation;

import org.leaguemodel.interfaces.IDivisions;
import org.leaguemodel.interfaces.ITeam;
import org.leaguesimulation.interfaces.IScoreboard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DivisionScoreboard implements IScoreboard {

    private IDivisions division;
    private List<TeamOnScoreboard> scoreboard;

    public DivisionScoreboard(IDivisions division, String conferenceName) {
        this.division = division;
        scoreboard = new ArrayList<>();
    }

    public List<TeamOnScoreboard> getScoreboard() {
        return scoreboard;
    }

    @Override
    public List<TeamOnScoreboard> loadScoreboard() {
        for (ITeam team : division.getTeams()) {
            scoreboard.add(new TeamOnScoreboard(team));
        }
        return scoreboard;
    }

    @Override
    public List<TeamOnScoreboard> sort() {
        Collections.sort(scoreboard);
        return scoreboard;
    }
}
