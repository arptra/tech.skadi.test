package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import java.util.HashMap;
import java.util.Map;

final class Jobs {

    /* renamed from: a  reason: collision with root package name */
    public final Map f2496a = new HashMap();
    public final Map b = new HashMap();

    public EngineJob a(Key key, boolean z) {
        return (EngineJob) b(z).get(key);
    }

    public final Map b(boolean z) {
        return z ? this.b : this.f2496a;
    }

    public void c(Key key, EngineJob engineJob) {
        b(engineJob.p()).put(key, engineJob);
    }

    public void d(Key key, EngineJob engineJob) {
        Map b2 = b(engineJob.p());
        if (engineJob.equals(b2.get(key))) {
            b2.remove(key);
        }
    }
}
