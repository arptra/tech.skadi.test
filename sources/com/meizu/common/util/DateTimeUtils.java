package com.meizu.common.util;

import android.content.Context;
import android.text.format.Time;
import com.meizu.common.R;
import java.util.Calendar;

public class DateTimeUtils {
    public static final int FORMAT_TYPE_APP_VERSIONS = 7;
    public static final int FORMAT_TYPE_CALENDAR_APPWIDGET = 8;
    public static final int FORMAT_TYPE_CALL_LOGS = 5;
    public static final int FORMAT_TYPE_CALL_LOGS_NEW = 11;
    public static final int FORMAT_TYPE_CONTACTS_BIRTHDAY_MD = 10;
    public static final int FORMAT_TYPE_CONTACTS_BIRTHDAY_YMD = 9;
    public static final int FORMAT_TYPE_EMAIL = 2;
    public static final int FORMAT_TYPE_MMS = 1;
    public static final int FORMAT_TYPE_NORMAL = 0;
    public static final int FORMAT_TYPE_PERSONAL_FOOTPRINT = 6;
    public static final int FORMAT_TYPE_RECORDER = 3;
    public static final int FORMAT_TYPE_RECORDER_PHONE = 4;
    public static final int FORMAT_TYPE_SIMPLE = 12;
    private static String FormatResultLast = null;
    private static int FormatTypeLast = -1;
    private static final int MILLISECONDS_OF_HOUR = 3600000;
    private static long NowMillisLast;
    private static Time NowTimeLast;
    private static Time ThenTimeLast;

    public static String formatTimeStampString(Context context, long j, boolean z) {
        return formatTimeStampString(context, j, 0, z);
    }

    public static String getWeek(Context context, int i, int i2, int i3) {
        Calendar instance = Calendar.getInstance();
        instance.set(i, i2, i3);
        int i4 = instance.get(7) - 1;
        String[] stringArray = context.getResources().getStringArray(R.array.mc_custom_weekday);
        return (i4 < 0 || i4 >= stringArray.length) ? "" : stringArray[i4];
    }

