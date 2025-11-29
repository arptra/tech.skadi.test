package com.xingin.xhssharesdk.k;

import android.util.Log;
import com.xingin.xhssharesdk.log.IShareLogger;

public final class a implements IShareLogger {
    public final void d(String str, String str2) {
        Log.d(str, str2);
    }

    public final void e(String str, String str2, Throwable th) {
        Log.w(str, str2, th);
    }

    public final void i(String str, String str2) {
        Log.i(str, str2);
    }

    public final void v(String str, String str2) {
        Log.v(str, str2);
    }

    public final void w(String str, String str2, Throwable th) {
        Log.w(str, str2, th);
    }
}
