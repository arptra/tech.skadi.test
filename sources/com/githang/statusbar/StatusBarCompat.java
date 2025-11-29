package com.githang.statusbar;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

public class StatusBarCompat {

    /* renamed from: a  reason: collision with root package name */
    public static final IStatusBar f3002a = new StatusBarMImpl();

    /* renamed from: com.githang.statusbar.StatusBarCompat$1  reason: invalid class name */
    public static class AnonymousClass1 implements IStatusBar {
        public void a(Window window, int i) {
        }
    }

    public static void a(Window window, boolean z) {
        View childAt = ((ViewGroup) window.findViewById(16908290)).getChildAt(0);
        if (childAt != null) {
            childAt.setFitsSystemWindows(z);
        }
    }

    public static void b(Activity activity, int i) {
        c(activity, i, e(i) > 225);
    }

    public static void c(Activity activity, int i, boolean z) {
        d(activity.getWindow(), i, z);
    }

    public static void d(Window window, int i, boolean z) {
        if ((window.getAttributes().flags & 1024) <= 0 && !StatusBarExclude.f3003a) {
            f3002a.a(window, i);
            LightStatusBarCompat.a(window, z);
        }
    }

    public static int e(int i) {
        int blue = Color.blue(i);
        return (((Color.red(i) * 38) + (Color.green(i) * 75)) + (blue * 15)) >> 7;
    }
}
