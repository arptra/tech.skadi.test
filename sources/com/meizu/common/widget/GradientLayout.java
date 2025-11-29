package com.meizu.common.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.animation.PathInterpolator;
import android.widget.LinearLayout;
import com.meizu.common.R;
import io.netty.handler.codec.http2.Http2CodecUtil;

public class GradientLayout extends LinearLayout {
    private final long ANIM_DOWN_DURATION;
    private final long ANIM_UP_DURATION;
    private final int DEFAULT_COLOR;
    private final int DISABLED_PAINT_COLOR;
    private final float MAX_GRADIENT_SCALE;
    private final float MIN_GRADIENT_SCALE;
    private final String PROPERTY_CANVAS_ROTATION_Y;
    private final String PROPERTY_CANVAS_ROTATION_Z;
    private final String PROPERTY_CANVAS_SCALE;
    private final int SHAPE_CIRCLE;
    private final int SHAPE_NORMAL;
    private boolean mBackgroundBeGreyWhenDisabled;
    /* access modifiers changed from: private */
    public Paint mBackgroundPaint;
    private Camera mCamera;
    private float mCanvasRotationY;
    private float mCanvasRotationZ;
    private float mCanvasScale;
    private float mCenterEdge;
    private float mCenterX;
    private float mCenterY;
    private int mCornerRadius;
    private float mDensity;
    private int mDisableColorAlpha;
    /* access modifiers changed from: private */
    public Paint mDisabledPaint;
    /* access modifiers changed from: private */
    public Shader mDisabledShader;
    private long mDownTime;
    /* access modifiers changed from: private */
    public float mDownX;
    /* access modifiers changed from: private */
    public float mDownY;
    /* access modifiers changed from: private */
    public boolean mDrawShader;
    private boolean mEnableDrawBackground;
    private boolean mEnableRotateY;
    private ValueAnimator mGradientDownAnimator;
    /* access modifiers changed from: private */
    public Matrix mGradientMatrix;
    /* access modifiers changed from: private */
    public float mGradientScale;
    /* access modifiers changed from: private */
    public Shader mGradientShader;
    /* access modifiers changed from: private */
    public ValueAnimator mGradientUpAnimator;
    /* access modifiers changed from: private */
    public boolean mHasMultiChild;
    private TimeInterpolator mInterpolator;
    private boolean mIsSwipeMode;
    private boolean mIsTouchCanceled;
    private float mLastTouchX;
    private ObjectAnimator mLayoutDownAnimator;
    private int mLayoutHeight;
    /* access modifiers changed from: private */
    public ObjectAnimator mLayoutUpAnimator;
    private int mLayoutWidth;
    /* access modifiers changed from: private */
    public int mLeftColor;
    private float mMaxRotationYDegree;
    private float mMinScale;
    /* access modifiers changed from: private */
    public Shader mNormalShader;
    private boolean mOnlyDrawShadow;
    private float mOutSlop;
    private int mRadialCenterColor;
    private int mRadialEdgeColor;
    private RectF mRect;
    /* access modifiers changed from: private */
    public int mRightColor;
    private Matrix mRotationMatrix;
    private float mRotationPivot;
    /* access modifiers changed from: private */
    public Paint mShaderPaint;
    /* access modifiers changed from: private */
    public int mShaderPaintAlpha;
    /* access modifiers changed from: private */
    public Drawable mShadowDrawable;
    private int mShapeMode;
    private boolean mShouldDrawShadow;
    private float mTargetScale;
    private float mTargetYDegree;
    private long mUpTime;
    /* access modifiers changed from: private */
    public float mUpTranslate;
    private float mValidTouchSlop;

