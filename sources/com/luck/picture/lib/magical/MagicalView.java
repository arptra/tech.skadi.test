package com.luck.picture.lib.magical;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.transition.ChangeBounds;
import android.transition.ChangeImageTransform;
import android.transition.ChangeTransform;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import com.luck.picture.lib.basic.InterpolatorFactory;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.config.SelectorProviders;
import com.luck.picture.lib.utils.DensityUtil;

public class MagicalView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public float f9425a;
    public final long b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public final int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public boolean p;
    public final FrameLayout q;
    public final View r;
    public final MagicalViewWrapper s;
    public final boolean t;
    public final SelectorConfig u;
    public int v;
    public int w;
    public OnMagicalViewCallback x;

    public MagicalView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void getScreenSize() {
        this.g = DensityUtil.e(getContext());
        if (this.t) {
            this.h = DensityUtil.d(getContext());
        } else {
            this.h = DensityUtil.g(getContext());
        }
    }

    public void A(int i2, int i3, boolean z) {
        int i4;
        int i5;
        if (!this.t && (i4 = this.g) <= (i5 = this.h)) {
            if (((int) (((float) i4) / (((float) i2) / ((float) i3)))) > i5) {
                this.h = this.i;
                if (z) {
                    this.s.d((float) i4);
                    this.s.a((float) this.h);
                }
            }
        }
    }

    public void B() {
        getScreenSize();
        J(true);
    }

    public void C(int i2, int i3, boolean z) {
        getScreenSize();
        K(i2, i3, z);
    }

    public final void D() {
        this.q.getLocationOnScreen(new int[2]);
        this.m = 0;
        int i2 = this.g;
        int i3 = this.h;
        float f2 = ((float) i2) / ((float) i3);
        int i4 = this.n;
        int i5 = this.o;
        if (f2 < ((float) i4) / ((float) i5)) {
            this.k = i2;
            int i6 = (int) (((float) i2) * (((float) i5) / ((float) i4)));
            this.l = i6;
            this.j = (i3 - i6) / 2;
        } else {
            this.l = i3;
            int i7 = (int) (((float) i3) * (((float) i4) / ((float) i5)));
            this.k = i7;
            this.j = 0;
            this.m = (i2 - i7) / 2;
        }
        this.s.d((float) this.f);
        this.s.a((float) this.e);
        this.s.b(this.c);
        this.s.c(this.d);
    }

    public final void E() {
        this.p = false;
        z();
        OnMagicalViewCallback onMagicalViewCallback = this.x;
        if (onMagicalViewCallback != null) {
            onMagicalViewCallback.b(this, false);
        }
    }

    public void F(int i2, int i3, int i4, int i5, int i6, int i7) {
        this.n = i6;
        this.o = i7;
        this.c = i2;
        this.d = i3;
        this.f = i4;
        this.e = i5;
    }

    public final void G(float f2, float f3, float f4, float f5) {
        I(true, 0.0f, 0.0f, f2, 0.0f, f3, 0.0f, f4, 0.0f, f5);
    }

    public final void H(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        I(false, f2, f3, f4, f5, f6, f7, f8, f9, f10);
    }

    public final void I(boolean z, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        if (z) {
            this.s.d(f8);
            this.s.a(f10);
            this.s.b((int) f6);
            this.s.c((int) f4);
            return;
        }
        float f11 = (f6 - f5) * f2;
        float f12 = (f8 - f7) * f2;
        float f13 = (f10 - f9) * f2;
        this.s.d(f7 + f12);
        this.s.a(f9 + f13);
        this.s.b((int) (f5 + f11));
        this.s.c((int) (f3 + (f2 * (f4 - f3))));
    }

    public void J(boolean z) {
        float f2;
        if (z) {
            f2 = 1.0f;
            this.f9425a = 1.0f;
        } else {
            f2 = 0.0f;
        }
        this.f9425a = f2;
        this.r.setAlpha(f2);
        setVisibility(0);
        D();
        x(z);
    }

    public void K(int i2, int i3, boolean z) {
        this.n = i2;
        this.o = i3;
        this.c = 0;
        this.d = 0;
        this.f = 0;
        this.e = 0;
        setVisibility(0);
        D();
        G((float) this.j, (float) this.m, (float) this.k, (float) this.l);
        if (z) {
            this.f9425a = 1.0f;
            this.r.setAlpha(1.0f);
        } else {
            this.f9425a = 0.0f;
            this.r.setAlpha(0.0f);
            this.q.setAlpha(0.0f);
            this.q.animate().alpha(1.0f).setDuration(250).start();
            this.r.animate().alpha(1.0f).setDuration(250).start();
        }
        E();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
        if (r1 != 3) goto L_0x0066;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.widget.FrameLayout r0 = r5.q
            r1 = 0
            android.view.View r0 = r0.getChildAt(r1)
            boolean r1 = r0 instanceof androidx.viewpager2.widget.ViewPager2
            if (r1 == 0) goto L_0x000e
            androidx.viewpager2.widget.ViewPager2 r0 = (androidx.viewpager2.widget.ViewPager2) r0
            goto L_0x000f
        L_0x000e:
            r0 = 0
        L_0x000f:
            int r1 = r6.getAction()
            r2 = 1
            if (r1 == 0) goto L_0x0053
            if (r1 == r2) goto L_0x004d
            r3 = 2
            if (r1 == r3) goto L_0x001f
            r3 = 3
            if (r1 == r3) goto L_0x004d
            goto L_0x0066
        L_0x001f:
            float r1 = r6.getX()
            int r1 = (int) r1
            float r3 = r6.getY()
            int r3 = (int) r3
            int r4 = r5.v
            int r1 = r1 - r4
            int r1 = java.lang.Math.abs(r1)
            int r4 = r5.w
            int r4 = r3 - r4
            int r4 = java.lang.Math.abs(r4)
            if (r1 <= r4) goto L_0x0040
            if (r0 == 0) goto L_0x0066
            r0.setUserInputEnabled(r2)
            goto L_0x0066
        L_0x0040:
            if (r0 == 0) goto L_0x0066
            int r1 = r5.w
            int r1 = r1 - r3
            boolean r1 = r5.canScrollVertically(r1)
            r0.setUserInputEnabled(r1)
            goto L_0x0066
        L_0x004d:
            if (r0 == 0) goto L_0x0066
            r0.setUserInputEnabled(r2)
            goto L_0x0066
        L_0x0053:
            float r1 = r6.getX()
            int r1 = (int) r1
            r5.v = r1
            float r1 = r6.getY()
            int r1 = (int) r1
            r5.w = r1
            if (r0 == 0) goto L_0x0066
            r0.setUserInputEnabled(r2)
        L_0x0066:
            boolean r5 = super.dispatchTouchEvent(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.magical.MagicalView.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setBackgroundAlpha(float f2) {
        this.f9425a = f2;
        this.r.setAlpha(f2);
    }

    public void setBackgroundColor(int i2) {
        this.r.setBackgroundColor(i2);
    }

    public void setMagicalContent(View view) {
        this.q.addView(view);
    }

    public void setOnMojitoViewCallback(OnMagicalViewCallback onMagicalViewCallback) {
        this.x = onMagicalViewCallback;
    }

    public void t() {
        if (!this.p) {
            if (this.f == 0 || this.e == 0) {
                v();
                return;
            }
            OnMagicalViewCallback onMagicalViewCallback = this.x;
            if (onMagicalViewCallback != null) {
                onMagicalViewCallback.e();
            }
            w(false);
            u();
        }
    }

    public final void u() {
        this.q.post(new Runnable() {
            public void run() {
                TransitionManager.beginDelayedTransition((ViewGroup) MagicalView.this.q.getParent(), new TransitionSet().setDuration(250).addTransition(new ChangeBounds()).addTransition(new ChangeTransform()).addTransition(new ChangeImageTransform()));
                MagicalView.this.w(true);
                MagicalView.this.q.setTranslationX(0.0f);
                MagicalView.this.q.setTranslationY(0.0f);
                MagicalView.this.s.d((float) MagicalView.this.f);
                MagicalView.this.s.a((float) MagicalView.this.e);
                MagicalView.this.s.c(MagicalView.this.d);
                MagicalView.this.s.b(MagicalView.this.c);
                MagicalView.this.y(true);
            }
        });
    }

    public final void v() {
        this.q.animate().alpha(0.0f).setDuration(250).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (MagicalView.this.x != null) {
                    MagicalView.this.x.c();
                }
            }
        }).start();
        this.r.animate().alpha(0.0f).setDuration(250).start();
    }

    public final void w(boolean z) {
        if (z) {
            this.x.a(true);
        }
    }

    public final void x(boolean z) {
        Interpolator a2;
        if (z) {
            this.f9425a = 1.0f;
            this.r.setAlpha(1.0f);
            G((float) this.j, (float) this.m, (float) this.k, (float) this.l);
            E();
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                MagicalView magicalView = MagicalView.this;
                magicalView.H(floatValue, (float) magicalView.d, (float) MagicalView.this.j, (float) MagicalView.this.c, (float) MagicalView.this.m, (float) MagicalView.this.f, (float) MagicalView.this.k, (float) MagicalView.this.e, (float) MagicalView.this.l);
            }
        });
        ofFloat.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                MagicalView.this.E();
            }
        });
        InterpolatorFactory interpolatorFactory = this.u.W0;
        if (!(interpolatorFactory == null || (a2 = interpolatorFactory.a()) == null)) {
            ofFloat.setInterpolator(a2);
        }
        ofFloat.setDuration(250).start();
        y(false);
    }

    public final void y(final boolean z) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.f9425a, z ? 0.0f : 1.0f});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                boolean unused = MagicalView.this.p = true;
                float unused2 = MagicalView.this.f9425a = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                MagicalView.this.r.setAlpha(MagicalView.this.f9425a);
                if (MagicalView.this.x != null) {
                    MagicalView.this.x.d(MagicalView.this.f9425a);
                }
            }
        });
        ofFloat.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                boolean unused = MagicalView.this.p = false;
                if (z && MagicalView.this.x != null) {
                    MagicalView.this.x.c();
                }
            }
        });
        ofFloat.setDuration(250);
        ofFloat.start();
    }

    public final void z() {
        int i2 = this.h;
        this.l = i2;
        this.k = this.g;
        this.j = 0;
        this.s.a((float) i2);
        this.s.d((float) this.g);
        this.s.c(0);
        this.s.b(0);
    }

    public MagicalView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MagicalView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f9425a = 0.0f;
        this.b = 250;
        this.p = false;
        SelectorConfig d2 = SelectorProviders.c().d();
        this.u = d2;
        this.t = d2.K;
        this.i = DensityUtil.d(getContext());
        getScreenSize();
        View view = new View(context);
        this.r = view;
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        view.setAlpha(this.f9425a);
        addView(view);
        FrameLayout frameLayout = new FrameLayout(context);
        this.q = frameLayout;
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(frameLayout);
        this.s = new MagicalViewWrapper(frameLayout);
    }
}
