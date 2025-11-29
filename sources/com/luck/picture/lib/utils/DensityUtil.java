package com.luck.picture.lib.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.luck.picture.lib.immersive.RomUtils;

public class DensityUtil {
    public static int a(Context context, float f) {
        return (int) ((f * context.getApplicationContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int b(Context context, String str) {
        try {
            int identifier = Resources.getSystem().getIdentifier(str, "dimen", "android");
            if (identifier > 0) {
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(identifier);
                int dimensionPixelSize2 = Resources.getSystem().getDimensionPixelSize(identifier);
                if (dimensionPixelSize2 >= dimensionPixelSize) {
                    return dimensionPixelSize2;
                }
                float f = (((float) dimensionPixelSize) * Resources.getSystem().getDisplayMetrics().density) / context.getResources().getDisplayMetrics().density;
                return (int) (f >= 0.0f ? f + 0.5f : f - 0.5f);
            }
        } catch (Resources.NotFoundException unused) {
        }
        return 0;
    }

    public static int c(Context context) {
        boolean z = true;
        if (context.getResources().getConfiguration().orientation != 1) {
            z = false;
        }
        if (!k(context)) {
            return 0;
        }
        return b(context, z ? "navigation_bar_height" : "navigation_bar_height_landscape");
    }

    public static int d(Context context) {
        Point point = new Point();
        ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getRealSize(point);
        return point.y;
    }

    public static int e(Context context) {
        Point point = new Point();
        ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getRealSize(point);
        return point.x;
    }

    public static String f(Context context, int i) {
        try {
            return context.getResources().getResourceEntryName(i);
        } catch (Exception unused) {
            return "";
        }
    }

    public static int g(Context context) {
        return d(context) - j(context);
    }

    public static int h() {
        Resources system = Resources.getSystem();
        return system.getDimensionPixelSize(system.getIdentifier("status_bar_height", "dimen", "android"));
    }

    public static int i(Context context) {
        int i;
        int i2;
        Resources system = Resources.getSystem();
        int identifier = system.getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            try {
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(identifier);
                i2 = system.getDimensionPixelSize(identifier);
                if (i2 < dimensionPixelSize) {
                    float f = (((float) dimensionPixelSize) * system.getDisplayMetrics().density) / context.getResources().getDisplayMetrics().density;
                    i2 = (int) (f >= 0.0f ? f + 0.5f : f - 0.5f);
                }
            } catch (Exception unused) {
                i = h();
            }
        } else {
            i2 = 0;
        }
        i = i2;
        return i == 0 ? a(context, 26.0f) : i;
    }

    public static int j(Context context) {
        return k(context) ? i(context) + c(context) : i(context);
    }

    public static boolean k(Context context) {
        boolean z;
        boolean z2 = false;
        if (!(context instanceof Activity)) {
            return false;
        }
        Activity activity = (Activity) context;
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        int childCount = viewGroup.getChildCount();
        int i = 0;
        while (true) {
            if (i >= childCount) {
                z = false;
                break;
            }
            View childAt = viewGroup.getChildAt(i);
            int id = childAt.getId();
            if (id != -1 && "navigationBarBackground".equals(f(activity, id)) && childAt.getVisibility() == 0) {
                z = true;
                break;
            }
            i++;
        }
        if (!z) {
            return z;
        }
        RomUtils.k();
        if ((viewGroup.getSystemUiVisibility() & 2) == 0) {
            z2 = true;
        }
        return z2;
    }
}
