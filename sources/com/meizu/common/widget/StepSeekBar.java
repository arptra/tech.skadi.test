package com.meizu.common.widget;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.RequiresApi;
import com.meizu.common.R;
import com.meizu.common.util.CommonUtils;

public class StepSeekBar extends View {
    private static final int MIN_WIDTH = 64;
    private static final String TAG = "StepSeekBar";
    private static final int TIMEOUT_SEND_ACCESSIBILITY_EVENT = 200;
    private boolean hasMoved;
    private boolean isDrag;
    private AccessibilityEventSender mAccessibilityEventSender;
    private boolean mAccessibilityFocused;
    private ValueAnimator mDrawablePositionAnimator;
    /* access modifiers changed from: private */
    public DrawableXYHolder mDrawableXYHolder;
    private boolean mEnableEngine;
    private XYHolder mEndXY;
    private int mHalfThumbHeight;
    private int mHalfThumbWidth;
    private float mInitialThumbX;
    private float mInitialTouchX;
    private boolean mIsDragging;
    private boolean mIsInItemPositon;
    private Interpolator mLocationInterpolator;
    private int mMax;
    private OnStepSeekBarChangeListener mOnStepSeekBarChangeListener;
    private Paint mPaint;
    private int mPaintColor;
    private ColorStateList mPaintColorStateList;
    private int mProgress;
    private int mScaledTouchSlop;
    private int mSpotColor;
    private ColorStateList mSpotColorStateList;
    private float mSpotPadding;
    private float mSpotRadius;
    private XYHolder mStartXY;
    private int mStrokeColor;
    private ColorStateList mStrokeColorStateList;
    private int mStrokeWidth;
    private Drawable mThumb;
    private float mThumbScaleValue;
    private int mTouchDownProgress;
    private XYEvaluator mXYEvaluator;

    public class AccessibilityEventSender implements Runnable {
        private AccessibilityEventSender() {
        }

        public void run() {
            StepSeekBar.this.sendAccessibilityEvent(4);
        }
    }

    public class DrawableXYHolder {
        private Drawable mDrawable;

        public DrawableXYHolder() {
        }

        public XYHolder getXY() {
            Drawable drawable = this.mDrawable;
            if (drawable == null) {
                return null;
            }
            Rect bounds = drawable.getBounds();
            return new XYHolder((float) bounds.left, (float) bounds.top);
        }

        public void setDrawable(Drawable drawable) {
            this.mDrawable = drawable;
        }

        public void setXY(XYHolder xYHolder) {
            Drawable drawable = this.mDrawable;
            if (drawable != null) {
                drawable.setBounds((int) xYHolder.getX(), (int) xYHolder.getY(), (int) (xYHolder.getX() + ((float) this.mDrawable.getIntrinsicWidth())), (int) (xYHolder.getY() + ((float) this.mDrawable.getIntrinsicHeight())));
                StepSeekBar.this.invalidate();
            }
        }

        public DrawableXYHolder(Drawable drawable) {
            this.mDrawable = drawable;
        }
    }

    public interface OnStepSeekBarChangeListener {
        void onProgressChanged(StepSeekBar stepSeekBar, int i);

        void onProgressDragging(StepSeekBar stepSeekBar, int i);

        void onStartTrackingTouch(StepSeekBar stepSeekBar);

