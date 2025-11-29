package com.xingin.xhssharesdk.callback;

import androidx.annotation.Keep;
import androidx.annotation.Nullable;

@Keep
public interface XhsShareRegisterCallback {
    void onError(int i, String str, @Nullable Exception exc);

    void onSuccess();
}
