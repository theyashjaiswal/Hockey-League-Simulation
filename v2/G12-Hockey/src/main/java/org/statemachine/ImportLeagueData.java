package org.statemachine;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.leaguemodel.*;
import org.leaguemodel.interfaces.*;
import org.statemachine.interfaces.IImportLeagueData;
import org.statemachine.interfaces.IInput;
import org.statemachine.interfaces.IJsonValidation;
import org.statemachine.interfaces.IValidate;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class ImportLeagueData implements IJsonValidation, IImportLeagueData {
    LeagueDataKeys leagueDataKeys = new LeagueDataKeys();

    public ILeague loadLeagueMemory(String jsonFileLocation) {
        JSONParser jsonParser = new JSONParser();
        String leagueName, conferenceName, divisionName, teamName, playerName, position, name;
        int injuryDaysLow, injuryDaysHigh, daysUntilStatIncreaseCheck, lossPoint, maxPlayersPerTrade, age;
        double randomWinChance, randomInjuryChance, randomTradeOfferChance, randomAcceptanceChance, coachSkating, coachShooting, coachChecking, coachSaving;
        boolean captain;
        ILeague leagueLOM = null;
        try {
            Reader reader = new FileReader(jsonFileLocation);
            JSONObject leagueJSONObject = (JSONObject) jsonParser.parse(reader);
            JSONArray conferencesJSONArray = (JSONArray) leagueJSONObject.get(leagueDataKeys.getConferences());
            leagueLOM = new League();
            IGameplayConfig gameplayConfig = new GameplayConfig();
            JSONObject gameplayConfigJSONObject = (JSONObject) leagueJSONObject.get(leagueDataKeys.getGameplayConfig());

            IAging aging = new Aging();
            JSONObject ageingObject = (JSONObject) gameplayConfigJSONObject.get(leagueDataKeys.getAging());
            int averageRetirementAge = (int) (long) ageingObject.get(leagueDataKeys.getAverageRetirementAge());
            int maximumAge = (int) (long) ageingObject.get(leagueDataKeys.getMaximumAge());
            aging.setAverageRetirementAge(averageRetirementAge);
            aging.setMaximumAge(maximumAge);
            gameplayConfig.setAging(aging);

            IGameResolver gameResolver = new GameResolver();
            JSONObject gameResolverJSONObject = (JSONObject) gameplayConfigJSONObject.get(leagueDataKeys.getGameResolver());
            randomWinChance = (double) gameResolverJSONObject.get(leagueDataKeys.getRandomWinChance());
            gameResolver.setRandomWinChance(randomWinChance);
            gameplayConfig.setGameResolver(gameResolver);

            IInjuries injuries = new Injuries();
            JSONObject injuriesJSONObject = (JSONObject) gameplayConfigJSONObject.get(leagueDataKeys.getInjuries());
            randomInjuryChance = (double) injuriesJSONObject.get(leagueDataKeys.getRandomInjuryChance());
            injuryDaysLow = (int) (long) injuriesJSONObject.get(leagueDataKeys.getInjuryDaysLow());
            injuryDaysHigh = (int) (long) injuriesJSONObject.get(leagueDataKeys.getInjuryDaysHigh());
            injuries.setRandomInjuryChance(randomInjuryChance);
            injuries.setInjuryDaysLow(injuryDaysLow);
            injuries.setInjuryDaysHigh(injuryDaysHigh);
            gameplayConfig.setInjuries(injuries);

            ITraining training = new Training();
            JSONObject trainingJSONObject = (JSONObject) gameplayConfigJSONObject.get(leagueDataKeys.getTraining());
            daysUntilStatIncreaseCheck = (int) (long) trainingJSONObject.get(leagueDataKeys.getDaysUntilStatIncreaseCheck());
            training.setDaysUntilStatIncreaseCheck(daysUntilStatIncreaseCheck);
            gameplayConfig.setTraining(training);

            ITrading trading = new Trading();
            JSONObject tradingJSONObject = (JSONObject) gameplayConfigJSONObject.get(leagueDataKeys.getTrading());
            lossPoint = (int) (long) tradingJSONObject.get(leagueDataKeys.getLossPoint());
            randomTradeOfferChance = (double) tradingJSONObject.get(leagueDataKeys.getRandomTradeOfferChance());
            maxPlayersPerTrade = (int) (long) tradingJSONObject.get(leagueDataKeys.getMaxPlayersPerTrade());
            randomAcceptanceChance = (double) tradingJSONObject.get(leagueDataKeys.getRandomAcceptanceChance());
            trading.setLossPoint(lossPoint);
            trading.setMaxPlayersPerTrade(maxPlayersPerTrade);
            trading.setRandomAcceptanceChance(randomAcceptanceChance);
            trading.setRandomTradeOfferChance(randomTradeOfferChance);
            gameplayConfig.setTrading(trading);

            List<IConference> conferenceArrayListLOM = new ArrayList<>();
            leagueName = (String) leagueJSONObject.get(leagueDataKeys.getLeagueName());
            leagueLOM.setLeagueName(leagueName);
            leagueLOM.setGameplayConfig(gameplayConfig);
            leagueLOM.setConference(conferenceArrayListLOM);

            for (int i = 0; i < conferencesJSONArray.size(); i++) {
                JSONObject conferencesJSONObject = (JSONObject) conferencesJSONArray.get(i);
                JSONArray divisionsJSONArray = (JSONArray) conferencesJSONObject.get(leagueDataKeys.getDivisions());

                IConference conferenceLOM = new Conference();
                List<IDivisions> divisionsArrayList = new ArrayList<>();
                conferenceName = (String) conferencesJSONObject.get(leagueDataKeys.getConferenceName());

                conferenceLOM.setConferenceName(conferenceName);
                conferenceLOM.setDivisions(divisionsArrayList);
                conferenceArrayListLOM.add(conferenceLOM);

                for (int j = 0; j < divisionsJSONArray.size(); j++) {
                    JSONObject divisionsJSONObject = (JSONObject) divisionsJSONArray.get(j);
                    JSONArray teamsJSONArray = (JSONArray) divisionsJSONObject.get(leagueDataKeys.getTeams());

                    IDivisions divisionsLOM = new Divisions();
                    List<ITeam> teamArrayList = new ArrayList<>();
                    divisionName = (String) divisionsJSONObject.get(leagueDataKeys.getDivisionName());

                    divisionsLOM.setDivisionName(divisionName);
                    divisionsLOM.setTeams(teamArrayList);
                    divisionsArrayList.add(divisionsLOM);

                    for (int k = 0; k < teamsJSONArray.size(); k++) {
                        JSONObject teamsJSONObject = (JSONObject) teamsJSONArray.get(k);
                        JSONArray playersJSONArray = (JSONArray) teamsJSONObject.get(leagueDataKeys.getPlayers());

                        ITeam teamLOM = new Team();
                        List<IPlayers> playersArrayListLOM = new ArrayList<>();
                        teamName = (String) teamsJSONObject.get(leagueDataKeys.getTeamName());
                        String teamGeneralManager = (String) teamsJSONObject.get(leagueDataKeys.getGeneralManager());

                        IHeadCoach headCoach = new HeadCoach();
                        JSONObject headCoachJSONObject = (JSONObject) teamsJSONObject.get(leagueDataKeys.getHeadCoach());
                        name = (String) headCoachJSONObject.get(leagueDataKeys.getName());
                        double headcoachSkating = (double) headCoachJSONObject.get(leagueDataKeys.getSkating());
                        double headcoachShooting = (double) headCoachJSONObject.get(leagueDataKeys.getShooting());
                        double headcoachChecking = (double) headCoachJSONObject.get(leagueDataKeys.getChecking());
                        double headcoachSaving = (double) headCoachJSONObject.get(leagueDataKeys.getSaving());
                        headCoach.setName(name);
                        headCoach.setSkating(headcoachSkating);
                        headCoach.setShooting(headcoachShooting);
                        headCoach.setChecking(headcoachChecking);
                        headCoach.setSaving(headcoachSaving);
                        teamLOM.setTeamName(teamName);
                        teamLOM.setGeneralManager(teamGeneralManager);
                        teamLOM.setHeadCoach(headCoach);
                        teamLOM.setPlayers(playersArrayListLOM);
                        teamArrayList.add(teamLOM);

                        for (int l = 0; l < playersJSONArray.size(); l++) {
                            JSONObject playersJSONObject = (JSONObject) playersJSONArray.get(l);
                            IPlayers playersLOM = new Players();
                            playerName = (String) playersJSONObject.get(leagueDataKeys.getPlayerName());
                            position = (String) playersJSONObject.get(leagueDataKeys.getPosition());
                            captain = (boolean) playersJSONObject.get(leagueDataKeys.getCaptain());
                            age = (int) (long) playersJSONObject.get(leagueDataKeys.getAge());
                            Integer skating = (int) (long) playersJSONObject.get(leagueDataKeys.getSkating());
                            Integer shooting = (int) (long) playersJSONObject.get(leagueDataKeys.getShooting());
                            Integer checking = (int) (long) playersJSONObject.get(leagueDataKeys.getChecking());
                            Integer saving = (int) (long) playersJSONObject.get(leagueDataKeys.getSaving());

                            playersLOM.setPlayerName(playerName);
                            playersLOM.setPlayerPosition(position);
                            playersLOM.setIsCaptain(captain);
                            playersLOM.setAge(age);
                            playersLOM.setSkating(skating);
                            playersLOM.setShooting(shooting);
                            playersLOM.setChecking(checking);
                            playersLOM.setSaving(saving);
                            playersArrayListLOM.add(playersLOM);
                        }
                    }
                }
            }
            JSONArray freeAgentsJSONArray = (JSONArray) leagueJSONObject.get(leagueDataKeys.getFreeAgents());
            List<IPlayers> freeAgentsArrayListLOM = new ArrayList<>();
            leagueLOM.setFreeAgents(freeAgentsArrayListLOM);
            for (int i = 0; i < freeAgentsJSONArray.size(); i++) {
                JSONObject freeAgentsJSONObject = (JSONObject) freeAgentsJSONArray.get(i);

                IPlayers freeAgentsLOM = new FreeAgents();
                playerName = (String) freeAgentsJSONObject.get(leagueDataKeys.getPlayerName());
                position = (String) freeAgentsJSONObject.get(leagueDataKeys.getPosition());
                age = (int) (long) freeAgentsJSONObject.get(leagueDataKeys.getAge());
                Integer skating = (int) (long) freeAgentsJSONObject.get(leagueDataKeys.getSkating());
                Integer shooting = (int) (long) freeAgentsJSONObject.get(leagueDataKeys.getShooting());
                Integer checking = (int) (long) freeAgentsJSONObject.get(leagueDataKeys.getChecking());
                Integer saving = (int) (long) freeAgentsJSONObject.get(leagueDataKeys.getSaving());

                freeAgentsLOM.setPlayerName(playerName);
                freeAgentsLOM.setPlayerPosition(position);
                freeAgentsLOM.setAge(age);
                freeAgentsLOM.setSkating(skating);
                freeAgentsLOM.setShooting(shooting);
                freeAgentsLOM.setChecking(checking);
                freeAgentsLOM.setSaving(saving);
                freeAgentsArrayListLOM.add(freeAgentsLOM);
            }
            JSONArray coachJsonArray = (JSONArray) leagueJSONObject.get(leagueDataKeys.getCoaches());
            List<ICoach> coachArrayList = new ArrayList<>();
            leagueLOM.setCoaches(coachArrayList);
            for (int i = 0; i < coachJsonArray.size(); i++) {
                JSONObject coachJSONObject = (JSONObject) coachJsonArray.get(i);
                ICoach coach = new Coach();
                name = (String) coachJSONObject.get(leagueDataKeys.getName());
                coachSkating = (double) coachJSONObject.get(leagueDataKeys.getSkating());
                coachShooting = (double) coachJSONObject.get(leagueDataKeys.getShooting());
                coachChecking = (double) coachJSONObject.get(leagueDataKeys.getChecking());
                coachSaving = (double) coachJSONObject.get(leagueDataKeys.getSaving());
                coach.setName(name);
                coach.setSkating(coachSkating);
                coach.setShooting(coachShooting);
                coach.setChecking(coachChecking);
                coach.setSaving(coachSaving);
                coachArrayList.add(coach);
            }
            JSONArray generalManagerJSONArray = (JSONArray) leagueJSONObject.get(leagueDataKeys.getGeneralManagers());
            List<String> generalManagersArrayList = new ArrayList<>();
            leagueLOM.setGeneralManagers(generalManagersArrayList);
            for (int i = 0; i < generalManagerJSONArray.size(); i++) {
                generalManagersArrayList.add((String) generalManagerJSONArray.get(i));
            }
            return leagueLOM;
        } catch (FileNotFoundException e) {
            System.out.println("File not found exception!" + e);
        } catch (ParseException e) {
            System.out.println("Parse exception has occurred!" + e);
        } catch (IOException e) {
            System.out.println("An IO exception has occurred!" + e);
        } catch (Exception e) {
            System.out.println("An exception has occurred!" + e);
        }
        return leagueLOM;
    }

    public ILeague importLeagueJSON(String[] args, String jsonSchemaLocation) {
        boolean schemaValStatus;
        String leagueData;
        String jsonSchema;
        String inputJsonLocation = args[0];
        IValidate validate = new Validation();
        IImportLeagueData importLeagueData = new ImportLeagueData();
        ILeague leagueLOM = null;
        IInput input = new Input();
        leagueData = input.readJSON(inputJsonLocation);
        jsonSchema = input.readJSON(jsonSchemaLocation);
        schemaValStatus = validate.schemaValidation(leagueData, jsonSchema);

        if (schemaValStatus) {
            leagueLOM = importLeagueData.loadLeagueMemory(inputJsonLocation);
            if (validate.validateLOM(leagueLOM)) {
                return null;
            }
            return leagueLOM;
        }
        System.out.println("Aborted due to incorrect values in JSON!");
        return leagueLOM;
    }
}
