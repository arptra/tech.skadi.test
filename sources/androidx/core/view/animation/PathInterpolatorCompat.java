package androidx.core.view.animation;

import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

public final class PathInterpolatorCompat {

    @RequiresApi
    public static class Api21Impl {
        @DoNotInline
        public static Interpolator a(float f, float f2) {
            return new PathInterpolator(f, f2);
        }

        @DoNotInline
        public static Interpolator b(float f, float f2, float f3, float f4) {
            return new PathInterpolator(f, f2, f3, f4);
        }

        @DoNotInline
        public static Interpolator c(Path path) {
            return new PathInterpolator(path);
        }
    }

    public static Interpolator a(float f, float f2, float f3, float f4) {
        return Api21Impl.b(f, f2, f3, f4);
    }

    public static Interpolator b(Path path) {
        return Api21Impl.c(path);
    }
}
