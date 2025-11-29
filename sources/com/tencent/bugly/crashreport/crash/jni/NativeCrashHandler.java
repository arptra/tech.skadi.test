package com.tencent.bugly.crashreport.crash.jni;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.aa;
import com.tencent.bugly.proguard.ac;
import com.tencent.bugly.proguard.ak;
import com.tencent.bugly.proguard.al;
import com.tencent.bugly.proguard.ap;
import com.tencent.bugly.proguard.as;
import com.tencent.bugly.proguard.at;
import com.tencent.bugly.proguard.bd;
import com.tencent.bugly.proguard.be;
import com.tencent.bugly.proguard.q;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.time.DateUtils;

public class NativeCrashHandler implements q {
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public static String f9510a = null;
    private static NativeCrashHandler b = null;
    private static int c = 1;
    /* access modifiers changed from: private */
    public static boolean n = true;
    /* access modifiers changed from: private */
    public final Context d;
    private final aa e;
    private final ak f;
    /* access modifiers changed from: private */
    public NativeExceptionHandler g;
    private final boolean h;
    private boolean i = false;
    private boolean j = false;
    private boolean k = false;
    private boolean l = false;
    /* access modifiers changed from: private */
    public as m;

    @SuppressLint({"SdCardPath"})
    private NativeCrashHandler(Context context, aa aaVar, as asVar, ak akVar, boolean z, String str) {
        this.d = ap.a(context);
        if (ap.b(f9510a)) {
            try {
                if (ap.b(str)) {
                    str = context.getDir("bugly", 0).getAbsolutePath();
                }
            } catch (Throwable unused) {
                str = "/data/data/" + aa.a(context).c + "/app_bugly";
            }
            f9510a = str;
        }
        this.m = asVar;
        this.e = aaVar;
        this.f = akVar;
        this.h = z;
        this.g = new bd(context, aaVar, asVar, ac.a());
    }

    public static synchronized String getDumpFilePath() {
        String str;
        synchronized (NativeCrashHandler.class) {
            str = f9510a;
        }
        return str;
    }

