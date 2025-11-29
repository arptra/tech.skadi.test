package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;

public class ChangeScroll extends Transition {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f1836a = {"android:changeScroll:x", "android:changeScroll:y"};

    private void captureValues(TransitionValues transitionValues) {
        transitionValues.f1876a.put("android:changeScroll:x", Integer.valueOf(transitionValues.b.getScrollX()));
        transitionValues.f1876a.put("android:changeScroll:y", Integer.valueOf(transitionValues.b.getScrollY()));
    }

    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2 = null;
        if (transitionValues == null || transitionValues2 == null) {
            return null;
        }
        View view = transitionValues2.b;
        int intValue = ((Integer) transitionValues.f1876a.get("android:changeScroll:x")).intValue();
        int intValue2 = ((Integer) transitionValues2.f1876a.get("android:changeScroll:x")).intValue();
        int intValue3 = ((Integer) transitionValues.f1876a.get("android:changeScroll:y")).intValue();
        int intValue4 = ((Integer) transitionValues2.f1876a.get("android:changeScroll:y")).intValue();
        if (intValue != intValue2) {
            view.setScrollX(intValue);
            objectAnimator = ObjectAnimator.ofInt(view, "scrollX", new int[]{intValue, intValue2});
        } else {
            objectAnimator = null;
        }
        if (intValue3 != intValue4) {
            view.setScrollY(intValue3);
            objectAnimator2 = ObjectAnimator.ofInt(view, "scrollY", new int[]{intValue3, intValue4});
        }
        return TransitionUtils.c(objectAnimator, objectAnimator2);
    }

    public String[] getTransitionProperties() {
        return f1836a;
    }
}
