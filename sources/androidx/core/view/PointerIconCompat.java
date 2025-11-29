package androidx.core.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.PointerIcon;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

public final class PointerIconCompat {

    /* renamed from: a  reason: collision with root package name */
    public final PointerIcon f880a;

    @RequiresApi
    public static class Api24Impl {
        @DoNotInline
        public static PointerIcon a(Bitmap bitmap, float f, float f2) {
            return PointerIcon.create(bitmap, f, f2);
        }

        @DoNotInline
        public static PointerIcon b(Context context, int i) {
            return PointerIcon.getSystemIcon(context, i);
        }

        @DoNotInline
        public static PointerIcon c(Resources resources, int i) {
            return PointerIcon.load(resources, i);
        }
    }

    public PointerIconCompat(PointerIcon pointerIcon) {
        this.f880a = pointerIcon;
    }

    public static PointerIconCompat b(Context context, int i) {
        return new PointerIconCompat(Api24Impl.b(context, i));
    }

    public Object a() {
        return this.f880a;
    }
}
