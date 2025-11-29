package com.google.android.material.sidesheet;

import androidx.annotation.RestrictTo;

@RestrictTo
final class SheetUtils {
    private SheetUtils() {
    }

    public static boolean isSwipeMostlyHorizontal(float f, float f2) {
        return Math.abs(f) > Math.abs(f2);
    }
}
