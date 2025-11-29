package com.xingin.xhssharesdk.a;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f8129a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g = Integer.MAX_VALUE;
    public int h;

    public f(byte[] bArr, int i, int i2, boolean z) {
        this.f8129a = bArr;
        this.b = i2 + i;
        this.d = i;
        this.f = -i;
    }

    public final int a() {
        int i = this.d;
        if (this.b - i >= 4) {
            byte[] bArr = this.f8129a;
            this.d = i + 4;
            return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24);
        }
        l(4);
        throw m.b();
    }

    public final void b(int i) {
        if (this.e != i) {
            throw new m("Protocol message end-group tag did not match expected tag.");
        }
    }

    public final int c(int i) {
        if (i >= 0) {
            int i2 = this.f + this.d + i;
            int i3 = this.g;
            if (i2 <= i3) {
                this.g = i2;
                m();
                return i3;
            }
            throw m.b();
        }
        throw new m("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public final long d() {
        int i = this.d;
        if (this.b - i >= 8) {
            byte[] bArr = this.f8129a;
            this.d = i + 8;
            return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
        }
        l(8);
        throw m.b();
    }

    public final int e() {
        byte b2;
        byte b3;
        int i = this.d;
        int i2 = this.b;
        if (i2 != i) {
            byte[] bArr = this.f8129a;
            int i3 = i + 1;
            byte b4 = bArr[i];
            if (b4 >= 0) {
                this.d = i3;
                return b4;
            } else if (i2 - i3 >= 9) {
                int i4 = i + 2;
                byte b5 = (bArr[i3] << 7) ^ b4;
                if (b5 < 0) {
                    b2 = b5 ^ Byte.MIN_VALUE;
                } else {
                    int i5 = i + 3;
                    byte b6 = (bArr[i4] << 14) ^ b5;
                    if (b6 >= 0) {
                        b3 = b6 ^ 16256;
                    } else {
                        int i6 = i + 4;
                        byte b7 = b6 ^ (bArr[i5] << 21);
                        if (b7 < 0) {
                            b2 = -2080896 ^ b7;
                        } else {
                            i5 = i + 5;
                            byte b8 = bArr[i6];
                            byte b9 = (b7 ^ (b8 << 28)) ^ 266354560;
                            if (b8 < 0) {
                                i6 = i + 6;
                                if (bArr[i5] < 0) {
                                    i5 = i + 7;
                                    if (bArr[i6] < 0) {
                                        i6 = i + 8;
                                        if (bArr[i5] < 0) {
                                            i5 = i + 9;
                                            if (bArr[i6] < 0) {
                                                int i7 = i + 10;
                                                if (bArr[i5] >= 0) {
                                                    byte b10 = b9;
                                                    i4 = i7;
                                                    b2 = b10;
                                                }
                                            }
                                        }
                                    }
                                }
                                b2 = b9;
                            }
                            b3 = b9;
                        }
                        i4 = i6;
                    }
                    i4 = i5;
                }
                this.d = i4;
                return b2;
            }
        }
        long j = 0;
        int i8 = 0;
        while (i8 < 64) {
            int i9 = this.d;
            if (i9 != this.b) {
                byte[] bArr2 = this.f8129a;
                this.d = i9 + 1;
                byte b11 = bArr2[i9];
                j |= ((long) (b11 & Byte.MAX_VALUE)) << i8;
                if ((b11 & 128) == 0) {
                    return (int) j;
                }
                i8 += 7;
            } else {
                l(1);
                throw m.b();
            }
        }
        throw new m("CodedInputStream encountered a malformed varint.");
    }

    public final byte[] f(int i) {
        if (i > 0) {
            int i2 = this.f;
            int i3 = this.d;
            int i4 = i2 + i3 + i;
            if (i4 <= 67108864) {
                int i5 = this.g;
                if (i4 <= i5) {
                    throw m.b();
                }
                j((i5 - i2) - i3);
                throw m.b();
            }
            throw new m("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
        } else if (i == 0) {
            return l.b;
        } else {
            throw new m("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
    }

    public final long g() {
        long j;
        long j2;
        long j3;
        int i = this.d;
        int i2 = this.b;
        long j4 = 0;
        if (i2 != i) {
            byte[] bArr = this.f8129a;
            int i3 = i + 1;
            byte b2 = bArr[i];
            if (b2 >= 0) {
                this.d = i3;
                return (long) b2;
            } else if (i2 - i3 >= 9) {
                int i4 = i + 2;
                byte b3 = (bArr[i3] << 7) ^ b2;
                if (b3 < 0) {
                    j = (long) (b3 ^ Byte.MIN_VALUE);
                } else {
                    int i5 = i + 3;
                    byte b4 = (bArr[i4] << 14) ^ b3;
                    if (b4 >= 0) {
                        j = (long) (b4 ^ 16256);
                        i4 = i5;
                    } else {
                        int i6 = i + 4;
                        byte b5 = b4 ^ (bArr[i5] << 21);
                        if (b5 < 0) {
                            j = (long) (-2080896 ^ b5);
                            i4 = i6;
                        } else {
                            long j5 = (long) b5;
                            int i7 = i + 5;
                            long j6 = j5 ^ (((long) bArr[i6]) << 28);
                            if (j6 >= 0) {
                                j3 = 266354560;
                            } else {
                                int i8 = i + 6;
                                long j7 = j6 ^ (((long) bArr[i7]) << 35);
                                if (j7 < 0) {
                                    j2 = -34093383808L;
                                } else {
                                    i7 = i + 7;
                                    j6 = j7 ^ (((long) bArr[i8]) << 42);
                                    if (j6 >= 0) {
                                        j3 = 4363953127296L;
                                    } else {
                                        i8 = i + 8;
                                        j7 = j6 ^ (((long) bArr[i7]) << 49);
                                        if (j7 < 0) {
                                            j2 = -558586000294016L;
                                        } else {
                                            i4 = i + 9;
                                            long j8 = (j7 ^ (((long) bArr[i8]) << 56)) ^ 71499008037633920L;
                                            if (j8 < 0) {
                                                int i9 = i + 10;
                                                if (((long) bArr[i4]) >= 0) {
                                                    i4 = i9;
                                                }
                                            }
                                            j = j8;
                                        }
                                    }
                                }
                                j = j7 ^ j2;
                                i4 = i8;
                            }
                            j = j3 ^ j6;
                        }
                    }
                }
                this.d = i4;
                return j;
            }
        }
        int i10 = 0;
        while (i10 < 64) {
            int i11 = this.d;
            if (i11 != this.b) {
                byte[] bArr2 = this.f8129a;
                this.d = i11 + 1;
                byte b6 = bArr2[i11];
                j4 |= ((long) (b6 & Byte.MAX_VALUE)) << i10;
                if ((b6 & 128) == 0) {
                    return j4;
                }
                i10 += 7;
            } else {
                l(1);
                throw m.b();
            }
        }
        throw new m("CodedInputStream encountered a malformed varint.");
    }

    public final boolean h(int i) {
        int i2;
        int k;
        int i3 = i & 7;
        int i4 = 0;
        if (i3 != 0) {
            if (i3 == 1) {
                i2 = 8;
            } else if (i3 == 2) {
                i2 = e();
            } else if (i3 == 3) {
                do {
                    k = k();
                    if (k == 0 || !h(k)) {
                    }
                    k = k();
                    break;
                } while (!h(k));
                if (this.e == c0.a(i >>> 3, 4)) {
                    return true;
                }
                throw new m("Protocol message end-group tag did not match expected tag.");
            } else if (i3 == 4) {
                return false;
            } else {
                if (i3 == 5) {
                    j(4);
                    return true;
                }
                throw new m("Protocol message tag had invalid wire type.");
            }
            j(i2);
            return true;
        }
        int i5 = this.b;
        int i6 = this.d;
        if (i5 - i6 >= 10) {
            byte[] bArr = this.f8129a;
            int i7 = 0;
            while (true) {
                if (i7 >= 10) {
                    break;
                }
                int i8 = i6 + 1;
                if (bArr[i6] >= 0) {
                    this.d = i8;
                    break;
                }
                i7++;
                i6 = i8;
            }
            return true;
        }
        while (i4 < 10) {
            int i9 = this.d;
            if (i9 != this.b) {
                byte[] bArr2 = this.f8129a;
                this.d = i9 + 1;
                if (bArr2[i9] >= 0) {
                    return true;
                }
                i4++;
            } else {
                l(1);
                throw m.b();
            }
        }
        throw new m("CodedInputStream encountered a malformed varint.");
    }

    public final String i() {
        byte[] bArr;
        int e2 = e();
        int i = this.d;
        int i2 = this.b;
        if (e2 <= i2 - i && e2 > 0) {
            bArr = this.f8129a;
            this.d = i + e2;
        } else if (e2 == 0) {
            return "";
        } else {
            if (e2 > i2) {
                bArr = f(e2);
                i = 0;
            } else {
                l(e2);
                throw m.b();
            }
        }
        if (b0.d(bArr, i, i + e2)) {
            return new String(bArr, i, e2, l.f8140a);
        }
        throw new m("Protocol message had invalid UTF-8.");
    }

    public final void j(int i) {
        int i2 = this.b;
        int i3 = this.d;
        if (i <= i2 - i3 && i >= 0) {
            this.d = i3 + i;
        } else if (i >= 0) {
            int i4 = this.f;
            int i5 = i4 + i3 + i;
            int i6 = this.g;
            if (i5 > i6) {
                j((i6 - i4) - i3);
                throw m.b();
            }
            this.d = i2;
            l(1);
            throw m.b();
        } else {
            throw new m("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
    }

    public final int k() {
        if (this.d == this.b) {
            l(1);
            this.e = 0;
            return 0;
        }
        int e2 = e();
        this.e = e2;
        if ((e2 >>> 3) != 0) {
            return e2;
        }
        throw new m("Protocol message contained an invalid tag (zero).");
    }

    public final void l(int i) {
        if (this.d + i <= this.b) {
            throw new IllegalStateException("refillBuffer() called when " + i + " bytes were already available in buffer");
        }
    }

    public final void m() {
        int i = this.b + this.c;
        this.b = i;
        int i2 = this.f + i;
        int i3 = this.g;
        if (i2 > i3) {
            int i4 = i2 - i3;
            this.c = i4;
            this.b = i - i4;
            return;
        }
        this.c = 0;
    }
}
