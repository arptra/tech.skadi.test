package com.meizu.common.util;

import android.content.res.Resources;

public class InternalResUtils {
    public static final int RES_TYPE_ARRAY = 8;
    public static final int RES_TYPE_ATTR = 4;
    public static final int RES_TYPE_BOOL = 7;
    public static final int RES_TYPE_COLOR = 10;
    public static final int RES_TYPE_DIMEN = 1;
    public static final int RES_TYPE_DRAWABLE = 11;
    public static final int RES_TYPE_ID = 0;
    public static final int RES_TYPE_INTEGER = 9;
    public static final int RES_TYPE_LAYOUT = 5;
    public static final int RES_TYPE_STRING = 2;
    public static final int RES_TYPE_STYLE = 6;
    public static final int RES_TYPE_STYLEABLE = 3;

    public static int getInternalResId(int i, String str) {
        Resources system;
        if (str == null || str.isEmpty() || (system = Resources.getSystem()) == null) {
            return -1;
        }
        switch (i) {
            case 0:
                return ResourceUtils.getIdentifier(system, str, "id", "android");
            case 1:
                return ResourceUtils.getIdentifier(system, str, "dimen", "android");
            case 2:
                return ResourceUtils.getIdentifier(system, str, "string", "android");
            case 3:
                return ResourceUtils.getIdentifier(system, str, "styleable", "android");
            case 4:
                return ResourceUtils.getIdentifier(system, str, "attr", "android");
            case 5:
                return ResourceUtils.getIdentifier(system, str, "layout", "android");
            case 6:
                return ResourceUtils.getIdentifier(system, str, "style", "android");
            case 7:
                return ResourceUtils.getIdentifier(system, str, "bool", "android");
            case 8:
                return ResourceUtils.getIdentifier(system, str, "array", "android");
            case 9:
                return ResourceUtils.getIdentifier(system, str, "integer", "android");
            case 10:
                return ResourceUtils.getIdentifier(system, str, "color", "android");
            case 11:
                return ResourceUtils.getIdentifier(system, str, "drawable", "android");
            default:
                return -1;
        }
    }
}
