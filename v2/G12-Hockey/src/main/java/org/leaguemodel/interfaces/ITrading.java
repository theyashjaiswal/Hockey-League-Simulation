package org.leaguemodel.interfaces;

public interface ITrading {
    Integer getLossPoint();

    void setLossPoint(Integer lossPoint);

    Double getRandomTradeOfferChance();

    void setRandomTradeOfferChance(Double randomTradeOfferChance);

    Integer getMaxPlayersPerTrade();

    void setMaxPlayersPerTrade(Integer maxPlayersPerTrade);

    Double getRandomAcceptanceChance();

    void setRandomAcceptanceChance(Double randomAcceptanceChance);
}
