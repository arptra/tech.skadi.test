package com.upuphone.starrynet.strategy.discovery.fastpair.localfastpair;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import com.here.posclient.PositionEstimate;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.strategy.StarryNetData;

public class FloatWindowManager {
    private static final String TAG = "FloatWindowManager";
    static boolean mIsShow;
    private static WindowManager.LayoutParams mLayoutParams;
    private static WindowManager mWindowManager;

    private FloatWindowManager() {
    }

    public static void dissmissFloatingWindow(View view) {
        WindowManager windowManager = mWindowManager;
        if (windowManager == null || view == null) {
            StLog.i(TAG, "setOutSideTouch: mWindowManager is " + mWindowManager + "mIsShow = " + mIsShow);
        } else {
            windowManager.removeViewImmediate(view);
            mLayoutParams = null;
        }
        mIsShow = false;
    }

    public static DisplayMetrics getDisplayMetrics() {
        if (mWindowManager == null) {
            mWindowManager = (WindowManager) StarryNetData.getInstance().getApplicationContext().getSystemService("window");
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        mWindowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static void setOutSideTouch(View view, boolean z) {
        WindowManager windowManager;
        if (!mIsShow || (windowManager = mWindowManager) == null) {
            StLog.e(TAG, "setOutSideTouch: mWindowManager is " + mWindowManager + "mIsShow = " + mIsShow);
            return;
        }
        if (z) {
            mLayoutParams.flags = PositionEstimate.Value.BUILDING_NAME;
        } else {
            mLayoutParams.flags = 32;
        }
        windowManager.updateViewLayout(view, mLayoutParams);
    }

    public static void showFloatingWindow(Context context, View view, int i) {
        if (!mIsShow) {
            mIsShow = true;
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -2, 0, 0, -2);
            mLayoutParams = layoutParams;
            layoutParams.flags = PositionEstimate.Value.BUILDING_NAME;
            WindowManager.LayoutParams layoutParams2 = mLayoutParams;
            layoutParams2.type = 2038;
            layoutParams2.gravity = i | 1;
            layoutParams2.width = -1;
            layoutParams2.height = -2;
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            mWindowManager = windowManager;
            windowManager.addView(view, mLayoutParams);
        }
    }
}
