package org.leaguemodel;

import org.leaguemodel.interfaces.IAging;

public class Aging implements IAging {

    private Integer averageRetirementAge;
    private Integer maximumAge;

    @Override
    public Integer getAverageRetirementAge() {
        return averageRetirementAge;
    }

    @Override
    public void setAverageRetirementAge(Integer averageRetirementAge) {
        this.averageRetirementAge = averageRetirementAge;
    }

    @Override
    public Integer getMaximumAge() {
        return maximumAge;
    }

    @Override
    public void setMaximumAge(Integer maximumAge) {
        this.maximumAge = maximumAge;
    }

}
