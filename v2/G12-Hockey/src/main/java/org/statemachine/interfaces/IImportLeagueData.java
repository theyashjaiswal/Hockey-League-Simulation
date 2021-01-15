package org.statemachine.interfaces;

import org.leaguemodel.interfaces.ILeague;

public interface IImportLeagueData {
    public ILeague loadLeagueMemory(String jsonFileLocation);
}
