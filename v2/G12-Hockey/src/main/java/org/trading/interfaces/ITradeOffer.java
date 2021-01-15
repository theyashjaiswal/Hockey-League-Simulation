package org.trading.interfaces;

import org.leaguemodel.interfaces.ILeague;
import org.leaguesimulation.interfaces.IScoreboard;

public interface ITradeOffer {

    public void generateTradeOffer(IScoreboard scoreboardObj, ILeague leagueObj);

    public Boolean randomTradeOffer(Double randomTradeOfferChance);
}
