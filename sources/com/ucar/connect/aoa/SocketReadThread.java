package com.ucar.connect.aoa;

import com.easy.logger.EasyLog;
import com.ucar.protocol.channel.ChannelType;
import com.ucar.util.ByteConvert;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class SocketReadThread extends Thread {
    public static final AtomicInteger m = new AtomicInteger(16);

    /* renamed from: a  reason: collision with root package name */
    public final CountDownLatch f9626a = new CountDownLatch(1);
    public final byte[] b = new byte[8];
    public final int c;
    public boolean d;
    public final String e;
    public final String f;
    public Socket g = null;
    public BufferedInputStream h = null;
    public BufferedOutputStream i = null;
    public volatile int j = -1;
    public int k = -1;
    public int l = 2;

    /* renamed from: com.ucar.connect.aoa.SocketReadThread$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f9627a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.ucar.protocol.channel.ChannelType[] r0 = com.ucar.protocol.channel.ChannelType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f9627a = r0
                com.ucar.protocol.channel.ChannelType r1 = com.ucar.protocol.channel.ChannelType.RTP     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f9627a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.ucar.protocol.channel.ChannelType r1 = com.ucar.protocol.channel.ChannelType.RTSP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f9627a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.ucar.protocol.channel.ChannelType r1 = com.ucar.protocol.channel.ChannelType.UIBC     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f9627a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.ucar.protocol.channel.ChannelType r1 = com.ucar.protocol.channel.ChannelType.AUTH     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f9627a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.ucar.protocol.channel.ChannelType r1 = com.ucar.protocol.channel.ChannelType.CONTROL     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f9627a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.ucar.protocol.channel.ChannelType r1 = com.ucar.protocol.channel.ChannelType.MEDIA     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f9627a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.ucar.protocol.channel.ChannelType r1 = com.ucar.protocol.channel.ChannelType.SENSOR     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f9627a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.ucar.protocol.channel.ChannelType r1 = com.ucar.protocol.channel.ChannelType.CERT     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ucar.connect.aoa.SocketReadThread.AnonymousClass1.<clinit>():void");
        }
    }

    public SocketReadThread(int i2, String str, int i3) {
        this.c = i2;
        String str2 = str + "SocketReadThread";
        this.f = str2;
        setName(str2);
        EasyLog.a("AOASocketReadThread", "Create " + str2 + ",ChannelId " + i3);
        this.e = str;
        if (i3 != -1) {
            p(i3);
        }
        this.d = true;
    }

    public int a(int i2) {
        switch (AnonymousClass1.f9627a[ChannelType.fromPort(i2).ordinal()]) {
            case 1:
                return 4;
            case 2:
                return 3;
            case 3:
                return 5;
            case 4:
                return 7;
            case 5:
                return 2;
            case 6:
                return 6;
            case 7:
                return 8;
            case 8:
                return 9;
            default:
                return m.getAndIncrement();
        }
    }

    public void b() {
        try {
            Socket socket = this.g;
            if (socket != null) {
                socket.close();
                this.g = null;
            }
            BufferedInputStream bufferedInputStream = this.h;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
                this.h = null;
            }
            BufferedOutputStream bufferedOutputStream = this.i;
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
                this.i = null;
            }
            this.d = false;
        } catch (Exception e2) {
            EasyLog.d("AOASocketReadThread", "Close " + this.f + " fail. ", e2);
        }
    }

    public String c() {
        StringBuilder sb = new StringBuilder();
        sb.append("--------------------------------\n");
        sb.append("Socket name(");
        sb.append(f());
        sb.append(")\nSocket port(");
        sb.append(g());
        sb.append(")\nChannel ID(");
        sb.append(d());
        sb.append(")\nSocket type(");
        sb.append(k() ? "server" : "client");
        sb.append(")\nMsg type(");
        sb.append(l() ? "ucar" : "raw");
        sb.append(")\n");
        return sb.toString();
    }

    public int d() {
        return this.j;
    }

    public int e() {
        return this.l;
    }

    public String f() {
        return this.e;
    }

    public int g() {
        return this.c;
    }

    public int h() {
        return this.k;
    }

    public String i() {
        return this.f;
    }

    public boolean j() {
        return this.d;
    }

    public boolean k() {
        return h() == 1;
    }

    public boolean l() {
        return e() == 1;
    }

    public void m() {
        this.f9626a.countDown();
    }

    public void n() {
    }

    public int o(byte[] bArr, int i2, int i3) {
        try {
            if (this.h != null) {
                int i4 = 0;
                int i5 = i3;
                while (i5 > 0) {
                    int read = this.h.read(bArr, i2 + i4, i5);
                    if (read > 0) {
                        i5 -= read;
                        i4 += read;
                    } else {
                        throw new IOException("Receive Data Error: ret = " + read);
                    }
                }
                if (i4 == i3) {
                    return i4;
                }
                throw new IOException("Expect receive " + i3 + " bytes, but received " + i4 + " bytes");
            }
            throw new IOException("mInputStream is null");
        } catch (Exception e2) {
            EasyLog.d("AOASocketReadThread", this.e + " readData exception:" + e2.getMessage(), e2);
            return -1;
        }
    }

    public void p(int i2) {
        if (i2 == -1) {
            EasyLog.c("AOASocketReadThread", "set " + this.e + " channel id failed, use invalid channel id");
        } else if (this.j == -1) {
            this.j = i2;
            System.arraycopy(ByteConvert.d(this.j), 0, this.b, 0, 4);
        } else {
            EasyLog.i("AOASocketReadThread", "set " + this.e + " channel id failed, channel id already set");
        }
    }

    public void q(int i2) {
        if (i2 == 1 || i2 == 2) {
            this.l = i2;
        } else {
            EasyLog.c("AOASocketReadThread", "invalid msg type");
        }
    }

    public void r(int i2) {
        this.k = i2;
    }

    public void run() {
        EasyLog.a("AOASocketReadThread", "Begin to run in " + this.f);
        if (h() != 2) {
            m();
        }
        Socket u = u();
        this.g = u;
        if (u != null) {
            try {
                this.h = new BufferedInputStream(this.g.getInputStream());
                this.i = new BufferedOutputStream(this.g.getOutputStream());
                n();
            } catch (IOException e2) {
                EasyLog.d("AOASocketReadThread", "Get Exception in " + this.f, e2);
            }
        }
        if (h() == 2) {
            m();
        }
        try {
            byte[] bArr = new byte[20];
            byte[] bArr2 = new byte[65536];
            while (true) {
                Socket socket = this.g;
                if (socket != null && this.d) {
                    if (!socket.isConnected()) {
                        EasyLog.c("AOASocketReadThread", "socket is disconnected when read data");
                        return;
                    } else if (this.l != 1) {
                        int s = s(bArr2, 0, 65536);
                        if (s >= 0) {
                            ByteConvert.c(s, this.b, 4);
                            if (AOAHostSetup.m().e(this.b, 8, bArr2, Math.max(s, 8)) < 0) {
                                EasyLog.c("AOASocketReadThread", "raw data bulkTransferOut fail");
                                return;
                            }
                        } else {
                            return;
                        }
                    } else if (o(bArr, 0, 20) >= 0) {
                        int a2 = ByteConvert.a(bArr, 0);
                        int i2 = a2 - 20;
                        ByteConvert.c(a2, this.b, 4);
                        if (bArr.length < a2) {
                            byte[] bArr3 = new byte[a2];
                            System.arraycopy(bArr, 0, bArr3, 0, 20);
                            bArr = bArr3;
                        }
                        if (o(bArr, 20, i2) >= 0) {
                            if (AOAHostSetup.m().e(this.b, 8, bArr, a2) < 0) {
                                EasyLog.c("AOASocketReadThread", "ucar data bulkTransferOut fail");
                                return;
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        } catch (Exception e3) {
            EasyLog.d("AOASocketReadThread", "get Exception in ReadThread", e3);
        }
    }

    public int s(byte[] bArr, int i2, int i3) {
        try {
            BufferedInputStream bufferedInputStream = this.h;
            if (bufferedInputStream != null) {
                return bufferedInputStream.read(bArr, i2, i3);
            }
            throw new IOException("mInputStream is null");
        } catch (Exception e2) {
            EasyLog.d("AOASocketReadThread", this.e + " tryReadData exception:" + e2.getMessage(), e2);
            return -1;
        }
    }

    public void t() {
        try {
            EasyLog.e("AOASocketReadThread", "Waiting for socket running");
            if (!this.f9626a.await(500, TimeUnit.MILLISECONDS)) {
                EasyLog.e("AOASocketReadThread", "Waiting for socket ready timeout");
            }
        } catch (InterruptedException e2) {
            EasyLog.d("AOASocketReadThread", "Socket READY.await() failed.", e2);
        }
    }

    public String toString() {
        return c();
    }

    public abstract Socket u();

    public int v(byte[] bArr, int i2, int i3) {
        try {
            BufferedOutputStream bufferedOutputStream = this.i;
            if (bufferedOutputStream != null) {
                bufferedOutputStream.write(bArr, i2, i3);
                this.i.flush();
                return i3;
            }
            throw new IOException("mOutputStream is null");
        } catch (Exception e2) {
            EasyLog.d("AOASocketReadThread", this.e + " writeData exception:" + e2.getMessage(), e2);
            return -1;
        }
    }
}
