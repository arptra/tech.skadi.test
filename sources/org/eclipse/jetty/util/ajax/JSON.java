package org.eclipse.jetty.util.ajax;

import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang3.BooleanUtils;
import org.eclipse.jetty.util.IO;
import org.eclipse.jetty.util.Loader;
import org.eclipse.jetty.util.QuotedStringTokenizer;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

public class JSON {
    public static final JSON DEFAULT = new JSON();
    static final Logger LOG = Log.getLogger((Class<?>) JSON.class);
    private Map<String, Convertor> _convertors = new ConcurrentHashMap();
    private int _stringBufferSize = 1024;

    public final class ConvertableOutput implements Output {
        private final Appendable _buffer;
        char c;

        public void add(Object obj) {
            if (this.c != 0) {
                JSON.this.append(this._buffer, obj);
                this.c = 0;
                return;
            }
            throw new IllegalStateException();
        }

        public void addClass(Class cls) {
            try {
                char c2 = this.c;
                if (c2 != 0) {
                    this._buffer.append(c2);
                    this._buffer.append("\"class\":");
                    JSON.this.append(this._buffer, (Object) cls.getName());
                    this.c = StringUtil.COMMA;
                    return;
                }
                throw new IllegalStateException();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void complete() {
            try {
                char c2 = this.c;
                if (c2 == '{') {
                    this._buffer.append("{}");
                } else if (c2 != 0) {
                    this._buffer.append("}");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        private ConvertableOutput(Appendable appendable) {
            this.c = '{';
            this._buffer = appendable;
        }

        public void add(String str, Object obj) {
            try {
                char c2 = this.c;
                if (c2 != 0) {
                    this._buffer.append(c2);
                    QuotedStringTokenizer.quote(this._buffer, str);
                    this._buffer.append(':');
                    JSON.this.append(this._buffer, obj);
                    this.c = StringUtil.COMMA;
                    return;
                }
                throw new IllegalStateException();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void add(String str, double d) {
            try {
                char c2 = this.c;
                if (c2 != 0) {
                    this._buffer.append(c2);
                    QuotedStringTokenizer.quote(this._buffer, str);
                    this._buffer.append(':');
                    JSON.this.appendNumber(this._buffer, (Number) Double.valueOf(d));
                    this.c = StringUtil.COMMA;
                    return;
                }
                throw new IllegalStateException();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void add(String str, long j) {
            try {
                char c2 = this.c;
                if (c2 != 0) {
                    this._buffer.append(c2);
                    QuotedStringTokenizer.quote(this._buffer, str);
                    this._buffer.append(':');
                    JSON.this.appendNumber(this._buffer, (Number) Long.valueOf(j));
                    this.c = StringUtil.COMMA;
                    return;
                }
                throw new IllegalStateException();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void add(String str, boolean z) {
            try {
                char c2 = this.c;
                if (c2 != 0) {
                    this._buffer.append(c2);
                    QuotedStringTokenizer.quote(this._buffer, str);
                    this._buffer.append(':');
                    JSON.this.appendBoolean(this._buffer, z ? Boolean.TRUE : Boolean.FALSE);
                    this.c = StringUtil.COMMA;
                    return;
                }
                throw new IllegalStateException();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public interface Convertible {
        void fromJSON(Map map);

        void toJSON(Output output);
    }

    public interface Convertor {
        Object fromJSON(Map map);

        void toJSON(Object obj, Output output);
    }

    public interface Generator {
        void addJSON(Appendable appendable);
    }

    public static class Literal implements Generator {
        private String _json;

        public Literal(String str) {
            if (JSON.LOG.isDebugEnabled()) {
                JSON.parse(str);
            }
            this._json = str;
        }

        public void addJSON(Appendable appendable) {
            try {
                appendable.append(this._json);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public String toString() {
            return this._json;
        }
    }

    public interface Output {
        void add(Object obj);

        void add(String str, double d);

        void add(String str, long j);

        void add(String str, Object obj);

        void add(String str, boolean z);

        void addClass(Class cls);
    }

    public static class ReaderSource implements Source {
        private int _next = -1;
        private Reader _reader;
        private char[] scratch;

        public ReaderSource(Reader reader) {
            this._reader = reader;
        }

        private void getNext() {
            if (this._next < 0) {
                try {
                    this._next = this._reader.read();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        public boolean hasNext() {
            getNext();
            if (this._next >= 0) {
                return true;
            }
            this.scratch = null;
            return false;
        }

        public char next() {
            getNext();
            char c = (char) this._next;
            this._next = -1;
            return c;
        }

        public char peek() {
            getNext();
            return (char) this._next;
        }

        public char[] scratchBuffer() {
            if (this.scratch == null) {
                this.scratch = new char[1024];
            }
            return this.scratch;
        }

        public void setReader(Reader reader) {
            this._reader = reader;
            this._next = -1;
        }
    }

    public interface Source {
        boolean hasNext();

        char next();

        char peek();

        char[] scratchBuffer();
    }

    public static class StringSource implements Source {
        private int index;
        private char[] scratch;
        private final String string;

        public StringSource(String str) {
            this.string = str;
        }

        public boolean hasNext() {
            if (this.index < this.string.length()) {
                return true;
            }
            this.scratch = null;
            return false;
        }

        public char next() {
            String str = this.string;
            int i = this.index;
            this.index = i + 1;
            return str.charAt(i);
        }

        public char peek() {
            return this.string.charAt(this.index);
        }

        public char[] scratchBuffer() {
            if (this.scratch == null) {
                this.scratch = new char[this.string.length()];
            }
            return this.scratch;
        }

        public String toString() {
            return this.string.substring(0, this.index) + "|||" + this.string.substring(this.index);
        }
    }

    public static void complete(String str, Source source) {
        int i = 0;
        while (source.hasNext() && i < str.length()) {
            char next = source.next();
            int i2 = i + 1;
            if (next == str.charAt(i)) {
                i = i2;
            } else {
                throw new IllegalStateException("Unexpected '" + next + " while seeking  \"" + str + "\"");
            }
        }
        if (i < str.length()) {
            throw new IllegalStateException("Expected \"" + str + "\"");
        }
    }

    public static JSON getDefault() {
        return DEFAULT;
    }

    public static Object parse(String str) {
        return DEFAULT.parse((Source) new StringSource(str), false);
    }

    public static void registerConvertor(Class cls, Convertor convertor) {
        DEFAULT.addConvertor(cls, convertor);
    }

    @Deprecated
    public static void setDefault(JSON json) {
    }

    public static String toString(Object obj) {
        JSON json = DEFAULT;
        StringBuilder sb = new StringBuilder(json.getStringBufferSize());
        json.append((Appendable) sb, obj);
        return sb.toString();
    }

    public void addConvertor(Class cls, Convertor convertor) {
        this._convertors.put(cls.getName(), convertor);
    }

    public void addConvertorFor(String str, Convertor convertor) {
        this._convertors.put(str, convertor);
    }

    @Deprecated
    public void append(StringBuffer stringBuffer, Object obj) {
        append((Appendable) stringBuffer, obj);
    }

    @Deprecated
    public void appendArray(StringBuffer stringBuffer, Collection collection) {
        appendArray((Appendable) stringBuffer, collection);
    }

    @Deprecated
    public void appendBoolean(StringBuffer stringBuffer, Boolean bool) {
        appendBoolean((Appendable) stringBuffer, bool);
    }

    @Deprecated
    public void appendJSON(StringBuffer stringBuffer, Convertor convertor, Object obj) {
        appendJSON((Appendable) stringBuffer, convertor, obj);
    }

    @Deprecated
    public void appendMap(StringBuffer stringBuffer, Map<?, ?> map) {
        appendMap((Appendable) stringBuffer, map);
    }

    @Deprecated
    public void appendNull(StringBuffer stringBuffer) {
        appendNull((Appendable) stringBuffer);
    }

    @Deprecated
    public void appendNumber(StringBuffer stringBuffer, Number number) {
        appendNumber((Appendable) stringBuffer, number);
    }

    @Deprecated
    public void appendString(StringBuffer stringBuffer, String str) {
        appendString((Appendable) stringBuffer, str);
    }

    public JSON contextFor(String str) {
        return this;
    }

    public JSON contextForArray() {
        return this;
    }

    public Object convertTo(Class cls, Map map) {
        if (cls == null || !Convertible.class.isAssignableFrom(cls)) {
            Convertor convertor = getConvertor(cls);
            return convertor != null ? convertor.fromJSON(map) : map;
        }
        try {
            Convertible convertible = (Convertible) cls.newInstance();
            convertible.fromJSON(map);
            return convertible;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Object fromJSON(String str) {
        return parse((Source) new StringSource(str));
    }

    public Convertor getConvertor(Class<? super Object> cls) {
        JSON json;
        Convertor convertor = this._convertors.get(cls.getName());
        if (convertor == null && this != (json = DEFAULT)) {
            convertor = json.getConvertor(cls);
        }
        while (convertor == null && cls != Object.class) {
            Class[] interfaces = cls.getInterfaces();
            int i = 0;
            while (convertor == null && interfaces != null && i < interfaces.length) {
                convertor = this._convertors.get(interfaces[i].getName());
                i++;
            }
            if (convertor == null) {
                cls = cls.getSuperclass();
                convertor = this._convertors.get(cls.getName());
            }
        }
        return convertor;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r1 = DEFAULT;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.eclipse.jetty.util.ajax.JSON.Convertor getConvertorFor(java.lang.String r3) {
        /*
            r2 = this;
            java.util.Map<java.lang.String, org.eclipse.jetty.util.ajax.JSON$Convertor> r0 = r2._convertors
            java.lang.Object r0 = r0.get(r3)
            org.eclipse.jetty.util.ajax.JSON$Convertor r0 = (org.eclipse.jetty.util.ajax.JSON.Convertor) r0
            if (r0 != 0) goto L_0x0012
            org.eclipse.jetty.util.ajax.JSON r1 = DEFAULT
            if (r2 == r1) goto L_0x0012
            org.eclipse.jetty.util.ajax.JSON$Convertor r0 = r1.getConvertorFor(r3)
        L_0x0012:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.ajax.JSON.getConvertorFor(java.lang.String):org.eclipse.jetty.util.ajax.JSON$Convertor");
    }

    public int getStringBufferSize() {
        return this._stringBufferSize;
    }

    public Object handleUnknown(Source source, char c) {
        throw new IllegalStateException("unknown char '" + c + "'(" + c + ") in " + source);
    }

    public Object[] newArray(int i) {
        return new Object[i];
    }

    public Map<String, Object> newMap() {
        return new HashMap();
    }

    public Object parseArray(Source source) {
        if (source.next() == '[') {
            Object obj = null;
            ArrayList arrayList = null;
            int i = 0;
            while (true) {
                boolean z = true;
                while (source.hasNext()) {
                    char peek = source.peek();
                    if (peek != ',') {
                        if (peek == ']') {
                            source.next();
                            if (i == 0) {
                                return newArray(0);
                            }
                            if (i != 1) {
                                return arrayList.toArray(newArray(arrayList.size()));
                            }
                            Object[] newArray = newArray(1);
                            Array.set(newArray, 0, obj);
                            return newArray;
                        } else if (Character.isWhitespace(peek)) {
                            source.next();
                        } else {
                            int i2 = i + 1;
                            if (i == 0) {
                                obj = contextForArray().parse(source);
                            } else {
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                    arrayList.add(obj);
                                    arrayList.add(contextForArray().parse(source));
                                } else {
                                    arrayList.add(contextForArray().parse(source));
                                }
                                obj = null;
                            }
                            i = i2;
                            z = false;
                        }
                    } else if (!z) {
                        source.next();
                    } else {
                        throw new IllegalStateException();
                    }
                }
                throw new IllegalStateException("unexpected end of array");
            }
        }
        throw new IllegalStateException();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0058, code lost:
        r0 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Number parseNumber(org.eclipse.jetty.util.ajax.JSON.Source r11) {
        /*
            r10 = this;
            r10 = 0
            r0 = 0
            r2 = r0
        L_0x0004:
            boolean r4 = r11.hasNext()
            r5 = 46
            r6 = 101(0x65, float:1.42E-43)
            r7 = 69
            r8 = 43
            r9 = 45
            if (r4 == 0) goto L_0x0058
            char r4 = r11.peek()
            if (r4 == r8) goto L_0x0047
            if (r4 == r7) goto L_0x0031
            if (r4 == r6) goto L_0x0031
            if (r4 == r9) goto L_0x0047
            if (r4 == r5) goto L_0x0031
            switch(r4) {
                case 48: goto L_0x0026;
                case 49: goto L_0x0026;
                case 50: goto L_0x0026;
                case 51: goto L_0x0026;
                case 52: goto L_0x0026;
                case 53: goto L_0x0026;
                case 54: goto L_0x0026;
                case 55: goto L_0x0026;
                case 56: goto L_0x0026;
                case 57: goto L_0x0026;
                default: goto L_0x0025;
            }
        L_0x0025:
            goto L_0x0058
        L_0x0026:
            r5 = 10
            long r2 = r2 * r5
            int r4 = r4 + -48
            long r4 = (long) r4
            long r2 = r2 + r4
            r11.next()
            goto L_0x0004
        L_0x0031:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = 16
            r0.<init>(r1)
            if (r10 == 0) goto L_0x003d
            r0.append(r9)
        L_0x003d:
            r0.append(r2)
            r0.append(r4)
            r11.next()
            goto L_0x0059
        L_0x0047:
            int r10 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r10 != 0) goto L_0x0050
            r11.next()
            r10 = 1
            goto L_0x0004
        L_0x0050:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "bad number"
            r10.<init>(r11)
            throw r10
        L_0x0058:
            r0 = 0
        L_0x0059:
            if (r0 != 0) goto L_0x0065
            if (r10 == 0) goto L_0x0060
            r10 = -1
            long r2 = r2 * r10
        L_0x0060:
            java.lang.Long r10 = java.lang.Long.valueOf(r2)
            return r10
        L_0x0065:
            boolean r10 = r11.hasNext()
            if (r10 == 0) goto L_0x0084
            char r10 = r11.peek()
            if (r10 == r8) goto L_0x007d
            if (r10 == r7) goto L_0x007d
            if (r10 == r6) goto L_0x007d
            if (r10 == r9) goto L_0x007d
            if (r10 == r5) goto L_0x007d
            switch(r10) {
                case 48: goto L_0x007d;
                case 49: goto L_0x007d;
                case 50: goto L_0x007d;
                case 51: goto L_0x007d;
                case 52: goto L_0x007d;
                case 53: goto L_0x007d;
                case 54: goto L_0x007d;
                case 55: goto L_0x007d;
                case 56: goto L_0x007d;
                case 57: goto L_0x007d;
                default: goto L_0x007c;
            }
        L_0x007c:
            goto L_0x0084
        L_0x007d:
            r0.append(r10)
            r11.next()
            goto L_0x0065
        L_0x0084:
            java.lang.Double r10 = new java.lang.Double
            java.lang.String r11 = r0.toString()
            r10.<init>(r11)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.ajax.JSON.parseNumber(org.eclipse.jetty.util.ajax.JSON$Source):java.lang.Number");
    }

    public Object parseObject(Source source) {
        if (source.next() == '{') {
            Map<String, Object> newMap = newMap();
            char seekTo = seekTo("\"}", source);
            while (true) {
                if (!source.hasNext()) {
                    break;
                } else if (seekTo == '}') {
                    source.next();
                    break;
                } else {
                    String parseString = parseString(source);
                    seekTo(':', source);
                    source.next();
                    newMap.put(parseString, contextFor(parseString).parse(source));
                    seekTo(",}", source);
                    if (source.next() == '}') {
                        break;
                    }
                    seekTo = seekTo("\"}", source);
                }
            }
            String str = (String) newMap.get("x-class");
            if (str != null) {
                Convertor convertorFor = getConvertorFor(str);
                if (convertorFor != null) {
                    return convertorFor.fromJSON(newMap);
                }
                LOG.warn("No Convertor for x-class '{}'", str);
            }
            String str2 = (String) newMap.get("class");
            if (str2 != null) {
                try {
                    return convertTo(Loader.loadClass(JSON.class, str2), newMap);
                } catch (ClassNotFoundException unused) {
                    LOG.warn("No Class for '{}'", str2);
                }
            }
            return newMap;
        }
        throw new IllegalStateException();
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01ba A[EDGE_INSN: B:91:0x01ba->B:79:0x01ba ?: BREAK  , SYNTHETIC] */
    public java.lang.String parseString(org.eclipse.jetty.util.ajax.JSON.Source r21) {
        /*
            r20 = this;
            r0 = r20
            char r1 = r21.next()
            r2 = 34
            if (r1 != r2) goto L_0x01bf
            char[] r1 = r21.scratchBuffer()
            r6 = 117(0x75, float:1.64E-43)
            r7 = 116(0x74, float:1.63E-43)
            r8 = 114(0x72, float:1.6E-43)
            r9 = 110(0x6e, float:1.54E-43)
            r10 = 102(0x66, float:1.43E-43)
            r11 = 98
            r13 = 12
            r14 = 47
            r15 = 92
            r3 = 0
            r17 = 1
            if (r1 == 0) goto L_0x00e1
            r4 = r3
            r18 = r4
        L_0x0028:
            boolean r19 = r21.hasNext()
            if (r19 == 0) goto L_0x00d9
            int r5 = r1.length
            if (r4 < r5) goto L_0x003e
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            int r12 = r1.length
            int r12 = r12 * 2
            r5.<init>(r12)
            r5.append(r1, r3, r4)
            goto L_0x00da
        L_0x003e:
            char r5 = r21.next()
            if (r18 == 0) goto L_0x00c5
            if (r5 == r2) goto L_0x00bc
            if (r5 == r14) goto L_0x00b7
            if (r5 == r15) goto L_0x00b2
            if (r5 == r11) goto L_0x00ab
            if (r5 == r10) goto L_0x00a6
            if (r5 == r9) goto L_0x009f
            if (r5 == r8) goto L_0x0098
            if (r5 == r7) goto L_0x0090
            if (r5 == r6) goto L_0x005c
            int r12 = r4 + 1
            r1[r4] = r5
        L_0x005a:
            r4 = r12
            goto L_0x00c1
        L_0x005c:
            char r5 = r21.next()
            byte r5 = (byte) r5
            byte r5 = org.eclipse.jetty.util.TypeUtil.convertHexDigit((byte) r5)
            int r5 = r5 << r13
            char r12 = r21.next()
            byte r12 = (byte) r12
            byte r12 = org.eclipse.jetty.util.TypeUtil.convertHexDigit((byte) r12)
            r18 = 8
            int r12 = r12 << 8
            int r5 = r5 + r12
            char r12 = r21.next()
            byte r12 = (byte) r12
            byte r12 = org.eclipse.jetty.util.TypeUtil.convertHexDigit((byte) r12)
            int r12 = r12 << 4
            int r5 = r5 + r12
            char r12 = r21.next()
            byte r12 = (byte) r12
            byte r12 = org.eclipse.jetty.util.TypeUtil.convertHexDigit((byte) r12)
            int r5 = r5 + r12
            char r5 = (char) r5
            int r12 = r4 + 1
            r1[r4] = r5
            goto L_0x005a
        L_0x0090:
            int r5 = r4 + 1
            r12 = 9
            r1[r4] = r12
        L_0x0096:
            r4 = r5
            goto L_0x00c1
        L_0x0098:
            int r5 = r4 + 1
            r12 = 13
            r1[r4] = r12
            goto L_0x0096
        L_0x009f:
            int r5 = r4 + 1
            r12 = 10
            r1[r4] = r12
            goto L_0x0096
        L_0x00a6:
            int r5 = r4 + 1
            r1[r4] = r13
            goto L_0x0096
        L_0x00ab:
            int r5 = r4 + 1
            r12 = 8
            r1[r4] = r12
            goto L_0x0096
        L_0x00b2:
            int r5 = r4 + 1
            r1[r4] = r15
            goto L_0x0096
        L_0x00b7:
            int r5 = r4 + 1
            r1[r4] = r14
            goto L_0x0096
        L_0x00bc:
            int r5 = r4 + 1
            r1[r4] = r2
            goto L_0x0096
        L_0x00c1:
            r18 = r3
            goto L_0x0028
        L_0x00c5:
            if (r5 != r15) goto L_0x00cb
            r18 = r17
            goto L_0x0028
        L_0x00cb:
            if (r5 != r2) goto L_0x00d2
            java.lang.String r0 = r0.toString(r1, r3, r4)
            return r0
        L_0x00d2:
            int r12 = r4 + 1
            r1[r4] = r5
            r4 = r12
            goto L_0x0028
        L_0x00d9:
            r5 = 0
        L_0x00da:
            if (r5 != 0) goto L_0x00ec
            java.lang.String r0 = r0.toString(r1, r3, r4)
            return r0
        L_0x00e1:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            int r0 = r20.getStringBufferSize()
            r5.<init>(r0)
        L_0x00ea:
            r18 = r3
        L_0x00ec:
            boolean r0 = r21.hasNext()
            if (r0 == 0) goto L_0x01ba
            char r0 = r21.next()
            if (r18 == 0) goto L_0x01a4
            if (r0 == r2) goto L_0x0195
            if (r0 == r14) goto L_0x0189
            if (r0 == r15) goto L_0x017d
            if (r0 == r11) goto L_0x0171
            if (r0 == r10) goto L_0x0167
            if (r0 == r9) goto L_0x015b
            if (r0 == r8) goto L_0x0151
            if (r0 == r7) goto L_0x0149
            if (r0 == r6) goto L_0x0117
            r5.append(r0)
        L_0x010d:
            r0 = 8
            r1 = 9
        L_0x0111:
            r4 = 13
        L_0x0113:
            r12 = 10
            goto L_0x01a0
        L_0x0117:
            char r0 = r21.next()
            byte r0 = (byte) r0
            byte r0 = org.eclipse.jetty.util.TypeUtil.convertHexDigit((byte) r0)
            int r0 = r0 << r13
            char r1 = r21.next()
            byte r1 = (byte) r1
            byte r1 = org.eclipse.jetty.util.TypeUtil.convertHexDigit((byte) r1)
            r4 = 8
            int r1 = r1 << r4
            int r0 = r0 + r1
            char r1 = r21.next()
            byte r1 = (byte) r1
            byte r1 = org.eclipse.jetty.util.TypeUtil.convertHexDigit((byte) r1)
            int r1 = r1 << 4
            int r0 = r0 + r1
            char r1 = r21.next()
            byte r1 = (byte) r1
            byte r1 = org.eclipse.jetty.util.TypeUtil.convertHexDigit((byte) r1)
            int r0 = r0 + r1
            char r0 = (char) r0
            r5.append(r0)
            goto L_0x010d
        L_0x0149:
            r1 = 9
            r5.append(r1)
            r0 = 8
            goto L_0x0111
        L_0x0151:
            r1 = 9
            r4 = 13
            r5.append(r4)
            r0 = 8
            goto L_0x0113
        L_0x015b:
            r1 = 9
            r4 = 13
            r12 = 10
            r5.append(r12)
        L_0x0164:
            r0 = 8
            goto L_0x01a0
        L_0x0167:
            r1 = 9
            r4 = 13
            r12 = 10
            r5.append(r13)
            goto L_0x0164
        L_0x0171:
            r0 = 8
            r1 = 9
            r4 = 13
            r12 = 10
            r5.append(r0)
            goto L_0x01a0
        L_0x017d:
            r0 = 8
            r1 = 9
            r4 = 13
            r12 = 10
            r5.append(r15)
            goto L_0x01a0
        L_0x0189:
            r0 = 8
            r1 = 9
            r4 = 13
            r12 = 10
            r5.append(r14)
            goto L_0x01a0
        L_0x0195:
            r0 = 8
            r1 = 9
            r4 = 13
            r12 = 10
            r5.append(r2)
        L_0x01a0:
            r16 = r0
            goto L_0x00ea
        L_0x01a4:
            r1 = 9
            r4 = 13
            r12 = 10
            r16 = 8
            if (r0 != r15) goto L_0x01b2
            r18 = r17
            goto L_0x00ec
        L_0x01b2:
            if (r0 != r2) goto L_0x01b5
            goto L_0x01ba
        L_0x01b5:
            r5.append(r0)
            goto L_0x00ec
        L_0x01ba:
            java.lang.String r0 = r5.toString()
            return r0
        L_0x01bf:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.ajax.JSON.parseString(org.eclipse.jetty.util.ajax.JSON$Source):java.lang.String");
    }

    public void seekTo(char c, Source source) {
        while (source.hasNext()) {
            char peek = source.peek();
            if (peek != c) {
                if (Character.isWhitespace(peek)) {
                    source.next();
                } else {
                    throw new IllegalStateException("Unexpected '" + peek + " while seeking '" + c + "'");
                }
            } else {
                return;
            }
        }
        throw new IllegalStateException("Expected '" + c + "'");
    }

    public void setStringBufferSize(int i) {
        this._stringBufferSize = i;
    }

    public String toJSON(Object obj) {
        StringBuilder sb = new StringBuilder(getStringBufferSize());
        append((Appendable) sb, obj);
        return sb.toString();
    }

    public static Object parse(String str, boolean z) {
        return DEFAULT.parse((Source) new StringSource(str), z);
    }

    public void append(Appendable appendable, Object obj) {
        if (obj == null) {
            try {
                appendable.append("null");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (obj instanceof Map) {
            appendMap(appendable, (Map<?, ?>) (Map) obj);
        } else if (obj instanceof String) {
            appendString(appendable, (String) obj);
        } else if (obj instanceof Number) {
            appendNumber(appendable, (Number) obj);
        } else if (obj instanceof Boolean) {
            appendBoolean(appendable, (Boolean) obj);
        } else if (obj.getClass().isArray()) {
            appendArray(appendable, obj);
        } else if (obj instanceof Character) {
            appendString(appendable, obj.toString());
        } else if (obj instanceof Convertible) {
            appendJSON(appendable, (Convertible) obj);
        } else if (obj instanceof Generator) {
            appendJSON(appendable, (Generator) obj);
        } else {
            Convertor convertor = getConvertor(obj.getClass());
            if (convertor != null) {
                appendJSON(appendable, convertor, obj);
            } else if (obj instanceof Collection) {
                appendArray(appendable, (Collection) obj);
            } else {
                appendString(appendable, obj.toString());
            }
        }
    }

    public void appendArray(Appendable appendable, Collection collection) {
        if (collection == null) {
            try {
                appendNull(appendable);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            appendable.append('[');
            boolean z = true;
            for (Object append : collection) {
                if (!z) {
                    appendable.append(StringUtil.COMMA);
                }
                append(appendable, append);
                z = false;
            }
            appendable.append(']');
        }
    }

    public void appendBoolean(Appendable appendable, Boolean bool) {
        if (bool == null) {
            try {
                appendNull(appendable);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            appendable.append(bool.booleanValue() ? BooleanUtils.TRUE : BooleanUtils.FALSE);
        }
    }

    public void appendJSON(Appendable appendable, final Convertor convertor, final Object obj) {
        appendJSON(appendable, (Convertible) new Convertible() {
            public void fromJSON(Map map) {
            }

            public void toJSON(Output output) {
                convertor.toJSON(obj, output);
            }
        });
    }

    public void appendMap(Appendable appendable, Map<?, ?> map) {
        if (map == null) {
            try {
                appendNull(appendable);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            appendable.append('{');
            Iterator<Map.Entry<?, ?>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry next = it.next();
                QuotedStringTokenizer.quote(appendable, next.getKey().toString());
                appendable.append(':');
                append(appendable, next.getValue());
                if (it.hasNext()) {
                    appendable.append(StringUtil.COMMA);
                }
            }
            appendable.append('}');
        }
    }

    public void appendNull(Appendable appendable) {
        try {
            appendable.append("null");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void appendNumber(Appendable appendable, Number number) {
        if (number == null) {
            try {
                appendNull(appendable);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            appendable.append(String.valueOf(number));
        }
    }

    public void appendString(Appendable appendable, String str) {
        if (str == null) {
            appendNull(appendable);
        } else {
            QuotedStringTokenizer.quote(appendable, str);
        }
    }

    public static Object parse(Reader reader) throws IOException {
        return DEFAULT.parse((Source) new ReaderSource(reader), false);
    }

    @Deprecated
    public void appendJSON(StringBuffer stringBuffer, Convertible convertible) {
        appendJSON((Appendable) stringBuffer, convertible);
    }

    public static Object parse(Reader reader, boolean z) throws IOException {
        return DEFAULT.parse((Source) new ReaderSource(reader), z);
    }

    public static String toString(Map map) {
        JSON json = DEFAULT;
        StringBuilder sb = new StringBuilder(json.getStringBufferSize());
        json.appendMap((Appendable) sb, (Map<?, ?>) map);
        return sb.toString();
    }

    public void appendJSON(Appendable appendable, Convertible convertible) {
        ConvertableOutput convertableOutput = new ConvertableOutput(appendable);
        convertible.toJSON(convertableOutput);
        convertableOutput.complete();
    }

    @Deprecated
    public static Object parse(InputStream inputStream) throws IOException {
        return DEFAULT.parse((Source) new StringSource(IO.toString(inputStream)), false);
    }

    @Deprecated
    public static Object parse(InputStream inputStream, boolean z) throws IOException {
        return DEFAULT.parse((Source) new StringSource(IO.toString(inputStream)), z);
    }

    public static String toString(Object[] objArr) {
        JSON json = DEFAULT;
        StringBuilder sb = new StringBuilder(json.getStringBufferSize());
        json.appendArray((Appendable) sb, (Object) objArr);
        return sb.toString();
    }

    @Deprecated
    public void appendJSON(StringBuffer stringBuffer, Generator generator) {
        generator.addJSON(stringBuffer);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0043, code lost:
        if (r4 != 13) goto L_0x005a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object parse(org.eclipse.jetty.util.ajax.JSON.Source r10, boolean r11) {
        /*
            r9 = this;
            if (r11 != 0) goto L_0x0007
            java.lang.Object r9 = r9.parse((org.eclipse.jetty.util.ajax.JSON.Source) r10)
            return r9
        L_0x0007:
            r11 = 1
            r0 = 0
            r1 = 0
            r3 = r11
            r2 = r0
        L_0x000c:
            boolean r4 = r10.hasNext()
            if (r4 == 0) goto L_0x005e
            char r4 = r10.peek()
            r5 = 47
            r6 = 42
            r7 = 2
            if (r2 != r11) goto L_0x0029
            if (r4 == r6) goto L_0x0024
            if (r4 == r5) goto L_0x0022
            goto L_0x005a
        L_0x0022:
            r2 = -1
            goto L_0x005a
        L_0x0024:
            if (r3 != r11) goto L_0x0030
            r2 = r0
            r3 = r7
            goto L_0x005a
        L_0x0029:
            r8 = 3
            if (r2 <= r11) goto L_0x003b
            if (r4 == r6) goto L_0x0039
            if (r4 == r5) goto L_0x0032
        L_0x0030:
            r2 = r7
            goto L_0x005a
        L_0x0032:
            if (r2 != r8) goto L_0x0030
            if (r3 != r7) goto L_0x0037
            return r1
        L_0x0037:
            r2 = r0
            goto L_0x005a
        L_0x0039:
            r2 = r8
            goto L_0x005a
        L_0x003b:
            if (r2 >= 0) goto L_0x0046
            r5 = 10
            if (r4 == r5) goto L_0x0037
            r5 = 13
            if (r4 == r5) goto L_0x0037
            goto L_0x005a
        L_0x0046:
            boolean r7 = java.lang.Character.isWhitespace(r4)
            if (r7 != 0) goto L_0x005a
            if (r4 != r5) goto L_0x0050
            r2 = r11
            goto L_0x005a
        L_0x0050:
            if (r4 != r6) goto L_0x0053
            goto L_0x0039
        L_0x0053:
            if (r1 != 0) goto L_0x005a
            java.lang.Object r1 = r9.parse((org.eclipse.jetty.util.ajax.JSON.Source) r10)
            goto L_0x000c
        L_0x005a:
            r10.next()
            goto L_0x000c
        L_0x005e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.ajax.JSON.parse(org.eclipse.jetty.util.ajax.JSON$Source, boolean):java.lang.Object");
    }

    public char seekTo(String str, Source source) {
        while (source.hasNext()) {
            char peek = source.peek();
            if (str.indexOf(peek) >= 0) {
                return peek;
            }
            if (Character.isWhitespace(peek)) {
                source.next();
            } else {
                throw new IllegalStateException("Unexpected '" + peek + "' while seeking one of '" + str + "'");
            }
        }
        throw new IllegalStateException("Expected one of '" + str + "'");
    }

    public void appendJSON(Appendable appendable, Generator generator) {
        generator.addJSON(appendable);
    }

    @Deprecated
    public void appendArray(StringBuffer stringBuffer, Object obj) {
        appendArray((Appendable) stringBuffer, obj);
    }

    public String toString(char[] cArr, int i, int i2) {
        return new String(cArr, i, i2);
    }

    public void appendArray(Appendable appendable, Object obj) {
        if (obj == null) {
            try {
                appendNull(appendable);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            appendable.append('[');
            int length = Array.getLength(obj);
            for (int i = 0; i < length; i++) {
                if (i != 0) {
                    appendable.append(StringUtil.COMMA);
                }
                append(appendable, Array.get(obj, i));
            }
            appendable.append(']');
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0028, code lost:
        if (r1 != 3) goto L_0x0025;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object parse(org.eclipse.jetty.util.ajax.JSON.Source r9) {
        /*
            r8 = this;
            r0 = 0
            r1 = r0
        L_0x0002:
            boolean r2 = r9.hasNext()
            r3 = 0
            if (r2 == 0) goto L_0x00b4
            char r2 = r9.peek()
            r4 = 42
            r5 = 2
            r6 = 47
            r7 = 1
            if (r1 != r7) goto L_0x001e
            if (r2 == r4) goto L_0x0025
            if (r2 == r6) goto L_0x001b
            goto L_0x00a5
        L_0x001b:
            r1 = -1
            goto L_0x00a5
        L_0x001e:
            if (r1 <= r7) goto L_0x0030
            r3 = 3
            if (r2 == r4) goto L_0x002d
            if (r2 == r6) goto L_0x0028
        L_0x0025:
            r1 = r5
            goto L_0x00a5
        L_0x0028:
            if (r1 != r3) goto L_0x0025
        L_0x002a:
            r1 = r0
            goto L_0x00a5
        L_0x002d:
            r1 = r3
            goto L_0x00a5
        L_0x0030:
            if (r1 >= 0) goto L_0x003b
            r3 = 10
            if (r2 == r3) goto L_0x002a
            r3 = 13
            if (r2 == r3) goto L_0x002a
            goto L_0x00a5
        L_0x003b:
            r4 = 34
            if (r2 == r4) goto L_0x00af
            r4 = 45
            if (r2 == r4) goto L_0x00aa
            if (r2 == r6) goto L_0x00a4
            r4 = 78
            if (r2 == r4) goto L_0x009e
            r4 = 91
            if (r2 == r4) goto L_0x0099
            r4 = 102(0x66, float:1.43E-43)
            if (r2 == r4) goto L_0x0091
            r4 = 110(0x6e, float:1.54E-43)
            if (r2 == r4) goto L_0x008b
            r4 = 123(0x7b, float:1.72E-43)
            if (r2 == r4) goto L_0x0086
            r4 = 116(0x74, float:1.63E-43)
            if (r2 == r4) goto L_0x007e
            r4 = 117(0x75, float:1.64E-43)
            if (r2 == r4) goto L_0x0078
            boolean r3 = java.lang.Character.isDigit(r2)
            if (r3 == 0) goto L_0x006c
            java.lang.Number r8 = r8.parseNumber(r9)
            return r8
        L_0x006c:
            boolean r3 = java.lang.Character.isWhitespace(r2)
            if (r3 == 0) goto L_0x0073
            goto L_0x00a5
        L_0x0073:
            java.lang.Object r8 = r8.handleUnknown(r9, r2)
            return r8
        L_0x0078:
            java.lang.String r8 = "undefined"
            complete(r8, r9)
            return r3
        L_0x007e:
            java.lang.String r8 = "true"
            complete(r8, r9)
            java.lang.Boolean r8 = java.lang.Boolean.TRUE
            return r8
        L_0x0086:
            java.lang.Object r8 = r8.parseObject(r9)
            return r8
        L_0x008b:
            java.lang.String r8 = "null"
            complete(r8, r9)
            return r3
        L_0x0091:
            java.lang.String r8 = "false"
            complete(r8, r9)
            java.lang.Boolean r8 = java.lang.Boolean.FALSE
            return r8
        L_0x0099:
            java.lang.Object r8 = r8.parseArray(r9)
            return r8
        L_0x009e:
            java.lang.String r8 = "NaN"
            complete(r8, r9)
            return r3
        L_0x00a4:
            r1 = r7
        L_0x00a5:
            r9.next()
            goto L_0x0002
        L_0x00aa:
            java.lang.Number r8 = r8.parseNumber(r9)
            return r8
        L_0x00af:
            java.lang.String r8 = r8.parseString(r9)
            return r8
        L_0x00b4:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.ajax.JSON.parse(org.eclipse.jetty.util.ajax.JSON$Source):java.lang.Object");
    }
}
