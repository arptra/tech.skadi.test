package flyme.support.v7.util;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.TypedValue;
import android.view.View;
import androidx.core.graphics.drawable.DrawableCompat;
import com.meizu.common.util.CommonUtils;
import flyme.support.v7.appcompat.R;
import java.lang.reflect.Field;

public class ResourceUtils {
    private static final int RIPPLE_RADIUS_IN_SPLIT_DP = 70;
    private static Field backgroundField = null;
    private static Class<?> cls = null;
    private static int mNightModeColor = -1;

    public static int getAppCompatActionBarHeight(Context context) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(CommonUtils.hasFullDisplay() ? R.attr.mzActionBarSizeFullScreen : androidx.appcompat.R.attr.actionBarSize, typedValue, true)) {
            return TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
        }
        return context.getResources().getDimensionPixelSize(CommonUtils.hasFullDisplay() ? com.meizu.common.R.dimen.mz_action_bar_default_height_appcompat_full_screen : com.meizu.common.R.dimen.mz_action_bar_default_height_appcompat);
    }

    public static int getNightModeColor(Context context) {
        try {
            if (mNightModeColor == -1) {
                mNightModeColor = context.getResources().getColor(Class.forName("com.flyme.internal.R$color").getField("mz_night_mode_popup_window_background").getInt((Object) null));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mNightModeColor;
    }

    public static int getStatusBarHeight(Context context) {
        return com.meizu.common.util.ResourceUtils.getStatusBarHeight(context);
    }

    public static boolean isUiModeNight(Configuration configuration) {
        return (configuration.uiMode & 48) == 32;
    }

    public static void setupBorderlessRippleRadius(View view, int i, boolean z) {
        int i2;
        int i3;
        Drawable background = view.getBackground();
        if (background != null && (background instanceof RippleDrawable)) {
            int sqrt = (int) (((double) (i / 2)) / Math.sqrt(2.0d));
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            if (z) {
                i2 = view.getPaddingLeft() - view.getPaddingRight();
                i3 = view.getPaddingTop() - view.getPaddingBottom();
            } else {
                i2 = 0;
                i3 = 0;
            }
            int i4 = (measuredWidth + i2) / 2;
            int i5 = (measuredHeight + i3) / 2;
            DrawableCompat.l(background, i4 - sqrt, i5 - sqrt, i4 + sqrt, i5 + sqrt);
        }
    }

    public static void setupRippleStyleInSplitBar(View view) {
        setupBorderlessRippleRadius(view, (int) (view.getContext().getResources().getDisplayMetrics().density * 70.0f), false);
    }
}
