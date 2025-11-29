package com.fasterxml.jackson.core.io;

import com.meizu.common.widget.CircularProgressButton;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

public final class UTF8Writer extends Writer {
    static final int SURR1_FIRST = 55296;
    static final int SURR1_LAST = 56319;
    static final int SURR2_FIRST = 56320;
    static final int SURR2_LAST = 57343;
    private final IOContext _context;
    private OutputStream _out;
    private byte[] _outBuffer;
    private final int _outBufferEnd;
    private int _outPtr = 0;
    private int _surrogate;

    public UTF8Writer(IOContext iOContext, OutputStream outputStream) {
        this._context = iOContext;
        this._out = outputStream;
        byte[] allocWriteEncodingBuffer = iOContext.allocWriteEncodingBuffer();
        this._outBuffer = allocWriteEncodingBuffer;
        this._outBufferEnd = allocWriteEncodingBuffer.length - 4;
    }

    public static void illegalSurrogate(int i) throws IOException {
        throw new IOException(illegalSurrogateDesc(i));
    }

    public static String illegalSurrogateDesc(int i) {
        if (i > 1114111) {
            return "Illegal character point (0x" + Integer.toHexString(i) + ") to output; max is 0x10FFFF as per RFC 4627";
        } else if (i < 55296) {
            return "Illegal character point (0x" + Integer.toHexString(i) + ") to output";
        } else if (i <= 56319) {
            return "Unmatched first part of surrogate pair (0x" + Integer.toHexString(i) + ")";
        } else {
            return "Unmatched second part of surrogate pair (0x" + Integer.toHexString(i) + ")";
        }
    }

    public void close() throws IOException {
        OutputStream outputStream = this._out;
        if (outputStream != null) {
            int i = this._outPtr;
            if (i > 0) {
                outputStream.write(this._outBuffer, 0, i);
                this._outPtr = 0;
            }
            OutputStream outputStream2 = this._out;
            this._out = null;
            byte[] bArr = this._outBuffer;
            if (bArr != null) {
                this._outBuffer = null;
                this._context.releaseWriteEncodingBuffer(bArr);
            }
            outputStream2.close();
            int i2 = this._surrogate;
            this._surrogate = 0;
            if (i2 > 0) {
                illegalSurrogate(i2);
            }
        }
    }

    public int convertSurrogate(int i) throws IOException {
        int i2 = this._surrogate;
        this._surrogate = 0;
        if (i >= 56320 && i <= 57343) {
            return ((i2 - 55296) << 10) + 65536 + (i - 56320);
        }
        throw new IOException("Broken surrogate pair: first char 0x" + Integer.toHexString(i2) + ", second 0x" + Integer.toHexString(i) + "; illegal combination");
    }

    public void flush() throws IOException {
        OutputStream outputStream = this._out;
        if (outputStream != null) {
            int i = this._outPtr;
            if (i > 0) {
                outputStream.write(this._outBuffer, 0, i);
                this._outPtr = 0;
            }
            this._out.flush();
        }
    }

    public void write(char[] cArr) throws IOException {
        write(cArr, 0, cArr.length);
    }

    public Writer append(char c) throws IOException {
        write((int) c);
        return this;
    }

    public void write(char[] cArr, int i, int i2) throws IOException {
        if (i2 >= 2) {
            if (this._surrogate > 0) {
                i2--;
                write(convertSurrogate(cArr[i]));
                i++;
            }
            int i3 = this._outPtr;
            byte[] bArr = this._outBuffer;
            int i4 = this._outBufferEnd;
            int i5 = i2 + r10;
            while (r10 < i5) {
                if (i3 >= i4) {
                    this._out.write(bArr, 0, i3);
                    i3 = 0;
                }
                int i6 = r10 + 1;
                char c = cArr[r10];
                if (c < 128) {
                    int i7 = i3 + 1;
                    bArr[i3] = (byte) c;
                    int i8 = i5 - i6;
                    int i9 = i4 - i7;
                    if (i8 > i9) {
                        i8 = i9;
                    }
                    int i10 = i8 + i6;
                    while (true) {
                        r10 = i6;
                        i3 = i7;
                        if (r10 >= i10) {
                            continue;
                            break;
                        }
                        i6 = r10 + 1;
                        c = cArr[r10];
                        if (c >= 128) {
                            break;
                        }
                        i7 = i3 + 1;
                        bArr[i3] = (byte) c;
                    }
                }
                if (c < 2048) {
                    int i11 = i3 + 1;
                    bArr[i3] = (byte) ((c >> 6) | 192);
                    i3 += 2;
                    bArr[i11] = (byte) ((c & '?') | 128);
                } else if (c < 55296 || c > 57343) {
                    bArr[i3] = (byte) ((c >> 12) | 224);
                    int i12 = i3 + 2;
                    bArr[i3 + 1] = (byte) (((c >> 6) & 63) | 128);
                    i3 += 3;
                    bArr[i12] = (byte) ((c & '?') | 128);
                } else {
                    if (c > 56319) {
                        this._outPtr = i3;
                        illegalSurrogate(c);
                    }
                    this._surrogate = c;
                    if (i6 >= i5) {
                        break;
                    }
                    r10 = i6 + 1;
                    int convertSurrogate = convertSurrogate(cArr[i6]);
                    if (convertSurrogate > 1114111) {
                        this._outPtr = i3;
                        illegalSurrogate(convertSurrogate);
                    }
                    bArr[i3] = (byte) ((convertSurrogate >> 18) | CircularProgressButton.MorphingAnimation.DURATION_NORMAL);
                    bArr[i3 + 1] = (byte) (((convertSurrogate >> 12) & 63) | 128);
                    int i13 = i3 + 3;
                    bArr[i3 + 2] = (byte) (((convertSurrogate >> 6) & 63) | 128);
                    i3 += 4;
                    bArr[i13] = (byte) ((convertSurrogate & 63) | 128);
                }
                r10 = i6;
            }
            this._outPtr = i3;
        } else if (i2 == 1) {
            write((int) cArr[i]);
        }
    }

