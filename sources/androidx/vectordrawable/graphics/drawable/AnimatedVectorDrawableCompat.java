package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.RequiresApi;
import androidx.collection.ArrayMap;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

public class AnimatedVectorDrawableCompat extends VectorDrawableCommon implements Animatable2Compat {
    public AnimatedVectorDrawableCompatState b;
    public Context c;
    public ArgbEvaluator d;
    public AnimatedVectorDrawableDelegateState e;
    public Animator.AnimatorListener f;
    public ArrayList g;
    public final Drawable.Callback h;

    public static class AnimatedVectorDrawableCompatState extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        public int f1895a;
        public VectorDrawableCompat b;
        public AnimatorSet c;
        public ArrayList d;
        public ArrayMap e;

        public AnimatedVectorDrawableCompatState(Context context, AnimatedVectorDrawableCompatState animatedVectorDrawableCompatState, Drawable.Callback callback, Resources resources) {
            if (animatedVectorDrawableCompatState != null) {
                this.f1895a = animatedVectorDrawableCompatState.f1895a;
                VectorDrawableCompat vectorDrawableCompat = animatedVectorDrawableCompatState.b;
                if (vectorDrawableCompat != null) {
                    Drawable.ConstantState constantState = vectorDrawableCompat.getConstantState();
                    if (resources != null) {
                        this.b = (VectorDrawableCompat) constantState.newDrawable(resources);
                    } else {
                        this.b = (VectorDrawableCompat) constantState.newDrawable();
                    }
                    VectorDrawableCompat vectorDrawableCompat2 = (VectorDrawableCompat) this.b.mutate();
                    this.b = vectorDrawableCompat2;
                    vectorDrawableCompat2.setCallback(callback);
                    this.b.setBounds(animatedVectorDrawableCompatState.b.getBounds());
                    this.b.h(false);
                }
                ArrayList arrayList = animatedVectorDrawableCompatState.d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.d = new ArrayList(size);
                    this.e = new ArrayMap(size);
                    for (int i = 0; i < size; i++) {
                        Animator animator = (Animator) animatedVectorDrawableCompatState.d.get(i);
                        Animator clone = animator.clone();
                        String str = (String) animatedVectorDrawableCompatState.e.get(animator);
                        clone.setTarget(this.b.d(str));
                        this.d.add(clone);
                        this.e.put(clone, str);
                    }
                    a();
                }
            }
        }

        public void a() {
            if (this.c == null) {
                this.c = new AnimatorSet();
            }
            this.c.playTogether(this.d);
        }

        public int getChangingConfigurations() {
            return this.f1895a;
        }

        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    public AnimatedVectorDrawableCompat() {
        this((Context) null, (AnimatedVectorDrawableCompatState) null, (Resources) null);
    }

    public static AnimatedVectorDrawableCompat a(Context context, int i) {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(context);
        Drawable f2 = ResourcesCompat.f(context.getResources(), i, context.getTheme());
        animatedVectorDrawableCompat.f1900a = f2;
        f2.setCallback(animatedVectorDrawableCompat.h);
        animatedVectorDrawableCompat.e = new AnimatedVectorDrawableDelegateState(animatedVectorDrawableCompat.f1900a.getConstantState());
        return animatedVectorDrawableCompat;
    }

    public static AnimatedVectorDrawableCompat b(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(context);
        animatedVectorDrawableCompat.inflate(resources, xmlPullParser, attributeSet, theme);
        return animatedVectorDrawableCompat;
    }

    public static void d(AnimatedVectorDrawable animatedVectorDrawable, Animatable2Compat.AnimationCallback animationCallback) {
        animatedVectorDrawable.registerAnimationCallback(animationCallback.getPlatformCallback());
    }

    public static boolean h(AnimatedVectorDrawable animatedVectorDrawable, Animatable2Compat.AnimationCallback animationCallback) {
        return animatedVectorDrawable.unregisterAnimationCallback(animationCallback.getPlatformCallback());
    }

    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f1900a;
        if (drawable != null) {
            DrawableCompat.a(drawable, theme);
        }
    }

    public void c(Animatable2Compat.AnimationCallback animationCallback) {
        Drawable drawable = this.f1900a;
        if (drawable != null) {
            d((AnimatedVectorDrawable) drawable, animationCallback);
        } else if (animationCallback != null) {
            if (this.g == null) {
                this.g = new ArrayList();
            }
            if (!this.g.contains(animationCallback)) {
                this.g.add(animationCallback);
                if (this.f == null) {
                    this.f = new AnimatorListenerAdapter() {
                        public void onAnimationEnd(Animator animator) {
                            ArrayList arrayList = new ArrayList(AnimatedVectorDrawableCompat.this.g);
                            int size = arrayList.size();
                            for (int i = 0; i < size; i++) {
                                ((Animatable2Compat.AnimationCallback) arrayList.get(i)).onAnimationEnd(AnimatedVectorDrawableCompat.this);
                            }
                        }

                        public void onAnimationStart(Animator animator) {
                            ArrayList arrayList = new ArrayList(AnimatedVectorDrawableCompat.this.g);
                            int size = arrayList.size();
                            for (int i = 0; i < size; i++) {
                                ((Animatable2Compat.AnimationCallback) arrayList.get(i)).onAnimationStart(AnimatedVectorDrawableCompat.this);
                            }
                        }
                    };
                }
                this.b.c.addListener(this.f);
            }
        }
    }

    public boolean canApplyTheme() {
        Drawable drawable = this.f1900a;
        if (drawable != null) {
            return DrawableCompat.b(drawable);
        }
        return false;
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.f1900a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.b.b.draw(canvas);
        if (this.b.c.isStarted()) {
            invalidateSelf();
        }
    }

    public final void e() {
        Animator.AnimatorListener animatorListener = this.f;
        if (animatorListener != null) {
            this.b.c.removeListener(animatorListener);
            this.f = null;
        }
    }

    public final void f(String str, Animator animator) {
        animator.setTarget(this.b.b.d(str));
        AnimatedVectorDrawableCompatState animatedVectorDrawableCompatState = this.b;
        if (animatedVectorDrawableCompatState.d == null) {
            animatedVectorDrawableCompatState.d = new ArrayList();
            this.b.e = new ArrayMap();
        }
        this.b.d.add(animator);
        this.b.e.put(animator, str);
    }

    public boolean g(Animatable2Compat.AnimationCallback animationCallback) {
        Drawable drawable = this.f1900a;
        if (drawable != null) {
            h((AnimatedVectorDrawable) drawable, animationCallback);
        }
        ArrayList arrayList = this.g;
        if (arrayList == null || animationCallback == null) {
            return false;
        }
        boolean remove = arrayList.remove(animationCallback);
        if (this.g.size() == 0) {
            e();
        }
        return remove;
    }

    public int getAlpha() {
        Drawable drawable = this.f1900a;
        return drawable != null ? DrawableCompat.d(drawable) : this.b.b.getAlpha();
    }

    public int getChangingConfigurations() {
        Drawable drawable = this.f1900a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return this.b.f1895a | super.getChangingConfigurations();
    }

    public ColorFilter getColorFilter() {
        Drawable drawable = this.f1900a;
        return drawable != null ? DrawableCompat.e(drawable) : this.b.b.getColorFilter();
    }

    public Drawable.ConstantState getConstantState() {
        if (this.f1900a != null) {
            return new AnimatedVectorDrawableDelegateState(this.f1900a.getConstantState());
        }
        return null;
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.f1900a;
        return drawable != null ? drawable.getIntrinsicHeight() : this.b.b.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.f1900a;
        return drawable != null ? drawable.getIntrinsicWidth() : this.b.b.getIntrinsicWidth();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public int getOpacity() {
        Drawable drawable = this.f1900a;
        return drawable != null ? drawable.getOpacity() : this.b.b.getOpacity();
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        Drawable drawable = this.f1900a;
        if (drawable != null) {
            DrawableCompat.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray q = TypedArrayUtils.q(resources, theme, attributeSet, AndroidResources.e);
                    int resourceId = q.getResourceId(0, 0);
                    if (resourceId != 0) {
                        VectorDrawableCompat b2 = VectorDrawableCompat.b(resources, resourceId, theme);
                        b2.h(false);
                        b2.setCallback(this.h);
                        VectorDrawableCompat vectorDrawableCompat = this.b.b;
                        if (vectorDrawableCompat != null) {
                            vectorDrawableCompat.setCallback((Drawable.Callback) null);
                        }
                        this.b.b = b2;
                    }
                    q.recycle();
                } else if ("target".equals(name)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, AndroidResources.f);
                    String string = obtainAttributes.getString(0);
                    int resourceId2 = obtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.c;
                        if (context != null) {
                            f(string, AnimatorInflaterCompat.a(context, resourceId2));
                        } else {
                            obtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    obtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        this.b.a();
    }

    public boolean isAutoMirrored() {
        Drawable drawable = this.f1900a;
        return drawable != null ? DrawableCompat.h(drawable) : this.b.b.isAutoMirrored();
    }

    public boolean isRunning() {
        Drawable drawable = this.f1900a;
        return drawable != null ? ((AnimatedVectorDrawable) drawable).isRunning() : this.b.c.isRunning();
    }

    public boolean isStateful() {
        Drawable drawable = this.f1900a;
        return drawable != null ? drawable.isStateful() : this.b.b.isStateful();
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public Drawable mutate() {
        Drawable drawable = this.f1900a;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f1900a;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.b.b.setBounds(rect);
        }
    }

    public boolean onLevelChange(int i) {
        Drawable drawable = this.f1900a;
        return drawable != null ? drawable.setLevel(i) : this.b.b.setLevel(i);
    }

    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f1900a;
        return drawable != null ? drawable.setState(iArr) : this.b.b.setState(iArr);
    }

    public void setAlpha(int i) {
        Drawable drawable = this.f1900a;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else {
            this.b.b.setAlpha(i);
        }
    }

    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.f1900a;
        if (drawable != null) {
            DrawableCompat.j(drawable, z);
        } else {
            this.b.b.setAutoMirrored(z);
        }
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i, PorterDuff.Mode mode) {
        super.setColorFilter(i, mode);
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    public void setTint(int i) {
        Drawable drawable = this.f1900a;
        if (drawable != null) {
            DrawableCompat.n(drawable, i);
        } else {
            this.b.b.setTint(i);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f1900a;
        if (drawable != null) {
            DrawableCompat.o(drawable, colorStateList);
        } else {
            this.b.b.setTintList(colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f1900a;
        if (drawable != null) {
            DrawableCompat.p(drawable, mode);
        } else {
            this.b.b.setTintMode(mode);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f1900a;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        this.b.b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    public void start() {
        Drawable drawable = this.f1900a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else if (!this.b.c.isStarted()) {
            this.b.c.start();
            invalidateSelf();
        }
    }

    public void stop() {
        Drawable drawable = this.f1900a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.b.c.end();
        }
    }

    public AnimatedVectorDrawableCompat(Context context) {
        this(context, (AnimatedVectorDrawableCompatState) null, (Resources) null);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f1900a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.b.b.setColorFilter(colorFilter);
        }
    }

    @RequiresApi
    public static class AnimatedVectorDrawableDelegateState extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        public final Drawable.ConstantState f1896a;

        public AnimatedVectorDrawableDelegateState(Drawable.ConstantState constantState) {
            this.f1896a = constantState;
        }

        public boolean canApplyTheme() {
            return this.f1896a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f1896a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
            Drawable newDrawable = this.f1896a.newDrawable();
            animatedVectorDrawableCompat.f1900a = newDrawable;
            newDrawable.setCallback(animatedVectorDrawableCompat.h);
            return animatedVectorDrawableCompat;
        }

        public Drawable newDrawable(Resources resources) {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
            Drawable newDrawable = this.f1896a.newDrawable(resources);
            animatedVectorDrawableCompat.f1900a = newDrawable;
            newDrawable.setCallback(animatedVectorDrawableCompat.h);
            return animatedVectorDrawableCompat;
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
            Drawable newDrawable = this.f1896a.newDrawable(resources, theme);
            animatedVectorDrawableCompat.f1900a = newDrawable;
            newDrawable.setCallback(animatedVectorDrawableCompat.h);
            return animatedVectorDrawableCompat;
        }
    }

    public AnimatedVectorDrawableCompat(Context context, AnimatedVectorDrawableCompatState animatedVectorDrawableCompatState, Resources resources) {
        this.d = null;
        this.f = null;
        this.g = null;
        AnonymousClass1 r0 = new Drawable.Callback() {
            public void invalidateDrawable(Drawable drawable) {
                AnimatedVectorDrawableCompat.this.invalidateSelf();
            }

            public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
                AnimatedVectorDrawableCompat.this.scheduleSelf(runnable, j);
            }

            public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                AnimatedVectorDrawableCompat.this.unscheduleSelf(runnable);
            }
        };
        this.h = r0;
        this.c = context;
        if (animatedVectorDrawableCompatState != null) {
            this.b = animatedVectorDrawableCompatState;
        } else {
            this.b = new AnimatedVectorDrawableCompatState(context, animatedVectorDrawableCompatState, r0, resources);
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, (Resources.Theme) null);
    }
}
