package org.statemachine;

import org.statemachine.interfaces.IStateMachine;

public class Main {
    public static void main(String[] args) {
        IStateMachine simulationStateMachine = new SimulationStateMachine(args);
        simulationStateMachine.runStateMachine();
    }
}