    public GradientLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0011, code lost:
        if (r1 > 1.0f) goto L_0x000b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void calculateTransform(float r5) {
        /*
            r4 = this;
            float r0 = r4.mCenterX
            float r1 = r5 - r0
            float r1 = r1 / r0
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r3 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r3 >= 0) goto L_0x000d
        L_0x000b:
            r1 = r2
            goto L_0x0014
        L_0x000d:
            r2 = 1065353216(0x3f800000, float:1.0)
            int r3 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r3 <= 0) goto L_0x0014
            goto L_0x000b
        L_0x0014:
            float r2 = r4.mMaxRotationYDegree
            float r1 = r1 * r2
            r4.mTargetYDegree = r1
            int r5 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r5 >= 0) goto L_0x0024
            int r5 = r4.mLayoutWidth
            float r5 = (float) r5
            r4.setRotationPivot(r5)
            goto L_0x0028
        L_0x0024:
            r5 = 0
            r4.setRotationPivot(r5)
        L_0x0028:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.widget.GradientLayout.calculateTransform(float):void");
    }

    private void cancelAllAnimator() {
        ObjectAnimator objectAnimator = this.mLayoutDownAnimator;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.mLayoutDownAnimator.cancel();
        }
        ValueAnimator valueAnimator = this.mGradientDownAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mGradientDownAnimator.cancel();
        }
    }

    private void drawBackground(Canvas canvas) {
        canvas.save();
        RectF rectF = this.mRect;
        int i = this.mCornerRadius;
        canvas.drawRoundRect(rectF, (float) i, (float) i, this.mBackgroundPaint);
        canvas.restore();
    }

    private void drawShadow(Canvas canvas) {
        if (this.mShadowDrawable != null) {
            canvas.save();
            float f = 1.0f - ((1.0f - this.mCanvasScale) * 6.0f);
            canvas.scale(f, f, this.mCenterX, this.mCenterY);
            if (this.mShapeMode == 1) {
                canvas.translate(0.0f, this.mDensity * 4.0f);
            } else if (this.mHasMultiChild) {
                int i = this.mLayoutHeight;
                canvas.translate(0.0f, ((this.mCanvasScale - 1.0f) * ((float) i) * 6.0f) + (((float) i) * 0.4f));
            } else {
                int i2 = this.mLayoutHeight;
                canvas.translate(0.0f, ((this.mCanvasScale - 1.0f) * ((float) i2) * 6.0f) + (((float) i2) * 0.4f) + (this.mDensity * 3.0f));
            }
            this.mShadowDrawable.draw(canvas);
            canvas.restore();
        }
    }

    private int getColorWhenAnimating(int i) {
        float f = this.mCanvasScale;
        if (f == 1.0f) {
            return i;
        }
        float f2 = (1.0f - f) / (1.0f - this.mMinScale);
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        fArr[1] = fArr[1] + (0.05f * f2);
        fArr[2] = fArr[2] - (f2 * 0.1f);
        return Color.HSVToColor(fArr);
    }

    private int getDarkerColor(int i) {
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        fArr[1] = fArr[1] + 0.05f;
        fArr[2] = fArr[2] - 0.1f;
        return Color.HSVToColor(fArr);
    }

    /* access modifiers changed from: private */
    public int getDisabledColor(int i) {
        return (this.mDisableColorAlpha << 24) | (i & Http2CodecUtil.MAX_FRAME_SIZE_UPPER_BOUND);
    }

    /* access modifiers changed from: private */
    public int getLighterColor(int i) {
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        fArr[1] = fArr[1] - 0.05f;
        fArr[2] = fArr[2] + 0.1f;
        return Color.HSVToColor(fArr);
    }

    private void handleActionDown(MotionEvent motionEvent) {
        this.mDownTime = System.currentTimeMillis();
        this.mDownX = motionEvent.getX();
        this.mDownY = motionEvent.getY();
        float f = this.mDownX;
        this.mLastTouchX = f;
        this.mUpTranslate = 0.0f;
        calculateTransform(f);
        setupLayoutDownAnimator();
        this.mLayoutDownAnimator.start();
    }

    private void handleActionMove(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        float f = this.mOutSlop;
        boolean z = true;
        if (x < 0.0f - f || x > ((float) this.mLayoutWidth) + f || y < 0.0f || y > ((float) this.mLayoutHeight)) {
            this.mIsTouchCanceled = true;
        }
        if (!this.mIsTouchCanceled && this.mHasMultiChild) {
            float f2 = this.mDownX;
            float f3 = this.mCenterEdge;
            if ((f2 >= f3 || x <= f3) && (f2 <= f3 || x >= f3)) {
                z = false;
            }
            this.mIsTouchCanceled = z;
        }
        if (this.mIsTouchCanceled) {
            handleActionUp(motionEvent);
        }
    }

    private void handleActionUp(MotionEvent motionEvent) {
        this.mIsSwipeMode = false;
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
        Paint paint = new Paint();
        this.mShaderPaint = paint;
        paint.setAntiAlias(true);
        this.mShaderPaintAlpha = this.mShaderPaint.getAlpha();
        Paint paint2 = new Paint(this.mShaderPaint);
        this.mBackgroundPaint = paint2;
        paint2.setAntiAlias(true);
        this.mBackgroundPaint.setColor(this.mLeftColor);
        Paint paint3 = new Paint(this.mBackgroundPaint);
        this.mDisabledPaint = paint3;
        paint3.setColor(-1710619);
        setOrientation(0);
        setGravity(17);
        float scaledTouchSlop = (float) ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mValidTouchSlop = scaledTouchSlop;
        this.mOutSlop = scaledTouchSlop;
        this.mDensity = getResources().getDisplayMetrics().density;
    }

    private void rotateCanvas(Canvas canvas) {
        this.mCamera.save();
        this.mCamera.rotateY(this.mCanvasRotationY);
        this.mRotationMatrix.reset();
        this.mCamera.getMatrix(this.mRotationMatrix);
        this.mRotationMatrix.preTranslate(-this.mRotationPivot, (float) ((-this.mLayoutHeight) / 2));
        this.mRotationMatrix.postTranslate(this.mRotationPivot, (float) (this.mLayoutHeight / 2));
        canvas.concat(this.mRotationMatrix);
        this.mCamera.restore();
    }

    private void rotateShadowCanvas(Canvas canvas) {
        this.mCamera.save();
        this.mCamera.rotateZ(this.mCanvasRotationZ);
        this.mRotationMatrix.reset();
        this.mCamera.getMatrix(this.mRotationMatrix);
        this.mRotationMatrix.preTranslate(-this.mRotationPivot, (float) ((-this.mLayoutHeight) / 2));
        this.mRotationMatrix.postTranslate(this.mRotationPivot, (float) (this.mLayoutHeight / 2));
        canvas.concat(this.mRotationMatrix);
        this.mCamera.restore();
    }

    private void setRotationPivot(float f) {
        this.mRotationPivot = f;
    }

    private void setupGradientDownAnimator(float f, float f2, long j) {
        this.mShaderPaint.setAlpha(this.mShaderPaintAlpha);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f, f2});
        this.mGradientDownAnimator = ofFloat;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = GradientLayout.this.mGradientScale = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                GradientLayout.this.mGradientMatrix.setScale(GradientLayout.this.mGradientScale, GradientLayout.this.mGradientScale);
                GradientLayout.this.mGradientMatrix.preTranslate(-GradientLayout.this.mDownX, -GradientLayout.this.mDownY);
                GradientLayout.this.mGradientMatrix.postTranslate(GradientLayout.this.mDownX, GradientLayout.this.mDownY);
                GradientLayout.this.mGradientShader.setLocalMatrix(GradientLayout.this.mGradientMatrix);
                GradientLayout.this.postInvalidate();
            }
        });
        this.mGradientDownAnimator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (GradientLayout.this.mLayoutUpAnimator != null && GradientLayout.this.mLayoutUpAnimator.isRunning()) {
                    GradientLayout.this.mLayoutUpAnimator.cancel();
                }
                if (GradientLayout.this.mGradientUpAnimator != null && GradientLayout.this.mGradientUpAnimator.isRunning()) {
                    GradientLayout.this.mGradientUpAnimator.cancel();
                }
            }
        });
        this.mGradientDownAnimator.setInterpolator(this.mInterpolator);
        this.mGradientDownAnimator.setDuration(j);
    }

    private void setupGradientUpAnimator(float f, float f2, long j) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f, f2});
        this.mGradientUpAnimator = ofFloat;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = GradientLayout.this.mGradientScale = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                GradientLayout.this.mGradientMatrix.setScale(GradientLayout.this.mGradientScale, GradientLayout.this.mGradientScale);
                GradientLayout.this.mGradientMatrix.preTranslate(-GradientLayout.this.mDownX, -GradientLayout.this.mDownY);
                GradientLayout.this.mGradientMatrix.postTranslate(GradientLayout.this.mDownX, GradientLayout.this.mDownY);
                GradientLayout.this.mGradientMatrix.postTranslate(GradientLayout.this.mUpTranslate, 0.0f);
                GradientLayout.this.mShaderPaint.setAlpha((int) ((GradientLayout.this.mGradientScale * ((float) GradientLayout.this.mShaderPaintAlpha)) / 1.0f));
                GradientLayout.this.mGradientShader.setLocalMatrix(GradientLayout.this.mGradientMatrix);
                GradientLayout.this.postInvalidate();
            }
        });
        this.mGradientUpAnimator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                boolean unused = GradientLayout.this.mDrawShader = false;
                GradientLayout.this.postInvalidate();
            }

            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                float[] fArr = new float[9];
                GradientLayout.this.mGradientMatrix.getValues(fArr);
                float unused = GradientLayout.this.mUpTranslate = fArr[2];
            }
        });
        this.mGradientUpAnimator.setInterpolator(this.mInterpolator);
        this.mGradientUpAnimator.setDuration(j);
    }

    private void setupLayoutDownAnimator() {
        this.mTargetScale = this.mMinScale;
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("canvasRotationY", new float[]{0.0f, this.mTargetYDegree});
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("canvasScale", new float[]{1.0f, this.mTargetScale});
        ObjectAnimator objectAnimator = this.mLayoutDownAnimator;
        if (objectAnimator == null) {
            if (this.mEnableRotateY) {
                this.mLayoutDownAnimator = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{ofFloat, ofFloat2});
            } else {
                this.mLayoutDownAnimator = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{ofFloat2});
            }
            this.mLayoutDownAnimator.setInterpolator(this.mInterpolator);
            this.mLayoutDownAnimator.setDuration(128);
        } else if (this.mEnableRotateY) {
            objectAnimator.setValues(new PropertyValuesHolder[]{ofFloat, ofFloat2});
        } else {
            objectAnimator.setValues(new PropertyValuesHolder[]{ofFloat2});
        }
    }

    private void setupLayoutUpAnimator() {
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("canvasRotationY", new float[]{this.mTargetYDegree, 0.0f});
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("canvasScale", new float[]{this.mTargetScale, 1.0f});
        ObjectAnimator objectAnimator = this.mLayoutUpAnimator;
        if (objectAnimator == null) {
            if (this.mEnableRotateY) {
                this.mLayoutUpAnimator = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{ofFloat, ofFloat2});
            } else {
                this.mLayoutUpAnimator = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{ofFloat2});
            }
            this.mLayoutUpAnimator.setInterpolator(this.mInterpolator);
            this.mLayoutUpAnimator.setDuration(352);
        } else if (this.mEnableRotateY) {
            objectAnimator.setValues(new PropertyValuesHolder[]{ofFloat, ofFloat2});
        } else {
            objectAnimator.setValues(new PropertyValuesHolder[]{ofFloat2});
        }
    }

    /* access modifiers changed from: private */
    public boolean shouldSetDisabledShader() {
        return this.mShapeMode != 1 && !this.mBackgroundBeGreyWhenDisabled;
    }

    private void updateGradient() {
        if (this.mRightColor == -1) {
            this.mRightColor = -16711936;
        }
        if (this.mLeftColor == -1) {
            this.mLeftColor = -16711936;
        }
        post(new Runnable() {
            public void run() {
                if (!GradientLayout.this.mHasMultiChild) {
                    GradientLayout gradientLayout = GradientLayout.this;
                    int access$200 = gradientLayout.getLighterColor(gradientLayout.mLeftColor);
                    GradientLayout gradientLayout2 = GradientLayout.this;
                    Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                    Shader unused = gradientLayout2.mNormalShader = new LinearGradient(0.0f, 0.0f, (float) GradientLayout.this.getWidth(), (float) GradientLayout.this.getHeight(), new int[]{access$200, GradientLayout.this.mLeftColor}, (float[]) null, tileMode);
                    if (GradientLayout.this.shouldSetDisabledShader()) {
                        GradientLayout gradientLayout3 = GradientLayout.this;
                        float width = (float) GradientLayout.this.getWidth();
                        int access$600 = GradientLayout.this.getDisabledColor(access$200);
                        GradientLayout gradientLayout4 = GradientLayout.this;
                        Shader unused2 = gradientLayout3.mDisabledShader = new LinearGradient(0.0f, 0.0f, width, (float) GradientLayout.this.getHeight(), new int[]{access$600, gradientLayout4.getDisabledColor(gradientLayout4.mLeftColor)}, (float[]) null, tileMode);
                    }
                    if (GradientLayout.this.mShadowDrawable != null) {
                        GradientLayout.this.mShadowDrawable.setColorFilter(GradientLayout.this.mLeftColor, PorterDuff.Mode.SRC_IN);
                    }
                } else {
                    GradientLayout gradientLayout5 = GradientLayout.this;
                    Shader.TileMode tileMode2 = Shader.TileMode.CLAMP;
                    Shader unused3 = gradientLayout5.mNormalShader = new LinearGradient(0.0f, 0.0f, (float) GradientLayout.this.getWidth(), (float) GradientLayout.this.getHeight(), new int[]{GradientLayout.this.mLeftColor, GradientLayout.this.mRightColor}, (float[]) null, tileMode2);
                    if (GradientLayout.this.shouldSetDisabledShader()) {
                        GradientLayout gradientLayout6 = GradientLayout.this;
                        float width2 = (float) GradientLayout.this.getWidth();
                        float height = (float) GradientLayout.this.getHeight();
                        GradientLayout gradientLayout7 = GradientLayout.this;
                        int access$6002 = gradientLayout7.getDisabledColor(gradientLayout7.mLeftColor);
                        GradientLayout gradientLayout8 = GradientLayout.this;
                        Shader unused4 = gradientLayout6.mDisabledShader = new LinearGradient(0.0f, 0.0f, width2, height, new int[]{access$6002, gradientLayout8.getDisabledColor(gradientLayout8.mRightColor)}, (float[]) null, tileMode2);
                    }
                }
                GradientLayout.this.mBackgroundPaint.setShader(GradientLayout.this.mNormalShader);
                if (GradientLayout.this.shouldSetDisabledShader()) {
                    GradientLayout.this.mDisabledPaint.setShader(GradientLayout.this.mDisabledShader);
                }
                GradientLayout.this.postInvalidate();
            }
        });
    }

    public void dispatchDraw(Canvas canvas) {
        this.mBackgroundPaint.setColor(getColorWhenAnimating(this.mLeftColor));
        if (this.mRect.width() > 0.0f && this.mRect.height() > 0.0f) {
            if (isEnabled()) {
                float f = this.mCanvasScale;
                canvas.scale(f, f, this.mCenterX, this.mCenterY);
                if (this.mEnableDrawBackground) {
                    drawBackground(canvas);
                }
            } else if (this.mEnableDrawBackground) {
                RectF rectF = this.mRect;
                int i = this.mCornerRadius;
                canvas.drawRoundRect(rectF, (float) i, (float) i, this.mDisabledPaint);
            }
        }
        super.dispatchDraw(canvas);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001d, code lost:
        if (r0 != 3) goto L_0x0036;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(android.view.MotionEvent r3) {
        /*
            r2 = this;
            boolean r0 = r2.mOnlyDrawShadow
            if (r0 == 0) goto L_0x0009
            boolean r2 = super.dispatchTouchEvent(r3)
            return r2
        L_0x0009:
            boolean r0 = r2.isEnabled()
            r1 = 1
            if (r0 != 0) goto L_0x0011
            return r1
        L_0x0011:
            int r0 = r3.getAction()
            if (r0 == 0) goto L_0x0033
            if (r0 == r1) goto L_0x0028
            r1 = 2
            if (r0 == r1) goto L_0x0020
            r1 = 3
            if (r0 == r1) goto L_0x0028
            goto L_0x0036
        L_0x0020:
            boolean r0 = r2.mIsTouchCanceled
            if (r0 != 0) goto L_0x0036
            r2.handleActionMove(r3)
            goto L_0x0036
        L_0x0028:
            boolean r0 = r2.mIsTouchCanceled
            if (r0 != 0) goto L_0x002f
            r2.handleActionUp(r3)
        L_0x002f:
            r0 = 0
            r2.mIsTouchCanceled = r0
            goto L_0x0036
        L_0x0033:
            r2.handleActionDown(r3)
        L_0x0036:
            boolean r2 = super.dispatchTouchEvent(r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.widget.GradientLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public void enableDrawBackground(boolean z) {
        this.mEnableDrawBackground = z;
    }

    public float getCanvasRotationY() {
        return this.mCanvasRotationY;
    }

    public float getCanvasRotationZ() {
        return this.mCanvasRotationZ;
    }

    public float getCanvasScale() {
        return this.mCanvasScale;
    }

    public int getDisableColorAlpha() {
        return this.mDisableColorAlpha;
    }

    public boolean getEnableRotateY() {
        return this.mEnableRotateY;
    }

    public boolean isOnlyDrawShadow() {
        return this.mOnlyDrawShadow;
    }

    public boolean isShouldDrawShadow() {
        return this.mShouldDrawShadow;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mRect.set(0.0f, 0.0f, (float) i, (float) i2);
        this.mLayoutWidth = i;
        this.mLayoutHeight = i2;
        this.mCenterX = (float) (i / 2);
        this.mCenterY = (float) (i2 / 2);
        this.mCornerRadius = i2 / 2;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mOnlyDrawShadow) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public void setCanvasRotationY(float f) {
        this.mCanvasRotationY = f;
        invalidate();
    }

    public void setCanvasRotationZ(float f) {
        this.mCanvasRotationZ = f;
        invalidate();
    }

    public void setCanvasScale(float f) {
        this.mCanvasScale = f;
        invalidate();
    }

    public void setDisableColorAlpha(int i) {
        if (i >= 0 && i <= 255) {
            this.mDisableColorAlpha = i;
        }
    }

    public void setEnableRotateY(boolean z) {
        this.mEnableRotateY = z;
    }

    public void setLeftColor(int i) {
        this.mLeftColor = i;
        this.mBackgroundPaint.setColor(i);
        postInvalidate();
    }

    public void setOnlyDrawShadow(boolean z) {
        this.mOnlyDrawShadow = z;
        invalidate();
    }

    public void setOrientation(int i) {
        if (i == 0) {
            super.setOrientation(i);
            return;
        }
        throw new IllegalStateException("Orientation must be HORIZONTAL");
    }

    public void setRightColor(int i) {
        this.mRightColor = i;
        postInvalidate();
    }

    public void setShouldDrawShadow(boolean z) {
        this.mShouldDrawShadow = z;
        if (z && this.mShadowDrawable == null) {
            setupShadowDrawable();
        }
        invalidate();
    }

    public void setupShadowDrawable() {
        if (!this.mShouldDrawShadow) {
            return;
        }
        if (this.mShapeMode == 1) {
            this.mShadowDrawable = getResources().getDrawable(R.drawable.mc_gradient_layout_circle_shadow, (Resources.Theme) null);
        } else {
            this.mShadowDrawable = getResources().getDrawable(R.drawable.mc_gradient_layout_shadow, (Resources.Theme) null);
        }
    }

    public GradientLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GradientLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.DEFAULT_COLOR = -16711936;
        this.SHAPE_NORMAL = 0;
        this.SHAPE_CIRCLE = 1;
        this.DISABLED_PAINT_COLOR = -1710619;
        this.mMaxRotationYDegree = 5.0f;
        this.mMinScale = 0.95f;
        this.MAX_GRADIENT_SCALE = 1.0f;
        this.MIN_GRADIENT_SCALE = 0.1f;
        this.ANIM_DOWN_DURATION = 128;
        this.ANIM_UP_DURATION = 352;
        this.PROPERTY_CANVAS_SCALE = "canvasScale";
        this.PROPERTY_CANVAS_ROTATION_Y = "canvasRotationY";
        this.PROPERTY_CANVAS_ROTATION_Z = "canvasRotationZ";
        this.mRect = new RectF();
        this.mCamera = new Camera();
        this.mRotationMatrix = new Matrix();
        this.mGradientMatrix = new Matrix();
        this.mRadialCenterColor = 654311424;
        this.mRadialEdgeColor = 0;
        this.mDisableColorAlpha = 76;
        this.mLeftColor = -16711936;
        this.mRightColor = -16711936;
        this.mTargetScale = 1.0f;
        this.mCanvasScale = 1.0f;
        this.mTargetYDegree = 0.0f;
        this.mGradientScale = 0.0f;
        this.mIsSwipeMode = false;
        this.mIsTouchCanceled = false;
        this.mShouldDrawShadow = true;
        this.mEnableRotateY = false;
        this.mHasMultiChild = false;
        this.mDrawShader = false;
        this.mOnlyDrawShadow = false;
        this.mBackgroundBeGreyWhenDisabled = true;
        this.mEnableDrawBackground = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.GradientLayout, 0, 0);
        if (obtainStyledAttributes != null) {
            this.mLeftColor = obtainStyledAttributes.getColor(R.styleable.GradientLayout_mcLeftColor, this.mLeftColor);
            this.mRightColor = obtainStyledAttributes.getColor(R.styleable.GradientLayout_mcRightColor, this.mRightColor);
            this.mShapeMode = obtainStyledAttributes.getInt(R.styleable.GradientLayout_mcShape, 0);
            this.mShouldDrawShadow = obtainStyledAttributes.getBoolean(R.styleable.GradientLayout_mcDrawShadow, true);
            this.mEnableRotateY = obtainStyledAttributes.getBoolean(R.styleable.GradientLayout_mcEnableRotateY, false);
            this.mOnlyDrawShadow = obtainStyledAttributes.getBoolean(R.styleable.GradientLayout_mcOnlyDrawShadow, false);
            this.mBackgroundBeGreyWhenDisabled = obtainStyledAttributes.getBoolean(R.styleable.GradientLayout_mcGreyWhenDisabled, true);
            this.mEnableDrawBackground = obtainStyledAttributes.getBoolean(R.styleable.GradientLayout_mcEnableDrawBackground, true);
            obtainStyledAttributes.recycle();
        }
        init();
    }
}
