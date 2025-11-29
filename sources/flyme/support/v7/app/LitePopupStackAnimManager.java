package flyme.support.v7.app;

import android.app.Activity;
import android.util.Log;
import android.widget.LinearLayout;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatValueHolder;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.meizu.common.util.ResourceUtils;
import flyme.support.v7.appcompat.R;
import flyme.support.v7.widget.LitePopupContentFrameLayout;
import flyme.support.v7.widget.PopupNestedScrollingLayout;

final class LitePopupStackAnimManager {
    public static float DAMP1 = 0.88f;
    public static float DAMP2 = 0.93f;
    public static float STIFFNESS1 = 340.0f;
    public static float STIFFNESS2 = 400.0f;
    private static LitePopupStackAnimManager sInstance;
    private boolean isInStackState;
    private LitePopupContentFrameLayout mContent;
    /* access modifiers changed from: private */
    public PopupNestedScrollingLayout mNestedScrollingLayout;
    private Activity mStackBottomActivity;
    private final SpringAnimation mStackPopupScaleXSpringAnimation;
    private final SpringAnimation mStackPopupTansYSpringAnimation;
    private int mTargetPopupType = -1;
    private LinearLayout mToolbarContainer;

    private LitePopupStackAnimManager() {
        SpringAnimation springAnimation = new SpringAnimation(new FloatValueHolder());
        this.mStackPopupTansYSpringAnimation = springAnimation;
        springAnimation.c(new DynamicAnimation.OnAnimationUpdateListener() {
            public void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f2) {
                LitePopupStackAnimManager.this.mNestedScrollingLayout.performScrollTo((int) f);
            }
        });
        SpringAnimation springAnimation2 = new SpringAnimation(new FloatValueHolder());
        this.mStackPopupScaleXSpringAnimation = springAnimation2;
        springAnimation2.c(new DynamicAnimation.OnAnimationUpdateListener() {
            public void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f2) {
                float f3 = f / 100.0f;
                LitePopupStackAnimManager.this.mNestedScrollingLayout.setScaleX(f3);
                LitePopupStackAnimManager.this.mNestedScrollingLayout.setScaleY(f3);
            }
        });
    }

    public static LitePopupStackAnimManager getInstance() {
        if (sInstance == null) {
            sInstance = new LitePopupStackAnimManager();
        }
        return sInstance;
    }

    private boolean isEnableStackMode() {
        return this.mStackBottomActivity != null && (this.mNestedScrollingLayout.getPositionState() == this.mTargetPopupType || this.mNestedScrollingLayout.getPositionState() == 1);
    }

    public void bottomPopupEnterStack() {
        if (isEnableStackMode()) {
            Log.d(LitePopupActivity.POPUP_STACK_TAG, " bottom stack pause , enter stack state ");
            int dp2px = (int) ResourceUtils.dp2px(10.0f, this.mStackBottomActivity);
            if (this.mNestedScrollingLayout.getPositionState() == 0) {
                dp2px = (int) ResourceUtils.dp2px(35.0f, this.mStackBottomActivity);
            }
            this.mStackPopupTansYSpringAnimation.y(new SpringForce().d(DAMP1).f(STIFFNESS1));
            this.mStackPopupTansYSpringAnimation.n((float) this.mNestedScrollingLayout.getCurrentScrollY());
            this.mStackPopupTansYSpringAnimation.v().e((float) (this.mNestedScrollingLayout.getCurrentScrollY() + dp2px));
            this.mStackPopupTansYSpringAnimation.q();
            this.mStackPopupScaleXSpringAnimation.y(new SpringForce().d(DAMP1).f(STIFFNESS1));
            this.mStackPopupScaleXSpringAnimation.n(100.0f);
            this.mStackPopupScaleXSpringAnimation.v().e(93.0f);
            this.mStackPopupScaleXSpringAnimation.q();
            this.isInStackState = true;
        }
    }

    public void bottomPopupExitStack() {
        if (!this.isInStackState || !isEnableStackMode()) {
            Log.e(LitePopupActivity.POPUP_STACK_TAG, "  call bottom stack do stackExit , but state error, return ");
            return;
        }
        Log.d(LitePopupActivity.POPUP_STACK_TAG, " bottom stack exit success!! ");
        int i = -((int) ResourceUtils.dp2px(10.0f, this.mStackBottomActivity));
        if (this.mNestedScrollingLayout.getPositionState() == 0) {
            i = -((int) ResourceUtils.dp2px(35.0f, this.mStackBottomActivity));
        }
        this.mStackPopupTansYSpringAnimation.y(new SpringForce().d(DAMP2).f(STIFFNESS2));
        this.mStackPopupTansYSpringAnimation.n((float) this.mNestedScrollingLayout.getCurrentScrollY());
        this.mStackPopupTansYSpringAnimation.v().e((float) (this.mNestedScrollingLayout.getCurrentScrollY() + i));
        this.mStackPopupTansYSpringAnimation.q();
        this.mStackPopupScaleXSpringAnimation.y(new SpringForce().d(DAMP2).f(STIFFNESS2));
        this.mStackPopupScaleXSpringAnimation.n(93.0f);
        this.mStackPopupScaleXSpringAnimation.v().e(100.0f);
        this.mStackPopupScaleXSpringAnimation.q();
        this.isInStackState = false;
    }

    public void bottomStackResume() {
        if (this.isInStackState) {
            Log.e(LitePopupActivity.POPUP_STACK_TAG, " bottom stack resume, but still in stack, call exit ");
            bottomPopupExitStack();
        }
        this.isInStackState = false;
    }

    public Activity getBottomStackActivity() {
        return this.mStackBottomActivity;
    }

    public void release() {
        sInstance = null;
    }

    public void setStackBottomActivity(Activity activity, int i) {
        if (this.mStackBottomActivity == null) {
            this.mStackBottomActivity = activity;
            this.mContent = (LitePopupContentFrameLayout) activity.findViewById(16908290);
            this.mToolbarContainer = (LinearLayout) activity.findViewById(R.id.action_bar_container);
            this.mNestedScrollingLayout = (PopupNestedScrollingLayout) activity.findViewById(R.id.nested_scrolling_layout);
            this.mTargetPopupType = i;
        }
        this.isInStackState = true;
    }
}
