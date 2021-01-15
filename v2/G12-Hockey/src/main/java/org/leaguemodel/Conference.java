package org.leaguemodel;

import org.leaguemodel.interfaces.IConference;
import org.leaguemodel.interfaces.IDivisions;

import java.util.List;

public class Conference implements IConference {

    private String conferenceName;
    private List<IDivisions> divisions;

    public Conference() {
        this.conferenceName = null;
        this.divisions = null;
    }

    public Conference(String conferenceName, List<IDivisions> divisions) {

        this.conferenceName = conferenceName;
        this.divisions = divisions;
    }

    @Override
    public String getConferenceName() {
        return conferenceName;
    }

    @Override
    public void setConferenceName(String conferenceName) {
        this.conferenceName = conferenceName;
    }

    @Override
    public List<IDivisions> getDivisions() {
        return divisions;
    }

    @Override
    public void setDivisions(List<IDivisions> divisions) {
        this.divisions = divisions;
    }

}
