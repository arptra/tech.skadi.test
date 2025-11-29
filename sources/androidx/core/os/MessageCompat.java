package androidx.core.os;

import android.os.Message;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

public final class MessageCompat {

    @RequiresApi
    public static class Api22Impl {
        @DoNotInline
        public static boolean a(Message message) {
            return message.isAsynchronous();
        }

        @DoNotInline
        public static void b(Message message, boolean z) {
            message.setAsynchronous(z);
        }
    }
}
