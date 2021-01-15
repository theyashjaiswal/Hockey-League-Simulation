package org.statemachine.interfaces;

import org.leaguemodel.interfaces.ILeague;
import org.leaguemodel.interfaces.ILeagueGetSetDB;
import org.leaguemodel.interfaces.ILoadSaveTeam;

public interface ILoad {

    ILeague loadTeam(ILeague leagueLOM, ILoadSaveTeam iLoadSaveTeam, ILeagueGetSetDB db);
}
