package androidx.core.app;

import android.app.Notification;
import android.app.Service;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class ServiceCompat {

    @RequiresApi
    public static class Api24Impl {
        @DoNotInline
        public static void a(Service service, int i) {
            service.stopForeground(i);
        }
    }

    @RequiresApi
    public static class Api29Impl {
        @DoNotInline
        public static void a(Service service, int i, Notification notification, int i2) {
            if (i2 == 0 || i2 == -1) {
                service.startForeground(i, notification, i2);
            } else {
                service.startForeground(i, notification, i2 & 255);
            }
        }
    }

    @RequiresApi
    public static class Api34Impl {
        @DoNotInline
        public static void a(Service service, int i, Notification notification, int i2) {
            if (i2 == 0 || i2 == -1) {
                service.startForeground(i, notification, i2);
            } else {
                service.startForeground(i, notification, i2 & 1073745919);
            }
        }
    }

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface StopForegroundFlags {
    }

    public static void a(Service service, int i, Notification notification, int i2) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.a(service, i, notification, i2);
        } else {
            Api29Impl.a(service, i, notification, i2);
        }
    }
}
