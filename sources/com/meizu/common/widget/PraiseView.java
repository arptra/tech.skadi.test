package com.meizu.common.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.meizu.common.R;

public class PraiseView extends View implements View.OnTouchListener {
    /* access modifiers changed from: private */
    public boolean isAnimationRunning;
    private boolean isPerformAnimation;
    private Drawable mAnimImage;
    private ImageView mAnimImageView;
    private Animation.AnimationListener mAnimListener;
    /* access modifiers changed from: private */
    public PopupWindow mAnimPopWindow;
    private boolean mBackImageChanged;
    private Context mContext;
    private Stage mCurrentStage;
    private int mHeight;
    private Animation mPopAnimation;
    /* access modifiers changed from: private */
    public ViewGroup mPopWindowView;
    private int mPopwindowHiehgt;
    private int mPopwindowWidth;
    /* access modifiers changed from: private */
    public onPraiseCallBack mPraiseCallBack;
    private Drawable mPraiseImage;
    private float mTranslateHeight;
    private Drawable mUnPraiseImage;
    private int mWidth;

    public enum Stage {
        PRAISED,
        CANCEL
    }

    public interface onPraiseCallBack {
        void cancelAnimEnd();

        @Deprecated
        void praAlphAnimEnd();

        void praAnimEnd();
    }

