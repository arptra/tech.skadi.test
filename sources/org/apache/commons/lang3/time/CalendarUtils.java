package org.apache.commons.lang3.time;

import java.util.Calendar;
import java.util.Objects;

public class CalendarUtils {
    public static final CalendarUtils INSTANCE = new CalendarUtils(Calendar.getInstance());
    private final Calendar calendar;

    public CalendarUtils(Calendar calendar2) {
        Objects.requireNonNull(calendar2, "calendar");
        this.calendar = calendar2;
    }

    public int getDayOfMonth() {
        return this.calendar.get(5);
    }

    public int getMonth() {
        return this.calendar.get(2);
    }

    public int getYear() {
        return this.calendar.get(1);
    }
}