    public static synchronized NativeCrashHandler getInstance(Context context, aa aaVar, as asVar, ac acVar, ak akVar, boolean z, String str) {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            try {
                if (b == null) {
                    b = new NativeCrashHandler(context, aaVar, asVar, akVar, z, str);
                }
                nativeCrashHandler = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return nativeCrashHandler;
    }

    private native String getProperties(String str);

    private native String getSoCpuAbi();

    public static boolean isShouldHandleInJava() {
        return n;
    }

    public static synchronized void setDumpFilePath(String str) {
        synchronized (NativeCrashHandler.class) {
            f9510a = str;
        }
    }

    public static void setShouldHandleInJava(boolean z) {
        n = z;
        NativeCrashHandler nativeCrashHandler = b;
        if (nativeCrashHandler != null) {
            nativeCrashHandler.a(999, String.valueOf(z));
        }
    }

    public boolean appendLogToNative(String str, String str2, String str3) {
        Class<String> cls = String.class;
        if (!((!this.i && !this.j) || str == null || str2 == null || str3 == null)) {
            try {
                if (this.j) {
                    return appendNativeLog(str, str2, str3);
                }
                Boolean bool = (Boolean) ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "appendNativeLog", new Class[]{cls, cls, cls}, new Object[]{str, str2, str3});
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (UnsatisfiedLinkError unused) {
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return false;
    }

    public native boolean appendNativeLog(String str, String str2, String str3);

    public native boolean appendWholeNativeLog(String str);

    public void checkUploadRecordCrash() {
        this.f.a(new Runnable() {
            public final void run() {
                if (!ap.a(NativeCrashHandler.this.d, "native_record_lock")) {
                    al.a("[Native] Failed to lock file for handling native crash record.", new Object[0]);
                    return;
                }
                if (!NativeCrashHandler.n) {
                    boolean unused = NativeCrashHandler.this.a(999, BooleanUtils.FALSE);
                }
                CrashDetailBean a2 = be.a(NativeCrashHandler.this.d, NativeCrashHandler.f9510a, NativeCrashHandler.this.g);
                if (a2 != null) {
                    al.a("[Native] Get crash from native record.", new Object[0]);
                    if (!NativeCrashHandler.this.m.a(a2, true)) {
                        NativeCrashHandler.this.m.b(a2, false);
                    }
                    be.a(false, NativeCrashHandler.f9510a);
                }
                NativeCrashHandler nativeCrashHandler = NativeCrashHandler.this;
                long b = ap.b() - at.j;
                long b2 = ap.b() + DateUtils.MILLIS_PER_DAY;
                File file = new File(NativeCrashHandler.f9510a);
                if (file.exists() && file.isDirectory()) {
                    try {
                        File[] listFiles = file.listFiles();
                        if (listFiles != null) {
                            if (listFiles.length != 0) {
                                Arrays.sort(listFiles, new Comparator<File>() {
                                    public final /* synthetic */ int compare(Object obj, Object obj2) {
                                        return Long.compare(((File) obj2).lastModified(), ((File) obj).lastModified());
                                    }
                                });
                                long j = 0;
                                int i = 0;
                                int i2 = 0;
                                for (File file2 : listFiles) {
                                    long lastModified = file2.lastModified();
                                    j += file2.length();
                                    if (lastModified >= b && lastModified < b2) {
                                        if (j < at.i) {
                                        }
                                    }
                                    al.a("[Native] Delete record file: %s", file2.getAbsolutePath());
                                    i++;
                                    if (file2.delete()) {
                                        i2++;
                                    }
                                }
                                al.c("[Native] Number of record files overdue: %d, has deleted: %d", Integer.valueOf(i), Integer.valueOf(i2));
                            }
                        }
                    } catch (Throwable th) {
                        al.a(th);
                    }
                }
                ap.b(NativeCrashHandler.this.d, "native_record_lock");
            }
        });
    }

    public void disableCatchAnrTrace() {
        c = 1;
    }

    public void dumpAnrNativeStack() {
        a(19, "1");
    }

    public void enableCatchAnrTrace() {
        c |= 2;
    }

    public boolean filterSigabrtSysLog() {
        return a(998, BooleanUtils.TRUE);
    }

    public String getLogFromNative() {
        if (!this.i && !this.j) {
            return null;
        }
        try {
            return this.j ? getNativeLog() : (String) ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "getNativeLog", (Class<?>[]) null, (Object[]) null);
        } catch (UnsatisfiedLinkError unused) {
            return null;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public NativeExceptionHandler getNativeExceptionHandler() {
        return this.g;
    }

    public native String getNativeKeyValueList();

    public native String getNativeLog();

    public String getRunningCpuAbi() {
        try {
            return getSoCpuAbi();
        } catch (Throwable unused) {
            al.d("get so cpu abi failed，please upgrade bugly so version", new Object[0]);
            return "";
        }
    }

    public String getSystemProperty(String str) {
        return (this.j || this.i) ? getProperties(str) : "fail";
    }

    public boolean isEnableCatchAnrTrace() {
        return (c & 2) == 2;
    }

    public synchronized boolean isUserOpened() {
        return this.l;
    }

    public synchronized void onStrategyChanged(StrategyBean strategyBean) {
        if (strategyBean != null) {
            try {
                boolean z = strategyBean.f;
                if (z != this.k) {
                    al.d("server native changed to %b", Boolean.valueOf(z));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        boolean z2 = ac.a().c().f && this.l;
        if (z2 != this.k) {
            al.a("native changed to %b", Boolean.valueOf(z2));
            b(z2);
        }
    }

    public boolean putKeyValueToNative(String str, String str2) {
        Class<String> cls = String.class;
        if (!((!this.i && !this.j) || str == null || str2 == null)) {
            try {
                if (this.j) {
                    return putNativeKeyValue(str, str2);
                }
                Boolean bool = (Boolean) ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "putNativeKeyValue", new Class[]{cls, cls}, new Object[]{str, str2});
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (UnsatisfiedLinkError unused) {
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return false;
    }

    public native boolean putNativeKeyValue(String str, String str2);

    public native String regist(String str, boolean z, int i2);

    public void removeEmptyNativeRecordFiles() {
        be.c(f9510a);
    }

    public native String removeNativeKeyValue(String str);

    public void resendSigquit() {
        a(20, "");
    }

    public boolean setNativeAppChannel(String str) {
        return a(12, str);
    }

    public boolean setNativeAppPackage(String str) {
        return a(13, str);
    }

    public boolean setNativeAppVersion(String str) {
        return a(10, str);
    }

    public native void setNativeInfo(int i2, String str);

    public boolean setNativeIsAppForeground(boolean z) {
        return a(14, z ? BooleanUtils.TRUE : BooleanUtils.FALSE);
    }

    public boolean setNativeLaunchTime(long j2) {
        try {
            return a(15, String.valueOf(j2));
        } catch (NumberFormatException e2) {
            if (al.a(e2)) {
                return false;
            }
            e2.printStackTrace();
            return false;
        }
    }

    public boolean setNativeUserId(String str) {
        return a(11, str);
    }

    public synchronized void setUserOpened(boolean z) {
        try {
            c(z);
            boolean isUserOpened = isUserOpened();
            ac a2 = ac.a();
            if (a2 != null) {
                isUserOpened = isUserOpened && a2.c().f;
            }
            if (isUserOpened != this.k) {
                al.a("native changed to %b", Boolean.valueOf(isUserOpened));
                b(isUserOpened);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:29:0x0055=Splitter:B:29:0x0055, B:33:0x008a=Splitter:B:33:0x008a} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void startNativeMonitor() {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.j     // Catch:{ all -> 0x0025 }
            if (r0 != 0) goto L_0x008a
            boolean r0 = r4.i     // Catch:{ all -> 0x0025 }
            if (r0 == 0) goto L_0x000b
            goto L_0x008a
        L_0x000b:
            com.tencent.bugly.proguard.aa r0 = r4.e     // Catch:{ all -> 0x0025 }
            java.lang.String r0 = r0.t     // Catch:{ all -> 0x0025 }
            boolean r0 = com.tencent.bugly.proguard.ap.b((java.lang.String) r0)     // Catch:{ all -> 0x0025 }
            r1 = 0
            r0 = r0 ^ 1
            boolean r2 = com.tencent.bugly.proguard.at.b     // Catch:{ all -> 0x0025 }
            if (r2 == 0) goto L_0x0038
            java.lang.String r2 = "Bugly_Native"
            java.lang.String r3 = "NativeRQD"
            if (r0 == 0) goto L_0x0027
            com.tencent.bugly.proguard.aa r2 = r4.e     // Catch:{ all -> 0x0025 }
            java.lang.String r2 = r2.t     // Catch:{ all -> 0x0025 }
            goto L_0x0027
        L_0x0025:
            r0 = move-exception
            goto L_0x0091
        L_0x0027:
            boolean r2 = a((java.lang.String) r2, (boolean) r0)     // Catch:{ all -> 0x0025 }
            r4.j = r2     // Catch:{ all -> 0x0025 }
            if (r2 != 0) goto L_0x004b
            if (r0 != 0) goto L_0x004b
            boolean r0 = a((java.lang.String) r3, (boolean) r1)     // Catch:{ all -> 0x0025 }
            r4.i = r0     // Catch:{ all -> 0x0025 }
            goto L_0x004b
        L_0x0038:
            java.lang.String r1 = "Bugly_Native"
            com.tencent.bugly.proguard.aa r2 = r4.e     // Catch:{ all -> 0x0025 }
            java.lang.String r3 = r2.t     // Catch:{ all -> 0x0025 }
            if (r0 != 0) goto L_0x0044
            r2.getClass()     // Catch:{ all -> 0x0025 }
            goto L_0x0045
        L_0x0044:
            r1 = r3
        L_0x0045:
            boolean r0 = a((java.lang.String) r1, (boolean) r0)     // Catch:{ all -> 0x0025 }
            r4.j = r0     // Catch:{ all -> 0x0025 }
        L_0x004b:
            boolean r0 = r4.j     // Catch:{ all -> 0x0025 }
            if (r0 != 0) goto L_0x0055
            boolean r0 = r4.i     // Catch:{ all -> 0x0025 }
            if (r0 != 0) goto L_0x0055
            monitor-exit(r4)
            return
        L_0x0055:
            boolean r0 = r4.h     // Catch:{ all -> 0x0025 }
            r4.a((boolean) r0)     // Catch:{ all -> 0x0025 }
            com.tencent.bugly.proguard.aa r0 = r4.e     // Catch:{ all -> 0x0025 }
            java.lang.String r0 = r0.o     // Catch:{ all -> 0x0025 }
            r4.setNativeAppVersion(r0)     // Catch:{ all -> 0x0025 }
            com.tencent.bugly.proguard.aa r0 = r4.e     // Catch:{ all -> 0x0025 }
            java.lang.String r0 = r0.s     // Catch:{ all -> 0x0025 }
            r4.setNativeAppChannel(r0)     // Catch:{ all -> 0x0025 }
            com.tencent.bugly.proguard.aa r0 = r4.e     // Catch:{ all -> 0x0025 }
            java.lang.String r0 = r0.c     // Catch:{ all -> 0x0025 }
            r4.setNativeAppPackage(r0)     // Catch:{ all -> 0x0025 }
            com.tencent.bugly.proguard.aa r0 = r4.e     // Catch:{ all -> 0x0025 }
            java.lang.String r0 = r0.f()     // Catch:{ all -> 0x0025 }
            r4.setNativeUserId(r0)     // Catch:{ all -> 0x0025 }
            com.tencent.bugly.proguard.aa r0 = r4.e     // Catch:{ all -> 0x0025 }
            boolean r0 = r0.a()     // Catch:{ all -> 0x0025 }
            r4.setNativeIsAppForeground(r0)     // Catch:{ all -> 0x0025 }
            com.tencent.bugly.proguard.aa r0 = r4.e     // Catch:{ all -> 0x0025 }
            long r0 = r0.f9513a     // Catch:{ all -> 0x0025 }
            r4.setNativeLaunchTime(r0)     // Catch:{ all -> 0x0025 }
            monitor-exit(r4)
            return
        L_0x008a:
            boolean r0 = r4.h     // Catch:{ all -> 0x0025 }
            r4.a((boolean) r0)     // Catch:{ all -> 0x0025 }
            monitor-exit(r4)
            return
        L_0x0091:
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.startNativeMonitor():void");
    }

    public native void testCrash();

    public void testNativeCrash() {
        if (!this.j) {
            al.d("[Native] Bugly SO file has not been load.", new Object[0]);
        } else {
            testCrash();
        }
    }

    public void unBlockSigquit(boolean z) {
        if (z) {
            a(21, BooleanUtils.TRUE);
        } else {
            a(21, BooleanUtils.FALSE);
        }
    }

    public native String unregist();

    private synchronized void c() {
        if (!this.k) {
            al.d("[Native] Native crash report has already unregistered.", new Object[0]);
            return;
        }
        try {
            if (unregist() != null) {
                al.a("[Native] Successfully closed native crash report.", new Object[0]);
                this.k = false;
                return;
            }
        } catch (Throwable unused) {
            al.c("[Native] Failed to close native crash report.", new Object[0]);
        }
        try {
            ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", new Class[]{Boolean.TYPE}, new Object[]{Boolean.FALSE});
            this.k = false;
            al.a("[Native] Successfully closed native crash report.", new Object[0]);
            return;
        } catch (Throwable unused2) {
            al.c("[Native] Failed to close native crash report.", new Object[0]);
            this.j = false;
            this.i = false;
            return;
        }
    }

    private synchronized void b(boolean z) {
        if (z) {
            startNativeMonitor();
        } else {
            c();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:8|9|10|(3:12|13|(4:15|(1:19)|20|(1:22)))(2:29|(7:31|32|33|(1:35)(1:36)|37|(1:39)|(4:41|(1:43)(1:44)|45|(1:47))))|50|51|52|53) */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0073, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0118, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:50:0x0119 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void a(boolean r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            boolean r0 = r11.k     // Catch:{ all -> 0x000f }
            r1 = 0
            if (r0 == 0) goto L_0x0012
            java.lang.String r12 = "[Native] Native crash report has already registered."
            java.lang.Object[] r0 = new java.lang.Object[r1]     // Catch:{ all -> 0x000f }
            com.tencent.bugly.proguard.al.d(r12, r0)     // Catch:{ all -> 0x000f }
            monitor-exit(r11)
            return
        L_0x000f:
            r12 = move-exception
            goto L_0x011f
        L_0x0012:
            boolean r0 = r11.j     // Catch:{ all -> 0x000f }
            r2 = 1
            if (r0 == 0) goto L_0x007d
            java.lang.String r0 = f9510a     // Catch:{ all -> 0x0074 }
            int r3 = c     // Catch:{ all -> 0x0074 }
            java.lang.String r12 = r11.regist(r0, r12, r3)     // Catch:{ all -> 0x0074 }
            if (r12 == 0) goto L_0x0119
            java.lang.String r0 = "[Native] Native Crash Report enable."
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ all -> 0x0074 }
            com.tencent.bugly.proguard.al.a((java.lang.String) r0, (java.lang.Object[]) r3)     // Catch:{ all -> 0x0074 }
            com.tencent.bugly.proguard.aa r0 = r11.e     // Catch:{ all -> 0x0074 }
            r0.u = r12     // Catch:{ all -> 0x0074 }
            java.lang.String r0 = "-"
            java.lang.String r12 = r0.concat(r12)     // Catch:{ all -> 0x0074 }
            boolean r0 = com.tencent.bugly.proguard.at.b     // Catch:{ all -> 0x0074 }
            if (r0 != 0) goto L_0x0054
            com.tencent.bugly.proguard.aa r0 = r11.e     // Catch:{ all -> 0x0074 }
            java.lang.String r0 = r0.h     // Catch:{ all -> 0x0074 }
            boolean r12 = r0.contains(r12)     // Catch:{ all -> 0x0074 }
            if (r12 != 0) goto L_0x0054
            com.tencent.bugly.proguard.aa r12 = r11.e     // Catch:{ all -> 0x0074 }
            java.lang.String r0 = r12.h     // Catch:{ all -> 0x0074 }
            java.lang.String r3 = "-"
            java.lang.String r0 = r0.concat(r3)     // Catch:{ all -> 0x0074 }
            com.tencent.bugly.proguard.aa r3 = r11.e     // Catch:{ all -> 0x0074 }
            java.lang.String r3 = r3.u     // Catch:{ all -> 0x0074 }
            java.lang.String r0 = r0.concat(r3)     // Catch:{ all -> 0x0074 }
            r12.h = r0     // Catch:{ all -> 0x0074 }
        L_0x0054:
            java.lang.String r12 = "comInfo.sdkVersion %s"
            com.tencent.bugly.proguard.aa r0 = r11.e     // Catch:{ all -> 0x0074 }
            java.lang.String r0 = r0.h     // Catch:{ all -> 0x0074 }
            java.lang.Object[] r0 = new java.lang.Object[]{r0}     // Catch:{ all -> 0x0074 }
            com.tencent.bugly.proguard.al.a((java.lang.String) r12, (java.lang.Object[]) r0)     // Catch:{ all -> 0x0074 }
            r11.k = r2     // Catch:{ all -> 0x0074 }
            java.lang.String r12 = r11.getRunningCpuAbi()     // Catch:{ all -> 0x0074 }
            boolean r0 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x0074 }
            if (r0 != 0) goto L_0x0072
            com.tencent.bugly.proguard.aa r0 = r11.e     // Catch:{ all -> 0x0074 }
            r0.e(r12)     // Catch:{ all -> 0x0074 }
        L_0x0072:
            monitor-exit(r11)
            return
        L_0x0074:
            java.lang.String r12 = "[Native] Failed to load Bugly SO file."
            java.lang.Object[] r0 = new java.lang.Object[r1]     // Catch:{ all -> 0x000f }
            com.tencent.bugly.proguard.al.c(r12, r0)     // Catch:{ all -> 0x000f }
            goto L_0x0119
        L_0x007d:
            boolean r0 = r11.i     // Catch:{ all -> 0x000f }
            if (r0 == 0) goto L_0x0119
            java.lang.String r0 = "com.tencent.feedback.eup.jni.NativeExceptionUpload"
            java.lang.String r3 = "registNativeExceptionHandler2"
            java.lang.Class<java.lang.String> r4 = java.lang.String.class
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch:{ all -> 0x0119 }
            java.lang.Class[] r4 = new java.lang.Class[]{r4, r5, r6, r6}     // Catch:{ all -> 0x0119 }
            java.lang.String r5 = f9510a     // Catch:{ all -> 0x0119 }
            java.lang.String r7 = com.tencent.bugly.proguard.ab.d()     // Catch:{ all -> 0x0119 }
            r8 = 5
            if (r12 == 0) goto L_0x009a
            r9 = r2
            goto L_0x009b
        L_0x009a:
            r9 = r8
        L_0x009b:
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0119 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0119 }
            java.lang.Object[] r5 = new java.lang.Object[]{r5, r7, r9, r10}     // Catch:{ all -> 0x0119 }
            java.lang.Object r0 = com.tencent.bugly.proguard.ap.a(r0, r3, r4, r5)     // Catch:{ all -> 0x0119 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0119 }
            if (r0 != 0) goto L_0x00d6
            java.lang.String r0 = "com.tencent.feedback.eup.jni.NativeExceptionUpload"
            java.lang.String r3 = "registNativeExceptionHandler"
            java.lang.Class<java.lang.String> r4 = java.lang.String.class
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            java.lang.Class[] r4 = new java.lang.Class[]{r4, r5, r6}     // Catch:{ all -> 0x0119 }
            java.lang.String r5 = f9510a     // Catch:{ all -> 0x0119 }
            java.lang.String r7 = com.tencent.bugly.proguard.ab.d()     // Catch:{ all -> 0x0119 }
            com.tencent.bugly.proguard.aa.b()     // Catch:{ all -> 0x0119 }
            int r9 = com.tencent.bugly.proguard.aa.B()     // Catch:{ all -> 0x0119 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0119 }
            java.lang.Object[] r5 = new java.lang.Object[]{r5, r7, r9}     // Catch:{ all -> 0x0119 }
            java.lang.Object r0 = com.tencent.bugly.proguard.ap.a(r0, r3, r4, r5)     // Catch:{ all -> 0x0119 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0119 }
        L_0x00d6:
            if (r0 == 0) goto L_0x0119
            r11.k = r2     // Catch:{ all -> 0x0119 }
            com.tencent.bugly.proguard.aa r3 = r11.e     // Catch:{ all -> 0x0119 }
            r3.u = r0     // Catch:{ all -> 0x0119 }
            java.lang.String r0 = "com.tencent.feedback.eup.jni.NativeExceptionUpload"
            java.lang.String r3 = "enableHandler"
            java.lang.Class r4 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x0119 }
            java.lang.Class[] r4 = new java.lang.Class[]{r4}     // Catch:{ all -> 0x0119 }
            java.lang.Boolean r5 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0119 }
            java.lang.Object[] r5 = new java.lang.Object[]{r5}     // Catch:{ all -> 0x0119 }
            com.tencent.bugly.proguard.ap.a(r0, r3, r4, r5)     // Catch:{ all -> 0x0119 }
            if (r12 == 0) goto L_0x00f4
            goto L_0x00f5
        L_0x00f4:
            r2 = r8
        L_0x00f5:
            java.lang.String r12 = "com.tencent.feedback.eup.jni.NativeExceptionUpload"
            java.lang.String r0 = "setLogMode"
            java.lang.Class[] r3 = new java.lang.Class[]{r6}     // Catch:{ all -> 0x0119 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0119 }
            java.lang.Object[] r2 = new java.lang.Object[]{r2}     // Catch:{ all -> 0x0119 }
            com.tencent.bugly.proguard.ap.a(r12, r0, r3, r2)     // Catch:{ all -> 0x0119 }
            java.lang.String r12 = r11.getRunningCpuAbi()     // Catch:{ all -> 0x0119 }
            boolean r0 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x0119 }
            if (r0 != 0) goto L_0x0117
            com.tencent.bugly.proguard.aa r0 = r11.e     // Catch:{ all -> 0x0119 }
            r0.e(r12)     // Catch:{ all -> 0x0119 }
        L_0x0117:
            monitor-exit(r11)
            return
        L_0x0119:
            r11.j = r1     // Catch:{ all -> 0x000f }
            r11.i = r1     // Catch:{ all -> 0x000f }
            monitor-exit(r11)
            return
        L_0x011f:
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.a(boolean):void");
    }

    public static synchronized NativeCrashHandler getInstance() {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            nativeCrashHandler = b;
        }
        return nativeCrashHandler;
    }

    public void testNativeCrash(boolean z, boolean z2, boolean z3) {
        a(16, String.valueOf(z));
        a(17, String.valueOf(z2));
        a(18, String.valueOf(z3));
        testNativeCrash();
    }

    private synchronized void c(boolean z) {
        if (this.l != z) {
            al.a("user change native %b", Boolean.valueOf(z));
            this.l = z;
        }
    }

    private static boolean a(String str, boolean z) {
        boolean z2;
        try {
            al.a("[Native] Trying to load so: %s", str);
            if (z) {
                System.load(str);
            } else {
                System.loadLibrary(str);
            }
            try {
                al.a("[Native] Successfully loaded SO: %s", str);
                return true;
            } catch (Throwable th) {
                Throwable th2 = th;
                z2 = true;
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            z2 = false;
            al.d(th.getMessage(), new Object[0]);
            al.d("[Native] Failed to load so: %s", str);
            return z2;
        }
    }

    /* access modifiers changed from: private */
    public boolean a(int i2, String str) {
        if (!this.j) {
            return false;
        }
        try {
            setNativeInfo(i2, str);
            return true;
        } catch (UnsatisfiedLinkError unused) {
            return false;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }
}
