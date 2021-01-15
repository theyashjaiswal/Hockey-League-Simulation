package org.leaguemodel.interfaces;

public interface ILoadSaveTeam {

    void saveTeam(ILeague league, ILeagueGetSetDB databaseObj);

    ILeague loadTeam(String leagueName, String teamName, ILeague league, ILeagueGetSetDB db);

    ILeague appendTeam(String divisionName, String conferenceName, ITeam team, ILeague league);
}