    public PraiseView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void addImageView() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mWidth, this.mHeight);
        layoutParams.gravity = 81;
        ImageView imageView = new ImageView(this.mContext);
        this.mAnimImageView = imageView;
        imageView.setImageDrawable(this.mAnimImage);
        this.mAnimImageView.setLayoutParams(layoutParams);
        this.mPopWindowView.addView(this.mAnimImageView);
    }

    @TargetApi(21)
    private Interpolator getInterpolator(float f, float f2, float f3, float f4) {
        return new PathInterpolator(f, f2, f3, f4);
    }

    private int getMeasure(int i, int i2, int i3) {
        return i2 != 1073741824 ? i3 : i;
    }

    private Animation initAnimation() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.6f, 1.0f, 1.6f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(getInterpolator(0.3f, 0.0f, 0.1f, 1.0f));
        scaleAnimation.setDuration(700);
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, -(this.mTranslateHeight / ((float) this.mPopwindowHiehgt)));
        translateAnimation.setInterpolator(getInterpolator(0.3f, 0.0f, 0.1f, 1.0f));
        translateAnimation.setDuration(700);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 25.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(100);
        rotateAnimation.setInterpolator(getInterpolator(0.3f, 0.0f, 0.7f, 1.0f));
        RotateAnimation rotateAnimation2 = new RotateAnimation(0.0f, -25.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation2.setDuration(120);
        rotateAnimation2.setStartOffset(100);
        rotateAnimation2.setInterpolator(getInterpolator(0.3f, 0.0f, 0.7f, 1.0f));
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setInterpolator(getInterpolator(0.3f, 0.0f, 0.7f, 1.0f));
        alphaAnimation.setDuration(300);
        alphaAnimation.setStartOffset(700);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(rotateAnimation);
        animationSet.addAnimation(rotateAnimation2);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                if (PraiseView.this.mPraiseCallBack != null) {
                    PraiseView.this.mPraiseCallBack.praAlphAnimEnd();
                }
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        animationSet.setAnimationListener(this.mAnimListener);
        return animationSet;
    }

    private void initAttributes(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PraiseView, i, R.style.Widget_MeizuCommon_PraiseView_Default);
        this.mPraiseImage = obtainStyledAttributes.getDrawable(R.styleable.PraiseView_praiseBackDrawable);
        this.mUnPraiseImage = obtainStyledAttributes.getDrawable(R.styleable.PraiseView_unPraiseBackDrawable);
        this.mAnimImage = this.mPraiseImage.getConstantState().newDrawable();
        obtainStyledAttributes.recycle();
        setBackground(this.mUnPraiseImage);
        this.mCurrentStage = Stage.CANCEL;
        this.isPerformAnimation = true;
        this.isAnimationRunning = false;
        this.mBackImageChanged = true;
    }

    private void initPopWindow() {
        this.mPopWindowView = new FrameLayout(this.mContext);
        addImageView();
        PopupWindow popupWindow = new PopupWindow(this.mPopWindowView, this.mPopwindowWidth, this.mPopwindowHiehgt);
        this.mAnimPopWindow = popupWindow;
        popupWindow.setAnimationStyle(0);
        this.mAnimPopWindow.setTouchable(false);
        this.mAnimPopWindow.setOutsideTouchable(true);
        this.mAnimPopWindow.setTouchInterceptor(this);
    }

    private void measurePopwindowHeight(int i, int i2) {
        this.mPopwindowWidth = i * 2;
        float f = this.mContext.getResources().getDisplayMetrics().density * 66.666664f;
        this.mTranslateHeight = f;
        this.mPopwindowHiehgt = (int) (((double) f) + (((double) i2) * 1.6d));
    }

    private void startAnim() {
        if (this.mAnimPopWindow == null || this.mBackImageChanged) {
            initPopWindow();
        } else {
            addImageView();
        }
        if (this.mPopAnimation == null || this.mBackImageChanged) {
            this.mPopAnimation = initAnimation();
        }
        this.mBackImageChanged = false;
        this.mAnimPopWindow.showAsDropDown(this, -(this.mWidth / 2), -this.mPopwindowHiehgt);
        this.mAnimImageView.startAnimation(this.mPopAnimation);
    }

    public onPraiseCallBack getPraiseCallBack() {
        return this.mPraiseCallBack;
    }

    public Stage getState() {
        return this.mCurrentStage;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(PraiseView.class.getName());
    }

    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int intrinsicWidth = this.mPraiseImage.getIntrinsicWidth();
        int intrinsicHeight = this.mPraiseImage.getIntrinsicHeight();
        this.mWidth = getMeasure(size, mode, intrinsicWidth);
        int measure = getMeasure(size2, mode2, intrinsicHeight);
        this.mHeight = measure;
        setMeasuredDimension(this.mWidth, measure);
        measurePopwindowHeight(this.mWidth, this.mHeight);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        Animation.AnimationListener animationListener;
        if (motionEvent.getAction() != 4 && motionEvent.getAction() != 4) {
            return false;
        }
        Animation animation = this.mPopAnimation;
        if (animation == null || (animationListener = this.mAnimListener) == null) {
            return true;
        }
        animationListener.onAnimationEnd(animation);
        return true;
    }

    public void setAnimationPerform(boolean z) {
        this.isPerformAnimation = z;
    }

    public void setBackgroundDrawable(Drawable drawable, Drawable drawable2) {
        this.mUnPraiseImage = drawable2;
        this.mPraiseImage = drawable;
        this.mAnimImage = drawable.getConstantState().newDrawable();
        if (this.mCurrentStage == Stage.CANCEL) {
            setBackground(drawable2);
        } else {
            setBackground(drawable);
        }
        this.mBackImageChanged = true;
    }

    public void setBackgroundResId(int i, int i2) {
        this.mUnPraiseImage = getResources().getDrawable(i2);
        Drawable drawable = getResources().getDrawable(i);
        this.mPraiseImage = drawable;
        this.mAnimImage = drawable.getConstantState().newDrawable();
        if (this.mCurrentStage == Stage.CANCEL) {
            setBackground(this.mUnPraiseImage);
        } else {
            setBackground(this.mPraiseImage);
        }
        this.mBackImageChanged = true;
    }

    public void setPraiseCallBack(onPraiseCallBack onpraisecallback) {
        this.mPraiseCallBack = onpraisecallback;
    }

    public void setState(Stage stage) {
        Stage stage2 = Stage.PRAISED;
        if (stage == stage2) {
            if (this.mCurrentStage != stage) {
                this.mCurrentStage = stage2;
                setBackground(this.mPraiseImage);
                if (this.isPerformAnimation) {
                    startAnim();
                }
            }
        } else if (this.mCurrentStage != stage) {
            this.mCurrentStage = Stage.CANCEL;
            PopupWindow popupWindow = this.mAnimPopWindow;
            if (popupWindow != null) {
                popupWindow.dismiss();
            }
            setBackground(this.mUnPraiseImage);
            onPraiseCallBack onpraisecallback = this.mPraiseCallBack;
            if (onpraisecallback != null) {
                onpraisecallback.cancelAnimEnd();
            }
        }
    }

    public PraiseView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PraiseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mAnimListener = new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                if (PraiseView.this.mPopWindowView.getChildCount() >= 1) {
                    PraiseView.this.mPopWindowView.removeViewAt(0);
                }
                PraiseView.this.post(new Runnable() {
                    public void run() {
                        PraiseView.this.mAnimPopWindow.dismiss();
                    }
                });
                if (PraiseView.this.mPraiseCallBack != null) {
                    PraiseView.this.mPraiseCallBack.praAnimEnd();
                }
                boolean unused = PraiseView.this.isAnimationRunning = false;
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                boolean unused = PraiseView.this.isAnimationRunning = true;
            }
        };
        this.mContext = context;
        initAttributes(context, attributeSet, i);
    }
}
