package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.EngineResource;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskCacheAdapter;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import java.util.Map;
import java.util.concurrent.Executor;

public class Engine implements EngineJobListener, MemoryCache.ResourceRemovedListener, EngineResource.ResourceListener {
    public static final boolean i = Log.isLoggable("Engine", 2);

    /* renamed from: a  reason: collision with root package name */
    public final Jobs f2482a;
    public final EngineKeyFactory b;
    public final MemoryCache c;
    public final EngineJobFactory d;
    public final ResourceRecycler e;
    public final LazyDiskCacheProvider f;
    public final DecodeJobFactory g;
    public final ActiveResources h;

    @VisibleForTesting
    public static class DecodeJobFactory {

        /* renamed from: a  reason: collision with root package name */
        public final DecodeJob.DiskCacheProvider f2483a;
        public final Pools.Pool b = FactoryPools.d(150, new FactoryPools.Factory<DecodeJob<?>>() {
            /* renamed from: a */
            public DecodeJob create() {
                DecodeJobFactory decodeJobFactory = DecodeJobFactory.this;
                return new DecodeJob(decodeJobFactory.f2483a, decodeJobFactory.b);
            }
        });
        public int c;

        public DecodeJobFactory(DecodeJob.DiskCacheProvider diskCacheProvider) {
            this.f2483a = diskCacheProvider;
        }

        public DecodeJob a(GlideContext glideContext, Object obj, EngineKey engineKey, Key key, int i, int i2, Class cls, Class cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map map, boolean z, boolean z2, boolean z3, Options options, DecodeJob.Callback callback) {
            DecodeJob decodeJob = (DecodeJob) Preconditions.d((DecodeJob) this.b.acquire());
            int i3 = this.c;
            int i4 = i3;
            this.c = i3 + 1;
            return decodeJob.q(glideContext, obj, engineKey, key, i, i2, cls, cls2, priority, diskCacheStrategy, map, z, z2, z3, options, callback, i4);
        }
    }

    @VisibleForTesting
    public static class EngineJobFactory {

        /* renamed from: a  reason: collision with root package name */
        public final GlideExecutor f2485a;
        public final GlideExecutor b;
        public final GlideExecutor c;
        public final GlideExecutor d;
        public final EngineJobListener e;
        public final EngineResource.ResourceListener f;
        public final Pools.Pool g = FactoryPools.d(150, new FactoryPools.Factory<EngineJob<?>>() {
            /* renamed from: a */
            public EngineJob create() {
                EngineJobFactory engineJobFactory = EngineJobFactory.this;
                return new EngineJob(engineJobFactory.f2485a, engineJobFactory.b, engineJobFactory.c, engineJobFactory.d, engineJobFactory.e, engineJobFactory.f, engineJobFactory.g);
            }
        });

        public EngineJobFactory(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener, EngineResource.ResourceListener resourceListener) {
            this.f2485a = glideExecutor;
            this.b = glideExecutor2;
            this.c = glideExecutor3;
            this.d = glideExecutor4;
            this.e = engineJobListener;
            this.f = resourceListener;
        }

        public EngineJob a(Key key, boolean z, boolean z2, boolean z3, boolean z4) {
            return ((EngineJob) Preconditions.d((EngineJob) this.g.acquire())).l(key, z, z2, z3, z4);
        }
    }

    public static class LazyDiskCacheProvider implements DecodeJob.DiskCacheProvider {

        /* renamed from: a  reason: collision with root package name */
        public final DiskCache.Factory f2487a;
        public volatile DiskCache b;

        public LazyDiskCacheProvider(DiskCache.Factory factory) {
            this.f2487a = factory;
        }

