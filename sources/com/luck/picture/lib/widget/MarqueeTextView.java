package com.luck.picture.lib.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import androidx.annotation.Nullable;

public class MarqueeTextView extends MediumBoldTextView {
    public MarqueeTextView(Context context) {
        super(context);
    }

    public boolean isFocused() {
        return true;
    }

    public boolean isSelected() {
        return true;
    }

    public void onFocusChanged(boolean z, int i, Rect rect) {
        if (z) {
            super.onFocusChanged(true, i, rect);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        if (z) {
            super.onWindowFocusChanged(true);
        }
    }

    public MarqueeTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