        void onStopTrackingTouch(StepSeekBar stepSeekBar);
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int progress;

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.progress);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.progress = parcel.readInt();
        }
    }

    public class XYEvaluator implements TypeEvaluator {
        private XYEvaluator() {
        }

        public Object evaluate(float f, Object obj, Object obj2) {
            XYHolder xYHolder = (XYHolder) obj;
            XYHolder xYHolder2 = (XYHolder) obj2;
            return new XYHolder(xYHolder.getX() + ((xYHolder2.getX() - xYHolder.getX()) * f), xYHolder.getY() + (f * (xYHolder2.getY() - xYHolder.getY())));
        }
    }

    public StepSeekBar(Context context) {
        this(context, (AttributeSet) null);
    }

    private void attemptClaimDrag() {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
    }

    private void flingThumb(MotionEvent motionEvent) {
        ValueAnimator valueAnimator = this.mDrawablePositionAnimator;
        if (valueAnimator == null || !valueAnimator.isStarted()) {
            getWidth();
            int progressAvailableWidth = getProgressAvailableWidth();
            Rect bounds = this.mThumb.getBounds();
            int x = (int) ((this.mInitialThumbX + ((float) ((int) motionEvent.getX()))) - this.mInitialTouchX);
            if (x < 0) {
                x = 0;
            } else if (x > progressAvailableWidth) {
                x = progressAvailableWidth;
            }
            int round = isRTL() ? Math.round((1.0f - (((float) x) / ((float) progressAvailableWidth))) * ((float) getMax())) : Math.round((((float) x) / ((float) progressAvailableWidth)) * ((float) getMax()));
            setProgress(round, true, true);
            int max = isRTL() ? (int) (((float) progressAvailableWidth) * (1.0f - (((float) round) / ((float) getMax())))) : (progressAvailableWidth * round) / getMax();
            Drawable drawable = this.mThumb;
            drawable.setBounds(max, bounds.top, drawable.getIntrinsicWidth() + max, bounds.bottom);
            invalidate();
        }
    }

    private int getDisabledColor(ColorStateList colorStateList) {
        return colorStateList.getColorForState(new int[]{-16842910}, 0);
    }

    private synchronized int getMax() {
        return this.mMax;
    }

    private int getNormalColor(ColorStateList colorStateList) {
        return colorStateList.getColorForState(new int[]{16842910}, 0);
    }

    private int getProgressAvailableWidth() {
        return ((getWidth() - getPaddingLeft()) - getPaddingRight()) - this.mStrokeWidth;
    }

    public static String getTAG() {
        return TAG;
    }

    private int getTouchWidth() {
        return (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private boolean isPointInside(int i, int i2) {
        return true;
    }

    private boolean isRTL() {
        return getContext().getResources().getConfiguration().getLayoutDirection() == 1;
    }

    /* access modifiers changed from: private */
    public void notifyProgressChanged() {
        OnStepSeekBarChangeListener onStepSeekBarChangeListener = this.mOnStepSeekBarChangeListener;
        if (onStepSeekBarChangeListener != null) {
            onStepSeekBarChangeListener.onProgressChanged(this, getProgress());
        }
    }

    private void onProgressRefresh(float f) {
        Drawable drawable = this.mThumb;
        if (drawable != null) {
            setThumbPos(getWidth(), drawable, f, Integer.MIN_VALUE);
        }
    }

    private void refreshRes() {
        if (isEnabled()) {
            this.mStrokeColor = getNormalColor(this.mStrokeColorStateList);
            this.mSpotColor = getNormalColor(this.mSpotColorStateList);
            this.mPaintColor = getNormalColor(this.mPaintColorStateList);
            return;
        }
        this.mStrokeColor = getDisabledColor(this.mStrokeColorStateList);
        this.mSpotColor = getDisabledColor(this.mSpotColorStateList);
        this.mPaintColor = getDisabledColor(this.mPaintColorStateList);
    }

    private void scheduleAccessibilityEventSender() {
        AccessibilityEventSender accessibilityEventSender = this.mAccessibilityEventSender;
        if (accessibilityEventSender == null) {
            this.mAccessibilityEventSender = new AccessibilityEventSender();
        } else {
            removeCallbacks(accessibilityEventSender);
        }
        postDelayed(this.mAccessibilityEventSender, 200);
    }

    private synchronized void setMax(int i) {
        if (i < 0) {
            i = 0;
        }
        try {
            if (i != this.mMax) {
                this.mMax = i;
                if (this.mProgress > i) {
                    this.mProgress = i;
                }
                onProgressRefresh(i > 0 ? ((float) this.mProgress) / ((float) i) : 0.0f);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0056, code lost:
        if (r7.isStarted() != false) goto L_0x005a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void setThumbPos(int r9, android.graphics.drawable.Drawable r10, float r11, int r12) {
        /*
            r8 = this;
            int r0 = r8.getPaddingLeft()
            int r9 = r9 - r0
            int r0 = r8.getPaddingRight()
            int r9 = r9 - r0
            int r0 = r8.mStrokeWidth
            int r9 = r9 - r0
            int r0 = r10.getIntrinsicWidth()
            boolean r1 = r8.isRTL()
            if (r1 == 0) goto L_0x0021
            float r1 = (float) r9
            float r11 = r11 * r1
            int r11 = java.lang.Math.round(r11)
            int r11 = r9 - r11
            int r9 = r9 - r11
            goto L_0x002d
        L_0x0021:
            r1 = 1065353216(0x3f800000, float:1.0)
            float r1 = r1 - r11
            float r11 = (float) r9
            float r1 = r1 * r11
            int r11 = java.lang.Math.round(r1)
            int r11 = r9 - r11
            r9 = r11
        L_0x002d:
            int r0 = r0 + r9
            r1 = 0
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1
            if (r12 != r2) goto L_0x003e
            android.graphics.Rect r4 = r10.getBounds()
            int r5 = r4.top
            int r4 = r4.bottom
            r6 = r3
            goto L_0x0045
        L_0x003e:
            int r4 = r10.getIntrinsicHeight()
            int r4 = r4 + r12
            r5 = r12
            r6 = r1
        L_0x0045:
            android.animation.ValueAnimator r7 = r8.mDrawablePositionAnimator
            if (r7 == 0) goto L_0x0059
            if (r6 != 0) goto L_0x0052
            r7.cancel()
            r1 = 0
            r8.mDrawablePositionAnimator = r1
            goto L_0x0059
        L_0x0052:
            boolean r7 = r7.isStarted()
            if (r7 == 0) goto L_0x0059
            goto L_0x005a
        L_0x0059:
            r1 = r6
        L_0x005a:
            if (r1 == 0) goto L_0x00cb
            android.graphics.Rect r9 = r10.getBounds()
            int r9 = r9.left
            if (r9 != r11) goto L_0x006c
            r8.mIsInItemPositon = r3
            if (r12 != r2) goto L_0x006b
            r8.notifyProgressChanged()
        L_0x006b:
            return
        L_0x006c:
            com.meizu.common.widget.StepSeekBar$XYHolder r12 = r8.mStartXY
            float r9 = (float) r9
            float r0 = (float) r5
            r12.setXY(r9, r0)
            com.meizu.common.widget.StepSeekBar$XYHolder r9 = r8.mEndXY
            float r11 = (float) r11
            r9.setXY(r11, r0)
            com.meizu.common.widget.StepSeekBar$DrawableXYHolder r9 = r8.mDrawableXYHolder
            r9.setDrawable(r10)
            com.meizu.common.widget.StepSeekBar$XYEvaluator r9 = r8.mXYEvaluator
            com.meizu.common.widget.StepSeekBar$XYHolder r10 = r8.mStartXY
            com.meizu.common.widget.StepSeekBar$XYHolder r11 = r8.mEndXY
            java.lang.Object[] r10 = new java.lang.Object[]{r10, r11}
            android.animation.ValueAnimator r9 = android.animation.ValueAnimator.ofObject(r9, r10)
            r8.mDrawablePositionAnimator = r9
            com.meizu.common.widget.StepSeekBar$XYHolder r9 = r8.mEndXY
            float r9 = r9.getX()
            com.meizu.common.widget.StepSeekBar$XYHolder r10 = r8.mStartXY
            float r10 = r10.getX()
            float r9 = r9 - r10
            float r9 = java.lang.Math.abs(r9)
            r10 = 1055100473(0x3ee38e39, float:0.44444445)
            float r9 = r9 * r10
            int r9 = (int) r9
            android.animation.ValueAnimator r10 = r8.mDrawablePositionAnimator
            long r11 = (long) r9
            r10.setDuration(r11)
            android.animation.ValueAnimator r9 = r8.mDrawablePositionAnimator
            android.view.animation.Interpolator r10 = r8.mLocationInterpolator
            r9.setInterpolator(r10)
            android.animation.ValueAnimator r9 = r8.mDrawablePositionAnimator
            com.meizu.common.widget.StepSeekBar$1 r10 = new com.meizu.common.widget.StepSeekBar$1
            r10.<init>()
            r9.addListener(r10)
            android.animation.ValueAnimator r9 = r8.mDrawablePositionAnimator
            com.meizu.common.widget.StepSeekBar$2 r10 = new com.meizu.common.widget.StepSeekBar$2
            r10.<init>()
            r9.addUpdateListener(r10)
            android.animation.ValueAnimator r9 = r8.mDrawablePositionAnimator
            r9.start()
            goto L_0x00d3
        L_0x00cb:
            android.graphics.drawable.Drawable r10 = r8.mThumb
            r10.setBounds(r9, r5, r0, r4)
            r8.invalidate()
        L_0x00d3:
            r8.mIsInItemPositon = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.widget.StepSeekBar.setThumbPos(int, android.graphics.drawable.Drawable, float, int):void");
    }

    private void trackTapUpTouchEvent(MotionEvent motionEvent) {
        float f;
        int round;
        int i;
        int progress;
        int progress2;
        ValueAnimator valueAnimator = this.mDrawablePositionAnimator;
        if (valueAnimator == null || !valueAnimator.isStarted()) {
            getWidth();
            int touchWidth = getTouchWidth();
            float x = (float) ((int) motionEvent.getX());
            float f2 = 0.0f;
            if (x < ((float) getPaddingLeft())) {
                if (isRTL()) {
                    int progress3 = getProgress() + 1;
                    i = this.mMax;
                    if (progress3 <= i) {
                        progress = getProgress();
                        round = progress + 1;
                        f = (float) round;
                        float f3 = f / ((float) this.mMax);
                        setProgress((int) f, true, true);
                        setThumbPos(getWidth(), this.mThumb, f3, Integer.MIN_VALUE);
                    }
                } else {
                    if (getProgress() - 1 >= 0) {
                        progress2 = getProgress();
                        f2 = (float) (progress2 - 1);
                    }
                    f = f2;
                    float f32 = f / ((float) this.mMax);
                    setProgress((int) f, true, true);
                    setThumbPos(getWidth(), this.mThumb, f32, Integer.MIN_VALUE);
                }
            } else if (x <= ((float) (getPaddingLeft() + touchWidth))) {
                round = isRTL() ? Math.round((1.0f - ((x - ((float) getPaddingLeft())) / ((float) touchWidth))) * ((float) this.mMax)) : Math.round(((x - ((float) getPaddingLeft())) / ((float) touchWidth)) * ((float) this.mMax));
                f = (float) round;
                float f322 = f / ((float) this.mMax);
                setProgress((int) f, true, true);
                setThumbPos(getWidth(), this.mThumb, f322, Integer.MIN_VALUE);
            } else if (isRTL()) {
                if (getProgress() - 1 >= 0) {
                    progress2 = getProgress();
                    f2 = (float) (progress2 - 1);
                }
                f = f2;
                float f3222 = f / ((float) this.mMax);
                setProgress((int) f, true, true);
                setThumbPos(getWidth(), this.mThumb, f3222, Integer.MIN_VALUE);
            } else {
                int progress4 = getProgress() + 1;
                i = this.mMax;
                if (progress4 <= i) {
                    progress = getProgress();
                    round = progress + 1;
                    f = (float) round;
                    float f32222 = f / ((float) this.mMax);
                    setProgress((int) f, true, true);
                    setThumbPos(getWidth(), this.mThumb, f32222, Integer.MIN_VALUE);
                }
            }
            f = (float) i;
            float f322222 = f / ((float) this.mMax);
            setProgress((int) f, true, true);
            setThumbPos(getWidth(), this.mThumb, f322222, Integer.MIN_VALUE);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x001e, code lost:
        if (isRTL() != false) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0033, code lost:
        if (isRTL() != false) goto L_0x0021;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void trackTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r5.getWidth()
            int r1 = r5.getProgressAvailableWidth()
            float r6 = r6.getX()
            int r6 = (int) r6
            float r2 = r5.mInitialThumbX
            float r6 = (float) r6
            float r2 = r2 + r6
            float r6 = r5.mInitialTouchX
            float r2 = r2 - r6
            int r6 = (int) r2
            r2 = 1065353216(0x3f800000, float:1.0)
            r3 = 0
            if (r6 >= 0) goto L_0x0023
            boolean r6 = r5.isRTL()
            if (r6 == 0) goto L_0x0021
            goto L_0x0045
        L_0x0021:
            r2 = r3
            goto L_0x0045
        L_0x0023:
            int r4 = r5.getPaddingRight()
            int r0 = r0 - r4
            int r4 = r5.mHalfThumbWidth
            int r4 = r4 * 2
            int r0 = r0 - r4
            if (r6 <= r0) goto L_0x0036
            boolean r6 = r5.isRTL()
            if (r6 == 0) goto L_0x0045
            goto L_0x0021
        L_0x0036:
            boolean r0 = r5.isRTL()
            if (r0 == 0) goto L_0x0041
            float r6 = (float) r6
            float r0 = (float) r1
            float r6 = r6 / r0
            float r2 = r2 - r6
            goto L_0x0045
        L_0x0041:
            float r6 = (float) r6
            float r0 = (float) r1
            float r2 = r6 / r0
        L_0x0045:
            int r6 = r5.getMax()
            float r6 = (float) r6
            float r2 = r2 * r6
            float r2 = r2 + r3
            int r6 = java.lang.Math.round(r2)
            r0 = 0
            r1 = 1
            r5.setProgress(r6, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.widget.StepSeekBar.trackTouchEvent(android.view.MotionEvent):void");
    }

    private void updateThumbPos(int i, int i2) {
        Drawable drawable = this.mThumb;
        int max = getMax();
        float f = max > 0 ? isRTL() ? 1.0f - (((float) this.mProgress) / ((float) max)) : ((float) this.mProgress) / ((float) max) : 0.0f;
        if (drawable != null) {
            setThumbPos(i, drawable, f, 0);
        }
    }

    public void drawableStateChanged() {
        int[] drawableState = getDrawableState();
        Drawable drawable = this.mThumb;
        if (drawable != null && drawable.isStateful()) {
            this.mThumb.setState(drawableState);
        }
        super.drawableStateChanged();
        invalidate();
    }

    public CharSequence getAccessibilityClassName() {
        return StepSeekBar.class.getName();
    }

    public synchronized int getProgress() {
        return this.mProgress;
    }

    public int getStrokeColor() {
        return this.mStrokeColor;
    }

    public int getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public Drawable getThumb() {
        return this.mThumb;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mPaintColorStateList = getResources().getColorStateList(R.color.mz_seekbar_background_state_color);
        refreshDrawableState();
        refreshRes();
        invalidate();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AccessibilityEventSender accessibilityEventSender = this.mAccessibilityEventSender;
        if (accessibilityEventSender != null) {
            this.mAccessibilityFocused = false;
            removeCallbacks(accessibilityEventSender);
        }
    }

    public synchronized void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
            if (this.mThumb != null) {
                getMeasuredHeight();
                Rect bounds = this.mThumb.getBounds();
                canvas.save();
                canvas.translate((float) getPaddingLeft(), (float) (getPaddingTop() + (this.mStrokeWidth / 2)));
                float progressAvailableWidth = (float) getProgressAvailableWidth();
                this.mPaint.setStrokeWidth((float) this.mStrokeWidth);
                this.mPaint.setColor(this.mPaintColor);
                this.mPaint.setAntiAlias(true);
                this.mPaint.setStrokeCap(Paint.Cap.ROUND);
                int i = this.mStrokeWidth;
                canvas.drawLine((float) (i / 2), 0.0f, progressAvailableWidth + ((float) (i / 2)), 0.0f, this.mPaint);
                canvas.restore();
                canvas.save();
                int max = getMax();
                float f = max > 0 ? progressAvailableWidth / ((float) max) : 0.0f;
                canvas.translate(((float) getPaddingLeft()) + this.mSpotPadding, (float) (getPaddingTop() + (this.mStrokeWidth / 2)));
                for (int i2 = 0; i2 <= max; i2++) {
                    this.mPaint.setColor(this.mSpotColor);
                    float f2 = this.mSpotRadius;
                    canvas.drawCircle((((float) i2) * f) + f2, 0.0f, f2, this.mPaint);
                }
                canvas.restore();
                canvas.save();
                canvas.translate(((float) getPaddingLeft()) + ((this.mSpotPadding + this.mSpotRadius) - ((float) this.mHalfThumbWidth)), (float) (getPaddingTop() + ((this.mStrokeWidth / 2) - this.mHalfThumbHeight)));
                float f3 = this.mThumbScaleValue;
                canvas.scale(f3, f3, (float) bounds.centerX(), (float) bounds.centerY());
                this.mThumb.draw(canvas);
                canvas.restore();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        if (accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled()) {
            int action = motionEvent.getAction();
            if (action == 7) {
                motionEvent.setAction(2);
            } else if (action == 9) {
                motionEvent.setAction(0);
            } else if (action == 10) {
                motionEvent.setAction(1);
            }
            motionEvent.setAction(action);
        }
        return super.onHoverEvent(motionEvent);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(StepSeekBar.class.getName());
        accessibilityEvent.setItemCount(this.mMax);
        accessibilityEvent.setCurrentItemIndex(this.mProgress);
    }

    @RequiresApi
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(StepSeekBar.class.getName());
        if (isEnabled()) {
            int progress = getProgress();
            accessibilityNodeInfo.setRangeInfo(AccessibilityNodeInfo.RangeInfo.obtain(0, 0.0f, (float) getMax(), (float) progress));
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS);
            if (progress > 0) {
                accessibilityNodeInfo.addAction(8192);
            }
            if (progress < getMax()) {
                accessibilityNodeInfo.addAction(4096);
            }
        }
    }

    public synchronized void onMeasure(int i, int i2) {
        try {
            Drawable drawable = this.mThumb;
            int intrinsicHeight = drawable == null ? 0 : drawable.getIntrinsicHeight();
            int minimumHeight = getMinimumHeight();
            int paddingLeft = getPaddingLeft() + 64 + getPaddingRight();
            if (intrinsicHeight != 0) {
                minimumHeight = Math.max(intrinsicHeight, minimumHeight);
            }
            setMeasuredDimension(View.resolveSizeAndState(Math.max(paddingLeft, View.MeasureSpec.getSize(i)), i, 0), View.resolveSizeAndState(minimumHeight + getPaddingTop() + getPaddingBottom(), i2, 0));
        } catch (Throwable th) {
            throw th;
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            setProgress(savedState.progress, true, false);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.progress = this.mProgress;
        return savedState;
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        updateThumbPos(i, i2);
    }

    public void onStartTrackingTouch() {
        this.mIsDragging = true;
        OnStepSeekBarChangeListener onStepSeekBarChangeListener = this.mOnStepSeekBarChangeListener;
        if (onStepSeekBarChangeListener != null) {
            onStepSeekBarChangeListener.onStartTrackingTouch(this);
        }
    }

    public void onStopTrackingTouch() {
        this.mIsDragging = false;
        OnStepSeekBarChangeListener onStepSeekBarChangeListener = this.mOnStepSeekBarChangeListener;
        if (onStepSeekBarChangeListener != null) {
            onStepSeekBarChangeListener.onStopTrackingTouch(this);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || getMax() == 0) {
            return false;
        }
        float x = motionEvent.getX();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.isDrag = false;
            this.mTouchDownProgress = Math.round(((x - ((float) getPaddingLeft())) / ((float) getProgressAvailableWidth())) * ((float) getMax()));
            trackTapUpTouchEvent(motionEvent);
            if (isPointInside((int) motionEvent.getX(), (int) motionEvent.getY())) {
                setPressed(true);
                Drawable drawable = this.mThumb;
                if (drawable != null) {
                    invalidate(drawable.getBounds());
                }
                onStartTrackingTouch();
            }
            Drawable drawable2 = this.mThumb;
            if (drawable2 != null) {
                float f = (float) drawable2.getBounds().left;
                this.mInitialThumbX = f;
                this.mInitialTouchX = f;
            }
            attemptClaimDrag();
            this.hasMoved = false;
        } else if (action != 1) {
            if (action == 2) {
                ValueAnimator valueAnimator = this.mDrawablePositionAnimator;
                if (valueAnimator != null && valueAnimator.isStarted()) {
                    return true;
                }
                if (this.mIsDragging) {
                    this.mIsInItemPositon = false;
                    flingThumb(motionEvent);
                    attemptClaimDrag();
                }
                if (Math.abs(motionEvent.getX() - this.mInitialTouchX) > ((float) this.mScaledTouchSlop)) {
                    this.hasMoved = true;
                    this.isDrag = true;
                    Drawable drawable3 = this.mThumb;
                    if (drawable3 != null) {
                        invalidate(drawable3.getBounds());
                    }
                } else {
                    this.hasMoved = false;
                }
            } else if (action == 3) {
                if (this.mIsDragging) {
                    onStopTrackingTouch();
                    setPressed(false);
                }
                invalidate();
            }
        } else if (!this.hasMoved) {
            trackTapUpTouchEvent(motionEvent);
            setPressed(false);
            Drawable drawable4 = this.mThumb;
            if (drawable4 != null) {
                invalidate(drawable4.getBounds());
            }
        } else {
            Drawable drawable5 = this.mThumb;
            if (drawable5 != null) {
                invalidate(drawable5.getBounds());
            }
            if (this.mIsDragging) {
                trackTouchEvent(motionEvent);
                onStopTrackingTouch();
                setPressed(false);
            } else {
                setProgress(this.mTouchDownProgress, false, true);
            }
        }
        return true;
    }

    public boolean performAccessibilityAction(int i, Bundle bundle) {
        if (i == 64) {
            this.mAccessibilityFocused = true;
        } else if (i == 128) {
            this.mAccessibilityFocused = false;
        }
        if (super.performAccessibilityAction(i, bundle)) {
            return true;
        }
        if (!isEnabled()) {
            return false;
        }
        int progress = getProgress();
        if (i != 4096) {
            if (i != 8192) {
                if (i != 16908349 || !isEnabled() || bundle == null || !bundle.containsKey("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE")) {
                    return false;
                }
                setProgress((int) bundle.getFloat("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE"), true, true);
                return true;
            } else if (progress <= 0) {
                return false;
            } else {
                setProgress(progress - 1, false, false);
                return true;
            }
        } else if (progress >= getMax()) {
            return false;
        } else {
            setProgress(progress + 1, false, false);
            return true;
        }
    }

    public void setEnableEngine(boolean z) {
        this.mEnableEngine = z;
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        refreshRes();
        invalidate();
    }

    public void setItemsCount(int i) {
        if (i < 1) {
            setMax(0);
        } else {
            setMax(i - 1);
        }
    }

    public void setOnStepSeekBarChangeListener(OnStepSeekBarChangeListener onStepSeekBarChangeListener) {
        this.mOnStepSeekBarChangeListener = onStepSeekBarChangeListener;
    }

    public void setPaintColor(int i) {
        this.mPaintColor = i;
    }

    public synchronized void setProgress(int i) {
        setProgress(i, false, false);
    }

    public void setStrokeColor(int i) {
        this.mStrokeColor = i;
    }

    public void setStrokeWidth(int i) {
        this.mStrokeWidth = i;
    }

    public final void setThumb(Drawable drawable) {
        boolean z;
        if (drawable == null) {
            drawable = getResources().getDrawable(R.drawable.mz_step_seekbar_thumb);
        }
        Drawable drawable2 = this.mThumb;
        if (drawable2 == null || drawable == drawable2) {
            z = false;
        } else {
            drawable2.setCallback((Drawable.Callback) null);
            this.mThumb.getIntrinsicWidth();
            z = true;
        }
        if (drawable != null) {
            drawable.setCallback(this);
            if (z && !(drawable.getIntrinsicWidth() == this.mThumb.getIntrinsicWidth() && drawable.getIntrinsicHeight() == this.mThumb.getIntrinsicHeight())) {
                requestLayout();
            }
            this.mHalfThumbWidth = drawable.getIntrinsicWidth() / 2;
            this.mHalfThumbHeight = drawable.getIntrinsicHeight() / 2;
        }
        this.mThumb = drawable;
        invalidate();
        if (z) {
            updateThumbPos(getWidth(), getHeight());
            if (drawable != null && drawable.isStateful()) {
                drawable.setState(getDrawableState());
            }
        }
    }

    public class XYHolder {
        private float mX;
        private float mY;

        public XYHolder() {
            this.mY = 0.0f;
            this.mX = 0.0f;
        }

        public float getX() {
            return this.mX;
        }

        public float getY() {
            return this.mY;
        }

        public void setX(float f) {
            this.mX = f;
        }

        public void setXY(float f, float f2) {
            this.mX = f;
            this.mY = f2;
        }

        public void setY(float f) {
            this.mY = f;
        }

        public XYHolder(float f, float f2) {
            this.mX = f;
            this.mY = f2;
        }
    }

    public StepSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.MeizuCommon_StepSeekBarStyle);
    }

    public StepSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isDrag = false;
        this.mTouchDownProgress = 0;
        this.mHalfThumbWidth = 0;
        this.mHalfThumbHeight = 0;
        this.mThumbScaleValue = 1.0f;
        this.mStartXY = new XYHolder();
        this.mEndXY = new XYHolder();
        this.mXYEvaluator = new XYEvaluator();
        this.mDrawableXYHolder = new DrawableXYHolder();
        this.hasMoved = false;
        this.mAccessibilityFocused = false;
        this.mEnableEngine = true;
        this.mScaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.StepSeekBar, i, R.style.Widget_MeizuCommon_StepSeekBar);
        setProgress(obtainStyledAttributes.getInt(R.styleable.StepSeekBar_mcStepProgress, 0));
        setItemsCount(obtainStyledAttributes.getInt(R.styleable.StepSeekBar_mcStepItemsCount, 1));
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.StepSeekBar_mcStepThumb);
        drawable = drawable == null ? context.getResources().getDrawable(R.drawable.mz_step_seekbar_thumb) : drawable;
        this.mStrokeWidth = (int) obtainStyledAttributes.getDimension(R.styleable.StepSeekBar_mcStepStrokeWidth, getResources().getDimension(R.dimen.mc_enhance_seekbar_stroke_width));
        this.mStrokeColorStateList = obtainStyledAttributes.getColorStateList(R.styleable.StepSeekBar_mcStepStrokeColor);
        setThumb(drawable);
        this.mPaintColorStateList = getResources().getColorStateList(R.color.mz_seekbar_background_state_color);
        this.mSpotColorStateList = getResources().getColorStateList(R.color.mz_enhance_seekbar_spot_color);
        this.mSpotRadius = getResources().getDimension(R.dimen.mc_enhance_seekbar_spot_radius);
        this.mSpotPadding = (float) obtainStyledAttributes.getDimensionPixelOffset(R.styleable.StepSeekBar_mzStepSpotPadding, 0);
        obtainStyledAttributes.recycle();
        refreshDrawableState();
        refreshRes();
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(this.mPaintColor);
        this.mLocationInterpolator = new PathInterpolator(0.2f, 0.31f, 0.34f, 1.0f);
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        setForceDarkAllowed(false);
        CommonUtils.disableDarkMode(this);
    }

    public synchronized void setProgress(int i, boolean z, boolean z2) {
        if (i < 0) {
            i = 0;
        }
        try {
            int i2 = this.mMax;
            if (i > i2) {
                i = i2;
            }
            if (i != this.mProgress && z2 && this.mEnableEngine) {
                CommonUtils.shakeForFlymeFeature(this, 31015);
            }
            if (i != this.mProgress || !this.mIsInItemPositon) {
                this.mProgress = i;
                if (!z) {
                    int i3 = this.mMax;
                    onProgressRefresh(i3 > 0 ? ((float) i) / ((float) i3) : 0.0f);
                } else {
                    OnStepSeekBarChangeListener onStepSeekBarChangeListener = this.mOnStepSeekBarChangeListener;
                    if (onStepSeekBarChangeListener != null && this.mIsDragging) {
                        onStepSeekBarChangeListener.onProgressDragging(this, getProgress());
                    }
                }
                AccessibilityManager accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
                if (accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled() && this.mAccessibilityFocused) {
                    scheduleAccessibilityEventSender();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
