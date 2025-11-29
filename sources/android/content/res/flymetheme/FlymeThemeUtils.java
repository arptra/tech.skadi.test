package android.content.res.flymetheme;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.RestrictTo;

@RestrictTo
public class FlymeThemeUtils {
    public static Drawable getCustomRes(Context context, String str) {
        Log.w("FlymeThemeUtils", "Framework do not has the method: #getCustomRes");
        return null;
    }

    public static boolean isUseSystemThemeIcon(Context context) {
        Log.w("FlymeThemeUtils", "Framework do not has method: #isUseSystemThemeIcon");
        return true;
    }
}
