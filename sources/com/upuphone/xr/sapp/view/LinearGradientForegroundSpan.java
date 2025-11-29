package com.upuphone.xr.sapp.view;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.text.style.ReplacementSpan;
import android.text.style.UpdateAppearance;

public class LinearGradientForegroundSpan extends ReplacementSpan implements UpdateAppearance {

    /* renamed from: a  reason: collision with root package name */
    public int f7976a;
    public int[] b;

    public LinearGradientForegroundSpan(int[] iArr) {
        this.b = iArr;
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Paint paint2 = paint;
        paint2.setShader(new LinearGradient(f, 0.0f, ((float) this.f7976a) + f, 0.0f, this.b, (float[]) null, Shader.TileMode.REPEAT));
        canvas.drawText(charSequence, i, i2, f, (float) i4, paint);
    }

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        int measureText = (int) paint.measureText(charSequence, i, i2);
        this.f7976a = measureText;
        return measureText;
    }
}
