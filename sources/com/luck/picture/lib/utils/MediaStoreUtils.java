package com.luck.picture.lib.utils;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.honey.account.constant.AccountConstantKt;
import com.luck.picture.lib.config.SelectorConfig;
import java.io.File;

public class MediaStoreUtils {
    public static ContentValues a(String str, String str2) {
        String g = ValueOf.g(Long.valueOf(System.currentTimeMillis()));
        ContentValues contentValues = new ContentValues(3);
        if (TextUtils.isEmpty(str)) {
            contentValues.put("_display_name", DateUtils.c("IMG_"));
        } else if (str.lastIndexOf(".") == -1) {
            contentValues.put("_display_name", DateUtils.c("IMG_"));
        } else {
            contentValues.put("_display_name", str.replaceAll(str.substring(str.lastIndexOf(".")), ""));
        }
        if (TextUtils.isEmpty(str2) || str2.startsWith("video")) {
            str2 = "image/jpeg";
        }
        contentValues.put("mime_type", str2);
        if (SdkVersionUtils.f()) {
            contentValues.put("datetaken", g);
            contentValues.put("relative_path", "DCIM/Camera");
        }
        return contentValues;
    }

    public static ContentValues b(String str, String str2) {
        String g = ValueOf.g(Long.valueOf(System.currentTimeMillis()));
        ContentValues contentValues = new ContentValues(3);
        if (TextUtils.isEmpty(str)) {
            contentValues.put("_display_name", DateUtils.c("VID_"));
        } else if (str.lastIndexOf(".") == -1) {
            contentValues.put("_display_name", DateUtils.c("VID_"));
        } else {
            contentValues.put("_display_name", str.replaceAll(str.substring(str.lastIndexOf(".")), ""));
        }
        if (TextUtils.isEmpty(str2) || str2.startsWith("image")) {
            str2 = "video/mp4";
        }
        contentValues.put("mime_type", str2);
        if (SdkVersionUtils.f()) {
            contentValues.put("datetaken", g);
            contentValues.put("relative_path", Environment.DIRECTORY_MOVIES);
        }
        return contentValues;
    }

    public static Uri c(Context context, SelectorConfig selectorConfig) {
        String str;
        String str2 = "";
        if (TextUtils.isEmpty(selectorConfig.T)) {
            str = str2;
        } else if (selectorConfig.b) {
            str = selectorConfig.T;
        } else {
            str = System.currentTimeMillis() + AccountConstantKt.DEFAULT_SEGMENT + selectorConfig.T;
        }
        if (!SdkVersionUtils.f() || !TextUtils.isEmpty(selectorConfig.W)) {
            File b = PictureFileUtils.b(context, 1, str, selectorConfig.d, selectorConfig.W);
            selectorConfig.a0 = b.getAbsolutePath();
            return PictureFileUtils.q(context, b);
        }
        Uri e = e(context, str, selectorConfig.f);
        if (e != null) {
            str2 = e.toString();
        }
        selectorConfig.a0 = str2;
        return e;
    }

    public static Uri d(Context context, SelectorConfig selectorConfig) {
        String str;
        String str2 = "";
        if (TextUtils.isEmpty(selectorConfig.U)) {
            str = str2;
        } else if (selectorConfig.b) {
            str = selectorConfig.U;
        } else {
            str = System.currentTimeMillis() + AccountConstantKt.DEFAULT_SEGMENT + selectorConfig.U;
        }
        if (!SdkVersionUtils.f() || !TextUtils.isEmpty(selectorConfig.W)) {
            File b = PictureFileUtils.b(context, 2, str, selectorConfig.e, selectorConfig.W);
            selectorConfig.a0 = b.getAbsolutePath();
            return PictureFileUtils.q(context, b);
        }
        Uri f = f(context, str, selectorConfig.g);
        if (f != null) {
            str2 = f.toString();
        }
        selectorConfig.a0 = str2;
        return f;
    }

    public static Uri e(Context context, String str, String str2) {
        Context applicationContext = context.getApplicationContext();
        Uri[] uriArr = {null};
        String externalStorageState = Environment.getExternalStorageState();
        ContentValues a2 = a(str, str2);
        if (externalStorageState.equals("mounted")) {
            uriArr[0] = applicationContext.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, a2);
        } else {
            uriArr[0] = applicationContext.getContentResolver().insert(MediaStore.Images.Media.INTERNAL_CONTENT_URI, a2);
        }
        return uriArr[0];
    }

    public static Uri f(Context context, String str, String str2) {
        Context applicationContext = context.getApplicationContext();
        Uri[] uriArr = {null};
        String externalStorageState = Environment.getExternalStorageState();
        ContentValues b = b(str, str2);
        if (externalStorageState.equals("mounted")) {
            uriArr[0] = applicationContext.getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, b);
        } else {
            uriArr[0] = applicationContext.getContentResolver().insert(MediaStore.Video.Media.INTERNAL_CONTENT_URI, b);
        }
        return uriArr[0];
    }
}
