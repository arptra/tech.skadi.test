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

@Deprecated
public abstract class ViewTarget<T extends View, Z> extends BaseTarget<Z> {
    public static boolean g;
    public static int h = R.id.glide_custom_view_target_tag;
    public final View b;
    public final SizeDeterminer c;
    public View.OnAttachStateChangeListener d;
    public boolean e;
    public boolean f;

    /* renamed from: com.bumptech.glide.request.target.ViewTarget$1  reason: invalid class name */
    class AnonymousClass1 implements View.OnAttachStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewTarget f2720a;

        public void onViewAttachedToWindow(View view) {
            this.f2720a.o();
        }

        public void onViewDetachedFromWindow(View view) {
            this.f2720a.n();
        }
    }

    @VisibleForTesting
    public static final class SizeDeterminer {
        public static Integer e;

        /* renamed from: a  reason: collision with root package name */
        public final View f2721a;
        public final List b = new ArrayList();
        public boolean c;
        public SizeDeterminerLayoutListener d;

        public static final class SizeDeterminerLayoutListener implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: a  reason: collision with root package name */
            public final WeakReference f2722a;

            public SizeDeterminerLayoutListener(SizeDeterminer sizeDeterminer) {
                this.f2722a = new WeakReference(sizeDeterminer);
            }

            public boolean onPreDraw() {
                if (Log.isLoggable("ViewTarget", 2)) {
                    Log.v("ViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                SizeDeterminer sizeDeterminer = (SizeDeterminer) this.f2722a.get();
                if (sizeDeterminer == null) {
                    return true;
                }
                sizeDeterminer.a();
                return true;
            }
        }

        public SizeDeterminer(View view) {
            this.f2721a = view;
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
            ViewTreeObserver viewTreeObserver = this.f2721a.getViewTreeObserver();
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
                ViewTreeObserver viewTreeObserver = this.f2721a.getViewTreeObserver();
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
            if (this.c && this.f2721a.isLayoutRequested()) {
                return 0;
            }
            int i5 = i - i3;
            if (i5 > 0) {
                return i5;
            }
            if (this.f2721a.isLayoutRequested() || i2 != -2) {
                return 0;
            }
            if (Log.isLoggable("ViewTarget", 4)) {
                Log.i("ViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return c(this.f2721a.getContext());
        }

        public final int f() {
            int paddingTop = this.f2721a.getPaddingTop() + this.f2721a.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f2721a.getLayoutParams();
            return e(this.f2721a.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        public final int g() {
            int paddingLeft = this.f2721a.getPaddingLeft() + this.f2721a.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f2721a.getLayoutParams();
            return e(this.f2721a.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
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

    public ViewTarget(View view) {
        this.b = (View) Preconditions.d(view);
        this.c = new SizeDeterminer(view);
    }

    public void a(SizeReadyCallback sizeReadyCallback) {
        this.c.k(sizeReadyCallback);
    }

    public Request c() {
        Object k = k();
        if (k == null) {
            return null;
        }
        if (k instanceof Request) {
            return (Request) k;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    public void d(Drawable drawable) {
        super.d(drawable);
        this.c.b();
        if (!this.e) {
            m();
        }
    }

    public void g(Drawable drawable) {
        super.g(drawable);
        l();
    }

    public View getView() {
        return this.b;
    }

    public void h(Request request) {
        p(request);
    }

    public void j(SizeReadyCallback sizeReadyCallback) {
        this.c.d(sizeReadyCallback);
    }

    public final Object k() {
        return this.b.getTag(h);
    }

    public final void l() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.d;
        if (onAttachStateChangeListener != null && !this.f) {
            this.b.addOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f = true;
        }
    }

    public final void m() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.d;
        if (onAttachStateChangeListener != null && this.f) {
            this.b.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f = false;
        }
    }

    public void n() {
        Request c2 = c();
        if (c2 != null) {
            this.e = true;
            c2.clear();
            this.e = false;
        }
    }

    public void o() {
        Request c2 = c();
        if (c2 != null && c2.e()) {
            c2.i();
        }
    }

    public final void p(Object obj) {
        g = true;
        this.b.setTag(h, obj);
    }

    public String toString() {
        return "Target for: " + this.b;
    }
}
