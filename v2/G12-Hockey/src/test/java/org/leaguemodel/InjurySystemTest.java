package org.leaguemodel;

import junit.framework.TestCase;
import org.junit.Test;
import org.leaguemodel.interfaces.IInjuries;
import org.leaguemodel.interfaces.IInjurySystem;
import org.leaguemodel.interfaces.IPlayers;
import org.leaguemodel.interfaces.ITeam;
import resources.MockData;
import java.time.LocalDate;

public class InjurySystemTest extends TestCase {

    @Test
    public void testIsPlayerInjured() {
        IPlayers players = new Players();
        IInjurySystem injurySystem = new InjurySystem();
        IInjuries injuries = new Injuries();
        injuries.setInjuryDaysHigh(250);
        injuries.setInjuryDaysLow(1);
        injuries.setRandomInjuryChance(1.0);
        players.setPlayerName("Player One");
        LocalDate date = LocalDate.now();
        assertTrue(injurySystem.isPlayerInjured(injuries, players));
    }

    @Test
    public void testIsPlayerInjuredFalse() {
        IPlayers players = new Players();
        IInjurySystem injurySystem = new InjurySystem();
        IInjuries injuries = new Injuries();
        injuries.setInjuryDaysHigh(250);
        injuries.setInjuryDaysLow(1);
        injuries.setRandomInjuryChance(0.0);
        players.setPlayerName("Player One");
        LocalDate date = LocalDate.now();
        assertFalse(injurySystem.isPlayerInjured(injuries, players));
    }

    @Test
    public void testIsPlayerRecovered() {
        IPlayers players = new Players();
        IInjurySystem injurySystem = new InjurySystem();
        players.setPlayerName("Player One");
        players.setNoOfDaysInjured(10);
        LocalDate date = LocalDate.now();
        date = date.plusDays(10);
        injurySystem.isPlayerRecovered(players);
        assertEquals(9, players.getNoOfDaysInjured());
    }

    @Test
    public void testIsPlayerRecoveredFalse() {
        IPlayers players = new Players();
        IInjurySystem injurySystem = new InjurySystem();
        IInjuries injuries = new Injuries();
        injuries.setInjuryDaysHigh(250);
        injuries.setInjuryDaysLow(1);
        injuries.setRandomInjuryChance(1.0);
        players.setPlayerName("Player One");
        LocalDate date = LocalDate.now();
        injurySystem.isPlayerRecovered(players);
        assertEquals(-1, players.getNoOfDaysInjured());
    }

    @Test
    public void testCheckTeamInjuries() {
        IPlayers players = new Players();
        IInjurySystem injurySystem = new InjurySystem();
        IInjuries injuries = new Injuries();
        MockData leagueLOM = new MockData();
        ITeam team = leagueLOM.leagueOne.getConference().get(0).getDivisions().get(0).getTeams().get(0);
        team.getPlayers().get(0).setNoOfDaysInjured(-1);
        injuries.setInjuryDaysHigh(250);
        injuries.setInjuryDaysLow(250);
        injuries.setRandomInjuryChance(1.0);
        players.setPlayerName("Player One");
        LocalDate date = LocalDate.now();
        injurySystem.checkTeamInjuries(team, injuries);
        assertEquals(250, team.getPlayers().get(0).getNoOfDaysInjured());
    }
}
