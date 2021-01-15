package org.statemachine;

import junit.framework.TestCase;
import org.database.Database;
import org.junit.rules.TemporaryFolder;
import org.leaguemodel.League;
import org.leaguemodel.MockData;


import java.io.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerChoiceTest extends TestCase {
    private PlayerChoice playerChoice = new PlayerChoice();

    League leagueLOM = new League();
    MockData mockData = new MockData();
    ImportLeagueData importLeagueData = new ImportLeagueData();
    private TemporaryFolder temporaryFolder = new TemporaryFolder();
    private String leagueData = "{\n" +
            "  \"leagueName\":\"Dalhousie Hockey League\",\n" +
            "  \"conferences\":[\n" +
            "    {\n" +
            "      \"conferenceName\":\"Eastern Conference\",\n" +
            "      \"divisions\":[\n" +
            "        {\n" +
            "          \"divisionName\":\"Atlantic\",\n" +
            "          \"teams\":[\n" +
            "            {\n" +
            "              \"teamName\":\"Halifax\",\n" +
            "              \"generalManager\":\"Mister Fred\",\n" +
            "              \"headCoach\":\"Mary Smith\",\n" +
            "              \"players\":[\n" +
            "                {\n" +
            "                  \"playerName\":\"Player One\",\n" +
            "                  \"position\":\"forward\",\n" +
            "                  \"captain\":true\n" +
            "                },\n" +
            "                {\n" +
            "                  \"playerName\":\"Player Two\",\n" +
            "                  \"position\":\"defense\",\n" +
            "                  \"captain\":false\n" +
            "                },\n" +
            "                {\n" +
            "                  \"playerName\":\"Player Three\",\n" +
            "                  \"position\":\"goalie\",\n" +
            "                  \"captain\":false\n" +
            "                }\n" +
            "              ]\n" +
            "            }\n" +
            "          ]\n" +
            "        }\n" +
            "      ]\n" +
            "    }\t\n" +
            "  ],\n" +
            "  \"freeAgents\":[\n" +
            "    {\n" +
            "      \"playerName\":\"Agent One\",\n" +
            "      \"position\":\"forward\",\n" +
            "      \"captain\":false\n" +
            "    },\n" +
            "    {\n" +
            "      \"playerName\":\"Agent Two\",\n" +
            "      \"position\":\"defense\",\n" +
            "      \"captain\":false\n" +
            "    },\n" +
            "    {\n" +
            "      \"playerName\":\"Agent Three\",\n" +
            "      \"position\":\"goalie\",\n" +
            "      \"captain\":false\n" +
            "    }\n" +
            "  ]\n" +
            "}";
    private String jsonSchema ="{\n" +
            "\"$schema\": \"http://json-schema.org/draft-07/schema#\",\n" +
            "\"required\": [\n" +
            "\t\t\"leagueName\"\n" +
            "\t],\n" +
            "\"properties\": {\n" +
            "\t\"leagueName\": {\n" +
            "\t\t\"id\": \"#/properties/leagueName\",\n" +
            "\t\t\"type\": \"string\",\n" +
            "\t\t\"title\": \"League Name\",\n" +
            "\t\t\"description\": \"Name of the league\",\n" +
            "\t\t\"minLength\": 1\n" +
            "\t}\n" +
            "}\t\n" +
            "}";

    public void testAbortSimulation() {
        assertTrue(playerChoice.abortSimulation());
    }

    public void userInputMock(String input) {
        InputStream is = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    public League loadMemoryMock() {
        try {
            temporaryFolder.create();
            File newFile = temporaryFolder.newFile("leagueJSON.json");
            FileWriter fileWriter = new FileWriter(newFile);
            fileWriter.write(leagueData);
            fileWriter.close();
            leagueLOM = importLeagueData.loadMemory(newFile.getPath());
            temporaryFolder.delete();
            return leagueLOM;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void testCreateTeamFromInput() {
        League leagueLOM = new League();
        String conferenceName = "Eastern Conference";
        String divisionName = "Atlantic";
        String teamName = "Halifax";
        String generalManager = "Mister Fred";
        String headCoach = "Mary Smith";
        playerChoice.createTeamFromInput(conferenceName,divisionName,teamName,generalManager,headCoach,loadMemoryMock(),mockData);
    }

    public void testLoadTeam() {
        leagueLOM = loadMemoryMock();
        userInputMock("Dalhousie Hockey League\nHalifax\n2");
        playerChoice.loadTeam(leagueLOM, mockData);
    }

    public void testSimulateSeasons() {
        userInputMock("3\n");
        Scanner scanner = new Scanner(System.in);
        playerChoice.simulateSeasons("Halifax",scanner);
    }

    public void testNestedState1() {
        playerChoice.nestedState1(2);
    }

    public void testNestedState2() {
        playerChoice.nestedState2();
    }

    public void testInitJSONTrue() {
        try {
            temporaryFolder.create();
            File newFile = temporaryFolder.newFile("leagueJ.json");
            File jsonSchemaLocation = temporaryFolder.newFile("schema.json");

            FileWriter fileWriter = new FileWriter(newFile);
            fileWriter.write(leagueData);
            fileWriter.close();
            FileWriter schemaFileWriter = new FileWriter(jsonSchemaLocation);
            schemaFileWriter.write(jsonSchema);
            schemaFileWriter.close();
            String args[] = new String[1];
            args[0] = newFile.getPath();
            leagueLOM = playerChoice.initJSON(args, jsonSchemaLocation.getPath());
            temporaryFolder.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testInitJSONFalse() {
        try {
            temporaryFolder.create();
            File newFile = temporaryFolder.newFile("leagueJ.json");
            File jsonSchemaLocation = temporaryFolder.newFile("schema.json");

            FileWriter fileWriter = new FileWriter(newFile);
            fileWriter.write("Invalid JSON!");
            fileWriter.close();
            FileWriter schemaFileWriter = new FileWriter(jsonSchemaLocation);
            schemaFileWriter.write(jsonSchema);
            schemaFileWriter.close();
            String args[] = new String[1];
            args[0] = newFile.getPath();
            leagueLOM = playerChoice.initJSON(args, jsonSchemaLocation.getPath());
            temporaryFolder.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testPlayerChoiceParamerizedConstructor(){
        try {
            temporaryFolder.create();
            File newFile = temporaryFolder.newFile("leagueJSON.json");

            FileWriter fileWriter = new FileWriter(newFile);
            fileWriter.write(leagueData);
            fileWriter.close();
            String args[] = new String[1];
            userInputMock("Dalhousie Hockey League\nHalifax\n2");
            PlayerChoice playerChoice = new PlayerChoice(args, mockData);
            temporaryFolder.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testCreateTeam(){
        userInputMock("Eastern Conference\nAtlantic\nHalifax\nMister Fred\nMary Smith\n3\n");
        leagueLOM = loadMemoryMock();
        leagueLOM = playerChoice.createTeam(leagueLOM, mockData);
        assertEquals("Dalhousie Hockey League", leagueLOM.getLeagueName());
    }
}