package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.ColorFilter;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.BlendModeUtils;

public class BlendModeColorFilterCompat {

    @RequiresApi
    public static class Api29Impl {
        @DoNotInline
        public static ColorFilter a(int i, Object obj) {
            return new BlendModeColorFilter(i, (BlendMode) obj);
        }
    }

    public static ColorFilter a(int i, BlendModeCompat blendModeCompat) {
        Object a2 = BlendModeUtils.Api29Impl.a(blendModeCompat);
        if (a2 != null) {
            return Api29Impl.a(i, a2);
        }
        return null;
    }
}
