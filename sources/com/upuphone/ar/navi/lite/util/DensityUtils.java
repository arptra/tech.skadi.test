package com.upuphone.ar.navi.lite.util;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.meizu.common.widget.CircleProgressBar;

public final class DensityUtils {
    public static int a(Context context, float f) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public static int b(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getHeight();
    }

    public static int c(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static View d(Context context) {
        View view = new View(context.getApplicationContext());
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, c(context) + 10));
        return view;
    }

    public static void e(Context context, Window window) {
        window.requestFeature(1);
        window.clearFlags(CircleProgressBar.RIM_COLOR_DEF);
        window.getDecorView().setSystemUiVisibility(!NaviUtil.E0(context) ? 14082 : 5890);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
        window.setNavigationBarColor(0);
    }
}
