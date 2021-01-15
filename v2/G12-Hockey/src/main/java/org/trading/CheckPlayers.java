package org.trading;

import org.leaguemodel.interfaces.ITeam;
import org.trading.interfaces.ICheckPlayers;

import java.util.Collections;

public class CheckPlayers implements ICheckPlayers {

    enum enumPosition {
        goalie, forward, defense;
    };

    public void Captain(ITeam team) {
        Collections.sort(team.getPlayers(), new StatsComparator());
        for (int i = 0; i < team.getPlayers().size(); i++) {
            team.getPlayers().get(i).setIsCaptain(false);
        }
        team.getPlayers().get(0).setIsCaptain(true);
    }

    public int goalies(ITeam team) {
        int goaliesSize = 0;
        for (int i = 0; i < team.getPlayers().size(); i++) {
            if (team.getPlayers().get(i).getPlayerPosition().equalsIgnoreCase(enumPosition.goalie.toString())) {
                goaliesSize++;
            } else {
                continue;
            }
        }
        return goaliesSize;
    }

    public int skaters(ITeam team) {
        int skatersSize = 0;
        for (int i = 0; i < team.getPlayers().size(); i++) {
            if (team.getPlayers().get(i).getPlayerPosition().equalsIgnoreCase(enumPosition.forward.toString()) || team.getPlayers().get(i).getPlayerPosition().equalsIgnoreCase(enumPosition.defense.toString())) {
                skatersSize++;
            } else {
                continue;
            }
        }
        return skatersSize;
    }
}
