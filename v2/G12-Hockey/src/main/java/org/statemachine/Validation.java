package org.statemachine;

import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONException;
import org.json.JSONObject;
import org.leaguemodel.HeadCoach;
import org.leaguemodel.ValidationsInLeague;
import org.leaguemodel.interfaces.ICoach;
import org.leaguemodel.interfaces.IHeadCoach;
import org.leaguemodel.interfaces.ILeague;
import org.leaguemodel.interfaces.IValidationsInLeague;
import org.statemachine.interfaces.IValidate;

import java.util.List;

public class Validation implements IValidate {
    public boolean validateLOM(ILeague leagueLOM) {
        boolean validateStatus = false;
        IValidationsInLeague validateLeagueData = new ValidationsInLeague();
        if (validateLeagueData.validateConferenceList(leagueLOM)) {
            System.out.println("Duplicate conferences in the import");
            validateStatus = true;
        } else if (validateLeagueData.validateDivisionList(leagueLOM)) {
            System.out.println("Duplicate divisions in the conference");
            validateStatus = true;
        } else if (validateLeagueData.validateTeamList(leagueLOM)) {
            System.out.println("Duplicate teams in the league");
            validateStatus = true;
        } else if (validateLeagueData.validateCaptain(leagueLOM)) {
            System.out.println("Captain status is ambigious");
            validateStatus = true;
        }
        return validateStatus;
    }

    public boolean validateGeneralManager(ILeague leagueLOM, String generalManager) {
        List<String> managers = leagueLOM.getGeneralManagers();
        for (int i = 0; i < managers.size(); i++) {
            if (managers.get(i).equalsIgnoreCase(generalManager)) {
                managers.remove(i);
                return false;
            }
        }
        return true;
    }

    public IHeadCoach validateHeadCoach(ILeague leagueLOM, String headCoach) {
        List<ICoach> coachesList = leagueLOM.getCoaches();
        int headCoachNumber = 0;
        headCoachNumber = Integer.parseInt(headCoach);
        if (headCoachNumber > coachesList.size() || headCoachNumber <= 0) {
            return null;
        } else {
            IHeadCoach coach = new HeadCoach();
            coach.setName(coachesList.get(headCoachNumber - 1).getName());
            coach.setSkating(coachesList.get(headCoachNumber - 1).getSkating());
            coach.setShooting(coachesList.get(headCoachNumber - 1).getShooting());
            coach.setChecking(coachesList.get(headCoachNumber - 1).getChecking());
            coach.setSaving(coachesList.get(headCoachNumber - 1).getSaving());
            coachesList.remove(headCoachNumber - 1);
            return coach;
        }
    }

    public boolean validateString(String userInput) {
        String regex = "[0-9]+";
        if (userInput.matches(regex)) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean schemaValidation(String leagueData, String jsonSchema) {
        boolean status = false;
        JSONObject jsonObject = new JSONObject(jsonSchema);
        try {
            Schema schema = SchemaLoader.load(jsonObject);
            schema.validate(new JSONObject(leagueData));
            status = true;
        } catch (ValidationException e) {
            System.out.println("Below values are incorrect, kindly provide proper values:");
            for (String schemaViolation : e.getAllMessages()) {
                System.out.println(schemaViolation);
            }
        } catch (JSONException e) {
            System.out.println("JSONException occurred!" + e);
        } catch (Exception e) {
            System.out.println("Exception occurred!" + e);
        }
        return status;
    }
}