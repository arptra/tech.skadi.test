package androidx.appcompat.widget;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;

@RestrictTo
class TooltipCompatHandler implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {
    public static TooltipCompatHandler k;
    public static TooltipCompatHandler l;

    /* renamed from: a  reason: collision with root package name */
    public final View f374a;
    public final CharSequence b;
    public final int c;
    public final Runnable d;
    public final Runnable e;
    public int f;
    public int g;
    public TooltipPopup h;
    public boolean i;
    public boolean j;

    public static void e(TooltipCompatHandler tooltipCompatHandler) {
        TooltipCompatHandler tooltipCompatHandler2 = k;
        if (tooltipCompatHandler2 != null) {
            tooltipCompatHandler2.a();
        }
        k = tooltipCompatHandler;
        if (tooltipCompatHandler != null) {
            tooltipCompatHandler.d();
        }
    }

    public final void a() {
        this.f374a.removeCallbacks(this.d);
    }

    public final void b() {
        this.j = true;
    }

    public void c() {
        if (l == this) {
            l = null;
            TooltipPopup tooltipPopup = this.h;
            if (tooltipPopup != null) {
                tooltipPopup.c();
                this.h = null;
                b();
                this.f374a.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (k == this) {
            e((TooltipCompatHandler) null);
        }
        this.f374a.removeCallbacks(this.e);
    }

    public final void d() {
        this.f374a.postDelayed(this.d, (long) ViewConfiguration.getLongPressTimeout());
    }

    public void f(boolean z) {
        long j2;
        long longPressTimeout;
        long j3;
        if (ViewCompat.V(this.f374a)) {
            e((TooltipCompatHandler) null);
            TooltipCompatHandler tooltipCompatHandler = l;
            if (tooltipCompatHandler != null) {
                tooltipCompatHandler.c();
            }
            l = this;
            this.i = z;
            TooltipPopup tooltipPopup = new TooltipPopup(this.f374a.getContext());
            this.h = tooltipPopup;
            tooltipPopup.e(this.f374a, this.f, this.g, this.i, this.b);
            this.f374a.addOnAttachStateChangeListener(this);
            if (this.i) {
                j2 = 2500;
            } else {
                if ((ViewCompat.O(this.f374a) & 1) == 1) {
                    longPressTimeout = (long) ViewConfiguration.getLongPressTimeout();
                    j3 = 3000;
                } else {
                    longPressTimeout = (long) ViewConfiguration.getLongPressTimeout();
                    j3 = 15000;
                }
                j2 = j3 - longPressTimeout;
            }
            this.f374a.removeCallbacks(this.e);
            this.f374a.postDelayed(this.e, j2);
        }
    }

    public final boolean g(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (!this.j && Math.abs(x - this.f) <= this.c && Math.abs(y - this.g) <= this.c) {
            return false;
        }
        this.f = x;
        this.g = y;
        this.j = false;
        return true;
    }

    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.h != null && this.i) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f374a.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                b();
                c();
            }
        } else if (this.f374a.isEnabled() && this.h == null && g(motionEvent)) {
            e(this);
        }
        return false;
    }

    public boolean onLongClick(View view) {
        this.f = view.getWidth() / 2;
        this.g = view.getHeight() / 2;
        f(true);
        return true;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        c();
    }
}
