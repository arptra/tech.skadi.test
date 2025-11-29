package org.apache.tika.detect;

import com.meizu.common.widget.CircularProgressButton;

public class TextStatistics {

    /* renamed from: a  reason: collision with root package name */
    public final int[] f10058a = new int[256];
    public int b = 0;

    public void a(byte[] bArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            int[] iArr = this.f10058a;
            byte b2 = bArr[i + i3] & 255;
            iArr[b2] = iArr[b2] + 1;
            this.b++;
        }
    }

    public int b(int i) {
        return this.f10058a[i & 255];
    }

    public final int c(int i, int i2) {
        int i3 = 0;
        while (i < i2) {
            i3 += this.f10058a[i];
            i++;
        }
        return i3;
    }

    public final int d() {
        return b(9) + b(10) + b(13) + b(12) + b(27);
    }

    public boolean e() {
        int c = c(0, 32);
        int c2 = c(32, 128);
        int d = d();
        int i = this.b;
        return i > 0 && (c - d) * 100 < i * 2 && (c2 + d) * 100 > i * 90;
    }

    public boolean f() {
        int c = c(0, 32);
        int c2 = c(32, 128);
        int d = d();
        int[] iArr = {c(192, 224), c(224, CircularProgressButton.MorphingAnimation.DURATION_NORMAL), c(CircularProgressButton.MorphingAnimation.DURATION_NORMAL, 248)};
        int i = 0;
        int i2 = 0;
        while (i < 3) {
            int i3 = iArr[i];
            c2 += i3;
            i++;
            i2 += i3 * i;
        }
        int c3 = c(128, 192);
        return c2 > 0 && c3 <= i2 && c3 >= i2 - 3 && c(248, 256) == 0 && (c - d) * 100 < c2 * 2;
    }
}
