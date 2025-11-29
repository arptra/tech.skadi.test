package androidx.core.view;

import android.view.Display;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

public final class DisplayCompat {

    @RequiresApi
    public static class Api23Impl {
    }

    public static final class ModeCompat {

        @RequiresApi
        public static class Api23Impl {
            @DoNotInline
            public static int a(Display.Mode mode) {
                return mode.getPhysicalHeight();
            }

            @DoNotInline
            public static int b(Display.Mode mode) {
                return mode.getPhysicalWidth();
            }
        }
    }
}
