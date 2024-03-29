package org.leaguemodel.interfaces;

import java.util.List;

public interface ITeam {
    String getTeamName();

    void setTeamName(String teamName);

    String getGeneralManager();

    void setGeneralManager(String generalManager);

    IHeadCoach getHeadCoach();

    void setHeadCoach(IHeadCoach headCoach);

    List<IPlayers> getPlayers();

    void setPlayers(List<IPlayers> players);

    void setTeamType(String teamType);

    String getTeamType();
}
