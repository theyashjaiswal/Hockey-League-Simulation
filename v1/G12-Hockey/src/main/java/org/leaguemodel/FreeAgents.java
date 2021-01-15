package org.leaguemodel;
import java.util.ArrayList;

public class FreeAgents {

	public String getPlayerPosition() {
		return playerPosition;
	}

	public void setPlayerPosition(String playerPosition) {
		this.playerPosition = playerPosition;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public boolean isCaptain() {
		return isCaptain;
	}

	public void setCaptain(boolean captain) {
		isCaptain = captain;
	}

	private String playerPosition;
	private String playerName;
	private boolean isCaptain;

	private ArrayList<Players> players;

	public FreeAgents()
	{
		this.players = null;
	}
	public FreeAgents(ArrayList<Players> players) {
		this.players = players;
	}

	public ArrayList<Players> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Players> players) {
		this.players = players;
	} 
	
}
