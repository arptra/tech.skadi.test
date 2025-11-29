package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.manager.TargetTracker;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class RequestManager implements ComponentCallbacks2, LifecycleListener, ModelTypes<RequestBuilder<Drawable>> {
    public static final RequestOptions m = ((RequestOptions) RequestOptions.n0(Bitmap.class).O());
    public static final RequestOptions n = ((RequestOptions) RequestOptions.n0(GifDrawable.class).O());
    public static final RequestOptions o = ((RequestOptions) ((RequestOptions) RequestOptions.o0(DiskCacheStrategy.c).W(Priority.LOW)).f0(true));

    /* renamed from: a  reason: collision with root package name */
    public final Glide f2428a;
    public final Context b;
    public final Lifecycle c;
    public final RequestTracker d;
    public final RequestManagerTreeNode e;
    public final TargetTracker f;
    public final Runnable g;
    public final ConnectivityMonitor h;
    public final CopyOnWriteArrayList i;
    public RequestOptions j;
    public boolean k;
    public boolean l;

    public static class ClearTarget extends CustomViewTarget<View, Object> {
        public void e(Object obj, Transition transition) {
        }

        public void i(Drawable drawable) {
        }

        public void l(Drawable drawable) {
        }
    }

    public class RequestManagerConnectivityListener implements ConnectivityMonitor.ConnectivityListener {

        /* renamed from: a  reason: collision with root package name */
        public final RequestTracker f2430a;

        public RequestManagerConnectivityListener(RequestTracker requestTracker) {
            this.f2430a = requestTracker;
        }

        public void a(boolean z) {
            if (z) {
                synchronized (RequestManager.this) {
                    this.f2430a.e();
                }
            }
        }
    }

    public RequestManager(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, Context context) {
        this(glide, lifecycle, requestManagerTreeNode, new RequestTracker(), glide.g(), context);
    }

    public final void A(Target target) {
        boolean z = z(target);
        Request c2 = target.c();
        if (!z && !this.f2428a.p(target) && c2 != null) {
            target.h((Request) null);
            c2.clear();
        }
    }

    public RequestBuilder b(Class cls) {
        return new RequestBuilder(this.f2428a, this, cls, this.b);
    }

    public RequestBuilder f() {
        return b(Bitmap.class).b(m);
    }

    public RequestBuilder k() {
        return b(Drawable.class);
    }

    public void l(Target target) {
        if (target != null) {
            A(target);
        }
    }

    public final synchronized void m() {
        try {
            for (Target l2 : this.f.f()) {
                l(l2);
            }
            this.f.b();
        } catch (Throwable th) {
            throw th;
        }
    }

    public List n() {
        return this.i;
    }

    public synchronized RequestOptions o() {
        return this.j;
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public synchronized void onDestroy() {
        this.f.onDestroy();
        m();
        this.d.b();
        this.c.a(this);
        this.c.a(this.h);
        Util.x(this.g);
        this.f2428a.s(this);
    }

    public void onLowMemory() {
    }

    public synchronized void onStart() {
        w();
        this.f.onStart();
    }

    public synchronized void onStop() {
        try {
            this.f.onStop();
            if (this.l) {
                m();
            } else {
                v();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void onTrimMemory(int i2) {
        if (i2 == 60 && this.k) {
            u();
        }
    }

    public TransitionOptions p(Class cls) {
        return this.f2428a.i().e(cls);
    }

    public RequestBuilder q(Uri uri) {
        return k().B0(uri);
    }

    public RequestBuilder r(Object obj) {
        return k().C0(obj);
    }

    public RequestBuilder s(String str) {
        return k().D0(str);
    }

    public synchronized void t() {
        this.d.c();
    }

    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.d + ", treeNode=" + this.e + "}";
    }

    public synchronized void u() {
        t();
        for (RequestManager t : this.e.a()) {
            t.t();
        }
    }

    public synchronized void v() {
        this.d.d();
    }

    public synchronized void w() {
        this.d.f();
    }

    public synchronized void x(RequestOptions requestOptions) {
        this.j = (RequestOptions) ((RequestOptions) requestOptions.clone()).c();
    }

    public synchronized void y(Target target, Request request) {
        this.f.k(target);
        this.d.g(request);
    }

    public synchronized boolean z(Target target) {
        Request c2 = target.c();
        if (c2 == null) {
            return true;
        }
        if (!this.d.a(c2)) {
            return false;
        }
        this.f.l(target);
        target.h((Request) null);
        return true;
    }

    public RequestManager(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, RequestTracker requestTracker, ConnectivityMonitorFactory connectivityMonitorFactory, Context context) {
        this.f = new TargetTracker();
        AnonymousClass1 r0 = new Runnable() {
            public void run() {
                RequestManager requestManager = RequestManager.this;
                requestManager.c.b(requestManager);
            }
        };
        this.g = r0;
        this.f2428a = glide;
        this.c = lifecycle;
        this.e = requestManagerTreeNode;
        this.d = requestTracker;
        this.b = context;
        ConnectivityMonitor a2 = connectivityMonitorFactory.a(context.getApplicationContext(), new RequestManagerConnectivityListener(requestTracker));
        this.h = a2;
        glide.o(this);
        if (Util.s()) {
            Util.w(r0);
        } else {
            lifecycle.b(this);
        }
        lifecycle.b(a2);
        this.i = new CopyOnWriteArrayList(glide.i().c());
        x(glide.i().d());
    }
}
