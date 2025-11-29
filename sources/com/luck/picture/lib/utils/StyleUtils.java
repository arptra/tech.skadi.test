package com.luck.picture.lib.utils;

import android.content.Context;
import android.graphics.ColorFilter;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;
import java.util.regex.Pattern;

public class StyleUtils {
    public static boolean a(int[] iArr) {
        return iArr != null && iArr.length > 0;
    }

    public static boolean b(int i) {
        return i > 0;
    }

    public static boolean c(int i) {
        return i != 0;
    }

    public static boolean d(String str) {
        return Pattern.compile("\\([^)]*\\)").matcher(str).find();
    }

    public static boolean e(String str) {
        int i = 0;
        while (Pattern.compile("%[^%]*\\d").matcher(str).find()) {
            i++;
        }
        return i >= 2;
    }

    public static boolean f(String str) {
        return !TextUtils.isEmpty(str);
    }

    public static ColorFilter g(Context context, int i) {
        return BlendModeColorFilterCompat.a(ContextCompat.getColor(context, i), BlendModeCompat.SRC_ATOP);
    }
}
