package com.luck.picture.lib.language;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.luck.picture.lib.utils.SpUtils;
import java.lang.ref.WeakReference;
import java.util.Locale;

public class PictureLanguageUtils {
    public static void a(Context context, Locale locale) {
        b(context, locale, false);
    }

    public static void b(Context context, Locale locale, boolean z) {
        if (z) {
            SpUtils.d(context, "KEY_LOCALE", "VALUE_FOLLOW_SYSTEM");
        } else {
            String language = locale.getLanguage();
            String country = locale.getCountry();
            SpUtils.d(context, "KEY_LOCALE", language + "$" + country);
        }
        f(context, locale);
    }

    public static boolean c(CharSequence charSequence, CharSequence charSequence2) {
        int length;
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || (length = charSequence.length()) != charSequence2.length()) {
            return false;
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return charSequence.equals(charSequence2);
        }
        for (int i = 0; i < length; i++) {
            if (charSequence.charAt(i) != charSequence2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void d(Context context, int i, int i2) {
        WeakReference weakReference = new WeakReference(context);
        if (i >= 0) {
            a((Context) weakReference.get(), LocaleTransform.a(i));
        } else if (i2 >= 0) {
            a((Context) weakReference.get(), LocaleTransform.a(i2));
        } else {
            e((Context) weakReference.get());
        }
    }

    public static void e(Context context) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        configuration.setLocale(Locale.getDefault());
        context.createConfigurationContext(configuration);
        resources.updateConfiguration(configuration, displayMetrics);
    }

    public static void f(Context context, Locale locale) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        Locale locale2 = configuration.locale;
        if (!c(locale2.getLanguage(), locale.getLanguage()) || !c(locale2.getCountry(), locale.getCountry())) {
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            configuration.setLocale(locale);
            context.createConfigurationContext(configuration);
            resources.updateConfiguration(configuration, displayMetrics);
        }
    }
}