        public DiskCache a() {
            if (this.b == null) {
                synchronized (this) {
                    try {
                        if (this.b == null) {
                            this.b = this.f2487a.build();
                        }
                        if (this.b == null) {
                            this.b = new DiskCacheAdapter();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return this.b;
        }
    }

    public class LoadStatus {

        /* renamed from: a  reason: collision with root package name */
        public final EngineJob f2488a;
        public final ResourceCallback b;

        public LoadStatus(ResourceCallback resourceCallback, EngineJob engineJob) {
            this.b = resourceCallback;
            this.f2488a = engineJob;
        }

        public void a() {
            synchronized (Engine.this) {
                this.f2488a.r(this.b);
            }
        }
    }

    public Engine(MemoryCache memoryCache, DiskCache.Factory factory, GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, boolean z) {
        this(memoryCache, factory, glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, (Jobs) null, (EngineKeyFactory) null, (ActiveResources) null, (EngineJobFactory) null, (DecodeJobFactory) null, (ResourceRecycler) null, z);
    }

    public static void j(String str, long j, Key key) {
        Log.v("Engine", str + " in " + LogTime.a(j) + "ms, key: " + key);
    }

    public synchronized void a(EngineJob engineJob, Key key, EngineResource engineResource) {
        if (engineResource != null) {
            try {
                if (engineResource.f()) {
                    this.h.a(key, engineResource);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f2482a.d(key, engineJob);
    }

    public synchronized void b(EngineJob engineJob, Key key) {
        this.f2482a.d(key, engineJob);
    }

    public void c(Key key, EngineResource engineResource) {
        this.h.d(key);
        if (engineResource.f()) {
            this.c.d(key, engineResource);
        } else {
            this.e.a(engineResource, false);
        }
    }

    public void d(Resource resource) {
        this.e.a(resource, true);
    }

    public final EngineResource e(Key key) {
        Resource e2 = this.c.e(key);
        if (e2 == null) {
            return null;
        }
        return e2 instanceof EngineResource ? (EngineResource) e2 : new EngineResource(e2, true, true, key, this);
    }

    public LoadStatus f(GlideContext glideContext, Object obj, Key key, int i2, int i3, Class cls, Class cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map map, boolean z, boolean z2, Options options, boolean z3, boolean z4, boolean z5, boolean z6, ResourceCallback resourceCallback, Executor executor) {
        long b2 = i ? LogTime.b() : 0;
        EngineKey a2 = this.b.a(obj, key, i2, i3, map, cls, cls2, options);
        synchronized (this) {
            try {
                EngineResource i4 = i(a2, z3, b2);
                if (i4 == null) {
                    LoadStatus l = l(glideContext, obj, key, i2, i3, cls, cls2, priority, diskCacheStrategy, map, z, z2, options, z3, z4, z5, z6, resourceCallback, executor, a2, b2);
                    return l;
                }
                resourceCallback.c(i4, DataSource.MEMORY_CACHE, false);
                return null;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public final EngineResource g(Key key) {
        EngineResource e2 = this.h.e(key);
        if (e2 != null) {
            e2.d();
        }
        return e2;
    }

    public final EngineResource h(Key key) {
        EngineResource e2 = e(key);
        if (e2 != null) {
            e2.d();
            this.h.a(key, e2);
        }
        return e2;
    }

    public final EngineResource i(EngineKey engineKey, boolean z, long j) {
        if (!z) {
            return null;
        }
        EngineResource g2 = g(engineKey);
        if (g2 != null) {
            if (i) {
                j("Loaded resource from active resources", j, engineKey);
            }
            return g2;
        }
        EngineResource h2 = h(engineKey);
        if (h2 == null) {
            return null;
        }
        if (i) {
            j("Loaded resource from cache", j, engineKey);
        }
        return h2;
    }

    public void k(Resource resource) {
        if (resource instanceof EngineResource) {
            ((EngineResource) resource).g();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    public final LoadStatus l(GlideContext glideContext, Object obj, Key key, int i2, int i3, Class cls, Class cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map map, boolean z, boolean z2, Options options, boolean z3, boolean z4, boolean z5, boolean z6, ResourceCallback resourceCallback, Executor executor, EngineKey engineKey, long j) {
        ResourceCallback resourceCallback2 = resourceCallback;
        Executor executor2 = executor;
        EngineKey engineKey2 = engineKey;
        long j2 = j;
        EngineJob a2 = this.f2482a.a(engineKey2, z6);
        if (a2 != null) {
            a2.a(resourceCallback2, executor2);
            if (i) {
                j("Added to existing load", j2, engineKey2);
            }
            return new LoadStatus(resourceCallback2, a2);
        }
        EngineJob a3 = this.d.a(engineKey, z3, z4, z5, z6);
        EngineJob engineJob = a3;
        EngineKey engineKey3 = engineKey2;
        DecodeJob a4 = this.g.a(glideContext, obj, engineKey, key, i2, i3, cls, cls2, priority, diskCacheStrategy, map, z, z2, z6, options, a3);
        this.f2482a.c(engineKey3, engineJob);
        EngineJob engineJob2 = engineJob;
        EngineKey engineKey4 = engineKey3;
        ResourceCallback resourceCallback3 = resourceCallback;
        engineJob2.a(resourceCallback3, executor);
        engineJob2.s(a4);
        if (i) {
            j("Started new load", j, engineKey4);
        }
        return new LoadStatus(resourceCallback3, engineJob2);
    }

    public Engine(MemoryCache memoryCache, DiskCache.Factory factory, GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, Jobs jobs, EngineKeyFactory engineKeyFactory, ActiveResources activeResources, EngineJobFactory engineJobFactory, DecodeJobFactory decodeJobFactory, ResourceRecycler resourceRecycler, boolean z) {
        this.c = memoryCache;
        DiskCache.Factory factory2 = factory;
        LazyDiskCacheProvider lazyDiskCacheProvider = new LazyDiskCacheProvider(factory);
        this.f = lazyDiskCacheProvider;
        ActiveResources activeResources2 = activeResources == null ? new ActiveResources(z) : activeResources;
        this.h = activeResources2;
        activeResources2.f(this);
        this.b = engineKeyFactory == null ? new EngineKeyFactory() : engineKeyFactory;
        this.f2482a = jobs == null ? new Jobs() : jobs;
        this.d = engineJobFactory == null ? new EngineJobFactory(glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, this, this) : engineJobFactory;
        this.g = decodeJobFactory == null ? new DecodeJobFactory(lazyDiskCacheProvider) : decodeJobFactory;
        this.e = resourceRecycler == null ? new ResourceRecycler() : resourceRecycler;
        memoryCache.f(this);
    }
}
