package org.leaguemodel;

import junit.framework.TestCase;
import org.junit.Test;
import org.leaguemodel.interfaces.*;
import resources.MockDataTrading;

public class AgingEngineTest extends TestCase {

    @Test
    public void testInitAging() {
        IInjurySystem injurySystem = new InjurySystem();
        IAging aging = new Aging();
        aging.setAverageRetirementAge(30);
        aging.setMaximumAge(40);
        IAgingSystem agingSystem = new AgingSystem();
        IPlayerReplacement playerReplacement = new PlayerReplacement();

        IAgingEngine agingEngine = new AgingEngine(injurySystem, aging, agingSystem, playerReplacement);
        MockDataTrading mockData = new MockDataTrading();
        agingEngine.initAging(mockData.leagueOne, 365);
    }
}