package io.flutter.util;

import android.os.Handler;
import android.os.Looper;

public final class HandlerCompat {
    public static Handler createAsyncHandler(Looper looper) {
        return Handler.createAsync(looper);
    }
}
