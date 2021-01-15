package org.leaguemodel;

import org.leaguemodel.interfaces.ITraining;

public class Training implements ITraining {

    private Integer daysUntilStatIncreaseCheck;

    @Override
    public Integer getDaysUntilStatIncreaseCheck() {
        return daysUntilStatIncreaseCheck;
    }

    @Override
    public void setDaysUntilStatIncreaseCheck(Integer daysUntilStatIncreaseCheck) {
        this.daysUntilStatIncreaseCheck = daysUntilStatIncreaseCheck;
    }

}
