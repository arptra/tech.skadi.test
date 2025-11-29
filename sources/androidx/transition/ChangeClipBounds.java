package androidx.transition;

import android.graphics.Rect;
import android.view.View;
import androidx.core.view.ViewCompat;

public class ChangeClipBounds extends Transition {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f1832a = {"android:clipBounds:clip"};

    private void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.b;
        if (view.getVisibility() != 8) {
            Rect s = ViewCompat.s(view);
            transitionValues.f1876a.put("android:clipBounds:clip", s);
            if (s == null) {
                transitionValues.f1876a.put("android:clipBounds:bounds", new Rect(0, 0, view.getWidth(), view.getHeight()));
            }
        }
    }

    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: android.graphics.Rect} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: android.graphics.Rect} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.animation.Animator createAnimator(android.view.ViewGroup r5, androidx.transition.TransitionValues r6, androidx.transition.TransitionValues r7) {
        /*
            r4 = this;
            r5 = 0
            if (r6 == 0) goto L_0x0079
            if (r7 == 0) goto L_0x0079
            java.util.Map r0 = r6.f1876a
            java.lang.String r1 = "android:clipBounds:clip"
            boolean r0 = r0.containsKey(r1)
            if (r0 == 0) goto L_0x0079
            java.util.Map r0 = r7.f1876a
            boolean r0 = r0.containsKey(r1)
            if (r0 != 0) goto L_0x0018
            goto L_0x0079
        L_0x0018:
            java.util.Map r0 = r6.f1876a
            java.lang.Object r0 = r0.get(r1)
            android.graphics.Rect r0 = (android.graphics.Rect) r0
            java.util.Map r2 = r7.f1876a
            java.lang.Object r1 = r2.get(r1)
            android.graphics.Rect r1 = (android.graphics.Rect) r1
            if (r1 != 0) goto L_0x002c
            r2 = 1
            goto L_0x002d
        L_0x002c:
            r2 = 0
        L_0x002d:
            if (r0 != 0) goto L_0x0032
            if (r1 != 0) goto L_0x0032
            return r5
        L_0x0032:
            java.lang.String r3 = "android:clipBounds:bounds"
            if (r0 != 0) goto L_0x0040
            java.util.Map r6 = r6.f1876a
            java.lang.Object r6 = r6.get(r3)
            r0 = r6
            android.graphics.Rect r0 = (android.graphics.Rect) r0
            goto L_0x004b
        L_0x0040:
            if (r1 != 0) goto L_0x004b
            java.util.Map r6 = r7.f1876a
            java.lang.Object r6 = r6.get(r3)
            r1 = r6
            android.graphics.Rect r1 = (android.graphics.Rect) r1
        L_0x004b:
            boolean r6 = r0.equals(r1)
            if (r6 == 0) goto L_0x0052
            return r5
        L_0x0052:
            android.view.View r5 = r7.b
            androidx.core.view.ViewCompat.C0(r5, r0)
            androidx.transition.RectEvaluator r5 = new androidx.transition.RectEvaluator
            android.graphics.Rect r6 = new android.graphics.Rect
            r6.<init>()
            r5.<init>(r6)
            android.view.View r6 = r7.b
            android.util.Property r3 = androidx.transition.ViewUtils.c
            android.graphics.Rect[] r0 = new android.graphics.Rect[]{r0, r1}
            android.animation.ObjectAnimator r5 = android.animation.ObjectAnimator.ofObject(r6, r3, r5, r0)
            if (r2 == 0) goto L_0x0079
            android.view.View r6 = r7.b
            androidx.transition.ChangeClipBounds$1 r7 = new androidx.transition.ChangeClipBounds$1
            r7.<init>(r6)
            r5.addListener(r7)
        L_0x0079:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.ChangeClipBounds.createAnimator(android.view.ViewGroup, androidx.transition.TransitionValues, androidx.transition.TransitionValues):android.animation.Animator");
    }

    public String[] getTransitionProperties() {
        return f1832a;
    }
}
