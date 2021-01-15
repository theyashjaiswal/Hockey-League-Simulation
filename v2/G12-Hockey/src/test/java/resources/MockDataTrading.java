package resources;

import org.leaguemodel.*;
import org.leaguemodel.interfaces.*;

import java.util.ArrayList;
import java.util.List;

public class MockDataTrading extends League {

    private IPlayers playerOne = new Players("Forward", "Player one", false, 27, 15, 18, 12, 0);//45
    private IPlayers playerTwo = new Players("Defense", "Player two", false, 20, 10, 10, 10, 0);//30
    private IPlayers playerThree = new Players("Goalie", "Player three", true, 33, 10, 4, 9, 18);//41
    private IPlayers playerFour = new Players("Forward", "Player four", false, 27, 15, 18, 12, 0);//45
    private IPlayers playerFive = new Players("Defense", "Player five", false, 20, 10, 11, 10, 0);//30
    private IPlayers playerSix = new Players("Forward", "Player six", false, 33, 10, 4, 9, 18);//41
    private IPlayers playerSeven = new Players("Forward", "Player seven", false, 27, 15, 17, 12, 0);//45
    private IPlayers playerEight = new Players("Defense", "Player eight", false, 20, 12, 10, 10, 0);//30
    private IPlayers playerNine = new Players("Defense", "Player nine", true, 33, 11, 5, 9, 18);//41
    private IPlayers playerTen = new Players("Forward", "Player ten", false, 27, 15, 14, 12, 0);//45
    private IPlayers playerEleven = new Players("Forward", "Player eleven", false, 27, 11, 18, 12, 0);//45
    private IPlayers playerTwelve = new Players("Defense", "Player twelve", false, 20, 9, 10, 10, 0);//30
    private IPlayers playerThirteen = new Players("Goalie", "Player thirteen", false, 33, 10, 7, 9, 18);//41
    private IPlayers playerFourteen = new Players("Forward", "Player fourteen", false, 27, 13, 12, 12, 0);//45
    private IPlayers playerFifteen = new Players("Defense", "Player fifteen", false, 20, 12, 13, 10, 0);//30
    private IPlayers playerSixteen = new Players("Forward", "Player sixteen", false, 33, 10, 8, 9, 17);//41
    private IPlayers playerSeventeen = new Players("Forward", "Player seventeen", false, 27, 15, 17, 16, 0);//45
    private IPlayers playerEighteen = new Players("Defense", "Player eighteen", false, 20, 12, 11, 10, 0);//30
    private IPlayers playerNinteen = new Players("Defense", "Player ninteen", false, 33, 11, 5, 9, 18);//41
    private IPlayers playerTwenty = new Players("Forward", "Player twenty", false, 27, 14, 14, 12, 0);//45


    private IPlayers playerOneTwo = new Players("Forward", "Player oneOne", true, 33, 120, 20, 20, 0);//33
    private IPlayers playerTwoTwo = new Players("Defense", "Player twoTwo", false, 20, 110, 10, 10, 0);//30
    private IPlayers playerThreeThree = new Players("Goalie", "Player threeThree", false, 27, 115, 18, 12, 19);//64
    private IPlayers playerFourFour = new Players("Forward", "Player fourFour", false, 27, 9, 20, 9, 0);//45
    private IPlayers playerFiveFive = new Players("Defense", "Player fiveFive", false, 20, 10, 19, 17, 0);//30
    private IPlayers playerSixSix = new Players("Forward", "Player sixSix", false, 33, 10, 8, 9, 18);//41
    private IPlayers playerSevenSeven = new Players("Forward", "Player sevenSeven", false, 27, 11, 17, 12, 0);//45
    private IPlayers playerEightEight = new Players("Defense", "Player eightEight", false, 20, 12, 14, 10, 0);//30
    private IPlayers playerNineNine = new Players("Defense", "Player nineNine", true, 33, 9, 5, 9, 18);//41
    private IPlayers playerTenTen = new Players("Forward", "Player tenTen", false, 27, 11, 14, 8, 0);//45
    private IPlayers playerElevenEleven = new Players("Forward", "Player elevenEleven", false, 27, 18, 18, 12, 0);//45
    private IPlayers playerTwelveTwelve = new Players("Defense", "Player twelveTwelve", false, 20, 5, 10, 10, 0);//30
    private IPlayers playerThirteenThirteen = new Players("Forward", "Player thirteenThirteen", false, 33, 11, 6, 9, 18);//41
    private IPlayers playerFourteenFourteen = new Players("Forward", "Player fourteenFourteen", false, 27, 11, 11, 12, 0);//45
    private IPlayers playerFifteenFifteen = new Players("Defense", "Player fifteenFifteen", false, 20, 19, 13, 10, 0);//30
    private IPlayers playerSixteenSixteen = new Players("Forward", "Player sixteenSixteen", false, 33, 11, 8, 2, 17);//41
    private IPlayers playerSeventeenSeventeen = new Players("Forward", "Player seventeenSeventeen", false, 27, 14, 17, 15, 0);//45
    private IPlayers playerEighteenEighteen = new Players("Defense", "Player eighteenEighteen", false, 20, 12, 11, 10, 0);//30
    private IPlayers playerNinteenNinteen = new Players("Defense", "Player ninteenNinteen", false, 33, 11, 5, 4, 18);//41
    private IPlayers playerTwentyTwenty = new Players("Forward", "Player twentyTwenty", false, 27, 9, 12, 11, 0);//45
    private IPlayers playerTwentyOneTwentyOne = new Players("Defense", "Player TwentyOneTwentyOne", false, 20, 12, 11, 10, 0);//30
    private IPlayers playerTwentyTwoTwentyTwo = new Players("Defense", "Player TwentyTwoTwentyTwo", false, 33, 11, 5, 4, 18);//41
    private IPlayers playerTwentyThreeTwentyThree = new Players("Forward", "Player TwentyThreeTwentyThree", false, 27, 9, 12, 11, 0);//45


