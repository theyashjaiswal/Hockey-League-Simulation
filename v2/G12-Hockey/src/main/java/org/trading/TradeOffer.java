package org.trading;

import org.leaguemodel.interfaces.ILeague;
import org.leaguemodel.interfaces.ITrading;
import org.leaguesimulation.interfaces.IScoreboard;
import org.trading.interfaces.ITradeOffer;
import org.trading.interfaces.ITradingTeam;

public class TradeOffer implements ITradeOffer {
    public void generateTradeOffer(IScoreboard scoreboardObj, ILeague leagueObj) {
        ITradingTeam trading = new TradingTeam();
        ITrading tradeConfig = leagueObj.getGameplayConfig().getTrading();
        for (int i = 0; i < scoreboardObj.getScoreboard().size(); i++) {
            if (scoreboardObj.getScoreboard().get(i).getLossPoints() >= tradeConfig.getLossPoint()) {
                if (randomTradeOffer(tradeConfig.getRandomTradeOfferChance())) {
                    trading.tradingTeamPlayers(scoreboardObj.getScoreboard().get(i).getTeam(), leagueObj, tradeConfig);
                    scoreboardObj.getScoreboard().get(i).setLossPoints(0);
                }
            } else {
                continue;
            }
        }
    }

    public Boolean randomTradeOffer(Double randomTradeOfferChance) {
        double randomValue = Math.random();
        if (randomValue < randomTradeOfferChance) {
            return true;
        } else {
            return false;
        }
    }
}
