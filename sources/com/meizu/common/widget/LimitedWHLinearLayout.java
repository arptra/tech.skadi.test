package com.meizu.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;

public class LimitedWHLinearLayout extends LinearLayout {
    private int mMaxHeight = Integer.MAX_VALUE;
    private int mMaxWidth = Integer.MAX_VALUE;

    public LimitedWHLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(LimitedWHLinearLayout.class.getName());
    }

    public void onMeasure(int i, int i2) {
        boolean z;
        super.onMeasure(i, i2);
        int measuredHeight = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();
        int i3 = this.mMaxHeight;
        boolean z2 = true;
        if (measuredHeight > i3) {
            i2 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
            z = true;
        } else {
            z = false;
        }
        int i4 = this.mMaxWidth;
        if (measuredWidth > i4) {
            i = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
        } else {
            z2 = z;
        }
        if (z2) {
            super.onMeasure(i, i2);
        }
    }

    public void setMaxHeight(int i) {
        this.mMaxHeight = i;
    }

    public void setMaxWidth(int i) {
        this.mMaxWidth = i;
    }

    public LimitedWHLinearLayout(Context context) {
        super(context);
    }
}
