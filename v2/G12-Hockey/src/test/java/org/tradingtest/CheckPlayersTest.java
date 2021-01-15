package org.tradingtest;

import org.junit.Assert;
import org.junit.Test;
import org.trading.CheckPlayers;
import resources.MockDataTrading;

public class CheckPlayersTest {

    @Test
    public void testCaptain() {
        CheckPlayers ch = new CheckPlayers();
        MockDataTrading md = new MockDataTrading();
        ch.Captain(md.leagueOne.getConference().get(0).getDivisions().get(0).getTeams().get(0));
        Assert.assertEquals(md.leagueOne.getConference().get(0).getDivisions().get(0).getTeams().get(0).getPlayers().get(0).isCaptain(), true);
    }

    @Test
    public void testGoalies() {
        CheckPlayers ch = new CheckPlayers();
        MockDataTrading md = new MockDataTrading();
        Assert.assertEquals(ch.goalies(md.leagueOne.getConference().get(0).getDivisions().get(0).getTeams().get(0)), 2);
    }

    @Test
    public void testSkaters() {
        CheckPlayers ch = new CheckPlayers();
        MockDataTrading md = new MockDataTrading();
        Assert.assertEquals(ch.skaters(md.leagueOne.getConference().get(2).getDivisions().get(0).getTeams().get(0)), 18);
    }
}