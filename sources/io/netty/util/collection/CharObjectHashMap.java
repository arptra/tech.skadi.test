package io.netty.util.collection;

import io.netty.util.collection.CharObjectMap;
import io.netty.util.internal.MathUtil;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class CharObjectHashMap<V> implements CharObjectMap<V> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int DEFAULT_CAPACITY = 8;
    public static final float DEFAULT_LOAD_FACTOR = 0.5f;
    private static final Object NULL_VALUE = new Object();
    private final Iterable<CharObjectMap.PrimitiveEntry<V>> entries;
    /* access modifiers changed from: private */
    public final Set<Map.Entry<Character, V>> entrySet;
    private final Set<Character> keySet;
    /* access modifiers changed from: private */
    public char[] keys;
    private final float loadFactor;
    private int mask;
    private int maxSize;
    /* access modifiers changed from: private */
    public int size;
    /* access modifiers changed from: private */
    public V[] values;

    public final class EntrySet extends AbstractSet<Map.Entry<Character, V>> {
        private EntrySet() {
        }

        public Iterator<Map.Entry<Character, V>> iterator() {
            return new MapIterator();
        }

        public int size() {
            return CharObjectHashMap.this.size();
        }
    }

    public final class KeySet extends AbstractSet<Character> {
        private KeySet() {
        }

        public void clear() {
            CharObjectHashMap.this.clear();
        }

        public boolean contains(Object obj) {
            return CharObjectHashMap.this.containsKey(obj);
        }

        public Iterator<Character> iterator() {
            return new Iterator<Character>() {
                private final Iterator<Map.Entry<Character, V>> iter;

                {
                    this.iter = CharObjectHashMap.this.entrySet.iterator();
                }

                public boolean hasNext() {
                    return this.iter.hasNext();
                }

                public void remove() {
                    this.iter.remove();
                }

                public Character next() {
                    return (Character) this.iter.next().getKey();
                }
            };
        }

        public boolean remove(Object obj) {
            return CharObjectHashMap.this.remove(obj) != null;
        }

        public boolean retainAll(Collection<?> collection) {
            Iterator it = CharObjectHashMap.this.entries().iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (!collection.contains(Character.valueOf(((CharObjectMap.PrimitiveEntry) it.next()).key()))) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        public int size() {
            return CharObjectHashMap.this.size();
        }
    }

    public final class MapEntry implements Map.Entry<Character, V> {
        private final int entryIndex;

        public MapEntry(int i) {
            this.entryIndex = i;
        }

        private void verifyExists() {
            if (CharObjectHashMap.this.values[this.entryIndex] == null) {
                throw new IllegalStateException("The map entry has been removed");
            }
        }

        public V getValue() {
            verifyExists();
            return CharObjectHashMap.toExternal(CharObjectHashMap.this.values[this.entryIndex]);
        }

        public V setValue(V v) {
            verifyExists();
            V access$900 = CharObjectHashMap.toExternal(CharObjectHashMap.this.values[this.entryIndex]);
            CharObjectHashMap.this.values[this.entryIndex] = CharObjectHashMap.toInternal(v);
            return access$900;
        }

        public Character getKey() {
            verifyExists();
            return Character.valueOf(CharObjectHashMap.this.keys[this.entryIndex]);
        }
    }

    public final class MapIterator implements Iterator<Map.Entry<Character, V>> {
        private final CharObjectHashMap<V>.PrimitiveIterator iter;

        private MapIterator() {
            this.iter = new PrimitiveIterator();
        }

        public boolean hasNext() {
            return this.iter.hasNext();
        }

        public void remove() {
            this.iter.remove();
        }

        public Map.Entry<Character, V> next() {
            if (hasNext()) {
                this.iter.next();
                return new MapEntry(this.iter.entryIndex);
            }
            throw new NoSuchElementException();
        }
    }

    public final class PrimitiveIterator implements Iterator<CharObjectMap.PrimitiveEntry<V>>, CharObjectMap.PrimitiveEntry<V> {
        /* access modifiers changed from: private */
        public int entryIndex;
        private int nextIndex;
        private int prevIndex;

        private PrimitiveIterator() {
            this.prevIndex = -1;
            this.nextIndex = -1;
            this.entryIndex = -1;
        }

        /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void scanNext() {
            /*
                r2 = this;
            L_0x0000:
                int r0 = r2.nextIndex
                int r0 = r0 + 1
                r2.nextIndex = r0
                io.netty.util.collection.CharObjectHashMap r1 = io.netty.util.collection.CharObjectHashMap.this
                java.lang.Object[] r1 = r1.values
                int r1 = r1.length
                if (r0 == r1) goto L_0x001c
                io.netty.util.collection.CharObjectHashMap r0 = io.netty.util.collection.CharObjectHashMap.this
                java.lang.Object[] r0 = r0.values
                int r1 = r2.nextIndex
                r0 = r0[r1]
                if (r0 != 0) goto L_0x001c
                goto L_0x0000
            L_0x001c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.util.collection.CharObjectHashMap.PrimitiveIterator.scanNext():void");
        }

        public boolean hasNext() {
            if (this.nextIndex == -1) {
                scanNext();
            }
            return this.nextIndex != CharObjectHashMap.this.values.length;
        }

        public char key() {
            return CharObjectHashMap.this.keys[this.entryIndex];
        }

        public void remove() {
            int i = this.prevIndex;
            if (i != -1) {
                if (CharObjectHashMap.this.removeAt(i)) {
                    this.nextIndex = this.prevIndex;
                }
                this.prevIndex = -1;
                return;
            }
            throw new IllegalStateException("next must be called before each remove.");
        }

        public void setValue(V v) {
            CharObjectHashMap.this.values[this.entryIndex] = CharObjectHashMap.toInternal(v);
        }

        public V value() {
            return CharObjectHashMap.toExternal(CharObjectHashMap.this.values[this.entryIndex]);
        }

        public CharObjectMap.PrimitiveEntry<V> next() {
            if (hasNext()) {
                this.prevIndex = this.nextIndex;
                scanNext();
                this.entryIndex = this.prevIndex;
                return this;
            }
            throw new NoSuchElementException();
        }
    }

    public CharObjectHashMap() {
        this(8, 0.5f);
    }

    private int calcMaxSize(int i) {
        return Math.min(i - 1, (int) (((float) i) * this.loadFactor));
    }

    private void growSize() {
        int i = this.size + 1;
        this.size = i;
        if (i > this.maxSize) {
            char[] cArr = this.keys;
            if (cArr.length != Integer.MAX_VALUE) {
                rehash(cArr.length << 1);
                return;
            }
            throw new IllegalStateException("Max capacity reached at size=" + this.size);
        }
    }

    private static int hashCode(char c) {
        return c;
    }

    private int hashIndex(char c) {
        return this.mask & hashCode(c);
    }

    private int indexOf(char c) {
        int hashIndex = hashIndex(c);
        int i = hashIndex;
        while (this.values[i] != null) {
            if (c == this.keys[i]) {
                return i;
            }
            i = probeNext(i);
            if (i == hashIndex) {
                return -1;
            }
        }
        return -1;
    }

    private char objectToKey(Object obj) {
        return ((Character) obj).charValue();
    }

    private int probeNext(int i) {
        return this.mask & (i + 1);
    }

    private void rehash(int i) {
        V[] vArr;
        char[] cArr = this.keys;
        V[] vArr2 = this.values;
        this.keys = new char[i];
        this.values = new Object[i];
        this.maxSize = calcMaxSize(i);
        this.mask = i - 1;
        for (int i2 = 0; i2 < vArr2.length; i2++) {
            V v = vArr2[i2];
            if (v != null) {
                char c = cArr[i2];
                int hashIndex = hashIndex(c);
                while (true) {
                    vArr = this.values;
                    if (vArr[hashIndex] == null) {
                        break;
                    }
                    hashIndex = probeNext(hashIndex);
                }
                this.keys[hashIndex] = c;
                vArr[hashIndex] = v;
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean removeAt(int i) {
        this.size--;
        this.keys[i] = 0;
        this.values[i] = null;
        int probeNext = probeNext(i);
        V v = this.values[probeNext];
        int i2 = i;
        while (v != null) {
            char c = this.keys[probeNext];
            int hashIndex = hashIndex(c);
            if ((probeNext < hashIndex && (hashIndex <= i2 || i2 <= probeNext)) || (hashIndex <= i2 && i2 <= probeNext)) {
                char[] cArr = this.keys;
                cArr[i2] = c;
                V[] vArr = this.values;
                vArr[i2] = v;
                cArr[probeNext] = 0;
                vArr[probeNext] = null;
                i2 = probeNext;
            }
            V[] vArr2 = this.values;
            probeNext = probeNext(probeNext);
            v = vArr2[probeNext];
        }
        return i2 != i;
    }

    /* access modifiers changed from: private */
    public static <T> T toExternal(T t) {
        if (t == NULL_VALUE) {
            return null;
        }
        return t;
    }

    /* access modifiers changed from: private */
    public static <T> T toInternal(T t) {
        return t == null ? NULL_VALUE : t;
    }

    public void clear() {
        Arrays.fill(this.keys, 0);
        Arrays.fill(this.values, (Object) null);
        this.size = 0;
    }

    public boolean containsKey(char c) {
        return indexOf(c) >= 0;
    }

    public boolean containsValue(Object obj) {
        Object internal = toInternal(obj);
        for (V v : this.values) {
            if (v != null && v.equals(internal)) {
                return true;
            }
        }
        return false;
    }

    public Iterable<CharObjectMap.PrimitiveEntry<V>> entries() {
        return this.entries;
    }

    public Set<Map.Entry<Character, V>> entrySet() {
        return this.entrySet;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CharObjectMap)) {
            return false;
        }
        CharObjectMap charObjectMap = (CharObjectMap) obj;
        if (this.size != charObjectMap.size()) {
            return false;
        }
        int i = 0;
        while (true) {
            V[] vArr = this.values;
            if (i >= vArr.length) {
                return true;
            }
            V v = vArr[i];
            if (v != null) {
                Object obj2 = charObjectMap.get(this.keys[i]);
                if (v == NULL_VALUE) {
                    if (obj2 != null) {
                        return false;
                    }
                } else if (!v.equals(obj2)) {
                    return false;
                }
            }
            i++;
        }
    }

    public V get(char c) {
        int indexOf = indexOf(c);
        if (indexOf == -1) {
            return null;
        }
        return toExternal(this.values[indexOf]);
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public Set<Character> keySet() {
        return this.keySet;
    }

    public String keyToString(char c) {
        return Character.toString(c);
    }

    public void putAll(Map<? extends Character, ? extends V> map) {
        if (map instanceof CharObjectHashMap) {
            CharObjectHashMap charObjectHashMap = (CharObjectHashMap) map;
            int i = 0;
            while (true) {
                V[] vArr = charObjectHashMap.values;
                if (i < vArr.length) {
                    V v = vArr[i];
                    if (v != null) {
                        put(charObjectHashMap.keys[i], v);
                    }
                    i++;
                } else {
                    return;
                }
            }
        } else {
            for (Map.Entry next : map.entrySet()) {
                put((Character) next.getKey(), next.getValue());
            }
        }
    }

    public V remove(char c) {
        int indexOf = indexOf(c);
        if (indexOf == -1) {
            return null;
        }
        V v = this.values[indexOf];
        removeAt(indexOf);
        return toExternal(v);
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.size * 4);
        sb.append('{');
        boolean z = true;
        int i = 0;
        while (true) {
            V[] vArr = this.values;
            if (i < vArr.length) {
                V v = vArr[i];
                if (v != null) {
                    if (!z) {
                        sb.append(", ");
                    }
                    sb.append(keyToString(this.keys[i]));
                    sb.append('=');
                    sb.append(v == this ? "(this Map)" : toExternal(v));
                    z = false;
                }
                i++;
            } else {
                sb.append('}');
                return sb.toString();
            }
        }
    }

    public Collection<V> values() {
        return new AbstractCollection<V>() {
            public Iterator<V> iterator() {
                return new Iterator<V>() {
                    final CharObjectHashMap<V>.PrimitiveIterator iter;

                    {
                        this.iter = new PrimitiveIterator();
                    }

                    public boolean hasNext() {
                        return this.iter.hasNext();
                    }

                    public V next() {
                        return this.iter.next().value();
                    }

                    public void remove() {
                        this.iter.remove();
                    }
                };
            }

            public int size() {
                return CharObjectHashMap.this.size;
            }
        };
    }

    public CharObjectHashMap(int i) {
        this(i, 0.5f);
    }

    public boolean containsKey(Object obj) {
        return containsKey(objectToKey(obj));
    }

    public int hashCode() {
        int i = this.size;
        for (char hashCode : this.keys) {
            i ^= hashCode(hashCode);
        }
        return i;
    }

    public V put(char c, V v) {
        int hashIndex = hashIndex(c);
        int i = hashIndex;
        do {
            V[] vArr = this.values;
            V v2 = vArr[i];
            if (v2 == null) {
                this.keys[i] = c;
                vArr[i] = toInternal(v);
                growSize();
                return null;
            } else if (this.keys[i] == c) {
                vArr[i] = toInternal(v);
                return toExternal(v2);
            } else {
                i = probeNext(i);
            }
        } while (i != hashIndex);
        throw new IllegalStateException("Unable to insert");
    }

    public CharObjectHashMap(int i, float f) {
        this.keySet = new KeySet();
        this.entrySet = new EntrySet();
        this.entries = new Iterable<CharObjectMap.PrimitiveEntry<V>>() {
            public Iterator<CharObjectMap.PrimitiveEntry<V>> iterator() {
                return new PrimitiveIterator();
            }
        };
        if (f <= 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("loadFactor must be > 0 and <= 1");
        }
        this.loadFactor = f;
        int safeFindNextPositivePowerOfTwo = MathUtil.safeFindNextPositivePowerOfTwo(i);
        this.mask = safeFindNextPositivePowerOfTwo - 1;
        this.keys = new char[safeFindNextPositivePowerOfTwo];
        this.values = new Object[safeFindNextPositivePowerOfTwo];
        this.maxSize = calcMaxSize(safeFindNextPositivePowerOfTwo);
    }

    public V get(Object obj) {
        return get(objectToKey(obj));
    }

    public V remove(Object obj) {
        return remove(objectToKey(obj));
    }

    public V put(Character ch, V v) {
        return put(objectToKey(ch), v);
    }
}
