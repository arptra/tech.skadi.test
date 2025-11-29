package androidx.core.app;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public final class AppOpsManagerCompat {

    @RequiresApi
    public static class Api23Impl {
        @DoNotInline
        public static <T> T a(Context context, Class<T> cls) {
            return context.getSystemService(cls);
        }

        @DoNotInline
        public static int b(AppOpsManager appOpsManager, String str, String str2) {
            return appOpsManager.noteProxyOp(str, str2);
        }

        @DoNotInline
        public static int c(AppOpsManager appOpsManager, String str, String str2) {
            return appOpsManager.noteProxyOpNoThrow(str, str2);
        }

        @DoNotInline
        public static String d(String str) {
            return AppOpsManager.permissionToOp(str);
        }
    }

    @RequiresApi
    public static class Api29Impl {
        @DoNotInline
        public static int a(@Nullable AppOpsManager appOpsManager, @NonNull String str, int i, @NonNull String str2) {
            if (appOpsManager == null) {
                return 1;
            }
            return appOpsManager.checkOpNoThrow(str, i, str2);
        }

        @DoNotInline
        @NonNull
        public static String b(@NonNull Context context) {
            return context.getOpPackageName();
        }

        @DoNotInline
        @Nullable
        public static AppOpsManager c(@NonNull Context context) {
            return (AppOpsManager) context.getSystemService(AppOpsManager.class);
        }
    }

    public static int a(Context context, int i, String str, String str2) {
        AppOpsManager c = Api29Impl.c(context);
        int a2 = Api29Impl.a(c, str, Binder.getCallingUid(), str2);
        return a2 != 0 ? a2 : Api29Impl.a(c, str, i, Api29Impl.b(context));
    }

    public static int b(Context context, String str, String str2) {
        return Api23Impl.c((AppOpsManager) Api23Impl.a(context, AppOpsManager.class), str, str2);
    }

    public static String c(String str) {
        return Api23Impl.d(str);
    }
}
