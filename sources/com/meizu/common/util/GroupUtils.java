package com.meizu.common.util;

import android.database.Cursor;
import android.text.format.Time;
import android.util.Log;
import java.util.List;

public class GroupUtils {
    private static final int DATE_TYPE_LENGTH = 6;
    private static final int DEFAULT_DATE = -1;
    public static final int FORMER_YEAR = 5;
    public static final int FUTURE = 0;
    private static final int SPECIFIED_DATE_GROUP_LENGTH = 4;
    public static final int SPECIFIED_FUTURE = 0;
    public static final int SPECIFIED_OTHER = 3;
    public static final int SPECIFIED_THIS_MONTH = 2;
    public static final int SPECIFIED_THIS_WEEK = 1;
    public static final int THIS_MONTH = 3;
    public static final int THIS_WEEK = 2;
    public static final int THIS_YEAR = 4;
    public static final int TODAY = 1;
    public static final int TYPE_FWMO = 0;

    private static int checkDateType(long j, Time time, Time time2, long j2) {
        time.set(j);
        int i = time.year;
        int i2 = time2.year;
        if (i < i2) {
            return 5;
        }
        int i3 = j > j2 ? 0 : -1;
        if (i == i2) {
            i3 = time.month == time2.month ? 3 : 4;
        }
        int i4 = time2.yearDay - time2.weekDay;
        int i5 = i4 + 7;
        int i6 = time.yearDay;
        return (i6 < i4 || i6 >= i5) ? i3 : time.monthDay == time2.monthDay ? 1 : 2;
    }

    public static int[] getGroupCountsByCursor(Cursor cursor, int i) {
        return getGroupCountsByCursor(cursor, i, 0, cursor.getCount() - 1);
    }

    public static int[] getGroupCountsByList(List<Long> list) {
        return getGroupCountsByList(list, 0, list.size() - 1);
    }

    public static int[] getSpecifiedGroupCounts(int i, Cursor cursor, int i2, int i3, int i4) {
        int[] groupCountsByCursor = getGroupCountsByCursor(cursor, i2, i3, i4);
        return new int[]{groupCountsByCursor[0], groupCountsByCursor[1] + groupCountsByCursor[2], groupCountsByCursor[3], groupCountsByCursor[4] + groupCountsByCursor[5]};
    }

    private static void signDateCount(int i, int[] iArr) {
        if (i == 0) {
            iArr[0] = iArr[0] + 1;
        } else if (i == 1) {
            iArr[1] = iArr[1] + 1;
        } else if (i == 2) {
            iArr[2] = iArr[2] + 1;
        } else if (i == 3) {
            iArr[3] = iArr[3] + 1;
        } else if (i == 4) {
            iArr[4] = iArr[4] + 1;
        } else if (i == 5) {
            iArr[5] = iArr[5] + 1;
        }
    }

    public static int[] getGroupCountsByCursor(Cursor cursor, int i, int i2, int i3) {
        if (i2 > i3) {
            Log.e("Error", "getGroupConntByCursor startPos > endPos error");
            return null;
        }
        int[] iArr = new int[6];
        Time time = new Time();
        Time time2 = new Time();
        long currentTimeMillis = System.currentTimeMillis();
        time2.set(currentTimeMillis);
        if (cursor.moveToPosition(i2)) {
            do {
                signDateCount(checkDateType(cursor.getLong(i), time, time2, currentTimeMillis), iArr);
                if (cursor.getPosition() == i3) {
                    break;
                }
            } while (cursor.moveToNext());
        }
        return iArr;
    }

    public static int[] getGroupCountsByList(List<Long> list, int i, int i2) {
        if (i > i2) {
            Log.e("Error", "getGroupConntByCursor startPos > endPos error");
            return null;
        }
        int[] iArr = new int[6];
        Time time = new Time();
        Time time2 = new Time();
        long currentTimeMillis = System.currentTimeMillis();
        time2.set(currentTimeMillis);
        while (i <= i2) {
            signDateCount(checkDateType(list.get(i).longValue(), time, time2, currentTimeMillis), iArr);
            i++;
        }
        return iArr;
    }

    public static int[] getSpecifiedGroupCounts(int i, Cursor cursor, int i2) {
        return getSpecifiedGroupCounts(i, cursor, i2, 0, cursor.getCount() - 1);
    }

    public static int[] getSpecifiedGroupCounts(int i, List<Long> list, int i2, int i3) {
        int[] groupCountsByList = getGroupCountsByList(list, i2, i3);
        return new int[]{groupCountsByList[0], groupCountsByList[1] + groupCountsByList[2], groupCountsByList[3], groupCountsByList[4] + groupCountsByList[5]};
    }

    public static int[] getSpecifiedGroupCounts(int i, List<Long> list) {
        return getSpecifiedGroupCounts(i, list, 0, list.size() - 1);
    }
}
