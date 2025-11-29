package com.bumptech.glide.provider;

import androidx.collection.ArrayMap;
import androidx.core.util.Pools;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.LoadPath;
import com.bumptech.glide.load.resource.transcode.UnitTranscoder;
import com.bumptech.glide.util.MultiClassKey;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

public class LoadPathCache {
    public static final LoadPath c;

    /* renamed from: a  reason: collision with root package name */
    public final ArrayMap f2701a = new ArrayMap();
    public final AtomicReference b = new AtomicReference();

    static {
        Class<Object> cls = Object.class;
        Class<Object> cls2 = Object.class;
        Class<Object> cls3 = Object.class;
        c = new LoadPath(cls, cls2, cls3, Collections.singletonList(new DecodePath(Object.class, Object.class, Object.class, Collections.emptyList(), new UnitTranscoder(), (Pools.Pool) null)), (Pools.Pool) null);
    }

    public LoadPath a(Class cls, Class cls2, Class cls3) {
        LoadPath loadPath;
        MultiClassKey b2 = b(cls, cls2, cls3);
        synchronized (this.f2701a) {
            loadPath = (LoadPath) this.f2701a.get(b2);
        }
        this.b.set(b2);
        return loadPath;
    }

    public final MultiClassKey b(Class cls, Class cls2, Class cls3) {
        MultiClassKey multiClassKey = (MultiClassKey) this.b.getAndSet((Object) null);
        if (multiClassKey == null) {
            multiClassKey = new MultiClassKey();
        }
        multiClassKey.a(cls, cls2, cls3);
        return multiClassKey;
    }

    public boolean c(LoadPath loadPath) {
        return c.equals(loadPath);
    }

    public void d(Class cls, Class cls2, Class cls3, LoadPath loadPath) {
        synchronized (this.f2701a) {
            ArrayMap arrayMap = this.f2701a;
            MultiClassKey multiClassKey = new MultiClassKey(cls, cls2, cls3);
            if (loadPath == null) {
                loadPath = c;
            }
            arrayMap.put(multiClassKey, loadPath);
        }
    }
}
