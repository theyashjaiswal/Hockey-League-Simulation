package org.trading;

import org.leaguemodel.interfaces.ILeague;
import org.leaguemodel.interfaces.IPlayers;
import org.leaguemodel.interfaces.ITeam;
import org.trading.interfaces.ICheckPlayers;
import org.trading.interfaces.IDisplayTrade;

import java.util.List;
import java.util.Scanner;

public class DisplayTrade implements IDisplayTrade {

    public Boolean displayUserTrade(List<IPlayers> weakPlayers, List<IPlayers> strongPlayers) {
        System.out.println("Players Offered for Trade: ");
        System.out.println("Player Name" + "  " + "Position" + "  " + "Age" + "  " + "Skating" + "  " + "Shooting" + "  " + "Checking" + " " + "Saving");
        System.out.println("=============================================================================");
        for (int i = 0; i < weakPlayers.size(); i++) {
            System.out.print("" + weakPlayers.get(i).getPlayerName());
            System.out.print(" 	" + weakPlayers.get(i).getPlayerPosition());
            System.out.print("  " + weakPlayers.get(i).getAge());
            System.out.print("	" + weakPlayers.get(i).getSkating());
            System.out.print(" 	" + weakPlayers.get(i).getShooting());
            System.out.print(" 	" + weakPlayers.get(i).getChecking());
            System.out.print(" 	" + weakPlayers.get(i).getSaving() + "\n");
        }
        System.out.println("\nPlayers Requested for Trade from your Team:");
        System.out.println("Player Name" + "  " + "Position" + "  " + "Age" + "  " + "Skating" + "  " + "Shooting" + "  " + "Checking" + " " + "Saving");
        System.out.println("=============================================================================");
        for (int i = 0; i < strongPlayers.size(); i++) {
            System.out.print("" + strongPlayers.get(i).getPlayerName());
            System.out.print("      " + strongPlayers.get(i).getPlayerPosition());
            System.out.print("      " + strongPlayers.get(i).getAge());
            System.out.print("      " + strongPlayers.get(i).getSkating());
            System.out.print("      " + strongPlayers.get(i).getShooting());
            System.out.print("      " + strongPlayers.get(i).getChecking());
            System.out.print("      " + strongPlayers.get(i).getSaving() + "\n");
        }
        System.out.println("\nDo you accept the Trade Offer ? : 1.Yes 2.No");
        System.out.println("Enter your choice: ");
        Scanner sc = new Scanner(System.in);
        int userChoice = sc.nextInt();
        boolean correctOption = false;
        do {
            if (userChoice == 1) {
                correctOption = true;
                return true;
            } else if (userChoice == 2) {
                correctOption = true;
                return false;
            } else {
                System.out.println("re-enter correct option!!!!");
                System.out.println("Enter your choice: ");
                userChoice = sc.nextInt();
            }
        } while (correctOption == false);
        return false;
    }

    public int displayFreeAgents(ITeam team, ILeague leagueObj) {
        ICheckPlayers check = new CheckPlayers();
        System.out.println("Add players from Free Agents List to your Team: ");
        System.out.println("No." + "  " + "Player Name" + "  " + "Position" + "  " + "Age" + "  " + "Skating" + "  " + "Shooting" + "  " + "Checking" + " " + "Saving");
        System.out.println("=================================================================");
        for (int i = 0; i < leagueObj.getFreeAgents().size(); i++) {
            System.out.print((i + 1) + "        " + leagueObj.getFreeAgents().get(i).getPlayerName());
            System.out.print("      " + leagueObj.getFreeAgents().get(i).getPlayerPosition());
            System.out.print("      " + leagueObj.getFreeAgents().get(i).getAge());
            System.out.print("      " + leagueObj.getFreeAgents().get(i).getSkating());
            System.out.print("      " + leagueObj.getFreeAgents().get(i).getShooting());
            System.out.print("      " + leagueObj.getFreeAgents().get(i).getChecking());
            System.out.print("      " + leagueObj.getFreeAgents().get(i).getSaving() + "\n");
        }
        System.out.println("\nAdjust your roster to satisfy 18 Skaters and 2 Goalies to proceed further!!!");
        System.out.println("Skaters Count: " + check.skaters(team));
        System.out.println("Goalies Count: " + check.goalies(team));
        System.out.println("Select the Free agent to add to your Team: ");
        Scanner sc = new Scanner(System.in);
        int freeAgentIndex = sc.nextInt();
        return freeAgentIndex;
    }

    public int displayPlayerList(ITeam team) {
        ICheckPlayers check = new CheckPlayers();
        System.out.println("Drop Players from your Team: ");
        System.out.println("No." + "  " + "Player Name" + "  " + "Position" + "  " + "Age" + "  " + "Skating" + "  " + "Shooting" + "  " + "Checking" + " " + "Saving");
        System.out.println("=================================================================");
        for (int i = 0; i < team.getPlayers().size(); i++) {
            System.out.print(i + 1 + "      " + team.getPlayers().get(i).getPlayerName());
            System.out.print("      " + team.getPlayers().get(i).getPlayerPosition());
            System.out.print("      " + team.getPlayers().get(i).getAge());
            System.out.print("      " + team.getPlayers().get(i).getSkating());
            System.out.print("      " + team.getPlayers().get(i).getShooting());
            System.out.print("      " + team.getPlayers().get(i).getChecking());
            System.out.print("      " + team.getPlayers().get(i).getSaving() + "\n");
        }
        System.out.println("\nAdjust your roster to satisfy 18 Skaters and 2 Goalies to proceed further!!!");
        System.out.println("Skaters Count: " + check.skaters(team));
        System.out.println("Goalies Count : " + check.goalies(team));
        System.out.println("Select the player to drop from your Team: ");
        Scanner sc = new Scanner(System.in);
        int playerDropIndex = sc.nextInt();
        return playerDropIndex;
    }

    public void displayAITradeStatus(String askingTeam, String oppositeTeam, Boolean tradeDecision) {

        if (tradeDecision) {
            System.out.println("Team: " + askingTeam + " succesfully traded with " + oppositeTeam);
        } else {
            System.out.println("Team: " + askingTeam + "  Trade offer got rejected by " + oppositeTeam);
        }
    }

    public void displayUserTradeStatus(String askingTeam, String oppositeTeam, Boolean tradeDecision) {

        if (tradeDecision) {
            System.out.println("User Team's - " + oppositeTeam + " Trade with - " + askingTeam + " completed!!");
        } else {
            System.out.println("You rejected Trade offer by - " + askingTeam);
        }
    }
}
