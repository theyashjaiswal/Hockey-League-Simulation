package org.statemachine;

import org.leaguemodel.interfaces.ILeague;
import org.leaguemodel.interfaces.ILeagueGetSetDB;
import org.leaguemodel.interfaces.ILoadSaveTeam;
import org.statemachine.interfaces.IDisplay;
import org.statemachine.interfaces.IInput;
import org.statemachine.interfaces.ILoad;

public class LoadTeam implements ILoad {

    private IInput input;

    public ILeague loadTeam(ILeague leagueLOM, ILoadSaveTeam iLoadSaveTeam, ILeagueGetSetDB db) {
        StateMachineStringConstants stringConstants = new StateMachineStringConstants();
        String leagueName;
        String teamName;
        input = new Input();
        IDisplay display = new Display();
        System.out.println("Here is the list of leagues:");
        display.displayLeagueList(db);
        leagueName = input.userInput(stringConstants.LEAGUENAME);
        display.displayTeamList(leagueName, db);
        teamName = input.userInput(stringConstants.EXISTINGTEAMNAME);
        System.out.println("Please wait while we load the team ...");
        leagueLOM = iLoadSaveTeam.loadTeam(leagueName, teamName, leagueLOM, db);
        return leagueLOM;
    }
}
