package com.here.sdk.core.utilities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class Preconditions {
    private Preconditions() {
    }

    @NonNull
    public static <T> T checkArgumentNotNull(@Nullable T t, @Nullable String str) {
        if (t != null) {
            return t;
        }
        if (str == null) {
            str = "NonNull argument is null.";
        }
        throw new IllegalArgumentException(str);
    }

    @NonNull
    public static <T> T checkNotNull(@Nullable T t) {
        t.getClass();
        return t;
    }
}
