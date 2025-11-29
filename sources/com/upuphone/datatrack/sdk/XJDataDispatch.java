package com.upuphone.datatrack.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.upuphone.datatrack.base.db.XJDataBaseManager;
import com.upuphone.datatrack.base.utils.LogUtil;
import com.upuphone.datatrack.base.utils.XJPackageUtil;
import com.upuphone.datatrack.sdk.reporter.DataTrackReporter;
import com.upuphone.datatrack.sdk.reporter.InstantReporter;
import com.upuphone.datatrack.sdk.reporter.NormalReporter;
import com.upuphone.datatrack.sdk.reporter.PeriodReporter;
import java.util.HashMap;

public class XJDataDispatch {

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap f6406a;

    static {
        HashMap hashMap = new HashMap();
        f6406a = hashMap;
        NormalReporter normalReporter = new NormalReporter();
        hashMap.put(1, normalReporter);
        hashMap.put(3, new PeriodReporter());
        hashMap.put(2, new InstantReporter());
        hashMap.put(-1, normalReporter);
    }

    public static void a(Context context, int i, String str, String str2) {
        b(context, i, str, str2, false);
    }

    public static void b(Context context, int i, String str, String str2, boolean z) {
        if (!XJDataTrackConfig.a()) {
            LogUtil.c("XJDataTrack", "dispatch, isFeatureEnable=false");
            return;
        }
        String d = XJPackageUtil.d(context);
        if (TextUtils.isEmpty(d)) {
            LogUtil.c("XJDataTrack", "dispatch, packageName is null");
        } else if (TextUtils.isEmpty(str)) {
            LogUtil.c("XJDataTrack", "dispatch, trackMsg is null");
        } else if (TextUtils.isEmpty(str2)) {
            LogUtil.c("XJDataTrack", "dispatch, eventName is null");
        } else if (i == 5) {
            LogUtil.c("XJDataTrack", "dispatch, deviceType: " + i + " is not supported");
        } else if (i == 6) {
            try {
                int c = XJDataBaseManager.d(context).c(str2);
                DataTrackReporter dataTrackReporter = (DataTrackReporter) f6406a.get(Integer.valueOf(c));
                if (dataTrackReporter != null) {
                    dataTrackReporter.a(d, str, str2, z);
                } else {
                    LogUtil.c("XJDataTrack", "dispatch, unsupported reportType: " + c);
                }
                int g = XJDataBaseManager.d(context).g(d);
                if (g > 100000) {
                    XJDataBaseManager.d(context).b(d, 100000);
                } else if (g >= 500) {
                    XJTriggerScan.g(context);
                }
            } catch (Exception e) {
                LogUtil.d("XJDataTrack", "dispatch, error: ", e);
            }
        } else {
            LogUtil.c("XJDataTrack", "dispatch, deviceType: " + i + " is undefined");
        }
    }
}
