package com.meizu.common.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
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
import android.text.TextPaint;
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

public class EnhanceSeekBar extends View {
    private static final int AURA_HIDE_ANIM_TIME = 200;
    private static final float AURA_SCALE_BASELINE = 1.0f;
    private static final float AURA_SCALE_TARGET = 0.5f;
    private static final int AURA_SHOW_ANIM_TIME = 180;
    private static final int MIN_HEIGHT = 20;
    private static final int MIN_WIDTH = 64;
    private static final String TAG = "EnhanceSeekBar";
    private static final float THUMB_SCALE_BASELINE = 1.0f;
    private static final float THUMB_SCALE_TARGET = 0.7f;
    private static final int TIMEOUT_SEND_ACCESSIBILITY_EVENT = 200;
    private boolean hasMoved;
    private int iconPadding;
    private int iconWidth;
    private boolean isAuraShow;
    /* access modifiers changed from: private */
    public boolean isDrag;
    private AccessibilityEventSender mAccessibilityEventSender;
    private boolean mAccessibilityFocused;
    private Drawable mAuraDrawble;
    /* access modifiers changed from: private */
    public int mAuraHeight;
    private ValueAnimator mAuraHideAnimator;
    private Interpolator mAuraHideInterpolator;
    /* access modifiers changed from: private */
    public int mAuraRadius;
    private ValueAnimator mAuraShowAnimator;
    private Interpolator mAuraShowInterpolator;
    private int mAuraWidth;
    private int mDistance;
    private ValueAnimator mDrawablePositionAnimator;
    /* access modifiers changed from: private */
    public DrawableXYHolder mDrawableXYHolder;
    private boolean mEnableEngine;
    private XYHolder mEndXY;
    private int mFontHeight;
    private int mHalfThumbHeight;
    private int mHalfThumbWidth;
    private float mInitialThumbX;
    private float mInitialTouchX;
    private boolean mIsDragging;
    private boolean mIsInItemPositon;
    private int mItemTextColor;
    private int mItemTextPosition;
    /* access modifiers changed from: private */
    public CharSequence[] mItems;
    private Drawable mLeftIcon;
    private Rect mLeftIconRect;
    private Interpolator mLocationInterpolator;
    private int mMax;
    /* access modifiers changed from: private */
    public OnEnhanceSeekBarChangeListener mOnEnhanceSeekBarChangeListener;
    private Paint mPaint;
    private int mPaintColor;
    private ColorStateList mPaintColorStateList;
    /* access modifiers changed from: private */
    public int mProgress;
    private Drawable mRightIcon;
    private Rect mRightIconRect;
    private int mScaledTouchSlop;
    private int mSpotColor;
    private ColorStateList mSpotColorStateList;
    private float mSpotRadius;
    private XYHolder mStartXY;
    private int mStrokeColor;
    private ColorStateList mStrokeColorStateList;
    private int mStrokeWidth;
    private Paint mTextPaint;
    private int mTextSize;
    private Drawable mThumb;
    private int mThumbOffset;
    private ValueAnimator mThumbRecoverAnimator;
    private Interpolator mThumbRecoverInterpolator;
    /* access modifiers changed from: private */
    public float mThumbScaleValue;
    private ValueAnimator mThumbShrinkAnimator;
    private Interpolator mThumbShrinkInterpolator;
    private int mTouchDownProgress;
    private XYEvaluator mXYEvaluator;

    public class AccessibilityEventSender implements Runnable {
        private AccessibilityEventSender() {
        }

        public void run() {
            EnhanceSeekBar.this.sendAccessibilityEvent(4);
            EnhanceSeekBar enhanceSeekBar = EnhanceSeekBar.this;
            enhanceSeekBar.announceForAccessibility(String.format(enhanceSeekBar.getResources().getString(R.string.mc_enhanceseekbar), new Object[]{EnhanceSeekBar.this.mItems[EnhanceSeekBar.this.mProgress]}));
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
                EnhanceSeekBar.this.invalidate();
            }
        }

