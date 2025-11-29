package com.upuphone.ar.navi.lite.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.view.View;
import com.honey.account.n4.a;
import com.honey.account.n4.b;
import com.honey.account.n4.c;
import com.upuphone.ar.navi.lite.R;
import com.upuphone.ar.navi.lite.util.PermissionUtil;
import com.upuphone.ar.navi.lite.view.PermissionDialog;

public class LocationUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5808a = ("NAVI-" + LocationUtil.class.getSimpleName());

    public interface LocationCallback {
        void a();

        void b();
    }

    public static void e(Activity activity, int i, LocationCallback locationCallback) {
        if (j(activity)) {
            k(activity, locationCallback);
        } else {
            l(activity, i, locationCallback);
        }
    }

    public static void f(Activity activity, int i) {
        activity.startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), i);
    }

    public static /* synthetic */ void h(PermissionDialog permissionDialog, LocationCallback locationCallback, View view) {
        permissionDialog.dismiss();
        if (locationCallback != null) {
            locationCallback.a();
        }
    }

    public static /* synthetic */ void i(PermissionDialog permissionDialog, Activity activity, int i, View view) {
        permissionDialog.dismiss();
        f(activity, i);
    }

    public static boolean j(Context context) {
        return ((LocationManager) context.getSystemService("location")).isProviderEnabled("gps");
    }

    public static void k(Activity activity, LocationCallback locationCallback) {
        if (!NaviUtil.S0(activity.getApplicationContext())) {
            locationCallback.b();
        } else if (NaviUtil.s0()) {
            NaviUtil.x1(activity, (View.OnClickListener) null, new c(activity));
        } else {
            m(activity);
        }
    }

    public static void l(Activity activity, int i, LocationCallback locationCallback) {
        PermissionDialog permissionDialog = new PermissionDialog(activity);
        permissionDialog.a(true);
        permissionDialog.d(activity.getString(R.string.open_gps_title_desp));
        permissionDialog.b(activity.getString(R.string.dont_open_gps), new a(permissionDialog, locationCallback)).c(activity.getString(R.string.click_to_set), new b(permissionDialog, activity, i)).show();
    }

    public static void m(Activity activity) {
        PermissionUtil.f(activity, 100008, new PermissionUtil.IPermissionSettings() {
            public void a() {
                CLog.b(LocationUtil.f5808a, "onSettings   ");
            }

            public void b() {
                CLog.b(LocationUtil.f5808a, "onQuit   ");
            }
        });
    }
}
