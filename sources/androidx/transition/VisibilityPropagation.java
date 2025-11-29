package androidx.transition;

import android.view.View;

public abstract class VisibilityPropagation extends TransitionPropagation {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f1888a = {"android:visibilityPropagation:visibility", "android:visibilityPropagation:center"};

    public static int d(TransitionValues transitionValues, int i) {
        int[] iArr;
        if (transitionValues == null || (iArr = (int[]) transitionValues.f1876a.get("android:visibilityPropagation:center")) == null) {
            return -1;
        }
        return iArr[i];
    }

    public void a(TransitionValues transitionValues) {
        View view = transitionValues.b;
        Integer num = (Integer) transitionValues.f1876a.get("android:visibility:visibility");
        if (num == null) {
            num = Integer.valueOf(view.getVisibility());
        }
        transitionValues.f1876a.put("android:visibilityPropagation:visibility", num);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int round = iArr[0] + Math.round(view.getTranslationX());
        iArr[0] = round;
        iArr[0] = round + (view.getWidth() / 2);
        int round2 = iArr[1] + Math.round(view.getTranslationY());
        iArr[1] = round2;
        iArr[1] = round2 + (view.getHeight() / 2);
        transitionValues.f1876a.put("android:visibilityPropagation:center", iArr);
    }

    public String[] b() {
        return f1888a;
    }

    public int e(TransitionValues transitionValues) {
        Integer num;
        if (transitionValues == null || (num = (Integer) transitionValues.f1876a.get("android:visibilityPropagation:visibility")) == null) {
            return 8;
        }
        return num.intValue();
    }

    public int f(TransitionValues transitionValues) {
        return d(transitionValues, 0);
    }

    public int g(TransitionValues transitionValues) {
        return d(transitionValues, 1);
    }
}
