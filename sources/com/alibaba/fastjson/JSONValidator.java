package com.alibaba.fastjson;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public abstract class JSONValidator implements Cloneable {
    protected char ch;
    protected int count = 0;
    protected boolean eof;
    protected int pos = -1;
    protected boolean supportMultiValue = true;
    protected Type type;

    public static class ReaderValidator extends JSONValidator {
        private static final ThreadLocal<char[]> bufLocal = new ThreadLocal<>();
        private char[] buf;
        private int end = -1;
        final Reader r;
        private int readCount = 0;

        public ReaderValidator(Reader reader) {
            this.r = reader;
            ThreadLocal<char[]> threadLocal = bufLocal;
            char[] cArr = threadLocal.get();
            this.buf = cArr;
            if (cArr != null) {
                threadLocal.set((Object) null);
            } else {
                this.buf = new char[8192];
            }
            next();
            skipWhiteSpace();
        }

        public void close() throws IOException {
            bufLocal.set(this.buf);
            this.r.close();
        }

        public void error() {
            throw new JSONException("error, readCount " + this.readCount + ", valueCount : " + this.count + ", pos " + this.pos);
        }

        public void next() {
            int i = this.pos;
            if (i < this.end) {
                char[] cArr = this.buf;
                int i2 = i + 1;
                this.pos = i2;
                this.ch = cArr[i2];
            } else if (!this.eof) {
                try {
                    Reader reader = this.r;
                    char[] cArr2 = this.buf;
                    int read = reader.read(cArr2, 0, cArr2.length);
                    this.readCount++;
                    if (read > 0) {
                        this.ch = this.buf[0];
                        this.pos = 0;
                        this.end = read - 1;
                    } else if (read == -1) {
                        this.pos = 0;
                        this.end = 0;
                        this.buf = null;
                        this.ch = 0;
                        this.eof = true;
                    } else {
                        this.pos = 0;
                        this.end = 0;
                        this.buf = null;
                        this.ch = 0;
                        this.eof = true;
                        throw new JSONException("read error");
                    }
                } catch (IOException unused) {
                    throw new JSONException("read error");
                }
            }
        }
    }

    public enum Type {
        Object,
        Array,
        Value
    }

    public static class UTF16Validator extends JSONValidator {
        private final String str;

        public UTF16Validator(String str2) {
            this.str = str2;
            next();
            skipWhiteSpace();
        }

        public void next() {
            int i = this.pos + 1;
            this.pos = i;
            if (i >= this.str.length()) {
                this.ch = 0;
                this.eof = true;
                return;
            }
            this.ch = this.str.charAt(this.pos);
        }
    }

    public static class UTF8InputStreamValidator extends JSONValidator {
        private static final ThreadLocal<byte[]> bufLocal = new ThreadLocal<>();
        private byte[] buf;
        private int end = -1;
        private final InputStream is;
        private int readCount = 0;

        public UTF8InputStreamValidator(InputStream inputStream) {
            this.is = inputStream;
            ThreadLocal<byte[]> threadLocal = bufLocal;
            byte[] bArr = threadLocal.get();
            this.buf = bArr;
            if (bArr != null) {
                threadLocal.set((Object) null);
            } else {
                this.buf = new byte[8192];
            }
            next();
            skipWhiteSpace();
        }

        public void close() throws IOException {
            bufLocal.set(this.buf);
            this.is.close();
        }

        public void error() {
            throw new JSONException("error, readCount " + this.readCount + ", valueCount : " + this.count + ", pos " + this.pos);
        }

        public void next() {
            int i = this.pos;
            if (i < this.end) {
                byte[] bArr = this.buf;
                int i2 = i + 1;
                this.pos = i2;
                this.ch = (char) bArr[i2];
            } else if (!this.eof) {
                try {
                    InputStream inputStream = this.is;
                    byte[] bArr2 = this.buf;
                    int read = inputStream.read(bArr2, 0, bArr2.length);
                    this.readCount++;
                    if (read > 0) {
                        this.ch = (char) this.buf[0];
                        this.pos = 0;
                        this.end = read - 1;
                    } else if (read == -1) {
                        this.pos = 0;
                        this.end = 0;
                        this.buf = null;
                        this.ch = 0;
                        this.eof = true;
                    } else {
                        this.pos = 0;
                        this.end = 0;
                        this.buf = null;
                        this.ch = 0;
                        this.eof = true;
                        throw new JSONException("read error");
                    }
                } catch (IOException unused) {
                    throw new JSONException("read error");
                }
            }
        }
    }

    public static class UTF8Validator extends JSONValidator {
        private final byte[] bytes;

        public UTF8Validator(byte[] bArr) {
            this.bytes = bArr;
            next();
            skipWhiteSpace();
        }

        public void next() {
            int i = this.pos + 1;
            this.pos = i;
            byte[] bArr = this.bytes;
            if (i >= bArr.length) {
                this.ch = 0;
                this.eof = true;
                return;
            }
            this.ch = (char) bArr[i];
        }
    }

    public static JSONValidator from(String str) {
        return new UTF16Validator(str);
    }

    public static JSONValidator fromUtf8(byte[] bArr) {
        return new UTF8Validator(bArr);
    }

    public static final boolean isWhiteSpace(char c) {
        return c == ' ' || c == 9 || c == 13 || c == 10 || c == 12 || c == 8;
    }

    /* JADX WARNING: Removed duplicated region for block: B:118:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x011d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void any() {
        /*
            r11 = this;
            char r0 = r11.ch
            r1 = 117(0x75, float:1.64E-43)
            r2 = 34
            if (r0 == r2) goto L_0x01e3
            r3 = 101(0x65, float:1.42E-43)
            r4 = 45
            r5 = 43
            if (r0 == r5) goto L_0x0179
            if (r0 == r4) goto L_0x0179
            r6 = 91
            r7 = 93
            r8 = 44
            if (r0 == r6) goto L_0x0148
            r6 = 102(0x66, float:1.43E-43)
            r9 = 108(0x6c, float:1.51E-43)
            r10 = 125(0x7d, float:1.75E-43)
            if (r0 == r6) goto L_0x00bd
            r6 = 110(0x6e, float:1.54E-43)
            if (r0 == r6) goto L_0x0102
            r6 = 116(0x74, float:1.63E-43)
            if (r0 == r6) goto L_0x007e
            r1 = 123(0x7b, float:1.72E-43)
            if (r0 == r1) goto L_0x0033
            switch(r0) {
                case 48: goto L_0x0179;
                case 49: goto L_0x0179;
                case 50: goto L_0x0179;
                case 51: goto L_0x0179;
                case 52: goto L_0x0179;
                case 53: goto L_0x0179;
                case 54: goto L_0x0179;
                case 55: goto L_0x0179;
                case 56: goto L_0x0179;
                case 57: goto L_0x0179;
                default: goto L_0x0031;
            }
        L_0x0031:
            goto L_0x0139
        L_0x0033:
            r11.next()
            r11.skipWhiteSpace()
            char r0 = r11.ch
            if (r0 != r10) goto L_0x0045
            r11.next()
            com.alibaba.fastjson.JSONValidator$Type r0 = com.alibaba.fastjson.JSONValidator.Type.Object
            r11.type = r0
            return
        L_0x0045:
            char r0 = r11.ch
            if (r0 != r2) goto L_0x004d
            r11.fieldName()
            goto L_0x0050
        L_0x004d:
            r11.error()
        L_0x0050:
            r11.skipWhiteSpace()
            char r0 = r11.ch
            r1 = 58
            if (r0 != r1) goto L_0x005d
            r11.next()
            goto L_0x0060
        L_0x005d:
            r11.error()
        L_0x0060:
            r11.skipWhiteSpace()
            r11.any()
            r11.skipWhiteSpace()
            char r0 = r11.ch
            if (r0 != r8) goto L_0x0074
            r11.next()
            r11.skipWhiteSpace()
            goto L_0x0045
        L_0x0074:
            if (r0 != r10) goto L_0x0045
            r11.next()
            com.alibaba.fastjson.JSONValidator$Type r0 = com.alibaba.fastjson.JSONValidator.Type.Object
            r11.type = r0
            return
        L_0x007e:
            r11.next()
            char r0 = r11.ch
            r2 = 114(0x72, float:1.6E-43)
            if (r0 == r2) goto L_0x008a
            r11.error()
        L_0x008a:
            r11.next()
            char r0 = r11.ch
            if (r0 == r1) goto L_0x0094
            r11.error()
        L_0x0094:
            r11.next()
            char r0 = r11.ch
            if (r0 == r3) goto L_0x009e
            r11.error()
        L_0x009e:
            r11.next()
            char r0 = r11.ch
            boolean r0 = isWhiteSpace(r0)
            if (r0 != 0) goto L_0x00b8
            char r0 = r11.ch
            if (r0 == r8) goto L_0x00b8
            if (r0 == r7) goto L_0x00b8
            if (r0 == r10) goto L_0x00b8
            if (r0 != 0) goto L_0x00b4
            goto L_0x00b8
        L_0x00b4:
            r11.error()
            goto L_0x00bd
        L_0x00b8:
            com.alibaba.fastjson.JSONValidator$Type r0 = com.alibaba.fastjson.JSONValidator.Type.Value
            r11.type = r0
            return
        L_0x00bd:
            r11.next()
            char r0 = r11.ch
            r2 = 97
            if (r0 == r2) goto L_0x00c9
            r11.error()
        L_0x00c9:
            r11.next()
            char r0 = r11.ch
            if (r0 == r9) goto L_0x00d3
            r11.error()
        L_0x00d3:
            r11.next()
            char r0 = r11.ch
            r2 = 115(0x73, float:1.61E-43)
            if (r0 == r2) goto L_0x00df
            r11.error()
        L_0x00df:
            r11.next()
            char r0 = r11.ch
            if (r0 == r3) goto L_0x00e9
            r11.error()
        L_0x00e9:
            r11.next()
            char r0 = r11.ch
            boolean r0 = isWhiteSpace(r0)
            if (r0 != 0) goto L_0x0143
            char r0 = r11.ch
            if (r0 == r8) goto L_0x0143
            if (r0 == r7) goto L_0x0143
            if (r0 == r10) goto L_0x0143
            if (r0 != 0) goto L_0x00ff
            goto L_0x0143
        L_0x00ff:
            r11.error()
        L_0x0102:
            r11.next()
            char r0 = r11.ch
            if (r0 == r1) goto L_0x010c
            r11.error()
        L_0x010c:
            r11.next()
            char r0 = r11.ch
            if (r0 == r9) goto L_0x0116
            r11.error()
        L_0x0116:
            r11.next()
            char r0 = r11.ch
            if (r0 == r9) goto L_0x0120
            r11.error()
        L_0x0120:
            r11.next()
            char r0 = r11.ch
            boolean r0 = isWhiteSpace(r0)
            if (r0 != 0) goto L_0x013e
            char r0 = r11.ch
            if (r0 == r8) goto L_0x013e
            if (r0 == r7) goto L_0x013e
            if (r0 == r10) goto L_0x013e
            if (r0 != 0) goto L_0x0136
            goto L_0x013e
        L_0x0136:
            r11.error()
        L_0x0139:
            r11.error()
            goto L_0x01e2
        L_0x013e:
            com.alibaba.fastjson.JSONValidator$Type r0 = com.alibaba.fastjson.JSONValidator.Type.Value
            r11.type = r0
            return
        L_0x0143:
            com.alibaba.fastjson.JSONValidator$Type r0 = com.alibaba.fastjson.JSONValidator.Type.Value
            r11.type = r0
            return
        L_0x0148:
            r11.next()
            r11.skipWhiteSpace()
            char r0 = r11.ch
            if (r0 != r7) goto L_0x015a
            r11.next()
            com.alibaba.fastjson.JSONValidator$Type r0 = com.alibaba.fastjson.JSONValidator.Type.Array
            r11.type = r0
            return
        L_0x015a:
            r11.any()
            r11.skipWhiteSpace()
            char r0 = r11.ch
            if (r0 != r8) goto L_0x016b
            r11.next()
            r11.skipWhiteSpace()
            goto L_0x015a
        L_0x016b:
            if (r0 != r7) goto L_0x0175
            r11.next()
            com.alibaba.fastjson.JSONValidator$Type r0 = com.alibaba.fastjson.JSONValidator.Type.Array
            r11.type = r0
            return
        L_0x0175:
            r11.error()
            goto L_0x015a
        L_0x0179:
            r1 = 57
            r2 = 48
            if (r0 == r4) goto L_0x0181
            if (r0 != r5) goto L_0x0190
        L_0x0181:
            r11.next()
            r11.skipWhiteSpace()
            char r0 = r11.ch
            if (r0 < r2) goto L_0x018d
            if (r0 <= r1) goto L_0x0190
        L_0x018d:
            r11.error()
        L_0x0190:
            r11.next()
            char r0 = r11.ch
            if (r0 < r2) goto L_0x0199
            if (r0 <= r1) goto L_0x0190
        L_0x0199:
            r6 = 46
            if (r0 != r6) goto L_0x01b3
            r11.next()
            char r0 = r11.ch
            if (r0 < r2) goto L_0x01a6
            if (r0 <= r1) goto L_0x01a9
        L_0x01a6:
            r11.error()
        L_0x01a9:
            char r0 = r11.ch
            if (r0 < r2) goto L_0x01b3
            if (r0 > r1) goto L_0x01b3
            r11.next()
            goto L_0x01a9
        L_0x01b3:
            char r0 = r11.ch
            if (r0 == r3) goto L_0x01bb
            r3 = 69
            if (r0 != r3) goto L_0x01de
        L_0x01bb:
            r11.next()
            char r0 = r11.ch
            if (r0 == r4) goto L_0x01c4
            if (r0 != r5) goto L_0x01c7
        L_0x01c4:
            r11.next()
        L_0x01c7:
            char r0 = r11.ch
            if (r0 < r2) goto L_0x01d1
            if (r0 > r1) goto L_0x01d1
            r11.next()
            goto L_0x01d4
        L_0x01d1:
            r11.error()
        L_0x01d4:
            char r0 = r11.ch
            if (r0 < r2) goto L_0x01de
            if (r0 > r1) goto L_0x01de
            r11.next()
            goto L_0x01d4
        L_0x01de:
            com.alibaba.fastjson.JSONValidator$Type r0 = com.alibaba.fastjson.JSONValidator.Type.Value
            r11.type = r0
        L_0x01e2:
            return
        L_0x01e3:
            r11.next()
        L_0x01e6:
            char r0 = r11.ch
            r3 = 92
            if (r0 != r3) goto L_0x0207
            r11.next()
            char r0 = r11.ch
            if (r0 != r1) goto L_0x0203
            r11.next()
            r11.next()
            r11.next()
            r11.next()
            r11.next()
            goto L_0x01e6
        L_0x0203:
            r11.next()
            goto L_0x01e6
        L_0x0207:
            if (r0 != r2) goto L_0x0211
            r11.next()
            com.alibaba.fastjson.JSONValidator$Type r0 = com.alibaba.fastjson.JSONValidator.Type.Value
            r11.type = r0
            return
        L_0x0211:
            r11.next()
            goto L_0x01e6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.JSONValidator.any():void");
    }

    public void close() throws IOException {
    }

    public void error() {
        throw new JSONException("error : " + this.pos);
    }

    public void fieldName() {
        next();
        while (true) {
            char c = this.ch;
            if (c == '\\') {
                next();
                if (this.ch == 'u') {
                    next();
                    next();
                    next();
                    next();
                    next();
                } else {
                    next();
                }
            } else if (c == '\"') {
                next();
                return;
            } else {
                next();
            }
        }
    }

    public Type getType() {
        return this.type;
    }

    public abstract void next();

    public void skipWhiteSpace() {
        while (isWhiteSpace(this.ch)) {
            next();
        }
    }

    public boolean validate() {
        do {
            any();
            this.count++;
            if (!this.supportMultiValue || this.eof) {
                return true;
            }
            skipWhiteSpace();
        } while (!this.eof);
        return true;
    }

    public static JSONValidator from(Reader reader) {
        return new ReaderValidator(reader);
    }

    public static JSONValidator fromUtf8(InputStream inputStream) {
        return new UTF8InputStreamValidator(inputStream);
    }
}
