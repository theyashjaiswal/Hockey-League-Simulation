package org.leaguemodel;

import org.leaguemodel.interfaces.*;

import java.util.ArrayList;
import java.util.List;

public class AgingEngine implements IAgingEngine {
    private IInjurySystem injurySystem;
    private IAging aging;
    private IAgingSystem agingSystem;
    private IPlayerReplacement playerReplacement;
    private LeagueModelConstants leagueConstants;

    public AgingEngine(IInjurySystem injurySystem, IAging aging, IAgingSystem agingSystem, IPlayerReplacement playerReplacement) {
        this.injurySystem = injurySystem;
        this.aging = aging;
        this.agingSystem = agingSystem;
        this.playerReplacement = playerReplacement;
        this.leagueConstants = new LeagueModelConstants();
    }

    @Override
    public void initAging(ILeague leagueLOM, int numberOfDays) {

        List<Object> agingInputList = new ArrayList<>();
        List<IPlayers> freeAgents = leagueLOM.getFreeAgents();
        for (IConference conference : leagueLOM.getConference()) {
            for (IDivisions divisions : conference.getDivisions()) {
                for (ITeam team : divisions.getTeams()) {
                    for (IPlayers player : team.getPlayers()) {
                        agingInputList.add(team);
                        agingInputList.add(playerReplacement);
                        agingInputList.add(freeAgents);
                        agingSystem.agePlayer(player, injurySystem, numberOfDays);
                        if ((numberOfDays % leagueConstants.ONEYEAR) == 0) {
                            agingSystem.retireTeamPlayers(agingInputList, freeAgents, aging);
                        }
                    }
                }
            }
        }
        for (IPlayers freeAgent : leagueLOM.getFreeAgents()) {
            agingSystem.agePlayer(freeAgent, injurySystem, numberOfDays);
            if ((numberOfDays % leagueConstants.ONEYEAR) == 0) {
                agingSystem.retireFreeAgents(freeAgent, aging);
            }
        }
    }
}
