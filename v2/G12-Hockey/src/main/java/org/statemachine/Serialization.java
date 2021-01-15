package org.statemachine;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.parser.JSONParser;
import org.leaguemodel.League;
import org.leaguemodel.interfaces.ILeague;
import org.statemachine.interfaces.ISerialization;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Serialization implements ISerialization {

    public void serialize(ILeague leagueLOM) {
        try {
            FileWriter fileWriter = new FileWriter("leagueobj.json");
            new GsonBuilder().setPrettyPrinting().create().toJson(leagueLOM, fileWriter);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public ILeague deserialize(String filename) {
        ILeague leagueLOM = null;
        try {
            FileReader readerObj = new FileReader("leagueobj.json");
            Gson gsonObj = new Gson();
            JSONParser jsonObj = new JSONParser();
            leagueLOM = gsonObj.fromJson(jsonObj.parse(readerObj).toString(), League.class);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return leagueLOM;
    }
}
