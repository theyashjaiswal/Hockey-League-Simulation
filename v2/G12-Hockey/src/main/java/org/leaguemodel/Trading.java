package org.leaguemodel;

import org.leaguemodel.interfaces.ITrading;

public class Trading implements ITrading {

    private Integer lossPoint;
    private Double randomTradeOfferChance;
    private Integer maxPlayersPerTrade;
    private Double randomAcceptanceChance;

    @Override
    public Integer getLossPoint() {
        return lossPoint;
    }

    @Override
    public void setLossPoint(Integer lossPoint) {
        this.lossPoint = lossPoint;
    }

    @Override
    public Double getRandomTradeOfferChance() {
        return randomTradeOfferChance;
    }

    @Override
    public void setRandomTradeOfferChance(Double randomTradeOfferChance) {
        this.randomTradeOfferChance = randomTradeOfferChance;
    }

    @Override
    public Integer getMaxPlayersPerTrade() {
        return maxPlayersPerTrade;
    }

    @Override
    public void setMaxPlayersPerTrade(Integer maxPlayersPerTrade) {
        this.maxPlayersPerTrade = maxPlayersPerTrade;
    }

    @Override
    public Double getRandomAcceptanceChance() {
        return randomAcceptanceChance;
    }

    @Override
    public void setRandomAcceptanceChance(Double randomAcceptanceChance) {
        this.randomAcceptanceChance = randomAcceptanceChance;
    }

}
