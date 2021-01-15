package org.trading;

import org.apache.commons.lang3.StringUtils;
import org.leaguemodel.FreeAgents;
import org.leaguemodel.Players;
import org.leaguemodel.interfaces.ILeague;
import org.leaguemodel.interfaces.IPlayers;
import org.leaguemodel.interfaces.ITeam;
import org.trading.interfaces.IBalance;
import org.trading.interfaces.ICheckPlayers;
import org.trading.interfaces.IDisplayTrade;

import java.util.Collections;
import java.util.List;

public class Balance implements IBalance {

    enum enumPosition {
        goalie, forward, defense
    }
    enum enumTeamType {
        AI, User
    }
    final static int constTeamSizeNum = 20;
    final static int constSkaterSizeNum = 18;
    final static int constGoalieSizeNum = 2;
    final static int constZero = 0;


    public void balanceTeams(ITeam team, ILeague leagueObj) {
        ICheckPlayers check = new CheckPlayers();
        IDisplayTrade display = new DisplayTrade();
        for (int i = 0; i < leagueObj.getFreeAgents().size(); i++) {
            Collections.sort(leagueObj.getFreeAgents(), new StatsComparator());
        }
        if (StringUtils.equalsIgnoreCase(team.getTeamType(), enumTeamType.AI.toString())) {
            if (team.getPlayers().size() <= constTeamSizeNum) {
                int countGoalie = constGoalieSizeNum - check.goalies(team);
                int countSkaters = constSkaterSizeNum - check.skaters(team);
                if (countGoalie < constGoalieSizeNum) {
                    addFromFreeAgent(team, leagueObj, enumPosition.goalie.toString(), countGoalie);
                }
                if (countSkaters < constSkaterSizeNum) {
                    addFromFreeAgent(team, leagueObj, enumPosition.forward.toString(), countSkaters);
                    if (team.getPlayers().size() < constTeamSizeNum) {
                        countSkaters = constTeamSizeNum - team.getPlayers().size();
                        addFromFreeAgent(team, leagueObj, enumPosition.defense.toString(), countSkaters);
                    }
                }
            }
            if (team.getPlayers().size() >= constTeamSizeNum) {
                int countGoalie = check.goalies(team);
                int countSkaters = check.skaters(team);
                if (countGoalie < constGoalieSizeNum) {
                    addFromFreeAgent(team, leagueObj, enumPosition.goalie.toString(), constGoalieSizeNum - countGoalie);
                    countGoalie = constGoalieSizeNum;
                }
                if (countGoalie > constGoalieSizeNum) {
                    removeFromTeam(team, leagueObj, enumPosition.goalie.toString(), countGoalie);
                } else if (countGoalie == constGoalieSizeNum) {
                    if (team.getPlayers().size() > constTeamSizeNum) {
                        removeFromTeam(team, leagueObj, enumPosition.forward.toString(), countSkaters);
                        if (team.getPlayers().size() > constTeamSizeNum) {
                            countSkaters = team.getPlayers().size() - constTeamSizeNum;
                            removeFromTeam(team, leagueObj, enumPosition.defense.toString(), countSkaters);
                        }
                    }
                }
            }
        }
        if(StringUtils.equalsIgnoreCase(team.getTeamType(), enumTeamType.User.toString())) {
            boolean goaliesNotBalanced = true;
            boolean skatersNotBalanced = true;
            boolean start = true;
            if (check.goalies(team) == constGoalieSizeNum && check.skaters(team) == constSkaterSizeNum) {
                start = false;
            }
            if (start) {
                while (goaliesNotBalanced && skatersNotBalanced) {
                    if (team.getPlayers().size() <= constTeamSizeNum) {
                        Collections.sort(team.getPlayers(), new StatsComparator());
                        int freeAgentIndex = display.displayFreeAgents(team, leagueObj);
                        addUserTeam(team, leagueObj, freeAgentIndex - 1);
                    }
                    if (team.getPlayers().size() >= constTeamSizeNum) {
                        Collections.sort(team.getPlayers(), new StatsComparator());
                        int playerDropIndex = display.displayPlayerList(team);
                        removeUserTeam(team, leagueObj, playerDropIndex - 1);
                    }
                    if (check.goalies(team) == constGoalieSizeNum && check.skaters(team) == constSkaterSizeNum) {
                        goaliesNotBalanced = false;
                        skatersNotBalanced = false;
                    }
                }
            }
        }
    }

