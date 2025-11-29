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

public class BannerSharedEnterTransition extends ChangeBounds {
    private static final long ANIM_DURATION = 420;
    private static final Interpolator sBounceInterpolator = PathInterpolatorCompat.a(0.2f, 0.0f, 0.4f, 1.0f);
    private static final Interpolator sCommonInterpolator = PathInterpolatorCompat.a(0.2f, 0.0f, 0.2f, 1.0f);

    @Nullable
    public Animator createAnimator(@Nullable ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        View view;
        Animator createAnimator;
        ObjectAnimator objectAnimator = null;
        if (transitionValues2 == null || (view = transitionValues2.view) == null || !AnimUtils.isViewHaveTransitionName(view) || (createAnimator = super.createAnimator(viewGroup, transitionValues, transitionValues2)) == null) {
            return null;
        }
        Interpolator interpolator = sCommonInterpolator;
        createAnimator.setInterpolator(interpolator);
        createAnimator.setDuration(ANIM_DURATION);
        View view2 = transitionValues2.view;
        if (view2 instanceof SmoothCornerView) {
            objectAnimator = ObjectAnimator.ofFloat((SmoothCornerView) view2, "radiusDp", new float[]{16.0f, 1.0f});
            objectAnimator.setInterpolator(interpolator);
            objectAnimator.setDuration(ANIM_DURATION);
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
