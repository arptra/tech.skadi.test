package flyme.support.v7.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import flyme.support.v7.app.LitePopup;
import flyme.support.v7.appcompat.R;
import flyme.support.v7.widget.LitePopupContentFrameLayout;
import flyme.support.v7.widget.PopupNestedScrollingLayout;

class LitePopupImpl implements LitePopup {
    private static final Interpolator DIM_ALPHA_INTERPOLATOR = PathInterpolatorCompat.a(0.33f, 0.0f, 0.67f, 1.0f);
    private static final Interpolator ENTER_TRANS_INTERPOLATOR = PathInterpolatorCompat.a(0.11f, 0.9f, 0.2f, 1.0f);
    private static final Interpolator EXIT_TRANS_INTERPOLATOR = PathInterpolatorCompat.a(0.23f, 0.03f, 0.63f, 0.93f);
    private ActionBar mActionBar;
    /* access modifiers changed from: private */
    public LitePopupActivity mActivity;
    protected boolean mCancelable = true;
    private LitePopupContentFrameLayout mContent;
    private int mCurDimAlpha;
    private final ColorDrawable mDimBackground;
    private LitePopup.OnDismissedListener mDismissedListener = new LitePopup.OnDismissedListener() {
        public void onDismissProgress(float f) {
            LitePopupImpl.this.updateDimAlpha(f);
            LitePopupImpl.this.mActivity.performDismissProgress(f);
        }

        public void onDismissed(boolean z) {
            LitePopupImpl.this.mActivity.performDismissed();
            LitePopupImpl.this.mActivity.finish(z);
        }

        public void onDragTriggered() {
            LitePopupImpl.this.mActivity.performDragTriggered();
        }
    };
    /* access modifiers changed from: private */
    public AnimatorSet mExitAnimator;
    /* access modifiers changed from: private */
    public PopupNestedScrollingLayout mNestedScrollingLayout;
    private boolean mScrollToDismissEnabled = true;
    private SpringAnimation mSpringAnimation;
    private int mStyle = 0;
    private LinearLayout mToolbarContainer;
    private final int mTotalDimAlpha;
    private Window mWindow;

    public LitePopupImpl(LitePopupActivity litePopupActivity) {
        this.mActivity = litePopupActivity;
        this.mWindow = litePopupActivity.getWindow();
        PopupNestedScrollingLayout popupNestedScrollingLayout = (PopupNestedScrollingLayout) this.mActivity.findViewById(R.id.nested_scrolling_layout);
        this.mNestedScrollingLayout = popupNestedScrollingLayout;
        popupNestedScrollingLayout.setUncollapsibleHeight(this.mActivity.getResources().getDimensionPixelSize(R.dimen.mz_lite_popup_middle_state_height));
        this.mActionBar = this.mActivity.getSupportActionBar();
        this.mContent = (LitePopupContentFrameLayout) this.mActivity.findViewById(16908290);
        this.mDimBackground = new ColorDrawable(this.mActivity.getResources().getColor(R.color.mz_lite_popup_window_dim));
        this.mToolbarContainer = (LinearLayout) this.mActivity.findViewById(R.id.action_bar_container);
        this.mNestedScrollingLayout.setOnDismissedListener(this.mDismissedListener);
        this.mTotalDimAlpha = 255;
        this.mCurDimAlpha = 255;
        this.mSpringAnimation = new SpringAnimation(this.mNestedScrollingLayout, DynamicAnimation.n);
    }

    /* access modifiers changed from: private */
    public boolean isCurrentStackBottom() {
        return LitePopupStackAnimManager.getInstance().getBottomStackActivity() == this.mActivity;
    }

