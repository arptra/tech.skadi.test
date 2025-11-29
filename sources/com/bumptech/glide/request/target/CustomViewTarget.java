package com.bumptech.glide.request.target;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.R;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Preconditions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class CustomViewTarget<T extends View, Z> implements Target<Z> {
    public static final int f = R.id.glide_custom_view_target_tag;

    /* renamed from: a  reason: collision with root package name */
    public final SizeDeterminer f2714a;
    public final View b;
    public View.OnAttachStateChangeListener c;
    public boolean d;
    public boolean e;

    /* renamed from: com.bumptech.glide.request.target.CustomViewTarget$1  reason: invalid class name */
    class AnonymousClass1 implements View.OnAttachStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CustomViewTarget f2715a;

        public void onViewAttachedToWindow(View view) {
            this.f2715a.o();
        }

        public void onViewDetachedFromWindow(View view) {
            this.f2715a.n();
        }
    }

    @VisibleForTesting
    public static final class SizeDeterminer {
        public static Integer e;

        /* renamed from: a  reason: collision with root package name */
        public final View f2716a;
        public final List b;
        public boolean c;
        public SizeDeterminerLayoutListener d;

        public static final class SizeDeterminerLayoutListener implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: a  reason: collision with root package name */
            public final WeakReference f2717a;

            public SizeDeterminerLayoutListener(SizeDeterminer sizeDeterminer) {
                this.f2717a = new WeakReference(sizeDeterminer);
            }

            public boolean onPreDraw() {
                if (Log.isLoggable("CustomViewTarget", 2)) {
                    Log.v("CustomViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                SizeDeterminer sizeDeterminer = (SizeDeterminer) this.f2717a.get();
                if (sizeDeterminer == null) {
                    return true;
                }
                sizeDeterminer.a();
                return true;
            }
        }

        public static int c(Context context) {
            if (e == null) {
                Display defaultDisplay = ((WindowManager) Preconditions.d((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                e = Integer.valueOf(Math.max(point.x, point.y));
            }
            return e.intValue();
        }

        public void a() {
            if (!this.b.isEmpty()) {
                int g = g();
                int f = f();
                if (i(g, f)) {
                    j(g, f);
                    b();
                }
            }
        }

        public void b() {
            ViewTreeObserver viewTreeObserver = this.f2716a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.d);
            }
            this.d = null;
            this.b.clear();
        }

        public void d(SizeReadyCallback sizeReadyCallback) {
            int g = g();
            int f = f();
            if (i(g, f)) {
                sizeReadyCallback.d(g, f);
                return;
            }
            if (!this.b.contains(sizeReadyCallback)) {
                this.b.add(sizeReadyCallback);
            }
            if (this.d == null) {
                ViewTreeObserver viewTreeObserver = this.f2716a.getViewTreeObserver();
                SizeDeterminerLayoutListener sizeDeterminerLayoutListener = new SizeDeterminerLayoutListener(this);
                this.d = sizeDeterminerLayoutListener;
                viewTreeObserver.addOnPreDrawListener(sizeDeterminerLayoutListener);
            }
        }

        public final int e(int i, int i2, int i3) {
            int i4 = i2 - i3;
            if (i4 > 0) {
                return i4;
            }
            if (this.c && this.f2716a.isLayoutRequested()) {
                return 0;
            }
            int i5 = i - i3;
            if (i5 > 0) {
                return i5;
            }
            if (this.f2716a.isLayoutRequested() || i2 != -2) {
                return 0;
            }
            if (Log.isLoggable("CustomViewTarget", 4)) {
                Log.i("CustomViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return c(this.f2716a.getContext());
        }

        public final int f() {
            int paddingTop = this.f2716a.getPaddingTop() + this.f2716a.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f2716a.getLayoutParams();
            return e(this.f2716a.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        public final int g() {
            int paddingLeft = this.f2716a.getPaddingLeft() + this.f2716a.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f2716a.getLayoutParams();
            return e(this.f2716a.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        public final boolean h(int i) {
            return i > 0 || i == Integer.MIN_VALUE;
        }

        public final boolean i(int i, int i2) {
            return h(i) && h(i2);
        }

        public final void j(int i, int i2) {
            Iterator it = new ArrayList(this.b).iterator();
            while (it.hasNext()) {
                ((SizeReadyCallback) it.next()).d(i, i2);
            }
        }

        public void k(SizeReadyCallback sizeReadyCallback) {
            this.b.remove(sizeReadyCallback);
        }
    }

    private Object b() {
        return this.b.getTag(f);
    }

    private void f() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.c;
        if (onAttachStateChangeListener != null && !this.e) {
            this.b.addOnAttachStateChangeListener(onAttachStateChangeListener);
            this.e = true;
        }
    }

    private void k() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.c;
        if (onAttachStateChangeListener != null && this.e) {
            this.b.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            this.e = false;
        }
    }

    private void p(Object obj) {
        this.b.setTag(f, obj);
    }

    public final void a(SizeReadyCallback sizeReadyCallback) {
        this.f2714a.k(sizeReadyCallback);
    }

    public final Request c() {
        Object b2 = b();
        if (b2 == null) {
            return null;
        }
        if (b2 instanceof Request) {
            return (Request) b2;
        }
        throw new IllegalArgumentException("You must not pass non-R.id ids to setTag(id)");
    }

    public final void d(Drawable drawable) {
        this.f2714a.b();
        l(drawable);
        if (!this.d) {
            k();
        }
    }

    public final void g(Drawable drawable) {
        f();
        m(drawable);
    }

    public final void h(Request request) {
        p(request);
    }

    public final void j(SizeReadyCallback sizeReadyCallback) {
        this.f2714a.d(sizeReadyCallback);
    }

    public abstract void l(Drawable drawable);

    public void m(Drawable drawable) {
    }

    public final void n() {
        Request c2 = c();
        if (c2 != null) {
            this.d = true;
            c2.clear();
            this.d = false;
        }
    }

    public final void o() {
        Request c2 = c();
        if (c2 != null && c2.e()) {
            c2.i();
        }
    }

    public void onDestroy() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public String toString() {
        return "Target for: " + this.b;
    }
}
