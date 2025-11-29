package com.bumptech.glide.request;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.drawable.DrawableDecoderCompat;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.GlideTrace;
import com.bumptech.glide.util.pool.StateVerifier;
import com.geetest.sdk.x;
import java.util.List;
import java.util.concurrent.Executor;

public final class SingleRequest<R> implements Request, SizeReadyCallback, ResourceCallback {
    public static final boolean E = Log.isLoggable("GlideRequest", 2);
    public int A;
    public int B;
    public boolean C;
    public RuntimeException D;

    /* renamed from: a  reason: collision with root package name */
    public int f2710a;
    public final String b;
    public final StateVerifier c;
    public final Object d;
    public final RequestListener e;
    public final RequestCoordinator f;
    public final Context g;
    public final GlideContext h;
    public final Object i;
    public final Class j;
    public final BaseRequestOptions k;
    public final int l;
    public final int m;
    public final Priority n;
    public final Target o;
    public final List p;
    public final TransitionFactory q;
    public final Executor r;
    public Resource s;
    public Engine.LoadStatus t;
    public long u;
    public volatile Engine v;
    public Status w;
    public Drawable x;
    public Drawable y;
    public Drawable z;

    public enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    public SingleRequest(Context context, GlideContext glideContext, Object obj, Object obj2, Class cls, BaseRequestOptions baseRequestOptions, int i2, int i3, Priority priority, Target target, RequestListener requestListener, List list, RequestCoordinator requestCoordinator, Engine engine, TransitionFactory transitionFactory, Executor executor) {
        this.b = E ? String.valueOf(super.hashCode()) : null;
        this.c = StateVerifier.a();
        this.d = obj;
        this.g = context;
        this.h = glideContext;
        this.i = obj2;
        this.j = cls;
        this.k = baseRequestOptions;
        this.l = i2;
        this.m = i3;
        this.n = priority;
        this.o = target;
        this.e = requestListener;
        this.p = list;
        this.f = requestCoordinator;
        this.v = engine;
        this.q = transitionFactory;
        this.r = executor;
        this.w = Status.PENDING;
        if (this.D == null && glideContext.g().a(GlideBuilder.LogRequestOrigins.class)) {
            this.D = new RuntimeException("Glide request origin trace");
        }
    }

    public static int v(int i2, float f2) {
        return i2 == Integer.MIN_VALUE ? i2 : Math.round(f2 * ((float) i2));
    }

