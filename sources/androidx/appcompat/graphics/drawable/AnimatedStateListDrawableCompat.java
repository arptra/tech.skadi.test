package androidx.appcompat.graphics.drawable;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.graphics.drawable.DrawableContainerCompat;
import androidx.appcompat.graphics.drawable.StateListDrawableCompat;
import androidx.appcompat.resources.Compatibility;
import androidx.appcompat.resources.R;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class AnimatedStateListDrawableCompat extends StateListDrawableCompat implements TintAwareDrawable {
    public AnimatedStateListState o;
    public Transition p;
    public int q;
    public int r;
    public boolean s;

    public static class AnimatableTransition extends Transition {

        /* renamed from: a  reason: collision with root package name */
        public final Animatable f199a;

        public AnimatableTransition(Animatable animatable) {
            super();
            this.f199a = animatable;
        }

        public void c() {
            this.f199a.start();
        }

        public void d() {
            this.f199a.stop();
        }
    }

    public static class AnimatedStateListState extends StateListDrawableCompat.StateListState {
        public LongSparseArray K;
        public SparseArrayCompat L;

        public AnimatedStateListState(AnimatedStateListState animatedStateListState, AnimatedStateListDrawableCompat animatedStateListDrawableCompat, Resources resources) {
            super(animatedStateListState, animatedStateListDrawableCompat, resources);
            if (animatedStateListState != null) {
                this.K = animatedStateListState.K;
                this.L = animatedStateListState.L;
                return;
            }
            this.K = new LongSparseArray();
            this.L = new SparseArrayCompat();
        }

        public static long E(int i, int i2) {
            return ((long) i2) | (((long) i) << 32);
        }

        public int C(int[] iArr, Drawable drawable, int i) {
            int A = super.A(iArr, drawable);
            this.L.m(A, Integer.valueOf(i));
            return A;
        }

        public int D(int i, int i2, Drawable drawable, boolean z) {
            int a2 = super.a(drawable);
            long E = E(i, i2);
            long j = z ? 8589934592L : 0;
            long j2 = (long) a2;
            this.K.append(E, Long.valueOf(j2 | j));
            if (z) {
                this.K.append(E(i2, i), Long.valueOf(4294967296L | j2 | j));
            }
            return a2;
        }

        public int F(int i) {
            if (i < 0) {
                return 0;
            }
            return ((Integer) this.L.h(i, 0)).intValue();
        }

        public int G(int[] iArr) {
            int B = super.B(iArr);
            return B >= 0 ? B : super.B(StateSet.WILD_CARD);
        }

        public int H(int i, int i2) {
            return (int) ((Long) this.K.get(E(i, i2), -1L)).longValue();
        }

        public boolean I(int i, int i2) {
            return (((Long) this.K.get(E(i, i2), -1L)).longValue() & 4294967296L) != 0;
        }

        public boolean J(int i, int i2) {
            return (((Long) this.K.get(E(i, i2), -1L)).longValue() & 8589934592L) != 0;
        }

        public Drawable newDrawable() {
            return new AnimatedStateListDrawableCompat(this, (Resources) null);
        }

        public void s() {
            this.K = this.K.clone();
            this.L = this.L.clone();
        }

        public Drawable newDrawable(Resources resources) {
            return new AnimatedStateListDrawableCompat(this, resources);
        }
    }

    public static class AnimatedVectorDrawableTransition extends Transition {

        /* renamed from: a  reason: collision with root package name */
        public final AnimatedVectorDrawableCompat f200a;

        public AnimatedVectorDrawableTransition(AnimatedVectorDrawableCompat animatedVectorDrawableCompat) {
            super();
            this.f200a = animatedVectorDrawableCompat;
        }

        public void c() {
            this.f200a.start();
        }

        public void d() {
            this.f200a.stop();
        }
    }

    public static class AnimationDrawableTransition extends Transition {

        /* renamed from: a  reason: collision with root package name */
        public final ObjectAnimator f201a;
        public final boolean b;

        public AnimationDrawableTransition(AnimationDrawable animationDrawable, boolean z, boolean z2) {
            super();
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i = 0;
            int i2 = z ? numberOfFrames - 1 : 0;
            i = !z ? numberOfFrames - 1 : i;
            FrameInterpolator frameInterpolator = new FrameInterpolator(animationDrawable, z);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", new int[]{i2, i});
            Compatibility.Api18Impl.a(ofInt, true);
            ofInt.setDuration((long) frameInterpolator.a());
            ofInt.setInterpolator(frameInterpolator);
            this.b = z2;
            this.f201a = ofInt;
        }

        public boolean a() {
            return this.b;
        }

        public void b() {
            this.f201a.reverse();
        }

        public void c() {
            this.f201a.start();
        }

        public void d() {
            this.f201a.cancel();
        }
    }

    public static class FrameInterpolator implements TimeInterpolator {

        /* renamed from: a  reason: collision with root package name */
        public int[] f202a;
        public int b;
        public int c;

        public FrameInterpolator(AnimationDrawable animationDrawable, boolean z) {
            b(animationDrawable, z);
        }

        public int a() {
            return this.c;
        }

        public int b(AnimationDrawable animationDrawable, boolean z) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.b = numberOfFrames;
            int[] iArr = this.f202a;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.f202a = new int[numberOfFrames];
            }
            int[] iArr2 = this.f202a;
            int i = 0;
            for (int i2 = 0; i2 < numberOfFrames; i2++) {
                int duration = animationDrawable.getDuration(z ? (numberOfFrames - i2) - 1 : i2);
                iArr2[i2] = duration;
                i += duration;
            }
            this.c = i;
            return i;
        }

        public float getInterpolation(float f) {
            int i = (int) ((f * ((float) this.c)) + 0.5f);
            int i2 = this.b;
            int[] iArr = this.f202a;
            int i3 = 0;
            while (i3 < i2) {
                int i4 = iArr[i3];
                if (i < i4) {
                    break;
                }
                i -= i4;
                i3++;
            }
            return (((float) i3) / ((float) i2)) + (i3 < i2 ? ((float) i) / ((float) this.c) : 0.0f);
        }
    }

    public static abstract class Transition {
        public Transition() {
        }

        public boolean a() {
            return false;
        }

        public void b() {
        }

        public abstract void c();

        public abstract void d();
    }

    public AnimatedStateListDrawableCompat() {
        this((AnimatedStateListState) null, (Resources) null);
    }

    public static AnimatedStateListDrawableCompat m(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            AnimatedStateListDrawableCompat animatedStateListDrawableCompat = new AnimatedStateListDrawableCompat();
            animatedStateListDrawableCompat.n(context, resources, xmlPullParser, attributeSet, theme);
            return animatedStateListDrawableCompat;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
    }

    private void p() {
        onStateChange(getState());
    }

    public void h(DrawableContainerCompat.DrawableContainerState drawableContainerState) {
        super.h(drawableContainerState);
        if (drawableContainerState instanceof AnimatedStateListState) {
            this.o = (AnimatedStateListState) drawableContainerState;
        }
    }

    public boolean isStateful() {
        return true;
    }

    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        Transition transition = this.p;
        if (transition != null) {
            transition.d();
            this.p = null;
            g(this.q);
            this.q = -1;
            this.r = -1;
        }
    }

    /* renamed from: l */
    public AnimatedStateListState j() {
        return new AnimatedStateListState(this.o, this, (Resources) null);
    }

    public Drawable mutate() {
        if (!this.s && super.mutate() == this) {
            this.o.s();
            this.s = true;
        }
        return this;
    }

    public void n(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray q2 = TypedArrayUtils.q(resources, theme, attributeSet, R.styleable.AnimatedStateListDrawableCompat);
        setVisible(q2.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_visible, true), true);
        t(q2);
        i(resources);
        q2.recycle();
        o(context, resources, xmlPullParser, attributeSet, theme);
        p();
    }

    public final void o(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next != 1) {
                int depth2 = xmlPullParser.getDepth();
                if (depth2 < depth && next == 3) {
                    return;
                }
                if (next == 2 && depth2 <= depth) {
                    if (xmlPullParser.getName().equals("item")) {
                        q(context, resources, xmlPullParser, attributeSet, theme);
                    } else if (xmlPullParser.getName().equals("transition")) {
                        r(context, resources, xmlPullParser, attributeSet, theme);
                    }
                }
            } else {
                return;
            }
        }
    }

    public boolean onStateChange(int[] iArr) {
        int G = this.o.G(iArr);
        boolean z = G != c() && (s(G) || g(G));
        Drawable current = getCurrent();
        return current != null ? z | current.setState(iArr) : z;
    }

    public final int q(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int next;
        TypedArray q2 = TypedArrayUtils.q(resources, theme, attributeSet, R.styleable.AnimatedStateListDrawableItem);
        int resourceId = q2.getResourceId(R.styleable.AnimatedStateListDrawableItem_android_id, 0);
        int resourceId2 = q2.getResourceId(R.styleable.AnimatedStateListDrawableItem_android_drawable, -1);
        Drawable i = resourceId2 > 0 ? ResourceManagerInternal.g().i(context, resourceId2) : null;
        q2.recycle();
        int[] k = k(attributeSet);
        if (i == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next == 2) {
                i = xmlPullParser.getName().equals("vector") ? VectorDrawableCompat.c(resources, xmlPullParser, attributeSet, theme) : Compatibility.Api21Impl.a(resources, xmlPullParser, attributeSet, theme);
            } else {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
        }
        if (i != null) {
            return this.o.C(k, i, resourceId);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
    }

    public final int r(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int next;
        TypedArray q2 = TypedArrayUtils.q(resources, theme, attributeSet, R.styleable.AnimatedStateListDrawableTransition);
        int resourceId = q2.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_fromId, -1);
        int resourceId2 = q2.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_toId, -1);
        int resourceId3 = q2.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_drawable, -1);
        Drawable i = resourceId3 > 0 ? ResourceManagerInternal.g().i(context, resourceId3) : null;
        boolean z = q2.getBoolean(R.styleable.AnimatedStateListDrawableTransition_android_reversible, false);
        q2.recycle();
        if (i == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next == 2) {
                i = xmlPullParser.getName().equals("animated-vector") ? AnimatedVectorDrawableCompat.b(context, resources, xmlPullParser, attributeSet, theme) : Compatibility.Api21Impl.a(resources, xmlPullParser, attributeSet, theme);
            } else {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
        }
        if (i == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
        } else if (resourceId != -1 && resourceId2 != -1) {
            return this.o.D(resourceId, resourceId2, i, z);
        } else {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
        }
    }

    public final boolean s(int i) {
        int i2;
        int H;
        Transition transition;
        Transition transition2 = this.p;
        if (transition2 == null) {
            i2 = c();
        } else if (i == this.q) {
            return true;
        } else {
            if (i != this.r || !transition2.a()) {
                i2 = this.q;
                transition2.d();
            } else {
                transition2.b();
                this.q = this.r;
                this.r = i;
                return true;
            }
        }
        this.p = null;
        this.r = -1;
        this.q = -1;
        AnimatedStateListState animatedStateListState = this.o;
        int F = animatedStateListState.F(i2);
        int F2 = animatedStateListState.F(i);
        if (F2 == 0 || F == 0 || (H = animatedStateListState.H(F, F2)) < 0) {
            return false;
        }
        boolean J = animatedStateListState.J(F, F2);
        g(H);
        Drawable current = getCurrent();
        if (current instanceof AnimationDrawable) {
            transition = new AnimationDrawableTransition((AnimationDrawable) current, animatedStateListState.I(F, F2), J);
        } else if (current instanceof AnimatedVectorDrawableCompat) {
            transition = new AnimatedVectorDrawableTransition((AnimatedVectorDrawableCompat) current);
        } else {
            if (current instanceof Animatable) {
                transition = new AnimatableTransition((Animatable) current);
            }
            return false;
        }
        transition.c();
        this.p = transition;
        this.r = i2;
        this.q = i;
        return true;
    }

    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        Transition transition = this.p;
        if (transition != null && (visible || z2)) {
            if (z) {
                transition.c();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    public final void t(TypedArray typedArray) {
        AnimatedStateListState animatedStateListState = this.o;
        animatedStateListState.d |= Compatibility.Api21Impl.b(typedArray);
        animatedStateListState.y(typedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_variablePadding, animatedStateListState.i));
        animatedStateListState.u(typedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_constantSize, animatedStateListState.l));
        animatedStateListState.v(typedArray.getInt(R.styleable.AnimatedStateListDrawableCompat_android_enterFadeDuration, animatedStateListState.A));
        animatedStateListState.w(typedArray.getInt(R.styleable.AnimatedStateListDrawableCompat_android_exitFadeDuration, animatedStateListState.B));
        setDither(typedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_dither, animatedStateListState.x));
    }

    public AnimatedStateListDrawableCompat(AnimatedStateListState animatedStateListState, Resources resources) {
        super((StateListDrawableCompat.StateListState) null);
        this.q = -1;
        this.r = -1;
        h(new AnimatedStateListState(animatedStateListState, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }
}
