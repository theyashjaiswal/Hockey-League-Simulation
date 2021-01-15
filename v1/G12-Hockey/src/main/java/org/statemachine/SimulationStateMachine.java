package org.statemachine;

import org.database.Database;
import org.leaguemodel.ILeague;

/**
 * Simulation State Machine!
 */
public class SimulationStateMachine {

    public static void main(String[] args) {
        SimulationStateMachine ssm = new SimulationStateMachine();

        ILeague iLeagueDB = new Database();
        PlayerChoice playerChoice = new PlayerChoice(args,iLeagueDB);
        //playerChoice.abortSimulation();
        //System.out.println(System.getenv("DHL_HOME"));
        System.out.println("Thank you for using our app, simulation ended.");

    }
}
