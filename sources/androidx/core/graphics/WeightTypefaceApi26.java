package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.LongSparseArray;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@RequiresApi
@SuppressLint({"SoonBlockedPrivateApi"})
@RestrictTo
final class WeightTypefaceApi26 {

    /* renamed from: a  reason: collision with root package name */
    public static final Field f725a;
    public static final Method b;
    public static final Constructor c;
    public static final LongSparseArray d = new LongSparseArray(3);
    public static final Object e = new Object();

    static {
        Method method;
        Field field;
        Constructor<Typeface> constructor;
        Class<Typeface> cls = Typeface.class;
        try {
            field = cls.getDeclaredField("native_instance");
            Class cls2 = Long.TYPE;
            method = cls.getDeclaredMethod("nativeCreateFromTypefaceWithExactStyle", new Class[]{cls2, Integer.TYPE, Boolean.TYPE});
            method.setAccessible(true);
            constructor = cls.getDeclaredConstructor(new Class[]{cls2});
            constructor.setAccessible(true);
        } catch (NoSuchFieldException | NoSuchMethodException e2) {
            Log.e("WeightTypeface", e2.getClass().getName(), e2);
            field = null;
            constructor = null;
            method = null;
        }
        f725a = field;
        b = method;
        c = constructor;
    }
}
