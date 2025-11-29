package com.google.android.material.appbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.dynamicanimation.animation.DynamicAnimation;
import com.google.android.material.appbar.AppBarLayout;
import flyme.support.v7.anim.FlymeXYSpring;
import flyme.support.v7.widget.AnimationUtils;
import flyme.support.v7.widget.CollapsingToolbarLayout;
import flyme.support.v7.widget.ITitleControl;
import flyme.support.v7.widget.MzAppBarLayout;
import java.lang.reflect.Field;

public class FlymeAppBarBehavior extends AppBarLayout.Behavior implements ITitleControl {
    private static final float DAMPING_RATIO = 0.92f;
    private static final float SCALE_MAX = 1.0f;
    private static final float SCALE_MIN = 0.625f;
    private static final float STIFFNESS = 300.0f;
    private final String TAG = " [FlymeAppBarBehavior] ";
    private ValueAnimator flymeAnimator;
    /* access modifiers changed from: private */
    public AppBarLayout flymeAppBarLayout;
    /* access modifiers changed from: private */
    public CoordinatorLayout flymeCoordinatorLayout;
    /* access modifiers changed from: private */
    public boolean isOffsetAniStart = false;
    /* access modifiers changed from: private */
    public boolean isSpringStart = false;
    /* access modifiers changed from: private */
    public FlymeXYSpring spring = null;
    private ITitleControl titleScaleControl;

    public FlymeAppBarBehavior() {
        initSnapAnimator();
    }

    /* access modifiers changed from: private */
    public void checkAniAllStop() {
        if (!this.isSpringStart && !this.isOffsetAniStart) {
            releaseTitleScale();
        }
    }

    private ValueAnimator createSnapAni() {
        final MzAppBarLayout.AppbarValueAnimator appbarValueAnimator = new MzAppBarLayout.AppbarValueAnimator();
        appbarValueAnimator.setInterpolator(AnimationUtils.ANIMATION_INTERPOLATOR_SNAP);
        appbarValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                if (FlymeAppBarBehavior.this.flymeCoordinatorLayout != null && FlymeAppBarBehavior.this.flymeAppBarLayout != null) {
                    FlymeAppBarBehavior flymeAppBarBehavior = FlymeAppBarBehavior.this;
                    flymeAppBarBehavior.setHeaderTopBottomOffset(flymeAppBarBehavior.flymeCoordinatorLayout, FlymeAppBarBehavior.this.flymeAppBarLayout, ((Integer) appbarValueAnimator.getAnimatedValue()).intValue());
                }
            }
        });
        appbarValueAnimator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                boolean unused = FlymeAppBarBehavior.this.isOffsetAniStart = false;
                if (FlymeAppBarBehavior.this.spring != null) {
                    Log.i(" [FlymeAppBarBehavior] ", "releaseTitleScale stop by offsetAnimator cancle");
                    FlymeAppBarBehavior.this.spring.stop();
                    FlymeAppBarBehavior.this.releaseTitleScale();
                }
            }

            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                boolean unused = FlymeAppBarBehavior.this.isOffsetAniStart = false;
            }

            public void onAnimationPause(Animator animator) {
                super.onAnimationPause(animator);
            }

            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
            }

            public void onAnimationResume(Animator animator) {
                super.onAnimationResume(animator);
            }

            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                boolean unused = FlymeAppBarBehavior.this.isOffsetAniStart = true;
            }
        });
        return appbarValueAnimator;
    }

    private FlymeXYSpring createSpring(Context context) {
        return new FlymeXYSpring(new TextView(context), DAMPING_RATIO, STIFFNESS, new DynamicAnimation.OnAnimationEndListener() {
            public void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z, float f, float f2) {
                boolean unused = FlymeAppBarBehavior.this.isSpringStart = false;
                FlymeAppBarBehavior.this.checkAniAllStop();
            }
        }, true);
    }

    private void initSnapAnimator() {
        try {
            Field declaredField = getClass().getSuperclass().getSuperclass().getDeclaredField("offsetAnimator");
            declaredField.setAccessible(true);
            ValueAnimator valueAnimator = this.flymeAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ValueAnimator createSnapAni = createSnapAni();
            this.flymeAnimator = createSnapAni;
            declaredField.set(this, createSnapAni);
        } catch (Exception e) {
            Log.e(" [FlymeAppBarBehavior] ", "initSnapAnimator: " + e);
        }
    }

    private void startSpringAni(MzAppBarLayout.AppbarValueAnimator appbarValueAnimator) {
        ITitleControl iTitleControl;
        int[] offsetValues = appbarValueAnimator.getOffsetValues();
        if (offsetValues != null && offsetValues.length >= 2 && (iTitleControl = this.titleScaleControl) != null) {
            float currentScale = iTitleControl.getCurrentScale();
            if (currentScale >= 0.0f) {
                int i = offsetValues[offsetValues.length - 1] - offsetValues[0];
                AnonymousClass3 r1 = new DynamicAnimation.OnAnimationUpdateListener() {
                    public void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f2) {
                        FlymeAppBarBehavior.this.updateScaleValue(f);
                    }
                };
                if (i > 0) {
                    this.spring.start(currentScale, 1.0f, r1);
                } else if (i < 0) {
                    this.spring.start(currentScale, SCALE_MIN, r1);
                }
                this.isSpringStart = true;
                takeOverTitleScale();
            }
        }
    }

    public float getCurrentScale() {
        ITitleControl iTitleControl = this.titleScaleControl;
        if (iTitleControl != null) {
            return iTitleControl.getCurrentScale();
        }
        return -1.0f;
    }

    public void initLayout(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout) {
        CollapsingToolbarLayout collapsingToolbarLayout;
        if (this.flymeCoordinatorLayout == null) {
            this.flymeCoordinatorLayout = coordinatorLayout;
            this.flymeAppBarLayout = appBarLayout;
            this.spring = createSpring(appBarLayout.getContext());
            int childCount = appBarLayout.getChildCount();
            int i = 0;
            while (true) {
                if (i >= childCount) {
                    collapsingToolbarLayout = null;
                    break;
                }
                View childAt = appBarLayout.getChildAt(i);
                if (childAt instanceof CollapsingToolbarLayout) {
                    collapsingToolbarLayout = (CollapsingToolbarLayout) childAt;
                    break;
                }
                i++;
            }
            if (collapsingToolbarLayout != null) {
                this.titleScaleControl = collapsingToolbarLayout.getTitleScaleControl();
            }
        }
    }

    public void releaseTitleScale() {
        ITitleControl iTitleControl = this.titleScaleControl;
        if (iTitleControl != null) {
            iTitleControl.releaseTitleScale();
        }
    }

    public void setTitleOverScrollY(float f) {
        ITitleControl iTitleControl = this.titleScaleControl;
        if (iTitleControl != null) {
            iTitleControl.setTitleOverScrollY(f);
        }
    }

    public void takeOverTitleScale() {
        ITitleControl iTitleControl = this.titleScaleControl;
        if (iTitleControl != null) {
            iTitleControl.takeOverTitleScale();
        }
    }

    public void updateScaleValue(float f) {
        ITitleControl iTitleControl = this.titleScaleControl;
        if (iTitleControl != null) {
            iTitleControl.updateScaleValue(f);
        }
    }

    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, View view2, int i, int i2) {
        initLayout(coordinatorLayout, appBarLayout);
        return super.onStartNestedScroll(coordinatorLayout, appBarLayout, view, view2, i, i2);
    }

    public FlymeAppBarBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initSnapAnimator();
    }
}
