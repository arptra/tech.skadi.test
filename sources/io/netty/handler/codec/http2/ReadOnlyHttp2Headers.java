package io.netty.handler.codec.http2;

import io.netty.handler.codec.CharSequenceValueConverter;
import io.netty.handler.codec.Headers;
import io.netty.handler.codec.http2.Http2Headers;
import io.netty.util.AsciiString;
import io.netty.util.HashingStrategy;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public final class ReadOnlyHttp2Headers implements Http2Headers {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final byte PSEUDO_HEADER_TOKEN = 58;
    /* access modifiers changed from: private */
    public final AsciiString[] otherHeaders;
    /* access modifiers changed from: private */
    public final AsciiString[] pseudoHeaders;

    public final class ReadOnlyIterator implements Map.Entry<CharSequence, CharSequence>, Iterator<Map.Entry<CharSequence, CharSequence>> {
        private AsciiString[] current;
        private int i;
        private AsciiString key;
        private AsciiString value;

        private ReadOnlyIterator() {
            this.current = ReadOnlyHttp2Headers.this.pseudoHeaders.length != 0 ? ReadOnlyHttp2Headers.this.pseudoHeaders : ReadOnlyHttp2Headers.this.otherHeaders;
        }

        public boolean hasNext() {
            return this.i != this.current.length;
        }

        public void remove() {
            throw new UnsupportedOperationException("read only");
        }

        public String toString() {
            return this.key.toString() + '=' + this.value.toString();
        }

        public CharSequence getKey() {
            return this.key;
        }

        public CharSequence getValue() {
            return this.value;
        }

        public Map.Entry<CharSequence, CharSequence> next() {
            if (hasNext()) {
                AsciiString[] asciiStringArr = this.current;
                int i2 = this.i;
                this.key = asciiStringArr[i2];
                this.value = asciiStringArr[i2 + 1];
                int i3 = i2 + 2;
                this.i = i3;
                if (i3 == asciiStringArr.length && asciiStringArr == ReadOnlyHttp2Headers.this.pseudoHeaders) {
                    this.current = ReadOnlyHttp2Headers.this.otherHeaders;
                    this.i = 0;
                }
                return this;
            }
            throw new NoSuchElementException();
        }

        public CharSequence setValue(CharSequence charSequence) {
            throw new UnsupportedOperationException("read only");
        }
    }

    public final class ReadOnlyValueIterator implements Iterator<CharSequence> {
        private AsciiString[] current;
        private int i;
        private final CharSequence name;
        private final int nameHash;
        private AsciiString next;

        public ReadOnlyValueIterator(CharSequence charSequence) {
            this.current = ReadOnlyHttp2Headers.this.pseudoHeaders.length != 0 ? ReadOnlyHttp2Headers.this.pseudoHeaders : ReadOnlyHttp2Headers.this.otherHeaders;
            this.nameHash = AsciiString.hashCode(charSequence);
            this.name = charSequence;
            calculateNext();
        }

        private void calculateNext() {
            while (true) {
                int i2 = this.i;
                AsciiString[] asciiStringArr = this.current;
                if (i2 < asciiStringArr.length) {
                    AsciiString asciiString = asciiStringArr[i2];
                    if (asciiString.hashCode() != this.nameHash || !asciiString.contentEqualsIgnoreCase(this.name)) {
                        this.i += 2;
                    } else {
                        int i3 = this.i;
                        int i4 = i3 + 1;
                        AsciiString[] asciiStringArr2 = this.current;
                        if (i4 < asciiStringArr2.length) {
                            this.next = asciiStringArr2[i3 + 1];
                            this.i = i3 + 2;
                            return;
                        }
                        return;
                    }
                } else if (asciiStringArr == ReadOnlyHttp2Headers.this.pseudoHeaders) {
                    this.i = 0;
                    this.current = ReadOnlyHttp2Headers.this.otherHeaders;
                    calculateNext();
                    return;
                } else {
                    this.next = null;
                    return;
                }
            }
        }

        public boolean hasNext() {
            return this.next != null;
        }

        public void remove() {
            throw new UnsupportedOperationException("read only");
        }

        public CharSequence next() {
            if (hasNext()) {
                AsciiString asciiString = this.next;
                calculateNext();
                return asciiString;
            }
            throw new NoSuchElementException();
        }
    }

    private ReadOnlyHttp2Headers(boolean z, AsciiString[] asciiStringArr, AsciiString... asciiStringArr2) {
        if ((asciiStringArr2.length & 1) == 0) {
            if (z) {
                validateHeaders(asciiStringArr, asciiStringArr2);
            }
            this.pseudoHeaders = asciiStringArr;
            this.otherHeaders = asciiStringArr2;
            return;
        }
        throw newInvalidArraySizeException();
    }

    public static ReadOnlyHttp2Headers clientHeaders(boolean z, AsciiString asciiString, AsciiString asciiString2, AsciiString asciiString3, AsciiString asciiString4, AsciiString... asciiStringArr) {
        return new ReadOnlyHttp2Headers(z, new AsciiString[]{Http2Headers.PseudoHeaderName.METHOD.value(), asciiString, Http2Headers.PseudoHeaderName.PATH.value(), asciiString2, Http2Headers.PseudoHeaderName.SCHEME.value(), asciiString3, Http2Headers.PseudoHeaderName.AUTHORITY.value(), asciiString4}, asciiStringArr);
    }

    private AsciiString get0(CharSequence charSequence) {
        int hashCode = AsciiString.hashCode(charSequence);
        int length = this.pseudoHeaders.length - 1;
        for (int i = 0; i < length; i += 2) {
            AsciiString asciiString = this.pseudoHeaders[i];
            if (asciiString.hashCode() == hashCode && asciiString.contentEqualsIgnoreCase(charSequence)) {
                return this.pseudoHeaders[i + 1];
            }
        }
        int length2 = this.otherHeaders.length - 1;
        for (int i2 = 0; i2 < length2; i2 += 2) {
            AsciiString asciiString2 = this.otherHeaders[i2];
            if (asciiString2.hashCode() == hashCode && asciiString2.contentEqualsIgnoreCase(charSequence)) {
                return this.otherHeaders[i2 + 1];
            }
        }
        return null;
    }

    private static IllegalArgumentException newInvalidArraySizeException() {
        return new IllegalArgumentException("pseudoHeaders and otherHeaders must be arrays of [name, value] pairs");
    }

    public static ReadOnlyHttp2Headers serverHeaders(boolean z, AsciiString asciiString, AsciiString... asciiStringArr) {
        return new ReadOnlyHttp2Headers(z, new AsciiString[]{Http2Headers.PseudoHeaderName.STATUS.value(), asciiString}, asciiStringArr);
    }

    public static ReadOnlyHttp2Headers trailers(boolean z, AsciiString... asciiStringArr) {
        return new ReadOnlyHttp2Headers(z, EmptyArrays.EMPTY_ASCII_STRINGS, asciiStringArr);
    }

    private static void validateHeaders(AsciiString[] asciiStringArr, AsciiString... asciiStringArr2) {
        for (int i = 1; i < asciiStringArr.length; i += 2) {
            ObjectUtil.checkNotNullArrayParam(asciiStringArr[i], i, "pseudoHeaders");
        }
        int length = asciiStringArr2.length - 1;
        boolean z = false;
        for (int i2 = 0; i2 < length; i2 += 2) {
            AsciiString asciiString = asciiStringArr2[i2];
            DefaultHttp2Headers.HTTP2_NAME_VALIDATOR.validateName(asciiString);
            if (!z && !asciiString.isEmpty() && asciiString.byteAt(0) != 58) {
                z = true;
            } else if (z && !asciiString.isEmpty() && asciiString.byteAt(0) == 58) {
                throw new IllegalArgumentException("otherHeaders name at index " + i2 + " is a pseudo header that appears after non-pseudo headers.");
            }
            int i3 = i2 + 1;
            ObjectUtil.checkNotNullArrayParam(asciiStringArr2[i3], i3, "otherHeaders");
        }
    }

    public Http2Headers authority(CharSequence charSequence) {
        throw new UnsupportedOperationException("read only");
    }

    public boolean containsFloat(CharSequence charSequence, float f) {
        return false;
    }

    public boolean isEmpty() {
        return this.pseudoHeaders.length == 0 && this.otherHeaders.length == 0;
    }

    public Iterator<Map.Entry<CharSequence, CharSequence>> iterator() {
        return new ReadOnlyIterator();
    }

    public Http2Headers method(CharSequence charSequence) {
        throw new UnsupportedOperationException("read only");
    }

    public Set<CharSequence> names() {
        if (isEmpty()) {
            return Collections.emptySet();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(size());
        int length = this.pseudoHeaders.length - 1;
        for (int i = 0; i < length; i += 2) {
            linkedHashSet.add(this.pseudoHeaders[i]);
        }
        int length2 = this.otherHeaders.length - 1;
        for (int i2 = 0; i2 < length2; i2 += 2) {
            linkedHashSet.add(this.otherHeaders[i2]);
        }
        return linkedHashSet;
    }

    public Http2Headers path(CharSequence charSequence) {
        throw new UnsupportedOperationException("read only");
    }

    public Http2Headers scheme(CharSequence charSequence) {
        throw new UnsupportedOperationException("read only");
    }

    public int size() {
        return (this.pseudoHeaders.length + this.otherHeaders.length) >>> 1;
    }

    public Http2Headers status(CharSequence charSequence) {
        throw new UnsupportedOperationException("read only");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(ReadOnlyHttp2Headers.class.getSimpleName());
        sb.append('[');
        Iterator<Map.Entry<CharSequence, CharSequence>> it = iterator();
        String str = "";
        while (it.hasNext()) {
            Map.Entry next = it.next();
            sb.append(str);
            sb.append((CharSequence) next.getKey());
            sb.append(": ");
            sb.append((CharSequence) next.getValue());
            str = ", ";
        }
        sb.append(']');
        return sb.toString();
    }

    public Iterator<CharSequence> valueIterator(CharSequence charSequence) {
        return new ReadOnlyValueIterator(charSequence);
    }

    public Http2Headers addBoolean(CharSequence charSequence, boolean z) {
        throw new UnsupportedOperationException("read only");
    }

    public Http2Headers addByte(CharSequence charSequence, byte b) {
        throw new UnsupportedOperationException("read only");
    }

    public Http2Headers addChar(CharSequence charSequence, char c) {
        throw new UnsupportedOperationException("read only");
    }

    public Http2Headers addDouble(CharSequence charSequence, double d) {
        throw new UnsupportedOperationException("read only");
    }

    public Http2Headers addFloat(CharSequence charSequence, float f) {
        throw new UnsupportedOperationException("read only");
    }

    public Http2Headers addInt(CharSequence charSequence, int i) {
        throw new UnsupportedOperationException("read only");
    }

    public Http2Headers addLong(CharSequence charSequence, long j) {
        throw new UnsupportedOperationException("read only");
    }

    public Http2Headers addShort(CharSequence charSequence, short s) {
        throw new UnsupportedOperationException("read only");
    }

    public Http2Headers addTimeMillis(CharSequence charSequence, long j) {
        throw new UnsupportedOperationException("read only");
    }

    public CharSequence authority() {
        return get((CharSequence) Http2Headers.PseudoHeaderName.AUTHORITY.value());
    }

    public Http2Headers clear() {
        throw new UnsupportedOperationException("read only");
    }

    public boolean containsBoolean(CharSequence charSequence, boolean z) {
        return contains(charSequence, (CharSequence) String.valueOf(z));
    }

    public boolean containsByte(CharSequence charSequence, byte b) {
        return contains(charSequence, (CharSequence) String.valueOf(b));
    }

    public boolean containsChar(CharSequence charSequence, char c) {
        return contains(charSequence, (CharSequence) String.valueOf(c));
    }

    public boolean containsDouble(CharSequence charSequence, double d) {
        return contains(charSequence, (CharSequence) String.valueOf(d));
    }

    public boolean containsInt(CharSequence charSequence, int i) {
        return contains(charSequence, (CharSequence) String.valueOf(i));
    }

    public boolean containsLong(CharSequence charSequence, long j) {
        return contains(charSequence, (CharSequence) String.valueOf(j));
    }

    public boolean containsObject(CharSequence charSequence, Object obj) {
        if (obj instanceof CharSequence) {
            return contains(charSequence, (CharSequence) obj);
        }
        return contains(charSequence, (CharSequence) obj.toString());
    }

    public boolean containsShort(CharSequence charSequence, short s) {
        return contains(charSequence, (CharSequence) String.valueOf(s));
    }

    public boolean containsTimeMillis(CharSequence charSequence, long j) {
        return contains(charSequence, (CharSequence) String.valueOf(j));
    }

    public List<CharSequence> getAll(CharSequence charSequence) {
        int hashCode = AsciiString.hashCode(charSequence);
        ArrayList arrayList = new ArrayList();
        int length = this.pseudoHeaders.length - 1;
        for (int i = 0; i < length; i += 2) {
            AsciiString asciiString = this.pseudoHeaders[i];
            if (asciiString.hashCode() == hashCode && asciiString.contentEqualsIgnoreCase(charSequence)) {
                arrayList.add(this.pseudoHeaders[i + 1]);
            }
        }
        int length2 = this.otherHeaders.length - 1;
        for (int i2 = 0; i2 < length2; i2 += 2) {
            AsciiString asciiString2 = this.otherHeaders[i2];
            if (asciiString2.hashCode() == hashCode && asciiString2.contentEqualsIgnoreCase(charSequence)) {
                arrayList.add(this.otherHeaders[i2 + 1]);
            }
        }
        return arrayList;
    }

    public List<CharSequence> getAllAndRemove(CharSequence charSequence) {
        throw new UnsupportedOperationException("read only");
    }

    public CharSequence method() {
        return get((CharSequence) Http2Headers.PseudoHeaderName.METHOD.value());
    }

    public CharSequence path() {
        return get((CharSequence) Http2Headers.PseudoHeaderName.PATH.value());
    }

    public boolean remove(CharSequence charSequence) {
        throw new UnsupportedOperationException("read only");
    }

    public CharSequence scheme() {
        return get((CharSequence) Http2Headers.PseudoHeaderName.SCHEME.value());
    }

    public Http2Headers setAll(Headers<? extends CharSequence, ? extends CharSequence, ?> headers) {
        throw new UnsupportedOperationException("read only");
    }

    public Http2Headers setBoolean(CharSequence charSequence, boolean z) {
        throw new UnsupportedOperationException("read only");
    }

    public Http2Headers setByte(CharSequence charSequence, byte b) {
        throw new UnsupportedOperationException("read only");
    }

    public Http2Headers setChar(CharSequence charSequence, char c) {
        throw new UnsupportedOperationException("read only");
    }

    public Http2Headers setDouble(CharSequence charSequence, double d) {
        throw new UnsupportedOperationException("read only");
    }

    public Http2Headers setFloat(CharSequence charSequence, float f) {
        throw new UnsupportedOperationException("read only");
    }

    public Http2Headers setInt(CharSequence charSequence, int i) {
        throw new UnsupportedOperationException("read only");
    }

    public Http2Headers setLong(CharSequence charSequence, long j) {
        throw new UnsupportedOperationException("read only");
    }

    public Http2Headers setShort(CharSequence charSequence, short s) {
        throw new UnsupportedOperationException("read only");
    }

    public Http2Headers setTimeMillis(CharSequence charSequence, long j) {
        throw new UnsupportedOperationException("read only");
    }

    public CharSequence status() {
        return get((CharSequence) Http2Headers.PseudoHeaderName.STATUS.value());
    }

    public boolean contains(CharSequence charSequence) {
        return get(charSequence) != null;
    }

    public CharSequence get(CharSequence charSequence) {
        return get0(charSequence);
    }

    public CharSequence getAndRemove(CharSequence charSequence) {
        throw new UnsupportedOperationException("read only");
    }

    public Boolean getBoolean(CharSequence charSequence) {
        AsciiString r0 = get0(charSequence);
        if (r0 != null) {
            return Boolean.valueOf(CharSequenceValueConverter.INSTANCE.convertToBoolean((CharSequence) r0));
        }
        return null;
    }

    public Boolean getBooleanAndRemove(CharSequence charSequence) {
        throw new UnsupportedOperationException("read only");
    }

    public Byte getByte(CharSequence charSequence) {
        AsciiString r0 = get0(charSequence);
        if (r0 != null) {
            return Byte.valueOf(CharSequenceValueConverter.INSTANCE.convertToByte((CharSequence) r0));
        }
        return null;
    }

    public Byte getByteAndRemove(CharSequence charSequence) {
        throw new UnsupportedOperationException("read only");
    }

    public Character getChar(CharSequence charSequence) {
        AsciiString r0 = get0(charSequence);
        if (r0 != null) {
            return Character.valueOf(CharSequenceValueConverter.INSTANCE.convertToChar((CharSequence) r0));
        }
        return null;
    }

    public Character getCharAndRemove(CharSequence charSequence) {
        throw new UnsupportedOperationException("read only");
    }

    public Double getDouble(CharSequence charSequence) {
        AsciiString r0 = get0(charSequence);
        if (r0 != null) {
            return Double.valueOf(CharSequenceValueConverter.INSTANCE.convertToDouble((CharSequence) r0));
        }
        return null;
    }

    public Double getDoubleAndRemove(CharSequence charSequence) {
        throw new UnsupportedOperationException("read only");
    }

    public Float getFloat(CharSequence charSequence) {
        AsciiString r0 = get0(charSequence);
        if (r0 != null) {
            return Float.valueOf(CharSequenceValueConverter.INSTANCE.convertToFloat((CharSequence) r0));
        }
        return null;
    }

    public Float getFloatAndRemove(CharSequence charSequence) {
        throw new UnsupportedOperationException("read only");
    }

    public Integer getInt(CharSequence charSequence) {
        AsciiString r0 = get0(charSequence);
        if (r0 != null) {
            return Integer.valueOf(CharSequenceValueConverter.INSTANCE.convertToInt((CharSequence) r0));
        }
        return null;
    }

    public Integer getIntAndRemove(CharSequence charSequence) {
        throw new UnsupportedOperationException("read only");
    }

    public Long getLong(CharSequence charSequence) {
        AsciiString r0 = get0(charSequence);
        if (r0 != null) {
            return Long.valueOf(CharSequenceValueConverter.INSTANCE.convertToLong((CharSequence) r0));
        }
        return null;
    }

    public Long getLongAndRemove(CharSequence charSequence) {
        throw new UnsupportedOperationException("read only");
    }

    public Short getShort(CharSequence charSequence) {
        AsciiString r0 = get0(charSequence);
        if (r0 != null) {
            return Short.valueOf(CharSequenceValueConverter.INSTANCE.convertToShort((CharSequence) r0));
        }
        return null;
    }

    public Short getShortAndRemove(CharSequence charSequence) {
        throw new UnsupportedOperationException("read only");
    }

    public Long getTimeMillis(CharSequence charSequence) {
        AsciiString r0 = get0(charSequence);
        if (r0 != null) {
            return Long.valueOf(CharSequenceValueConverter.INSTANCE.convertToTimeMillis((CharSequence) r0));
        }
        return null;
    }

    public Long getTimeMillisAndRemove(CharSequence charSequence) {
        throw new UnsupportedOperationException("read only");
    }

    public Http2Headers addObject(CharSequence charSequence, Object obj) {
        throw new UnsupportedOperationException("read only");
    }

    public boolean contains(CharSequence charSequence, CharSequence charSequence2) {
        return contains(charSequence, charSequence2, false);
    }

    public CharSequence get(CharSequence charSequence, CharSequence charSequence2) {
        CharSequence charSequence3 = get(charSequence);
        return charSequence3 != null ? charSequence3 : charSequence2;
    }

    public CharSequence getAndRemove(CharSequence charSequence, CharSequence charSequence2) {
        throw new UnsupportedOperationException("read only");
    }

    public boolean getBooleanAndRemove(CharSequence charSequence, boolean z) {
        throw new UnsupportedOperationException("read only");
    }

    public byte getByteAndRemove(CharSequence charSequence, byte b) {
        throw new UnsupportedOperationException("read only");
    }

    public char getCharAndRemove(CharSequence charSequence, char c) {
        throw new UnsupportedOperationException("read only");
    }

    public double getDoubleAndRemove(CharSequence charSequence, double d) {
        throw new UnsupportedOperationException("read only");
    }

    public float getFloatAndRemove(CharSequence charSequence, float f) {
        throw new UnsupportedOperationException("read only");
    }

    public int getIntAndRemove(CharSequence charSequence, int i) {
        throw new UnsupportedOperationException("read only");
    }

    public long getLongAndRemove(CharSequence charSequence, long j) {
        throw new UnsupportedOperationException("read only");
    }

    public short getShortAndRemove(CharSequence charSequence, short s) {
        throw new UnsupportedOperationException("read only");
    }

    public long getTimeMillisAndRemove(CharSequence charSequence, long j) {
        throw new UnsupportedOperationException("read only");
    }

    public Http2Headers setObject(CharSequence charSequence, Object obj) {
        throw new UnsupportedOperationException("read only");
    }

    public Http2Headers add(CharSequence charSequence, CharSequence charSequence2) {
        throw new UnsupportedOperationException("read only");
    }

    public Http2Headers addObject(CharSequence charSequence, Iterable<?> iterable) {
        throw new UnsupportedOperationException("read only");
    }

    public boolean contains(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        int hashCode = AsciiString.hashCode(charSequence);
        HashingStrategy<CharSequence> hashingStrategy = z ? AsciiString.CASE_INSENSITIVE_HASHER : AsciiString.CASE_SENSITIVE_HASHER;
        int hashCode2 = hashingStrategy.hashCode(charSequence2);
        if (!contains(charSequence, hashCode, charSequence2, hashCode2, hashingStrategy, this.otherHeaders)) {
            return contains(charSequence, hashCode, charSequence2, hashCode2, hashingStrategy, this.pseudoHeaders);
        }
    }

    public boolean getBoolean(CharSequence charSequence, boolean z) {
        Boolean bool = getBoolean(charSequence);
        return bool != null ? bool.booleanValue() : z;
    }

    public byte getByte(CharSequence charSequence, byte b) {
        Byte b2 = getByte(charSequence);
        return b2 != null ? b2.byteValue() : b;
    }

    public char getChar(CharSequence charSequence, char c) {
        Character ch = getChar(charSequence);
        return ch != null ? ch.charValue() : c;
    }

    public double getDouble(CharSequence charSequence, double d) {
        Double d2 = getDouble(charSequence);
        return d2 != null ? d2.doubleValue() : d;
    }

    public float getFloat(CharSequence charSequence, float f) {
        Float f2 = getFloat(charSequence);
        return f2 != null ? f2.floatValue() : f;
    }

    public int getInt(CharSequence charSequence, int i) {
        Integer num = getInt(charSequence);
        return num != null ? num.intValue() : i;
    }

    public long getLong(CharSequence charSequence, long j) {
        Long l = getLong(charSequence);
        return l != null ? l.longValue() : j;
    }

    public short getShort(CharSequence charSequence, short s) {
        Short sh = getShort(charSequence);
        return sh != null ? sh.shortValue() : s;
    }

    public long getTimeMillis(CharSequence charSequence, long j) {
        Long timeMillis = getTimeMillis(charSequence);
        return timeMillis != null ? timeMillis.longValue() : j;
    }

    public Http2Headers set(CharSequence charSequence, CharSequence charSequence2) {
        throw new UnsupportedOperationException("read only");
    }

    public Http2Headers setObject(CharSequence charSequence, Iterable<?> iterable) {
        throw new UnsupportedOperationException("read only");
    }

    public Http2Headers add(CharSequence charSequence, Iterable<? extends CharSequence> iterable) {
        throw new UnsupportedOperationException("read only");
    }

    public Http2Headers addObject(CharSequence charSequence, Object... objArr) {
        throw new UnsupportedOperationException("read only");
    }

    public Http2Headers set(CharSequence charSequence, Iterable<? extends CharSequence> iterable) {
        throw new UnsupportedOperationException("read only");
    }

    public Http2Headers setObject(CharSequence charSequence, Object... objArr) {
        throw new UnsupportedOperationException("read only");
    }

    public Http2Headers add(CharSequence charSequence, CharSequence... charSequenceArr) {
        throw new UnsupportedOperationException("read only");
    }

    public Http2Headers set(CharSequence charSequence, CharSequence... charSequenceArr) {
        throw new UnsupportedOperationException("read only");
    }

    public Http2Headers add(Headers<? extends CharSequence, ? extends CharSequence, ?> headers) {
        throw new UnsupportedOperationException("read only");
    }

    public Http2Headers set(Headers<? extends CharSequence, ? extends CharSequence, ?> headers) {
        throw new UnsupportedOperationException("read only");
    }

    private static boolean contains(CharSequence charSequence, int i, CharSequence charSequence2, int i2, HashingStrategy<CharSequence> hashingStrategy, AsciiString[] asciiStringArr) {
        int length = asciiStringArr.length - 1;
        for (int i3 = 0; i3 < length; i3 += 2) {
            AsciiString asciiString = asciiStringArr[i3];
            AsciiString asciiString2 = asciiStringArr[i3 + 1];
            if (asciiString.hashCode() == i && asciiString2.hashCode() == i2 && asciiString.contentEqualsIgnoreCase(charSequence) && hashingStrategy.equals(asciiString2, charSequence2)) {
                return true;
            }
        }
        return false;
    }
}
