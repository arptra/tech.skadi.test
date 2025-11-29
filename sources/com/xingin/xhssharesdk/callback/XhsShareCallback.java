package com.xingin.xhssharesdk.callback;

import androidx.annotation.Keep;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

@Keep
public interface XhsShareCallback {
    @MainThread
    @Deprecated
    void onError(@NonNull String str, int i, @NonNull String str2, @Nullable Throwable th);

    @MainThread
    void onError2(@NonNull String str, int i, @Deprecated int i2, @NonNull String str2, @Nullable Throwable th) {
        onError(str, i2, str2, th);
    }

    @MainThread
    void onSuccess(String str);
}
