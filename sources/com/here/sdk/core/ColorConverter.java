package com.here.sdk.core;

final class ColorConverter {
    public static Color convertFromInternal(ColorInternal colorInternal) {
        return Color.valueOf(colorInternal.r, colorInternal.g, colorInternal.b, colorInternal.f9158a);
    }

    public static ColorInternal convertToInternal(Color color) {
        return new ColorInternal(color.red(), color.green(), color.blue(), color.alpha());
    }
}
