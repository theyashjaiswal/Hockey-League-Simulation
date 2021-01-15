package org.tradingtest;

import org.junit.Assert;
import org.junit.Test;
import org.leaguemodel.Players;
import org.leaguemodel.interfaces.IPlayers;
import org.trading.TradeDecision;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

public class TradeDecisionTest {

    @Test
    public void testTradeAIDecision() {
        TradeDecision tradeDecision = new TradeDecision();
        Assert.assertTrue(tradeDecision.tradeAIDecision(2.0));
    }

    @Test
    public void testTradeUserDecision() {
        TradeDecision tradeDecision = new TradeDecision();

        List<IPlayers> weakPlayers = new ArrayList<>();
        IPlayers playerOne = new Players("Forward", "Player Onethird", true, 33, 11, 14, 11, 0);
        IPlayers playerTwo = new Players("Defense", "Player Twothird", false, 20, 10, 10, 10, 0);
        weakPlayers.add(playerOne);
        weakPlayers.add(playerTwo);
        List<IPlayers> strongPlayers = new ArrayList<>();
        IPlayers playerOneTwo = new Players("Forward", "Player oneOne", true, 33, 120, 20, 20, 0);
        IPlayers playerTwoTwo = new Players("Defense", "Player twoTwo", false, 20, 110, 10, 10, 0);
        strongPlayers.add(playerOneTwo);
        strongPlayers.add(playerTwoTwo);
        userInputMock("1\n");
        Assert.assertTrue(tradeDecision.tradeUserDecision(weakPlayers, strongPlayers));
    }

    public void userInputMock(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}