    public void write(int i) throws IOException {
        int i2;
        if (this._surrogate > 0) {
            i = convertSurrogate(i);
        } else if (i >= 55296 && i <= 57343) {
            if (i > 56319) {
                illegalSurrogate(i);
            }
            this._surrogate = i;
            return;
        }
        int i3 = this._outPtr;
        if (i3 >= this._outBufferEnd) {
            this._out.write(this._outBuffer, 0, i3);
            this._outPtr = 0;
        }
        if (i < 128) {
            byte[] bArr = this._outBuffer;
            int i4 = this._outPtr;
            this._outPtr = i4 + 1;
            bArr[i4] = (byte) i;
            return;
        }
        int i5 = this._outPtr;
        if (i < 2048) {
            byte[] bArr2 = this._outBuffer;
            int i6 = i5 + 1;
            bArr2[i5] = (byte) ((i >> 6) | 192);
            i2 = i5 + 2;
            bArr2[i6] = (byte) ((i & 63) | 128);
        } else if (i <= 65535) {
            byte[] bArr3 = this._outBuffer;
            bArr3[i5] = (byte) ((i >> 12) | 224);
            int i7 = i5 + 2;
            bArr3[i5 + 1] = (byte) (((i >> 6) & 63) | 128);
            i2 = i5 + 3;
            bArr3[i7] = (byte) ((i & 63) | 128);
        } else {
            if (i > 1114111) {
                illegalSurrogate(i);
            }
            byte[] bArr4 = this._outBuffer;
            bArr4[i5] = (byte) ((i >> 18) | CircularProgressButton.MorphingAnimation.DURATION_NORMAL);
            bArr4[i5 + 1] = (byte) (((i >> 12) & 63) | 128);
            int i8 = i5 + 3;
            bArr4[i5 + 2] = (byte) (((i >> 6) & 63) | 128);
            i2 = i5 + 4;
            bArr4[i8] = (byte) ((i & 63) | 128);
        }
        this._outPtr = i2;
    }

    public void write(String str) throws IOException {
        write(str, 0, str.length());
    }

    public void write(String str, int i, int i2) throws IOException {
        if (i2 >= 2) {
            if (this._surrogate > 0) {
                i2--;
                write(convertSurrogate(str.charAt(i)));
                i++;
            }
            int i3 = this._outPtr;
            byte[] bArr = this._outBuffer;
            int i4 = this._outBufferEnd;
            int i5 = i2 + r10;
            while (r10 < i5) {
                if (i3 >= i4) {
                    this._out.write(bArr, 0, i3);
                    i3 = 0;
                }
                int i6 = r10 + 1;
                char charAt = str.charAt(r10);
                if (charAt < 128) {
                    int i7 = i3 + 1;
                    bArr[i3] = (byte) charAt;
                    int i8 = i5 - i6;
                    int i9 = i4 - i7;
                    if (i8 > i9) {
                        i8 = i9;
                    }
                    int i10 = i8 + i6;
                    while (true) {
                        r10 = i6;
                        i3 = i7;
                        if (r10 >= i10) {
                            continue;
                            break;
                        }
                        i6 = r10 + 1;
                        charAt = str.charAt(r10);
                        if (charAt >= 128) {
                            break;
                        }
                        i7 = i3 + 1;
                        bArr[i3] = (byte) charAt;
                    }
                }
                if (charAt < 2048) {
                    int i11 = i3 + 1;
                    bArr[i3] = (byte) ((charAt >> 6) | 192);
                    i3 += 2;
                    bArr[i11] = (byte) ((charAt & '?') | 128);
                } else if (charAt < 55296 || charAt > 57343) {
                    bArr[i3] = (byte) ((charAt >> 12) | 224);
                    int i12 = i3 + 2;
                    bArr[i3 + 1] = (byte) (((charAt >> 6) & 63) | 128);
                    i3 += 3;
                    bArr[i12] = (byte) ((charAt & '?') | 128);
                } else {
                    if (charAt > 56319) {
                        this._outPtr = i3;
                        illegalSurrogate(charAt);
                    }
                    this._surrogate = charAt;
                    if (i6 >= i5) {
                        break;
                    }
                    r10 = i6 + 1;
                    int convertSurrogate = convertSurrogate(str.charAt(i6));
                    if (convertSurrogate > 1114111) {
                        this._outPtr = i3;
                        illegalSurrogate(convertSurrogate);
                    }
                    bArr[i3] = (byte) ((convertSurrogate >> 18) | CircularProgressButton.MorphingAnimation.DURATION_NORMAL);
                    bArr[i3 + 1] = (byte) (((convertSurrogate >> 12) & 63) | 128);
                    int i13 = i3 + 3;
                    bArr[i3 + 2] = (byte) (((convertSurrogate >> 6) & 63) | 128);
                    i3 += 4;
                    bArr[i13] = (byte) ((convertSurrogate & 63) | 128);
                }
                r10 = i6;
            }
            this._outPtr = i3;
        } else if (i2 == 1) {
            write((int) str.charAt(i));
        }
    }
}
