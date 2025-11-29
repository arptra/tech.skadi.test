package javax.obex;

import com.alibaba.fastjson.asm.Opcodes;
import com.google.mlkit.common.MlKitException;
import com.upuphone.starrynet.strategy.discovery.advertiser.pack.AdvPackConstants;
import java.io.IOException;
import java.io.InputStream;

public final class ServerOperation implements Operation, BaseStream {

    /* renamed from: a  reason: collision with root package name */
    public boolean f3695a = false;
    public HeaderSet b;
    public HeaderSet c;
    public boolean d;
    public InputStream e;
    public ServerSession f;
    public int g;
    public int h;
    public boolean i;
    public boolean j;
    public PrivateInputStream k;
    public PrivateOutputStream l;
    public boolean m;
    public String n;
    public ServerRequestHandler o;
    public boolean p;
    public boolean q;
    public boolean r = true;

    public ServerOperation(ServerSession serverSession, InputStream inputStream, int i2, int i3, ServerRequestHandler serverRequestHandler) {
        byte[] bArr;
        this.f = serverSession;
        this.e = inputStream;
        this.g = i3;
        this.i = false;
        this.b = new HeaderSet();
        this.c = new HeaderSet();
        this.k = new PrivateInputStream(this);
        this.h = 3;
        this.o = serverRequestHandler;
        this.p = false;
        this.m = false;
        this.q = false;
        if (i2 == 2 || i2 == 130) {
            this.j = false;
            if ((i2 & 128) == 0) {
                this.d = false;
            } else {
                this.d = true;
                this.p = true;
            }
        } else if (i2 == 3 || i2 == 131) {
            this.j = true;
            this.d = false;
            if (i2 == 131) {
                this.p = true;
            }
        } else {
            throw new IOException("ServerOperation can not handle such request");
        }
        int read = (inputStream.read() << 8) + inputStream.read();
        if (read <= 65534) {
            if (read > 3) {
                int i4 = read - 3;
                byte[] bArr2 = new byte[i4];
                int read2 = inputStream.read(bArr2);
                while (read2 != i4) {
                    read2 += inputStream.read(bArr2, read2, i4 - read2);
                }
                byte[] j2 = ObexHelper.j(this.b, bArr2);
                if (j2 != null) {
                    this.q = true;
                }
                if (this.o.a() == -1 || (bArr = this.b.v) == null) {
                    this.o.k(1);
                } else {
                    this.o.k(ObexHelper.c(bArr));
                }
                byte[] bArr3 = this.b.u;
                if (bArr3 == null || this.f.b(bArr3)) {
                    HeaderSet headerSet = this.b;
                    if (headerSet.t != null) {
                        this.f.a(headerSet);
                        HeaderSet headerSet2 = this.c;
                        HeaderSet headerSet3 = this.b;
                        byte[] bArr4 = new byte[headerSet3.u.length];
                        headerSet2.u = bArr4;
                        System.arraycopy(headerSet3.u, 0, bArr4, 0, bArr4.length);
                        HeaderSet headerSet4 = this.b;
                        headerSet4.u = null;
                        headerSet4.t = null;
                    }
                    if (j2 == null) {
                        while (!this.j && !this.d) {
                            f(AdvPackConstants.ADV_MODE_ACTIVE_NO_WINDOW);
                            if (this.k.available() > 0) {
                                break;
                            }
                        }
                    } else {
                        this.k.b(j2, 1);
                    }
                } else {
                    this.n = "Authentication Failed";
                    this.f.j(Opcodes.INSTANCEOF, (byte[]) null);
                    this.i = true;
                    this.b.u = null;
                    return;
                }
            }
            while (!this.j && !this.d && this.k.available() == 0) {
                f(AdvPackConstants.ADV_MODE_ACTIVE_NO_WINDOW);
                if (this.k.available() > 0) {
                    break;
                }
            }
            while (this.j && !this.p) {
                f(AdvPackConstants.ADV_MODE_ACTIVE_NO_WINDOW);
            }
            return;
        }
        this.f.j(MlKitException.CODE_SCANNER_PIPELINE_INFERENCE_ERROR, (byte[]) null);
        throw new IOException("Packet received was too large");
    }

    public void a() {
        if (this.n != null) {
            throw new IOException(this.n);
        } else if (this.i) {
            throw new IOException("Operation has already ended");
        }
    }

