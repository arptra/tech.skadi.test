package com.luck.picture.lib.immersive;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import com.meizu.common.widget.CircleProgressBar;
import com.upuphone.runasone.uupcast.CaptureType;
import io.flutter.plugin.platform.PlatformPlugin;

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

    public static void c(Activity activity, boolean z) {
        Window window = activity.getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.clearFlags(CaptureType.CAPTURE_TYPE_ICCOA);
        window.setStatusBarColor(0);
        View decorView = window.getDecorView();
        if (z) {
            decorView.setSystemUiVisibility(9472);
        } else {
            window.getDecorView().setSystemUiVisibility(PlatformPlugin.DEFAULT_SYSTEM_UI);
        }
        View childAt = ((ViewGroup) window.findViewById(16908290)).getChildAt(0);
        if (childAt != null) {
            childAt.setFitsSystemWindows(false);
            ViewCompat.q0(childAt);
        }
    }
}
