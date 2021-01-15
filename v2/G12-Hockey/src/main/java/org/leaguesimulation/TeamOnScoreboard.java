package org.leaguesimulation;

import org.leaguemodel.interfaces.ITeam;
import org.leaguesimulation.interfaces.ITeamOnScoreboard;

public class TeamOnScoreboard implements ITeamOnScoreboard, Comparable<TeamOnScoreboard> {

    private ITeam team;
    private int score;
    private int lossPoints;
    private int lossPointsForTrade;

    public TeamOnScoreboard() { }

    public TeamOnScoreboard(ITeam team) {
        this.team = team;
        this.score = LeagueSimulationConstants.ZERO;
        this.lossPoints = LeagueSimulationConstants.ZERO;
        this.lossPointsForTrade = LeagueSimulationConstants.ZERO;
    }

    public int getLossPoints() {
        return lossPoints;
    }

    public void setLossPoints(int lossPoints) {
        this.lossPoints = lossPoints;
    }

    @Override
    public ITeam getTeam() {
        return team;
    }

    public void setTeam(ITeam team) {
        this.team = team;
    }

    @Override
    public int getScore() {
        return this.score;
    }

    @Override
    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int getLossPointsForTrade() {
        return lossPointsForTrade;
    }

    @Override
    public void setLossPointsForTrade(int lossPointsForTrade) {
        this.lossPointsForTrade = lossPointsForTrade;
    }

    @Override
    public int compareTo(TeamOnScoreboard team) {
        int compareScore = team.getScore();
        return compareScore - this.score;
    }
}
