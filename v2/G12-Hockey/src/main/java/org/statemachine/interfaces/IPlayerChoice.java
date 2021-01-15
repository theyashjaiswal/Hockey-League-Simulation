package org.statemachine.interfaces;

import org.leaguemodel.interfaces.ILeague;
import org.leaguemodel.interfaces.ILeagueGetSetDB;
import org.leaguemodel.interfaces.IPlayers;

import java.util.List;

public interface IPlayerChoice {

    List<IPlayers> choosePlayers(ILeague league);

    ILeague playerChoice(String[] args, String jsonSchemaLocation, ILeagueGetSetDB db);
}
