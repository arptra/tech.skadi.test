package com.meizu.common.datetimepicker.date;

import java.util.Calendar;

public interface DatePickerController {
    int getFirstDayOfWeek();

    Calendar getMaxDate();

    int getMaxYear();

    Calendar getMinDate();

    int getMinYear();

    CalendarDay getSelectedDay();

    void onDayOfMonthSelected(int i, int i2, int i3);

    void onYearSelected(int i);

    void registerOnDateChangedListener(OnDateChangedListener onDateChangedListener);

    void tryVibrate();

    void unregisterOnDateChangedListener(OnDateChangedListener onDateChangedListener);
}
