package com.meizu.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.meizu.common.R;

public abstract class AbsSeekBar extends ProgressBar {
    private static final int INVALID_POINTER = -1;
    private static final int NO_ALPHA = 255;
    public static final int SEEK_BAR_SCROLL_MODE_COMMON = 0;
    public static final int SEEK_BAR_SCROLL_MODE_SLOW = 1;
    private static final String TAG = "AbsSeekBar";
    private int mActivePointerId = -1;
    private float mDisabledAlpha;
    private int mHalfThumbHeight = 0;
    private int mHalfThumbWidth = 0;
    private boolean mInDragging = false;
    private boolean mIsDragging;
    boolean mIsUserSeekable = true;
    boolean mIsVertical = false;
    private int mKeyProgressIncrement = 1;
    private float mLastMotionX;
    private float mLastMotionY;
    private int mScaledTouchSlop;
    private Drawable mThumb;
    private int mThumbOffset;
    private int mTouchDownProgress = 0;
    private float mTouchDownX;
    private float mTouchDownY;
    float mTouchProgressOffset;
    protected int mTouchScrollMode = 0;
    private int mTouchSlopSquare = 256;

    public AbsSeekBar(Context context) {
        super(context);
    }

    private void attemptClaimDrag() {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
    }

    private int getIntFromFloat(float f) {
        return Math.round(f);
    }

    private int getPosByProgress(int i) {
        int width;
        int paddingRight;
        int width2;
        int paddingRight2;
        if (this.mIsVertical) {
            width = getHeight() - getPaddingTop();
            paddingRight = getPaddingBottom();
        } else {
            width = getWidth() - getPaddingLeft();
            paddingRight = getPaddingRight();
        }
        int i2 = width - paddingRight;
        int paddingLeft = getPaddingLeft();
        int paddingBottom = getPaddingBottom();
        float f = ((float) i) - this.mTouchProgressOffset;
        if (f < 0.0f) {
            return this.mIsVertical ? paddingBottom : paddingLeft;
        }
        if (f > ((float) getMax())) {
            if (this.mIsVertical) {
                width2 = getHeight();
                paddingRight2 = getPaddingBottom();
            } else {
                width2 = getWidth();
                paddingRight2 = getPaddingRight();
            }
            return width2 - paddingRight2;
        } else if (getMax() <= 0) {
            return this.mIsVertical ? paddingBottom : paddingLeft;
        } else {
            float f2 = (float) i2;
            return this.mIsVertical ? paddingBottom + ((int) (f2 * (f / ((float) getMax())))) : paddingLeft + ((int) ((f / ((float) getMax())) * f2));
        }
    }

