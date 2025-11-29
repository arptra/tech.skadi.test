package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.pool.GlideTrace;
import java.io.File;
import java.util.List;

class ResourceCacheGenerator implements DataFetcherGenerator, DataFetcher.DataCallback<Object> {

    /* renamed from: a  reason: collision with root package name */
    public final DataFetcherGenerator.FetcherReadyCallback f2499a;
    public final DecodeHelper b;
    public int c;
    public int d = -1;
    public Key e;
    public List f;
    public int g;
    public volatile ModelLoader.LoadData h;
    public File i;
    public ResourceCacheKey j;

    public ResourceCacheGenerator(DecodeHelper decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.b = decodeHelper;
        this.f2499a = fetcherReadyCallback;
    }

    private boolean b() {
        return this.g < this.f.size();
    }

    public boolean a() {
        GlideTrace.a("ResourceCacheGenerator.startNext");
        try {
            List c2 = this.b.c();
            boolean z = false;
            if (c2.isEmpty()) {
                GlideTrace.e();
                return false;
            }
            List m = this.b.m();
            if (!m.isEmpty()) {
                while (true) {
                    if (this.f != null) {
                        if (b()) {
                            this.h = null;
                            while (!z && b()) {
                                List list = this.f;
                                int i2 = this.g;
                                this.g = i2 + 1;
                                this.h = ((ModelLoader) list.get(i2)).a(this.i, this.b.t(), this.b.f(), this.b.k());
                                if (this.h != null && this.b.u(this.h.c.a())) {
                                    this.h.c.d(this.b.l(), this);
                                    z = true;
                                }
                            }
                            GlideTrace.e();
                            return z;
                        }
                    }
                    int i3 = this.d + 1;
                    this.d = i3;
                    if (i3 >= m.size()) {
                        int i4 = this.c + 1;
                        this.c = i4;
                        if (i4 >= c2.size()) {
                            GlideTrace.e();
                            return false;
                        }
                        this.d = 0;
                    }
                    Key key = (Key) c2.get(this.c);
                    Class cls = (Class) m.get(this.d);
                    this.j = new ResourceCacheKey(this.b.b(), key, this.b.p(), this.b.t(), this.b.f(), this.b.s(cls), cls, this.b.k());
                    File b2 = this.b.d().b(this.j);
                    this.i = b2;
                    if (b2 != null) {
                        this.e = key;
                        this.f = this.b.j(b2);
                        this.g = 0;
                    }
                }
            } else if (File.class.equals(this.b.r())) {
                GlideTrace.e();
                return false;
            } else {
                throw new IllegalStateException("Failed to find any load path from " + this.b.i() + " to " + this.b.r());
            }
        } catch (Throwable th) {
            GlideTrace.e();
            throw th;
        }
    }

    public void cancel() {
        ModelLoader.LoadData loadData = this.h;
        if (loadData != null) {
            loadData.c.cancel();
        }
    }

    public void e(Object obj) {
        this.f2499a.g(this.e, obj, this.h.c, DataSource.RESOURCE_DISK_CACHE, this.j);
    }

    public void f(Exception exc) {
        this.f2499a.b(this.j, exc, this.h.c, DataSource.RESOURCE_DISK_CACHE);
    }
}
