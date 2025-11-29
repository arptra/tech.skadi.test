package org.apache.commons.lang3.time;

import com.meizu.common.widget.MzContactsContract;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.FieldPosition;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.apache.commons.codec.language.Soundex;
import org.apache.commons.lang3.LocaleUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;

public class FastDatePrinter implements DatePrinter, Serializable {
    private static final Rule[] EMPTY_RULE_ARRAY = new Rule[0];
    public static final int FULL = 0;
    public static final int LONG = 1;
    private static final int MAX_DIGITS = 10;
    public static final int MEDIUM = 2;
    public static final int SHORT = 3;
    private static final ConcurrentMap<TimeZoneDisplayKey, String> cTimeZoneDisplayCache = new ConcurrentHashMap(7);
    private static final long serialVersionUID = 1;
    private final Locale mLocale;
    private transient int mMaxLengthEstimate;
    private final String mPattern;
    private transient Rule[] mRules;
    private final TimeZone mTimeZone;

    public static class CharacterLiteral implements Rule {
        private final char mValue;

        public CharacterLiteral(char c) {
            this.mValue = c;
        }

        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendable.append(this.mValue);
        }

        public int estimateLength() {
            return 1;
        }
    }

    public static class Iso8601_Rule implements Rule {
        static final Iso8601_Rule ISO8601_HOURS = new Iso8601_Rule(3);
        static final Iso8601_Rule ISO8601_HOURS_COLON_MINUTES = new Iso8601_Rule(6);
        static final Iso8601_Rule ISO8601_HOURS_MINUTES = new Iso8601_Rule(5);
        final int length;

        public Iso8601_Rule(int i) {
            this.length = i;
        }

        public static Iso8601_Rule getRule(int i) {
            if (i == 1) {
                return ISO8601_HOURS;
            }
            if (i == 2) {
                return ISO8601_HOURS_MINUTES;
            }
            if (i == 3) {
                return ISO8601_HOURS_COLON_MINUTES;
            }
            throw new IllegalArgumentException("invalid number of X");
        }

        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            int i = calendar.get(15) + calendar.get(16);
            if (i == 0) {
                appendable.append("Z");
                return;
            }
            if (i < 0) {
                appendable.append(Soundex.SILENT_MARKER);
                i = -i;
            } else {
                appendable.append('+');
            }
            int i2 = i / 3600000;
            FastDatePrinter.appendDigits(appendable, i2);
            int i3 = this.length;
            if (i3 >= 5) {
                if (i3 == 6) {
                    appendable.append(':');
                }
                FastDatePrinter.appendDigits(appendable, (i / 60000) - (i2 * 60));
            }
        }

        public int estimateLength() {
            return this.length;
        }
    }

    public interface NumberRule extends Rule {
        void appendTo(Appendable appendable, int i) throws IOException;
    }

    public static class PaddedNumberField implements NumberRule {
        private final int mField;
        private final int mSize;

        public PaddedNumberField(int i, int i2) {
            if (i2 >= 3) {
                this.mField = i;
                this.mSize = i2;
                return;
            }
            throw new IllegalArgumentException();
        }

        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(this.mField));
        }

        public int estimateLength() {
            return this.mSize;
        }

        public final void appendTo(Appendable appendable, int i) throws IOException {
            FastDatePrinter.appendFullDigits(appendable, i, this.mSize);
        }
    }

    public interface Rule {
        void appendTo(Appendable appendable, Calendar calendar) throws IOException;

        int estimateLength();
    }

    public static class StringLiteral implements Rule {
        private final String mValue;

        public StringLiteral(String str) {
            this.mValue = str;
        }

        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendable.append(this.mValue);
        }

        public int estimateLength() {
            return this.mValue.length();
        }
    }

    public static class TextField implements Rule {
        private final int mField;
        private final String[] mValues;

        public TextField(int i, String[] strArr) {
            this.mField = i;
            this.mValues = strArr;
        }

        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendable.append(this.mValues[calendar.get(this.mField)]);
        }

        public int estimateLength() {
            int length = this.mValues.length;
            int i = 0;
            while (true) {
                length--;
                if (length < 0) {
                    return i;
                }
                int length2 = this.mValues[length].length();
                if (length2 > i) {
                    i = length2;
                }
            }
        }
    }

    public static class TimeZoneDisplayKey {
        private final Locale mLocale;
        private final int mStyle;
        private final TimeZone mTimeZone;

        public TimeZoneDisplayKey(TimeZone timeZone, boolean z, int i, Locale locale) {
            this.mTimeZone = timeZone;
            if (z) {
                this.mStyle = Integer.MIN_VALUE | i;
            } else {
                this.mStyle = i;
            }
            this.mLocale = LocaleUtils.toLocale(locale);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TimeZoneDisplayKey)) {
                return false;
            }
            TimeZoneDisplayKey timeZoneDisplayKey = (TimeZoneDisplayKey) obj;
            return this.mTimeZone.equals(timeZoneDisplayKey.mTimeZone) && this.mStyle == timeZoneDisplayKey.mStyle && this.mLocale.equals(timeZoneDisplayKey.mLocale);
        }

        public int hashCode() {
            return (((this.mStyle * 31) + this.mLocale.hashCode()) * 31) + this.mTimeZone.hashCode();
        }
    }

    public static class TimeZoneNameRule implements Rule {
        private final String mDaylight;
        private final Locale mLocale;
        private final String mStandard;
        private final int mStyle;

        public TimeZoneNameRule(TimeZone timeZone, Locale locale, int i) {
            this.mLocale = LocaleUtils.toLocale(locale);
            this.mStyle = i;
            this.mStandard = FastDatePrinter.getTimeZoneDisplay(timeZone, false, i, locale);
            this.mDaylight = FastDatePrinter.getTimeZoneDisplay(timeZone, true, i, locale);
        }

        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            TimeZone timeZone = calendar.getTimeZone();
            if (calendar.get(16) == 0) {
                appendable.append(FastDatePrinter.getTimeZoneDisplay(timeZone, false, this.mStyle, this.mLocale));
            } else {
                appendable.append(FastDatePrinter.getTimeZoneDisplay(timeZone, true, this.mStyle, this.mLocale));
            }
        }

        public int estimateLength() {
            return Math.max(this.mStandard.length(), this.mDaylight.length());
        }
    }

    public static class TimeZoneNumberRule implements Rule {
        static final TimeZoneNumberRule INSTANCE_COLON = new TimeZoneNumberRule(true);
        static final TimeZoneNumberRule INSTANCE_NO_COLON = new TimeZoneNumberRule(false);
        final boolean mColon;

        public TimeZoneNumberRule(boolean z) {
            this.mColon = z;
        }

        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            int i = calendar.get(15) + calendar.get(16);
            if (i < 0) {
                appendable.append(Soundex.SILENT_MARKER);
                i = -i;
            } else {
                appendable.append('+');
            }
            int i2 = i / 3600000;
            FastDatePrinter.appendDigits(appendable, i2);
            if (this.mColon) {
                appendable.append(':');
            }
            FastDatePrinter.appendDigits(appendable, (i / 60000) - (i2 * 60));
        }

        public int estimateLength() {
            return 5;
        }
    }

    public static class TwoDigitMonthField implements NumberRule {
        static final TwoDigitMonthField INSTANCE = new TwoDigitMonthField();

        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(2) + 1);
        }

        public int estimateLength() {
            return 2;
        }

        public final void appendTo(Appendable appendable, int i) throws IOException {
            FastDatePrinter.appendDigits(appendable, i);
        }
    }

    public static class TwoDigitNumberField implements NumberRule {
        private final int mField;

        public TwoDigitNumberField(int i) {
            this.mField = i;
        }

        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(this.mField));
        }

        public int estimateLength() {
            return 2;
        }

        public final void appendTo(Appendable appendable, int i) throws IOException {
            if (i < 100) {
                FastDatePrinter.appendDigits(appendable, i);
            } else {
                FastDatePrinter.appendFullDigits(appendable, i, 2);
            }
        }
    }

    public static class TwoDigitYearField implements NumberRule {
        static final TwoDigitYearField INSTANCE = new TwoDigitYearField();

        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(1) % 100);
        }

        public int estimateLength() {
            return 2;
        }

        public final void appendTo(Appendable appendable, int i) throws IOException {
            FastDatePrinter.appendDigits(appendable, i % 100);
        }
    }

    public static class UnpaddedMonthField implements NumberRule {
        static final UnpaddedMonthField INSTANCE = new UnpaddedMonthField();

        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(2) + 1);
        }

        public int estimateLength() {
            return 2;
        }

        public final void appendTo(Appendable appendable, int i) throws IOException {
            if (i < 10) {
                appendable.append((char) (i + 48));
            } else {
                FastDatePrinter.appendDigits(appendable, i);
            }
        }
    }

    public static class UnpaddedNumberField implements NumberRule {
        private final int mField;

        public UnpaddedNumberField(int i) {
            this.mField = i;
        }

        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(this.mField));
        }

        public int estimateLength() {
            return 4;
        }

        public final void appendTo(Appendable appendable, int i) throws IOException {
            if (i < 10) {
                appendable.append((char) (i + 48));
            } else if (i < 100) {
                FastDatePrinter.appendDigits(appendable, i);
            } else {
                FastDatePrinter.appendFullDigits(appendable, i, 1);
            }
        }
    }

    public static class WeekYear implements NumberRule {
        private final NumberRule mRule;

        public WeekYear(NumberRule numberRule) {
            this.mRule = numberRule;
        }

        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            this.mRule.appendTo(appendable, calendar.getWeekYear());
        }

        public int estimateLength() {
            return this.mRule.estimateLength();
        }

        public void appendTo(Appendable appendable, int i) throws IOException {
            this.mRule.appendTo(appendable, i);
        }
    }

    public FastDatePrinter(String str, TimeZone timeZone, Locale locale) {
        this.mPattern = str;
        this.mTimeZone = timeZone;
        this.mLocale = LocaleUtils.toLocale(locale);
        init();
    }

    /* access modifiers changed from: private */
    public static void appendDigits(Appendable appendable, int i) throws IOException {
        appendable.append((char) ((i / 10) + 48));
        appendable.append((char) ((i % 10) + 48));
    }

    /* access modifiers changed from: private */
    public static void appendFullDigits(Appendable appendable, int i, int i2) throws IOException {
        if (i < 10000) {
            int i3 = i < 1000 ? i < 100 ? i < 10 ? 1 : 2 : 3 : 4;
            for (int i4 = i2 - i3; i4 > 0; i4--) {
                appendable.append('0');
            }
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            appendable.append((char) ((i / 1000) + 48));
                            i %= 1000;
                        } else {
                            return;
                        }
                    }
                    if (i >= 100) {
                        appendable.append((char) ((i / 100) + 48));
                        i %= 100;
                    } else {
                        appendable.append('0');
                    }
                }
                if (i >= 10) {
                    appendable.append((char) ((i / 10) + 48));
                    i %= 10;
                } else {
                    appendable.append('0');
                }
            }
            appendable.append((char) (i + 48));
            return;
        }
        char[] cArr = new char[10];
        int i5 = 0;
        while (i != 0) {
            cArr[i5] = (char) ((i % 10) + 48);
            i /= 10;
            i5++;
        }
        while (i5 < i2) {
            appendable.append('0');
            i2--;
        }
        while (true) {
            i5--;
            if (i5 >= 0) {
                appendable.append(cArr[i5]);
            } else {
                return;
            }
        }
    }

    private String applyRulesToString(Calendar calendar) {
        return ((StringBuilder) applyRules(calendar, new StringBuilder(this.mMaxLengthEstimate))).toString();
    }

    public static String getTimeZoneDisplay(TimeZone timeZone, boolean z, int i, Locale locale) {
        TimeZoneDisplayKey timeZoneDisplayKey = new TimeZoneDisplayKey(timeZone, z, i, locale);
        ConcurrentMap<TimeZoneDisplayKey, String> concurrentMap = cTimeZoneDisplayCache;
        String str = concurrentMap.get(timeZoneDisplayKey);
        if (str != null) {
            return str;
        }
        String displayName = timeZone.getDisplayName(z, i, locale);
        String putIfAbsent = concurrentMap.putIfAbsent(timeZoneDisplayKey, displayName);
        return putIfAbsent != null ? putIfAbsent : displayName;
    }

    private void init() {
        Rule[] ruleArr = (Rule[]) parsePattern().toArray(EMPTY_RULE_ARRAY);
        this.mRules = ruleArr;
        int length = ruleArr.length;
        int i = 0;
        while (true) {
            length--;
            if (length >= 0) {
                i += this.mRules[length].estimateLength();
            } else {
                this.mMaxLengthEstimate = i;
                return;
            }
        }
    }

    private Calendar newCalendar() {
        return Calendar.getInstance(this.mTimeZone, this.mLocale);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        init();
    }

    @Deprecated
    public StringBuffer applyRules(Calendar calendar, StringBuffer stringBuffer) {
        return (StringBuffer) applyRules(calendar, stringBuffer);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FastDatePrinter)) {
            return false;
        }
        FastDatePrinter fastDatePrinter = (FastDatePrinter) obj;
        return this.mPattern.equals(fastDatePrinter.mPattern) && this.mTimeZone.equals(fastDatePrinter.mTimeZone) && this.mLocale.equals(fastDatePrinter.mLocale);
    }

    @Deprecated
    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        String str;
        if (obj instanceof Date) {
            return format((Date) obj, stringBuffer);
        }
        if (obj instanceof Calendar) {
            return format((Calendar) obj, stringBuffer);
        }
        if (obj instanceof Long) {
            return format(((Long) obj).longValue(), stringBuffer);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unknown class: ");
        if (obj == null) {
            str = "<null>";
        } else {
            str = obj.getClass().getName();
        }
        sb.append(str);
        throw new IllegalArgumentException(sb.toString());
    }

    public Locale getLocale() {
        return this.mLocale;
    }

    public int getMaxLengthEstimate() {
        return this.mMaxLengthEstimate;
    }

    public String getPattern() {
        return this.mPattern;
    }

    public TimeZone getTimeZone() {
        return this.mTimeZone;
    }

    public int hashCode() {
        return this.mPattern.hashCode() + ((this.mTimeZone.hashCode() + (this.mLocale.hashCode() * 13)) * 13);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b4, code lost:
        r11 = r13;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<org.apache.commons.lang3.time.FastDatePrinter.Rule> parsePattern() {
        /*
            r16 = this;
            r0 = r16
            java.text.DateFormatSymbols r1 = new java.text.DateFormatSymbols
            java.util.Locale r2 = r0.mLocale
            r1.<init>(r2)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.lang.String[] r3 = r1.getEras()
            java.lang.String[] r4 = r1.getMonths()
            java.lang.String[] r5 = r1.getShortMonths()
            java.lang.String[] r6 = r1.getWeekdays()
            java.lang.String[] r7 = r1.getShortWeekdays()
            java.lang.String[] r1 = r1.getAmPmStrings()
            java.lang.String r8 = r0.mPattern
            int r8 = r8.length()
            r9 = 0
            r10 = r9
        L_0x002e:
            if (r10 >= r8) goto L_0x0184
            int[] r10 = new int[]{r10}
            java.lang.String r11 = r0.mPattern
            java.lang.String r11 = r0.parseToken(r11, r10)
            r10 = r10[r9]
            int r12 = r11.length()
            if (r12 != 0) goto L_0x0044
            goto L_0x0184
        L_0x0044:
            char r13 = r11.charAt(r9)
            r14 = 121(0x79, float:1.7E-43)
            r15 = 2
            r9 = 1
            if (r13 == r14) goto L_0x0082
            r14 = 122(0x7a, float:1.71E-43)
            if (r13 == r14) goto L_0x014c
            r14 = 3
            switch(r13) {
                case 39: goto L_0x012f;
                case 75: goto L_0x0127;
                case 77: goto L_0x010a;
                case 83: goto L_0x0102;
                case 97: goto L_0x00f9;
                case 100: goto L_0x00f2;
                case 104: goto L_0x00e6;
                case 107: goto L_0x00da;
                case 109: goto L_0x00d3;
                case 115: goto L_0x00cc;
                case 117: goto L_0x00c1;
                case 119: goto L_0x00bc;
                default: goto L_0x0056;
            }
        L_0x0056:
            switch(r13) {
                case 68: goto L_0x00b6;
                case 69: goto L_0x00a7;
                case 70: goto L_0x00a0;
                case 71: goto L_0x0097;
                case 72: goto L_0x0090;
                default: goto L_0x0059;
            }
        L_0x0059:
            switch(r13) {
                case 87: goto L_0x008a;
                case 88: goto L_0x0085;
                case 89: goto L_0x0082;
                case 90: goto L_0x0073;
                default: goto L_0x005c;
            }
        L_0x005c:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Illegal pattern component: "
            r1.append(r2)
            r1.append(r11)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0073:
            if (r12 != r9) goto L_0x007a
            org.apache.commons.lang3.time.FastDatePrinter$TimeZoneNumberRule r11 = org.apache.commons.lang3.time.FastDatePrinter.TimeZoneNumberRule.INSTANCE_NO_COLON
        L_0x0077:
            r14 = 0
            goto L_0x017d
        L_0x007a:
            if (r12 != r15) goto L_0x007f
            org.apache.commons.lang3.time.FastDatePrinter$Iso8601_Rule r11 = org.apache.commons.lang3.time.FastDatePrinter.Iso8601_Rule.ISO8601_HOURS_COLON_MINUTES
            goto L_0x0077
        L_0x007f:
            org.apache.commons.lang3.time.FastDatePrinter$TimeZoneNumberRule r11 = org.apache.commons.lang3.time.FastDatePrinter.TimeZoneNumberRule.INSTANCE_COLON
            goto L_0x0077
        L_0x0082:
            r14 = 0
            goto L_0x0165
        L_0x0085:
            org.apache.commons.lang3.time.FastDatePrinter$Iso8601_Rule r11 = org.apache.commons.lang3.time.FastDatePrinter.Iso8601_Rule.getRule(r12)
            goto L_0x0077
        L_0x008a:
            r11 = 4
            org.apache.commons.lang3.time.FastDatePrinter$NumberRule r11 = r0.selectNumberRule(r11, r12)
            goto L_0x0077
        L_0x0090:
            r11 = 11
            org.apache.commons.lang3.time.FastDatePrinter$NumberRule r11 = r0.selectNumberRule(r11, r12)
            goto L_0x0077
        L_0x0097:
            org.apache.commons.lang3.time.FastDatePrinter$TextField r11 = new org.apache.commons.lang3.time.FastDatePrinter$TextField
            r12 = 0
            r11.<init>(r12, r3)
            r14 = r12
            goto L_0x017d
        L_0x00a0:
            r11 = 8
            org.apache.commons.lang3.time.FastDatePrinter$NumberRule r11 = r0.selectNumberRule(r11, r12)
            goto L_0x0077
        L_0x00a7:
            r11 = 4
            org.apache.commons.lang3.time.FastDatePrinter$TextField r13 = new org.apache.commons.lang3.time.FastDatePrinter$TextField
            if (r12 >= r11) goto L_0x00af
            r12 = r7
        L_0x00ad:
            r11 = 7
            goto L_0x00b1
        L_0x00af:
            r12 = r6
            goto L_0x00ad
        L_0x00b1:
            r13.<init>(r11, r12)
        L_0x00b4:
            r11 = r13
            goto L_0x0077
        L_0x00b6:
            r11 = 6
            org.apache.commons.lang3.time.FastDatePrinter$NumberRule r11 = r0.selectNumberRule(r11, r12)
            goto L_0x0077
        L_0x00bc:
            org.apache.commons.lang3.time.FastDatePrinter$NumberRule r11 = r0.selectNumberRule(r14, r12)
            goto L_0x0077
        L_0x00c1:
            r11 = 7
            org.apache.commons.lang3.time.FastDatePrinter$DayInWeekField r13 = new org.apache.commons.lang3.time.FastDatePrinter$DayInWeekField
            org.apache.commons.lang3.time.FastDatePrinter$NumberRule r11 = r0.selectNumberRule(r11, r12)
            r13.<init>(r11)
            goto L_0x00b4
        L_0x00cc:
            r11 = 13
            org.apache.commons.lang3.time.FastDatePrinter$NumberRule r11 = r0.selectNumberRule(r11, r12)
            goto L_0x0077
        L_0x00d3:
            r11 = 12
            org.apache.commons.lang3.time.FastDatePrinter$NumberRule r11 = r0.selectNumberRule(r11, r12)
            goto L_0x0077
        L_0x00da:
            org.apache.commons.lang3.time.FastDatePrinter$TwentyFourHourField r11 = new org.apache.commons.lang3.time.FastDatePrinter$TwentyFourHourField
            r13 = 11
            org.apache.commons.lang3.time.FastDatePrinter$NumberRule r12 = r0.selectNumberRule(r13, r12)
            r11.<init>(r12)
            goto L_0x0077
        L_0x00e6:
            org.apache.commons.lang3.time.FastDatePrinter$TwelveHourField r11 = new org.apache.commons.lang3.time.FastDatePrinter$TwelveHourField
            r13 = 10
            org.apache.commons.lang3.time.FastDatePrinter$NumberRule r12 = r0.selectNumberRule(r13, r12)
            r11.<init>(r12)
            goto L_0x0077
        L_0x00f2:
            r11 = 5
            org.apache.commons.lang3.time.FastDatePrinter$NumberRule r11 = r0.selectNumberRule(r11, r12)
            goto L_0x0077
        L_0x00f9:
            org.apache.commons.lang3.time.FastDatePrinter$TextField r11 = new org.apache.commons.lang3.time.FastDatePrinter$TextField
            r12 = 9
            r11.<init>(r12, r1)
            goto L_0x0077
        L_0x0102:
            r11 = 14
            org.apache.commons.lang3.time.FastDatePrinter$NumberRule r11 = r0.selectNumberRule(r11, r12)
            goto L_0x0077
        L_0x010a:
            r11 = 4
            if (r12 < r11) goto L_0x0114
            org.apache.commons.lang3.time.FastDatePrinter$TextField r11 = new org.apache.commons.lang3.time.FastDatePrinter$TextField
            r11.<init>(r15, r4)
            goto L_0x0077
        L_0x0114:
            if (r12 != r14) goto L_0x011d
            org.apache.commons.lang3.time.FastDatePrinter$TextField r11 = new org.apache.commons.lang3.time.FastDatePrinter$TextField
            r11.<init>(r15, r5)
            goto L_0x0077
        L_0x011d:
            if (r12 != r15) goto L_0x0123
            org.apache.commons.lang3.time.FastDatePrinter$TwoDigitMonthField r11 = org.apache.commons.lang3.time.FastDatePrinter.TwoDigitMonthField.INSTANCE
            goto L_0x0077
        L_0x0123:
            org.apache.commons.lang3.time.FastDatePrinter$UnpaddedMonthField r11 = org.apache.commons.lang3.time.FastDatePrinter.UnpaddedMonthField.INSTANCE
            goto L_0x0077
        L_0x0127:
            r11 = 10
            org.apache.commons.lang3.time.FastDatePrinter$NumberRule r11 = r0.selectNumberRule(r11, r12)
            goto L_0x0077
        L_0x012f:
            java.lang.String r11 = r11.substring(r9)
            int r12 = r11.length()
            if (r12 != r9) goto L_0x0146
            org.apache.commons.lang3.time.FastDatePrinter$CharacterLiteral r12 = new org.apache.commons.lang3.time.FastDatePrinter$CharacterLiteral
            r13 = 0
            char r11 = r11.charAt(r13)
            r12.<init>(r11)
        L_0x0143:
            r11 = r12
            goto L_0x0077
        L_0x0146:
            org.apache.commons.lang3.time.FastDatePrinter$StringLiteral r12 = new org.apache.commons.lang3.time.FastDatePrinter$StringLiteral
            r12.<init>(r11)
            goto L_0x0143
        L_0x014c:
            r11 = 4
            if (r12 < r11) goto L_0x015a
            org.apache.commons.lang3.time.FastDatePrinter$TimeZoneNameRule r11 = new org.apache.commons.lang3.time.FastDatePrinter$TimeZoneNameRule
            java.util.TimeZone r12 = r0.mTimeZone
            java.util.Locale r13 = r0.mLocale
            r11.<init>(r12, r13, r9)
            goto L_0x0077
        L_0x015a:
            org.apache.commons.lang3.time.FastDatePrinter$TimeZoneNameRule r11 = new org.apache.commons.lang3.time.FastDatePrinter$TimeZoneNameRule
            java.util.TimeZone r12 = r0.mTimeZone
            java.util.Locale r13 = r0.mLocale
            r14 = 0
            r11.<init>(r12, r13, r14)
            goto L_0x017d
        L_0x0165:
            if (r12 != r15) goto L_0x016a
            org.apache.commons.lang3.time.FastDatePrinter$TwoDigitYearField r11 = org.apache.commons.lang3.time.FastDatePrinter.TwoDigitYearField.INSTANCE
            goto L_0x0173
        L_0x016a:
            r11 = 4
            int r11 = java.lang.Math.max(r12, r11)
            org.apache.commons.lang3.time.FastDatePrinter$NumberRule r11 = r0.selectNumberRule(r9, r11)
        L_0x0173:
            r12 = 89
            if (r13 != r12) goto L_0x017d
            org.apache.commons.lang3.time.FastDatePrinter$WeekYear r12 = new org.apache.commons.lang3.time.FastDatePrinter$WeekYear
            r12.<init>(r11)
            r11 = r12
        L_0x017d:
            r2.add(r11)
            int r10 = r10 + r9
            r9 = r14
            goto L_0x002e
        L_0x0184:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.time.FastDatePrinter.parsePattern():java.util.List");
    }

    public String parseToken(String str, int[] iArr) {
        StringBuilder sb = new StringBuilder();
        int i = iArr[0];
        int length = str.length();
        char charAt = str.charAt(i);
        if ((charAt >= 'A' && charAt <= 'Z') || (charAt >= 'a' && charAt <= 'z')) {
            sb.append(charAt);
            while (true) {
                int i2 = i + 1;
                if (i2 >= length || str.charAt(i2) != charAt) {
                    break;
                }
                sb.append(charAt);
                i = i2;
            }
        } else {
            sb.append('\'');
            boolean z = false;
            while (true) {
                if (i >= length) {
                    break;
                }
                char charAt2 = str.charAt(i);
                if (charAt2 == '\'') {
                    int i3 = i + 1;
                    if (i3 >= length || str.charAt(i3) != '\'') {
                        z = !z;
                    } else {
                        sb.append(charAt2);
                        i = i3;
                    }
                } else if (z || ((charAt2 < 'A' || charAt2 > 'Z') && (charAt2 < 'a' || charAt2 > 'z'))) {
                    sb.append(charAt2);
                }
                i++;
            }
            i--;
        }
        iArr[0] = i;
        return sb.toString();
    }

    public NumberRule selectNumberRule(int i, int i2) {
        return i2 != 1 ? i2 != 2 ? new PaddedNumberField(i, i2) : new TwoDigitNumberField(i) : new UnpaddedNumberField(i);
    }

    public String toString() {
        return "FastDatePrinter[" + this.mPattern + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA + this.mLocale + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA + this.mTimeZone.getID() + "]";
    }

    public static class DayInWeekField implements NumberRule {
        private final NumberRule mRule;

        public DayInWeekField(NumberRule numberRule) {
            this.mRule = numberRule;
        }

        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            int i = 7;
            int i2 = calendar.get(7);
            NumberRule numberRule = this.mRule;
            if (i2 != 1) {
                i = i2 - 1;
            }
            numberRule.appendTo(appendable, i);
        }

        public int estimateLength() {
            return this.mRule.estimateLength();
        }

        public void appendTo(Appendable appendable, int i) throws IOException {
            this.mRule.appendTo(appendable, i);
        }
    }

    private <B extends Appendable> B applyRules(Calendar calendar, B b) {
        try {
            for (Rule appendTo : this.mRules) {
                appendTo.appendTo(b, calendar);
            }
        } catch (IOException e) {
            ExceptionUtils.rethrow(e);
        }
        return b;
    }

    public static class TwelveHourField implements NumberRule {
        private final NumberRule mRule;

        public TwelveHourField(NumberRule numberRule) {
            this.mRule = numberRule;
        }

        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            int i = calendar.get(10);
            if (i == 0) {
                i = calendar.getLeastMaximum(10) + 1;
            }
            this.mRule.appendTo(appendable, i);
        }

        public int estimateLength() {
            return this.mRule.estimateLength();
        }

        public void appendTo(Appendable appendable, int i) throws IOException {
            this.mRule.appendTo(appendable, i);
        }
    }

    public static class TwentyFourHourField implements NumberRule {
        private final NumberRule mRule;

        public TwentyFourHourField(NumberRule numberRule) {
            this.mRule = numberRule;
        }

        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            int i = calendar.get(11);
            if (i == 0) {
                i = calendar.getMaximum(11) + 1;
            }
            this.mRule.appendTo(appendable, i);
        }

        public int estimateLength() {
            return this.mRule.estimateLength();
        }

        public void appendTo(Appendable appendable, int i) throws IOException {
            this.mRule.appendTo(appendable, i);
        }
    }

    public String format(Object obj) {
        String str;
        if (obj instanceof Date) {
            return format((Date) obj);
        }
        if (obj instanceof Calendar) {
            return format((Calendar) obj);
        }
        if (obj instanceof Long) {
            return format(((Long) obj).longValue());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unknown class: ");
        if (obj == null) {
            str = "<null>";
        } else {
            str = obj.getClass().getName();
        }
        sb.append(str);
        throw new IllegalArgumentException(sb.toString());
    }

    public String format(long j) {
        Calendar newCalendar = newCalendar();
        newCalendar.setTimeInMillis(j);
        return applyRulesToString(newCalendar);
    }

    public String format(Date date) {
        Calendar newCalendar = newCalendar();
        newCalendar.setTime(date);
        return applyRulesToString(newCalendar);
    }

    public String format(Calendar calendar) {
        return ((StringBuilder) format(calendar, new StringBuilder(this.mMaxLengthEstimate))).toString();
    }

    public StringBuffer format(long j, StringBuffer stringBuffer) {
        Calendar newCalendar = newCalendar();
        newCalendar.setTimeInMillis(j);
        return (StringBuffer) applyRules(newCalendar, stringBuffer);
    }

    public StringBuffer format(Date date, StringBuffer stringBuffer) {
        Calendar newCalendar = newCalendar();
        newCalendar.setTime(date);
        return (StringBuffer) applyRules(newCalendar, stringBuffer);
    }

    public StringBuffer format(Calendar calendar, StringBuffer stringBuffer) {
        return format(calendar.getTime(), stringBuffer);
    }

    public <B extends Appendable> B format(long j, B b) {
        Calendar newCalendar = newCalendar();
        newCalendar.setTimeInMillis(j);
        return applyRules(newCalendar, b);
    }

    public <B extends Appendable> B format(Date date, B b) {
        Calendar newCalendar = newCalendar();
        newCalendar.setTime(date);
        return applyRules(newCalendar, b);
    }

    public <B extends Appendable> B format(Calendar calendar, B b) {
        if (!calendar.getTimeZone().equals(this.mTimeZone)) {
            calendar = (Calendar) calendar.clone();
            calendar.setTimeZone(this.mTimeZone);
        }
        return applyRules(calendar, b);
    }
}