    private int getProgressByPos(int i) {
        int i2;
        if (this.mIsVertical) {
            i2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            i = i2 - i;
        } else {
            i2 = (getWidth() - getPaddingLeft()) - getPaddingRight();
        }
        return (int) (((float) ((i * getMax()) / i2)) - this.mTouchProgressOffset);
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            int i = actionIndex == 0 ? 1 : 0;
            this.mLastMotionX = motionEvent.getX(i);
            this.mLastMotionY = motionEvent.getY(i);
            this.mActivePointerId = motionEvent.getPointerId(i);
        }
    }

    private void setThumbPos(int i, int i2, Drawable drawable, float f, int i3) {
        int i4;
        int i5;
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        int paddingTop = (this.mIsVertical ? ((i2 - getPaddingTop()) - getPaddingBottom()) - intrinsicHeight : ((i - getPaddingLeft()) - getPaddingRight()) - intrinsicWidth) + (this.mThumbOffset * 2);
        if (this.mIsVertical) {
            int i6 = (int) ((1.0f - f) * ((float) paddingTop));
            if (i3 == Integer.MIN_VALUE) {
                Rect bounds = drawable.getBounds();
                i3 = bounds.left;
                i5 = bounds.right;
            } else {
                i5 = i3 + intrinsicWidth;
            }
            drawable.setBounds(i3, i6, i5, intrinsicHeight + i6);
            return;
        }
        int i7 = (int) (f * ((float) paddingTop));
        if (i3 == Integer.MIN_VALUE) {
            Rect bounds2 = drawable.getBounds();
            i3 = bounds2.top;
            i4 = bounds2.bottom;
        } else {
            i4 = i3 + intrinsicHeight;
        }
        drawable.setBounds(i7, i3, intrinsicWidth + i7, i4);
    }

    private void trackTouchEvent(MotionEvent motionEvent) {
        int max;
        float f = 1.0f;
        float f2 = 0.0f;
        if (this.mIsVertical) {
            int height = getHeight();
            int paddingTop = (height - getPaddingTop()) - getPaddingBottom();
            int y = (int) motionEvent.getY();
            if (y >= getPaddingTop()) {
                if (y > height - getPaddingBottom()) {
                    f = 0.0f;
                } else {
                    f = 1.0f - (((float) (y - getPaddingTop())) / ((float) paddingTop));
                    f2 = this.mTouchProgressOffset;
                }
            }
            max = getMax();
        } else {
            int width = getWidth();
            int paddingLeft = (width - getPaddingLeft()) - getPaddingRight();
            int x = (int) motionEvent.getX();
            if (x < getPaddingLeft()) {
                f = 0.0f;
            } else if (x <= width - getPaddingRight()) {
                f = ((float) (x - getPaddingLeft())) / ((float) paddingLeft);
                f2 = this.mTouchProgressOffset;
            }
            max = getMax();
        }
        setProgress((int) (f2 + (f * ((float) max))), true);
    }

    private void updateThumbPos(int i, int i2) {
        Drawable currentDrawable = getCurrentDrawable();
        Drawable drawable = this.mThumb;
        float f = 0.0f;
        if (this.mIsVertical) {
            int intrinsicWidth = drawable == null ? 0 : drawable.getIntrinsicWidth();
            int min = Math.min(this.mMaxWidth, (i - getPaddingLeft()) - getPaddingRight());
            int max = getMax();
            if (max > 0) {
                f = ((float) getProgress()) / ((float) max);
            }
            float f2 = f;
            if (intrinsicWidth > min) {
                if (drawable != null) {
                    setThumbPos(i, i2, drawable, f2, 0);
                }
                int i3 = (intrinsicWidth - min) / 2;
                if (currentDrawable != null) {
                    currentDrawable.setBounds(i3, 0, ((i - getPaddingRight()) - i3) - getPaddingLeft(), (i2 - getPaddingBottom()) - getPaddingTop());
                    return;
                }
                return;
            }
            if (currentDrawable != null) {
                currentDrawable.setBounds(0, 0, (i - getPaddingRight()) - getPaddingLeft(), (i2 - getPaddingBottom()) - getPaddingTop());
            }
            int i4 = (min - intrinsicWidth) / 2;
            if (drawable != null) {
                setThumbPos(i, i2, drawable, f2, i4);
                return;
            }
            return;
        }
        int intrinsicHeight = drawable == null ? 0 : drawable.getIntrinsicHeight();
        int min2 = Math.min(this.mMaxHeight, (i2 - getPaddingTop()) - getPaddingBottom());
        int max2 = getMax();
        if (max2 > 0) {
            f = ((float) getProgress()) / ((float) max2);
        }
        float f3 = f;
        if (intrinsicHeight > min2) {
            if (drawable != null) {
                setThumbPos(i, i2, drawable, f3, 0);
            }
            int i5 = (intrinsicHeight - min2) / 2;
            if (currentDrawable != null) {
                currentDrawable.setBounds(0, i5, (i - getPaddingRight()) - getPaddingLeft(), ((i2 - getPaddingBottom()) - i5) - getPaddingTop());
                return;
            }
            return;
        }
        if (currentDrawable != null) {
            currentDrawable.setBounds(0, 0, (i - getPaddingRight()) - getPaddingLeft(), (i2 - getPaddingBottom()) - getPaddingTop());
        }
        int i6 = (min2 - intrinsicHeight) / 2;
        if (drawable != null) {
            setThumbPos(i, i2, drawable, f3, i6);
        }
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable progressDrawable = getProgressDrawable();
        if (progressDrawable != null) {
            progressDrawable.setAlpha(isEnabled() ? 255 : (int) (this.mDisabledAlpha * 255.0f));
        }
        Drawable drawable = this.mThumb;
        if (drawable != null && drawable.isStateful()) {
            this.mThumb.setState(getDrawableState());
        }
    }

    public int getKeyProgressIncrement() {
        return this.mKeyProgressIncrement;
    }

    public Drawable getThumb() {
        return this.mThumb;
    }

    public int getThumbOffset() {
        return this.mThumbOffset;
    }

    public boolean isInScrollingContainer() {
        for (ViewParent parent = getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
            if (((ViewGroup) parent).shouldDelayChildPressedState()) {
                return true;
            }
        }
        return false;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.mThumb;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public synchronized void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
            if (this.mThumb != null) {
                canvas.save();
                if (this.mIsVertical) {
                    canvas.translate((float) getPaddingLeft(), (float) (getPaddingTop() - this.mThumbOffset));
                    this.mThumb.draw(canvas);
                    canvas.restore();
                } else {
                    canvas.translate((float) (getPaddingLeft() - this.mThumbOffset), (float) getPaddingTop());
                    this.mThumb.draw(canvas);
                    canvas.restore();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(AbsSeekBar.class.getName());
    }

    public void onKeyChange() {
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (isEnabled()) {
            int progress = getProgress();
            if ((i != 21 || this.mIsVertical) && (i != 20 || !this.mIsVertical)) {
                if (((i == 22 && !this.mIsVertical) || (i == 19 && this.mIsVertical)) && progress < getMax()) {
                    setProgress(progress + this.mKeyProgressIncrement, true);
                    onKeyChange();
                    return true;
                }
            } else if (progress > 0) {
                setProgress(progress - this.mKeyProgressIncrement, true);
                onKeyChange();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    public synchronized void onMeasure(int i, int i2) {
        int i3;
        int i4;
        try {
            Drawable currentDrawable = getCurrentDrawable();
            Drawable drawable = this.mThumb;
            int intrinsicHeight = drawable == null ? 0 : drawable.getIntrinsicHeight();
            if (currentDrawable != null) {
                i3 = Math.max(this.mMinWidth, Math.min(this.mMaxWidth, currentDrawable.getIntrinsicWidth()));
                i4 = Math.max(intrinsicHeight, Math.max(this.mMinHeight, Math.min(this.mMaxHeight, currentDrawable.getIntrinsicHeight())));
            } else {
                i4 = 0;
                i3 = 0;
            }
            setMeasuredDimension(View.resolveSizeAndState(i3 + getPaddingLeft() + getPaddingRight(), i, 0), View.resolveSizeAndState(i4 + getPaddingTop() + getPaddingBottom(), i2, 0));
            if (getMeasuredHeight() > getMeasuredWidth()) {
                this.mIsVertical = true;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void onProgressRefresh(float f, boolean z) {
        super.onProgressRefresh(f, z);
        Drawable drawable = this.mThumb;
        if (drawable != null) {
            setThumbPos(getWidth(), getHeight(), drawable, f, Integer.MIN_VALUE);
            invalidate();
        }
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        updateThumbPos(i, i2);
    }

    public void onStartTrackingTouch() {
        this.mIsDragging = true;
    }

    public void onStopTrackingTouch() {
        this.mIsDragging = false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int width;
        int paddingRight;
        float f;
        float f2;
        int width2;
        int paddingRight2;
        if (!this.mIsUserSeekable || !isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action == 1) {
                if (this.mIsDragging) {
                    if (this.mIsVertical) {
                        width = getHeight() - getPaddingTop();
                        paddingRight = getPaddingBottom();
                    } else {
                        width = getWidth() - getPaddingLeft();
                        paddingRight = getPaddingRight();
                    }
                    int i = width - paddingRight;
                    if (this.mTouchScrollMode != 1) {
                        trackTouchEvent(motionEvent);
                    } else if (!this.mInDragging) {
                        int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                        float y = this.mIsVertical ? motionEvent.getY(findPointerIndex) : motionEvent.getX(findPointerIndex);
                        float f3 = ((float) i) - y;
                        if (((float) getPaddingBottom()) + f3 < ((float) (getPosByProgress(this.mTouchDownProgress) - this.mHalfThumbWidth)) || f3 + ((float) getPaddingBottom()) > ((float) (getPosByProgress(this.mTouchDownProgress) + this.mHalfThumbWidth))) {
                            int i2 = (int) y;
                            int progressByPos = getProgressByPos(i2);
                            int i3 = this.mTouchDownProgress;
                            int i4 = this.mKeyProgressIncrement;
                            if (progressByPos >= i3 + i4) {
                                setProgress(i3 + i4, true);
                            } else {
                                int progressByPos2 = getProgressByPos(i2);
                                int i5 = this.mTouchDownProgress;
                                int i6 = this.mKeyProgressIncrement;
                                if (progressByPos2 < i5 + i6) {
                                    setProgress(i5 - i6, true);
                                }
                            }
                        }
                    } else if (i != 0) {
                        int findPointerIndex2 = motionEvent.findPointerIndex(this.mActivePointerId);
                        setProgress(this.mTouchDownProgress + getIntFromFloat((this.mIsVertical ? (this.mLastMotionY - motionEvent.getY(findPointerIndex2)) / ((float) i) : (motionEvent.getX(findPointerIndex2) - this.mLastMotionX) / ((float) i)) * ((float) getMax())), true);
                    }
                    this.mActivePointerId = -1;
                    onStopTrackingTouch();
                    setPressed(false);
                } else {
                    onStartTrackingTouch();
                    trackTouchEvent(motionEvent);
                    this.mActivePointerId = -1;
                    onStopTrackingTouch();
                }
                invalidate();
                this.mInDragging = false;
            } else if (action != 2) {
                if (action == 3) {
                    if (this.mIsDragging) {
                        this.mActivePointerId = -1;
                        onStopTrackingTouch();
                        setPressed(false);
                    }
                    invalidate();
                } else if (action == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    float x = motionEvent.getX(actionIndex);
                    float y2 = motionEvent.getY(actionIndex);
                    this.mLastMotionX = x;
                    this.mLastMotionY = y2;
                    this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                    this.mTouchDownProgress = getProgress();
                } else if (action == 6) {
                    onSecondaryPointerUp(motionEvent);
                    this.mLastMotionX = motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId));
                    this.mLastMotionY = motionEvent.getY(motionEvent.findPointerIndex(this.mActivePointerId));
                    this.mTouchDownProgress = getProgress();
                }
            } else if (!this.mIsDragging) {
                int findPointerIndex3 = motionEvent.findPointerIndex(this.mActivePointerId);
                if ((this.mIsVertical ? Math.abs(motionEvent.getY(findPointerIndex3) - this.mTouchDownY) : Math.abs(motionEvent.getX(findPointerIndex3) - this.mTouchDownX)) > ((float) this.mScaledTouchSlop)) {
                    setPressed(true);
                    Drawable drawable = this.mThumb;
                    if (drawable != null) {
                        invalidate(drawable.getBounds());
                    }
                    onStartTrackingTouch();
                    trackTouchEvent(motionEvent);
                    attemptClaimDrag();
                }
            } else if (this.mTouchScrollMode == 1) {
                int findPointerIndex4 = motionEvent.findPointerIndex(this.mActivePointerId);
                if (findPointerIndex4 < 0) {
                    Log.w(TAG, "Invalid pointer index:" + findPointerIndex4);
                    f2 = motionEvent.getX();
                    f = motionEvent.getY();
                } else {
                    float x2 = motionEvent.getX(findPointerIndex4);
                    f = motionEvent.getY(findPointerIndex4);
                    f2 = x2;
                }
                float abs = Math.abs(f2 - this.mLastMotionX);
                float abs2 = Math.abs(f - this.mLastMotionY);
                if ((abs * abs) + (abs2 * abs2) > ((float) this.mTouchSlopSquare) && !this.mInDragging) {
                    this.mLastMotionX = f2;
                    this.mLastMotionY = f;
                    this.mInDragging = true;
                }
                if (this.mInDragging) {
                    if (this.mIsVertical) {
                        width2 = getHeight() - getPaddingTop();
                        paddingRight2 = getPaddingBottom();
                    } else {
                        width2 = getWidth() - getPaddingLeft();
                        paddingRight2 = getPaddingRight();
                    }
                    int i7 = width2 - paddingRight2;
                    if (i7 != 0) {
                        if (this.mIsVertical) {
                            f2 = this.mLastMotionY;
                        } else {
                            f = this.mLastMotionX;
                        }
                        setProgress(this.mTouchDownProgress + getIntFromFloat(((f2 - f) / ((float) i7)) * ((float) getMax())), true);
                    }
                }
            } else {
                trackTouchEvent(motionEvent);
            }
        } else if (!isInScrollingContainer()) {
            setPressed(true);
            Drawable drawable2 = this.mThumb;
            if (drawable2 != null) {
                invalidate(drawable2.getBounds());
            }
            onStartTrackingTouch();
            this.mTouchDownProgress = 0;
            if (this.mTouchScrollMode == 1) {
                this.mLastMotionX = motionEvent.getX();
                this.mLastMotionY = motionEvent.getY();
                this.mActivePointerId = motionEvent.getPointerId(0);
                this.mInDragging = false;
                this.mTouchDownProgress = getProgress();
            } else {
                trackTouchEvent(motionEvent);
            }
            attemptClaimDrag();
        } else if (this.mTouchScrollMode == 1) {
            onStartTrackingTouch();
            this.mInDragging = false;
            float x3 = motionEvent.getX();
            this.mTouchDownX = x3;
            this.mLastMotionX = x3;
            float y3 = motionEvent.getY();
            this.mTouchDownY = y3;
            this.mLastMotionY = y3;
            this.mActivePointerId = motionEvent.getPointerId(0);
            this.mTouchDownProgress = getProgress();
            attemptClaimDrag();
        }
        return true;
    }

    public void setKeyProgressIncrement(int i) {
        if (i < 0) {
            i = -i;
        }
        this.mKeyProgressIncrement = i;
    }

    public synchronized void setMax(int i) {
        try {
            super.setMax(i);
            if (this.mKeyProgressIncrement != 0) {
                if (getMax() / this.mKeyProgressIncrement > 20) {
                }
            }
            setKeyProgressIncrement(Math.max(1, Math.round(((float) getMax()) / 20.0f)));
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setThumb(Drawable drawable) {
        boolean z;
        Drawable drawable2 = this.mThumb;
        if (drawable2 == null || drawable == drawable2) {
            z = false;
        } else {
            drawable2.setCallback((Drawable.Callback) null);
            z = true;
        }
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.mIsVertical) {
                this.mThumbOffset = drawable.getIntrinsicHeight() / 2;
            } else {
                this.mThumbOffset = drawable.getIntrinsicWidth() / 2;
            }
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
            if (drawable.isStateful()) {
                drawable.setState(getDrawableState());
            }
        }
    }

    public void setThumbOffset(int i) {
        this.mThumbOffset = i;
        invalidate();
    }

    public void setTouchMode(int i) {
        if (i < 0 || i > 1) {
            Log.w(TAG, "mode:" + i + " should be one of common or slow.");
            return;
        }
        Log.i(TAG, "setTouchMode:" + i);
        this.mTouchScrollMode = i;
    }

    public boolean verifyDrawable(Drawable drawable) {
        return drawable == this.mThumb || super.verifyDrawable(drawable);
    }

    public AbsSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AbsSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SeekBar, i, 0);
        setThumb(obtainStyledAttributes.getDrawable(R.styleable.SeekBar_mcThumb));
        setThumbOffset(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.SeekBar_mcThumbOffset, getThumbOffset()));
        obtainStyledAttributes.recycle();
        this.mDisabledAlpha = 0.5f;
        int scaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mScaledTouchSlop = scaledTouchSlop;
        this.mTouchSlopSquare = scaledTouchSlop * scaledTouchSlop;
    }
}