    public void addFromFreeAgent(ITeam team, ILeague leagueObj, String playerPosition, int count) {
        List<IPlayers> fr = leagueObj.getFreeAgents();
        IPlayers players = new Players();
        List<IPlayers> pl = team.getPlayers();

        for (int j = 0; j < fr.size(); j++) {
            if (StringUtils.equalsIgnoreCase(fr.get(j).getPlayerPosition(), playerPosition) && count > constZero) {
                players.setPlayerName(fr.get(j).getPlayerName());
                players.setPlayerPosition(playerPosition);
                players.setIsCaptain(false);
                players.setAge(fr.get(j).getAge());
                players.setSkating(fr.get(j).getSkating());
                players.setShooting(fr.get(j).getShooting());
                players.setChecking(fr.get(j).getChecking());
                players.setSaving(fr.get(j).getSaving());
                pl.add(players);
                fr.remove(fr.get(j));
                team.setPlayers(pl);
                count--;
            }
        }
    }

    public void removeFromTeam(ITeam team, ILeague leagueObj, String playerPosition, int count) {

        List<IPlayers> pl = team.getPlayers();
        IPlayers fr = new FreeAgents();
        List<IPlayers> frList = leagueObj.getFreeAgents();
        for (int j = 0; j < pl.size(); j++) {
            if ((StringUtils.equalsIgnoreCase(pl.get(j).getPlayerPosition(), playerPosition) && count > constSkaterSizeNum) ||
                    (StringUtils.equalsIgnoreCase(pl.get(j).getPlayerPosition(), enumPosition.goalie.toString()) && count > constGoalieSizeNum)
                            && team.getPlayers().size() > constTeamSizeNum) {
                fr.setPlayerName(pl.get(j).getPlayerName());
                fr.setPlayerPosition(playerPosition);
                fr.setAge(pl.get(j).getAge());
                fr.setSkating(pl.get(j).getSkating());
                fr.setShooting(pl.get(j).getShooting());
                fr.setChecking(pl.get(j).getChecking());
                fr.setSaving(pl.get(j).getSaving());
                frList.add(fr);
                pl.remove(pl.get(j));
                leagueObj.setFreeAgents(frList);
                count--;
            }
        }
    }

    public void addUserTeam(ITeam team, ILeague leagueObj, int freeAgentNum) {
        List<IPlayers> fr = leagueObj.getFreeAgents();
        IPlayers players = new Players();
        List<IPlayers> pl = team.getPlayers();
        players.setPlayerName(fr.get(freeAgentNum).getPlayerName());
        players.setPlayerPosition(fr.get(freeAgentNum).getPlayerPosition());
        players.setIsCaptain(false);
        players.setAge(fr.get(freeAgentNum).getAge());
        players.setSkating(fr.get(freeAgentNum).getSkating());
        players.setShooting(fr.get(freeAgentNum).getShooting());
        players.setChecking(fr.get(freeAgentNum).getChecking());
        players.setSaving(fr.get(freeAgentNum).getSaving());
        pl.add(players);
        fr.remove(fr.get(freeAgentNum));
        team.setPlayers(pl);
    }

    public void removeUserTeam(ITeam team, ILeague leagueObj, int playerNum) {
        List<IPlayers> pl = team.getPlayers();
        IPlayers fr = new FreeAgents();
        List<IPlayers> frList = leagueObj.getFreeAgents();
        fr.setPlayerName(pl.get(playerNum).getPlayerName());
        fr.setPlayerPosition(pl.get(playerNum).getPlayerPosition());
        fr.setAge(pl.get(playerNum).getAge());
        fr.setSkating(pl.get(playerNum).getSkating());
        fr.setShooting(pl.get(playerNum).getShooting());
        fr.setChecking(pl.get(playerNum).getChecking());
        fr.setSaving(pl.get(playerNum).getSaving());
        frList.add(fr);
        pl.remove(pl.get(playerNum));
        leagueObj.setFreeAgents(frList);
    }

}

