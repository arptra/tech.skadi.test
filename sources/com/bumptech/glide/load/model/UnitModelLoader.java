package com.bumptech.glide.load.model;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;

public class UnitModelLoader<Model> implements ModelLoader<Model, Model> {

    /* renamed from: a  reason: collision with root package name */
    public static final UnitModelLoader f2590a = new UnitModelLoader();

    public static class Factory<Model> implements ModelLoaderFactory<Model, Model> {

        /* renamed from: a  reason: collision with root package name */
        public static final Factory f2591a = new Factory();

        public static Factory a() {
            return f2591a;
        }

        public ModelLoader c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return UnitModelLoader.c();
        }
    }

    public static class UnitFetcher<Model> implements DataFetcher<Model> {

        /* renamed from: a  reason: collision with root package name */
        public final Object f2592a;

        public UnitFetcher(Object obj) {
            this.f2592a = obj;
        }

        public Class a() {
            return this.f2592a.getClass();
        }

        public void b() {
        }

        public DataSource c() {
            return DataSource.LOCAL;
        }

        public void cancel() {
        }

        public void d(Priority priority, DataFetcher.DataCallback dataCallback) {
            dataCallback.e(this.f2592a);
        }
    }

    public static UnitModelLoader c() {
        return f2590a;
    }

    public ModelLoader.LoadData a(Object obj, int i, int i2, Options options) {
        return new ModelLoader.LoadData(new ObjectKey(obj), new UnitFetcher(obj));
    }

    public boolean b(Object obj) {
        return true;
    }
}
