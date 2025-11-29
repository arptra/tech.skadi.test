package com.meizu.net.pedometerprovider.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class DisplayUtil {
    private static final String TAG = "DisplayUtil";
    private static Context mContext;
    private static DisplayMetrics mDisplayMetrics;

    public static Display getDisplay() {
        return ((WindowManager) mContext.getSystemService("window")).getDefaultDisplay();
    }

    public static DisplayMetrics getDisplayDm() {
        return mDisplayMetrics;
    }

    public static void initContext(Context context) {
        mContext = context;
    }

    public static void initDisplayDm() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) mContext.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        mDisplayMetrics = displayMetrics;
        Logs.d(TAG, "initDisplayDm | dm=" + displayMetrics.toString());
    }

    public static int px2dip(float f) {
        return (int) ((f / mContext.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2sp(float f) {
        return (int) ((f / mContext.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static void showDisplayDetail() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) mContext.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        Logs.e("dm=" + displayMetrics.toString());
    }
}
