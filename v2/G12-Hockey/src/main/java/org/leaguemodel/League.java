package org.leaguemodel;

import org.leaguemodel.interfaces.*;

import java.util.List;

public class League implements ILeague {

    private String leagueName;
    private IGameplayConfig gameplayConfig;
    private List<IConference> conference;
    private List<IPlayers> freeAgents;
    private List<ICoach> coaches;
    private List<String> generalManagers;

    public League() {
        this.leagueName = null;
        this.conference = null;
    }

    public League(String leagueName, List<IConference> conference, List<IPlayers> freeagent) {

        this.leagueName = leagueName;
        this.conference = conference;
    }

    @Override
    public String getLeagueName() {
        return leagueName;
    }

    @Override
    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    @Override
    public IGameplayConfig getGameplayConfig() {
        return gameplayConfig;
    }

    @Override
    public void setGameplayConfig(IGameplayConfig gameplayConfig) {
        this.gameplayConfig = gameplayConfig;
    }

    @Override
    public List<IConference> getConference() {
        return conference;
    }

    @Override
    public void setConference(List<IConference> conference) {
        this.conference = conference;
    }

    @Override
    public List<IPlayers> getFreeAgents() {
        return freeAgents;
    }

    @Override
    public void setFreeAgents(List<IPlayers> freeAgents) {
        this.freeAgents = freeAgents;
    }

    @Override
    public List<ICoach> getCoaches() {
        return coaches;
    }

    @Override
    public void setCoaches(List<ICoach> coaches) {
        this.coaches = coaches;
    }

    @Override
    public List<String> getGeneralManagers() {
        return generalManagers;
    }

    @Override
    public void setGeneralManagers(List<String> generalManagers) {
        this.generalManagers = generalManagers;
    }

}
