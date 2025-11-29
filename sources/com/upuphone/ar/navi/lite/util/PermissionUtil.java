package com.upuphone.ar.navi.lite.util;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import com.honey.account.n4.g;
import com.honey.account.n4.h;
import com.upuphone.ar.navi.lite.R;
import com.upuphone.xr.sapp.context.SdkContext;
import flyme.support.v7.app.AlertDialog;
import java.util.ArrayList;
import java.util.HashMap;

public class PermissionUtil {

    public interface IPermissionSettings {
        void a();

        void b();
    }

    public static void c(Activity activity, int i) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", activity.getPackageName(), (String) null));
        activity.startActivityForResult(intent, i);
    }

    public static /* synthetic */ void d(IPermissionSettings iPermissionSettings, Activity activity, int i, DialogInterface dialogInterface, int i2) {
        iPermissionSettings.a();
        c(activity, i);
    }

    public static void f(Activity activity, int i, IPermissionSettings iPermissionSettings) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
        HashMap b = SdkContext.f6675a.f().b(activity, (String[]) arrayList.toArray(new String[0]));
        new AlertDialog.Builder(activity).setTitle((CharSequence) b.getOrDefault("rejectTitle", "")).setMessage((CharSequence) b.getOrDefault("content", "")).setCancelable(false).setPositiveButton(R.string.open_gps, (DialogInterface.OnClickListener) new g(iPermissionSettings, activity, i)).setNegativeButton(R.string.navi_cancel, (DialogInterface.OnClickListener) new h(iPermissionSettings)).show();
    }
}
