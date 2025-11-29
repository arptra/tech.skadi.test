package androidx.core.os;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.RequiresApi;

public final class HandlerCompat {

    @RequiresApi
    public static class Api28Impl {
        public static Handler a(Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    @RequiresApi
    public static class Api29Impl {
    }

    public static Handler a(Looper looper) {
        return Api28Impl.a(looper);
    }
}
