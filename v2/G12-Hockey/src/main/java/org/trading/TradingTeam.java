package org.trading;

import org.apache.commons.lang3.StringUtils;
import org.leaguemodel.CheckStrength;
import org.leaguemodel.interfaces.*;
import org.trading.interfaces.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TradingTeam implements ITradingTeam {

    public void tradingTeamPlayers(ITeam askingTeam, ILeague leagueOne, ITrading tradingConfig) {
        ArrayList<ITeam> universalTeamList = new ArrayList<>();
        List<IPlayers> askingplayerList;
        List<IPlayers> weakPlayers;
        String strongestTeam = null;
        double strength = 0;
        double maxStrength = 0;
        for (int i = 0; i < leagueOne.getConference().size(); i++) {
            for (int j = 0; j < leagueOne.getConference().get(i).getDivisions().size(); j++) {
                universalTeamList.addAll(leagueOne.getConference().get(i).getDivisions().get(j).getTeams());
            }
        }
        for (int i = 0; i < universalTeamList.size(); i++) {
            Collections.sort(universalTeamList.get(i).getPlayers(), new StatsComparator());
        }
        askingplayerList = askingTeam.getPlayers();
        weakPlayers = askingplayerList.subList(askingplayerList.size() - tradingConfig.getMaxPlayersPerTrade(), askingplayerList.size());
        for (int i = 0; i < universalTeamList.size(); i++) {
            if (StringUtils.equalsIgnoreCase(askingTeam.getTeamName(), universalTeamList.get(i).getTeamName())) {
                continue;
            } else {
                for (int j = 0; j < universalTeamList.get(i).getPlayers().size(); j++) {
                    for (int k = 0; k < weakPlayers.size(); k++) {
                        if (StringUtils.equalsIgnoreCase(((IPlayers) weakPlayers.get(weakPlayers.size() - 1)).getPlayerPosition(), universalTeamList.get(i).getPlayers().get(j).getPlayerPosition())) {
                            ICheckStrength checkStrength = new CheckStrength();
                            strength = checkStrength.playerStrength((IStrength) universalTeamList.get(i).getPlayers().get(j));
                            if (strength > maxStrength) {
                                maxStrength = strength;
                                strongestTeam = universalTeamList.get(i).getTeamName();
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < universalTeamList.size(); i++) {
            if (StringUtils.equalsIgnoreCase(universalTeamList.get(i).getTeamName(), strongestTeam)) {
                if (StringUtils.equalsIgnoreCase(askingTeam.getTeamType(), enumTeamType.AI.toString()) &&
                        StringUtils.equalsIgnoreCase(universalTeamList.get(i).getTeamType(), enumTeamType.User.toString())) {
                    UserTrade(askingTeam, universalTeamList.get(i), tradingConfig.getMaxPlayersPerTrade(), leagueOne);
                    break;
                } else if (StringUtils.equalsIgnoreCase(askingTeam.getTeamType(), enumTeamType.AI.toString()) &&
                        StringUtils.equalsIgnoreCase(universalTeamList.get(i).getTeamType(), enumTeamType.AI.toString())) {
                    AITrade(askingTeam, universalTeamList.get(i), tradingConfig, leagueOne);
                    break;
                }
            }
        }
    }

    ;

    public void AITrade(ITeam askingTeam, ITeam oppositeTeam, ITrading tradeConfig, ILeague leagueOne) {
        List<IPlayers> askingplayerList = new ArrayList<>();
        List<IPlayers> oppositeplayerList = new ArrayList<>();
        List<IPlayers> finalaskingplayerList = new ArrayList<>();
        List<IPlayers> finaloppositeplayerList = new ArrayList<>();
        List<IPlayers> weakPlayers = new ArrayList<>();
        List<IPlayers> strongPlayers = new ArrayList<>();
        List<IPlayers> tempweakPlayers = new ArrayList<>();
        List<IPlayers> tempstrongPlayers = new ArrayList<>();
        askingplayerList = askingTeam.getPlayers();
        tempweakPlayers = askingplayerList.subList(askingplayerList.size() - tradeConfig.getMaxPlayersPerTrade(), askingplayerList.size());
        weakPlayers = tempweakPlayers;
        oppositeplayerList = oppositeTeam.getPlayers();
        tempstrongPlayers = oppositeplayerList.subList(0, tradeConfig.getMaxPlayersPerTrade());
        strongPlayers = tempstrongPlayers;
        ITradeDecision tradeAIDecision = new TradeDecision();
        IBalance balance = new Balance();
        ICheckPlayers check = new CheckPlayers();
        IDisplayTrade display = new DisplayTrade();
        boolean tradeDecisionAI = tradeAIDecision.tradeAIDecision(tradeConfig.getRandomAcceptanceChance());
        if (tradeDecisionAI) {
            finalaskingplayerList.addAll(strongPlayers);
            finaloppositeplayerList.addAll(weakPlayers);
            askingplayerList.removeAll(weakPlayers);
            oppositeplayerList.removeAll(strongPlayers);
            finalaskingplayerList.addAll(askingplayerList);
            finaloppositeplayerList.addAll(oppositeplayerList);
            askingTeam.setPlayers(finalaskingplayerList);
            oppositeTeam.setPlayers(finaloppositeplayerList);
            balance.balanceTeams(askingTeam, leagueOne);
            balance.balanceTeams(oppositeTeam, leagueOne);
            check.Captain(askingTeam);
            check.Captain(oppositeTeam);
            display.displayAITradeStatus(askingTeam.getTeamName(), oppositeTeam.getTeamName(), true);
        } else {
            display.displayAITradeStatus(askingTeam.getTeamName(), oppositeTeam.getTeamName(), false);
        }
    }

    public void UserTrade(ITeam askingTeam, ITeam oppositeTeam, int maxPlayersPerTrade, ILeague leagueOne) {
        List<IPlayers> askingplayerList;
        List<IPlayers> oppositeplayerList;
        List<IPlayers> finalaskingplayerList = new ArrayList<>();
        List<IPlayers> finaloppositeplayerList = new ArrayList<>();
        List<IPlayers> weakPlayers;
        List<IPlayers> strongPlayers;
        List<IPlayers> tempweakPlayers;
        List<IPlayers> tempstrongPlayers;
        askingplayerList = askingTeam.getPlayers();
        tempweakPlayers = askingplayerList.subList(askingplayerList.size() - maxPlayersPerTrade, askingplayerList.size());
        weakPlayers = tempweakPlayers;
        oppositeplayerList = oppositeTeam.getPlayers();
        tempstrongPlayers = oppositeplayerList.subList(0, maxPlayersPerTrade);
        strongPlayers = tempstrongPlayers;
        ITradeDecision trdUserDecision = new TradeDecision();
        IBalance balance = new Balance();
        ICheckPlayers check = new CheckPlayers();
        IDisplayTrade display = new DisplayTrade();
        boolean tradeDecision = trdUserDecision.tradeUserDecision(weakPlayers, strongPlayers);
        if (tradeDecision) {
            finalaskingplayerList.addAll(strongPlayers);
            finaloppositeplayerList.addAll(weakPlayers);
            askingplayerList.removeAll(weakPlayers);
            oppositeplayerList.removeAll(strongPlayers);
            finalaskingplayerList.addAll(askingplayerList);
            finaloppositeplayerList.addAll(oppositeplayerList);
            askingTeam.setPlayers(finalaskingplayerList);
            oppositeTeam.setPlayers(finaloppositeplayerList);
            balance.balanceTeams(askingTeam, leagueOne);
            balance.balanceTeams(oppositeTeam, leagueOne);
            check.Captain(askingTeam);
            check.Captain(oppositeTeam);
            display.displayUserTradeStatus(askingTeam.getTeamName(), oppositeTeam.getTeamName(), true);
        } else {
            display.displayUserTradeStatus(askingTeam.getTeamName(), oppositeTeam.getTeamName(), false);
        }
    }

    enum enumTeamType {
        AI, User;
    }
}
