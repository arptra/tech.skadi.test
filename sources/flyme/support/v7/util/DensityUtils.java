package flyme.support.v7.util;

import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.here.odnp.config.OdnpConfigStatic;
import com.meizu.common.util.ReflectUtils;

public class DensityUtils {

    public enum Type {
        WIDTH,
        HEIGHT
    }

    public static int dip2px(Context context, double d) {
        return (int) TypedValue.applyDimension(1, (float) d, context.getResources().getDisplayMetrics());
    }

    public static Point getScreenDip(Context context) {
        Point point = new Point();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        point.y = px2dip(context, (double) displayMetrics.heightPixels);
        point.x = px2dip(context, (double) displayMetrics.widthPixels);
        return point;
    }

    public static Point getScreenPx(Context context) {
        Point point = new Point();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        point.y = displayMetrics.heightPixels;
        point.x = displayMetrics.widthPixels;
        return point;
    }

    public static int px2dip(Context context, double d) {
        return (int) ((d / ((double) context.getResources().getDisplayMetrics().density)) + 0.5d);
    }

    public static int dip2px(float f) {
        float f2;
        try {
            ReflectUtils.IReflectMethod method = ReflectUtils.from("android.os.SystemProperties").method("getInt", String.class, Integer.TYPE);
            Integer num = (Integer) method.invoke((Object) null, "ro.sf.lcd_density", Integer.valueOf(OdnpConfigStatic.UPLOAD_LOW_PRIORITY_DURATION_MINUTES));
            num.intValue();
            f2 = ((float) ((Integer) method.invoke((Object) null, "persist.sys.density", num)).intValue()) / 160.0f;
        } catch (Exception unused) {
            f2 = 3.0f;
        }
        return (int) (f * f2);
    }
}
