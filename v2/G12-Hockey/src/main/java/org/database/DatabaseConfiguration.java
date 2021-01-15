package org.database;

import org.database.interfaces.IDatabaseConfiguration;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DatabaseConfiguration implements IDatabaseConfiguration {

    String host;
    String username;
    String password;
    FileReader reader;
    {
        try {
            reader = new FileReader("dbconfig.properties");
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }

        Properties pr = new Properties();
        try {
            pr.load(reader);
        } catch (IOException e) {
            System.out.println("Error: IO Exception");
        }
        host = pr.getProperty("DB_HOST");
        username = pr.getProperty("DB_USERNAME");
        password = pr.getProperty("DB_PASSWORD");
    }

    private String URL = host;
    private String USER = username;
    private String PASSWORD = password;

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
