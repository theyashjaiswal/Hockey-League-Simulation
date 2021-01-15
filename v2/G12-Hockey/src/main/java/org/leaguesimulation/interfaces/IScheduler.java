package org.leaguesimulation.interfaces;

import org.leaguesimulation.Game;

import java.util.List;

public interface IScheduler {

    List<Game> schedule(int totalGamesPerTeam);

}
