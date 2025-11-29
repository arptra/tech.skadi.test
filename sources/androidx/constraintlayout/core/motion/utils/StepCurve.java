package androidx.constraintlayout.core.motion.utils;

import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.Arrays;

public class StepCurve extends Easing {
    public MonotonicCurveFit d;

    public StepCurve(String str) {
        this.f498a = str;
        double[] dArr = new double[(str.length() / 2)];
        int indexOf = str.indexOf(40) + 1;
        int indexOf2 = str.indexOf(44, indexOf);
        int i = 0;
        while (indexOf2 != -1) {
            dArr[i] = Double.parseDouble(str.substring(indexOf, indexOf2).trim());
            indexOf = indexOf2 + 1;
            indexOf2 = str.indexOf(44, indexOf);
            i++;
        }
        dArr[i] = Double.parseDouble(str.substring(indexOf, str.indexOf(41, indexOf)).trim());
        this.d = d(Arrays.copyOf(dArr, i + 1));
    }

    public static MonotonicCurveFit d(double[] dArr) {
        double[] dArr2 = dArr;
        int length = (dArr2.length * 3) - 2;
        int length2 = dArr2.length - 1;
        double d2 = 1.0d / ((double) length2);
        int[] iArr = new int[2];
        iArr[1] = 1;
        iArr[0] = length;
        double[][] dArr3 = (double[][]) Array.newInstance(Double.TYPE, iArr);
        double[] dArr4 = new double[length];
        for (int i = 0; i < dArr2.length; i++) {
            double d3 = dArr2[i];
            int i2 = i + length2;
            dArr3[i2][0] = d3;
            double d4 = ((double) i) * d2;
            dArr4[i2] = d4;
            if (i > 0) {
                int i3 = (length2 * 2) + i;
                dArr3[i3][0] = d3 + 1.0d;
                dArr4[i3] = d4 + 1.0d;
                int i4 = i - 1;
                dArr3[i4][0] = (d3 - 1.0d) - d2;
                dArr4[i4] = (d4 - 4.0d) - d2;
            }
        }
        MonotonicCurveFit monotonicCurveFit = new MonotonicCurveFit(dArr4, dArr3);
        PrintStream printStream = System.out;
        printStream.println(" 0 " + monotonicCurveFit.c(0.0d, 0));
        printStream.println(" 1 " + monotonicCurveFit.c(1.0d, 0));
        return monotonicCurveFit;
    }

    public double a(double d2) {
        return this.d.c(d2, 0);
    }

    public double b(double d2) {
        return this.d.f(d2, 0);
    }
}
