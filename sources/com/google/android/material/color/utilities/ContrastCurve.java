package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

@RestrictTo
public final class ContrastCurve {
    private final double high;
    private final double low;
    private final double medium;
    private final double normal;

    public ContrastCurve(double d, double d2, double d3, double d4) {
        this.low = d;
        this.normal = d2;
        this.medium = d3;
        this.high = d4;
    }

    public double getContrast(double d) {
        return d <= -1.0d ? this.low : d < 0.0d ? MathUtils.lerp(this.low, this.normal, (d - -1.0d) / 1.0d) : d < 0.5d ? MathUtils.lerp(this.normal, this.medium, (d - 0.0d) / 0.5d) : d < 1.0d ? MathUtils.lerp(this.medium, this.high, (d - 0.5d) / 0.5d) : this.high;
    }
}
