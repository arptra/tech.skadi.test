package com.meizu.net.pedometerprovider.manager;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.meizu.net.pedometerprovider.manager.bean.StepBean;
import com.meizu.net.pedometerprovider.manager.bean.UInfo;
import com.meizu.net.pedometerprovider.util.CalendarType;
import com.meizu.net.pedometerprovider.util.DateUtil;
import com.xjsd.ai.assistant.protocol.CmdCode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PedoManager {
    private static final String COL_AGE = "age";
    private static final String COL_BEGIN = "begin";
    private static final String COL_COUNT = "count";
    private static final String COL_FUN_ON = "pedometer_function_on";
    private static final String COL_GENDER = "gender";
    private static final String COL_HEIGHT = "height";
    private static final String COL_PUSH_NOTIFICATION_ON = "push_notification_on";
    private static final String COL_STATUS = "status";
    private static final String COL_TARGET = "target";
    private static final String COL_TEMP = "temp";
    private static final String COL_TIME = "time";
    private static final String COL_TOKEN = "token";
    private static final String COL_UID = "uid";
    private static final String COL_WEIGHT = "weight";
    private static final Uri CONTENT_URI;
    public static final int DAY_MAX_STEP = 100000;
    private static final Uri EXPORT_SETTING_URL;
    public static final int HOUR_MAX_STEP = 20000;
    private static final int MIN_CALENDAR_SIZE = 6;
    private static final long ONE_DAY_MILLS = 86400000;
    private static final String STEP_TABLE_NAME = "stepcount";
    private static final Uri STEP_URI;
    private static final String TAG = "Pedo_Manager";
    private static final String URI_AUTHORITY = "com.meizu.net.pedometer";
    private static final String USER_TABLE_NAME = "userinfo";
    private static final Uri USER_URI;
    private static PedoManager mInstance;
    private static String sUID = null;
    private static UInfo sUserInfo = null;
    private Context mContext;
    private List<StepListener> mListeners = null;
    StepObserver mObserver;

    static {
        Uri parse = Uri.parse("content://com.meizu.net.pedometer/");
        CONTENT_URI = parse;
        STEP_URI = Uri.parse(parse.toString() + STEP_TABLE_NAME);
        USER_URI = Uri.parse(parse.toString() + USER_TABLE_NAME);
        EXPORT_SETTING_URL = Uri.parse(parse.toString() + "exportsettinginfo");
    }

    private PedoManager(Context context) {
        this.mContext = context.getApplicationContext();
        this.mObserver = new StepObserver(new Handler(Looper.getMainLooper()), this);
        this.mContext.getContentResolver().registerContentObserver(STEP_URI, true, this.mObserver);
        setUserId(this.mContext);
    }

    private List<StepBean> converttoList(Map<Long, Integer> map, CalendarType calendarType, int i) {
        int i2;
        ArrayList<StepBean> arrayList = new ArrayList<>();
        Iterator<Long> it = map.keySet().iterator();
        while (true) {
            i2 = 0;
            if (!it.hasNext()) {
                break;
            }
            Long next = it.next();
            long longValue = next.longValue();
            int intValue = Integer.valueOf(String.valueOf(longValue).substring(0, 4)).intValue();
            int intValue2 = Integer.valueOf(String.valueOf(longValue).substring(4, 6)).intValue();
            int intValue3 = Integer.valueOf(String.valueOf(longValue).substring(6, 8)).intValue();
            arrayList.add(new StepBean(Long.valueOf(intValue + getStringInt(intValue2 + 1) + getStringInt(intValue3)).longValue(), map.get(next).intValue()));
        }
        Collections.sort(arrayList, new Comparator<StepBean>() {
            public int compare(StepBean stepBean, StepBean stepBean2) {
                return stepBean.getData() > stepBean2.getData() ? 1 : -1;
            }
        });
        int intValue4 = Integer.valueOf(String.valueOf(i).substring(0, 4)).intValue();
        int intValue5 = Integer.valueOf(String.valueOf(i).substring(4, 6)).intValue();
        int intValue6 = Integer.valueOf(String.valueOf(i).substring(6, 8)).intValue();
        if (calendarType == CalendarType.YEAR) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (i3 != arrayList.size() - 1 || (intValue5 == 11 && intValue6 == 31)) {
                    arrayList.set(i3, new StepBean(((StepBean) arrayList.get(i3)).getData(), resetVlue(((StepBean) arrayList.get(i3)).getCount() / getDayCount(Integer.valueOf(String.valueOf(((StepBean) arrayList.get(i3)).getData()).substring(0, 4)).intValue()))));
                } else {
                    Calendar instance = Calendar.getInstance();
                    instance.set(1, intValue4);
                    instance.set(2, intValue5);
                    instance.set(5, intValue6);
                    long timeInMillis = instance.getTimeInMillis();
                    Calendar instance2 = Calendar.getInstance();
                    instance2.set(1, intValue4);
                    instance2.set(2, 0);
                    instance2.set(5, 1);
                    long timeInMillis2 = (timeInMillis - instance2.getTimeInMillis()) / 86400000;
                    if (timeInMillis2 == 0) {
                        timeInMillis2 = 1;
                    }
                    arrayList.set(i3, new StepBean(((StepBean) arrayList.get(i3)).getData(), resetVlue(Integer.valueOf(String.valueOf(((long) ((StepBean) arrayList.get(i3)).getCount()) / timeInMillis2)).intValue())));
                }
            }
        } else if (calendarType == CalendarType.MONTH) {
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                int dayCountOfMonth = DateUtil.getDayCountOfMonth(Integer.valueOf(String.valueOf(((StepBean) arrayList.get(i4)).getData()).substring(0, 4)).intValue(), Integer.valueOf(String.valueOf(((StepBean) arrayList.get(i4)).getData()).substring(4, 6)).intValue());
                if (i4 != arrayList.size() - 1) {
                    arrayList.set(i4, new StepBean(((StepBean) arrayList.get(i4)).getData(), resetVlue(((StepBean) arrayList.get(i4)).getCount() / dayCountOfMonth)));
                } else {
                    arrayList.set(i4, new StepBean(((StepBean) arrayList.get(i4)).getData(), resetVlue(((StepBean) arrayList.get(i4)).getCount() / intValue6)));
                }
            }
        } else if (calendarType == CalendarType.WEEK) {
            int inWeekIndex = DateUtil.getInWeekIndex((long) i);
            while (i2 < arrayList.size()) {
                arrayList.set(i2, new StepBean(((StepBean) arrayList.get(i2)).getData(), resetVlue(((StepBean) arrayList.get(i2)).getCount() / (i2 == arrayList.size() - 1 ? inWeekIndex : 7))));
                i2++;
            }
        } else if (calendarType == CalendarType.DAY) {
            for (StepBean stepBean : arrayList) {
                stepBean.setCount(resetVlue(stepBean.getCount()));
            }
        }
        return arrayList;
    }

    private void fillNullDataDay(int i, int i2, Map<Long, Integer> map) {
        int intValue = Integer.valueOf(String.valueOf(i).substring(0, 4)).intValue();
        int intValue2 = Integer.valueOf(String.valueOf(i2).substring(0, 4)).intValue();
        int intValue3 = Integer.valueOf(String.valueOf(i).substring(4, 6)).intValue();
        int intValue4 = Integer.valueOf(String.valueOf(i2).substring(4, 6)).intValue();
        int intValue5 = Integer.valueOf(String.valueOf(i).substring(6, 8)).intValue();
        int intValue6 = Integer.valueOf(String.valueOf(i2).substring(6, 8)).intValue();
        Calendar instance = Calendar.getInstance();
        instance.set(1, intValue);
        instance.set(2, intValue3);
        instance.set(5, intValue5);
        instance.set(11, 0);
        Calendar instance2 = Calendar.getInstance();
        instance2.set(1, intValue2);
        instance2.set(2, intValue4);
        instance2.set(5, intValue6);
        instance2.set(11, 0);
        long timeInMillis = instance2.getTimeInMillis();
        for (long timeInMillis2 = instance.getTimeInMillis(); timeInMillis2 <= timeInMillis; timeInMillis2 += 86400000) {
            Calendar instance3 = Calendar.getInstance();
            instance3.setTimeInMillis(timeInMillis2);
            int i3 = instance3.get(1);
            int i4 = instance3.get(2);
            int i5 = instance3.get(5);
            Long valueOf = Long.valueOf(i3 + getStringInt(i4) + getStringInt(i5));
            valueOf.longValue();
            map.put(valueOf, 0);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x005c, code lost:
        r7 = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x005e, code lost:
        if (r7 >= r9) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0060, code lost:
        r8 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0061, code lost:
        if (r8 > 11) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0063, code lost:
        r4 = java.lang.Long.valueOf(r7 + getStringInt(r8) + "01");
        r4.longValue();
        r11.put(r4, 0);
        r8 = r8 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0086, code lost:
        if (r1 > r10) goto L_0x00ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0088, code lost:
        r7 = java.lang.Long.valueOf(r9 + getStringInt(r1) + "01");
        r7.longValue();
        r11.put(r7, 0);
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x005a, code lost:
        if ((r9 - r7) >= 2) goto L_0x005c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void fillNullDataMonth(int r7, int r8, int r9, int r10, java.util.Map<java.lang.Long, java.lang.Integer> r11) {
        /*
            r6 = this;
            java.lang.String r0 = "01"
            r1 = 0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
            if (r9 != r7) goto L_0x002e
        L_0x0009:
            if (r8 > r10) goto L_0x00ab
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r7)
            java.lang.String r1 = r6.getStringInt(r8)
            r9.append(r1)
            r9.append(r0)
            java.lang.String r9 = r9.toString()
            java.lang.Long r9 = java.lang.Long.valueOf(r9)
            r9.longValue()
            r11.put(r9, r2)
            int r8 = r8 + 1
            goto L_0x0009
        L_0x002e:
            if (r9 <= r7) goto L_0x00ab
        L_0x0030:
            r3 = 11
            if (r8 > r3) goto L_0x0057
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r7)
            java.lang.String r4 = r6.getStringInt(r8)
            r3.append(r4)
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r3.longValue()
            r11.put(r3, r2)
            int r8 = r8 + 1
            goto L_0x0030
        L_0x0057:
            int r8 = r9 - r7
            r4 = 2
            if (r8 < r4) goto L_0x0086
        L_0x005c:
            int r7 = r7 + 1
            if (r7 >= r9) goto L_0x0086
            r8 = r1
        L_0x0061:
            if (r8 > r3) goto L_0x005c
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r7)
            java.lang.String r5 = r6.getStringInt(r8)
            r4.append(r5)
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r4.longValue()
            r11.put(r4, r2)
            int r8 = r8 + 1
            goto L_0x0061
        L_0x0086:
            if (r1 > r10) goto L_0x00ab
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r9)
            java.lang.String r8 = r6.getStringInt(r1)
            r7.append(r8)
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            java.lang.Long r7 = java.lang.Long.valueOf(r7)
            r7.longValue()
            r11.put(r7, r2)
            int r1 = r1 + 1
            goto L_0x0086
        L_0x00ab:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.net.pedometerprovider.manager.PedoManager.fillNullDataMonth(int, int, int, int, java.util.Map):void");
    }

    private void fillNullDataWeek(long j, long j2, Map<Long, Integer> map) {
        while (j <= j2) {
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(j);
            int i = instance.get(1);
            int i2 = instance.get(2);
            int i3 = instance.get(5);
            Long valueOf = Long.valueOf(i + getStringInt(i2) + getStringInt(i3));
            valueOf.longValue();
            map.put(valueOf, 0);
            j += 604800000;
        }
    }

    private void fillNullDataYear(int i, int i2, Map<Long, Integer> map) {
        for (long j = (long) i; j <= ((long) i2); j++) {
            Long valueOf = Long.valueOf(j + "00" + "01");
            valueOf.longValue();
            map.put(valueOf, 0);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0067, code lost:
        if (r1 != null) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0069, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0074, code lost:
        if (r1 == null) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0077, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<com.meizu.net.pedometerprovider.manager.bean.StepBean> getAllStepList() {
        /*
            r11 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            java.lang.String r2 = sUID     // Catch:{ Exception -> 0x006d }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x006d }
            java.lang.String r3 = "time"
            java.lang.String r4 = "count"
            if (r2 == 0) goto L_0x002b
            android.content.Context r11 = r11.mContext     // Catch:{ Exception -> 0x006d }
            android.content.ContentResolver r5 = r11.getContentResolver()     // Catch:{ Exception -> 0x006d }
            android.net.Uri r6 = STEP_URI     // Catch:{ Exception -> 0x006d }
            java.lang.String[] r7 = new java.lang.String[]{r4, r3}     // Catch:{ Exception -> 0x006d }
            java.lang.String r8 = "uid is null AND count > 0"
            java.lang.String r10 = "time ASC"
            r9 = 0
            android.database.Cursor r11 = r5.query(r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x006d }
        L_0x0027:
            r1 = r11
            goto L_0x0046
        L_0x0029:
            r11 = move-exception
            goto L_0x0078
        L_0x002b:
            android.content.Context r11 = r11.mContext     // Catch:{ Exception -> 0x006d }
            android.content.ContentResolver r5 = r11.getContentResolver()     // Catch:{ Exception -> 0x006d }
            android.net.Uri r6 = STEP_URI     // Catch:{ Exception -> 0x006d }
            java.lang.String[] r7 = new java.lang.String[]{r4, r3}     // Catch:{ Exception -> 0x006d }
            java.lang.String r8 = "uid = ? AND count > 0"
            java.lang.String r11 = sUID     // Catch:{ Exception -> 0x006d }
            java.lang.String[] r9 = new java.lang.String[]{r11}     // Catch:{ Exception -> 0x006d }
            java.lang.String r10 = "time ASC"
            android.database.Cursor r11 = r5.query(r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x006d }
            goto L_0x0027
        L_0x0046:
            if (r1 == 0) goto L_0x0067
            int r11 = r1.getCount()     // Catch:{ Exception -> 0x006d }
            if (r11 < 0) goto L_0x0067
        L_0x004e:
            boolean r11 = r1.moveToNext()     // Catch:{ Exception -> 0x006d }
            if (r11 == 0) goto L_0x0067
            com.meizu.net.pedometerprovider.manager.bean.StepBean r11 = new com.meizu.net.pedometerprovider.manager.bean.StepBean     // Catch:{ Exception -> 0x006d }
            r2 = 1
            long r2 = r1.getLong(r2)     // Catch:{ Exception -> 0x006d }
            r4 = 0
            int r4 = r1.getInt(r4)     // Catch:{ Exception -> 0x006d }
            r11.<init>(r2, r4)     // Catch:{ Exception -> 0x006d }
            r0.add(r11)     // Catch:{ Exception -> 0x006d }
            goto L_0x004e
        L_0x0067:
            if (r1 == 0) goto L_0x0077
        L_0x0069:
            r1.close()
            goto L_0x0077
        L_0x006d:
            java.lang.String r11 = "Pedo"
            java.lang.String r2 = "PedoManager getAllStepList failed!!"
            android.util.Log.i(r11, r2)     // Catch:{ all -> 0x0029 }
            if (r1 == 0) goto L_0x0077
            goto L_0x0069
        L_0x0077:
            return r0
        L_0x0078:
            if (r1 == 0) goto L_0x007d
            r1.close()
        L_0x007d:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.net.pedometerprovider.manager.PedoManager.getAllStepList():java.util.List");
    }

    private int getDayCount(int i) {
        return ((i % 4 != 0 || i % 100 == 0) && i % CmdCode.CODE_WAKEUP_RECORDING != 0) ? 365 : 366;
    }

    private long getDayKey(long j) {
        int intValue = Integer.valueOf(String.valueOf(j).substring(0, 4)).intValue();
        int intValue2 = Integer.valueOf(String.valueOf(j).substring(4, 6)).intValue();
        int intValue3 = Integer.valueOf(String.valueOf(j).substring(6, 8)).intValue();
        return Long.valueOf(intValue + getStringInt(intValue2) + getStringInt(intValue3)).longValue();
    }

    private int getDayStepEx(long j, long j2) {
        Cursor cursor = null;
        try {
            Cursor query = TextUtils.isEmpty(sUID) ? this.mContext.getContentResolver().query(STEP_URI, new String[]{"SUM(count)"}, "time>= ? AND time <= ? AND uid is null", new String[]{String.valueOf(j), String.valueOf(j2)}, (String) null) : this.mContext.getContentResolver().query(STEP_URI, new String[]{"SUM(count)"}, "time>= ? AND time <= ? AND uid = ?", new String[]{String.valueOf(j), String.valueOf(j2), sUID}, (String) null);
            int i = 0;
            if (query != null) {
                if (query.getCount() != 0) {
                    query.moveToFirst();
                    i = query.getInt(0);
                }
            }
            int resetVlue = resetVlue(i);
            if (query == null) {
                return resetVlue;
            }
            query.close();
            return resetVlue;
        } catch (Exception e) {
            Log.i(TAG, "getDayStepEx exception: " + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
            return -1;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private UInfo getDefaultUser() {
        UInfo uInfo = new UInfo();
        uInfo.setGender(1);
        uInfo.setAge(25);
        uInfo.setWeight(60.0f);
        uInfo.setHeight(165.0f);
        uInfo.setTarget(5000);
        return uInfo;
    }

    public static synchronized PedoManager getInstance(Context context) {
        PedoManager pedoManager;
        synchronized (PedoManager.class) {
            try {
                if (mInstance == null) {
                    mInstance = new PedoManager(context);
                }
                pedoManager = mInstance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return pedoManager;
    }

    private static String getMonth(String str) {
        if (Integer.valueOf(str).intValue() + 1 >= 10) {
            return String.valueOf(Integer.valueOf(str).intValue() + 1);
        }
        return "0" + String.valueOf(Integer.valueOf(str).intValue() + 1);
    }

    private long getMontyKey(long j) {
        int intValue = Integer.valueOf(String.valueOf(j).substring(0, 4)).intValue();
        int intValue2 = Integer.valueOf(String.valueOf(j).substring(4, 6)).intValue();
        return Long.valueOf(intValue + getStringInt(intValue2) + "01").longValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x007a, code lost:
        if (r1 != null) goto L_0x007c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007c, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0086, code lost:
        if (r1 == null) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0089, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<com.meizu.net.pedometerprovider.manager.bean.StepBean> getStepList(long r12, long r14) {
        /*
            r11 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            java.lang.String r2 = sUID     // Catch:{ Exception -> 0x0086, all -> 0x0034 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0086, all -> 0x0034 }
            java.lang.String r3 = "time"
            java.lang.String r4 = "count"
            if (r2 == 0) goto L_0x0036
            android.content.Context r11 = r11.mContext     // Catch:{ Exception -> 0x0086, all -> 0x0034 }
            android.content.ContentResolver r5 = r11.getContentResolver()     // Catch:{ Exception -> 0x0086, all -> 0x0034 }
            android.net.Uri r6 = STEP_URI     // Catch:{ Exception -> 0x0086, all -> 0x0034 }
            java.lang.String[] r7 = new java.lang.String[]{r4, r3}     // Catch:{ Exception -> 0x0086, all -> 0x0034 }
            java.lang.String r8 = "time>= ? AND time <= ? AND uid is null"
            java.lang.String r11 = java.lang.String.valueOf(r12)     // Catch:{ Exception -> 0x0086, all -> 0x0034 }
            java.lang.String r12 = java.lang.String.valueOf(r14)     // Catch:{ Exception -> 0x0086, all -> 0x0034 }
            java.lang.String[] r9 = new java.lang.String[]{r11, r12}     // Catch:{ Exception -> 0x0086, all -> 0x0034 }
            java.lang.String r10 = "time ASC"
            android.database.Cursor r11 = r5.query(r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0086, all -> 0x0034 }
        L_0x0032:
            r1 = r11
            goto L_0x0059
        L_0x0034:
            r11 = move-exception
            goto L_0x0080
        L_0x0036:
            android.content.Context r11 = r11.mContext     // Catch:{ Exception -> 0x0086, all -> 0x0034 }
            android.content.ContentResolver r5 = r11.getContentResolver()     // Catch:{ Exception -> 0x0086, all -> 0x0034 }
            android.net.Uri r6 = STEP_URI     // Catch:{ Exception -> 0x0086, all -> 0x0034 }
            java.lang.String[] r7 = new java.lang.String[]{r4, r3}     // Catch:{ Exception -> 0x0086, all -> 0x0034 }
            java.lang.String r8 = "time>= ? AND time <= ? AND uid = ?"
            java.lang.String r11 = java.lang.String.valueOf(r12)     // Catch:{ Exception -> 0x0086, all -> 0x0034 }
            java.lang.String r12 = java.lang.String.valueOf(r14)     // Catch:{ Exception -> 0x0086, all -> 0x0034 }
            java.lang.String r13 = sUID     // Catch:{ Exception -> 0x0086, all -> 0x0034 }
            java.lang.String[] r9 = new java.lang.String[]{r11, r12, r13}     // Catch:{ Exception -> 0x0086, all -> 0x0034 }
            java.lang.String r10 = "time ASC"
            android.database.Cursor r11 = r5.query(r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0086, all -> 0x0034 }
            goto L_0x0032
        L_0x0059:
            if (r1 == 0) goto L_0x007a
            int r11 = r1.getCount()     // Catch:{ Exception -> 0x0086, all -> 0x0034 }
            if (r11 < 0) goto L_0x007a
        L_0x0061:
            boolean r11 = r1.moveToNext()     // Catch:{ Exception -> 0x0086, all -> 0x0034 }
            if (r11 == 0) goto L_0x007a
            com.meizu.net.pedometerprovider.manager.bean.StepBean r11 = new com.meizu.net.pedometerprovider.manager.bean.StepBean     // Catch:{ Exception -> 0x0086, all -> 0x0034 }
            r12 = 1
            long r12 = r1.getLong(r12)     // Catch:{ Exception -> 0x0086, all -> 0x0034 }
            r14 = 0
            int r14 = r1.getInt(r14)     // Catch:{ Exception -> 0x0086, all -> 0x0034 }
            r11.<init>(r12, r14)     // Catch:{ Exception -> 0x0086, all -> 0x0034 }
            r0.add(r11)     // Catch:{ Exception -> 0x0086, all -> 0x0034 }
            goto L_0x0061
        L_0x007a:
            if (r1 == 0) goto L_0x0089
        L_0x007c:
            r1.close()
            goto L_0x0089
        L_0x0080:
            if (r1 == 0) goto L_0x0085
            r1.close()
        L_0x0085:
            throw r11
        L_0x0086:
            if (r1 == 0) goto L_0x0089
            goto L_0x007c
        L_0x0089:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.net.pedometerprovider.manager.PedoManager.getStepList(long, long):java.util.List");
    }

    private long getWeekKey(long j) {
        int inWeekIndex = DateUtil.getInWeekIndex(j);
        long timeInMillis = inWeekIndex != 1 ? DateUtil.getTimeInMillis(j) - (((long) (inWeekIndex - 1)) * 86400000) : DateUtil.getTimeInMillis(j);
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(timeInMillis);
        int i = instance.get(1);
        int i2 = instance.get(2);
        int i3 = instance.get(5);
        return Long.valueOf(i + getStringInt(i2) + getStringInt(i3)).longValue();
    }

    private long getYearKey(long j) {
        int intValue = Integer.valueOf(String.valueOf(j).substring(0, 4)).intValue();
        return Long.valueOf(intValue + "0001").longValue();
    }

    private boolean isPedoInstall(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.meizu.net.pedometer", 0) != null;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    private int resetVlue(int i) {
        if (i > 100000) {
            i = 100000;
        }
        if (i < 0) {
            return 0;
        }
        return i;
    }

    private static void setUserId(Context context) {
        sUID = UserManager.getInstance(context).getSetingInfo().getUid();
    }

    public List<StepBean> getCalendarStepListDay(int i) {
        List<StepBean> stepList = getStepList(0, Long.valueOf(String.valueOf(i) + "2300").longValue());
        int intValue = stepList.size() == 0 ? i : Integer.valueOf(String.valueOf(stepList.get(0).getData()).substring(0, 8)).intValue();
        long timeInMillis = DateUtil.getTimeInMillis((long) i);
        if (timeInMillis - DateUtil.getTimeInMillis((long) intValue) < 432000000) {
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(timeInMillis - 432000000);
            int i2 = instance.get(1);
            int i3 = instance.get(2);
            int i4 = instance.get(5);
            intValue = Integer.valueOf((i2 + getStringInt(i3) + getStringInt(i4)).toString()).intValue();
        }
        HashMap hashMap = new HashMap();
        fillNullDataDay(intValue, i, hashMap);
        for (StepBean next : stepList) {
            long dayKey = getDayKey(next.getData());
            if (hashMap.containsKey(Long.valueOf(dayKey))) {
                hashMap.put(Long.valueOf(dayKey), Integer.valueOf(((Integer) hashMap.get(Long.valueOf(dayKey))).intValue() + next.getCount()));
            } else {
                hashMap.put(Long.valueOf(dayKey), Integer.valueOf(next.getCount()));
            }
        }
        return converttoList(hashMap, CalendarType.DAY, i);
    }

    public List<StepBean> getCalendarStepListMonth(int i) {
        int i2;
        int i3;
        int intValue = Integer.valueOf(String.valueOf(i).substring(0, 4)).intValue();
        int intValue2 = Integer.valueOf(String.valueOf(i).substring(4, 6)).intValue();
        int dayCountOfMonth = DateUtil.getDayCountOfMonth(intValue, intValue2);
        List<StepBean> stepList = getStepList(0, Long.valueOf(String.valueOf(intValue) + getStringInt(intValue2) + getStringInt(dayCountOfMonth) + "2300").longValue());
        if (stepList.size() == 0) {
            i2 = intValue;
            i3 = intValue2;
        } else {
            i2 = Integer.valueOf(String.valueOf(stepList.get(0).getData()).substring(0, 4)).intValue();
            i3 = Integer.valueOf(String.valueOf(stepList.get(0).getData()).substring(4, 6)).intValue();
        }
        if (intValue == i2 && intValue2 - i3 < 5 && intValue2 - 5 < 0) {
            i2 = intValue - 1;
            i3 = intValue2 + 7;
        }
        if (intValue - i2 == 1 && (intValue2 + 12) - i3 < 5) {
            i3 = intValue2 + 7;
        }
        int i4 = i3;
        HashMap hashMap = new HashMap();
        fillNullDataMonth(i2, i4, intValue, intValue2, hashMap);
        for (StepBean next : stepList) {
            long montyKey = getMontyKey(next.getData());
            if (hashMap.containsKey(Long.valueOf(montyKey))) {
                hashMap.put(Long.valueOf(montyKey), Integer.valueOf(((Integer) hashMap.get(Long.valueOf(montyKey))).intValue() + next.getCount()));
            } else {
                hashMap.put(Long.valueOf(montyKey), Integer.valueOf(next.getCount()));
            }
        }
        return converttoList(hashMap, CalendarType.MONTH, i);
    }

    public List<StepBean> getCalendarStepListWeek(int i) {
        long j;
        long j2 = (long) i;
        int inWeekIndex = DateUtil.getInWeekIndex(j2);
        long timeInMillis = inWeekIndex != 7 ? DateUtil.getTimeInMillis(j2) + (((long) (7 - inWeekIndex)) * 86400000) : DateUtil.getTimeInMillis(j2);
        long j3 = timeInMillis - 518400000;
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(timeInMillis);
        int i2 = instance.get(1);
        int i3 = instance.get(2);
        int i4 = instance.get(5);
        List<StepBean> stepList = getStepList(0, Long.valueOf(String.valueOf(i2) + getStringInt(i3) + getStringInt(i4) + "2300").longValue());
        if (stepList.size() == 0) {
            j = timeInMillis;
        } else {
            int inWeekIndex2 = DateUtil.getInWeekIndex(stepList.get(0).getData());
            j = inWeekIndex2 != 1 ? DateUtil.getTimeInMillis(stepList.get(0).getData()) - (((long) (inWeekIndex2 - 1)) * 86400000) : DateUtil.getTimeInMillis(stepList.get(0).getData());
        }
        long j4 = j3 - j < 3024000000L ? timeInMillis - 3542400000L : j;
        HashMap hashMap = new HashMap();
        fillNullDataWeek(j4, timeInMillis, hashMap);
        for (StepBean next : stepList) {
            long weekKey = getWeekKey(next.getData());
            if (hashMap.containsKey(Long.valueOf(weekKey))) {
                hashMap.put(Long.valueOf(weekKey), Integer.valueOf(((Integer) hashMap.get(Long.valueOf(weekKey))).intValue() + next.getCount()));
            } else {
                hashMap.put(Long.valueOf(weekKey), Integer.valueOf(next.getCount()));
            }
        }
        return converttoList(hashMap, CalendarType.WEEK, i);
    }

    public List<StepBean> getCalendarStepListYear(int i) {
        int intValue = Integer.valueOf(String.valueOf(i).substring(0, 4)).intValue();
        List<StepBean> stepList = getStepList(0, Long.valueOf(String.valueOf(intValue) + "11312300").longValue());
        int intValue2 = stepList.size() == 0 ? intValue : Integer.valueOf(String.valueOf(stepList.get(0).getData()).substring(0, 4)).intValue();
        if (intValue - intValue2 < 5) {
            intValue2 = intValue - 5;
        }
        HashMap hashMap = new HashMap();
        fillNullDataYear(intValue2, intValue, hashMap);
        for (StepBean next : stepList) {
            long yearKey = getYearKey(next.getData());
            if (hashMap.containsKey(Long.valueOf(yearKey))) {
                hashMap.put(Long.valueOf(yearKey), Integer.valueOf(((Integer) hashMap.get(Long.valueOf(yearKey))).intValue() + next.getCount()));
            } else {
                hashMap.put(Long.valueOf(yearKey), Integer.valueOf(next.getCount()));
            }
        }
        return converttoList(hashMap, CalendarType.YEAR, i);
    }

    public float getCalories() {
        return ((float) getToadayStep()) * 0.68f * 0.001f * getUserInfo().getWeight();
    }

    public int getContinuousWalkDay() {
        long currentTimeMillis = System.currentTimeMillis();
        List<StepBean> allStepList = getAllStepList();
        HashMap hashMap = new HashMap();
        for (StepBean next : allStepList) {
            long dayKey = getDayKey(next.getData());
            if (hashMap.containsKey(Long.valueOf(dayKey))) {
                hashMap.put(Long.valueOf(dayKey), Integer.valueOf(((Integer) hashMap.get(Long.valueOf(dayKey))).intValue() + next.getCount()));
            } else {
                hashMap.put(Long.valueOf(dayKey), Integer.valueOf(next.getCount()));
            }
        }
        int i = 0;
        while (i < Integer.MAX_VALUE && hashMap.containsKey(Long.valueOf(DateUtil.convetTime(currentTimeMillis - (((long) i) * 86400000), true)))) {
            i++;
        }
        return i;
    }

    public int[] getDayBeforList(int i) {
        int[] iArr = new int[24];
        if (i < 0) {
            return iArr;
        }
        if (i == 0) {
            return getTodayList();
        }
        List<StepBean> stepList = getStepList(DateUtil.getDayBeforBegin(i), DateUtil.getDayBeforEnd(i));
        Collections.sort(stepList, new Comparator<StepBean>() {
            public int compare(StepBean stepBean, StepBean stepBean2) {
                return stepBean.getData() > stepBean2.getData() ? 1 : -1;
            }
        });
        for (StepBean next : stepList) {
            iArr[Integer.valueOf(String.valueOf(next.getData()).substring(8, 10)).intValue()] = next.getCount();
        }
        return iArr;
    }

    public int getDayStep(int i) {
        if (i == 0) {
            return getToadayStep();
        }
        if (i < 0) {
            return 0;
        }
        return getDayStepEx(DateUtil.getDayBeforBegin(i), DateUtil.getDayBeforEnd(i));
    }

    public float getDistances() {
        return ((float) getToadayStep()) * 0.68f;
    }

    public int getLastUpDate() {
        Cursor query;
        long j;
        Cursor cursor = null;
        try {
            if (TextUtils.isEmpty(sUID)) {
                query = this.mContext.getContentResolver().query(STEP_URI, new String[]{"time"}, "uid is null AND count > ?", new String[]{"0"}, "time DESC");
            } else {
                query = this.mContext.getContentResolver().query(STEP_URI, new String[]{"time"}, "uid = ? AND count > ?", new String[]{sUID, "0"}, "time DESC");
            }
            cursor = query;
            if (cursor == null || cursor.getCount() == 0) {
                j = 0;
            } else {
                cursor.moveToFirst();
                j = cursor.getLong(0);
            }
            if (j == 0) {
                if (cursor != null) {
                    cursor.close();
                }
                return 0;
            }
            String valueOf = String.valueOf(j);
            int intValue = Integer.valueOf(valueOf.substring(0, 4) + getMonth(valueOf.substring(4, 6)) + valueOf.substring(6, 8) + valueOf.substring(8, 10)).intValue();
            if (cursor != null) {
                cursor.close();
            }
            return intValue;
        } catch (Exception unused) {
            if (cursor != null) {
                cursor.close();
            }
            return 0;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.meizu.net.pedometerprovider.manager.bean.SettingInfo getSettingInfo() {
        /*
            r8 = this;
            r0 = 0
            android.content.Context r8 = r8.mContext     // Catch:{ Exception -> 0x0058, all -> 0x0053 }
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch:{ Exception -> 0x0058, all -> 0x0053 }
            android.net.Uri r2 = EXPORT_SETTING_URL     // Catch:{ Exception -> 0x0058, all -> 0x0053 }
            r5 = 0
            r6 = 0
            r3 = 0
            r4 = 0
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x0058, all -> 0x0053 }
            if (r8 == 0) goto L_0x004d
            boolean r1 = r8.moveToFirst()     // Catch:{ Exception -> 0x0048 }
            if (r1 == 0) goto L_0x004d
            com.meizu.net.pedometerprovider.manager.bean.SettingInfo r1 = new com.meizu.net.pedometerprovider.manager.bean.SettingInfo     // Catch:{ Exception -> 0x0048 }
            r1.<init>()     // Catch:{ Exception -> 0x0048 }
            java.lang.String r0 = "pedometer_function_on"
            int r0 = r8.getColumnIndex(r0)     // Catch:{ Exception -> 0x0046 }
            int r0 = r8.getInt(r0)     // Catch:{ Exception -> 0x0046 }
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x002e
            r0 = r3
            goto L_0x002f
        L_0x002e:
            r0 = r2
        L_0x002f:
            r1.setPedoFunctionOn(r0)     // Catch:{ Exception -> 0x0046 }
            java.lang.String r0 = "push_notification_on"
            int r0 = r8.getColumnIndex(r0)     // Catch:{ Exception -> 0x0046 }
            int r0 = r8.getInt(r0)     // Catch:{ Exception -> 0x0046 }
            if (r0 == 0) goto L_0x003f
            r2 = r3
        L_0x003f:
            r1.setPushNotificationOn(r2)     // Catch:{ Exception -> 0x0046 }
            r0 = r1
            goto L_0x004d
        L_0x0044:
            r0 = move-exception
            goto L_0x006a
        L_0x0046:
            r0 = move-exception
            goto L_0x005c
        L_0x0048:
            r1 = move-exception
            r7 = r1
            r1 = r0
            r0 = r7
            goto L_0x005c
        L_0x004d:
            if (r8 == 0) goto L_0x0069
            r8.close()
            goto L_0x0069
        L_0x0053:
            r8 = move-exception
            r7 = r0
            r0 = r8
            r8 = r7
            goto L_0x006a
        L_0x0058:
            r8 = move-exception
            r1 = r0
            r0 = r8
            r8 = r1
        L_0x005c:
            java.lang.String r2 = "Pedo_Manager"
            java.lang.String r3 = ""
            android.util.Log.w(r2, r3, r0)     // Catch:{ all -> 0x0044 }
            if (r8 == 0) goto L_0x0068
            r8.close()
        L_0x0068:
            r0 = r1
        L_0x0069:
            return r0
        L_0x006a:
            if (r8 == 0) goto L_0x006f
            r8.close()
        L_0x006f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.net.pedometerprovider.manager.PedoManager.getSettingInfo():com.meizu.net.pedometerprovider.manager.bean.SettingInfo");
    }

    public int[] getSomeDayData(int i) {
        int[] iArr = new int[25];
        iArr[0] = getDayStep(i);
        System.arraycopy(getDayBeforList(i), 0, iArr, 1, 24);
        return iArr;
    }

    public int getStepByDate(int i) {
        int intValue;
        if (String.valueOf(i).length() != 8 || Integer.valueOf(String.valueOf(i).substring(4, 6)).intValue() - 1 < 0) {
            return 0;
        }
        String stringInt = getStringInt(intValue);
        String substring = String.valueOf(i).substring(0, 4);
        String substring2 = String.valueOf(i).substring(6, 8);
        long longValue = Long.valueOf(substring + stringInt + substring2 + "0000").longValue();
        return resetVlue(getDayStepEx(longValue, Long.valueOf(substring + stringInt + substring2 + "2300").longValue()));
    }

    public String getStringInt(int i) {
        if (i >= 10) {
            return String.valueOf(i);
        }
        return "0" + i;
    }

    public int getToadayStep() {
        return getDayStepEx(DateUtil.getTodayBegin(), DateUtil.getTodayBegin() + 2300);
    }

    public int[] getTodayList() {
        int[] iArr = new int[24];
        long todayBegin = DateUtil.getTodayBegin();
        List<StepBean> stepList = getStepList(todayBegin, 2300 + todayBegin);
        Collections.sort(stepList, new Comparator<StepBean>() {
            public int compare(StepBean stepBean, StepBean stepBean2) {
                return stepBean.getData() > stepBean2.getData() ? 1 : -1;
            }
        });
        for (StepBean next : stepList) {
            iArr[Integer.valueOf(String.valueOf(next.getData()).substring(8, 10)).intValue()] = next.getCount();
        }
        return iArr;
    }

    public int getTotalWalkDay() {
        List<StepBean> allStepList = getAllStepList();
        HashMap hashMap = new HashMap();
        for (StepBean next : allStepList) {
            long dayKey = getDayKey(next.getData());
            if (hashMap.containsKey(Long.valueOf(dayKey))) {
                hashMap.put(Long.valueOf(dayKey), Integer.valueOf(((Integer) hashMap.get(Long.valueOf(dayKey))).intValue() + next.getCount()));
            } else {
                hashMap.put(Long.valueOf(dayKey), Integer.valueOf(next.getCount()));
            }
        }
        if (hashMap.keySet() == null || hashMap.keySet().size() == 0) {
            return 0;
        }
        return hashMap.size();
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.meizu.net.pedometerprovider.manager.bean.UInfo getUserInfo() {
        /*
            r11 = this;
            com.meizu.net.pedometerprovider.manager.bean.UInfo r0 = sUserInfo
            if (r0 != 0) goto L_0x008f
            r0 = 0
            android.content.Context r1 = r11.mContext     // Catch:{ Exception -> 0x007e, all -> 0x007b }
            android.content.ContentResolver r2 = r1.getContentResolver()     // Catch:{ Exception -> 0x007e, all -> 0x007b }
            android.net.Uri r3 = USER_URI     // Catch:{ Exception -> 0x007e, all -> 0x007b }
            java.lang.String r4 = "uid"
            java.lang.String r5 = "gender"
            java.lang.String r6 = "weight"
            java.lang.String r7 = "height"
            java.lang.String r8 = "target"
            java.lang.String r9 = "age"
            java.lang.String r10 = "token"
            java.lang.String[] r4 = new java.lang.String[]{r4, r5, r6, r7, r8, r9, r10}     // Catch:{ Exception -> 0x007e, all -> 0x007b }
            r6 = 0
            r7 = 0
            r5 = 0
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x007e, all -> 0x007b }
            if (r1 == 0) goto L_0x006f
            int r2 = r1.getCount()     // Catch:{ Exception -> 0x0088, all -> 0x0033 }
            if (r2 != 0) goto L_0x0035
            com.meizu.net.pedometerprovider.manager.bean.UInfo r11 = r11.getDefaultUser()     // Catch:{ Exception -> 0x0088, all -> 0x0033 }
            goto L_0x0073
        L_0x0033:
            r11 = move-exception
            goto L_0x0080
        L_0x0035:
            r1.moveToFirst()     // Catch:{ Exception -> 0x0088, all -> 0x0033 }
            r11 = 0
            java.lang.String r11 = r1.getString(r11)     // Catch:{ Exception -> 0x0088, all -> 0x0033 }
            r2 = 1
            int r2 = r1.getInt(r2)     // Catch:{ Exception -> 0x0088, all -> 0x0033 }
            r3 = 2
            float r3 = r1.getFloat(r3)     // Catch:{ Exception -> 0x0088, all -> 0x0033 }
            r4 = 3
            float r4 = r1.getFloat(r4)     // Catch:{ Exception -> 0x0088, all -> 0x0033 }
            r5 = 4
            int r5 = r1.getInt(r5)     // Catch:{ Exception -> 0x0088, all -> 0x0033 }
            r6 = 5
            int r6 = r1.getInt(r6)     // Catch:{ Exception -> 0x0088, all -> 0x0033 }
            com.meizu.net.pedometerprovider.manager.bean.UInfo r7 = new com.meizu.net.pedometerprovider.manager.bean.UInfo     // Catch:{ Exception -> 0x0088, all -> 0x0033 }
            r7.<init>()     // Catch:{ Exception -> 0x0088, all -> 0x0033 }
            r7.setUserId(r11)     // Catch:{ Exception -> 0x0088, all -> 0x0033 }
            r7.setGender(r2)     // Catch:{ Exception -> 0x0088, all -> 0x0033 }
            r7.setWeight(r3)     // Catch:{ Exception -> 0x0088, all -> 0x0033 }
            r7.setHeight(r4)     // Catch:{ Exception -> 0x0088, all -> 0x0033 }
            r7.setTarget(r5)     // Catch:{ Exception -> 0x0088, all -> 0x0033 }
            r7.setAge(r6)     // Catch:{ Exception -> 0x0088, all -> 0x0033 }
            r11 = r7
            goto L_0x0073
        L_0x006f:
            com.meizu.net.pedometerprovider.manager.bean.UInfo r11 = r11.getDefaultUser()     // Catch:{ Exception -> 0x0088, all -> 0x0033 }
        L_0x0073:
            if (r1 == 0) goto L_0x0078
            r1.close()
        L_0x0078:
            sUserInfo = r11
            goto L_0x008f
        L_0x007b:
            r11 = move-exception
            r1 = r0
            goto L_0x0080
        L_0x007e:
            r1 = r0
            goto L_0x0088
        L_0x0080:
            if (r1 == 0) goto L_0x0085
            r1.close()
        L_0x0085:
            sUserInfo = r0
            throw r11
        L_0x0088:
            if (r1 == 0) goto L_0x008d
            r1.close()
        L_0x008d:
            sUserInfo = r0
        L_0x008f:
            com.meizu.net.pedometerprovider.manager.bean.UInfo r11 = sUserInfo
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.net.pedometerprovider.manager.PedoManager.getUserInfo():com.meizu.net.pedometerprovider.manager.bean.UInfo");
    }

    public void notifyListener(int i) {
        List<StepListener> list = this.mListeners;
        if (list != null) {
            for (StepListener next : list) {
                if (next != null) {
                    next.onStepChanged(i);
                }
            }
        }
    }

    public void registStepListener(StepListener stepListener) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList();
        }
        for (int size = this.mListeners.size() - 1; size >= 0; size--) {
            StepListener stepListener2 = this.mListeners.get(size);
            if (stepListener2.getType() == stepListener.getType()) {
                this.mListeners.remove(stepListener2);
            }
        }
        if (!this.mListeners.contains(stepListener)) {
            this.mListeners.add(stepListener);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00c5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void saveUserInfo(com.meizu.net.pedometerprovider.manager.bean.UInfo r11) {
        /*
            r10 = this;
            android.content.Context r0 = r10.mContext
            java.lang.String r0 = r0.getPackageName()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x001d
            java.lang.String r1 = "com.meizu.net.map"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x001d
            java.lang.String r1 = "com.meizu.net.pedometer"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x001d
            return
        L_0x001d:
            r0 = 0
            android.content.Context r1 = r10.mContext     // Catch:{ Exception -> 0x00c3, all -> 0x00ba }
            android.content.ContentResolver r2 = r1.getContentResolver()     // Catch:{ Exception -> 0x00c3, all -> 0x00ba }
            android.net.Uri r1 = USER_URI     // Catch:{ Exception -> 0x00c3, all -> 0x00ba }
            java.lang.String r3 = "uid"
            java.lang.String r4 = "gender"
            java.lang.String r5 = "weight"
            java.lang.String r6 = "height"
            java.lang.String r7 = "target"
            java.lang.String r8 = "age"
            java.lang.String r9 = "token"
            java.lang.String[] r4 = new java.lang.String[]{r3, r4, r5, r6, r7, r8, r9}     // Catch:{ Exception -> 0x00c3, all -> 0x00ba }
            r6 = 0
            r7 = 0
            r5 = 0
            r3 = r1
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x00c3, all -> 0x00ba }
            if (r2 == 0) goto L_0x00b2
            r2.moveToFirst()     // Catch:{ Exception -> 0x00a7, all -> 0x00a4 }
            android.content.ContentValues r3 = new android.content.ContentValues     // Catch:{ Exception -> 0x00a7, all -> 0x00a4 }
            r3.<init>()     // Catch:{ Exception -> 0x00a7, all -> 0x00a4 }
            java.lang.String r4 = "uid"
            java.lang.String r5 = r11.getUserId()     // Catch:{ Exception -> 0x00a7, all -> 0x00a4 }
            r3.put(r4, r5)     // Catch:{ Exception -> 0x00a7, all -> 0x00a4 }
            java.lang.String r4 = "gender"
            int r5 = r11.getGender()     // Catch:{ Exception -> 0x00a7, all -> 0x00a4 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x00a7, all -> 0x00a4 }
            r3.put(r4, r5)     // Catch:{ Exception -> 0x00a7, all -> 0x00a4 }
            java.lang.String r4 = "weight"
            float r5 = r11.getWeight()     // Catch:{ Exception -> 0x00a7, all -> 0x00a4 }
            java.lang.Float r5 = java.lang.Float.valueOf(r5)     // Catch:{ Exception -> 0x00a7, all -> 0x00a4 }
            r3.put(r4, r5)     // Catch:{ Exception -> 0x00a7, all -> 0x00a4 }
            java.lang.String r4 = "height"
            float r5 = r11.getHeight()     // Catch:{ Exception -> 0x00a7, all -> 0x00a4 }
            java.lang.Float r5 = java.lang.Float.valueOf(r5)     // Catch:{ Exception -> 0x00a7, all -> 0x00a4 }
            r3.put(r4, r5)     // Catch:{ Exception -> 0x00a7, all -> 0x00a4 }
            java.lang.String r4 = "target"
            int r5 = r11.getTarget()     // Catch:{ Exception -> 0x00a7, all -> 0x00a4 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x00a7, all -> 0x00a4 }
            r3.put(r4, r5)     // Catch:{ Exception -> 0x00a7, all -> 0x00a4 }
            java.lang.String r4 = "age"
            int r5 = r11.getAge()     // Catch:{ Exception -> 0x00a7, all -> 0x00a4 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x00a7, all -> 0x00a4 }
            r3.put(r4, r5)     // Catch:{ Exception -> 0x00a7, all -> 0x00a4 }
            int r4 = r2.getCount()     // Catch:{ Exception -> 0x00a7, all -> 0x00a4 }
            if (r4 <= 0) goto L_0x00a9
            android.content.Context r10 = r10.mContext     // Catch:{ Exception -> 0x00a7, all -> 0x00a4 }
            android.content.ContentResolver r10 = r10.getContentResolver()     // Catch:{ Exception -> 0x00a7, all -> 0x00a4 }
            r10.update(r1, r3, r0, r0)     // Catch:{ Exception -> 0x00a7, all -> 0x00a4 }
            goto L_0x00b2
        L_0x00a4:
            r10 = move-exception
            r0 = r2
            goto L_0x00bb
        L_0x00a7:
            r0 = r2
            goto L_0x00c3
        L_0x00a9:
            android.content.Context r10 = r10.mContext     // Catch:{ Exception -> 0x00a7, all -> 0x00a4 }
            android.content.ContentResolver r10 = r10.getContentResolver()     // Catch:{ Exception -> 0x00a7, all -> 0x00a4 }
            r10.insert(r1, r3)     // Catch:{ Exception -> 0x00a7, all -> 0x00a4 }
        L_0x00b2:
            if (r2 == 0) goto L_0x00b7
            r2.close()
        L_0x00b7:
            sUserInfo = r11
            goto L_0x00c9
        L_0x00ba:
            r10 = move-exception
        L_0x00bb:
            if (r0 == 0) goto L_0x00c0
            r0.close()
        L_0x00c0:
            sUserInfo = r11
            throw r10
        L_0x00c3:
            if (r0 == 0) goto L_0x00b7
            r0.close()
            goto L_0x00b7
        L_0x00c9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.net.pedometerprovider.manager.PedoManager.saveUserInfo(com.meizu.net.pedometerprovider.manager.bean.UInfo):void");
    }

    public void startPedoMainPage(Context context) {
        if (isPedoInstall(context)) {
            context.startActivity(new Intent("com.meizu.net.pedometer.action_main_page"));
        }
    }

    public void unRegisterObserver() {
        if (this.mObserver != null) {
            this.mContext.getContentResolver().unregisterContentObserver(this.mObserver);
        }
        List<StepListener> list = this.mListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void unRegisterStepListener(StepListener stepListener) {
        List<StepListener> list = this.mListeners;
        if (list != null && list.contains(stepListener)) {
            this.mListeners.remove(stepListener);
        }
    }

    public void notifyListener() {
        new AsyncTask() {
            public Object doInBackground(Object[] objArr) {
                return Integer.valueOf(PedoManager.this.getToadayStep());
            }

            public void onPostExecute(Object obj) {
                Integer num = (Integer) obj;
                if (num.intValue() != -1) {
                    PedoManager.this.notifyListener(num.intValue());
                }
            }
        }.execute(new Object[0]);
    }

    public void setUserId(String str) {
        sUID = str;
    }

    private int getDayStep(long j, long j2) {
        Cursor cursor;
        Cursor cursor2 = null;
        int i = 0;
        try {
            String[] strArr = {"time", COL_BEGIN, COL_TEMP, COL_COUNT};
            if (TextUtils.isEmpty(sUID)) {
                cursor = this.mContext.getContentResolver().query(STEP_URI, strArr, "time>= ? AND time <= ? AND uid is null", new String[]{String.valueOf(j), String.valueOf(j2)}, "time ASC");
            } else {
                cursor = this.mContext.getContentResolver().query(STEP_URI, strArr, "time>= ? AND time <= ? AND uid = ?", new String[]{String.valueOf(j), String.valueOf(j2), sUID}, "time ASC");
            }
            if (cursor != null) {
                int i2 = cursor.moveToLast() ? cursor.getInt(2) : 0;
                int i3 = cursor.moveToFirst() ? cursor.getInt(1) : 0;
                if (i2 == 0 || i3 == 0) {
                    while (cursor.moveToNext()) {
                        i += cursor.getInt(3);
                    }
                } else {
                    i = i2 - i3;
                }
            }
            int resetVlue = resetVlue(i);
            if (cursor == null) {
                return resetVlue;
            }
            cursor.close();
            return resetVlue;
        } catch (Exception unused) {
            if (cursor2 != null) {
                cursor2.close();
            }
            return 0;
        } catch (Throwable th) {
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public int getLastUpDate(int i) {
        int intValue;
        Cursor query;
        long j;
        if (String.valueOf(i).length() != 8 || Integer.valueOf(String.valueOf(i).substring(4, 6)).intValue() - 1 < 0) {
            return 0;
        }
        String stringInt = getStringInt(intValue);
        String substring = String.valueOf(i).substring(0, 4);
        String substring2 = String.valueOf(i).substring(6, 8);
        long longValue = Long.valueOf(substring + stringInt + substring2 + "0000").longValue();
        long longValue2 = Long.valueOf(substring + stringInt + substring2 + "2300").longValue();
        Cursor cursor = null;
        try {
            if (TextUtils.isEmpty(sUID)) {
                query = this.mContext.getContentResolver().query(STEP_URI, new String[]{"time"}, "time>= ? AND time <= ? AND uid is null AND count > ?", new String[]{String.valueOf(longValue), String.valueOf(longValue2), "0"}, "time DESC");
            } else {
                query = this.mContext.getContentResolver().query(STEP_URI, new String[]{"time"}, "time>= ? AND time <= ? AND uid = ? AND count > ?", new String[]{String.valueOf(longValue), String.valueOf(longValue2), sUID, "0"}, "time DESC");
            }
            cursor = query;
            if (cursor == null || cursor.getCount() == 0) {
                j = 0;
            } else {
                cursor.moveToFirst();
                j = cursor.getLong(0);
            }
            if (j == 0) {
                if (cursor != null) {
                    cursor.close();
                }
                return 0;
            }
            String valueOf = String.valueOf(j);
            int intValue2 = Integer.valueOf(valueOf.substring(0, 4) + getMonth(valueOf.substring(4, 6)) + valueOf.substring(6, 8) + valueOf.substring(8, 10)).intValue();
            if (cursor != null) {
                cursor.close();
            }
            return intValue2;
        } catch (Exception unused) {
            if (cursor != null) {
                cursor.close();
            }
            return 0;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }
}
