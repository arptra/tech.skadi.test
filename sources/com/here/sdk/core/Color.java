package com.here.sdk.core;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;

public final class Color {
    private final float falpha;
    private final float fblue;
    private final float fgreen;
    private final float fred;

    public Color(float f, float f2, float f3, float f4) {
        this.fred = f;
        this.fgreen = f2;
        this.fblue = f3;
        this.falpha = f4;
    }

    @NonNull
    public static Color valueOf(float f, float f2, float f3) {
        return new Color(f, f2, f3, 1.0f);
    }

    public float alpha() {
        return this.falpha;
    }

    public float blue() {
        return this.fblue;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Color)) {
            return false;
        }
        Color color = (Color) obj;
        return Float.compare(this.fred, color.fred) == 0 && Float.compare(this.fgreen, color.fgreen) == 0 && Float.compare(this.fblue, color.fblue) == 0 && Float.compare(this.falpha, color.falpha) == 0;
    }

    public float green() {
        return this.fgreen;
    }

    public int hashCode() {
        return toArgb();
    }

    public float red() {
        return this.fred;
    }

    @ColorInt
    public int toArgb() {
        return ((int) ((blue() * 255.0f) + 0.5f)) | (((int) ((alpha() * 255.0f) + 0.5f)) << 24) | (((int) ((red() * 255.0f) + 0.5f)) << 16) | (((int) ((green() * 255.0f) + 0.5f)) << 8);
    }

    @NonNull
    public String toString() {
        return "Color(" + red() + ", " + green() + ", " + blue() + ", " + alpha() + ")";
    }

    @NonNull
    public static Color valueOf(float f, float f2, float f3, float f4) {
        return new Color(f, f2, f3, f4);
    }

    @NonNull
    public static Color valueOf(@ColorInt int i) {
        return valueOf(((float) ((i >> 16) & 255)) / 255.0f, ((float) ((i >> 8) & 255)) / 255.0f, ((float) (i & 255)) / 255.0f, ((float) ((i >> 24) & 255)) / 255.0f);
    }
}
