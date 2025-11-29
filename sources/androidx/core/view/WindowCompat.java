package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

public final class WindowCompat {

    public static class Api16Impl {
        public static void a(Window window, boolean z) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z ? systemUiVisibility & -1793 : systemUiVisibility | 1792);
        }
    }

    @RequiresApi
    public static class Api28Impl {
        @DoNotInline
        public static <T> T a(Window window, int i) {
            return window.requireViewById(i);
        }
    }

    @RequiresApi
    public static class Api30Impl {
        @DoNotInline
        public static void a(@NonNull Window window, boolean z) {
            window.setDecorFitsSystemWindows(z);
        }
    }

    public static WindowInsetsControllerCompat a(Window window, View view) {
        return new WindowInsetsControllerCompat(window, view);
    }

    public static void b(Window window, boolean z) {
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.a(window, z);
        } else {
            Api16Impl.a(window, z);
        }
    }
}
