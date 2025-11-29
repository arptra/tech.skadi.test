package com.yalantis.ucrop.statusbar;

import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import com.meizu.common.widget.CircleProgressBar;

public class ImmersiveManager {
    public static void a(AppCompatActivity appCompatActivity, int i, int i2, boolean z) {
        b(appCompatActivity, false, false, i, i2, z);
    }

    public static void b(AppCompatActivity appCompatActivity, boolean z, boolean z2, int i, int i2, boolean z3) {
        try {
            Window window = appCompatActivity.getWindow();
            boolean z4 = false;
            boolean z5 = true;
            if (z && z2) {
                window.clearFlags(CircleProgressBar.RIM_COLOR_DEF);
                if (i == 0) {
                    z4 = true;
                }
                LightStatusBarUtils.d(appCompatActivity, true, true, z4, z3);
                window.addFlags(Integer.MIN_VALUE);
            } else if (!z && !z2) {
                window.requestFeature(1);
                window.clearFlags(CircleProgressBar.RIM_COLOR_DEF);
                if (i != 0) {
                    z5 = false;
                }
                LightStatusBarUtils.d(appCompatActivity, false, false, z5, z3);
                window.addFlags(Integer.MIN_VALUE);
            } else if (!z) {
                window.requestFeature(1);
                window.clearFlags(CircleProgressBar.RIM_COLOR_DEF);
                LightStatusBarUtils.d(appCompatActivity, false, true, i == 0, z3);
                window.addFlags(Integer.MIN_VALUE);
            } else {
                return;
            }
            window.setStatusBarColor(i);
            window.setNavigationBarColor(i2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
