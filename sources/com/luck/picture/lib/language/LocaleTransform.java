package com.luck.picture.lib.language;

import java.util.Locale;

public class LocaleTransform {
    public static Locale a(int i) {
        switch (i) {
            case 1:
                return Locale.TRADITIONAL_CHINESE;
            case 2:
                return Locale.ENGLISH;
            case 3:
                return Locale.KOREA;
            case 4:
                return Locale.GERMANY;
            case 5:
                return Locale.FRANCE;
            case 6:
                return Locale.JAPAN;
            case 7:
                return new Locale("vi");
            case 8:
                return new Locale("es", "ES");
            case 9:
                return new Locale("pt", "PT");
            case 10:
                return new Locale("ar", "AE");
            case 11:
                return new Locale("ru", "rRU");
            case 12:
                return new Locale("cs", "rCZ");
            case 13:
                return new Locale("kk", "rKZ");
            default:
                return Locale.CHINESE;
        }
    }
}
