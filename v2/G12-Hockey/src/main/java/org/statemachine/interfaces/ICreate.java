package org.statemachine.interfaces;


import org.leaguemodel.interfaces.ILeague;
import org.leaguemodel.interfaces.ILeagueGetSetDB;
import org.leaguemodel.interfaces.ILoadSaveTeam;
import org.leaguemodel.interfaces.IValidationsInLeague;

public interface ICreate {
    void createTeam(IValidationsInLeague iValidationsInLeague, ILeagueGetSetDB db, ILeague leagueLOM, ILoadSaveTeam iLoadSaveTeam);
}
