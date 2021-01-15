package org.leaguemodel.interfaces;

import java.util.List;

public interface ILeague {
    String getLeagueName();

    void setLeagueName(String leagueName);

    IGameplayConfig getGameplayConfig();

    void setGameplayConfig(IGameplayConfig gameplayConfig);

    List<IConference> getConference();

    void setConference(List<IConference> conference);

    List<IPlayers> getFreeAgents();

    void setFreeAgents(List<IPlayers> freeAgents);

    List<ICoach> getCoaches();

    void setCoaches(List<ICoach> coaches);

    List<String> getGeneralManagers();

    void setGeneralManagers(List<String> generalManagers);
}
