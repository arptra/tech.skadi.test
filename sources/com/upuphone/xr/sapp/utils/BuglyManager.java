package com.upuphone.xr.sapp.utils;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Printer;
import com.honey.account.w8.a;
import com.honey.account.w8.b;
import com.honey.account.w8.c;
import com.tencent.bugly.crashreport.CrashReport;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.MainApplication;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\"#$B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\r\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0003J\u0019\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\u0003J\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0003R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u0017R\u0016\u0010 \u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u0017R\u0016\u0010!\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0017¨\u0006%"}, d2 = {"Lcom/upuphone/xr/sapp/utils/BuglyManager;", "", "<init>", "()V", "", "n", "j", "", "pid", "", "i", "(I)Ljava/lang/String;", "l", "command", "f", "(Ljava/lang/String;)V", "Landroid/content/Context;", "context", "g", "(Landroid/content/Context;)V", "m", "", "b", "Z", "buglyInit", "", "c", "J", "buglyInitTime", "d", "buglyStarted", "e", "logcatInit", "monitorMainlooperInit", "ByglyLogPrinter", "SlowDispatch2Throwable", "ThreadLooperWatchdog", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nBuglyManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BuglyManager.kt\ncom/upuphone/xr/sapp/utils/BuglyManager\n+ 2 Strings.kt\nkotlin/text/StringsKt__StringsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,349:1\n107#2:350\n79#2,22:351\n1#3:373\n*S KotlinDebug\n*F\n+ 1 BuglyManager.kt\ncom/upuphone/xr/sapp/utils/BuglyManager\n*L\n74#1:350\n74#1:351,22\n*E\n"})
public final class BuglyManager {

    /* renamed from: a  reason: collision with root package name */
    public static final BuglyManager f7849a = new BuglyManager();
    public static boolean b;
    public static long c = -1;
    public static boolean d = true;
    public static boolean e;
    public static boolean f;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078\u0002XD¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\t¨\u0006\r"}, d2 = {"Lcom/upuphone/xr/sapp/utils/BuglyManager$ByglyLogPrinter;", "Landroid/util/Printer;", "", "str", "", "println", "(Ljava/lang/String;)V", "", "a", "J", "SLOW_LOG_THRESHOLD_MS", "b", "mStartTime", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class ByglyLogPrinter implements Printer {

        /* renamed from: a  reason: collision with root package name */
        public final long f7850a;
        public long b;

        public void println(String str) {
            if (this.b <= 0) {
                this.b = SystemClock.uptimeMillis();
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            if (uptimeMillis - this.b <= this.f7850a || str == null || !StringsKt.startsWith$default(str, "<<<<< Finished to ", false, 2, (Object) null)) {
                this.b = uptimeMillis;
                return;
            }
            ULog.Delegate delegate = ULog.f6446a;
            long j = uptimeMillis - this.b;
            delegate.o("BuglyManager", "Dispatch slow took " + j + "ms, " + str);
            this.b = 0;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/utils/BuglyManager$SlowDispatch2Throwable;", "", "message", "", "(Ljava/lang/String;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class SlowDispatch2Throwable extends Throwable {
        public SlowDispatch2Throwable(@Nullable String str) {
            super(str);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\r\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0003R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u00020\u00078\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/upuphone/xr/sapp/utils/BuglyManager$ThreadLooperWatchdog;", "", "<init>", "()V", "", "g", "h", "Landroid/os/Handler;", "b", "Landroid/os/Handler;", "mWatchHandler", "c", "mMainLooperHandler", "", "d", "J", "CHECK_INTERVAL_MS", "e", "SLOW_DISPATCH_MS", "f", "lastReportTime", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class ThreadLooperWatchdog {

        /* renamed from: a  reason: collision with root package name */
        public static final ThreadLooperWatchdog f7851a = new ThreadLooperWatchdog();
        public static Handler b;
        public static Handler c;
        public static final long d = 3000;
        public static final long e = 300;
        public static long f = -3600000;

        public final void g() {
            StringBuilder sb = new StringBuilder();
            SlowDispatch2Throwable slowDispatch2Throwable = new SlowDispatch2Throwable("Mainlooper Dispatch Slow");
            Looper mainLooper = Looper.getMainLooper();
            Ref.IntRef intRef = new Ref.IntRef();
            StackTraceElement[] stackTrace = mainLooper.getThread().getStackTrace();
            if (stackTrace != null) {
                slowDispatch2Throwable.setStackTrace(stackTrace);
            }
            mainLooper.dump(new BuglyManager$ThreadLooperWatchdog$dispatchSlow$2(intRef, sb), "BuglyManager");
            ULog.Delegate delegate = ULog.f6446a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("current mainlooper messages ");
            sb2.append(intRef.element - 1);
            sb2.append(": \n");
            sb2.append(sb);
            delegate.p("BuglyManager", sb2.toString(), slowDispatch2Throwable);
            if (!BuildConfig.f6575a.booleanValue() && BuglyManager.b && SystemClock.uptimeMillis() - BuglyManager.c > 20000 && SystemClock.uptimeMillis() - f > 3600000) {
                String stackTraceToString = ExceptionsKt.stackTraceToString(slowDispatch2Throwable);
                if (StringsKt.contains$default((CharSequence) stackTraceToString, (CharSequence) "java.lang.ThreadGroup.uncaughtException", false, 2, (Object) null)) {
                    return;
                }
                if (!StringsKt.contains$default((CharSequence) stackTraceToString, (CharSequence) "android.os.MessageQueue.nativePollOnce", false, 2, (Object) null) || intRef.element >= 40) {
                    CrashReport.postCatchedException(slowDispatch2Throwable, mainLooper.getThread());
                    f = SystemClock.uptimeMillis();
                    delegate.o("BuglyManager", "post Dispatch Slow Info to bugly service");
                }
            }
        }

        public final void h() {
            new BuglyManager$ThreadLooperWatchdog$start$1().start();
        }
    }

    public static final void h(Context context) {
        Intrinsics.checkNotNullParameter(context, "$context");
        String str = context.getFilesDir() + "/ulog/logcat/";
        if (PhoneTypeUtils.f7912a.l()) {
            String str2 = "logcat -d *:D -f " + str + "logcat -r 1024 -n 10";
            while (true) {
                BuglyManager buglyManager = f7849a;
                buglyManager.f("mkdir -p " + str);
                buglyManager.f(str2);
                Thread.sleep(30000);
            }
        } else {
            String str3 = "logcat *:D -f " + str + "logcat -r 1024 -n 10";
            while (true) {
                for (int i = 0; i < 5; i++) {
                    BuglyManager buglyManager2 = f7849a;
                    buglyManager2.f("mkdir -p " + str);
                    buglyManager2.f(str3);
                    ULog.f6446a.g("BuglyManager", "execute logcat command exit, try again");
                }
                ULog.f6446a.c("BuglyManager", "execute logcat command exit too many times, just wait some time");
                Thread.sleep(5000);
            }
        }
    }

    public static final void k() {
        f7849a.m();
    }

    public static final void o() {
        f7849a.l();
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0067 A[SYNTHETIC, Splitter:B:21:0x0067] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006d A[SYNTHETIC, Splitter:B:24:0x006d] */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f(java.lang.String r7) {
        /*
            r6 = this;
            com.upuphone.star.core.log.ULog$Delegate r6 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "executeCommand start "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "BuglyManager"
            r6.g(r1, r0)
            r0 = 0
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch:{ Exception -> 0x0061 }
            java.lang.Process r2 = r2.exec(r7)     // Catch:{ Exception -> 0x0061 }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0061 }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0061 }
            java.io.InputStream r5 = r2.getInputStream()     // Catch:{ Exception -> 0x0061 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x0061 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x0061 }
            java.lang.String r0 = r3.readLine()     // Catch:{ Exception -> 0x003c, all -> 0x0039 }
            if (r0 == 0) goto L_0x003f
            r6.g(r1, r0)     // Catch:{ Exception -> 0x003c, all -> 0x0039 }
            goto L_0x003f
        L_0x0039:
            r6 = move-exception
            r0 = r3
            goto L_0x006b
        L_0x003c:
            r6 = move-exception
            r0 = r3
            goto L_0x0062
        L_0x003f:
            r2.waitFor()     // Catch:{ Exception -> 0x003c, all -> 0x0039 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x003c, all -> 0x0039 }
            r0.<init>()     // Catch:{ Exception -> 0x003c, all -> 0x0039 }
            java.lang.String r2 = "executeCommand finish "
            r0.append(r2)     // Catch:{ Exception -> 0x003c, all -> 0x0039 }
            r0.append(r7)     // Catch:{ Exception -> 0x003c, all -> 0x0039 }
            java.lang.String r7 = r0.toString()     // Catch:{ Exception -> 0x003c, all -> 0x0039 }
            r6.g(r1, r7)     // Catch:{ Exception -> 0x003c, all -> 0x0039 }
            r3.close()     // Catch:{ IOException -> 0x005a }
            goto L_0x006a
        L_0x005a:
            r6 = move-exception
            r6.printStackTrace()
            goto L_0x006a
        L_0x005f:
            r6 = move-exception
            goto L_0x006b
        L_0x0061:
            r6 = move-exception
        L_0x0062:
            r6.printStackTrace()     // Catch:{ all -> 0x005f }
            if (r0 == 0) goto L_0x006a
            r0.close()     // Catch:{ IOException -> 0x005a }
        L_0x006a:
            return
        L_0x006b:
            if (r0 == 0) goto L_0x0075
            r0.close()     // Catch:{ IOException -> 0x0071 }
            goto L_0x0075
        L_0x0071:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0075:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.utils.BuglyManager.f(java.lang.String):void");
    }

    public final void g(Context context) {
        if (!e) {
            e = true;
            ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
            Intrinsics.checkNotNullExpressionValue(newSingleThreadExecutor, "newSingleThreadExecutor(...)");
            newSingleThreadExecutor.execute(new c(context));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0077 A[SYNTHETIC, Splitter:B:35:0x0077] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String i(int r9) {
        /*
            r8 = this;
            r8 = 0
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ all -> 0x0070 }
            java.io.FileReader r1 = new java.io.FileReader     // Catch:{ all -> 0x0070 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0070 }
            r2.<init>()     // Catch:{ all -> 0x0070 }
            java.lang.String r3 = "/proc/"
            r2.append(r3)     // Catch:{ all -> 0x0070 }
            r2.append(r9)     // Catch:{ all -> 0x0070 }
            java.lang.String r9 = "/cmdline"
            r2.append(r9)     // Catch:{ all -> 0x0070 }
            java.lang.String r9 = r2.toString()     // Catch:{ all -> 0x0070 }
            r1.<init>(r9)     // Catch:{ all -> 0x0070 }
            r0.<init>(r1)     // Catch:{ all -> 0x0070 }
            java.lang.String r9 = r0.readLine()     // Catch:{ all -> 0x005c }
            boolean r1 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x005c }
            if (r1 != 0) goto L_0x0067
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)     // Catch:{ all -> 0x005c }
            int r1 = r9.length()     // Catch:{ all -> 0x005c }
            r2 = 1
            int r1 = r1 - r2
            r3 = 0
            r4 = r3
            r5 = r4
        L_0x0037:
            if (r4 > r1) goto L_0x005e
            if (r5 != 0) goto L_0x003d
            r6 = r4
            goto L_0x003e
        L_0x003d:
            r6 = r1
        L_0x003e:
            char r6 = r9.charAt(r6)     // Catch:{ all -> 0x005c }
            r7 = 32
            int r6 = kotlin.jvm.internal.Intrinsics.compare((int) r6, (int) r7)     // Catch:{ all -> 0x005c }
            if (r6 > 0) goto L_0x004c
            r6 = r2
            goto L_0x004d
        L_0x004c:
            r6 = r3
        L_0x004d:
            if (r5 != 0) goto L_0x0056
            if (r6 != 0) goto L_0x0053
            r5 = r2
            goto L_0x0037
        L_0x0053:
            int r4 = r4 + 1
            goto L_0x0037
        L_0x0056:
            if (r6 != 0) goto L_0x0059
            goto L_0x005e
        L_0x0059:
            int r1 = r1 + -1
            goto L_0x0037
        L_0x005c:
            r9 = move-exception
            goto L_0x0072
        L_0x005e:
            int r1 = r1 + r2
            java.lang.CharSequence r9 = r9.subSequence(r4, r1)     // Catch:{ all -> 0x005c }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x005c }
        L_0x0067:
            r0.close()     // Catch:{ IOException -> 0x006b }
            goto L_0x006f
        L_0x006b:
            r8 = move-exception
            r8.printStackTrace()
        L_0x006f:
            return r9
        L_0x0070:
            r9 = move-exception
            r0 = r8
        L_0x0072:
            r9.printStackTrace()     // Catch:{ all -> 0x0080 }
            if (r0 == 0) goto L_0x007f
            r0.close()     // Catch:{ IOException -> 0x007b }
            goto L_0x007f
        L_0x007b:
            r9 = move-exception
            r9.printStackTrace()
        L_0x007f:
            return r8
        L_0x0080:
            r8 = move-exception
            if (r0 == 0) goto L_0x008b
            r0.close()     // Catch:{ IOException -> 0x0087 }
            goto L_0x008b
        L_0x0087:
            r9 = move-exception
            r9.printStackTrace()
        L_0x008b:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.utils.BuglyManager.i(int):java.lang.String");
    }

    public final void j() {
        if (Intrinsics.areEqual((Object) Looper.myLooper(), (Object) Looper.getMainLooper())) {
            m();
        } else {
            new Handler(Looper.getMainLooper()).post(new b());
        }
    }

    public final void l() {
        MainApplication d2 = MainApplication.k.d();
        if (d2 == null) {
            ULog.f6446a.a("BuglyManager", "MainApplication has not attached");
            return;
        }
        boolean z = false;
        if (((Boolean) DataStoreUtils.i(DataStoreUtils.e.a(), "sp_user_agreement_state", Boolean.FALSE, (Context) null, 4, (Object) null)).booleanValue()) {
            if (!b) {
                String packageName = d2.getPackageName();
                String i = i(Process.myPid());
                if (i == null || !StringsKt.contains$default((CharSequence) i, (CharSequence) "sandboxed_process", false, 2, (Object) null)) {
                    CrashReport.UserStrategy userStrategy = new CrashReport.UserStrategy(d2);
                    if (i == null || Intrinsics.areEqual((Object) i, (Object) packageName)) {
                        z = true;
                    }
                    userStrategy.setUploadProcess(z);
                    CrashReport.initCrashReport(d2, userStrategy);
                    b = true;
                    c = SystemClock.uptimeMillis();
                    String string = Settings.Secure.getString(d2.getContentResolver(), "android_id");
                    CrashReport.setDeviceId(d2, string);
                    CrashReport.setUserId(string);
                    CrashReport.setDeviceModel(d2, Build.MODEL);
                    ULog.f6446a.g("BuglyManager", "initBugly finished. processName: " + i);
                    if (Intrinsics.areEqual((Object) i, (Object) packageName)) {
                        g(d2);
                    }
                } else {
                    ULog.f6446a.g("BuglyManager", "processName " + i + " do not init bugly");
                    return;
                }
            }
            if (!d) {
                CrashReport.startCrashReport();
                d = true;
                ULog.f6446a.g("BuglyManager", "Bugly reopen report");
            }
        } else if (b && d) {
            CrashReport.closeCrashReport();
            d = false;
            ULog.f6446a.g("BuglyManager", "Bugly close report");
        }
    }

    public final void m() {
        if (!f) {
            f = true;
            ThreadLooperWatchdog.f7851a.h();
            ULog.f6446a.a("BuglyManager", "LooperWatchdog started");
        }
        ULog.f6446a.a("BuglyManager", "do not initStrictMode for release");
    }

    public final void n() {
        Boolean bool = BuildConfig.f6575a;
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        if (bool.booleanValue()) {
            ULog.f6446a.a("BuglyManager", "do not initBugly for intl");
        } else if (Intrinsics.areEqual((Object) Looper.myLooper(), (Object) Looper.getMainLooper())) {
            l();
        } else {
            new Handler(Looper.getMainLooper()).post(new a());
        }
    }
}
