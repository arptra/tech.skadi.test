package androidx.datastore.preferences.protobuf;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public abstract class CodedInputStream {

    /* renamed from: a  reason: collision with root package name */
    public int f1064a;
    public int b;
    public int c;
    public CodedInputStreamReader d;
    public boolean e;

    public static final class ArrayDecoder extends CodedInputStream {
        public final byte[] f;
        public final boolean g;
        public int h;
        public int i;
        public int j;
        public int k;
        public int l;
        public boolean m;
        public int n;

        public String A() {
            int K = K();
            if (K > 0) {
                int i2 = this.h;
                int i3 = this.j;
                if (K <= i2 - i3) {
                    String str = new String(this.f, i3, K, Internal.f1098a);
                    this.j += K;
                    return str;
                }
            }
            if (K == 0) {
                return "";
            }
            if (K < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public String B() {
            int K = K();
            if (K > 0) {
                int i2 = this.h;
                int i3 = this.j;
                if (K <= i2 - i3) {
                    String h2 = Utf8.h(this.f, i3, K);
                    this.j += K;
                    return h2;
                }
            }
            if (K == 0) {
                return "";
            }
            if (K <= 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public int C() {
            if (e()) {
                this.l = 0;
                return 0;
            }
            int K = K();
            this.l = K;
            if (WireFormat.a(K) != 0) {
                return this.l;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        public int D() {
            return K();
        }

        public long E() {
            return L();
        }

        public boolean F(int i2) {
            int b = WireFormat.b(i2);
            if (b == 0) {
                Q();
                return true;
            } else if (b == 1) {
                P(8);
                return true;
            } else if (b == 2) {
                P(K());
                return true;
            } else if (b == 3) {
                O();
                a(WireFormat.c(WireFormat.a(i2), 4));
                return true;
            } else if (b == 4) {
                return false;
            } else {
                if (b == 5) {
                    P(4);
                    return true;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        public byte G() {
            int i2 = this.j;
            if (i2 != this.h) {
                byte[] bArr = this.f;
                this.j = i2 + 1;
                return bArr[i2];
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public byte[] H(int i2) {
            if (i2 > 0) {
                int i3 = this.h;
                int i4 = this.j;
                if (i2 <= i3 - i4) {
                    int i5 = i2 + i4;
                    this.j = i5;
                    return Arrays.copyOfRange(this.f, i4, i5);
                }
            }
            if (i2 > 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            } else if (i2 == 0) {
                return Internal.c;
            } else {
                throw InvalidProtocolBufferException.negativeSize();
            }
        }

        public int I() {
            int i2 = this.j;
            if (this.h - i2 >= 4) {
                byte[] bArr = this.f;
                this.j = i2 + 4;
                return (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 24);
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public long J() {
            int i2 = this.j;
            if (this.h - i2 >= 8) {
                byte[] bArr = this.f;
                this.j = i2 + 8;
                return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public int K() {
            byte b;
            byte b2;
            int i2 = this.j;
            int i3 = this.h;
            if (i3 != i2) {
                byte[] bArr = this.f;
                int i4 = i2 + 1;
                byte b3 = bArr[i2];
                if (b3 >= 0) {
                    this.j = i4;
                    return b3;
                } else if (i3 - i4 >= 9) {
                    int i5 = i2 + 2;
                    byte b4 = (bArr[i4] << 7) ^ b3;
                    if (b4 < 0) {
                        b = b4 ^ Byte.MIN_VALUE;
                    } else {
                        int i6 = i2 + 3;
                        byte b5 = (bArr[i5] << 14) ^ b4;
                        if (b5 >= 0) {
                            b2 = b5 ^ 16256;
                        } else {
                            int i7 = i2 + 4;
                            byte b6 = b5 ^ (bArr[i6] << 21);
                            if (b6 < 0) {
                                b = -2080896 ^ b6;
                            } else {
                                i6 = i2 + 5;
                                byte b7 = bArr[i7];
                                byte b8 = (b6 ^ (b7 << 28)) ^ 266354560;
                                if (b7 < 0) {
                                    i7 = i2 + 6;
                                    if (bArr[i6] < 0) {
                                        i6 = i2 + 7;
                                        if (bArr[i7] < 0) {
                                            i7 = i2 + 8;
                                            if (bArr[i6] < 0) {
                                                i6 = i2 + 9;
                                                if (bArr[i7] < 0) {
                                                    int i8 = i2 + 10;
                                                    if (bArr[i6] >= 0) {
                                                        byte b9 = b8;
                                                        i5 = i8;
                                                        b = b9;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    b = b8;
                                }
                                b2 = b8;
                            }
                            i5 = i7;
                        }
                        i5 = i6;
                    }
                    this.j = i5;
                    return b;
                }
            }
            return (int) M();
        }

        public long L() {
            long j2;
            long j3;
            long j4;
            int i2 = this.j;
            int i3 = this.h;
            if (i3 != i2) {
                byte[] bArr = this.f;
                int i4 = i2 + 1;
                byte b = bArr[i2];
                if (b >= 0) {
                    this.j = i4;
                    return (long) b;
                } else if (i3 - i4 >= 9) {
                    int i5 = i2 + 2;
                    byte b2 = (bArr[i4] << 7) ^ b;
                    if (b2 < 0) {
                        j2 = (long) (b2 ^ Byte.MIN_VALUE);
                    } else {
                        int i6 = i2 + 3;
                        byte b3 = (bArr[i5] << 14) ^ b2;
                        if (b3 >= 0) {
                            j2 = (long) (b3 ^ 16256);
                            i5 = i6;
                        } else {
                            int i7 = i2 + 4;
                            byte b4 = b3 ^ (bArr[i6] << 21);
                            if (b4 < 0) {
                                i5 = i7;
                                j2 = (long) (-2080896 ^ b4);
                            } else {
                                long j5 = (long) b4;
                                int i8 = i2 + 5;
                                long j6 = j5 ^ (((long) bArr[i7]) << 28);
                                if (j6 >= 0) {
                                    j4 = 266354560;
                                } else {
                                    int i9 = i2 + 6;
                                    long j7 = j6 ^ (((long) bArr[i8]) << 35);
                                    if (j7 < 0) {
                                        j3 = -34093383808L;
                                    } else {
                                        i8 = i2 + 7;
                                        j6 = j7 ^ (((long) bArr[i9]) << 42);
                                        if (j6 >= 0) {
                                            j4 = 4363953127296L;
                                        } else {
                                            i9 = i2 + 8;
                                            j7 = j6 ^ (((long) bArr[i8]) << 49);
                                            if (j7 < 0) {
                                                j3 = -558586000294016L;
                                            } else {
                                                i5 = i2 + 9;
                                                long j8 = (j7 ^ (((long) bArr[i9]) << 56)) ^ 71499008037633920L;
                                                if (j8 < 0) {
                                                    int i10 = i2 + 10;
                                                    if (((long) bArr[i5]) >= 0) {
                                                        i5 = i10;
                                                    }
                                                }
                                                j2 = j8;
                                            }
                                        }
                                    }
                                    j2 = j7 ^ j3;
                                    i5 = i9;
                                }
                                j2 = j6 ^ j4;
                            }
                        }
                    }
                    this.j = i5;
                    return j2;
                }
            }
            return M();
        }

        public long M() {
            long j2 = 0;
            for (int i2 = 0; i2 < 64; i2 += 7) {
                byte G = G();
                j2 |= ((long) (G & Byte.MAX_VALUE)) << i2;
                if ((G & 128) == 0) {
                    return j2;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        public final void N() {
            int i2 = this.h + this.i;
            this.h = i2;
            int i3 = i2 - this.k;
            int i4 = this.n;
            if (i3 > i4) {
                int i5 = i3 - i4;
                this.i = i5;
                this.h = i2 - i5;
                return;
            }
            this.i = 0;
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public void O() {
            /*
                r1 = this;
            L_0x0000:
                int r0 = r1.C()
                if (r0 == 0) goto L_0x000c
                boolean r0 = r1.F(r0)
                if (r0 != 0) goto L_0x0000
            L_0x000c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.CodedInputStream.ArrayDecoder.O():void");
        }

        public void P(int i2) {
            if (i2 >= 0) {
                int i3 = this.h;
                int i4 = this.j;
                if (i2 <= i3 - i4) {
                    this.j = i4 + i2;
                    return;
                }
            }
            if (i2 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public final void Q() {
            if (this.h - this.j >= 10) {
                R();
            } else {
                S();
            }
        }

        public final void R() {
            int i2 = 0;
            while (i2 < 10) {
                byte[] bArr = this.f;
                int i3 = this.j;
                this.j = i3 + 1;
                if (bArr[i3] < 0) {
                    i2++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        public final void S() {
            int i2 = 0;
            while (i2 < 10) {
                if (G() < 0) {
                    i2++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        public void a(int i2) {
            if (this.l != i2) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        public int d() {
            return this.j - this.k;
        }

        public boolean e() {
            return this.j == this.h;
        }

        public void l(int i2) {
            this.n = i2;
            N();
        }

        public int m(int i2) {
            if (i2 >= 0) {
                int d = i2 + d();
                int i3 = this.n;
                if (d <= i3) {
                    this.n = d;
                    N();
                    return i3;
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        public boolean n() {
            return L() != 0;
        }

        public ByteString o() {
            int K = K();
            if (K > 0) {
                int i2 = this.h;
                int i3 = this.j;
                if (K <= i2 - i3) {
                    ByteString copyFrom = (!this.g || !this.m) ? ByteString.copyFrom(this.f, i3, K) : ByteString.wrap(this.f, i3, K);
                    this.j += K;
                    return copyFrom;
                }
            }
            return K == 0 ? ByteString.EMPTY : ByteString.wrap(H(K));
        }

        public double p() {
            return Double.longBitsToDouble(J());
        }

        public int q() {
            return K();
        }

        public int r() {
            return I();
        }

        public long s() {
            return J();
        }

        public float t() {
            return Float.intBitsToFloat(I());
        }

        public int u() {
            return K();
        }

        public long v() {
            return L();
        }

        public int w() {
            return I();
        }

        public long x() {
            return J();
        }

        public int y() {
            return CodedInputStream.b(K());
        }

        public long z() {
            return CodedInputStream.c(L());
        }

        public ArrayDecoder(byte[] bArr, int i2, int i3, boolean z) {
            super();
            this.n = Integer.MAX_VALUE;
            this.f = bArr;
            this.h = i3 + i2;
            this.j = i2;
            this.k = i2;
            this.g = z;
        }
    }

    public static final class IterableDirectByteBufferDecoder extends CodedInputStream {
        public Iterator f;
        public ByteBuffer g;
        public boolean h;
        public boolean i;
        public int j;
        public int k;
        public int l;
        public int m;
        public int n;
        public int o;
        public long p;
        public long q;
        public long r;
        public long s;

        private void P() {
            int i2 = this.j + this.k;
            this.j = i2;
            int i3 = i2 - this.o;
            int i4 = this.l;
            if (i3 > i4) {
                int i5 = i3 - i4;
                this.k = i5;
                this.j = i2 - i5;
                return;
            }
            this.k = 0;
        }

        private void T() {
            int i2 = 0;
            while (i2 < 10) {
                if (I() < 0) {
                    i2++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        public String A() {
            int M = M();
            if (M > 0) {
                long j2 = (long) M;
                long j3 = this.s;
                long j4 = this.p;
                if (j2 <= j3 - j4) {
                    byte[] bArr = new byte[M];
                    UnsafeUtil.n(j4, bArr, 0, j2);
                    String str = new String(bArr, Internal.f1098a);
                    this.p += j2;
                    return str;
                }
            }
            if (M > 0 && M <= Q()) {
                byte[] bArr2 = new byte[M];
                J(bArr2, 0, M);
                return new String(bArr2, Internal.f1098a);
            } else if (M == 0) {
                return "";
            } else {
                if (M < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        public String B() {
            int M = M();
            if (M > 0) {
                long j2 = (long) M;
                long j3 = this.s;
                long j4 = this.p;
                if (j2 <= j3 - j4) {
                    String g2 = Utf8.g(this.g, (int) (j4 - this.q), M);
                    this.p += j2;
                    return g2;
                }
            }
            if (M >= 0 && M <= Q()) {
                byte[] bArr = new byte[M];
                J(bArr, 0, M);
                return Utf8.h(bArr, 0, M);
            } else if (M == 0) {
                return "";
            } else {
                if (M <= 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        public int C() {
            if (e()) {
                this.m = 0;
                return 0;
            }
            int M = M();
            this.m = M;
            if (WireFormat.a(M) != 0) {
                return this.m;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        public int D() {
            return M();
        }

        public long E() {
            return N();
        }

        public boolean F(int i2) {
            int b = WireFormat.b(i2);
            if (b == 0) {
                T();
                return true;
            } else if (b == 1) {
                S(8);
                return true;
            } else if (b == 2) {
                S(M());
                return true;
            } else if (b == 3) {
                R();
                a(WireFormat.c(WireFormat.a(i2), 4));
                return true;
            } else if (b == 4) {
                return false;
            } else {
                if (b == 5) {
                    S(4);
                    return true;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        public final long G() {
            return this.s - this.p;
        }

        public final void H() {
            if (this.f.hasNext()) {
                V();
                return;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public byte I() {
            if (G() == 0) {
                H();
            }
            long j2 = this.p;
            this.p = 1 + j2;
            return UnsafeUtil.v(j2);
        }

        public final void J(byte[] bArr, int i2, int i3) {
            if (i3 >= 0 && i3 <= Q()) {
                int i4 = i3;
                while (i4 > 0) {
                    if (G() == 0) {
                        H();
                    }
                    int min = Math.min(i4, (int) G());
                    long j2 = (long) min;
                    UnsafeUtil.n(this.p, bArr, (long) ((i3 - i4) + i2), j2);
                    i4 -= min;
                    this.p += j2;
                }
            } else if (i3 > 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            } else if (i3 != 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
        }

        public int K() {
            if (G() >= 4) {
                long j2 = this.p;
                this.p = 4 + j2;
                return (UnsafeUtil.v(j2) & 255) | ((UnsafeUtil.v(1 + j2) & 255) << 8) | ((UnsafeUtil.v(2 + j2) & 255) << 16) | ((UnsafeUtil.v(j2 + 3) & 255) << 24);
            }
            return ((I() & 255) << 24) | (I() & 255) | ((I() & 255) << 8) | ((I() & 255) << 16);
        }

        public long L() {
            if (G() >= 8) {
                long j2 = this.p;
                this.p = 8 + j2;
                return (((long) UnsafeUtil.v(j2)) & 255) | ((((long) UnsafeUtil.v(1 + j2)) & 255) << 8) | ((((long) UnsafeUtil.v(2 + j2)) & 255) << 16) | ((((long) UnsafeUtil.v(3 + j2)) & 255) << 24) | ((((long) UnsafeUtil.v(4 + j2)) & 255) << 32) | ((((long) UnsafeUtil.v(5 + j2)) & 255) << 40) | ((((long) UnsafeUtil.v(6 + j2)) & 255) << 48) | ((((long) UnsafeUtil.v(j2 + 7)) & 255) << 56);
            }
            return ((((long) I()) & 255) << 56) | (((long) I()) & 255) | ((((long) I()) & 255) << 8) | ((((long) I()) & 255) << 16) | ((((long) I()) & 255) << 24) | ((((long) I()) & 255) << 32) | ((((long) I()) & 255) << 40) | ((((long) I()) & 255) << 48);
        }

        public int M() {
            byte b;
            byte b2;
            long j2 = this.p;
            if (this.s != j2) {
                long j3 = j2 + 1;
                byte v = UnsafeUtil.v(j2);
                if (v >= 0) {
                    this.p++;
                    return v;
                } else if (this.s - this.p >= 10) {
                    long j4 = 2 + j2;
                    byte v2 = (UnsafeUtil.v(j3) << 7) ^ v;
                    if (v2 < 0) {
                        b = v2 ^ Byte.MIN_VALUE;
                    } else {
                        long j5 = 3 + j2;
                        byte v3 = (UnsafeUtil.v(j4) << 14) ^ v2;
                        if (v3 >= 0) {
                            b2 = v3 ^ 16256;
                        } else {
                            long j6 = 4 + j2;
                            byte v4 = v3 ^ (UnsafeUtil.v(j5) << 21);
                            if (v4 < 0) {
                                b = -2080896 ^ v4;
                            } else {
                                j5 = 5 + j2;
                                byte v5 = UnsafeUtil.v(j6);
                                byte b3 = (v4 ^ (v5 << 28)) ^ 266354560;
                                if (v5 < 0) {
                                    j6 = 6 + j2;
                                    if (UnsafeUtil.v(j5) < 0) {
                                        j5 = 7 + j2;
                                        if (UnsafeUtil.v(j6) < 0) {
                                            j6 = 8 + j2;
                                            if (UnsafeUtil.v(j5) < 0) {
                                                j5 = 9 + j2;
                                                if (UnsafeUtil.v(j6) < 0) {
                                                    long j7 = j2 + 10;
                                                    if (UnsafeUtil.v(j5) >= 0) {
                                                        long j8 = j7;
                                                        b = b3;
                                                        j4 = j8;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    b = b3;
                                }
                                b2 = b3;
                            }
                            j4 = j6;
                        }
                        j4 = j5;
                    }
                    this.p = j4;
                    return b;
                }
            }
            return (int) O();
        }

        public long N() {
            long j2;
            long j3;
            long j4;
            long j5 = this.p;
            if (this.s != j5) {
                long j6 = j5 + 1;
                byte v = UnsafeUtil.v(j5);
                if (v >= 0) {
                    this.p++;
                    return (long) v;
                } else if (this.s - this.p >= 10) {
                    long j7 = 2 + j5;
                    byte v2 = (UnsafeUtil.v(j6) << 7) ^ v;
                    if (v2 < 0) {
                        j2 = (long) (v2 ^ Byte.MIN_VALUE);
                    } else {
                        long j8 = 3 + j5;
                        byte v3 = (UnsafeUtil.v(j7) << 14) ^ v2;
                        if (v3 >= 0) {
                            j2 = (long) (v3 ^ 16256);
                            j7 = j8;
                        } else {
                            long j9 = 4 + j5;
                            byte v4 = v3 ^ (UnsafeUtil.v(j8) << 21);
                            if (v4 < 0) {
                                j2 = (long) (-2080896 ^ v4);
                                j7 = j9;
                            } else {
                                long j10 = 5 + j5;
                                long v5 = (((long) UnsafeUtil.v(j9)) << 28) ^ ((long) v4);
                                if (v5 >= 0) {
                                    j4 = 266354560;
                                } else {
                                    long j11 = 6 + j5;
                                    long v6 = v5 ^ (((long) UnsafeUtil.v(j10)) << 35);
                                    if (v6 < 0) {
                                        j3 = -34093383808L;
                                    } else {
                                        j10 = 7 + j5;
                                        v5 = v6 ^ (((long) UnsafeUtil.v(j11)) << 42);
                                        if (v5 >= 0) {
                                            j4 = 4363953127296L;
                                        } else {
                                            j11 = 8 + j5;
                                            v6 = v5 ^ (((long) UnsafeUtil.v(j10)) << 49);
                                            if (v6 < 0) {
                                                j3 = -558586000294016L;
                                            } else {
                                                j10 = 9 + j5;
                                                long v7 = (v6 ^ (((long) UnsafeUtil.v(j11)) << 56)) ^ 71499008037633920L;
                                                if (v7 < 0) {
                                                    long j12 = j5 + 10;
                                                    if (((long) UnsafeUtil.v(j10)) >= 0) {
                                                        long j13 = j12;
                                                        j2 = v7;
                                                        j7 = j13;
                                                    }
                                                } else {
                                                    j2 = v7;
                                                    j7 = j10;
                                                }
                                            }
                                        }
                                    }
                                    j2 = j3 ^ v6;
                                    j7 = j11;
                                }
                                j2 = j4 ^ v5;
                                j7 = j10;
                            }
                        }
                    }
                    this.p = j7;
                    return j2;
                }
            }
            return O();
        }

        public long O() {
            long j2 = 0;
            for (int i2 = 0; i2 < 64; i2 += 7) {
                byte I = I();
                j2 |= ((long) (I & Byte.MAX_VALUE)) << i2;
                if ((I & 128) == 0) {
                    return j2;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        public final int Q() {
            return (int) ((((long) (this.j - this.n)) - this.p) + this.q);
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public void R() {
            /*
                r1 = this;
            L_0x0000:
                int r0 = r1.C()
                if (r0 == 0) goto L_0x000c
                boolean r0 = r1.F(r0)
                if (r0 != 0) goto L_0x0000
            L_0x000c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.CodedInputStream.IterableDirectByteBufferDecoder.R():void");
        }

        public void S(int i2) {
            if (i2 >= 0 && ((long) i2) <= (((long) (this.j - this.n)) - this.p) + this.q) {
                while (i2 > 0) {
                    if (G() == 0) {
                        H();
                    }
                    int min = Math.min(i2, (int) G());
                    i2 -= min;
                    this.p += (long) min;
                }
            } else if (i2 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            } else {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(3:6|7|8) */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0038, code lost:
            throw r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0027, code lost:
            r4 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x002d, code lost:
            throw androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.truncatedMessage();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x002e, code lost:
            r3.g.position(r0);
            r3.g.limit(r1);
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0029 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.nio.ByteBuffer U(int r4, int r5) {
            /*
                r3 = this;
                java.nio.ByteBuffer r0 = r3.g
                int r0 = r0.position()
                java.nio.ByteBuffer r1 = r3.g
                int r1 = r1.limit()
                java.nio.ByteBuffer r2 = r3.g     // Catch:{ IllegalArgumentException -> 0x0029 }
                r2.position(r4)     // Catch:{ IllegalArgumentException -> 0x0029 }
                java.nio.ByteBuffer r4 = r3.g     // Catch:{ IllegalArgumentException -> 0x0029 }
                r4.limit(r5)     // Catch:{ IllegalArgumentException -> 0x0029 }
                java.nio.ByteBuffer r4 = r3.g     // Catch:{ IllegalArgumentException -> 0x0029 }
                java.nio.ByteBuffer r4 = r4.slice()     // Catch:{ IllegalArgumentException -> 0x0029 }
                java.nio.ByteBuffer r5 = r3.g
                r5.position(r0)
                java.nio.ByteBuffer r3 = r3.g
                r3.limit(r1)
                return r4
            L_0x0027:
                r4 = move-exception
                goto L_0x002e
            L_0x0029:
                androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r4 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.truncatedMessage()     // Catch:{ all -> 0x0027 }
                throw r4     // Catch:{ all -> 0x0027 }
            L_0x002e:
                java.nio.ByteBuffer r5 = r3.g
                r5.position(r0)
                java.nio.ByteBuffer r3 = r3.g
                r3.limit(r1)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.CodedInputStream.IterableDirectByteBufferDecoder.U(int, int):java.nio.ByteBuffer");
        }

        public final void V() {
            ByteBuffer byteBuffer = (ByteBuffer) this.f.next();
            this.g = byteBuffer;
            this.n += (int) (this.p - this.q);
            long position = (long) byteBuffer.position();
            this.p = position;
            this.q = position;
            this.s = (long) this.g.limit();
            long i2 = UnsafeUtil.i(this.g);
            this.r = i2;
            this.p += i2;
            this.q += i2;
            this.s += i2;
        }

        public void a(int i2) {
            if (this.m != i2) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        public int d() {
            return (int) ((((long) (this.n - this.o)) + this.p) - this.q);
        }

        public boolean e() {
            return (((long) this.n) + this.p) - this.q == ((long) this.j);
        }

        public void l(int i2) {
            this.l = i2;
            P();
        }

        public int m(int i2) {
            if (i2 >= 0) {
                int d = i2 + d();
                int i3 = this.l;
                if (d <= i3) {
                    this.l = d;
                    P();
                    return i3;
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        public boolean n() {
            return N() != 0;
        }

        public ByteString o() {
            int M = M();
            if (M > 0) {
                long j2 = (long) M;
                long j3 = this.s;
                long j4 = this.p;
                if (j2 <= j3 - j4) {
                    if (!this.h || !this.i) {
                        byte[] bArr = new byte[M];
                        UnsafeUtil.n(j4, bArr, 0, j2);
                        this.p += j2;
                        return ByteString.wrap(bArr);
                    }
                    int i2 = (int) (j4 - this.r);
                    ByteString wrap = ByteString.wrap(U(i2, M + i2));
                    this.p += j2;
                    return wrap;
                }
            }
            if (M > 0 && M <= Q()) {
                byte[] bArr2 = new byte[M];
                J(bArr2, 0, M);
                return ByteString.wrap(bArr2);
            } else if (M == 0) {
                return ByteString.EMPTY;
            } else {
                if (M < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        public double p() {
            return Double.longBitsToDouble(L());
        }

        public int q() {
            return M();
        }

        public int r() {
            return K();
        }

        public long s() {
            return L();
        }

        public float t() {
            return Float.intBitsToFloat(K());
        }

        public int u() {
            return M();
        }

        public long v() {
            return N();
        }

        public int w() {
            return K();
        }

        public long x() {
            return L();
        }

        public int y() {
            return CodedInputStream.b(M());
        }

        public long z() {
            return CodedInputStream.c(N());
        }
    }

    public static final class StreamDecoder extends CodedInputStream {
        public final InputStream f;
        public final byte[] g;
        public int h;
        public int i;
        public int j;
        public int k;
        public int l;
        public int m;
        public RefillCallback n;

        public interface RefillCallback {
            void onRefill();
        }

        public class SkippedDataSink implements RefillCallback {

            /* renamed from: a  reason: collision with root package name */
            public int f1065a;
            public ByteArrayOutputStream b;
            public final /* synthetic */ StreamDecoder c;

            public void onRefill() {
                if (this.b == null) {
                    this.b = new ByteArrayOutputStream();
                }
                this.b.write(this.c.g, this.f1065a, this.c.j - this.f1065a);
                this.f1065a = 0;
            }
        }

        private void S() {
            int i2 = this.h + this.i;
            this.h = i2;
            int i3 = this.l + i2;
            int i4 = this.m;
            if (i3 > i4) {
                int i5 = i3 - i4;
                this.i = i5;
                this.h = i2 - i5;
                return;
            }
            this.i = 0;
        }

        private void X() {
            if (this.h - this.j >= 10) {
                Y();
            } else {
                Z();
            }
        }

        private void Y() {
            int i2 = 0;
            while (i2 < 10) {
                byte[] bArr = this.g;
                int i3 = this.j;
                this.j = i3 + 1;
                if (bArr[i3] < 0) {
                    i2++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void Z() {
            int i2 = 0;
            while (i2 < 10) {
                if (J() < 0) {
                    i2++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        public String A() {
            int P = P();
            if (P > 0) {
                int i2 = this.h;
                int i3 = this.j;
                if (P <= i2 - i3) {
                    String str = new String(this.g, i3, P, Internal.f1098a);
                    this.j += P;
                    return str;
                }
            }
            if (P == 0) {
                return "";
            }
            if (P > this.h) {
                return new String(K(P, false), Internal.f1098a);
            }
            T(P);
            String str2 = new String(this.g, this.j, P, Internal.f1098a);
            this.j += P;
            return str2;
        }

        public String B() {
            byte[] bArr;
            int P = P();
            int i2 = this.j;
            int i3 = this.h;
            if (P <= i3 - i2 && P > 0) {
                bArr = this.g;
                this.j = i2 + P;
            } else if (P == 0) {
                return "";
            } else {
                i2 = 0;
                if (P <= i3) {
                    T(P);
                    bArr = this.g;
                    this.j = P;
                } else {
                    bArr = K(P, false);
                }
            }
            return Utf8.h(bArr, i2, P);
        }

        public int C() {
            if (e()) {
                this.k = 0;
                return 0;
            }
            int P = P();
            this.k = P;
            if (WireFormat.a(P) != 0) {
                return this.k;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        public int D() {
            return P();
        }

        public long E() {
            return Q();
        }

        public boolean F(int i2) {
            int b = WireFormat.b(i2);
            if (b == 0) {
                X();
                return true;
            } else if (b == 1) {
                V(8);
                return true;
            } else if (b == 2) {
                V(P());
                return true;
            } else if (b == 3) {
                U();
                a(WireFormat.c(WireFormat.a(i2), 4));
                return true;
            } else if (b == 4) {
                return false;
            } else {
                if (b == 5) {
                    V(4);
                    return true;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        public final ByteString I(int i2) {
            byte[] L = L(i2);
            if (L != null) {
                return ByteString.copyFrom(L);
            }
            int i3 = this.j;
            int i4 = this.h;
            int i5 = i4 - i3;
            this.l += i4;
            this.j = 0;
            this.h = 0;
            List<byte[]> M = M(i2 - i5);
            byte[] bArr = new byte[i2];
            System.arraycopy(this.g, i3, bArr, 0, i5);
            for (byte[] bArr2 : M) {
                System.arraycopy(bArr2, 0, bArr, i5, bArr2.length);
                i5 += bArr2.length;
            }
            return ByteString.wrap(bArr);
        }

        public byte J() {
            if (this.j == this.h) {
                T(1);
            }
            byte[] bArr = this.g;
            int i2 = this.j;
            this.j = i2 + 1;
            return bArr[i2];
        }

        public final byte[] K(int i2, boolean z) {
            byte[] L = L(i2);
            if (L != null) {
                return z ? (byte[]) L.clone() : L;
            }
            int i3 = this.j;
            int i4 = this.h;
            int i5 = i4 - i3;
            this.l += i4;
            this.j = 0;
            this.h = 0;
            List<byte[]> M = M(i2 - i5);
            byte[] bArr = new byte[i2];
            System.arraycopy(this.g, i3, bArr, 0, i5);
            for (byte[] bArr2 : M) {
                System.arraycopy(bArr2, 0, bArr, i5, bArr2.length);
                i5 += bArr2.length;
            }
            return bArr;
        }

        public final byte[] L(int i2) {
            if (i2 == 0) {
                return Internal.c;
            }
            if (i2 >= 0) {
                int i3 = this.l;
                int i4 = this.j;
                int i5 = i3 + i4 + i2;
                if (i5 - this.c <= 0) {
                    int i6 = this.m;
                    if (i5 <= i6) {
                        int i7 = this.h - i4;
                        int i8 = i2 - i7;
                        if (i8 >= 4096 && i8 > this.f.available()) {
                            return null;
                        }
                        byte[] bArr = new byte[i2];
                        System.arraycopy(this.g, this.j, bArr, 0, i7);
                        this.l += this.h;
                        this.j = 0;
                        this.h = 0;
                        while (i7 < i2) {
                            int read = this.f.read(bArr, i7, i2 - i7);
                            if (read != -1) {
                                this.l += read;
                                i7 += read;
                            } else {
                                throw InvalidProtocolBufferException.truncatedMessage();
                            }
                        }
                        return bArr;
                    }
                    V((i6 - i3) - i4);
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                throw InvalidProtocolBufferException.sizeLimitExceeded();
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        public final List M(int i2) {
            ArrayList arrayList = new ArrayList();
            while (i2 > 0) {
                int min = Math.min(i2, 4096);
                byte[] bArr = new byte[min];
                int i3 = 0;
                while (i3 < min) {
                    int read = this.f.read(bArr, i3, min - i3);
                    if (read != -1) {
                        this.l += read;
                        i3 += read;
                    } else {
                        throw InvalidProtocolBufferException.truncatedMessage();
                    }
                }
                i2 -= min;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        public int N() {
            int i2 = this.j;
            if (this.h - i2 < 4) {
                T(4);
                i2 = this.j;
            }
            byte[] bArr = this.g;
            this.j = i2 + 4;
            return (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 24);
        }

        public long O() {
            int i2 = this.j;
            if (this.h - i2 < 8) {
                T(8);
                i2 = this.j;
            }
            byte[] bArr = this.g;
            this.j = i2 + 8;
            return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
        }

        public int P() {
            byte b;
            byte b2;
            int i2 = this.j;
            int i3 = this.h;
            if (i3 != i2) {
                byte[] bArr = this.g;
                int i4 = i2 + 1;
                byte b3 = bArr[i2];
                if (b3 >= 0) {
                    this.j = i4;
                    return b3;
                } else if (i3 - i4 >= 9) {
                    int i5 = i2 + 2;
                    byte b4 = (bArr[i4] << 7) ^ b3;
                    if (b4 < 0) {
                        b = b4 ^ Byte.MIN_VALUE;
                    } else {
                        int i6 = i2 + 3;
                        byte b5 = (bArr[i5] << 14) ^ b4;
                        if (b5 >= 0) {
                            b2 = b5 ^ 16256;
                        } else {
                            int i7 = i2 + 4;
                            byte b6 = b5 ^ (bArr[i6] << 21);
                            if (b6 < 0) {
                                b = -2080896 ^ b6;
                            } else {
                                i6 = i2 + 5;
                                byte b7 = bArr[i7];
                                byte b8 = (b6 ^ (b7 << 28)) ^ 266354560;
                                if (b7 < 0) {
                                    i7 = i2 + 6;
                                    if (bArr[i6] < 0) {
                                        i6 = i2 + 7;
                                        if (bArr[i7] < 0) {
                                            i7 = i2 + 8;
                                            if (bArr[i6] < 0) {
                                                i6 = i2 + 9;
                                                if (bArr[i7] < 0) {
                                                    int i8 = i2 + 10;
                                                    if (bArr[i6] >= 0) {
                                                        byte b9 = b8;
                                                        i5 = i8;
                                                        b = b9;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    b = b8;
                                }
                                b2 = b8;
                            }
                            i5 = i7;
                        }
                        i5 = i6;
                    }
                    this.j = i5;
                    return b;
                }
            }
            return (int) R();
        }

        public long Q() {
            long j2;
            long j3;
            long j4;
            int i2 = this.j;
            int i3 = this.h;
            if (i3 != i2) {
                byte[] bArr = this.g;
                int i4 = i2 + 1;
                byte b = bArr[i2];
                if (b >= 0) {
                    this.j = i4;
                    return (long) b;
                } else if (i3 - i4 >= 9) {
                    int i5 = i2 + 2;
                    byte b2 = (bArr[i4] << 7) ^ b;
                    if (b2 < 0) {
                        j2 = (long) (b2 ^ Byte.MIN_VALUE);
                    } else {
                        int i6 = i2 + 3;
                        byte b3 = (bArr[i5] << 14) ^ b2;
                        if (b3 >= 0) {
                            j2 = (long) (b3 ^ 16256);
                            i5 = i6;
                        } else {
                            int i7 = i2 + 4;
                            byte b4 = b3 ^ (bArr[i6] << 21);
                            if (b4 < 0) {
                                i5 = i7;
                                j2 = (long) (-2080896 ^ b4);
                            } else {
                                long j5 = (long) b4;
                                int i8 = i2 + 5;
                                long j6 = j5 ^ (((long) bArr[i7]) << 28);
                                if (j6 >= 0) {
                                    j4 = 266354560;
                                } else {
                                    int i9 = i2 + 6;
                                    long j7 = j6 ^ (((long) bArr[i8]) << 35);
                                    if (j7 < 0) {
                                        j3 = -34093383808L;
                                    } else {
                                        i8 = i2 + 7;
                                        j6 = j7 ^ (((long) bArr[i9]) << 42);
                                        if (j6 >= 0) {
                                            j4 = 4363953127296L;
                                        } else {
                                            i9 = i2 + 8;
                                            j7 = j6 ^ (((long) bArr[i8]) << 49);
                                            if (j7 < 0) {
                                                j3 = -558586000294016L;
                                            } else {
                                                i5 = i2 + 9;
                                                long j8 = (j7 ^ (((long) bArr[i9]) << 56)) ^ 71499008037633920L;
                                                if (j8 < 0) {
                                                    int i10 = i2 + 10;
                                                    if (((long) bArr[i5]) >= 0) {
                                                        i5 = i10;
                                                    }
                                                }
                                                j2 = j8;
                                            }
                                        }
                                    }
                                    j2 = j7 ^ j3;
                                    i5 = i9;
                                }
                                j2 = j6 ^ j4;
                            }
                        }
                    }
                    this.j = i5;
                    return j2;
                }
            }
            return R();
        }

        public long R() {
            long j2 = 0;
            for (int i2 = 0; i2 < 64; i2 += 7) {
                byte J = J();
                j2 |= ((long) (J & Byte.MAX_VALUE)) << i2;
                if ((J & 128) == 0) {
                    return j2;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        public final void T(int i2) {
            if (a0(i2)) {
                return;
            }
            if (i2 > (this.c - this.l) - this.j) {
                throw InvalidProtocolBufferException.sizeLimitExceeded();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public void U() {
            /*
                r1 = this;
            L_0x0000:
                int r0 = r1.C()
                if (r0 == 0) goto L_0x000c
                boolean r0 = r1.F(r0)
                if (r0 != 0) goto L_0x0000
            L_0x000c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.CodedInputStream.StreamDecoder.U():void");
        }

        public void V(int i2) {
            int i3 = this.h;
            int i4 = this.j;
            if (i2 > i3 - i4 || i2 < 0) {
                W(i2);
            } else {
                this.j = i4 + i2;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x005c, code lost:
            throw new java.lang.IllegalStateException(r8.f.getClass() + "#skip returned invalid result: " + r0 + "\nThe InputStream implementation is buggy.");
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void W(int r9) {
            /*
                r8 = this;
                if (r9 < 0) goto L_0x0097
                int r0 = r8.l
                int r1 = r8.j
                int r2 = r0 + r1
                int r2 = r2 + r9
                int r3 = r8.m
                if (r2 > r3) goto L_0x008d
                androidx.datastore.preferences.protobuf.CodedInputStream$StreamDecoder$RefillCallback r2 = r8.n
                r3 = 0
                if (r2 != 0) goto L_0x006f
                int r0 = r0 + r1
                r8.l = r0
                int r0 = r8.h
                int r0 = r0 - r1
                r8.h = r3
                r8.j = r3
                r3 = r0
            L_0x001d:
                if (r3 >= r9) goto L_0x0067
                int r0 = r9 - r3
                java.io.InputStream r1 = r8.f     // Catch:{ all -> 0x005d }
                long r4 = (long) r0     // Catch:{ all -> 0x005d }
                long r0 = r1.skip(r4)     // Catch:{ all -> 0x005d }
                r6 = 0
                int r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
                if (r2 < 0) goto L_0x0038
                int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                if (r4 > 0) goto L_0x0038
                if (r2 != 0) goto L_0x0035
                goto L_0x0067
            L_0x0035:
                int r0 = (int) r0     // Catch:{ all -> 0x005d }
                int r3 = r3 + r0
                goto L_0x001d
            L_0x0038:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x005d }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x005d }
                r2.<init>()     // Catch:{ all -> 0x005d }
                java.io.InputStream r4 = r8.f     // Catch:{ all -> 0x005d }
                java.lang.Class r4 = r4.getClass()     // Catch:{ all -> 0x005d }
                r2.append(r4)     // Catch:{ all -> 0x005d }
                java.lang.String r4 = "#skip returned invalid result: "
                r2.append(r4)     // Catch:{ all -> 0x005d }
                r2.append(r0)     // Catch:{ all -> 0x005d }
                java.lang.String r0 = "\nThe InputStream implementation is buggy."
                r2.append(r0)     // Catch:{ all -> 0x005d }
                java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x005d }
                r9.<init>(r0)     // Catch:{ all -> 0x005d }
                throw r9     // Catch:{ all -> 0x005d }
            L_0x005d:
                r9 = move-exception
                int r0 = r8.l
                int r0 = r0 + r3
                r8.l = r0
                r8.S()
                throw r9
            L_0x0067:
                int r0 = r8.l
                int r0 = r0 + r3
                r8.l = r0
                r8.S()
            L_0x006f:
                if (r3 >= r9) goto L_0x008c
                int r0 = r8.h
                int r1 = r8.j
                int r1 = r0 - r1
                r8.j = r0
                r0 = 1
                r8.T(r0)
            L_0x007d:
                int r2 = r9 - r1
                int r3 = r8.h
                if (r2 <= r3) goto L_0x008a
                int r1 = r1 + r3
                r8.j = r3
                r8.T(r0)
                goto L_0x007d
            L_0x008a:
                r8.j = r2
            L_0x008c:
                return
            L_0x008d:
                int r3 = r3 - r0
                int r3 = r3 - r1
                r8.V(r3)
                androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r8 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.truncatedMessage()
                throw r8
            L_0x0097:
                androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r8 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.negativeSize()
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.CodedInputStream.StreamDecoder.W(int):void");
        }

        public void a(int i2) {
            if (this.k != i2) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        public final boolean a0(int i2) {
            int i3 = this.j;
            if (i3 + i2 > this.h) {
                int i4 = this.c;
                int i5 = this.l;
                if (i2 > (i4 - i5) - i3 || i5 + i3 + i2 > this.m) {
                    return false;
                }
                RefillCallback refillCallback = this.n;
                if (refillCallback != null) {
                    refillCallback.onRefill();
                }
                int i6 = this.j;
                if (i6 > 0) {
                    int i7 = this.h;
                    if (i7 > i6) {
                        byte[] bArr = this.g;
                        System.arraycopy(bArr, i6, bArr, 0, i7 - i6);
                    }
                    this.l += i6;
                    this.h -= i6;
                    this.j = 0;
                }
                InputStream inputStream = this.f;
                byte[] bArr2 = this.g;
                int i8 = this.h;
                int read = inputStream.read(bArr2, i8, Math.min(bArr2.length - i8, (this.c - this.l) - i8));
                if (read == 0 || read < -1 || read > this.g.length) {
                    throw new IllegalStateException(this.f.getClass() + "#read(byte[]) returned invalid result: " + read + "\nThe InputStream implementation is buggy.");
                } else if (read <= 0) {
                    return false;
                } else {
                    this.h += read;
                    S();
                    if (this.h >= i2) {
                        return true;
                    }
                    return a0(i2);
                }
            } else {
                throw new IllegalStateException("refillBuffer() called when " + i2 + " bytes were already available in buffer");
            }
        }

        public int d() {
            return this.l + this.j;
        }

        public boolean e() {
            return this.j == this.h && !a0(1);
        }

        public void l(int i2) {
            this.m = i2;
            S();
        }

        public int m(int i2) {
            if (i2 >= 0) {
                int i3 = i2 + this.l + this.j;
                int i4 = this.m;
                if (i3 <= i4) {
                    this.m = i3;
                    S();
                    return i4;
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        public boolean n() {
            return Q() != 0;
        }

        public ByteString o() {
            int P = P();
            int i2 = this.h;
            int i3 = this.j;
            if (P > i2 - i3 || P <= 0) {
                return P == 0 ? ByteString.EMPTY : I(P);
            }
            ByteString copyFrom = ByteString.copyFrom(this.g, i3, P);
            this.j += P;
            return copyFrom;
        }

        public double p() {
            return Double.longBitsToDouble(O());
        }

        public int q() {
            return P();
        }

        public int r() {
            return N();
        }

        public long s() {
            return O();
        }

        public float t() {
            return Float.intBitsToFloat(N());
        }

        public int u() {
            return P();
        }

        public long v() {
            return Q();
        }

        public int w() {
            return N();
        }

        public long x() {
            return O();
        }

        public int y() {
            return CodedInputStream.b(P());
        }

        public long z() {
            return CodedInputStream.c(Q());
        }

        public StreamDecoder(InputStream inputStream, int i2) {
            super();
            this.m = Integer.MAX_VALUE;
            this.n = null;
            Internal.b(inputStream, "input");
            this.f = inputStream;
            this.g = new byte[i2];
            this.h = 0;
            this.j = 0;
            this.l = 0;
        }
    }

    public static final class UnsafeDirectNioDecoder extends CodedInputStream {
        public final ByteBuffer f;
        public final boolean g;
        public final long h;
        public long i;
        public long j;
        public long k;
        public int l;
        public int m;
        public boolean n;
        public int o;

        public static boolean H() {
            return UnsafeUtil.I();
        }

        private void O() {
            long j2 = this.i + ((long) this.l);
            this.i = j2;
            int i2 = (int) (j2 - this.k);
            int i3 = this.o;
            if (i2 > i3) {
                int i4 = i2 - i3;
                this.l = i4;
                this.i = j2 - ((long) i4);
                return;
            }
            this.l = 0;
        }

        private int P() {
            return (int) (this.i - this.j);
        }

        private void S() {
            if (P() >= 10) {
                T();
            } else {
                U();
            }
        }

        private void T() {
            int i2 = 0;
            while (i2 < 10) {
                long j2 = this.j;
                this.j = 1 + j2;
                if (UnsafeUtil.v(j2) < 0) {
                    i2++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void U() {
            int i2 = 0;
            while (i2 < 10) {
                if (I() < 0) {
                    i2++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        public String A() {
            int L = L();
            if (L > 0 && L <= P()) {
                byte[] bArr = new byte[L];
                long j2 = (long) L;
                UnsafeUtil.n(this.j, bArr, 0, j2);
                String str = new String(bArr, Internal.f1098a);
                this.j += j2;
                return str;
            } else if (L == 0) {
                return "";
            } else {
                if (L < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        public String B() {
            int L = L();
            if (L > 0 && L <= P()) {
                String g2 = Utf8.g(this.f, G(this.j), L);
                this.j += (long) L;
                return g2;
            } else if (L == 0) {
                return "";
            } else {
                if (L <= 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        public int C() {
            if (e()) {
                this.m = 0;
                return 0;
            }
            int L = L();
            this.m = L;
            if (WireFormat.a(L) != 0) {
                return this.m;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        public int D() {
            return L();
        }

        public long E() {
            return M();
        }

        public boolean F(int i2) {
            int b = WireFormat.b(i2);
            if (b == 0) {
                S();
                return true;
            } else if (b == 1) {
                R(8);
                return true;
            } else if (b == 2) {
                R(L());
                return true;
            } else if (b == 3) {
                Q();
                a(WireFormat.c(WireFormat.a(i2), 4));
                return true;
            } else if (b == 4) {
                return false;
            } else {
                if (b == 5) {
                    R(4);
                    return true;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        public final int G(long j2) {
            return (int) (j2 - this.h);
        }

        public byte I() {
            long j2 = this.j;
            if (j2 != this.i) {
                this.j = 1 + j2;
                return UnsafeUtil.v(j2);
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public int J() {
            long j2 = this.j;
            if (this.i - j2 >= 4) {
                this.j = 4 + j2;
                return (UnsafeUtil.v(j2) & 255) | ((UnsafeUtil.v(1 + j2) & 255) << 8) | ((UnsafeUtil.v(2 + j2) & 255) << 16) | ((UnsafeUtil.v(j2 + 3) & 255) << 24);
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public long K() {
            long j2 = this.j;
            if (this.i - j2 >= 8) {
                this.j = 8 + j2;
                return ((((long) UnsafeUtil.v(j2 + 7)) & 255) << 56) | (((long) UnsafeUtil.v(j2)) & 255) | ((((long) UnsafeUtil.v(1 + j2)) & 255) << 8) | ((((long) UnsafeUtil.v(2 + j2)) & 255) << 16) | ((((long) UnsafeUtil.v(3 + j2)) & 255) << 24) | ((((long) UnsafeUtil.v(4 + j2)) & 255) << 32) | ((((long) UnsafeUtil.v(5 + j2)) & 255) << 40) | ((((long) UnsafeUtil.v(6 + j2)) & 255) << 48);
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x008c, code lost:
            if (androidx.datastore.preferences.protobuf.UnsafeUtil.v(r3) < 0) goto L_0x008e;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int L() {
            /*
                r9 = this;
                long r0 = r9.j
                long r2 = r9.i
                int r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r2 != 0) goto L_0x000a
                goto L_0x008e
            L_0x000a:
                r2 = 1
                long r2 = r2 + r0
                byte r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.v(r0)
                if (r4 < 0) goto L_0x0016
                r9.j = r2
                return r4
            L_0x0016:
                long r5 = r9.i
                long r5 = r5 - r2
                r7 = 9
                int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r5 >= 0) goto L_0x0021
                goto L_0x008e
            L_0x0021:
                r5 = 2
                long r5 = r5 + r0
                byte r2 = androidx.datastore.preferences.protobuf.UnsafeUtil.v(r2)
                int r2 = r2 << 7
                r2 = r2 ^ r4
                if (r2 >= 0) goto L_0x0031
                r0 = r2 ^ -128(0xffffffffffffff80, float:NaN)
                goto L_0x0098
            L_0x0031:
                r3 = 3
                long r3 = r3 + r0
                byte r5 = androidx.datastore.preferences.protobuf.UnsafeUtil.v(r5)
                int r5 = r5 << 14
                r2 = r2 ^ r5
                if (r2 < 0) goto L_0x0041
                r0 = r2 ^ 16256(0x3f80, float:2.278E-41)
            L_0x003f:
                r5 = r3
                goto L_0x0098
            L_0x0041:
                r5 = 4
                long r5 = r5 + r0
                byte r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.v(r3)
                int r3 = r3 << 21
                r2 = r2 ^ r3
                if (r2 >= 0) goto L_0x0052
                r0 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L_0x0098
            L_0x0052:
                r3 = 5
                long r3 = r3 + r0
                byte r5 = androidx.datastore.preferences.protobuf.UnsafeUtil.v(r5)
                int r6 = r5 << 28
                r2 = r2 ^ r6
                r6 = 266354560(0xfe03f80, float:2.2112565E-29)
                r2 = r2 ^ r6
                if (r5 >= 0) goto L_0x0096
                r5 = 6
                long r5 = r5 + r0
                byte r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.v(r3)
                if (r3 >= 0) goto L_0x0094
                r3 = 7
                long r3 = r3 + r0
                byte r5 = androidx.datastore.preferences.protobuf.UnsafeUtil.v(r5)
                if (r5 >= 0) goto L_0x0096
                r5 = 8
                long r5 = r5 + r0
                byte r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.v(r3)
                if (r3 >= 0) goto L_0x0094
                long r3 = r0 + r7
                byte r5 = androidx.datastore.preferences.protobuf.UnsafeUtil.v(r5)
                if (r5 >= 0) goto L_0x0096
                r5 = 10
                long r5 = r5 + r0
                byte r0 = androidx.datastore.preferences.protobuf.UnsafeUtil.v(r3)
                if (r0 >= 0) goto L_0x0094
            L_0x008e:
                long r0 = r9.N()
                int r9 = (int) r0
                return r9
            L_0x0094:
                r0 = r2
                goto L_0x0098
            L_0x0096:
                r0 = r2
                goto L_0x003f
            L_0x0098:
                r9.j = r5
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.CodedInputStream.UnsafeDirectNioDecoder.L():int");
        }

        public long M() {
            long j2;
            long j3;
            long j4;
            byte b;
            long j5 = this.j;
            if (this.i != j5) {
                long j6 = 1 + j5;
                byte v = UnsafeUtil.v(j5);
                if (v >= 0) {
                    this.j = j6;
                    return (long) v;
                } else if (this.i - j6 >= 9) {
                    long j7 = 2 + j5;
                    byte v2 = (UnsafeUtil.v(j6) << 7) ^ v;
                    if (v2 < 0) {
                        b = v2 ^ Byte.MIN_VALUE;
                    } else {
                        long j8 = 3 + j5;
                        byte v3 = v2 ^ (UnsafeUtil.v(j7) << 14);
                        if (v3 >= 0) {
                            j2 = (long) (v3 ^ 16256);
                            j7 = j8;
                        } else {
                            j7 = 4 + j5;
                            byte v4 = v3 ^ (UnsafeUtil.v(j8) << 21);
                            if (v4 < 0) {
                                b = -2080896 ^ v4;
                            } else {
                                long j9 = 5 + j5;
                                long v5 = ((long) v4) ^ (((long) UnsafeUtil.v(j7)) << 28);
                                if (v5 >= 0) {
                                    j4 = 266354560;
                                } else {
                                    long j10 = 6 + j5;
                                    long v6 = v5 ^ (((long) UnsafeUtil.v(j9)) << 35);
                                    if (v6 < 0) {
                                        j3 = -34093383808L;
                                    } else {
                                        j9 = 7 + j5;
                                        v5 = v6 ^ (((long) UnsafeUtil.v(j10)) << 42);
                                        if (v5 >= 0) {
                                            j4 = 4363953127296L;
                                        } else {
                                            j10 = 8 + j5;
                                            v6 = v5 ^ (((long) UnsafeUtil.v(j9)) << 49);
                                            if (v6 < 0) {
                                                j3 = -558586000294016L;
                                            } else {
                                                long j11 = j5 + 9;
                                                long v7 = (v6 ^ (((long) UnsafeUtil.v(j10)) << 56)) ^ 71499008037633920L;
                                                if (v7 < 0) {
                                                    long j12 = j5 + 10;
                                                    if (((long) UnsafeUtil.v(j11)) >= 0) {
                                                        j7 = j12;
                                                        j2 = v7;
                                                    }
                                                } else {
                                                    j2 = v7;
                                                    j7 = j11;
                                                }
                                            }
                                        }
                                    }
                                    j2 = j3 ^ v6;
                                    j7 = j10;
                                }
                                j2 = j4 ^ v5;
                                j7 = j9;
                            }
                        }
                        this.j = j7;
                        return j2;
                    }
                    j2 = (long) b;
                    this.j = j7;
                    return j2;
                }
            }
            return N();
        }

        public long N() {
            long j2 = 0;
            for (int i2 = 0; i2 < 64; i2 += 7) {
                byte I = I();
                j2 |= ((long) (I & Byte.MAX_VALUE)) << i2;
                if ((I & 128) == 0) {
                    return j2;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public void Q() {
            /*
                r1 = this;
            L_0x0000:
                int r0 = r1.C()
                if (r0 == 0) goto L_0x000c
                boolean r0 = r1.F(r0)
                if (r0 != 0) goto L_0x0000
            L_0x000c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.CodedInputStream.UnsafeDirectNioDecoder.Q():void");
        }

        public void R(int i2) {
            if (i2 >= 0 && i2 <= P()) {
                this.j += (long) i2;
            } else if (i2 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            } else {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0040, code lost:
            throw r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x002f, code lost:
            r4 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0035, code lost:
            throw androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.truncatedMessage();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0036, code lost:
            r3.f.position(r0);
            r3.f.limit(r1);
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0031 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.nio.ByteBuffer V(long r4, long r6) {
            /*
                r3 = this;
                java.nio.ByteBuffer r0 = r3.f
                int r0 = r0.position()
                java.nio.ByteBuffer r1 = r3.f
                int r1 = r1.limit()
                java.nio.ByteBuffer r2 = r3.f     // Catch:{ IllegalArgumentException -> 0x0031 }
                int r4 = r3.G(r4)     // Catch:{ IllegalArgumentException -> 0x0031 }
                r2.position(r4)     // Catch:{ IllegalArgumentException -> 0x0031 }
                java.nio.ByteBuffer r4 = r3.f     // Catch:{ IllegalArgumentException -> 0x0031 }
                int r5 = r3.G(r6)     // Catch:{ IllegalArgumentException -> 0x0031 }
                r4.limit(r5)     // Catch:{ IllegalArgumentException -> 0x0031 }
                java.nio.ByteBuffer r4 = r3.f     // Catch:{ IllegalArgumentException -> 0x0031 }
                java.nio.ByteBuffer r4 = r4.slice()     // Catch:{ IllegalArgumentException -> 0x0031 }
                java.nio.ByteBuffer r5 = r3.f
                r5.position(r0)
                java.nio.ByteBuffer r3 = r3.f
                r3.limit(r1)
                return r4
            L_0x002f:
                r4 = move-exception
                goto L_0x0036
            L_0x0031:
                androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r4 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.truncatedMessage()     // Catch:{ all -> 0x002f }
                throw r4     // Catch:{ all -> 0x002f }
            L_0x0036:
                java.nio.ByteBuffer r5 = r3.f
                r5.position(r0)
                java.nio.ByteBuffer r3 = r3.f
                r3.limit(r1)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.CodedInputStream.UnsafeDirectNioDecoder.V(long, long):java.nio.ByteBuffer");
        }

        public void a(int i2) {
            if (this.m != i2) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        public int d() {
            return (int) (this.j - this.k);
        }

        public boolean e() {
            return this.j == this.i;
        }

        public void l(int i2) {
            this.o = i2;
            O();
        }

        public int m(int i2) {
            if (i2 >= 0) {
                int d = i2 + d();
                int i3 = this.o;
                if (d <= i3) {
                    this.o = d;
                    O();
                    return i3;
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        public boolean n() {
            return M() != 0;
        }

        public ByteString o() {
            int L = L();
            if (L <= 0 || L > P()) {
                if (L == 0) {
                    return ByteString.EMPTY;
                }
                if (L < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            } else if (!this.g || !this.n) {
                byte[] bArr = new byte[L];
                long j2 = (long) L;
                UnsafeUtil.n(this.j, bArr, 0, j2);
                this.j += j2;
                return ByteString.wrap(bArr);
            } else {
                long j3 = this.j;
                long j4 = (long) L;
                ByteBuffer V = V(j3, j3 + j4);
                this.j += j4;
                return ByteString.wrap(V);
            }
        }

        public double p() {
            return Double.longBitsToDouble(K());
        }

        public int q() {
            return L();
        }

        public int r() {
            return J();
        }

        public long s() {
            return K();
        }

        public float t() {
            return Float.intBitsToFloat(J());
        }

        public int u() {
            return L();
        }

        public long v() {
            return M();
        }

        public int w() {
            return J();
        }

        public long x() {
            return K();
        }

        public int y() {
            return CodedInputStream.b(L());
        }

        public long z() {
            return CodedInputStream.c(M());
        }

        public UnsafeDirectNioDecoder(ByteBuffer byteBuffer, boolean z) {
            super();
            this.o = Integer.MAX_VALUE;
            this.f = byteBuffer;
            long i2 = UnsafeUtil.i(byteBuffer);
            this.h = i2;
            this.i = ((long) byteBuffer.limit()) + i2;
            long position = i2 + ((long) byteBuffer.position());
            this.j = position;
            this.k = position;
            this.g = z;
        }
    }

    public static int b(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long c(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static CodedInputStream f(InputStream inputStream) {
        return g(inputStream, 4096);
    }

    public static CodedInputStream g(InputStream inputStream, int i) {
        if (i > 0) {
            return inputStream == null ? i(Internal.c) : new StreamDecoder(inputStream, i);
        }
        throw new IllegalArgumentException("bufferSize must be > 0");
    }

    public static CodedInputStream h(ByteBuffer byteBuffer, boolean z) {
        if (byteBuffer.hasArray()) {
            return k(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining(), z);
        }
        if (byteBuffer.isDirect() && UnsafeDirectNioDecoder.H()) {
            return new UnsafeDirectNioDecoder(byteBuffer, z);
        }
        int remaining = byteBuffer.remaining();
        byte[] bArr = new byte[remaining];
        byteBuffer.duplicate().get(bArr);
        return k(bArr, 0, remaining, true);
    }

    public static CodedInputStream i(byte[] bArr) {
        return j(bArr, 0, bArr.length);
    }

    public static CodedInputStream j(byte[] bArr, int i, int i2) {
        return k(bArr, i, i2, false);
    }

    public static CodedInputStream k(byte[] bArr, int i, int i2, boolean z) {
        ArrayDecoder arrayDecoder = new ArrayDecoder(bArr, i, i2, z);
        try {
            arrayDecoder.m(i2);
            return arrayDecoder;
        } catch (InvalidProtocolBufferException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public abstract String A();

    public abstract String B();

    public abstract int C();

    public abstract int D();

    public abstract long E();

    public abstract boolean F(int i);

    public abstract void a(int i);

    public abstract int d();

    public abstract boolean e();

    public abstract void l(int i);

    public abstract int m(int i);

    public abstract boolean n();

    public abstract ByteString o();

    public abstract double p();

    public abstract int q();

    public abstract int r();

    public abstract long s();

    public abstract float t();

    public abstract int u();

    public abstract long v();

    public abstract int w();

    public abstract long x();

    public abstract int y();

    public abstract long z();

    public CodedInputStream() {
        this.b = 100;
        this.c = Integer.MAX_VALUE;
        this.e = false;
    }
}
