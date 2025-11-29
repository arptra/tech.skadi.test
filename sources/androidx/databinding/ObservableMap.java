package androidx.databinding;

import java.util.Map;

public interface ObservableMap<K, V> extends Map<K, V> {

    public static abstract class OnMapChangedCallback<T extends ObservableMap<K, V>, K, V> {
        public abstract void a(ObservableMap observableMap, Object obj);
    }

    void b(OnMapChangedCallback onMapChangedCallback);
}
