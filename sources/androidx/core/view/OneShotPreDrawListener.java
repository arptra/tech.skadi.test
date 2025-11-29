package androidx.core.view;

import android.view.View;
import android.view.ViewTreeObserver;

public final class OneShotPreDrawListener implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final View f879a;
    public ViewTreeObserver b;
    public final Runnable c;

    public OneShotPreDrawListener(View view, Runnable runnable) {
        this.f879a = view;
        this.b = view.getViewTreeObserver();
        this.c = runnable;
    }

    public static OneShotPreDrawListener a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        } else if (runnable != null) {
            OneShotPreDrawListener oneShotPreDrawListener = new OneShotPreDrawListener(view, runnable);
            view.getViewTreeObserver().addOnPreDrawListener(oneShotPreDrawListener);
            view.addOnAttachStateChangeListener(oneShotPreDrawListener);
            return oneShotPreDrawListener;
        } else {
            throw new NullPointerException("runnable == null");
        }
    }

    public void b() {
        if (this.b.isAlive()) {
            this.b.removeOnPreDrawListener(this);
        } else {
            this.f879a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f879a.removeOnAttachStateChangeListener(this);
    }

    public boolean onPreDraw() {
        b();
        this.c.run();
        return true;
    }

    public void onViewAttachedToWindow(View view) {
        this.b = view.getViewTreeObserver();
    }

    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
