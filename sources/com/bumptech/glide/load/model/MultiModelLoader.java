package com.bumptech.glide.load.model;

import androidx.core.util.Pools;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MultiModelLoader<Model, Data> implements ModelLoader<Model, Data> {

    /* renamed from: a  reason: collision with root package name */
    public final List f2576a;
    public final Pools.Pool b;

    public static class MultiFetcher<Data> implements DataFetcher<Data>, DataFetcher.DataCallback<Data> {

        /* renamed from: a  reason: collision with root package name */
        public final List f2577a;
        public final Pools.Pool b;
        public int c = 0;
        public Priority d;
        public DataFetcher.DataCallback e;
        public List f;
        public boolean g;

        public MultiFetcher(List list, Pools.Pool pool) {
            this.b = pool;
            Preconditions.c(list);
            this.f2577a = list;
        }

        public Class a() {
            return ((DataFetcher) this.f2577a.get(0)).a();
        }

        public void b() {
            List list = this.f;
            if (list != null) {
                this.b.a(list);
            }
            this.f = null;
            for (DataFetcher b2 : this.f2577a) {
                b2.b();
            }
        }

        public DataSource c() {
            return ((DataFetcher) this.f2577a.get(0)).c();
        }

        public void cancel() {
            this.g = true;
            for (DataFetcher cancel : this.f2577a) {
                cancel.cancel();
            }
        }

        public void d(Priority priority, DataFetcher.DataCallback dataCallback) {
            this.d = priority;
            this.e = dataCallback;
            this.f = (List) this.b.acquire();
            ((DataFetcher) this.f2577a.get(this.c)).d(priority, this);
            if (this.g) {
                cancel();
            }
        }

        public void e(Object obj) {
            if (obj != null) {
                this.e.e(obj);
            } else {
                g();
            }
        }

        public void f(Exception exc) {
            ((List) Preconditions.d(this.f)).add(exc);
            g();
        }

        public final void g() {
            if (!this.g) {
                if (this.c < this.f2577a.size() - 1) {
                    this.c++;
                    d(this.d, this.e);
                    return;
                }
                Preconditions.d(this.f);
                this.e.f(new GlideException("Fetch failed", (List<Throwable>) new ArrayList(this.f)));
            }
        }
    }

    public MultiModelLoader(List list, Pools.Pool pool) {
        this.f2576a = list;
        this.b = pool;
    }

    public ModelLoader.LoadData a(Object obj, int i, int i2, Options options) {
        ModelLoader.LoadData a2;
        int size = this.f2576a.size();
        ArrayList arrayList = new ArrayList(size);
        Key key = null;
        for (int i3 = 0; i3 < size; i3++) {
            ModelLoader modelLoader = (ModelLoader) this.f2576a.get(i3);
            if (modelLoader.b(obj) && (a2 = modelLoader.a(obj, i, i2, options)) != null) {
                key = a2.f2572a;
                arrayList.add(a2.c);
            }
        }
        if (arrayList.isEmpty() || key == null) {
            return null;
        }
        return new ModelLoader.LoadData(key, new MultiFetcher(arrayList, this.b));
    }

    public boolean b(Object obj) {
        for (ModelLoader b2 : this.f2576a) {
            if (b2.b(obj)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.f2576a.toArray()) + '}';
    }
}
