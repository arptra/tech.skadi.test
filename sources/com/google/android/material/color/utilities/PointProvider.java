package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

@RestrictTo
public interface PointProvider {
    double distance(double[] dArr, double[] dArr2);

    double[] fromInt(int i);

    int toInt(double[] dArr);
}
