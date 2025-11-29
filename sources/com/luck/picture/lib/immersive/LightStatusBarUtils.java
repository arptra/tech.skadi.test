package com.luck.picture.lib.immersive;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import io.flutter.plugin.platform.PlatformPlugin;
import java.lang.reflect.Field;

public class LightStatusBarUtils {
    public static void a(Activity activity, boolean z, boolean z2) {
        if (z && z2) {
            activity.getWindow().getDecorView().setSystemUiVisibility(256);
        } else if (!z && !z2) {
            activity.getWindow().getDecorView().setSystemUiVisibility(PlatformPlugin.DEFAULT_SYSTEM_UI);
        } else if (!z && z2) {
            activity.getWindow().getDecorView().setSystemUiVisibility(PlatformPlugin.DEFAULT_SYSTEM_UI);
        }
    }

    public static void b(Activity activity, boolean z, boolean z2, boolean z3, boolean z4) {
        if (z3) {
            try {
                Window window = activity.getWindow();
                if (!z || !z2) {
                    if (z || z2) {
                        if (!z && z2) {
                            if (z4) {
                                window.getDecorView().setSystemUiVisibility(9472);
                            } else {
                                window.getDecorView().setSystemUiVisibility(PlatformPlugin.DEFAULT_SYSTEM_UI);
                            }
                        }
                    } else if (z4) {
                        window.getDecorView().setSystemUiVisibility(9472);
                    } else {
                        window.getDecorView().setSystemUiVisibility(PlatformPlugin.DEFAULT_SYSTEM_UI);
                    }
                } else if (z4) {
                    window.getDecorView().setSystemUiVisibility(8448);
                } else {
                    window.getDecorView().setSystemUiVisibility(256);
                }
            } catch (Exception unused) {
            }
        } else {
            View decorView = activity.getWindow().getDecorView();
            if (z4) {
                decorView.setSystemUiVisibility(8192);
            } else {
                decorView.setSystemUiVisibility(0);
            }
        }
    }

    public static boolean c(Activity activity, boolean z, boolean z2, boolean z3, boolean z4) {
        Class<WindowManager.LayoutParams> cls = WindowManager.LayoutParams.class;
        boolean z5 = false;
        if (activity == null) {
            return false;
        }
        a(activity, z, z2);
        try {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            Field declaredField = cls.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
            Field declaredField2 = cls.getDeclaredField("meizuFlags");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            int i = declaredField.getInt((Object) null);
            int i2 = declaredField2.getInt(attributes);
            declaredField2.setInt(attributes, z4 ? i | i2 : (~i) & i2);
            activity.getWindow().setAttributes(attributes);
            try {
                if (RomUtils.b() >= 7) {
                    b(activity, z, z2, z3, z4);
                }
                return true;
            } catch (Exception unused) {
                z5 = true;
                b(activity, z, z2, z3, z4);
                return z5;
            }
        } catch (Exception unused2) {
            b(activity, z, z2, z3, z4);
            return z5;
        }
    }

    public static void d(Activity activity, boolean z, boolean z2, boolean z3, boolean z4) {
        int c = RomUtils.c();
        if (c != 1) {
            if (c == 2) {
                c(activity, z, z2, z3, z4);
            } else if (c == 3) {
                b(activity, z, z2, z3, z4);
            }
        } else if (RomUtils.d() >= 7) {
            b(activity, z, z2, z3, z4);
        } else {
            e(activity, z, z2, z3, z4);
        }
    }

    public static boolean e(Activity activity, boolean z, boolean z2, boolean z3, boolean z4) {
        a(activity, z, z2);
        Class<?> cls = activity.getWindow().getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Class cls3 = Integer.TYPE;
            cls.getMethod("setExtraFlags", new Class[]{cls3, cls3}).invoke(activity.getWindow(), new Object[]{Integer.valueOf(z4 ? i : 0), Integer.valueOf(i)});
            return true;
        } catch (Exception unused) {
            b(activity, z, z2, z3, z4);
            return false;
        }
    }
}
