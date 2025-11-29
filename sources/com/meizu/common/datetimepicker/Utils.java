package com.meizu.common.datetimepicker;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.view.View;

public class Utils {
    public static final int FULL_ALPHA = 255;
    public static final int MONDAY_BEFORE_JULIAN_EPOCH = 2440585;
    public static final int PULSE_ANIMATOR_DURATION = 544;
    public static final int SELECTED_ALPHA = 51;
    public static final int SELECTED_ALPHA_THEME_DARK = 102;
    static final String SHARED_PREFS_NAME = "com.android.calendar_preferences";

    public static int getDaysInMonth(int i, int i2) {
        switch (i) {
            case 0:
            case 2:
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
                return 31;
            case 1:
                return i2 % 4 == 0 ? 29 : 28;
            case 3:
            case 5:
            case 8:
            case 10:
                return 30;
            default:
                throw new IllegalArgumentException("Invalid Month");
        }
    }

    public static int getJulianMondayFromWeeksSinceEpoch(int i) {
        return (i * 7) + MONDAY_BEFORE_JULIAN_EPOCH;
    }

    public static ObjectAnimator getPulseAnimator(View view, float f, float f2) {
        Keyframe ofFloat = Keyframe.ofFloat(0.0f, 1.0f);
        Keyframe ofFloat2 = Keyframe.ofFloat(0.275f, f);
        Keyframe ofFloat3 = Keyframe.ofFloat(0.69f, f2);
        Keyframe ofFloat4 = Keyframe.ofFloat(1.0f, 1.0f);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofKeyframe("scaleX", new Keyframe[]{ofFloat, ofFloat2, ofFloat3, ofFloat4}), PropertyValuesHolder.ofKeyframe("scaleY", new Keyframe[]{ofFloat, ofFloat2, ofFloat3, ofFloat4})});
        ofPropertyValuesHolder.setDuration(544);
        return ofPropertyValuesHolder;
    }

    public static int getWeeksSinceEpochFromJulianDay(int i, int i2) {
        int i3 = 4 - i2;
        if (i3 < 0) {
            i3 = 11 - i2;
        }
        return (i - (2440588 - i3)) / 7;
    }

    public static boolean isJellybeanOrLater() {
        return true;
    }

    @SuppressLint({"NewApi"})
    public static void tryAccessibilityAnnounce(View view, CharSequence charSequence) {
        if (isJellybeanOrLater() && view != null && charSequence != null) {
            view.announceForAccessibility(charSequence);
        }
    }
}
