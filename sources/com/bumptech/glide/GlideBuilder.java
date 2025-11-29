package com.bumptech.glide;

import android.content.Context;
import androidx.collection.ArrayMap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideExperiments;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.request.RequestOptions;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class GlideBuilder {

    /* renamed from: a  reason: collision with root package name */
    public final Map f2416a = new ArrayMap();
    public final GlideExperiments.Builder b = new GlideExperiments.Builder();
    public Engine c;
    public BitmapPool d;
    public ArrayPool e;
    public MemoryCache f;
    public GlideExecutor g;
    public GlideExecutor h;
    public DiskCache.Factory i;
    public MemorySizeCalculator j;
    public ConnectivityMonitorFactory k;
    public int l = 4;
    public Glide.RequestOptionsFactory m = new Glide.RequestOptionsFactory() {
        public RequestOptions build() {
            return new RequestOptions();
        }
    };
    public RequestManagerRetriever.RequestManagerFactory n;
    public GlideExecutor o;
    public boolean p;
    public List q;

    /* renamed from: com.bumptech.glide.GlideBuilder$2  reason: invalid class name */
    class AnonymousClass2 implements Glide.RequestOptionsFactory {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RequestOptions f2418a;

        public RequestOptions build() {
            RequestOptions requestOptions = this.f2418a;
            return requestOptions != null ? requestOptions : new RequestOptions();
        }
    }

    public static final class EnableImageDecoderForBitmaps implements GlideExperiments.Experiment {
    }

    public static final class LogRequestOrigins implements GlideExperiments.Experiment {
    }

    public static final class ManualOverrideHardwareBitmapMaxFdCount implements GlideExperiments.Experiment {
    }

    public Glide a(Context context, List list, AppGlideModule appGlideModule) {
        Context context2 = context;
        if (this.g == null) {
            this.g = GlideExecutor.h();
        }
        if (this.h == null) {
            this.h = GlideExecutor.f();
        }
        if (this.o == null) {
            this.o = GlideExecutor.d();
        }
        if (this.j == null) {
            this.j = new MemorySizeCalculator.Builder(context2).a();
        }
        if (this.k == null) {
            this.k = new DefaultConnectivityMonitorFactory();
        }
        if (this.d == null) {
            int b2 = this.j.b();
            if (b2 > 0) {
                this.d = new LruBitmapPool((long) b2);
            } else {
                this.d = new BitmapPoolAdapter();
            }
        }
        if (this.e == null) {
            this.e = new LruArrayPool(this.j.a());
        }
        if (this.f == null) {
            this.f = new LruResourceCache((long) this.j.d());
        }
        if (this.i == null) {
            this.i = new InternalCacheDiskCacheFactory(context2);
        }
        if (this.c == null) {
            this.c = new Engine(this.f, this.i, this.h, this.g, GlideExecutor.j(), this.o, this.p);
        }
        List list2 = this.q;
        if (list2 == null) {
            this.q = Collections.emptyList();
        } else {
            this.q = Collections.unmodifiableList(list2);
        }
        GlideExperiments b3 = this.b.b();
        return new Glide(context, this.c, this.f, this.d, this.e, new RequestManagerRetriever(this.n), this.k, this.l, this.m, this.f2416a, this.q, list, appGlideModule, b3);
    }

    public void b(RequestManagerRetriever.RequestManagerFactory requestManagerFactory) {
        this.n = requestManagerFactory;
    }
}
