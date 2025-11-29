package androidx.core.os;

import android.os.LocaleList;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.text.ICUCompat;
import com.honey.account.constant.AccountConstantKt;
import com.meizu.common.util.LunarCalendar;
import com.meizu.common.widget.MzContactsContract;
import java.util.Locale;

public final class LocaleListCompat {
    public static final LocaleListCompat b = a(new Locale[0]);

    /* renamed from: a  reason: collision with root package name */
    public final LocaleListInterface f775a;

    @RequiresApi
    public static class Api21Impl {

        /* renamed from: a  reason: collision with root package name */
        public static final Locale[] f776a = {new Locale("en", "XA"), new Locale("ar", "XB")};

        @DoNotInline
        public static Locale a(String str) {
            return Locale.forLanguageTag(str);
        }

        public static boolean b(Locale locale) {
            for (Locale equals : f776a) {
                if (equals.equals(locale)) {
                    return true;
                }
            }
            return false;
        }

        @DoNotInline
        public static boolean c(@NonNull Locale locale, @NonNull Locale locale2) {
            if (locale.equals(locale2)) {
                return true;
            }
            if (!locale.getLanguage().equals(locale2.getLanguage()) || b(locale) || b(locale2)) {
                return false;
            }
            String a2 = ICUCompat.a(locale);
            if (!a2.isEmpty()) {
                return a2.equals(ICUCompat.a(locale2));
            }
            String country = locale.getCountry();
            return country.isEmpty() || country.equals(locale2.getCountry());
        }
    }

    @RequiresApi
    public static class Api24Impl {
        @DoNotInline
        public static LocaleList a(Locale... localeArr) {
            return new LocaleList(localeArr);
        }

        @DoNotInline
        public static LocaleList b() {
            return LocaleList.getAdjustedDefault();
        }

        @DoNotInline
        public static LocaleList c() {
            return LocaleList.getDefault();
        }
    }

    public LocaleListCompat(LocaleListInterface localeListInterface) {
        this.f775a = localeListInterface;
    }

    public static LocaleListCompat a(Locale... localeArr) {
        return j(Api24Impl.a(localeArr));
    }

    public static Locale b(String str) {
        if (str.contains(LunarCalendar.DATE_SEPARATOR)) {
            String[] split = str.split(LunarCalendar.DATE_SEPARATOR, -1);
            if (split.length > 2) {
                return new Locale(split[0], split[1], split[2]);
            }
            if (split.length > 1) {
                return new Locale(split[0], split[1]);
            }
            if (split.length == 1) {
                return new Locale(split[0]);
            }
        } else if (!str.contains(AccountConstantKt.DEFAULT_SEGMENT)) {
            return new Locale(str);
        } else {
            String[] split2 = str.split(AccountConstantKt.DEFAULT_SEGMENT, -1);
            if (split2.length > 2) {
                return new Locale(split2[0], split2[1], split2[2]);
            }
            if (split2.length > 1) {
                return new Locale(split2[0], split2[1]);
            }
            if (split2.length == 1) {
                return new Locale(split2[0]);
            }
        }
        throw new IllegalArgumentException("Can not parse language tag: [" + str + "]");
    }

    public static LocaleListCompat c(String str) {
        if (str == null || str.isEmpty()) {
            return e();
        }
        String[] split = str.split(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA, -1);
        int length = split.length;
        Locale[] localeArr = new Locale[length];
        for (int i = 0; i < length; i++) {
            localeArr[i] = Api21Impl.a(split[i]);
        }
        return a(localeArr);
    }

    public static LocaleListCompat e() {
        return b;
    }

    public static LocaleListCompat j(LocaleList localeList) {
        return new LocaleListCompat(new LocaleListPlatformWrapper(localeList));
    }

    public Locale d(int i) {
        return this.f775a.get(i);
    }

    public boolean equals(Object obj) {
        return (obj instanceof LocaleListCompat) && this.f775a.equals(((LocaleListCompat) obj).f775a);
    }

    public boolean f() {
        return this.f775a.isEmpty();
    }

    public int g() {
        return this.f775a.size();
    }

    public String h() {
        return this.f775a.a();
    }

    public int hashCode() {
        return this.f775a.hashCode();
    }

    public Object i() {
        return this.f775a.b();
    }

    public String toString() {
        return this.f775a.toString();
    }
}
