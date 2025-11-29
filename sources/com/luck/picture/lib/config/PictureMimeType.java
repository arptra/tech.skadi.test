package com.luck.picture.lib.config;

import android.text.TextUtils;
import org.eclipse.jetty.util.URIUtil;

public final class PictureMimeType {
    public static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 1;
        }
        if (str.startsWith("video")) {
            return 2;
        }
        return str.startsWith("audio") ? 3 : 1;
    }

    public static String b(String str) {
        try {
            int lastIndexOf = str.lastIndexOf("/");
            return lastIndexOf != -1 ? str.substring(lastIndexOf + 1) : "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("content://");
    }

    public static boolean d(String str) {
        return str != null && str.startsWith("audio");
    }

    public static boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(p()) || str.startsWith(u()) || str.startsWith(t());
    }

    public static boolean f(String str) {
        return str != null && (str.equals("image/gif") || str.equals("image/GIF"));
    }

    public static boolean g(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(URIUtil.HTTP) || str.startsWith(URIUtil.HTTPS);
    }

    public static boolean h(String str) {
        return str != null && str.startsWith("image");
    }

    public static boolean i(String str) {
        return str != null && str.startsWith("video");
    }

    public static boolean j(String str) {
        return str != null && str.equalsIgnoreCase("image/webp");
    }

    public static boolean k(String str, String str2) {
        return TextUtils.isEmpty(str) || a(str) == a(str2);
    }

    public static boolean l(String str) {
        return str.toLowerCase().endsWith(".amr") || str.toLowerCase().endsWith(".mp3");
    }

    public static boolean m(String str) {
        return str.toLowerCase().endsWith(".gif");
    }

    public static boolean n(String str) {
        return str.toLowerCase().endsWith(".jpg") || str.toLowerCase().endsWith(".jpeg") || str.toLowerCase().endsWith(".png") || str.toLowerCase().endsWith(".heic");
    }

    public static boolean o(String str) {
        return str.toLowerCase().endsWith(".mp4");
    }

    public static String p() {
        return "image/bmp";
    }

    public static String q() {
        return "image/gif";
    }

    public static String r() {
        return "image/jpeg";
    }

    public static String s() {
        return "image/webp";
    }

    public static String t() {
        return "image/vnd.wap.wbmp";
    }

    public static String u() {
        return "image/x-ms-bmp";
    }
}
