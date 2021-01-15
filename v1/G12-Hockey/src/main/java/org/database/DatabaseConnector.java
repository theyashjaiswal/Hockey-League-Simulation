package org.database;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnector {
    public static Connection establishConnection() {
        String url,name,pass;
        Connection con = null;
        FileReader reader = null;
        try {
            //System.getenv("DHL_HOME");
            //reader = new FileReader(System.getenv("DHL_HOME")+"//conf//dbconfig.properties");
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
        String host = pr.getProperty("DB_HOST");
        String username = pr.getProperty("DB_USERNAME");
        String password = pr.getProperty("DB_PASSWORD");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            url = host;
            name = username;
            pass = password;
            con = DriverManager.getConnection(url, name, pass);
            //System.out.println("Connected to database successfully!!");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error: unable to load driver class!");
            System.exit(1);
        }
        return con;
    }

}
