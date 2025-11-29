package androidx.core.text.util;

import android.icu.number.NumberFormatter;
import android.icu.text.DateFormat;
import android.icu.text.DateTimePatternGenerator;
import android.icu.util.Calendar;
import android.icu.util.MeasureUnit;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;

@RequiresApi
public final class LocalePreferences {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f834a = {"BS", "BZ", "KY", "PR", "PW", "US"};

    /* renamed from: androidx.core.text.util.LocalePreferences$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f835a;

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0021 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002e */
        static {
            /*
                android.icu.text.DateFormat$HourCycle[] r0 = android.icu.text.DateFormat.HourCycle.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f835a = r0
                android.icu.text.DateFormat$HourCycle r1 = android.icu.text.DateFormat.HourCycle.HOUR_CYCLE_11     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f835a     // Catch:{ NoSuchFieldError -> 0x0021 }
                android.icu.text.DateFormat$HourCycle r1 = android.icu.text.DateFormat.HourCycle.HOUR_CYCLE_12     // Catch:{ NoSuchFieldError -> 0x0021 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0021 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0021 }
            L_0x0021:
                int[] r0 = f835a     // Catch:{ NoSuchFieldError -> 0x002e }
                android.icu.text.DateFormat$HourCycle r1 = android.icu.text.DateFormat.HourCycle.HOUR_CYCLE_23     // Catch:{ NoSuchFieldError -> 0x002e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r0 = f835a     // Catch:{ NoSuchFieldError -> 0x003b }
                android.icu.text.DateFormat$HourCycle r1 = android.icu.text.DateFormat.HourCycle.HOUR_CYCLE_24     // Catch:{ NoSuchFieldError -> 0x003b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003b }
            L_0x003b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.text.util.LocalePreferences.AnonymousClass1.<clinit>():void");
        }
    }

    @RequiresApi
    public static class Api24Impl {
        @DoNotInline
        public static String a(@NonNull Locale locale) {
            return Calendar.getInstance(locale).getType();
        }

        @DoNotInline
        public static Locale b() {
            return Locale.getDefault(Locale.Category.FORMAT);
        }
    }

    @RequiresApi
    public static class Api33Impl {
        @DoNotInline
        public static String a(@NonNull Locale locale) {
            return b(DateTimePatternGenerator.getInstance(locale).getDefaultHourCycle());
        }

        public static String b(DateFormat.HourCycle hourCycle) {
            int i = AnonymousClass1.f835a[hourCycle.ordinal()];
            return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "" : "h24" : "h23" : "h12" : "h11";
        }

        @DoNotInline
        public static String c(@NonNull Locale locale) {
            String identifier = NumberFormatter.with().usage(VuiModelType.WEATHER).unit(MeasureUnit.CELSIUS).locale(locale).format(1).getOutputUnit().getIdentifier();
            return identifier.startsWith("fahrenhe") ? "fahrenhe" : identifier;
        }
    }

    public static class CalendarType {

        @RestrictTo
        @Retention(RetentionPolicy.SOURCE)
        public @interface CalendarTypes {
        }
    }

    public static class FirstDayOfWeek {

        @RestrictTo
        @Retention(RetentionPolicy.SOURCE)
        public @interface Days {
        }
    }

    public static class HourCycle {

        @RestrictTo
        @Retention(RetentionPolicy.SOURCE)
        public @interface HourCycleTypes {
        }
    }

    public static class TemperatureUnit {

        @RestrictTo
        @Retention(RetentionPolicy.SOURCE)
        public @interface TemperatureUnits {
        }
    }
}
