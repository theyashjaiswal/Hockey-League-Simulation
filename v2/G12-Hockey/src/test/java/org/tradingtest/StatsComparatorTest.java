package org.tradingtest;

import org.junit.Assert;
import org.junit.Test;
import org.trading.StatsComparator;
import resources.MockDataTrading;

import java.util.Collections;

public class StatsComparatorTest {

    @Test
    public void testCompare() {
        MockDataTrading md = new MockDataTrading();
        Assert.assertEquals(md.leagueOne.getConference().get(0).getDivisions().get(0).getTeams().get(0).getPlayers().get(0).getPlayerName(),"Player one");
        Collections.sort(md.leagueOne.getConference().get(0).getDivisions().get(0).getTeams().get(0).getPlayers(),new StatsComparator());
        Assert.assertEquals(md.leagueOne.getConference().get(0).getDivisions().get(0).getTeams().get(0).getPlayers().get(0).getPlayerName(),"Player seventeen");
    }
}