package org.leaguemodel;

import org.leaguemodel.interfaces.IGameResolver;

public class GameResolver implements IGameResolver {

    private Double randomWinChance;

    @Override
    public Double getRandomWinChance() {
        return randomWinChance;
    }

    @Override
    public void setRandomWinChance(Double randomWinChance) {
        this.randomWinChance = randomWinChance;
    }

}
