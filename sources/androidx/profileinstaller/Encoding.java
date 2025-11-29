package androidx.profileinstaller;

import androidx.annotation.RequiresApi;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;

@RequiresApi
class Encoding {
    public static int a(int i) {
        return ((i + 7) & -8) / 8;
    }

    public static byte[] b(byte[] bArr) {
        DeflaterOutputStream deflaterOutputStream;
        Deflater deflater = new Deflater(1);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
            deflaterOutputStream.write(bArr);
            deflaterOutputStream.close();
            deflater.end();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            deflater.end();
            throw th;
        }
        throw th;
    }

    public static RuntimeException c(String str) {
        return new IllegalStateException(str);
    }

    public static byte[] d(InputStream inputStream, int i) {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read >= 0) {
                i2 += read;
            } else {
                throw c("Not enough bytes to read: " + i);
            }
        }
        return bArr;
    }

    public static byte[] e(InputStream inputStream, int i, int i2) {
        Inflater inflater = new Inflater();
        try {
            byte[] bArr = new byte[i2];
            byte[] bArr2 = new byte[2048];
            int i3 = 0;
            int i4 = 0;
            while (!inflater.finished() && !inflater.needsDictionary() && i3 < i) {
                int read = inputStream.read(bArr2);
                if (read >= 0) {
                    inflater.setInput(bArr2, 0, read);
                    i4 += inflater.inflate(bArr, i4, i2 - i4);
                    i3 += read;
                } else {
                    throw c("Invalid zip data. Stream ended after $totalBytesRead bytes. Expected " + i + " bytes");
                }
            }
            if (i3 != i) {
                throw c("Didn't read enough bytes during decompression. expected=" + i + " actual=" + i3);
            } else if (inflater.finished()) {
                inflater.end();
                return bArr;
            } else {
                throw c("Inflater did not finish");
            }
        } catch (DataFormatException e) {
            throw c(e.getMessage());
        } catch (Throwable th) {
            inflater.end();
            throw th;
        }
    }

    public static String f(InputStream inputStream, int i) {
        return new String(d(inputStream, i), StandardCharsets.UTF_8);
    }

    public static long g(InputStream inputStream, int i) {
        byte[] d = d(inputStream, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j += ((long) (d[i2] & 255)) << (i2 * 8);
        }
        return j;
    }

    public static int h(InputStream inputStream) {
        return (int) g(inputStream, 2);
    }

    public static long i(InputStream inputStream) {
        return g(inputStream, 4);
    }

    public static int j(InputStream inputStream) {
        return (int) g(inputStream, 1);
    }

    public static int k(String str) {
        return str.getBytes(StandardCharsets.UTF_8).length;
    }

    public static void l(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[512];
        while (true) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static void m(OutputStream outputStream, byte[] bArr) {
        q(outputStream, (long) bArr.length);
        byte[] b = b(bArr);
        q(outputStream, (long) b.length);
        outputStream.write(b);
    }

    public static void n(OutputStream outputStream, String str) {
        outputStream.write(str.getBytes(StandardCharsets.UTF_8));
    }

    public static void o(OutputStream outputStream, long j, int i) {
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) ((int) ((j >> (i2 * 8)) & 255));
        }
        outputStream.write(bArr);
    }

    public static void p(OutputStream outputStream, int i) {
        o(outputStream, (long) i, 2);
    }

    public static void q(OutputStream outputStream, long j) {
        o(outputStream, j, 4);
    }

    public static void r(OutputStream outputStream, int i) {
        o(outputStream, (long) i, 1);
    }
}
