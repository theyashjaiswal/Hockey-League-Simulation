package org.leaguemodel;

//Player Model Class
public class Players {
	
	private String playerPosition;
	private String playerName;
	private boolean isCaptain;
	
	
	public Players()
	{
		this.playerPosition = null;
		this.playerName = null;
		this.isCaptain = false;
	}
	
	public Players(String playerPosition, String playerName, boolean captain) {
		
		this.playerPosition = playerPosition;
		this.playerName = playerName;
		isCaptain = captain;
	}

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

	public void setIsCaptain(boolean Captain) {
		isCaptain = Captain;
	} 
	
}

