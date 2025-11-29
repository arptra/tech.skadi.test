package com.meizu.common.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import com.meizu.common.R;

public class AnimSeekBar extends SkipPosSeekBar implements GestureDetector.OnGestureListener {
    private static final float CIRCLE_MIN_PADDING_DP = 1.5f;
    private static final int DEFAULT_ANIMSEEKBAE_HEIGHT = 65;
    private static final int DEFAULT_DISTANCE_BEW = 10;
    private static final int DEFAULT_EXPANDED_PIN_RADIUS_DP = 15;
    private static final int DEFAULT_LAGRECIRCLE_MOVEUP_VALUE = 24;
    private static final int DEFAULT_TEXT_COLOR = -1;
    private static final int DEFAULT_TEXT_SIZE = 14;
    private static final float DEFAULT_THUMB_RADIUS_DP = 0.0f;
    private static final boolean Debug = false;
    private static final String MAX_STRING = "100";
    private static final String TAG = "AnimSeekBar";
    private int mAinmSeekBarHeight;
    private Rect mBounds;
    private boolean mCheckRadisChanged;
    private Drawable mCircleAnimDrawble;
    private int mCircleRadius;
    private int mDefaultHeight;
    private int mDefaultWidth;
    private int mDistanceBwCircle;
    private ValueAnimator mFadeAnim;
    private Interpolator mFadeInterpolator;
    private int mFadeValue;
    private GestureDetector mGesture;
    private boolean mIsStartAnim;
    private boolean mIsTapPressed;
    private ValueAnimator mMoveAnim;
    private Interpolator mMoveDownInterpolator;
    private Interpolator mMoveUpInterpolator;
    private int mMoveUpValue;
    private int mMoveUpValueDp;
    private float mPinRadisMax;
    private float mPinRadisMin;
    private float mPinRadiusPx;
    private Drawable mProgressDrawble;
    private Resources mRes;
    private Interpolator mScaleInterpolator;
    private ValueAnimator mScaleanim;
    private String mTextNumber;
    private int mTextNumberColor;
    private int mTextNumberSize;
    private Paint mTextPaint;
    private Drawable mThumbDrawable;
    private float mThumbHeight;
    private int mThumbRadis;
    private float mX;
    private float mY;

    public AnimSeekBar(Context context) {
        this(context, (AttributeSet) null);
    }

    private void onActionUp(float f, float f2) {
        if (this.mIsStartAnim) {
            this.mIsStartAnim = false;
        }
        releasePin();
    }

