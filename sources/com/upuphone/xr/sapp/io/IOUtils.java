package com.upuphone.xr.sapp.io;

import com.here.posclient.UpdateOptions;
import com.upuphone.xr.sapp.io.stream.ByteArrayOutputStream;
import com.upuphone.xr.sapp.io.stream.StringBuilderWriter;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class IOUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final char f7101a = File.separatorChar;
    public static final String b;

    static {
        StringBuilderWriter stringBuilderWriter = new StringBuilderWriter(4);
        PrintWriter printWriter = new PrintWriter(stringBuilderWriter);
        printWriter.println();
        b = stringBuilderWriter.toString();
        printWriter.close();
    }

    public static int a(InputStream inputStream, OutputStream outputStream) {
        long b2 = b(inputStream, outputStream);
        if (b2 > UpdateOptions.SOURCE_ANY) {
            return -1;
        }
        return (int) b2;
    }

    public static long b(InputStream inputStream, OutputStream outputStream) {
        return c(inputStream, outputStream, new byte[4096]);
    }

    public static long c(InputStream inputStream, OutputStream outputStream, byte[] bArr) {
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += (long) read;
        }
    }

    public static byte[] d(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.b();
    }
}
