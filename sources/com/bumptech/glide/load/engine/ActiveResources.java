package com.bumptech.glide.load.engine;

import android.os.Process;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.EngineResource;
import com.bumptech.glide.util.Preconditions;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

final class ActiveResources {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f2468a;
    public final Executor b;
    public final Map c;
    public final ReferenceQueue d;
    public EngineResource.ResourceListener e;
    public volatile boolean f;
    public volatile DequeuedResourceCallback g;

    @VisibleForTesting
    public interface DequeuedResourceCallback {
        void a();
    }

    @VisibleForTesting
    public static final class ResourceWeakReference extends WeakReference<EngineResource<?>> {

        /* renamed from: a  reason: collision with root package name */
        public final Key f2471a;
        public final boolean b;
        public Resource c;

        public ResourceWeakReference(Key key, EngineResource engineResource, ReferenceQueue referenceQueue, boolean z) {
            super(engineResource, referenceQueue);
            this.f2471a = (Key) Preconditions.d(key);
            this.c = (!engineResource.f() || !z) ? null : (Resource) Preconditions.d(engineResource.e());
            this.b = engineResource.f();
        }

        public void a() {
            this.c = null;
            clear();
        }
    }

    public ActiveResources(boolean z) {
        this(z, Executors.newSingleThreadExecutor(new ThreadFactory() {
            public Thread newThread(final Runnable runnable) {
                return new Thread(new Runnable() {
                    public void run() {
                        Process.setThreadPriority(10);
                        runnable.run();
                    }
                }, "glide-active-resources");
            }
        }));
    }

    public synchronized void a(Key key, EngineResource engineResource) {
        ResourceWeakReference resourceWeakReference = (ResourceWeakReference) this.c.put(key, new ResourceWeakReference(key, engineResource, this.d, this.f2468a));
        if (resourceWeakReference != null) {
            resourceWeakReference.a();
        }
    }

    public void b() {
        while (!this.f) {
            try {
                c((ResourceWeakReference) this.d.remove());
                DequeuedResourceCallback dequeuedResourceCallback = this.g;
                if (dequeuedResourceCallback != null) {
                    dequeuedResourceCallback.a();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void c(ResourceWeakReference resourceWeakReference) {
        synchronized (this) {
            this.c.remove(resourceWeakReference.f2471a);
            if (resourceWeakReference.b) {
                Resource resource = resourceWeakReference.c;
                if (resource != null) {
                    this.e.c(resourceWeakReference.f2471a, new EngineResource(resource, true, false, resourceWeakReference.f2471a, this.e));
                }
            }
        }
    }

    public synchronized void d(Key key) {
        ResourceWeakReference resourceWeakReference = (ResourceWeakReference) this.c.remove(key);
        if (resourceWeakReference != null) {
            resourceWeakReference.a();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001d, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.bumptech.glide.load.engine.EngineResource e(com.bumptech.glide.load.Key r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.util.Map r0 = r1.c     // Catch:{ all -> 0x001a }
            java.lang.Object r2 = r0.get(r2)     // Catch:{ all -> 0x001a }
            com.bumptech.glide.load.engine.ActiveResources$ResourceWeakReference r2 = (com.bumptech.glide.load.engine.ActiveResources.ResourceWeakReference) r2     // Catch:{ all -> 0x001a }
            if (r2 != 0) goto L_0x000e
            monitor-exit(r1)
            r1 = 0
            return r1
        L_0x000e:
            java.lang.Object r0 = r2.get()     // Catch:{ all -> 0x001a }
            com.bumptech.glide.load.engine.EngineResource r0 = (com.bumptech.glide.load.engine.EngineResource) r0     // Catch:{ all -> 0x001a }
            if (r0 != 0) goto L_0x001c
            r1.c(r2)     // Catch:{ all -> 0x001a }
            goto L_0x001c
        L_0x001a:
            r2 = move-exception
            goto L_0x001e
        L_0x001c:
            monitor-exit(r1)
            return r0
        L_0x001e:
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.ActiveResources.e(com.bumptech.glide.load.Key):com.bumptech.glide.load.engine.EngineResource");
    }

    public void f(EngineResource.ResourceListener resourceListener) {
        synchronized (resourceListener) {
            synchronized (this) {
                this.e = resourceListener;
            }
        }
    }

    public ActiveResources(boolean z, Executor executor) {
        this.c = new HashMap();
        this.d = new ReferenceQueue();
        this.f2468a = z;
        this.b = executor;
        executor.execute(new Runnable() {
            public void run() {
                ActiveResources.this.b();
            }
        });
    }
}
