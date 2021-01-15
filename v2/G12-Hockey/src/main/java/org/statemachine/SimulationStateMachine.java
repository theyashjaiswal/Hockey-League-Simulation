package org.statemachine;

import org.database.Database;
import org.leaguemodel.LoadSaveTeamToDB;
import org.leaguemodel.interfaces.ILeague;
import org.leaguemodel.interfaces.ILeagueGetSetDB;
import org.leaguemodel.interfaces.ILoadSaveTeam;
import org.statemachine.interfaces.*;

/**
 * Simulation State Machine!
 */
public class SimulationStateMachine implements IStateMachine {

    private String[] args;

    public SimulationStateMachine(String[] args) {
        this.args = args;
    }

    public void runStateMachine() {
        String jsonSchemaLocation = "schema.json";
        ILeagueGetSetDB iLeagueGetSetDB = new Database();
        IPlayerChoice playerChoice = new PlayerChoice();
        ILeague leagueLOM;
        leagueLOM = playerChoice.playerChoice(args, jsonSchemaLocation, iLeagueGetSetDB);
        ISimulation checkNumberOfSimulations = new Simulate();
        int numberOfSeasons = checkNumberOfSimulations.simulateSeasons();
        ILoadSaveTeam iLoadSaveTeam= new LoadSaveTeamToDB();
        ILeagueGetSetDB db= new Database();
        IDisplay display = new Display();

        for (int i = 0; i < numberOfSeasons; i++) {
            IStateMachine leagueSimulationStateMachine = new LeagueSimulationStateMachine(leagueLOM);
            leagueSimulationStateMachine.runStateMachine();
            iLoadSaveTeam.saveTeam(leagueLOM, db);
            ILeagueDateDB leagueStateForDate = (ILeagueDateDB) leagueSimulationStateMachine;
            db.setLeagueDate(leagueLOM.getLeagueName(),leagueStateForDate.getCurrentDate());
            display.printSaveSimulationMessage();
        }
        System.out.println("Thank you for using our app, simulation ended.");
    }
}
