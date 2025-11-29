package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

class WrappedDrawableApi14 extends Drawable implements Drawable.Callback, WrappedDrawable, TintAwareDrawable {
    public static final PorterDuff.Mode g = PorterDuff.Mode.SRC_IN;

    /* renamed from: a  reason: collision with root package name */
    public int f728a;
    public PorterDuff.Mode b;
    public boolean c;
    public WrappedDrawableState d;
    public boolean e;
    public Drawable f;

    public WrappedDrawableApi14(WrappedDrawableState wrappedDrawableState, Resources resources) {
        this.d = wrappedDrawableState;
        e(resources);
    }

    public final void a(Drawable drawable) {
        Drawable drawable2 = this.f;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            WrappedDrawableState wrappedDrawableState = this.d;
            if (wrappedDrawableState != null) {
                wrappedDrawableState.b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    public final Drawable b() {
        return this.f;
    }

    public boolean c() {
        return true;
    }

    public final WrappedDrawableState d() {
        return new WrappedDrawableState(this.d);
    }

    public void draw(Canvas canvas) {
        this.f.draw(canvas);
    }

    public final void e(Resources resources) {
        Drawable.ConstantState constantState;
        WrappedDrawableState wrappedDrawableState = this.d;
        if (wrappedDrawableState != null && (constantState = wrappedDrawableState.b) != null) {
            a(constantState.newDrawable(resources));
        }
    }

    public final boolean f(int[] iArr) {
        if (!c()) {
            return false;
        }
        WrappedDrawableState wrappedDrawableState = this.d;
        ColorStateList colorStateList = wrappedDrawableState.c;
        PorterDuff.Mode mode = wrappedDrawableState.d;
        if (colorStateList == null || mode == null) {
            this.c = false;
            clearColorFilter();
        } else {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!(this.c && colorForState == this.f728a && mode == this.b)) {
                setColorFilter(colorForState, mode);
                this.f728a = colorForState;
                this.b = mode;
                this.c = true;
                return true;
            }
        }
        return false;
    }

    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        WrappedDrawableState wrappedDrawableState = this.d;
        return this.f.getChangingConfigurations() | changingConfigurations | (wrappedDrawableState != null ? wrappedDrawableState.getChangingConfigurations() : 0);
    }

    public Drawable.ConstantState getConstantState() {
        WrappedDrawableState wrappedDrawableState = this.d;
        if (wrappedDrawableState == null || !wrappedDrawableState.a()) {
            return null;
        }
        this.d.f729a = getChangingConfigurations();
        return this.d;
    }

    public Drawable getCurrent() {
        return this.f.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.f.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.f.getIntrinsicWidth();
    }

    public int getLayoutDirection() {
        return DrawableCompat.f(this.f);
    }

    public int getMinimumHeight() {
        return this.f.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.f.getMinimumWidth();
    }

    public int getOpacity() {
        return this.f.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.f.getPadding(rect);
    }

    public int[] getState() {
        return this.f.getState();
    }

    public Region getTransparentRegion() {
        return this.f.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return DrawableCompat.h(this.f);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r1.d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isStateful() {
        /*
            r1 = this;
            boolean r0 = r1.c()
            if (r0 == 0) goto L_0x000d
            androidx.core.graphics.drawable.WrappedDrawableState r0 = r1.d
            if (r0 == 0) goto L_0x000d
            android.content.res.ColorStateList r0 = r0.c
            goto L_0x000e
        L_0x000d:
            r0 = 0
        L_0x000e:
            if (r0 == 0) goto L_0x0016
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x001e
        L_0x0016:
            android.graphics.drawable.Drawable r1 = r1.f
            boolean r1 = r1.isStateful()
            if (r1 == 0) goto L_0x0020
        L_0x001e:
            r1 = 1
            goto L_0x0021
        L_0x0020:
            r1 = 0
        L_0x0021:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.drawable.WrappedDrawableApi14.isStateful():boolean");
    }

    public void jumpToCurrentState() {
        this.f.jumpToCurrentState();
    }

    public Drawable mutate() {
        if (!this.e && super.mutate() == this) {
            this.d = d();
            Drawable drawable = this.f;
            if (drawable != null) {
                drawable.mutate();
            }
            WrappedDrawableState wrappedDrawableState = this.d;
            if (wrappedDrawableState != null) {
                Drawable drawable2 = this.f;
                wrappedDrawableState.b = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.e = true;
        }
        return this;
    }

    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    public boolean onLayoutDirectionChanged(int i) {
        return DrawableCompat.m(this.f, i);
    }

    public boolean onLevelChange(int i) {
        return this.f.setLevel(i);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void setAlpha(int i) {
        this.f.setAlpha(i);
    }

    public void setAutoMirrored(boolean z) {
        DrawableCompat.j(this.f, z);
    }

    public void setChangingConfigurations(int i) {
        this.f.setChangingConfigurations(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f.setColorFilter(colorFilter);
    }

    public void setDither(boolean z) {
        this.f.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f.setFilterBitmap(z);
    }

    public boolean setState(int[] iArr) {
        return f(iArr) || this.f.setState(iArr);
    }

    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.d.c = colorStateList;
        f(getState());
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.d.d = mode;
        f(getState());
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f.setVisible(z, z2);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
