package com.meizu.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.meizu.common.util.ResourceUtils;

public class NewMessageView extends View {
    private static final int MAX_COUNT = 999;
    private int mCurrentStage = 0;
    private boolean mIsHide = true;
    private NewMessagePainter mNewMessagePainter;

    public NewMessageView(Context context) {
        super(context);
        init(context, (AttributeSet) null);
    }

    private int getMeasure(int i, int i2, int i3, int i4) {
        return (i4 == 1073741824 && i >= i2) ? i > i3 ? i3 : i : i2;
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mNewMessagePainter = new NewMessagePainter(context);
    }

    public int getBorderWidth() {
        return this.mNewMessagePainter.getBorderWidth();
    }

    public int getNewMessageGravity() {
        return ((FrameLayout.LayoutParams) getLayoutParams()).gravity;
    }

    public int[] getNewMessageMargin() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        return new int[]{layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin};
    }

    public Integer getNewMessageNum() {
        return this.mNewMessagePainter.getNewMessageNum();
    }

    public int getState() {
        return this.mNewMessagePainter.getState();
    }

    public TypedArray getTypedArray(Context context, AttributeSet attributeSet, int[] iArr) {
        return context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public int getViewMaxHeight() {
        return this.mNewMessagePainter.getViewMaxHeight();
    }

    public int getViewMaxWidth() {
        return this.mNewMessagePainter.getViewMaxWidth();
    }

    public boolean isHide() {
        return this.mIsHide;
    }

    public void onDraw(Canvas canvas) {
        this.mNewMessagePainter.draw(canvas);
    }

    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        this.mNewMessagePainter.measure();
        setMeasuredDimension(getMeasure(size, this.mNewMessagePainter.getWidth(), this.mNewMessagePainter.getViewMaxWidth(), mode), getMeasure(size2, this.mNewMessagePainter.getHeight(), this.mNewMessagePainter.getViewMaxHeight(), mode2));
    }

    public void setBackgroundColor(int i) {
        this.mNewMessagePainter.setBackgroundColor(i);
    }

    public void setBorderColor(int i) {
        this.mNewMessagePainter.setBorderColor(i);
    }

    public void setBorderWidth(int i) {
        this.mNewMessagePainter.setBorderWidth(i);
    }

    public void setCurrentStage(int i) {
        this.mNewMessagePainter.setCurrentStage(i);
    }

    public void setHide(boolean z) {
        this.mIsHide = z;
        if (this.mCurrentStage == 1) {
            setText(this.mNewMessagePainter.getTextContent());
        } else {
            setText((String) null);
        }
    }

    public void setNewMessageGravity(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.gravity = i;
        setLayoutParams(layoutParams);
    }

    public void setNewMessageMargin(int i, int i2, int i3, int i4) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.leftMargin = (int) ResourceUtils.dp2px((float) i, getContext());
        layoutParams.topMargin = (int) ResourceUtils.dp2px((float) i2, getContext());
        layoutParams.rightMargin = (int) ResourceUtils.dp2px((float) i3, getContext());
        layoutParams.bottomMargin = (int) ResourceUtils.dp2px((float) i4, getContext());
        setLayoutParams(layoutParams);
    }

    public void setNewMessageNum(int i) {
        setCurrentStage(1);
        if (i >= 999) {
            i = 999;
        } else if (i <= 0) {
            i = 0;
        }
        setText(String.valueOf(i));
        requestLayout();
    }

    public void setNewMessageSpace(int i) {
        this.mNewMessagePainter.setNewMessageSpace(i);
    }

    public void setShowBorder(boolean z) {
        this.mNewMessagePainter.setShowBorder(z);
    }

    public void setText(String str) {
        if (!isHide() || (str != null && !str.equalsIgnoreCase("0"))) {
            setVisibility(0);
        } else {
            setVisibility(8);
        }
        this.mNewMessagePainter.setText(str);
    }

    public void setTextSize(float f) {
        this.mNewMessagePainter.setTextSize(f);
    }

    public void setViewMaxSize(int i, int i2) {
        this.mNewMessagePainter.setViewMaxSize(i, i2);
    }

    public NewMessageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public NewMessageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }
}
