package org.leaguemodel;

import org.leaguemodel.interfaces.IHeadCoach;

public class HeadCoach implements IHeadCoach {

    private String name;
    private Double skating;
    private Double shooting;
    private Double checking;
    private Double saving;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Double getSkating() {
        return skating;
    }

    @Override
    public void setSkating(Double skating) {
        this.skating = skating;
    }

    @Override
    public Double getShooting() {
        return shooting;
    }

    @Override
    public void setShooting(Double shooting) {
        this.shooting = shooting;
    }

    @Override
    public Double getChecking() {
        return checking;
    }

    @Override
    public void setChecking(Double checking) {
        this.checking = checking;
    }

    @Override
    public Double getSaving() {
        return saving;
    }

    @Override
    public void setSaving(Double saving) {
        this.saving = saving;
    }

}
