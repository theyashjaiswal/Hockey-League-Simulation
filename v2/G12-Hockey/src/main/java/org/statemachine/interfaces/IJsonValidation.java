package org.statemachine.interfaces;

import org.leaguemodel.interfaces.ILeague;

public interface IJsonValidation {
    public ILeague importLeagueJSON(String[] args, String jsonSchemaLocation);
}
