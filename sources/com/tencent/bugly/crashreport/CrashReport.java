package com.tencent.bugly.crashreport;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.CrashModule;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.h5.H5JavaScriptInterface;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.aa;
import com.tencent.bugly.proguard.ac;
import com.tencent.bugly.proguard.ak;
import com.tencent.bugly.proguard.al;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.ap;
import com.tencent.bugly.proguard.aq;
import com.tencent.bugly.proguard.at;
import com.tencent.bugly.proguard.au;
import com.tencent.bugly.proguard.bc;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.r;
import com.tencent.bugly.proguard.s;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import com.upuphone.starrynet.common.StarryNetConstant;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CrashReport {

    /* renamed from: a  reason: collision with root package name */
    private static Context f9500a;

    public static class CrashHandleCallback extends BuglyStrategy.a {
    }

    public static class UserStrategy extends BuglyStrategy {
        CrashHandleCallback c;

        public UserStrategy(Context context) {
        }

        public synchronized int getCallBackType() {
            return this.f9498a;
        }

        public synchronized boolean getCloseErrorCallback() {
            return this.b;
        }

        public synchronized void setCallBackType(int i) {
            this.f9498a = i;
        }

        public synchronized void setCloseErrorCallback(boolean z) {
            this.b = z;
        }

        public synchronized void setCrashHandleCallback(CrashHandleCallback crashHandleCallback) {
            this.c = crashHandleCallback;
        }

        public synchronized CrashHandleCallback getCrashHandleCallback() {
            return this.c;
        }
    }

    public interface a {
        String a();

        void a(H5JavaScriptInterface h5JavaScriptInterface, String str);

        void a(String str);

        void b();

        CharSequence c();
    }

    public static void closeBugly() {
        if (!p.f9586a) {
            Log.w(al.b, "Can not close bugly because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.w(al.b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else if (f9500a != null) {
            aq a2 = aq.a();
            if (a2 != null) {
                a2.b(f9500a);
            }
            closeCrashReport();
            s.a(f9500a);
            ak a3 = ak.a();
            if (a3 != null) {
                a3.b();
            }
        }
    }

    public static void closeCrashReport() {
        if (!p.f9586a) {
            Log.w(al.b, "Can not close crash report because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.w(al.b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            at.a().c();
        }
    }

    public static void closeNativeReport() {
        if (!p.f9586a) {
            Log.w(al.b, "Can not close native report because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(al.b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            at.a().d();
        }
    }

    public static void enableBugly(boolean z) {
        p.f9586a = z;
    }

    public static void enableObtainId(Context context, boolean z) {
        setCollectPrivacyInfo(context, z);
    }

    public static Set<String> getAllUserDataKeys(Context context) {
        if (!p.f9586a) {
            Log.w(al.b, "Can not get all keys of user data because bugly is disable.");
            return new HashSet();
        } else if (context != null) {
            return aa.a(context).w();
        } else {
            Log.e(al.b, "getAllUserDataKeys args context should not be null");
            return new HashSet();
        }
    }

    public static String getAppChannel() {
        if (!p.f9586a) {
            Log.w(al.b, "Can not get App channel because bugly is disable.");
            return StarryNetConstant.DEVICE_NAME_UNKNOWN;
        } else if (CrashModule.getInstance().hasInitialized()) {
            return aa.a(f9500a).s;
        } else {
            Log.e(al.b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return StarryNetConstant.DEVICE_NAME_UNKNOWN;
        }
    }

    public static String getAppID() {
        if (!p.f9586a) {
            Log.w(al.b, "Can not get App ID because bugly is disable.");
            return StarryNetConstant.DEVICE_NAME_UNKNOWN;
        } else if (CrashModule.getInstance().hasInitialized()) {
            return aa.a(f9500a).e();
        } else {
            Log.e(al.b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return StarryNetConstant.DEVICE_NAME_UNKNOWN;
        }
    }

    public static String getAppVer() {
        if (!p.f9586a) {
            Log.w(al.b, "Can not get app version because bugly is disable.");
            return StarryNetConstant.DEVICE_NAME_UNKNOWN;
        } else if (CrashModule.getInstance().hasInitialized()) {
            return aa.a(f9500a).o;
        } else {
            Log.e(al.b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return StarryNetConstant.DEVICE_NAME_UNKNOWN;
        }
    }

    public static String getBuglyVersion(Context context) {
        if (context != null) {
            return aa.a(context).h;
        }
        al.d("Please call with context.", new Object[0]);
        return StarryNetConstant.DEVICE_NAME_UNKNOWN;
    }

    public static Context getContext() {
        return f9500a;
    }

    public static String getDeviceID(Context context) {
        return aa.a(context).g();
    }

    public static Proxy getHttpProxy() {
        return an.f9531a;
    }

    public static Map<String, String> getSdkExtraData() {
        if (!p.f9586a) {
            Log.w(al.b, "Can not get SDK extra data because bugly is disable.");
            return new HashMap();
        } else if (CrashModule.getInstance().hasInitialized()) {
            return aa.a(f9500a).K;
        } else {
            Log.e(al.b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return null;
        }
    }

    public static String getUserData(Context context, String str) {
        if (!p.f9586a) {
            Log.w(al.b, "Can not get user data because bugly is disable.");
            return StarryNetConstant.DEVICE_NAME_UNKNOWN;
        } else if (context == null) {
            Log.e(al.b, "getUserDataValue args context should not be null");
            return StarryNetConstant.DEVICE_NAME_UNKNOWN;
        } else if (ap.b(str)) {
            return null;
        } else {
            return aa.a(context).g(str);
        }
    }

    public static int getUserDatasSize(Context context) {
        if (!p.f9586a) {
            Log.w(al.b, "Can not get size of user data because bugly is disable.");
            return -1;
        } else if (context != null) {
            return aa.a(context).v();
        } else {
            Log.e(al.b, "getUserDatasSize args context should not be null");
            return -1;
        }
    }

    public static String getUserId() {
        if (!p.f9586a) {
            Log.w(al.b, "Can not get user ID because bugly is disable.");
            return StarryNetConstant.DEVICE_NAME_UNKNOWN;
        } else if (CrashModule.getInstance().hasInitialized()) {
            return aa.a(f9500a).f();
        } else {
            Log.e(al.b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return StarryNetConstant.DEVICE_NAME_UNKNOWN;
        }
    }

    public static int getUserSceneTagId(Context context) {
        if (!p.f9586a) {
            Log.w(al.b, "Can not get user scene tag because bugly is disable.");
            return -1;
        } else if (context != null) {
            return aa.a(context).z();
        } else {
            Log.e(al.b, "getUserSceneTagId args context should not be null");
            return -1;
        }
    }

    public static void initCrashReport(Context context) {
        if (context != null) {
            f9500a = context;
            p.a((o) CrashModule.getInstance());
            p.a(context);
        }
    }

    public static boolean isLastSessionCrash() {
        if (!p.f9586a) {
            Log.w(al.b, "The info 'isLastSessionCrash' is not accurate because bugly is disable.");
            return false;
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(al.b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return false;
        } else {
            at a2 = at.a();
            Boolean bool = a2.A;
            if (bool != null) {
                return bool.booleanValue();
            }
            String str = aa.b().d;
            List<y> a3 = w.a().a(1);
            ArrayList arrayList = new ArrayList();
            if (a3 == null || a3.size() <= 0) {
                a2.A = Boolean.FALSE;
                return false;
            }
            for (y next : a3) {
                if (str.equals(next.c)) {
                    a2.A = Boolean.TRUE;
                    arrayList.add(next);
                }
            }
            if (arrayList.size() > 0) {
                w.a().a((List<y>) arrayList);
            }
            return true;
        }
    }

    public static void postCatchedException(Throwable th) {
        postCatchedException(th, Thread.currentThread());
    }

    public static void postException(Thread thread, int i, String str, String str2, String str3, Map<String, String> map) {
        if (!p.f9586a) {
            Log.w(al.b, "Can not post crash caught because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(al.b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            au.a(thread, i, str, str2, str3, map);
        }
    }

    private static void putSdkData(Context context, String str, String str2) {
        if (context != null && !ap.b(str) && !ap.b(str2)) {
            String replace = str.replace("[a-zA-Z[0-9]]+", "");
            if (replace.length() > 100) {
                Log.w(al.b, String.format("putSdkData key length over limit %d, will be cutted.", new Object[]{50}));
                replace = replace.substring(0, 50);
            }
            if (str2.length() > 500) {
                Log.w(al.b, String.format("putSdkData value length over limit %d, will be cutted!", new Object[]{200}));
                str2 = str2.substring(0, 200);
            }
            aa.a(context).b(replace, str2);
            al.b(String.format("[param] putSdkData data: %s - %s", new Object[]{replace, str2}), new Object[0]);
        }
    }

    public static void putUserData(Context context, String str, String str2) {
        if (!p.f9586a) {
            Log.w(al.b, "Can not put user data because bugly is disable.");
        } else if (context == null) {
            Log.w(al.b, "putUserData args context should not be null");
        } else if (str == null) {
            al.d("putUserData args key should not be null or empty", new Object[0]);
        } else if (str2 == null) {
            al.d("putUserData args value should not be null", new Object[0]);
        } else {
            if (str2.length() > 200) {
                al.d("user data value length over limit %d, it will be cutted!", 200);
                str2 = str2.substring(0, 200);
            }
            aa a2 = aa.a(context);
            if (a2.w().contains(str)) {
                NativeCrashHandler instance = NativeCrashHandler.getInstance();
                if (instance != null) {
                    instance.putKeyValueToNative(str, str2);
                }
                aa.a(context).a(str, str2);
                al.c("replace KV %s %s", str, str2);
            } else if (a2.v() >= 50) {
                al.d("user data size is over limit %d, it will be cutted!", 50);
            } else {
                if (str.length() > 50) {
                    al.d("user data key length over limit %d , will drop this new key %s", 50, str);
                    str = str.substring(0, 50);
                }
                NativeCrashHandler instance2 = NativeCrashHandler.getInstance();
                if (instance2 != null) {
                    instance2.putKeyValueToNative(str, str2);
                }
                aa.a(context).a(str, str2);
                al.b("[param] set user data: %s - %s", str, str2);
            }
        }
    }

    public static String removeUserData(Context context, String str) {
        if (!p.f9586a) {
            Log.w(al.b, "Can not remove user data because bugly is disable.");
            return StarryNetConstant.DEVICE_NAME_UNKNOWN;
        } else if (context == null) {
            Log.e(al.b, "removeUserData args context should not be null");
            return StarryNetConstant.DEVICE_NAME_UNKNOWN;
        } else if (ap.b(str)) {
            return null;
        } else {
            al.b("[param] remove user data: %s", str);
            return aa.a(context).f(str);
        }
    }

    public static void setAllThreadStackEnable(Context context, boolean z, boolean z2) {
        aa a2 = aa.a(context);
        a2.Q = z;
        a2.R = z2;
    }

    public static void setAppChannel(Context context, String str) {
        if (!p.f9586a) {
            Log.w(al.b, "Can not set App channel because Bugly is disable.");
        } else if (context == null) {
            Log.w(al.b, "setAppChannel args context should not be null");
        } else if (str == null) {
            Log.w(al.b, "App channel is null, will not set");
        } else {
            aa.a(context).s = str;
            NativeCrashHandler instance = NativeCrashHandler.getInstance();
            if (instance != null) {
                instance.setNativeAppChannel(str);
            }
        }
    }

    public static void setAppPackage(Context context, String str) {
        if (!p.f9586a) {
            Log.w(al.b, "Can not set App package because bugly is disable.");
        } else if (context == null) {
            Log.w(al.b, "setAppPackage args context should not be null");
        } else if (str == null) {
            Log.w(al.b, "App package is null, will not set");
        } else {
            aa.a(context).c = str;
            NativeCrashHandler instance = NativeCrashHandler.getInstance();
            if (instance != null) {
                instance.setNativeAppPackage(str);
            }
        }
    }

    public static void setAppVersion(Context context, String str) {
        if (!p.f9586a) {
            Log.w(al.b, "Can not set App version because bugly is disable.");
        } else if (context == null) {
            Log.w(al.b, "setAppVersion args context should not be null");
        } else if (str == null) {
            Log.w(al.b, "App version is null, will not set");
        } else {
            aa.a(context).o = str;
            NativeCrashHandler instance = NativeCrashHandler.getInstance();
            if (instance != null) {
                instance.setNativeAppVersion(str);
            }
        }
    }

    public static void setBuglyDbName(String str) {
        if (!p.f9586a) {
            Log.w(al.b, "Can not set DB name because bugly is disable.");
            return;
        }
        Log.i(al.b, "Set Bugly DB name: ".concat(String.valueOf(str)));
        x.f9601a = str;
    }

    public static void setCollectPrivacyInfo(Context context, boolean z) {
        if (!p.f9586a) {
            Log.w(al.b, "Can not set collect privacy info enable because bugly is disable.");
        } else if (context == null) {
            Log.w(al.b, "setCollectPrivacyInfo args context should not be null");
        } else {
            Log.i(al.b, "setCollectPrivacyInfo: ".concat(String.valueOf(z)));
            aa.a(context).n = z;
        }
    }

    public static void setContext(Context context) {
        f9500a = context;
    }

    public static void setCrashFilter(String str) {
        if (!p.f9586a) {
            Log.w(al.b, "Can not set App package because bugly is disable.");
            return;
        }
        Log.i(al.b, "Set crash stack filter: ".concat(String.valueOf(str)));
        at.q = str;
    }

    public static void setCrashRegularFilter(String str) {
        if (!p.f9586a) {
            Log.w(al.b, "Can not set App package because bugly is disable.");
            return;
        }
        Log.i(al.b, "Set crash stack filter: ".concat(String.valueOf(str)));
        at.r = str;
    }

    public static void setDeviceId(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            aa.a(context).a(str);
        }
    }

    public static void setDeviceModel(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            aa.a(context).b(str);
        }
    }

    public static void setDumpFilePath(Context context, String str) {
        if (!p.f9586a) {
            Log.w(al.b, "Can not set App version because bugly is disable.");
        } else if (context == null) {
            Log.w(al.b, "setTombPath args context should not be null");
        } else if (str == null) {
            Log.w(al.b, "tombstone path is null, will not set");
        } else {
            Log.i(al.b, "user set tombstone path: ".concat(str));
            NativeCrashHandler.setDumpFilePath(str);
        }
    }

    public static void setHandleNativeCrashInJava(boolean z) {
        if (!p.f9586a) {
            Log.w(al.b, "Can not set App package because bugly is disable.");
            return;
        }
        Log.i(al.b, "Should handle native crash in Java profile after handled in native profile: ".concat(String.valueOf(z)));
        NativeCrashHandler.setShouldHandleInJava(z);
    }

    public static void setHttpProxy(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            an.f9531a = null;
        } else {
            an.f9531a = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(str, i));
        }
    }

    @Deprecated
    public static void setIsAppForeground(Context context, boolean z) {
        al.a("App fore and back status are no longer supported", new Object[0]);
    }

    public static void setIsDevelopmentDevice(Context context, boolean z) {
        if (!p.f9586a) {
            Log.w(al.b, "Can not set 'isDevelopmentDevice' because bugly is disable.");
        } else if (context == null) {
            al.d("Context should not be null.", new Object[0]);
        } else {
            if (z) {
                al.c("This is a development device.", new Object[0]);
            } else {
                al.c("This is not a development device.", new Object[0]);
            }
            aa.a(context).I = z;
        }
    }

    public static boolean setJavascriptMonitor(WebView webView, boolean z) {
        return setJavascriptMonitor(webView, z, false);
    }

    public static void setSdkExtraData(Context context, String str, String str2) {
        if (!p.f9586a) {
            Log.w(al.b, "Can not put SDK extra data because bugly is disable.");
        } else if (context != null && !ap.b(str) && !ap.b(str2)) {
            aa a2 = aa.a(context);
            if (str != null && str2 != null) {
                synchronized (a2.T) {
                    a2.K.put(str, str2);
                }
            }
        }
    }

    public static void setServerUrl(String str) {
        if (ap.b(str) || !ap.d(str)) {
            Log.i(al.b, "URL is invalid.");
            return;
        }
        ac.a(str);
        StrategyBean.f9504a = str;
        StrategyBean.b = str;
    }

    public static void setSessionIntervalMills(long j) {
        if (!p.f9586a) {
            Log.w(al.b, "Can not set 'SessionIntervalMills' because bugly is disable.");
        } else {
            s.a(j);
        }
    }

    public static void setUserId(String str) {
        if (!p.f9586a) {
            Log.w(al.b, "Can not set user ID because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(al.b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            setUserId(f9500a, str);
        }
    }

    public static void setUserSceneTag(Context context, int i) {
        if (!p.f9586a) {
            Log.w(al.b, "Can not set tag caught because bugly is disable.");
        } else if (context == null) {
            Log.e(al.b, "setTag args context should not be null");
        } else {
            if (i <= 0) {
                al.d("setTag args tagId should > 0", new Object[0]);
            }
            aa a2 = aa.a(context);
            synchronized (a2.U) {
                try {
                    int i2 = a2.w;
                    if (i2 != i) {
                        a2.w = i;
                        al.a("user scene tag %d changed to tag %d", Integer.valueOf(i2), Integer.valueOf(a2.w));
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            al.b("[param] set user scene tag: %d", Integer.valueOf(i));
        }
    }

    public static void startCrashReport() {
        if (!p.f9586a) {
            Log.w(al.b, "Can not start crash report because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.w(al.b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            at.a().b();
        }
    }

    public static void testANRCrash() {
        if (!p.f9586a) {
            Log.w(al.b, "Can not test ANR crash because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(al.b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            al.a("start to create a anr crash for test!", new Object[0]);
            at.a().h();
        }
    }

    public static void testJavaCrash() {
        int i;
        if (!p.f9586a) {
            Log.w(al.b, "Can not test Java crash because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(al.b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            aa b = aa.b();
            if (!(b == null || (i = b.x) == 24096)) {
                b.x = 24096;
                al.a("server scene tag %d changed to tag %d", Integer.valueOf(i), Integer.valueOf(b.x));
            }
            throw new RuntimeException("This Crash create for Test! You can go to Bugly see more detail!");
        }
    }

    public static void testNativeCrash() {
        testNativeCrash(true, true, false);
    }

    public static void uploadUserInfo() {
        if (!p.f9586a) {
            Log.w(al.b, "Can not upload user info because bugly is disable.");
            return;
        }
        r rVar = s.b;
        if (rVar == null) {
            Log.w(al.b, "Can not upload user info because bugly is not init.");
        } else {
            rVar.b();
        }
    }

    public static void postCatchedException(Throwable th, Thread thread) {
        postCatchedException(th, thread, false);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public static boolean setJavascriptMonitor(final WebView webView, boolean z, boolean z2) {
        if (webView == null) {
            Log.w(al.b, "WebView is null.");
            return false;
        }
        webView.getSettings().setSavePassword(false);
        webView.getSettings().setAllowFileAccess(false);
        return setJavascriptMonitor((a) new a() {
            public final String a() {
                return webView.getUrl();
            }

            public final void b() {
                WebSettings settings = webView.getSettings();
                if (!settings.getJavaScriptEnabled()) {
                    settings.setJavaScriptEnabled(true);
                }
            }

            public final CharSequence c() {
                return webView.getContentDescription();
            }

            public final void a(String str) {
                webView.loadUrl(str);
            }

            public final void a(H5JavaScriptInterface h5JavaScriptInterface, String str) {
                webView.addJavascriptInterface(h5JavaScriptInterface, str);
            }
        }, z, z2);
    }

    public static void testNativeCrash(boolean z, boolean z2, boolean z3) {
        if (!p.f9586a) {
            Log.w(al.b, "Can not test native crash because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(al.b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            al.a("start to create a native crash for test!", new Object[0]);
            at.a().a(z, z2, z3);
        }
    }

    public static void postCatchedException(Throwable th, Thread thread, boolean z) {
        if (!p.f9586a) {
            Log.w(al.b, "Can not post crash caught because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(al.b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else if (th == null) {
            al.d("throwable is null, just return", new Object[0]);
        } else {
            if (thread == null) {
                thread = Thread.currentThread();
            }
            at a2 = at.a();
            a2.w.a(new Runnable(thread, th, z) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ boolean f9546a = false;
                final /* synthetic */ Thread b;
                final /* synthetic */ Throwable c;
                final /* synthetic */ String d;
                final /* synthetic */ byte[] e;
                final /* synthetic */ boolean f;
                final /* synthetic */ boolean g;

                {
                    this.b = r2;
                    this.c = r3;
                    this.d = null;
                    this.e = null;
                    this.f = true;
                    this.g = r4;
                }

                public final void run() {
                    try {
                        al.c("post a throwable %b", Boolean.valueOf(this.f9546a));
                        at.this.t.a(this.b, this.c, false, this.d, this.e, this.f);
                        if (this.g) {
                            al.a("clear user datas", new Object[0]);
                            aa.a(at.this.c).u();
                        }
                    } catch (Throwable th) {
                        if (!al.b(th)) {
                            th.printStackTrace();
                        }
                        al.e("java catch error: %s", this.c.toString());
                    }
                }
            });
        }
    }

    public static void initCrashReport(Context context, UserStrategy userStrategy) {
        if (context != null) {
            f9500a = context;
            p.a((o) CrashModule.getInstance());
            p.a(context, userStrategy);
        }
    }

    public static void setHttpProxy(InetAddress inetAddress, int i) {
        if (inetAddress == null) {
            an.f9531a = null;
        } else {
            an.f9531a = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(inetAddress, i));
        }
    }

    public static void postException(int i, String str, String str2, String str3, Map<String, String> map) {
        postException(Thread.currentThread(), i, str, str2, str3, map);
    }

    public static void setUserId(Context context, String str) {
        if (!p.f9586a) {
            Log.w(al.b, "Can not set user ID because bugly is disable.");
        } else if (context == null) {
            Log.e(al.b, "Context should not be null when bugly has not been initialed!");
        } else if (TextUtils.isEmpty(str)) {
            al.d("userId should not be null", new Object[0]);
        } else {
            if (str.length() > 100) {
                String substring = str.substring(0, 100);
                al.d("userId %s length is over limit %d substring to %s", str, 100, substring);
                str = substring;
            }
            if (!str.equals(aa.a(context).f())) {
                aa a2 = aa.a(context);
                synchronized (a2.V) {
                    a2.l = str;
                }
                al.b("[user] set userId : %s", str);
                NativeCrashHandler instance = NativeCrashHandler.getInstance();
                if (instance != null) {
                    instance.setNativeUserId(str);
                }
                if (CrashModule.getInstance().hasInitialized()) {
                    s.a();
                }
            }
        }
    }

    public static Map<String, String> getSdkExtraData(Context context) {
        if (!p.f9586a) {
            Log.w(al.b, "Can not get SDK extra data because bugly is disable.");
            return new HashMap();
        } else if (context != null) {
            return aa.a(context).K;
        } else {
            al.d("Context should not be null.", new Object[0]);
            return null;
        }
    }

    public static void initCrashReport(Context context, String str, boolean z) {
        initCrashReport(context, str, z, (UserStrategy) null);
    }

    public static boolean setJavascriptMonitor(a aVar, boolean z) {
        return setJavascriptMonitor(aVar, z, false);
    }

    public static void initCrashReport(Context context, String str, boolean z, UserStrategy userStrategy) {
        if (context != null) {
            f9500a = context;
            p.a((o) CrashModule.getInstance());
            p.a(context, str, z, userStrategy);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public static boolean setJavascriptMonitor(a aVar, boolean z, boolean z2) {
        if (aVar == null) {
            Log.w(al.b, "WebViewInterface is null.");
            return false;
        } else if (!CrashModule.getInstance().hasInitialized()) {
            al.e("CrashReport has not been initialed! please to call method 'initCrashReport' first!", new Object[0]);
            return false;
        } else {
            al.a("Set Javascript exception monitor of webview.", new Object[0]);
            if (!p.f9586a) {
                Log.w(al.b, "Can not set JavaScript monitor because bugly is disable.");
                return false;
            }
            al.c("URL of webview is %s", aVar.a());
            al.a("Enable the javascript needed by webview monitor.", new Object[0]);
            aVar.b();
            H5JavaScriptInterface instance = H5JavaScriptInterface.getInstance(aVar);
            if (instance != null) {
                al.a("Add a secure javascript interface to the webview.", new Object[0]);
                aVar.a(instance, "exceptionUploader");
            }
            if (!z) {
                return true;
            }
            al.a("Inject bugly.js(v%s) to the webview.", bc.b());
            String a2 = bc.a();
            if (a2 == null) {
                al.e("Failed to inject Bugly.js.", bc.b());
                return false;
            }
            aVar.a("javascript:".concat(a2));
            return true;
        }
    }
}
