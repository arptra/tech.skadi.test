package com.upuphone.xr.sapp.utils;

import android.content.Context;
import android.database.Cursor;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.entity.XiaoMiQuerrySteps;
import com.upuphone.xr.sapp.entity.XiaoMiSteps;
import java.util.LinkedList;
import java.util.TimeZone;
import org.apache.commons.lang3.time.DateUtils;

public class XiaoMiFeatureParser {

    /* renamed from: a  reason: collision with root package name */
    public static XiaoMiFeatureParser f7937a;

    public static synchronized XiaoMiFeatureParser e() {
        XiaoMiFeatureParser xiaoMiFeatureParser;
        synchronized (XiaoMiFeatureParser.class) {
            try {
                if (f7937a == null) {
                    f7937a = new XiaoMiFeatureParser();
                }
                xiaoMiFeatureParser = f7937a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return xiaoMiFeatureParser;
    }

    public final LinkedList a(Context context) {
        LinkedList linkedList = new LinkedList();
        Cursor query = context.getContentResolver().query(XiaoMiQuerrySteps.CONTENT_URI, XiaoMiQuerrySteps.projection, (String) null, (String[]) null, XiaoMiQuerrySteps.DEFAULT_SORT_ORDER);
        if (query.moveToFirst()) {
            do {
                linkedList.add(new XiaoMiSteps(query.getInt(0), query.getLong(1), query.getLong(2), query.getInt(3), query.getInt(4)));
            } while (query.moveToNext());
        }
        ULog.i("XiaoMiFeatureParser", "getAllSteps" + linkedList.size());
        return linkedList;
    }

    public boolean b(String str, boolean z) {
        try {
            return ((Boolean) Class.forName("miui.util.FeatureParser").getMethod("getBoolean", new Class[]{String.class, Boolean.TYPE}).invoke((Object) null, new Object[]{str, Boolean.valueOf(z)})).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return z;
        }
    }

    public final long c() {
        return ((System.currentTimeMillis() / DateUtils.MILLIS_PER_DAY) * DateUtils.MILLIS_PER_DAY) - ((long) TimeZone.getDefault().getRawOffset());
    }

    public final long d() {
        return (((System.currentTimeMillis() / DateUtils.MILLIS_PER_DAY) * DateUtils.MILLIS_PER_DAY) - ((long) TimeZone.getDefault().getRawOffset())) + 86399999;
    }

    public int f(Context context) {
        int i;
        ULog.i("XiaoMiFeatureParser", "BeginTime:" + c() + "EndTime:" + d());
        try {
            LinkedList a2 = a(context);
            i = 0;
            for (int i2 = 0; i2 < a2.size(); i2++) {
                XiaoMiSteps xiaoMiSteps = (XiaoMiSteps) a2.get(i2);
                if (xiaoMiSteps.getmBeginTime() >= c() && xiaoMiSteps.getmEndTime() <= d()) {
                    i += xiaoMiSteps.getmSteps();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            i = -1;
        }
        ULog.i("XiaoMiFeatureParser", "getXiaoMiSteps:" + i);
        return i;
    }
}
