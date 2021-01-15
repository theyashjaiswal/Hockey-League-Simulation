package org.trading;

import org.leaguemodel.interfaces.IPlayers;
import org.trading.interfaces.IDisplayTrade;
import org.trading.interfaces.ITradeDecision;

import java.util.List;

public class TradeDecision implements ITradeDecision {

    public Boolean tradeAIDecision(Double randomAcceptanceChance) {
        double randomValue = Math.random();
        if (randomValue < randomAcceptanceChance) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean tradeUserDecision(List<IPlayers> weakPlayers, List<IPlayers> strongPlayers) {
        IDisplayTrade displayUserTrade = new DisplayTrade();
        if (displayUserTrade.displayUserTrade(weakPlayers, strongPlayers)) {
            return true;
        } else {
            return false;
        }
    }
}
