package com.meizu.common.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.BitmapDrawable;
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
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.meizu.common.R;

public class CollectingView extends View implements View.OnTouchListener {
    /* access modifiers changed from: private */
    public boolean isAnimationRunning;
    private boolean isPerformAnimation;
    private Drawable mAnimImage;
    private ImageView mAnimImageView;
    private Animation.AnimationListener mAnimListener;
    /* access modifiers changed from: private */
    public PopupWindow mAnimPopWindow;
    private boolean mBackImageChanged;
    private Drawable mCollectImage;
    /* access modifiers changed from: private */
    public OnCollectCallBack mCollectingCallBack;
    private Context mContext;
    private Stage mCurrentStage;
    private int mHeight;
    private Animation mPopAnimation;
    /* access modifiers changed from: private */
    public ViewGroup mPopWindowView;
    private int mPopwindowHiehgt;
    private int mPopwindowWidth;
    private float mTranslateHeight;
    private Drawable mUnCollectImage;
    private int mWidth;

    public interface OnCollectCallBack {
        void cancleEndAnim();

        void cancleStartAnim();

        void collectEndAnim();

        void collectStartAnim();
    }

    public enum Stage {
        COLLECTED,
        CANCEL
    }

    public CollectingView(Context context) {
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
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setInterpolator(getInterpolator(0.3f, 0.0f, 0.7f, 1.0f));
        alphaAnimation.setDuration(300);
        alphaAnimation.setStartOffset(700);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setAnimationListener(this.mAnimListener);
        return animationSet;
    }

    private void initAttributes(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CollectingView, i, R.style.Widget_MeizuCommon_CollectingView_Default);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.CollectingView_collectBackDrawable);
        this.mCollectImage = drawable;
        this.mAnimImage = drawable.getConstantState().newDrawable();
        this.mUnCollectImage = obtainStyledAttributes.getDrawable(R.styleable.CollectingView_unCollectBackDrawable);
        obtainStyledAttributes.recycle();
        setBackground(this.mUnCollectImage);
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
        this.mAnimPopWindow.setTouchable(true);
        this.mAnimPopWindow.setOutsideTouchable(true);
        this.mAnimPopWindow.setBackgroundDrawable(new BitmapDrawable());
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
        this.mAnimPopWindow.showAsDropDown(this, 1 == getLayoutDirection() ? Math.abs((this.mPopwindowWidth - this.mWidth) / 2) : -Math.abs((this.mPopwindowWidth - this.mWidth) / 2), -this.mPopwindowHiehgt);
        this.mAnimImageView.startAnimation(this.mPopAnimation);
    }

    public OnCollectCallBack getCollectCallBack() {
        return this.mCollectingCallBack;
    }

    public Stage getState() {
        return this.mCurrentStage;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(CollectingView.class.getName());
    }

    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int intrinsicWidth = this.mCollectImage.getIntrinsicWidth();
        int intrinsicHeight = this.mCollectImage.getIntrinsicHeight();
        this.mWidth = getMeasure(size, mode, intrinsicWidth);
        int measure = getMeasure(size2, mode2, intrinsicHeight);
        this.mHeight = measure;
        setMeasuredDimension(this.mWidth, measure);
        measurePopwindowHeight(this.mWidth, this.mHeight);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        Animation.AnimationListener animationListener;
        if (motionEvent.getAction() != 0 && motionEvent.getAction() != 4) {
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
        this.mUnCollectImage = drawable2;
        this.mCollectImage = drawable;
        this.mAnimImage = drawable.getConstantState().newDrawable();
        if (this.mCurrentStage == Stage.CANCEL) {
            setBackground(this.mUnCollectImage);
        } else {
            setBackground(this.mCollectImage);
        }
        this.mBackImageChanged = true;
    }

    public void setBackgroundResId(int i, int i2) {
        this.mUnCollectImage = getResources().getDrawable(i2);
        Drawable drawable = getResources().getDrawable(i);
        this.mCollectImage = drawable;
        this.mAnimImage = drawable.getConstantState().newDrawable();
        if (this.mCurrentStage == Stage.CANCEL) {
            setBackground(this.mUnCollectImage);
        } else {
            setBackground(this.mCollectImage);
        }
        this.mBackImageChanged = true;
    }

    public void setCollectCallBack(OnCollectCallBack onCollectCallBack) {
        this.mCollectingCallBack = onCollectCallBack;
    }

    public void setState(Stage stage) {
        OnCollectCallBack onCollectCallBack;
        Stage stage2 = Stage.COLLECTED;
        if (stage == stage2) {
            if (this.mCurrentStage != stage) {
                this.mCurrentStage = stage2;
                setBackground(this.mCollectImage);
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
            setBackground(this.mUnCollectImage);
            if (this.isAnimationRunning && (onCollectCallBack = this.mCollectingCallBack) != null) {
                onCollectCallBack.cancleStartAnim();
            }
            OnCollectCallBack onCollectCallBack2 = this.mCollectingCallBack;
            if (onCollectCallBack2 != null) {
                onCollectCallBack2.cancleEndAnim();
            }
        }
    }

    public CollectingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CollectingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mAnimListener = new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                if (CollectingView.this.mPopWindowView.getChildCount() >= 1) {
                    CollectingView.this.mPopWindowView.removeViewAt(0);
                }
                CollectingView.this.post(new Runnable() {
                    public void run() {
                        if (CollectingView.this.mAnimPopWindow != null) {
                            CollectingView.this.mAnimPopWindow.dismiss();
                        }
                    }
                });
                if (CollectingView.this.mCollectingCallBack != null) {
                    CollectingView.this.mCollectingCallBack.collectEndAnim();
                }
                boolean unused = CollectingView.this.isAnimationRunning = false;
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                if (CollectingView.this.mCollectingCallBack != null) {
                    CollectingView.this.mCollectingCallBack.collectStartAnim();
                }
                boolean unused = CollectingView.this.isAnimationRunning = true;
            }
        };
        this.mContext = context;
        initAttributes(context, attributeSet, i);
    }
}
