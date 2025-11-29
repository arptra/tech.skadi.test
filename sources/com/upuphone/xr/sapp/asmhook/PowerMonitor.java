package com.upuphone.xr.sapp.asmhook;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.SystemClock;
import com.honey.account.constant.AccountConstantKt;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.ar.navi.lite.util.NaviUtil;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.utils.DataTrackUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PowerMonitor {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f6632a = new Object();
    public static MonitorThread b = null;
    public static boolean c = false;
    public static long d;
    public static final HashMap e = new HashMap();
    public static final ArrayList f = new ArrayList();
    public static final HashMap g = new HashMap();
    public static final ArrayList h = new ArrayList();
    public static final HashMap i = new HashMap();
    public static boolean j = false;

    public static class LocationRequestInfo {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference f6633a;
        public long b;
        public long c;
        public String d;
    }

    public static class MonitorThread extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public Handler f6634a;

        public void a() {
            if (!this.f6634a.hasMessages(1)) {
                this.f6634a.sendEmptyMessageDelayed(1, 600000);
            }
        }

        public void b() {
            this.f6634a.removeMessages(1);
        }

        public void run() {
            Looper.prepare();
            this.f6634a = new Handler(Looper.myLooper()) {
                public void handleMessage(Message message) {
                    int i = message.what;
                    if (i == 1) {
                        PowerMonitor.g();
                        PowerMonitor.h();
                    } else if (i == 2) {
                        PowerMonitor.i();
                    }
                }
            };
            ULog.d("PowerMonitor", "PowerMonitor MonitorThread started");
            Looper.loop();
        }
    }

    public static class WakelockInfo {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference f6636a;
        public long b;
        public long c;
        public ArrayList d;
        public HashMap e;
    }

    public static void d() {
        Iterator it = i.entrySet().iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) ((Map.Entry) it.next()).getValue();
            if (weakReference.get() == null) {
                ULog.d("PowerMonitor", "CheckValidRefCountedFalseWakelockLocked ref.get() null, ref: " + weakReference);
                it.remove();
            }
        }
    }

    public static void e(WakelockInfo wakelockInfo, long j2) {
        if (j2 > wakelockInfo.b && !c) {
            wakelockInfo.c = j2;
            wakelockInfo.d.clear();
            ArrayList arrayList = h;
            if (arrayList.size() < 100) {
                arrayList.add(wakelockInfo);
            }
        }
    }

    public static void f(HashMap hashMap, StringBuilder sb) {
        for (Map.Entry entry : hashMap.entrySet()) {
            sb.append((String) entry.getKey());
            sb.append(AccountConstantKt.CODE_SEPARTOR);
            sb.append(entry.getValue());
            sb.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_VCARD);
            if (sb.length() > 256) {
                return;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x013c, code lost:
        if (r10 < 100) goto L_0x0174;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x013e, code lost:
        r6.append("requestLocationUpdates too offen, listener count more than " + r10 + " in recent " + 600000 + "ms. ");
        f(r7, r6);
        p("GPS", r6);
        com.upuphone.star.core.log.ULog.m("PowerMonitor", r6.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0174, code lost:
        r11 = r11 - r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0179, code lost:
        if (r11 <= 20000) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x017b, code lost:
        r6.append("Turn on GPS for " + r11 + "ms in recent " + 600000 + "ms. ");
        f(r7, r6);
        p("GPS", r6);
        com.upuphone.star.core.log.ULog.m("PowerMonitor", r6.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void g() {
        /*
            long r0 = android.os.SystemClock.elapsedRealtime()
            long r2 = d
            r4 = 600000(0x927c0, double:2.964394E-318)
            long r6 = r0 - r4
            long r2 = java.lang.Math.max(r2, r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
            java.lang.Object r8 = f6632a
            monitor-enter(r8)
            boolean r9 = c     // Catch:{ all -> 0x0022 }
            if (r9 == 0) goto L_0x0025
            monitor-exit(r8)     // Catch:{ all -> 0x0022 }
            return
        L_0x0022:
            r0 = move-exception
            goto L_0x01b1
        L_0x0025:
            java.util.HashMap r9 = e     // Catch:{ all -> 0x0022 }
            int r10 = r9.size()     // Catch:{ all -> 0x0022 }
            if (r10 <= 0) goto L_0x002f
            r11 = r0
            goto L_0x0030
        L_0x002f:
            r11 = r2
        L_0x0030:
            java.util.Set r9 = r9.entrySet()     // Catch:{ all -> 0x0022 }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x0022 }
            r13 = r0
        L_0x0039:
            boolean r15 = r9.hasNext()     // Catch:{ all -> 0x0022 }
            if (r15 == 0) goto L_0x00cb
            java.lang.Object r15 = r9.next()     // Catch:{ all -> 0x0022 }
            java.util.Map$Entry r15 = (java.util.Map.Entry) r15     // Catch:{ all -> 0x0022 }
            java.lang.Object r15 = r15.getValue()     // Catch:{ all -> 0x0022 }
            com.upuphone.xr.sapp.asmhook.PowerMonitor$LocationRequestInfo r15 = (com.upuphone.xr.sapp.asmhook.PowerMonitor.LocationRequestInfo) r15     // Catch:{ all -> 0x0022 }
            java.lang.ref.WeakReference r16 = r15.f6633a     // Catch:{ all -> 0x0022 }
            java.lang.Object r16 = r16.get()     // Catch:{ all -> 0x0022 }
            android.location.LocationListener r16 = (android.location.LocationListener) r16     // Catch:{ all -> 0x0022 }
            if (r16 != 0) goto L_0x008f
            java.lang.String r4 = "PowerMonitor"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0022 }
            r5.<init>()     // Catch:{ all -> 0x0022 }
            r17 = r11
            java.lang.String r11 = "requestLocationUpdates leak LocationListener caller:"
            r5.append(r11)     // Catch:{ all -> 0x0022 }
            java.lang.String r11 = r15.d     // Catch:{ all -> 0x0022 }
            r5.append(r11)     // Catch:{ all -> 0x0022 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0022 }
            com.upuphone.star.core.log.ULog.m(r4, r5)     // Catch:{ all -> 0x0022 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0022 }
            r4.<init>()     // Catch:{ all -> 0x0022 }
            java.lang.String r5 = r15.d     // Catch:{ all -> 0x0022 }
            r4.append(r5)     // Catch:{ all -> 0x0022 }
            java.lang.String r5 = "&"
            r4.append(r5)     // Catch:{ all -> 0x0022 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0022 }
            m(r7, r4)     // Catch:{ all -> 0x0022 }
            r9.remove()     // Catch:{ all -> 0x0022 }
            goto L_0x00b4
        L_0x008f:
            r17 = r11
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0022 }
            r4.<init>()     // Catch:{ all -> 0x0022 }
            java.lang.String r5 = r15.d     // Catch:{ all -> 0x0022 }
            r4.append(r5)     // Catch:{ all -> 0x0022 }
            java.lang.String r5 = "&"
            r4.append(r5)     // Catch:{ all -> 0x0022 }
            java.lang.Class r5 = r16.getClass()     // Catch:{ all -> 0x0022 }
            java.lang.String r5 = r5.getName()     // Catch:{ all -> 0x0022 }
            r4.append(r5)     // Catch:{ all -> 0x0022 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0022 }
            m(r7, r4)     // Catch:{ all -> 0x0022 }
        L_0x00b4:
            int r4 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x00c4
            long r4 = r15.b     // Catch:{ all -> 0x0022 }
            long r4 = java.lang.Math.max(r2, r4)     // Catch:{ all -> 0x0022 }
            long r13 = java.lang.Math.min(r13, r4)     // Catch:{ all -> 0x0022 }
        L_0x00c4:
            r11 = r17
            r4 = 600000(0x927c0, double:2.964394E-318)
            goto L_0x0039
        L_0x00cb:
            r17 = r11
            r4 = 100
            if (r10 < r4) goto L_0x00d6
            java.util.HashMap r5 = e     // Catch:{ all -> 0x0022 }
            r5.clear()     // Catch:{ all -> 0x0022 }
        L_0x00d6:
            java.util.ArrayList r5 = f     // Catch:{ all -> 0x0022 }
            int r9 = r5.size()     // Catch:{ all -> 0x0022 }
            int r10 = r10 + r9
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x0022 }
            r11 = r17
        L_0x00e3:
            boolean r9 = r5.hasNext()     // Catch:{ all -> 0x0022 }
            if (r9 == 0) goto L_0x0127
            java.lang.Object r9 = r5.next()     // Catch:{ all -> 0x0022 }
            com.upuphone.xr.sapp.asmhook.PowerMonitor$LocationRequestInfo r9 = (com.upuphone.xr.sapp.asmhook.PowerMonitor.LocationRequestInfo) r9     // Catch:{ all -> 0x0022 }
            long r15 = r9.c     // Catch:{ all -> 0x0022 }
            int r15 = (r15 > r2 ? 1 : (r15 == r2 ? 0 : -1))
            if (r15 > 0) goto L_0x00f8
            goto L_0x00e3
        L_0x00f8:
            int r15 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r15 <= 0) goto L_0x010c
            r16 = r5
            long r4 = r9.b     // Catch:{ all -> 0x0022 }
            long r4 = java.lang.Math.max(r2, r4)     // Catch:{ all -> 0x0022 }
            long r4 = java.lang.Math.min(r13, r4)     // Catch:{ all -> 0x0022 }
            r13 = r4
            goto L_0x010e
        L_0x010c:
            r16 = r5
        L_0x010e:
            int r4 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1))
            if (r4 >= 0) goto L_0x011b
            long r4 = r9.c     // Catch:{ all -> 0x0022 }
            long r4 = java.lang.Math.max(r11, r4)     // Catch:{ all -> 0x0022 }
            r11 = r4
        L_0x011b:
            java.lang.String r4 = r9.d     // Catch:{ all -> 0x0022 }
            m(r7, r4)     // Catch:{ all -> 0x0022 }
            r5 = r16
            r4 = 100
            goto L_0x00e3
        L_0x0127:
            java.util.ArrayList r0 = f     // Catch:{ all -> 0x0022 }
            r0.clear()     // Catch:{ all -> 0x0022 }
            java.util.HashMap r0 = e     // Catch:{ all -> 0x0022 }
            int r0 = r0.size()     // Catch:{ all -> 0x0022 }
            if (r0 <= 0) goto L_0x0139
            com.upuphone.xr.sapp.asmhook.PowerMonitor$MonitorThread r0 = b     // Catch:{ all -> 0x0022 }
            r0.a()     // Catch:{ all -> 0x0022 }
        L_0x0139:
            monitor-exit(r8)     // Catch:{ all -> 0x0022 }
            r0 = 100
            if (r10 < r0) goto L_0x0174
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "requestLocationUpdates too offen, listener count more than "
            r0.append(r1)
            r0.append(r10)
            java.lang.String r1 = " in recent "
            r0.append(r1)
            r1 = 600000(0x927c0, double:2.964394E-318)
            r0.append(r1)
            java.lang.String r1 = "ms. "
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r6.append(r0)
            f(r7, r6)
            java.lang.String r0 = "GPS"
            p(r0, r6)
            java.lang.String r0 = "PowerMonitor"
            java.lang.String r1 = r6.toString()
            com.upuphone.star.core.log.ULog.m(r0, r1)
            goto L_0x01b0
        L_0x0174:
            long r11 = r11 - r13
            r0 = 20000(0x4e20, double:9.8813E-320)
            int r0 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x01b0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Turn on GPS for "
            r0.append(r1)
            r0.append(r11)
            java.lang.String r1 = "ms in recent "
            r0.append(r1)
            r1 = 600000(0x927c0, double:2.964394E-318)
            r0.append(r1)
            java.lang.String r1 = "ms. "
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r6.append(r0)
            f(r7, r6)
            java.lang.String r0 = "GPS"
            p(r0, r6)
            java.lang.String r0 = "PowerMonitor"
            java.lang.String r1 = r6.toString()
            com.upuphone.star.core.log.ULog.m(r0, r1)
        L_0x01b0:
            return
        L_0x01b1:
            monitor-exit(r8)     // Catch:{ all -> 0x0022 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.asmhook.PowerMonitor.g():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00fa, code lost:
        if (r3 < 100) goto L_0x0133;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00fc, code lost:
        r8.append("wakeLock.acquire too offen, wakeLock count more than " + r3 + " in recent " + 600000 + "ms. ");
        f(r9, r8);
        p("WAKELOCK", r8);
        com.upuphone.star.core.log.ULog.m("PowerMonitor", r8.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0133, code lost:
        r6 = r6 - r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0139, code lost:
        if (r6 <= 300000) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x013b, code lost:
        r8.append("wakeLock.acquire for " + r6 + "ms in recent " + 600000 + "ms. ");
        f(r9, r8);
        p("WAKELOCK", r8);
        com.upuphone.star.core.log.ULog.m("PowerMonitor", r8.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void h() {
        /*
            boolean r0 = j
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            long r0 = android.os.SystemClock.elapsedRealtime()
            r2 = 600000(0x927c0, double:2.964394E-318)
            long r4 = r0 - r2
            r6 = 0
            long r4 = java.lang.Math.max(r6, r4)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.util.HashMap r9 = new java.util.HashMap
            r9.<init>()
            java.lang.Object r10 = f6632a
            monitor-enter(r10)
            boolean r11 = c     // Catch:{ all -> 0x0027 }
            if (r11 == 0) goto L_0x002a
            monitor-exit(r10)     // Catch:{ all -> 0x0027 }
            return
        L_0x0027:
            r0 = move-exception
            goto L_0x0172
        L_0x002a:
            java.util.HashMap r11 = g     // Catch:{ all -> 0x0027 }
            java.util.Set r11 = r11.entrySet()     // Catch:{ all -> 0x0027 }
            java.util.Iterator r11 = r11.iterator()     // Catch:{ all -> 0x0027 }
            r12 = r0
        L_0x0035:
            boolean r14 = r11.hasNext()     // Catch:{ all -> 0x0027 }
            if (r14 == 0) goto L_0x007b
            java.lang.Object r14 = r11.next()     // Catch:{ all -> 0x0027 }
            java.util.Map$Entry r14 = (java.util.Map.Entry) r14     // Catch:{ all -> 0x0027 }
            java.lang.Object r15 = r14.getValue()     // Catch:{ all -> 0x0027 }
            com.upuphone.xr.sapp.asmhook.PowerMonitor$WakelockInfo r15 = (com.upuphone.xr.sapp.asmhook.PowerMonitor.WakelockInfo) r15     // Catch:{ all -> 0x0027 }
            java.lang.Object r14 = r14.getKey()     // Catch:{ all -> 0x0027 }
            java.lang.Integer r14 = (java.lang.Integer) r14     // Catch:{ all -> 0x0027 }
            int r14 = r14.intValue()     // Catch:{ all -> 0x0027 }
            long r2 = j(r15, r0, r14)     // Catch:{ all -> 0x0027 }
            int r14 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r14 < 0) goto L_0x0060
            e(r15, r2)     // Catch:{ all -> 0x0027 }
            r11.remove()     // Catch:{ all -> 0x0027 }
            goto L_0x0077
        L_0x0060:
            java.util.HashMap r2 = r15.e     // Catch:{ all -> 0x0027 }
            o(r9, r2)     // Catch:{ all -> 0x0027 }
            int r2 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x0077
            long r2 = r15.b     // Catch:{ all -> 0x0027 }
            long r2 = java.lang.Math.max(r4, r2)     // Catch:{ all -> 0x0027 }
            long r12 = java.lang.Math.min(r12, r2)     // Catch:{ all -> 0x0027 }
        L_0x0077:
            r2 = 600000(0x927c0, double:2.964394E-318)
            goto L_0x0035
        L_0x007b:
            java.util.HashMap r2 = g     // Catch:{ all -> 0x0027 }
            int r3 = r2.size()     // Catch:{ all -> 0x0027 }
            if (r3 <= 0) goto L_0x0085
            r6 = r0
            goto L_0x0086
        L_0x0085:
            r6 = r4
        L_0x0086:
            r11 = 100
            if (r3 < r11) goto L_0x008d
            r2.clear()     // Catch:{ all -> 0x0027 }
        L_0x008d:
            d()     // Catch:{ all -> 0x0027 }
            java.util.ArrayList r2 = h     // Catch:{ all -> 0x0027 }
            int r14 = r2.size()     // Catch:{ all -> 0x0027 }
            int r3 = r3 + r14
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0027 }
        L_0x009b:
            boolean r14 = r2.hasNext()     // Catch:{ all -> 0x0027 }
            if (r14 == 0) goto L_0x00e4
            java.lang.Object r14 = r2.next()     // Catch:{ all -> 0x0027 }
            com.upuphone.xr.sapp.asmhook.PowerMonitor$WakelockInfo r14 = (com.upuphone.xr.sapp.asmhook.PowerMonitor.WakelockInfo) r14     // Catch:{ all -> 0x0027 }
            long r16 = r14.c     // Catch:{ all -> 0x0027 }
            int r15 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r15 > 0) goto L_0x00b0
            goto L_0x009b
        L_0x00b0:
            int r15 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r15 <= 0) goto L_0x00c8
            r16 = r12
            long r11 = r14.b     // Catch:{ all -> 0x0027 }
            long r11 = java.lang.Math.max(r4, r11)     // Catch:{ all -> 0x0027 }
            r18 = r4
            r4 = r16
            long r4 = java.lang.Math.min(r4, r11)     // Catch:{ all -> 0x0027 }
            r12 = r4
            goto L_0x00cb
        L_0x00c8:
            r18 = r4
            r4 = r12
        L_0x00cb:
            int r4 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r4 >= 0) goto L_0x00d8
            long r4 = r14.c     // Catch:{ all -> 0x0027 }
            long r4 = java.lang.Math.max(r6, r4)     // Catch:{ all -> 0x0027 }
            r6 = r4
        L_0x00d8:
            java.util.HashMap r4 = r14.e     // Catch:{ all -> 0x0027 }
            o(r9, r4)     // Catch:{ all -> 0x0027 }
            r4 = r18
            r11 = 100
            goto L_0x009b
        L_0x00e4:
            r4 = r12
            java.util.ArrayList r0 = h     // Catch:{ all -> 0x0027 }
            r0.clear()     // Catch:{ all -> 0x0027 }
            java.util.HashMap r0 = g     // Catch:{ all -> 0x0027 }
            int r0 = r0.size()     // Catch:{ all -> 0x0027 }
            if (r0 <= 0) goto L_0x00f7
            com.upuphone.xr.sapp.asmhook.PowerMonitor$MonitorThread r0 = b     // Catch:{ all -> 0x0027 }
            r0.a()     // Catch:{ all -> 0x0027 }
        L_0x00f7:
            monitor-exit(r10)     // Catch:{ all -> 0x0027 }
            r0 = 100
            if (r3 < r0) goto L_0x0133
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "wakeLock.acquire too offen, wakeLock count more than "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r1 = " in recent "
            r0.append(r1)
            r1 = 600000(0x927c0, double:2.964394E-318)
            r0.append(r1)
            java.lang.String r1 = "ms. "
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r8.append(r0)
            f(r9, r8)
            java.lang.String r0 = "WAKELOCK"
            p(r0, r8)
            java.lang.String r0 = "PowerMonitor"
            java.lang.String r1 = r8.toString()
            com.upuphone.star.core.log.ULog.m(r0, r1)
            goto L_0x0171
        L_0x0133:
            long r6 = r6 - r4
            r0 = 300000(0x493e0, double:1.482197E-318)
            int r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0171
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "wakeLock.acquire for "
            r0.append(r1)
            r0.append(r6)
            java.lang.String r1 = "ms in recent "
            r0.append(r1)
            r1 = 600000(0x927c0, double:2.964394E-318)
            r0.append(r1)
            java.lang.String r1 = "ms. "
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r8.append(r0)
            f(r9, r8)
            java.lang.String r0 = "WAKELOCK"
            p(r0, r8)
            java.lang.String r0 = "PowerMonitor"
            java.lang.String r1 = r8.toString()
            com.upuphone.star.core.log.ULog.m(r0, r1)
        L_0x0171:
            return
        L_0x0172:
            monitor-exit(r10)     // Catch:{ all -> 0x0027 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.asmhook.PowerMonitor.h():void");
    }

    public static void i() {
        synchronized (f6632a) {
            try {
                boolean u0 = NaviUtil.u0();
                if (c != u0) {
                    c = u0;
                    ULog.d("PowerMonitor", "sIsInNavigation:" + c);
                    if (c) {
                        b.b();
                    } else {
                        d = SystemClock.elapsedRealtime();
                        b.a();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static long j(WakelockInfo wakelockInfo, long j2, int i2) {
        if (wakelockInfo.d.size() <= 0) {
            return 0;
        }
        if (l(wakelockInfo, i2)) {
            long longValue = ((Long) wakelockInfo.d.get(0)).longValue();
            if (longValue < j2) {
                return longValue;
            }
        }
        long longValue2 = ((Long) wakelockInfo.d.get(wakelockInfo.d.size() - 1)).longValue();
        if (longValue2 < j2) {
            return longValue2;
        }
        if (((PowerManager.WakeLock) wakelockInfo.f6636a.get()) != null) {
            return -1;
        }
        StringBuilder sb = new StringBuilder();
        f(wakelockInfo.e, sb);
        ULog.m("PowerMonitor", "getWakelockFinishTimeLocked storeWakeLock null, wakelock may leak release, callers: " + sb);
        return j2;
    }

    public static void k() {
    }

    public static boolean l(WakelockInfo wakelockInfo, int i2) {
        HashMap hashMap = i;
        if (!hashMap.containsKey(Integer.valueOf(i2))) {
            return false;
        }
        PowerManager.WakeLock wakeLock = (PowerManager.WakeLock) ((WeakReference) hashMap.get(Integer.valueOf(i2))).get();
        if (wakeLock == null) {
            ULog.d("PowerMonitor", "isRefCountedFalseLocked storeWakeLock null, ref: " + hashMap.get(Integer.valueOf(i2)));
            hashMap.remove(Integer.valueOf(i2));
        }
        return wakeLock == wakelockInfo.f6636a.get();
    }

    public static void m(HashMap hashMap, String str) {
        n(hashMap, str, 1);
    }

    public static void n(HashMap hashMap, String str, int i2) {
        if (i2 <= 0) {
            i2 = 1;
        }
        Integer num = (Integer) hashMap.get(str);
        if (num == null) {
            hashMap.put(str, Integer.valueOf(i2));
        } else {
            hashMap.put(str, Integer.valueOf(num.intValue() + i2));
        }
    }

    public static void o(HashMap hashMap, HashMap hashMap2) {
        for (Map.Entry entry : hashMap2.entrySet()) {
            n(hashMap, (String) entry.getKey(), ((Integer) entry.getValue()).intValue());
        }
    }

    public static void p(String str, StringBuilder sb) {
        HashMap hashMap = new HashMap();
        hashMap.put(str, sb.toString());
        DataTrackUtil.f7875a.l("power_monitor_event", hashMap, false);
    }
}