    private IPlayers playerOneThird = new Players("Forward", "Player Onethird", true, 33, 11, 14, 11, 0);//33
    private IPlayers playerTwoThird = new Players("Defense", "Player Twothird", false, 20, 10, 10, 10, 0);//30
    private IPlayers playerThreeThird = new Players("Goalie", "Player Threethird", false, 27, 12, 12, 12, 19);//64
    private IPlayers playerFourThird = new Players("Forward", "Player fourThird", false, 27, 15, 13, 12, 0);//45
    private IPlayers playerFiveThird = new Players("Defense", "Player fiveThird", false, 20, 10, 11, 10, 0);//30
    private IPlayers playerSixThird = new Players("Forward", "Player sixThird", false, 33, 10, 4, 9, 18);//41
    private IPlayers playerSevenThird = new Players("Forward", "Player sevenThird", false, 27, 5, 20, 20, 0);//45
    private IPlayers playerEightThird = new Players("Defense", "Player eightThird", false, 20, 14, 10, 10, 0);//30
    private IPlayers playerNineThird = new Players("Defense", "Player nineThird", true, 33, 11, 3, 9, 18);//41
    private IPlayers playerTenThird = new Players("Forward", "Player tenThird", false, 27, 11, 11, 13, 0);//45
    private IPlayers playerElevenThird = new Players("Forward", "Player elevenThird", false, 27, 11, 16, 12, 0);//45
    private IPlayers playerTwelveThird = new Players("Defense", "Player twelveThird", false, 20, 16, 11, 11, 0);//30
    private IPlayers playerThirteenThird = new Players("Forward", "Player thirteenThird", false, 33, 15, 5, 10, 18);//41
    private IPlayers playerFourteenThird = new Players("Forward", "Player fourteenThird", false, 27, 11, 12, 19, 0);//45
    private IPlayers playerFifteenThird = new Players("Defense", "Player fifteenThird", false, 20, 12, 13, 10, 0);//30
    private IPlayers playerSixteenThird = new Players("Forward", "Player sixteenThird", false, 33, 14, 5, 11, 17);//41
    private IPlayers playerSeventeenThird = new Players("Forward", "Player seventeenThird", false, 27, 50, 90, 12, 0);//45
    private IPlayers playerEighteenThird = new Players("Defense", "Player eighteenThird", false, 20, 20, 20, 20, 0);//30
    private IPlayers playerNinteenThird = new Players("Defense", "Player ninteenThird", false, 33, 11, 5, 9, 18);//41
    private IPlayers playerTwentyThird = new Players("Forward", "Player twentyThird", false, 27, 17, 18, 13, 0);//45
    private ArrayList<IPlayers> playerList = new ArrayList<>();
    private ArrayList<IPlayers> playerListTwo = new ArrayList<>();
    private ArrayList<ITeam> teamsList = new ArrayList<>();
    private ArrayList<ITeam> teamsListTwo = new ArrayList<>();
    private ArrayList<IDivisions> divisionList = new ArrayList<>();
    private ArrayList<IConference> conferenceList = new ArrayList<>();
    private ArrayList<IDivisions> divisionListTwo = new ArrayList<>();

