package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

@RestrictTo
public final class QuantizerWsmeans {
    private static final int MAX_ITERATIONS = 10;
    private static final double MIN_MOVEMENT_DISTANCE = 3.0d;

    public static final class Distance implements Comparable<Distance> {
        double distance = -1.0d;
        int index = -1;

        public int compareTo(Distance distance2) {
            return Double.valueOf(this.distance).compareTo(Double.valueOf(distance2.distance));
        }
    }

    private QuantizerWsmeans() {
    }

    public static Map<Integer, Integer> quantize(int[] iArr, int[] iArr2, int i) {
        int[] iArr3;
        int i2;
        int i3;
        int i4;
        int[] iArr4 = iArr;
        int[] iArr5 = iArr2;
        int i5 = 1;
        Random random = new Random(272008);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        double[][] dArr = new double[iArr4.length][];
        int[] iArr6 = new int[iArr4.length];
        PointProviderLab pointProviderLab = new PointProviderLab();
        int i6 = 0;
        for (int i7 : iArr4) {
            Integer num = (Integer) linkedHashMap.get(Integer.valueOf(i7));
            if (num == null) {
                dArr[i6] = pointProviderLab.fromInt(i7);
                iArr6[i6] = i7;
                i6++;
                linkedHashMap.put(Integer.valueOf(i7), 1);
            } else {
                linkedHashMap.put(Integer.valueOf(i7), Integer.valueOf(num.intValue() + 1));
            }
        }
        int[] iArr7 = new int[i6];
        for (int i8 = 0; i8 < i6; i8++) {
            iArr7[i8] = ((Integer) linkedHashMap.get(Integer.valueOf(iArr6[i8]))).intValue();
        }
        int min = Math.min(i, i6);
        if (iArr5.length != 0) {
            min = Math.min(min, iArr5.length);
        }
        double[][] dArr2 = new double[min][];
        int i9 = 0;
        for (int i10 = 0; i10 < iArr5.length; i10++) {
            dArr2[i10] = pointProviderLab.fromInt(iArr5[i10]);
            i9++;
        }
        int i11 = min - i9;
        if (i11 > 0) {
            for (int i12 = 0; i12 < i11; i12++) {
            }
        }
        int[] iArr8 = new int[i6];
        for (int i13 = 0; i13 < i6; i13++) {
            iArr8[i13] = random.nextInt(min);
        }
        int[][] iArr9 = new int[min][];
        for (int i14 = 0; i14 < min; i14++) {
            iArr9[i14] = new int[min];
        }
        Distance[][] distanceArr = new Distance[min][];
        for (int i15 = 0; i15 < min; i15++) {
            distanceArr[i15] = new Distance[min];
            for (int i16 = 0; i16 < min; i16++) {
                distanceArr[i15][i16] = new Distance();
            }
        }
        int[] iArr10 = new int[min];
        int i17 = 0;
        while (true) {
            if (i17 >= 10) {
                iArr3 = iArr10;
                i2 = 0;
                break;
            }
            int i18 = 0;
            while (i18 < min) {
                int i19 = i18 + 1;
                int i20 = i19;
                while (i20 < min) {
                    int[] iArr11 = iArr10;
                    double distance = pointProviderLab.distance(dArr2[i18], dArr2[i20]);
                    Distance distance2 = distanceArr[i20][i18];
                    distance2.distance = distance;
                    distance2.index = i18;
                    Distance distance3 = distanceArr[i18][i20];
                    distance3.distance = distance;
                    distance3.index = i20;
                    i5 = 1;
                    i20++;
                    iArr10 = iArr11;
                    i17 = i17;
                }
                int[] iArr12 = iArr10;
                int i21 = i17;
                Arrays.sort(distanceArr[i18]);
                for (int i22 = 0; i22 < min; i22 += i5) {
                    iArr9[i18][i22] = distanceArr[i18][i22].index;
                }
                iArr10 = iArr12;
                i17 = i21;
                i18 = i19;
            }
            int[] iArr13 = iArr10;
            int i23 = i17;
            int i24 = 0;
            int i25 = 0;
            while (i24 < i6) {
                double[] dArr3 = dArr[i24];
                int i26 = iArr8[i24];
                double distance4 = pointProviderLab.distance(dArr3, dArr2[i26]);
                int[][] iArr14 = iArr9;
                double d = distance4;
                int i27 = -1;
                int i28 = 0;
                while (i28 < min) {
                    Distance[][] distanceArr2 = distanceArr;
                    int i29 = i6;
                    if (distanceArr[i26][i28].distance < 4.0d * distance4) {
                        double distance5 = pointProviderLab.distance(dArr3, dArr2[i28]);
                        if (distance5 < d) {
                            d = distance5;
                            i27 = i28;
                        }
                    }
                    i28++;
                    i6 = i29;
                    distanceArr = distanceArr2;
                }
                Distance[][] distanceArr3 = distanceArr;
                int i30 = i6;
                if (i27 != -1 && Math.abs(Math.sqrt(d) - Math.sqrt(distance4)) > 3.0d) {
                    i25++;
                    iArr8[i24] = i27;
                }
                i24++;
                iArr9 = iArr14;
                i6 = i30;
                distanceArr = distanceArr3;
            }
            int[][] iArr15 = iArr9;
            Distance[][] distanceArr4 = distanceArr;
            int i31 = i6;
            if (i25 == 0 && i23 != 0) {
                i2 = 0;
                iArr3 = iArr13;
                break;
            }
            double[] dArr4 = new double[min];
            double[] dArr5 = new double[min];
            double[] dArr6 = new double[min];
            int[] iArr16 = iArr13;
            char c = 0;
            Arrays.fill(iArr16, 0);
            int i32 = 0;
            while (true) {
                i3 = i31;
                if (i32 >= i3) {
                    break;
                }
                int i33 = iArr8[i32];
                double[] dArr7 = dArr[i32];
                int i34 = iArr7[i32];
                iArr16[i33] = iArr16[i33] + i34;
                double d2 = dArr4[i33];
                double d3 = dArr7[c];
                int[] iArr17 = iArr7;
                double d4 = (double) i34;
                dArr4[i33] = d2 + (d3 * d4);
                dArr5[i33] = dArr5[i33] + (dArr7[1] * d4);
                dArr6[i33] = dArr6[i33] + (dArr7[2] * d4);
                i32++;
                iArr7 = iArr17;
                iArr8 = iArr8;
                c = 0;
                i31 = i3;
            }
            int[] iArr18 = iArr7;
            int[] iArr19 = iArr8;
            int i35 = 0;
            while (i35 < min) {
                int i36 = iArr16[i35];
                if (i36 == 0) {
                    dArr2[i35] = new double[]{0.0d, 0.0d, 0.0d};
                    i4 = 1;
                } else {
                    double d5 = (double) i36;
                    double[] dArr8 = dArr2[i35];
                    dArr8[0] = dArr4[i35] / d5;
                    i4 = 1;
                    dArr8[1] = dArr5[i35] / d5;
                    dArr8[2] = dArr6[i35] / d5;
                }
                i35 += i4;
            }
            i17 = i23 + 1;
            iArr7 = iArr18;
            i5 = 1;
            iArr9 = iArr15;
            iArr8 = iArr19;
            distanceArr = distanceArr4;
            iArr10 = iArr16;
            i6 = i3;
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (int i37 = i2; i37 < min; i37++) {
            int i38 = iArr3[i37];
            if (i38 != 0) {
                int i39 = pointProviderLab.toInt(dArr2[i37]);
                if (!linkedHashMap2.containsKey(Integer.valueOf(i39))) {
                    linkedHashMap2.put(Integer.valueOf(i39), Integer.valueOf(i38));
                }
            }
        }
        return linkedHashMap2;
    }
}
