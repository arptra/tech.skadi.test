package androidx.emoji2.text.flatbuffer;

import androidx.emoji2.text.flatbuffer.Utf8;
import java.nio.ByteBuffer;

public final class Utf8Safe extends Utf8 {

    public static class UnpairedSurrogateException extends IllegalArgumentException {
        public UnpairedSurrogateException(int i, int i2) {
            super("Unpaired surrogate at index " + i + " of " + i2);
        }
    }

    public static String b(byte[] bArr, int i, int i2) {
        if ((i | i2 | ((bArr.length - i) - i2)) >= 0) {
            int i3 = i + i2;
            char[] cArr = new char[i2];
            int i4 = 0;
            while (r10 < i3) {
                byte b = bArr[r10];
                if (!Utf8.DecodeUtil.g(b)) {
                    break;
                }
                i = r10 + 1;
                Utf8.DecodeUtil.b(b, cArr, i4);
                i4++;
            }
            int i5 = i4;
            while (r10 < i3) {
                int i6 = r10 + 1;
                byte b2 = bArr[r10];
                if (Utf8.DecodeUtil.g(b2)) {
                    int i7 = i5 + 1;
                    Utf8.DecodeUtil.b(b2, cArr, i5);
                    while (i6 < i3) {
                        byte b3 = bArr[i6];
                        if (!Utf8.DecodeUtil.g(b3)) {
                            break;
                        }
                        i6++;
                        Utf8.DecodeUtil.b(b3, cArr, i7);
                        i7++;
                    }
                    i5 = i7;
                    r10 = i6;
                } else if (Utf8.DecodeUtil.i(b2)) {
                    if (i6 < i3) {
                        r10 += 2;
                        Utf8.DecodeUtil.d(b2, bArr[i6], cArr, i5);
                        i5++;
                    } else {
                        throw new IllegalArgumentException("Invalid UTF-8");
                    }
                } else if (Utf8.DecodeUtil.h(b2)) {
                    if (i6 < i3 - 1) {
                        int i8 = r10 + 2;
                        r10 += 3;
                        Utf8.DecodeUtil.c(b2, bArr[i6], bArr[i8], cArr, i5);
                        i5++;
                    } else {
                        throw new IllegalArgumentException("Invalid UTF-8");
                    }
                } else if (i6 < i3 - 2) {
                    byte b4 = bArr[i6];
                    int i9 = r10 + 3;
                    byte b5 = bArr[r10 + 2];
                    r10 += 4;
                    Utf8.DecodeUtil.a(b2, b4, b5, bArr[i9], cArr, i5);
                    i5 += 2;
                } else {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
            }
            return new String(cArr, 0, i5);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)}));
    }

    public static String c(ByteBuffer byteBuffer, int i, int i2) {
        if ((i | i2 | ((byteBuffer.limit() - i) - i2)) >= 0) {
            int i3 = i + i2;
            char[] cArr = new char[i2];
            int i4 = 0;
            while (r10 < i3) {
                byte b = byteBuffer.get(r10);
                if (!Utf8.DecodeUtil.g(b)) {
                    break;
                }
                i = r10 + 1;
                Utf8.DecodeUtil.b(b, cArr, i4);
                i4++;
            }
            int i5 = i4;
            while (r10 < i3) {
                int i6 = r10 + 1;
                byte b2 = byteBuffer.get(r10);
                if (Utf8.DecodeUtil.g(b2)) {
                    int i7 = i5 + 1;
                    Utf8.DecodeUtil.b(b2, cArr, i5);
                    while (i6 < i3) {
                        byte b3 = byteBuffer.get(i6);
                        if (!Utf8.DecodeUtil.g(b3)) {
                            break;
                        }
                        i6++;
                        Utf8.DecodeUtil.b(b3, cArr, i7);
                        i7++;
                    }
                    i5 = i7;
                    r10 = i6;
                } else if (Utf8.DecodeUtil.i(b2)) {
                    if (i6 < i3) {
                        r10 += 2;
                        Utf8.DecodeUtil.d(b2, byteBuffer.get(i6), cArr, i5);
                        i5++;
                    } else {
                        throw new IllegalArgumentException("Invalid UTF-8");
                    }
                } else if (Utf8.DecodeUtil.h(b2)) {
                    if (i6 < i3 - 1) {
                        int i8 = r10 + 2;
                        r10 += 3;
                        Utf8.DecodeUtil.c(b2, byteBuffer.get(i6), byteBuffer.get(i8), cArr, i5);
                        i5++;
                    } else {
                        throw new IllegalArgumentException("Invalid UTF-8");
                    }
                } else if (i6 < i3 - 2) {
                    byte b4 = byteBuffer.get(i6);
                    int i9 = r10 + 3;
                    byte b5 = byteBuffer.get(r10 + 2);
                    r10 += 4;
                    Utf8.DecodeUtil.a(b2, b4, b5, byteBuffer.get(i9), cArr, i5);
                    i5 += 2;
                } else {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
            }
            return new String(cArr, 0, i5);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i2)}));
    }
}
