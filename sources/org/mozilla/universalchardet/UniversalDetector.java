package org.mozilla.universalchardet;

import java.io.File;
import java.io.InputStream;
import org.mozilla.universalchardet.prober.CharsetProber;
import org.mozilla.universalchardet.prober.EscCharsetProber;
import org.mozilla.universalchardet.prober.Latin1Prober;
import org.mozilla.universalchardet.prober.MBCSGroupProber;
import org.mozilla.universalchardet.prober.SBCSGroupProber;

public class UniversalDetector {

    /* renamed from: a  reason: collision with root package name */
    public InputState f3434a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e = true;
    public byte f;
    public String g;
    public CharsetProber[] h;
    public CharsetProber i;
    public CharsetListener j;

    public enum InputState {
        PURE_ASCII,
        ESC_ASCII,
        HIGHBYTE
    }

    public UniversalDetector(CharsetListener charsetListener) {
        this.j = charsetListener;
        this.i = null;
        this.h = new CharsetProber[3];
        i();
    }

    public static String b(File file) {
        return d(file.toPath());
    }

    public static String c(InputStream inputStream) {
        byte[] bArr = new byte[4096];
        UniversalDetector universalDetector = new UniversalDetector((CharsetListener) null);
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0 || universalDetector.h()) {
                universalDetector.a();
                String f2 = universalDetector.f();
                universalDetector.i();
            } else {
                universalDetector.g(bArr, 0, read);
            }
        }
        universalDetector.a();
        String f22 = universalDetector.f();
        universalDetector.i();
        return f22;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
        r2.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0016, code lost:
        r1 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String d(java.nio.file.Path r2) {
        /*
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream
            r1 = 0
            java.nio.file.OpenOption[] r1 = new java.nio.file.OpenOption[r1]
            java.io.InputStream r2 = java.nio.file.Files.newInputStream(r2, r1)
            r0.<init>(r2)
            java.lang.String r2 = c(r0)     // Catch:{ all -> 0x0014 }
            r0.close()
            return r2
        L_0x0014:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0016 }
        L_0x0016:
            r1 = move-exception
            r0.close()     // Catch:{ all -> 0x001b }
            goto L_0x001f
        L_0x001b:
            r0 = move-exception
            r2.addSuppressed(r0)
        L_0x001f:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.universalchardet.UniversalDetector.d(java.nio.file.Path):java.lang.String");
    }

    public static String e(byte[] bArr, int i2) {
        int i3 = i2 + 3;
        if (bArr.length <= i3) {
            return null;
        }
        byte b2 = bArr[i2] & 255;
        byte b3 = bArr[i2 + 1] & 255;
        byte b4 = bArr[i2 + 2] & 255;
        byte b5 = bArr[i3] & 255;
        if (b2 != 0) {
            if (b2 != 239) {
                if (b2 != 254) {
                    if (b2 != 255) {
                        return null;
                    }
                    if (b3 == 254 && b4 == 0 && b5 == 0) {
                        return Constants.y;
                    }
                    if (b3 == 254) {
                        return Constants.w;
                    }
                    return null;
                } else if (b3 == 255 && b4 == 0 && b5 == 0) {
                    return Constants.C;
                } else {
                    if (b3 == 255) {
                        return Constants.v;
                    }
                    return null;
                }
            } else if (b3 == 187 && b4 == 191) {
                return Constants.u;
            } else {
                return null;
            }
        } else if (b3 == 0 && b4 == 254 && b5 == 255) {
            return Constants.x;
        } else {
            if (b3 == 0 && b4 == 255 && b5 == 254) {
                return Constants.D;
            }
            return null;
        }
    }

    public void a() {
        CharsetProber[] charsetProberArr;
        if (this.d) {
            String str = this.g;
            if (str != null) {
                this.b = true;
                CharsetListener charsetListener = this.j;
                if (charsetListener != null) {
                    charsetListener.a(str);
                    return;
                }
                return;
            }
            InputState inputState = this.f3434a;
            if (inputState == InputState.HIGHBYTE) {
                int i2 = 0;
                float f2 = 0.0f;
                int i3 = 0;
                while (true) {
                    charsetProberArr = this.h;
                    if (i2 >= charsetProberArr.length) {
                        break;
                    }
                    float d2 = charsetProberArr[i2].d();
                    if (d2 > f2) {
                        i3 = i2;
                        f2 = d2;
                    }
                    i2++;
                }
                if (f2 > 0.2f) {
                    String c2 = charsetProberArr[i3].c();
                    this.g = c2;
                    CharsetListener charsetListener2 = this.j;
                    if (charsetListener2 != null) {
                        charsetListener2.a(c2);
                    }
                }
            } else if (inputState != InputState.ESC_ASCII && inputState == InputState.PURE_ASCII && this.e) {
                this.g = Constants.A;
            }
        }
    }

    public String f() {
        return this.g;
    }

    public void g(byte[] bArr, int i2, int i3) {
        String e2;
        if (!this.b) {
            if (i3 > 0) {
                this.d = true;
            }
            int i4 = 0;
            if (this.c) {
                this.c = false;
                if (i3 > 3 && (e2 = e(bArr, i2)) != null) {
                    this.g = e2;
                    this.b = true;
                    return;
                }
            }
            int i5 = i2 + i3;
            for (int i6 = i2; i6 < i5; i6++) {
                byte b2 = bArr[i6];
                byte b3 = b2 & 255;
                if ((b2 & 128) == 0 || b3 == 160) {
                    InputState inputState = this.f3434a;
                    InputState inputState2 = InputState.PURE_ASCII;
                    if (inputState == inputState2 && (b3 == 27 || (b3 == 123 && this.f == 126))) {
                        this.f3434a = InputState.ESC_ASCII;
                    }
                    if (this.f3434a == inputState2 && this.e) {
                        this.e = (b3 >= 32 && b3 <= 126) || b3 == 10 || b3 == 13 || b3 == 9;
                    }
                    this.f = b2;
                } else {
                    InputState inputState3 = this.f3434a;
                    InputState inputState4 = InputState.HIGHBYTE;
                    if (inputState3 != inputState4) {
                        this.f3434a = inputState4;
                        if (this.i != null) {
                            this.i = null;
                        }
                        CharsetProber[] charsetProberArr = this.h;
                        if (charsetProberArr[0] == null) {
                            charsetProberArr[0] = new MBCSGroupProber();
                        }
                        CharsetProber[] charsetProberArr2 = this.h;
                        if (charsetProberArr2[1] == null) {
                            charsetProberArr2[1] = new SBCSGroupProber();
                        }
                        CharsetProber[] charsetProberArr3 = this.h;
                        if (charsetProberArr3[2] == null) {
                            charsetProberArr3[2] = new Latin1Prober();
                        }
                    }
                }
            }
            InputState inputState5 = this.f3434a;
            if (inputState5 == InputState.ESC_ASCII) {
                if (this.i == null) {
                    this.i = new EscCharsetProber();
                }
                if (this.i.f(bArr, i2, i3) == CharsetProber.ProbingState.FOUND_IT) {
                    this.b = true;
                    this.g = this.i.c();
                }
            } else if (inputState5 == InputState.HIGHBYTE) {
                while (true) {
                    CharsetProber[] charsetProberArr4 = this.h;
                    if (i4 >= charsetProberArr4.length) {
                        return;
                    }
                    if (charsetProberArr4[i4].f(bArr, i2, i3) == CharsetProber.ProbingState.FOUND_IT) {
                        this.b = true;
                        this.g = this.h[i4].c();
                        return;
                    }
                    i4++;
                }
            }
        }
    }

    public boolean h() {
        return this.b;
    }

    public final void i() {
        int i2 = 0;
        this.b = false;
        this.c = true;
        this.g = null;
        this.d = false;
        this.f3434a = InputState.PURE_ASCII;
        this.f = 0;
        CharsetProber charsetProber = this.i;
        if (charsetProber != null) {
            charsetProber.j();
        }
        while (true) {
            CharsetProber[] charsetProberArr = this.h;
            if (i2 < charsetProberArr.length) {
                CharsetProber charsetProber2 = charsetProberArr[i2];
                if (charsetProber2 != null) {
                    charsetProber2.j();
                }
                i2++;
            } else {
                return;
            }
        }
    }
}
