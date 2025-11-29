package com.geetest.sdk.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class l {

    /* renamed from: a  reason: collision with root package name */
    public static b f2963a = null;
    public static boolean b = true;

    public static class b {
        public static String d = "";

        /* renamed from: a  reason: collision with root package name */
        public HandlerThread f2964a;
        public Handler b;
        public SimpleDateFormat c = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

        public class a extends Handler {
            public a(Looper looper) {
                super(looper);
            }

            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (!Thread.interrupted()) {
                    int i = message.what;
                    if (i == 0) {
                        C0014b bVar = (C0014b) message.obj;
                        b bVar2 = b.this;
                        bVar2.e(b.g(bVar2.c, bVar.f2966a, bVar.b, bVar.c));
                    } else if (i == 1) {
                        boolean unused = b.j();
                    }
                }
            }
        }

        /* renamed from: com.geetest.sdk.utils.l$b$b  reason: collision with other inner class name */
        public static class C0014b {

            /* renamed from: a  reason: collision with root package name */
            public long f2966a;
            public String b;
            public String c;

            public C0014b() {
            }
        }

        public static String g(SimpleDateFormat simpleDateFormat, long j, String str, String str2) {
            return simpleDateFormat.format(new Date(j)) + 9 + str + 10 + str2 + 10;
        }

        public static boolean j() {
            File file = new File(k());
            if (!file.exists()) {
                return false;
            }
            File file2 = new File(file, "sensebot_log.txt");
            if (file2.exists() && file2.length() >= 10485760) {
                return file2.delete();
            }
            return false;
        }

        public static String k() {
            if (TextUtils.isEmpty(d)) {
                d = m.a() + File.separator + "Geetest";
            }
            return d;
        }

        public synchronized void c() {
            Message obtainMessage = this.b.obtainMessage();
            obtainMessage.what = 1;
            this.b.sendMessage(obtainMessage);
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x003e A[SYNTHETIC, Splitter:B:21:0x003e] */
        /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void e(java.lang.String r6) {
            /*
                r5 = this;
                java.io.File r5 = new java.io.File
                java.lang.String r0 = k()
                r5.<init>(r0)
                boolean r0 = r5.exists()
                if (r0 != 0) goto L_0x0012
                r5.mkdirs()
            L_0x0012:
                r0 = 0
                java.io.BufferedOutputStream r1 = new java.io.BufferedOutputStream     // Catch:{ FileNotFoundException -> 0x0048, UnsupportedEncodingException -> 0x0045, Exception -> 0x0042, all -> 0x003b }
                java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0048, UnsupportedEncodingException -> 0x0045, Exception -> 0x0042, all -> 0x003b }
                java.io.File r3 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0048, UnsupportedEncodingException -> 0x0045, Exception -> 0x0042, all -> 0x003b }
                java.lang.String r4 = "sensebot_log.txt"
                r3.<init>(r5, r4)     // Catch:{ FileNotFoundException -> 0x0048, UnsupportedEncodingException -> 0x0045, Exception -> 0x0042, all -> 0x003b }
                r5 = 1
                r2.<init>(r3, r5)     // Catch:{ FileNotFoundException -> 0x0048, UnsupportedEncodingException -> 0x0045, Exception -> 0x0042, all -> 0x003b }
                r1.<init>(r2)     // Catch:{ FileNotFoundException -> 0x0048, UnsupportedEncodingException -> 0x0045, Exception -> 0x0042, all -> 0x003b }
                java.lang.String r5 = "utf-8"
                byte[] r5 = r6.getBytes(r5)     // Catch:{ FileNotFoundException -> 0x0039, UnsupportedEncodingException -> 0x0037, Exception -> 0x0035, all -> 0x0032 }
                r1.write(r5)     // Catch:{ FileNotFoundException -> 0x0039, UnsupportedEncodingException -> 0x0037, Exception -> 0x0035, all -> 0x0032 }
                r1.close()     // Catch:{ Exception -> 0x004d }
                goto L_0x004d
            L_0x0032:
                r5 = move-exception
                r0 = r1
                goto L_0x003c
            L_0x0035:
                r0 = r1
                goto L_0x0042
            L_0x0037:
                r0 = r1
                goto L_0x0045
            L_0x0039:
                r0 = r1
                goto L_0x0048
            L_0x003b:
                r5 = move-exception
            L_0x003c:
                if (r0 == 0) goto L_0x0041
                r0.close()     // Catch:{ Exception -> 0x0041 }
            L_0x0041:
                throw r5
            L_0x0042:
                if (r0 == 0) goto L_0x004d
                goto L_0x004a
            L_0x0045:
                if (r0 == 0) goto L_0x004d
                goto L_0x004a
            L_0x0048:
                if (r0 == 0) goto L_0x004d
            L_0x004a:
                r0.close()     // Catch:{ Exception -> 0x004d }
            L_0x004d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.geetest.sdk.utils.l.b.e(java.lang.String):void");
        }

        public synchronized void f(String str, String str2) {
            Message obtainMessage = this.b.obtainMessage();
            obtainMessage.what = 0;
            C0014b bVar = new C0014b();
            bVar.f2966a = System.currentTimeMillis();
            bVar.b = str;
            bVar.c = str2;
            obtainMessage.obj = bVar;
            this.b.sendMessage(obtainMessage);
        }

        public synchronized void h() {
            HandlerThread handlerThread = new HandlerThread("Geetest Thread");
            this.f2964a = handlerThread;
            handlerThread.start();
            this.b = new a(this.f2964a.getLooper());
        }
    }

    public static void a(String str, String str2) {
        if (f2963a == null) {
            b bVar = new b();
            f2963a = bVar;
            bVar.h();
            f2963a.c();
        }
        f2963a.f(str, str2);
    }

    public static void b(boolean z) {
        b = z;
    }

    public static void c(String str, String str2) {
        if (b) {
            Log.i(str, str2);
            a(str, str2);
        }
    }

    public static void d(String str, String str2) {
        if (b) {
            Log.e(str, str2);
            a(str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (b) {
            Log.i(str, str2);
            a(str, str2);
        }
    }
}
