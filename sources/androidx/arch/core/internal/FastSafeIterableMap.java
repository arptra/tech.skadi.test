package androidx.arch.core.internal;

import androidx.annotation.RestrictTo;
import androidx.arch.core.internal.SafeIterableMap;
import java.util.HashMap;
import java.util.Map;

@RestrictTo
public class FastSafeIterableMap<K, V> extends SafeIterableMap<K, V> {
    public final HashMap e = new HashMap();

    public SafeIterableMap.Entry b(Object obj) {
        return (SafeIterableMap.Entry) this.e.get(obj);
    }

    public boolean contains(Object obj) {
        return this.e.containsKey(obj);
    }

    public Object f(Object obj, Object obj2) {
        SafeIterableMap.Entry b = b(obj);
        if (b != null) {
            return b.b;
        }
        this.e.put(obj, e(obj, obj2));
        return null;
    }

    public Object h(Object obj) {
        Object h = super.h(obj);
        this.e.remove(obj);
        return h;
    }

    public Map.Entry i(Object obj) {
        if (contains(obj)) {
            return ((SafeIterableMap.Entry) this.e.get(obj)).d;
        }
        return null;
    }
}
