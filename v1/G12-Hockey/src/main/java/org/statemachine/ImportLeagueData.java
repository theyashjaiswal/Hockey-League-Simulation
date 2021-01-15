package org.statemachine;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.leaguemodel.*;
import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.util.*;

public class ImportLeagueData implements IJsonValidation {
    LeagueDataKeys leagueDataKeys = new LeagueDataKeys();
    @Override
    public String readJSON(String fileLocation) {
        String jsonString = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileLocation));
            String readLine = null;
            boolean emptyJSON = true;
            while ((readLine = bufferedReader.readLine()) != null) {
                jsonString = jsonString.concat(readLine);
                emptyJSON = false;
            }
            if (emptyJSON)
                System.out.println("JSON file is empty!");
            else
                System.out.println("Successfully read the JSON File:"+fileLocation);
        } catch (FileNotFoundException e) {
            System.out.println("Could not find the file at the specified location:"+fileLocation);
        } catch (IOException e) {
            System.out.println("IOException - Error while reading the file content!");
        }
        return jsonString;
    }

    @Override
    public boolean schemaValidation(String leagueData, String jsonSchema) {
        boolean status = false;
        JSONObject jsonObject = new JSONObject(jsonSchema);
        try {
            Schema schema = SchemaLoader.load(jsonObject);
            schema.validate(new JSONObject(leagueData));
            status = true;
        }
        catch (ValidationException e){
            System.out.println("Below values are incorrect, kindly provide proper values:");
            for (String schemaViolation : e.getAllMessages()){
                System.out.println(schemaViolation);
            }
        }
        catch (JSONException e){
            System.out.println("JSONException occurred!"+e);
        }
        catch (Exception e){
            System.out.println("Exception occurred!"+e);
        }
        return status;
    }

    public League loadMemory (String jsonFileLocation) {
        JSONParser jsonParser = new JSONParser();
        String leagueName, conferenceName, divisionName, teamName, playerName, position, generalManager, headCoach;
        boolean captain = false;

        try{
            Reader reader = new FileReader(jsonFileLocation);
            org.json.simple.JSONObject leagueJSONObject = (org.json.simple.JSONObject) jsonParser.parse(reader);
            JSONArray conferencesJSONArray = (JSONArray) leagueJSONObject.get(leagueDataKeys.getConferences());

            League leagueLOM = new League();
            ArrayList<org.leaguemodel.Conference> conferenceArrayListLOM = new ArrayList<org.leaguemodel.Conference>();
            leagueName = (String) leagueJSONObject.get(leagueDataKeys.getLeagueName());

            leagueLOM.setLeagueName(leagueName);
            leagueLOM.setConference(conferenceArrayListLOM);

            for (int i = 0; i < conferencesJSONArray.size(); i++) {
                org.json.simple.JSONObject conferencesJSONObject = (org.json.simple.JSONObject) conferencesJSONArray.get(i);
                JSONArray divisionsJSONArray = (JSONArray) conferencesJSONObject.get(leagueDataKeys.getDivisions());

                org.leaguemodel.Conference conferenceLOM = new Conference();//
                ArrayList<Divisions> divisionsArrayList = new ArrayList<Divisions>();
                conferenceName = (String) conferencesJSONObject.get(leagueDataKeys.getConferenceName());

                conferenceLOM.setConferenceName(conferenceName);
                conferenceLOM.setDivisions(divisionsArrayList);
                conferenceArrayListLOM.add(conferenceLOM);

                for (int j = 0; j < divisionsJSONArray.size() ; j++) {
                    org.json.simple.JSONObject divisionsJSONObject = (org.json.simple.JSONObject) divisionsJSONArray.get(j);
                    JSONArray teamsJSONArray = (JSONArray) divisionsJSONObject.get(leagueDataKeys.getTeams());

                    Divisions divisionsLOM = new Divisions();//
                    ArrayList<Team> teamArrayList = new ArrayList<Team>();
                    divisionName = (String) divisionsJSONObject.get(leagueDataKeys.getDivisionName());

                    divisionsLOM.setDivisionName(divisionName);
                    divisionsLOM.setTeams(teamArrayList);
                    divisionsArrayList.add(divisionsLOM);

                    for (int k = 0; k < teamsJSONArray.size(); k++) {
                        org.json.simple.JSONObject teamsJSONObject = (org.json.simple.JSONObject) teamsJSONArray.get(k);
                        JSONArray playersJSONArray = (JSONArray) teamsJSONObject.get(leagueDataKeys.getPlayers());

                        Team teamLOM = new Team();//
                        ArrayList<Players> playersArrayListLOM = new ArrayList<Players>();
                        teamName = (String) teamsJSONObject.get(leagueDataKeys.getTeamName());
                        generalManager = (String) teamsJSONObject.get(leagueDataKeys.getGeneralManager());
                        headCoach = (String) teamsJSONObject.get(leagueDataKeys.getHeadCoach());

                        teamLOM.setTeamName(teamName);
                        teamLOM.setGeneralManager(generalManager);
                        teamLOM.setHeadCoach(headCoach);
                        teamLOM.setPlayers(playersArrayListLOM);
                        teamArrayList.add(teamLOM);

                        for (int l = 0; l < playersJSONArray.size(); l++) {
                            org.json.simple.JSONObject playersJSONObject = (org.json.simple.JSONObject) playersJSONArray.get(l);

                            Players playersLOM = new Players();//
                            playerName = (String) playersJSONObject.get(leagueDataKeys.getPlayerName());
                            position = (String) playersJSONObject.get(leagueDataKeys.getPosition());
                            captain = (boolean) playersJSONObject.get(leagueDataKeys.getCaptain());

                            playersLOM.setPlayerName(playerName);
                            playersLOM.setPlayerPosition(position);
                            playersLOM.setIsCaptain(captain);
                            playersArrayListLOM.add(playersLOM);
                        }
                    }
                }
            }
            //leagueLOM = loadFreeAgents(leagueLOM, leagueJSONObject); // load freeAgents into LOM
            JSONArray freeAgentsJSONArray = (JSONArray) leagueJSONObject.get(leagueDataKeys.getFreeAgents());
            ArrayList<FreeAgents> freeAgentsArrayListLOM = new ArrayList<FreeAgents>();

            leagueLOM.setFreeAgents(freeAgentsArrayListLOM);

            for (int i = 0; i < freeAgentsJSONArray.size(); i++) {
                org.json.simple.JSONObject freeAgentsJSONObject = (org.json.simple.JSONObject) freeAgentsJSONArray.get(i);

                FreeAgents freeAgentsLOM = new FreeAgents();
                playerName = (String) freeAgentsJSONObject.get(leagueDataKeys.getPlayerName());
                position = (String) freeAgentsJSONObject.get(leagueDataKeys.getPosition());
                captain = (boolean) freeAgentsJSONObject.get(leagueDataKeys.getCaptain());

                freeAgentsLOM.setPlayerName(playerName);
                freeAgentsLOM.setPlayerPosition(position);
                freeAgentsLOM.setCaptain(captain);
                freeAgentsArrayListLOM.add(freeAgentsLOM);
            }

            return leagueLOM;
        } catch (FileNotFoundException e) {
            System.out.println("File not found exception!"+e);
        } catch (ParseException e) {
            System.out.println("Parse exception has occurred!"+e);
        } catch (IOException e) {
            System.out.println("An IO exception has occurred!"+e);
        } catch (Exception e) {
            System.out.println("An exception has occurred!"+e);
        }
        return null;
    }
}
