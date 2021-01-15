package org.statemachine;

import org.leaguemodel.League;

import java.util.Scanner;

public interface IStateMachine {
    public League createTeam(League leagueLOM);
    public void loadTeam(League leagueLOM);
    public void simulateSeasons(String teamName, Scanner scanner);
}
