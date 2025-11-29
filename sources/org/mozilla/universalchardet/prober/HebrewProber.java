package org.mozilla.universalchardet.prober;

import org.mozilla.universalchardet.Constants;
import org.mozilla.universalchardet.prober.CharsetProber;

public class HebrewProber extends CharsetProber {
    public int b;
    public int c;
    public byte d;
    public byte e;
    public CharsetProber f = null;
    public CharsetProber g = null;

    public HebrewProber() {
        j();
    }

    public static boolean l(byte b2) {
        byte b3 = b2 & 255;
        return b3 == 234 || b3 == 237 || b3 == 239 || b3 == 243 || b3 == 245;
    }

    public static boolean m(byte b2) {
        byte b3 = b2 & 255;
        return b3 == 235 || b3 == 238 || b3 == 240 || b3 == 244;
    }

    public String c() {
        int i = this.b - this.c;
        if (i >= 5) {
            return Constants.t;
        }
        if (i <= -5) {
            return Constants.f;
        }
        float d2 = this.f.d() - this.g.d();
        return d2 > 0.01f ? Constants.t : d2 < -0.01f ? Constants.f : i < 0 ? Constants.f : Constants.t;
    }

    public float d() {
        return 0.0f;
    }

    public CharsetProber.ProbingState e() {
        CharsetProber.ProbingState e2 = this.f.e();
        CharsetProber.ProbingState probingState = CharsetProber.ProbingState.NOT_ME;
        return (e2 == probingState && this.g.e() == probingState) ? probingState : CharsetProber.ProbingState.DETECTING;
    }

    public CharsetProber.ProbingState f(byte[] bArr, int i, int i2) {
        CharsetProber.ProbingState e2 = e();
        CharsetProber.ProbingState probingState = CharsetProber.ProbingState.NOT_ME;
        if (e2 == probingState) {
            return probingState;
        }
        int i3 = i2 + i;
        while (i < i3) {
            byte b2 = bArr[i];
            if (b2 == 32) {
                if (this.e != 32) {
                    if (l(this.d)) {
                        this.b++;
                    } else if (m(this.d)) {
                        this.c++;
                    }
                }
            } else if (this.e == 32 && l(this.d) && b2 != 32) {
                this.c++;
            }
            this.e = this.d;
            this.d = b2;
            i++;
        }
        return CharsetProber.ProbingState.DETECTING;
    }

    public final void j() {
        this.b = 0;
        this.c = 0;
        this.d = 32;
        this.e = 32;
    }

    public void n(CharsetProber charsetProber, CharsetProber charsetProber2) {
        this.f = charsetProber;
        this.g = charsetProber2;
    }
}
