package org.statemachine.interfaces;

import org.leaguemodel.interfaces.ILeague;
import org.leaguemodel.interfaces.ILeagueGetSetDB;

public interface IDisplay {

    public void displayLeagueList(ILeagueGetSetDB db);

    public void displayTeamList(String leagueName, ILeagueGetSetDB db);

    public void displayTeam(ILeague league);

    public void displayGeneralManagerList(ILeague league);

    public void displayHeadCoach(ILeague league);

    public void displayFreeAgents(ILeague league);

    public void printSaveSimulationMessage();
}
