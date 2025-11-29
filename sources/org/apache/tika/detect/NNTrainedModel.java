package org.apache.tika.detect;

import java.lang.reflect.Array;

public class NNTrainedModel extends TrainedModel {

    /* renamed from: a  reason: collision with root package name */
    public final int f10056a;
    public final int b;
    public final int c;
    public final float[][] d;
    public final float[][] e;

    public NNTrainedModel(int i, int i2, int i3, float[] fArr) {
        this.f10056a = i;
        this.b = i2;
        this.c = i3;
        int[] iArr = new int[2];
        iArr[1] = i + 1;
        iArr[0] = i2;
        Class cls = Float.TYPE;
        this.d = (float[][]) Array.newInstance(cls, iArr);
        int[] iArr2 = new int[2];
        iArr2[1] = i2 + 1;
        iArr2[0] = i3;
        this.e = (float[][]) Array.newInstance(cls, iArr2);
        b(fArr);
    }

    public float a(float[] fArr) {
        float[][] fArr2 = this.d;
        int length = fArr2.length;
        int length2 = fArr2[0].length;
        float[] fArr3 = new float[(length + 1)];
        fArr3[0] = 1.0f;
        int i = 0;
        while (true) {
            double d2 = 0.0d;
            if (i >= length) {
                break;
            }
            for (int i2 = 0; i2 < length2; i2++) {
                d2 += (double) (this.d[i][i2] * fArr[i2]);
            }
            i++;
            fArr3[i] = (float) (1.0d / (Math.exp(-d2) + 1.0d));
        }
        float[][] fArr4 = this.e;
        int length3 = fArr4.length;
        int length4 = fArr4[0].length;
        float[] fArr5 = new float[length3];
        for (int i3 = 0; i3 < length3; i3++) {
            double d3 = 0.0d;
            for (int i4 = 0; i4 < length4; i4++) {
                d3 += (double) (this.e[i3][i4] * fArr3[i4]);
            }
            fArr5[i3] = (float) (1.0d / (Math.exp(-d3) + 1.0d));
        }
        return fArr5[0];
    }

    public final void b(float[] fArr) {
        float[][] fArr2 = this.d;
        int length = fArr2.length;
        int length2 = fArr2[0].length;
        int i = 0;
        for (int i2 = 0; i2 < length2; i2++) {
            for (int i3 = 0; i3 < length; i3++) {
                this.d[i3][i2] = fArr[i];
                i++;
            }
        }
        float[][] fArr3 = this.e;
        int length3 = fArr3.length;
        int length4 = fArr3[0].length;
        for (int i4 = 0; i4 < length4; i4++) {
            for (int i5 = 0; i5 < length3; i5++) {
                this.e[i5][i4] = fArr[i];
                i++;
            }
        }
    }
}
