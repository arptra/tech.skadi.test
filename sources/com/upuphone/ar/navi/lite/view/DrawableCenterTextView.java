package com.upuphone.ar.navi.lite.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

public class DrawableCenterTextView extends TextView {
    public DrawableCenterTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void onDraw(Canvas canvas) {
        Drawable drawable = getCompoundDrawablesRelative()[0];
        if (drawable != null) {
            int width = (getWidth() - ((int) ((getPaint().measureText(getText().toString()) + ((float) drawable.getIntrinsicWidth())) + ((float) getCompoundDrawablePadding())))) / 2;
            setPadding(width, getPaddingTop(), width, getPaddingBottom());
        }
        super.onDraw(canvas);
    }

    public DrawableCenterTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DrawableCenterTextView(Context context) {
        super(context);
    }
}
