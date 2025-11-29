package io.flutter.plugin.localization;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.os.LocaleList;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.meizu.common.util.LunarCalendar;
import io.flutter.embedding.engine.systemchannels.LocalizationChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.commons.codec.language.Soundex;

public class LocalizationPlugin {
    /* access modifiers changed from: private */
    @NonNull
    public final Context context;
    @NonNull
    private final LocalizationChannel localizationChannel;
    @VisibleForTesting
    @SuppressLint({"AppBundleLocaleChanges", "DiscouragedApi"})
    final LocalizationChannel.LocalizationMessageHandler localizationMessageHandler;

    public LocalizationPlugin(@NonNull Context context2, @NonNull LocalizationChannel localizationChannel2) {
        AnonymousClass1 r0 = new LocalizationChannel.LocalizationMessageHandler() {
            public String getStringResource(@NonNull String str, @Nullable String str2) {
                Context access$000 = LocalizationPlugin.this.context;
                if (str2 != null) {
                    Locale localeFromString = LocalizationPlugin.localeFromString(str2);
                    Configuration configuration = new Configuration(LocalizationPlugin.this.context.getResources().getConfiguration());
                    configuration.setLocale(localeFromString);
                    access$000 = LocalizationPlugin.this.context.createConfigurationContext(configuration);
                }
                int identifier = access$000.getResources().getIdentifier(str, "string", LocalizationPlugin.this.context.getPackageName());
                if (identifier != 0) {
                    return access$000.getResources().getString(identifier);
                }
                return null;
            }
        };
        this.localizationMessageHandler = r0;
        this.context = context2;
        this.localizationChannel = localizationChannel2;
        localizationChannel2.setLocalizationMessageHandler(r0);
    }

    @NonNull
    public static Locale localeFromString(@NonNull String str) {
        String str2;
        String[] split = str.replace('_', Soundex.SILENT_MARKER).split(LunarCalendar.DATE_SEPARATOR, -1);
        String str3 = split[0];
        String str4 = "";
        int i = 1;
        if (split.length <= 1 || split[1].length() != 4) {
            str2 = str4;
        } else {
            str2 = split[1];
            i = 2;
        }
        if (split.length > i && split[i].length() >= 2 && split[i].length() <= 3) {
            str4 = split[i];
        }
        return new Locale(str3, str4, str2);
    }

    @Nullable
    public Locale resolveNativeLocale(@Nullable List<Locale> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        LocaleList locales = this.context.getResources().getConfiguration().getLocales();
        int size = locales.size();
        for (int i = 0; i < size; i++) {
            Locale locale = locales.get(i);
            String language = locale.getLanguage();
            if (!locale.getScript().isEmpty()) {
                language = language + LunarCalendar.DATE_SEPARATOR + locale.getScript();
            }
            if (!locale.getCountry().isEmpty()) {
                language = language + LunarCalendar.DATE_SEPARATOR + locale.getCountry();
            }
            arrayList.add(new Locale.LanguageRange(language));
            arrayList.add(new Locale.LanguageRange(locale.getLanguage()));
            arrayList.add(new Locale.LanguageRange(locale.getLanguage() + "-*"));
        }
        Locale lookup = Locale.lookup(arrayList, list);
        return lookup != null ? lookup : list.get(0);
    }

    public void sendLocalesToFlutter(@NonNull Configuration configuration) {
        ArrayList arrayList = new ArrayList();
        LocaleList locales = configuration.getLocales();
        int size = locales.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(locales.get(i));
        }
        this.localizationChannel.sendLocales(arrayList);
    }
}
