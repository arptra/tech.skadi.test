package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.Paint;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

public final class PaintCompat {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadLocal f713a = new ThreadLocal();

    @RequiresApi
    public static class Api23Impl {
        @DoNotInline
        public static boolean a(Paint paint, String str) {
            return paint.hasGlyph(str);
        }
    }

    @RequiresApi
    public static class Api29Impl {
        @DoNotInline
        public static void a(Paint paint, Object obj) {
            paint.setBlendMode((BlendMode) obj);
        }
    }

    public static boolean a(Paint paint, String str) {
        return Api23Impl.a(paint, str);
    }
}
