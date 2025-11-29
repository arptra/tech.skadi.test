package androidx.core.database;

import android.database.CursorWindow;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

public final class CursorWindowCompat {

    @RequiresApi
    public static class Api28Impl {
        @DoNotInline
        public static CursorWindow a(String str, long j) {
            return new CursorWindow(str, j);
        }
    }
}
