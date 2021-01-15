package org.trading.interfaces;

import org.leaguemodel.interfaces.ITeam;

public interface ICheckPlayers {

    void Captain(ITeam team);

    public int goalies(ITeam team);

    public int skaters(ITeam team);
}
