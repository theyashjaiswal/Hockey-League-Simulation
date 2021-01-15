package org.statemachine;

import junit.framework.TestCase;
import org.junit.Test;

public class StateMachineConstantsTest extends TestCase {

    @Test
    public void testStringConstantsCheck() {
        StateMachineConstants stringConstants = new StateMachineConstants();
        assertEquals(2, stringConstants.GOALIECOUNT);
    }
}