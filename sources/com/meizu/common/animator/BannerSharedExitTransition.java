package com.meizu.common.animator;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.transition.ChangeBounds;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.meizu.common.util.AnimUtils;
import com.meizu.common.widget.SmoothCornerView;
import org.jetbrains.annotations.Nullable;

public class BannerSharedExitTransition extends ChangeBounds {
    private static final long DURATION = 420;
    private static final Interpolator sInterpolator = PathInterpolatorCompat.a(0.2f, 0.0f, 0.2f, 1.0f);

    @Nullable
    public Animator createAnimator(@Nullable ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        View view;
        Animator createAnimator = super.createAnimator(viewGroup, transitionValues, transitionValues2);
        ObjectAnimator objectAnimator = null;
        if (createAnimator == null) {
            return null;
        }
        Interpolator interpolator = sInterpolator;
        createAnimator.setInterpolator(interpolator);
        createAnimator.setDuration(DURATION);
        if (transitionValues != null && (view = transitionValues.view) != null && (view instanceof SmoothCornerView) && AnimUtils.isViewHaveTransitionName(view)) {
            objectAnimator = ObjectAnimator.ofFloat((SmoothCornerView) transitionValues.view, "radiusDp", new float[]{0.0f, 16.0f});
            objectAnimator.setInterpolator(interpolator);
            objectAnimator.setDuration(DURATION);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        if (objectAnimator == null) {
            animatorSet.playTogether(new Animator[]{createAnimator});
        } else {
            animatorSet.playTogether(new Animator[]{createAnimator, objectAnimator});
        }
        return animatorSet;
    }
}
