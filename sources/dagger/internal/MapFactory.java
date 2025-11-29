package dagger.internal;

import dagger.internal.AbstractMapFactory;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public final class MapFactory<K, V> extends AbstractMapFactory<K, V, V> {
    public static final Provider b = InstanceFactory.a(Collections.emptyMap());

    public static final class Builder<K, V> extends AbstractMapFactory.Builder<K, V, V> {
    }

    /* renamed from: b */
    public Map get() {
        LinkedHashMap c = DaggerCollections.c(a().size());
        for (Map.Entry entry : a().entrySet()) {
            c.put(entry.getKey(), ((Provider) entry.getValue()).get());
        }
        return Collections.unmodifiableMap(c);
    }
}
