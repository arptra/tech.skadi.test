package com.google.android.material.internal;

import android.animation.TypeEvaluator;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo
public class RectEvaluator implements TypeEvaluator<Rect> {
    private final Rect rect;

    public RectEvaluator(@NonNull Rect rect2) {
        this.rect = rect2;
    }

    public Rect evaluate(float f, @NonNull Rect rect2, @NonNull Rect rect3) {
        int i = rect2.left;
        int i2 = i + ((int) (((float) (rect3.left - i)) * f));
        int i3 = rect2.top;
        int i4 = i3 + ((int) (((float) (rect3.top - i3)) * f));
        int i5 = rect2.right;
        int i6 = rect2.bottom;
        int i7 = i6 + ((int) (((float) (rect3.bottom - i6)) * f));
        this.rect.set(i2, i4, i5 + ((int) (((float) (rect3.right - i5)) * f)), i7);
        return this.rect;
    }
}
