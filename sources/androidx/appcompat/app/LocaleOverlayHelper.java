package androidx.appcompat.app;

import androidx.annotation.RequiresApi;
import androidx.core.os.LocaleListCompat;
import java.util.LinkedHashSet;
import java.util.Locale;

@RequiresApi
final class LocaleOverlayHelper {
    public static LocaleListCompat a(LocaleListCompat localeListCompat, LocaleListCompat localeListCompat2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int i = 0;
        while (i < localeListCompat.g() + localeListCompat2.g()) {
            Locale d = i < localeListCompat.g() ? localeListCompat.d(i) : localeListCompat2.d(i - localeListCompat.g());
            if (d != null) {
                linkedHashSet.add(d);
            }
            i++;
        }
        return LocaleListCompat.a((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]));
    }

    public static LocaleListCompat b(LocaleListCompat localeListCompat, LocaleListCompat localeListCompat2) {
        return (localeListCompat == null || localeListCompat.f()) ? LocaleListCompat.e() : a(localeListCompat, localeListCompat2);
    }
}
