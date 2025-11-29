package com.xjsd.ai.assistant.log;

public interface ILogger {
    void d(String str, String str2);

    void d(String str, String str2, Throwable th);

    void e(String str, String str2);

    void e(String str, String str2, Throwable th);

    void i(String str, String str2);

    void setEnable(boolean z);

    void w(String str, String str2);

    void w(String str, String str2, Throwable th);
}
