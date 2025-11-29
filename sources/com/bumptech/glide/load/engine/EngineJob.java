package com.bumptech.glide.load.engine;

import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.EngineResource;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

class EngineJob<R> implements DecodeJob.Callback<R>, FactoryPools.Poolable {
    public static final EngineResourceFactory z = new EngineResourceFactory();

    /* renamed from: a  reason: collision with root package name */
    public final ResourceCallbacksAndExecutors f2489a;
    public final StateVerifier b;
    public final EngineResource.ResourceListener c;
    public final Pools.Pool d;
    public final EngineResourceFactory e;
    public final EngineJobListener f;
    public final GlideExecutor g;
    public final GlideExecutor h;
    public final GlideExecutor i;
    public final GlideExecutor j;
    public final AtomicInteger k;
    public Key l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public Resource q;
    public DataSource r;
    public boolean s;
    public GlideException t;
    public boolean u;
    public EngineResource v;
    public DecodeJob w;
    public volatile boolean x;
    public boolean y;

    public class CallLoadFailed implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final ResourceCallback f2490a;

        public CallLoadFailed(ResourceCallback resourceCallback) {
            this.f2490a = resourceCallback;
        }

        public void run() {
            synchronized (this.f2490a.h()) {
                synchronized (EngineJob.this) {
                    try {
                        if (EngineJob.this.f2489a.b(this.f2490a)) {
                            EngineJob.this.e(this.f2490a);
                        }
                        EngineJob.this.i();
                    } catch (Throwable th) {
                        while (true) {
                            throw th;
                        }
                    }
                }
            }
        }
    }

    public class CallResourceReady implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final ResourceCallback f2491a;

        public CallResourceReady(ResourceCallback resourceCallback) {
            this.f2491a = resourceCallback;
        }

        public void run() {
            synchronized (this.f2491a.h()) {
                synchronized (EngineJob.this) {
                    try {
                        if (EngineJob.this.f2489a.b(this.f2491a)) {
                            EngineJob.this.v.d();
                            EngineJob.this.g(this.f2491a);
                            EngineJob.this.r(this.f2491a);
                        }
                        EngineJob.this.i();
                    } catch (Throwable th) {
                        while (true) {
                            throw th;
                        }
                    }
                }
            }
        }
    }

    @VisibleForTesting
    public static class EngineResourceFactory {
        public EngineResource a(Resource resource, boolean z, Key key, EngineResource.ResourceListener resourceListener) {
            return new EngineResource(resource, z, true, key, resourceListener);
        }
    }

    public static final class ResourceCallbackAndExecutor {

        /* renamed from: a  reason: collision with root package name */
        public final ResourceCallback f2492a;
        public final Executor b;

        public ResourceCallbackAndExecutor(ResourceCallback resourceCallback, Executor executor) {
            this.f2492a = resourceCallback;
            this.b = executor;
        }

        public boolean equals(Object obj) {
            if (obj instanceof ResourceCallbackAndExecutor) {
                return this.f2492a.equals(((ResourceCallbackAndExecutor) obj).f2492a);
            }
            return false;
        }

        public int hashCode() {
            return this.f2492a.hashCode();
        }
    }

    public static final class ResourceCallbacksAndExecutors implements Iterable<ResourceCallbackAndExecutor> {

        /* renamed from: a  reason: collision with root package name */
        public final List f2493a;

        public ResourceCallbacksAndExecutors() {
            this(new ArrayList(2));
        }

        public static ResourceCallbackAndExecutor d(ResourceCallback resourceCallback) {
            return new ResourceCallbackAndExecutor(resourceCallback, Executors.a());
        }

        public void a(ResourceCallback resourceCallback, Executor executor) {
            this.f2493a.add(new ResourceCallbackAndExecutor(resourceCallback, executor));
        }

        public boolean b(ResourceCallback resourceCallback) {
            return this.f2493a.contains(d(resourceCallback));
        }

        public ResourceCallbacksAndExecutors c() {
            return new ResourceCallbacksAndExecutors(new ArrayList(this.f2493a));
        }

        public void clear() {
            this.f2493a.clear();
        }

        public void e(ResourceCallback resourceCallback) {
            this.f2493a.remove(d(resourceCallback));
        }

        public boolean isEmpty() {
            return this.f2493a.isEmpty();
        }

        public Iterator iterator() {
            return this.f2493a.iterator();
        }

        public int size() {
            return this.f2493a.size();
        }

        public ResourceCallbacksAndExecutors(List list) {
            this.f2493a = list;
        }
    }

    public EngineJob(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener, EngineResource.ResourceListener resourceListener, Pools.Pool pool) {
        this(glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, engineJobListener, resourceListener, pool, z);
    }

    private synchronized void q() {
        if (this.l != null) {
            this.f2489a.clear();
            this.l = null;
            this.v = null;
            this.q = null;
            this.u = false;
            this.x = false;
            this.s = false;
            this.y = false;
            this.w.z(false);
            this.w = null;
            this.t = null;
            this.r = null;
            this.d.a(this);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public synchronized void a(ResourceCallback resourceCallback, Executor executor) {
        try {
            this.b.c();
            this.f2489a.a(resourceCallback, executor);
            if (this.s) {
                k(1);
                executor.execute(new CallResourceReady(resourceCallback));
            } else if (this.u) {
                k(1);
                executor.execute(new CallLoadFailed(resourceCallback));
            } else {
                Preconditions.a(!this.x, "Cannot add callbacks to a cancelled EngineJob");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void b(GlideException glideException) {
        synchronized (this) {
            this.t = glideException;
        }
        n();
    }

    public void c(Resource resource, DataSource dataSource, boolean z2) {
        synchronized (this) {
            this.q = resource;
            this.r = dataSource;
            this.y = z2;
        }
        o();
    }

    public void d(DecodeJob decodeJob) {
        j().execute(decodeJob);
    }

    public void e(ResourceCallback resourceCallback) {
        try {
            resourceCallback.b(this.t);
        } catch (Throwable th) {
            throw new CallbackException(th);
        }
    }

    public StateVerifier f() {
        return this.b;
    }

    public void g(ResourceCallback resourceCallback) {
        try {
            resourceCallback.c(this.v, this.r, this.y);
        } catch (Throwable th) {
            throw new CallbackException(th);
        }
    }

    public void h() {
        if (!m()) {
            this.x = true;
            this.w.h();
            this.f.b(this, this.l);
        }
    }

    public void i() {
        EngineResource engineResource;
        synchronized (this) {
            try {
                this.b.c();
                Preconditions.a(m(), "Not yet complete!");
                int decrementAndGet = this.k.decrementAndGet();
                Preconditions.a(decrementAndGet >= 0, "Can't decrement below 0");
                if (decrementAndGet == 0) {
                    engineResource = this.v;
                    q();
                } else {
                    engineResource = null;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (engineResource != null) {
            engineResource.g();
        }
    }

    public final GlideExecutor j() {
        return this.n ? this.i : this.o ? this.j : this.h;
    }

    public synchronized void k(int i2) {
        EngineResource engineResource;
        Preconditions.a(m(), "Not yet complete!");
        if (this.k.getAndAdd(i2) == 0 && (engineResource = this.v) != null) {
            engineResource.d();
        }
    }

    public synchronized EngineJob l(Key key, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.l = key;
        this.m = z2;
        this.n = z3;
        this.o = z4;
        this.p = z5;
        return this;
    }

    public final boolean m() {
        return this.u || this.s || this.x;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0031, code lost:
        r4.f.a(r4, r1, (com.bumptech.glide.load.engine.EngineResource) null);
        r0 = r2.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003f, code lost:
        if (r0.hasNext() == false) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0041, code lost:
        r1 = (com.bumptech.glide.load.engine.EngineJob.ResourceCallbackAndExecutor) r0.next();
        r1.b.execute(new com.bumptech.glide.load.engine.EngineJob.CallLoadFailed(r4, r1.f2492a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0054, code lost:
        i();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0057, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void n() {
        /*
            r4 = this;
            monitor-enter(r4)
            com.bumptech.glide.util.pool.StateVerifier r0 = r4.b     // Catch:{ all -> 0x000f }
            r0.c()     // Catch:{ all -> 0x000f }
            boolean r0 = r4.x     // Catch:{ all -> 0x000f }
            if (r0 == 0) goto L_0x0011
            r4.q()     // Catch:{ all -> 0x000f }
            monitor-exit(r4)     // Catch:{ all -> 0x000f }
            return
        L_0x000f:
            r0 = move-exception
            goto L_0x0068
        L_0x0011:
            com.bumptech.glide.load.engine.EngineJob$ResourceCallbacksAndExecutors r0 = r4.f2489a     // Catch:{ all -> 0x000f }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x000f }
            if (r0 != 0) goto L_0x0060
            boolean r0 = r4.u     // Catch:{ all -> 0x000f }
            if (r0 != 0) goto L_0x0058
            r0 = 1
            r4.u = r0     // Catch:{ all -> 0x000f }
            com.bumptech.glide.load.Key r1 = r4.l     // Catch:{ all -> 0x000f }
            com.bumptech.glide.load.engine.EngineJob$ResourceCallbacksAndExecutors r2 = r4.f2489a     // Catch:{ all -> 0x000f }
            com.bumptech.glide.load.engine.EngineJob$ResourceCallbacksAndExecutors r2 = r2.c()     // Catch:{ all -> 0x000f }
            int r3 = r2.size()     // Catch:{ all -> 0x000f }
            int r3 = r3 + r0
            r4.k(r3)     // Catch:{ all -> 0x000f }
            monitor-exit(r4)     // Catch:{ all -> 0x000f }
            com.bumptech.glide.load.engine.EngineJobListener r0 = r4.f
            r3 = 0
            r0.a(r4, r1, r3)
            java.util.Iterator r0 = r2.iterator()
        L_0x003b:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0054
            java.lang.Object r1 = r0.next()
            com.bumptech.glide.load.engine.EngineJob$ResourceCallbackAndExecutor r1 = (com.bumptech.glide.load.engine.EngineJob.ResourceCallbackAndExecutor) r1
            java.util.concurrent.Executor r2 = r1.b
            com.bumptech.glide.load.engine.EngineJob$CallLoadFailed r3 = new com.bumptech.glide.load.engine.EngineJob$CallLoadFailed
            com.bumptech.glide.request.ResourceCallback r1 = r1.f2492a
            r3.<init>(r1)
            r2.execute(r3)
            goto L_0x003b
        L_0x0054:
            r4.i()
            return
        L_0x0058:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x000f }
            java.lang.String r1 = "Already failed once"
            r0.<init>(r1)     // Catch:{ all -> 0x000f }
            throw r0     // Catch:{ all -> 0x000f }
        L_0x0060:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x000f }
            java.lang.String r1 = "Received an exception without any callbacks to notify"
            r0.<init>(r1)     // Catch:{ all -> 0x000f }
            throw r0     // Catch:{ all -> 0x000f }
        L_0x0068:
            monitor-exit(r4)     // Catch:{ all -> 0x000f }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.EngineJob.n():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0048, code lost:
        r5.f.a(r5, r0, r2);
        r0 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0055, code lost:
        if (r0.hasNext() == false) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0057, code lost:
        r1 = (com.bumptech.glide.load.engine.EngineJob.ResourceCallbackAndExecutor) r0.next();
        r1.b.execute(new com.bumptech.glide.load.engine.EngineJob.CallResourceReady(r5, r1.f2492a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006a, code lost:
        i();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void o() {
        /*
            r5 = this;
            monitor-enter(r5)
            com.bumptech.glide.util.pool.StateVerifier r0 = r5.b     // Catch:{ all -> 0x0014 }
            r0.c()     // Catch:{ all -> 0x0014 }
            boolean r0 = r5.x     // Catch:{ all -> 0x0014 }
            if (r0 == 0) goto L_0x0016
            com.bumptech.glide.load.engine.Resource r0 = r5.q     // Catch:{ all -> 0x0014 }
            r0.a()     // Catch:{ all -> 0x0014 }
            r5.q()     // Catch:{ all -> 0x0014 }
            monitor-exit(r5)     // Catch:{ all -> 0x0014 }
            return
        L_0x0014:
            r0 = move-exception
            goto L_0x007e
        L_0x0016:
            com.bumptech.glide.load.engine.EngineJob$ResourceCallbacksAndExecutors r0 = r5.f2489a     // Catch:{ all -> 0x0014 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0014 }
            if (r0 != 0) goto L_0x0076
            boolean r0 = r5.s     // Catch:{ all -> 0x0014 }
            if (r0 != 0) goto L_0x006e
            com.bumptech.glide.load.engine.EngineJob$EngineResourceFactory r0 = r5.e     // Catch:{ all -> 0x0014 }
            com.bumptech.glide.load.engine.Resource r1 = r5.q     // Catch:{ all -> 0x0014 }
            boolean r2 = r5.m     // Catch:{ all -> 0x0014 }
            com.bumptech.glide.load.Key r3 = r5.l     // Catch:{ all -> 0x0014 }
            com.bumptech.glide.load.engine.EngineResource$ResourceListener r4 = r5.c     // Catch:{ all -> 0x0014 }
            com.bumptech.glide.load.engine.EngineResource r0 = r0.a(r1, r2, r3, r4)     // Catch:{ all -> 0x0014 }
            r5.v = r0     // Catch:{ all -> 0x0014 }
            r0 = 1
            r5.s = r0     // Catch:{ all -> 0x0014 }
            com.bumptech.glide.load.engine.EngineJob$ResourceCallbacksAndExecutors r1 = r5.f2489a     // Catch:{ all -> 0x0014 }
            com.bumptech.glide.load.engine.EngineJob$ResourceCallbacksAndExecutors r1 = r1.c()     // Catch:{ all -> 0x0014 }
            int r2 = r1.size()     // Catch:{ all -> 0x0014 }
            int r2 = r2 + r0
            r5.k(r2)     // Catch:{ all -> 0x0014 }
            com.bumptech.glide.load.Key r0 = r5.l     // Catch:{ all -> 0x0014 }
            com.bumptech.glide.load.engine.EngineResource r2 = r5.v     // Catch:{ all -> 0x0014 }
            monitor-exit(r5)     // Catch:{ all -> 0x0014 }
            com.bumptech.glide.load.engine.EngineJobListener r3 = r5.f
            r3.a(r5, r0, r2)
            java.util.Iterator r0 = r1.iterator()
        L_0x0051:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x006a
            java.lang.Object r1 = r0.next()
            com.bumptech.glide.load.engine.EngineJob$ResourceCallbackAndExecutor r1 = (com.bumptech.glide.load.engine.EngineJob.ResourceCallbackAndExecutor) r1
            java.util.concurrent.Executor r2 = r1.b
            com.bumptech.glide.load.engine.EngineJob$CallResourceReady r3 = new com.bumptech.glide.load.engine.EngineJob$CallResourceReady
            com.bumptech.glide.request.ResourceCallback r1 = r1.f2492a
            r3.<init>(r1)
            r2.execute(r3)
            goto L_0x0051
        L_0x006a:
            r5.i()
            return
        L_0x006e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0014 }
            java.lang.String r1 = "Already have resource"
            r0.<init>(r1)     // Catch:{ all -> 0x0014 }
            throw r0     // Catch:{ all -> 0x0014 }
        L_0x0076:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0014 }
            java.lang.String r1 = "Received a resource without any callbacks to notify"
            r0.<init>(r1)     // Catch:{ all -> 0x0014 }
            throw r0     // Catch:{ all -> 0x0014 }
        L_0x007e:
            monitor-exit(r5)     // Catch:{ all -> 0x0014 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.EngineJob.o():void");
    }

    public boolean p() {
        return this.p;
    }

    public synchronized void r(ResourceCallback resourceCallback) {
        try {
            this.b.c();
            this.f2489a.e(resourceCallback);
            if (this.f2489a.isEmpty()) {
                h();
                if (!this.s) {
                    if (this.u) {
                    }
                }
                if (this.k.get() == 0) {
                    q();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void s(DecodeJob decodeJob) {
        try {
            this.w = decodeJob;
            (decodeJob.G() ? this.g : j()).execute(decodeJob);
        } catch (Throwable th) {
            throw th;
        }
    }

    public EngineJob(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener, EngineResource.ResourceListener resourceListener, Pools.Pool pool, EngineResourceFactory engineResourceFactory) {
        this.f2489a = new ResourceCallbacksAndExecutors();
        this.b = StateVerifier.a();
        this.k = new AtomicInteger();
        this.g = glideExecutor;
        this.h = glideExecutor2;
        this.i = glideExecutor3;
        this.j = glideExecutor4;
        this.f = engineJobListener;
        this.c = resourceListener;
        this.d = pool;
        this.e = engineResourceFactory;
    }
}
