package androidx.core.graphics;

import android.graphics.Path;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

public final class PathUtils {

    @RequiresApi
    public static class Api26Impl {
        @DoNotInline
        public static float[] a(Path path, float f) {
            return path.approximate(f);
        }
    }
}
