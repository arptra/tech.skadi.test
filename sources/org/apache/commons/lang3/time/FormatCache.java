package org.apache.commons.lang3.time;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.apache.commons.lang3.LocaleUtils;
import org.apache.commons.lang3.Validate;

abstract class FormatCache<F extends Format> {
    static final int NONE = -1;
    private static final ConcurrentMap<ArrayKey, String> cDateTimeInstanceCache = new ConcurrentHashMap(7);
    private final ConcurrentMap<ArrayKey, F> cInstanceCache = new ConcurrentHashMap(7);

    public static final class ArrayKey {
        private final int hashCode;
        private final Object[] keys;

        public ArrayKey(Object... objArr) {
            this.keys = objArr;
            this.hashCode = computeHashCode(objArr);
        }

        private static int computeHashCode(Object[] objArr) {
            return 31 + Arrays.hashCode(objArr);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && ArrayKey.class == obj.getClass()) {
                return Arrays.deepEquals(this.keys, ((ArrayKey) obj).keys);
            }
            return false;
        }

        public int hashCode() {
            return this.hashCode;
        }
    }

    private F getDateTimeInstance(Integer num, Integer num2, TimeZone timeZone, Locale locale) {
        Locale locale2 = LocaleUtils.toLocale(locale);
        return getInstance(getPatternForStyle(num, num2, locale2), timeZone, locale2);
    }

    public static String getPatternForStyle(Integer num, Integer num2, Locale locale) {
        DateFormat dateFormat;
        Locale locale2 = LocaleUtils.toLocale(locale);
        ArrayKey arrayKey = new ArrayKey(num, num2, locale2);
        ConcurrentMap<ArrayKey, String> concurrentMap = cDateTimeInstanceCache;
        String str = concurrentMap.get(arrayKey);
        if (str != null) {
            return str;
        }
        if (num == null) {
            try {
                dateFormat = DateFormat.getTimeInstance(num2.intValue(), locale2);
            } catch (ClassCastException unused) {
                throw new IllegalArgumentException("No date time pattern for locale: " + locale2);
            }
        } else {
            dateFormat = num2 == null ? DateFormat.getDateInstance(num.intValue(), locale2) : DateFormat.getDateTimeInstance(num.intValue(), num2.intValue(), locale2);
        }
        String pattern = ((SimpleDateFormat) dateFormat).toPattern();
        String putIfAbsent = concurrentMap.putIfAbsent(arrayKey, pattern);
        return putIfAbsent != null ? putIfAbsent : pattern;
    }

    public abstract F createInstance(String str, TimeZone timeZone, Locale locale);

    public F getDateInstance(int i, TimeZone timeZone, Locale locale) {
        return getDateTimeInstance(Integer.valueOf(i), (Integer) null, timeZone, locale);
    }

    public F getInstance() {
        return getDateTimeInstance(3, 3, TimeZone.getDefault(), Locale.getDefault());
    }

    public F getTimeInstance(int i, TimeZone timeZone, Locale locale) {
        return getDateTimeInstance((Integer) null, Integer.valueOf(i), timeZone, locale);
    }

    public F getInstance(String str, TimeZone timeZone, Locale locale) {
        Validate.notNull(str, "pattern", new Object[0]);
        if (timeZone == null) {
            timeZone = TimeZone.getDefault();
        }
        Locale locale2 = LocaleUtils.toLocale(locale);
        ArrayKey arrayKey = new ArrayKey(str, timeZone, locale2);
        F f = (Format) this.cInstanceCache.get(arrayKey);
        if (f != null) {
            return f;
        }
        F createInstance = createInstance(str, timeZone, locale2);
        F f2 = (Format) this.cInstanceCache.putIfAbsent(arrayKey, createInstance);
        return f2 != null ? f2 : createInstance;
    }

    public F getDateTimeInstance(int i, int i2, TimeZone timeZone, Locale locale) {
        return getDateTimeInstance(Integer.valueOf(i), Integer.valueOf(i2), timeZone, locale);
    }
}
