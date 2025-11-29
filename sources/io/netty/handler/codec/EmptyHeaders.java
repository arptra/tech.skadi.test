package io.netty.handler.codec;

import io.netty.handler.codec.Headers;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EmptyHeaders<K, V, T extends Headers<K, V, T>> implements Headers<K, V, T> {
    private T thisT() {
        return this;
    }

    public T add(K k, V v) {
        throw new UnsupportedOperationException("read only");
    }

    public T addBoolean(K k, boolean z) {
        throw new UnsupportedOperationException("read only");
    }

    public T addByte(K k, byte b) {
        throw new UnsupportedOperationException("read only");
    }

    public T addChar(K k, char c) {
        throw new UnsupportedOperationException("read only");
    }

    public T addDouble(K k, double d) {
        throw new UnsupportedOperationException("read only");
    }

    public T addFloat(K k, float f) {
        throw new UnsupportedOperationException("read only");
    }

    public T addInt(K k, int i) {
        throw new UnsupportedOperationException("read only");
    }

    public T addLong(K k, long j) {
        throw new UnsupportedOperationException("read only");
    }

    public T addObject(K k, Object obj) {
        throw new UnsupportedOperationException("read only");
    }

    public T addShort(K k, short s) {
        throw new UnsupportedOperationException("read only");
    }

    public T addTimeMillis(K k, long j) {
        throw new UnsupportedOperationException("read only");
    }

    public T clear() {
        return thisT();
    }

    public boolean contains(K k) {
        return false;
    }

    public boolean containsBoolean(K k, boolean z) {
        return false;
    }

    public boolean containsByte(K k, byte b) {
        return false;
    }

    public boolean containsChar(K k, char c) {
        return false;
    }

    public boolean containsDouble(K k, double d) {
        return false;
    }

    public boolean containsFloat(K k, float f) {
        return false;
    }

    public boolean containsInt(K k, int i) {
        return false;
    }

    public boolean containsLong(K k, long j) {
        return false;
    }

    public boolean containsObject(K k, Object obj) {
        return false;
    }

    public boolean containsShort(K k, short s) {
        return false;
    }

    public boolean containsTimeMillis(K k, long j) {
        return false;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Headers)) {
            return false;
        }
        return isEmpty() && ((Headers) obj).isEmpty();
    }

    public V get(K k) {
        return null;
    }

    public List<V> getAll(K k) {
        return Collections.emptyList();
    }

    public List<V> getAllAndRemove(K k) {
        return Collections.emptyList();
    }

    public V getAndRemove(K k) {
        return null;
    }

    public Boolean getBoolean(K k) {
        return null;
    }

    public Boolean getBooleanAndRemove(K k) {
        return null;
    }

    public byte getByte(K k, byte b) {
        return b;
    }

    public byte getByteAndRemove(K k, byte b) {
        return b;
    }

    public char getChar(K k, char c) {
        return c;
    }

    public char getCharAndRemove(K k, char c) {
        return c;
    }

    public double getDouble(K k, double d) {
        return d;
    }

    public double getDoubleAndRemove(K k, double d) {
        return d;
    }

    public float getFloat(K k, float f) {
        return f;
    }

    public float getFloatAndRemove(K k, float f) {
        return f;
    }

    public int getInt(K k, int i) {
        return i;
    }

    public int getIntAndRemove(K k, int i) {
        return i;
    }

    public long getLong(K k, long j) {
        return j;
    }

    public long getLongAndRemove(K k, long j) {
        return j;
    }

    public Short getShort(K k) {
        return null;
    }

    public Short getShortAndRemove(K k) {
        return null;
    }

    public long getTimeMillis(K k, long j) {
        return j;
    }

    public long getTimeMillisAndRemove(K k, long j) {
        return j;
    }

    public int hashCode() {
        return -1028477387;
    }

    public boolean isEmpty() {
        return true;
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        return Collections.emptyList().iterator();
    }

    public Set<K> names() {
        return Collections.emptySet();
    }

    public boolean remove(K k) {
        return false;
    }

    public T set(K k, V v) {
        throw new UnsupportedOperationException("read only");
    }

    public T setAll(Headers<? extends K, ? extends V, ?> headers) {
        throw new UnsupportedOperationException("read only");
    }

    public T setBoolean(K k, boolean z) {
        throw new UnsupportedOperationException("read only");
    }

    public T setByte(K k, byte b) {
        throw new UnsupportedOperationException("read only");
    }

    public T setChar(K k, char c) {
        throw new UnsupportedOperationException("read only");
    }

    public T setDouble(K k, double d) {
        throw new UnsupportedOperationException("read only");
    }

    public T setFloat(K k, float f) {
        throw new UnsupportedOperationException("read only");
    }

    public T setInt(K k, int i) {
        throw new UnsupportedOperationException("read only");
    }

    public T setLong(K k, long j) {
        throw new UnsupportedOperationException("read only");
    }

    public T setObject(K k, Object obj) {
        throw new UnsupportedOperationException("read only");
    }

    public T setShort(K k, short s) {
        throw new UnsupportedOperationException("read only");
    }

    public T setTimeMillis(K k, long j) {
        throw new UnsupportedOperationException("read only");
    }

    public int size() {
        return 0;
    }

    public String toString() {
        return getClass().getSimpleName() + '[' + ']';
    }

    public Iterator<V> valueIterator(K k) {
        return Collections.emptyList().iterator();
    }

    public T add(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException("read only");
    }

    public T addObject(K k, Iterable<?> iterable) {
        throw new UnsupportedOperationException("read only");
    }

    public boolean contains(K k, V v) {
        return false;
    }

    public V get(K k, V v) {
        return v;
    }

    public V getAndRemove(K k, V v) {
        return v;
    }

    public boolean getBoolean(K k, boolean z) {
        return z;
    }

    public boolean getBooleanAndRemove(K k, boolean z) {
        return z;
    }

    public Byte getByte(K k) {
        return null;
    }

    public Byte getByteAndRemove(K k) {
        return null;
    }

    public Character getChar(K k) {
        return null;
    }

    public Character getCharAndRemove(K k) {
        return null;
    }

    public Double getDouble(K k) {
        return null;
    }

    public Double getDoubleAndRemove(K k) {
        return null;
    }

    public Float getFloat(K k) {
        return null;
    }

    public Float getFloatAndRemove(K k) {
        return null;
    }

    public Integer getInt(K k) {
        return null;
    }

    public Integer getIntAndRemove(K k) {
        return null;
    }

    public Long getLong(K k) {
        return null;
    }

    public Long getLongAndRemove(K k) {
        return null;
    }

    public short getShort(K k, short s) {
        return s;
    }

    public short getShortAndRemove(K k, short s) {
        return s;
    }

    public Long getTimeMillis(K k) {
        return null;
    }

    public Long getTimeMillisAndRemove(K k) {
        return null;
    }

    public T set(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException("read only");
    }

    public T setObject(K k, Iterable<?> iterable) {
        throw new UnsupportedOperationException("read only");
    }

    public T add(K k, V... vArr) {
        throw new UnsupportedOperationException("read only");
    }

    public T addObject(K k, Object... objArr) {
        throw new UnsupportedOperationException("read only");
    }

    public T set(K k, V... vArr) {
        throw new UnsupportedOperationException("read only");
    }

    public T setObject(K k, Object... objArr) {
        throw new UnsupportedOperationException("read only");
    }

    public T add(Headers<? extends K, ? extends V, ?> headers) {
        throw new UnsupportedOperationException("read only");
    }

    public T set(Headers<? extends K, ? extends V, ?> headers) {
        throw new UnsupportedOperationException("read only");
    }
}
