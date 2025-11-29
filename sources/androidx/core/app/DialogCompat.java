package androidx.core.app;

import android.app.Dialog;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

public class DialogCompat {

    @RequiresApi
    public static class Api28Impl {
        @DoNotInline
        public static <T> T a(Dialog dialog, int i) {
            return dialog.requireViewById(i);
        }
    }
}
