package org.mozilla.universalchardet.prober;

import java.nio.ByteBuffer;
import org.mozilla.universalchardet.Constants;
import org.mozilla.universalchardet.prober.CharsetProber;

public class Latin1Prober extends CharsetProber {
    public static final byte[] e = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 1, 1, 1, 1, 1, 0, 1, 7, 1, 1, 1, 1, 1, 1, 5, 1, 5, 0, 5, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 7, 1, 7, 0, 7, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4, 4, 4, 4, 4, 5, 5, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 4, 4, 4, 4, 4, 1, 4, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6, 7, 7, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 6, 6, 6, 6, 6, 1, 6, 6, 6, 6, 6, 7, 7, 7};
    public static final byte[] f = {0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 3, 3, 3, 3, 0, 3, 3, 3, 3, 3, 3, 3, 0, 3, 3, 3, 1, 1, 3, 3, 0, 3, 3, 3, 1, 2, 1, 2, 0, 3, 3, 3, 3, 3, 3, 3, 0, 3, 1, 3, 1, 1, 1, 3, 0, 3, 1, 3, 1, 1, 3, 3};
    public CharsetProber.ProbingState b;
    public byte c;
    public int[] d = new int[4];

    public Latin1Prober() {
        j();
    }

    public String c() {
        return Constants.r;
    }

    public float d() {
        int[] iArr;
        float f2;
        if (this.b == CharsetProber.ProbingState.NOT_ME) {
            return 0.01f;
        }
        int i = 0;
        int i2 = 0;
        while (true) {
            iArr = this.d;
            if (i >= iArr.length) {
                break;
            }
            i2 += iArr[i];
            i++;
        }
        float f3 = 0.0f;
        if (i2 <= 0) {
            f2 = 0.0f;
        } else {
            float f4 = (float) i2;
            f2 = ((((float) iArr[3]) * 1.0f) / f4) - ((((float) iArr[1]) * 20.0f) / f4);
        }
        if (f2 >= 0.0f) {
            f3 = f2;
        }
        return f3 * 0.5f;
    }

    public CharsetProber.ProbingState e() {
        return this.b;
    }

    public CharsetProber.ProbingState f(byte[] bArr, int i, int i2) {
        ByteBuffer a2 = a(bArr, i, i2);
        byte[] array = a2.array();
        int position = a2.position();
        int i3 = 0;
        while (true) {
            if (i3 >= position) {
                break;
            }
            byte b2 = e[array[i3] & 255];
            byte b3 = f[(this.c * 8) + b2];
            if (b3 == 0) {
                this.b = CharsetProber.ProbingState.NOT_ME;
                break;
            }
            int[] iArr = this.d;
            iArr[b3] = iArr[b3] + 1;
            this.c = b2;
            i3++;
        }
        return this.b;
    }

    public final void j() {
        this.b = CharsetProber.ProbingState.DETECTING;
        this.c = 1;
        int i = 0;
        while (true) {
            int[] iArr = this.d;
            if (i < iArr.length) {
                iArr[i] = 0;
                i++;
            } else {
                return;
            }
        }
    }
}
