package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import com.bumptech.glide.gifdecoder.GifDecoder;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

public class StandardGifDecoder implements GifDecoder {
    public static final String u = "StandardGifDecoder";

    /* renamed from: a  reason: collision with root package name */
    public int[] f2443a;
    public final int[] b;
    public final GifDecoder.BitmapProvider c;
    public ByteBuffer d;
    public byte[] e;
    public short[] f;
    public byte[] g;
    public byte[] h;
    public byte[] i;
    public int[] j;
    public int k;
    public GifHeader l;
    public Bitmap m;
    public boolean n;
    public int o;
    public int p;
    public int q;
    public int r;
    public Boolean s;
    public Bitmap.Config t;

    public StandardGifDecoder(GifDecoder.BitmapProvider bitmapProvider, GifHeader gifHeader, ByteBuffer byteBuffer, int i2) {
        this(bitmapProvider);
        r(gifHeader, byteBuffer, i2);
    }

    public void a(Bitmap.Config config) {
        Bitmap.Config config2;
        Bitmap.Config config3 = Bitmap.Config.ARGB_8888;
        if (config == config3 || config == (config2 = Bitmap.Config.RGB_565)) {
            this.t = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + config3 + " or " + config2);
    }

    public void b() {
        this.k = -1;
    }

    public int c() {
        return this.k;
    }

    public void clear() {
        this.l = null;
        byte[] bArr = this.i;
        if (bArr != null) {
            this.c.e(bArr);
        }
        int[] iArr = this.j;
        if (iArr != null) {
            this.c.f(iArr);
        }
        Bitmap bitmap = this.m;
        if (bitmap != null) {
            this.c.c(bitmap);
        }
        this.m = null;
        this.d = null;
        this.s = null;
        byte[] bArr2 = this.e;
        if (bArr2 != null) {
            this.c.e(bArr2);
        }
    }

