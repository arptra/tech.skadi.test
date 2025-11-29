package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.IOException;
import java.util.List;

class SourceGenerator implements DataFetcherGenerator, DataFetcherGenerator.FetcherReadyCallback {

    /* renamed from: a  reason: collision with root package name */
    public final DecodeHelper f2501a;
    public final DataFetcherGenerator.FetcherReadyCallback b;
    public volatile int c;
    public volatile DataCacheGenerator d;
    public volatile Object e;
    public volatile ModelLoader.LoadData f;
    public volatile DataCacheKey g;

    public SourceGenerator(DecodeHelper decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.f2501a = decodeHelper;
        this.b = fetcherReadyCallback;
    }

    public boolean a() {
        if (this.e != null) {
            Object obj = this.e;
            this.e = null;
            try {
                if (!c(obj)) {
                    return true;
                }
            } catch (IOException e2) {
                if (Log.isLoggable("SourceGenerator", 3)) {
                    Log.d("SourceGenerator", "Failed to properly rewind or write data to cache", e2);
                }
            }
        }
        if (this.d != null && this.d.a()) {
            return true;
        }
        this.d = null;
        this.f = null;
        boolean z = false;
        while (!z && e()) {
            List g2 = this.f2501a.g();
            int i = this.c;
            this.c = i + 1;
            this.f = (ModelLoader.LoadData) g2.get(i);
            if (this.f != null && (this.f2501a.e().c(this.f.c.c()) || this.f2501a.u(this.f.c.a()))) {
                j(this.f);
                z = true;
            }
        }
        return z;
    }

