package org.statemachine;

import org.database.Database;
import org.leaguemodel.*;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerChoice {

    //String jsonSchemaLocation = System.getProperty("user.dir")+"//G12-Hockey-war//src//main//conf//schema.json";
    //String jsonSchemaLocation = System.getenv("DHL_HOME")+"//conf//schema.json";
    String jsonSchemaLocation = "schema.json";
    Database db = new Database();
    PlayerChoice(){

    }

    PlayerChoice(String[] args, ILeague db) {
        int optionSelected = 2;
        League leagueLOM = new League();

        System.out.println("\nWelcome to Hockey League Simulation!\n");
        if(args.length!=0 && args[0]!=null && args[0].length()>0){
            leagueLOM = initJSON(args, jsonSchemaLocation);
            if (leagueLOM == null)
                optionSelected = 4;
            else {
                System.out.println("1. Create team\n2. Load Team\n");
                Scanner scanner = new Scanner(System.in);
                optionSelected = Integer.parseInt(userInput("selected option from the above list", scanner));
            }
        }

        switch (optionSelected){
            case 1: createTeam(leagueLOM, db);
                break;
            case 2: loadTeam(leagueLOM, db);
                break;
            default: abortSimulation();
        }
    }

    public boolean abortSimulation() {
        System.out.println("Hockey league simulation ended!");
        return true;
    }

    public String userInput (String str, Scanner scanner) {
        String strDuplicate = str;
        do {
            System.out.print("Enter the "+strDuplicate+":");
            str = scanner.nextLine();
        } while (str.length() == 0);
        return str;
    }

    public League createTeam (League leagueLOM, ILeague db){ //Instantiate LOM based on the JSON input and user input.
        String conferenceName = "";
        String divisionName = "";
        String teamName = "";
        String generalManager = "";
        String headCoach = "";
        boolean proceed = false;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Let's begin the team creation ...");

        conferenceName = userInput("conference name", scanner);
        proceed = leagueLOM.validateConference(conferenceName, leagueLOM);
        divisionName = proceed ? userInput("division name",scanner) : "";
        proceed = leagueLOM.validateDivisions(conferenceName, divisionName, leagueLOM);

        if(!proceed) {
            System.out.println("Provided incorrect value, team creation aborted!");
            return null;
        }

        teamName = userInput("new team name to be created", scanner);
        generalManager = userInput("general manager name", scanner);
        headCoach = userInput("head coach name", scanner);

        createTeamFromInput(conferenceName, divisionName, teamName, generalManager, headCoach, leagueLOM, db);
        simulateSeasons(teamName, scanner);
        scanner.close();
        return  leagueLOM;
    }

    public boolean validateLOM(League leagueLOM){
        boolean validateStatus=false;
        if(leagueLOM.validateConferenceList(leagueLOM)){
            System.out.println("Duplicate conferences in the import");
            validateStatus = true;
        }
        else if(leagueLOM.validateDivisionList(leagueLOM)){
            System.out.println("Duplicate divisions in the conference");
            validateStatus = true;
        }
        else if(leagueLOM.validateTeamList(leagueLOM)){
            System.out.println("Duplicate teams in the league");
            validateStatus = true;
        }
        else if(leagueLOM.validateCaptain(leagueLOM)){
            System.out.println("Captain status is ambigious");
            validateStatus = true;
        }
        return validateStatus;
    }

    public void createDBObject(League leagueLOM, ILeague db){
        leagueLOM.insertTeam(leagueLOM,db);
    }

    public void createTeamFromInput (String conferenceName, String divisionName,String teamName, String generalManager, String headCoach, League leagueLOM, ILeague db){
        Team teamLOM = new Team();
        ArrayList<Players> playersArrayList = new ArrayList<Players>();

        teamLOM.setTeamName(teamName);
        teamLOM.setGeneralManager(generalManager);
        teamLOM.setHeadCoach(headCoach);
        teamLOM.setPlayers(playersArrayList); // Teams are created without players for M1

        leagueLOM = leagueLOM.appendTeam(divisionName, conferenceName, teamLOM, leagueLOM);
        System.out.println("Please wait while we load the team ...");
        createDBObject(leagueLOM, db);
        System.out.println("Team is created successfully!");
    }

    public void listLeague(ILeague db) {
        List leagueNameList = new ArrayList();
        leagueNameList = db.getLeagueName();
        if(leagueNameList.size()==0 || leagueNameList.isEmpty()){
            System.out.println("No League in the db to load");
            System. exit(1);
        }
        for (int i = 0; i < leagueNameList.size(); i++) {
            System.out.println((i+1)+". "+leagueNameList.get(i));
        }
    }

    public void listTeam(String leagueName, ILeague db) {
        List teamNameList = new ArrayList();
        teamNameList = db.getTeamName(leagueName);
        if(teamNameList.size()==0 || teamNameList.isEmpty()){
            System.out.println("No teams in the league");
            System. exit(1);
        }
        for (int i = 0; i < teamNameList.size(); i++) {
            System.out.println((i+1)+". "+teamNameList.get(i));
        }
    }

    public void loadTeam (League leagueLOM, ILeague db){ //Perform instantiation of LOM using data fetched with team name from DB.
        String leagueName;
        String teamName = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Here is the list of leagues:");
        listLeague(db);
        leagueName = userInput("league name from the list to load", scanner);//Call DB to show the list of leagues
        listTeam(leagueName, db);
        teamName = userInput("existing team name from last saved data", scanner);
        System.out.println("Please wait while we load the team ...");
        leagueLOM = leagueLOM.loadTeam(leagueName,teamName,leagueLOM,db);
        simulateSeasons(teamName, scanner);
        displayTeam(leagueLOM);
        scanner.close();
    }

    public void displayTeam(League league){
        System.out.println("\n==============================");
        for(int i = 0;i<league.getConference().size();i++)
        {
        System.out.println("Conference Name : "+league.getConference().get(i).getConferenceName());
            for(int j = 0; j<league.getConference().get(i).getDivisions().size();j++)
            {
                System.out.println("Division Name : "+league.getConference().get(i).getDivisions().get(j).getDivisionName());
                for(int k = 0; k<league.getConference().get(i).getDivisions().get(j).getTeams().size();k++){
                    System.out.println("Team Name : "+league.getConference().get(i).getDivisions().get(j).getTeams().get(k).getTeamName());
                }
            }
        }
    }

    public void simulateSeasons (String teamName, Scanner scanner){ //Simulation of multiple states
        String numOfSeasons = "";

        System.out.println("Let's begin the simulation ...");
        numOfSeasons = userInput("number of seasons to simulate", scanner);

        System.out.println("Simulation begins:");
        for (int i = 1; i <= Integer.parseInt(numOfSeasons); i++) {
            System.out.println("Entering season "+i+":");
            nestedState1(i);
            System.out.println("Simulated season "+ i +" for team:"+teamName);
        }

    }

    public void nestedState1(int seasonNum) {
        System.out.println("Nested state to play season "+ seasonNum);
        nestedState2();
    }

    public void nestedState2(){
        System.out.println("Nested state to take a break");

    }

    public League initJSON(String[] args, String jsonSchemaLocation){
        boolean schemaValStatus = false;
        String leagueData, jsonSchema;
        String inputJsonLocation = args[0];

        ImportLeagueData importLeagueData = new ImportLeagueData();
        leagueData = importLeagueData.readJSON(inputJsonLocation);
        jsonSchema = importLeagueData.readJSON(jsonSchemaLocation);
        schemaValStatus = importLeagueData.schemaValidation(leagueData,jsonSchema);

        if(!schemaValStatus){
            System.out.println("Aborted due to incorrect values in JSON!");
            return null;
        }
        // Instantiate LOM and pass it to load memory method to load data into it
        League leagueLOM;
        leagueLOM = importLeagueData.loadMemory(inputJsonLocation);
        if(validateLOM(leagueLOM)){
            return null;
        }
        return leagueLOM;
    }
}