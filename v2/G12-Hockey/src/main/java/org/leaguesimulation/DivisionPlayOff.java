package org.leaguesimulation;

import org.leaguesimulation.interfaces.IPlayOffScoreboard;
import org.leaguesimulation.interfaces.IScoreboard;
import org.leaguesimulation.interfaces.ISeed;
import org.leaguesimulation.interfaces.ITeamOnScoreboard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DivisionPlayOff implements IScoreboard, IPlayOffScoreboard, ISeed {

    private IScoreboard divisionScoreboard;
    private List<TeamOnScoreboard> divisionPlayOffScoreboard;
    private TeamOnScoreboard winner;
    private boolean isFinal;

    public DivisionPlayOff(IScoreboard divisionScoreboard) {
        this.divisionScoreboard = divisionScoreboard;
        divisionPlayOffScoreboard = new ArrayList<>();
    }

    @Override
    public List<TeamOnScoreboard> loadScoreboard() {
        divisionScoreboard.sort();
        divisionPlayOffScoreboard.add(divisionScoreboard.getScoreboard().get(LeagueSimulationConstants.ZERO));
        divisionPlayOffScoreboard.add(divisionScoreboard.getScoreboard().get(LeagueSimulationConstants.ONE));
        divisionPlayOffScoreboard.add(divisionScoreboard.getScoreboard().get(LeagueSimulationConstants.TWO));
        return divisionPlayOffScoreboard;
    }

    @Override
    public List<TeamOnScoreboard> getScoreboard() {
        return divisionPlayOffScoreboard;
    }

    @Override
    public List<TeamOnScoreboard> sort() {
        Collections.sort(divisionPlayOffScoreboard);
        return divisionPlayOffScoreboard;
    }

    @Override
    public TeamOnScoreboard getWinner() {
        return winner;
    }

    @Override
    public ITeamOnScoreboard checkWinner() {
        if (isFinal) {
            winner = sort().get(LeagueSimulationConstants.ZERO);
            return winner;
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
        for (TeamOnScoreboard team :
                divisionPlayOffScoreboard) {
            team.setScore(LeagueSimulationConstants.ZERO);
            team.setLossPointsForTrade(LeagueSimulationConstants.ZERO);
        }
    }

    @Override
    public void seed(int numberOfWildCards) {
        System.out.println("Correct usage: call with League");
    }

    @Override
    public void seed(TeamOnScoreboard wildCard) {
        divisionPlayOffScoreboard.add(wildCard);
    }
}
