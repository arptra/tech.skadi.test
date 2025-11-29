package com.google.android.material.tabs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.TintTypedArray;
import com.google.android.material.R;

public class TabItem extends View {
    public final int customLayout;
    public final Drawable icon;
    public final CharSequence text;

    public TabItem(Context context) {
        this(context, (AttributeSet) null);
    }

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TintTypedArray u = TintTypedArray.u(context, attributeSet, R.styleable.TabItem);
        this.text = u.p(R.styleable.TabItem_android_text);
        this.icon = u.g(R.styleable.TabItem_android_icon);
        this.customLayout = u.n(R.styleable.TabItem_android_layout, 0);
        u.w();
    }
}
