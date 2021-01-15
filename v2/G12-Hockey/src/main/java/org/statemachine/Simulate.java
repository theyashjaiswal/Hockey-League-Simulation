package org.statemachine;

import org.statemachine.interfaces.IInput;
import org.statemachine.interfaces.ISimulation;
import java.util.Scanner;

public class Simulate implements ISimulation {
    public int simulateSeasons() {
        StateMachineStringConstants stringConstants = new StateMachineStringConstants();
        IInput input = new Input();
        String numOfSeasons = "";
        System.out.println("Let's begin the simulation ...");
        numOfSeasons = input.userInput(stringConstants.SIMULATESEASON);
        System.out.println("Simulation begins:");
        return Integer.parseInt(numOfSeasons);
    }

    public boolean abortSimulation() {
        System.out.println("Hockey league simulation ended!");
        return true;
    }
}
