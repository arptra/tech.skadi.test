package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

public class Explode extends Visibility {
    public static final TimeInterpolator b = new DecelerateInterpolator();
    public static final TimeInterpolator c = new AccelerateInterpolator();

    /* renamed from: a  reason: collision with root package name */
    public int[] f1842a;

    private void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.b;
        view.getLocationOnScreen(this.f1842a);
        int[] iArr = this.f1842a;
        int i = iArr[0];
        int i2 = iArr[1];
        transitionValues.f1876a.put("android:explode:screenBounds", new Rect(i, i2, view.getWidth() + i, view.getHeight() + i2));
    }

    public static float t(float f, float f2) {
        return (float) Math.sqrt((double) ((f * f) + (f2 * f2)));
    }

    public static float u(View view, int i, int i2) {
        return t((float) Math.max(i, view.getWidth() - i), (float) Math.max(i2, view.getHeight() - i2));
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
        Rect rect = (Rect) transitionValues2.f1876a.get("android:explode:screenBounds");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        v(viewGroup, rect, this.f1842a);
        int[] iArr = this.f1842a;
        return TranslationAnimationCreator.a(view, transitionValues2, rect.left, rect.top, translationX + ((float) iArr[0]), translationY + ((float) iArr[1]), translationX, translationY, b, this);
    }

    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        float f;
        float f2;
        if (transitionValues == null) {
            return null;
        }
        Rect rect = (Rect) transitionValues.f1876a.get("android:explode:screenBounds");
        int i = rect.left;
        int i2 = rect.top;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) transitionValues.b.getTag(R.id.transition_position);
        if (iArr != null) {
            int i3 = iArr[0];
            f2 = ((float) (i3 - rect.left)) + translationX;
            int i4 = iArr[1];
            f = ((float) (i4 - rect.top)) + translationY;
            rect.offsetTo(i3, i4);
        } else {
            f2 = translationX;
            f = translationY;
        }
        v(viewGroup, rect, this.f1842a);
        int[] iArr2 = this.f1842a;
        return TranslationAnimationCreator.a(view, transitionValues, i, i2, translationX, translationY, f2 + ((float) iArr2[0]), f + ((float) iArr2[1]), c, this);
    }

    public final void v(View view, Rect rect, int[] iArr) {
        int i;
        int i2;
        view.getLocationOnScreen(this.f1842a);
        int[] iArr2 = this.f1842a;
        int i3 = iArr2[0];
        int i4 = iArr2[1];
        Rect epicenter = getEpicenter();
        if (epicenter == null) {
            i = (view.getWidth() / 2) + i3 + Math.round(view.getTranslationX());
            i2 = (view.getHeight() / 2) + i4 + Math.round(view.getTranslationY());
        } else {
            int centerX = epicenter.centerX();
            i2 = epicenter.centerY();
            i = centerX;
        }
        float centerX2 = (float) (rect.centerX() - i);
        float centerY = (float) (rect.centerY() - i2);
        if (centerX2 == 0.0f && centerY == 0.0f) {
            float random = ((float) (Math.random() * 2.0d)) - 1.0f;
            centerX2 = ((float) (Math.random() * 2.0d)) - 1.0f;
            centerY = random;
        }
        float t = t(centerX2, centerY);
        float u = u(view, i - i3, i2 - i4);
        iArr[0] = Math.round((centerX2 / t) * u);
        iArr[1] = Math.round(u * (centerY / t));
    }
}
