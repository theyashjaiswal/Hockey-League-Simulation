package org.statemachine;

public interface IJsonValidation {
    String readJSON(String fileLocation);
    boolean schemaValidation(String leagueData, String jsonSchema);
}
