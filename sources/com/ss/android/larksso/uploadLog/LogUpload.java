package com.ss.android.larksso.uploadLog;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class LogUpload {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicInteger f10014a = new AtomicInteger(0);
    public static List b = Collections.synchronizedList(new ArrayList());
    public static Set c = Collections.synchronizedSet(new HashSet());
    public static InnerHandler d = null;
    public static final Object e = new Object();
    public static final Object f = new Object();
    public static String g;
    public static String h;
    public static String i;
    public static boolean j;
    public static URL k;

    public static class InnerHandler extends Handler {
        public InnerHandler(Looper looper) {
            super(looper);
        }

        /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
            java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
            	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
            	at java.util.ArrayList.get(ArrayList.java:435)
            	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processExcHandler(RegionMaker.java:1043)
            	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:975)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
            */
        public void handleMessage(android.os.Message r13) {
            /*
                r12 = this;
                super.handleMessage(r13)
                int r0 = r13.what
                r1 = 1
                if (r0 == 0) goto L_0x0206
                if (r0 == r1) goto L_0x000c
                goto L_0x0221
            L_0x000c:
                java.util.ArrayList r12 = new java.util.ArrayList
                java.util.List r13 = com.ss.android.larksso.uploadLog.LogUpload.b
                r12.<init>(r13)
                java.util.List r13 = com.ss.android.larksso.uploadLog.LogUpload.b
                r13.clear()
                boolean r13 = r12.isEmpty()
                if (r13 == 0) goto L_0x0020
                goto L_0x0221
            L_0x0020:
                int r13 = r12.size()
                int r13 = r13 + -50
                r0 = 0
                if (r13 > 0) goto L_0x002b
                r3 = r0
                goto L_0x0043
            L_0x002b:
                java.util.ListIterator r2 = r12.listIterator()
                r3 = r0
            L_0x0030:
                boolean r4 = r2.hasNext()
                if (r4 == 0) goto L_0x0043
                if (r13 <= 0) goto L_0x0043
                r2.next()
                r2.remove()
                int r13 = r13 + -1
                int r3 = r3 + 1
                goto L_0x0030
            L_0x0043:
                java.util.ArrayList r13 = new java.util.ArrayList
                r13.<init>()
                boolean r2 = r12.isEmpty()
                if (r2 == 0) goto L_0x004f
                goto L_0x006b
            L_0x004f:
                java.util.ArrayList r2 = new java.util.ArrayList
                r2.<init>()
                java.util.Iterator r12 = r12.iterator()
            L_0x0058:
                boolean r4 = r12.hasNext()
                if (r4 == 0) goto L_0x0068
                java.lang.Object r4 = r12.next()
                com.ss.android.larksso.uploadLog.LogUpload$LogEvent r4 = (com.ss.android.larksso.uploadLog.LogUpload.LogEvent) r4
                r2.add(r4)
                goto L_0x0058
            L_0x0068:
                r13.add(r2)
            L_0x006b:
                java.util.Iterator r12 = r13.iterator()
            L_0x006f:
                boolean r13 = r12.hasNext()
                if (r13 == 0) goto L_0x01c3
                java.lang.Object r13 = r12.next()
                java.util.List r13 = (java.util.List) r13
                if (r13 == 0) goto L_0x01b5
                boolean r2 = r13.isEmpty()
                if (r2 == 0) goto L_0x0085
                goto L_0x01b5
            L_0x0085:
                com.ss.android.larksso.uploadLog.UpdateLogRequestBody r2 = new com.ss.android.larksso.uploadLog.UpdateLogRequestBody
                r2.<init>()
                java.lang.String r4 = android.os.Build.MANUFACTURER
                java.lang.String r4 = android.os.Build.VERSION.RELEASE
                java.util.ArrayList r4 = new java.util.ArrayList
                r4.<init>()
                r2.f10017a = r4
                java.util.Iterator r4 = r13.iterator()
            L_0x0099:
                boolean r5 = r4.hasNext()
                if (r5 == 0) goto L_0x00f0
                java.lang.Object r5 = r4.next()
                com.ss.android.larksso.uploadLog.LogUpload$LogEvent r5 = (com.ss.android.larksso.uploadLog.LogUpload.LogEvent) r5
                java.util.List<com.ss.android.larksso.uploadLog.UpdateLogRequestBody$DataEntity> r6 = r2.f10017a
                com.ss.android.larksso.uploadLog.UpdateLogRequestBody$DataEntity r7 = new com.ss.android.larksso.uploadLog.UpdateLogRequestBody$DataEntity
                r7.<init>()
                com.ss.android.larksso.uploadLog.UpdateLogRequestBody$DataDataEntity r8 = new com.ss.android.larksso.uploadLog.UpdateLogRequestBody$DataDataEntity
                r8.<init>()
                com.ss.android.larksso.uploadLog.UpdateLogRequestBody$DataDataEntity$MessageBuilder r9 = new com.ss.android.larksso.uploadLog.UpdateLogRequestBody$DataDataEntity$MessageBuilder
                r9.<init>()
                long r10 = r5.h
                r9.f10018a = r10
                java.lang.String r10 = r5.c
                r9.b = r10
                java.lang.String r10 = r5.j
                r9.c = r10
                java.lang.String r10 = "release"
                r9.d = r10
                java.lang.String r10 = "unknown"
                r9.f = r10
                java.lang.String r10 = "main"
                r9.g = r10
                boolean r5 = r5.g
                r9.h = r5
                boolean r5 = com.ss.android.larksso.uploadLog.LogUpload.j
                if (r5 == 0) goto L_0x00d9
                java.lang.String r10 = "feishu"
                goto L_0x00db
            L_0x00d9:
                java.lang.String r10 = "lark"
            L_0x00db:
                r9.i = r10
                if (r5 == 0) goto L_0x00e2
                java.lang.String r5 = "feishu"
                goto L_0x00e4
            L_0x00e2:
                java.lang.String r5 = "lark"
            L_0x00e4:
                r9.j = r5
                android.os.Process.myPid()
                com.alibaba.fastjson.JSON.toJSONString(r8)     // Catch:{ all -> 0x00ec }
            L_0x00ec:
                r6.add(r7)
                goto L_0x0099
            L_0x00f0:
                com.ss.android.larksso.uploadLog.UpLoadRequest r4 = new com.ss.android.larksso.uploadLog.UpLoadRequest
                r4.<init>(r2)
                java.net.URL r2 = com.ss.android.larksso.uploadLog.LogUpload.k
                if (r2 != 0) goto L_0x00fb
                goto L_0x01b5
            L_0x00fb:
                r5 = 0
                com.ss.android.larksso.uploadLog.UpdateLogRequestBody r4 = r4.f10016a     // Catch:{ all -> 0x01a3 }
                java.lang.String r4 = com.alibaba.fastjson.JSON.toJSONString(r4)     // Catch:{ all -> 0x01a3 }
                byte[] r4 = r4.getBytes()     // Catch:{ all -> 0x01a3 }
                java.net.URLConnection r2 = r2.openConnection()     // Catch:{ all -> 0x01a3 }
                java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ all -> 0x01a3 }
                r5 = 3000(0xbb8, float:4.204E-42)
                r2.setConnectTimeout(r5)     // Catch:{ all -> 0x01a0 }
                r2.setDoInput(r1)     // Catch:{ all -> 0x01a0 }
                r2.setDoOutput(r1)     // Catch:{ all -> 0x01a0 }
                java.lang.String r5 = "POST"
                r2.setRequestMethod(r5)     // Catch:{ all -> 0x01a0 }
                r2.setUseCaches(r0)     // Catch:{ all -> 0x01a0 }
                java.lang.String r5 = "Connection"
                java.lang.String r6 = "Keep-Alive"
                r2.setRequestProperty(r5, r6)     // Catch:{ all -> 0x01a0 }
                java.lang.String r5 = "Locale"
                java.lang.String r6 = "zh_CN"
                r2.setRequestProperty(r5, r6)     // Catch:{ all -> 0x01a0 }
                java.lang.String r5 = "X-Request-ID"
                java.util.UUID r6 = java.util.UUID.randomUUID()     // Catch:{ all -> 0x01a0 }
                java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x01a0 }
                java.lang.String r7 = "-"
                java.lang.String r8 = ""
                java.lang.String r6 = r6.replace(r7, r8)     // Catch:{ all -> 0x01a0 }
                r2.setRequestProperty(r5, r6)     // Catch:{ all -> 0x01a0 }
                java.lang.String r5 = "X-Terminal-Type"
                java.lang.String r6 = "3"
                r2.setRequestProperty(r5, r6)     // Catch:{ all -> 0x01a0 }
                java.lang.String r5 = "X-Api-Version"
                java.lang.String r6 = "3-10"
                r2.setRequestProperty(r5, r6)     // Catch:{ all -> 0x01a0 }
                java.lang.String r5 = "Content-Type"
                java.lang.String r6 = "application/json;charset=utf-8"
                r2.setRequestProperty(r5, r6)     // Catch:{ all -> 0x01a0 }
                java.lang.String r5 = "X-Passport-Unit"
                java.lang.String r6 = "eu_nc"
                r2.setRequestProperty(r5, r6)     // Catch:{ all -> 0x01a0 }
                java.io.OutputStream r5 = r2.getOutputStream()     // Catch:{ all -> 0x01a0 }
                int r6 = r4.length     // Catch:{ all -> 0x01a0 }
                r5.write(r4, r0, r6)     // Catch:{ all -> 0x01a0 }
                int r4 = r2.getResponseCode()     // Catch:{ all -> 0x01a0 }
                r5 = 200(0xc8, float:2.8E-43)
                if (r4 != r5) goto L_0x01aa
                java.io.InputStream r4 = r2.getInputStream()     // Catch:{ all -> 0x01a0 }
                java.lang.String r5 = "utf-8"
                java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x01a0 }
                r6.<init>()     // Catch:{ all -> 0x01a0 }
                r7 = 1024(0x400, float:1.435E-42)
                byte[] r7 = new byte[r7]     // Catch:{ all -> 0x01a0 }
                if (r4 == 0) goto L_0x01aa
            L_0x017f:
                int r8 = r4.read(r7)     // Catch:{ all -> 0x018d }
                r9 = -1
                if (r8 == r9) goto L_0x018f
                r7.toString()     // Catch:{ all -> 0x018d }
                r6.write(r7, r0, r8)     // Catch:{ all -> 0x018d }
                goto L_0x017f
            L_0x018d:
                r4 = move-exception
                goto L_0x019c
            L_0x018f:
                java.lang.String r4 = new java.lang.String     // Catch:{ all -> 0x018d }
                byte[] r7 = r6.toByteArray()     // Catch:{ all -> 0x018d }
                r4.<init>(r7, r5)     // Catch:{ all -> 0x018d }
                r6.flush()     // Catch:{ all -> 0x018d }
                goto L_0x01aa
            L_0x019c:
                r4.printStackTrace()     // Catch:{ all -> 0x01a0 }
                goto L_0x01aa
            L_0x01a0:
                r4 = move-exception
                r5 = r2
                goto L_0x01a4
            L_0x01a3:
                r4 = move-exception
            L_0x01a4:
                r4.printStackTrace()     // Catch:{ all -> 0x01ae }
                if (r5 == 0) goto L_0x01b5
                r2 = r5
            L_0x01aa:
                r2.disconnect()
                goto L_0x01b5
            L_0x01ae:
                r12 = move-exception
                if (r5 == 0) goto L_0x01b4
                r5.disconnect()
            L_0x01b4:
                throw r12
            L_0x01b5:
                java.lang.Object r2 = com.ss.android.larksso.uploadLog.LogUpload.f
                monitor-enter(r2)
                java.util.Set r4 = com.ss.android.larksso.uploadLog.LogUpload.c     // Catch:{ all -> 0x01c0 }
                r4.addAll(r13)     // Catch:{ all -> 0x01c0 }
                monitor-exit(r2)     // Catch:{ all -> 0x01c0 }
                goto L_0x006f
            L_0x01c0:
                r12 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x01c0 }
                throw r12
            L_0x01c3:
                if (r3 <= 0) goto L_0x0221
                java.lang.String r12 = "LogUpload"
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>()
                java.lang.String r2 = "limitEvents remove "
                r13.append(r2)
                r13.append(r3)
                java.lang.String r13 = r13.toString()
                com.ss.android.larksso.uploadLog.LogLevel r2 = com.ss.android.larksso.uploadLog.LogLevel.info     // Catch:{ Exception -> 0x0201 }
                java.lang.String r2 = r2.f10013a     // Catch:{ Exception -> 0x0201 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0201 }
                r3.<init>()     // Catch:{ Exception -> 0x0201 }
                r3.append(r12)     // Catch:{ Exception -> 0x0201 }
                java.lang.String r4 = ": "
                r3.append(r4)     // Catch:{ Exception -> 0x0201 }
                r3.append(r13)     // Catch:{ Exception -> 0x0201 }
                java.lang.String r4 = ",LarkSSO=true,associate_id="
                r3.append(r4)     // Catch:{ Exception -> 0x0201 }
                java.lang.String r4 = com.ss.android.larksso.uploadLog.LogUpload.i     // Catch:{ Exception -> 0x0201 }
                r3.append(r4)     // Catch:{ Exception -> 0x0201 }
                java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0201 }
                com.ss.android.larksso.uploadLog.LogUpload.b(r2, r3, r0, r1)     // Catch:{ Exception -> 0x0201 }
                android.util.Log.i(r12, r13)     // Catch:{ Exception -> 0x0201 }
                goto L_0x0221
            L_0x0201:
                r12 = move-exception
                r12.printStackTrace()
                goto L_0x0221
            L_0x0206:
                java.lang.Object r13 = r13.obj
                com.ss.android.larksso.uploadLog.LogUpload$LogEvent r13 = (com.ss.android.larksso.uploadLog.LogUpload.LogEvent) r13
                boolean r0 = r13.i
                if (r0 != 0) goto L_0x020f
                goto L_0x0221
            L_0x020f:
                java.util.List r0 = com.ss.android.larksso.uploadLog.LogUpload.b
                boolean r0 = r0.isEmpty()
                java.util.List r2 = com.ss.android.larksso.uploadLog.LogUpload.b
                r2.add(r13)
                if (r0 == 0) goto L_0x0221
                r2 = 3000(0xbb8, double:1.482E-320)
                r12.sendEmptyMessageDelayed(r1, r2)
            L_0x0221:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ss.android.larksso.uploadLog.LogUpload.InnerHandler.handleMessage(android.os.Message):void");
        }
    }

    public static class LogEvent {

        /* renamed from: a  reason: collision with root package name */
        public String f10015a;
        public String b;
        public String c;
        public String d;
        public int e;
        public String f;
        public boolean g;
        public long h;
        public boolean i;
        public String j;
    }

    public static void a(String str, String str2) {
        try {
            String str3 = LogLevel.error.f10013a;
            b(str3, str + ": " + str2 + ",LarkSSO=true,associate_id=" + i, false, true);
            Log.e(str, str2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void b(String str, String str2, boolean z, boolean z2) {
        LogEvent logEvent;
        synchronized (f) {
            try {
                Iterator it = c.iterator();
                logEvent = null;
                while (it.hasNext()) {
                    logEvent = (LogEvent) it.next();
                    it.remove();
                }
            } finally {
                while (true) {
                }
            }
        }
        if (logEvent == null) {
            logEvent = new LogEvent();
        }
        logEvent.b = str;
        logEvent.c = str2;
        boolean unused = logEvent.g = z;
        logEvent.f = Thread.currentThread().getName();
        logEvent.f10015a = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX", Locale.getDefault()).format(new Date());
        logEvent.h = (long) f10014a.getAndIncrement();
        boolean unused2 = logEvent.i = z2;
        logEvent.j = h;
        try {
            logEvent.d = "file";
            logEvent.e = 0;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        Message obtain = Message.obtain();
        obtain.what = 0;
        obtain.obj = logEvent;
        if (d == null) {
            synchronized (e) {
                try {
                    if (d == null) {
                        HandlerThread handlerThread = new HandlerThread("LogUpload");
                        handlerThread.start();
                        d = new InnerHandler(handlerThread.getLooper());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        d.sendMessage(obtain);
    }
}
