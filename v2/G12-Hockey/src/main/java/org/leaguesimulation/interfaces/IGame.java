package org.leaguesimulation.interfaces;

import org.leaguemodel.interfaces.IGameplayConfig;
import org.leaguesimulation.TeamOnScoreboard;

public interface IGame {

    void executeGame(IGameplayConfig gameplayConfig);
    TeamOnScoreboard getTeamOne();
    TeamOnScoreboard getTeamTwo();

}
