package org.tradingtest;

import org.junit.Assert;
import org.junit.Test;
import org.trading.TradingTeam;
import org.trading.interfaces.ITradingTeam;
import resources.MockDataTrading;
import resources.MockTrading;
import java.io.ByteArrayInputStream;

public class TradingTeamTest {

    @Test
    public void testTradingTeams() {

        MockDataTrading md = new MockDataTrading();
        MockTrading mc = new MockTrading();
        ITradingTeam trade = new TradingTeam();
        trade.tradingTeamPlayers(md.leagueOne.getConference().get(0).getDivisions().get(0).getTeams().get(0), md.leagueOne, mc);
        Assert.assertEquals(md.leagueOne.getConference().get(0).getDivisions().get(0).getTeams().get(0).getPlayers().get(0).getPlayerName(), "Player oneOne");
    }

    @Test
    public void testAITrade() {
        MockDataTrading md = new MockDataTrading();
        MockTrading mc = new MockTrading();
        ITradingTeam trade = new TradingTeam();
        trade.AITrade(md.leagueOne.getConference().get(0).getDivisions().get(0).getTeams().get(0), md.leagueOne.getConference().get(1).getDivisions().get(0).getTeams().get(0), mc, md.leagueOne);
        Assert.assertEquals(md.leagueOne.getConference().get(0).getDivisions().get(0).getTeams().get(0).getPlayers().get(0).getPlayerName(), "Player oneOne");
    }

    @Test
    public void testUserTrade() {
        MockDataTrading md = new MockDataTrading();
        MockTrading mc = new MockTrading();
        ITradingTeam trade = new TradingTeam();
        userInputMock("2\n");
        trade.UserTrade(md.leagueOne.getConference().get(2).getDivisions().get(0).getTeams().get(0), md.leagueOne.getConference().get(0).getDivisions().get(0).getTeams().get(0), mc.getMaxPlayersPerTrade(), md.leagueOne);
        Assert.assertEquals(md.leagueOne.getConference().get(2).getDivisions().get(0).getTeams().get(0).getPlayers().get(0).getPlayerName(), "Player Onethird");

    }

    public void userInputMock(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}