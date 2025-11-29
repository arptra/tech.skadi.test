package org.mozilla.universalchardet.prober.distributionanalysis;

public abstract class CharDistributionAnalysis {

    /* renamed from: a  reason: collision with root package name */
    public int f3438a;
    public int b;
    public int[] c;
    public float d;

    public CharDistributionAnalysis() {
        e();
    }

    public float a() {
        int i;
        int i2 = this.b;
        if (i2 <= 0 || (i = this.f3438a) <= 4) {
            return 0.01f;
        }
        if (i2 != i) {
            float f = ((float) i) / (((float) (i2 - i)) * this.d);
            if (f < 0.99f) {
                return f;
            }
        }
        return 0.99f;
    }

    public abstract int b(byte[] bArr, int i);

    public boolean c() {
        return this.b > 1024;
    }

    public void d(byte[] bArr, int i, int i2) {
        int b2 = i2 == 2 ? b(bArr, i) : -1;
        if (b2 >= 0) {
            this.b++;
            int[] iArr = this.c;
            if (b2 < iArr.length && 512 > iArr[b2]) {
                this.f3438a++;
            }
        }
    }

    public final void e() {
        this.b = 0;
        this.f3438a = 0;
    }
}