    public static SingleRequest y(Context context, GlideContext glideContext, Object obj, Object obj2, Class cls, BaseRequestOptions baseRequestOptions, int i2, int i3, Priority priority, Target target, RequestListener requestListener, List list, RequestCoordinator requestCoordinator, Engine engine, TransitionFactory transitionFactory, Executor executor) {
        return new SingleRequest(context, glideContext, obj, obj2, cls, baseRequestOptions, i2, i3, priority, target, requestListener, list, requestCoordinator, engine, transitionFactory, executor);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00d3 A[Catch:{ all -> 0x00b5 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void A(com.bumptech.glide.load.engine.Resource r16, java.lang.Object r17, com.bumptech.glide.load.DataSource r18, boolean r19) {
        /*
            r15 = this;
            r1 = r15
            r0 = r18
            boolean r9 = r15.s()
            com.bumptech.glide.request.SingleRequest$Status r2 = com.bumptech.glide.request.SingleRequest.Status.COMPLETE
            r1.w = r2
            r2 = r16
            r1.s = r2
            com.bumptech.glide.GlideContext r2 = r1.h
            int r2 = r2.h()
            r3 = 3
            if (r2 > r3) goto L_0x006f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Finished loading "
            r2.append(r3)
            java.lang.Class r3 = r17.getClass()
            java.lang.String r3 = r3.getSimpleName()
            r2.append(r3)
            java.lang.String r3 = " from "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r3 = " for "
            r2.append(r3)
            java.lang.Object r3 = r1.i
            r2.append(r3)
            java.lang.String r3 = " with size ["
            r2.append(r3)
            int r3 = r1.A
            r2.append(r3)
            java.lang.String r3 = "x"
            r2.append(r3)
            int r3 = r1.B
            r2.append(r3)
            java.lang.String r3 = "] in "
            r2.append(r3)
            long r3 = r1.u
            double r3 = com.bumptech.glide.util.LogTime.a(r3)
            r2.append(r3)
            java.lang.String r3 = " ms"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "Glide"
            android.util.Log.d(r3, r2)
        L_0x006f:
            r15.x()
            r10 = 1
            r1.C = r10
            r11 = 0
            java.util.List r2 = r1.p     // Catch:{ all -> 0x00b5 }
            if (r2 == 0) goto L_0x00b9
            java.util.Iterator r12 = r2.iterator()     // Catch:{ all -> 0x00b5 }
            r8 = r11
        L_0x007f:
            boolean r2 = r12.hasNext()     // Catch:{ all -> 0x00b5 }
            if (r2 == 0) goto L_0x00ba
            java.lang.Object r2 = r12.next()     // Catch:{ all -> 0x00b5 }
            r13 = r2
            com.bumptech.glide.request.RequestListener r13 = (com.bumptech.glide.request.RequestListener) r13     // Catch:{ all -> 0x00b5 }
            java.lang.Object r4 = r1.i     // Catch:{ all -> 0x00b5 }
            com.bumptech.glide.request.target.Target r5 = r1.o     // Catch:{ all -> 0x00b5 }
            r2 = r13
            r3 = r17
            r6 = r18
            r7 = r9
            boolean r2 = r2.f(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x00b5 }
            r14 = r8 | r2
            boolean r2 = r13 instanceof com.bumptech.glide.request.ExperimentalRequestListener     // Catch:{ all -> 0x00b5 }
            if (r2 == 0) goto L_0x00b7
            r2 = r13
            com.bumptech.glide.request.ExperimentalRequestListener r2 = (com.bumptech.glide.request.ExperimentalRequestListener) r2     // Catch:{ all -> 0x00b5 }
            java.lang.Object r4 = r1.i     // Catch:{ all -> 0x00b5 }
            com.bumptech.glide.request.target.Target r5 = r1.o     // Catch:{ all -> 0x00b5 }
            r3 = r17
            r6 = r18
            r7 = r9
            r8 = r19
            boolean r2 = r2.c(r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x00b5 }
            r2 = r2 | r14
            r8 = r2
            goto L_0x007f
        L_0x00b5:
            r0 = move-exception
            goto L_0x00ea
        L_0x00b7:
            r8 = r14
            goto L_0x007f
        L_0x00b9:
            r8 = r11
        L_0x00ba:
            com.bumptech.glide.request.RequestListener r2 = r1.e     // Catch:{ all -> 0x00b5 }
            if (r2 == 0) goto L_0x00ce
            java.lang.Object r4 = r1.i     // Catch:{ all -> 0x00b5 }
            com.bumptech.glide.request.target.Target r5 = r1.o     // Catch:{ all -> 0x00b5 }
            r3 = r17
            r6 = r18
            r7 = r9
            boolean r2 = r2.f(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x00b5 }
            if (r2 == 0) goto L_0x00ce
            goto L_0x00cf
        L_0x00ce:
            r10 = r11
        L_0x00cf:
            r2 = r8 | r10
            if (r2 != 0) goto L_0x00e0
            com.bumptech.glide.request.transition.TransitionFactory r2 = r1.q     // Catch:{ all -> 0x00b5 }
            com.bumptech.glide.request.transition.Transition r0 = r2.a(r0, r9)     // Catch:{ all -> 0x00b5 }
            com.bumptech.glide.request.target.Target r2 = r1.o     // Catch:{ all -> 0x00b5 }
            r3 = r17
            r2.e(r3, r0)     // Catch:{ all -> 0x00b5 }
        L_0x00e0:
            r1.C = r11
            java.lang.String r0 = "GlideRequest"
            int r1 = r1.f2710a
            com.bumptech.glide.util.pool.GlideTrace.f(r0, r1)
            return
        L_0x00ea:
            r1.C = r11
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.A(com.bumptech.glide.load.engine.Resource, java.lang.Object, com.bumptech.glide.load.DataSource, boolean):void");
    }

    public final void B() {
        if (l()) {
            Drawable q2 = this.i == null ? q() : null;
            if (q2 == null) {
                q2 = p();
            }
            if (q2 == null) {
                q2 = r();
            }
            this.o.i(q2);
        }
    }

    public boolean a() {
        boolean z2;
        synchronized (this.d) {
            z2 = this.w == Status.COMPLETE;
        }
        return z2;
    }

    public void b(GlideException glideException) {
        z(glideException, 5);
    }

    public void c(Resource resource, DataSource dataSource, boolean z2) {
        this.c.c();
        Resource resource2 = null;
        try {
            synchronized (this.d) {
                try {
                    this.t = null;
                    if (resource == null) {
                        b(new GlideException("Expected to receive a Resource<R> with an object of " + this.j + " inside, but instead got null."));
                        return;
                    }
                    Object obj = resource.get();
                    if (obj != null) {
                        if (this.j.isAssignableFrom(obj.getClass())) {
                            if (!m()) {
                                try {
                                    this.s = null;
                                    this.w = Status.COMPLETE;
                                    GlideTrace.f("GlideRequest", this.f2710a);
                                    this.v.k(resource);
                                    return;
                                } catch (Throwable th) {
                                    resource2 = resource;
                                    th = th;
                                    throw th;
                                }
                            } else {
                                A(resource, obj, dataSource, z2);
                                return;
                            }
                        }
                    }
                    this.s = null;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Expected to receive an object of ");
                    sb.append(this.j);
                    sb.append(" but instead got ");
                    sb.append(obj != null ? obj.getClass() : "");
                    sb.append("{");
                    sb.append(obj);
                    sb.append("} inside Resource{");
                    sb.append(resource);
                    sb.append("}.");
                    sb.append(obj != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
                    b(new GlideException(sb.toString()));
                    this.v.k(resource);
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            }
        } catch (Throwable th3) {
            if (resource2 != null) {
                this.v.k(resource2);
            }
            throw th3;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003a, code lost:
        if (r1 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003c, code lost:
        r5.v.k(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void clear() {
        /*
            r5 = this;
            java.lang.Object r0 = r5.d
            monitor-enter(r0)
            r5.j()     // Catch:{ all -> 0x0013 }
            com.bumptech.glide.util.pool.StateVerifier r1 = r5.c     // Catch:{ all -> 0x0013 }
            r1.c()     // Catch:{ all -> 0x0013 }
            com.bumptech.glide.request.SingleRequest$Status r1 = r5.w     // Catch:{ all -> 0x0013 }
            com.bumptech.glide.request.SingleRequest$Status r2 = com.bumptech.glide.request.SingleRequest.Status.CLEARED     // Catch:{ all -> 0x0013 }
            if (r1 != r2) goto L_0x0015
            monitor-exit(r0)     // Catch:{ all -> 0x0013 }
            return
        L_0x0013:
            r5 = move-exception
            goto L_0x0042
        L_0x0015:
            r5.n()     // Catch:{ all -> 0x0013 }
            com.bumptech.glide.load.engine.Resource r1 = r5.s     // Catch:{ all -> 0x0013 }
            r3 = 0
            if (r1 == 0) goto L_0x0020
            r5.s = r3     // Catch:{ all -> 0x0013 }
            goto L_0x0021
        L_0x0020:
            r1 = r3
        L_0x0021:
            boolean r3 = r5.k()     // Catch:{ all -> 0x0013 }
            if (r3 == 0) goto L_0x0030
            com.bumptech.glide.request.target.Target r3 = r5.o     // Catch:{ all -> 0x0013 }
            android.graphics.drawable.Drawable r4 = r5.r()     // Catch:{ all -> 0x0013 }
            r3.d(r4)     // Catch:{ all -> 0x0013 }
        L_0x0030:
            java.lang.String r3 = "GlideRequest"
            int r4 = r5.f2710a     // Catch:{ all -> 0x0013 }
            com.bumptech.glide.util.pool.GlideTrace.f(r3, r4)     // Catch:{ all -> 0x0013 }
            r5.w = r2     // Catch:{ all -> 0x0013 }
            monitor-exit(r0)     // Catch:{ all -> 0x0013 }
            if (r1 == 0) goto L_0x0041
            com.bumptech.glide.load.engine.Engine r5 = r5.v
            r5.k(r1)
        L_0x0041:
            return
        L_0x0042:
            monitor-exit(r0)     // Catch:{ all -> 0x0013 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.clear():void");
    }

    public void d(int i2, int i3) {
        Object obj;
        this.c.c();
        Object obj2 = this.d;
        synchronized (obj2) {
            try {
                boolean z2 = E;
                if (z2) {
                    u("Got onSizeReady in " + LogTime.a(this.u));
                }
                if (this.w == Status.WAITING_FOR_SIZE) {
                    Status status = Status.RUNNING;
                    this.w = status;
                    float y2 = this.k.y();
                    this.A = v(i2, y2);
                    this.B = v(i3, y2);
                    if (z2) {
                        u("finished setup for calling load in " + LogTime.a(this.u));
                    }
                    Status status2 = status;
                    Status status3 = status2;
                    obj = obj2;
                    try {
                        this.t = this.v.f(this.h, this.i, this.k.x(), this.A, this.B, this.k.w(), this.j, this.n, this.k.k(), this.k.A(), this.k.L(), this.k.H(), this.k.q(), this.k.F(), this.k.C(), this.k.B(), this.k.p(), this, this.r);
                        if (this.w != status3) {
                            this.t = null;
                        }
                        if (z2) {
                            u("finished onSizeReady in " + LogTime.a(this.u));
                        }
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                obj = obj2;
                throw th;
            }
        }
    }

    public boolean e() {
        boolean z2;
        synchronized (this.d) {
            z2 = this.w == Status.CLEARED;
        }
        return z2;
    }

    public boolean f() {
        boolean z2;
        synchronized (this.d) {
            z2 = this.w == Status.COMPLETE;
        }
        return z2;
    }

    public boolean g(Request request) {
        int i2;
        int i3;
        Object obj;
        Class cls;
        BaseRequestOptions baseRequestOptions;
        Priority priority;
        int size;
        int i4;
        int i5;
        Object obj2;
        Class cls2;
        BaseRequestOptions baseRequestOptions2;
        Priority priority2;
        int size2;
        if (!(request instanceof SingleRequest)) {
            return false;
        }
        synchronized (this.d) {
            try {
                i2 = this.l;
                i3 = this.m;
                obj = this.i;
                cls = this.j;
                baseRequestOptions = this.k;
                priority = this.n;
                List list = this.p;
                size = list != null ? list.size() : 0;
            } finally {
                while (true) {
                }
            }
        }
        SingleRequest singleRequest = (SingleRequest) request;
        synchronized (singleRequest.d) {
            try {
                i4 = singleRequest.l;
                i5 = singleRequest.m;
                obj2 = singleRequest.i;
                cls2 = singleRequest.j;
                baseRequestOptions2 = singleRequest.k;
                priority2 = singleRequest.n;
                List list2 = singleRequest.p;
                size2 = list2 != null ? list2.size() : 0;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return i2 == i4 && i3 == i5 && Util.d(obj, obj2) && cls.equals(cls2) && Util.c(baseRequestOptions, baseRequestOptions2) && priority == priority2 && size == size2;
    }

    public Object h() {
        this.c.c();
        return this.d;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ae, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void i() {
        /*
            r5 = this;
            java.lang.Object r0 = r5.d
            monitor-enter(r0)
            r5.j()     // Catch:{ all -> 0x0028 }
            com.bumptech.glide.util.pool.StateVerifier r1 = r5.c     // Catch:{ all -> 0x0028 }
            r1.c()     // Catch:{ all -> 0x0028 }
            long r1 = com.bumptech.glide.util.LogTime.b()     // Catch:{ all -> 0x0028 }
            r5.u = r1     // Catch:{ all -> 0x0028 }
            java.lang.Object r1 = r5.i     // Catch:{ all -> 0x0028 }
            if (r1 != 0) goto L_0x0040
            int r1 = r5.l     // Catch:{ all -> 0x0028 }
            int r2 = r5.m     // Catch:{ all -> 0x0028 }
            boolean r1 = com.bumptech.glide.util.Util.v(r1, r2)     // Catch:{ all -> 0x0028 }
            if (r1 == 0) goto L_0x002b
            int r1 = r5.l     // Catch:{ all -> 0x0028 }
            r5.A = r1     // Catch:{ all -> 0x0028 }
            int r1 = r5.m     // Catch:{ all -> 0x0028 }
            r5.B = r1     // Catch:{ all -> 0x0028 }
            goto L_0x002b
        L_0x0028:
            r5 = move-exception
            goto L_0x00b7
        L_0x002b:
            android.graphics.drawable.Drawable r1 = r5.q()     // Catch:{ all -> 0x0028 }
            if (r1 != 0) goto L_0x0033
            r1 = 5
            goto L_0x0034
        L_0x0033:
            r1 = 3
        L_0x0034:
            com.bumptech.glide.load.engine.GlideException r2 = new com.bumptech.glide.load.engine.GlideException     // Catch:{ all -> 0x0028 }
            java.lang.String r3 = "Received null model"
            r2.<init>(r3)     // Catch:{ all -> 0x0028 }
            r5.z(r2, r1)     // Catch:{ all -> 0x0028 }
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            return
        L_0x0040:
            com.bumptech.glide.request.SingleRequest$Status r2 = r5.w     // Catch:{ all -> 0x0028 }
            com.bumptech.glide.request.SingleRequest$Status r3 = com.bumptech.glide.request.SingleRequest.Status.RUNNING     // Catch:{ all -> 0x0028 }
            if (r2 == r3) goto L_0x00af
            com.bumptech.glide.request.SingleRequest$Status r4 = com.bumptech.glide.request.SingleRequest.Status.COMPLETE     // Catch:{ all -> 0x0028 }
            if (r2 != r4) goto L_0x0054
            com.bumptech.glide.load.engine.Resource r1 = r5.s     // Catch:{ all -> 0x0028 }
            com.bumptech.glide.load.DataSource r2 = com.bumptech.glide.load.DataSource.MEMORY_CACHE     // Catch:{ all -> 0x0028 }
            r3 = 0
            r5.c(r1, r2, r3)     // Catch:{ all -> 0x0028 }
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            return
        L_0x0054:
            r5.o(r1)     // Catch:{ all -> 0x0028 }
            java.lang.String r1 = "GlideRequest"
            int r1 = com.bumptech.glide.util.pool.GlideTrace.b(r1)     // Catch:{ all -> 0x0028 }
            r5.f2710a = r1     // Catch:{ all -> 0x0028 }
            com.bumptech.glide.request.SingleRequest$Status r1 = com.bumptech.glide.request.SingleRequest.Status.WAITING_FOR_SIZE     // Catch:{ all -> 0x0028 }
            r5.w = r1     // Catch:{ all -> 0x0028 }
            int r2 = r5.l     // Catch:{ all -> 0x0028 }
            int r4 = r5.m     // Catch:{ all -> 0x0028 }
            boolean r2 = com.bumptech.glide.util.Util.v(r2, r4)     // Catch:{ all -> 0x0028 }
            if (r2 == 0) goto L_0x0075
            int r2 = r5.l     // Catch:{ all -> 0x0028 }
            int r4 = r5.m     // Catch:{ all -> 0x0028 }
            r5.d(r2, r4)     // Catch:{ all -> 0x0028 }
            goto L_0x007a
        L_0x0075:
            com.bumptech.glide.request.target.Target r2 = r5.o     // Catch:{ all -> 0x0028 }
            r2.j(r5)     // Catch:{ all -> 0x0028 }
        L_0x007a:
            com.bumptech.glide.request.SingleRequest$Status r2 = r5.w     // Catch:{ all -> 0x0028 }
            if (r2 == r3) goto L_0x0080
            if (r2 != r1) goto L_0x008f
        L_0x0080:
            boolean r1 = r5.l()     // Catch:{ all -> 0x0028 }
            if (r1 == 0) goto L_0x008f
            com.bumptech.glide.request.target.Target r1 = r5.o     // Catch:{ all -> 0x0028 }
            android.graphics.drawable.Drawable r2 = r5.r()     // Catch:{ all -> 0x0028 }
            r1.g(r2)     // Catch:{ all -> 0x0028 }
        L_0x008f:
            boolean r1 = E     // Catch:{ all -> 0x0028 }
            if (r1 == 0) goto L_0x00ad
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0028 }
            r1.<init>()     // Catch:{ all -> 0x0028 }
            java.lang.String r2 = "finished run method in "
            r1.append(r2)     // Catch:{ all -> 0x0028 }
            long r2 = r5.u     // Catch:{ all -> 0x0028 }
            double r2 = com.bumptech.glide.util.LogTime.a(r2)     // Catch:{ all -> 0x0028 }
            r1.append(r2)     // Catch:{ all -> 0x0028 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0028 }
            r5.u(r1)     // Catch:{ all -> 0x0028 }
        L_0x00ad:
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            return
        L_0x00af:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0028 }
            java.lang.String r1 = "Cannot restart a running request"
            r5.<init>(r1)     // Catch:{ all -> 0x0028 }
            throw r5     // Catch:{ all -> 0x0028 }
        L_0x00b7:
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.i():void");
    }

    public boolean isRunning() {
        boolean z2;
        synchronized (this.d) {
            try {
                Status status = this.w;
                if (status != Status.RUNNING) {
                    if (status != Status.WAITING_FOR_SIZE) {
                        z2 = false;
                    }
                }
                z2 = true;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z2;
    }

    public final void j() {
        if (this.C) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    public final boolean k() {
        RequestCoordinator requestCoordinator = this.f;
        return requestCoordinator == null || requestCoordinator.j(this);
    }

    public final boolean l() {
        RequestCoordinator requestCoordinator = this.f;
        return requestCoordinator == null || requestCoordinator.c(this);
    }

    public final boolean m() {
        RequestCoordinator requestCoordinator = this.f;
        return requestCoordinator == null || requestCoordinator.d(this);
    }

    public final void n() {
        j();
        this.c.c();
        this.o.a(this);
        Engine.LoadStatus loadStatus = this.t;
        if (loadStatus != null) {
            loadStatus.a();
            this.t = null;
        }
    }

    public final void o(Object obj) {
        List<RequestListener> list = this.p;
        if (list != null) {
            for (RequestListener requestListener : list) {
                if (requestListener instanceof ExperimentalRequestListener) {
                    ((ExperimentalRequestListener) requestListener).a(obj);
                }
            }
        }
    }

    public final Drawable p() {
        if (this.x == null) {
            Drawable m2 = this.k.m();
            this.x = m2;
            if (m2 == null && this.k.l() > 0) {
                this.x = t(this.k.l());
            }
        }
        return this.x;
    }

    public void pause() {
        synchronized (this.d) {
            try {
                if (isRunning()) {
                    clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Drawable q() {
        if (this.z == null) {
            Drawable n2 = this.k.n();
            this.z = n2;
            if (n2 == null && this.k.o() > 0) {
                this.z = t(this.k.o());
            }
        }
        return this.z;
    }

    public final Drawable r() {
        if (this.y == null) {
            Drawable t2 = this.k.t();
            this.y = t2;
            if (t2 == null && this.k.u() > 0) {
                this.y = t(this.k.u());
            }
        }
        return this.y;
    }

    public final boolean s() {
        RequestCoordinator requestCoordinator = this.f;
        return requestCoordinator == null || !requestCoordinator.getRoot().a();
    }

    public final Drawable t(int i2) {
        return DrawableDecoderCompat.a(this.g, i2, this.k.z() != null ? this.k.z() : this.g.getTheme());
    }

    public String toString() {
        Object obj;
        Class cls;
        synchronized (this.d) {
            obj = this.i;
            cls = this.j;
        }
        return super.toString() + "[model=" + obj + ", transcodeClass=" + cls + "]";
    }

    public final void u(String str) {
        Log.v("GlideRequest", str + " this: " + this.b);
    }

    public final void w() {
        RequestCoordinator requestCoordinator = this.f;
        if (requestCoordinator != null) {
            requestCoordinator.h(this);
        }
    }

    public final void x() {
        RequestCoordinator requestCoordinator = this.f;
        if (requestCoordinator != null) {
            requestCoordinator.b(this);
        }
    }

    public final void z(GlideException glideException, int i2) {
        boolean z2;
        this.c.c();
        synchronized (this.d) {
            try {
                glideException.setOrigin(this.D);
                int h2 = this.h.h();
                if (h2 <= i2) {
                    Log.w("Glide", "Load failed for [" + this.i + "] with dimensions [" + this.A + x.f + this.B + "]", glideException);
                    if (h2 <= 4) {
                        glideException.logRootCauses("Glide");
                    }
                }
                this.t = null;
                this.w = Status.FAILED;
                w();
                boolean z3 = true;
                this.C = true;
                List<RequestListener> list = this.p;
                if (list != null) {
                    z2 = false;
                    for (RequestListener b2 : list) {
                        z2 |= b2.b(glideException, this.i, this.o, s());
                    }
                } else {
                    z2 = false;
                }
                RequestListener requestListener = this.e;
                if (requestListener == null || !requestListener.b(glideException, this.i, this.o, s())) {
                    z3 = false;
                }
                if (!z2 && !z3) {
                    B();
                }
                this.C = false;
                GlideTrace.f("GlideRequest", this.f2710a);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
