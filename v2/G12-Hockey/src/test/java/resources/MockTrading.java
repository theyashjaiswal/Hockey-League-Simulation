package resources;

import org.leaguemodel.interfaces.ITrading;

public class MockTrading implements ITrading {

    private Integer lossPoint;
    private Double randomTradeOfferChance;
    private Integer maxPlayersPerTrade;
    private Double randomAcceptanceChance;

    public Integer getLossPoint() {
        return lossPoint;
    }

    public void setLossPoint(Integer lossPoint) {
        this.lossPoint = lossPoint;
    }

    public Double getRandomTradeOfferChance() {
        return randomTradeOfferChance;
    }

    public void setRandomTradeOfferChance(Double randomTradeOfferChance) {
        this.randomTradeOfferChance = randomTradeOfferChance;
    }

    public Integer getMaxPlayersPerTrade() {
        return maxPlayersPerTrade;
    }

    public void setMaxPlayersPerTrade(Integer maxPlayersPerTrade) {
        this.maxPlayersPerTrade = maxPlayersPerTrade;
    }

    public Double getRandomAcceptanceChance() {
        return randomAcceptanceChance;
    }

    public void setRandomAcceptanceChance(Double randomAcceptanceChance) {
        this.randomAcceptanceChance = randomAcceptanceChance;
    }

    public MockTrading() {
        setLossPoint(8);
        setMaxPlayersPerTrade(2);
        setRandomAcceptanceChance(2.0);
        setRandomTradeOfferChance(0.8);
    }

}
