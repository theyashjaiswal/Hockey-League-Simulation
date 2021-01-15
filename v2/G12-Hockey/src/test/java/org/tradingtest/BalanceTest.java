package org.tradingtest;

import org.junit.Assert;
import org.junit.Test;
import org.trading.Balance;
import resources.MockDataTrading;

public class BalanceTest {

    @Test
    public void testBalanceTeams() {
        MockDataTrading md = new MockDataTrading();
        Balance bl = new Balance();
        bl.balanceTeams(md.leagueOne.getConference().get(0).getDivisions().get(0).getTeams().get(0), md.leagueOne);
        Assert.assertEquals(md.leagueOne.getConference().get(0).getDivisions().get(0).getTeams().get(0).getPlayers().size(), 20);
    }

    @Test
    public void testAddFromFreeAgent() {
        MockDataTrading md = new MockDataTrading();
        Balance bl = new Balance();
        bl.addFromFreeAgent(md.leagueOne.getConference().get(0).getDivisions().get(0).getTeams().get(0), md.leagueOne, "Forward", 1);
        int playerIndex = md.leagueOne.getConference().get(0).getDivisions().get(0).getTeams().get(0).getPlayers().size();
        Assert.assertEquals(md.leagueOne.getConference().get(0).getDivisions().get(0).getTeams().get(0).getPlayers().get(playerIndex - 1).getPlayerName(), "Agent Three");
    }

    @Test
    public void testRemoveFromTeam() {
        MockDataTrading md = new MockDataTrading();
        Balance bl = new Balance();
        int beforeRemoveTeamSize = md.leagueOne.getConference().get(1).getDivisions().get(0).getTeams().get(0).getPlayers().size() - 1;
        bl.removeFromTeam(md.leagueOne.getConference().get(1).getDivisions().get(0).getTeams().get(0), md.leagueOne, "Forward", 21);
        Assert.assertEquals(md.leagueOne.getConference().get(1).getDivisions().get(0).getTeams().get(0).getPlayers().size(), beforeRemoveTeamSize - 2);
    }

    @Test
    public void testAddUserTeam() {
        MockDataTrading md = new MockDataTrading();
        Balance bl = new Balance();
        int playerIndex = md.leagueOne.getConference().get(2).getDivisions().get(0).getTeams().get(0).getPlayers().size();
        bl.addUserTeam(md.leagueOne.getConference().get(2).getDivisions().get(0).getTeams().get(0), md.leagueOne, 1);
        Assert.assertEquals(md.leagueOne.getConference().get(2).getDivisions().get(0).getTeams().get(0).getPlayers().get(playerIndex).getPlayerName(), "Agent Two");
    }

    @Test
    public void testRemoveUserTeam() {
        MockDataTrading md = new MockDataTrading();
        Balance bl = new Balance();
        int beforeTeamSize = md.leagueOne.getConference().get(2).getDivisions().get(0).getTeams().get(0).getPlayers().size();
        bl.removeUserTeam(md.leagueOne.getConference().get(2).getDivisions().get(0).getTeams().get(0), md.leagueOne, 1);
        Assert.assertEquals(md.leagueOne.getConference().get(2).getDivisions().get(0).getTeams().get(0).getPlayers().size(), beforeTeamSize - 1);
    }

}