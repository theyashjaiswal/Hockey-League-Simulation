package org.leaguemodel;
import java.util.ArrayList;

//Conference Model Class
public class Conference {

	private String conferenceName;
	private ArrayList<Divisions> divisions;
	
	public Conference()
	{
		this.conferenceName = null;
		this.divisions = null;
	}
	
	public Conference(String conferenceName, ArrayList<Divisions> divisions) {
		
		this.conferenceName = conferenceName;
		this.divisions = divisions;
	}

	public String getConferenceName() {
		return conferenceName;
	}

	public void setConferenceName(String conferenceName) {
		this.conferenceName = conferenceName;
	}

	public ArrayList<Divisions> getDivisions() {
		return divisions;
	}

	public void setDivisions(ArrayList<Divisions> divisions) {
		this.divisions = divisions;
	}
	
}
