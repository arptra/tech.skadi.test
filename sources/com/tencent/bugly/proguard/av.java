package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import com.honey.account.constant.AccountConstantKt;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import java.lang.Thread;
import org.apache.commons.lang3.StringUtils;

public final class av implements Thread.UncaughtExceptionHandler {
    private static String h;
    private static final Object i = new Object();

    /* renamed from: a  reason: collision with root package name */
    protected final Context f9551a;
    protected final as b;
    protected final ac c;
    protected final aa d;
    protected Thread.UncaughtExceptionHandler e;
    protected Thread.UncaughtExceptionHandler f;
    protected boolean g = false;
    private int j;

    public av(Context context, as asVar, ac acVar, aa aaVar) {
        this.f9551a = context;
        this.b = asVar;
        this.c = acVar;
        this.d = aaVar;
    }

    private static void c() {
        al.e("current process die", new Object[0]);
        Process.killProcess(Process.myPid());
        System.exit(1);
    }

    public final synchronized void a() {
        if (this.j >= 10) {
            al.a("java crash handler over %d, no need set.", 10);
            return;
        }
        this.g = true;
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            if (!av.class.getName().equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                if ("com.android.internal.os.RuntimeInit$UncaughtHandler".equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                    al.a("backup system java handler: %s", defaultUncaughtExceptionHandler.toString());
                    this.f = defaultUncaughtExceptionHandler;
                    this.e = defaultUncaughtExceptionHandler;
                } else {
                    al.a("backup java handler: %s", defaultUncaughtExceptionHandler.toString());
                    this.e = defaultUncaughtExceptionHandler;
                }
            } else {
                return;
            }
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.j++;
        al.a("registered java monitor: %s", toString());
    }

