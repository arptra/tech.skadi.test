package androidx.core.view;

import android.view.Menu;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

public final class MenuCompat {

    @RequiresApi
    public static class Api28Impl {
        @DoNotInline
        public static void a(Menu menu, boolean z) {
            menu.setGroupDividerEnabled(z);
        }
    }
}
