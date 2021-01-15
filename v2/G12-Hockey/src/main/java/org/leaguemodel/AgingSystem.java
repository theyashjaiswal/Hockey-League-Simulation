package org.leaguemodel;

import org.leaguemodel.interfaces.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AgingSystem implements IAgingSystem {

    private LeagueModelConstants leagueConstants;

    public AgingSystem() {
        this.leagueConstants = new LeagueModelConstants();
    }

    public Map<String, IPlayers> retirementAlgorithm(List<IPlayers> playersList, IAging aging) {
        int averageRetirementAge = aging.getAverageRetirementAge();
        int maximumAge = aging.getMaximumAge();
        int range = (maximumAge - averageRetirementAge) / 3;
        Map<String, IPlayers> playersToRetireMap = new HashMap<>();
        ICheckStrength iCheckStrength = new CheckStrength();
        ITeam iTeam = new Team();
        iTeam.setPlayers(playersList);
        double averageStrength = iCheckStrength.teamStrength(iTeam) / playersList.size();

        for (int i = 0; i < playersList.size(); i++) {
            double playerStrength = 0.0;
            int age = playersList.get(i).getAge();
            int thrushHold = averageRetirementAge - range;
            String playerName = playersList.get(i).getPlayerName();
            playerStrength = iCheckStrength.playerStrength((IStrength) playersList.get(i));
            if (age >= maximumAge) {
                playersToRetireMap.put(playerName, playersList.get(i));
                playersList.get(i).setRetired(true);
            } else if (age >= averageRetirementAge) {
                if (playerStrength < averageStrength) {
                    playersToRetireMap.put(playerName, playersList.get(i));
                    playersList.get(i).setRetired(true);
                }
            } else if ((age >= thrushHold) && (playerStrength < averageStrength / 2.0)) {
                playersToRetireMap.put(playerName, playersList.get(i));
                playersList.get(i).setRetired(true);
            }
        }
        return playersToRetireMap;
    }

    public Map<String, IPlayers> retireTeamPlayers(List<Object> agingInputList, List<IPlayers> freeAgents, IAging aging) {
        List<IPlayers> playersList;
        ITeam team = (ITeam) agingInputList.get(0);
        IPlayerReplacement playerReplacement = (IPlayerReplacement) agingInputList.get(1);
        playersList = team.getPlayers();
        Map<String, IPlayers> retiredPlayers = retirementAlgorithm(playersList, aging);
        playerReplacement.replacePlayers(team, freeAgents);
        return retiredPlayers;
    }

    public Map<String, IPlayers> retireFreeAgents(IPlayers freeAgents, IAging aging) {
        List<IPlayers> playersList = new ArrayList<>();
        playersList.add(freeAgents);
        return retirementAlgorithm(playersList, aging);
    }

    public void agePlayer(IPlayers player, IInjurySystem injuryStatusUpdate, int numberOfDays) {
        if ((numberOfDays % leagueConstants.ONEYEAR) == 0) {
            player.setAge(player.getAge() + 1);
        }
        injuryStatusUpdate.isPlayerRecovered(player);
    }
}
