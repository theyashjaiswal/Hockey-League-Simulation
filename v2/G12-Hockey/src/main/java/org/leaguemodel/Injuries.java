package org.leaguemodel;

import org.leaguemodel.interfaces.IInjuries;

public class Injuries implements IInjuries {

    private Double randomInjuryChance;
    private Integer injuryDaysLow;
    private Integer injuryDaysHigh;

    @Override
    public Double getRandomInjuryChance() {
        return randomInjuryChance;
    }

    @Override
    public void setRandomInjuryChance(Double randomInjuryChance) {
        this.randomInjuryChance = randomInjuryChance;
    }

    @Override
    public Integer getInjuryDaysLow() {
        return injuryDaysLow;
    }

    @Override
    public void setInjuryDaysLow(Integer injuryDaysLow) {
        this.injuryDaysLow = injuryDaysLow;
    }

    @Override
    public Integer getInjuryDaysHigh() {
        return injuryDaysHigh;
    }

    @Override
    public void setInjuryDaysHigh(Integer injuryDaysHigh) {
        this.injuryDaysHigh = injuryDaysHigh;
    }

}
