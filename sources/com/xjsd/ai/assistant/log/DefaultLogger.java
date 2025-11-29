package com.xjsd.ai.assistant.log;

import android.util.Log;

public class DefaultLogger implements ILogger {

    /* renamed from: a  reason: collision with root package name */
    public boolean f8500a = true;

    public void d(String str, String str2) {
        if (this.f8500a) {
            Log.d(str, str2);
        }
    }

    public void e(String str, String str2) {
        if (this.f8500a) {
            Log.e(str, str2);
        }
    }

    public void i(String str, String str2) {
        if (this.f8500a) {
            Log.i(str, str2);
        }
    }

    public void setEnable(boolean z) {
        this.f8500a = z;
    }

    public void w(String str, String str2) {
        if (this.f8500a) {
            Log.w(str, str2);
        }
    }

    public void d(String str, String str2, Throwable th) {
        if (this.f8500a) {
            Log.d(str, str2, th);
        }
    }

    public void e(String str, String str2, Throwable th) {
        if (this.f8500a) {
            Log.e(str, str2, th);
        }
    }

    public void w(String str, String str2, Throwable th) {
        if (this.f8500a) {
            Log.w(str, str2, th);
        }
    }
}
