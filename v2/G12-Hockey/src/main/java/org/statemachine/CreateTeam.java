package org.statemachine;

import org.leaguemodel.Team;
import org.leaguemodel.interfaces.*;
import org.statemachine.interfaces.*;
import java.util.List;

public class CreateTeam implements ICreate {

    private IInput input;

    public void createTeam(IValidationsInLeague iValidationsInLeague, ILeagueGetSetDB db, ILeague leagueLOM, ILoadSaveTeam iLoadSaveTeam) {
        StateMachineStringConstants stringConstants = new StateMachineStringConstants();
        String conferenceName;
        String divisionName = "";
        String teamName;
        boolean proceed;
        List<IPlayers> playersList;
        input = new Input();
        IValidate validate = new Validation();
        IDisplay display = new Display();
        IPlayerChoice choosePlayer = new PlayerChoice();
        ITeam teamLOM = new Team();
        System.out.println("Let's begin the team creation ...");
        conferenceName = input.userInput(stringConstants.CONFERENCENAME);
        proceed = iValidationsInLeague.validateConference(conferenceName, leagueLOM);
        if (proceed) {
            divisionName = input.userInput(stringConstants.DIVISIONNAME);
        }
        proceed = iValidationsInLeague.validateDivisions(conferenceName, divisionName, leagueLOM);
        if (proceed) {
            teamName = input.userInput(stringConstants.TEAMNAME);
            String userGeneralManager = teamGeneralManger(display, validate, leagueLOM);
            IHeadCoach teamHeadCoach = teamHeadCoach(display, validate, leagueLOM);
            playersList = choosePlayer.choosePlayers(leagueLOM);
            teamLOM.setTeamName(teamName);
            teamLOM.setGeneralManager(userGeneralManager);
            teamLOM.setHeadCoach(teamHeadCoach);
            teamLOM.setPlayers(playersList);
            teamLOM.setTeamType(stringConstants.USER);
            leagueLOM = iLoadSaveTeam.appendTeam(divisionName, conferenceName, teamLOM, leagueLOM);
            System.out.println("Please wait while we load the team ...");
            System.out.println("Team is created successfully!");
        } else {
            System.out.println("Provided incorrect value, team creation aborted!");
        }
    }

    public String teamGeneralManger(IDisplay display, IValidate validate, ILeague leagueLOM) {
        StateMachineStringConstants stringConstants = new StateMachineStringConstants();
        String generalManager;
        display.displayGeneralManagerList(leagueLOM);
        input = new Input();
        boolean flagManager;
        do {
            flagManager = false;
            generalManager = input.userInput(stringConstants.MANAGERNAME);

            if (validate.validateGeneralManager(leagueLOM, generalManager)) {
                System.out.println("Select option from the given list");
                flagManager = true;
            }

        } while (flagManager);
        return generalManager;
    }

    public IHeadCoach teamHeadCoach(IDisplay display, IValidate validate, ILeague leagueLOM) {
        StateMachineStringConstants stringConstants = new StateMachineStringConstants();
        String headCoach;
        IHeadCoach headCoachObj = null;
        input = new Input();
        display.displayHeadCoach(leagueLOM);
        boolean flagHeadCoach;
        do {
            flagHeadCoach = false;
            headCoach = input.userInput(stringConstants.HEADCOACHNAME);
            if (validate.validateString(headCoach)) {
                System.out.println("Please enter digits only");
                flagHeadCoach = true;
            } else {
                headCoachObj = validate.validateHeadCoach(leagueLOM, headCoach);
                if (null == headCoachObj) {
                    System.out.println("Select option from the given list");
                    flagHeadCoach = true;
                }
            }
        } while (flagHeadCoach);
        return headCoachObj;
    }
}
