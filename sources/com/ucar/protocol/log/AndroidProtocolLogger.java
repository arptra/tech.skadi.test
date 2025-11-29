package com.ucar.protocol.log;

import android.util.Log;

public class AndroidProtocolLogger implements ProtocolLogger {

    /* renamed from: a  reason: collision with root package name */
    public int f9650a = 4;
    public boolean b = false;

    public boolean a() {
        return this.b;
    }

    public void d(String str, String str2) {
        if (this.f9650a <= 3) {
            Log.d("UCarProtocol", str + "(" + Thread.currentThread().getName() + "): " + str2);
        }
    }

    public void e(String str, String str2) {
        if (this.f9650a <= 6) {
            Log.e("UCarProtocol", str + "(" + Thread.currentThread().getName() + "): " + str2);
        }
    }

    public void i(String str, String str2) {
        if (this.f9650a <= 4) {
            Log.i("UCarProtocol", str + "(" + Thread.currentThread().getName() + "): " + str2);
        }
    }

    public void w(String str, String str2) {
        if (this.f9650a <= 5) {
            Log.w("UCarProtocol", str + "(" + Thread.currentThread().getName() + "): " + str2);
        }
    }

    public void e(String str, String str2, Throwable th) {
        if (this.f9650a <= 6) {
            if (th == null) {
                Log.e("UCarProtocol", str + "(" + Thread.currentThread().getName() + "): " + str2);
                return;
            }
            Log.e("UCarProtocol", str + "(" + Thread.currentThread().getName() + "): " + str2, th);
        }
    }

    public void w(String str, String str2, Throwable th) {
        if (this.f9650a <= 5) {
            if (th == null) {
                Log.w("UCarProtocol", str + "(" + Thread.currentThread().getName() + "): " + str2);
                return;
            }
            Log.w("UCarProtocol", str + "(" + Thread.currentThread().getName() + "): " + str2, th);
        }
    }
}
