package com.meizu.common.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class IFTextView extends TextView {
    public IFTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void init(Context context) {
        setTypeface(Typeface.createFromAsset(context.getAssets(), "iconfont.ttf"));
    }

    public IFTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IFTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }
}
