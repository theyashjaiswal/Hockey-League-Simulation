package org.trading.interfaces;

import org.leaguemodel.interfaces.ILeague;
import org.leaguemodel.interfaces.ITeam;
import org.leaguemodel.interfaces.ITrading;

public interface ITradingTeam {

    public void tradingTeamPlayers(ITeam askingTeam, ILeague leagueOne, ITrading tradeConfig);

    public void AITrade(ITeam askingTeam, ITeam oppositeTeam, ITrading tradeConfig, ILeague leagueOne);

    public void UserTrade(ITeam askingTeam, ITeam oppositeTeam, int maxPlayersPerTrade, ILeague leagueOne);
}
