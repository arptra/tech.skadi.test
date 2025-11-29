package com.meizu.common.util;

import android.content.Context;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.content.PermissionChecker;

public class VibrateUtil {
    private static final String CLASS_NAME_FLYME_FEATURE = "flyme.config.FlymeFeature";
    private static final int FEEDBACK_CONSTANT = 31020;
    private static final String FIELD_SUPPORT_MOTOR = "SHELL_HAPTICFEEDBACK_MOTOR";
    private static final String FIELD_USE_QCOM_VIBRATE = "USE_QCOM_VIBRATE";
    private static final int VIBRATE_DURATION = 50;

    public static void click(@NonNull Context context) {
        vibrate(context, 0);
    }

    public static void doubleClick(@NonNull Context context) {
        vibrate(context, 1);
    }

    public static boolean hasFlymeFeature() {
        try {
            Class<?> cls = Class.forName(CLASS_NAME_FLYME_FEATURE);
            boolean z = cls.getDeclaredField(FIELD_SUPPORT_MOTOR).getBoolean((Object) null);
            return !z ? cls.getDeclaredField(FIELD_USE_QCOM_VIBRATE).getBoolean((Object) null) : z;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
            return false;
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            return false;
        }
    }

    private static boolean hasVibratePermission(Context context) {
        return PermissionChecker.a(context, "android.permission.VIBRATE") == 0;
    }

    public static void heavyClick(@NonNull Context context) {
        vibrate(context, 5);
    }

    public static void performHapticFeedback(@NonNull View view, boolean z) {
        if (z) {
            view.performHapticFeedback(FEEDBACK_CONSTANT);
        } else {
            view.performHapticFeedback(0);
        }
    }

    public static void tick(@NonNull Context context) {
        vibrate(context, 2);
    }

    public static void vibrate(@NonNull Context context, int i) {
        Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
        if (hasVibratePermission(context)) {
            vibrator.vibrate(VibrationEffect.createOneShot(50, i));
        }
    }
}
