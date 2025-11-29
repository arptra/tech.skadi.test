package com.bumptech.glide;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GlideExperiments {

    /* renamed from: a  reason: collision with root package name */
    public final Map f2420a;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public final Map f2421a = new HashMap();

        public GlideExperiments b() {
            return new GlideExperiments(this);
        }
    }

    public interface Experiment {
    }

    public GlideExperiments(Builder builder) {
        this.f2420a = Collections.unmodifiableMap(new HashMap(builder.f2421a));
    }

    public boolean a(Class cls) {
        return this.f2420a.containsKey(cls);
    }
}
