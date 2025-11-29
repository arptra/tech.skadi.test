package io.netty.handler.codec;

import io.netty.util.internal.ObjectUtil;
import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import okhttp3.HttpUrl;

public final class HeadersUtils {

    public static final class CharSequenceDelegatingStringSet extends DelegatingStringSet<CharSequence> {
        public CharSequenceDelegatingStringSet(Set<CharSequence> set) {
            super(set);
        }

        public boolean addAll(Collection<? extends String> collection) {
            return this.allNames.addAll(collection);
        }

        public boolean add(String str) {
            return this.allNames.add(str);
        }
    }

    public static abstract class DelegatingStringSet<T> extends AbstractCollection<String> implements Set<String> {
        protected final Set<T> allNames;

        public DelegatingStringSet(Set<T> set) {
            this.allNames = (Set) ObjectUtil.checkNotNull(set, "allNames");
        }

        public void clear() {
            this.allNames.clear();
        }

        public boolean contains(Object obj) {
            return this.allNames.contains(obj.toString());
        }

        public boolean isEmpty() {
            return this.allNames.isEmpty();
        }

        public Iterator<String> iterator() {
            return new StringIterator(this.allNames.iterator());
        }

        public boolean remove(Object obj) {
            return this.allNames.remove(obj);
        }

        public int size() {
            return this.allNames.size();
        }
    }

    public static final class StringEntry implements Map.Entry<String, String> {
        private final Map.Entry<CharSequence, CharSequence> entry;
        private String name;
        private String value;

        public StringEntry(Map.Entry<CharSequence, CharSequence> entry2) {
            this.entry = entry2;
        }

        public String toString() {
            return this.entry.toString();
        }

        public String getKey() {
            if (this.name == null) {
                this.name = this.entry.getKey().toString();
            }
            return this.name;
        }

        public String getValue() {
            if (this.value == null && this.entry.getValue() != null) {
                this.value = this.entry.getValue().toString();
            }
            return this.value;
        }

        public String setValue(String str) {
            String value2 = getValue();
            this.entry.setValue(str);
            return value2;
        }
    }

    public static final class StringEntryIterator implements Iterator<Map.Entry<String, String>> {
        private final Iterator<Map.Entry<CharSequence, CharSequence>> iter;

        public StringEntryIterator(Iterator<Map.Entry<CharSequence, CharSequence>> it) {
            this.iter = it;
        }

        public boolean hasNext() {
            return this.iter.hasNext();
        }

        public void remove() {
            this.iter.remove();
        }

        public Map.Entry<String, String> next() {
            return new StringEntry(this.iter.next());
        }
    }

    public static final class StringIterator<T> implements Iterator<String> {
        private final Iterator<T> iter;

        public StringIterator(Iterator<T> it) {
            this.iter = it;
        }

        public boolean hasNext() {
            return this.iter.hasNext();
        }

        public void remove() {
            this.iter.remove();
        }

        public String next() {
            T next = this.iter.next();
            if (next != null) {
                return next.toString();
            }
            return null;
        }
    }

    private HeadersUtils() {
    }

    public static <K, V> List<String> getAllAsString(Headers<K, V, ?> headers, K k) {
        final List<V> all = headers.getAll(k);
        return new AbstractList<String>() {
            public int size() {
                return all.size();
            }

            public String get(int i) {
                Object obj = all.get(i);
                if (obj != null) {
                    return obj.toString();
                }
                return null;
            }
        };
    }

    public static <K, V> String getAsString(Headers<K, V, ?> headers, K k) {
        V v = headers.get(k);
        if (v != null) {
            return v.toString();
        }
        return null;
    }

    public static Iterator<Map.Entry<String, String>> iteratorAsString(Iterable<Map.Entry<CharSequence, CharSequence>> iterable) {
        return new StringEntryIterator(iterable.iterator());
    }

    public static Set<String> namesAsString(Headers<CharSequence, CharSequence, ?> headers) {
        return new CharSequenceDelegatingStringSet(headers.names());
    }

    public static <K, V> String toString(Class<?> cls, Iterator<Map.Entry<K, V>> it, int i) {
        String simpleName = cls.getSimpleName();
        if (i == 0) {
            return simpleName + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sb = new StringBuilder(simpleName.length() + 2 + (i * 20));
        sb.append(simpleName);
        sb.append('[');
        while (it.hasNext()) {
            Map.Entry next = it.next();
            sb.append(next.getKey());
            sb.append(": ");
            sb.append(next.getValue());
            sb.append(", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append(']');
        return sb.toString();
    }
}
