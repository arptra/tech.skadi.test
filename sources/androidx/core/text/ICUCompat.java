package androidx.core.text;

import android.icu.util.ULocale;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import java.util.Locale;

public final class ICUCompat {

    @RequiresApi
    public static class Api21Impl {
        @DoNotInline
        public static String a(Locale locale) {
            return locale.getScript();
        }
    }

    @RequiresApi
    public static class Api24Impl {
        @DoNotInline
        public static ULocale a(Object obj) {
            return ULocale.addLikelySubtags((ULocale) obj);
        }

        @DoNotInline
        public static ULocale b(Locale locale) {
            return ULocale.forLocale(locale);
        }

        @DoNotInline
        public static String c(Object obj) {
            return ((ULocale) obj).getScript();
        }
    }

    public static String a(Locale locale) {
        return Api24Impl.c(Api24Impl.a(Api24Impl.b(locale)));
    }
}
