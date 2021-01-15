package org.leaguemodel;
import java.util.ArrayList;

//Divisions Model Class
public class Divisions {
	
	private String divisionName;
	private ArrayList<Team> teams;
	
	public Divisions()
	{
		this.divisionName = null;
		this.teams = null;
	}
	public Divisions(String divisionName, ArrayList<Team> teams) {
		
		this.divisionName = divisionName;
		this.teams = teams;
	}

	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	public ArrayList<Team> getTeams() {
		return teams;
	}

	public void setTeams(ArrayList<Team> teams) {
		this.teams = teams;
	}
}
