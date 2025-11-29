package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

final class WrappedDrawableState extends Drawable.ConstantState {

    /* renamed from: a  reason: collision with root package name */
    public int f729a;
    public Drawable.ConstantState b;
    public ColorStateList c = null;
    public PorterDuff.Mode d = WrappedDrawableApi14.g;

    public WrappedDrawableState(WrappedDrawableState wrappedDrawableState) {
        if (wrappedDrawableState != null) {
            this.f729a = wrappedDrawableState.f729a;
            this.b = wrappedDrawableState.b;
            this.c = wrappedDrawableState.c;
            this.d = wrappedDrawableState.d;
        }
    }

    public boolean a() {
        return this.b != null;
    }

    public int getChangingConfigurations() {
        int i = this.f729a;
        Drawable.ConstantState constantState = this.b;
        return (constantState != null ? constantState.getChangingConfigurations() : 0) | i;
    }

    public Drawable newDrawable() {
        return newDrawable((Resources) null);
    }

    public Drawable newDrawable(Resources resources) {
        return new WrappedDrawableApi21(this, resources);
    }
}
