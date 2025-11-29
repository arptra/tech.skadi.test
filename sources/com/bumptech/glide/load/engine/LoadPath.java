package com.bumptech.glide.load.engine;

import androidx.core.util.Pools;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoadPath<Data, ResourceType, Transcode> {

    /* renamed from: a  reason: collision with root package name */
    public final Class f2497a;
    public final Pools.Pool b;
    public final List c;
    public final String d;

    public LoadPath(Class cls, Class cls2, Class cls3, List list, Pools.Pool pool) {
        this.f2497a = cls;
        this.b = pool;
        this.c = (List) Preconditions.c(list);
        this.d = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public Resource a(DataRewinder dataRewinder, Options options, int i, int i2, DecodePath.DecodeCallback decodeCallback) {
        List list = (List) Preconditions.d(this.b.acquire());
        try {
            return b(dataRewinder, options, i, i2, decodeCallback, list);
        } finally {
            this.b.a(list);
        }
    }

    public final Resource b(DataRewinder dataRewinder, Options options, int i, int i2, DecodePath.DecodeCallback decodeCallback, List list) {
        List list2 = list;
        int size = this.c.size();
        Resource resource = null;
        for (int i3 = 0; i3 < size; i3++) {
            try {
                resource = ((DecodePath) this.c.get(i3)).a(dataRewinder, i, i2, options, decodeCallback);
            } catch (GlideException e) {
                list2.add(e);
            }
            if (resource != null) {
                break;
            }
        }
        if (resource != null) {
            return resource;
        }
        throw new GlideException(this.d, (List<Throwable>) new ArrayList(list2));
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.c.toArray()) + '}';
    }
}
