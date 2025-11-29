package flyme.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import androidx.core.view.animation.PathInterpolatorCompat;
import flyme.support.v7.app.ActionBar;
import flyme.support.v7.appcompat.R;

public class ActionBarDropDownView extends FrameLayout {
    private static final int ANIMATION_DURATION = 350;
    private static final Interpolator ANIMATION_INTERPOLATOR_ALPHA = PathInterpolatorCompat.a(0.33f, 0.0f, 0.66f, 1.0f);
    private static final Interpolator ANIMATION_INTERPOLATOR_TRANSLATION = PathInterpolatorCompat.a(0.12f, 0.31f, 0.1f, 1.0f);
    private static final int STATE_CONTENT_DISMISSED = 1;
    private static final int STATE_CONTENT_DISMISSING = 0;
    private static final int STATE_CONTENT_SHOWING = 2;
    private static final int STATE_CONTENT_SHOWN = 3;
    private View mBackgroundView;
    /* access modifiers changed from: private */
    public ActionBar.DropDownCallback mCallback;
    private int mContentHeight;
    private View mContentView;
    private AnimatorSet mCurAnimator;
    private Animator.AnimatorListener mDismissAnimatorListener;
    private int mGravity;
    private Animator.AnimatorListener mShowAnimatorListener;
    /* access modifiers changed from: private */
    public int mState;

    public ActionBarDropDownView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void startShowAnim() {
        AnimatorSet animatorSet = this.mCurAnimator;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.mContentView.setTranslationY((float) (-this.mContentHeight));
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mContentView, "translationY", new float[]{0.0f});
        ofFloat.setInterpolator(ANIMATION_INTERPOLATOR_TRANSLATION);
        AnimatorSet.Builder play = animatorSet2.play(ofFloat);
        this.mBackgroundView.setAlpha(0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mBackgroundView, "alpha", new float[]{1.0f});
        ofFloat2.setInterpolator(ANIMATION_INTERPOLATOR_ALPHA);
        play.with(ofFloat2);
        animatorSet2.setDuration(350);
        animatorSet2.addListener(this.mShowAnimatorListener);
        animatorSet2.start();
        this.mCurAnimator = animatorSet2;
        ActionBar.DropDownCallback dropDownCallback = this.mCallback;
        if (dropDownCallback != null) {
            dropDownCallback.onShow();
        }
    }

    public void dismiss() {
        int i = this.mState;
        if (i != 1 && i != 0) {
            AnimatorSet animatorSet = this.mCurAnimator;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mContentView, "translationY", new float[]{(float) (-this.mContentHeight)});
            ofFloat.setInterpolator(ANIMATION_INTERPOLATOR_TRANSLATION);
            AnimatorSet.Builder play = animatorSet2.play(ofFloat);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mBackgroundView, "alpha", new float[]{0.0f});
            ofFloat2.setInterpolator(ANIMATION_INTERPOLATOR_ALPHA);
            play.with(ofFloat2);
            animatorSet2.setDuration(350);
            animatorSet2.addListener(this.mDismissAnimatorListener);
            animatorSet2.start();
            this.mCurAnimator = animatorSet2;
            ActionBar.DropDownCallback dropDownCallback = this.mCallback;
            if (dropDownCallback != null) {
                dropDownCallback.onHide();
            }
        }
    }

    public void onMeasure(int i, int i2) {
        View view;
        super.onMeasure(i, i2);
        if (getVisibility() == 0 && (view = this.mContentView) != null) {
            int measuredHeight = view.getMeasuredHeight();
            this.mContentHeight = measuredHeight;
            if (this.mState == 1 && measuredHeight > 0) {
                startShowAnim();
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            return true;
        }
        if (action == 1) {
            dismiss();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCallback(ActionBar.DropDownCallback dropDownCallback) {
        this.mCallback = dropDownCallback;
    }

    public void setContentView(View view, int i, int i2) {
        ViewGroup viewGroup;
        if (view != null) {
            View view2 = this.mContentView;
            if (view2 != null && view2.getParent() == this) {
                removeView(this.mContentView);
            }
            if (!(view.getParent() == null || (viewGroup = (ViewGroup) view.getParent()) == this)) {
                viewGroup.removeView(view);
            }
            this.mContentView = view;
            addView(view, i, i2);
        }
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public void show(int i) {
        if (this.mContentView != null) {
            this.mGravity = i;
            if (getVisibility() != 0) {
                setVisibility(0);
                requestLayout();
                return;
            }
            int i2 = this.mState;
            if (i2 == 1 || i2 == 0) {
                startShowAnim();
            }
        }
    }

    public ActionBarDropDownView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionBarDropDownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContentHeight = -1;
        this.mState = 1;
        this.mShowAnimatorListener = new AnimatorListenerAdapter() {
            private boolean mIsCanceled;

            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                this.mIsCanceled = true;
            }

            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (!this.mIsCanceled) {
                    int unused = ActionBarDropDownView.this.mState = 3;
                    if (ActionBarDropDownView.this.mCallback != null) {
                        ActionBarDropDownView.this.mCallback.onShown();
                    }
                }
            }

            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                int unused = ActionBarDropDownView.this.mState = 2;
                ActionBarDropDownView.this.setVisibility(0);
                this.mIsCanceled = false;
            }
        };
        this.mDismissAnimatorListener = new AnimatorListenerAdapter() {
            private boolean mIsCancel;

            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                this.mIsCancel = true;
            }

            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (!this.mIsCancel) {
                    int unused = ActionBarDropDownView.this.mState = 1;
                    ActionBarDropDownView.this.setVisibility(4);
                    if (ActionBarDropDownView.this.mCallback != null) {
                        ActionBarDropDownView.this.mCallback.onHidden();
                    }
                }
            }

            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                int unused = ActionBarDropDownView.this.mState = 0;
                this.mIsCancel = false;
            }
        };
        View view = new View(context);
        this.mBackgroundView = view;
        view.setBackgroundColor(context.getResources().getColor(R.color.mz_action_bar_drop_down_view_background));
        addView(this.mBackgroundView, -1, -1);
    }
}
