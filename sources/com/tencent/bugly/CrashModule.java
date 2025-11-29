package com.tencent.bugly;

import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.at;
import com.tencent.bugly.proguard.o;

public class CrashModule extends o {
    public static final int MODULE_ID = 1004;
    private static int c;
    private static CrashModule e = new CrashModule();

    /* renamed from: a  reason: collision with root package name */
    private long f9499a;
    private BuglyStrategy.a b;
    private boolean d = false;

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0053, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void a(android.content.Context r5, com.tencent.bugly.BuglyStrategy r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r6 != 0) goto L_0x0005
            monitor-exit(r4)
            return
        L_0x0005:
            java.lang.String r0 = r6.getLibBuglySOFilePath()     // Catch:{ all -> 0x001f }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x001f }
            if (r1 != 0) goto L_0x0021
            com.tencent.bugly.proguard.aa r5 = com.tencent.bugly.proguard.aa.a((android.content.Context) r5)     // Catch:{ all -> 0x001f }
            r5.t = r0     // Catch:{ all -> 0x001f }
            java.lang.String r5 = "setted libBugly.so file path :%s"
            java.lang.Object[] r0 = new java.lang.Object[]{r0}     // Catch:{ all -> 0x001f }
            com.tencent.bugly.proguard.al.a((java.lang.String) r5, (java.lang.Object[]) r0)     // Catch:{ all -> 0x001f }
            goto L_0x0021
        L_0x001f:
            r5 = move-exception
            goto L_0x0054
        L_0x0021:
            com.tencent.bugly.BuglyStrategy$a r5 = r6.getCrashHandleCallback()     // Catch:{ all -> 0x001f }
            if (r5 == 0) goto L_0x0035
            com.tencent.bugly.BuglyStrategy$a r5 = r6.getCrashHandleCallback()     // Catch:{ all -> 0x001f }
            r4.b = r5     // Catch:{ all -> 0x001f }
            java.lang.String r5 = "setted CrashHanldeCallback"
            r0 = 0
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ all -> 0x001f }
            com.tencent.bugly.proguard.al.a((java.lang.String) r5, (java.lang.Object[]) r0)     // Catch:{ all -> 0x001f }
        L_0x0035:
            long r0 = r6.getAppReportDelay()     // Catch:{ all -> 0x001f }
            r2 = 0
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 <= 0) goto L_0x0052
            long r5 = r6.getAppReportDelay()     // Catch:{ all -> 0x001f }
            r4.f9499a = r5     // Catch:{ all -> 0x001f }
            java.lang.String r0 = "setted delay: %d"
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x001f }
            java.lang.Object[] r5 = new java.lang.Object[]{r5}     // Catch:{ all -> 0x001f }
            com.tencent.bugly.proguard.al.a((java.lang.String) r0, (java.lang.Object[]) r5)     // Catch:{ all -> 0x001f }
        L_0x0052:
            monitor-exit(r4)
            return
        L_0x0054:
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.CrashModule.a(android.content.Context, com.tencent.bugly.BuglyStrategy):void");
    }

    public static CrashModule getInstance() {
        CrashModule crashModule = e;
        crashModule.id = 1004;
        return crashModule;
    }

    public String[] getTables() {
        return new String[]{"t_cr"};
    }

    public synchronized boolean hasInitialized() {
        return this.d;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00e7, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0099 A[Catch:{ all -> 0x005b }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b0 A[Catch:{ all -> 0x005b }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b8 A[Catch:{ all -> 0x005b }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00bd A[Catch:{ all -> 0x005b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void init(android.content.Context r5, boolean r6, com.tencent.bugly.BuglyStrategy r7) {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r5 == 0) goto L_0x00e6
            boolean r0 = r4.d     // Catch:{ all -> 0x005b }
            if (r0 == 0) goto L_0x0009
            goto L_0x00e6
        L_0x0009:
            java.lang.String r0 = "Initializing crash module."
            r1 = 0
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch:{ all -> 0x005b }
            com.tencent.bugly.proguard.al.a((java.lang.String) r0, (java.lang.Object[]) r2)     // Catch:{ all -> 0x005b }
            com.tencent.bugly.proguard.u r0 = com.tencent.bugly.proguard.u.a()     // Catch:{ all -> 0x005b }
            int r2 = c     // Catch:{ all -> 0x005b }
            r3 = 1
            int r2 = r2 + r3
            c = r2     // Catch:{ all -> 0x005b }
            r0.a((int) r2)     // Catch:{ all -> 0x005b }
            r4.d = r3     // Catch:{ all -> 0x005b }
            com.tencent.bugly.crashreport.CrashReport.setContext(r5)     // Catch:{ all -> 0x005b }
            r4.a(r5, r7)     // Catch:{ all -> 0x005b }
            com.tencent.bugly.BuglyStrategy$a r0 = r4.b     // Catch:{ all -> 0x005b }
            com.tencent.bugly.proguard.at r6 = com.tencent.bugly.proguard.at.a((android.content.Context) r5, (boolean) r6, (com.tencent.bugly.BuglyStrategy.a) r0)     // Catch:{ all -> 0x005b }
            com.tencent.bugly.proguard.av r0 = r6.t     // Catch:{ all -> 0x005b }
            r0.a()     // Catch:{ all -> 0x005b }
            if (r7 == 0) goto L_0x0064
            int r0 = r7.getCallBackType()     // Catch:{ all -> 0x005b }
            r6.B = r0     // Catch:{ all -> 0x005b }
            boolean r0 = r7.getCloseErrorCallback()     // Catch:{ all -> 0x005b }
            r6.C = r0     // Catch:{ all -> 0x005b }
            boolean r0 = r7.isUploadSpotCrash()     // Catch:{ all -> 0x005b }
            com.tencent.bugly.proguard.at.o = r0     // Catch:{ all -> 0x005b }
            com.tencent.bugly.proguard.aa r0 = com.tencent.bugly.proguard.aa.a((android.content.Context) r5)     // Catch:{ all -> 0x005b }
            boolean r2 = r7.isEnableRecordAnrMainStack()     // Catch:{ all -> 0x005b }
            r0.S = r2     // Catch:{ all -> 0x005b }
            boolean r0 = r7.isEnableCatchAnrTrace()     // Catch:{ all -> 0x005b }
            if (r0 != 0) goto L_0x005e
            com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler r0 = r6.u     // Catch:{ all -> 0x005b }
            r0.disableCatchAnrTrace()     // Catch:{ all -> 0x005b }
            goto L_0x0069
        L_0x005b:
            r5 = move-exception
            goto L_0x00e4
        L_0x005e:
            com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler r0 = r6.u     // Catch:{ all -> 0x005b }
            r0.enableCatchAnrTrace()     // Catch:{ all -> 0x005b }
            goto L_0x0069
        L_0x0064:
            com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler r0 = r6.u     // Catch:{ all -> 0x005b }
            r0.enableCatchAnrTrace()     // Catch:{ all -> 0x005b }
        L_0x0069:
            com.tencent.bugly.proguard.aa r0 = com.tencent.bugly.proguard.aa.b()     // Catch:{ all -> 0x005b }
            java.lang.String r0 = r0.d     // Catch:{ all -> 0x005b }
            android.content.Context r2 = r6.c     // Catch:{ all -> 0x005b }
            java.lang.String r2 = com.tencent.bugly.proguard.z.a((android.content.Context) r2)     // Catch:{ all -> 0x005b }
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x005b }
            if (r0 == 0) goto L_0x0080
            com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler r0 = r6.u     // Catch:{ all -> 0x005b }
            r0.removeEmptyNativeRecordFiles()     // Catch:{ all -> 0x005b }
        L_0x0080:
            if (r7 == 0) goto L_0x0094
            boolean r0 = r7.isEnableNativeCrashMonitor()     // Catch:{ all -> 0x005b }
            if (r0 == 0) goto L_0x0089
            goto L_0x0094
        L_0x0089:
            java.lang.String r0 = "[crash] Closed native crash monitor!"
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch:{ all -> 0x005b }
            com.tencent.bugly.proguard.al.a((java.lang.String) r0, (java.lang.Object[]) r2)     // Catch:{ all -> 0x005b }
            r6.d()     // Catch:{ all -> 0x005b }
            goto L_0x0097
        L_0x0094:
            r6.e()     // Catch:{ all -> 0x005b }
        L_0x0097:
            if (r7 == 0) goto L_0x00ab
            boolean r0 = r7.isEnableANRCrashMonitor()     // Catch:{ all -> 0x005b }
            if (r0 == 0) goto L_0x00a0
            goto L_0x00ab
        L_0x00a0:
            java.lang.String r0 = "[crash] Closed ANR monitor!"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x005b }
            com.tencent.bugly.proguard.al.a((java.lang.String) r0, (java.lang.Object[]) r1)     // Catch:{ all -> 0x005b }
            r6.g()     // Catch:{ all -> 0x005b }
            goto L_0x00ae
        L_0x00ab:
            r6.f()     // Catch:{ all -> 0x005b }
        L_0x00ae:
            if (r7 == 0) goto L_0x00b6
            boolean r0 = r7.isMerged()     // Catch:{ all -> 0x005b }
            com.tencent.bugly.proguard.at.e = r0     // Catch:{ all -> 0x005b }
        L_0x00b6:
            if (r7 == 0) goto L_0x00bd
            long r0 = r7.getAppReportDelay()     // Catch:{ all -> 0x005b }
            goto L_0x00bf
        L_0x00bd:
            r0 = 0
        L_0x00bf:
            r6.a((long) r0)     // Catch:{ all -> 0x005b }
            com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler r6 = r6.u     // Catch:{ all -> 0x005b }
            r6.checkUploadRecordCrash()     // Catch:{ all -> 0x005b }
            com.tencent.bugly.proguard.au.a((android.content.Context) r5)     // Catch:{ all -> 0x005b }
            com.tencent.bugly.proguard.aq r6 = com.tencent.bugly.proguard.aq.a()     // Catch:{ all -> 0x005b }
            java.lang.String r7 = "android.net.conn.CONNECTIVITY_CHANGE"
            r6.a((java.lang.String) r7)     // Catch:{ all -> 0x005b }
            r6.a((android.content.Context) r5)     // Catch:{ all -> 0x005b }
            com.tencent.bugly.proguard.u r5 = com.tencent.bugly.proguard.u.a()     // Catch:{ all -> 0x005b }
            int r6 = c     // Catch:{ all -> 0x005b }
            int r6 = r6 - r3
            c = r6     // Catch:{ all -> 0x005b }
            r5.a((int) r6)     // Catch:{ all -> 0x005b }
            monitor-exit(r4)
            return
        L_0x00e4:
            monitor-exit(r4)
            throw r5
        L_0x00e6:
            monitor-exit(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.CrashModule.init(android.content.Context, boolean, com.tencent.bugly.BuglyStrategy):void");
    }

    public void onServerStrategyChanged(StrategyBean strategyBean) {
        at a2;
        if (strategyBean != null && (a2 = at.a()) != null) {
            a2.t.a(strategyBean);
            a2.u.onStrategyChanged(strategyBean);
            a2.x.b();
        }
    }
}
