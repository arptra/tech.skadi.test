package com.xingin.xhssharesdk.log;

import androidx.annotation.Keep;
import androidx.annotation.Nullable;

@Keep
public interface IShareLogger {
    void d(String str, String str2);

    void e(String str, String str2, @Nullable Throwable th);

    void i(String str, String str2);

    void v(String str, String str2);

    void w(String str, String str2, @Nullable Throwable th);
}