    private ArrayList<IPlayers> playerListThree = new ArrayList<>();
    private ArrayList<ITeam> teamsListThree = new ArrayList<>();
    private ArrayList<IDivisions> divisionListThree = new ArrayList<>();
    private ArrayList<IConference> conferenceListThree = new ArrayList<>();

    private List<String> managersList = new ArrayList();

    public League leagueOne = new League();
    public ArrayList<IPlayers> freeAgents = new ArrayList<>();

    public MockDataTrading() {
        playerList.add(playerOne);
        playerList.add(playerTwo);
        playerList.add(playerThree);
        playerList.add(playerFour);
        playerList.add(playerFive);
        playerList.add(playerSix);
        playerList.add(playerSeven);
        playerList.add(playerEight);
        playerList.add(playerNine);
        playerList.add(playerTen);
        playerList.add(playerEleven);
        playerList.add(playerTwelve);
        playerList.add(playerThirteen);
        playerList.add(playerFourteen);
        playerList.add(playerFifteen);
        playerList.add(playerSixteen);
        playerList.add(playerSeventeen);
        playerListTwo.add(playerOneTwo);
        playerListTwo.add(playerTwoTwo);
        playerListTwo.add(playerThreeThree);
        playerListTwo.add(playerFourFour);
        playerListTwo.add(playerFiveFive);
        playerListTwo.add(playerSixSix);
        playerListTwo.add(playerSevenSeven);
        playerListTwo.add(playerEightEight);
        playerListTwo.add(playerNineNine);
        playerListTwo.add(playerTenTen);
        playerListTwo.add(playerElevenEleven);
        playerListTwo.add(playerTwelveTwelve);
        playerListTwo.add(playerThirteenThirteen);
        playerListTwo.add(playerFourteenFourteen);
        playerListTwo.add(playerFifteenFifteen);
        playerListTwo.add(playerSixteenSixteen);
        playerListTwo.add(playerSeventeenSeventeen);
        playerListTwo.add(playerEighteenEighteen);
        playerListTwo.add(playerNinteenNinteen);
        playerListTwo.add(playerTwentyTwenty);
        playerListTwo.add(playerTwentyOneTwentyOne);
        playerListTwo.add(playerTwentyTwoTwentyTwo);
        playerListTwo.add(playerTwentyThreeTwentyThree);

        playerListThree.add(playerOneThird);
        playerListThree.add(playerTwoThird);
        playerListThree.add(playerThreeThird);
        playerListThree.add(playerFourThird);
        playerListThree.add(playerFiveThird);
        playerListThree.add(playerSixThird);
        playerListThree.add(playerSevenThird);
        playerListThree.add(playerEightThird);
        playerListThree.add(playerNineThird);
        playerListThree.add(playerTenThird);
        playerListThree.add(playerElevenThird);
        playerListThree.add(playerTwelveThird);
        playerListThree.add(playerThirteenThird);
        playerListThree.add(playerFourteenThird);
        playerListThree.add(playerFifteenThird);
        playerListThree.add(playerSixteenThird);
        playerListThree.add(playerSeventeenThird);
        playerListThree.add(playerEighteenThird);
        playerListThree.add(playerNinteenThird);
        IHeadCoach headCoach = new HeadCoach();
        headCoach.setName("headcoach");
        headCoach.setChecking(2.4);
        headCoach.setSaving(3.1);
        headCoach.setShooting(1.2);
        headCoach.setSkating(0.5);

        ITeam teamOne = new Team("Team 12", "AI", "Mary Smith", headCoach, playerList);
        teamsList.add(teamOne);

        ITeam teamTwo = new Team("Rob's Team", "AI", "Rob", headCoach, playerListTwo);
        teamsListTwo.add(teamTwo);

        ITeam teamThree = new Team("Third Team", "USER", "Kethan", headCoach, playerListThree);
        teamsListThree.add(teamThree);

        Divisions divisionOne = new Divisions("Atlantic", teamsList);
        Divisions divisionTwo = new Divisions("Central", teamsListTwo);
        Divisions divisionThree = new Divisions("Metropolitan", teamsListThree);
        divisionList.add(divisionOne);
        divisionListTwo.add(divisionTwo);
        divisionListThree.add(divisionThree);
        IConference conferenceOne = new Conference("Eastern Conference", divisionList);
        IConference conferenceTwo = new Conference("Western Conference", divisionListTwo);
        IConference conferenceThree = new Conference("Eastern Conference", divisionListThree);

        conferenceList.add(conferenceOne);
        conferenceList.add(conferenceTwo);
        conferenceList.add(conferenceThree);
        leagueOne = new League("Dalhousie Hockey League", conferenceList, playerList);
        managersList.add("Siddhant");
        managersList.add("Vikram");
        managersList.add("Yash");
        managersList.add("Kethan");
        Coach coachA = new Coach();
        coachA.setName("A");
        coachA.setChecking(2.4);
        coachA.setSaving(3.1);
        coachA.setShooting(1.2);
        coachA.setSkating(0.5);

        Coach coachB = new Coach();
        coachB.setName("B");
        coachB.setChecking(1.3);
        coachB.setSaving(1.4);
        coachB.setShooting(8.2);
        coachB.setSkating(4.5);

        List<ICoach> coachList = new ArrayList();
        coachList.add(coachA);
        coachList.add(coachB);

        IPlayers agent1 = new FreeAgents("defense", "A1", 20, 10, 30, 10, 20);
        IPlayers agent2 = new FreeAgents("goalie", "Agent Two", 30, 10, 40, 10, 80);
        IPlayers agent3 = new FreeAgents("forward", "Agent Three", 20, 10, 30, 10, 20);
        IPlayers agent4 = new FreeAgents("goalie", "A4", 20, 60, 40, 10, 80);
        IPlayers agent5 = new FreeAgents("defense", "A5", 10, 10, 30, 10, 20);
        IPlayers agent6 = new FreeAgents("goalie", "A6", 20, 10, 40, 10, 80);
        IPlayers agent7 = new FreeAgents("defense", "A7", 20, 10, 30, 10, 20);
        IPlayers agent8 = new FreeAgents("defense", "A8", 20, 70, 40, 10, 80);
        IPlayers agent9 = new FreeAgents("defense", "A9", 10, 10, 30, 10, 20);
        IPlayers agent10 = new FreeAgents("defense", "A10", 20, 10, 90, 10, 80);
        IPlayers agent11 = new FreeAgents("defense", "A11", 20, 10, 30, 10, 20);
        IPlayers agent12 = new FreeAgents("defense", "A12", 20, 10, 40, 60, 80);
        IPlayers agent13 = new FreeAgents("defense", "A13", 20, 30, 30, 10, 20);
        IPlayers agent14 = new FreeAgents("defense", "A14", 20, 10, 40, 10, 80);
        IPlayers agent15 = new FreeAgents("defense", "A15", 20, 10, 30, 10, 20);
        IPlayers agent16 = new FreeAgents("defense", "A16", 80, 10, 40, 10, 80);
        IPlayers agent17 = new FreeAgents("defense", "A17", 20, 10, 90, 10, 20);
        IPlayers agent18 = new FreeAgents("defense", "A18", 20, 10, 40, 10, 80);
        IPlayers agent19 = new FreeAgents("defense", "A19", 20, 10, 30, 10, 20);
        IPlayers agent20 = new FreeAgents("defense", "A20", 40, 10, 40, 10, 80);
        IPlayers agent21 = new FreeAgents("defense", "A21", 20, 10, 50, 10, 20);
        IPlayers agent22 = new FreeAgents("defense", "A22", 30, 10, 40, 10, 80);
        IPlayers agent23 = new FreeAgents("defense", "A23", 20, 10, 30, 10, 20);
        IPlayers agent24 = new FreeAgents("defense", "A24", 20, 00, 40, 10, 80);
        IPlayers agent25 = new FreeAgents("defense", "A25", 20, 30, 30, 10, 20);
        IPlayers agent26 = new FreeAgents("goalie", "A26", 20, 10, 40, 10, 80);
        freeAgents.add(agent1);
        freeAgents.add(agent2);
        freeAgents.add(agent3);
        freeAgents.add(agent4);
        freeAgents.add(agent5);
        freeAgents.add(agent6);
        freeAgents.add(agent7);
        freeAgents.add(agent8);
        freeAgents.add(agent9);
        freeAgents.add(agent10);
        freeAgents.add(agent11);
        freeAgents.add(agent12);
        freeAgents.add(agent13);
        freeAgents.add(agent14);
        freeAgents.add(agent15);
        freeAgents.add(agent16);
        freeAgents.add(agent17);
        freeAgents.add(agent18);
        freeAgents.add(agent19);
        freeAgents.add(agent20);
        freeAgents.add(agent21);
        freeAgents.add(agent22);
        freeAgents.add(agent23);
        freeAgents.add(agent24);
        freeAgents.add(agent25);
        freeAgents.add(agent26);

        leagueOne.setFreeAgents(freeAgents);
        leagueOne.setGeneralManagers(managersList);
        leagueOne.setCoaches(coachList);
        leagueOne.setFreeAgents(freeAgents);
    }
}
