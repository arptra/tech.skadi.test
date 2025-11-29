package io.netty.handler.codec.http;

import io.netty.handler.codec.CharSequenceValueConverter;
import io.netty.handler.codec.DateFormatter;
import io.netty.handler.codec.DefaultHeaders;
import io.netty.handler.codec.DefaultHeadersImpl;
import io.netty.handler.codec.HeadersUtils;
import io.netty.handler.codec.ValueConverter;
import io.netty.util.AsciiString;
import io.netty.util.ByteProcessor;
import io.netty.util.internal.PlatformDependent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DefaultHttpHeaders extends HttpHeaders {
    /* access modifiers changed from: private */
    public static final ByteProcessor HEADER_NAME_VALIDATOR = new ByteProcessor() {
        public boolean process(byte b) throws Exception {
            DefaultHttpHeaders.validateHeaderNameElement(b);
            return true;
        }
    };
    private static final int HIGHEST_INVALID_VALUE_CHAR_MASK = -16;
    static final DefaultHeaders.NameValidator<CharSequence> HttpNameValidator = new DefaultHeaders.NameValidator<CharSequence>() {
        public void validateName(CharSequence charSequence) {
            if (charSequence == null || charSequence.length() == 0) {
                throw new IllegalArgumentException("empty headers are not allowed [" + charSequence + "]");
            } else if (charSequence instanceof AsciiString) {
                try {
                    ((AsciiString) charSequence).forEachByte(DefaultHttpHeaders.HEADER_NAME_VALIDATOR);
                } catch (Exception e) {
                    PlatformDependent.throwException(e);
                }
            } else {
                for (int i = 0; i < charSequence.length(); i++) {
                    DefaultHttpHeaders.validateHeaderNameElement(charSequence.charAt(i));
                }
            }
        }
    };
    private final DefaultHeaders<CharSequence, CharSequence, ?> headers;

    public static class HeaderValueConverter extends CharSequenceValueConverter {
        static final HeaderValueConverter INSTANCE = new HeaderValueConverter();

        private HeaderValueConverter() {
        }

        public CharSequence convertObject(Object obj) {
            if (obj instanceof CharSequence) {
                return (CharSequence) obj;
            }
            if (obj instanceof Date) {
                return DateFormatter.format((Date) obj);
            }
            if (obj instanceof Calendar) {
                return DateFormatter.format(((Calendar) obj).getTime());
            }
            return obj.toString();
        }
    }

    public static final class HeaderValueConverterAndValidator extends HeaderValueConverter {
        static final HeaderValueConverterAndValidator INSTANCE = new HeaderValueConverterAndValidator();

        private HeaderValueConverterAndValidator() {
            super();
        }

        private static int validateValueChar(CharSequence charSequence, int i, char c) {
            if ((c & 65520) == 0) {
                if (c == 0) {
                    throw new IllegalArgumentException("a header value contains a prohibited character '\u0000'");
                } else if (c == 11) {
                    throw new IllegalArgumentException("a header value contains a prohibited character '\\v'");
                } else if (c == 12) {
                    throw new IllegalArgumentException("a header value contains a prohibited character '\\f'");
                }
            }
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        if (c == 9 || c == ' ') {
                            return 0;
                        }
                        throw new IllegalArgumentException("only ' ' and '\\t' are allowed after '\\n'");
                    }
                } else if (c == 10) {
                    return 2;
                } else {
                    throw new IllegalArgumentException("only '\\n' is allowed after '\\r'");
                }
            } else if (c == 10) {
                return 2;
            } else {
                if (c != 13) {
                    return i;
                }
                return 1;
            }
            return i;
        }

        public CharSequence convertObject(Object obj) {
            CharSequence convertObject = super.convertObject(obj);
            int i = 0;
            for (int i2 = 0; i2 < convertObject.length(); i2++) {
                i = validateValueChar(convertObject, i, convertObject.charAt(i2));
            }
            if (i == 0) {
                return convertObject;
            }
            throw new IllegalArgumentException("a header value must not end with '\\r' or '\\n'");
        }
    }

    public DefaultHttpHeaders() {
        this(true);
    }

    public static DefaultHeaders.NameValidator<CharSequence> nameValidator(boolean z) {
        return z ? HttpNameValidator : DefaultHeaders.NameValidator.NOT_NULL;
    }

    /* access modifiers changed from: private */
    public static void validateHeaderNameElement(byte b) {
        if (!(b == 0 || b == 44 || b == 61 || b == 58 || b == 59)) {
            switch (b) {
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                    break;
                default:
                    switch (b) {
                        case 28:
                        case 29:
                        case 30:
                        case 31:
                        case 32:
                            break;
                        default:
                            if (b < 0) {
                                throw new IllegalArgumentException("a header name cannot contain non-ASCII character: " + b);
                            }
                            return;
                    }
            }
        }
        throw new IllegalArgumentException("a header name cannot contain the following prohibited characters: =,;: \\t\\r\\n\\v\\f: " + b);
    }

    public static ValueConverter<CharSequence> valueConverter(boolean z) {
        return z ? HeaderValueConverterAndValidator.INSTANCE : HeaderValueConverter.INSTANCE;
    }

    public HttpHeaders add(HttpHeaders httpHeaders) {
        if (!(httpHeaders instanceof DefaultHttpHeaders)) {
            return super.add(httpHeaders);
        }
        this.headers.add(((DefaultHttpHeaders) httpHeaders).headers);
        return this;
    }

    public HttpHeaders addInt(CharSequence charSequence, int i) {
        this.headers.addInt(charSequence, i);
        return this;
    }

    public HttpHeaders addShort(CharSequence charSequence, short s) {
        this.headers.addShort(charSequence, s);
        return this;
    }

    public HttpHeaders clear() {
        this.headers.clear();
        return this;
    }

    public boolean contains(String str) {
        return contains((CharSequence) str);
    }

    public HttpHeaders copy() {
        return new DefaultHttpHeaders(this.headers.copy());
    }

    public List<Map.Entry<String, String>> entries() {
        if (isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(this.headers.size());
        Iterator<Map.Entry<String, String>> it = iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        return (obj instanceof DefaultHttpHeaders) && this.headers.equals(((DefaultHttpHeaders) obj).headers, AsciiString.CASE_SENSITIVE_HASHER);
    }

    public String get(String str) {
        return get((CharSequence) str);
    }

    public List<String> getAll(String str) {
        return getAll((CharSequence) str);
    }

    public Integer getInt(CharSequence charSequence) {
        return this.headers.getInt(charSequence);
    }

    public Short getShort(CharSequence charSequence) {
        return this.headers.getShort(charSequence);
    }

    public Long getTimeMillis(CharSequence charSequence) {
        return this.headers.getTimeMillis(charSequence);
    }

    public int hashCode() {
        return this.headers.hashCode(AsciiString.CASE_SENSITIVE_HASHER);
    }

    public boolean isEmpty() {
        return this.headers.isEmpty();
    }

    @Deprecated
    public Iterator<Map.Entry<String, String>> iterator() {
        return HeadersUtils.iteratorAsString(this.headers);
    }

    public Iterator<Map.Entry<CharSequence, CharSequence>> iteratorCharSequence() {
        return this.headers.iterator();
    }

    public Set<String> names() {
        return HeadersUtils.namesAsString(this.headers);
    }

    public HttpHeaders remove(String str) {
        this.headers.remove(str);
        return this;
    }

    public HttpHeaders set(HttpHeaders httpHeaders) {
        if (!(httpHeaders instanceof DefaultHttpHeaders)) {
            return super.set(httpHeaders);
        }
        this.headers.set(((DefaultHttpHeaders) httpHeaders).headers);
        return this;
    }

    public HttpHeaders setInt(CharSequence charSequence, int i) {
        this.headers.setInt(charSequence, i);
        return this;
    }

    public HttpHeaders setShort(CharSequence charSequence, short s) {
        this.headers.setShort(charSequence, s);
        return this;
    }

    public int size() {
        return this.headers.size();
    }

    public Iterator<CharSequence> valueCharSequenceIterator(CharSequence charSequence) {
        return this.headers.valueIterator(charSequence);
    }

    public Iterator<String> valueStringIterator(CharSequence charSequence) {
        final Iterator<CharSequence> valueCharSequenceIterator = valueCharSequenceIterator(charSequence);
        return new Iterator<String>() {
            public boolean hasNext() {
                return valueCharSequenceIterator.hasNext();
            }

            public void remove() {
                valueCharSequenceIterator.remove();
            }

            public String next() {
                return ((CharSequence) valueCharSequenceIterator.next()).toString();
            }
        };
    }

    public DefaultHttpHeaders(boolean z) {
        this(z, nameValidator(z));
    }

    public boolean contains(CharSequence charSequence) {
        return this.headers.contains(charSequence);
    }

    public String get(CharSequence charSequence) {
        return HeadersUtils.getAsString(this.headers, charSequence);
    }

    public List<String> getAll(CharSequence charSequence) {
        return HeadersUtils.getAllAsString(this.headers, charSequence);
    }

    public int getInt(CharSequence charSequence, int i) {
        return this.headers.getInt(charSequence, i);
    }

    public short getShort(CharSequence charSequence, short s) {
        return this.headers.getShort(charSequence, s);
    }

    public long getTimeMillis(CharSequence charSequence, long j) {
        return this.headers.getTimeMillis(charSequence, j);
    }

    public HttpHeaders remove(CharSequence charSequence) {
        this.headers.remove(charSequence);
        return this;
    }

    public DefaultHttpHeaders(boolean z, DefaultHeaders.NameValidator<CharSequence> nameValidator) {
        this((DefaultHeaders<CharSequence, CharSequence, ?>) new DefaultHeadersImpl(AsciiString.CASE_INSENSITIVE_HASHER, valueConverter(z), nameValidator));
    }

    /* access modifiers changed from: private */
    public static void validateHeaderNameElement(char c) {
        if (!(c == 0 || c == ',' || c == '=' || c == ':' || c == ';')) {
            switch (c) {
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                    break;
                default:
                    switch (c) {
                        case 28:
                        case 29:
                        case 30:
                        case 31:
                        case ' ':
                            break;
                        default:
                            if (c > 127) {
                                throw new IllegalArgumentException("a header name cannot contain non-ASCII character: " + c);
                            }
                            return;
                    }
            }
        }
        throw new IllegalArgumentException("a header name cannot contain the following prohibited characters: =,;: \\t\\r\\n\\v\\f: " + c);
    }

    public boolean contains(String str, String str2, boolean z) {
        return contains((CharSequence) str, (CharSequence) str2, z);
    }

    public HttpHeaders add(String str, Object obj) {
        this.headers.addObject(str, obj);
        return this;
    }

    public boolean contains(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        return this.headers.contains(charSequence, charSequence2, z ? AsciiString.CASE_INSENSITIVE_HASHER : AsciiString.CASE_SENSITIVE_HASHER);
    }

    public HttpHeaders set(String str, Object obj) {
        this.headers.setObject(str, obj);
        return this;
    }

    public HttpHeaders add(CharSequence charSequence, Object obj) {
        this.headers.addObject(charSequence, obj);
        return this;
    }

    public HttpHeaders set(CharSequence charSequence, Object obj) {
        this.headers.setObject(charSequence, obj);
        return this;
    }

    public DefaultHttpHeaders(DefaultHeaders<CharSequence, CharSequence, ?> defaultHeaders) {
        this.headers = defaultHeaders;
    }

    public HttpHeaders add(String str, Iterable<?> iterable) {
        this.headers.addObject(str, iterable);
        return this;
    }

    public HttpHeaders set(String str, Iterable<?> iterable) {
        this.headers.setObject(str, iterable);
        return this;
    }

    public HttpHeaders add(CharSequence charSequence, Iterable<?> iterable) {
        this.headers.addObject(charSequence, iterable);
        return this;
    }

    public HttpHeaders set(CharSequence charSequence, Iterable<?> iterable) {
        this.headers.setObject(charSequence, iterable);
        return this;
    }
}
