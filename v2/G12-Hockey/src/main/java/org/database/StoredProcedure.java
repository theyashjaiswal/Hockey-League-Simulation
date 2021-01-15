package org.database;

import org.apache.commons.lang3.StringUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StoredProcedure {
    private String storedProcedureName;
    private Connection connection;
    private CallableStatement statement;

    public StoredProcedure(String storedProcedureName) throws SQLException {
        this.storedProcedureName = storedProcedureName;
        connection = null;
        statement = null;
        openConnection();
        createStatement();
    }

    public StoredProcedure(String storedProcedureName, String value) throws SQLException {
        this.storedProcedureName = storedProcedureName;
        connection = null;
        statement = null;
        openConnection();
        createStatement(value);
    }

    public StoredProcedure(String storedProcedureName, int value) throws SQLException {
        this.storedProcedureName = storedProcedureName;
        connection = null;
        statement = null;
        openConnection();
        createStatement(value);
    }

    public StoredProcedure(String storedProcedureName, String parameterValue1, String parameterValue2) throws SQLException {
        this.storedProcedureName = storedProcedureName;
        connection = null;
        statement = null;
        openConnection();
        createStatement(parameterValue1, parameterValue2);
    }

    public StoredProcedure(String storedProcedureName, String parameterValue1, String parameterValue2, String parameterValue3, String parameterValue4, String parameterValue5, String parameterValue6) throws SQLException {
        this.storedProcedureName = storedProcedureName;
        connection = null;
        statement = null;
        openConnection();
        createStatement(parameterValue1, parameterValue2, parameterValue3, parameterValue4, parameterValue5, parameterValue6);
    }

    public StoredProcedure(String storedProcedureName, List<Object> createLeagueList) throws SQLException {
        this.storedProcedureName = storedProcedureName;
        connection = null;
        statement = null;
        openConnection();
        createStatement(createLeagueList);
    }

    private void createStatement(List<Object> createList) throws SQLException {

        if (StringUtils.equalsIgnoreCase(storedProcedureName, "spInsertTeamData")) {
            String leagueName = (String) createList.get(0);
            String conferenceName = (String) createList.get(1);
            String divisionName = (String) createList.get(2);
            String managerName = (String) createList.get(3);
            String headCoachName = (String) createList.get(4);
            double headCoachSkating = (double) createList.get(5);
            double headCoachShooting = (double) createList.get(6);
            double headCoachChecking = (double) createList.get(7);
            double headCoachSaving = (double) createList.get(8);
            String teamName = (String) createList.get(9);
            String teamType = (String) createList.get(10);
            statement = connection.prepareCall("{call " + storedProcedureName + "(?,?,?,?,?,?,?,?,?,?,?)}");
            setParameter(1, leagueName);
            setParameter(2, conferenceName);
            setParameter(3, divisionName);
            setParameter(4, managerName);
            setParameter(5, headCoachName);
            setParameter(6, headCoachSkating);
            setParameter(7, headCoachShooting);
            setParameter(8, headCoachChecking);
            setParameter(9, headCoachSaving);
            setParameter(10, teamName);
            setParameter(11, teamType);
        }
        if (StringUtils.equalsIgnoreCase(storedProcedureName, "spInsertPlayerData")) {
            String playerName = (String) createList.get(0);
            String leagueName = (String) createList.get(1);
            String teamName = (String) createList.get(2);
            String playerPosition = (String) createList.get(3);
            boolean captain = (boolean) createList.get(4);
            boolean isPlayerRetired = (boolean) createList.get(5);
            boolean isFreeAgent = (boolean) createList.get(6);
            int playerAge = (int) createList.get(7);
            int playerSkating = (int) createList.get(8);
            int playerShooting = (int) createList.get(9);
            int playerChecking = (int) createList.get(10);
            int playerSaving = (int) createList.get(11);
            int noOfDaysInjured = (int) createList.get(12);

            statement = connection.prepareCall("{call " + storedProcedureName + "(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            setParameter(1, playerName);
            setParameter(2, leagueName);
            setParameter(3, teamName);
            setParameter(4, playerPosition);
            setParameter(5, captain);
            setParameter(6, isPlayerRetired);
            setParameter(7, isFreeAgent);
            setParameter(8, playerAge);
            setParameter(9, playerSkating);
            setParameter(10, playerShooting);
            setParameter(11, playerChecking);
            setParameter(12, playerSaving);
            setParameter(13, noOfDaysInjured);
        }
        if (StringUtils.equalsIgnoreCase(storedProcedureName, "spInsertGameplayConfig")) {
            String leagueName = (String) createList.get(0);
            int averageRetirmentAge = (int) createList.get(1);
            int maximumAge = (int) createList.get(2);
            double randomWinChance = (double) createList.get(3);
            double randomInjuryChance = (double) createList.get(4);
            int injuryDaysLow = (int) createList.get(5);
            int injuryDaysHigh = (int) createList.get(6);
            int daysUntilStatIncreaseCheck = (int) createList.get(7);
            int lossPoint = (int) createList.get(8);
            double randomTradeOfferChance = (double) createList.get(9);
            int maxPlayersPerTrade = (int) createList.get(10);
            double randomAcceptanceChance = (double) createList.get(11);

            statement = connection.prepareCall("{call " + storedProcedureName + "(?,?,?,?,?,?,?,?,?,?,?,?)}");
            setParameter(1, leagueName);
            setParameter(2, averageRetirmentAge);
            setParameter(3, maximumAge);
            setParameter(4, randomWinChance);
            setParameter(5, randomInjuryChance);
            setParameter(6, injuryDaysLow);
            setParameter(7, injuryDaysHigh);
            setParameter(8, daysUntilStatIncreaseCheck);
            setParameter(9, lossPoint);
            setParameter(10, randomTradeOfferChance);
            setParameter(11, maxPlayersPerTrade);
            setParameter(12, randomAcceptanceChance);
        }

    }

    private void setParameter(int paramIndex, double value) throws SQLException {
        statement.setDouble(paramIndex, value);
    }

    private void setParameter(int paramIndex, Date leagueDate) throws SQLException {
        statement.setDate(paramIndex, leagueDate);
    }

    public StoredProcedure(String storedProcedureName, String parameterValue1, String parameterValue2, String parameterValue3, String parameterValue4, Boolean parameterValue5) throws SQLException {
        this.storedProcedureName = storedProcedureName;
        connection = null;
        statement = null;
        openConnection();
        createStatement(parameterValue1, parameterValue2, parameterValue3, parameterValue4, parameterValue5);
    }

    private void createStatement() throws SQLException {
        statement = connection.prepareCall("{call " + storedProcedureName + "}");
    }

    private void createStatement(String parameterValue) throws SQLException {
        statement = connection.prepareCall("{call " + storedProcedureName + "(?)}");
        setParameter(1, parameterValue);
    }

    private void createStatement(int parameterValue) throws SQLException {
        statement = connection.prepareCall("{call " + storedProcedureName + "(?)}");
        setParameter(1, parameterValue);
    }

    private void createStatement(String parameterValue1, String parameterValue2) throws SQLException {
        statement = connection.prepareCall("{call " + storedProcedureName + "(?,?)}");
        setParameter(1, parameterValue1);
        setParameter(2, parameterValue2);
    }

    private void createStatement(String parameterValue1, Date parameterValue2) throws SQLException {
        statement = connection.prepareCall("{call " + storedProcedureName + "(?,?)}");
        setParameter(1, parameterValue1);
        setParameter(2, parameterValue2);
    }

    private void createStatement(String parameterValue1, String parameterValue2, String parameterValue3, String parameterValue4, Boolean parameterValue5) throws SQLException {
        statement = connection.prepareCall("{call " + storedProcedureName + "(?,?,?,?,?)}");
        setParameter(1, parameterValue1);
        setParameter(2, parameterValue2);
        setParameter(3, parameterValue3);
        setParameter(4, parameterValue4);
        setParameter(5, parameterValue5);
    }

    private void createStatement(String parameterValue1, String parameterValue2, String parameterValue3, String parameterValue4, String parameterValue5, String parameterValue6) throws SQLException {
        statement = connection.prepareCall("{call " + storedProcedureName + "(?,?,?,?,?,?)}");
        setParameter(1, parameterValue1);
        setParameter(2, parameterValue2);
        setParameter(3, parameterValue3);
        setParameter(4, parameterValue4);
        setParameter(5, parameterValue5);
        setParameter(6, parameterValue6);
    }


    private void openConnection() throws SQLException {
        connection = ConnectionManager.instance().getDBConnection();
    }

    private void cleanup() {
        try {
            statement = ConnectionManager.instance().getSafeCallableStatement(statement);
            statement.close();
            connection = ConnectionManager.instance().getSafeConnection(connection);
            if (connection.isClosed() == false) {
                connection.close();
            }

        } catch (Exception e) {
            System.out.println("Failed to perform DB cleanup:" + e.getMessage());
        }
    }

    public void setParameter(int paramIndex, String value) throws SQLException {
        statement.setString(paramIndex, value);
    }

    public void registerOutputParameterString(int paramIndex) throws SQLException {
        statement.registerOutParameter(paramIndex, Types.VARCHAR);
    }

    public void setParameter(int paramIndex, Boolean value) throws SQLException {
        statement.setBoolean(paramIndex, value);
    }

    public void setParameter(int paramIndex, long value) throws SQLException {
        statement.setLong(paramIndex, value);
    }

    public void registerOutputParameterLong(int paramIndex) throws SQLException {
        statement.registerOutParameter(paramIndex, Types.BIGINT);
    }

    public int getIntValue(int paramIndex) throws SQLException {
        statement.execute();
        int result = statement.getInt(paramIndex);
        cleanup();
        return result;
    }

    public ArrayList<HashMap<String, Object>> executeWithResults() throws SQLException {
        ArrayList<HashMap<String, Object>> results;
        if (statement.execute()) {
            results = convertResultSetToList(statement.getResultSet());
        } else {
            results = new ArrayList<HashMap<String, Object>>();
        }
        cleanup();
        return results;
    }

    public void execute() throws SQLException {
        statement.execute();
        cleanup();
    }

    private ArrayList<HashMap<String, Object>> convertResultSetToList(ResultSet rs) throws SQLException {
        ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        ResultSetMetaData md = rs.getMetaData();
        int columns = md.getColumnCount();
        while (rs.next()) {
            HashMap<String, Object> row = new HashMap<String, Object>(columns);
            for (int i = 1; i <= columns; i++) {
                row.put(md.getColumnName(i), rs.getObject(i));
            }
            list.add(row);
        }
        return list;
    }

    public StoredProcedure(String storedProcedureName, String leagueName, Date leagueDate) throws SQLException {
        this.storedProcedureName = storedProcedureName;
        connection = null;
        statement = null;
        openConnection();
        createStatement(leagueName, leagueDate);
    }
}
