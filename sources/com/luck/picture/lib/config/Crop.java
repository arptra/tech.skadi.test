package com.luck.picture.lib.config;

import android.content.Intent;
import android.net.Uri;

public class Crop {
    public static Throwable a(Intent intent) {
        return (Throwable) intent.getSerializableExtra("com.yalantis.ucrop.Error");
    }

    public static Uri b(Intent intent) {
        Uri uri = (Uri) intent.getParcelableExtra("output");
        return uri == null ? (Uri) intent.getParcelableExtra("com.yalantis.ucrop.OutputUri") : uri;
    }

    public static float c(Intent intent) {
        return intent.getFloatExtra("com.yalantis.ucrop.CropAspectRatio", 0.0f);
    }

    public static String d(Intent intent) {
        return intent.getStringExtra("customExtraData");
    }

    public static int e(Intent intent) {
        return intent.getIntExtra("com.yalantis.ucrop.ImageHeight", -1);
    }

    public static int f(Intent intent) {
        return intent.getIntExtra("com.yalantis.ucrop.OffsetX", 0);
    }

    public static int g(Intent intent) {
        return intent.getIntExtra("com.yalantis.ucrop.OffsetY", 0);
    }

    public static int h(Intent intent) {
        return intent.getIntExtra("com.yalantis.ucrop.ImageWidth", -1);
    }
}
