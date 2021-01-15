package org.leaguesimulation;

import org.leaguesimulation.interfaces.ITeamOnScoreboard;
import org.leaguesimulation.interfaces.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConferencePlayOff implements IScoreboard, IPlayOffScoreboard, ISeed, IConferencePlayOffScoreboard {

    private IConferenceScoreboard conferenceScoreboard;
    private List<TeamOnScoreboard> conferencePlayOffScoreboard;
    private List<IScoreboard> divisionPlayOffScoreboards;
    private TeamOnScoreboard winner;
    private boolean isFinal;

    public ConferencePlayOff(IConferenceScoreboard conferenceScoreboard) {
        this.conferenceScoreboard = conferenceScoreboard;
        conferencePlayOffScoreboard = new ArrayList<>();
        divisionPlayOffScoreboards = new ArrayList<>();
    }

    @Override
    public List<TeamOnScoreboard> loadScoreboard() {
        for (IScoreboard divisionScoreboard : conferenceScoreboard.getDivisionScoreboards()) {
            IScoreboard divisionPlayOffScoreboard = new DivisionPlayOff(divisionScoreboard);
            conferencePlayOffScoreboard.addAll(divisionPlayOffScoreboard.loadScoreboard());
            divisionPlayOffScoreboards.add(divisionPlayOffScoreboard);
        }
        return conferencePlayOffScoreboard;
    }

    @Override
    public List<TeamOnScoreboard> getScoreboard() {
        return conferencePlayOffScoreboard;
    }

    @Override
    public List<TeamOnScoreboard> sort() {
        Collections.sort(conferencePlayOffScoreboard);
        return conferencePlayOffScoreboard;
    }

    @Override
    public ITeamOnScoreboard getWinner() {
        return winner;
    }

    @Override
    public ITeamOnScoreboard checkWinner() {
        if (isFinal) {
            winner = sort().get(LeagueSimulationConstants.ZERO);
            return winner;
        } else {
            for (IScoreboard divisionScoreboard : divisionPlayOffScoreboards) {
                IPlayOffScoreboard divisionPlayOffScoreboard = (IPlayOffScoreboard) divisionScoreboard;
                divisionPlayOffScoreboard.checkWinner();
            }
        }
        return null;
    }

    @Override
    public boolean setFinal() {
        isFinal = true;
        return true;
    }

    @Override
    public void initiateScoreToZero() {
        for (IScoreboard divisionScoreboard :
                divisionPlayOffScoreboards) {
            IPlayOffScoreboard playOffScoreboard = (IPlayOffScoreboard) divisionScoreboard;
            playOffScoreboard.initiateScoreToZero();
        }
    }

    @Override
    public void seed(int numberOfWildCards) {
        sort();
        int i = 0;
        IScoreboard iScoreboard = (IScoreboard) conferenceScoreboard;
        iScoreboard.sort();
        for (IScoreboard divisionScoreboard :
                divisionPlayOffScoreboards) {
            ISeed seedDivision = (ISeed) divisionScoreboard;
            seedDivision.seed(iScoreboard.getScoreboard().get((numberOfWildCards * LeagueSimulationConstants.THREE) + i));
            i++;
        }
    }

    @Override
    public void seed(TeamOnScoreboard wildCard) {
        System.out.println("Correct usage: call with the division");
    }

    @Override
    public List<IScoreboard> getDivisionScoreboards() {
        return divisionPlayOffScoreboards;
    }
}
