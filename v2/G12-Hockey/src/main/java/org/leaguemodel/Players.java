package org.leaguemodel;

import org.leaguemodel.interfaces.IPlayers;
import org.leaguemodel.interfaces.IStrength;

public class Players implements IStrength, IPlayers {

    private String playerPosition;
    private String playerName;
    private boolean isCaptain;
    private Integer age;
    private Integer skating;
    private Integer shooting;
    private Integer checking;
    private Integer saving;
    private boolean isRetired;
    private int noOfDaysInjured;

    public Players() {
        this.playerPosition = null;
        this.playerName = null;
        this.isCaptain = false;
        this.isRetired = false;
        this.noOfDaysInjured = -1;
    }

    public Players(String playerPosition, String playerName, boolean captain) {

        this.playerPosition = playerPosition;
        this.playerName = playerName;
        isCaptain = captain;
    }

    public Players(String playerPosition, String playerName, boolean isCaptain, Integer age, Integer skating, Integer shooting, Integer checking, Integer saving) {
        this(playerPosition, playerName, age, skating, shooting, checking, saving);
        this.isCaptain = isCaptain;
    }

    public Players(String playerPosition, String playerName, Integer age, Integer skating, Integer shooting, Integer checking, Integer saving) {
        this.playerPosition = playerPosition;
        this.playerName = playerName;
        this.age = age;
        this.skating = skating;
        this.shooting = shooting;
        this.checking = checking;
        this.saving = saving;
        this.isRetired = false;
        this.noOfDaysInjured = -1;
    }

    @Override
    public Integer getSaving() {
        return saving;
    }

    @Override
    public void setSaving(Integer saving) {
        this.saving = saving;
    }

    @Override
    public void setCaptain(boolean isCaptain) {
        this.isCaptain = isCaptain;
    }

    @Override
    public String getPlayerPosition() {
        return playerPosition;
    }

    @Override
    public void setPlayerPosition(String playerPosition) {
        this.playerPosition = playerPosition;
    }

    @Override
    public String getPlayerName() {
        return playerName;
    }

    @Override
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public boolean isCaptain() {
        return isCaptain;
    }

    @Override
    public void setIsCaptain(boolean captain) {
        isCaptain = captain;
    }

    @Override
    public Integer getAge() {
        return age;
    }

    @Override
    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public Integer getSkating() {
        return skating;
    }

    @Override
    public void setSkating(Integer skating) {
        this.skating = skating;
    }

    @Override
    public Integer getShooting() {
        return shooting;
    }

    @Override
    public void setShooting(Integer shooting) {
        this.shooting = shooting;
    }

    @Override
    public Integer getChecking() {
        return checking;
    }

    @Override
    public void setChecking(Integer checking) {
        this.checking = checking;
    }

    public boolean isRetired() {
        return isRetired;
    }

    public void setRetired(boolean retired) {
        isRetired = retired;
    }

    @Override
    public int getNoOfDaysInjured() {
        return noOfDaysInjured;
    }

    @Override
    public void setNoOfDaysInjured(int noOfDaysInjured) {
        this.noOfDaysInjured = noOfDaysInjured;
    }
}

