package org.leaguesimulation;

import org.leaguesimulation.interfaces.IPlayOffSeries;

import java.util.ArrayList;
import java.util.List;

public class PlayOffSeries implements IPlayOffSeries {

    private Game playOffGame;
    private List<Game> playOffSeries;

    public PlayOffSeries(Game playOffGame, int bestOf) {
        this.playOffGame = playOffGame;
        playOffSeries = generatePlayOffSeries(bestOf);
    }

    public List<Game> generatePlayOffSeries(int bestOf) {
        playOffSeries = new ArrayList<>();
        for (int i = 0; i < bestOf; i++) {
            playOffSeries.add(playOffGame);
        }
        return playOffSeries;
    }

    @Override
    public List<Game> getPlayOffSeries() {
        return playOffSeries;
    }
}
