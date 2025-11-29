package com.bumptech.glide.load.engine;

import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.resource.UnitTransformation;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class DecodeHelper<Transcode> {

    /* renamed from: a  reason: collision with root package name */
    public final List f2474a = new ArrayList();
    public final List b = new ArrayList();
    public GlideContext c;
    public Object d;
    public int e;
    public int f;
    public Class g;
    public DecodeJob.DiskCacheProvider h;
    public Options i;
    public Map j;
    public Class k;
    public boolean l;
    public boolean m;
    public Key n;
    public Priority o;
    public DiskCacheStrategy p;
    public boolean q;
    public boolean r;

    public void a() {
        this.c = null;
        this.d = null;
        this.n = null;
        this.g = null;
        this.k = null;
        this.i = null;
        this.o = null;
        this.j = null;
        this.p = null;
        this.f2474a.clear();
        this.l = false;
        this.b.clear();
        this.m = false;
    }

    public ArrayPool b() {
        return this.c.b();
    }

    public List c() {
        if (!this.m) {
            this.m = true;
            this.b.clear();
            List g2 = g();
            int size = g2.size();
            for (int i2 = 0; i2 < size; i2++) {
                ModelLoader.LoadData loadData = (ModelLoader.LoadData) g2.get(i2);
                if (!this.b.contains(loadData.f2572a)) {
                    this.b.add(loadData.f2572a);
                }
                for (int i3 = 0; i3 < loadData.b.size(); i3++) {
                    if (!this.b.contains(loadData.b.get(i3))) {
                        this.b.add(loadData.b.get(i3));
                    }
                }
            }
        }
        return this.b;
    }

    public DiskCache d() {
        return this.h.a();
    }

    public DiskCacheStrategy e() {
        return this.p;
    }

    public int f() {
        return this.f;
    }

    public List g() {
        if (!this.l) {
            this.l = true;
            this.f2474a.clear();
            List i2 = this.c.i().i(this.d);
            int size = i2.size();
            for (int i3 = 0; i3 < size; i3++) {
                ModelLoader.LoadData a2 = ((ModelLoader) i2.get(i3)).a(this.d, this.e, this.f, this.i);
                if (a2 != null) {
                    this.f2474a.add(a2);
                }
            }
        }
        return this.f2474a;
    }

    public LoadPath h(Class cls) {
        return this.c.i().h(cls, this.g, this.k);
    }

    public Class i() {
        return this.d.getClass();
    }

    public List j(File file) {
        return this.c.i().i(file);
    }

    public Options k() {
        return this.i;
    }

    public Priority l() {
        return this.o;
    }

    public List m() {
        return this.c.i().j(this.d.getClass(), this.g, this.k);
    }

    public ResourceEncoder n(Resource resource) {
        return this.c.i().k(resource);
    }

    public DataRewinder o(Object obj) {
        return this.c.i().l(obj);
    }

    public Key p() {
        return this.n;
    }

    public Encoder q(Object obj) {
        return this.c.i().m(obj);
    }

    public Class r() {
        return this.k;
    }

    public Transformation s(Class cls) {
        Transformation transformation = (Transformation) this.j.get(cls);
        if (transformation == null) {
            Iterator it = this.j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    transformation = (Transformation) entry.getValue();
                    break;
                }
            }
        }
        if (transformation != null) {
            return transformation;
        }
        if (!this.j.isEmpty() || !this.q) {
            return UnitTransformation.c();
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }

    public int t() {
        return this.e;
    }

    public boolean u(Class cls) {
        return h(cls) != null;
    }

    public void v(GlideContext glideContext, Object obj, Key key, int i2, int i3, DiskCacheStrategy diskCacheStrategy, Class cls, Class cls2, Priority priority, Options options, Map map, boolean z, boolean z2, DecodeJob.DiskCacheProvider diskCacheProvider) {
        this.c = glideContext;
        this.d = obj;
        this.n = key;
        this.e = i2;
        this.f = i3;
        this.p = diskCacheStrategy;
        this.g = cls;
        this.h = diskCacheProvider;
        this.k = cls2;
        this.o = priority;
        this.i = options;
        this.j = map;
        this.q = z;
        this.r = z2;
    }

    public boolean w(Resource resource) {
        return this.c.i().n(resource);
    }

    public boolean x() {
        return this.r;
    }

    public boolean y(Key key) {
        List g2 = g();
        int size = g2.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((ModelLoader.LoadData) g2.get(i2)).f2572a.equals(key)) {
                return true;
            }
        }
        return false;
    }
}
