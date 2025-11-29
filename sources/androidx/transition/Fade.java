package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;

public class Fade extends Visibility {

    public static class FadeAnimatorListener extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final View f1844a;
        public boolean b = false;

        public FadeAnimatorListener(View view) {
            this.f1844a = view;
        }

        public void onAnimationEnd(Animator animator) {
            ViewUtils.h(this.f1844a, 1.0f);
            if (this.b) {
                this.f1844a.setLayerType(0, (Paint) null);
            }
        }

        public void onAnimationStart(Animator animator) {
            if (ViewCompat.S(this.f1844a) && this.f1844a.getLayerType() == 0) {
                this.b = true;
                this.f1844a.setLayerType(2, (Paint) null);
            }
        }
    }

    public Fade(int i) {
        setMode(i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r1 = (java.lang.Float) r1.f1876a.get("android:fade:transitionAlpha");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static float u(androidx.transition.TransitionValues r1, float r2) {
        /*
            if (r1 == 0) goto L_0x0012
            java.util.Map r1 = r1.f1876a
            java.lang.String r0 = "android:fade:transitionAlpha"
            java.lang.Object r1 = r1.get(r0)
            java.lang.Float r1 = (java.lang.Float) r1
            if (r1 == 0) goto L_0x0012
            float r2 = r1.floatValue()
        L_0x0012:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Fade.u(androidx.transition.TransitionValues, float):float");
    }

    public void captureStartValues(TransitionValues transitionValues) {
        super.captureStartValues(transitionValues);
        transitionValues.f1876a.put("android:fade:transitionAlpha", Float.valueOf(ViewUtils.c(transitionValues.b)));
    }

    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        float f = 0.0f;
        float u = u(transitionValues, 0.0f);
        if (u != 1.0f) {
            f = u;
        }
        return t(view, f, 1.0f);
    }

    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        ViewUtils.e(view);
        return t(view, u(transitionValues, 1.0f), 0.0f);
    }

    public final Animator t(final View view, float f, float f2) {
        if (f == f2) {
            return null;
        }
        ViewUtils.h(view, f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, ViewUtils.b, new float[]{f2});
        ofFloat.addListener(new FadeAnimatorListener(view));
        addListener(new TransitionListenerAdapter() {
            public void onTransitionEnd(Transition transition) {
                ViewUtils.h(view, 1.0f);
                ViewUtils.a(view);
                transition.removeListener(this);
            }
        });
        return ofFloat;
    }

    public Fade() {
    }
}
