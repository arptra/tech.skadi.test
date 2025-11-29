package com.meizu.common.util;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.libpag.PAGView;

public class PAGAnimatorHelper {
    private static final int DEFAULT_ANIMATOR_DURATION = 250;
    private final List<PAGView> pagViews = new ArrayList();
    private final HashMap<View, Animator> viewAnimators = new HashMap<>();

    private Animator createFadeAnimator(View view, boolean z, Interpolator interpolator, int i) {
        if (z) {
            return createFloatAnimator(view, "alpha", i, interpolator, 0.0f, 1.0f);
        }
        return createFloatAnimator(view, "alpha", i, interpolator, 1.0f, 0.0f);
    }

    private ObjectAnimator createFloatAnimator(View view, String str, int i, Interpolator interpolator, float... fArr) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, str, fArr);
        ofFloat.setDuration((long) i);
        ofFloat.setInterpolator(interpolator);
        return ofFloat;
    }

    private ObjectAnimator createIntAnimator(View view, String str, int i, Interpolator interpolator, int... iArr) {
        ObjectAnimator ofInt = ObjectAnimator.ofInt(view, str, iArr);
        ofInt.setDuration((long) i);
        ofInt.setInterpolator(interpolator);
        return ofInt;
    }

    public PAGAnimatorHelper addFadeItem(View view, boolean z, Interpolator interpolator) {
        return addFadeItem(view, z, interpolator, 250);
    }

    public PAGAnimatorHelper addFloatItem(View view, String str, Interpolator interpolator, float... fArr) {
        return addFloatItem(view, str, 250, interpolator, fArr);
    }

    public PAGAnimatorHelper addIntItem(View view, String str, Interpolator interpolator, int... iArr) {
        return addIntItem(view, str, 250, interpolator, iArr);
    }

    public PAGAnimatorHelper addItem(PAGView pAGView) {
        this.pagViews.add(pAGView);
        return this;
    }

    public PAGAnimatorHelper removeItem(PAGView pAGView) {
        this.pagViews.remove(pAGView);
        return this;
    }

    public void start() {
        for (PAGView play : this.pagViews) {
            play.play();
        }
        for (Map.Entry<View, Animator> value : this.viewAnimators.entrySet()) {
            ((Animator) value.getValue()).start();
        }
    }

    public PAGAnimatorHelper addFadeItem(View view, boolean z, Interpolator interpolator, int i) {
        this.viewAnimators.put(view, createFadeAnimator(view, z, interpolator, i));
        return this;
    }

    public PAGAnimatorHelper addFloatItem(View view, String str, int i, Interpolator interpolator, float... fArr) {
        this.viewAnimators.put(view, createFloatAnimator(view, str, i, interpolator, fArr));
        return this;
    }

    public PAGAnimatorHelper addIntItem(View view, String str, int i, Interpolator interpolator, int... iArr) {
        this.viewAnimators.put(view, createIntAnimator(view, str, i, interpolator, iArr));
        return this;
    }

    public PAGAnimatorHelper addItem(View view, Animator animator) {
        this.viewAnimators.put(view, animator);
        return this;
    }

    public PAGAnimatorHelper removeItem(View view) {
        this.viewAnimators.remove(view);
        return this;
    }
}
