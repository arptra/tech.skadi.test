package com.baseflow.permissionhandler;

import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;
import java.util.List;

final class ServiceManager {

    @FunctionalInterface
    public interface SuccessCallback {
        void onSuccess(int i);
    }

    public void a(int i, Context context, SuccessCallback successCallback, ErrorCallback errorCallback) {
        if (context == null) {
            Log.d("permissions_handler", "Context cannot be null.");
            errorCallback.a("PermissionHandler.ServiceManager", "Android context cannot be null.");
        } else if (i == 3 || i == 4 || i == 5) {
            successCallback.onSuccess(d(context) ? 1 : 0);
        } else if (i == 21) {
            successCallback.onSuccess(c(context) ? 1 : 0);
        } else if (i == 8) {
            PackageManager packageManager = context.getPackageManager();
            if (!packageManager.hasSystemFeature("android.hardware.telephony")) {
                successCallback.onSuccess(2);
                return;
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null || telephonyManager.getPhoneType() == 0) {
                successCallback.onSuccess(2);
            } else if (b(packageManager).isEmpty()) {
                successCallback.onSuccess(2);
            } else if (telephonyManager.getSimState() != 5) {
                successCallback.onSuccess(0);
            } else {
                successCallback.onSuccess(1);
            }
        } else if (i == 16) {
            successCallback.onSuccess(1);
        } else {
            successCallback.onSuccess(2);
        }
    }

    public final List b(PackageManager packageManager) {
        Intent intent = new Intent("android.intent.action.CALL");
        intent.setData(Uri.parse("tel:123123"));
        return Build.VERSION.SDK_INT >= 33 ? packageManager.queryIntentActivities(intent, PackageManager.ResolveInfoFlags.of(0)) : packageManager.queryIntentActivities(intent, 0);
    }

    public final boolean c(Context context) {
        return ((BluetoothManager) context.getSystemService("bluetooth")).getAdapter().isEnabled();
    }

    public final boolean d(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService(LocationManager.class);
        if (locationManager == null) {
            return false;
        }
        return locationManager.isLocationEnabled();
    }
}
