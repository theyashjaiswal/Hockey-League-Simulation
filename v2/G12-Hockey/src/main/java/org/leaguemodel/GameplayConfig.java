package org.leaguemodel;

import org.leaguemodel.interfaces.*;

public class GameplayConfig implements IGameplayConfig {

    private IAging aging;
    private IGameResolver gameResolver;
    private IInjuries injuries;
    private ITraining training;
    private ITrading trading;

    @Override
    public IAging getAging() {
        return aging;
    }

    @Override
    public void setAging(IAging aging) {
        this.aging = aging;
    }

    @Override
    public IGameResolver getGameResolver() {
        return gameResolver;
    }

    @Override
    public void setGameResolver(IGameResolver gameResolver) {
        this.gameResolver = gameResolver;
    }

    @Override
    public IInjuries getInjuries() {
        return injuries;
    }

    @Override
    public void setInjuries(IInjuries injuries) {
        this.injuries = injuries;
    }

    @Override
    public ITraining getTraining() {
        return training;
    }

    @Override
    public void setTraining(ITraining training) {
        this.training = training;
    }

    @Override
    public ITrading getTrading() {
        return trading;
    }

    @Override
    public void setTrading(ITrading trading) {
        this.trading = trading;
    }
}
