package org.statemachine.interfaces;

import org.leaguemodel.interfaces.IHeadCoach;
import org.leaguemodel.interfaces.ILeague;

public interface IValidate {

    public boolean validateLOM(ILeague leagueLOM);

    public boolean validateGeneralManager(ILeague leagueOne, String generalManager);

    public IHeadCoach validateHeadCoach(ILeague leagueLOM, String headCoach);

    public boolean validateString(String userInput);

    boolean schemaValidation(String leagueData, String jsonSchema);
}
