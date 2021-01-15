package org.leaguesimulation;

import org.leaguesimulation.interfaces.IScheduler;
import org.leaguesimulation.interfaces.IScoreboard;

import java.util.ArrayList;
import java.util.List;

public class RegularSeasonScheduler implements IScheduler {
    List<Game> listOfGames;
    IScoreboard leagueScoreboard;

    public RegularSeasonScheduler(IScoreboard leagueScoreboard) {
        this.listOfGames = new ArrayList<>();
        this.leagueScoreboard = leagueScoreboard;
    }

    @Override
    public List<Game> schedule(int totalGamesPerTeam) {
        for (int i = 0; i < repeatGames(totalGamesPerTeam); i++) {
            for (TeamOnScoreboard teamOnScoreboardOne : leagueScoreboard.getScoreboard()) {

                for (TeamOnScoreboard teamOnScoreboardTwo : leagueScoreboard.getScoreboard()) {
                    if (teamOnScoreboardOne.equals(teamOnScoreboardTwo)) {
                    } else {
                        listOfGames.add(new Game(teamOnScoreboardOne, teamOnScoreboardTwo));
                    }
                }

            }
        }
        return listOfGames;
    }

    private int repeatGames(int totalGamesPerTeam) {
        int returnValue = totalGamesPerTeam / leagueScoreboard.getScoreboard().size();
        return returnValue == 0 ? 1 : returnValue;
    }

}