    private void pressPin() {
        int i = this.mThumbRadis;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{(float) i, (float) i});
        this.mScaleanim = ofFloat;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                AnimSeekBar.this.setSize(((Float) valueAnimator.getAnimatedValue()).floatValue());
                AnimSeekBar.this.invalidate();
            }
        });
        this.mScaleanim.setInterpolator(this.mScaleInterpolator);
        this.mScaleanim.setDuration(166);
        this.mScaleanim.start();
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, 255});
        this.mFadeAnim = ofInt;
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                AnimSeekBar.this.setFadeValue(((Integer) valueAnimator.getAnimatedValue()).intValue());
                AnimSeekBar.this.invalidate();
            }
        });
        this.mFadeAnim.setInterpolator(this.mFadeInterpolator);
        this.mFadeAnim.setDuration(166);
        this.mFadeAnim.start();
        ValueAnimator ofInt2 = ValueAnimator.ofInt(new int[]{0, this.mMoveUpValueDp});
        this.mMoveAnim = ofInt2;
        ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                AnimSeekBar.this.setMoveValue(((Integer) valueAnimator.getAnimatedValue()).intValue());
                AnimSeekBar.this.invalidate();
            }
        });
        this.mMoveAnim.setDuration(166);
        this.mMoveAnim.setInterpolator(this.mMoveUpInterpolator);
        this.mMoveAnim.start();
    }

    private void releasePin() {
        int i = this.mThumbRadis;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{(float) i, (float) i});
        this.mScaleanim = ofFloat;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                AnimSeekBar.this.setSize(((Float) valueAnimator.getAnimatedValue()).floatValue());
                AnimSeekBar.this.invalidate();
            }
        });
        this.mScaleanim.setInterpolator(this.mScaleInterpolator);
        this.mScaleanim.setDuration(166);
        this.mScaleanim.start();
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{255, 0});
        this.mFadeAnim = ofInt;
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                AnimSeekBar.this.setFadeValue(((Integer) valueAnimator.getAnimatedValue()).intValue());
                AnimSeekBar.this.invalidate();
            }
        });
        this.mFadeAnim.setInterpolator(this.mFadeInterpolator);
        this.mFadeAnim.setDuration(166);
        this.mFadeAnim.start();
        ValueAnimator ofInt2 = ValueAnimator.ofInt(new int[]{this.mMoveUpValueDp, 0});
        this.mMoveAnim = ofInt2;
        ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                AnimSeekBar.this.setMoveValue(((Integer) valueAnimator.getAnimatedValue()).intValue());
                AnimSeekBar.this.invalidate();
            }
        });
        this.mMoveAnim.setDuration(166);
        this.mMoveAnim.setInterpolator(this.mMoveDownInterpolator);
        this.mMoveAnim.start();
    }

    private void seekBarAnimationInit(Context context, AttributeSet attributeSet, int i) {
        this.mRes = context.getResources();
        this.mGesture = new GestureDetector(context, this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AnimSeekBar, i, 0);
        this.mCircleAnimDrawble = obtainStyledAttributes.getDrawable(R.styleable.AnimSeekBar_mcLargeCircleDrawble);
        this.mCircleRadius = (int) obtainStyledAttributes.getDimension(R.styleable.AnimSeekBar_mcLargeCircleRadis, 15.0f);
        this.mTextNumberColor = obtainStyledAttributes.getColor(R.styleable.AnimSeekBar_mcTextNumberColor, -1);
        this.mDistanceBwCircle = (int) obtainStyledAttributes.getDimension(R.styleable.AnimSeekBar_mcDistanceToCircle, this.mRes.getDisplayMetrics().density * 10.0f);
        this.mTextNumberSize = (int) obtainStyledAttributes.getDimension(R.styleable.AnimSeekBar_mcTextNumberSize, 14.0f);
        this.mMoveUpValueDp = (int) TypedValue.applyDimension(1, 24.0f, this.mRes.getDisplayMetrics());
        this.mDefaultHeight = (int) TypedValue.applyDimension(1, 65.0f, this.mRes.getDisplayMetrics());
        Paint paint = new Paint();
        this.mTextPaint = paint;
        paint.setColor(this.mTextNumberColor);
        this.mTextPaint.setAntiAlias(true);
        this.mTextPaint.setTextSize((float) this.mTextNumberSize);
        this.mTextPaint.setTypeface(Typeface.create("sans-serif-medium", 0));
        obtainStyledAttributes.recycle();
        int round = Math.round(TypedValue.applyDimension(1, CIRCLE_MIN_PADDING_DP, this.mRes.getDisplayMetrics()));
        this.mTextPaint.getTextBounds("100", 0, 3, this.mBounds);
        if (this.mBounds.width() >= (this.mCircleRadius - round) * 2) {
            this.mCircleRadius = Math.round((((float) this.mBounds.width()) / 2.0f) + ((float) round));
        }
        this.mScaleInterpolator = new PathInterpolator(DEFAULT_THUMB_RADIUS_DP, DEFAULT_THUMB_RADIUS_DP, 0.1f, 1.0f);
        this.mFadeInterpolator = new PathInterpolator(0.33f, DEFAULT_THUMB_RADIUS_DP, 0.67f, 1.0f);
        this.mMoveUpInterpolator = new PathInterpolator(0.33f, DEFAULT_THUMB_RADIUS_DP, 0.1f, 1.0f);
        this.mMoveDownInterpolator = new PathInterpolator(0.66f, DEFAULT_THUMB_RADIUS_DP, 0.67f, 1.0f);
    }

    /* access modifiers changed from: private */
    public void setFadeValue(int i) {
        this.mFadeValue = i;
    }

    /* access modifiers changed from: private */
    public void setMoveValue(int i) {
        this.mMoveUpValue = i;
    }

    /* access modifiers changed from: private */
    public void setSize(float f) {
        this.mPinRadiusPx = (float) ((int) f);
    }

    private void setmY(float f) {
        this.mY = f;
    }

    public int getDistanceToCircle() {
        return this.mDistanceBwCircle;
    }

    public Drawable getLargeCircleDrawble() {
        Drawable drawable = this.mCircleAnimDrawble;
        if (drawable != null) {
            return drawable;
        }
        return null;
    }

    public int getLargeCircleRadius() {
        return this.mCircleRadius;
    }

    public int getTextNumberColor() {
        return this.mTextNumberColor;
    }

    public int getTextNumberSize() {
        return this.mTextNumberSize;
    }

    public boolean onDown(MotionEvent motionEvent) {
        if (getParent() == null) {
            return false;
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        return false;
    }

    public synchronized void onDraw(Canvas canvas) {
        try {
            canvas.translate(DEFAULT_THUMB_RADIUS_DP, (((float) (this.mAinmSeekBarHeight / 2)) - this.mThumbHeight) - ((float) getPaddingBottom()));
            canvas.save();
            Drawable drawable = this.mThumbDrawable;
            if (!(drawable == null || this.mCircleAnimDrawble == null)) {
                float centerX = (float) ((drawable.getBounds().centerX() + getPaddingLeft()) - (this.mThumbDrawable.getIntrinsicWidth() / 2));
                this.mX = centerX;
                Rect rect = this.mBounds;
                int i = this.mCircleRadius;
                float f = this.mY;
                int i2 = this.mMoveUpValue;
                int i3 = this.mDistanceBwCircle;
                rect.set((int) (centerX - ((float) i)), (int) (((f - ((float) i)) - ((float) i2)) - ((float) i3)), (int) (centerX + ((float) i)), (int) (((f + ((float) i)) - ((float) i2)) - ((float) i3)));
                this.mCircleAnimDrawble.setBounds(this.mBounds);
                this.mCircleAnimDrawble.setAlpha(this.mFadeValue);
                this.mCircleAnimDrawble.draw(canvas);
                if (this.mFadeValue > 100) {
                    this.mTextNumber = Integer.toString(getRealProgress());
                } else {
                    this.mTextNumber = "";
                }
                if (this.mTextNumber.length() > 4) {
                    this.mTextNumber = this.mTextNumber.substring(0, 4);
                }
                Paint paint = this.mTextPaint;
                String str = this.mTextNumber;
                paint.getTextBounds(str, 0, str.length(), this.mBounds);
                this.mTextPaint.setTextAlign(Paint.Align.CENTER);
                Paint.FontMetricsInt fontMetricsInt = this.mTextPaint.getFontMetricsInt();
                float f2 = (this.mY - ((float) this.mMoveUpValue)) - ((float) this.mDistanceBwCircle);
                int i4 = fontMetricsInt.bottom;
                int i5 = fontMetricsInt.top;
                canvas.drawText(this.mTextNumber, this.mX, (float) (((int) ((f2 - ((float) ((i4 - i5) / 2))) - ((float) i5))) - (((int) getResources().getDisplayMetrics().density) / 2)), this.mTextPaint);
            }
            super.onDraw(canvas);
        } catch (Throwable th) {
            throw th;
        }
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.mThumbDrawable == null) {
            return true;
        }
        releasePin();
        invalidate();
        return true;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(AnimSeekBar.class.getName());
    }

    public void onLongPress(MotionEvent motionEvent) {
        this.mIsTapPressed = false;
    }

    public synchronized void onMeasure(int i, int i2) {
        int i3;
        try {
            this.mAinmSeekBarHeight = Math.round(((float) ((this.mCircleRadius * 2) + this.mDistanceBwCircle + this.mMoveUpValueDp + getPaddingTop() + getPaddingBottom())) + (((float) this.mThumbDrawable.getIntrinsicHeight()) / 2.0f));
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            if (mode != Integer.MIN_VALUE) {
                if (mode != 1073741824) {
                    size = this.mDefaultWidth;
                }
            }
            if (mode2 == Integer.MIN_VALUE) {
                i3 = this.mAinmSeekBarHeight;
            } else if (mode2 == 1073741824) {
                int i4 = this.mDefaultHeight;
                if (size2 <= i4) {
                    this.mCircleRadius = (int) TypedValue.applyDimension(1, 15.0f, this.mRes.getDisplayMetrics());
                    this.mDistanceBwCircle = (int) TypedValue.applyDimension(1, 10.0f, this.mRes.getDisplayMetrics());
                    i3 = i4;
                } else {
                    i3 = this.mAinmSeekBarHeight;
                }
            } else {
                i3 = this.mAinmSeekBarHeight;
            }
            setMeasuredDimension(size, i3);
        } catch (Throwable th) {
            throw th;
        }
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.mIsTapPressed = false;
        if (!this.mIsStartAnim) {
            this.mIsStartAnim = true;
            pressPin();
        } else {
            this.mScaleanim.end();
            this.mPinRadiusPx = this.mPinRadisMin;
        }
        invalidate();
        return true;
    }

    public void onShowPress(MotionEvent motionEvent) {
        if (!this.mIsStartAnim) {
            pressPin();
            this.mIsStartAnim = true;
        }
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        this.mIsTapPressed = this.mPinRadiusPx == this.mPinRadisMax && !this.mIsStartAnim;
        return true;
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Drawable progressDrawable = getProgressDrawable();
        this.mProgressDrawble = progressDrawable;
        Drawable drawable = this.mThumbDrawable;
        if (drawable != null && progressDrawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth() / 2;
            this.mThumbRadis = intrinsicWidth;
            this.mPinRadisMax = (float) intrinsicWidth;
            this.mPinRadisMin = (float) intrinsicWidth;
            this.mThumbHeight = (float) this.mThumbDrawable.getIntrinsicHeight();
            this.mPinRadiusPx = (float) this.mThumbRadis;
            setmY((float) this.mProgressDrawble.getBounds().centerY());
            int paddingTop = (int) (((float) (this.mCircleRadius + this.mDistanceBwCircle + this.mMoveUpValueDp + getPaddingTop() + getPaddingBottom())) + this.mThumbHeight);
            this.mAinmSeekBarHeight = paddingTop;
            if (paddingTop != getHeight()) {
                requestLayout();
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        if (!isEnabled()) {
            return false;
        }
        this.mGesture.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action == 1 || action == 3) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
            if (!this.mIsTapPressed) {
                onActionUp(motionEvent.getX(), motionEvent.getY());
            }
        }
        return true;
    }

    public void setDistanceToCircle(int i) {
        Context context = getContext();
        if (this.mRes == null) {
            this.mRes = Resources.getSystem();
        } else {
            this.mRes = context.getResources();
        }
        int applyDimension = (int) TypedValue.applyDimension(1, (float) i, this.mRes.getDisplayMetrics());
        if (i != this.mDistanceBwCircle) {
            this.mDistanceBwCircle = applyDimension;
            this.mCheckRadisChanged = true;
            requestLayout();
        }
        invalidate();
    }

    public void setLargeCircleDrawble(Drawable drawable) {
        int i;
        int i2;
        Drawable drawable2 = this.mCircleAnimDrawble;
        if (drawable2 != drawable) {
            int width = drawable2.getBounds().width();
            int height = this.mCircleAnimDrawble.getBounds().height();
            this.mCircleAnimDrawble = drawable;
            if (drawable != null) {
                i2 = drawable.getBounds().width();
                i = drawable.getBounds().height();
            } else {
                i2 = -1;
                i = -1;
            }
            if (!(width == i2 && height == i)) {
                requestLayout();
            }
            invalidate();
        }
    }

    public void setLargeCircleRadis(int i) {
        Context context = getContext();
        if (this.mRes == null) {
            this.mRes = Resources.getSystem();
        } else {
            this.mRes = context.getResources();
        }
        int applyDimension = (int) TypedValue.applyDimension(1, (float) i, this.mRes.getDisplayMetrics());
        if (this.mCircleRadius != i) {
            this.mCircleRadius = applyDimension;
            requestLayout();
        }
        invalidate();
    }

    public void setTextNumberColor(int i) {
        if (this.mTextNumberColor != i) {
            this.mTextNumberColor = i;
            this.mTextPaint.setColor(i);
            postInvalidate();
        }
    }

    public void setTextNumberSize(int i) {
        Context context = getContext();
        if (this.mRes == null) {
            this.mRes = Resources.getSystem();
        } else {
            this.mRes = context.getResources();
        }
        int applyDimension = (int) TypedValue.applyDimension(2, (float) i, this.mRes.getDisplayMetrics());
        if (applyDimension != this.mTextNumberSize) {
            this.mTextNumberSize = applyDimension;
            this.mTextPaint.setTextSize((float) applyDimension);
            requestLayout();
        }
        invalidate();
    }

    public void setThumb(Drawable drawable) {
        super.setThumb(drawable);
        this.mThumbDrawable = drawable;
    }

    public AnimSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.MeizuCommon_AnimSeekBarStyle);
    }

    public AnimSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPinRadiusPx = DEFAULT_THUMB_RADIUS_DP;
        this.mFadeValue = 0;
        this.mPinRadisMax = DEFAULT_THUMB_RADIUS_DP;
        this.mPinRadisMin = DEFAULT_THUMB_RADIUS_DP;
        this.mIsStartAnim = false;
        this.mIsTapPressed = false;
        this.mCheckRadisChanged = false;
        this.mDefaultWidth = 500;
        this.mBounds = new Rect();
        this.mGesture = null;
        seekBarAnimationInit(context, attributeSet, i);
    }
}
