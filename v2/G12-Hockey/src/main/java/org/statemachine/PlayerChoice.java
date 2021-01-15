package org.statemachine;

import org.leaguemodel.League;
import org.leaguemodel.LoadSaveTeamToDB;
import org.leaguemodel.Players;
import org.leaguemodel.ValidationsInLeague;
import org.leaguemodel.interfaces.*;
import org.statemachine.interfaces.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerChoice implements IPlayerChoice {
    enum Position {
        goalie, forward, defense;
    }
    public ILeague playerChoice(String[] args, String jsonSchemaLocation, ILeagueGetSetDB db) {
        StateMachineConstants constants = new StateMachineConstants();
        int optionSelected = constants.OPTION3;
        ICreate createObj = new CreateTeam();
        ILoad loadObj = new LoadTeam();
        IJsonValidation jsonObj = new ImportLeagueData();
        ISimulation simulateObj = new Simulate();

        ILeague leagueLOM = new League();
        IValidationsInLeague iValidationsInLeague = new ValidationsInLeague();
        ILoadSaveTeam iLoadSaveTeam = new LoadSaveTeamToDB();
        System.out.println("\nWelcome to Hockey League Simulation!\n");

        if (args.length == 1) {
            leagueLOM = jsonObj.importLeagueJSON(args, jsonSchemaLocation);
            if (null == leagueLOM)
                optionSelected = constants.OPTION1;
            else {
                optionSelected = constants.OPTION2;
            }
        }
        if (optionSelected == constants.OPTION2) {
            createObj.createTeam(iValidationsInLeague, db, leagueLOM, iLoadSaveTeam);
        } else if (optionSelected == constants.OPTION3) {
            loadObj.loadTeam(leagueLOM, iLoadSaveTeam, db);
        }
        return leagueLOM;
    }

    public List<IPlayers> choosePlayers(ILeague league) {
        StateMachineConstants constants = new StateMachineConstants();
        StateMachineStringConstants stringConstants = new StateMachineStringConstants();
        int goalieCount = 0;
        int totalPlayer = 20;
        boolean flag = true;
        IValidate validate = new Validation();
        List<IPlayers> playersList = new ArrayList<>();
        List<Integer> trackIndex = new ArrayList<>();
        List<IPlayers> freeAgentsList = new ArrayList<>();
        IInput input = new Input();
        IDisplay display = new Display();
        Position position = Position.goalie;
        display.displayFreeAgents(league);
        do {
            flag = true;
            System.out.println("No of players left to be picked:" + (totalPlayer - playersList.size()));
            System.out.println("Provide the player number you want to pick");
            String number = input.userInput(stringConstants.PLAYERNUMBER);
            if (validate.validateString(number)) {
                System.out.println("Please enter digits only");
                flag = false;
            } else {
                int playerNumber = Integer.parseInt(number);
                if (trackIndex.contains(playerNumber)) {
                    System.out.println("Cannot enter same player again");
                    flag = false;
                }
                if (playerNumber > league.getFreeAgents().size() || playerNumber <= 0) {
                    System.out.println("Enter correct number");
                } else {
                    if (league.getFreeAgents().get(playerNumber - 1).getPlayerPosition().equalsIgnoreCase(position.toString())) {
                        goalieCount++;
                        if (goalieCount > constants.GOALIECOUNT) {
                            System.out.println("You can have only two goalie");
                            flag = false;
                        }
                    }
                    if (flag) {
                        trackIndex.add(playerNumber);
                        IPlayers player = new Players();
                        player.setPlayerName(league.getFreeAgents().get(playerNumber - 1).getPlayerName());
                        player.setPlayerPosition(league.getFreeAgents().get(playerNumber - 1).getPlayerPosition());
                        player.setAge(league.getFreeAgents().get(playerNumber - 1).getAge());
                        player.setSkating(league.getFreeAgents().get(playerNumber - 1).getSkating());
                        player.setShooting(league.getFreeAgents().get(playerNumber - 1).getShooting());
                        player.setChecking(league.getFreeAgents().get(playerNumber - 1).getChecking());
                        player.setSaving(league.getFreeAgents().get(playerNumber - 1).getSaving());
                        player.setIsCaptain(false);
                        playersList.add(player);
                    }
                }
            }
        } while (playersList.size() < constants.PLAYERCOUNT);
        for (int k = 0; k < trackIndex.size(); k++) {
            int value = trackIndex.get(k);
            freeAgentsList.add(league.getFreeAgents().get(value - 1));
        }
        league.getFreeAgents().removeAll(freeAgentsList);
        return playersList;
    }
}
