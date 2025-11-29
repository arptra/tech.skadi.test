package com.luck.picture.lib.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.luck.picture.lib.R;

public class RoundCornerRelativeLayout extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public final Path f9485a;
    public final float b;
    public final boolean c;
    public final boolean d;
    public final RectF e;

    public RoundCornerRelativeLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.clipPath(this.f9485a);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f9485a.reset();
        RectF rectF = this.e;
        rectF.right = (float) i;
        rectF.bottom = (float) i2;
        boolean z = this.c;
        if (z || this.d) {
            if (z) {
                float f = this.b;
                this.f9485a.addRoundRect(rectF, new float[]{0.0f, 0.0f, 0.0f, 0.0f, f, f, f, f}, Path.Direction.CW);
            }
            if (this.d) {
                float f2 = this.b;
                this.f9485a.addRoundRect(this.e, new float[]{f2, f2, f2, f2, 0.0f, 0.0f, 0.0f, 0.0f}, Path.Direction.CW);
                return;
            }
            return;
        }
        Path path = this.f9485a;
        float f3 = this.b;
        path.addRoundRect(rectF, f3, f3, Path.Direction.CW);
    }

    public RoundCornerRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundCornerRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = new RectF();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.PictureRoundCornerRelativeLayout, i, 0);
        this.b = obtainStyledAttributes.getDimension(R.styleable.PictureRoundCornerRelativeLayout_psCorners, 0.0f);
        this.c = obtainStyledAttributes.getBoolean(R.styleable.PictureRoundCornerRelativeLayout_psTopNormal, false);
        this.d = obtainStyledAttributes.getBoolean(R.styleable.PictureRoundCornerRelativeLayout_psBottomNormal, false);
        obtainStyledAttributes.recycle();
        this.f9485a = new Path();
    }
}
