package com.meizu.common.widget;

import android.animation.Animator;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.LinearInterpolator;
import com.meizu.common.R;
import com.meizu.common.util.ResourceUtils;

@SuppressLint({"NewApi"})
public class LoadingView extends View {
    private static final int LOADING_ANIMATION = 1;
    private static final int PROGRESS_ANIMATION = 2;
    public static final String START_ANGLE_PROPERTY = "startAngle";
    public static final String SWEEP_ANGLE_PROPERTY = "sweepAngle";
    private final long LOADING_ANIM_DURATION;
    private int mBackgroundColor;
    private float mCentX;
    private float mCentY;
    private RectF mCircleBounds;
    private Context mContext;
    private Paint mDotPaint;
    private int mForegroundColor;
    private Animator mLoadingAnimator;
    private int mLoadingState;
    private Paint mPaint;
    private Paint mPaintArc;
    private Paint mPaintArcBack;
    private int mPaintWidth;
    private float mRadius;
    private float mRingWidth;
    private float mStartAngle;
    private float mSweepAngle;
    private int mThemeColor;

    public LoadingView(Context context) {
        this(context, (AttributeSet) null);
    }

    private Animator createLoadingAnimator() {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofKeyframe("startAngle", new Keyframe[]{Keyframe.ofFloat(0.0f, -90.0f), Keyframe.ofFloat(0.5f, 330.0f), Keyframe.ofFloat(1.0f, 630.0f)}), PropertyValuesHolder.ofFloat("sweepAngle", new float[]{0.0f, -144.0f, 0.0f})});
        ofPropertyValuesHolder.setDuration(1760);
        ofPropertyValuesHolder.setInterpolator(new LinearInterpolator());
        ofPropertyValuesHolder.setRepeatCount(-1);
        return ofPropertyValuesHolder;
    }

    private void drawLoadingAnimation(Canvas canvas) {
        canvas.drawArc(this.mCircleBounds, -90.0f, 360.0f, false, this.mPaintArcBack);
        canvas.drawArc(this.mCircleBounds, this.mStartAngle, this.mSweepAngle, false, this.mPaintArc);
        float width = this.mCircleBounds.width() / 2.0f;
        float height = this.mCircleBounds.height() / 2.0f;
        float strokeWidth = this.mPaintArc.getStrokeWidth() / 2.0f;
        canvas.drawCircle(this.mCircleBounds.right - (((float) (1.0d - Math.cos(Math.toRadians((double) this.mStartAngle)))) * width), this.mCircleBounds.bottom - (((float) (1.0d - Math.sin(Math.toRadians((double) this.mStartAngle)))) * height), strokeWidth, this.mDotPaint);
        canvas.drawCircle(this.mCircleBounds.right - (width * ((float) (1.0d - Math.cos(Math.toRadians((double) (this.mSweepAngle + this.mStartAngle)))))), this.mCircleBounds.bottom - (height * ((float) (1.0d - Math.sin(Math.toRadians((double) (this.mSweepAngle + this.mStartAngle)))))), strokeWidth, this.mDotPaint);
    }

    private void init() {
        this.mCentX = getX() + ((float) getPaddingLeft()) + this.mRadius + ((float) (this.mPaintWidth * 2)) + this.mRingWidth;
        this.mCentY = getY() + ((float) getPaddingTop()) + this.mRadius + ((float) (this.mPaintWidth * 2)) + this.mRingWidth;
        RectF rectF = new RectF();
        this.mCircleBounds = rectF;
        float f = this.mCentX;
        float f2 = this.mRadius;
        int i = this.mPaintWidth;
        float f3 = this.mRingWidth;
        rectF.left = ((f - f2) - ((float) (i / 2))) - (f3 / 2.0f);
        float f4 = this.mCentY;
        rectF.top = ((f4 - f2) - ((float) (i / 2))) - (f3 / 2.0f);
        rectF.right = f + f2 + ((float) (i / 2)) + (f3 / 2.0f);
        rectF.bottom = f4 + f2 + ((float) (i / 2)) + (f3 / 2.0f);
    }

    private void startLoadingAnimation() {
        Animator animator = this.mLoadingAnimator;
        if (animator == null || !animator.isRunning()) {
            this.mLoadingState = 1;
            Animator createLoadingAnimator = createLoadingAnimator();
            this.mLoadingAnimator = createLoadingAnimator;
            createLoadingAnimator.start();
        }
    }

    public int getBarBackgroundColor() {
        return this.mBackgroundColor;
    }

    public int getBarColor() {
        return this.mForegroundColor;
    }

    public float getStartAngle() {
        return this.mStartAngle;
    }

    public float getSweepAngle() {
        return this.mSweepAngle;
    }

    public void onDraw(Canvas canvas) {
        canvas.translate((((float) (getWidth() / 2)) - this.mRadius) - this.mRingWidth, (((float) (getHeight() / 2)) - this.mRadius) - this.mRingWidth);
        if (this.mForegroundColor == this.mBackgroundColor) {
            this.mPaintArcBack.setAlpha(26);
        }
        if (this.mLoadingState == 1) {
            drawLoadingAnimation(canvas);
        } else {
            super.onDraw(canvas);
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(LoadingView.class.getName());
    }

    public void onMeasure(int i, int i2) {
        int i3 = (int) ((this.mRadius + this.mRingWidth + 2.0f) * 2.0f);
        setMeasuredDimension(View.resolveSizeAndState(getPaddingLeft() + getPaddingRight() + i3, i, 0), View.resolveSizeAndState(i3 + getPaddingTop() + getPaddingBottom(), i2, 0));
    }

    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (1 == this.mLoadingState) {
            if (i != 0) {
                Animator animator = this.mLoadingAnimator;
                if (animator != null) {
                    animator.cancel();
                    this.mLoadingAnimator = null;
                }
            } else if (isShown()) {
                startLoadingAnimation();
            }
        }
    }

    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (1 == this.mLoadingState) {
            if (i != 0) {
                Animator animator = this.mLoadingAnimator;
                if (animator != null) {
                    animator.cancel();
                    this.mLoadingAnimator = null;
                }
            } else if (isShown()) {
                startLoadingAnimation();
            }
        }
    }

    public void setBarBackgroundColor(int i) {
        Paint paint = this.mPaintArcBack;
        if (paint != null && paint.getColor() != i) {
            this.mPaintArcBack.setColor(i);
            this.mBackgroundColor = i;
            postInvalidate();
        }
    }

    public void setBarColor(int i) {
        Paint paint = this.mPaintArc;
        if (paint != null && paint.getColor() != i) {
            this.mPaintArc.setColor(i);
            this.mDotPaint.setColor(i);
            this.mForegroundColor = i;
            postInvalidate();
        }
    }

    public void setStartAngle(float f) {
        this.mStartAngle = f;
        invalidate();
    }

    public void setSweepAngle(float f) {
        this.mSweepAngle = f;
        invalidate();
    }

    public void setVisibility(int i) {
        Animator animator;
        super.setVisibility(i);
        if (i == 0) {
            startLoadingAnimation();
        } else if ((i == 4 || i == 8) && (animator = this.mLoadingAnimator) != null) {
            animator.cancel();
            this.mLoadingAnimator = null;
        }
    }

    public void startAnimator() {
        startLoadingAnimation();
    }

    @Deprecated
    public void startProgressAnimation() {
        this.mLoadingState = 2;
    }

    public void stopAnimator() {
        Animator animator = this.mLoadingAnimator;
        if (animator != null) {
            animator.cancel();
            this.mLoadingAnimator = null;
        }
    }

    public LoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.MeizuCommon_LoadingViewStyle);
    }

    public LoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPaint = null;
        this.mPaintArc = null;
        this.mPaintArcBack = null;
        this.mDotPaint = null;
        this.mLoadingAnimator = null;
        this.LOADING_ANIM_DURATION = 1760;
        this.mCircleBounds = null;
        this.mPaintWidth = 0;
        this.mLoadingState = 1;
        this.mContext = context;
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setColor(-1);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setTextAlign(Paint.Align.CENTER);
        this.mPaint.setTextSize(36.0f);
        int identifierByAttrId = ResourceUtils.getIdentifierByAttrId(R.attr.colorPrimary, context);
        this.mForegroundColor = context.getResources().getColor(identifierByAttrId == 0 ? R.color.fd_sys_color_primary_blue : identifierByAttrId);
        int identifierByAttrId2 = ResourceUtils.getIdentifierByAttrId(R.attr.colorPrimaryContainer, context);
        this.mBackgroundColor = context.getResources().getColor(identifierByAttrId2 == 0 ? R.color.fd_sys_color_primary_container_blue : identifierByAttrId2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LoadingView, R.attr.MeizuCommon_LoadingStyle, 0);
        this.mRadius = (float) obtainStyledAttributes.getDimensionPixelOffset(R.styleable.LoadingView_mcLoadingRadius, 24);
        this.mRingWidth = (float) obtainStyledAttributes.getDimensionPixelOffset(R.styleable.LoadingView_mcRingWidth, 10);
        this.mBackgroundColor = obtainStyledAttributes.getColor(R.styleable.LoadingView_mcLBackground, this.mBackgroundColor);
        this.mForegroundColor = obtainStyledAttributes.getColor(R.styleable.LoadingView_mcLForeground, this.mForegroundColor);
        this.mLoadingState = obtainStyledAttributes.getInt(R.styleable.LoadingView_mcLoadingState, 1);
        obtainStyledAttributes.recycle();
        Paint paint2 = new Paint(1);
        this.mPaintArc = paint2;
        paint2.setAntiAlias(true);
        this.mPaintArc.setColor(this.mForegroundColor);
        Paint paint3 = this.mPaintArc;
        Paint.Style style = Paint.Style.STROKE;
        paint3.setStyle(style);
        Paint paint4 = new Paint(this.mPaintArc);
        this.mDotPaint = paint4;
        paint4.setStyle(Paint.Style.FILL);
        Paint paint5 = new Paint(1);
        this.mPaintArcBack = paint5;
        paint5.setAntiAlias(true);
        this.mPaintArcBack.setColor(this.mBackgroundColor);
        this.mPaintArcBack.setStyle(style);
        this.mPaintArc.setStrokeWidth(this.mRingWidth - ((float) this.mPaintWidth));
        this.mPaintArcBack.setStrokeWidth(this.mRingWidth - ((float) this.mPaintWidth));
        init();
    }

    public LoadingView(Context context, float f, float f2) {
        this(context, (AttributeSet) null);
        this.mRadius = f;
        this.mRingWidth = f2;
        init();
    }
}
