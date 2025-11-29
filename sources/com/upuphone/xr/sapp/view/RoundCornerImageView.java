package com.upuphone.xr.sapp.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.upuphone.xr.sapp.R;

public class RoundCornerImageView extends AppCompatImageView {

    /* renamed from: a  reason: collision with root package name */
    public float f7981a;
    public float b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;

    public RoundCornerImageView(Context context) {
        this(context, (AttributeSet) null);
        a(context, (AttributeSet) null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoundCornerImageView);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RoundCornerImageView_radius, this.c);
        this.d = dimensionPixelOffset;
        int i = this.c;
        if (i == this.e) {
            this.e = dimensionPixelOffset;
        }
        if (i == this.f) {
            this.f = dimensionPixelOffset;
        }
        if (i == this.g) {
            this.g = dimensionPixelOffset;
        }
        if (i == this.h) {
            this.h = dimensionPixelOffset;
        }
        obtainStyledAttributes.recycle();
    }

    public void onDraw(Canvas canvas) {
        int max = Math.max(this.e, this.h) + Math.max(this.f, this.g);
        int max2 = Math.max(this.e, this.f) + Math.max(this.h, this.g);
        if (this.f7981a >= ((float) max) && this.b > ((float) max2)) {
            Path path = new Path();
            path.moveTo((float) this.e, 0.0f);
            path.lineTo(this.f7981a - ((float) this.f), 0.0f);
            float f2 = this.f7981a;
            path.quadTo(f2, 0.0f, f2, (float) this.f);
            path.lineTo(this.f7981a, this.b - ((float) this.g));
            float f3 = this.f7981a;
            float f4 = this.b;
            path.quadTo(f3, f4, f3 - ((float) this.g), f4);
            path.lineTo((float) this.h, this.b);
            float f5 = this.b;
            path.quadTo(0.0f, f5, 0.0f, f5 - ((float) this.h));
            path.lineTo(0.0f, (float) this.e);
            path.quadTo(0.0f, 0.0f, (float) this.e, 0.0f);
            canvas.clipPath(path);
        }
        super.onDraw(canvas);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f7981a = (float) getWidth();
        this.b = (float) getHeight();
    }

    public RoundCornerImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        a(context, attributeSet);
    }

    public RoundCornerImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = 0;
        a(context, attributeSet);
    }
}
