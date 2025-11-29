package androidx.core.os;

import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import io.netty.util.internal.StringUtil;
import java.util.Locale;

final class LocaleListCompatWrapper implements LocaleListInterface {
    public static final Locale[] c = new Locale[0];
    public static final Locale d = new Locale("en", "XA");
    public static final Locale e = new Locale("ar", "XB");
    public static final Locale f = LocaleListCompat.b("en-Latn");

    /* renamed from: a  reason: collision with root package name */
    public final Locale[] f777a;
    public final String b;

    @RequiresApi
    public static class Api21Impl {
        @DoNotInline
        public static String a(Locale locale) {
            return locale.getScript();
        }
    }

    public String a() {
        return this.b;
    }

    public Object b() {
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocaleListCompatWrapper)) {
            return false;
        }
        Locale[] localeArr = ((LocaleListCompatWrapper) obj).f777a;
        if (this.f777a.length != localeArr.length) {
            return false;
        }
        int i = 0;
        while (true) {
            Locale[] localeArr2 = this.f777a;
            if (i >= localeArr2.length) {
                return true;
            }
            if (!localeArr2[i].equals(localeArr[i])) {
                return false;
            }
            i++;
        }
    }

    public Locale get(int i) {
        if (i >= 0) {
            Locale[] localeArr = this.f777a;
            if (i < localeArr.length) {
                return localeArr[i];
            }
        }
        return null;
    }

    public int hashCode() {
        int i = 1;
        for (Locale hashCode : this.f777a) {
            i = (i * 31) + hashCode.hashCode();
        }
        return i;
    }

    public boolean isEmpty() {
        return this.f777a.length == 0;
    }

    public int size() {
        return this.f777a.length;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int i = 0;
        while (true) {
            Locale[] localeArr = this.f777a;
            if (i < localeArr.length) {
                sb.append(localeArr[i]);
                if (i < this.f777a.length - 1) {
                    sb.append(StringUtil.COMMA);
                }
                i++;
            } else {
                sb.append("]");
                return sb.toString();
            }
        }
    }
}
