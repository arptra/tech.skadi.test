package com.bumptech.glide;

import android.graphics.drawable.Drawable;
import android.widget.AbsListView;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import java.util.List;
import java.util.Queue;

public class ListPreloader<T> implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    public final int f2422a;
    public final PreloadTargetQueue b;
    public final RequestManager c;
    public final PreloadModelProvider d;
    public final PreloadSizeProvider e;
    public int f;
    public int g;
    public int h;
    public int i;
    public boolean j;

    public interface PreloadModelProvider<U> {
        List a(int i);

        RequestBuilder b(Object obj);
    }

    public interface PreloadSizeProvider<T> {
        int[] a(Object obj, int i, int i2);
    }

    public static final class PreloadTarget implements Target<Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f2423a;
        public int b;
        public Request c;

        public void a(SizeReadyCallback sizeReadyCallback) {
        }

        public Request c() {
            return this.c;
        }

        public void d(Drawable drawable) {
        }

        public void e(Object obj, Transition transition) {
        }

        public void g(Drawable drawable) {
        }

        public void h(Request request) {
            this.c = request;
        }

        public void i(Drawable drawable) {
        }

        public void j(SizeReadyCallback sizeReadyCallback) {
            sizeReadyCallback.d(this.b, this.f2423a);
        }

        public void onDestroy() {
        }

        public void onStart() {
        }

        public void onStop() {
        }
    }

    public static final class PreloadTargetQueue {

        /* renamed from: a  reason: collision with root package name */
        public final Queue f2424a;

        public PreloadTarget a(int i, int i2) {
            PreloadTarget preloadTarget = (PreloadTarget) this.f2424a.poll();
            this.f2424a.offer(preloadTarget);
            preloadTarget.b = i;
            preloadTarget.f2423a = i2;
            return preloadTarget;
        }
    }

    public final void a() {
        for (int i2 = 0; i2 < this.b.f2424a.size(); i2++) {
            this.c.l(this.b.a(0, 0));
        }
    }

    public final void b(int i2, int i3) {
        int i4;
        int i5;
        if (i2 < i3) {
            i4 = Math.max(this.f, i2);
            i5 = i3;
        } else {
            i5 = Math.min(this.g, i2);
            i4 = i3;
        }
        int min = Math.min(this.i, i5);
        int min2 = Math.min(this.i, Math.max(0, i4));
        if (i2 < i3) {
            for (int i6 = min2; i6 < min; i6++) {
                d(this.d.a(i6), i6, true);
            }
        } else {
            for (int i7 = min - 1; i7 >= min2; i7--) {
                d(this.d.a(i7), i7, false);
            }
        }
        this.g = min2;
        this.f = min;
    }

    public final void c(int i2, boolean z) {
        if (this.j != z) {
            this.j = z;
            a();
        }
        b(i2, (z ? this.f2422a : -this.f2422a) + i2);
    }

    public final void d(List list, int i2, boolean z) {
        int size = list.size();
        if (z) {
            for (int i3 = 0; i3 < size; i3++) {
                e(list.get(i3), i2, i3);
            }
            return;
        }
        for (int i4 = size - 1; i4 >= 0; i4--) {
            e(list.get(i4), i2, i4);
        }
    }

    public final void e(Object obj, int i2, int i3) {
        int[] a2;
        RequestBuilder b2;
        if (obj != null && (a2 = this.e.a(obj, i2, i3)) != null && (b2 = this.d.b(obj)) != null) {
            b2.w0(this.b.a(a2[0], a2[1]));
        }
    }

    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        if (this.i != 0 || i4 != 0) {
            this.i = i4;
            int i5 = this.h;
            if (i2 > i5) {
                c(i3 + i2, true);
            } else if (i2 < i5) {
                c(i2, false);
            }
            this.h = i2;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i2) {
    }
}
