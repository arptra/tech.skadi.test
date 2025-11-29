package com.sina.weibo.sdk;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.File;

public final class l {
    public static long a(String str) {
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return 0;
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        return Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
    }

    public static boolean b(Context context, Uri uri) {
        String str;
        try {
            if ("content".equals(uri.getScheme())) {
                str = context.getContentResolver().getType(uri);
            } else {
                str = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(uri.toString()).toLowerCase());
            }
            if (!TextUtils.isEmpty(str) && str.startsWith("image/") && (str.contains("jpg") || str.contains("gif") || str.contains("png") || str.contains("jpeg"))) {
                return true;
            }
            String str2 = n.b;
            n.b(str2, "unexpected mimeType(" + str + ") for image " + uri);
            return false;
        } catch (Exception e) {
            n.a(n.b, "process mimeType fail ", e);
            return false;
        }
    }

    public static boolean c(Context context, Uri uri) {
        try {
            String type = "content".equals(uri.getScheme()) ? context.getContentResolver().getType(uri) : MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(uri.toString()).toLowerCase());
            if (!TextUtils.isEmpty(type) ? type.startsWith("video/") : false) {
                return true;
            }
            String str = n.b;
            n.b(str, "unexpected mimeType(" + type + ") for video " + uri);
            return false;
        } catch (Exception e) {
            n.a(n.b, "process mimeType fail ", e);
            return false;
        }
    }

    public static String a(Context context, Uri uri) {
        String uri2 = uri.toString();
        return new File(context.getExternalFilesDir((String) null), uri2.substring(uri2.lastIndexOf("/"))).getAbsolutePath();
    }
}
