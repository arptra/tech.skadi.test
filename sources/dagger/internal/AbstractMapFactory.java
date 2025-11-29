package dagger.internal;

import java.util.Map;

abstract class AbstractMapFactory<K, V, V2> implements Factory<Map<K, V2>> {

    /* renamed from: a  reason: collision with root package name */
    public final Map f8774a;

    public static abstract class Builder<K, V, V2> {
    }

    public final Map a() {
        return this.f8774a;
    }
}
