package org.leaguemodel;

import org.leaguemodel.interfaces.IHeadCoach;
import org.leaguemodel.interfaces.IPlayers;
import org.leaguemodel.interfaces.ITeam;

import java.util.List;

public class Team implements ITeam {

    private String teamName;
    private String generalManager;
    private List<IPlayers> players;
    private IHeadCoach headCoach;
    private String teamType;

    public Team() {
        this.teamName = null;
        this.generalManager = null;
        this.headCoach = null;
        this.teamType = "AI";
        players = null;
    }

    public Team(String teamName, String teamType, String generalManager, IHeadCoach headCoach, List<IPlayers> players) {

        this.teamName = teamName;
        this.generalManager = generalManager;
        this.headCoach = headCoach;
        this.teamType = teamType;
        this.players = players;
    }

    @Override
    public String getTeamName() {
        return teamName;
    }

    @Override
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public String getGeneralManager() {
        return generalManager;
    }

    @Override
    public void setGeneralManager(String generalManager) {
        this.generalManager = generalManager;
    }

    @Override
    public IHeadCoach getHeadCoach() {
        return headCoach;
    }

    @Override
    public void setHeadCoach(IHeadCoach headCoach) {
        this.headCoach = headCoach;
    }

    @Override
    public List<IPlayers> getPlayers() {
        return players;
    }

    @Override
    public void setPlayers(List<IPlayers> players) {
        this.players = players;
    }

    public String getTeamType() {
        return teamType;
    }

    public void setTeamType(String teamType) {
        this.teamType = teamType;
    }
}
