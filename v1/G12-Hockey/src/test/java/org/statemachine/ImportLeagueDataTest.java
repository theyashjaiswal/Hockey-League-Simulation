package org.statemachine;

import junit.framework.TestCase;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.leaguemodel.League;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ImportLeagueDataTest extends TestCase {

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
    @Test
    public void testReadEmptyJSON() {
        try {

            temporaryFolder.create();
            File sampleJSONFile = temporaryFolder.newFile("testEmptyJSON.json");
            assertNotNull("Something",importLeagueData.readJSON(sampleJSONFile.getPath()));
            temporaryFolder.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testReadNonEmptyJSON() {
        try {
            temporaryFolder.create();
            File newFile = temporaryFolder.newFile("testNonEmptyJSON.json");
            FileWriter fileWriter = new FileWriter(newFile);
            fileWriter.write(leagueData);
            fileWriter.close();
            assertNotNull("Something",importLeagueData.readJSON(newFile.getPath()));
            temporaryFolder.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSchemaValidationTrue() {
        String leagueData = "{\n" +
                "\t\"leagueName\":\"Dalhousie Hockey League\"\n" +
                "}\n";
        assertTrue(importLeagueData.schemaValidation(leagueData, jsonSchema));
    }

    @Test
    public void testSchemaValidationFalse() {
        String leagueData = "{\n" +
                "\t\"leagueName\":\"\"\n" +
                "}\n";
        assertFalse(importLeagueData.schemaValidation(leagueData, jsonSchema));
    }

    @Test
    public void testLoadMemory() {
        try {
            temporaryFolder.create();
            File newFile = temporaryFolder.newFile("leagueJSON.json");

            FileWriter fileWriter = new FileWriter(newFile);
            fileWriter.write(leagueData);
            fileWriter.close();
            assertEquals("Dalhousie Hockey League",importLeagueData.loadMemory(newFile.getPath()).getLeagueName());
            temporaryFolder.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLoadConference() {
        try {
            temporaryFolder.create();
            File newFile = temporaryFolder.newFile("leagueJSON.json");
            FileWriter fileWriter = new FileWriter(newFile);
            fileWriter.write(leagueData);
            fileWriter.close();
            assertEquals("Eastern Conference",importLeagueData.loadMemory(newFile.getPath()).getConference().get(0).getConferenceName());
            temporaryFolder.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLoadDivision() {
        try {
            temporaryFolder.create();
            File newFile = temporaryFolder.newFile("leagueJSON.json");
            FileWriter fileWriter = new FileWriter(newFile);
            fileWriter.write(leagueData);
            fileWriter.close();
            assertEquals("Atlantic",importLeagueData.loadMemory(newFile.getPath()).getConference().get(0).getDivisions().get(0).getDivisionName());
            temporaryFolder.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLoadTeam() {
        try {
            temporaryFolder.create();
            File newFile = temporaryFolder.newFile("leagueJSON.json");
            FileWriter fileWriter = new FileWriter(newFile);
            fileWriter.write(leagueData);
            fileWriter.close();
            assertEquals("Halifax",importLeagueData.loadMemory(newFile.getPath()).getConference().get(0).getDivisions().get(0).getTeams().get(0).getTeamName());
            temporaryFolder.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLoadPlayer() {
        try {
            temporaryFolder.create();
            File newFile = temporaryFolder.newFile("leagueJSON.json");
            FileWriter fileWriter = new FileWriter(newFile);
            fileWriter.write(leagueData);
            fileWriter.close();
            assertEquals("Player One",importLeagueData.loadMemory(newFile.getPath()).getConference().get(0).getDivisions().get(0).getTeams().get(0).getPlayers().get(0).getPlayerName());
            temporaryFolder.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLoadFreeAgents() {
        try {
            temporaryFolder.create();
            File newFile = temporaryFolder.newFile("leagueJSON.json");
            FileWriter fileWriter = new FileWriter(newFile);
            fileWriter.write(leagueData);
            fileWriter.close();
            assertEquals("Agent One",importLeagueData.loadMemory(newFile.getPath()).getFreeAgents().get(0).getPlayerName());
            temporaryFolder.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
