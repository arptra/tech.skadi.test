package flyme.support.v7.widget;

import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

public class AnimationUtils {
    public static final Interpolator ACCELERATE_DECELERATE_INTERPOLATOR = new AccelerateDecelerateInterpolator();
    public static final int ANIMATION_DURATION_TRANSLATION = 260;
    public static final Interpolator ANIMATION_INTERPOLATOR_SNAP = PathInterpolatorCompat.a(0.0f, 0.0f, 0.6f, 1.0f);
    public static final Interpolator ANIMATION_INTERPOLATOR_TEXT_SCALE = PathInterpolatorCompat.a(0.4f, 0.0f, 0.4f, 1.0f);
    public static final Interpolator ANIMATION_INTERPOLATOR_TRANSLATION_IN = PathInterpolatorCompat.a(0.0f, 0.33f, 0.1f, 1.0f);
    public static final Interpolator ANIMATION_INTERPOLATOR_TRANSLATION_OUT = PathInterpolatorCompat.a(0.0f, 0.66f, 0.66f, 1.0f);
    public static final Interpolator DECELERATE_INTERPOLATOR = new DecelerateInterpolator();
    public static final long FADE_IN_DURATION_MS = 200;
    public static final long FADE_OUT_DURATION_MS = 100;
    static final Interpolator FAST_OUT_LINEAR_IN_INTERPOLATOR = new FastOutLinearInInterpolator();
    static final Interpolator FAST_OUT_SLOW_IN_INTERPOLATOR = new FastOutSlowInInterpolator();
    public static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    static final Interpolator LINEAR_OUT_SLOW_IN_INTERPOLATOR = new LinearOutSlowInInterpolator();

    public static class AlphaVisibilityAnimator {
        /* access modifiers changed from: private */
        public ViewPropertyAnimatorCompat mAnimator;
        /* access modifiers changed from: private */
        public ViewPropertyAnimatorListener mAnimatorListener;
        /* access modifiers changed from: private */
        public View mTarget;
        private VisibilityAnimListener mVisAnimInnerListener = new VisibilityAnimListener();

        public class VisibilityAnimListener implements ViewPropertyAnimatorListener {
            private boolean mCanceled;
            int mFinalVisibility;

            private VisibilityAnimListener() {
                this.mCanceled = false;
            }

            public void onAnimationCancel(View view) {
                this.mCanceled = true;
                if (AlphaVisibilityAnimator.this.mAnimatorListener != null) {
                    AlphaVisibilityAnimator.this.mAnimatorListener.onAnimationCancel(view);
                }
            }

            public void onAnimationEnd(View view) {
                if (!this.mCanceled) {
                    ViewPropertyAnimatorCompat unused = AlphaVisibilityAnimator.this.mAnimator = null;
                    AlphaVisibilityAnimator.this.mTarget.setVisibility(this.mFinalVisibility);
                    if (AlphaVisibilityAnimator.this.mAnimatorListener != null) {
                        AlphaVisibilityAnimator.this.mAnimatorListener.onAnimationEnd(view);
                    }
                }
            }

            public void onAnimationStart(View view) {
                AlphaVisibilityAnimator.this.mTarget.setVisibility(0);
                this.mCanceled = false;
                if (AlphaVisibilityAnimator.this.mAnimatorListener != null) {
                    AlphaVisibilityAnimator.this.mAnimatorListener.onAnimationStart(view);
                }
            }

            public VisibilityAnimListener withFinalVisibility(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, int i) {
                ViewPropertyAnimatorCompat unused = AlphaVisibilityAnimator.this.mAnimator = viewPropertyAnimatorCompat;
                this.mFinalVisibility = i;
                return this;
            }
        }

        public AlphaVisibilityAnimator(View view, int i) {
            this.mTarget = view;
            if (i == 0) {
                if (view.getVisibility() != 0) {
                    ViewCompat.y0(this.mTarget, 0.0f);
                }
                ViewPropertyAnimatorCompat b = ViewCompat.e(this.mTarget).b(1.0f);
                this.mAnimator = b;
                b.i(100);
                ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mAnimator;
                viewPropertyAnimatorCompat.k(this.mVisAnimInnerListener.withFinalVisibility(viewPropertyAnimatorCompat, i));
                return;
            }
            ViewPropertyAnimatorCompat b2 = ViewCompat.e(view).b(0.0f);
            this.mAnimator = b2;
            b2.i(200);
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = this.mAnimator;
            viewPropertyAnimatorCompat2.k(this.mVisAnimInnerListener.withFinalVisibility(viewPropertyAnimatorCompat2, i));
        }

        public void cancel() {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mAnimator;
            if (viewPropertyAnimatorCompat != null) {
                viewPropertyAnimatorCompat.c();
            }
        }

        public ViewPropertyAnimatorCompat getAnimator() {
            return this.mAnimator;
        }

        public int getFinalVisibility() {
            return this.mVisAnimInnerListener.mFinalVisibility;
        }

        public void setAnimatorListener(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
            this.mAnimatorListener = viewPropertyAnimatorListener;
        }

        public void setDuration(int i) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mAnimator;
            if (viewPropertyAnimatorCompat != null) {
                viewPropertyAnimatorCompat.i((long) i);
            }
        }

        public void start() {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mAnimator;
            if (viewPropertyAnimatorCompat != null) {
                viewPropertyAnimatorCompat.o();
            }
        }
    }

    public static class AnimationListenerAdapter implements Animation.AnimationListener {
        public void onAnimationEnd(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    public static float lerp(float f, float f2, float f3) {
        return f + (f3 * (f2 - f));
    }

    public static int lerp(int i, int i2, float f) {
        return i + Math.round(f * ((float) (i2 - i)));
    }
}
