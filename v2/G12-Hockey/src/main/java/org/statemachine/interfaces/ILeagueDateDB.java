package org.statemachine.interfaces;

import java.sql.Date;
import java.time.LocalDate;

public interface ILeagueDateDB {
    Date getCurrentDate();
    void setCurrentDate(LocalDate date);
}
