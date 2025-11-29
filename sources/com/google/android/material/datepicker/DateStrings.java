package com.google.android.material.datepicker;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import com.google.android.material.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

class DateStrings {
    private DateStrings() {
    }

    public static Pair<String, String> getDateRangeString(@Nullable Long l, @Nullable Long l2) {
        return getDateRangeString(l, l2, (SimpleDateFormat) null);
    }

    public static String getDateString(long j) {
        return getDateString(j, (SimpleDateFormat) null);
    }

    public static String getDayContentDescription(Context context, long j, boolean z, boolean z2, boolean z3) {
        String optionalYearMonthDayOfWeekDay = getOptionalYearMonthDayOfWeekDay(j);
        if (z) {
            optionalYearMonthDayOfWeekDay = String.format(context.getString(R.string.mtrl_picker_today_description), new Object[]{optionalYearMonthDayOfWeekDay});
        }
        return z2 ? String.format(context.getString(R.string.mtrl_picker_start_date_description), new Object[]{optionalYearMonthDayOfWeekDay}) : z3 ? String.format(context.getString(R.string.mtrl_picker_end_date_description), new Object[]{optionalYearMonthDayOfWeekDay}) : optionalYearMonthDayOfWeekDay;
    }

    public static String getMonthDay(long j) {
        return getMonthDay(j, Locale.getDefault());
    }

    public static String getMonthDayOfWeekDay(long j) {
        return getMonthDayOfWeekDay(j, Locale.getDefault());
    }

    public static String getOptionalYearMonthDayOfWeekDay(long j) {
        return isDateWithinCurrentYear(j) ? getMonthDayOfWeekDay(j) : getYearMonthDayOfWeekDay(j);
    }

    public static String getYearContentDescription(Context context, int i) {
        return UtcDates.getTodayCalendar().get(1) == i ? String.format(context.getString(R.string.mtrl_picker_navigate_to_current_year_description), new Object[]{Integer.valueOf(i)}) : String.format(context.getString(R.string.mtrl_picker_navigate_to_year_description), new Object[]{Integer.valueOf(i)});
    }

    public static String getYearMonth(long j) {
        return UtcDates.getYearMonthFormat(Locale.getDefault()).format(new Date(j));
    }

    public static String getYearMonthDay(long j) {
        return getYearMonthDay(j, Locale.getDefault());
    }

    public static String getYearMonthDayOfWeekDay(long j) {
        return getYearMonthDayOfWeekDay(j, Locale.getDefault());
    }

    private static boolean isDateWithinCurrentYear(long j) {
        Calendar todayCalendar = UtcDates.getTodayCalendar();
        Calendar utcCalendar = UtcDates.getUtcCalendar();
        utcCalendar.setTimeInMillis(j);
        return todayCalendar.get(1) == utcCalendar.get(1);
    }

    public static Pair<String, String> getDateRangeString(@Nullable Long l, @Nullable Long l2, @Nullable SimpleDateFormat simpleDateFormat) {
        if (l == null && l2 == null) {
            return Pair.a((Object) null, (Object) null);
        }
        if (l == null) {
            return Pair.a((Object) null, getDateString(l2.longValue(), simpleDateFormat));
        }
        if (l2 == null) {
            return Pair.a(getDateString(l.longValue(), simpleDateFormat), (Object) null);
        }
        Calendar todayCalendar = UtcDates.getTodayCalendar();
        Calendar utcCalendar = UtcDates.getUtcCalendar();
        utcCalendar.setTimeInMillis(l.longValue());
        Calendar utcCalendar2 = UtcDates.getUtcCalendar();
        utcCalendar2.setTimeInMillis(l2.longValue());
        if (simpleDateFormat != null) {
            return Pair.a(simpleDateFormat.format(new Date(l.longValue())), simpleDateFormat.format(new Date(l2.longValue())));
        } else if (utcCalendar.get(1) != utcCalendar2.get(1)) {
            return Pair.a(getYearMonthDay(l.longValue(), Locale.getDefault()), getYearMonthDay(l2.longValue(), Locale.getDefault()));
        } else {
            if (utcCalendar.get(1) == todayCalendar.get(1)) {
                return Pair.a(getMonthDay(l.longValue(), Locale.getDefault()), getMonthDay(l2.longValue(), Locale.getDefault()));
            }
            return Pair.a(getMonthDay(l.longValue(), Locale.getDefault()), getYearMonthDay(l2.longValue(), Locale.getDefault()));
        }
    }

    public static String getDateString(long j, @Nullable SimpleDateFormat simpleDateFormat) {
        if (simpleDateFormat != null) {
            return simpleDateFormat.format(new Date(j));
        }
        if (isDateWithinCurrentYear(j)) {
            return getMonthDay(j);
        }
        return getYearMonthDay(j);
    }

    public static String getMonthDay(long j, Locale locale) {
        return UtcDates.getAbbrMonthDayFormat(locale).format(new Date(j));
    }

    public static String getMonthDayOfWeekDay(long j, Locale locale) {
        return UtcDates.getMonthWeekdayDayFormat(locale).format(new Date(j));
    }

    public static String getYearMonthDay(long j, Locale locale) {
        return UtcDates.getYearAbbrMonthDayFormat(locale).format(new Date(j));
    }

    public static String getYearMonthDayOfWeekDay(long j, Locale locale) {
        return UtcDates.getYearMonthWeekdayDayFormat(locale).format(new Date(j));
    }
}
