package org.leaguesimulation;

import org.leaguemodel.CheckStrength;
import org.leaguemodel.interfaces.IGameplayConfig;
import org.leaguesimulation.interfaces.IGame;
import org.statemachine.Display;

public class Game implements IGame {

    private TeamOnScoreboard teamOne;
    private TeamOnScoreboard teamTwo;

    public Game(TeamOnScoreboard teamOne, TeamOnScoreboard teamTwo) {
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
    }

    public void executeGame(IGameplayConfig gameplayConfig) {
        Display display = new Display();
        TeamOnScoreboard strongerTeam = calculateStrongerTeam();
        TeamOnScoreboard weakerTeam = calculateWeakerTeam();
        TeamOnScoreboard gameWinner = isRandomGameUpset(gameplayConfig) ? weakerTeam : strongerTeam;
        TeamOnScoreboard gameLoser = isRandomGameUpset(gameplayConfig) ? strongerTeam : weakerTeam;
        updateScores(gameWinner, gameLoser);
        display.printGameResult(gameWinner.getTeam());
    }

    private boolean isRandomGameUpset(IGameplayConfig gameplayConfig) {
        return gameplayConfig.getGameResolver().getRandomWinChance() > Math.random();
    }

    public TeamOnScoreboard calculateStrongerTeam() {
        return getTeamStrength(teamOne) > getTeamStrength(teamTwo) ? teamOne : teamTwo;
    }

    public TeamOnScoreboard calculateWeakerTeam() {
        return getTeamStrength(teamOne) > getTeamStrength(teamTwo) ? teamTwo : teamOne;
    }

    public double getTeamStrength(TeamOnScoreboard teamOnScoreboard) {
        CheckStrength checkStrength = new CheckStrength();
        return checkStrength.teamStrength(teamOnScoreboard.getTeam());
    }

    public void updateScores(TeamOnScoreboard gameWinner, TeamOnScoreboard gameLoser) {
        gameWinner.setScore(gameWinner.getScore() + 2);
        gameLoser.setScore(gameLoser.getScore() - 2);
        gameLoser.setLossPointsForTrade(gameLoser.getLossPointsForTrade() + 2);
        gameLoser.setLossPoints(gameLoser.getLossPoints() + 2);
    }

    public TeamOnScoreboard getTeamOne() {
        return teamOne;
    }

    public TeamOnScoreboard getTeamTwo() {
        return teamTwo;
    }

}