    /* access modifiers changed from: private */
    public void startEnterAnimation() {
        AnimatorSet animatorSet = new AnimatorSet();
        this.mNestedScrollingLayout.setTranslationY((float) (this.mNestedScrollingLayout.getCurrentScrollY() <= 0 ? this.mNestedScrollingLayout.getUncollapsibleHeight() : this.mNestedScrollingLayout.getMeasuredHeight()));
        this.mSpringAnimation.y(new SpringForce().d(LitePopupStackAnimManager.DAMP1).f(LitePopupStackAnimManager.STIFFNESS1));
        this.mSpringAnimation.v().e(0.0f);
        this.mSpringAnimation.q();
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this.mDimBackground, "alpha", new int[]{0, this.mTotalDimAlpha});
        ofInt.setInterpolator(DIM_ALPHA_INTERPOLATOR);
        ofInt.setDuration(100);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                if (!LitePopupImpl.this.isCurrentStackBottom()) {
                    LitePopupStackAnimManager.getInstance().bottomPopupEnterStack();
                }
            }
        });
        animatorSet.playTogether(new Animator[]{ofInt});
        animatorSet.start();
    }

    /* access modifiers changed from: private */
    public void updateDimAlpha(float f) {
        int i = (int) (((float) this.mTotalDimAlpha) * (1.0f - f));
        this.mDimBackground.setAlpha(i);
        this.mCurDimAlpha = i;
    }

    public void addDimLayer() {
    }

    public void cancelDrag() {
        this.mNestedScrollingLayout.cancelDrag();
    }

    public int getUncollapsibleHeight() {
        return this.mNestedScrollingLayout.getUncollapsibleHeight();
    }

    public void hideTitleBar() {
        this.mToolbarContainer.setVisibility(8);
        Drawable drawable = this.mActivity.getResources().getDrawable(R.drawable.mz_lite_popup_title_bar_bg);
        drawable.setTint(this.mActivity.getColor(R.color.fd_sys_color_surface_bright_default));
        this.mContent.setBackground(drawable);
    }

    public void onActivityCreate() {
        this.mActivity.getWindow().setBackgroundDrawable(this.mDimBackground);
        this.mNestedScrollingLayout.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                LitePopupImpl.this.mNestedScrollingLayout.getViewTreeObserver().removeOnPreDrawListener(this);
                LitePopupImpl.this.startEnterAnimation();
                return true;
            }
        });
        this.mActivity.overridePendingTransition(0, 0);
        if (Build.VERSION.SDK_INT >= 30) {
            this.mWindow.setDecorFitsSystemWindows(false);
        } else {
            this.mWindow.getDecorView().setSystemUiVisibility(this.mWindow.getDecorView().getSystemUiVisibility() | 1792);
        }
    }

    public void onActivityFinish() {
        AnimatorSet animatorSet = this.mExitAnimator;
        if (animatorSet == null || !animatorSet.isRunning()) {
            this.mExitAnimator = new AnimatorSet();
            int uncollapsibleHeight = this.mNestedScrollingLayout.getCurrentScrollY() <= 0 ? this.mNestedScrollingLayout.getUncollapsibleHeight() : this.mNestedScrollingLayout.getMeasuredHeight();
            this.mSpringAnimation.y(new SpringForce().d(LitePopupStackAnimManager.DAMP2).f(LitePopupStackAnimManager.STIFFNESS2));
            this.mSpringAnimation.v().e((float) uncollapsibleHeight);
            this.mSpringAnimation.q();
            ObjectAnimator ofInt = ObjectAnimator.ofInt(this.mDimBackground, "alpha", new int[]{this.mCurDimAlpha, 0});
            ofInt.setInterpolator(DIM_ALPHA_INTERPOLATOR);
            ofInt.setDuration(300);
            this.mExitAnimator.playTogether(new Animator[]{ofInt});
            this.mExitAnimator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    LitePopupImpl.this.mActivity.superFinish();
                    LitePopupImpl.this.mActivity.overridePendingTransition(0, 0);
                    AnimatorSet unused = LitePopupImpl.this.mExitAnimator = null;
                    LitePopupStackAnimManager.getInstance().release();
                }

                public void onAnimationStart(Animator animator) {
                    if (!LitePopupImpl.this.isCurrentStackBottom()) {
                        Log.d(LitePopupActivity.POPUP_STACK_TAG, " top stack start exit Anim, try to call bottom stack do stackExit ");
                        LitePopupStackAnimManager.getInstance().bottomPopupExitStack();
                    }
                }
            });
            this.mExitAnimator.start();
        }
    }

    public void onActivityResume() {
        if (isCurrentStackBottom()) {
            Log.d(LitePopupActivity.POPUP_STACK_TAG, " bottom stack resume, to reset state ");
            LitePopupStackAnimManager.getInstance().bottomStackResume();
        }
    }

    public void onBackPressed() {
        if (this.mCancelable) {
            this.mActivity.superOnBackPressed();
        }
    }

    public void prepareStackPopup(int i) {
        LitePopupStackAnimManager.getInstance().setStackBottomActivity(this.mActivity, i);
    }

    public void removeDimLayer() {
    }

    public void setCancelable(boolean z) {
        this.mCancelable = z;
        this.mNestedScrollingLayout.setDismissedOnTouchOutside(z);
    }

    public void setCanceledOnTouchOutside(boolean z) {
        if (z && !this.mCancelable) {
            this.mCancelable = true;
        }
        this.mNestedScrollingLayout.setDismissedOnTouchOutside(z);
    }

    public void setScrollPopupFirstOnTop(boolean z) {
        PopupNestedScrollingLayout popupNestedScrollingLayout = this.mNestedScrollingLayout;
        if (popupNestedScrollingLayout != null) {
            popupNestedScrollingLayout.setScrollPopupFirstOnTop(z);
        }
    }

    public void setScrollToDismissEnabled(boolean z) {
        this.mScrollToDismissEnabled = z;
        PopupNestedScrollingLayout popupNestedScrollingLayout = this.mNestedScrollingLayout;
        if (popupNestedScrollingLayout != null) {
            popupNestedScrollingLayout.setScrollToDismissEnabled(z);
        }
    }

    public void setStyle(int i) {
        this.mStyle = i;
        PopupNestedScrollingLayout popupNestedScrollingLayout = this.mNestedScrollingLayout;
        if (popupNestedScrollingLayout != null) {
            popupNestedScrollingLayout.setStyle(i);
        }
    }

    public void setUncollapsibleHeight(int i) {
        this.mNestedScrollingLayout.setUncollapsibleHeight(i);
    }

    public void showTitleBar() {
        this.mToolbarContainer.setVisibility(0);
        this.mContent.setBackground(this.mActivity.getResources().getDrawable(com.meizu.common.R.color.white));
    }

    public void unLimitMiddleOnlyHeight() {
        PopupNestedScrollingLayout popupNestedScrollingLayout = this.mNestedScrollingLayout;
        if (popupNestedScrollingLayout != null) {
            popupNestedScrollingLayout.unLimitMiddleOnlyHeight();
        }
    }
}
