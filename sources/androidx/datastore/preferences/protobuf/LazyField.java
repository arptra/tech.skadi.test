package androidx.datastore.preferences.protobuf;

import java.util.Iterator;
import java.util.Map;

public class LazyField extends LazyFieldLite {
    public final MessageLite f;

    public static class LazyEntry<K> implements Map.Entry<K, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Map.Entry f1106a;

        public LazyField a() {
            return (LazyField) this.f1106a.getValue();
        }

        public Object getKey() {
            return this.f1106a.getKey();
        }

        public Object getValue() {
            LazyField lazyField = (LazyField) this.f1106a.getValue();
            if (lazyField == null) {
                return null;
            }
            return lazyField.f();
        }

        public Object setValue(Object obj) {
            if (obj instanceof MessageLite) {
                return ((LazyField) this.f1106a.getValue()).d((MessageLite) obj);
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }

        public LazyEntry(Map.Entry entry) {
            this.f1106a = entry;
        }
    }

    public static class LazyIterator<K> implements Iterator<Map.Entry<K, Object>> {

        /* renamed from: a  reason: collision with root package name */
        public Iterator f1107a;

        public LazyIterator(Iterator it) {
            this.f1107a = it;
        }

        /* renamed from: a */
        public Map.Entry next() {
            Map.Entry entry = (Map.Entry) this.f1107a.next();
            return entry.getValue() instanceof LazyField ? new LazyEntry(entry) : entry;
        }

        public boolean hasNext() {
            return this.f1107a.hasNext();
        }

        public void remove() {
            this.f1107a.remove();
        }
    }

    public boolean equals(Object obj) {
        return f().equals(obj);
    }

    public MessageLite f() {
        return c(this.f);
    }

    public int hashCode() {
        return f().hashCode();
    }

    public String toString() {
        return f().toString();
    }
}
