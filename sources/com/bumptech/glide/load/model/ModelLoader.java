package com.bumptech.glide.load.model;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.util.Preconditions;
import java.util.Collections;
import java.util.List;

public interface ModelLoader<Model, Data> {

    public static class LoadData<Data> {

        /* renamed from: a  reason: collision with root package name */
        public final Key f2572a;
        public final List b;
        public final DataFetcher c;

        public LoadData(Key key, DataFetcher dataFetcher) {
            this(key, Collections.emptyList(), dataFetcher);
        }

        public LoadData(Key key, List list, DataFetcher dataFetcher) {
            this.f2572a = (Key) Preconditions.d(key);
            this.b = (List) Preconditions.d(list);
            this.c = (DataFetcher) Preconditions.d(dataFetcher);
        }
    }

    LoadData a(Object obj, int i, int i2, Options options);

    boolean b(Object obj);
}