        public DrawableXYHolder(Drawable drawable) {
            this.mDrawable = drawable;
        }
    }

    public interface OnEnhanceSeekBarChangeListener {
        void onProgressChanged(EnhanceSeekBar enhanceSeekBar, int i);

        void onProgressDragging(EnhanceSeekBar enhanceSeekBar, int i);

        void onStartTrackingTouch(EnhanceSeekBar enhanceSeekBar);

        void onStopTrackingTouch(EnhanceSeekBar enhanceSeekBar);
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

    public EnhanceSeekBar(Context context) {
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
            int width = ((getWidth() - getPaddingLeft()) - getPaddingRight()) - (this.iconWidth * 2);
            Rect bounds = this.mThumb.getBounds();
            int x = (int) ((this.mInitialThumbX + ((float) ((int) motionEvent.getX()))) - this.mInitialTouchX);
            if (x < 0) {
                x = 0;
            } else if (x > width) {
                x = width;
            }
            int round = isRTL() ? Math.round((1.0f - (((float) x) / ((float) width))) * ((float) getMax())) : Math.round((((float) x) / ((float) width)) * ((float) getMax()));
            setProgress(round, true, true);
            int max = isRTL() ? (int) (((float) width) * (1.0f - (((float) round) / ((float) getMax())))) : (width * round) / getMax();
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

    public static String getTAG() {
        return TAG;
    }

    private boolean isPointInside(int i, int i2) {
        return true;
    }

    private boolean isRTL() {
        return getContext().getResources().getConfiguration().getLayoutDirection() == 1;
    }

    private void onProgressRefresh(float f) {
        Drawable drawable = this.mThumb;
        if (drawable != null) {
            setThumbPos(getWidth(), drawable, f, Integer.MIN_VALUE);
        }
    }

    private void prepareStartAuraHide() {
        this.isAuraShow = false;
        if (this.mAuraDrawble != null && this.mThumb != null) {
            startAuraHideAnim();
        }
    }

    private void prepareStartAuraShow() {
        if (this.mThumb != null && this.mAuraDrawble != null && !this.isAuraShow) {
            startAuraShowAnim();
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

    private void setIconRect() {
        this.mLeftIconRect = new Rect(getPaddingLeft(), ((getPaddingTop() + this.mFontHeight) + this.mHalfThumbHeight) - ((this.iconWidth - this.iconPadding) / 2), (getPaddingLeft() + this.iconWidth) - this.iconPadding, getPaddingTop() + this.mFontHeight + this.mHalfThumbHeight + ((this.iconWidth - this.iconPadding) / 2));
        this.mRightIconRect = new Rect(((getWidth() - getPaddingRight()) - this.iconWidth) + this.iconPadding, ((getPaddingTop() + this.mFontHeight) + this.mHalfThumbHeight) - ((this.iconWidth - this.iconPadding) / 2), getWidth() - getPaddingRight(), getPaddingTop() + this.mFontHeight + this.mHalfThumbHeight + ((this.iconWidth - this.iconPadding) / 2));
    }

    private void setLeftIcon(Drawable drawable) {
        this.mRightIcon = drawable;
        drawable.setCallback(this);
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

    private void setRightIcon(Drawable drawable) {
        this.mLeftIcon = drawable;
        drawable.setCallback(this);
    }

    private void setThumbOffset(int i) {
        this.mThumbOffset = i;
        invalidate();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0058, code lost:
        if (r7.isStarted() != false) goto L_0x005c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void setThumbPos(int r9, android.graphics.drawable.Drawable r10, float r11, int r12) {
        /*
            r8 = this;
            int r0 = r8.getPaddingLeft()
            int r9 = r9 - r0
            int r0 = r8.getPaddingRight()
            int r9 = r9 - r0
            int r0 = r8.iconWidth
            int r0 = r0 * 2
            int r9 = r9 - r0
            int r0 = r10.getIntrinsicWidth()
            boolean r1 = r8.isRTL()
            if (r1 == 0) goto L_0x0023
            float r1 = (float) r9
            float r11 = r11 * r1
            int r11 = java.lang.Math.round(r11)
            int r11 = r9 - r11
            int r9 = r9 - r11
            goto L_0x002f
        L_0x0023:
            r1 = 1065353216(0x3f800000, float:1.0)
            float r1 = r1 - r11
            float r11 = (float) r9
            float r1 = r1 * r11
            int r11 = java.lang.Math.round(r1)
            int r11 = r9 - r11
            r9 = r11
        L_0x002f:
            int r0 = r0 + r9
            r1 = 0
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1
            if (r12 != r2) goto L_0x0040
            android.graphics.Rect r4 = r10.getBounds()
            int r5 = r4.top
            int r4 = r4.bottom
            r6 = r3
            goto L_0x0047
        L_0x0040:
            int r4 = r10.getIntrinsicHeight()
            int r4 = r4 + r12
            r5 = r12
            r6 = r1
        L_0x0047:
            android.animation.ValueAnimator r7 = r8.mDrawablePositionAnimator
            if (r7 == 0) goto L_0x005b
            if (r6 != 0) goto L_0x0054
            r7.cancel()
            r1 = 0
            r8.mDrawablePositionAnimator = r1
            goto L_0x005b
        L_0x0054:
            boolean r7 = r7.isStarted()
            if (r7 == 0) goto L_0x005b
            goto L_0x005c
        L_0x005b:
            r1 = r6
        L_0x005c:
            if (r1 == 0) goto L_0x00d5
            android.graphics.Rect r9 = r10.getBounds()
            int r9 = r9.left
            if (r9 != r11) goto L_0x0076
            r8.mIsInItemPositon = r3
            if (r12 != r2) goto L_0x0075
            com.meizu.common.widget.EnhanceSeekBar$OnEnhanceSeekBarChangeListener r9 = r8.mOnEnhanceSeekBarChangeListener
            if (r9 == 0) goto L_0x0075
            int r10 = r8.getProgress()
            r9.onProgressChanged(r8, r10)
        L_0x0075:
            return
        L_0x0076:
            com.meizu.common.widget.EnhanceSeekBar$XYHolder r12 = r8.mStartXY
            float r9 = (float) r9
            float r0 = (float) r5
            r12.setXY(r9, r0)
            com.meizu.common.widget.EnhanceSeekBar$XYHolder r9 = r8.mEndXY
            float r11 = (float) r11
            r9.setXY(r11, r0)
            com.meizu.common.widget.EnhanceSeekBar$DrawableXYHolder r9 = r8.mDrawableXYHolder
            r9.setDrawable(r10)
            com.meizu.common.widget.EnhanceSeekBar$XYEvaluator r9 = r8.mXYEvaluator
            com.meizu.common.widget.EnhanceSeekBar$XYHolder r10 = r8.mStartXY
            com.meizu.common.widget.EnhanceSeekBar$XYHolder r11 = r8.mEndXY
            java.lang.Object[] r10 = new java.lang.Object[]{r10, r11}
            android.animation.ValueAnimator r9 = android.animation.ValueAnimator.ofObject(r9, r10)
            r8.mDrawablePositionAnimator = r9
            com.meizu.common.widget.EnhanceSeekBar$XYHolder r9 = r8.mEndXY
            float r9 = r9.getX()
            com.meizu.common.widget.EnhanceSeekBar$XYHolder r10 = r8.mStartXY
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
            com.meizu.common.widget.EnhanceSeekBar$1 r10 = new com.meizu.common.widget.EnhanceSeekBar$1
            r10.<init>()
            r9.addListener(r10)
            android.animation.ValueAnimator r9 = r8.mDrawablePositionAnimator
            com.meizu.common.widget.EnhanceSeekBar$2 r10 = new com.meizu.common.widget.EnhanceSeekBar$2
            r10.<init>()
            r9.addUpdateListener(r10)
            android.animation.ValueAnimator r9 = r8.mDrawablePositionAnimator
            r9.start()
            goto L_0x00dd
        L_0x00d5:
            android.graphics.drawable.Drawable r10 = r8.mThumb
            r10.setBounds(r9, r5, r0, r4)
            r8.invalidate()
        L_0x00dd:
            r8.mIsInItemPositon = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.widget.EnhanceSeekBar.setThumbPos(int, android.graphics.drawable.Drawable, float, int):void");
    }

    private void startAuraHideAnim() {
        if (this.mAuraHideAnimator == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.5f});
            this.mAuraHideAnimator = ofFloat;
            ofFloat.setDuration(200);
            this.mAuraHideAnimator.setInterpolator(this.mAuraHideInterpolator);
            this.mAuraHideAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    EnhanceSeekBar enhanceSeekBar = EnhanceSeekBar.this;
                    int unused = enhanceSeekBar.mAuraRadius = (int) (((float) (enhanceSeekBar.mAuraHeight / 2)) * floatValue);
                    EnhanceSeekBar.this.invalidate();
                }
            });
            this.mAuraHideAnimator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    boolean unused = EnhanceSeekBar.this.isDrag = false;
                }
            });
        }
        this.mAuraHideAnimator.start();
        if (this.mThumbRecoverAnimator == null) {
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{THUMB_SCALE_TARGET, 1.0f});
            this.mThumbRecoverAnimator = ofFloat2;
            ofFloat2.setDuration(200);
            this.mThumbRecoverAnimator.setInterpolator(this.mThumbRecoverInterpolator);
            this.mThumbRecoverAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float unused = EnhanceSeekBar.this.mThumbScaleValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    EnhanceSeekBar.this.invalidate();
                }
            });
            this.mThumbRecoverAnimator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                }
            });
        }
        this.mThumbRecoverAnimator.start();
    }

    private void startAuraShowAnim() {
        this.isAuraShow = true;
        if (this.mAuraShowAnimator == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.5f, 1.0f});
            this.mAuraShowAnimator = ofFloat;
            ofFloat.setDuration(180);
            this.mAuraShowAnimator.setInterpolator(this.mAuraShowInterpolator);
            this.mAuraShowAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    EnhanceSeekBar enhanceSeekBar = EnhanceSeekBar.this;
                    int unused = enhanceSeekBar.mAuraRadius = (int) (((float) (enhanceSeekBar.mAuraHeight / 2)) * floatValue);
                    EnhanceSeekBar.this.invalidate();
                }
            });
        }
        this.mAuraShowAnimator.start();
        if (this.mThumbShrinkAnimator == null) {
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{1.0f, THUMB_SCALE_TARGET});
            this.mThumbShrinkAnimator = ofFloat2;
            ofFloat2.setDuration(180);
            this.mThumbShrinkAnimator.setInterpolator(this.mThumbShrinkInterpolator);
            this.mThumbShrinkAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float unused = EnhanceSeekBar.this.mThumbScaleValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    EnhanceSeekBar.this.invalidate();
                }
            });
        }
        this.mThumbShrinkAnimator.start();
    }

    private void stopAuraHideAnim() {
        ValueAnimator valueAnimator = this.mAuraHideAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mAuraHideAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.mThumbRecoverAnimator;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.mThumbRecoverAnimator.cancel();
        }
    }

    private void stopAuraShowAnim() {
        ValueAnimator valueAnimator = this.mAuraShowAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mAuraShowAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.mThumbShrinkAnimator;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.mThumbShrinkAnimator.cancel();
        }
    }

    private void trackTapUpTouchEvent(MotionEvent motionEvent) {
        float f;
        int round;
        int i;
        int progress;
        int progress2;
        ValueAnimator valueAnimator = this.mDrawablePositionAnimator;
        if (valueAnimator == null || !valueAnimator.isStarted()) {
            int width = ((getWidth() - getPaddingLeft()) - getPaddingRight()) - (this.iconWidth * 2);
            float x = (float) ((int) motionEvent.getX());
            float f2 = 0.0f;
            if (x < ((float) ((getPaddingLeft() + this.iconWidth) - this.iconPadding))) {
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
            } else if (x <= ((float) (getPaddingLeft() + this.iconWidth + width + this.iconPadding))) {
                round = isRTL() ? Math.round((1.0f - (((x - ((float) getPaddingLeft())) - ((float) this.iconWidth)) / ((float) width))) * ((float) this.mMax)) : Math.round((((x - ((float) getPaddingLeft())) - ((float) this.iconWidth)) / ((float) width)) * ((float) this.mMax));
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

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x002a, code lost:
        if (isRTL() != false) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003f, code lost:
        if (isRTL() != false) goto L_0x002d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void trackTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r5.getWidth()
            int r1 = r5.getPaddingLeft()
            int r1 = r0 - r1
            int r2 = r5.getPaddingRight()
            int r1 = r1 - r2
            int r2 = r5.iconWidth
            int r2 = r2 * 2
            int r1 = r1 - r2
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
            if (r6 >= 0) goto L_0x002f
            boolean r6 = r5.isRTL()
            if (r6 == 0) goto L_0x002d
            goto L_0x0051
        L_0x002d:
            r2 = r3
            goto L_0x0051
        L_0x002f:
            int r4 = r5.getPaddingRight()
            int r0 = r0 - r4
            int r4 = r5.mHalfThumbWidth
            int r4 = r4 * 2
            int r0 = r0 - r4
            if (r6 <= r0) goto L_0x0042
            boolean r6 = r5.isRTL()
            if (r6 == 0) goto L_0x0051
            goto L_0x002d
        L_0x0042:
            boolean r0 = r5.isRTL()
            if (r0 == 0) goto L_0x004d
            float r6 = (float) r6
            float r0 = (float) r1
            float r6 = r6 / r0
            float r2 = r2 - r6
            goto L_0x0051
        L_0x004d:
            float r6 = (float) r6
            float r0 = (float) r1
            float r2 = r6 / r0
        L_0x0051:
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
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.widget.EnhanceSeekBar.trackTouchEvent(android.view.MotionEvent):void");
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
        Drawable drawable2 = this.mLeftIcon;
        if (drawable2 != null && drawable2.isStateful()) {
            this.mLeftIcon.setState(drawableState);
        }
        Drawable drawable3 = this.mRightIcon;
        if (drawable3 != null && drawable3.isStateful()) {
            this.mRightIcon.setState(drawableState);
        }
        super.drawableStateChanged();
        invalidate();
    }

    public int getDistance() {
        return this.mDistance;
    }

    public synchronized int getItemsCount() {
        CharSequence[] charSequenceArr;
        try {
            charSequenceArr = this.mItems;
        } catch (Throwable th) {
            throw th;
        }
        return charSequenceArr != null ? charSequenceArr.length : this.mMax;
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

    public int getTextSize() {
        return this.mTextSize;
    }

    public Drawable getThumb() {
        return this.mThumb;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.mLeftIcon;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.mRightIcon;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mPaintColorStateList = getResources().getColorStateList(R.color.mz_seekbar_background_color);
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
            Drawable drawable = this.mThumb;
            if (drawable != null) {
                Rect bounds = drawable.getBounds();
                canvas.save();
                if (this.mItems != null) {
                    canvas.translate((float) (getPaddingLeft() + this.iconWidth), (float) (getPaddingTop() + this.mFontHeight + this.mHalfThumbHeight + this.mDistance));
                } else {
                    canvas.translate((float) (getPaddingLeft() + this.iconWidth), (float) (getPaddingTop() + this.mHalfThumbHeight));
                }
                float width = (float) (((getWidth() - getPaddingLeft()) - getPaddingRight()) - (this.iconWidth * 2));
                int max = getMax();
                float f = max > 0 ? width / ((float) max) : 0.0f;
                this.mPaint.setStrokeWidth((float) this.mStrokeWidth);
                this.mPaint.setColor(this.mPaintColor);
                this.mPaint.setAntiAlias(true);
                this.mPaint.setStrokeCap(Paint.Cap.ROUND);
                canvas.drawLine(0.0f, 0.0f, width, 0.0f, this.mPaint);
                for (int i = 0; i <= max; i++) {
                    if (isRTL()) {
                        int i2 = max - i;
                        if (getProgress() == i2) {
                            String str = (String) this.mItems[i2];
                            canvas.drawText(str, (((float) ((getItemsCount() - 1) - this.mItemTextPosition)) * f) - (this.mTextPaint.measureText(str) / 2.0f), (float) (-(this.mHalfThumbHeight + this.mDistance)), this.mTextPaint);
                        }
                    } else if (getProgress() == i) {
                        String str2 = (String) this.mItems[i];
                        canvas.drawText(str2, (((float) this.mItemTextPosition) * f) - (this.mTextPaint.measureText(str2) / 2.0f), (float) (-(this.mHalfThumbHeight + this.mDistance)), this.mTextPaint);
                    }
                }
                canvas.restore();
                canvas.save();
                if (this.mItems != null) {
                    canvas.translate((float) (getPaddingLeft() + this.iconWidth), (float) (getPaddingTop() + this.mFontHeight + this.mHalfThumbHeight + this.mDistance));
                } else {
                    canvas.translate((float) (getPaddingLeft() + this.iconWidth), (float) (getPaddingTop() + this.mHalfThumbHeight));
                }
                for (int i3 = 0; i3 <= max; i3++) {
                    this.mPaint.setColor(this.mSpotColor);
                    canvas.drawCircle(((float) i3) * f, 0.0f, this.mSpotRadius, this.mPaint);
                }
                canvas.restore();
                canvas.save();
                if (this.mItems != null) {
                    canvas.translate((float) ((getPaddingLeft() + this.iconWidth) - this.mHalfThumbWidth), (float) (getPaddingTop() + this.mFontHeight + this.mDistance));
                } else {
                    canvas.translate((float) ((getPaddingLeft() + this.iconWidth) - this.mHalfThumbWidth), (float) getPaddingTop());
                }
                float f2 = this.mThumbScaleValue;
                canvas.scale(f2, f2, (float) bounds.centerX(), (float) bounds.centerY());
                this.mThumb.draw(canvas);
                canvas.restore();
            }
        } finally {
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
            onTouchEvent(motionEvent);
            motionEvent.setAction(action);
        }
        return super.onHoverEvent(motionEvent);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(EnhanceSeekBar.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(EnhanceSeekBar.class.getName());
        if (isEnabled()) {
            int progress = getProgress();
            if (progress > 0) {
                accessibilityNodeInfo.addAction(8192);
            }
            if (progress < getMax()) {
                accessibilityNodeInfo.addAction(4096);
            }
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        setIconRect();
        super.onLayout(z, i, i2, i3, i4);
    }

    @RequiresApi
    public synchronized void onMeasure(int i, int i2) {
        int i3;
        int i4;
        try {
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            int i5 = 0;
            if (this.mItems != null) {
                Rect rect = new Rect();
                int i6 = 0;
                int i7 = 0;
                while (true) {
                    CharSequence[] charSequenceArr = this.mItems;
                    if (i6 >= charSequenceArr.length) {
                        break;
                    }
                    Paint paint = this.mTextPaint;
                    CharSequence charSequence = charSequenceArr[i6];
                    paint.getTextBounds(charSequence, 0, charSequence.length(), rect);
                    i7 = Math.max(i7, rect.height());
                    i6++;
                }
                this.mFontHeight = i7;
            } else {
                this.mFontHeight = 0;
            }
            if (mode != 1073741824) {
                if (this.mItems != null) {
                    int i8 = 0;
                    i4 = 0;
                    while (true) {
                        CharSequence[] charSequenceArr2 = this.mItems;
                        if (i8 >= charSequenceArr2.length) {
                            break;
                        }
                        i4 = Math.max(i4, (int) this.mTextPaint.measureText(charSequenceArr2[i8].toString()));
                        i8++;
                    }
                } else {
                    i4 = 0;
                }
                i3 = Math.max(i4, 64) + getPaddingLeft() + getPaddingRight();
            } else {
                i3 = Math.max(size, getPaddingLeft() + 64 + getPaddingRight());
            }
            Drawable drawable = this.mAuraDrawble;
            this.mAuraHeight = drawable == null ? 0 : drawable.getIntrinsicHeight();
            if (mode2 != 1073741824) {
                Drawable drawable2 = this.mThumb;
                int intrinsicHeight = drawable2 == null ? 0 : drawable2.getIntrinsicHeight();
                if (this.mItems != null) {
                    i5 = this.mFontHeight + this.mDistance;
                }
                size2 = i5 + getPaddingTop() + getPaddingBottom() + intrinsicHeight;
            }
            setMeasuredDimension(i3, size2);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setProgress(savedState.progress, true, false);
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
        OnEnhanceSeekBarChangeListener onEnhanceSeekBarChangeListener = this.mOnEnhanceSeekBarChangeListener;
        if (onEnhanceSeekBarChangeListener != null) {
            onEnhanceSeekBarChangeListener.onStartTrackingTouch(this);
        }
    }

    public void onStopTrackingTouch() {
        this.mIsDragging = false;
        OnEnhanceSeekBarChangeListener onEnhanceSeekBarChangeListener = this.mOnEnhanceSeekBarChangeListener;
        if (onEnhanceSeekBarChangeListener != null) {
            onEnhanceSeekBarChangeListener.onStopTrackingTouch(this);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || getMax() == 0) {
            return false;
        }
        float x = motionEvent.getX();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mInitialTouchX = x;
            this.isDrag = false;
            Drawable drawable = this.mThumb;
            if (drawable != null) {
                this.mInitialThumbX = (float) drawable.getBounds().left;
            }
            this.mTouchDownProgress = Math.round(((x - ((float) getPaddingLeft())) / ((float) (((getWidth() - getPaddingLeft()) - getPaddingRight()) - (this.iconWidth * 2)))) * ((float) getMax()));
            if (isPointInside((int) motionEvent.getX(), (int) motionEvent.getY())) {
                setPressed(true);
                Drawable drawable2 = this.mThumb;
                if (drawable2 != null) {
                    invalidate(drawable2.getBounds());
                }
                onStartTrackingTouch();
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
        int max = Math.max(1, Math.round(((float) getMax()) / 5.0f));
        if (i != 4096) {
            if (i != 8192 || progress <= 0) {
                return false;
            }
            setProgress(progress - max, false, false);
            return true;
        } else if (progress >= getMax()) {
            return false;
        } else {
            setProgress(progress + max, false, false);
            return true;
        }
    }

    public void setDistance(int i) {
        this.mDistance = i;
    }

    public void setEnableEngine(boolean z) {
        this.mEnableEngine = z;
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        refreshRes();
        invalidate();
    }

    public void setItemPosition(int i) {
        CharSequence[] charSequenceArr = this.mItems;
        if (charSequenceArr == null || charSequenceArr.length <= i || i < 0) {
            this.mItemTextPosition = 0;
        } else {
            this.mItemTextPosition = i;
        }
    }

    public void setItems(CharSequence[] charSequenceArr) {
        if (charSequenceArr == null || charSequenceArr.length == 0) {
            this.mItems = null;
            setMax(0);
            return;
        }
        int length = charSequenceArr.length;
        CharSequence[] charSequenceArr2 = new CharSequence[length];
        this.mItems = charSequenceArr2;
        System.arraycopy(charSequenceArr, 0, charSequenceArr2, 0, length);
        setMax(length - 1);
    }

    public void setItemsCount(int i) {
        CharSequence[] charSequenceArr = this.mItems;
        if (charSequenceArr != null && charSequenceArr.length < i) {
            setMax(charSequenceArr.length - 1);
        } else if (i < 1) {
            setMax(0);
        } else {
            setMax(i - 1);
        }
    }

    public void setOnEnhanceSeekBarChangeListener(OnEnhanceSeekBarChangeListener onEnhanceSeekBarChangeListener) {
        this.mOnEnhanceSeekBarChangeListener = onEnhanceSeekBarChangeListener;
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

    public void setTextSize(int i) {
        if (this.mTextSize != i) {
            this.mTextSize = i;
            this.mTextPaint.setTextSize((float) i);
            requestLayout();
            invalidate();
        }
    }

    public void setThumb(Drawable drawable) {
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
            this.mThumbOffset = drawable.getIntrinsicWidth() / 2;
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

    public EnhanceSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.MeizuCommon_EnhanceSeekBarStyle);
    }

    public EnhanceSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isDrag = false;
        this.mTouchDownProgress = 0;
        this.mHalfThumbWidth = 0;
        this.mHalfThumbHeight = 0;
        this.mThumbScaleValue = 1.0f;
        this.mAuraRadius = 0;
        this.mStartXY = new XYHolder();
        this.mEndXY = new XYHolder();
        this.mXYEvaluator = new XYEvaluator();
        this.mDrawableXYHolder = new DrawableXYHolder();
        this.hasMoved = false;
        this.mAccessibilityFocused = false;
        this.isAuraShow = false;
        this.mScaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.EnhanceSeekBar, i, 0);
        setItems(obtainStyledAttributes.getTextArray(R.styleable.EnhanceSeekBar_mcEItems));
        setProgress(obtainStyledAttributes.getInt(R.styleable.EnhanceSeekBar_mcEProgress, 0));
        setItemsCount(obtainStyledAttributes.getInt(R.styleable.EnhanceSeekBar_mcEItemsCount, 1));
        setItemPosition(obtainStyledAttributes.getInt(R.styleable.EnhanceSeekBar_mcEItemsPosition, 1));
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.EnhanceSeekBar_mcEThumb);
        drawable = drawable == null ? context.getResources().getDrawable(R.drawable.mz_step_seekbar_thumb) : drawable;
        this.mDistance = (int) obtainStyledAttributes.getDimension(R.styleable.EnhanceSeekBar_mcEnhanceDistance, getResources().getDimension(R.dimen.mc_enhance_seekbar_distance));
        this.mStrokeWidth = (int) obtainStyledAttributes.getDimension(R.styleable.EnhanceSeekBar_mcStrokeWidth, getResources().getDimension(R.dimen.mc_enhance_seekbar_stroke_width));
        this.mTextSize = (int) obtainStyledAttributes.getDimension(R.styleable.EnhanceSeekBar_mcItemsTextSize, (float) getResources().getDimensionPixelSize(R.dimen.mc_enhance_seekbar_item_text_size));
        this.mStrokeColorStateList = obtainStyledAttributes.getColorStateList(R.styleable.EnhanceSeekBar_mcEnhanceStrokeColor);
        this.mItemTextColor = obtainStyledAttributes.getColor(R.styleable.EnhanceSeekBar_mcItemsTextColor, R.attr.mzThemeColor);
        setThumb(drawable);
        this.mAuraDrawble = obtainStyledAttributes.getDrawable(R.styleable.EnhanceSeekBar_mcAuraEnhanceThumbDrawble);
        this.iconWidth = getResources().getDimensionPixelSize(R.dimen.mc_enhance_seekbar_icon_width);
        this.iconPadding = getResources().getDimensionPixelSize(R.dimen.mc_enhance_seekbar_icon_padding);
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.EnhanceSeekBar_mcLeftIcon);
        drawable2 = drawable2 == null ? context.getDrawable(R.drawable.mz_enhance_seekbar_ic_decrease) : drawable2;
        Drawable drawable3 = obtainStyledAttributes.getDrawable(R.styleable.EnhanceSeekBar_mcRightIcon);
        setLeftIcon(drawable3 == null ? context.getDrawable(R.drawable.mz_enhance_seekbar_ic_increase) : drawable3);
        setRightIcon(drawable2);
        this.mPaintColorStateList = getResources().getColorStateList(R.color.mz_seekbar_background_color);
        this.mSpotColorStateList = getResources().getColorStateList(R.color.mz_enhance_seekbar_spot_color);
        this.mSpotRadius = getResources().getDimension(R.dimen.mc_enhance_seekbar_spot_radius);
        obtainStyledAttributes.recycle();
        refreshDrawableState();
        refreshRes();
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(this.mPaintColor);
        TextPaint textPaint = new TextPaint();
        this.mTextPaint = textPaint;
        textPaint.setAntiAlias(true);
        this.mTextPaint.setTextSize((float) this.mTextSize);
        this.mTextPaint.setColor(this.mItemTextColor);
        this.mLocationInterpolator = new PathInterpolator(0.2f, 0.31f, 0.34f, 1.0f);
        this.mAuraShowInterpolator = new PathInterpolator(0.2f, 0.43f, 0.2f, 1.0f);
        this.mAuraHideInterpolator = new PathInterpolator(0.17f, 0.0f, 0.2f, 1.0f);
        this.mThumbShrinkInterpolator = new PathInterpolator(0.2f, 0.43f, 0.2f, 1.0f);
        this.mThumbRecoverInterpolator = new PathInterpolator(0.17f, 0.0f, 0.2f, 1.0f);
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
                CommonUtils.shakeForFlymeFeature(this);
            }
            if (i != this.mProgress || !this.mIsInItemPositon) {
                this.mProgress = i;
                if (!z) {
                    int i3 = this.mMax;
                    onProgressRefresh(i3 > 0 ? ((float) i) / ((float) i3) : 0.0f);
                } else {
                    OnEnhanceSeekBarChangeListener onEnhanceSeekBarChangeListener = this.mOnEnhanceSeekBarChangeListener;
                    if (onEnhanceSeekBarChangeListener != null && this.mIsDragging) {
                        onEnhanceSeekBarChangeListener.onProgressDragging(this, getProgress());
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
