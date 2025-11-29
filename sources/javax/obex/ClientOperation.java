package javax.obex;

import com.here.posclient.analytics.TrackerEvent;
import com.upuphone.starrynet.strategy.discovery.advertiser.pack.AdvPackConstants;
import java.io.IOException;
import java.io.InputStream;

public final class ClientOperation implements Operation, BaseStream {

    /* renamed from: a  reason: collision with root package name */
    public ClientSession f3689a;
    public boolean b = true;
    public PrivateInputStream c;
    public boolean d;
    public PrivateOutputStream e;
    public boolean f;
    public String g;
    public int h;
    public boolean i = false;
    public boolean j;
    public boolean k;
    public HeaderSet l;
    public HeaderSet m;
    public boolean n = false;

    public ClientOperation(int i2, ClientSession clientSession, HeaderSet headerSet, boolean z) {
        this.f3689a = clientSession;
        this.h = i2;
        this.j = z;
        this.k = false;
        this.d = false;
        this.f = false;
        this.c = null;
        this.e = null;
        this.m = new HeaderSet();
        this.l = new HeaderSet();
        int[] c2 = headerSet.c();
        if (c2 != null) {
            for (int i3 : c2) {
                this.l.e(i3, headerSet.b(i3));
            }
        }
        byte[] bArr = headerSet.t;
        if (bArr != null) {
            HeaderSet headerSet2 = this.l;
            byte[] bArr2 = new byte[bArr.length];
            headerSet2.t = bArr2;
            byte[] bArr3 = headerSet.t;
            System.arraycopy(bArr3, 0, bArr2, 0, bArr3.length);
        }
        byte[] bArr4 = headerSet.u;
        if (bArr4 != null) {
            HeaderSet headerSet3 = this.l;
            byte[] bArr5 = new byte[bArr4.length];
            headerSet3.u = bArr5;
            byte[] bArr6 = headerSet.u;
            System.arraycopy(bArr6, 0, bArr5, 0, bArr6.length);
        }
        if (headerSet.v != null) {
            byte[] bArr7 = new byte[4];
            this.l.v = bArr7;
            System.arraycopy(headerSet.v, 0, bArr7, 0, 4);
        }
    }

