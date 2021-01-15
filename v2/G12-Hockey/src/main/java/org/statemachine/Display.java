package org.statemachine;

import org.leaguemodel.interfaces.ILeague;
import org.leaguemodel.interfaces.ILeagueGetSetDB;
import org.leaguemodel.interfaces.ITeam;
import org.leaguesimulation.interfaces.IScoreboard;
import org.leaguesimulation.interfaces.ITeamOnScoreboard;
import org.statemachine.interfaces.IDisplay;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public class Display implements IDisplay {
    @Override
    public void displayLeagueList(ILeagueGetSetDB db) {
        List<HashMap<String, Object>> leagueNameList = db.getLeagueNameDB();
        if (leagueNameList.size() == 0) {
            System.out.println("No League in the db to load");
            System.exit(1);
        }
        for (int i = 0; i < leagueNameList.size(); i++) {
            System.out.println((i + 1) + ". " + leagueNameList.get(i).get("league_name").toString());
        }
    }

    @Override
    public void displayTeamList(String leagueName, ILeagueGetSetDB db) {
        List<HashMap<String, Object>> teamNameList;
        teamNameList = db.getTeamNameDB(leagueName);
        if (teamNameList.size() == 0) {
            System.out.println("No teams in the league");
            System.exit(1);
        }
        for (int i = 0; i < teamNameList.size(); i++) {
            System.out.println((i + 1) + ". " + teamNameList.get(i).get("team_name").toString());
        }
    }

    public void displayTeam(ILeague league) {
        System.out.println("\n==============================");
        for (int i = 0; i < league.getConference().size(); i++) {
            System.out.println("Conference Name : " + league.getConference().get(i).getConferenceName());
            for (int j = 0; j < league.getConference().get(i).getDivisions().size(); j++) {
                System.out.println("Division Name : " + league.getConference().get(i).getDivisions().get(j).getDivisionName());
                for (int k = 0; k < league.getConference().get(i).getDivisions().get(j).getTeams().size(); k++) {
                    System.out.println("Team Name : " + league.getConference().get(i).getDivisions().get(j).getTeams().get(k).getTeamName());
                }
            }
        }
    }

    public void displayGeneralManagerList(ILeague league) {
        List<String> managers = league.getGeneralManagers();
        for (int i = 0; i < managers.size(); i++) {
            System.out.println(i + 1 + " " + managers.get(i));
        }
    }

    public void displayHeadCoach(ILeague league) {
        System.out.println("Number" + "\t" + "Name" + "\t" + "Skating" + "\t\t" + "Shooting" + "\t" + "Checking" + "\t" + "Saving");
        for (int i = 0; i < league.getCoaches().size(); i++) {
            System.out.print(i + 1);
            System.out.print("\t\t" + league.getCoaches().get(i).getName());
            System.out.print("\t\t" + league.getCoaches().get(i).getSkating());
            System.out.print("\t\t\t" + league.getCoaches().get(i).getShooting());
            System.out.print("\t\t\t" + league.getCoaches().get(i).getChecking());
            System.out.print("\t\t\t" + league.getCoaches().get(i).getSaving());
            System.out.println();
        }
    }

    public void displayFreeAgents(ILeague league) {
        System.out.println("Number" + " \t" + "Name" + " \t" + "Position" + " \t" + "Age" + " \t" + "Skating" + "\t" + "Shooting" + "\t" + "Checking" + "\t" + "Saving");
        for (int i = 0; i < league.getFreeAgents().size(); i++) {
            System.out.println();
            System.out.print(i + 1);
            System.out.print("\t\t" + league.getFreeAgents().get(i).getPlayerName());
            System.out.print("\t\t" + league.getFreeAgents().get(i).getPlayerPosition());
            System.out.print("\t\t" + league.getFreeAgents().get(i).getAge());
            System.out.print("\t\t" + league.getFreeAgents().get(i).getSkating());
            System.out.print("\t\t\t" + league.getFreeAgents().get(i).getShooting());
            System.out.print("\t\t\t" + league.getFreeAgents().get(i).getChecking());
            System.out.print("\t\t\t" + league.getFreeAgents().get(i).getSaving());
        }
        System.out.println();
    }

    public void printGame(ITeam teamOne, ITeam teamTwo){
        System.out.println("\nGame: "+teamOne.getTeamName()+" V/S "+teamTwo.getTeamName()+ " ===> ");
    }

    public void printGameResult(ITeam team){
        System.out.print("Winner is "+ team.getTeamName());
    }

    public void printDate(LocalDate date){
        System.out.print("\n===Date:"+date.toString()+"===");
    }

    public void printWinner(ITeamOnScoreboard team){
        System.out.println("\n============LEAGUE WINNER: "+team.getTeam().getTeamName()+"============\n");
    }

    public void printRegularSeason(IScoreboard leagueScoreboard){
        leagueScoreboard.sort();
        System.out.print("\n\n===END OF REGULAR SEASON===");
        System.out.println("Team\t\tScore\t\tWon\t\tLoss");
        for (ITeamOnScoreboard team:
                leagueScoreboard.getScoreboard()) {
            System.out.println(team.getTeam().getTeamName()+"\t"+team.getScore()+"\t"+(team.getScore()+team.getLossPoints())/2+"\t"+team.getLossPoints()/2);
        }
        System.out.println();
        System.out.print("===END OF REGULAR SEASON===");
    }

    public void printPlayOffSeason(IScoreboard leagueScoreboard){
        leagueScoreboard.sort();
        System.out.print("\n\n===END OF PLAYOFFS===");
        System.out.println("\nTeam\t\tWon\t\tLoss");
        for (ITeamOnScoreboard team:
                leagueScoreboard.getScoreboard()) {
            System.out.println(team.getTeam().getTeamName()+"\t"+(team.getScore()+team.getLossPoints())/2+"\t"+team.getLossPoints()/2);
        }
        System.out.println();
        System.out.print("===END OF PLAYOFFS===");
    }

    public void printSaveSimulationMessage(){
        System.out.println("\nPlease wait while we are saving the progress...");
    }
}
