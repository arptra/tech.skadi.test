package com.meizu.net.pedometerprovider.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

public class ClickGrayTextView extends TextView {
    private Drawable mForeground;

    public ClickGrayTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.mForeground;
        if (drawable != null && drawable.isStateful()) {
            this.mForeground.setState(getDrawableState());
            invalidate();
        }
    }

    public Drawable getForeground() {
        return this.mForeground;
    }

    public void invalidateDrawable(Drawable drawable) {
        if (drawable == this.mForeground) {
            invalidate();
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Drawable drawable = this.mForeground;
        if (drawable != null) {
            drawable.setBounds(0, 0, getRight() - getLeft(), getBottom() - getTop());
            this.mForeground.draw(canvas);
        }
    }

    public void setForeground(Drawable drawable) {
        if (drawable != this.mForeground) {
            this.mForeground = drawable;
            invalidate();
        }
    }

    public ClickGrayTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ClickGrayTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
