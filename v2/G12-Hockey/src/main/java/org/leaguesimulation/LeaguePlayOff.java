package org.leaguesimulation;

import org.leaguesimulation.interfaces.IScoreboard;
import org.leaguesimulation.interfaces.ITeamOnScoreboard;
import org.leaguesimulation.interfaces.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeaguePlayOff implements IScoreboard, IPlayOffScoreboard, ISeed, ILeaguePlayOffScoreboard {

    private ILeagueScoreboard leagueScoreboard;
    private List<TeamOnScoreboard> leaguePlayOffScoreboard;
    private List<IConferencePlayOffScoreboard> conferencePlayOffScoreboards;
    private TeamOnScoreboard winner;
    private boolean isFinal;

    public LeaguePlayOff(IScoreboard leagueScoreboard) {
        this.leagueScoreboard = (ILeagueScoreboard) leagueScoreboard;
        this.leaguePlayOffScoreboard = new ArrayList<>();
        this.conferencePlayOffScoreboards = new ArrayList<>();
    }

    @Override
    public List<TeamOnScoreboard> loadScoreboard() {
        for (IConferenceScoreboard conferenceScoreboard : leagueScoreboard.getConferenceScoreboards()) {
            IScoreboard conferencePlayOffScoreboard = new ConferencePlayOff(conferenceScoreboard);
            leaguePlayOffScoreboard.addAll(conferencePlayOffScoreboard.loadScoreboard());
            conferencePlayOffScoreboards.add((IConferencePlayOffScoreboard) conferencePlayOffScoreboard);
        }
        return leaguePlayOffScoreboard;
    }

    @Override
    public List<TeamOnScoreboard> getScoreboard() {
        return leaguePlayOffScoreboard;
    }

    @Override
    public List<TeamOnScoreboard> sort() {
        Collections.sort(leaguePlayOffScoreboard);
        return leaguePlayOffScoreboard;
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
        } else {
            for (IConferencePlayOffScoreboard conferenceScoreboard : conferencePlayOffScoreboards) {
                IPlayOffScoreboard conferencePlayOffScoreboard = (IPlayOffScoreboard) conferenceScoreboard;
                conferencePlayOffScoreboard.checkWinner();
            }
        }
        return null;
    }

    @Override
    public boolean setFinal() {
        isFinal = true;
        return isFinal;
    }

    @Override
    public void initiateScoreToZero() {
        for (IConferencePlayOffScoreboard conferencePlayOffScoreboard :
                conferencePlayOffScoreboards) {
            IPlayOffScoreboard playOffScoreboard = (IPlayOffScoreboard) conferencePlayOffScoreboard;
            playOffScoreboard.initiateScoreToZero();
        }
    }

    @Override
    public void seed(int numberOfWildCardsPerConference) {
        for (IConferencePlayOffScoreboard conferencePlayOffScoreboard :
                conferencePlayOffScoreboards) {
            ISeed seedConference = (ISeed) conferencePlayOffScoreboard;
            seedConference.seed(numberOfWildCardsPerConference);
        }
    }

    @Override
    public void seed(TeamOnScoreboard wildCard) {
        System.out.println("League is not seedable. Correct usage is seed()");
    }

    @Override
    public List<IConferencePlayOffScoreboard> getConferenceScoreboards() {
        return conferencePlayOffScoreboards;
    }
}
