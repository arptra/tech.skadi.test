package com.upuphone.datatrack.sdk;

import android.app.Activity;
import android.app.Application;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.honey.account.m5.a;
import com.upuphone.datatrack.base.utils.ActivityUtil;
import com.upuphone.datatrack.base.utils.LogUtil;
import com.upuphone.datatrack.base.utils.XJDeviceUtil;
import com.upuphone.datatrack.base.utils.XJPackageUtil;
import com.upuphone.datatrack.base.utils.XJTrackUtil;
import com.upuphone.datatrack.base.utils.thread.ThreadUtils;
import com.upuphone.datatrack.sdk.service.TrackJobService;
import java.util.HashMap;
import java.util.Map;

public final class XJDataTrack {
    public static final Object c = new Object();
    public static volatile XJDataTrack d;
    public static long e;

    /* renamed from: a  reason: collision with root package name */
    public Context f6407a;
    public int b;

    /* renamed from: com.upuphone.datatrack.sdk.XJDataTrack$2  reason: invalid class name */
    class AnonymousClass2 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6411a;
        public final /* synthetic */ XJDataTrack b;

        public void run() {
            HashMap hashMap = new HashMap();
            hashMap.put("_event_name_", this.f6411a);
            hashMap.put("_event_type_", "action_x");
            XJDataDispatch.a(this.b.f6407a, this.b.b, XJTrackUtil.b(this.b.f6407a, hashMap), this.f6411a);
        }
    }

    public XJDataTrack(int i, Application application, String str, boolean z) {
        Log.i("XJDataTrack", "XJDataTrack#init, version: 0.4.14-SNAPSHOT, type: " + i + ", appModel: " + str + ", isDebug: " + z);
        XJPackageUtil.l(str);
        XJPackageUtil.m(z);
        LogUtil.b = z;
        if (application == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("XJDataTrack init params is error.");
        }
        this.f6407a = application;
        this.b = i;
        q(application, z);
        XJHttpManager.g(this.f6407a).f();
        if (i == 5) {
            LogUtil.c("XJDataTrack", "XJDataTrack#init, type " + i + " is not supported");
        } else if (i == 6) {
            XJDeviceUtil.x(application, 6);
            XJTriggerScan.g(this.f6407a);
        } else {
            LogUtil.c("XJDataTrack", "XJDataTrack#init, device type is undefined");
        }
        f(application);
    }

    public static XJDataTrack h() {
        if (d != null) {
            return d;
        }
        throw new IllegalStateException("XJDataTrack not init");
    }

    public static void i(int i, Application application, String str, boolean z) {
        if (d == null) {
            synchronized (c) {
                try {
                    if (d == null) {
                        d = new XJDataTrack(i, application, str, z);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final void f(Application application) {
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            public void onActivityDestroyed(Activity activity) {
            }

            public void onActivityPaused(Activity activity) {
            }

            public void onActivityResumed(Activity activity) {
            }

            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            public void onActivityStarted(Activity activity) {
                LogUtil.a("XJDataTrack", "onActivityStarted: " + activity);
                ActivityUtil.g(activity);
                if (ActivityUtil.a() == 1) {
                    LogUtil.a("XJDataTrack", "onActivityStarted: APP_START");
                    long unused = XJDataTrack.e = System.currentTimeMillis();
                    final HashMap hashMap = new HashMap();
                    hashMap.put("_event_name_", "_AppStart_");
                    hashMap.put("_screen_name_", activity.getLocalClassName());
                    hashMap.put("_title_", activity.getTitle());
                    hashMap.put("_is_first_time_", XJPackageUtil.k(XJDataTrack.this.f6407a));
                    hashMap.put("_event_type_", "action_x");
                    ThreadUtils.a(new Runnable() {
                        public void run() {
                            XJDataDispatch.a(XJDataTrack.this.f6407a, XJDataTrack.this.b, XJTrackUtil.b(XJDataTrack.this.f6407a, hashMap), "_AppStart_");
                        }
                    });
                }
            }

            public void onActivityStopped(Activity activity) {
                LogUtil.a("XJDataTrack", "onActivityStopped: " + activity);
                ActivityUtil.f(activity);
                if (ActivityUtil.a() == 0) {
                    LogUtil.a("XJDataTrack", "onActivityStopped: APP_END");
                    long unused = XJDataTrack.e = System.currentTimeMillis() - XJDataTrack.e;
                    final HashMap hashMap = new HashMap();
                    hashMap.put("_event_name_", "_AppEnd_");
                    hashMap.put("_screen_name_", activity.getLocalClassName());
                    hashMap.put("_title_", activity.getTitle());
                    hashMap.put("_event_duration_", Long.valueOf(XJDataTrack.e));
                    hashMap.put("_event_type_", "action_x");
                    ThreadUtils.a(new Runnable() {
                        public void run() {
                            XJDataDispatch.a(XJDataTrack.this.f6407a, XJDataTrack.this.b, XJTrackUtil.b(XJDataTrack.this.f6407a, hashMap), "_AppEnd_");
                        }
                    });
                }
            }
        });
    }

    public Context g() {
        return this.f6407a;
    }

    public final /* synthetic */ void j(String str, Map map, String str2, String str3, String str4, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("_event_name_", str);
        hashMap.put("_event_attr_value_", map);
        hashMap.put("_event_type_", "action_x");
        XJDataDispatch.b(this.f6407a, this.b, XJTrackUtil.c(this.f6407a, hashMap, str2, str3, str4), str, z);
    }

    public boolean k(String str, Map map) {
        return m(str, map, false);
    }

    public boolean l(String str, Map map, String str2, String str3, String str4) {
        return n(str, map, false, str2, str3, str4);
    }

    public boolean m(String str, Map map, boolean z) {
        return n(str, map, z, (String) null, (String) null, (String) null);
    }

    public boolean n(String str, Map map, boolean z, String str2, String str3, String str4) {
        if (!XJDataTrackConfig.a()) {
            LogUtil.c("XJDataTrack", "onEvent, isFeatureEnable=false");
            return false;
        } else if (TextUtils.isEmpty(str)) {
            LogUtil.c("XJDataTrack", "onEvent, eventName is empty");
            return false;
        } else {
            a aVar = new a(this, str, map, str2, str3, str4, z);
            if (z) {
                aVar.run();
                return true;
            }
            ThreadUtils.a(aVar);
            return true;
        }
    }

    public boolean o(Map map, String str, String str2, String str3) {
        if (!XJDataTrackConfig.a()) {
            LogUtil.c("XJDataTrack", "onEventByTrack, isFeatureEnable=false");
            return false;
        }
        final String str4 = (String) map.get("_event_name_");
        if (TextUtils.isEmpty(str4)) {
            LogUtil.c("XJDataTrack", "onEventByTrack, eventName is empty");
            return false;
        }
        final Map map2 = map;
        final String str5 = str;
        final String str6 = str2;
        final String str7 = str3;
        ThreadUtils.a(new Runnable() {
            public void run() {
                XJDataDispatch.a(XJDataTrack.this.f6407a, XJDataTrack.this.b, XJTrackUtil.c(XJDataTrack.this.f6407a, map2, str5, str6, str7), str4);
            }
        });
        return true;
    }

    public void p(String str) {
        XJPackageUtil.n(str);
    }

    public final void q(Context context, boolean z) {
        if (!XJDataTrackConfig.a()) {
            LogUtil.c("XJDataTrack", "startTrackJobService, isFeatureEnable=false");
            return;
        }
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService(JobScheduler.class);
        JobInfo.Builder builder = new JobInfo.Builder(1001, new ComponentName(context, TrackJobService.class));
        builder.setRequiredNetworkType(1);
        if (z) {
            builder.setPeriodic(900000);
            LogUtil.a("XJDataTrack", "XJDataTrack: interval:900000");
        } else {
            builder.setPeriodic(900000);
            LogUtil.a("XJDataTrack", "XJDataTrack: interval:900000");
        }
        jobScheduler.schedule(builder.build());
        LogUtil.a("XJDataTrack", "XJDataTrack: startTrackJobService");
    }
}
