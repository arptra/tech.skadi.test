package com.meizu.common.datetimepicker.date;

import android.text.format.Time;
import java.util.Calendar;

public class CalendarDay {
    private Calendar calendar;
    int day;
    int month;
    private Time time;
    int year;

    public CalendarDay() {
        setTime(System.currentTimeMillis());
    }

    private void setTime(long j) {
        if (this.calendar == null) {
            this.calendar = Calendar.getInstance();
        }
        this.calendar.setTimeInMillis(j);
        this.month = this.calendar.get(2);
        this.year = this.calendar.get(1);
        this.day = this.calendar.get(5);
    }

    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    public void set(CalendarDay calendarDay) {
        this.year = calendarDay.year;
        this.month = calendarDay.month;
        this.day = calendarDay.day;
    }

    public void setDay(int i, int i2, int i3) {
        this.year = i;
        this.month = i2;
        this.day = i3;
    }

    public synchronized void setJulianDay(int i) {
        try {
            if (this.time == null) {
                this.time = new Time();
            }
            this.time.setJulianDay(i);
            setTime(this.time.toMillis(false));
        } catch (Throwable th) {
            throw th;
        }
    }

    public CalendarDay(long j) {
        setTime(j);
    }

    public CalendarDay(Calendar calendar2) {
        this.year = calendar2.get(1);
        this.month = calendar2.get(2);
        this.day = calendar2.get(5);
    }

    public CalendarDay(int i, int i2, int i3) {
        setDay(i, i2, i3);
    }
}
