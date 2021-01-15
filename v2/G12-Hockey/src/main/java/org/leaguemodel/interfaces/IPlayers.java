package org.leaguemodel.interfaces;

public interface IPlayers {
    Integer getSaving();

    void setSaving(Integer saving);

    void setCaptain(boolean isCaptain);

    String getPlayerPosition();

    void setPlayerPosition(String playerPosition);

    String getPlayerName();

    void setPlayerName(String playerName);

    boolean isCaptain();

    void setIsCaptain(boolean captain);

    Integer getAge();

    void setAge(Integer age);

    Integer getSkating();

    void setSkating(Integer skating);

    Integer getShooting();

    void setShooting(Integer shooting);

    Integer getChecking();

    void setChecking(Integer checking);

    int getNoOfDaysInjured();

    void setNoOfDaysInjured(int noOfDaysInjured);

    boolean isRetired();

    void setRetired(boolean retired);
}
