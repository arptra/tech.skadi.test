package com.bumptech.glide.load.model;

import androidx.core.util.Pools;
import com.bumptech.glide.Registry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModelLoaderRegistry {

    /* renamed from: a  reason: collision with root package name */
    public final MultiModelLoaderFactory f2573a;
    public final ModelLoaderCache b;

    public static class ModelLoaderCache {

        /* renamed from: a  reason: collision with root package name */
        public final Map f2574a = new HashMap();

        public static class Entry<Model> {

            /* renamed from: a  reason: collision with root package name */
            public final List f2575a;

            public Entry(List list) {
                this.f2575a = list;
            }
        }

        public void a() {
            this.f2574a.clear();
        }

        public List b(Class cls) {
            Entry entry = (Entry) this.f2574a.get(cls);
            if (entry == null) {
                return null;
            }
            return entry.f2575a;
        }

        public void c(Class cls, List list) {
            if (((Entry) this.f2574a.put(cls, new Entry(list))) != null) {
                throw new IllegalStateException("Already cached loaders for model: " + cls);
            }
        }
    }

    public ModelLoaderRegistry(Pools.Pool pool) {
        this(new MultiModelLoaderFactory(pool));
    }

    public static Class b(Object obj) {
        return obj.getClass();
    }

    public synchronized void a(Class cls, Class cls2, ModelLoaderFactory modelLoaderFactory) {
        this.f2573a.b(cls, cls2, modelLoaderFactory);
        this.b.a();
    }

    public synchronized List c(Class cls) {
        return this.f2573a.g(cls);
    }

    public List d(Object obj) {
        List e = e(b(obj));
        if (!e.isEmpty()) {
            int size = e.size();
            List emptyList = Collections.emptyList();
            boolean z = true;
            for (int i = 0; i < size; i++) {
                ModelLoader modelLoader = (ModelLoader) e.get(i);
                if (modelLoader.b(obj)) {
                    if (z) {
                        emptyList = new ArrayList(size - i);
                        z = false;
                    }
                    emptyList.add(modelLoader);
                }
            }
            if (!emptyList.isEmpty()) {
                return emptyList;
            }
            throw new Registry.NoModelLoaderAvailableException(obj, e);
        }
        throw new Registry.NoModelLoaderAvailableException(obj);
    }

    public final synchronized List e(Class cls) {
        List b2;
        b2 = this.b.b(cls);
        if (b2 == null) {
            b2 = Collections.unmodifiableList(this.f2573a.e(cls));
            this.b.c(cls, b2);
        }
        return b2;
    }

    public ModelLoaderRegistry(MultiModelLoaderFactory multiModelLoaderFactory) {
        this.b = new ModelLoaderCache();
        this.f2573a = multiModelLoaderFactory;
    }
}
