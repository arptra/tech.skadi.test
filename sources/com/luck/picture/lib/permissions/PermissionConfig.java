package com.luck.picture.lib.permissions;

import android.content.Context;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.utils.SdkVersionUtils;

public class PermissionConfig {

    /* renamed from: a  reason: collision with root package name */
    public static String[] f9440a = new String[0];
    public static final String[] b = {"android.permission.CAMERA"};

    public static String[] a(Context context, int i) {
        if (!SdkVersionUtils.h()) {
            return new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
        }
        int i2 = context.getApplicationInfo().targetSdkVersion;
        if (i == SelectMimeType.c()) {
            if (i2 >= 33) {
                return new String[]{"android.permission.READ_MEDIA_IMAGES"};
            }
            return new String[]{"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_EXTERNAL_STORAGE"};
        } else if (i == SelectMimeType.d()) {
            if (i2 >= 33) {
                return new String[]{"android.permission.READ_MEDIA_VIDEO"};
            }
            return new String[]{"android.permission.READ_MEDIA_VIDEO", "android.permission.READ_EXTERNAL_STORAGE"};
        } else if (i == SelectMimeType.b()) {
            if (i2 >= 33) {
                return new String[]{"android.permission.READ_MEDIA_AUDIO"};
            }
            return new String[]{"android.permission.READ_MEDIA_AUDIO", "android.permission.READ_EXTERNAL_STORAGE"};
        } else if (i2 >= 33) {
            return new String[]{"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VIDEO"};
        } else {
            return new String[]{"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VIDEO", "android.permission.READ_EXTERNAL_STORAGE"};
        }
    }
}