    public final synchronized void b() {
        this.g = false;
        al.a("close java monitor!", new Object[0]);
        if ("bugly".equals(Thread.getDefaultUncaughtExceptionHandler().getClass().getName())) {
            al.a("Java monitor to unregister: %s", toString());
            Thread.setDefaultUncaughtExceptionHandler(this.e);
            this.j--;
        }
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        synchronized (i) {
            a(thread, th, true, (String) null, (byte[]) null, this.d.Q);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x010f A[Catch:{ all -> 0x0104 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x011d A[Catch:{ all -> 0x0104 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.tencent.bugly.crashreport.crash.CrashDetailBean b(java.lang.Thread r5, java.lang.Throwable r6, boolean r7, java.lang.String r8, byte[] r9, boolean r10) {
        /*
            r4 = this;
            r0 = 0
            if (r6 != 0) goto L_0x000c
            java.lang.String r4 = "We can do nothing with a null throwable."
            java.lang.Object[] r5 = new java.lang.Object[r0]
            com.tencent.bugly.proguard.al.d(r4, r5)
            r4 = 0
            return r4
        L_0x000c:
            com.tencent.bugly.crashreport.crash.CrashDetailBean r1 = new com.tencent.bugly.crashreport.crash.CrashDetailBean
            r1.<init>()
            long r2 = java.lang.System.currentTimeMillis()
            r1.r = r2
            long r2 = com.tencent.bugly.proguard.ab.j()
            r1.C = r2
            long r2 = com.tencent.bugly.proguard.ab.f()
            r1.D = r2
            long r2 = com.tencent.bugly.proguard.ab.l()
            r1.E = r2
            com.tencent.bugly.proguard.aa r2 = r4.d
            long r2 = r2.k()
            r1.F = r2
            com.tencent.bugly.proguard.aa r2 = r4.d
            long r2 = r2.j()
            r1.G = r2
            com.tencent.bugly.proguard.aa r2 = r4.d
            long r2 = r2.l()
            r1.H = r2
            if (r7 != 0) goto L_0x0050
            int r2 = com.tencent.bugly.proguard.aa.B()
            r3 = 31
            if (r2 < r3) goto L_0x0050
            r2 = 0
            r1.I = r2
            goto L_0x0058
        L_0x0050:
            android.content.Context r2 = r4.f9551a
            long r2 = com.tencent.bugly.proguard.ab.b(r2)
            r1.I = r2
        L_0x0058:
            long r2 = com.tencent.bugly.proguard.ab.g()
            r1.J = r2
            long r2 = com.tencent.bugly.proguard.ab.h()
            r1.K = r2
            byte[] r2 = com.tencent.bugly.proguard.ao.a()
            r1.y = r2
            if (r2 != 0) goto L_0x006e
            r2 = r0
            goto L_0x006f
        L_0x006e:
            int r2 = r2.length
        L_0x006f:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Object[] r2 = new java.lang.Object[]{r2}
            java.lang.String r3 = "user log size:%d"
            com.tencent.bugly.proguard.al.a((java.lang.String) r3, (java.lang.Object[]) r2)
            if (r7 == 0) goto L_0x0080
            r2 = r0
            goto L_0x0081
        L_0x0080:
            r2 = 2
        L_0x0081:
            r1.b = r2
            com.tencent.bugly.proguard.aa r2 = r4.d
            java.lang.String r2 = r2.g()
            r1.e = r2
            com.tencent.bugly.proguard.aa r2 = r4.d
            java.lang.String r3 = r2.o
            r1.f = r3
            java.lang.String r2 = r2.q()
            r1.g = r2
            com.tencent.bugly.proguard.aa r2 = r4.d
            java.lang.String r2 = r2.f()
            r1.m = r2
            int r2 = com.tencent.bugly.proguard.at.h
            java.util.Map r10 = com.tencent.bugly.proguard.ap.a((boolean) r10, (int) r2)
            r1.z = r10
            com.tencent.bugly.proguard.aa r10 = r4.d
            java.lang.String r10 = r10.d
            r1.A = r10
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r2 = r5.getName()
            r10.append(r2)
            java.lang.String r2 = "("
            r10.append(r2)
            long r2 = r5.getId()
            r10.append(r2)
            java.lang.String r5 = ")"
            r10.append(r5)
            java.lang.String r5 = r10.toString()
            r1.B = r5
            com.tencent.bugly.proguard.aa r5 = r4.d
            java.lang.String r5 = r5.s()
            r1.L = r5
            com.tencent.bugly.proguard.aa r5 = r4.d
            java.util.Map r5 = r5.p()
            r1.h = r5
            com.tencent.bugly.proguard.aa r5 = r4.d
            java.util.Map r5 = r5.A()
            r1.i = r5
            com.tencent.bugly.proguard.aa r5 = r4.d
            long r2 = r5.f9513a
            r1.Q = r2
            boolean r5 = r5.a()
            r1.R = r5
            a(r1, r6, r7)
            if (r7 != 0) goto L_0x011f
            r5 = 1
            if (r8 == 0) goto L_0x0106
            int r6 = r8.length()     // Catch:{ all -> 0x0104 }
            if (r6 <= 0) goto L_0x0106
            r6 = r5
            goto L_0x0107
        L_0x0104:
            r4 = move-exception
            goto L_0x013c
        L_0x0106:
            r6 = r0
        L_0x0107:
            if (r9 == 0) goto L_0x010d
            int r7 = r9.length     // Catch:{ all -> 0x0104 }
            if (r7 <= 0) goto L_0x010d
            r0 = r5
        L_0x010d:
            if (r6 == 0) goto L_0x011b
            java.util.HashMap r6 = new java.util.HashMap     // Catch:{ all -> 0x0104 }
            r6.<init>(r5)     // Catch:{ all -> 0x0104 }
            r1.S = r6     // Catch:{ all -> 0x0104 }
            java.lang.String r5 = "UserData"
            r6.put(r5, r8)     // Catch:{ all -> 0x0104 }
        L_0x011b:
            if (r0 == 0) goto L_0x011f
            r1.Y = r9     // Catch:{ all -> 0x0104 }
        L_0x011f:
            com.tencent.bugly.proguard.aa r5 = r4.d     // Catch:{ all -> 0x0104 }
            int r5 = r5.z()     // Catch:{ all -> 0x0104 }
            r1.U = r5     // Catch:{ all -> 0x0104 }
            com.tencent.bugly.proguard.aa r5 = r4.d     // Catch:{ all -> 0x0104 }
            int r6 = r5.x     // Catch:{ all -> 0x0104 }
            r1.V = r6     // Catch:{ all -> 0x0104 }
            java.util.Map r5 = r5.t()     // Catch:{ all -> 0x0104 }
            r1.W = r5     // Catch:{ all -> 0x0104 }
            com.tencent.bugly.proguard.aa r4 = r4.d     // Catch:{ all -> 0x0104 }
            java.util.Map r4 = r4.y()     // Catch:{ all -> 0x0104 }
            r1.X = r4     // Catch:{ all -> 0x0104 }
            goto L_0x0149
        L_0x013c:
            java.lang.String r4 = r4.toString()
            java.lang.Object[] r4 = new java.lang.Object[]{r4}
            java.lang.String r5 = "handle crash error %s"
            com.tencent.bugly.proguard.al.e(r5, r4)
        L_0x0149:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.av.b(java.lang.Thread, java.lang.Throwable, boolean, java.lang.String, byte[], boolean):com.tencent.bugly.crashreport.crash.CrashDetailBean");
    }

    private static void a(CrashDetailBean crashDetailBean, Throwable th, boolean z) {
        String str;
        String name = th.getClass().getName();
        String a2 = a(th);
        al.e("stack frame :%d, has cause %b", Integer.valueOf(th.getStackTrace().length), Boolean.valueOf(th.getCause() != null));
        String str2 = "";
        String stackTraceElement = th.getStackTrace().length > 0 ? th.getStackTrace()[0].toString() : str2;
        Throwable th2 = th;
        while (th2 != null && th2.getCause() != null) {
            th2 = th2.getCause();
        }
        if (th2 == null || th2 == th) {
            crashDetailBean.n = name;
            if (at.a().i() && z) {
                al.e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
                str2 = " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]";
            }
            crashDetailBean.o = a2 + str2;
            crashDetailBean.p = stackTraceElement;
            str = a(th, at.h);
            crashDetailBean.q = str;
        } else {
            crashDetailBean.n = th2.getClass().getName();
            crashDetailBean.o = a(th2);
            if (th2.getStackTrace().length > 0) {
                crashDetailBean.p = th2.getStackTrace()[0].toString();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(name);
            sb.append(AccountConstantKt.CODE_SEPARTOR);
            sb.append(a2);
            sb.append(StringUtils.LF);
            sb.append(stackTraceElement);
            sb.append("\n......");
            sb.append("\nCaused by:\n");
            sb.append(crashDetailBean.n);
            sb.append(AccountConstantKt.CODE_SEPARTOR);
            sb.append(crashDetailBean.o);
            sb.append(StringUtils.LF);
            str = a(th2, at.h);
            sb.append(str);
            crashDetailBean.q = sb.toString();
        }
        crashDetailBean.u = ap.c(crashDetailBean.q.getBytes());
        crashDetailBean.z.put(crashDetailBean.B, str);
    }

    private static boolean a(Thread thread) {
        synchronized (i) {
            try {
                if (h != null) {
                    if (thread.getName().equals(h)) {
                        return true;
                    }
                }
                h = thread.getName();
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void a(Thread thread, Throwable th, boolean z, String str, byte[] bArr, boolean z2) {
        String str2;
        Thread thread2 = thread;
        Throwable th2 = th;
        boolean z3 = z;
        if (z3) {
            al.e("Java Crash Happen cause by %s(%d)", thread.getName(), Long.valueOf(thread.getId()));
            if (a(thread)) {
                al.a("this class has handled this exception", new Object[0]);
                if (this.f != null) {
                    al.a("call system handler", new Object[0]);
                    this.f.uncaughtException(thread2, th2);
                } else {
                    c();
                }
            }
        } else {
            al.e("Java Catch Happen", new Object[0]);
        }
        try {
            if (!this.g) {
                al.c("Java crash handler is disable. Just return.", new Object[0]);
                if (z3) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.e;
                    if (uncaughtExceptionHandler != null && a(uncaughtExceptionHandler)) {
                        al.e("sys default last handle start!", new Object[0]);
                        this.e.uncaughtException(thread2, th2);
                        al.e("sys default last handle end!", new Object[0]);
                    } else if (this.f != null) {
                        al.e("system handle start!", new Object[0]);
                        this.f.uncaughtException(thread2, th2);
                        al.e("system handle end!", new Object[0]);
                    } else {
                        al.e("crashreport last handle start!", new Object[0]);
                        c();
                        al.e("crashreport last handle end!", new Object[0]);
                    }
                }
            } else {
                if (!this.c.b()) {
                    al.d("no remote but still store!", new Object[0]);
                }
                String str3 = "JAVA_CATCH";
                if (!this.c.c().f) {
                    if (this.c.b()) {
                        al.e("crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
                        if (z3) {
                            str2 = "JAVA_CRASH";
                        } else {
                            str2 = str3;
                        }
                        as.a(str2, ap.a(), this.d.d, thread.getName(), ap.a(th), (CrashDetailBean) null);
                        if (z3) {
                            Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.e;
                            if (uncaughtExceptionHandler2 != null && a(uncaughtExceptionHandler2)) {
                                al.e("sys default last handle start!", new Object[0]);
                                this.e.uncaughtException(thread2, th2);
                                al.e("sys default last handle end!", new Object[0]);
                                return;
                            } else if (this.f != null) {
                                al.e("system handle start!", new Object[0]);
                                this.f.uncaughtException(thread2, th2);
                                al.e("system handle end!", new Object[0]);
                                return;
                            } else {
                                al.e("crashreport last handle start!", new Object[0]);
                                c();
                                al.e("crashreport last handle end!", new Object[0]);
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                }
                CrashDetailBean b2 = b(thread, th, z, str, bArr, z2);
                if (b2 == null) {
                    al.e("pkg crash datas fail!", new Object[0]);
                    if (z3) {
                        Thread.UncaughtExceptionHandler uncaughtExceptionHandler3 = this.e;
                        if (uncaughtExceptionHandler3 != null && a(uncaughtExceptionHandler3)) {
                            al.e("sys default last handle start!", new Object[0]);
                            this.e.uncaughtException(thread2, th2);
                            al.e("sys default last handle end!", new Object[0]);
                        } else if (this.f != null) {
                            al.e("system handle start!", new Object[0]);
                            this.f.uncaughtException(thread2, th2);
                            al.e("system handle end!", new Object[0]);
                        } else {
                            al.e("crashreport last handle start!", new Object[0]);
                            c();
                            al.e("crashreport last handle end!", new Object[0]);
                        }
                    }
                } else {
                    if (z3) {
                        str3 = "JAVA_CRASH";
                    }
                    as.a(str3, ap.a(), this.d.d, thread.getName(), ap.a(th), b2);
                    if (!this.b.a(b2, z3)) {
                        this.b.b(b2, z3);
                    }
                    if (z3) {
                        this.b.a(b2);
                    }
                    if (z3) {
                        Thread.UncaughtExceptionHandler uncaughtExceptionHandler4 = this.e;
                        if (uncaughtExceptionHandler4 != null && a(uncaughtExceptionHandler4)) {
                            al.e("sys default last handle start!", new Object[0]);
                            this.e.uncaughtException(thread2, th2);
                            al.e("sys default last handle end!", new Object[0]);
                        } else if (this.f != null) {
                            al.e("system handle start!", new Object[0]);
                            this.f.uncaughtException(thread2, th2);
                            al.e("system handle end!", new Object[0]);
                        } else {
                            al.e("crashreport last handle start!", new Object[0]);
                            c();
                            al.e("crashreport last handle end!", new Object[0]);
                        }
                    }
                }
            }
        } catch (Throwable th3) {
            if (z3) {
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler5 = this.e;
                if (uncaughtExceptionHandler5 != null && a(uncaughtExceptionHandler5)) {
                    al.e("sys default last handle start!", new Object[0]);
                    this.e.uncaughtException(thread2, th2);
                    al.e("sys default last handle end!", new Object[0]);
                } else if (this.f != null) {
                    al.e("system handle start!", new Object[0]);
                    this.f.uncaughtException(thread2, th2);
                    al.e("system handle end!", new Object[0]);
                } else {
                    al.e("crashreport last handle start!", new Object[0]);
                    c();
                    al.e("crashreport last handle end!", new Object[0]);
                }
            }
            throw th3;
        }
    }

    private static boolean a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        if (uncaughtExceptionHandler == null) {
            return true;
        }
        String name = uncaughtExceptionHandler.getClass().getName();
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            String className = stackTraceElement.getClassName();
            String methodName = stackTraceElement.getMethodName();
            if (name.equals(className) && "uncaughtException".equals(methodName)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0028, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(com.tencent.bugly.crashreport.common.strategy.StrategyBean r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 == 0) goto L_0x0027
            boolean r0 = r3.f     // Catch:{ all -> 0x001f }
            boolean r1 = r2.g     // Catch:{ all -> 0x001f }
            if (r0 == r1) goto L_0x0027
            java.lang.String r1 = "java changed to %b"
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ all -> 0x001f }
            java.lang.Object[] r0 = new java.lang.Object[]{r0}     // Catch:{ all -> 0x001f }
            com.tencent.bugly.proguard.al.a((java.lang.String) r1, (java.lang.Object[]) r0)     // Catch:{ all -> 0x001f }
            boolean r3 = r3.f     // Catch:{ all -> 0x001f }
            if (r3 == 0) goto L_0x0021
            r2.a()     // Catch:{ all -> 0x001f }
            monitor-exit(r2)
            return
        L_0x001f:
            r3 = move-exception
            goto L_0x0025
        L_0x0021:
            r2.b()     // Catch:{ all -> 0x001f }
            goto L_0x0027
        L_0x0025:
            monitor-exit(r2)
            throw r3
        L_0x0027:
            monitor-exit(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.av.a(com.tencent.bugly.crashreport.common.strategy.StrategyBean):void");
    }

    private static String a(Throwable th, int i2) {
        if (th == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            if (th.getStackTrace() != null) {
                StackTraceElement[] stackTrace = th.getStackTrace();
                int length = stackTrace.length;
                int i3 = 0;
                while (i3 < length) {
                    StackTraceElement stackTraceElement = stackTrace[i3];
                    if (i2 <= 0 || sb.length() < i2) {
                        sb.append(stackTraceElement.toString());
                        sb.append(StringUtils.LF);
                        i3++;
                    } else {
                        sb.append("\n[Stack over limit size :" + i2 + " , has been cutted !]");
                        return sb.toString();
                    }
                }
            }
        } catch (Throwable th2) {
            al.e("gen stack error %s", th2.toString());
        }
        return sb.toString();
    }

    private static String a(Throwable th) {
        String message = th.getMessage();
        if (message == null) {
            return "";
        }
        if (message.length() <= 1000) {
            return message;
        }
        return message.substring(0, 1000) + "\n[Message over limit size:1000, has been cutted!]";
    }
}
