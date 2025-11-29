package com.meizu.common.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import com.meizu.common.R;

public class PartitionItemLayout extends FrameLayout implements AbsListView.SelectionBoundsAdjuster {
    protected Drawable mContentBackground;
    private Rect mItemShadeRect;

    public PartitionItemLayout(Context context) {
        super(context);
    }

    public void adjustListItemSelectionBounds(Rect rect) {
        int i = rect.left;
        Rect rect2 = this.mItemShadeRect;
        rect.left = i + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.mContentBackground;
        if (drawable != null && drawable.isStateful()) {
            this.mContentBackground.setState(getDrawableState());
        }
    }

    public Drawable getContentBackground() {
        return this.mContentBackground;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.mContentBackground;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public void onDraw(Canvas canvas) {
        Drawable drawable = this.mContentBackground;
        Rect rect = this.mItemShadeRect;
        drawable.setBounds(rect.left, rect.top, getMeasuredWidth() - this.mItemShadeRect.right, getMeasuredHeight() - this.mItemShadeRect.bottom);
        this.mContentBackground.draw(canvas);
        super.onDraw(canvas);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(PartitionItemLayout.class.getName());
    }

    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.mItemShadeRect == null) {
            this.mItemShadeRect = new Rect();
        }
        if (drawable != null) {
            drawable.getPadding(this.mItemShadeRect);
        } else {
            this.mItemShadeRect.setEmpty();
        }
    }

    public void setContentBackground(Drawable drawable) {
        Drawable drawable2 = this.mContentBackground;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
                unscheduleDrawable(this.mContentBackground);
            }
            this.mContentBackground = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.mContentBackground;
    }

    public PartitionItemLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PartitionItemLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Drawable drawable = getResources().getDrawable(R.drawable.mz_list_new_item_bg_light_activated);
        if (drawable != null) {
            setContentBackground(drawable);
        }
        if (this.mItemShadeRect == null) {
            this.mItemShadeRect = new Rect();
        }
    }
}
