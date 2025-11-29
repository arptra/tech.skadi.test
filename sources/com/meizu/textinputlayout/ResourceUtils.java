package com.meizu.textinputlayout;

import android.content.Context;
import android.content.res.TypedArray;

public class ResourceUtils {
    public static int getMzThemeColor(Context context) {
        int identifier = context.getResources().getIdentifier("mzThemeColor", "attr", context.getPackageName());
        if (identifier <= 0) {
            return 0;
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{identifier});
        int color = obtainStyledAttributes.getColor(0, -1);
        obtainStyledAttributes.recycle();
        if (color == -1) {
            return 0;
        }
        return color;
    }
}
