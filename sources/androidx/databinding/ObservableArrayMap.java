package androidx.databinding;

import androidx.collection.ArrayMap;
import androidx.databinding.ObservableMap;
import java.util.Collection;

public class ObservableArrayMap<K, V> extends ArrayMap<K, V> implements ObservableMap<K, V> {
    public transient MapChangeRegistry i;

    public void b(ObservableMap.OnMapChangedCallback onMapChangedCallback) {
        MapChangeRegistry mapChangeRegistry = this.i;
        if (mapChangeRegistry != null) {
            mapChangeRegistry.j(onMapChangedCallback);
        }
    }

    public void clear() {
        if (!isEmpty()) {
            super.clear();
            q((Object) null);
        }
    }

    public Object l(int i2) {
        Object j = j(i2);
        Object l = super.l(i2);
        if (l != null) {
            q(j);
        }
        return l;
    }

    public Object m(int i2, Object obj) {
        Object j = j(i2);
        Object m = super.m(i2, obj);
        q(j);
        return m;
    }

    public boolean p(Collection collection) {
        boolean z = false;
        for (int size = size() - 1; size >= 0; size--) {
            if (!collection.contains(j(size))) {
                l(size);
                z = true;
            }
        }
        return z;
    }

    public Object put(Object obj, Object obj2) {
        super.put(obj, obj2);
        q(obj);
        return obj2;
    }

    public final void q(Object obj) {
        MapChangeRegistry mapChangeRegistry = this.i;
        if (mapChangeRegistry != null) {
            mapChangeRegistry.e(this, 0, obj);
        }
    }
}
