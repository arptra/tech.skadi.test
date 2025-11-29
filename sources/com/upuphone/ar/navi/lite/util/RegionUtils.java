package com.upuphone.ar.navi.lite.util;

import android.text.TextUtils;
import com.upuphone.ar.navi.lite.BuildConfig;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Locale;

public class RegionUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5811a = ("NAVI-" + RegionUtils.class.getSimpleName());

    public enum RegionsEA {
        UK("en", "GB", "GBR"),
        USA("en", "US", "USA");
        
        /* access modifiers changed from: private */
        public String country;
        /* access modifiers changed from: private */
        public String countryCode;
        private String language;

        private RegionsEA(String str, String str2, String str3) {
            this.language = str;
            this.country = str2;
            this.countryCode = str3;
        }

        public String getCountry() {
            return this.country;
        }

        public String getCountryCode() {
            return this.countryCode;
        }

        public String getLanguage() {
            return this.language;
        }

        public void setCountryCode(String str) {
            this.countryCode = str;
        }
    }

    public enum RegionsEu {
        AUSTRIA("de", "AT", "AUT"),
        BELGIUM("fr", "BE", "BEL"),
        BULGARIA("bg", "BG", "BGR"),
        CYPRUS("el", "CY", "CYP"),
        CROATIA("hr", "HR", "HRV"),
        CZECHIA("cs", "CZ", "CZE"),
        DENMARK("da", "DK", "DNK"),
        ESTONIA("et", "EE", "EST"),
        FINLAND("fi", "FI", "FIN"),
        FRANCE("fr", "FR", "FRA"),
        GERMANY("de", "DE", "DEU"),
        GREECE("el", "GR", "GRC"),
        HUNGARY("hu", "HU", "HUN"),
        IRELAND("en", "IE", "IRL"),
        ITALY("it", "IT", "ITA"),
        LATVIA("lv", "LV", "LVA"),
        LITHUANIA("lt", "LT", "LTU"),
        LUXEMBOURG("fr", "LU", "LUX"),
        MALTA("en", "MT", "MLT"),
        NETHERLANDS("nl", "NL", "NLD"),
        POLAND("pl", "PL", "POL"),
        PORTUGAL("pt", "PT", "PRT"),
        ROMANIA("ro", "RO", "ROU"),
        SLOVAKIA("sk", "SK", "SVK"),
        SLOVENIA("si", "SI", "SVN"),
        SPAIN("es", "ES", "ESP"),
        SWEDEN("sv", "SE", "SWE");
        
        /* access modifiers changed from: private */
        public String country;
        /* access modifiers changed from: private */
        public String countryCode;
        private String language;

        private RegionsEu(String str, String str2, String str3) {
            this.language = str;
            this.country = str2;
            this.countryCode = str3;
        }

        public String getCountry() {
            return this.country;
        }

        public String getCountryCode() {
            return this.countryCode;
        }

        public String getLanguage() {
            return this.language;
        }

        public void setCountryCode(String str) {
            this.countryCode = str;
        }
    }

    public static boolean a() {
        String country = Locale.getDefault().getCountry();
        Iterator<E> it = EnumSet.allOf(RegionsEA.class).iterator();
        while (it.hasNext()) {
            if (((RegionsEA) it.next()).country.equalsIgnoreCase(country)) {
                return true;
            }
        }
        return false;
    }

    public static boolean b() {
        String O = NaviUtil.O();
        if (TextUtils.isEmpty(O)) {
            return a();
        }
        Iterator<E> it = EnumSet.allOf(RegionsEA.class).iterator();
        while (it.hasNext()) {
            if (((RegionsEA) it.next()).countryCode.equalsIgnoreCase(O)) {
                return true;
            }
        }
        return false;
    }

    public static boolean c() {
        Locale locale = Locale.getDefault();
        String country = locale.getCountry();
        String str = f5811a;
        CLog.b(str, "isEU  getLanguage=" + locale.getLanguage() + " getCountry=" + locale.getCountry());
        Iterator<E> it = EnumSet.allOf(RegionsEu.class).iterator();
        while (it.hasNext()) {
            if (((RegionsEu) it.next()).country.equalsIgnoreCase(country)) {
                return true;
            }
        }
        return false;
    }

    public static boolean d() {
        return BuildConfig.b.booleanValue() && (e() || b());
    }

    public static boolean e() {
        String O = NaviUtil.O();
        String str = f5811a;
        CLog.b(str, "isEULocation  countryCode=" + O);
        if (TextUtils.isEmpty(O)) {
            return c();
        }
        Iterator<E> it = EnumSet.allOf(RegionsEu.class).iterator();
        while (it.hasNext()) {
            if (((RegionsEu) it.next()).countryCode.equalsIgnoreCase(O)) {
                return true;
            }
        }
        return false;
    }
}
