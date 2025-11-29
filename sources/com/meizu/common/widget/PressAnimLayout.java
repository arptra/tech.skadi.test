package com.meizu.common.widget;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class PressAnimLayout extends FrameLayout {
    private final long ANIM_DOWN_DURATION;
    private final long ANIM_UP_DURATION;
    private long mDownTime;
    private float mDownX;
    private float mDownY;
    private TimeInterpolator mInterpolator;
    private boolean mIsTouchCanceled;
    private ObjectAnimator mLayoutDownAnimator;
    private int mLayoutHeight;
    private ObjectAnimator mLayoutUpAnimator;
    private int mLayoutWidth;
    private float mOutSlop;
    private float mScaleBaseline;
    private float mScaleTarget;
    private long mUpTime;

    public PressAnimLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void handleActionDown(MotionEvent motionEvent) {
        this.mDownTime = System.currentTimeMillis();
        this.mDownX = motionEvent.getX();
        this.mDownY = motionEvent.getY();
        setupLayoutDownAnimator();
        this.mLayoutDownAnimator.start();
    }

    private void handleActionMove(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        float f = this.mOutSlop;
        if (x < 0.0f - f || x > ((float) this.mLayoutWidth) + f || y < 0.0f || y > ((float) this.mLayoutHeight)) {
            this.mIsTouchCanceled = true;
        }
        if (this.mIsTouchCanceled) {
            handleActionUp(motionEvent);
        }
    }

    private void handleActionUp(MotionEvent motionEvent) {
        long currentTimeMillis = System.currentTimeMillis();
        this.mUpTime = currentTimeMillis;
        long j = currentTimeMillis - this.mDownTime;
        setupLayoutUpAnimator();
        if (j < 128) {
            this.mLayoutUpAnimator.setStartDelay(128 - j);
        } else {
            this.mLayoutUpAnimator.setStartDelay(0);
        }
        this.mLayoutUpAnimator.start();
    }

    private void init() {
        this.mInterpolator = new PathInterpolator(0.33f, 0.0f, 0.33f, 1.0f);
    }

    private void setupLayoutDownAnimator() {
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(FrameLayout.SCALE_X, new float[]{this.mScaleBaseline, this.mScaleTarget});
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat(FrameLayout.SCALE_Y, new float[]{this.mScaleBaseline, this.mScaleTarget});
        ObjectAnimator objectAnimator = this.mLayoutDownAnimator;
        if (objectAnimator == null) {
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{ofFloat, ofFloat2});
            this.mLayoutDownAnimator = ofPropertyValuesHolder;
            ofPropertyValuesHolder.setInterpolator(this.mInterpolator);
            this.mLayoutDownAnimator.setDuration(128);
            return;
        }
        objectAnimator.setValues(new PropertyValuesHolder[]{ofFloat, ofFloat2});
    }

    private void setupLayoutUpAnimator() {
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(FrameLayout.SCALE_X, new float[]{this.mScaleTarget, this.mScaleBaseline});
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat(FrameLayout.SCALE_Y, new float[]{this.mScaleTarget, this.mScaleBaseline});
        ObjectAnimator objectAnimator = this.mLayoutUpAnimator;
        if (objectAnimator == null) {
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{ofFloat, ofFloat2});
            this.mLayoutUpAnimator = ofPropertyValuesHolder;
            ofPropertyValuesHolder.setInterpolator(this.mInterpolator);
            this.mLayoutUpAnimator.setDuration(352);
            return;
        }
        objectAnimator.setValues(new PropertyValuesHolder[]{ofFloat, ofFloat2});
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0014, code lost:
        if (r0 != 3) goto L_0x002d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(android.view.MotionEvent r3) {
        /*
            r2 = this;
            boolean r0 = r2.isEnabled()
            r1 = 1
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            int r0 = r3.getAction()
            if (r0 == 0) goto L_0x002a
            if (r0 == r1) goto L_0x001f
            r1 = 2
            if (r0 == r1) goto L_0x0017
            r1 = 3
            if (r0 == r1) goto L_0x001f
            goto L_0x002d
        L_0x0017:
            boolean r0 = r2.mIsTouchCanceled
            if (r0 != 0) goto L_0x002d
            r2.handleActionMove(r3)
            goto L_0x002d
        L_0x001f:
            boolean r0 = r2.mIsTouchCanceled
            if (r0 != 0) goto L_0x0026
            r2.handleActionUp(r3)
        L_0x0026:
            r0 = 0
            r2.mIsTouchCanceled = r0
            goto L_0x002d
        L_0x002a:
            r2.handleActionDown(r3)
        L_0x002d:
            boolean r2 = super.dispatchTouchEvent(r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.widget.PressAnimLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mLayoutWidth = i;
        this.mLayoutHeight = i2;
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                childAt.setEnabled(z);
            }
        }
    }

    public PressAnimLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PressAnimLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ANIM_DOWN_DURATION = 128;
        this.ANIM_UP_DURATION = 352;
        this.mScaleBaseline = 1.0f;
        this.mScaleTarget = 0.95f;
        this.mIsTouchCanceled = false;
        init();
    }
}
