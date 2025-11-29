package com.githang.statusbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

public class StatusBarView extends View {

    /* renamed from: a  reason: collision with root package name */
    public int f3004a;

    public StatusBarView(Context context) {
        this(context, (AttributeSet) null);
    }

    public void onMeasure(int i, int i2) {
        setMeasuredDimension(View.MeasureSpec.getSize(i), this.f3004a);
    }

    public StatusBarView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3004a = StatusBarTools.a(context);
    }
}
