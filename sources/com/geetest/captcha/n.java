package com.geetest.captcha;

import java.io.File;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;

public class n {
    static {
        char c = File.separatorChar;
        try {
            StringWriter stringWriter = new StringWriter(4);
            new PrintWriter(stringWriter).println();
            stringWriter.toString();
        } catch (Exception unused) {
        }
    }

    public static String a(Reader reader) {
        try {
            StringWriter stringWriter = new StringWriter();
            char[] cArr = new char[4096];
            while (true) {
                int read = reader.read(cArr);
                if (-1 == read) {
                    return stringWriter.toString();
                }
                stringWriter.write(cArr, 0, read);
            }
        } catch (Exception unused) {
            return null;
        }
    }

    public static String b(byte[] bArr, String str) {
        return new String(bArr, Charset.forName(str));
    }

    public static void c(String str, Writer writer) {
        if (str != null) {
            writer.write(str);
        }
    }
}
