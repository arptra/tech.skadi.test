package dagger.internal;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public final class LazyClassKeyMap<V> implements Map<Class<?>, V> {

    /* renamed from: a  reason: collision with root package name */
    public final Map f8778a;

    public static class MapFactory<V> implements Factory<Map<Class<?>, V>> {

        /* renamed from: a  reason: collision with root package name */
        public Factory f8779a;

        /* renamed from: a */
        public Map get() {
            return LazyClassKeyMap.a((Map) this.f8779a.get());
        }
    }

    public static class MapProviderFactory<V> implements Factory<Map<Class<?>, Provider<V>>> {

        /* renamed from: a  reason: collision with root package name */
        public Factory f8780a;

        /* renamed from: a */
        public Map get() {
            return LazyClassKeyMap.a((Map) this.f8780a.get());
        }
    }

    public LazyClassKeyMap(Map map) {
        this.f8778a = map;
    }

    public static Map a(Map map) {
        return new LazyClassKeyMap(map);
    }

    /* renamed from: c */
    public Object put(Class cls, Object obj) {
        throw new UnsupportedOperationException("Dagger map bindings are immutable");
    }

    public void clear() {
        throw new UnsupportedOperationException("Dagger map bindings are immutable");
    }

    public boolean containsKey(Object obj) {
        if (obj instanceof Class) {
            return this.f8778a.containsKey(((Class) obj).getName());
        }
        throw new IllegalArgumentException("Key must be a class");
    }

    public boolean containsValue(Object obj) {
        return this.f8778a.containsValue(obj);
    }

    public Set entrySet() {
        throw new UnsupportedOperationException("Maps created with @LazyClassKey do not support usage of entrySet(). Consider @ClassKey instead.");
    }

    public Object get(Object obj) {
        if (obj instanceof Class) {
            return this.f8778a.get(((Class) obj).getName());
        }
        throw new IllegalArgumentException("Key must be a class");
    }

    public boolean isEmpty() {
        return this.f8778a.isEmpty();
    }

    public Set keySet() {
        throw new UnsupportedOperationException("Maps created with @LazyClassKey do not support usage of keySet(). Consider @ClassKey instead.");
    }

    public void putAll(Map map) {
        throw new UnsupportedOperationException("Dagger map bindings are immutable");
    }

    public Object remove(Object obj) {
        throw new UnsupportedOperationException("Dagger map bindings are immutable");
    }

    public int size() {
        return this.f8778a.size();
    }

    public Collection values() {
        return this.f8778a.values();
    }
}
