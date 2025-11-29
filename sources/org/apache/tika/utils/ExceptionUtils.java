package org.apache.tika.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.regex.Pattern;
import org.apache.tika.exception.TikaException;

public class ExceptionUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f3339a = Pattern.compile(":[^\r\n]+");

    public static String a(Throwable th) {
        if (th.getClass().equals(TikaException.class) && th.getCause() != null) {
            th = th.getCause();
        }
        return b(th);
    }

    public static String b(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        try {
            printWriter.flush();
            stringWriter.flush();
            printWriter.close();
            stringWriter.close();
        } catch (IOException unused) {
        }
        return stringWriter.toString();
    }
}
