package javax.obex;

import android.util.Log;
import com.google.mlkit.common.MlKitException;
import com.here.posclient.analytics.TrackerEvent;
import com.upuphone.starrynet.strategy.discovery.advertiser.pack.AdvPackConstants;
import java.io.InputStream;
import java.io.OutputStream;

public final class ServerSession extends ObexSession implements Runnable {
    public ObexTransport c;
    public InputStream d;
    public OutputStream e;
    public ServerRequestHandler f;
    public int g;
    public boolean h;

    public synchronized void c() {
        ServerRequestHandler serverRequestHandler = this.f;
        if (serverRequestHandler != null) {
            serverRequestHandler.d();
        }
        try {
            this.d.close();
            this.e.close();
            this.c.close();
            this.h = true;
        } catch (Exception unused) {
        }
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
    }

    public final void d() {
        int i;
        HeaderSet headerSet = new HeaderSet();
        HeaderSet headerSet2 = new HeaderSet();
        int read = (this.d.read() << 8) + this.d.read();
        if (read > 65534) {
            i = MlKitException.CODE_SCANNER_PIPELINE_INFERENCE_ERROR;
        } else {
            for (int i2 = 3; i2 < read; i2++) {
                this.d.read();
            }
            int b = this.f.b(headerSet, headerSet2);
            Log.v("Obex ServerSession", "onAbort request handler return value- " + b);
            i = k(b);
        }
        j(i, (byte[]) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x0122  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e() {
        /*
            r14 = this;
            javax.obex.HeaderSet r0 = new javax.obex.HeaderSet
            r0.<init>()
            javax.obex.HeaderSet r1 = new javax.obex.HeaderSet
            r1.<init>()
            java.io.InputStream r2 = r14.d
            int r2 = r2.read()
            int r2 = r2 << 8
            java.io.InputStream r3 = r14.d
            int r3 = r3.read()
            int r2 = r2 + r3
            java.io.InputStream r3 = r14.d
            r3.read()
            java.io.InputStream r3 = r14.d
            r3.read()
            java.io.InputStream r3 = r14.d
            int r3 = r3.read()
            r14.g = r3
            int r3 = r3 << 8
            java.io.InputStream r4 = r14.d
            int r4 = r4.read()
            int r3 = r3 + r4
            r14.g = r3
            r4 = 65534(0xfffe, float:9.1833E-41)
            if (r3 <= r4) goto L_0x003d
            r14.g = r4
        L_0x003d:
            r3 = 1
            r5 = 16
            r6 = 0
            r7 = 7
            r8 = 0
            r9 = -1
            if (r2 <= r4) goto L_0x004b
            r0 = 206(0xce, float:2.89E-43)
        L_0x0048:
            r4 = r7
            goto L_0x0100
        L_0x004b:
            if (r2 <= r7) goto L_0x0065
            int r2 = r2 - r7
            byte[] r4 = new byte[r2]
            java.io.InputStream r10 = r14.d
            int r10 = r10.read(r4)
        L_0x0056:
            if (r10 == r2) goto L_0x0062
            java.io.InputStream r11 = r14.d
            int r12 = r2 - r10
            int r11 = r11.read(r4, r10, r12)
            int r10 = r10 + r11
            goto L_0x0056
        L_0x0062:
            javax.obex.ObexHelper.j(r0, r4)
        L_0x0065:
            javax.obex.ServerRequestHandler r2 = r14.f
            long r10 = r2.a()
            r12 = -1
            int r2 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r2 == 0) goto L_0x007f
            byte[] r2 = r0.v
            if (r2 == 0) goto L_0x007f
            javax.obex.ServerRequestHandler r4 = r14.f
            long r10 = javax.obex.ObexHelper.c(r2)
            r4.k(r10)
            goto L_0x0086
        L_0x007f:
            javax.obex.ServerRequestHandler r2 = r14.f
            r10 = 1
            r2.k(r10)
        L_0x0086:
            byte[] r2 = r0.u
            r4 = 193(0xc1, float:2.7E-43)
            if (r2 == 0) goto L_0x00a3
            boolean r2 = r14.b(r2)
            if (r2 != 0) goto L_0x009f
            javax.obex.ServerRequestHandler r2 = r14.f
            byte[] r10 = r0.u
            byte[] r10 = javax.obex.ObexHelper.i(r3, r10)
            r2.c(r10)
            r2 = r4
            goto L_0x00a0
        L_0x009f:
            r2 = r9
        L_0x00a0:
            r0.u = r8
            goto L_0x00a4
        L_0x00a3:
            r2 = r9
        L_0x00a4:
            if (r2 == r4) goto L_0x00fd
            byte[] r2 = r0.t
            if (r2 == 0) goto L_0x00be
            r14.a(r0)
            byte[] r2 = r0.u
            int r2 = r2.length
            byte[] r2 = new byte[r2]
            r1.u = r2
            byte[] r4 = r0.u
            int r10 = r2.length
            java.lang.System.arraycopy(r4, r6, r2, r6, r10)
            r0.t = r8
            r0.u = r8
        L_0x00be:
            r2 = 208(0xd0, float:2.91E-43)
            javax.obex.ServerRequestHandler r4 = r14.f     // Catch:{ Exception -> 0x00d6 }
            int r0 = r4.e(r0, r1)     // Catch:{ Exception -> 0x00d6 }
            int r0 = r14.k(r0)     // Catch:{ Exception -> 0x00d6 }
            byte[] r4 = r1.s     // Catch:{ Exception -> 0x00d6 }
            if (r4 == 0) goto L_0x00d8
            byte[] r10 = new byte[r5]     // Catch:{ Exception -> 0x00d6 }
            r14.b = r10     // Catch:{ Exception -> 0x00d6 }
            java.lang.System.arraycopy(r4, r6, r10, r6, r5)     // Catch:{ Exception -> 0x00d6 }
            goto L_0x00da
        L_0x00d6:
            r0 = move-exception
            goto L_0x00fa
        L_0x00d8:
            r14.b = r8     // Catch:{ Exception -> 0x00d6 }
        L_0x00da:
            javax.obex.ServerRequestHandler r4 = r14.f     // Catch:{ Exception -> 0x00d6 }
            long r10 = r4.a()     // Catch:{ Exception -> 0x00d6 }
            int r4 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r4 != 0) goto L_0x00e7
            r1.v = r8     // Catch:{ Exception -> 0x00d6 }
            goto L_0x00ed
        L_0x00e7:
            byte[] r4 = javax.obex.ObexHelper.b(r10)     // Catch:{ Exception -> 0x00d6 }
            r1.v = r4     // Catch:{ Exception -> 0x00d6 }
        L_0x00ed:
            byte[] r1 = javax.obex.ObexHelper.f(r1, r6)     // Catch:{ Exception -> 0x00d6 }
            int r4 = r1.length     // Catch:{ Exception -> 0x00d6 }
            int r4 = r4 + r7
            int r10 = r14.g     // Catch:{ Exception -> 0x00d6 }
            if (r4 <= r10) goto L_0x00f8
            goto L_0x00fd
        L_0x00f8:
            r8 = r1
            goto L_0x0100
        L_0x00fa:
            r0.printStackTrace()
        L_0x00fd:
            r0 = r2
            goto L_0x0048
        L_0x0100:
            long r1 = (long) r4
            byte[] r1 = javax.obex.ObexHelper.b(r1)
            byte[] r2 = new byte[r4]
            byte r0 = (byte) r0
            r2[r6] = r0
            r0 = 2
            byte r4 = r1[r0]
            r2[r3] = r4
            r3 = 3
            byte r1 = r1[r3]
            r2[r0] = r1
            r2[r3] = r5
            r0 = 4
            r2[r0] = r6
            r0 = 5
            r2[r0] = r9
            r0 = 6
            r1 = -2
            r2[r0] = r1
            if (r8 == 0) goto L_0x0126
            int r0 = r8.length
            java.lang.System.arraycopy(r8, r6, r2, r7, r0)
        L_0x0126:
            java.io.OutputStream r0 = r14.e
            r0.write(r2)
            java.io.OutputStream r14 = r14.e
            r14.flush()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.obex.ServerSession.e():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f() {
        /*
            r13 = this;
            javax.obex.HeaderSet r0 = new javax.obex.HeaderSet
            r0.<init>()
            javax.obex.HeaderSet r1 = new javax.obex.HeaderSet
            r1.<init>()
            java.io.InputStream r2 = r13.d
            int r2 = r2.read()
            int r2 = r2 << 8
            java.io.InputStream r3 = r13.d
            int r3 = r3.read()
            int r2 = r2 + r3
            r3 = 65534(0xfffe, float:9.1833E-41)
            r4 = 1
            r5 = 0
            r6 = 3
            r7 = 0
            if (r2 <= r3) goto L_0x0027
            r0 = 206(0xce, float:2.89E-43)
        L_0x0024:
            r1 = r6
            goto L_0x00b9
        L_0x0027:
            if (r2 <= r6) goto L_0x0041
            int r2 = r2 - r6
            byte[] r3 = new byte[r2]
            java.io.InputStream r8 = r13.d
            int r8 = r8.read(r3)
        L_0x0032:
            if (r8 == r2) goto L_0x003e
            java.io.InputStream r9 = r13.d
            int r10 = r2 - r8
            int r9 = r9.read(r3, r8, r10)
            int r8 = r8 + r9
            goto L_0x0032
        L_0x003e:
            javax.obex.ObexHelper.j(r0, r3)
        L_0x0041:
            javax.obex.ServerRequestHandler r2 = r13.f
            long r2 = r2.a()
            r8 = -1
            int r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r2 == 0) goto L_0x005b
            byte[] r2 = r0.v
            if (r2 == 0) goto L_0x005b
            javax.obex.ServerRequestHandler r3 = r13.f
            long r10 = javax.obex.ObexHelper.c(r2)
            r3.k(r10)
            goto L_0x0062
        L_0x005b:
            javax.obex.ServerRequestHandler r2 = r13.f
            r10 = 1
            r2.k(r10)
        L_0x0062:
            byte[] r2 = r0.u
            r3 = 193(0xc1, float:2.7E-43)
            r10 = 160(0xa0, float:2.24E-43)
            if (r2 == 0) goto L_0x007e
            boolean r2 = r13.b(r2)
            if (r2 != 0) goto L_0x007c
            javax.obex.ServerRequestHandler r2 = r13.f
            byte[] r10 = r0.u
            byte[] r10 = javax.obex.ObexHelper.i(r4, r10)
            r2.c(r10)
            r10 = r3
        L_0x007c:
            r0.u = r7
        L_0x007e:
            if (r10 == r3) goto L_0x00b7
            byte[] r2 = r0.t
            if (r2 == 0) goto L_0x0089
            r13.a(r0)
            r0.t = r7
        L_0x0089:
            r2 = 208(0xd0, float:2.91E-43)
            javax.obex.ServerRequestHandler r3 = r13.f     // Catch:{ Exception -> 0x00b3 }
            r3.g(r0, r1)     // Catch:{ Exception -> 0x00b3 }
            javax.obex.ServerRequestHandler r0 = r13.f
            long r11 = r0.a()
            int r0 = (r11 > r8 ? 1 : (r11 == r8 ? 0 : -1))
            if (r0 != 0) goto L_0x009d
            r1.v = r7
            goto L_0x00a3
        L_0x009d:
            byte[] r0 = javax.obex.ObexHelper.b(r11)
            r1.v = r0
        L_0x00a3:
            byte[] r0 = javax.obex.ObexHelper.f(r1, r5)
            int r1 = r0.length
            int r1 = r1 + r6
            int r3 = r13.g
            if (r1 <= r3) goto L_0x00b0
            r0 = r2
            goto L_0x0024
        L_0x00b0:
            r7 = r0
        L_0x00b1:
            r0 = r10
            goto L_0x00b9
        L_0x00b3:
            r13.j(r2, r7)
            return
        L_0x00b7:
            r1 = r6
            goto L_0x00b1
        L_0x00b9:
            if (r7 == 0) goto L_0x00c0
            int r2 = r7.length
            int r2 = r2 + r6
            byte[] r2 = new byte[r2]
            goto L_0x00c2
        L_0x00c0:
            byte[] r2 = new byte[r6]
        L_0x00c2:
            byte r0 = (byte) r0
            r2[r5] = r0
            int r0 = r1 >> 8
            byte r0 = (byte) r0
            r2[r4] = r0
            r0 = 2
            byte r1 = (byte) r1
            r2[r0] = r1
            if (r7 == 0) goto L_0x00d4
            int r0 = r7.length
            java.lang.System.arraycopy(r7, r5, r2, r6, r0)
        L_0x00d4:
            java.io.OutputStream r0 = r13.e
            r0.write(r2)
            java.io.OutputStream r13 = r13.e
            r13.flush()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.obex.ServerSession.f():void");
    }

    public final void g(int i) {
        ServerOperation serverOperation = new ServerOperation(this, this.d, i, this.g, this.f);
        try {
            int k = k(this.f.h(serverOperation));
            if (!serverOperation.f3695a) {
                serverOperation.f(k);
            }
        } catch (Exception unused) {
            j(AdvPackConstants.ADV_MODE_REQUEST_CONNECT, (byte[]) null);
        }
    }

    public final void h(int i) {
        ServerOperation serverOperation = new ServerOperation(this, this.d, i, this.g, this.f);
        try {
            int k = (!serverOperation.d || serverOperation.e()) ? k(this.f.i(serverOperation)) : k(this.f.f(serverOperation.b, serverOperation.c));
            if (k != 160 && !serverOperation.f3695a) {
                serverOperation.f(k);
            } else if (!serverOperation.f3695a) {
                while (!serverOperation.d) {
                    serverOperation.f(AdvPackConstants.ADV_MODE_ACTIVE_NO_WINDOW);
                }
                serverOperation.f(k);
            }
        } catch (Exception unused) {
            if (!serverOperation.f3695a) {
                j(AdvPackConstants.ADV_MODE_REQUEST_CONNECT, (byte[]) null);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x010b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void i() {
        /*
            r16 = this;
            r0 = r16
            javax.obex.HeaderSet r1 = new javax.obex.HeaderSet
            r1.<init>()
            javax.obex.HeaderSet r2 = new javax.obex.HeaderSet
            r2.<init>()
            java.io.InputStream r3 = r0.d
            int r3 = r3.read()
            int r3 = r3 << 8
            java.io.InputStream r4 = r0.d
            int r4 = r4.read()
            int r3 = r3 + r4
            java.io.InputStream r4 = r0.d
            int r4 = r4.read()
            java.io.InputStream r5 = r0.d
            r5.read()
            r5 = 65534(0xfffe, float:9.1833E-41)
            r6 = 2
            r7 = 1
            r8 = 0
            r10 = 0
            if (r3 <= r5) goto L_0x0034
            r1 = 206(0xce, float:2.89E-43)
        L_0x0031:
            r4 = 3
            goto L_0x00fc
        L_0x0034:
            r5 = 193(0xc1, float:2.7E-43)
            r11 = -1
            r13 = 5
            if (r3 <= r13) goto L_0x008d
            int r3 = r3 - r13
            byte[] r13 = new byte[r3]
            java.io.InputStream r15 = r0.d
            int r15 = r15.read(r13)
        L_0x0044:
            if (r15 == r3) goto L_0x0050
            java.io.InputStream r14 = r0.d
            int r9 = r3 - r15
            int r9 = r14.read(r13, r15, r9)
            int r15 = r15 + r9
            goto L_0x0044
        L_0x0050:
            javax.obex.ObexHelper.j(r1, r13)
            javax.obex.ServerRequestHandler r3 = r0.f
            long r13 = r3.a()
            int r3 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r3 == 0) goto L_0x006b
            byte[] r3 = r1.v
            if (r3 == 0) goto L_0x006b
            javax.obex.ServerRequestHandler r9 = r0.f
            long r13 = javax.obex.ObexHelper.c(r3)
            r9.k(r13)
            goto L_0x0072
        L_0x006b:
            javax.obex.ServerRequestHandler r3 = r0.f
            r13 = 1
            r3.k(r13)
        L_0x0072:
            byte[] r3 = r1.u
            if (r3 == 0) goto L_0x008d
            boolean r3 = r0.b(r3)
            if (r3 != 0) goto L_0x0089
            javax.obex.ServerRequestHandler r3 = r0.f
            byte[] r9 = r1.u
            byte[] r9 = javax.obex.ObexHelper.i(r7, r9)
            r3.c(r9)
            r14 = r5
            goto L_0x008a
        L_0x0089:
            r14 = -1
        L_0x008a:
            r1.u = r10
            goto L_0x008e
        L_0x008d:
            r14 = -1
        L_0x008e:
            if (r14 == r5) goto L_0x00f9
            byte[] r3 = r1.t
            if (r3 == 0) goto L_0x00a8
            r0.a(r1)
            byte[] r3 = r1.u
            int r3 = r3.length
            byte[] r3 = new byte[r3]
            r2.u = r3
            byte[] r5 = r1.u
            int r9 = r3.length
            java.lang.System.arraycopy(r5, r8, r3, r8, r9)
            r1.t = r10
            r1.u = r10
        L_0x00a8:
            r3 = r4 & 1
            if (r3 == 0) goto L_0x00ae
            r3 = r7
            goto L_0x00af
        L_0x00ae:
            r3 = r8
        L_0x00af:
            r4 = r4 & r6
            if (r4 == 0) goto L_0x00b4
            r4 = r8
            goto L_0x00b5
        L_0x00b4:
            r4 = r7
        L_0x00b5:
            r5 = 208(0xd0, float:2.91E-43)
            javax.obex.ServerRequestHandler r9 = r0.f     // Catch:{ Exception -> 0x00f5 }
            int r1 = r9.j(r1, r2, r3, r4)     // Catch:{ Exception -> 0x00f5 }
            int r1 = r0.k(r1)
            byte[] r3 = r2.s
            if (r3 == 0) goto L_0x00cf
            r4 = 16
            byte[] r9 = new byte[r4]
            r0.b = r9
            java.lang.System.arraycopy(r3, r8, r9, r8, r4)
            goto L_0x00d1
        L_0x00cf:
            r0.b = r10
        L_0x00d1:
            javax.obex.ServerRequestHandler r3 = r0.f
            long r3 = r3.a()
            int r9 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r9 != 0) goto L_0x00de
            r2.v = r10
            goto L_0x00e4
        L_0x00de:
            byte[] r3 = javax.obex.ObexHelper.b(r3)
            r2.v = r3
        L_0x00e4:
            byte[] r2 = javax.obex.ObexHelper.f(r2, r8)
            int r3 = r2.length
            r4 = 3
            int r3 = r3 + r4
            int r4 = r0.g
            if (r3 <= r4) goto L_0x00f2
            r1 = r5
            goto L_0x0031
        L_0x00f2:
            r10 = r2
            r4 = r3
            goto L_0x00fc
        L_0x00f5:
            r0.j(r5, r10)
            return
        L_0x00f9:
            r1 = r14
            goto L_0x0031
        L_0x00fc:
            byte[] r2 = new byte[r4]
            byte r1 = (byte) r1
            r2[r8] = r1
            int r1 = r4 >> 8
            byte r1 = (byte) r1
            r2[r7] = r1
            byte r1 = (byte) r4
            r2[r6] = r1
            if (r10 == 0) goto L_0x0110
            int r1 = r10.length
            r3 = 3
            java.lang.System.arraycopy(r10, r8, r2, r3, r1)
        L_0x0110:
            java.io.OutputStream r1 = r0.e
            r1.write(r2)
            java.io.OutputStream r0 = r0.e
            r0.flush()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.obex.ServerSession.i():void");
    }

    public void j(int i, byte[] bArr) {
        byte[] bArr2;
        OutputStream outputStream = this.e;
        if (outputStream != null) {
            if (bArr != null) {
                int length = bArr.length + 3;
                bArr2 = new byte[length];
                bArr2[0] = (byte) i;
                bArr2[1] = (byte) (length >> 8);
                bArr2[2] = (byte) length;
                System.arraycopy(bArr, 0, bArr2, 3, bArr.length);
            } else {
                bArr2 = new byte[]{(byte) i, 0, (byte) 3};
            }
            outputStream.write(bArr2);
            outputStream.flush();
        }
    }

    public final int k(int i) {
        return (i < 160 || i > 166) ? (i < 176 || i > 181) ? (i < 192 || i > 207) ? (i < 208 || i > 213) ? (i < 224 || i > 225) ? AdvPackConstants.ADV_MODE_REQUEST_CONNECT : i : i : i : i : i;
    }

    public void run() {
        boolean z = false;
        while (!z) {
            try {
                if (!this.h) {
                    int read = this.d.read();
                    if (read != -1) {
                        if (read == 133) {
                            i();
                        } else if (read != 255) {
                            if (read != 2) {
                                if (read != 3) {
                                    switch (read) {
                                        case 128:
                                            e();
                                            break;
                                        case 129:
                                            f();
                                            break;
                                        case 130:
                                            break;
                                        case TrackerEvent.PositioningOfflineOutdoor /*131*/:
                                            break;
                                        default:
                                            int read2 = (this.d.read() << 8) + this.d.read();
                                            for (int i = 3; i < read2; i++) {
                                                this.d.read();
                                            }
                                            j(209, (byte[]) null);
                                            break;
                                    }
                                }
                                g(read);
                            }
                            h(read);
                        } else {
                            d();
                        }
                    }
                    z = true;
                } else {
                    c();
                }
            } catch (NullPointerException e2) {
                Log.d("Obex ServerSession", e2.toString());
            } catch (Exception e3) {
                Log.d("Obex ServerSession", e3.toString());
            }
        }
        c();
    }
}
