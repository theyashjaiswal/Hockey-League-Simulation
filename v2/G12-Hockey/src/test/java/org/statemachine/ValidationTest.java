package org.statemachine;

import org.junit.Test;
import org.statemachine.interfaces.IValidate;
import resources.MockData;
import static org.junit.Assert.*;

public class ValidationTest {

    @Test
    public void validateGeneralManagerTest() {
        MockData mock = new MockData();
        IValidate validate = new Validation();
        assertFalse(validate.validateGeneralManager(mock.leagueOne, "Siddhant"));
        assertTrue(validate.validateGeneralManager(mock.leagueOne, "test"));
    }

    @Test
    public void validateHeadCoachTest() {
        MockData mock = new MockData();
        IValidate validate = new Validation();
        assertEquals((validate.validateHeadCoach(mock.leagueOne, "4")), null);
    }

    @Test
    public void validateStringTest() {
        IValidate validate = new Validation();
        assertFalse(validate.validateString("9"));
        assertTrue(validate.validateString("test"));
    }
}
