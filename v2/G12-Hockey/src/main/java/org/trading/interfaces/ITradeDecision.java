package org.trading.interfaces;

import org.leaguemodel.interfaces.IPlayers;

import java.util.List;

public interface ITradeDecision {

    public Boolean tradeAIDecision(Double randomAcceptanceChance);

    public Boolean tradeUserDecision(List<IPlayers> weakPlayers, List<IPlayers> strongPlayers);
}
