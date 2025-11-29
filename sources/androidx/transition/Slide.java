package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Slide extends Visibility {
    public static final TimeInterpolator b = new DecelerateInterpolator();
    public static final TimeInterpolator c = new AccelerateInterpolator();
    public static final CalculateSlide d = new CalculateSlideHorizontal() {
        public float b(ViewGroup viewGroup, View view) {
            return view.getTranslationX() - ((float) viewGroup.getWidth());
        }
    };
    public static final CalculateSlide e = new CalculateSlideHorizontal() {
        public float b(ViewGroup viewGroup, View view) {
            return ViewCompat.z(viewGroup) == 1 ? view.getTranslationX() + ((float) viewGroup.getWidth()) : view.getTranslationX() - ((float) viewGroup.getWidth());
        }
    };
    public static final CalculateSlide f = new CalculateSlideVertical() {
        public float a(ViewGroup viewGroup, View view) {
            return view.getTranslationY() - ((float) viewGroup.getHeight());
        }
    };
    public static final CalculateSlide g = new CalculateSlideHorizontal() {
        public float b(ViewGroup viewGroup, View view) {
            return view.getTranslationX() + ((float) viewGroup.getWidth());
        }
    };
    public static final CalculateSlide h = new CalculateSlideHorizontal() {
        public float b(ViewGroup viewGroup, View view) {
            return ViewCompat.z(viewGroup) == 1 ? view.getTranslationX() - ((float) viewGroup.getWidth()) : view.getTranslationX() + ((float) viewGroup.getWidth());
        }
    };
    public static final CalculateSlide i = new CalculateSlideVertical() {
        public float a(ViewGroup viewGroup, View view) {
            return view.getTranslationY() + ((float) viewGroup.getHeight());
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public CalculateSlide f1862a;

    public interface CalculateSlide {
        float a(ViewGroup viewGroup, View view);

        float b(ViewGroup viewGroup, View view);
    }

    public static abstract class CalculateSlideHorizontal implements CalculateSlide {
        public CalculateSlideHorizontal() {
        }

        public float a(ViewGroup viewGroup, View view) {
            return view.getTranslationY();
        }
    }

    public static abstract class CalculateSlideVertical implements CalculateSlide {
        public CalculateSlideVertical() {
        }

        public float b(ViewGroup viewGroup, View view) {
            return view.getTranslationX();
        }
    }

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface GravityFlag {
    }

    private void captureValues(TransitionValues transitionValues) {
        int[] iArr = new int[2];
        transitionValues.b.getLocationOnScreen(iArr);
        transitionValues.f1876a.put("android:slide:screenPosition", iArr);
    }

    public void captureEndValues(TransitionValues transitionValues) {
        super.captureEndValues(transitionValues);
        captureValues(transitionValues);
    }

    public void captureStartValues(TransitionValues transitionValues) {
        super.captureStartValues(transitionValues);
        captureValues(transitionValues);
    }

    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues2 == null) {
            return null;
        }
        int[] iArr = (int[]) transitionValues2.f1876a.get("android:slide:screenPosition");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        return TranslationAnimationCreator.a(view, transitionValues2, iArr[0], iArr[1], this.f1862a.b(viewGroup, view), this.f1862a.a(viewGroup, view), translationX, translationY, b, this);
    }

    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null) {
            return null;
        }
        int[] iArr = (int[]) transitionValues.f1876a.get("android:slide:screenPosition");
        return TranslationAnimationCreator.a(view, transitionValues, iArr[0], iArr[1], view.getTranslationX(), view.getTranslationY(), this.f1862a.b(viewGroup, view), this.f1862a.a(viewGroup, view), c, this);
    }
}
