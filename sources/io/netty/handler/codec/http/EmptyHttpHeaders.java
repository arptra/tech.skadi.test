package io.netty.handler.codec.http;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EmptyHttpHeaders extends HttpHeaders {
    static final Iterator<Map.Entry<CharSequence, CharSequence>> EMPTY_CHARS_ITERATOR = Collections.emptyList().iterator();
    public static final EmptyHttpHeaders INSTANCE = instance();

    @Deprecated
    public static final class InstanceInitializer {
        /* access modifiers changed from: private */
        @Deprecated
        public static final EmptyHttpHeaders EMPTY_HEADERS = new EmptyHttpHeaders();

        private InstanceInitializer() {
        }
    }

    @Deprecated
    public static EmptyHttpHeaders instance() {
        return InstanceInitializer.EMPTY_HEADERS;
    }

    public HttpHeaders add(String str, Object obj) {
        throw new UnsupportedOperationException("read only");
    }

    public HttpHeaders addInt(CharSequence charSequence, int i) {
        throw new UnsupportedOperationException("read only");
    }

    public HttpHeaders addShort(CharSequence charSequence, short s) {
        throw new UnsupportedOperationException("read only");
    }

    public HttpHeaders clear() {
        throw new UnsupportedOperationException("read only");
    }

    public boolean contains(String str) {
        return false;
    }

    public List<Map.Entry<String, String>> entries() {
        return Collections.emptyList();
    }

    public String get(String str) {
        return null;
    }

    public List<String> getAll(String str) {
        return Collections.emptyList();
    }

    public int getInt(CharSequence charSequence, int i) {
        return i;
    }

    public Short getShort(CharSequence charSequence) {
        return null;
    }

    public long getTimeMillis(CharSequence charSequence, long j) {
        return j;
    }

    public boolean isEmpty() {
        return true;
    }

    public Iterator<Map.Entry<String, String>> iterator() {
        return entries().iterator();
    }

    public Iterator<Map.Entry<CharSequence, CharSequence>> iteratorCharSequence() {
        return EMPTY_CHARS_ITERATOR;
    }

    public Set<String> names() {
        return Collections.emptySet();
    }

    public HttpHeaders remove(String str) {
        throw new UnsupportedOperationException("read only");
    }

    public HttpHeaders set(String str, Object obj) {
        throw new UnsupportedOperationException("read only");
    }

    public HttpHeaders setInt(CharSequence charSequence, int i) {
        throw new UnsupportedOperationException("read only");
    }

    public HttpHeaders setShort(CharSequence charSequence, short s) {
        throw new UnsupportedOperationException("read only");
    }

    public int size() {
        return 0;
    }

    public HttpHeaders add(String str, Iterable<?> iterable) {
        throw new UnsupportedOperationException("read only");
    }

    public Integer getInt(CharSequence charSequence) {
        return null;
    }

    public short getShort(CharSequence charSequence, short s) {
        return s;
    }

    public Long getTimeMillis(CharSequence charSequence) {
        return null;
    }

    public HttpHeaders set(String str, Iterable<?> iterable) {
        throw new UnsupportedOperationException("read only");
    }
}
