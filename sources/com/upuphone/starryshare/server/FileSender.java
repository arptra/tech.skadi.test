package com.upuphone.starryshare.server;

import android.content.Context;
import com.upuphone.starrycommon.utils.StarryCastLog;
import com.upuphone.starryshare.bean.FileInfo;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class FileSender extends BaseTransfer implements Runnable {
    public static final String l = "FileSender";

    /* renamed from: a  reason: collision with root package name */
    public String f6556a;
    public int b;
    public List c;
    public Socket d;
    public DataOutputStream e;
    public final Object f = new Object();
    public boolean g = false;
    public boolean h = false;
    public boolean i = false;
    public OnSendListener j;
    public Context k;

    public interface OnSendListener {
        void a(Throwable th, int i);

        void b(FileInfo fileInfo);

        void c(int i, FileInfo fileInfo);

        void onStart();

        void onSuccess();
    }

    public FileSender(Context context, List list, String str, int i2) {
        this.c = list;
        this.f6556a = str;
        this.b = i2;
        this.k = context;
    }

    public final long a() {
        long j2 = 0;
        for (FileInfo size : this.c) {
            j2 += size.getSize();
        }
        return j2;
    }

    public void b() {
        Socket socket = this.d;
        if (socket != null && socket.isConnected()) {
            try {
                this.d.close();
            } catch (IOException e2) {
                String str = l;
                StarryCastLog.c(str, "cancel" + e2.getMessage());
                e2.printStackTrace();
            }
        }
    }

    public void c() {
        DataOutputStream dataOutputStream = this.e;
        if (dataOutputStream != null) {
            try {
                dataOutputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        Socket socket = this.d;
        if (socket != null && socket.isConnected()) {
            try {
                this.d.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
        StarryCastLog.d(l, "FileSender close socket######>>>");
    }

    public void d() {
        Socket socket = new Socket(this.f6556a, this.b);
        this.d = socket;
        socket.setTcpNoDelay(true);
        this.e = new DataOutputStream(this.d.getOutputStream());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00cf, code lost:
        r17 = r2;
        r16 = r6;
        r1.e.flush();
        r10.close();
        r11.close();
        r0 = r1.j;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00e0, code lost:
        if (r0 == null) goto L_0x00e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00e2, code lost:
        r0.b(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00e5, code lost:
        r6 = r16;
        r2 = r17;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e() {
        /*
            r23 = this;
            r1 = r23
            java.lang.String r0 = l
            java.lang.String r2 = "parseBody######>>>start"
            com.upuphone.starrycommon.utils.StarryCastLog.d(r0, r2)
            long r2 = java.lang.System.currentTimeMillis()
            long r4 = r23.a()
            java.util.List r0 = r1.c
            java.util.Iterator r6 = r0.iterator()
            r7 = 0
        L_0x0019:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x00eb
            java.lang.Object r0 = r6.next()
            r9 = r0
            com.upuphone.starryshare.bean.FileInfo r9 = (com.upuphone.starryshare.bean.FileInfo) r9
            android.net.Uri r0 = r9.getUri()
            r10 = 0
            java.lang.String r11 = r0.getScheme()     // Catch:{ Exception -> 0x0057 }
            java.lang.String r12 = "file"
            boolean r11 = r11.startsWith(r12)     // Catch:{ Exception -> 0x0057 }
            if (r11 == 0) goto L_0x0059
            android.content.Context r0 = r1.k     // Catch:{ Exception -> 0x0057 }
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ Exception -> 0x0057 }
            java.io.File r11 = new java.io.File     // Catch:{ Exception -> 0x0057 }
            java.lang.String r12 = r9.getFilePath()     // Catch:{ Exception -> 0x0057 }
            r11.<init>(r12)     // Catch:{ Exception -> 0x0057 }
            android.net.Uri r11 = android.net.Uri.fromFile(r11)     // Catch:{ Exception -> 0x0057 }
            java.io.InputStream r10 = r0.openInputStream(r11)     // Catch:{ Exception -> 0x0057 }
            if (r10 == 0) goto L_0x0051
            goto L_0x0073
        L_0x0051:
            java.io.FileNotFoundException r0 = new java.io.FileNotFoundException     // Catch:{ Exception -> 0x0057 }
            r0.<init>()     // Catch:{ Exception -> 0x0057 }
            throw r0     // Catch:{ Exception -> 0x0057 }
        L_0x0057:
            r0 = move-exception
            goto L_0x0070
        L_0x0059:
            java.lang.String r11 = r0.getScheme()     // Catch:{ Exception -> 0x0057 }
            java.lang.String r12 = "content"
            boolean r11 = r11.startsWith(r12)     // Catch:{ Exception -> 0x0057 }
            if (r11 == 0) goto L_0x0073
            android.content.Context r11 = r1.k     // Catch:{ Exception -> 0x0057 }
            android.content.ContentResolver r11 = r11.getContentResolver()     // Catch:{ Exception -> 0x0057 }
            java.io.InputStream r10 = r11.openInputStream(r0)     // Catch:{ Exception -> 0x0057 }
            goto L_0x0073
        L_0x0070:
            r0.printStackTrace()
        L_0x0073:
            java.io.BufferedInputStream r11 = new java.io.BufferedInputStream
            r11.<init>(r10)
            long r12 = r9.getBeginOfFile()
            long r7 = r7 + r12
            r11.skip(r12)
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r12 = new byte[r0]
            long r13 = java.lang.System.currentTimeMillis()
        L_0x0088:
            int r15 = r11.read(r12)
            r0 = -1
            if (r15 == r0) goto L_0x00cf
            r16 = r6
            java.lang.Object r6 = r1.f
            monitor-enter(r6)
            boolean r0 = r1.g     // Catch:{ all -> 0x009e }
            if (r0 == 0) goto L_0x00a4
            java.lang.Object r0 = r1.f     // Catch:{ InterruptedException -> 0x00a0 }
            r0.wait()     // Catch:{ InterruptedException -> 0x00a0 }
            goto L_0x00a4
        L_0x009e:
            r0 = move-exception
            goto L_0x00cd
        L_0x00a0:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x009e }
        L_0x00a4:
            java.io.DataOutputStream r0 = r1.e     // Catch:{ all -> 0x009e }
            r17 = r2
            r2 = 0
            r0.write(r12, r2, r15)     // Catch:{ all -> 0x009e }
            long r2 = (long) r15     // Catch:{ all -> 0x009e }
            long r7 = r7 + r2
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x009e }
            long r19 = r2 - r13
            r21 = 200(0xc8, double:9.9E-322)
            int r0 = (r19 > r21 ? 1 : (r19 == r21 ? 0 : -1))
            if (r0 <= 0) goto L_0x00c7
            com.upuphone.starryshare.server.FileSender$OnSendListener r0 = r1.j     // Catch:{ all -> 0x009e }
            if (r0 == 0) goto L_0x00c6
            r13 = 100
            long r13 = r13 * r7
            long r13 = r13 / r4
            int r13 = (int) r13     // Catch:{ all -> 0x009e }
            r0.c(r13, r9)     // Catch:{ all -> 0x009e }
        L_0x00c6:
            r13 = r2
        L_0x00c7:
            monitor-exit(r6)     // Catch:{ all -> 0x009e }
            r6 = r16
            r2 = r17
            goto L_0x0088
        L_0x00cd:
            monitor-exit(r6)     // Catch:{ all -> 0x009e }
            throw r0
        L_0x00cf:
            r17 = r2
            r16 = r6
            java.io.DataOutputStream r0 = r1.e
            r0.flush()
            r10.close()
            r11.close()
            com.upuphone.starryshare.server.FileSender$OnSendListener r0 = r1.j
            if (r0 == 0) goto L_0x00e5
            r0.b(r9)
        L_0x00e5:
            r6 = r16
            r2 = r17
            goto L_0x0019
        L_0x00eb:
            r17 = r2
            long r2 = java.lang.System.currentTimeMillis()
            java.lang.String r0 = l
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "FileSender body write######>>>"
            r4.append(r5)
            long r2 = r2 - r17
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            com.upuphone.starrycommon.utils.StarryCastLog.d(r0, r2)
            java.io.DataOutputStream r2 = r1.e
            r2.close()
            java.lang.String r2 = "parseBody######>>>end"
            com.upuphone.starrycommon.utils.StarryCastLog.d(r0, r2)
            com.upuphone.starryshare.server.FileSender$OnSendListener r0 = r1.j
            if (r0 == 0) goto L_0x011a
            r0.onSuccess()
        L_0x011a:
            r0 = 1
            r1.h = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.starryshare.server.FileSender.e():void");
    }

    public void f() {
        String str = l;
        StarryCastLog.d(str, "parseHeader######>>>start");
        String str2 = "1::" + FileInfo.toJsonStr(this.c);
        Charset charset = StandardCharsets.UTF_8;
        int length = str2.getBytes(charset).length;
        byte[] bytes = str2.getBytes(charset);
        this.e.writeInt(length);
        this.e.flush();
        this.e.write(bytes);
        this.e.flush();
        StarryCastLog.d(str, "FileSender header write------>>>" + new String(bytes, "UTF-8"));
        StarryCastLog.d(str, "parseHeader######>>>end");
    }

    public void g(OnSendListener onSendListener) {
        this.j = onSendListener;
    }

    public void run() {
        if (!this.i) {
            try {
                OnSendListener onSendListener = this.j;
                if (onSendListener != null) {
                    onSendListener.onStart();
                }
                d();
                try {
                    f();
                    try {
                        e();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        StarryCastLog.d(l, "FileSender init() --->>> occur expection");
                        c();
                        if (this.j != null) {
                            this.j.a(e2, -3);
                        }
                        c();
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                    c();
                    StarryCastLog.d(l, "FileSender init() --->>> occur expection");
                    if (this.j != null) {
                        this.j.a(e3, -2);
                    }
                    c();
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                c();
                StarryCastLog.d(l, "FileSender init() --->>> occur expection");
                OnSendListener onSendListener2 = this.j;
                if (onSendListener2 != null) {
                    onSendListener2.a(e4, -1);
                }
                c();
            }
        }
    }
}
