package com.bumptech.glide.gifdecoder;

import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class GifHeaderParser {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f2442a = new byte[256];
    public ByteBuffer b;
    public GifHeader c;
    public int d = 0;

    public void a() {
        this.b = null;
        this.c = null;
    }

    public final boolean b() {
        return this.c.b != 0;
    }

    public GifHeader c() {
        if (this.b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        } else if (b()) {
            return this.c;
        } else {
            k();
            if (!b()) {
                h();
                GifHeader gifHeader = this.c;
                if (gifHeader.c < 0) {
                    gifHeader.b = 1;
                }
            }
            return this.c;
        }
    }

    public final int d() {
        try {
            return this.b.get() & 255;
        } catch (Exception unused) {
            this.c.b = 1;
            return 0;
        }
    }

    public final void e() {
        this.c.d.f2440a = n();
        this.c.d.b = n();
        this.c.d.c = n();
        this.c.d.d = n();
        int d2 = d();
        boolean z = false;
        boolean z2 = (d2 & 128) != 0;
        int pow = (int) Math.pow(2.0d, (double) ((d2 & 7) + 1));
        GifFrame gifFrame = this.c.d;
        if ((d2 & 64) != 0) {
            z = true;
        }
        gifFrame.e = z;
        if (z2) {
            gifFrame.k = g(pow);
        } else {
            gifFrame.k = null;
        }
        this.c.d.j = this.b.position();
        r();
        if (!b()) {
            GifHeader gifHeader = this.c;
            gifHeader.c++;
            gifHeader.e.add(gifHeader.d);
        }
    }

    public final void f() {
        int d2 = d();
        this.d = d2;
        if (d2 > 0) {
            int i = 0;
            int i2 = 0;
            while (true) {
                try {
                    int i3 = this.d;
                    if (i < i3) {
                        i2 = i3 - i;
                        this.b.get(this.f2442a, i, i2);
                        i += i2;
                    } else {
                        return;
                    }
                } catch (Exception e) {
                    if (Log.isLoggable("GifHeaderParser", 3)) {
                        Log.d("GifHeaderParser", "Error Reading Block n: " + i + " count: " + i2 + " blockSize: " + this.d, e);
                    }
                    this.c.b = 1;
                    return;
                }
            }
        }
    }

    public final int[] g(int i) {
        byte[] bArr = new byte[(i * 3)];
        int[] iArr = null;
        try {
            this.b.get(bArr);
            iArr = new int[256];
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int i4 = i3 + 2;
                i3 += 3;
                int i5 = i2 + 1;
                iArr[i2] = ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3] & 255) << 16) | -16777216 | (bArr[i4] & 255);
                i2 = i5;
            }
        } catch (BufferUnderflowException e) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e);
            }
            this.c.b = 1;
        }
        return iArr;
    }

    public final void h() {
        i(Integer.MAX_VALUE);
    }

    public final void i(int i) {
        boolean z = false;
        while (!z && !b() && this.c.c <= i) {
            int d2 = d();
            if (d2 == 33) {
                int d3 = d();
                if (d3 == 1) {
                    q();
                } else if (d3 == 249) {
                    this.c.d = new GifFrame();
                    j();
                } else if (d3 == 254) {
                    q();
                } else if (d3 != 255) {
                    q();
                } else {
                    f();
                    StringBuilder sb = new StringBuilder();
                    for (int i2 = 0; i2 < 11; i2++) {
                        sb.append((char) this.f2442a[i2]);
                    }
                    if (sb.toString().equals("NETSCAPE2.0")) {
                        m();
                    } else {
                        q();
                    }
                }
            } else if (d2 == 44) {
                GifHeader gifHeader = this.c;
                if (gifHeader.d == null) {
                    gifHeader.d = new GifFrame();
                }
                e();
            } else if (d2 != 59) {
                this.c.b = 1;
            } else {
                z = true;
            }
        }
    }

    public final void j() {
        d();
        int d2 = d();
        GifFrame gifFrame = this.c.d;
        int i = (d2 & 28) >> 2;
        gifFrame.g = i;
        boolean z = true;
        if (i == 0) {
            gifFrame.g = 1;
        }
        if ((d2 & 1) == 0) {
            z = false;
        }
        gifFrame.f = z;
        int n = n();
        if (n < 2) {
            n = 10;
        }
        GifFrame gifFrame2 = this.c.d;
        gifFrame2.i = n * 10;
        gifFrame2.h = d();
        d();
    }

    public final void k() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append((char) d());
        }
        if (!sb.toString().startsWith("GIF")) {
            this.c.b = 1;
            return;
        }
        l();
        if (this.c.h && !b()) {
            GifHeader gifHeader = this.c;
            gifHeader.f2441a = g(gifHeader.i);
            GifHeader gifHeader2 = this.c;
            gifHeader2.l = gifHeader2.f2441a[gifHeader2.j];
        }
    }

    public final void l() {
        this.c.f = n();
        this.c.g = n();
        int d2 = d();
        GifHeader gifHeader = this.c;
        gifHeader.h = (d2 & 128) != 0;
        gifHeader.i = (int) Math.pow(2.0d, (double) ((d2 & 7) + 1));
        this.c.j = d();
        this.c.k = d();
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m() {
        /*
            r3 = this;
        L_0x0000:
            r3.f()
            byte[] r0 = r3.f2442a
            r1 = 0
            byte r1 = r0[r1]
            r2 = 1
            if (r1 != r2) goto L_0x001b
            byte r1 = r0[r2]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r2 = 2
            byte r0 = r0[r2]
            r0 = r0 & 255(0xff, float:3.57E-43)
            com.bumptech.glide.gifdecoder.GifHeader r2 = r3.c
            int r0 = r0 << 8
            r0 = r0 | r1
            r2.m = r0
        L_0x001b:
            int r0 = r3.d
            if (r0 <= 0) goto L_0x0025
            boolean r0 = r3.b()
            if (r0 == 0) goto L_0x0000
        L_0x0025:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.gifdecoder.GifHeaderParser.m():void");
    }

    public final int n() {
        return this.b.getShort();
    }

    public final void o() {
        this.b = null;
        Arrays.fill(this.f2442a, (byte) 0);
        this.c = new GifHeader();
        this.d = 0;
    }

    public GifHeaderParser p(ByteBuffer byteBuffer) {
        o();
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.b = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    public final void q() {
        int d2;
        do {
            d2 = d();
            this.b.position(Math.min(this.b.position() + d2, this.b.limit()));
        } while (d2 > 0);
    }

    public final void r() {
        d();
        q();
    }
}
