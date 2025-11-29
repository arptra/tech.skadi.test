package androidx.core.app;

import android.app.LocaleManager;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.core.os.LocaleListCompat;
import java.util.Locale;

public final class LocaleManagerCompat {

    @RequiresApi
    public static class Api21Impl {
        @DoNotInline
        public static String a(Locale locale) {
            return locale.toLanguageTag();
        }
    }

    @RequiresApi
    public static class Api24Impl {
        @DoNotInline
        public static LocaleListCompat a(Configuration configuration) {
            return LocaleListCompat.c(configuration.getLocales().toLanguageTags());
        }
    }

    @RequiresApi
    public static class Api33Impl {
        @DoNotInline
        public static LocaleList a(Object obj) {
            return ((LocaleManager) obj).getApplicationLocales();
        }

        @DoNotInline
        public static LocaleList b(Object obj) {
            return ((LocaleManager) obj).getSystemLocales();
        }
    }

    public static LocaleListCompat a(Context context) {
        if (Build.VERSION.SDK_INT < 33) {
            return LocaleListCompat.c(AppLocalesStorageHelper.a(context));
        }
        Object b = b(context);
        return b != null ? LocaleListCompat.j(Api33Impl.a(b)) : LocaleListCompat.e();
    }

    public static Object b(Context context) {
        return context.getSystemService("locale");
    }
}
