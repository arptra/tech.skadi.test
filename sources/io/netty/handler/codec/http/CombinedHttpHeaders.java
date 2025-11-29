package io.netty.handler.codec.http;

import io.netty.handler.codec.DefaultHeaders;
import io.netty.handler.codec.Headers;
import io.netty.handler.codec.ValueConverter;
import io.netty.util.AsciiString;
import io.netty.util.HashingStrategy;
import io.netty.util.internal.StringUtil;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CombinedHttpHeaders extends DefaultHttpHeaders {

    public static final class CombinedHttpHeadersImpl extends DefaultHeaders<CharSequence, CharSequence, CombinedHttpHeadersImpl> {
        private static final int VALUE_LENGTH_ESTIMATE = 10;
        private CsvValueEscaper<CharSequence> charSequenceEscaper;
        private CsvValueEscaper<Object> objectEscaper;

        public interface CsvValueEscaper<T> {
            CharSequence escape(CharSequence charSequence, T t);
        }

        public CombinedHttpHeadersImpl(HashingStrategy<CharSequence> hashingStrategy, ValueConverter<CharSequence> valueConverter, DefaultHeaders.NameValidator<CharSequence> nameValidator) {
            super(hashingStrategy, valueConverter, nameValidator);
        }

        private CombinedHttpHeadersImpl addEscapedValue(CharSequence charSequence, CharSequence charSequence2) {
            CharSequence charSequence3 = (CharSequence) get(charSequence);
            if (charSequence3 == null || cannotBeCombined(charSequence)) {
                super.add(charSequence, charSequence2);
            } else {
                set(charSequence, commaSeparateEscapedValues(charSequence3, charSequence2));
            }
            return this;
        }

        private static boolean cannotBeCombined(CharSequence charSequence) {
            return HttpHeaderNames.SET_COOKIE.contentEqualsIgnoreCase(charSequence);
        }

        private CsvValueEscaper<CharSequence> charSequenceEscaper() {
            if (this.charSequenceEscaper == null) {
                this.charSequenceEscaper = new CsvValueEscaper<CharSequence>() {
                    public CharSequence escape(CharSequence charSequence, CharSequence charSequence2) {
                        return StringUtil.escapeCsv(charSequence2, true);
                    }
                };
            }
            return this.charSequenceEscaper;
        }

        private static <T> CharSequence commaSeparate(CharSequence charSequence, CsvValueEscaper<T> csvValueEscaper, T... tArr) {
            StringBuilder sb = new StringBuilder(tArr.length * 10);
            if (tArr.length > 0) {
                int length = tArr.length - 1;
                for (int i = 0; i < length; i++) {
                    sb.append(csvValueEscaper.escape(charSequence, tArr[i]));
                    sb.append(StringUtil.COMMA);
                }
                sb.append(csvValueEscaper.escape(charSequence, tArr[length]));
            }
            return sb;
        }

        private static CharSequence commaSeparateEscapedValues(CharSequence charSequence, CharSequence charSequence2) {
            StringBuilder sb = new StringBuilder(charSequence.length() + 1 + charSequence2.length());
            sb.append(charSequence);
            sb.append(StringUtil.COMMA);
            sb.append(charSequence2);
            return sb;
        }

        private CsvValueEscaper<Object> objectEscaper() {
            if (this.objectEscaper == null) {
                this.objectEscaper = new CsvValueEscaper<Object>() {
                    public CharSequence escape(CharSequence charSequence, Object obj) {
                        try {
                            return StringUtil.escapeCsv((CharSequence) CombinedHttpHeadersImpl.this.valueConverter().convertObject(obj), true);
                        } catch (IllegalArgumentException e) {
                            throw new IllegalArgumentException("Failed to convert object value for header '" + charSequence + '\'', e);
                        }
                    }
                };
            }
            return this.objectEscaper;
        }

        public List<CharSequence> getAll(CharSequence charSequence) {
            List<CharSequence> all = super.getAll(charSequence);
            if (all.isEmpty() || cannotBeCombined(charSequence)) {
                return all;
            }
            if (all.size() == 1) {
                return StringUtil.unescapeCsvFields(all.get(0));
            }
            throw new IllegalStateException("CombinedHttpHeaders should only have one value");
        }

        public CombinedHttpHeadersImpl setAll(Headers<? extends CharSequence, ? extends CharSequence, ?> headers) {
            if (headers == this) {
                return this;
            }
            for (CharSequence remove : headers.names()) {
                remove(remove);
            }
            return add((Headers) headers);
        }

        public Iterator<CharSequence> valueIterator(CharSequence charSequence) {
            Iterator<CharSequence> valueIterator = super.valueIterator(charSequence);
            if (!valueIterator.hasNext() || cannotBeCombined(charSequence)) {
                return valueIterator;
            }
            Iterator<CharSequence> it = StringUtil.unescapeCsvFields(valueIterator.next()).iterator();
            if (!valueIterator.hasNext()) {
                return it;
            }
            throw new IllegalStateException("CombinedHttpHeaders should only have one value");
        }

        public CombinedHttpHeadersImpl addObject(CharSequence charSequence, Object obj) {
            return addEscapedValue(charSequence, commaSeparate(charSequence, objectEscaper(), (T[]) new Object[]{obj}));
        }

        public CombinedHttpHeadersImpl set(Headers<? extends CharSequence, ? extends CharSequence, ?> headers) {
            if (headers == this) {
                return this;
            }
            clear();
            return add((Headers) headers);
        }

        public CombinedHttpHeadersImpl setObject(CharSequence charSequence, Object obj) {
            set(charSequence, commaSeparate(charSequence, objectEscaper(), (T[]) new Object[]{obj}));
            return this;
        }

        public CombinedHttpHeadersImpl add(Headers<? extends CharSequence, ? extends CharSequence, ?> headers) {
            if (headers != this) {
                if (!(headers instanceof CombinedHttpHeadersImpl)) {
                    for (Map.Entry next : headers) {
                        add((CharSequence) next.getKey(), (CharSequence) next.getValue());
                    }
                } else if (isEmpty()) {
                    addImpl(headers);
                } else {
                    for (Map.Entry next2 : headers) {
                        addEscapedValue((CharSequence) next2.getKey(), (CharSequence) next2.getValue());
                    }
                }
                return this;
            }
            throw new IllegalArgumentException("can't add to itself.");
        }

        public CombinedHttpHeadersImpl addObject(CharSequence charSequence, Iterable<?> iterable) {
            return addEscapedValue(charSequence, commaSeparate(charSequence, objectEscaper(), iterable));
        }

        public CombinedHttpHeadersImpl setObject(CharSequence charSequence, Object... objArr) {
            set(charSequence, commaSeparate(charSequence, objectEscaper(), (T[]) objArr));
            return this;
        }

        private static <T> CharSequence commaSeparate(CharSequence charSequence, CsvValueEscaper<T> csvValueEscaper, Iterable<? extends T> iterable) {
            StringBuilder sb = iterable instanceof Collection ? new StringBuilder(((Collection) iterable).size() * 10) : new StringBuilder();
            Iterator<? extends T> it = iterable.iterator();
            if (it.hasNext()) {
                Object next = it.next();
                while (it.hasNext()) {
                    sb.append(csvValueEscaper.escape(charSequence, next));
                    sb.append(StringUtil.COMMA);
                    next = it.next();
                }
                sb.append(csvValueEscaper.escape(charSequence, next));
            }
            return sb;
        }

        public CombinedHttpHeadersImpl addObject(CharSequence charSequence, Object... objArr) {
            return addEscapedValue(charSequence, commaSeparate(charSequence, objectEscaper(), (T[]) objArr));
        }

        public CombinedHttpHeadersImpl set(CharSequence charSequence, CharSequence... charSequenceArr) {
            set(charSequence, commaSeparate(charSequence, charSequenceEscaper(), (T[]) charSequenceArr));
            return this;
        }

        public CombinedHttpHeadersImpl setObject(CharSequence charSequence, Iterable<?> iterable) {
            set(charSequence, commaSeparate(charSequence, objectEscaper(), iterable));
            return this;
        }

        public CombinedHttpHeadersImpl set(CharSequence charSequence, Iterable<? extends CharSequence> iterable) {
            set(charSequence, commaSeparate(charSequence, charSequenceEscaper(), iterable));
            return this;
        }

        public CombinedHttpHeadersImpl add(CharSequence charSequence, CharSequence charSequence2) {
            return addEscapedValue(charSequence, charSequenceEscaper().escape(charSequence, charSequence2));
        }

        public CombinedHttpHeadersImpl add(CharSequence charSequence, CharSequence... charSequenceArr) {
            return addEscapedValue(charSequence, commaSeparate(charSequence, charSequenceEscaper(), (T[]) charSequenceArr));
        }

        public CombinedHttpHeadersImpl add(CharSequence charSequence, Iterable<? extends CharSequence> iterable) {
            return addEscapedValue(charSequence, commaSeparate(charSequence, charSequenceEscaper(), iterable));
        }
    }

    public CombinedHttpHeaders(boolean z) {
        super((DefaultHeaders<CharSequence, CharSequence, ?>) new CombinedHttpHeadersImpl(AsciiString.CASE_INSENSITIVE_HASHER, DefaultHttpHeaders.valueConverter(z), DefaultHttpHeaders.nameValidator(z)));
    }

    public boolean containsValue(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        return super.containsValue(charSequence, StringUtil.trimOws(charSequence2), z);
    }
}
