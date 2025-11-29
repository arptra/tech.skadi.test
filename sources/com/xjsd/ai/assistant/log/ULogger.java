package com.xjsd.ai.assistant.log;

import android.content.Context;
import com.upuphone.star.core.log.ULog;

public class ULogger implements ILogger {

    /* renamed from: a  reason: collision with root package name */
    public boolean f8502a = true;
    public Context b;

    public ULogger(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.b = applicationContext;
        ULog.h(applicationContext, true, false);
    }

    public void d(String str, String str2) {
        if (this.f8502a) {
            ULog.d(str, str2);
        }
    }

    public void e(String str, String str2) {
        if (this.f8502a) {
            ULog.f(str, str2);
        }
    }

    public void i(String str, String str2) {
        if (this.f8502a) {
            ULog.i(str, str2);
        }
    }

    public void setEnable(boolean z) {
        this.f8502a = z;
        ULog.h(this.b, z, false);
    }

    public void w(String str, String str2) {
        if (this.f8502a) {
            ULog.m(str, str2);
        }
    }

    public void d(String str, String str2, Throwable th) {
        if (this.f8502a) {
            ULog.e(str, str2, th);
        }
    }

    public void e(String str, String str2, Throwable th) {
        if (this.f8502a) {
            ULog.g(str, str2, th);
        }
    }

    public void w(String str, String str2, Throwable th) {
        if (this.f8502a) {
            ULog.n(str, str2, th);
        }
    }
}
