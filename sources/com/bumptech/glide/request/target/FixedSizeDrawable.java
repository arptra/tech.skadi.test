package com.bumptech.glide.request.target;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.util.Preconditions;

public class FixedSizeDrawable extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    public final Matrix f2718a;
    public final RectF b;
    public final RectF c;
    public Drawable d;
    public State e;
    public boolean f;

    public static final class State extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        public final Drawable.ConstantState f2719a;
        public final int b;
        public final int c;

        public State(State state) {
            this(state.f2719a, state.b, state.c);
        }

        public int getChangingConfigurations() {
            return 0;
        }

        public Drawable newDrawable() {
            return new FixedSizeDrawable(this, this.f2719a.newDrawable());
        }

        public State(Drawable.ConstantState constantState, int i, int i2) {
            this.f2719a = constantState;
            this.b = i;
            this.c = i2;
        }

        public Drawable newDrawable(Resources resources) {
            return new FixedSizeDrawable(this, this.f2719a.newDrawable(resources));
        }
    }

    public FixedSizeDrawable(Drawable drawable, int i, int i2) {
        this(new State(drawable.getConstantState(), i, i2), drawable);
    }

    public final void a() {
        this.f2718a.setRectToRect(this.b, this.c, Matrix.ScaleToFit.CENTER);
    }

    public void clearColorFilter() {
        this.d.clearColorFilter();
    }

    public void draw(Canvas canvas) {
        canvas.save();
        canvas.concat(this.f2718a);
        this.d.draw(canvas);
        canvas.restore();
    }

    public int getAlpha() {
        return this.d.getAlpha();
    }

    public Drawable.Callback getCallback() {
        return this.d.getCallback();
    }

    public int getChangingConfigurations() {
        return this.d.getChangingConfigurations();
    }

    public Drawable.ConstantState getConstantState() {
        return this.e;
    }

    public Drawable getCurrent() {
        return this.d.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.e.c;
    }

    public int getIntrinsicWidth() {
        return this.e.b;
    }

    public int getMinimumHeight() {
        return this.d.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.d.getMinimumWidth();
    }

    public int getOpacity() {
        return this.d.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.d.getPadding(rect);
    }

    public void invalidateSelf() {
        super.invalidateSelf();
        this.d.invalidateSelf();
    }

    public Drawable mutate() {
        if (!this.f && super.mutate() == this) {
            this.d = this.d.mutate();
            this.e = new State(this.e);
            this.f = true;
        }
        return this;
    }

    public void scheduleSelf(Runnable runnable, long j) {
        super.scheduleSelf(runnable, j);
        this.d.scheduleSelf(runnable, j);
    }

    public void setAlpha(int i) {
        this.d.setAlpha(i);
    }

    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        this.c.set((float) i, (float) i2, (float) i3, (float) i4);
        a();
    }

    public void setChangingConfigurations(int i) {
        this.d.setChangingConfigurations(i);
    }

    public void setColorFilter(int i, PorterDuff.Mode mode) {
        this.d.setColorFilter(i, mode);
    }

    public void setDither(boolean z) {
        this.d.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.d.setFilterBitmap(z);
    }

    public boolean setVisible(boolean z, boolean z2) {
        return this.d.setVisible(z, z2);
    }

    public void unscheduleSelf(Runnable runnable) {
        super.unscheduleSelf(runnable);
        this.d.unscheduleSelf(runnable);
    }

    public FixedSizeDrawable(State state, Drawable drawable) {
        this.e = (State) Preconditions.d(state);
        this.d = (Drawable) Preconditions.d(drawable);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.f2718a = new Matrix();
        this.b = new RectF(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
        this.c = new RectF();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.d.setColorFilter(colorFilter);
    }

    public void setBounds(Rect rect) {
        super.setBounds(rect);
        this.c.set(rect);
        a();
    }
}
