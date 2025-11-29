package com.ucar.protocol.log;

import androidx.exifinterface.media.ExifInterface;
import java.io.PrintStream;
import org.apache.commons.lang3.StringUtils;

public class DefaultProtocolLogger implements ProtocolLogger {

    /* renamed from: a  reason: collision with root package name */
    public int f9651a = 4;
    public boolean b = false;

    public boolean a() {
        return this.b;
    }

    public final synchronized void b(String str, String str2, String str3) {
        for (String str4 : str2.split(StringUtils.LF)) {
            PrintStream printStream = System.out;
            printStream.println(System.currentTimeMillis() + " " + Thread.currentThread().getId() + " " + str3 + "/" + str + "(" + Thread.currentThread().getName() + "): " + str4);
        }
    }

    public final synchronized void c(Throwable th, String str, String str2) {
        if (th != null) {
            try {
                StackTraceElement[] stackTrace = th.getStackTrace();
                PrintStream printStream = System.out;
                if (str2.equals(ExifInterface.LONGITUDE_EAST)) {
                    printStream = System.err;
                }
                long id = Thread.currentThread().getId();
                String name = Thread.currentThread().getName();
                printStream.println(System.currentTimeMillis() + " " + id + " " + str2 + "/" + str + "(" + name + "): " + th.toString());
                for (StackTraceElement stackTraceElement : stackTrace) {
                    printStream.println(System.currentTimeMillis() + " " + id + " " + str2 + "/" + str + "(" + name + "): \tat " + stackTraceElement.toString());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void d(String str, String str2) {
        if (this.f9651a <= 3) {
            b(str, str2, "D");
        }
    }

    public void e(String str, String str2) {
        if (this.f9651a <= 6) {
            b(str, str2, ExifInterface.LONGITUDE_EAST);
        }
    }

    public void i(String str, String str2) {
        if (this.f9651a <= 4) {
            b(str, str2, "I");
        }
    }

    public void w(String str, String str2) {
        if (this.f9651a <= 5) {
            b(str, str2, ExifInterface.LONGITUDE_WEST);
        }
    }

    public void e(String str, String str2, Throwable th) {
        if (this.f9651a <= 6) {
            b(str, str2, ExifInterface.LONGITUDE_EAST);
            c(th, str, ExifInterface.LONGITUDE_EAST);
        }
    }

    public void w(String str, String str2, Throwable th) {
        if (this.f9651a <= 5) {
            b(str, str2, ExifInterface.LONGITUDE_WEST);
            c(th, str, ExifInterface.LONGITUDE_WEST);
        }
    }
}
