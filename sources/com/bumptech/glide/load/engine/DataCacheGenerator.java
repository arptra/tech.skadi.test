package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.pool.GlideTrace;
import java.io.File;
import java.util.List;

class DataCacheGenerator implements DataFetcherGenerator, DataFetcher.DataCallback<Object> {

    /* renamed from: a  reason: collision with root package name */
    public final List f2472a;
    public final DecodeHelper b;
    public final DataFetcherGenerator.FetcherReadyCallback c;
    public int d;
    public Key e;
    public List f;
    public int g;
    public volatile ModelLoader.LoadData h;
    public File i;

    public DataCacheGenerator(DecodeHelper decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this(decodeHelper.c(), decodeHelper, fetcherReadyCallback);
    }

    private boolean b() {
        return this.g < this.f.size();
    }

    public boolean a() {
        GlideTrace.a("DataCacheGenerator.startNext");
        while (true) {
            try {
                boolean z = false;
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
                if (i3 >= this.f2472a.size()) {
                    return false;
                }
                Key key = (Key) this.f2472a.get(this.d);
                File b2 = this.b.d().b(new DataCacheKey(key, this.b.p()));
                this.i = b2;
                if (b2 != null) {
                    this.e = key;
                    this.f = this.b.j(b2);
                    this.g = 0;
                }
            } finally {
                GlideTrace.e();
            }
        }
    }

    public void cancel() {
        ModelLoader.LoadData loadData = this.h;
        if (loadData != null) {
            loadData.c.cancel();
        }
    }

    public void e(Object obj) {
        this.c.g(this.e, obj, this.h.c, DataSource.DATA_DISK_CACHE, this.e);
    }

    public void f(Exception exc) {
        this.c.b(this.e, exc, this.h.c, DataSource.DATA_DISK_CACHE);
    }

    public DataCacheGenerator(List list, DecodeHelper decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.d = -1;
        this.f2472a = list;
        this.b = decodeHelper;
        this.c = fetcherReadyCallback;
    }
}
