package com.meizu.common.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.meizu.common.R;

public class NavigationMenuItemView extends LinearLayout implements BottomNavigationItemView {
    private MzImageView mIconView;
    private ButtonNavigationItem mItemData;
    private final NewMessagePainter mNewMessagePainter;
    private int mSelectedIconColor;
    private boolean mSelectedIconTintEnabled;
    private TextView mTitleView;

    public NavigationMenuItemView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void drawMessage(Canvas canvas) {
        int i;
        ButtonNavigationItem itemData = getItemData();
        if (itemData.isBadgeVisible()) {
            int right = this.mIconView.getRight();
            int top2 = this.mIconView.getTop();
            int width = this.mNewMessagePainter.getWidth();
            int height = this.mNewMessagePainter.getHeight();
            if (itemData.getBadgeCount() > 0) {
                i = right - (width >> 1);
                top2 -= height >> 1;
            } else {
                i = right - width;
            }
            canvas.save();
            canvas.translate((float) i, (float) top2);
            this.mNewMessagePainter.draw(canvas);
            canvas.restore();
        }
    }

    public void dispatchDraw(Canvas canvas) {
        MzImageView mzImageView = this.mIconView;
        if (mzImageView == null) {
            super.dispatchDraw(canvas);
            return;
        }
        Drawable drawable = mzImageView.getDrawable();
        if (this.mSelectedIconTintEnabled) {
            if (isSelected()) {
                drawable.setColorFilter(this.mSelectedIconColor, PorterDuff.Mode.SRC_IN);
            } else {
                drawable.setColorFilter((ColorFilter) null);
            }
        }
        super.dispatchDraw(canvas);
    }

    public ButtonNavigationItem getItemData() {
        return this.mItemData;
    }

    public View getView() {
        return this;
    }

    public void initialize(ButtonNavigationItem buttonNavigationItem) {
        this.mItemData = buttonNavigationItem;
        setTitle(buttonNavigationItem.getTitle());
        if (buttonNavigationItem.getTitleColor() != null) {
            setTitleColor(buttonNavigationItem.getTitleColor());
        }
        setIcon(buttonNavigationItem.getIcon());
        setSelected(buttonNavigationItem.isSelected());
        requestLayout();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MzImageView mzImageView = this.mIconView;
        if (mzImageView != null && mzImageView.getDrawable() != null) {
            this.mIconView.getDrawable().setColorFilter((ColorFilter) null);
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.mTitleView = (TextView) findViewById(R.id.title);
        this.mIconView = (MzImageView) findViewById(R.id.icon);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mNewMessagePainter.measure();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        MzImageView mzImageView = this.mIconView;
        if (mzImageView != null) {
            mzImageView.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIcon(Drawable drawable) {
        MzImageView mzImageView = this.mIconView;
        if (mzImageView != null) {
            mzImageView.setImageDrawable(drawable);
            ButtonNavigationItem itemData = getItemData();
            if (itemData.isBadgeVisible()) {
                int badgeCount = itemData.getBadgeCount();
                if (badgeCount <= 0) {
                    this.mNewMessagePainter.setCurrentStage(0);
                    return;
                }
                this.mNewMessagePainter.setCurrentStage(1);
                this.mNewMessagePainter.setNewMessageNum(badgeCount);
            }
        }
    }

    public void setSelectedIconColor(int i) {
        if (this.mSelectedIconColor != i) {
            this.mSelectedIconColor = i;
            invalidate();
        }
    }

    public void setSelectedIconTintEnabled(boolean z) {
        if (this.mSelectedIconTintEnabled != z) {
            this.mSelectedIconTintEnabled = z;
            invalidate();
        }
    }

    public void setTitle(CharSequence charSequence) {
        TextView textView = this.mTitleView;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void setTitleColor(ColorStateList colorStateList) {
        TextView textView = this.mTitleView;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSelectedIconTintEnabled = true;
        setWillNotDraw(false);
        NewMessagePainter newMessagePainter = new NewMessagePainter(context);
        this.mNewMessagePainter = newMessagePainter;
        newMessagePainter.setShowBorder(true);
    }
}
