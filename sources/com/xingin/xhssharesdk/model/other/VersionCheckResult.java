package com.xingin.xhssharesdk.model.other;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

@Keep
public class VersionCheckResult {
    public static final int NOT_INSTALL = -1;
    public static final int SUPPORT_SHARE_NOTE = 0;
    public static final int VERSION_IS_NOT_SUPPORT = -2;
    public int checkResultCode;
    @NonNull
    public String errorMessage;
    @Nullable
    public Throwable exception;

    public VersionCheckResult(int i, @NonNull String str, @Nullable Throwable th) {
        this.checkResultCode = i;
        this.errorMessage = str;
        this.exception = th;
    }
}
