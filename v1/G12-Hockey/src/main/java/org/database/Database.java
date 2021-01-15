package org.database;

import org.leaguemodel.*;
import org.statemachine.ISimulate;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database implements ILeague, ISimulate {

    public List getLeagueName(){

        List leagueNameList = new ArrayList();
        Connection con = null;
        try {
            con = DatabaseConnector.establishConnection();
            CallableStatement stmt = con.prepareCall("{call spLeagueName()}");

            boolean gotResults = stmt.execute();

            while(gotResults){
                ResultSet resultSet = stmt.getResultSet();

                while (resultSet.next()) {
                    String league_name = resultSet.getString("league_name");
                    leagueNameList.add(league_name);
                }
                gotResults=false;
            }
            stmt.close();
            con.close();
        }
        catch ( SQLException ex) {
            System.out.println("Error: error in your sql query" + ex);
        }
        return leagueNameList;
    }

    public List getTeamName(String leagueName){

        List teamNameList = new ArrayList();
        Connection con = null;
        try {
            con = DatabaseConnector.establishConnection();
            CallableStatement stmt = con.prepareCall("{call spTeamName(?)}");
            stmt.setString("leaguename",leagueName);

            boolean gotResults = stmt.execute();

            while(gotResults){
                ResultSet resultSet = stmt.getResultSet();

                while (resultSet.next()) {
                    String league_name = resultSet.getString("league_name");
                    String team_name = resultSet.getString("team_name");
                    teamNameList.add(team_name);
                }
                gotResults=false;
            }

            stmt.close();
            con.close();
        }
        catch ( SQLException ex) {
            System.out.println("Error: error in your sql query" + ex);
        }
        return teamNameList;
    }

    public League getLeaguePlayerData(String leagueName, String teamName){
        Connection con = null;
        ResultSet resultSet = null;
        ArrayList<Players> playerList = new ArrayList();
        ArrayList<Team> teamList = new ArrayList();
        ArrayList<Divisions> divisionList = new ArrayList();
        ArrayList<Conference> conferenceList = new ArrayList();
        Team team = new Team();
        Divisions division = new Divisions();
        Conference conference = new Conference();
        League league = new League();
        String team_name = null;
        String manager_name = null;
        String coach_name = null;
        String league_name = null;
        String conference_name = null;
        String division_name = null;
        try {
            con = DatabaseConnector.establishConnection();
            CallableStatement stmt = con.prepareCall("{call spLeaguePlayerData(?,?)}");
            stmt.setString("leaguename",leagueName);
            stmt.setString("teamname",teamName);
            boolean gotResults = stmt.execute();

           if(gotResults){
                resultSet = stmt.getResultSet();

            while (resultSet.next()) {
                team_name = resultSet.getString("team_name");
                manager_name = resultSet.getString("manager_name");
                coach_name = resultSet.getString("coach_name");
                league_name = resultSet.getString("league_name");
                conference_name = resultSet.getString("conference_name");
                division_name = resultSet.getString("division_name");
                Players player = new Players();
                String player_name = resultSet.getString("player_name");
                String position = resultSet.getString("position");
                Boolean is_captain = resultSet.getBoolean("is_captain");
                player.setPlayerName(player_name);
                player.setPlayerPosition(position);
                player.setIsCaptain(is_captain);
                playerList.add(player);
            }
            team.setTeamName(team_name);
            team.setGeneralManager(manager_name);
            team.setHeadCoach(coach_name);
            team.setPlayers(playerList);
            teamList.add(team);
            division.setDivisionName(division_name);
            division.setTeams(teamList);
            divisionList.add(division);
            conference.setConferenceName(conference_name);
            conference.setDivisions(divisionList);
            conferenceList.add(conference);
            league.setLeagueName(league_name);
            league.setConference(conferenceList);
            }
            stmt.close();
            con.close();
        }
        catch ( SQLException ex) {
            System.out.println("Error: error in your sql query");
        }
        return league;
    }

    public Boolean setLeagueTeamData(String leagueName, String conferenceName, String divisionName, String managerName, String coachName,String teamName){
        Connection con = null;
        Boolean isInserted = null;
        try {
            con = DatabaseConnector.establishConnection();
            CallableStatement stmt = con.prepareCall("{call spInsertTeamData(?,?,?,?,?,?,?)}");
            stmt.setString("leaguename",leagueName);
            stmt.setString("conferencename",conferenceName);
            stmt.setString("divisionname",divisionName);
            stmt.setString("managername",managerName);
            stmt.setString("coachname",coachName);
            stmt.setString("teamname",teamName);
            stmt.registerOutParameter("output",Types.BOOLEAN);
            stmt.execute();
            isInserted = stmt.getBoolean("output");

            stmt.close();
            con.close();
        }
        catch ( SQLException ex) {
            System.out.println("Error: error in your sql query"+ex);
        }
        return isInserted;
    }

    public Boolean setPlayerData(String playerName,String leagueName, String teamName, String position, Boolean captain){
        Connection con = null;
        Boolean isInserted = false;
        try {
            con = DatabaseConnector.establishConnection();
            CallableStatement stmt = con.prepareCall("{call spInsertPlayerData(?,?,?,?,?)}");
            stmt.setString("playername",playerName);
            stmt.setString("leaguename",leagueName);
            stmt.setString("teamname",teamName);
            stmt.setString("position",position);
            stmt.setBoolean("captain",captain);
            if(stmt.executeUpdate()!=0){
                isInserted = true;
            }

            stmt.close();
            con.close();
        }
        catch ( SQLException ex) {
            System.out.println("Error: error in your sql query"+ex);
        }
        return isInserted;
    }
}
