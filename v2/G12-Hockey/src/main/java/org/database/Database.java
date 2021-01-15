package org.database;

import org.database.interfaces.IDatabaseConfiguration;
import org.leaguemodel.interfaces.ILeagueGetSetDB;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Database implements ILeagueGetSetDB {

    public List<HashMap<String, Object>> getLeagueNameDB() {
        List<HashMap<String, Object>> results = new ArrayList<>();
        try {
            IDatabaseConfiguration id = new DatabaseConfiguration();
            ConnectionManager.instance().configure(id);
            StoredProcedure sp = new StoredProcedure("spLoadLeagueNamesList");
            results = sp.executeWithResults();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return results;
    }

    public List<HashMap<String, Object>> getTeamNameDB(String leagueName) {

        List<HashMap<String, Object>> results = new ArrayList<>();
        try {
            IDatabaseConfiguration id = new DatabaseConfiguration();
            ConnectionManager.instance().configure(id);
            StoredProcedure sp = new StoredProcedure("spLoadTeamNamesList", leagueName);
            results = sp.executeWithResults();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return results;
    }

    public void setLeagueTeamDataDB(List<Object> createLeagueList) {
        StoredProcedure sp = null;
        try {
            IDatabaseConfiguration id = new DatabaseConfiguration();
            ConnectionManager.instance().configure(id);
            sp = new StoredProcedure("spInsertTeamData", createLeagueList);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                sp.execute();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void setPlayerDataDB(List<Object> playersList) {
        StoredProcedure sp = null;
        try {
            IDatabaseConfiguration id = new DatabaseConfiguration();
            ConnectionManager.instance().configure(id);
            sp = new StoredProcedure("spInsertPlayerData", playersList);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                sp.execute();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public List<HashMap<String, Object>> getLeagueIDDB(String leagueName) {
        List<HashMap<String, Object>> results = new ArrayList<>();
        try {
            IDatabaseConfiguration id = new DatabaseConfiguration();
            ConnectionManager.instance().configure(id);
            StoredProcedure sp = new StoredProcedure("spLoadLeague", leagueName);
            results = sp.executeWithResults();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return results;
    }

    public List<HashMap<String, Object>> getConferencesDB(int leagueID) {
        List<HashMap<String, Object>> results = new ArrayList<>();
        try {
            IDatabaseConfiguration id = new DatabaseConfiguration();
            ConnectionManager.instance().configure(id);
            StoredProcedure sp = new StoredProcedure("spLoadConference", leagueID);
            results = sp.executeWithResults();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return results;
    }

    public List<HashMap<String, Object>> getDivisionsDB(int conferenceID) {
        List<HashMap<String, Object>> results = new ArrayList<>();
        try {
            IDatabaseConfiguration id = new DatabaseConfiguration();
            ConnectionManager.instance().configure(id);
            StoredProcedure sp = new StoredProcedure("spLoadDivision", conferenceID);
            results = sp.executeWithResults();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return results;
    }

    public List<HashMap<String, Object>> getTeamsDB(int divisionID) {
        List<HashMap<String, Object>> results = new ArrayList<>();
        try {
            IDatabaseConfiguration id = new DatabaseConfiguration();
            ConnectionManager.instance().configure(id);
            StoredProcedure sp = new StoredProcedure("spLoadTeam", divisionID);
            results = sp.executeWithResults();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return results;
    }

    public List<HashMap<String, Object>> getHeadCoachDB(int coachID) {
        List<HashMap<String, Object>> results = new ArrayList<>();
        try {
            IDatabaseConfiguration id = new DatabaseConfiguration();
            ConnectionManager.instance().configure(id);
            StoredProcedure sp = new StoredProcedure("spLoadCoach", coachID);
            results = sp.executeWithResults();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return results;
    }

    public List<HashMap<String, Object>> getPlayersDB(int teamID) {
        List<HashMap<String, Object>> results = new ArrayList<>();
        try {
            IDatabaseConfiguration id = new DatabaseConfiguration();
            ConnectionManager.instance().configure(id);
            StoredProcedure sp = new StoredProcedure("spLoadPlayer", teamID);
            results = sp.executeWithResults();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return results;
    }

    public List<HashMap<String, Object>> getFreeAgentsDB() {
        List<HashMap<String, Object>> results = new ArrayList<>();
        try {
            IDatabaseConfiguration id = new DatabaseConfiguration();
            ConnectionManager.instance().configure(id);
            StoredProcedure sp = new StoredProcedure("spLoadFreeAgents");
            results = sp.executeWithResults();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return results;
    }

    public List<HashMap<String, Object>> getGameplayConfigDB(String leagueName) {
        List<HashMap<String, Object>> results = new ArrayList<>();
        try {
            IDatabaseConfiguration id = new DatabaseConfiguration();
            ConnectionManager.instance().configure(id);
            StoredProcedure sp = new StoredProcedure("spLoadGameplayConfig", leagueName);
            results = sp.executeWithResults();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return results;
    }

    @Override
    public void setGameplayConfigDB(List<Object> gameplayConfigList) {
        StoredProcedure sp = null;
        try {
            IDatabaseConfiguration id = new DatabaseConfiguration();
            ConnectionManager.instance().configure(id);
            sp = new StoredProcedure("spInsertGameplayConfig",gameplayConfigList);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                sp.execute();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public void overwriteData() {
        StoredProcedure sp = null;
        try {
            IDatabaseConfiguration id = new DatabaseConfiguration();
            ConnectionManager.instance().configure(id);
            sp = new StoredProcedure("spOverwritePrep");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                sp.execute();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public List<HashMap<String, Object>> getLeagueDate(String leagueName) {
        List<HashMap<String, Object>> results = new ArrayList<>();
        try {
            IDatabaseConfiguration id = new DatabaseConfiguration();
            ConnectionManager.instance().configure(id);
            StoredProcedure sp = new StoredProcedure("spGetLeagueDate",leagueName);
            results = sp.executeWithResults();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return results;
    }

    public List<HashMap<String, Object>> setLeagueDate(String leagueName, Date leagueDate) {

        List<HashMap<String, Object>> results = new ArrayList<>();
        try {
            IDatabaseConfiguration id = new DatabaseConfiguration();
            ConnectionManager.instance().configure(id);
            StoredProcedure sp = new StoredProcedure("spInsertLeagueDate", leagueName, leagueDate);
            results = sp.executeWithResults();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return results;
    }
}