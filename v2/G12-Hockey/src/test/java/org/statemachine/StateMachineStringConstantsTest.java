package org.statemachine;

import junit.framework.TestCase;
import org.junit.Test;

public class StateMachineStringConstantsTest extends TestCase {

    @Test
    public void testStringConstantsCheck() {
        StateMachineStringConstants stringConstants = new StateMachineStringConstants();
        assertEquals("Player Number", stringConstants.PLAYERNUMBER.toString());
    }
}