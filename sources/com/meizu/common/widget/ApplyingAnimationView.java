package com.meizu.common.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.provider.Settings;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.PathInterpolator;
import com.meizu.common.R;

public class ApplyingAnimationView extends View {
    private final String[] alphaProperty;
    /* access modifiers changed from: private */
    public AnimatorSet animator;
    private int bAlpha;
    private boolean bDraw;
    private float baseX;
    private float baseY;
    private float cbPosition;
    private float cbRadius;
    private float cgPosition;
    private float cgRadius;
    private float coPosition;
    private float coRadius;
    private float crPosition;
    private float crRadius;
    private int gAlpha;
    private boolean gDraw;
    private float halfMaxRadius;
    private float mAnimScale;
    private Paint mBluePaint;
    private Paint mGreenPaint;
    /* access modifiers changed from: private */
    public boolean mIsAnimRun;
    private Paint mOrangePaint;
    private Paint mRedPaint;
    /* access modifiers changed from: private */
    public boolean mStopFromUser;
    private float maxRadius;
    private int oAlpha;
    private boolean oDraw;
    private float po1;
    private float po2;
    private float po3;
    private float po4;
    private final String[] positionProperty;
    private int rAlpha;
    private boolean rDraw;
    private final String[] radiusProperty;

    public ApplyingAnimationView(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    private Animator createAlphaAnimator(int i) {
        ObjectAnimator[] objectAnimatorArr = new ObjectAnimator[4];
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this, this.alphaProperty[i], new int[]{255, 255});
        objectAnimatorArr[0] = ofInt;
        ofInt.setDuration(720);
        ObjectAnimator ofInt2 = ObjectAnimator.ofInt(this, this.alphaProperty[i], new int[]{255, 255});
        objectAnimatorArr[1] = ofInt2;
        ofInt2.setDuration(704);
        ObjectAnimator ofInt3 = ObjectAnimator.ofInt(this, this.alphaProperty[i], new int[]{255, 0, 0, 0});
        objectAnimatorArr[2] = ofInt3;
        ofInt3.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.4f, 1.0f));
        objectAnimatorArr[2].setDuration(704);
        ObjectAnimator ofInt4 = ObjectAnimator.ofInt(this, this.alphaProperty[i], new int[]{0, 255, 255});
        objectAnimatorArr[3] = ofInt4;
        ofInt4.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.4f, 1.0f));
        objectAnimatorArr[3].setDuration(688);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(new Animator[]{objectAnimatorArr[i % 4], objectAnimatorArr[(i + 1) % 4], objectAnimatorArr[(i + 2) % 4], objectAnimatorArr[(i + 3) % 4]});
        return animatorSet;
    }

    private Paint createCommonPaint() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        return paint;
    }

    private Animator createPositionAnimator(int i) {
        ObjectAnimator[] objectAnimatorArr = new ObjectAnimator[4];
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, this.positionProperty[i], new float[]{0.0f, this.po2});
        objectAnimatorArr[0] = ofFloat;
        ofFloat.setDuration(704);
        objectAnimatorArr[0].setInterpolator(new PathInterpolator(0.21f, 0.0f, 0.35f, 0.471f));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, this.positionProperty[i], new float[]{this.po2, this.po3});
        objectAnimatorArr[1] = ofFloat2;
        ofFloat2.setDuration(704);
        objectAnimatorArr[1].setInterpolator(new PathInterpolator(0.24f, 0.341f, 0.41f, 1.0f));
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this, this.positionProperty[i], new float[]{this.po3, this.po4});
        objectAnimatorArr[2] = ofFloat3;
        ofFloat3.setDuration(672);
        objectAnimatorArr[2].setInterpolator(new PathInterpolator(0.26f, 0.0f, 0.87f, 0.758f));
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this, this.positionProperty[i], new float[]{this.po4, this.po1});
        objectAnimatorArr[3] = ofFloat4;
        ofFloat4.setDuration(736);
        objectAnimatorArr[3].setInterpolator(new PathInterpolator(0.18f, 0.434f, 0.59f, 1.0f));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(new Animator[]{objectAnimatorArr[i % 4], objectAnimatorArr[(i + 1) % 4], objectAnimatorArr[(i + 2) % 4], objectAnimatorArr[(i + 3) % 4]});
        return animatorSet;
    }

    private Animator createRadiusAnimator(int i) {
        ObjectAnimator[] objectAnimatorArr = new ObjectAnimator[4];
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, this.radiusProperty[i], new float[]{this.halfMaxRadius, this.maxRadius});
        objectAnimatorArr[0] = ofFloat;
        ofFloat.setInterpolator(new PathInterpolator(0.24f, 0.209f, 0.25f, 1.0f));
        objectAnimatorArr[0].setDuration(720);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, this.radiusProperty[i], new float[]{this.maxRadius, this.halfMaxRadius});
        objectAnimatorArr[1] = ofFloat2;
        ofFloat2.setInterpolator(new PathInterpolator(0.29f, 0.0f, 0.32f, 0.631f));
        objectAnimatorArr[1].setDuration(704);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this, this.radiusProperty[i], new float[]{this.halfMaxRadius, this.maxRadius * 0.25f});
        objectAnimatorArr[2] = ofFloat3;
        ofFloat3.setInterpolator(new PathInterpolator(0.2f, 0.337f, 0.17f, 1.0f));
        objectAnimatorArr[2].setDuration(704);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this, this.radiusProperty[i], new float[]{this.maxRadius * 0.25f, this.halfMaxRadius});
        objectAnimatorArr[3] = ofFloat4;
        ofFloat4.setInterpolator(new PathInterpolator(0.19f, 0.0f, 0.37f, 0.31f));
        objectAnimatorArr[3].setDuration(688);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(new Animator[]{objectAnimatorArr[i % 4], objectAnimatorArr[(i + 1) % 4], objectAnimatorArr[(i + 2) % 4], objectAnimatorArr[(i + 3) % 4]});
        return animatorSet;
    }

    private void init(Context context) {
        initData(context);
        Paint createCommonPaint = createCommonPaint();
        this.mRedPaint = createCommonPaint;
        createCommonPaint.setColor(-1357238);
        Paint createCommonPaint2 = createCommonPaint();
        this.mBluePaint = createCommonPaint2;
        createCommonPaint2.setColor(-16737828);
        Paint createCommonPaint3 = createCommonPaint();
        this.mGreenPaint = createCommonPaint3;
        createCommonPaint3.setColor(110475);
        Paint createCommonPaint4 = createCommonPaint();
        this.mOrangePaint = createCommonPaint4;
        createCommonPaint4.setColor(-620493);
    }

    private void initData(Context context) {
        float density = getDensity(context) * this.mAnimScale;
        float f = 6.0f * density;
        this.maxRadius = f;
        this.halfMaxRadius = f * 0.5f;
        this.po1 = 0.0f;
        this.po2 = 12.3f * density;
        this.po3 = 24.0f * density;
        this.po4 = density * 11.0f;
        this.baseX = getX() + this.halfMaxRadius + (this.mAnimScale * 2.0f);
        this.baseY = getY();
    }

    private void setBAlpha(int i) {
        int round = Math.round((float) i);
        this.bAlpha = round;
        this.mBluePaint.setAlpha(round);
    }

    private void setCbPosition(float f) {
        this.cbPosition = f;
    }

    private void setCbRadius(float f) {
        this.cbRadius = f;
    }

    private void setCgPosition(float f) {
        this.cgPosition = f;
    }

    private void setCgRadius(float f) {
        this.cgRadius = f;
    }

    private void setCoPosition(float f) {
        this.coPosition = f;
        invalidate();
    }

    private void setCoRadius(float f) {
        this.coRadius = f;
    }

    private void setCrPosition(float f) {
        this.crPosition = f;
    }

    private void setCrRadius(float f) {
        this.crRadius = f;
    }

    private void setGAlpha(int i) {
        int round = Math.round((float) i);
        this.gAlpha = round;
        this.mGreenPaint.setAlpha(round);
    }

    private void setOAlpha(int i) {
        int round = Math.round((float) i);
        this.oAlpha = round;
        this.mOrangePaint.setAlpha(round);
    }

    private void setRAlpha(int i) {
        int round = Math.round((float) i);
        this.rAlpha = round;
        this.mRedPaint.setAlpha(round);
    }

    private void startAnimator() {
        if (!this.mIsAnimRun) {
            Animator createPositionAnimator = createPositionAnimator(0);
            Animator createPositionAnimator2 = createPositionAnimator(1);
            Animator createPositionAnimator3 = createPositionAnimator(2);
            Animator createPositionAnimator4 = createPositionAnimator(3);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new Animator[]{createPositionAnimator, createPositionAnimator2, createPositionAnimator3, createPositionAnimator4});
            Animator createRadiusAnimator = createRadiusAnimator(0);
            Animator createRadiusAnimator2 = createRadiusAnimator(1);
            Animator createRadiusAnimator3 = createRadiusAnimator(2);
            Animator createRadiusAnimator4 = createRadiusAnimator(3);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.playTogether(new Animator[]{createRadiusAnimator, createRadiusAnimator2, createRadiusAnimator3, createRadiusAnimator4});
            Animator createAlphaAnimator = createAlphaAnimator(0);
            Animator createAlphaAnimator2 = createAlphaAnimator(1);
            Animator createAlphaAnimator3 = createAlphaAnimator(2);
            Animator createAlphaAnimator4 = createAlphaAnimator(3);
            AnimatorSet animatorSet3 = new AnimatorSet();
            animatorSet3.playTogether(new Animator[]{createAlphaAnimator, createAlphaAnimator2, createAlphaAnimator3, createAlphaAnimator4});
            AnimatorSet animatorSet4 = new AnimatorSet();
            this.animator = animatorSet4;
            animatorSet4.playTogether(new Animator[]{animatorSet, animatorSet2, animatorSet3});
            this.animator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    if (Settings.Global.getFloat(ApplyingAnimationView.this.getContext().getContentResolver(), "animator_duration_scale", 1.0f) == 0.0f) {
                        return;
                    }
                    if (!ApplyingAnimationView.this.mStopFromUser && ApplyingAnimationView.this.animator != null) {
                        ApplyingAnimationView.this.animator.start();
                    } else if (ApplyingAnimationView.this.animator != null) {
                        boolean unused = ApplyingAnimationView.this.mStopFromUser = false;
                        boolean unused2 = ApplyingAnimationView.this.mIsAnimRun = false;
                    }
                }
            });
            this.mIsAnimRun = true;
            this.animator.start();
        }
    }

    private void stopRunAnimator() {
        AnimatorSet animatorSet = this.animator;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.mStopFromUser = true;
            this.mIsAnimRun = false;
            this.animator = null;
        }
    }

    public float getDensity(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public void onDraw(Canvas canvas) {
        float f = this.crRadius;
        if (f < this.halfMaxRadius) {
            canvas.drawCircle(this.baseX + this.crPosition, this.baseY + this.maxRadius, f, this.mRedPaint);
            this.rDraw = true;
        }
        float f2 = this.cbRadius;
        if (f2 < this.halfMaxRadius) {
            canvas.drawCircle(this.baseX + this.cbPosition, this.baseY + this.maxRadius, f2, this.mBluePaint);
            this.bDraw = true;
        }
        float f3 = this.cgRadius;
        if (f3 < this.halfMaxRadius) {
            canvas.drawCircle(this.baseX + this.cgPosition, this.baseY + this.maxRadius, f3, this.mGreenPaint);
            this.gDraw = true;
        }
        float f4 = this.coRadius;
        if (f4 < this.halfMaxRadius) {
            canvas.drawCircle(this.baseX + this.coPosition, this.baseY + this.maxRadius, f4, this.mOrangePaint);
            this.oDraw = true;
        }
        if (!this.rDraw) {
            canvas.drawCircle(this.baseX + this.crPosition, this.baseY + this.maxRadius, this.crRadius, this.mRedPaint);
        }
        if (!this.bDraw) {
            canvas.drawCircle(this.baseX + this.cbPosition, this.baseY + this.maxRadius, this.cbRadius, this.mBluePaint);
        }
        if (!this.gDraw) {
            canvas.drawCircle(this.baseX + this.cgPosition, this.baseY + this.maxRadius, this.cgRadius, this.mGreenPaint);
        }
        if (!this.oDraw) {
            canvas.drawCircle(this.baseX + this.coPosition, this.baseY + this.maxRadius, this.coRadius, this.mOrangePaint);
        }
        this.rDraw = false;
        this.bDraw = false;
        this.gDraw = false;
        this.oDraw = false;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ApplyingAnimationView.class.getName());
    }

    public void onMeasure(int i, int i2) {
        int round = Math.round((this.po3 - this.po1) + this.maxRadius + (this.mAnimScale * 4.0f) + 0.5f);
        int round2 = Math.round((this.maxRadius * 2.0f) + 0.5f);
        setMeasuredDimension(View.resolveSizeAndState(round + getPaddingLeft() + getPaddingRight(), i, 0), View.resolveSizeAndState(round2 + getPaddingTop() + getPaddingBottom(), i2, 0));
    }

    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i != 0) {
            stopRunAnimator();
        } else if (isShown()) {
            startAnimator();
            this.mStopFromUser = false;
        }
    }

    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i != 0) {
            stopRunAnimator();
        } else if (isShown()) {
            startAnimator();
            this.mStopFromUser = false;
        }
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            startAnimator();
            this.mStopFromUser = false;
        } else if (i == 4 || i == 8) {
            stopRunAnimator();
        }
    }

    public ApplyingAnimationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ApplyingAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.rAlpha = 255;
        this.bAlpha = 255;
        this.gAlpha = 255;
        this.oAlpha = 255;
        this.positionProperty = new String[]{"crPosition", "cbPosition", "cgPosition", "coPosition"};
        this.alphaProperty = new String[]{"rAlpha", "bAlpha", "gAlpha", "oAlpha"};
        this.radiusProperty = new String[]{"crRadius", "cbRadius", "cgRadius", "coRadius"};
        this.rDraw = false;
        this.bDraw = false;
        this.gDraw = false;
        this.oDraw = false;
        this.mStopFromUser = false;
        this.mIsAnimRun = false;
        this.mAnimScale = 1.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ApplyingAnimationView);
        this.mAnimScale = obtainStyledAttributes.getFloat(R.styleable.ApplyingAnimationView_mcApplyingAnimationScale, this.mAnimScale);
        obtainStyledAttributes.recycle();
        init(context);
    }
}
