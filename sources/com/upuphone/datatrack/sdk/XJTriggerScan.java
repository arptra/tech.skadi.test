package com.upuphone.datatrack.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.upuphone.datatrack.base.db.XJDataBaseManager;
import com.upuphone.datatrack.base.utils.DataTrackHelper;
import com.upuphone.datatrack.base.utils.LogUtil;
import com.upuphone.datatrack.base.utils.NetWorkUtil;
import com.upuphone.datatrack.base.utils.XJDeviceUtil;
import com.upuphone.datatrack.base.utils.XJPackageUtil;
import com.upuphone.datatrack.sdk.XJHttpManager;
import java.util.List;

public class XJTriggerScan {

    /* renamed from: a  reason: collision with root package name */
    public static final Integer f6417a = 10;
    public static Long b = null;
    public static volatile Runnable c = null;
    public static final HandlerThread d;
    public static final Handler e;

    static {
        HandlerThread handlerThread = new HandlerThread("XJTriggerScan");
        d = handlerThread;
        handlerThread.start();
        e = new Handler(handlerThread.getLooper());
    }

    public static void e(Context context, List list) {
        LogUtil.e("XJTriggerScan", "deleteDataFromDb, delete data size: " + list.size());
        XJDataBaseManager.d(context).a(list);
    }

    public static long f() {
        Long l;
        if (!XJPackageUtil.j() || (l = b) == null || l.longValue() <= 0) {
            return 900000;
        }
        return b.longValue();
    }

    public static synchronized void g(Context context) {
        synchronized (XJTriggerScan.class) {
            h(context, 0);
        }
    }

    public static synchronized void h(final Context context, long j) {
        synchronized (XJTriggerScan.class) {
            try {
                if (c == null) {
                    c = new Runnable() {
                        public void run() {
                            XJTriggerScan.e.removeCallbacks(this);
                            XJTriggerScan.e.postDelayed(this, XJTriggerScan.f());
                            XJTriggerScan.i(context);
                        }
                    };
                }
                e.postDelayed(c, j);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void i(Context context) {
        if (!XJDataTrackConfig.a()) {
            LogUtil.c("XJTriggerScan", "scanAndUpload, isFeatureEnable=false");
        } else if (NetWorkUtil.e(context)) {
            XJDataBaseManager d2 = XJDataBaseManager.d(context);
            Integer num = f6417a;
            List h = d2.h(num.intValue());
            if (!h.isEmpty()) {
                j(context, h);
            } else {
                j(context, d2.f(num.intValue()));
            }
        } else {
            LogUtil.c("XJTriggerScan", "scanAndUpload, network not connected, send data later");
        }
    }

    public static void j(final Context context, List list) {
        if (!XJDataTrackConfig.a()) {
            LogUtil.c("XJTriggerScan", "sendDataToCloud, isFeatureEnable=false");
        } else if (list.isEmpty()) {
            LogUtil.c("XJTriggerScan", "scanAndUpload, appTrackList is empty");
        } else {
            LogUtil.e("XJTriggerScan", "scanAndUpload, appTrackList size: " + list.size());
            final List a2 = XJDataTrackConfig.b() ? DataTrackHelper.a(list, XJDeviceUtil.f(), XJDeviceUtil.h()) : DataTrackHelper.b(list, XJDeviceUtil.f(), XJDeviceUtil.h());
            if (a2.isEmpty()) {
                LogUtil.c("XJTriggerScan", "scanAndUpload, trackDataList is empty, iotDeviceId: " + XJDeviceUtil.f() + ", iotDeviceRom: " + XJDeviceUtil.h());
                return;
            }
            LogUtil.e("XJTriggerScan", "sendDataToCloud, trackDataList size: " + a2.size());
            XJHttpManager.g(context).o(a2, new XJHttpManager.UploadCallback() {
                public void a(int i, String str) {
                    LogUtil.c("XJTriggerScan", "sendDataToCloud, failed errCode: " + i + ", errMsg: " + str);
                }

                public void onSuccess() {
                    LogUtil.e("XJTriggerScan", "sendDataToCloud, success");
                    XJTriggerScan.e(context, DataTrackHelper.c(a2));
                    XJTriggerScan.h(context, 1000);
                }
            });
        }
    }
}
