package com.luck.picture.lib.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.luck.picture.lib.R;

public class MediumBoldTextView extends AppCompatTextView {

    /* renamed from: a  reason: collision with root package name */
    public float f9483a;

    public MediumBoldTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public void onDraw(Canvas canvas) {
        TextPaint paint = getPaint();
        float strokeWidth = paint.getStrokeWidth();
        float f = this.f9483a;
        if (strokeWidth != f) {
            paint.setStrokeWidth(f);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
        }
        super.onDraw(canvas);
    }

    public void setStrokeWidth(float f) {
        this.f9483a = f;
        invalidate();
    }

    public MediumBoldTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MediumBoldTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9483a = 0.6f;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.PictureMediumBoldTextView, i, 0);
        this.f9483a = obtainStyledAttributes.getFloat(R.styleable.PictureMediumBoldTextView_stroke_Width, this.f9483a);
        obtainStyledAttributes.recycle();
    }
}
