package org.tradingtest;

import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.leaguemodel.GameplayConfig;
import org.leaguemodel.Trading;
import org.leaguemodel.interfaces.IGameplayConfig;
import org.leaguemodel.interfaces.ITrading;
import org.leaguesimulation.LeagueScoreboard;
import org.leaguesimulation.TeamOnScoreboard;
import org.leaguesimulation.interfaces.IScoreboard;
import org.trading.TradeOffer;
import org.trading.interfaces.ITradeOffer;
import resources.MockDataTrading;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

public class TradeOfferTest{

    private PrintStream printStream;
    private final ByteArrayOutputStream systemOutContent = new ByteArrayOutputStream();

    @Before
    public void setUpStream() {
        printStream = System.out;
        System.setOut(new PrintStream(systemOutContent));
    }

    @After
    public void resetStream() {
        System.setOut(printStream);
    }

    @Test
    public void testGenerateTradeOffer() {
        ITradeOffer tradeOffer = new TradeOffer();
        MockDataTrading md = new MockDataTrading();
        ITrading tradingConf = new Trading();
        tradingConf.setLossPoint(5);
        tradingConf.setMaxPlayersPerTrade(2);
        tradingConf.setRandomAcceptanceChance(10.0);
        tradingConf.setRandomTradeOfferChance(10.0);
        IGameplayConfig gameplayConfig = new GameplayConfig();
        gameplayConfig.setTrading(tradingConf);
        md.leagueOne.setGameplayConfig(gameplayConfig);
        LeagueScoreboard leagueScoreboard = new LeagueScoreboard(md.leagueOne);
        List<TeamOnScoreboard> scoreboard = leagueScoreboard.loadScoreboard();
        IScoreboard scoreboardObj = leagueScoreboard;
        scoreboardObj.getScoreboard().get(0).setLossPoints(9);
        scoreboardObj.getScoreboard().get(1).setLossPoints(9);
        scoreboardObj.getScoreboard().get(2).setLossPoints(9);
        scoreboardObj.loadScoreboard();
        tradeOffer.generateTradeOffer(scoreboardObj, md.leagueOne);
        Assert.assertTrue(StringUtils.isNotEmpty(systemOutContent.toString()));
    }

    @Test
    public void testRandomTradeOffer() {
        ITradeOffer tradeOffer = new TradeOffer();
        Assert.assertTrue(tradeOffer.randomTradeOffer(2.0));
    }
}