    public int d() {
        return this.d.limit() + this.i.length + (this.j.length * 4);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e7, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0042 A[Catch:{ all -> 0x000e }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00d0 A[Catch:{ all -> 0x000e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized android.graphics.Bitmap e() {
        /*
            r8 = this;
            monitor-enter(r8)
            com.bumptech.glide.gifdecoder.GifHeader r0 = r8.l     // Catch:{ all -> 0x000e }
            int r0 = r0.c     // Catch:{ all -> 0x000e }
            r1 = 3
            r2 = 1
            if (r0 <= 0) goto L_0x0011
            int r0 = r8.k     // Catch:{ all -> 0x000e }
            if (r0 >= 0) goto L_0x003d
            goto L_0x0011
        L_0x000e:
            r0 = move-exception
            goto L_0x00e8
        L_0x0011:
            java.lang.String r0 = u     // Catch:{ all -> 0x000e }
            boolean r3 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x000e }
            if (r3 == 0) goto L_0x003b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x000e }
            r3.<init>()     // Catch:{ all -> 0x000e }
            java.lang.String r4 = "Unable to decode frame, frameCount="
            r3.append(r4)     // Catch:{ all -> 0x000e }
            com.bumptech.glide.gifdecoder.GifHeader r4 = r8.l     // Catch:{ all -> 0x000e }
            int r4 = r4.c     // Catch:{ all -> 0x000e }
            r3.append(r4)     // Catch:{ all -> 0x000e }
            java.lang.String r4 = ", framePointer="
            r3.append(r4)     // Catch:{ all -> 0x000e }
            int r4 = r8.k     // Catch:{ all -> 0x000e }
            r3.append(r4)     // Catch:{ all -> 0x000e }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x000e }
            android.util.Log.d(r0, r3)     // Catch:{ all -> 0x000e }
        L_0x003b:
            r8.o = r2     // Catch:{ all -> 0x000e }
        L_0x003d:
            int r0 = r8.o     // Catch:{ all -> 0x000e }
            r3 = 0
            if (r0 == r2) goto L_0x00c8
            r4 = 2
            if (r0 != r4) goto L_0x0047
            goto L_0x00c8
        L_0x0047:
            r0 = 0
            r8.o = r0     // Catch:{ all -> 0x000e }
            byte[] r5 = r8.e     // Catch:{ all -> 0x000e }
            if (r5 != 0) goto L_0x0058
            com.bumptech.glide.gifdecoder.GifDecoder$BitmapProvider r5 = r8.c     // Catch:{ all -> 0x000e }
            r6 = 255(0xff, float:3.57E-43)
            byte[] r5 = r5.a(r6)     // Catch:{ all -> 0x000e }
            r8.e = r5     // Catch:{ all -> 0x000e }
        L_0x0058:
            com.bumptech.glide.gifdecoder.GifHeader r5 = r8.l     // Catch:{ all -> 0x000e }
            java.util.List r5 = r5.e     // Catch:{ all -> 0x000e }
            int r6 = r8.k     // Catch:{ all -> 0x000e }
            java.lang.Object r5 = r5.get(r6)     // Catch:{ all -> 0x000e }
            com.bumptech.glide.gifdecoder.GifFrame r5 = (com.bumptech.glide.gifdecoder.GifFrame) r5     // Catch:{ all -> 0x000e }
            int r6 = r8.k     // Catch:{ all -> 0x000e }
            int r6 = r6 - r2
            if (r6 < 0) goto L_0x0074
            com.bumptech.glide.gifdecoder.GifHeader r7 = r8.l     // Catch:{ all -> 0x000e }
            java.util.List r7 = r7.e     // Catch:{ all -> 0x000e }
            java.lang.Object r6 = r7.get(r6)     // Catch:{ all -> 0x000e }
            com.bumptech.glide.gifdecoder.GifFrame r6 = (com.bumptech.glide.gifdecoder.GifFrame) r6     // Catch:{ all -> 0x000e }
            goto L_0x0075
        L_0x0074:
            r6 = r3
        L_0x0075:
            int[] r7 = r5.k     // Catch:{ all -> 0x000e }
            if (r7 == 0) goto L_0x007a
            goto L_0x007e
        L_0x007a:
            com.bumptech.glide.gifdecoder.GifHeader r7 = r8.l     // Catch:{ all -> 0x000e }
            int[] r7 = r7.f2441a     // Catch:{ all -> 0x000e }
        L_0x007e:
            r8.f2443a = r7     // Catch:{ all -> 0x000e }
            if (r7 != 0) goto L_0x00a4
            java.lang.String r0 = u     // Catch:{ all -> 0x000e }
            boolean r1 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x000e }
            if (r1 == 0) goto L_0x00a0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x000e }
            r1.<init>()     // Catch:{ all -> 0x000e }
            java.lang.String r4 = "No valid color table found for frame #"
            r1.append(r4)     // Catch:{ all -> 0x000e }
            int r4 = r8.k     // Catch:{ all -> 0x000e }
            r1.append(r4)     // Catch:{ all -> 0x000e }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x000e }
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x000e }
        L_0x00a0:
            r8.o = r2     // Catch:{ all -> 0x000e }
            monitor-exit(r8)
            return r3
        L_0x00a4:
            boolean r1 = r5.f     // Catch:{ all -> 0x000e }
            if (r1 == 0) goto L_0x00c2
            int[] r1 = r8.b     // Catch:{ all -> 0x000e }
            int r2 = r7.length     // Catch:{ all -> 0x000e }
            java.lang.System.arraycopy(r7, r0, r1, r0, r2)     // Catch:{ all -> 0x000e }
            int[] r1 = r8.b     // Catch:{ all -> 0x000e }
            r8.f2443a = r1     // Catch:{ all -> 0x000e }
            int r2 = r5.h     // Catch:{ all -> 0x000e }
            r1[r2] = r0     // Catch:{ all -> 0x000e }
            int r0 = r5.g     // Catch:{ all -> 0x000e }
            if (r0 != r4) goto L_0x00c2
            int r0 = r8.k     // Catch:{ all -> 0x000e }
            if (r0 != 0) goto L_0x00c2
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x000e }
            r8.s = r0     // Catch:{ all -> 0x000e }
        L_0x00c2:
            android.graphics.Bitmap r0 = r8.s(r5, r6)     // Catch:{ all -> 0x000e }
            monitor-exit(r8)
            return r0
        L_0x00c8:
            java.lang.String r0 = u     // Catch:{ all -> 0x000e }
            boolean r1 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x000e }
            if (r1 == 0) goto L_0x00e6
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x000e }
            r1.<init>()     // Catch:{ all -> 0x000e }
            java.lang.String r2 = "Unable to decode frame, status="
            r1.append(r2)     // Catch:{ all -> 0x000e }
            int r2 = r8.o     // Catch:{ all -> 0x000e }
            r1.append(r2)     // Catch:{ all -> 0x000e }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x000e }
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x000e }
        L_0x00e6:
            monitor-exit(r8)
            return r3
        L_0x00e8:
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.gifdecoder.StandardGifDecoder.e():android.graphics.Bitmap");
    }

    public void f() {
        this.k = (this.k + 1) % this.l.c;
    }

    public int g() {
        return this.l.c;
    }

    public ByteBuffer getData() {
        return this.d;
    }

    public int h() {
        int i2 = this.l.m;
        if (i2 == -1) {
            return 1;
        }
        if (i2 == 0) {
            return 0;
        }
        return i2 + 1;
    }

    public int i() {
        int i2;
        if (this.l.c <= 0 || (i2 = this.k) < 0) {
            return 0;
        }
        return n(i2);
    }

    public final int j(int i2, int i3, int i4) {
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = i2; i10 < this.p + i2; i10++) {
            byte[] bArr = this.i;
            if (i10 >= bArr.length || i10 >= i3) {
                break;
            }
            int i11 = this.f2443a[bArr[i10] & 255];
            if (i11 != 0) {
                i5 += (i11 >> 24) & 255;
                i6 += (i11 >> 16) & 255;
                i7 += (i11 >> 8) & 255;
                i8 += i11 & 255;
                i9++;
            }
        }
        int i12 = i2 + i4;
        for (int i13 = i12; i13 < this.p + i12; i13++) {
            byte[] bArr2 = this.i;
            if (i13 >= bArr2.length || i13 >= i3) {
                break;
            }
            int i14 = this.f2443a[bArr2[i13] & 255];
            if (i14 != 0) {
                i5 += (i14 >> 24) & 255;
                i6 += (i14 >> 16) & 255;
                i7 += (i14 >> 8) & 255;
                i8 += i14 & 255;
                i9++;
            }
        }
        if (i9 == 0) {
            return 0;
        }
        return ((i5 / i9) << 24) | ((i6 / i9) << 16) | ((i7 / i9) << 8) | (i8 / i9);
    }

    public final void k(GifFrame gifFrame) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        GifFrame gifFrame2 = gifFrame;
        int[] iArr = this.j;
        int i7 = gifFrame2.d;
        int i8 = this.p;
        int i9 = i7 / i8;
        int i10 = gifFrame2.b / i8;
        int i11 = gifFrame2.c / i8;
        int i12 = gifFrame2.f2440a / i8;
        boolean z = this.k == 0;
        int i13 = this.r;
        int i14 = this.q;
        byte[] bArr = this.i;
        int[] iArr2 = this.f2443a;
        Boolean bool = this.s;
        int i15 = 8;
        int i16 = 0;
        int i17 = 0;
        int i18 = 1;
        while (i17 < i9) {
            Boolean bool2 = bool;
            if (gifFrame2.e) {
                if (i16 >= i9) {
                    int i19 = i18 + 1;
                    i2 = i9;
                    if (i19 == 2) {
                        i16 = 4;
                    } else if (i19 == 3) {
                        i15 = 4;
                        i18 = i19;
                        i16 = 2;
                    } else if (i19 == 4) {
                        i18 = i19;
                        i16 = 1;
                        i15 = 2;
                    }
                    i18 = i19;
                } else {
                    i2 = i9;
                }
                i3 = i16 + i15;
            } else {
                i2 = i9;
                i3 = i16;
                i16 = i17;
            }
            int i20 = i16 + i10;
            boolean z2 = i8 == 1;
            if (i20 < i14) {
                int i21 = i20 * i13;
                int i22 = i21 + i12;
                int i23 = i22 + i11;
                int i24 = i21 + i13;
                if (i24 < i23) {
                    i23 = i24;
                }
                i4 = i3;
                int i25 = i17 * i8 * gifFrame2.c;
                if (z2) {
                    int i26 = i22;
                    while (i26 < i23) {
                        int i27 = i10;
                        int i28 = iArr2[bArr[i25] & 255];
                        if (i28 != 0) {
                            iArr[i26] = i28;
                        } else if (z && bool2 == null) {
                            bool2 = Boolean.TRUE;
                        }
                        i25 += i8;
                        i26++;
                        i10 = i27;
                    }
                } else {
                    i6 = i10;
                    int i29 = ((i23 - i22) * i8) + i25;
                    int i30 = i22;
                    while (true) {
                        i5 = i11;
                        if (i30 >= i23) {
                            break;
                        }
                        int j2 = j(i25, i29, gifFrame2.c);
                        if (j2 != 0) {
                            iArr[i30] = j2;
                        } else if (z && bool2 == null) {
                            bool2 = Boolean.TRUE;
                        }
                        i25 += i8;
                        i30++;
                        i11 = i5;
                    }
                    bool = bool2;
                    i17++;
                    i10 = i6;
                    i9 = i2;
                    i11 = i5;
                    i16 = i4;
                }
            } else {
                i4 = i3;
            }
            i6 = i10;
            i5 = i11;
            bool = bool2;
            i17++;
            i10 = i6;
            i9 = i2;
            i11 = i5;
            i16 = i4;
        }
        Boolean bool3 = bool;
        if (this.s == null) {
            this.s = Boolean.valueOf(bool3 == null ? false : bool3.booleanValue());
        }
    }

    public final void l(GifFrame gifFrame) {
        GifFrame gifFrame2 = gifFrame;
        int[] iArr = this.j;
        int i2 = gifFrame2.d;
        int i3 = gifFrame2.b;
        int i4 = gifFrame2.c;
        int i5 = gifFrame2.f2440a;
        boolean z = this.k == 0;
        int i6 = this.r;
        byte[] bArr = this.i;
        int[] iArr2 = this.f2443a;
        int i7 = 0;
        byte b2 = -1;
        while (i7 < i2) {
            int i8 = (i7 + i3) * i6;
            int i9 = i8 + i5;
            int i10 = i9 + i4;
            int i11 = i8 + i6;
            if (i11 < i10) {
                i10 = i11;
            }
            int i12 = gifFrame2.c * i7;
            int i13 = i9;
            while (i13 < i10) {
                byte b3 = bArr[i12];
                int i14 = i2;
                byte b4 = b3 & 255;
                if (b4 != b2) {
                    int i15 = iArr2[b4];
                    if (i15 != 0) {
                        iArr[i13] = i15;
                    } else {
                        b2 = b3;
                    }
                }
                i12++;
                i13++;
                GifFrame gifFrame3 = gifFrame;
                i2 = i14;
            }
            int i16 = i2;
            i7++;
            gifFrame2 = gifFrame;
        }
        Boolean bool = this.s;
        this.s = Boolean.valueOf((bool != null && bool.booleanValue()) || (this.s == null && z && b2 != -1));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v14, resolved type: byte} */
    /* JADX WARNING: Incorrect type for immutable var: ssa=short, code=int, for r7v13, types: [short] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m(com.bumptech.glide.gifdecoder.GifFrame r29) {
        /*
            r28 = this;
            r0 = r28
            r1 = r29
            if (r1 == 0) goto L_0x000d
            java.nio.ByteBuffer r2 = r0.d
            int r3 = r1.j
            r2.position(r3)
        L_0x000d:
            if (r1 != 0) goto L_0x0017
            com.bumptech.glide.gifdecoder.GifHeader r1 = r0.l
            int r2 = r1.f
            int r1 = r1.g
        L_0x0015:
            int r2 = r2 * r1
            goto L_0x001c
        L_0x0017:
            int r2 = r1.c
            int r1 = r1.d
            goto L_0x0015
        L_0x001c:
            byte[] r1 = r0.i
            if (r1 == 0) goto L_0x0023
            int r1 = r1.length
            if (r1 >= r2) goto L_0x002b
        L_0x0023:
            com.bumptech.glide.gifdecoder.GifDecoder$BitmapProvider r1 = r0.c
            byte[] r1 = r1.a(r2)
            r0.i = r1
        L_0x002b:
            byte[] r1 = r0.i
            short[] r3 = r0.f
            r4 = 4096(0x1000, float:5.74E-42)
            if (r3 != 0) goto L_0x0037
            short[] r3 = new short[r4]
            r0.f = r3
        L_0x0037:
            short[] r3 = r0.f
            byte[] r5 = r0.g
            if (r5 != 0) goto L_0x0041
            byte[] r5 = new byte[r4]
            r0.g = r5
        L_0x0041:
            byte[] r5 = r0.g
            byte[] r6 = r0.h
            if (r6 != 0) goto L_0x004d
            r6 = 4097(0x1001, float:5.741E-42)
            byte[] r6 = new byte[r6]
            r0.h = r6
        L_0x004d:
            byte[] r6 = r0.h
            int r7 = r28.q()
            r8 = 1
            int r9 = r8 << r7
            int r10 = r9 + 1
            int r11 = r9 + 2
            int r7 = r7 + r8
            int r12 = r8 << r7
            int r12 = r12 - r8
            r13 = 0
            r14 = r13
        L_0x0060:
            if (r14 >= r9) goto L_0x006a
            r3[r14] = r13
            byte r15 = (byte) r14
            r5[r14] = r15
            int r14 = r14 + 1
            goto L_0x0060
        L_0x006a:
            byte[] r14 = r0.e
            r15 = -1
            r23 = r7
            r21 = r11
            r22 = r12
            r16 = r13
            r17 = r16
            r18 = r17
            r19 = r18
            r20 = r19
            r25 = r20
            r26 = r25
            r24 = r15
        L_0x0083:
            if (r13 >= r2) goto L_0x0090
            if (r16 != 0) goto L_0x0097
            int r16 = r28.p()
            if (r16 > 0) goto L_0x0095
            r3 = 3
            r0.o = r3
        L_0x0090:
            r13 = r20
            r0 = 0
            goto L_0x014f
        L_0x0095:
            r17 = 0
        L_0x0097:
            byte r4 = r14[r17]
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r4 = r4 << r18
            int r19 = r19 + r4
            int r18 = r18 + 8
            int r17 = r17 + 1
            int r16 = r16 + -1
            r4 = r18
            r8 = r21
            r15 = r23
            r0 = r24
            r23 = r7
            r7 = r25
        L_0x00b1:
            if (r4 < r15) goto L_0x0139
            r24 = r11
            r11 = r19 & r22
            int r19 = r19 >> r15
            int r4 = r4 - r15
            if (r11 != r9) goto L_0x00c5
            r22 = r12
            r15 = r23
            r8 = r24
            r11 = r8
            r0 = -1
            goto L_0x00b1
        L_0x00c5:
            if (r11 != r10) goto L_0x00dc
            r18 = r4
            r25 = r7
            r21 = r8
            r7 = r23
            r11 = r24
            r4 = 4096(0x1000, float:5.74E-42)
            r8 = 1
            r24 = r0
            r23 = r15
            r15 = -1
            r0 = r28
            goto L_0x0083
        L_0x00dc:
            r25 = r4
            r4 = -1
            if (r0 != r4) goto L_0x00f0
            byte r0 = r5[r11]
            r1[r20] = r0
            int r20 = r20 + 1
            int r13 = r13 + 1
            r0 = r11
            r7 = r0
            r11 = r24
            r4 = r25
            goto L_0x00b1
        L_0x00f0:
            if (r11 < r8) goto L_0x00f9
            byte r7 = (byte) r7
            r6[r26] = r7
            int r26 = r26 + 1
            r7 = r0
            goto L_0x00fa
        L_0x00f9:
            r7 = r11
        L_0x00fa:
            if (r7 < r9) goto L_0x0105
            byte r21 = r5[r7]
            r6[r26] = r21
            int r26 = r26 + 1
            short r7 = r3[r7]
            goto L_0x00fa
        L_0x0105:
            byte r7 = r5[r7]
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r4 = (byte) r7
            r1[r20] = r4
        L_0x010c:
            int r20 = r20 + 1
            int r13 = r13 + 1
            if (r26 <= 0) goto L_0x0119
            int r26 = r26 + -1
            byte r27 = r6[r26]
            r1[r20] = r27
            goto L_0x010c
        L_0x0119:
            r27 = r6
            r6 = 4096(0x1000, float:5.74E-42)
            if (r8 >= r6) goto L_0x0130
            short r0 = (short) r0
            r3[r8] = r0
            r5[r8] = r4
            int r8 = r8 + 1
            r0 = r8 & r22
            if (r0 != 0) goto L_0x0130
            if (r8 >= r6) goto L_0x0130
            int r15 = r15 + 1
            int r22 = r22 + r8
        L_0x0130:
            r0 = r11
            r11 = r24
            r4 = r25
            r6 = r27
            goto L_0x00b1
        L_0x0139:
            r25 = r4
            r24 = r0
            r21 = r8
            r18 = r25
            r4 = 4096(0x1000, float:5.74E-42)
            r8 = 1
            r0 = r28
            r25 = r7
            r7 = r23
            r23 = r15
            r15 = -1
            goto L_0x0083
        L_0x014f:
            java.util.Arrays.fill(r1, r13, r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.gifdecoder.StandardGifDecoder.m(com.bumptech.glide.gifdecoder.GifFrame):void");
    }

    public int n(int i2) {
        if (i2 >= 0) {
            GifHeader gifHeader = this.l;
            if (i2 < gifHeader.c) {
                return ((GifFrame) gifHeader.e.get(i2)).i;
            }
        }
        return -1;
    }

    public final Bitmap o() {
        Boolean bool = this.s;
        Bitmap b2 = this.c.b(this.r, this.q, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.t);
        b2.setHasAlpha(true);
        return b2;
    }

    public final int p() {
        int q2 = q();
        if (q2 <= 0) {
            return q2;
        }
        ByteBuffer byteBuffer = this.d;
        byteBuffer.get(this.e, 0, Math.min(q2, byteBuffer.remaining()));
        return q2;
    }

    public final int q() {
        return this.d.get() & 255;
    }

    public synchronized void r(GifHeader gifHeader, ByteBuffer byteBuffer, int i2) {
        if (i2 > 0) {
            try {
                int highestOneBit = Integer.highestOneBit(i2);
                this.o = 0;
                this.l = gifHeader;
                this.k = -1;
                ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
                this.d = asReadOnlyBuffer;
                asReadOnlyBuffer.position(0);
                this.d.order(ByteOrder.LITTLE_ENDIAN);
                this.n = false;
                Iterator it = gifHeader.e.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((GifFrame) it.next()).g == 3) {
                            this.n = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                this.p = highestOneBit;
                int i3 = gifHeader.f;
                this.r = i3 / highestOneBit;
                int i4 = gifHeader.g;
                this.q = i4 / highestOneBit;
                this.i = this.c.a(i3 * i4);
                this.j = this.c.d(this.r * this.q);
            } catch (Throwable th) {
                throw th;
            }
        } else {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i2);
        }
    }

    public final Bitmap s(GifFrame gifFrame, GifFrame gifFrame2) {
        int i2;
        int i3;
        Bitmap bitmap;
        int[] iArr = this.j;
        int i4 = 0;
        if (gifFrame2 == null) {
            Bitmap bitmap2 = this.m;
            if (bitmap2 != null) {
                this.c.c(bitmap2);
            }
            this.m = null;
            Arrays.fill(iArr, 0);
        }
        if (gifFrame2 != null && gifFrame2.g == 3 && this.m == null) {
            Arrays.fill(iArr, 0);
        }
        if (gifFrame2 != null && (i3 = gifFrame2.g) > 0) {
            if (i3 == 2) {
                if (!gifFrame.f) {
                    GifHeader gifHeader = this.l;
                    int i5 = gifHeader.l;
                    if (gifFrame.k == null || gifHeader.j != gifFrame.h) {
                        i4 = i5;
                    }
                }
                int i6 = gifFrame2.d;
                int i7 = this.p;
                int i8 = i6 / i7;
                int i9 = gifFrame2.b / i7;
                int i10 = gifFrame2.c / i7;
                int i11 = gifFrame2.f2440a / i7;
                int i12 = this.r;
                int i13 = (i9 * i12) + i11;
                int i14 = (i8 * i12) + i13;
                while (i13 < i14) {
                    int i15 = i13 + i10;
                    for (int i16 = i13; i16 < i15; i16++) {
                        iArr[i16] = i4;
                    }
                    i13 += this.r;
                }
            } else if (i3 == 3 && (bitmap = this.m) != null) {
                int i17 = this.r;
                bitmap.getPixels(iArr, 0, i17, 0, 0, i17, this.q);
            }
        }
        m(gifFrame);
        if (gifFrame.e || this.p != 1) {
            k(gifFrame);
        } else {
            l(gifFrame);
        }
        if (this.n && ((i2 = gifFrame.g) == 0 || i2 == 1)) {
            if (this.m == null) {
                this.m = o();
            }
            Bitmap bitmap3 = this.m;
            int i18 = this.r;
            bitmap3.setPixels(iArr, 0, i18, 0, 0, i18, this.q);
        }
        Bitmap o2 = o();
        int i19 = this.r;
        o2.setPixels(iArr, 0, i19, 0, 0, i19, this.q);
        return o2;
    }

    public StandardGifDecoder(GifDecoder.BitmapProvider bitmapProvider) {
        this.b = new int[256];
        this.t = Bitmap.Config.ARGB_8888;
        this.c = bitmapProvider;
        this.l = new GifHeader();
    }
}
