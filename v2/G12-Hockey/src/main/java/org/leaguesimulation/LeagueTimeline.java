package org.leaguesimulation;

import org.leaguesimulation.interfaces.ILeagueDate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

import static java.time.temporal.ChronoUnit.DAYS;

public class LeagueTimeline {
    LocalDate seasonStart;
    LocalDate playOffStartDate;
    LocalDate seasonEnd;
    LocalDate currentDate;

    public LeagueTimeline(LocalDate seasonStart) {
        this.seasonStart = seasonStart;
        this.currentDate = seasonStart;
        this.seasonEnd = getEndOfSeasonDate();
    }

    public void setCurrentDate(LocalDate currentDate) {
        this.currentDate = currentDate;
    }

    public void setPlayOffStartDate(LocalDate playOffStartDate) {
        this.playOffStartDate = playOffStartDate;
    }

    public LocalDate getTradeDeadline() {
        LocalDate temporalDate = LocalDate.of(seasonStart.getYear() + LeagueSimulationConstants.ONE, Month.FEBRUARY, LeagueSimulationConstants.ONE);
        LocalDate tradeDeadline = temporalDate.with(TemporalAdjusters.lastInMonth(DayOfWeek.MONDAY));
        return tradeDeadline;
    }

    public LocalDate getEndOfRegularSeason() {
        LocalDate temporalDate = LocalDate.of(seasonStart.getYear() + LeagueSimulationConstants.ONE, Month.APRIL, LeagueSimulationConstants.ONE);
        LocalDate endOfRegularSeasonDate = temporalDate.with(TemporalAdjusters.firstInMonth(DayOfWeek.SATURDAY));
        return endOfRegularSeasonDate;
    }

    public LocalDate getEndOfSeasonDate() {
        return LocalDate.of(seasonStart.plusYears(LeagueSimulationConstants.ONE).getYear(), Month.JUNE, LeagueSimulationConstants.ONE);
    }

    public LocalDate getPlayOffStartDate() {
        LocalDate temporalDate = LocalDate.of(seasonStart.getYear() + LeagueSimulationConstants.ONE, Month.APRIL, LeagueSimulationConstants.ONE);
        playOffStartDate = temporalDate.with(TemporalAdjusters.dayOfWeekInMonth(LeagueSimulationConstants.TWO, DayOfWeek.WEDNESDAY));
        return playOffStartDate;
    }

    public boolean isTradePossible() {
        return getTradeDeadline().isAfter(currentDate) || getTradeDeadline().equals(currentDate);
    }

    public boolean isRegularSeason() {
        return getEndOfRegularSeason().isAfter(currentDate) || getEndOfRegularSeason().equals(currentDate);
    }

    public int daysLeftOfRegularSeason() {
        return daysBetweenDates(currentDate, getEndOfRegularSeason());
    }

    public int daysLeftOfPlayOffSeason() {
        return daysBetweenDates(currentDate, getEndOfSeasonDate());
    }


    public int daysBetweenDates(LocalDate dateFrom, LocalDate dateUpto) {
        return (int) DAYS.between(dateFrom, dateUpto) + LeagueSimulationConstants.ONE;
    }

    public int daysOfPlayOff() {
        return daysBetweenDates(playOffStartDate, getEndOfSeasonDate());
    }

    public LocalDate getCurrentDate() {
        return currentDate;
    }

    public LocalDate incrementDateByOne() {
        currentDate = currentDate.plusDays(LeagueSimulationConstants.ONE);
        return currentDate;
    }

    public int daysPassedInLeague() {
        return daysBetweenDates(seasonStart, currentDate);
    }

    public void setCurrentDateFromDB(String leagueName){
        ILeagueDate leagueDateFromDB = new LeagueDateFromDB(leagueName);
        currentDate = leagueDateFromDB.getLeagueDate();
    }

}
