package androidx.core.graphics;

import android.graphics.Typeface;
import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.collection.LongSparseArray;
import java.lang.reflect.Field;

@RestrictTo
final class WeightTypefaceApi14 {

    /* renamed from: a  reason: collision with root package name */
    public static final Field f723a;
    public static final LongSparseArray b = new LongSparseArray(3);
    public static final Object c = new Object();

    static {
        Field field;
        try {
            field = Typeface.class.getDeclaredField("native_instance");
            field.setAccessible(true);
        } catch (Exception e) {
            Log.e("WeightTypeface", e.getClass().getName(), e);
            field = null;
        }
        f723a = field;
    }
}
