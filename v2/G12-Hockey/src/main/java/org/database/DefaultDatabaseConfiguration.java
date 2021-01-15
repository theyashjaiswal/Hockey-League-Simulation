package org.database;

import org.database.interfaces.IDatabaseConfiguration;

public class DefaultDatabaseConfiguration implements IDatabaseConfiguration {
    private static final String URL = "jdbc:mysql://db-5308.cs.dal.ca:3306/CSCI5308_12_DEVINT?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USER = "CSCI5308_12_DEVINT_USER";
    private static final String PASSWORD = "2HkmfSQ6eg";

    public String getDatabaseUserName() {
        return USER;
    }

    public String getDatabasePassword() {
        return PASSWORD;
    }

    public String getDatabaseURL() {
        return URL;
    }
}
