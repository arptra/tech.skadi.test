package com.meizu.common.widget;

import android.content.res.ColorStateList;
import androidx.annotation.NonNull;

class MorphingParams {
    public float cornerRadius;
    public int duration;
    public float fromAlpha;
    public ColorStateList fromColor;
    public ColorStateList fromDarkColor;
    public int fromStrokeColor;
    public int fromStrokeWidth;
    public int height;
    public StrokeGradientDrawable mDrawable;
    public float toAlpha;
    public ColorStateList toColor;
    public ColorStateList toDarkColor;
    public int toStrokeColor;
    public int toStrokeWidth;
    public int width;

    private MorphingParams(@NonNull StrokeGradientDrawable strokeGradientDrawable) {
        this.mDrawable = strokeGradientDrawable;
    }

    public static MorphingParams create(@NonNull StrokeGradientDrawable strokeGradientDrawable) {
        return new MorphingParams(strokeGradientDrawable);
    }

    public MorphingParams alpha(float f, float f2) {
        this.fromAlpha = f;
        this.toAlpha = f2;
        return this;
    }

    public MorphingParams color(ColorStateList colorStateList, ColorStateList colorStateList2) {
        this.fromColor = colorStateList;
        this.toColor = colorStateList2;
        return this;
    }

    public MorphingParams cornerRadius(int i) {
        this.cornerRadius = (float) i;
        return this;
    }

    public MorphingParams duration(int i) {
        this.duration = i;
        return this;
    }

    public MorphingParams height(int i) {
        this.height = i;
        return this;
    }

    public MorphingParams strokeColor(int i, int i2) {
        this.fromStrokeColor = i;
        this.toStrokeColor = i2;
        return this;
    }

    public MorphingParams strokeWidth(int i, int i2) {
        this.fromStrokeWidth = i;
        this.toStrokeWidth = i2;
        return this;
    }

    public MorphingParams width(int i) {
        this.width = i;
        return this;
    }
}
