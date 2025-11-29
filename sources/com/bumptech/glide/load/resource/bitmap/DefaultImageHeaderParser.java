package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

public final class DefaultImageHeaderParser implements ImageHeaderParser {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f2619a = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));
    public static final int[] b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    public static final class ByteBufferReader implements Reader {

        /* renamed from: a  reason: collision with root package name */
        public final ByteBuffer f2620a;

        public ByteBufferReader(ByteBuffer byteBuffer) {
            this.f2620a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        public int a() {
            return c() | (c() << 8);
        }

        public int b(byte[] bArr, int i) {
            int min = Math.min(i, this.f2620a.remaining());
            if (min == 0) {
                return -1;
            }
            this.f2620a.get(bArr, 0, min);
            return min;
        }

        public short c() {
            if (this.f2620a.remaining() >= 1) {
                return (short) (this.f2620a.get() & 255);
            }
            throw new Reader.EndOfFileException();
        }

        public long skip(long j) {
            int min = (int) Math.min((long) this.f2620a.remaining(), j);
            ByteBuffer byteBuffer = this.f2620a;
            byteBuffer.position(byteBuffer.position() + min);
            return (long) min;
        }
    }

    public static final class RandomAccessReader {

        /* renamed from: a  reason: collision with root package name */
        public final ByteBuffer f2621a;

        public RandomAccessReader(byte[] bArr, int i) {
            this.f2621a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i);
        }

        public short a(int i) {
            if (c(i, 2)) {
                return this.f2621a.getShort(i);
            }
            return -1;
        }

        public int b(int i) {
            if (c(i, 4)) {
                return this.f2621a.getInt(i);
            }
            return -1;
        }

        public final boolean c(int i, int i2) {
            return this.f2621a.remaining() - i >= i2;
        }

        public int d() {
            return this.f2621a.remaining();
        }

        public void e(ByteOrder byteOrder) {
            this.f2621a.order(byteOrder);
        }
    }

    public interface Reader {

        public static final class EndOfFileException extends IOException {
            private static final long serialVersionUID = 1;

            public EndOfFileException() {
                super("Unexpectedly reached end of a file");
            }
        }

        int a();

        int b(byte[] bArr, int i);

        short c();

        long skip(long j);
    }

    public static final class StreamReader implements Reader {

        /* renamed from: a  reason: collision with root package name */
        public final InputStream f2622a;

        public StreamReader(InputStream inputStream) {
            this.f2622a = inputStream;
        }

        public int a() {
            return c() | (c() << 8);
        }

        public int b(byte[] bArr, int i) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < i && (i3 = this.f2622a.read(bArr, i2, i - i2)) != -1) {
                i2 += i3;
            }
            if (i2 != 0 || i3 != -1) {
                return i2;
            }
            throw new Reader.EndOfFileException();
        }

        public short c() {
            int read = this.f2622a.read();
            if (read != -1) {
                return (short) read;
            }
            throw new Reader.EndOfFileException();
        }

        public long skip(long j) {
            if (j < 0) {
                return 0;
            }
            long j2 = j;
            while (j2 > 0) {
                long skip = this.f2622a.skip(j2);
                if (skip <= 0) {
                    if (this.f2622a.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j2 -= skip;
            }
            return j - j2;
        }
    }

    public static int e(int i, int i2) {
        return i + 2 + (i2 * 12);
    }

    public static boolean h(int i) {
        return (i & 65496) == 65496 || i == 19789 || i == 18761;
    }

    public static int k(RandomAccessReader randomAccessReader) {
        ByteOrder byteOrder;
        short a2 = randomAccessReader.a(6);
        if (a2 == 18761) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else if (a2 != 19789) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Unknown endianness = " + a2);
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        randomAccessReader.e(byteOrder);
        int b2 = randomAccessReader.b(10) + 6;
        short a3 = randomAccessReader.a(b2);
        for (int i = 0; i < a3; i++) {
            int e = e(b2, i);
            short a4 = randomAccessReader.a(e);
            if (a4 == 274) {
                short a5 = randomAccessReader.a(e + 2);
                if (a5 >= 1 && a5 <= 12) {
                    int b3 = randomAccessReader.b(e + 4);
                    if (b3 >= 0) {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Got tagIndex=" + i + " tagType=" + a4 + " formatCode=" + a5 + " componentCount=" + b3);
                        }
                        int i2 = b3 + b[a5];
                        if (i2 <= 4) {
                            int i3 = e + 8;
                            if (i3 < 0 || i3 > randomAccessReader.d()) {
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    Log.d("DfltImageHeaderParser", "Illegal tagValueOffset=" + i3 + " tagType=" + a4);
                                }
                            } else if (i2 >= 0 && i2 + i3 <= randomAccessReader.d()) {
                                return randomAccessReader.a(i3);
                            } else {
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    Log.d("DfltImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + a4);
                                }
                            }
                        } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + a5);
                        }
                    } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                        Log.d("DfltImageHeaderParser", "Negative tiff component count");
                    }
                } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Got invalid format code = " + a5);
                }
            }
        }
        return -1;
    }

    public int a(ByteBuffer byteBuffer, ArrayPool arrayPool) {
        return f(new ByteBufferReader((ByteBuffer) Preconditions.d(byteBuffer)), (ArrayPool) Preconditions.d(arrayPool));
    }

    public ImageHeaderParser.ImageType b(InputStream inputStream) {
        return g(new StreamReader((InputStream) Preconditions.d(inputStream)));
    }

    public int c(InputStream inputStream, ArrayPool arrayPool) {
        return f(new StreamReader((InputStream) Preconditions.d(inputStream)), (ArrayPool) Preconditions.d(arrayPool));
    }

    public ImageHeaderParser.ImageType d(ByteBuffer byteBuffer) {
        return g(new ByteBufferReader((ByteBuffer) Preconditions.d(byteBuffer)));
    }

    public final int f(Reader reader, ArrayPool arrayPool) {
        byte[] bArr;
        try {
            int a2 = reader.a();
            if (!h(a2)) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Parser doesn't handle magic number: " + a2);
                }
                return -1;
            }
            int j = j(reader);
            if (j == -1) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
                }
                return -1;
            }
            bArr = (byte[]) arrayPool.c(j, byte[].class);
            int l = l(reader, bArr, j);
            arrayPool.put(bArr);
            return l;
        } catch (Reader.EndOfFileException unused) {
            return -1;
        } catch (Throwable th) {
            arrayPool.put(bArr);
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003b, code lost:
        return com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0039 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.bumptech.glide.load.ImageHeaderParser.ImageType g(com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader r5) {
        /*
            r4 = this;
            int r0 = r5.a()     // Catch:{ EndOfFileException -> 0x00a9 }
            r1 = 65496(0xffd8, float:9.178E-41)
            if (r0 != r1) goto L_0x000c
            com.bumptech.glide.load.ImageHeaderParser$ImageType r4 = com.bumptech.glide.load.ImageHeaderParser.ImageType.JPEG     // Catch:{ EndOfFileException -> 0x00a9 }
            return r4
        L_0x000c:
            int r0 = r0 << 8
            short r1 = r5.c()     // Catch:{ EndOfFileException -> 0x00a9 }
            r0 = r0 | r1
            r1 = 4671814(0x474946, float:6.546606E-39)
            if (r0 != r1) goto L_0x001b
            com.bumptech.glide.load.ImageHeaderParser$ImageType r4 = com.bumptech.glide.load.ImageHeaderParser.ImageType.GIF     // Catch:{ EndOfFileException -> 0x00a9 }
            return r4
        L_0x001b:
            int r0 = r0 << 8
            short r1 = r5.c()     // Catch:{ EndOfFileException -> 0x00a9 }
            r0 = r0 | r1
            r1 = -1991225785(0xffffffff89504e47, float:-2.5073895E-33)
            if (r0 != r1) goto L_0x003c
            r0 = 21
            r5.skip(r0)     // Catch:{ EndOfFileException -> 0x00a9 }
            short r4 = r5.c()     // Catch:{ EndOfFileException -> 0x0039 }
            r5 = 3
            if (r4 < r5) goto L_0x0036
            com.bumptech.glide.load.ImageHeaderParser$ImageType r4 = com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG_A     // Catch:{ EndOfFileException -> 0x0039 }
            goto L_0x0038
        L_0x0036:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r4 = com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG     // Catch:{ EndOfFileException -> 0x0039 }
        L_0x0038:
            return r4
        L_0x0039:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r4 = com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG     // Catch:{ EndOfFileException -> 0x00a9 }
            return r4
        L_0x003c:
            r1 = 1380533830(0x52494646, float:2.16116855E11)
            if (r0 == r1) goto L_0x0046
            com.bumptech.glide.load.ImageHeaderParser$ImageType r4 = r4.m(r5, r0)     // Catch:{ EndOfFileException -> 0x00a9 }
            return r4
        L_0x0046:
            r0 = 4
            r5.skip(r0)     // Catch:{ EndOfFileException -> 0x00a9 }
            int r4 = r5.a()     // Catch:{ EndOfFileException -> 0x00a9 }
            int r4 = r4 << 16
            int r2 = r5.a()     // Catch:{ EndOfFileException -> 0x00a9 }
            r4 = r4 | r2
            r2 = 1464156752(0x57454250, float:2.16888601E14)
            if (r4 == r2) goto L_0x005e
            com.bumptech.glide.load.ImageHeaderParser$ImageType r4 = com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN     // Catch:{ EndOfFileException -> 0x00a9 }
            return r4
        L_0x005e:
            int r4 = r5.a()     // Catch:{ EndOfFileException -> 0x00a9 }
            int r4 = r4 << 16
            int r2 = r5.a()     // Catch:{ EndOfFileException -> 0x00a9 }
            r4 = r4 | r2
            r2 = r4 & -256(0xffffffffffffff00, float:NaN)
            r3 = 1448097792(0x56503800, float:5.7234734E13)
            if (r2 == r3) goto L_0x0073
            com.bumptech.glide.load.ImageHeaderParser$ImageType r4 = com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN     // Catch:{ EndOfFileException -> 0x00a9 }
            return r4
        L_0x0073:
            r4 = r4 & 255(0xff, float:3.57E-43)
            r2 = 88
            if (r4 != r2) goto L_0x0091
            r5.skip(r0)     // Catch:{ EndOfFileException -> 0x00a9 }
            short r4 = r5.c()     // Catch:{ EndOfFileException -> 0x00a9 }
            r5 = r4 & 2
            if (r5 == 0) goto L_0x0087
            com.bumptech.glide.load.ImageHeaderParser$ImageType r4 = com.bumptech.glide.load.ImageHeaderParser.ImageType.ANIMATED_WEBP     // Catch:{ EndOfFileException -> 0x00a9 }
            return r4
        L_0x0087:
            r4 = r4 & 16
            if (r4 == 0) goto L_0x008e
            com.bumptech.glide.load.ImageHeaderParser$ImageType r4 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP_A     // Catch:{ EndOfFileException -> 0x00a9 }
            return r4
        L_0x008e:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r4 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP     // Catch:{ EndOfFileException -> 0x00a9 }
            return r4
        L_0x0091:
            r2 = 76
            if (r4 != r2) goto L_0x00a6
            r5.skip(r0)     // Catch:{ EndOfFileException -> 0x00a9 }
            short r4 = r5.c()     // Catch:{ EndOfFileException -> 0x00a9 }
            r4 = r4 & 8
            if (r4 == 0) goto L_0x00a3
            com.bumptech.glide.load.ImageHeaderParser$ImageType r4 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP_A     // Catch:{ EndOfFileException -> 0x00a9 }
            goto L_0x00a5
        L_0x00a3:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r4 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP     // Catch:{ EndOfFileException -> 0x00a9 }
        L_0x00a5:
            return r4
        L_0x00a6:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r4 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP     // Catch:{ EndOfFileException -> 0x00a9 }
            return r4
        L_0x00a9:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r4 = com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.g(com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser$Reader):com.bumptech.glide.load.ImageHeaderParser$ImageType");
    }

    public final boolean i(byte[] bArr, int i) {
        boolean z = bArr != null && i > f2619a.length;
        if (z) {
            int i2 = 0;
            while (true) {
                byte[] bArr2 = f2619a;
                if (i2 >= bArr2.length) {
                    break;
                } else if (bArr[i2] != bArr2[i2]) {
                    return false;
                } else {
                    i2++;
                }
            }
        }
        return z;
    }

    public final int j(Reader reader) {
        short c;
        int a2;
        long j;
        long skip;
        do {
            short c2 = reader.c();
            if (c2 != 255) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Unknown segmentId=" + c2);
                }
                return -1;
            }
            c = reader.c();
            if (c == 218) {
                return -1;
            }
            if (c == 217) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            a2 = reader.a() - 2;
            if (c == 225) {
                return a2;
            }
            j = (long) a2;
            skip = reader.skip(j);
        } while (skip == j);
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Unable to skip enough data, type: " + c + ", wanted to skip: " + a2 + ", but actually skipped: " + skip);
        }
        return -1;
    }

    public final int l(Reader reader, byte[] bArr, int i) {
        int b2 = reader.b(bArr, i);
        if (b2 != i) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Unable to read exif segment data, length: " + i + ", actually read: " + b2);
            }
            return -1;
        } else if (i(bArr, i)) {
            return k(new RandomAccessReader(bArr, i));
        } else {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Missing jpeg exif preamble");
            }
            return -1;
        }
    }

    public final ImageHeaderParser.ImageType m(Reader reader, int i) {
        if (((reader.a() << 16) | reader.a()) != 1718909296) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        int a2 = (reader.a() << 16) | reader.a();
        if (a2 == 1635150195) {
            return ImageHeaderParser.ImageType.ANIMATED_AVIF;
        }
        int i2 = 0;
        boolean z = a2 == 1635150182;
        reader.skip(4);
        int i3 = i - 16;
        if (i3 % 4 == 0) {
            while (i2 < 5 && i3 > 0) {
                int a3 = (reader.a() << 16) | reader.a();
                if (a3 == 1635150195) {
                    return ImageHeaderParser.ImageType.ANIMATED_AVIF;
                }
                if (a3 == 1635150182) {
                    z = true;
                }
                i2++;
                i3 -= 4;
            }
        }
        return z ? ImageHeaderParser.ImageType.AVIF : ImageHeaderParser.ImageType.UNKNOWN;
    }
}
