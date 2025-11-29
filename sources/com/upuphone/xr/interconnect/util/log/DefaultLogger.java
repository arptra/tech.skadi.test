package com.upuphone.xr.interconnect.util.log;

import com.upuphone.star.core.log.ULog;

public class DefaultLogger implements ILogger {
    public void d(String str, String str2) {
        ULog.d(str, str2);
    }

    public void e(String str, String str2) {
        ULog.f(str, str2);
    }

    public void i(String str, String str2) {
        ULog.i(str, str2);
    }

    public void setEnable(boolean z) {
        ULog.e = z;
    }

    public void v(String str, String str2) {
        ULog.k(str, str2);
    }

    public void w(String str, String str2) {
        ULog.m(str, str2);
    }

    public void d(String str, String str2, Throwable th) {
        ULog.e(str, str2, th);
    }

    public void e(String str, String str2, Throwable th) {
        ULog.g(str, str2, th);
    }

    public void i(String str, String str2, Throwable th) {
        ULog.j(str, str2, th);
    }

    public void v(String str, String str2, Throwable th) {
        ULog.l(str, str2, th);
    }

    public void w(String str, String str2, Throwable th) {
        ULog.n(str, str2, th);
    }
}