    public synchronized boolean b(boolean z, boolean z2) {
        if (this.j) {
            f(AdvPackConstants.ADV_MODE_ACTIVE_NO_WINDOW);
            return true;
        } else if (this.d) {
            return false;
        } else {
            if (z) {
                f(AdvPackConstants.ADV_MODE_ACTIVE_NO_WINDOW);
                return true;
            } else if (this.h <= 3 && this.l.c() <= 0) {
                return false;
            } else {
                f(AdvPackConstants.ADV_MODE_ACTIVE_NO_WINDOW);
                return true;
            }
        }
    }

    public void c(boolean z) {
    }

    public void d() {
    }

    public boolean e() {
        return this.q;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0214, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean f(int r15) {
        /*
            r14 = this;
            monitor-enter(r14)
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0018 }
            r0.<init>()     // Catch:{ all -> 0x0018 }
            javax.obex.ServerRequestHandler r1 = r14.o     // Catch:{ all -> 0x0018 }
            long r1 = r1.a()     // Catch:{ all -> 0x0018 }
            r3 = -1
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r6 = 0
            if (r5 != 0) goto L_0x001b
            javax.obex.HeaderSet r1 = r14.c     // Catch:{ all -> 0x0018 }
            r1.v = r6     // Catch:{ all -> 0x0018 }
            goto L_0x0023
        L_0x0018:
            r15 = move-exception
            goto L_0x0226
        L_0x001b:
            javax.obex.HeaderSet r5 = r14.c     // Catch:{ all -> 0x0018 }
            byte[] r1 = javax.obex.ObexHelper.b(r1)     // Catch:{ all -> 0x0018 }
            r5.v = r1     // Catch:{ all -> 0x0018 }
        L_0x0023:
            javax.obex.HeaderSet r1 = r14.c     // Catch:{ all -> 0x0018 }
            r2 = 1
            byte[] r1 = javax.obex.ObexHelper.f(r1, r2)     // Catch:{ all -> 0x0018 }
            javax.obex.PrivateOutputStream r5 = r14.l     // Catch:{ all -> 0x0018 }
            r7 = -1
            if (r5 == 0) goto L_0x0035
            int r5 = r5.c()     // Catch:{ all -> 0x0018 }
        L_0x0033:
            r8 = r5
            goto L_0x0037
        L_0x0035:
            r5 = r7
            goto L_0x0033
        L_0x0037:
            int r9 = r1.length     // Catch:{ all -> 0x0018 }
            r10 = 3
            int r9 = r9 + r10
            int r11 = r14.g     // Catch:{ all -> 0x0018 }
            r12 = 0
            if (r9 <= r11) goto L_0x007f
            r0 = r12
        L_0x0040:
            r3 = r0
            int r4 = r1.length     // Catch:{ all -> 0x0018 }
            if (r0 == r4) goto L_0x0079
            int r0 = r14.g     // Catch:{ all -> 0x0018 }
            int r0 = r0 - r10
            int r0 = javax.obex.ObexHelper.g(r1, r3, r0)     // Catch:{ all -> 0x0018 }
            if (r0 != r7) goto L_0x006c
            r14.i = r2     // Catch:{ all -> 0x0018 }
            javax.obex.PrivateInputStream r15 = r14.k     // Catch:{ all -> 0x0018 }
            if (r15 == 0) goto L_0x0056
            r15.close()     // Catch:{ all -> 0x0018 }
        L_0x0056:
            javax.obex.PrivateOutputStream r15 = r14.l     // Catch:{ all -> 0x0018 }
            if (r15 == 0) goto L_0x005d
            r15.close()     // Catch:{ all -> 0x0018 }
        L_0x005d:
            javax.obex.ServerSession r15 = r14.f     // Catch:{ all -> 0x0018 }
            r0 = 208(0xd0, float:2.91E-43)
            r15.j(r0, r6)     // Catch:{ all -> 0x0018 }
            java.io.IOException r15 = new java.io.IOException     // Catch:{ all -> 0x0018 }
            java.lang.String r0 = "OBEX Packet exceeds max packet size"
            r15.<init>(r0)     // Catch:{ all -> 0x0018 }
            throw r15     // Catch:{ all -> 0x0018 }
        L_0x006c:
            int r4 = r0 - r3
            byte[] r8 = new byte[r4]     // Catch:{ all -> 0x0018 }
            java.lang.System.arraycopy(r1, r3, r8, r12, r4)     // Catch:{ all -> 0x0018 }
            javax.obex.ServerSession r3 = r14.f     // Catch:{ all -> 0x0018 }
            r3.j(r15, r8)     // Catch:{ all -> 0x0018 }
            goto L_0x0040
        L_0x0079:
            if (r5 <= 0) goto L_0x007d
            monitor-exit(r14)
            return r2
        L_0x007d:
            monitor-exit(r14)
            return r12
        L_0x007f:
            r0.write(r1)     // Catch:{ all -> 0x0018 }
            boolean r7 = r14.j     // Catch:{ all -> 0x0018 }
            r9 = 160(0xa0, float:2.24E-43)
            if (r7 == 0) goto L_0x008c
            if (r15 != r9) goto L_0x008c
            r14.d = r2     // Catch:{ all -> 0x0018 }
        L_0x008c:
            boolean r7 = r14.d     // Catch:{ all -> 0x0018 }
            r11 = 73
            if (r7 != 0) goto L_0x0099
            int r7 = r1.length     // Catch:{ all -> 0x0018 }
            int r13 = r14.g     // Catch:{ all -> 0x0018 }
            int r13 = r13 + -20
            if (r7 >= r13) goto L_0x00e8
        L_0x0099:
            if (r5 <= 0) goto L_0x00e8
            int r7 = r14.g     // Catch:{ all -> 0x0018 }
            int r13 = r1.length     // Catch:{ all -> 0x0018 }
            int r13 = r7 - r13
            int r13 = r13 + -6
            if (r5 <= r13) goto L_0x00a8
            int r1 = r1.length     // Catch:{ all -> 0x0018 }
            int r7 = r7 - r1
            int r5 = r7 + -6
        L_0x00a8:
            javax.obex.PrivateOutputStream r1 = r14.l     // Catch:{ all -> 0x0018 }
            byte[] r1 = r1.b(r5)     // Catch:{ all -> 0x0018 }
            boolean r7 = r14.d     // Catch:{ all -> 0x0018 }
            if (r7 != 0) goto L_0x00d3
            javax.obex.PrivateOutputStream r7 = r14.l     // Catch:{ all -> 0x0018 }
            boolean r7 = r7.isClosed()     // Catch:{ all -> 0x0018 }
            if (r7 == 0) goto L_0x00bb
            goto L_0x00d3
        L_0x00bb:
            boolean r7 = r14.r     // Catch:{ all -> 0x0018 }
            if (r7 != r2) goto L_0x00e8
            r7 = 72
            r0.write(r7)     // Catch:{ all -> 0x0018 }
            int r5 = r5 + r10
            int r7 = r5 >> 8
            byte r7 = (byte) r7     // Catch:{ all -> 0x0018 }
            r0.write(r7)     // Catch:{ all -> 0x0018 }
            byte r5 = (byte) r5     // Catch:{ all -> 0x0018 }
            r0.write(r5)     // Catch:{ all -> 0x0018 }
            r0.write(r1)     // Catch:{ all -> 0x0018 }
            goto L_0x00e8
        L_0x00d3:
            boolean r7 = r14.r     // Catch:{ all -> 0x0018 }
            if (r7 != r2) goto L_0x00e8
            r0.write(r11)     // Catch:{ all -> 0x0018 }
            int r5 = r5 + r10
            int r7 = r5 >> 8
            byte r7 = (byte) r7     // Catch:{ all -> 0x0018 }
            r0.write(r7)     // Catch:{ all -> 0x0018 }
            byte r5 = (byte) r5     // Catch:{ all -> 0x0018 }
            r0.write(r5)     // Catch:{ all -> 0x0018 }
            r0.write(r1)     // Catch:{ all -> 0x0018 }
        L_0x00e8:
            boolean r1 = r14.d     // Catch:{ all -> 0x0018 }
            if (r1 == 0) goto L_0x00ff
            if (r15 != r9) goto L_0x00ff
            if (r8 > 0) goto L_0x00ff
            boolean r1 = r14.r     // Catch:{ all -> 0x0018 }
            if (r1 != r2) goto L_0x00ff
            r0.write(r11)     // Catch:{ all -> 0x0018 }
            byte r1 = (byte) r12     // Catch:{ all -> 0x0018 }
            r0.write(r1)     // Catch:{ all -> 0x0018 }
            byte r1 = (byte) r10     // Catch:{ all -> 0x0018 }
            r0.write(r1)     // Catch:{ all -> 0x0018 }
        L_0x00ff:
            r14.h = r10     // Catch:{ all -> 0x0018 }
            javax.obex.ServerSession r1 = r14.f     // Catch:{ all -> 0x0018 }
            byte[] r0 = r0.toByteArray()     // Catch:{ all -> 0x0018 }
            r1.j(r15, r0)     // Catch:{ all -> 0x0018 }
            r0 = 144(0x90, float:2.02E-43)
            if (r15 != r0) goto L_0x0224
            java.io.InputStream r15 = r14.e     // Catch:{ all -> 0x0018 }
            int r15 = r15.read()     // Catch:{ all -> 0x0018 }
            java.io.InputStream r0 = r14.e     // Catch:{ all -> 0x0018 }
            int r0 = r0.read()     // Catch:{ all -> 0x0018 }
            int r0 = r0 << 8
            java.io.InputStream r1 = r14.e     // Catch:{ all -> 0x0018 }
            int r1 = r1.read()     // Catch:{ all -> 0x0018 }
            int r0 = r0 + r1
            r1 = 2
            r5 = 131(0x83, float:1.84E-43)
            r7 = 130(0x82, float:1.82E-43)
            if (r15 == r1) goto L_0x0175
            if (r15 == r7) goto L_0x0175
            if (r15 == r10) goto L_0x0175
            if (r15 == r5) goto L_0x0175
            if (r0 <= r10) goto L_0x0147
            int r0 = r0 - r10
            byte[] r1 = new byte[r0]     // Catch:{ all -> 0x0018 }
            java.io.InputStream r3 = r14.e     // Catch:{ all -> 0x0018 }
            int r3 = r3.read(r1)     // Catch:{ all -> 0x0018 }
        L_0x013b:
            if (r3 == r0) goto L_0x0147
            java.io.InputStream r4 = r14.e     // Catch:{ all -> 0x0018 }
            int r5 = r0 - r3
            int r4 = r4.read(r1, r3, r5)     // Catch:{ all -> 0x0018 }
            int r3 = r3 + r4
            goto L_0x013b
        L_0x0147:
            r0 = 255(0xff, float:3.57E-43)
            if (r15 != r0) goto L_0x0160
            javax.obex.ServerSession r15 = r14.f     // Catch:{ all -> 0x0018 }
            r15.j(r9, r6)     // Catch:{ all -> 0x0018 }
            r14.i = r2     // Catch:{ all -> 0x0018 }
            r14.f3695a = r2     // Catch:{ all -> 0x0018 }
            java.lang.String r15 = "Abort Received"
            r14.n = r15     // Catch:{ all -> 0x0018 }
            java.io.IOException r15 = new java.io.IOException     // Catch:{ all -> 0x0018 }
            java.lang.String r0 = "Abort Received"
            r15.<init>(r0)     // Catch:{ all -> 0x0018 }
            throw r15     // Catch:{ all -> 0x0018 }
        L_0x0160:
            javax.obex.ServerSession r15 = r14.f     // Catch:{ all -> 0x0018 }
            r0 = 192(0xc0, float:2.69E-43)
            r15.j(r0, r6)     // Catch:{ all -> 0x0018 }
            r14.i = r2     // Catch:{ all -> 0x0018 }
            java.lang.String r15 = "Bad Request Received"
            r14.n = r15     // Catch:{ all -> 0x0018 }
            java.io.IOException r15 = new java.io.IOException     // Catch:{ all -> 0x0018 }
            java.lang.String r0 = "Bad Request Received"
            r15.<init>(r0)     // Catch:{ all -> 0x0018 }
            throw r15     // Catch:{ all -> 0x0018 }
        L_0x0175:
            if (r15 != r7) goto L_0x017a
            r14.d = r2     // Catch:{ all -> 0x0018 }
            goto L_0x017e
        L_0x017a:
            if (r15 != r5) goto L_0x017e
            r14.p = r2     // Catch:{ all -> 0x0018 }
        L_0x017e:
            r15 = 65534(0xfffe, float:9.1833E-41)
            if (r0 > r15) goto L_0x0215
            if (r0 <= r10) goto L_0x0213
            int r0 = r0 - r10
            byte[] r15 = new byte[r0]     // Catch:{ all -> 0x0018 }
            java.io.InputStream r1 = r14.e     // Catch:{ all -> 0x0018 }
            int r1 = r1.read(r15)     // Catch:{ all -> 0x0018 }
        L_0x018e:
            if (r1 == r0) goto L_0x019a
            java.io.InputStream r5 = r14.e     // Catch:{ all -> 0x0018 }
            int r7 = r0 - r1
            int r5 = r5.read(r15, r1, r7)     // Catch:{ all -> 0x0018 }
            int r1 = r1 + r5
            goto L_0x018e
        L_0x019a:
            javax.obex.HeaderSet r0 = r14.b     // Catch:{ all -> 0x0018 }
            byte[] r15 = javax.obex.ObexHelper.j(r0, r15)     // Catch:{ all -> 0x0018 }
            if (r15 == 0) goto L_0x01a4
            r14.q = r2     // Catch:{ all -> 0x0018 }
        L_0x01a4:
            javax.obex.ServerRequestHandler r0 = r14.o     // Catch:{ all -> 0x0018 }
            long r0 = r0.a()     // Catch:{ all -> 0x0018 }
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 == 0) goto L_0x01be
            javax.obex.HeaderSet r0 = r14.b     // Catch:{ all -> 0x0018 }
            byte[] r0 = r0.v     // Catch:{ all -> 0x0018 }
            if (r0 == 0) goto L_0x01be
            javax.obex.ServerRequestHandler r1 = r14.o     // Catch:{ all -> 0x0018 }
            long r3 = javax.obex.ObexHelper.c(r0)     // Catch:{ all -> 0x0018 }
            r1.k(r3)     // Catch:{ all -> 0x0018 }
            goto L_0x01c5
        L_0x01be:
            javax.obex.ServerRequestHandler r0 = r14.o     // Catch:{ all -> 0x0018 }
            r3 = 1
            r0.k(r3)     // Catch:{ all -> 0x0018 }
        L_0x01c5:
            javax.obex.HeaderSet r0 = r14.b     // Catch:{ all -> 0x0018 }
            byte[] r0 = r0.u     // Catch:{ all -> 0x0018 }
            if (r0 == 0) goto L_0x01ea
            javax.obex.ServerSession r1 = r14.f     // Catch:{ all -> 0x0018 }
            boolean r0 = r1.b(r0)     // Catch:{ all -> 0x0018 }
            if (r0 != 0) goto L_0x01e6
            java.lang.String r15 = "Authentication Failed"
            r14.n = r15     // Catch:{ all -> 0x0018 }
            javax.obex.ServerSession r15 = r14.f     // Catch:{ all -> 0x0018 }
            r0 = 193(0xc1, float:2.7E-43)
            r15.j(r0, r6)     // Catch:{ all -> 0x0018 }
            r14.i = r2     // Catch:{ all -> 0x0018 }
            javax.obex.HeaderSet r15 = r14.b     // Catch:{ all -> 0x0018 }
            r15.u = r6     // Catch:{ all -> 0x0018 }
            monitor-exit(r14)
            return r12
        L_0x01e6:
            javax.obex.HeaderSet r0 = r14.b     // Catch:{ all -> 0x0018 }
            r0.u = r6     // Catch:{ all -> 0x0018 }
        L_0x01ea:
            javax.obex.HeaderSet r0 = r14.b     // Catch:{ all -> 0x0018 }
            byte[] r1 = r0.t     // Catch:{ all -> 0x0018 }
            if (r1 == 0) goto L_0x020c
            javax.obex.ServerSession r1 = r14.f     // Catch:{ all -> 0x0018 }
            r1.a(r0)     // Catch:{ all -> 0x0018 }
            javax.obex.HeaderSet r0 = r14.c     // Catch:{ all -> 0x0018 }
            javax.obex.HeaderSet r1 = r14.b     // Catch:{ all -> 0x0018 }
            byte[] r3 = r1.u     // Catch:{ all -> 0x0018 }
            int r3 = r3.length     // Catch:{ all -> 0x0018 }
            byte[] r3 = new byte[r3]     // Catch:{ all -> 0x0018 }
            r0.u = r3     // Catch:{ all -> 0x0018 }
            byte[] r0 = r1.u     // Catch:{ all -> 0x0018 }
            int r1 = r3.length     // Catch:{ all -> 0x0018 }
            java.lang.System.arraycopy(r0, r12, r3, r12, r1)     // Catch:{ all -> 0x0018 }
            javax.obex.HeaderSet r0 = r14.b     // Catch:{ all -> 0x0018 }
            r0.u = r6     // Catch:{ all -> 0x0018 }
            r0.t = r6     // Catch:{ all -> 0x0018 }
        L_0x020c:
            if (r15 == 0) goto L_0x0213
            javax.obex.PrivateInputStream r0 = r14.k     // Catch:{ all -> 0x0018 }
            r0.b(r15, r2)     // Catch:{ all -> 0x0018 }
        L_0x0213:
            monitor-exit(r14)
            return r2
        L_0x0215:
            javax.obex.ServerSession r15 = r14.f     // Catch:{ all -> 0x0018 }
            r0 = 206(0xce, float:2.89E-43)
            r15.j(r0, r6)     // Catch:{ all -> 0x0018 }
            java.io.IOException r15 = new java.io.IOException     // Catch:{ all -> 0x0018 }
            java.lang.String r0 = "Packet received was too large"
            r15.<init>(r0)     // Catch:{ all -> 0x0018 }
            throw r15     // Catch:{ all -> 0x0018 }
        L_0x0224:
            monitor-exit(r14)
            return r12
        L_0x0226:
            monitor-exit(r14)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.obex.ServerOperation.f(int):boolean");
    }
}