    public void a() {
        this.f3689a.f();
        if (this.g != null) {
            throw new IOException(this.g);
        } else if (!this.b) {
            throw new IOException("Operation has already ended");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004e, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0079, code lost:
        return false;
     */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:50:0x0072=Splitter:B:50:0x0072, B:29:0x004f=Splitter:B:29:0x004f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean b(boolean r6, boolean r7) {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r6 = r5.j     // Catch:{ all -> 0x0024 }
            r0 = 144(0x90, float:2.02E-43)
            r1 = 0
            r2 = 1
            if (r6 == 0) goto L_0x0055
            r6 = 131(0x83, float:1.84E-43)
            if (r7 == 0) goto L_0x0028
            boolean r3 = r5.i     // Catch:{ all -> 0x0024 }
            if (r3 != 0) goto L_0x0028
            javax.obex.ClientSession r7 = r5.f3689a     // Catch:{ all -> 0x0024 }
            javax.obex.HeaderSet r1 = r5.m     // Catch:{ all -> 0x0024 }
            javax.obex.PrivateInputStream r3 = r5.c     // Catch:{ all -> 0x0024 }
            r4 = 0
            r7.h(r6, r4, r1, r3)     // Catch:{ all -> 0x0024 }
            javax.obex.HeaderSet r6 = r5.m     // Catch:{ all -> 0x0024 }
            int r6 = r6.w     // Catch:{ all -> 0x0024 }
            if (r6 == r0) goto L_0x0026
            r5.i = r2     // Catch:{ all -> 0x0024 }
            goto L_0x0026
        L_0x0024:
            r6 = move-exception
            goto L_0x007a
        L_0x0026:
            monitor-exit(r5)
            return r2
        L_0x0028:
            if (r7 != 0) goto L_0x004f
            boolean r7 = r5.i     // Catch:{ all -> 0x0024 }
            if (r7 != 0) goto L_0x004f
            javax.obex.PrivateInputStream r7 = r5.c     // Catch:{ all -> 0x0024 }
            if (r7 != 0) goto L_0x0039
            javax.obex.PrivateInputStream r7 = new javax.obex.PrivateInputStream     // Catch:{ all -> 0x0024 }
            r7.<init>(r5)     // Catch:{ all -> 0x0024 }
            r5.c = r7     // Catch:{ all -> 0x0024 }
        L_0x0039:
            boolean r7 = r5.k     // Catch:{ all -> 0x0024 }
            if (r7 != 0) goto L_0x0042
            r6 = 3
            r5.j(r6)     // Catch:{ all -> 0x0024 }
            goto L_0x004d
        L_0x0042:
            r5.j(r6)     // Catch:{ all -> 0x0024 }
            javax.obex.HeaderSet r6 = r5.m     // Catch:{ all -> 0x0024 }
            int r6 = r6.w     // Catch:{ all -> 0x0024 }
            if (r6 == r0) goto L_0x004d
            r5.i = r2     // Catch:{ all -> 0x0024 }
        L_0x004d:
            monitor-exit(r5)
            return r2
        L_0x004f:
            boolean r6 = r5.i     // Catch:{ all -> 0x0024 }
            if (r6 == 0) goto L_0x0078
            monitor-exit(r5)
            return r1
        L_0x0055:
            if (r7 != 0) goto L_0x006a
            boolean r6 = r5.i     // Catch:{ all -> 0x0024 }
            if (r6 != 0) goto L_0x006a
            javax.obex.HeaderSet r6 = r5.m     // Catch:{ all -> 0x0024 }
            int r7 = r6.w     // Catch:{ all -> 0x0024 }
            r1 = -1
            if (r7 != r1) goto L_0x0064
            r6.w = r0     // Catch:{ all -> 0x0024 }
        L_0x0064:
            r6 = 2
            r5.j(r6)     // Catch:{ all -> 0x0024 }
            monitor-exit(r5)
            return r2
        L_0x006a:
            if (r7 == 0) goto L_0x0072
            boolean r6 = r5.i     // Catch:{ all -> 0x0024 }
            if (r6 != 0) goto L_0x0072
            monitor-exit(r5)
            return r1
        L_0x0072:
            boolean r6 = r5.i     // Catch:{ all -> 0x0024 }
            if (r6 == 0) goto L_0x0078
            monitor-exit(r5)
            return r1
        L_0x0078:
            monitor-exit(r5)
            return r1
        L_0x007a:
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.obex.ClientOperation.b(boolean, boolean):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0064 A[LOOP:2: B:34:0x0064->B:37:0x006e, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(boolean r7) {
        /*
            r6 = this;
            boolean r0 = r6.j
            r1 = -1
            r2 = 0
            r3 = 1
            r4 = 144(0x90, float:2.02E-43)
            if (r0 != 0) goto L_0x0054
            if (r7 != 0) goto L_0x004a
            boolean r0 = r6.i
            if (r0 != 0) goto L_0x004a
            javax.obex.PrivateOutputStream r7 = r6.e
            if (r7 == 0) goto L_0x0023
            int r7 = r7.c()
            if (r7 > 0) goto L_0x0023
            javax.obex.HeaderSet r7 = r6.l
            byte[] r7 = javax.obex.ObexHelper.f(r7, r2)
            int r7 = r7.length
            if (r7 > 0) goto L_0x0023
            goto L_0x0024
        L_0x0023:
            r2 = r3
        L_0x0024:
            javax.obex.HeaderSet r7 = r6.m
            int r0 = r7.w
            if (r0 != r1) goto L_0x002c
            r7.w = r4
        L_0x002c:
            if (r2 == 0) goto L_0x003a
            javax.obex.HeaderSet r7 = r6.m
            int r7 = r7.w
            if (r7 != r4) goto L_0x003a
            r7 = 2
            boolean r2 = r6.j(r7)
            goto L_0x002c
        L_0x003a:
            javax.obex.HeaderSet r7 = r6.m
            int r7 = r7.w
            if (r7 != r4) goto L_0x0046
            r7 = 130(0x82, float:1.82E-43)
            r6.j(r7)
            goto L_0x003a
        L_0x0046:
            r6.i = r3
            goto L_0x00d2
        L_0x004a:
            if (r7 == 0) goto L_0x00d2
            boolean r7 = r6.i
            if (r7 == 0) goto L_0x00d2
            r6.i = r3
            goto L_0x00d2
        L_0x0054:
            r0 = 131(0x83, float:1.84E-43)
            if (r7 == 0) goto L_0x0082
            boolean r5 = r6.i
            if (r5 != 0) goto L_0x0082
            javax.obex.HeaderSet r7 = r6.m
            int r2 = r7.w
            if (r2 != r1) goto L_0x0064
            r7.w = r4
        L_0x0064:
            javax.obex.HeaderSet r7 = r6.m
            int r7 = r7.w
            if (r7 != r4) goto L_0x0070
            boolean r7 = r6.j(r0)
            if (r7 != 0) goto L_0x0064
        L_0x0070:
            javax.obex.HeaderSet r7 = r6.m
            int r1 = r7.w
            if (r1 != r4) goto L_0x007f
            javax.obex.ClientSession r1 = r6.f3689a
            r2 = 0
            javax.obex.PrivateInputStream r5 = r6.c
            r1.h(r0, r2, r7, r5)
            goto L_0x0070
        L_0x007f:
            r6.i = r3
            goto L_0x00d2
        L_0x0082:
            if (r7 != 0) goto L_0x00d2
            boolean r7 = r6.i
            if (r7 != 0) goto L_0x00d2
            javax.obex.PrivateOutputStream r7 = r6.e
            if (r7 == 0) goto L_0x009d
            int r7 = r7.c()
            if (r7 > 0) goto L_0x009d
            javax.obex.HeaderSet r7 = r6.l
            byte[] r7 = javax.obex.ObexHelper.f(r7, r2)
            int r7 = r7.length
            if (r7 > 0) goto L_0x009d
            r7 = r2
            goto L_0x009e
        L_0x009d:
            r7 = r3
        L_0x009e:
            javax.obex.PrivateInputStream r1 = r6.c
            if (r1 != 0) goto L_0x00a9
            javax.obex.PrivateInputStream r1 = new javax.obex.PrivateInputStream
            r1.<init>(r6)
            r6.c = r1
        L_0x00a9:
            javax.obex.PrivateOutputStream r1 = r6.e
            if (r1 == 0) goto L_0x00b4
            int r1 = r1.c()
            if (r1 > 0) goto L_0x00b4
            goto L_0x00b5
        L_0x00b4:
            r2 = r7
        L_0x00b5:
            javax.obex.HeaderSet r7 = r6.m
            r7.w = r4
        L_0x00b9:
            if (r2 == 0) goto L_0x00c7
            javax.obex.HeaderSet r7 = r6.m
            int r7 = r7.w
            if (r7 != r4) goto L_0x00c7
            r7 = 3
            boolean r2 = r6.j(r7)
            goto L_0x00b9
        L_0x00c7:
            r6.j(r0)
            javax.obex.HeaderSet r7 = r6.m
            int r7 = r7.w
            if (r7 == r4) goto L_0x00d2
            r6.i = r3
        L_0x00d2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.obex.ClientOperation.c(boolean):void");
    }

    public void d() {
        if (this.i) {
            throw new IOException("Operation has completed");
        }
    }

    public synchronized void e() {
        try {
            a();
            boolean z = this.i;
            if (z) {
                if (this.m.w != 144) {
                    throw new IOException("Operation has already ended");
                }
            }
            this.g = "Operation aborted";
            if (!z) {
                HeaderSet headerSet = this.m;
                if (headerSet.w == 144) {
                    this.i = true;
                    this.f3689a.h(255, (byte[]) null, headerSet, (PrivateInputStream) null);
                    if (this.m.w == 160) {
                        this.g = null;
                    } else {
                        throw new IOException("Invalid response code from server");
                    }
                }
            }
            f();
        } catch (Throwable th) {
            throw th;
        }
    }

    public void f() {
        this.b = false;
        this.d = false;
        this.f = false;
        this.f3689a.l();
    }

    public HeaderSet g() {
        a();
        return this.m;
    }

    public synchronized int h() {
        int i2 = this.m.w;
        if (i2 == -1 || i2 == 144) {
            m();
        }
        return this.m.w;
    }

    public InputStream i() {
        a();
        if (!this.d) {
            if (this.j) {
                m();
            } else if (this.c == null) {
                this.c = new PrivateInputStream(this);
            }
            this.d = true;
            return this.c;
        }
        throw new IOException("no more input streams available");
    }

    /* JADX WARNING: Removed duplicated region for block: B:73:0x006b A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean j(int r12) {
        /*
            r11 = this;
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            javax.obex.HeaderSet r1 = r11.l
            r2 = 1
            byte[] r1 = javax.obex.ObexHelper.f(r1, r2)
            javax.obex.PrivateOutputStream r3 = r11.e
            r4 = -1
            if (r3 == 0) goto L_0x0016
            int r3 = r3.c()
            goto L_0x0017
        L_0x0016:
            r3 = r4
        L_0x0017:
            int r5 = r1.length
            r6 = 3
            int r5 = r5 + r6
            int r7 = r11.h
            r8 = 0
            if (r5 <= r7) goto L_0x006f
            r0 = r8
        L_0x0020:
            r5 = r0
            int r7 = r1.length
            if (r0 == r7) goto L_0x006b
            int r0 = r11.h
            int r0 = r0 - r6
            int r0 = javax.obex.ObexHelper.g(r1, r5, r0)
            if (r0 != r4) goto L_0x004e
            r11.i = r2
            r11.e()
            java.lang.String r12 = "Header larger then can be sent in a packet"
            r11.g = r12
            r11.b = r8
            javax.obex.PrivateInputStream r12 = r11.c
            if (r12 == 0) goto L_0x003f
            r12.close()
        L_0x003f:
            javax.obex.PrivateOutputStream r11 = r11.e
            if (r11 == 0) goto L_0x0046
            r11.close()
        L_0x0046:
            java.io.IOException r11 = new java.io.IOException
            java.lang.String r12 = "OBEX Packet exceeds max packet size"
            r11.<init>(r12)
            throw r11
        L_0x004e:
            int r7 = r0 - r5
            byte[] r9 = new byte[r7]
            java.lang.System.arraycopy(r1, r5, r9, r8, r7)
            javax.obex.ClientSession r5 = r11.f3689a
            javax.obex.HeaderSet r7 = r11.m
            javax.obex.PrivateInputStream r10 = r11.c
            boolean r5 = r5.h(r12, r9, r7, r10)
            if (r5 != 0) goto L_0x0062
            return r8
        L_0x0062:
            javax.obex.HeaderSet r5 = r11.m
            int r5 = r5.w
            r7 = 144(0x90, float:2.02E-43)
            if (r5 == r7) goto L_0x0020
            return r8
        L_0x006b:
            if (r3 <= 0) goto L_0x006e
            return r2
        L_0x006e:
            return r8
        L_0x006f:
            r0.write(r1)
            r4 = 72
            r5 = 73
            if (r3 <= 0) goto L_0x00ba
            int r7 = r11.h
            int r9 = r1.length
            int r9 = r7 - r9
            int r9 = r9 + -6
            if (r3 <= r9) goto L_0x0087
            int r1 = r1.length
            int r7 = r7 - r1
            int r3 = r7 + -6
            r1 = r2
            goto L_0x0088
        L_0x0087:
            r1 = r8
        L_0x0088:
            javax.obex.PrivateOutputStream r7 = r11.e
            byte[] r7 = r7.b(r3)
            javax.obex.PrivateOutputStream r9 = r11.e
            boolean r9 = r9.isClosed()
            if (r9 == 0) goto L_0x00a6
            if (r1 != 0) goto L_0x00a6
            boolean r9 = r11.n
            if (r9 != 0) goto L_0x00a6
            r9 = r12 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x00a6
            r0.write(r5)
            r11.n = r2
            goto L_0x00a9
        L_0x00a6:
            r0.write(r4)
        L_0x00a9:
            int r3 = r3 + r6
            int r9 = r3 >> 8
            byte r9 = (byte) r9
            r0.write(r9)
            byte r9 = (byte) r3
            r0.write(r9)
            if (r7 == 0) goto L_0x00bb
            r0.write(r7)
            goto L_0x00bb
        L_0x00ba:
            r1 = r8
        L_0x00bb:
            boolean r7 = r11.f
            if (r7 == 0) goto L_0x00da
            if (r3 > 0) goto L_0x00da
            boolean r3 = r11.n
            if (r3 != 0) goto L_0x00da
            r3 = r12 & 128(0x80, float:1.794E-43)
            if (r3 != 0) goto L_0x00cd
            r0.write(r4)
            goto L_0x00d2
        L_0x00cd:
            r0.write(r5)
            r11.n = r2
        L_0x00d2:
            byte r3 = (byte) r8
            r0.write(r3)
            byte r3 = (byte) r6
            r0.write(r3)
        L_0x00da:
            int r3 = r0.size()
            if (r3 != 0) goto L_0x00ef
            javax.obex.ClientSession r0 = r11.f3689a
            javax.obex.HeaderSet r2 = r11.m
            javax.obex.PrivateInputStream r11 = r11.c
            r3 = 0
            boolean r11 = r0.h(r12, r3, r2, r11)
            if (r11 != 0) goto L_0x00ee
            return r8
        L_0x00ee:
            return r1
        L_0x00ef:
            int r3 = r0.size()
            if (r3 <= 0) goto L_0x0106
            javax.obex.ClientSession r3 = r11.f3689a
            byte[] r0 = r0.toByteArray()
            javax.obex.HeaderSet r4 = r11.m
            javax.obex.PrivateInputStream r5 = r11.c
            boolean r12 = r3.h(r12, r0, r4, r5)
            if (r12 != 0) goto L_0x0106
            return r8
        L_0x0106:
            javax.obex.PrivateOutputStream r11 = r11.e
            if (r11 == 0) goto L_0x0111
            int r11 = r11.c()
            if (r11 <= 0) goto L_0x0111
            goto L_0x0112
        L_0x0111:
            r2 = r1
        L_0x0112:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.obex.ClientOperation.j(int):boolean");
    }

    public void k(boolean z) {
        this.k = z;
    }

    public final synchronized void l() {
        try {
            if (this.c == null) {
                this.c = new PrivateInputStream(this);
            }
            if (!this.j) {
                if (!this.i) {
                    this.m.w = AdvPackConstants.ADV_MODE_ACTIVE_NO_WINDOW;
                    boolean z = true;
                    while (z && this.m.w == 144) {
                        z = j(2);
                    }
                }
                HeaderSet headerSet = this.m;
                if (headerSet.w == 144) {
                    this.f3689a.h(130, (byte[]) null, headerSet, this.c);
                }
                if (this.m.w != 144) {
                    this.i = true;
                }
            } else if (!this.i) {
                if (!this.k) {
                    this.m.w = AdvPackConstants.ADV_MODE_ACTIVE_NO_WINDOW;
                    boolean z2 = true;
                    while (z2 && this.m.w == 144) {
                        z2 = j(3);
                    }
                    HeaderSet headerSet2 = this.m;
                    if (headerSet2.w == 144) {
                        this.f3689a.h(TrackerEvent.PositioningOfflineOutdoor, (byte[]) null, headerSet2, this.c);
                    }
                    if (this.m.w != 144) {
                        this.i = true;
                    }
                } else if (!j(TrackerEvent.PositioningOfflineOutdoor)) {
                    this.i = true;
                } else {
                    throw new IOException("FINAL_GET forced but data did not fit into single packet!");
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void m() {
        a();
        if (this.c == null) {
            l();
        }
    }
}
