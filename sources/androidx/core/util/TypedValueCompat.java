package androidx.core.util;

import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class TypedValueCompat {

    @RequiresApi
    public static class Api34Impl {
        @DoNotInline
        public static float a(int i, float f, DisplayMetrics displayMetrics) {
            return TypedValue.deriveDimension(i, f, displayMetrics);
        }
    }

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface ComplexDimensionUnit {
    }
}
