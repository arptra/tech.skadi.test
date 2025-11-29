package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true)
final class Platform {
    private Platform() {
    }

    public static void checkGwtRpcEnabled() {
    }
}
