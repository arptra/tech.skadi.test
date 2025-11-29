package androidx.core.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

@Deprecated
public final class ScrollerCompat {

    /* renamed from: a  reason: collision with root package name */
    public OverScroller f951a;

    public ScrollerCompat(Context context, Interpolator interpolator) {
        this.f951a = interpolator != null ? new OverScroller(context, interpolator) : new OverScroller(context);
    }

    public static ScrollerCompat a(Context context) {
        return b(context, (Interpolator) null);
    }

    public static ScrollerCompat b(Context context, Interpolator interpolator) {
        return new ScrollerCompat(context, interpolator);
    }

    public void c(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.f951a.fling(i, i2, i3, i4, i5, i6, i7, i8);
    }

    public int d() {
        return this.f951a.getFinalY();
    }
}
