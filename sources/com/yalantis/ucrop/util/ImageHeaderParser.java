package com.yalantis.ucrop.util;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

public class ImageHeaderParser {
    public static final byte[] b = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));
    public static final int[] c = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* renamed from: a  reason: collision with root package name */
    public final Reader f8753a;

    public static class RandomAccessReader {

        /* renamed from: a  reason: collision with root package name */
        public final ByteBuffer f8754a;

        public RandomAccessReader(byte[] bArr, int i) {
            this.f8754a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i);
        }

        public short a(int i) {
            return this.f8754a.getShort(i);
        }

        public int b(int i) {
            return this.f8754a.getInt(i);
        }

        public int c() {
            return this.f8754a.remaining();
        }

        public void d(ByteOrder byteOrder) {
            this.f8754a.order(byteOrder);
        }
    }

    public interface Reader {
        int a();

        int b(byte[] bArr, int i);

        short c();

        long skip(long j);
    }

    public static class StreamReader implements Reader {

        /* renamed from: a  reason: collision with root package name */
        public final InputStream f8755a;

        public StreamReader(InputStream inputStream) {
            this.f8755a = inputStream;
        }

        public int a() {
            return (this.f8755a.read() & 255) | ((this.f8755a.read() << 8) & 65280);
        }

        public int b(byte[] bArr, int i) {
            int i2 = i;
            while (i2 > 0) {
                int read = this.f8755a.read(bArr, i - i2, i2);
                if (read == -1) {
                    break;
                }
                i2 -= read;
            }
            return i - i2;
        }

        public short c() {
            return (short) (this.f8755a.read() & 255);
        }

        public long skip(long j) {
            if (j < 0) {
                return 0;
            }
            long j2 = j;
            while (j2 > 0) {
                long skip = this.f8755a.skip(j2);
                if (skip <= 0) {
                    if (this.f8755a.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j2 -= skip;
            }
            return j - j2;
        }
    }

    public ImageHeaderParser(InputStream inputStream) {
        this.f8753a = new StreamReader(inputStream);
    }

    public static int a(int i, int i2) {
        return i + 2 + (i2 * 12);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: android.os.ParcelFileDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: android.os.ParcelFileDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: android.os.ParcelFileDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: android.os.ParcelFileDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: android.os.ParcelFileDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: android.os.ParcelFileDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: android.os.ParcelFileDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.io.InputStream} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x005f A[SYNTHETIC, Splitter:B:29:0x005f] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006d A[SYNTHETIC, Splitter:B:34:0x006d] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0074 A[SYNTHETIC, Splitter:B:38:0x0074] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0082 A[SYNTHETIC, Splitter:B:43:0x0082] */
    /* JADX WARNING: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(android.content.Context r4, int r5, int r6, android.net.Uri r7, android.net.Uri r8) {
        /*
            java.lang.String r0 = "ImageHeaderParser"
            if (r4 != 0) goto L_0x000a
            java.lang.String r4 = "context is null"
            android.util.Log.d(r0, r4)
            return
        L_0x000a:
            r1 = 0
            android.content.ContentResolver r2 = r4.getContentResolver()     // Catch:{ IOException -> 0x0054, all -> 0x0051 }
            java.io.InputStream r7 = r2.openInputStream(r7)     // Catch:{ IOException -> 0x0054, all -> 0x0051 }
            androidx.exifinterface.media.ExifInterface r2 = new androidx.exifinterface.media.ExifInterface     // Catch:{ IOException -> 0x004d, all -> 0x0049 }
            r2.<init>((java.io.InputStream) r7)     // Catch:{ IOException -> 0x004d, all -> 0x0049 }
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch:{ IOException -> 0x004d, all -> 0x0049 }
            java.lang.String r3 = "rw"
            android.os.ParcelFileDescriptor r1 = r4.openFileDescriptor(r8, r3)     // Catch:{ IOException -> 0x004d, all -> 0x0049 }
            androidx.exifinterface.media.ExifInterface r4 = new androidx.exifinterface.media.ExifInterface     // Catch:{ IOException -> 0x004d, all -> 0x0049 }
            java.io.FileDescriptor r8 = r1.getFileDescriptor()     // Catch:{ IOException -> 0x004d, all -> 0x0049 }
            r4.<init>((java.io.FileDescriptor) r8)     // Catch:{ IOException -> 0x004d, all -> 0x0049 }
            f(r2, r4, r5, r6)     // Catch:{ IOException -> 0x004d, all -> 0x0049 }
            if (r7 == 0) goto L_0x003c
            r7.close()     // Catch:{ IOException -> 0x0034 }
            goto L_0x003c
        L_0x0034:
            r4 = move-exception
            java.lang.String r5 = r4.getMessage()
            android.util.Log.d(r0, r5, r4)
        L_0x003c:
            r1.close()     // Catch:{ IOException -> 0x0040 }
            goto L_0x0070
        L_0x0040:
            r4 = move-exception
            java.lang.String r5 = r4.getMessage()
            android.util.Log.d(r0, r5, r4)
            goto L_0x0070
        L_0x0049:
            r4 = move-exception
            r5 = r1
            r1 = r7
            goto L_0x0072
        L_0x004d:
            r4 = move-exception
            r5 = r1
            r1 = r7
            goto L_0x0056
        L_0x0051:
            r4 = move-exception
            r5 = r1
            goto L_0x0072
        L_0x0054:
            r4 = move-exception
            r5 = r1
        L_0x0056:
            java.lang.String r6 = r4.getMessage()     // Catch:{ all -> 0x0071 }
            android.util.Log.d(r0, r6, r4)     // Catch:{ all -> 0x0071 }
            if (r1 == 0) goto L_0x006b
            r1.close()     // Catch:{ IOException -> 0x0063 }
            goto L_0x006b
        L_0x0063:
            r4 = move-exception
            java.lang.String r6 = r4.getMessage()
            android.util.Log.d(r0, r6, r4)
        L_0x006b:
            if (r5 == 0) goto L_0x0070
            r5.close()     // Catch:{ IOException -> 0x0040 }
        L_0x0070:
            return
        L_0x0071:
            r4 = move-exception
        L_0x0072:
            if (r1 == 0) goto L_0x0080
            r1.close()     // Catch:{ IOException -> 0x0078 }
            goto L_0x0080
        L_0x0078:
            r6 = move-exception
            java.lang.String r7 = r6.getMessage()
            android.util.Log.d(r0, r7, r6)
        L_0x0080:
            if (r5 == 0) goto L_0x008e
            r5.close()     // Catch:{ IOException -> 0x0086 }
            goto L_0x008e
        L_0x0086:
            r5 = move-exception
            java.lang.String r6 = r5.getMessage()
            android.util.Log.d(r0, r6, r5)
        L_0x008e:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yalantis.ucrop.util.ImageHeaderParser.b(android.content.Context, int, int, android.net.Uri, android.net.Uri):void");
    }

    public static void c(Context context, int i, int i2, Uri uri, String str) {
        if (context == null) {
            Log.d("ImageHeaderParser", "context is null");
            return;
        }
        InputStream inputStream = null;
        try {
            inputStream = context.getContentResolver().openInputStream(uri);
            f(new ExifInterface(inputStream), new ExifInterface(str), i, i2);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    Log.d("ImageHeaderParser", e.getMessage(), e);
                }
            }
        } catch (IOException e2) {
            Log.d("ImageHeaderParser", e2.getMessage(), e2);
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    Log.d("ImageHeaderParser", e3.getMessage(), e3);
                }
            }
            throw th;
        }
    }

    public static void d(Context context, ExifInterface exifInterface, int i, int i2, Uri uri) {
        if (context == null) {
            Log.d("ImageHeaderParser", "context is null");
            return;
        }
        ParcelFileDescriptor parcelFileDescriptor = null;
        try {
            parcelFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "rw");
            f(exifInterface, new ExifInterface(parcelFileDescriptor.getFileDescriptor()), i, i2);
            try {
                parcelFileDescriptor.close();
            } catch (IOException e) {
                Log.d("ImageHeaderParser", e.getMessage(), e);
            }
        } catch (IOException e2) {
            Log.d("ImageHeaderParser", e2.getMessage());
            if (parcelFileDescriptor != null) {
                parcelFileDescriptor.close();
            }
        } catch (Throwable th) {
            if (parcelFileDescriptor != null) {
                try {
                    parcelFileDescriptor.close();
                } catch (IOException e3) {
                    Log.d("ImageHeaderParser", e3.getMessage(), e3);
                }
            }
            throw th;
        }
    }

    public static void e(ExifInterface exifInterface, int i, int i2, String str) {
        try {
            f(exifInterface, new ExifInterface(str), i, i2);
        } catch (IOException e) {
            Log.d("ImageHeaderParser", e.getMessage());
        }
    }

    public static void f(ExifInterface exifInterface, ExifInterface exifInterface2, int i, int i2) {
        ExifInterface exifInterface3 = exifInterface2;
        String[] strArr = {ExifInterface.TAG_F_NUMBER, ExifInterface.TAG_DATETIME, ExifInterface.TAG_DATETIME_DIGITIZED, ExifInterface.TAG_EXPOSURE_TIME, ExifInterface.TAG_FLASH, ExifInterface.TAG_FOCAL_LENGTH, ExifInterface.TAG_GPS_ALTITUDE, ExifInterface.TAG_GPS_ALTITUDE_REF, ExifInterface.TAG_GPS_DATESTAMP, ExifInterface.TAG_GPS_LATITUDE, ExifInterface.TAG_GPS_LATITUDE_REF, ExifInterface.TAG_GPS_LONGITUDE, ExifInterface.TAG_GPS_LONGITUDE_REF, ExifInterface.TAG_GPS_PROCESSING_METHOD, ExifInterface.TAG_GPS_TIMESTAMP, ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY, ExifInterface.TAG_MAKE, ExifInterface.TAG_MODEL, ExifInterface.TAG_SUBSEC_TIME, ExifInterface.TAG_SUBSEC_TIME_DIGITIZED, ExifInterface.TAG_SUBSEC_TIME_ORIGINAL, ExifInterface.TAG_WHITE_BALANCE};
        for (int i3 = 0; i3 < 22; i3++) {
            String str = strArr[i3];
            String attribute = exifInterface.getAttribute(str);
            if (!TextUtils.isEmpty(attribute)) {
                exifInterface3.setAttribute(str, attribute);
            }
        }
        exifInterface3.setAttribute(ExifInterface.TAG_IMAGE_WIDTH, String.valueOf(i));
        exifInterface3.setAttribute(ExifInterface.TAG_IMAGE_LENGTH, String.valueOf(i2));
        exifInterface3.setAttribute(ExifInterface.TAG_ORIENTATION, "0");
        exifInterface2.saveAttributes();
    }

    public static boolean h(int i) {
        return (i & 65496) == 65496 || i == 19789 || i == 18761;
    }

    public static int k(RandomAccessReader randomAccessReader) {
        ByteOrder byteOrder;
        short a2 = randomAccessReader.a(6);
        if (a2 == 19789) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else if (a2 == 18761) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else {
            if (Log.isLoggable("ImageHeaderParser", 3)) {
                Log.d("ImageHeaderParser", "Unknown endianness = " + a2);
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        randomAccessReader.d(byteOrder);
        int b2 = randomAccessReader.b(10) + 6;
        short a3 = randomAccessReader.a(b2);
        for (int i = 0; i < a3; i++) {
            int a4 = a(b2, i);
            short a5 = randomAccessReader.a(a4);
            if (a5 == 274) {
                short a6 = randomAccessReader.a(a4 + 2);
                if (a6 >= 1 && a6 <= 12) {
                    int b3 = randomAccessReader.b(a4 + 4);
                    if (b3 >= 0) {
                        if (Log.isLoggable("ImageHeaderParser", 3)) {
                            Log.d("ImageHeaderParser", "Got tagIndex=" + i + " tagType=" + a5 + " formatCode=" + a6 + " componentCount=" + b3);
                        }
                        int i2 = b3 + c[a6];
                        if (i2 <= 4) {
                            int i3 = a4 + 8;
                            if (i3 < 0 || i3 > randomAccessReader.c()) {
                                if (Log.isLoggable("ImageHeaderParser", 3)) {
                                    Log.d("ImageHeaderParser", "Illegal tagValueOffset=" + i3 + " tagType=" + a5);
                                }
                            } else if (i2 >= 0 && i2 + i3 <= randomAccessReader.c()) {
                                return randomAccessReader.a(i3);
                            } else {
                                if (Log.isLoggable("ImageHeaderParser", 3)) {
                                    Log.d("ImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + a5);
                                }
                            }
                        } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                            Log.d("ImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + a6);
                        }
                    } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                        Log.d("ImageHeaderParser", "Negative tiff component count");
                    }
                } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                    Log.d("ImageHeaderParser", "Got invalid format code = " + a6);
                }
            }
        }
        return -1;
    }

    public int g() {
        int a2 = this.f8753a.a();
        if (!h(a2)) {
            if (Log.isLoggable("ImageHeaderParser", 3)) {
                Log.d("ImageHeaderParser", "Parser doesn't handle magic number: " + a2);
            }
            return -1;
        }
        int j = j();
        if (j != -1) {
            return l(new byte[j], j);
        }
        if (Log.isLoggable("ImageHeaderParser", 3)) {
            Log.d("ImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
        }
        return -1;
    }

    public final boolean i(byte[] bArr, int i) {
        boolean z = bArr != null && i > b.length;
        if (z) {
            int i2 = 0;
            while (true) {
                byte[] bArr2 = b;
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

    public final int j() {
        short c2;
        int a2;
        long j;
        long skip;
        do {
            short c3 = this.f8753a.c();
            if (c3 != 255) {
                if (Log.isLoggable("ImageHeaderParser", 3)) {
                    Log.d("ImageHeaderParser", "Unknown segmentId=" + c3);
                }
                return -1;
            }
            c2 = this.f8753a.c();
            if (c2 == 218) {
                return -1;
            }
            if (c2 == 217) {
                if (Log.isLoggable("ImageHeaderParser", 3)) {
                    Log.d("ImageHeaderParser", "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            a2 = this.f8753a.a() - 2;
            if (c2 == 225) {
                return a2;
            }
            j = (long) a2;
            skip = this.f8753a.skip(j);
        } while (skip == j);
        if (Log.isLoggable("ImageHeaderParser", 3)) {
            Log.d("ImageHeaderParser", "Unable to skip enough data, type: " + c2 + ", wanted to skip: " + a2 + ", but actually skipped: " + skip);
        }
        return -1;
    }

    public final int l(byte[] bArr, int i) {
        int b2 = this.f8753a.b(bArr, i);
        if (b2 != i) {
            if (Log.isLoggable("ImageHeaderParser", 3)) {
                Log.d("ImageHeaderParser", "Unable to read exif segment data, length: " + i + ", actually read: " + b2);
            }
            return -1;
        } else if (i(bArr, i)) {
            return k(new RandomAccessReader(bArr, i));
        } else {
            if (Log.isLoggable("ImageHeaderParser", 3)) {
                Log.d("ImageHeaderParser", "Missing jpeg exif preamble");
            }
            return -1;
        }
    }
}
