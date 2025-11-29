package com.fasterxml.jackson.core.io;

import java.io.IOException;
import java.io.InputStream;

public final class MergedStream extends InputStream {
    private byte[] _b;
    private final IOContext _ctxt;
    private final int _end;
    private final InputStream _in;
    private int _ptr;

    public MergedStream(IOContext iOContext, InputStream inputStream, byte[] bArr, int i, int i2) {
        this._ctxt = iOContext;
        this._in = inputStream;
        this._b = bArr;
        this._ptr = i;
        this._end = i2;
    }

    private void _free() {
        byte[] bArr = this._b;
        if (bArr != null) {
            this._b = null;
            IOContext iOContext = this._ctxt;
            if (iOContext != null) {
                iOContext.releaseReadIOBuffer(bArr);
            }
        }
    }

    public int available() throws IOException {
        return this._b != null ? this._end - this._ptr : this._in.available();
    }

    public void close() throws IOException {
        _free();
        this._in.close();
    }

    public void mark(int i) {
        if (this._b == null) {
            this._in.mark(i);
        }
    }

    public boolean markSupported() {
        return this._b == null && this._in.markSupported();
    }

    public int read() throws IOException {
        byte[] bArr = this._b;
        if (bArr == null) {
            return this._in.read();
        }
        int i = this._ptr;
        int i2 = i + 1;
        this._ptr = i2;
        byte b = bArr[i] & 255;
        if (i2 >= this._end) {
            _free();
        }
        return b;
    }

    public void reset() throws IOException {
        if (this._b == null) {
            this._in.reset();
        }
    }

    public long skip(long j) throws IOException {
        long j2;
        if (this._b != null) {
            int i = this._end;
            int i2 = this._ptr;
            j2 = (long) (i - i2);
            if (j2 > j) {
                this._ptr = i2 + ((int) j);
                return j;
            }
            _free();
            j -= j2;
        } else {
            j2 = 0;
        }
        return j > 0 ? j2 + this._in.skip(j) : j2;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        byte[] bArr2 = this._b;
        if (bArr2 == null) {
            return this._in.read(bArr, i, i2);
        }
        int i3 = this._end;
        int i4 = this._ptr;
        int i5 = i3 - i4;
        if (i2 > i5) {
            i2 = i5;
        }
        System.arraycopy(bArr2, i4, bArr, i, i2);
        int i6 = this._ptr + i2;
        this._ptr = i6;
        if (i6 >= this._end) {
            _free();
        }
        return i2;
    }
}
