package org.mozilla.universalchardet.prober;

import org.mozilla.universalchardet.prober.CharsetProber;
import org.mozilla.universalchardet.prober.sequence.SequenceModel;

public class SingleByteCharsetProber extends CharsetProber {
    public CharsetProber.ProbingState b;
    public SequenceModel c;
    public boolean d;
    public short e;
    public int f;
    public int[] g;
    public int h;
    public int i;
    public CharsetProber j;

    public SingleByteCharsetProber(SequenceModel sequenceModel) {
        this.c = sequenceModel;
        this.d = false;
        this.j = null;
        this.g = new int[4];
        j();
    }

    public String c() {
        CharsetProber charsetProber = this.j;
        return charsetProber == null ? this.c.a() : charsetProber.c();
    }

    public float d() {
        int i2 = this.f;
        if (i2 <= 0) {
            return 0.01f;
        }
        float d2 = ((((((float) this.g[3]) * 1.0f) / ((float) i2)) / this.c.d()) * ((float) this.i)) / ((float) this.h);
        if (d2 >= 1.0f) {
            return 0.99f;
        }
        return d2;
    }

    public CharsetProber.ProbingState e() {
        return this.b;
    }

    public CharsetProber.ProbingState f(byte[] bArr, int i2, int i3) {
        int i4 = i3 + i2;
        while (i2 < i4) {
            short b2 = this.c.b(bArr[i2]);
            if (b2 < 250) {
                this.h++;
            }
            if (b2 < 64) {
                this.i++;
                short s = this.e;
                if (s < 64) {
                    this.f++;
                    if (!this.d) {
                        int[] iArr = this.g;
                        byte c2 = this.c.c((s * 64) + b2);
                        iArr[c2] = iArr[c2] + 1;
                    } else {
                        int[] iArr2 = this.g;
                        byte c3 = this.c.c((b2 * 64) + s);
                        iArr2[c3] = iArr2[c3] + 1;
                    }
                }
            }
            this.e = b2;
            i2++;
        }
        if (this.b == CharsetProber.ProbingState.DETECTING && this.f > 1024) {
            float d2 = d();
            if (d2 > 0.95f) {
                this.b = CharsetProber.ProbingState.FOUND_IT;
            } else if (d2 < 0.05f) {
                this.b = CharsetProber.ProbingState.NOT_ME;
            }
        }
        return this.b;
    }

    public final void j() {
        this.b = CharsetProber.ProbingState.DETECTING;
        this.e = 255;
        for (int i2 = 0; i2 < 4; i2++) {
            this.g[i2] = 0;
        }
        this.f = 0;
        this.h = 0;
        this.i = 0;
    }

    public SingleByteCharsetProber(SequenceModel sequenceModel, boolean z, CharsetProber charsetProber) {
        this.c = sequenceModel;
        this.d = z;
        this.j = charsetProber;
        this.g = new int[4];
        j();
    }
}
