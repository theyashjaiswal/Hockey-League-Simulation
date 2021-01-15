package org.leaguesimulation;

import org.database.Database;
import org.leaguemodel.interfaces.ILeague;
import org.leaguesimulation.interfaces.ILeagueDate;
import org.leaguemodel.interfaces.ILeagueGetSetDB;

import java.time.*;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;

public class LeagueDateFromDB implements ILeagueDate {
    String leagueName;

    public LeagueDateFromDB(String leagueName) {
        this.leagueName = leagueName;
    }

    @Override
    public LocalDate getLeagueDate() {
        ILeagueGetSetDB db = new Database();
        List<HashMap<String, Object>> leagueDate = db.getLeagueDate(leagueName);
        Date dateObj = (Date) leagueDate.get(0).get("start_date");
        LocalDate localDate = dateObj.toLocalDate();
        return localDate;
    }
}
