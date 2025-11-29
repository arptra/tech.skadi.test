package com.tencent.bugly.proguard;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler;
import java.util.HashMap;
import java.util.Map;

public final class bd implements NativeExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private final Context f9562a;
    private final as b;
    private final aa c;
    private final ac d;

    public bd(Context context, aa aaVar, as asVar, ac acVar) {
        this.f9562a = context;
        this.b = asVar;
        this.c = aaVar;
        this.d = acVar;
    }

    private static Map<String, String> a(String[] strArr) {
        HashMap hashMap = new HashMap(strArr == null ? 1 : strArr.length);
        if (strArr != null) {
            for (int i = 0; i < strArr.length; i++) {
                String str = strArr[i];
                if (str != null) {
                    al.a("Extra message[%d]: %s", Integer.valueOf(i), str);
                    String[] split = str.split("=");
                    if (split.length == 2) {
                        hashMap.put(split[0], split[1]);
                    } else {
                        al.d("bad extraMsg %s", str);
                    }
                }
            }
        } else {
            al.c("not found extraMsg", new Object[0]);
        }
        return hashMap;
    }

    public final boolean getAndUpdateAnrState() {
        if (ay.a() == null) {
            return false;
        }
        ay a2 = ay.a();
        if (a2.f9553a.get()) {
            al.c("anr is processing, return", new Object[0]);
            return false;
        }
        ActivityManager activityManager = a2.b;
        if (z.a(activityManager) || az.a(activityManager, 0) == null) {
            al.c("proc is not in anr, wait next check", new Object[0]);
            return false;
        } else if (a2.a(System.currentTimeMillis())) {
            return false;
        } else {
            return a2.a(true);
        }
    }

    public final void handleNativeException(int i, int i2, long j, long j2, String str, String str2, String str3, String str4, int i3, String str5, int i4, int i5, int i6, String str6, String str7) {
        int i7 = i;
        al.a("Native Crash Happen v1", new Object[0]);
        handleNativeException2(i, i2, j, j2, str, str2, str3, str4, i3, str5, i4, i5, i6, str6, str7, (String[]) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x009d A[Catch:{ all -> 0x0031 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00bd A[Catch:{ all -> 0x0031 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00f6 A[Catch:{ all -> 0x0031 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0109 A[SYNTHETIC, Splitter:B:32:0x0109] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x014c A[Catch:{ all -> 0x0031 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0151 A[Catch:{ all -> 0x0031 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0157 A[Catch:{ all -> 0x0031 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01a7 A[Catch:{ all -> 0x0031 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01b0 A[Catch:{ all -> 0x0031 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void handleNativeException2(int r29, int r30, long r31, long r33, java.lang.String r35, java.lang.String r36, java.lang.String r37, java.lang.String r38, int r39, java.lang.String r40, int r41, int r42, int r43, java.lang.String r44, java.lang.String r45, java.lang.String[] r46) {
        /*
            r28 = this;
            r0 = r28
            r1 = r30
            r14 = r36
            r2 = r41
            r13 = 0
            java.lang.Object[] r3 = new java.lang.Object[r13]
            java.lang.String r4 = "Native Crash Happen v2"
            com.tencent.bugly.proguard.al.a((java.lang.String) r4, (java.lang.Object[]) r3)
            java.lang.String r3 = ")"
            java.lang.String r4 = "("
            if (r39 <= 0) goto L_0x0034
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0031 }
            r5.<init>()     // Catch:{ all -> 0x0031 }
            r6 = r35
            r5.append(r6)     // Catch:{ all -> 0x0031 }
            r5.append(r4)     // Catch:{ all -> 0x0031 }
            r7 = r40
            r5.append(r7)     // Catch:{ all -> 0x0031 }
            r5.append(r3)     // Catch:{ all -> 0x0031 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0031 }
            r12 = r5
            goto L_0x0039
        L_0x0031:
            r0 = move-exception
            goto L_0x021d
        L_0x0034:
            r6 = r35
            r7 = r40
            r12 = r6
        L_0x0039:
            java.lang.String r11 = com.tencent.bugly.proguard.be.a((java.lang.String) r37)     // Catch:{ all -> 0x0031 }
            java.util.Map r5 = a(r46)     // Catch:{ all -> 0x0031 }
            java.lang.String r6 = "HasPendingException"
            java.lang.Object r6 = r5.get(r6)     // Catch:{ all -> 0x0031 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0031 }
            r10 = 1
            if (r6 == 0) goto L_0x005e
            java.lang.String r8 = "true"
            boolean r6 = r6.equals(r8)     // Catch:{ all -> 0x0031 }
            if (r6 == 0) goto L_0x005e
            java.lang.String r6 = "Native crash happened with a Java pending exception."
            java.lang.Object[] r8 = new java.lang.Object[r13]     // Catch:{ all -> 0x0031 }
            com.tencent.bugly.proguard.al.a((java.lang.String) r6, (java.lang.Object[]) r8)     // Catch:{ all -> 0x0031 }
            r18 = r10
            goto L_0x0060
        L_0x005e:
            r18 = r13
        L_0x0060:
            com.tencent.bugly.proguard.aa r6 = r0.c     // Catch:{ all -> 0x0031 }
            java.lang.String r8 = "ExceptionProcessName"
            java.lang.Object r8 = r5.get(r8)     // Catch:{ all -> 0x0031 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0031 }
            if (r8 == 0) goto L_0x007f
            int r9 = r8.length()     // Catch:{ all -> 0x0031 }
            if (r9 != 0) goto L_0x0073
            goto L_0x007f
        L_0x0073:
            java.lang.String r6 = "Name of crash process: %s"
            java.lang.Object[] r9 = new java.lang.Object[]{r8}     // Catch:{ all -> 0x0031 }
            com.tencent.bugly.proguard.al.c(r6, r9)     // Catch:{ all -> 0x0031 }
        L_0x007c:
            r19 = r8
            goto L_0x0082
        L_0x007f:
            java.lang.String r8 = r6.d     // Catch:{ all -> 0x0031 }
            goto L_0x007c
        L_0x0082:
            java.lang.String r6 = "ExceptionThreadName"
            java.lang.Object r6 = r5.get(r6)     // Catch:{ all -> 0x0031 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0031 }
            java.lang.String r8 = "crash thread name:%s tid:%s"
            java.lang.Integer r9 = java.lang.Integer.valueOf(r30)     // Catch:{ all -> 0x0031 }
            java.lang.Object[] r9 = new java.lang.Object[]{r6, r9}     // Catch:{ all -> 0x0031 }
            com.tencent.bugly.proguard.al.c(r8, r9)     // Catch:{ all -> 0x0031 }
            boolean r8 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0031 }
            if (r8 == 0) goto L_0x00bd
            java.lang.Thread r6 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0031 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0031 }
            r8.<init>()     // Catch:{ all -> 0x0031 }
            java.lang.String r6 = r6.getName()     // Catch:{ all -> 0x0031 }
            r8.append(r6)     // Catch:{ all -> 0x0031 }
            r8.append(r4)     // Catch:{ all -> 0x0031 }
            r8.append(r1)     // Catch:{ all -> 0x0031 }
            r8.append(r3)     // Catch:{ all -> 0x0031 }
            java.lang.String r1 = r8.toString()     // Catch:{ all -> 0x0031 }
        L_0x00ba:
            r20 = r1
            goto L_0x00d3
        L_0x00bd:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0031 }
            r8.<init>()     // Catch:{ all -> 0x0031 }
            r8.append(r6)     // Catch:{ all -> 0x0031 }
            r8.append(r4)     // Catch:{ all -> 0x0031 }
            r8.append(r1)     // Catch:{ all -> 0x0031 }
            r8.append(r3)     // Catch:{ all -> 0x0031 }
            java.lang.String r1 = r8.toString()     // Catch:{ all -> 0x0031 }
            goto L_0x00ba
        L_0x00d3:
            r8 = 1000(0x3e8, double:4.94E-321)
            long r15 = r31 * r8
            long r8 = r33 / r8
            long r8 = r8 + r15
            java.lang.String r1 = "SysLogPath"
            java.lang.Object r1 = r5.get(r1)     // Catch:{ all -> 0x0031 }
            r21 = r1
            java.lang.String r21 = (java.lang.String) r21     // Catch:{ all -> 0x0031 }
            java.lang.String r1 = "JniLogPath"
            java.lang.Object r1 = r5.get(r1)     // Catch:{ all -> 0x0031 }
            r22 = r1
            java.lang.String r22 = (java.lang.String) r22     // Catch:{ all -> 0x0031 }
            com.tencent.bugly.proguard.ac r1 = r0.d     // Catch:{ all -> 0x0031 }
            boolean r1 = r1.b()     // Catch:{ all -> 0x0031 }
            if (r1 != 0) goto L_0x00fd
            java.lang.String r1 = "no remote but still store!"
            java.lang.Object[] r5 = new java.lang.Object[r13]     // Catch:{ all -> 0x0031 }
            com.tencent.bugly.proguard.al.d(r1, r5)     // Catch:{ all -> 0x0031 }
        L_0x00fd:
            com.tencent.bugly.proguard.ac r1 = r0.d     // Catch:{ all -> 0x0031 }
            com.tencent.bugly.crashreport.common.strategy.StrategyBean r1 = r1.c()     // Catch:{ all -> 0x0031 }
            boolean r1 = r1.f     // Catch:{ all -> 0x0031 }
            java.lang.String r6 = "\n"
            if (r1 != 0) goto L_0x014a
            com.tencent.bugly.proguard.ac r1 = r0.d     // Catch:{ all -> 0x0031 }
            boolean r1 = r1.b()     // Catch:{ all -> 0x0031 }
            if (r1 == 0) goto L_0x014a
            java.lang.String r0 = "crash report was closed by remote , will not upload to Bugly , print local for helpful!"
            java.lang.Object[] r1 = new java.lang.Object[r13]     // Catch:{ all -> 0x0031 }
            com.tencent.bugly.proguard.al.e(r0, r1)     // Catch:{ all -> 0x0031 }
            java.lang.String r0 = "NATIVE_CRASH"
            java.lang.String r1 = com.tencent.bugly.proguard.ap.a()     // Catch:{ all -> 0x0031 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0031 }
            r2.<init>()     // Catch:{ all -> 0x0031 }
            r2.append(r12)     // Catch:{ all -> 0x0031 }
            r2.append(r6)     // Catch:{ all -> 0x0031 }
            r2.append(r14)     // Catch:{ all -> 0x0031 }
            r2.append(r6)     // Catch:{ all -> 0x0031 }
            r2.append(r11)     // Catch:{ all -> 0x0031 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0031 }
            r3 = 0
            r28 = r0
            r29 = r1
            r30 = r19
            r31 = r20
            r32 = r2
            r33 = r3
            com.tencent.bugly.proguard.as.a(r28, r29, r30, r31, r32, r33)     // Catch:{ all -> 0x0031 }
            com.tencent.bugly.proguard.ap.c((java.lang.String) r38)     // Catch:{ all -> 0x0031 }
            return
        L_0x014a:
            if (r39 <= 0) goto L_0x0151
            java.lang.String r1 = "KERNEL"
            r23 = r1
            goto L_0x0153
        L_0x0151:
            r23 = r7
        L_0x0153:
            java.lang.String r1 = "UNKNOWN"
            if (r39 > 0) goto L_0x017c
            if (r2 <= 0) goto L_0x015d
            java.lang.String r1 = com.tencent.bugly.proguard.z.a((int) r41)     // Catch:{ all -> 0x0031 }
        L_0x015d:
            java.lang.String r5 = java.lang.String.valueOf(r41)     // Catch:{ all -> 0x0031 }
            boolean r5 = r1.equals(r5)     // Catch:{ all -> 0x0031 }
            if (r5 != 0) goto L_0x017c
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0031 }
            r5.<init>()     // Catch:{ all -> 0x0031 }
            r5.append(r1)     // Catch:{ all -> 0x0031 }
            r5.append(r4)     // Catch:{ all -> 0x0031 }
            r5.append(r2)     // Catch:{ all -> 0x0031 }
            r5.append(r3)     // Catch:{ all -> 0x0031 }
            java.lang.String r1 = r5.toString()     // Catch:{ all -> 0x0031 }
        L_0x017c:
            r24 = r1
            r16 = 0
            r17 = 1
            r15 = 0
            r1 = r28
            r2 = r19
            r3 = r20
            r4 = r8
            r9 = r6
            r6 = r12
            r7 = r36
            r8 = r11
            r25 = r9
            r9 = r23
            r10 = r24
            r26 = r11
            r11 = r38
            r27 = r12
            r12 = r21
            r13 = r22
            r14 = r45
            com.tencent.bugly.crashreport.crash.CrashDetailBean r1 = r1.packageCrashDatas(r2, r3, r4, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)     // Catch:{ all -> 0x0031 }
            if (r1 != 0) goto L_0x01b0
            java.lang.String r0 = "pkg crash datas fail!"
            r2 = 0
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ all -> 0x0031 }
            com.tencent.bugly.proguard.al.e(r0, r1)     // Catch:{ all -> 0x0031 }
            return
        L_0x01b0:
            r2 = 0
            java.lang.String r3 = "NATIVE_CRASH"
            java.lang.String r4 = com.tencent.bugly.proguard.ap.a()     // Catch:{ all -> 0x0031 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0031 }
            r5.<init>()     // Catch:{ all -> 0x0031 }
            r6 = r27
            r5.append(r6)     // Catch:{ all -> 0x0031 }
            r6 = r25
            r5.append(r6)     // Catch:{ all -> 0x0031 }
            r7 = r36
            r5.append(r7)     // Catch:{ all -> 0x0031 }
            r5.append(r6)     // Catch:{ all -> 0x0031 }
            r6 = r26
            r5.append(r6)     // Catch:{ all -> 0x0031 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0031 }
            r29 = r3
            r30 = r4
            r31 = r19
            r32 = r20
            r33 = r5
            r34 = r1
            com.tencent.bugly.proguard.as.a(r29, r30, r31, r32, r33, r34)     // Catch:{ all -> 0x0031 }
            com.tencent.bugly.proguard.as r3 = r0.b     // Catch:{ all -> 0x0031 }
            if (r3 != 0) goto L_0x01f2
            java.lang.String r0 = "crashHandler is null. Won't upload native crash."
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ all -> 0x0031 }
            com.tencent.bugly.proguard.al.d(r0, r1)     // Catch:{ all -> 0x0031 }
            return
        L_0x01f2:
            r2 = 1
            boolean r3 = r3.a((com.tencent.bugly.crashreport.crash.CrashDetailBean) r1, (boolean) r2)     // Catch:{ all -> 0x0031 }
            r3 = r3 ^ r2
            com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler r4 = com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.getInstance()     // Catch:{ all -> 0x0031 }
            if (r4 == 0) goto L_0x0203
            java.lang.String r4 = com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.getDumpFilePath()     // Catch:{ all -> 0x0031 }
            goto L_0x0204
        L_0x0203:
            r4 = 0
        L_0x0204:
            com.tencent.bugly.proguard.be.a((boolean) r2, (java.lang.String) r4)     // Catch:{ all -> 0x0031 }
            if (r3 == 0) goto L_0x020e
            com.tencent.bugly.proguard.as r3 = r0.b     // Catch:{ all -> 0x0031 }
            r3.b((com.tencent.bugly.crashreport.crash.CrashDetailBean) r1, (boolean) r2)     // Catch:{ all -> 0x0031 }
        L_0x020e:
            com.tencent.bugly.proguard.as r0 = r0.b     // Catch:{ all -> 0x0031 }
            r0.a((com.tencent.bugly.crashreport.crash.CrashDetailBean) r1)     // Catch:{ all -> 0x0031 }
            com.tencent.bugly.proguard.at r0 = com.tencent.bugly.proguard.at.a()     // Catch:{ all -> 0x0031 }
            com.tencent.bugly.proguard.av r0 = r0.t     // Catch:{ all -> 0x0031 }
            r0.b()     // Catch:{ all -> 0x0031 }
            return
        L_0x021d:
            boolean r1 = com.tencent.bugly.proguard.al.a(r0)
            if (r1 != 0) goto L_0x0226
            r0.printStackTrace()
        L_0x0226:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.bd.handleNativeException2(int, int, long, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, int, int, int, java.lang.String, java.lang.String, java.lang.String[]):void");
    }

    public final CrashDetailBean packageCrashDatas(String str, String str2, long j, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, byte[] bArr, Map<String, String> map, boolean z, boolean z2) {
        int i;
        String str12;
        int indexOf;
        String str13 = str;
        String str14 = str8;
        byte[] bArr2 = bArr;
        boolean i2 = at.a().i();
        if (i2) {
            al.e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.b = 1;
        crashDetailBean.e = this.c.g();
        aa aaVar = this.c;
        crashDetailBean.f = aaVar.o;
        crashDetailBean.g = aaVar.q();
        crashDetailBean.m = this.c.f();
        crashDetailBean.n = str3;
        String str15 = "";
        crashDetailBean.o = i2 ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]" : str15;
        crashDetailBean.p = str4;
        if (str5 != null) {
            str15 = str5;
        }
        crashDetailBean.q = str15;
        crashDetailBean.r = j;
        crashDetailBean.u = ap.c(str15.getBytes());
        crashDetailBean.A = str13;
        crashDetailBean.B = str2;
        crashDetailBean.L = this.c.s();
        crashDetailBean.h = this.c.p();
        crashDetailBean.i = this.c.A();
        crashDetailBean.v = str14;
        String dumpFilePath = NativeCrashHandler.getInstance() != null ? NativeCrashHandler.getDumpFilePath() : null;
        String a2 = be.a(dumpFilePath, str14);
        if (!ap.b(a2)) {
            crashDetailBean.Z = a2;
        }
        crashDetailBean.aa = be.b(dumpFilePath);
        crashDetailBean.w = be.a(str9, at.f, at.k, at.p);
        crashDetailBean.x = be.a(str10, at.f, (String) null, true);
        crashDetailBean.N = str7;
        crashDetailBean.O = str6;
        crashDetailBean.P = str11;
        crashDetailBean.F = this.c.k();
        crashDetailBean.G = this.c.j();
        crashDetailBean.H = this.c.l();
        crashDetailBean.I = ab.b(this.f9562a);
        crashDetailBean.J = ab.g();
        crashDetailBean.K = ab.h();
        if (z) {
            crashDetailBean.C = ab.j();
            crashDetailBean.D = ab.f();
            crashDetailBean.E = ab.l();
            crashDetailBean.y = ao.a();
            aa aaVar2 = this.c;
            crashDetailBean.Q = aaVar2.f9513a;
            crashDetailBean.R = aaVar2.a();
            crashDetailBean.z = ap.a(this.c.Q, at.h);
            int indexOf2 = crashDetailBean.q.indexOf("java:\n");
            if (indexOf2 > 0 && (i = indexOf2 + 6) < crashDetailBean.q.length()) {
                String str16 = crashDetailBean.q;
                String substring = str16.substring(i, str16.length() - 1);
                if (substring.length() > 0 && crashDetailBean.z.containsKey(crashDetailBean.B) && (indexOf = str12.indexOf(substring)) > 0) {
                    String substring2 = (str12 = crashDetailBean.z.get(crashDetailBean.B)).substring(indexOf);
                    crashDetailBean.z.put(crashDetailBean.B, substring2);
                    crashDetailBean.q = crashDetailBean.q.substring(0, i);
                    crashDetailBean.q += substring2;
                }
            }
            if (str13 == null) {
                crashDetailBean.A = this.c.d;
            }
            crashDetailBean.U = this.c.z();
            aa aaVar3 = this.c;
            crashDetailBean.V = aaVar3.x;
            crashDetailBean.W = aaVar3.t();
            crashDetailBean.X = this.c.y();
        } else {
            crashDetailBean.C = -1;
            crashDetailBean.D = -1;
            crashDetailBean.E = -1;
            if (crashDetailBean.w == null) {
                crashDetailBean.w = "This crash occurred at last process! Log is miss, when get an terrible ABRT Native Exception etc.";
            }
            crashDetailBean.Q = -1;
            crashDetailBean.U = -1;
            crashDetailBean.V = -1;
            crashDetailBean.W = map;
            crashDetailBean.X = this.c.y();
            crashDetailBean.z = null;
            if (str13 == null) {
                crashDetailBean.A = "unknown(record)";
            }
            if (bArr2 != null) {
                crashDetailBean.y = bArr2;
            }
        }
        return crashDetailBean;
    }
}
