package org.trading.interfaces;

import org.leaguemodel.interfaces.ILeague;
import org.leaguemodel.interfaces.IPlayers;
import org.leaguemodel.interfaces.ITeam;

import java.util.List;

public interface IDisplayTrade {

    public Boolean displayUserTrade(List<IPlayers> weakPlayers, List<IPlayers> strongPlayers);

    public int displayFreeAgents(ITeam team, ILeague leagueObj);

    public int displayPlayerList(ITeam team);

    public void displayAITradeStatus(String askingTeam, String oppositeTeam, Boolean tradeDecision);

    public void displayUserTradeStatus(String askingTeam, String oppositeTeam, Boolean tradeDecision);
}
