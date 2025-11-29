package com.here.posclient.upload;

import android.os.Bundle;
import com.here.posclient.upload.UploadOptions;

public class UploadUtils {
    private static final String KEY_UPLOAD_OPTIONS_BATTERY_LEVEL = "upload.options.batterylevel";
    private static final String KEY_UPLOAD_OPTIONS_CONNECTION_TYPE = "upload.options.conntype";
    private static final String KEY_UPLOAD_OPTIONS_FLAGS = "upload.options.flags";

    public static UploadOptions uploadOptionsFromBundle(Bundle bundle) {
        if (bundle == null || !bundle.containsKey(KEY_UPLOAD_OPTIONS_CONNECTION_TYPE) || !bundle.containsKey(KEY_UPLOAD_OPTIONS_BATTERY_LEVEL) || !bundle.containsKey(KEY_UPLOAD_OPTIONS_FLAGS)) {
            return null;
        }
        return new UploadOptions().setConnectionType(UploadOptions.ConnectionType.values()[bundle.getInt(KEY_UPLOAD_OPTIONS_CONNECTION_TYPE)]).setBatteryLevel(bundle.getInt(KEY_UPLOAD_OPTIONS_BATTERY_LEVEL)).setFlags(bundle.getLong(KEY_UPLOAD_OPTIONS_FLAGS));
    }

    public static void uploadOptionsToBundle(Bundle bundle, UploadOptions uploadOptions) {
        if (uploadOptions != null) {
            bundle.putInt(KEY_UPLOAD_OPTIONS_CONNECTION_TYPE, uploadOptions.connectionType.ordinal());
            bundle.putInt(KEY_UPLOAD_OPTIONS_BATTERY_LEVEL, uploadOptions.batteryLevel);
            bundle.putLong(KEY_UPLOAD_OPTIONS_FLAGS, uploadOptions.flags);
        }
    }
}
