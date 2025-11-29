package com.meizu.common.util;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import java.io.IOException;

public class FontLoader {
    private static final String TAG = "FontLoader";
    private static final int WEIGHT_BLACK = 900;
    private static final int WEIGHT_BOLD = 700;
    private static final int WEIGHT_DIVIDER = 50;
    private static final int WEIGHT_EXTRA_BOLD = 800;
    public static final int WEIGHT_EXTRA_LIGHT = 200;
    public static final int WEIGHT_LIGHT = 300;
    private static final int WEIGHT_MEDIUM = 500;
    private static final int WEIGHT_REGULAR = 400;
    private static final int WEIGHT_SEMI_BOLD = 600;
    public static final int WEIGHT_THIN = 100;
    private static final SparseArray<Typeface> typefaceArray = new SparseArray<>();

    private static Typeface createTypeface(Context context, @NonNull String str, int i) {
        try {
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(new Font.Builder(context.getAssets(), str).build()).build()).setStyle(new FontStyle(i, 0)).build();
        } catch (IOException e) {
            Log.e(TAG, "has an error:" + e);
            return Typeface.createFromAsset(context.getAssets(), str);
        }
    }

    public static Typeface createTypefaceByCache(Context context, @NonNull String str, int i) {
        SparseArray<Typeface> sparseArray = typefaceArray;
        if (sparseArray.get(i) != null) {
            return sparseArray.get(i);
        }
        Typeface createTypeface = createTypeface(context, str, i);
        sparseArray.put(i, createTypeface);
        return createTypeface;
    }

    public static int fallArea(int i) {
        if (i < 150) {
            return 100;
        }
        if (i < 250) {
            return 200;
        }
        if (i < 350) {
            return 300;
        }
        if (i < 450) {
            return 400;
        }
        if (i < 550) {
            return 500;
        }
        if (i < 650) {
            return WEIGHT_SEMI_BOLD;
        }
        if (i < 750) {
            return WEIGHT_BOLD;
        }
        if (i < 850) {
            return 800;
        }
        return WEIGHT_BLACK;
    }
}