    public void b(Key key, Exception exc, DataFetcher dataFetcher, DataSource dataSource) {
        this.b.b(key, exc, dataFetcher, this.f.c.c());
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00e1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean c(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.String r0 = "SourceGenerator"
            long r1 = com.bumptech.glide.util.LogTime.b()
            r3 = 0
            com.bumptech.glide.load.engine.DecodeHelper r4 = r11.f2501a     // Catch:{ all -> 0x0072 }
            com.bumptech.glide.load.data.DataRewinder r4 = r4.o(r12)     // Catch:{ all -> 0x0072 }
            java.lang.Object r5 = r4.a()     // Catch:{ all -> 0x0072 }
            com.bumptech.glide.load.engine.DecodeHelper r6 = r11.f2501a     // Catch:{ all -> 0x0072 }
            com.bumptech.glide.load.Encoder r6 = r6.q(r5)     // Catch:{ all -> 0x0072 }
            com.bumptech.glide.load.engine.DataCacheWriter r7 = new com.bumptech.glide.load.engine.DataCacheWriter     // Catch:{ all -> 0x0072 }
            com.bumptech.glide.load.engine.DecodeHelper r8 = r11.f2501a     // Catch:{ all -> 0x0072 }
            com.bumptech.glide.load.Options r8 = r8.k()     // Catch:{ all -> 0x0072 }
            r7.<init>(r6, r5, r8)     // Catch:{ all -> 0x0072 }
            com.bumptech.glide.load.engine.DataCacheKey r5 = new com.bumptech.glide.load.engine.DataCacheKey     // Catch:{ all -> 0x0072 }
            com.bumptech.glide.load.model.ModelLoader$LoadData r8 = r11.f     // Catch:{ all -> 0x0072 }
            com.bumptech.glide.load.Key r8 = r8.f2572a     // Catch:{ all -> 0x0072 }
            com.bumptech.glide.load.engine.DecodeHelper r9 = r11.f2501a     // Catch:{ all -> 0x0072 }
            com.bumptech.glide.load.Key r9 = r9.p()     // Catch:{ all -> 0x0072 }
            r5.<init>(r8, r9)     // Catch:{ all -> 0x0072 }
            com.bumptech.glide.load.engine.DecodeHelper r8 = r11.f2501a     // Catch:{ all -> 0x0072 }
            com.bumptech.glide.load.engine.cache.DiskCache r8 = r8.d()     // Catch:{ all -> 0x0072 }
            r8.a(r5, r7)     // Catch:{ all -> 0x0072 }
            r7 = 2
            boolean r7 = android.util.Log.isLoggable(r0, r7)     // Catch:{ all -> 0x0072 }
            java.lang.String r9 = ", data: "
            if (r7 == 0) goto L_0x0074
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0072 }
            r7.<init>()     // Catch:{ all -> 0x0072 }
            java.lang.String r10 = "Finished encoding source to cache, key: "
            r7.append(r10)     // Catch:{ all -> 0x0072 }
            r7.append(r5)     // Catch:{ all -> 0x0072 }
            r7.append(r9)     // Catch:{ all -> 0x0072 }
            r7.append(r12)     // Catch:{ all -> 0x0072 }
            java.lang.String r10 = ", encoder: "
            r7.append(r10)     // Catch:{ all -> 0x0072 }
            r7.append(r6)     // Catch:{ all -> 0x0072 }
            java.lang.String r6 = ", duration: "
            r7.append(r6)     // Catch:{ all -> 0x0072 }
            double r1 = com.bumptech.glide.util.LogTime.a(r1)     // Catch:{ all -> 0x0072 }
            r7.append(r1)     // Catch:{ all -> 0x0072 }
            java.lang.String r1 = r7.toString()     // Catch:{ all -> 0x0072 }
            android.util.Log.v(r0, r1)     // Catch:{ all -> 0x0072 }
            goto L_0x0074
        L_0x0072:
            r12 = move-exception
            goto L_0x00df
        L_0x0074:
            java.io.File r1 = r8.b(r5)     // Catch:{ all -> 0x0072 }
            r2 = 1
            if (r1 == 0) goto L_0x0096
            r11.g = r5     // Catch:{ all -> 0x0072 }
            com.bumptech.glide.load.engine.DataCacheGenerator r12 = new com.bumptech.glide.load.engine.DataCacheGenerator     // Catch:{ all -> 0x0072 }
            com.bumptech.glide.load.model.ModelLoader$LoadData r0 = r11.f     // Catch:{ all -> 0x0072 }
            com.bumptech.glide.load.Key r0 = r0.f2572a     // Catch:{ all -> 0x0072 }
            java.util.List r0 = java.util.Collections.singletonList(r0)     // Catch:{ all -> 0x0072 }
            com.bumptech.glide.load.engine.DecodeHelper r1 = r11.f2501a     // Catch:{ all -> 0x0072 }
            r12.<init>(r0, r1, r11)     // Catch:{ all -> 0x0072 }
            r11.d = r12     // Catch:{ all -> 0x0072 }
            com.bumptech.glide.load.model.ModelLoader$LoadData r11 = r11.f
            com.bumptech.glide.load.data.DataFetcher r11 = r11.c
            r11.b()
            return r2
        L_0x0096:
            r1 = 3
            boolean r1 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x0072 }
            if (r1 == 0) goto L_0x00be
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0072 }
            r1.<init>()     // Catch:{ all -> 0x0072 }
            java.lang.String r5 = "Attempt to write: "
            r1.append(r5)     // Catch:{ all -> 0x0072 }
            com.bumptech.glide.load.engine.DataCacheKey r5 = r11.g     // Catch:{ all -> 0x0072 }
            r1.append(r5)     // Catch:{ all -> 0x0072 }
            r1.append(r9)     // Catch:{ all -> 0x0072 }
            r1.append(r12)     // Catch:{ all -> 0x0072 }
            java.lang.String r12 = " to the disk cache failed, maybe the disk cache is disabled? Trying to decode the data directly..."
            r1.append(r12)     // Catch:{ all -> 0x0072 }
            java.lang.String r12 = r1.toString()     // Catch:{ all -> 0x0072 }
            android.util.Log.d(r0, r12)     // Catch:{ all -> 0x0072 }
        L_0x00be:
            com.bumptech.glide.load.engine.DataFetcherGenerator$FetcherReadyCallback r12 = r11.b     // Catch:{ all -> 0x00dd }
            com.bumptech.glide.load.model.ModelLoader$LoadData r0 = r11.f     // Catch:{ all -> 0x00dd }
            com.bumptech.glide.load.Key r5 = r0.f2572a     // Catch:{ all -> 0x00dd }
            java.lang.Object r6 = r4.a()     // Catch:{ all -> 0x00dd }
            com.bumptech.glide.load.model.ModelLoader$LoadData r0 = r11.f     // Catch:{ all -> 0x00dd }
            com.bumptech.glide.load.data.DataFetcher r7 = r0.c     // Catch:{ all -> 0x00dd }
            com.bumptech.glide.load.model.ModelLoader$LoadData r0 = r11.f     // Catch:{ all -> 0x00dd }
            com.bumptech.glide.load.data.DataFetcher r0 = r0.c     // Catch:{ all -> 0x00dd }
            com.bumptech.glide.load.DataSource r8 = r0.c()     // Catch:{ all -> 0x00dd }
            com.bumptech.glide.load.model.ModelLoader$LoadData r0 = r11.f     // Catch:{ all -> 0x00dd }
            com.bumptech.glide.load.Key r9 = r0.f2572a     // Catch:{ all -> 0x00dd }
            r4 = r12
            r4.g(r5, r6, r7, r8, r9)     // Catch:{ all -> 0x00dd }
            return r3
        L_0x00dd:
            r12 = move-exception
            r3 = r2
        L_0x00df:
            if (r3 != 0) goto L_0x00e8
            com.bumptech.glide.load.model.ModelLoader$LoadData r11 = r11.f
            com.bumptech.glide.load.data.DataFetcher r11 = r11.c
            r11.b()
        L_0x00e8:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.SourceGenerator.c(java.lang.Object):boolean");
    }

    public void cancel() {
        ModelLoader.LoadData loadData = this.f;
        if (loadData != null) {
            loadData.c.cancel();
        }
    }

    public void d() {
        throw new UnsupportedOperationException();
    }

    public final boolean e() {
        return this.c < this.f2501a.g().size();
    }

    public boolean f(ModelLoader.LoadData loadData) {
        ModelLoader.LoadData loadData2 = this.f;
        return loadData2 != null && loadData2 == loadData;
    }

    public void g(Key key, Object obj, DataFetcher dataFetcher, DataSource dataSource, Key key2) {
        this.b.g(key, obj, dataFetcher, this.f.c.c(), key);
    }

    public void h(ModelLoader.LoadData loadData, Object obj) {
        DiskCacheStrategy e2 = this.f2501a.e();
        if (obj == null || !e2.c(loadData.c.c())) {
            DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback = this.b;
            Key key = loadData.f2572a;
            DataFetcher dataFetcher = loadData.c;
            fetcherReadyCallback.g(key, obj, dataFetcher, dataFetcher.c(), this.g);
            return;
        }
        this.e = obj;
        this.b.d();
    }

    public void i(ModelLoader.LoadData loadData, Exception exc) {
        DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback = this.b;
        DataCacheKey dataCacheKey = this.g;
        DataFetcher dataFetcher = loadData.c;
        fetcherReadyCallback.b(dataCacheKey, exc, dataFetcher, dataFetcher.c());
    }

    public final void j(final ModelLoader.LoadData loadData) {
        this.f.c.d(this.f2501a.l(), new DataFetcher.DataCallback<Object>() {
            public void e(Object obj) {
                if (SourceGenerator.this.f(loadData)) {
                    SourceGenerator.this.h(loadData, obj);
                }
            }

            public void f(Exception exc) {
                if (SourceGenerator.this.f(loadData)) {
                    SourceGenerator.this.i(loadData, exc);
                }
            }
        });
    }
}
