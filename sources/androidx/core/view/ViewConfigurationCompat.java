package androidx.core.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.InputDevice;
import android.view.ViewConfiguration;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.honey.account.q.t;
import com.honey.account.q.u;
import java.util.Objects;

public final class ViewConfigurationCompat {

    @RequiresApi
    public static class Api26Impl {
        @DoNotInline
        public static float a(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledHorizontalScrollFactor();
        }

        @DoNotInline
        public static float b(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledVerticalScrollFactor();
        }
    }

    @RequiresApi
    public static class Api28Impl {
        @DoNotInline
        public static int a(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledHoverSlop();
        }

        @DoNotInline
        public static boolean b(ViewConfiguration viewConfiguration) {
            return viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
        }
    }

    @RequiresApi
    public static class Api34Impl {
        @DoNotInline
        public static int a(@NonNull ViewConfiguration viewConfiguration, int i, int i2, int i3) {
            return viewConfiguration.getScaledMaximumFlingVelocity(i, i2, i3);
        }

        @DoNotInline
        public static int b(@NonNull ViewConfiguration viewConfiguration, int i, int i2, int i3) {
            return viewConfiguration.getScaledMinimumFlingVelocity(i, i2, i3);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
        r1 = r1.getDimensionPixelSize(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(android.content.res.Resources r1, int r2, androidx.core.util.Supplier r3, int r4) {
        /*
            r0 = -1
            if (r2 == r0) goto L_0x000e
            if (r2 == 0) goto L_0x000d
            int r1 = r1.getDimensionPixelSize(r2)
            if (r1 >= 0) goto L_0x000c
            goto L_0x000d
        L_0x000c:
            r4 = r1
        L_0x000d:
            return r4
        L_0x000e:
            java.lang.Object r1 = r3.get()
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.ViewConfigurationCompat.a(android.content.res.Resources, int, androidx.core.util.Supplier, int):int");
    }

    public static int b(Resources resources, String str, String str2) {
        return resources.getIdentifier(str, str2, "android");
    }

    public static int c(Resources resources, int i, int i2) {
        if (i == 4194304 && i2 == 26) {
            return b(resources, "config_viewMaxRotaryEncoderFlingVelocity", "dimen");
        }
        return -1;
    }

    public static int d(Resources resources, int i, int i2) {
        if (i == 4194304 && i2 == 26) {
            return b(resources, "config_viewMinRotaryEncoderFlingVelocity", "dimen");
        }
        return -1;
    }

    public static float e(ViewConfiguration viewConfiguration, Context context) {
        return Api26Impl.a(viewConfiguration);
    }

    public static int f(Context context, ViewConfiguration viewConfiguration, int i, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.a(viewConfiguration, i, i2, i3);
        }
        if (!j(i, i2, i3)) {
            return Integer.MIN_VALUE;
        }
        Resources resources = context.getResources();
        int c = c(resources, i3, i2);
        Objects.requireNonNull(viewConfiguration);
        return a(resources, c, new t(viewConfiguration), Integer.MIN_VALUE);
    }

    public static int g(Context context, ViewConfiguration viewConfiguration, int i, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.b(viewConfiguration, i, i2, i3);
        }
        if (!j(i, i2, i3)) {
            return Integer.MAX_VALUE;
        }
        Resources resources = context.getResources();
        int d = d(resources, i3, i2);
        Objects.requireNonNull(viewConfiguration);
        return a(resources, d, new u(viewConfiguration), Integer.MAX_VALUE);
    }

    public static float h(ViewConfiguration viewConfiguration, Context context) {
        return Api26Impl.b(viewConfiguration);
    }

    public static boolean i(ViewConfiguration viewConfiguration) {
        return viewConfiguration.hasPermanentMenuKey();
    }

    public static boolean j(int i, int i2, int i3) {
        InputDevice device = InputDevice.getDevice(i);
        return (device == null || device.getMotionRange(i2, i3) == null) ? false : true;
    }

    public static boolean k(ViewConfiguration viewConfiguration, Context context) {
        return Api28Impl.b(viewConfiguration);
    }
}
