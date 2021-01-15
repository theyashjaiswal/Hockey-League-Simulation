package org.statemachine;

import org.leaguemodel.InjurySystem;
import org.leaguemodel.interfaces.IInjuries;
import org.leaguemodel.interfaces.IInjurySystem;
import org.leaguemodel.interfaces.IPlayers;
import org.leaguemodel.interfaces.ITeam;
import org.statemachine.interfaces.ITrainingSystem;

public class TrainingSystem implements ITrainingSystem {
    private IInjurySystem playerInjury = new InjurySystem();

    public void CheckStatistics(IInjuries injuries, ITeam team)
    {
        double headCoachSkating = team.getHeadCoach().getSkating();
        double headCoachChecking = team.getHeadCoach().getChecking();
        double headCoachSaving = team.getHeadCoach().getSaving();
        double headCoachShooting = team.getHeadCoach().getShooting();
        for (int i = 0; i < team.getPlayers().size(); i++) {
            if (team.getPlayers().get(i).getNoOfDaysInjured() == -1) {
                checkSkatingStatistics(headCoachSkating, team.getPlayers().get(i), injuries);
                checkCheckingStatistics(headCoachChecking, team.getPlayers().get(i), injuries);
                checkSavingStatistics(headCoachSaving, team.getPlayers().get(i), injuries);
                checkShootingStatistics(headCoachShooting, team.getPlayers().get(i), injuries);
            }
        }
    }

    public void checkSkatingStatistics(double headCoachSkating, IPlayers player, IInjuries injury) {
        double valueSkating = Math.random();
        if (valueSkating < headCoachSkating) {
            player.setSkating(player.getSkating() + 1);
            System.out.println("Skating stats increased for:" + player.getPlayerName());
        } else {
            playerInjury.isPlayerInjured(injury, player);
        }
    }

    public void checkCheckingStatistics(double headCoachChecking, IPlayers player, IInjuries injury) {
        if (player.getNoOfDaysInjured() == -1) {
            double valueChecking = Math.random();
            if (valueChecking < headCoachChecking) {
                player.setChecking(player.getChecking() + 1);
                System.out.println("Checking stats increased for:" + player.getPlayerName());
            } else {
                playerInjury.isPlayerInjured(injury, player);
            }
        }
    }

    public void checkSavingStatistics(double headCoachSkating, IPlayers player, IInjuries injury) {
        if (player.getNoOfDaysInjured() == -1) {
            double valueSaving = Math.random();
            if (valueSaving < headCoachSkating) {
                player.setSaving(player.getSaving() + 1);
                System.out.println("Saving stats increased for:" + player.getPlayerName());
            } else {
                playerInjury.isPlayerInjured(injury, player);
            }
        }
    }

    public void checkShootingStatistics(double headCoachShooting, IPlayers player, IInjuries injury) {
        if (player.getNoOfDaysInjured() == -1) {
            double valueShooting = Math.random();
            if (valueShooting < headCoachShooting) {
                player.setShooting(player.getShooting() + 1);
                System.out.println("Shooting stats increased for:" + player.getPlayerName());
            } else {
                playerInjury.isPlayerInjured(injury, player);
            }
        }
    }
}