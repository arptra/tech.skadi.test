package com.android.internal.graphics.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

@Keep
public class BackgroundBlurDrawable extends Drawable {
    public void draw(@NonNull Canvas canvas) {
    }

    public int getOpacity() {
        return -1;
    }

    public void setAlpha(int i) {
    }

    @Keep
    public void setBlurRadius(int i) {
    }

    @Keep
    public void setColor(int i) {
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter) {
    }

    @Keep
    public void setCornerRadius(float f) {
    }

    @Keep
    public void setCornerRadius(float f, float f2, float f3, float f4) {
    }
}
