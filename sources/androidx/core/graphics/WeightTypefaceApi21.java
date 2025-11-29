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
final class WeightTypefaceApi21 {

    /* renamed from: a  reason: collision with root package name */
    public static final Field f724a;
    public static final Method b;
    public static final Method c;
    public static final Constructor d;
    public static final LongSparseArray e = new LongSparseArray(3);
    public static final Object f = new Object();

    static {
        Method method;
        Method method2;
        Field field;
        Constructor<Typeface> constructor;
        Class<Typeface> cls = Typeface.class;
        try {
            field = cls.getDeclaredField("native_instance");
            Class cls2 = Long.TYPE;
            Class cls3 = Integer.TYPE;
            method2 = cls.getDeclaredMethod("nativeCreateFromTypeface", new Class[]{cls2, cls3});
            method2.setAccessible(true);
            method = cls.getDeclaredMethod("nativeCreateWeightAlias", new Class[]{cls2, cls3});
            method.setAccessible(true);
            constructor = cls.getDeclaredConstructor(new Class[]{cls2});
            constructor.setAccessible(true);
        } catch (NoSuchFieldException | NoSuchMethodException e2) {
            Log.e("WeightTypeface", e2.getClass().getName(), e2);
            field = null;
            constructor = null;
            method2 = null;
            method = null;
        }
        f724a = field;
        b = method2;
        c = method;
        d = constructor;
    }
}