    public static String formatTimeStampString(Context context, long j, int i, boolean z) {
        return formatTimeStampString(context, j, i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x01bd  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x01db  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x01f9  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x023b  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x0268  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x031a  */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x03d0  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:293:0x0451  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:323:0x04c6  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:362:0x0596  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00bf A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00c1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String formatTimeStampString(android.content.Context r18, long r19, int r21) {
        /*
            r0 = r19
            r2 = r21
            android.text.format.Time r3 = new android.text.format.Time
            r3.<init>()
            r3.set(r0)
            long r4 = java.lang.System.currentTimeMillis()
            boolean r6 = android.text.format.DateFormat.is24HourFormat(r18)
            int r7 = FormatTypeLast
            if (r2 != r7) goto L_0x001a
            r7 = 1
            goto L_0x001b
        L_0x001a:
            r7 = 0
        L_0x001b:
            FormatTypeLast = r2
            android.text.format.Time r10 = NowTimeLast
            if (r10 != 0) goto L_0x0023
        L_0x0021:
            r11 = 0
            goto L_0x0032
        L_0x0023:
            long r11 = NowMillisLast
            int r13 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r13 < 0) goto L_0x0021
            r13 = 86400000(0x5265c00, double:4.2687272E-316)
            long r11 = r11 + r13
            int r11 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r11 >= 0) goto L_0x0021
            r11 = 1
        L_0x0032:
            if (r11 != 0) goto L_0x0055
            android.text.format.Time r10 = new android.text.format.Time
            r10.<init>()
            r10.set(r4)
            NowTimeLast = r10
            int r12 = r10.hour
            r13 = 3600000(0x36ee80, float:5.044674E-39)
            int r12 = r12 * r13
            int r13 = r10.minute
            r14 = 60000(0xea60, float:8.4078E-41)
            int r13 = r13 * r14
            int r12 = r12 + r13
            int r13 = r10.second
            int r13 = r13 * 1000
            int r12 = r12 + r13
            long r12 = (long) r12
            long r12 = r4 - r12
            NowMillisLast = r12
        L_0x0055:
            android.text.format.Time r12 = ThenTimeLast
            if (r12 == 0) goto L_0x0067
            int r13 = r12.year
            int r14 = r3.year
            if (r13 != r14) goto L_0x0067
            int r13 = r12.yearDay
            int r14 = r3.yearDay
            if (r13 != r14) goto L_0x0067
            r13 = 1
            goto L_0x0068
        L_0x0067:
            r13 = 0
        L_0x0068:
            if (r12 == 0) goto L_0x0078
            int r14 = r12.year
            int r15 = r3.year
            if (r14 != r15) goto L_0x0078
            int r12 = r12.month
            int r14 = r3.month
            if (r12 != r14) goto L_0x0078
            r12 = 1
            goto L_0x0079
        L_0x0078:
            r12 = 0
        L_0x0079:
            ThenTimeLast = r3
            int r14 = r10.yearDay
            int r15 = r10.weekDay
            int r15 = r14 - r15
            int r8 = r3.year
            int r9 = r10.year
            if (r8 > r9) goto L_0x008a
            r17 = 1
            goto L_0x008c
        L_0x008a:
            r17 = 0
        L_0x008c:
            if (r9 != r8) goto L_0x0094
            int r8 = r3.yearDay
            if (r8 > r14) goto L_0x0094
            r8 = 1
            goto L_0x0095
        L_0x0094:
            r8 = 0
        L_0x0095:
            if (r8 == 0) goto L_0x009d
            int r9 = r3.yearDay
            if (r9 != r14) goto L_0x009d
            r9 = 1
            goto L_0x009e
        L_0x009d:
            r9 = 0
        L_0x009e:
            if (r8 == 0) goto L_0x00a8
            int r0 = r3.yearDay
            int r1 = r14 + -1
            if (r0 != r1) goto L_0x00a8
            r0 = 1
            goto L_0x00a9
        L_0x00a8:
            r0 = 0
        L_0x00a9:
            if (r8 == 0) goto L_0x00b4
            int r1 = r3.yearDay
            if (r1 < r15) goto L_0x00b4
            if (r1 >= r14) goto L_0x00b4
            r16 = 1
            goto L_0x00b6
        L_0x00b4:
            r16 = 0
        L_0x00b6:
            android.content.res.Resources r1 = r18.getResources()
            java.lang.String r14 = " "
            switch(r2) {
                case 0: goto L_0x0596;
                case 1: goto L_0x04c6;
                case 2: goto L_0x04c6;
                case 3: goto L_0x0451;
                case 4: goto L_0x03d0;
                case 5: goto L_0x031a;
                case 6: goto L_0x0268;
                case 7: goto L_0x023b;
                case 8: goto L_0x01f9;
                case 9: goto L_0x01db;
                case 10: goto L_0x01bd;
                case 11: goto L_0x0162;
                case 12: goto L_0x00c1;
                default: goto L_0x00bf;
            }
        L_0x00bf:
            r0 = 0
            return r0
        L_0x00c1:
            if (r9 == 0) goto L_0x00db
            if (r6 == 0) goto L_0x00d0
            int r0 = com.meizu.common.R.string.mc_pattern_hour_minute
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            return r0
        L_0x00d0:
            int r0 = com.meizu.common.R.string.mc_pattern_hour_minute_12
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            return r0
        L_0x00db:
            if (r0 == 0) goto L_0x00e4
            int r0 = com.meizu.common.R.string.mc_pattern_yesterday
            java.lang.String r0 = r1.getString(r0)
            return r0
        L_0x00e4:
            if (r16 == 0) goto L_0x0104
            if (r11 == 0) goto L_0x00f7
            if (r13 == 0) goto L_0x00f7
            if (r7 == 0) goto L_0x00f7
            java.lang.String r0 = FormatResultLast
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00f7
            java.lang.String r0 = FormatResultLast
            return r0
        L_0x00f7:
            int r0 = com.meizu.common.R.string.mc_pattern_week
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            FormatResultLast = r0
            return r0
        L_0x0104:
            if (r8 == 0) goto L_0x0124
            if (r11 == 0) goto L_0x0117
            if (r13 == 0) goto L_0x0117
            if (r7 == 0) goto L_0x0117
            java.lang.String r0 = FormatResultLast
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0117
            java.lang.String r0 = FormatResultLast
            return r0
        L_0x0117:
            int r0 = com.meizu.common.R.string.mc_simple_pattern_month_day
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            FormatResultLast = r0
            return r0
        L_0x0124:
            if (r17 == 0) goto L_0x0144
            if (r11 == 0) goto L_0x0137
            if (r13 == 0) goto L_0x0137
            if (r7 == 0) goto L_0x0137
            java.lang.String r0 = FormatResultLast
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0137
            java.lang.String r0 = FormatResultLast
            return r0
        L_0x0137:
            int r0 = com.meizu.common.R.string.mc_simple_pattern_year_month_day
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            FormatResultLast = r0
            return r0
        L_0x0144:
            if (r11 == 0) goto L_0x0155
            if (r13 == 0) goto L_0x0155
            if (r7 == 0) goto L_0x0155
            java.lang.String r0 = FormatResultLast
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0155
            java.lang.String r0 = FormatResultLast
            return r0
        L_0x0155:
            int r0 = com.meizu.common.R.string.mc_simple_pattern_year_month_day
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            FormatResultLast = r0
            return r0
        L_0x0162:
            if (r9 == 0) goto L_0x017c
            if (r6 == 0) goto L_0x0171
            int r0 = com.meizu.common.R.string.mc_pattern_hour_minute
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            return r0
        L_0x0171:
            int r0 = com.meizu.common.R.string.mc_pattern_hour_minute_12
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            return r0
        L_0x017c:
            if (r0 == 0) goto L_0x0185
            int r0 = com.meizu.common.R.string.mc_pattern_yesterday
            java.lang.String r0 = r1.getString(r0)
            return r0
        L_0x0185:
            if (r16 == 0) goto L_0x0192
            int r0 = com.meizu.common.R.string.mc_pattern_week
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            return r0
        L_0x0192:
            if (r8 == 0) goto L_0x019f
            int r0 = com.meizu.common.R.string.mc_pattern_month_day
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            return r0
        L_0x019f:
            if (r11 == 0) goto L_0x01b0
            if (r13 == 0) goto L_0x01b0
            if (r7 == 0) goto L_0x01b0
            java.lang.String r0 = FormatResultLast
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x01b0
            java.lang.String r0 = FormatResultLast
            return r0
        L_0x01b0:
            int r0 = com.meizu.common.R.string.mc_pattern_month_day
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            FormatResultLast = r0
            return r0
        L_0x01bd:
            if (r11 == 0) goto L_0x01ce
            if (r13 == 0) goto L_0x01ce
            if (r7 == 0) goto L_0x01ce
            java.lang.String r0 = FormatResultLast
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x01ce
            java.lang.String r0 = FormatResultLast
            return r0
        L_0x01ce:
            int r0 = com.meizu.common.R.string.mc_pattern_month_day
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            FormatResultLast = r0
            return r0
        L_0x01db:
            if (r11 == 0) goto L_0x01ec
            if (r13 == 0) goto L_0x01ec
            if (r7 == 0) goto L_0x01ec
            java.lang.String r0 = FormatResultLast
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x01ec
            java.lang.String r0 = FormatResultLast
            return r0
        L_0x01ec:
            int r0 = com.meizu.common.R.string.mc_pattern_year_month_day
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            FormatResultLast = r0
            return r0
        L_0x01f9:
            int r0 = r10.year
            int r2 = r3.year
            if (r0 != r2) goto L_0x021d
            if (r11 == 0) goto L_0x0210
            if (r13 == 0) goto L_0x0210
            if (r7 == 0) goto L_0x0210
            java.lang.String r0 = FormatResultLast
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0210
            java.lang.String r0 = FormatResultLast
            return r0
        L_0x0210:
            int r0 = com.meizu.common.R.string.mc_pattern_month_day
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            FormatResultLast = r0
            return r0
        L_0x021d:
            if (r11 == 0) goto L_0x022e
            if (r12 == 0) goto L_0x022e
            if (r7 == 0) goto L_0x022e
            java.lang.String r0 = FormatResultLast
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x022e
            java.lang.String r0 = FormatResultLast
            return r0
        L_0x022e:
            int r0 = com.meizu.common.R.string.mc_pattern_year_month
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            FormatResultLast = r0
            return r0
        L_0x023b:
            if (r11 == 0) goto L_0x024c
            if (r13 == 0) goto L_0x024c
            if (r7 == 0) goto L_0x024c
            java.lang.String r0 = FormatResultLast
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x024c
            java.lang.String r0 = FormatResultLast
            return r0
        L_0x024c:
            if (r8 == 0) goto L_0x025b
            int r0 = com.meizu.common.R.string.mc_pattern_month_day
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            FormatResultLast = r0
            return r0
        L_0x025b:
            int r0 = com.meizu.common.R.string.mc_pattern_year_month_day
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            FormatResultLast = r0
            return r0
        L_0x0268:
            if (r9 == 0) goto L_0x02b3
            long r4 = r4 - r19
            r2 = 3600000(0x36ee80, double:1.7786363E-317)
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            java.lang.String r2 = ","
            if (r0 < 0) goto L_0x0295
            int r0 = (int) r4
            int r0 = r0 / 60
            int r0 = r0 / 60
            int r0 = r0 / 1000
            r3 = 1
            if (r0 != r3) goto L_0x0286
            int r0 = com.meizu.common.R.string.mc_pattern_a_hour_before
            java.lang.String r0 = r1.getString(r0)
            return r0
        L_0x0286:
            int r3 = com.meizu.common.R.string.mc_pattern_hour_before
            java.lang.String r1 = r1.getString(r3)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r0 = r1.replace(r2, r0)
            return r0
        L_0x0295:
            int r0 = (int) r4
            int r0 = r0 / 60
            int r0 = r0 / 1000
            r3 = 1
            if (r0 > r3) goto L_0x02a4
            int r0 = com.meizu.common.R.string.mc_pattern_a_minute_before
            java.lang.String r0 = r1.getString(r0)
            return r0
        L_0x02a4:
            int r3 = com.meizu.common.R.string.mc_pattern_minute_before
            java.lang.String r1 = r1.getString(r3)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r0 = r1.replace(r2, r0)
            return r0
        L_0x02b3:
            if (r0 == 0) goto L_0x02bc
            int r0 = com.meizu.common.R.string.mc_pattern_yesterday
            java.lang.String r0 = r1.getString(r0)
            return r0
        L_0x02bc:
            if (r8 == 0) goto L_0x02dc
            if (r11 == 0) goto L_0x02cf
            if (r13 == 0) goto L_0x02cf
            if (r7 == 0) goto L_0x02cf
            java.lang.String r0 = FormatResultLast
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x02cf
            java.lang.String r0 = FormatResultLast
            return r0
        L_0x02cf:
            int r0 = com.meizu.common.R.string.mc_pattern_month_day
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            FormatResultLast = r0
            return r0
        L_0x02dc:
            if (r17 == 0) goto L_0x02fc
            if (r11 == 0) goto L_0x02ef
            if (r13 == 0) goto L_0x02ef
            if (r7 == 0) goto L_0x02ef
            java.lang.String r0 = FormatResultLast
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x02ef
            java.lang.String r0 = FormatResultLast
            return r0
        L_0x02ef:
            int r0 = com.meizu.common.R.string.mc_pattern_year_month_day
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            FormatResultLast = r0
            return r0
        L_0x02fc:
            if (r11 == 0) goto L_0x030d
            if (r13 == 0) goto L_0x030d
            if (r7 == 0) goto L_0x030d
            java.lang.String r0 = FormatResultLast
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x030d
            java.lang.String r0 = FormatResultLast
            return r0
        L_0x030d:
            int r0 = com.meizu.common.R.string.mc_pattern_year_month_day
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            FormatResultLast = r0
            return r0
        L_0x031a:
            if (r9 == 0) goto L_0x0334
            if (r6 == 0) goto L_0x0329
            int r0 = com.meizu.common.R.string.mc_pattern_hour_minute
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            return r0
        L_0x0329:
            int r0 = com.meizu.common.R.string.mc_pattern_hour_minute_12
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            return r0
        L_0x0334:
            if (r0 == 0) goto L_0x037e
            if (r6 == 0) goto L_0x035b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r2 = com.meizu.common.R.string.mc_pattern_yesterday
            java.lang.String r2 = r1.getString(r2)
            r0.append(r2)
            r0.append(r14)
            int r2 = com.meizu.common.R.string.mc_pattern_hour_minute
            java.lang.String r1 = r1.getString(r2)
            java.lang.String r1 = r3.format(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        L_0x035b:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r2 = com.meizu.common.R.string.mc_pattern_yesterday
            java.lang.String r2 = r1.getString(r2)
            r0.append(r2)
            r0.append(r14)
            int r2 = com.meizu.common.R.string.mc_pattern_hour_minute_12
            java.lang.String r1 = r1.getString(r2)
            java.lang.String r1 = r3.format(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        L_0x037e:
            if (r16 == 0) goto L_0x0398
            if (r6 == 0) goto L_0x038d
            int r0 = com.meizu.common.R.string.mc_pattern_week_hour_minute
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            return r0
        L_0x038d:
            int r0 = com.meizu.common.R.string.mc_pattern_week_hour_minute_12
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            return r0
        L_0x0398:
            if (r8 == 0) goto L_0x03b2
            if (r6 == 0) goto L_0x03a7
            int r0 = com.meizu.common.R.string.mc_pattern_month_day_hour_minute
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            return r0
        L_0x03a7:
            int r0 = com.meizu.common.R.string.mc_pattern_month_day_hour_minute_12
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            return r0
        L_0x03b2:
            if (r6 == 0) goto L_0x03c1
            int r0 = com.meizu.common.R.string.mc_pattern_year_month_day_hour_minute
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            FormatResultLast = r0
            goto L_0x03cd
        L_0x03c1:
            int r0 = com.meizu.common.R.string.mc_pattern_year_month_day_hour_minute_12
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            FormatResultLast = r0
        L_0x03cd:
            java.lang.String r0 = FormatResultLast
            return r0
        L_0x03d0:
            if (r9 == 0) goto L_0x03ea
            if (r6 == 0) goto L_0x03df
            int r0 = com.meizu.common.R.string.mc_pattern_hour_minute
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            return r0
        L_0x03df:
            int r0 = com.meizu.common.R.string.mc_pattern_hour_minute_12
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            return r0
        L_0x03ea:
            if (r0 == 0) goto L_0x03f3
            int r0 = com.meizu.common.R.string.mc_pattern_yesterday
            java.lang.String r0 = r1.getString(r0)
            return r0
        L_0x03f3:
            if (r8 == 0) goto L_0x0413
            if (r11 == 0) goto L_0x0406
            if (r13 == 0) goto L_0x0406
            if (r7 == 0) goto L_0x0406
            java.lang.String r0 = FormatResultLast
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0406
            java.lang.String r0 = FormatResultLast
            return r0
        L_0x0406:
            int r0 = com.meizu.common.R.string.mc_pattern_month_day
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            FormatResultLast = r0
            return r0
        L_0x0413:
            if (r17 == 0) goto L_0x0433
            if (r11 == 0) goto L_0x0426
            if (r13 == 0) goto L_0x0426
            if (r7 == 0) goto L_0x0426
            java.lang.String r0 = FormatResultLast
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0426
            java.lang.String r0 = FormatResultLast
            return r0
        L_0x0426:
            int r0 = com.meizu.common.R.string.mc_pattern_year_month_day
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            FormatResultLast = r0
            return r0
        L_0x0433:
            if (r11 == 0) goto L_0x0444
            if (r13 == 0) goto L_0x0444
            if (r7 == 0) goto L_0x0444
            java.lang.String r0 = FormatResultLast
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0444
            java.lang.String r0 = FormatResultLast
            return r0
        L_0x0444:
            int r0 = com.meizu.common.R.string.mc_pattern_year_month_day
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            FormatResultLast = r0
            return r0
        L_0x0451:
            if (r9 == 0) goto L_0x046b
            if (r6 == 0) goto L_0x0460
            int r0 = com.meizu.common.R.string.mc_pattern_hour_minute
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            return r0
        L_0x0460:
            int r0 = com.meizu.common.R.string.mc_pattern_hour_minute_12
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            return r0
        L_0x046b:
            if (r0 == 0) goto L_0x0474
            int r0 = com.meizu.common.R.string.mc_pattern_yesterday
            java.lang.String r0 = r1.getString(r0)
            return r0
        L_0x0474:
            if (r8 == 0) goto L_0x048e
            if (r6 == 0) goto L_0x0483
            int r0 = com.meizu.common.R.string.mc_pattern_month_day_hour_minute
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            return r0
        L_0x0483:
            int r0 = com.meizu.common.R.string.mc_pattern_month_day_hour_minute_12
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            return r0
        L_0x048e:
            if (r17 == 0) goto L_0x04ae
            if (r11 == 0) goto L_0x04a1
            if (r13 == 0) goto L_0x04a1
            if (r7 == 0) goto L_0x04a1
            java.lang.String r0 = FormatResultLast
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x04a1
            java.lang.String r0 = FormatResultLast
            return r0
        L_0x04a1:
            int r0 = com.meizu.common.R.string.mc_pattern_year_month_day
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            FormatResultLast = r0
            return r0
        L_0x04ae:
            if (r6 == 0) goto L_0x04bb
            int r0 = com.meizu.common.R.string.mc_pattern_year_month_day_hour_minute
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            return r0
        L_0x04bb:
            int r0 = com.meizu.common.R.string.mc_pattern_year_month_day_hour_minute_12
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            return r0
        L_0x04c6:
            if (r9 == 0) goto L_0x04e0
            if (r6 == 0) goto L_0x04d5
            int r0 = com.meizu.common.R.string.mc_pattern_hour_minute
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            return r0
        L_0x04d5:
            int r0 = com.meizu.common.R.string.mc_pattern_hour_minute_12
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            return r0
        L_0x04e0:
            if (r0 == 0) goto L_0x052a
            if (r6 == 0) goto L_0x0507
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r2 = com.meizu.common.R.string.mc_pattern_yesterday
            java.lang.String r2 = r1.getString(r2)
            r0.append(r2)
            r0.append(r14)
            int r2 = com.meizu.common.R.string.mc_pattern_hour_minute
            java.lang.String r1 = r1.getString(r2)
            java.lang.String r1 = r3.format(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        L_0x0507:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r2 = com.meizu.common.R.string.mc_pattern_yesterday
            java.lang.String r2 = r1.getString(r2)
            r0.append(r2)
            r0.append(r14)
            int r2 = com.meizu.common.R.string.mc_pattern_hour_minute_12
            java.lang.String r1 = r1.getString(r2)
            java.lang.String r1 = r3.format(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        L_0x052a:
            if (r16 == 0) goto L_0x0544
            if (r6 == 0) goto L_0x0539
            int r0 = com.meizu.common.R.string.mc_pattern_week_hour_minute
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            return r0
        L_0x0539:
            int r0 = com.meizu.common.R.string.mc_pattern_week_hour_minute_12
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            return r0
        L_0x0544:
            if (r8 == 0) goto L_0x055e
            if (r6 == 0) goto L_0x0553
            int r0 = com.meizu.common.R.string.mc_pattern_month_day_hour_minute
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            return r0
        L_0x0553:
            int r0 = com.meizu.common.R.string.mc_pattern_month_day_hour_minute_12
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            return r0
        L_0x055e:
            if (r17 == 0) goto L_0x057e
            if (r11 == 0) goto L_0x0571
            if (r13 == 0) goto L_0x0571
            if (r7 == 0) goto L_0x0571
            java.lang.String r0 = FormatResultLast
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0571
            java.lang.String r0 = FormatResultLast
            return r0
        L_0x0571:
            int r0 = com.meizu.common.R.string.mc_pattern_year_month_day
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            FormatResultLast = r0
            return r0
        L_0x057e:
            if (r6 == 0) goto L_0x058b
            int r0 = com.meizu.common.R.string.mc_pattern_year_month_day_hour_minute
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            return r0
        L_0x058b:
            int r0 = com.meizu.common.R.string.mc_pattern_year_month_day_hour_minute_12
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            return r0
        L_0x0596:
            if (r9 == 0) goto L_0x05b0
            if (r6 == 0) goto L_0x05a5
            int r0 = com.meizu.common.R.string.mc_pattern_hour_minute
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            return r0
        L_0x05a5:
            int r0 = com.meizu.common.R.string.mc_pattern_hour_minute_12
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            return r0
        L_0x05b0:
            if (r0 == 0) goto L_0x05b9
            int r0 = com.meizu.common.R.string.mc_pattern_yesterday
            java.lang.String r0 = r1.getString(r0)
            return r0
        L_0x05b9:
            if (r16 == 0) goto L_0x05d9
            if (r11 == 0) goto L_0x05cc
            if (r13 == 0) goto L_0x05cc
            if (r7 == 0) goto L_0x05cc
            java.lang.String r0 = FormatResultLast
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x05cc
            java.lang.String r0 = FormatResultLast
            return r0
        L_0x05cc:
            int r0 = com.meizu.common.R.string.mc_pattern_week
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            FormatResultLast = r0
            return r0
        L_0x05d9:
            if (r8 == 0) goto L_0x05f9
            if (r11 == 0) goto L_0x05ec
            if (r13 == 0) goto L_0x05ec
            if (r7 == 0) goto L_0x05ec
            java.lang.String r0 = FormatResultLast
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x05ec
            java.lang.String r0 = FormatResultLast
            return r0
        L_0x05ec:
            int r0 = com.meizu.common.R.string.mc_pattern_month_day
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            FormatResultLast = r0
            return r0
        L_0x05f9:
            if (r17 == 0) goto L_0x0619
            if (r11 == 0) goto L_0x060c
            if (r13 == 0) goto L_0x060c
            if (r7 == 0) goto L_0x060c
            java.lang.String r0 = FormatResultLast
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x060c
            java.lang.String r0 = FormatResultLast
            return r0
        L_0x060c:
            int r0 = com.meizu.common.R.string.mc_pattern_year_month_day
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            FormatResultLast = r0
            return r0
        L_0x0619:
            if (r11 == 0) goto L_0x062a
            if (r13 == 0) goto L_0x062a
            if (r7 == 0) goto L_0x062a
            java.lang.String r0 = FormatResultLast
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x062a
            java.lang.String r0 = FormatResultLast
            return r0
        L_0x062a:
            int r0 = com.meizu.common.R.string.mc_pattern_year_month_day
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r0 = r3.format(r0)
            FormatResultLast = r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.util.DateTimeUtils.formatTimeStampString(android.content.Context, long, int):java.lang.String");
    }
}
