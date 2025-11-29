package com.fasterxml.jackson.core.io;

import com.meizu.common.widget.MzContactsContract;
import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class UTF32Reader extends Reader {
    protected static final int LAST_VALID_UNICODE_CHAR = 1114111;
    protected static final char NC = 0;
    protected final boolean _bigEndian;
    protected byte[] _buffer;
    protected int _byteCount;
    protected int _charCount;
    protected final IOContext _context;
    protected InputStream _in;
    protected int _length;
    protected final boolean _managedBuffers;
    protected int _ptr;
    protected char _surrogate = 0;
    protected char[] _tmpBuf;

    public UTF32Reader(IOContext iOContext, InputStream inputStream, byte[] bArr, int i, int i2, boolean z) {
        boolean z2 = false;
        this._context = iOContext;
        this._in = inputStream;
        this._buffer = bArr;
        this._ptr = i;
        this._length = i2;
        this._bigEndian = z;
        this._managedBuffers = inputStream != null ? true : z2;
    }

    private void freeBuffers() {
        byte[] bArr = this._buffer;
        if (bArr != null) {
            this._buffer = null;
            this._context.releaseReadIOBuffer(bArr);
        }
    }

    private boolean loadMore(int i) throws IOException {
        int i2;
        this._byteCount += this._length - i;
        if (i > 0) {
            int i3 = this._ptr;
            if (i3 > 0) {
                byte[] bArr = this._buffer;
                System.arraycopy(bArr, i3, bArr, 0, i);
                this._ptr = 0;
            }
            this._length = i;
        } else {
            this._ptr = 0;
            InputStream inputStream = this._in;
            int read = inputStream == null ? -1 : inputStream.read(this._buffer);
            if (read < 1) {
                this._length = 0;
                if (read < 0) {
                    if (this._managedBuffers) {
                        freeBuffers();
                    }
                    return false;
                }
                reportStrangeStream();
            }
            this._length = read;
        }
        while (true) {
            int i4 = this._length;
            if (i4 >= 4) {
                return true;
            }
            InputStream inputStream2 = this._in;
            if (inputStream2 == null) {
                i2 = -1;
            } else {
                byte[] bArr2 = this._buffer;
                i2 = inputStream2.read(bArr2, i4, bArr2.length - i4);
            }
            if (i2 < 1) {
                if (i2 < 0) {
                    if (this._managedBuffers) {
                        freeBuffers();
                    }
                    reportUnexpectedEOF(this._length, 4);
                }
                reportStrangeStream();
            }
            this._length += i2;
        }
    }

    private void reportBounds(char[] cArr, int i, int i2) throws IOException {
        throw new ArrayIndexOutOfBoundsException("read(buf," + i + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA + i2 + "), cbuf[" + cArr.length + "]");
    }

    private void reportInvalid(int i, int i2, String str) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid UTF-32 character 0x");
        sb.append(Integer.toHexString(i));
        sb.append(str);
        sb.append(" at char #");
        sb.append(this._charCount + i2);
        sb.append(", byte #");
        sb.append((this._byteCount + this._ptr) - 1);
        sb.append(")");
        throw new CharConversionException(sb.toString());
    }

    private void reportStrangeStream() throws IOException {
        throw new IOException("Strange I/O stream, returned 0 bytes on read");
    }

    private void reportUnexpectedEOF(int i, int i2) throws IOException {
        int i3 = this._charCount;
        throw new CharConversionException("Unexpected EOF in the middle of a 4-byte UTF-32 char: got " + i + ", needed " + i2 + ", at char #" + i3 + ", byte #" + (this._byteCount + i) + ")");
    }

    public void close() throws IOException {
        InputStream inputStream = this._in;
        if (inputStream != null) {
            this._in = null;
            freeBuffers();
            inputStream.close();
        }
    }

    public int read() throws IOException {
        if (this._tmpBuf == null) {
            this._tmpBuf = new char[1];
        }
        if (read(this._tmpBuf, 0, 1) < 1) {
            return -1;
        }
        return this._tmpBuf[0];
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c0, code lost:
        r1 = r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int read(char[] r9, int r10, int r11) throws java.io.IOException {
        /*
            r8 = this;
            byte[] r0 = r8._buffer
            r1 = -1
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            r0 = 1
            if (r11 >= r0) goto L_0x000a
            return r11
        L_0x000a:
            if (r10 < 0) goto L_0x0011
            int r0 = r10 + r11
            int r2 = r9.length
            if (r0 <= r2) goto L_0x0014
        L_0x0011:
            r8.reportBounds(r9, r10, r11)
        L_0x0014:
            int r11 = r11 + r10
            char r0 = r8._surrogate
            r2 = 4
            if (r0 == 0) goto L_0x0022
            int r1 = r10 + 1
            r9[r10] = r0
            r0 = 0
            r8._surrogate = r0
            goto L_0x003b
        L_0x0022:
            int r0 = r8._length
            int r3 = r8._ptr
            int r0 = r0 - r3
            if (r0 >= r2) goto L_0x003a
            boolean r3 = r8.loadMore(r0)
            if (r3 != 0) goto L_0x003a
            if (r0 != 0) goto L_0x0032
            return r1
        L_0x0032:
            int r0 = r8._length
            int r1 = r8._ptr
            int r0 = r0 - r1
            r8.reportUnexpectedEOF(r0, r2)
        L_0x003a:
            r1 = r10
        L_0x003b:
            int r0 = r8._length
            int r0 = r0 - r2
        L_0x003e:
            if (r1 >= r11) goto L_0x00d1
            int r2 = r8._ptr
            boolean r3 = r8._bigEndian
            if (r3 == 0) goto L_0x0063
            byte[] r3 = r8._buffer
            byte r4 = r3[r2]
            int r4 = r4 << 8
            int r5 = r2 + 1
            byte r5 = r3[r5]
            r5 = r5 & 255(0xff, float:3.57E-43)
            r4 = r4 | r5
            int r5 = r2 + 2
            byte r5 = r3[r5]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r5 = r5 << 8
            int r6 = r2 + 3
            byte r3 = r3[r6]
            r3 = r3 & 255(0xff, float:3.57E-43)
            r3 = r3 | r5
            goto L_0x0082
        L_0x0063:
            byte[] r3 = r8._buffer
            byte r4 = r3[r2]
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r5 = r2 + 1
            byte r5 = r3[r5]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r5 = r5 << 8
            r4 = r4 | r5
            int r5 = r2 + 2
            byte r5 = r3[r5]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r6 = r2 + 3
            byte r3 = r3[r6]
            int r3 = r3 << 8
            r3 = r3 | r5
            r7 = r4
            r4 = r3
            r3 = r7
        L_0x0082:
            int r2 = r2 + 4
            r8._ptr = r2
            if (r4 == 0) goto L_0x00c4
            r2 = 65535(0xffff, float:9.1834E-41)
            r2 = r2 & r4
            int r4 = r2 + -1
            r5 = 16
            int r4 = r4 << r5
            r3 = r3 | r4
            if (r2 <= r5) goto L_0x00aa
            int r2 = r1 - r10
            r4 = 1114111(0x10ffff, float:1.561202E-39)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.Object[] r4 = new java.lang.Object[]{r4}
            java.lang.String r5 = " (above 0x%08x)"
            java.lang.String r4 = java.lang.String.format(r5, r4)
            r8.reportInvalid(r3, r2, r4)
        L_0x00aa:
            int r2 = r1 + 1
            int r4 = r3 >> 10
            r5 = 55296(0xd800, float:7.7486E-41)
            int r4 = r4 + r5
            char r4 = (char) r4
            r9[r1] = r4
            r1 = r3 & 1023(0x3ff, float:1.434E-42)
            r4 = 56320(0xdc00, float:7.8921E-41)
            r1 = r1 | r4
            if (r2 < r11) goto L_0x00c2
            char r9 = (char) r3
            r8._surrogate = r9
        L_0x00c0:
            r1 = r2
            goto L_0x00d1
        L_0x00c2:
            r3 = r1
            r1 = r2
        L_0x00c4:
            int r2 = r1 + 1
            char r3 = (char) r3
            r9[r1] = r3
            int r1 = r8._ptr
            if (r1 <= r0) goto L_0x00ce
            goto L_0x00c0
        L_0x00ce:
            r1 = r2
            goto L_0x003e
        L_0x00d1:
            int r1 = r1 - r10
            int r9 = r8._charCount
            int r9 = r9 + r1
            r8._charCount = r9
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.io.UTF32Reader.read(char[], int, int):int");
    }
}
