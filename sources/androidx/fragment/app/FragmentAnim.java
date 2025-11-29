package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;
import androidx.core.view.OneShotPreDrawListener;
import androidx.fragment.R;

class FragmentAnim {
    public static int a(Fragment fragment, boolean z, boolean z2) {
        return z2 ? z ? fragment.getPopEnterAnim() : fragment.getPopExitAnim() : z ? fragment.getEnterAnim() : fragment.getExitAnim();
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x006b */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006b A[SYNTHETIC, Splitter:B:31:0x006b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.fragment.app.FragmentAnim.AnimationOrAnimator b(android.content.Context r4, androidx.fragment.app.Fragment r5, boolean r6, boolean r7) {
        /*
            int r0 = r5.getNextTransition()
            int r7 = a(r5, r6, r7)
            r1 = 0
            r5.setAnimations(r1, r1, r1, r1)
            android.view.ViewGroup r1 = r5.mContainer
            r2 = 0
            if (r1 == 0) goto L_0x0020
            int r3 = androidx.fragment.R.id.visible_removing_fragment_view_tag
            java.lang.Object r1 = r1.getTag(r3)
            if (r1 == 0) goto L_0x0020
            android.view.ViewGroup r1 = r5.mContainer
            int r3 = androidx.fragment.R.id.visible_removing_fragment_view_tag
            r1.setTag(r3, r2)
        L_0x0020:
            android.view.ViewGroup r1 = r5.mContainer
            if (r1 == 0) goto L_0x002b
            android.animation.LayoutTransition r1 = r1.getLayoutTransition()
            if (r1 == 0) goto L_0x002b
            return r2
        L_0x002b:
            android.view.animation.Animation r1 = r5.onCreateAnimation(r0, r6, r7)
            if (r1 == 0) goto L_0x0037
            androidx.fragment.app.FragmentAnim$AnimationOrAnimator r4 = new androidx.fragment.app.FragmentAnim$AnimationOrAnimator
            r4.<init>((android.view.animation.Animation) r1)
            return r4
        L_0x0037:
            android.animation.Animator r5 = r5.onCreateAnimator(r0, r6, r7)
            if (r5 == 0) goto L_0x0043
            androidx.fragment.app.FragmentAnim$AnimationOrAnimator r4 = new androidx.fragment.app.FragmentAnim$AnimationOrAnimator
            r4.<init>((android.animation.Animator) r5)
            return r4
        L_0x0043:
            if (r7 != 0) goto L_0x004b
            if (r0 == 0) goto L_0x004b
            int r7 = d(r4, r0, r6)
        L_0x004b:
            if (r7 == 0) goto L_0x0087
            android.content.res.Resources r5 = r4.getResources()
            java.lang.String r5 = r5.getResourceTypeName(r7)
            java.lang.String r6 = "anim"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x006b
            android.view.animation.Animation r6 = android.view.animation.AnimationUtils.loadAnimation(r4, r7)     // Catch:{ NotFoundException -> 0x0069, RuntimeException -> 0x006b }
            if (r6 == 0) goto L_0x0087
            androidx.fragment.app.FragmentAnim$AnimationOrAnimator r0 = new androidx.fragment.app.FragmentAnim$AnimationOrAnimator     // Catch:{ NotFoundException -> 0x0069, RuntimeException -> 0x006b }
            r0.<init>((android.view.animation.Animation) r6)     // Catch:{ NotFoundException -> 0x0069, RuntimeException -> 0x006b }
            return r0
        L_0x0069:
            r4 = move-exception
            throw r4
        L_0x006b:
            android.animation.Animator r6 = android.animation.AnimatorInflater.loadAnimator(r4, r7)     // Catch:{ RuntimeException -> 0x0077 }
            if (r6 == 0) goto L_0x0087
            androidx.fragment.app.FragmentAnim$AnimationOrAnimator r0 = new androidx.fragment.app.FragmentAnim$AnimationOrAnimator     // Catch:{ RuntimeException -> 0x0077 }
            r0.<init>((android.animation.Animator) r6)     // Catch:{ RuntimeException -> 0x0077 }
            return r0
        L_0x0077:
            r6 = move-exception
            if (r5 != 0) goto L_0x0086
            android.view.animation.Animation r4 = android.view.animation.AnimationUtils.loadAnimation(r4, r7)
            if (r4 == 0) goto L_0x0087
            androidx.fragment.app.FragmentAnim$AnimationOrAnimator r5 = new androidx.fragment.app.FragmentAnim$AnimationOrAnimator
            r5.<init>((android.view.animation.Animation) r4)
            return r5
        L_0x0086:
            throw r6
        L_0x0087:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentAnim.b(android.content.Context, androidx.fragment.app.Fragment, boolean, boolean):androidx.fragment.app.FragmentAnim$AnimationOrAnimator");
    }

    public static int c(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(16973825, new int[]{i});
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    public static int d(Context context, int i, boolean z) {
        if (i == 4097) {
            return z ? R.animator.fragment_open_enter : R.animator.fragment_open_exit;
        }
        if (i == 8194) {
            return z ? R.animator.fragment_close_enter : R.animator.fragment_close_exit;
        }
        if (i == 8197) {
            return z ? c(context, 16842938) : c(context, 16842939);
        }
        if (i == 4099) {
            return z ? R.animator.fragment_fade_enter : R.animator.fragment_fade_exit;
        }
        if (i != 4100) {
            return -1;
        }
        return z ? c(context, 16842936) : c(context, 16842937);
    }

    public static class AnimationOrAnimator {

        /* renamed from: a  reason: collision with root package name */
        public final Animation f1269a;
        public final AnimatorSet b;

        public AnimationOrAnimator(Animation animation) {
            this.f1269a = animation;
            this.b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        public AnimationOrAnimator(Animator animator) {
            this.f1269a = null;
            AnimatorSet animatorSet = new AnimatorSet();
            this.b = animatorSet;
            animatorSet.play(animator);
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    public static class EndViewTransitionAnimation extends AnimationSet implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final ViewGroup f1270a;
        public final View b;
        public boolean c;
        public boolean d;
        public boolean e = true;

        public EndViewTransitionAnimation(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f1270a = viewGroup;
            this.b = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        public boolean getTransformation(long j, Transformation transformation) {
            this.e = true;
            if (this.c) {
                return !this.d;
            }
            if (!super.getTransformation(j, transformation)) {
                this.c = true;
                OneShotPreDrawListener.a(this.f1270a, this);
            }
            return true;
        }

        public void run() {
            if (this.c || !this.e) {
                this.f1270a.endViewTransition(this.b);
                this.d = true;
                return;
            }
            this.e = false;
            this.f1270a.post(this);
        }

        public boolean getTransformation(long j, Transformation transformation, float f) {
            this.e = true;
            if (this.c) {
                return !this.d;
            }
            if (!super.getTransformation(j, transformation, f)) {
                this.c = true;
                OneShotPreDrawListener.a(this.f1270a, this);
            }
            return true;
        }
    }
}
