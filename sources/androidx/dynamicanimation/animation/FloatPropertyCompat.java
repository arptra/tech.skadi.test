package androidx.dynamicanimation.animation;

import android.util.FloatProperty;
import androidx.annotation.RequiresApi;

public abstract class FloatPropertyCompat<T> {
    final String mPropertyName;

    public FloatPropertyCompat(String str) {
        this.mPropertyName = str;
    }

    @RequiresApi
    public static <T> FloatPropertyCompat<T> createFloatPropertyCompat(final FloatProperty<T> floatProperty) {
        return new FloatPropertyCompat<T>(floatProperty.getName()) {
            public float getValue(Object obj) {
                return ((Float) floatProperty.get(obj)).floatValue();
            }

            public void setValue(Object obj, float f) {
                floatProperty.setValue(obj, f);
            }
        };
    }

    public abstract float getValue(Object obj);

    public abstract void setValue(Object obj, float f);
}
