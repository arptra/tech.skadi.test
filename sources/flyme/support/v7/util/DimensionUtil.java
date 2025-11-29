package flyme.support.v7.util;

import android.content.Context;
import android.util.TypedValue;
import androidx.annotation.NonNull;

public class DimensionUtil {
    public static float dp2Px(@NonNull Context context, float f) {
        return TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public static float px2dip(Context context, float f) {
        return f / context.getResources().getDisplayMetrics().density;
    }

    public static int px2sp(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
