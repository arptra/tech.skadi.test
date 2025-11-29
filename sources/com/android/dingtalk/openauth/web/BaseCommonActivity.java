package com.android.dingtalk.openauth.web;

import a.a.a.a.b.a;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.android.dingtalk.openauth.R;
import com.android.dingtalk.openauth.utils.DDAuthUtil;
import com.ucar.vehiclesdk.MDevice;
import com.upuphone.runasone.uupcast.CaptureType;
import io.flutter.plugin.platform.PlatformPlugin;

public abstract class BaseCommonActivity extends Activity {
    public static boolean b(Window window) {
        if (window != null) {
            try {
                View decorView = window.getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 8192);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private int d() {
        return R.id.ui_common_base_ui_activity_status_bar_placeholder;
    }

    private int e() {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return getResources().getDimensionPixelSize(Integer.parseInt(String.valueOf(cls.getField("status_bar_height").get(cls.newInstance()))));
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static boolean f() {
        try {
            return Build.BRAND.toLowerCase().equals(MDevice.MANUFACTURERS_MEIZU);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean g() {
        try {
            return Build.BRAND.toLowerCase().equals(MDevice.MANUFACTURERS_XIAOMI);
        } catch (Throwable unused) {
            return false;
        }
    }

    private boolean h() {
        String str = Build.MANUFACTURER;
        return !"Everest".equals(str) && !"HTC".equals(str);
    }

    public abstract int a();

    public void a(View view) {
        if (h()) {
            boolean b = b(getWindow());
            if (g()) {
                a(getWindow());
            } else if (f()) {
                a(this, false);
            }
            if (b && getWindow() != null && getWindow().getDecorView() != null) {
                getWindow().clearFlags(CaptureType.CAPTURE_TYPE_ICCOA);
                getWindow().addFlags(Integer.MIN_VALUE);
                getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() | PlatformPlugin.DEFAULT_SYSTEM_UI);
                getWindow().setStatusBarColor(0);
                if (view != null) {
                    view.setVisibility(0);
                    view.setBackgroundColor(-1);
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    layoutParams.height = b();
                    view.setLayoutParams(layoutParams);
                }
            }
        }
    }

    public int c() {
        try {
            return getResources().getDimensionPixelSize(getResources().getIdentifier("status_bar_height", "dimen", "android"));
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a());
        a(findViewById(d()));
    }

    public int b() {
        int c = c();
        if (c <= 0 && !DDAuthUtil.isTarget30FeatureEnable(this)) {
            c = e();
        }
        return c <= 0 ? DDAuthUtil.dp2px(this, 32.0f) : c;
    }

    public static boolean a(Window window) {
        if (window == null) {
            return false;
        }
        Class<?> cls = window.getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Class cls3 = Integer.TYPE;
            cls.getMethod("setExtraFlags", new Class[]{cls3, cls3}).invoke(window, new Object[]{0, Integer.valueOf(i)});
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void a(Activity activity, boolean z) {
        a.a(activity, z);
    }
}
