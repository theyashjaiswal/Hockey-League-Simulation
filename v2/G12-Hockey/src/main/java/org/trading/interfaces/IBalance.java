package org.trading.interfaces;

import org.leaguemodel.interfaces.ILeague;
import org.leaguemodel.interfaces.ITeam;

public interface IBalance {

    public void balanceTeams(ITeam team, ILeague leagueOne);

    public void addFromFreeAgent(ITeam team, ILeague leagueOne, String playerPosition, int count);

    public void removeFromTeam(ITeam team, ILeague leagueOne, String playerPosition, int count);

    public void addUserTeam(ITeam team, ILeague leagueOne, int freeAgentNum);

    public void removeUserTeam(ITeam team, ILeague leagueOne, int playerNum);

}
