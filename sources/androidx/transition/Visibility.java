package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.transition.AnimatorUtils;
import androidx.transition.Transition;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class Visibility extends Transition {
    public static final int MODE_IN = 1;
    public static final int MODE_OUT = 2;
    private static final String PROPNAME_PARENT = "android:visibility:parent";
    private static final String PROPNAME_SCREEN_LOCATION = "android:visibility:screenLocation";
    static final String PROPNAME_VISIBILITY = "android:visibility:visibility";
    private static final String[] sTransitionProperties = {PROPNAME_VISIBILITY, PROPNAME_PARENT};
    private int mMode = 3;

    public static class DisappearListener extends AnimatorListenerAdapter implements Transition.TransitionListener, AnimatorUtils.AnimatorPauseListenerCompat {

        /* renamed from: a  reason: collision with root package name */
        public final View f1886a;
        public final int b;
        public final ViewGroup c;
        public final boolean d;
        public boolean e;
        public boolean f = false;

        public DisappearListener(View view, int i, boolean z) {
            this.f1886a = view;
            this.b = i;
            this.c = (ViewGroup) view.getParent();
            this.d = z;
            b(true);
        }

        public final void a() {
            if (!this.f) {
                ViewUtils.i(this.f1886a, this.b);
                ViewGroup viewGroup = this.c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            b(false);
        }

        public final void b(boolean z) {
            ViewGroup viewGroup;
            if (this.d && this.e != z && (viewGroup = this.c) != null) {
                this.e = z;
                ViewGroupUtils.c(viewGroup, z);
            }
        }

        public void onAnimationCancel(Animator animator) {
            this.f = true;
        }

        public void onAnimationEnd(Animator animator) {
            a();
        }

        public void onAnimationPause(Animator animator) {
            if (!this.f) {
                ViewUtils.i(this.f1886a, this.b);
            }
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationResume(Animator animator) {
            if (!this.f) {
                ViewUtils.i(this.f1886a, 0);
            }
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onTransitionCancel(Transition transition) {
        }

        public void onTransitionEnd(Transition transition) {
            a();
            transition.removeListener(this);
        }

        public void onTransitionPause(Transition transition) {
            b(false);
        }

        public void onTransitionResume(Transition transition) {
            b(true);
        }

        public void onTransitionStart(Transition transition) {
        }
    }

    @SuppressLint({"UniqueConstants"})
    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    public static class VisibilityInfo {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1887a;
        public boolean b;
        public int c;
        public int d;
        public ViewGroup e;
        public ViewGroup f;
    }

    private void captureValues(TransitionValues transitionValues) {
        transitionValues.f1876a.put(PROPNAME_VISIBILITY, Integer.valueOf(transitionValues.b.getVisibility()));
        transitionValues.f1876a.put(PROPNAME_PARENT, transitionValues.b.getParent());
        int[] iArr = new int[2];
        transitionValues.b.getLocationOnScreen(iArr);
        transitionValues.f1876a.put(PROPNAME_SCREEN_LOCATION, iArr);
    }

    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Nullable
    public Animator createAnimator(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        VisibilityInfo s = s(transitionValues, transitionValues2);
        if (!s.f1887a) {
            return null;
        }
        if (s.e == null && s.f == null) {
            return null;
        }
        if (s.b) {
            return onAppear(viewGroup, transitionValues, s.c, transitionValues2, s.d);
        }
        return onDisappear(viewGroup, transitionValues, s.c, transitionValues2, s.d);
    }

    public int getMode() {
        return this.mMode;
    }

    @Nullable
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    public boolean isTransitionRequired(@Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        if (transitionValues == null && transitionValues2 == null) {
            return false;
        }
        if (transitionValues != null && transitionValues2 != null && transitionValues2.f1876a.containsKey(PROPNAME_VISIBILITY) != transitionValues.f1876a.containsKey(PROPNAME_VISIBILITY)) {
            return false;
        }
        VisibilityInfo s = s(transitionValues, transitionValues2);
        if (s.f1887a) {
            return s.c == 0 || s.d == 0;
        }
        return false;
    }

    public boolean isVisible(TransitionValues transitionValues) {
        if (transitionValues == null) {
            return false;
        }
        return ((Integer) transitionValues.f1876a.get(PROPNAME_VISIBILITY)).intValue() == 0 && ((View) transitionValues.f1876a.get(PROPNAME_PARENT)) != null;
    }

    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    public final VisibilityInfo s(TransitionValues transitionValues, TransitionValues transitionValues2) {
        VisibilityInfo visibilityInfo = new VisibilityInfo();
        visibilityInfo.f1887a = false;
        visibilityInfo.b = false;
        if (transitionValues == null || !transitionValues.f1876a.containsKey(PROPNAME_VISIBILITY)) {
            visibilityInfo.c = -1;
            visibilityInfo.e = null;
        } else {
            visibilityInfo.c = ((Integer) transitionValues.f1876a.get(PROPNAME_VISIBILITY)).intValue();
            visibilityInfo.e = (ViewGroup) transitionValues.f1876a.get(PROPNAME_PARENT);
        }
        if (transitionValues2 == null || !transitionValues2.f1876a.containsKey(PROPNAME_VISIBILITY)) {
            visibilityInfo.d = -1;
            visibilityInfo.f = null;
        } else {
            visibilityInfo.d = ((Integer) transitionValues2.f1876a.get(PROPNAME_VISIBILITY)).intValue();
            visibilityInfo.f = (ViewGroup) transitionValues2.f1876a.get(PROPNAME_PARENT);
        }
        if (transitionValues != null && transitionValues2 != null) {
            int i = visibilityInfo.c;
            int i2 = visibilityInfo.d;
            if (i == i2 && visibilityInfo.e == visibilityInfo.f) {
                return visibilityInfo;
            }
            if (i != i2) {
                if (i == 0) {
                    visibilityInfo.b = false;
                    visibilityInfo.f1887a = true;
                } else if (i2 == 0) {
                    visibilityInfo.b = true;
                    visibilityInfo.f1887a = true;
                }
            } else if (visibilityInfo.f == null) {
                visibilityInfo.b = false;
                visibilityInfo.f1887a = true;
            } else if (visibilityInfo.e == null) {
                visibilityInfo.b = true;
                visibilityInfo.f1887a = true;
            }
        } else if (transitionValues == null && visibilityInfo.d == 0) {
            visibilityInfo.b = true;
            visibilityInfo.f1887a = true;
        } else if (transitionValues2 == null && visibilityInfo.c == 0) {
            visibilityInfo.b = false;
            visibilityInfo.f1887a = true;
        }
        return visibilityInfo;
    }

    public void setMode(int i) {
        if ((i & -4) == 0) {
            this.mMode = i;
            return;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }

    @Nullable
    public Animator onAppear(ViewGroup viewGroup, TransitionValues transitionValues, int i, TransitionValues transitionValues2, int i2) {
        if ((this.mMode & 1) != 1 || transitionValues2 == null) {
            return null;
        }
        if (transitionValues == null) {
            View view = (View) transitionValues2.b.getParent();
            if (s(getMatchedTransitionValues(view, false), getTransitionValues(view, false)).f1887a) {
                return null;
            }
        }
        return onAppear(viewGroup, transitionValues2.b, transitionValues, transitionValues2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0083, code lost:
        if (r10.mCanRemoveViews != false) goto L_0x0085;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0040  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.animation.Animator onDisappear(final android.view.ViewGroup r11, androidx.transition.TransitionValues r12, int r13, androidx.transition.TransitionValues r14, int r15) {
        /*
            r10 = this;
            int r13 = r10.mMode
            r0 = 2
            r13 = r13 & r0
            r1 = 0
            if (r13 == r0) goto L_0x0008
            return r1
        L_0x0008:
            if (r12 != 0) goto L_0x000b
            return r1
        L_0x000b:
            android.view.View r13 = r12.b
            if (r14 == 0) goto L_0x0012
            android.view.View r2 = r14.b
            goto L_0x0013
        L_0x0012:
            r2 = r1
        L_0x0013:
            int r3 = androidx.transition.R.id.save_overlay_view
            java.lang.Object r3 = r13.getTag(r3)
            android.view.View r3 = (android.view.View) r3
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L_0x0023
            r2 = r1
            r6 = r5
            goto L_0x0088
        L_0x0023:
            if (r2 == 0) goto L_0x003a
            android.view.ViewParent r3 = r2.getParent()
            if (r3 != 0) goto L_0x002c
            goto L_0x003a
        L_0x002c:
            r3 = 4
            if (r15 != r3) goto L_0x0030
            goto L_0x0032
        L_0x0030:
            if (r13 != r2) goto L_0x0036
        L_0x0032:
            r3 = r2
            r6 = r4
            r2 = r1
            goto L_0x003e
        L_0x0036:
            r2 = r1
            r3 = r2
            r6 = r5
            goto L_0x003e
        L_0x003a:
            if (r2 == 0) goto L_0x0036
            r3 = r1
            r6 = r4
        L_0x003e:
            if (r6 == 0) goto L_0x0069
            android.view.ViewParent r6 = r13.getParent()
            if (r6 != 0) goto L_0x0047
            goto L_0x0085
        L_0x0047:
            android.view.ViewParent r6 = r13.getParent()
            boolean r6 = r6 instanceof android.view.View
            if (r6 == 0) goto L_0x0069
            android.view.ViewParent r6 = r13.getParent()
            android.view.View r6 = (android.view.View) r6
            androidx.transition.TransitionValues r7 = r10.getTransitionValues(r6, r5)
            androidx.transition.TransitionValues r8 = r10.getMatchedTransitionValues(r6, r5)
            androidx.transition.Visibility$VisibilityInfo r7 = r10.s(r7, r8)
            boolean r7 = r7.f1887a
            if (r7 != 0) goto L_0x006e
            android.view.View r2 = androidx.transition.TransitionUtils.a(r11, r13, r6)
        L_0x0069:
            r6 = r4
            r9 = r3
            r3 = r2
            r2 = r9
            goto L_0x0088
        L_0x006e:
            int r7 = r6.getId()
            android.view.ViewParent r6 = r6.getParent()
            if (r6 != 0) goto L_0x0069
            r6 = -1
            if (r7 == r6) goto L_0x0069
            android.view.View r6 = r11.findViewById(r7)
            if (r6 == 0) goto L_0x0069
            boolean r6 = r10.mCanRemoveViews
            if (r6 == 0) goto L_0x0069
        L_0x0085:
            r2 = r3
            r6 = r4
            r3 = r13
        L_0x0088:
            if (r3 == 0) goto L_0x00da
            if (r6 != 0) goto L_0x00bc
            java.util.Map r15 = r12.f1876a
            java.lang.String r1 = "android:visibility:screenLocation"
            java.lang.Object r15 = r15.get(r1)
            int[] r15 = (int[]) r15
            r1 = r15[r4]
            r15 = r15[r5]
            int[] r0 = new int[r0]
            r11.getLocationOnScreen(r0)
            r2 = r0[r4]
            int r1 = r1 - r2
            int r2 = r3.getLeft()
            int r1 = r1 - r2
            r3.offsetLeftAndRight(r1)
            r0 = r0[r5]
            int r15 = r15 - r0
            int r0 = r3.getTop()
            int r15 = r15 - r0
            r3.offsetTopAndBottom(r15)
            androidx.transition.ViewGroupOverlayImpl r15 = androidx.transition.ViewGroupUtils.b(r11)
            r15.add(r3)
        L_0x00bc:
            android.animation.Animator r12 = r10.onDisappear(r11, r3, r12, r14)
            if (r6 != 0) goto L_0x00d9
            if (r12 != 0) goto L_0x00cc
            androidx.transition.ViewGroupOverlayImpl r10 = androidx.transition.ViewGroupUtils.b(r11)
            r10.remove(r3)
            goto L_0x00d9
        L_0x00cc:
            int r14 = androidx.transition.R.id.save_overlay_view
            r13.setTag(r14, r3)
            androidx.transition.Visibility$1 r14 = new androidx.transition.Visibility$1
            r14.<init>(r11, r3, r13)
            r10.addListener(r14)
        L_0x00d9:
            return r12
        L_0x00da:
            if (r2 == 0) goto L_0x00fc
            int r13 = r2.getVisibility()
            androidx.transition.ViewUtils.i(r2, r4)
            android.animation.Animator r11 = r10.onDisappear(r11, r2, r12, r14)
            if (r11 == 0) goto L_0x00f8
            androidx.transition.Visibility$DisappearListener r12 = new androidx.transition.Visibility$DisappearListener
            r12.<init>(r2, r15, r5)
            r11.addListener(r12)
            androidx.transition.AnimatorUtils.a(r11, r12)
            r10.addListener(r12)
            goto L_0x00fb
        L_0x00f8:
            androidx.transition.ViewUtils.i(r2, r13)
        L_0x00fb:
            return r11
        L_0x00fc:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Visibility.onDisappear(android.view.ViewGroup, androidx.transition.TransitionValues, int, androidx.transition.TransitionValues, int):android.animation.Animator");
    }
}
