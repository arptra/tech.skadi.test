package com.ucar.protocol.log;

public interface ProtocolLogger {
    boolean a();

    void d(String str, String str2);

    void e(String str, String str2);

    void e(String str, String str2, Throwable th);

    void i(String str, String str2);

    void w(String str, String str2);

    void w(String str, String str2, Throwable th);
}
