package com.bumptech.glide.load.data.mediastore;

import android.net.Uri;
import com.xjsd.ai.assistant.protocol.VuiModelType;

public final class MediaStoreUtil {
    public static boolean a(Uri uri) {
        return c(uri) && uri.getPathSegments().contains("picker");
    }

    public static boolean b(Uri uri) {
        return c(uri) && !f(uri);
    }

    public static boolean c(Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && VuiModelType.MEDIA.equals(uri.getAuthority());
    }

    public static boolean d(Uri uri) {
        return c(uri) && f(uri);
    }

    public static boolean e(int i, int i2) {
        return i != Integer.MIN_VALUE && i2 != Integer.MIN_VALUE && i <= 512 && i2 <= 384;
    }

    public static boolean f(Uri uri) {
        return uri.getPathSegments().contains("video");
    }
}
