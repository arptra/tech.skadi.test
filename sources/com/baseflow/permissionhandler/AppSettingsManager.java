package com.baseflow.permissionhandler;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.here.posclient.PositionEstimate;
import com.upuphone.runasone.uupcast.CaptureType;

final class AppSettingsManager {

    @FunctionalInterface
    public interface OpenAppSettingsSuccessCallback {
        void a(boolean z);
    }

    public void a(Context context, OpenAppSettingsSuccessCallback openAppSettingsSuccessCallback, ErrorCallback errorCallback) {
        if (context == null) {
            Log.d("permissions_handler", "Context cannot be null.");
            errorCallback.a("PermissionHandler.AppSettingsManager", "Android context cannot be null.");
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setData(Uri.parse("package:" + context.getPackageName()));
            intent.addFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
            intent.addFlags(1073741824);
            intent.addFlags(PositionEstimate.Value.ACTIVITY);
            context.startActivity(intent);
            openAppSettingsSuccessCallback.a(true);
        } catch (Exception unused) {
            openAppSettingsSuccessCallback.a(false);
        }
    }
}
