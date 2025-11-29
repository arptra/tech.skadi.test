package com.geetest.sdk;

import com.here.posclient.UpdateOptions;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;

public class p {
    public static int a(Reader reader, Writer writer) {
        long f = f(reader, writer);
        if (f > UpdateOptions.SOURCE_ANY) {
            return -1;
        }
        return (int) f;
    }

    public static long b(Reader reader, Writer writer, char[] cArr) {
        long j = 0;
        while (true) {
            int read = reader.read(cArr);
            if (-1 == read) {
                return j;
            }
            writer.write(cArr, 0, read);
            j += (long) read;
        }
    }

    public static String c(Reader reader) {
        try {
            StringWriter stringWriter = new StringWriter();
            a(reader, stringWriter);
            reader.close();
            return stringWriter.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String d(byte[] bArr, String str) {
        return new String(bArr, Charset.forName(str));
    }

    public static void e(String str, Writer writer) {
        if (str != null) {
            writer.write(str);
        }
    }

    public static long f(Reader reader, Writer writer) {
        return b(reader, writer, new char[4096]);
    }
}
