package com.google.gson.internal.bind.util;

import com.honey.account.constant.AccountConstantKt;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.commons.codec.language.Soundex;
import org.apache.commons.lang3.time.TimeZones;

public class ISO8601Utils {
    private static final TimeZone TIMEZONE_UTC = TimeZone.getTimeZone(UTC_ID);
    private static final String UTC_ID = "UTC";

    private static boolean checkOffset(String str, int i, char c) {
        return i < str.length() && str.charAt(i) == c;
    }

    public static String format(Date date) {
        return format(date, false, TIMEZONE_UTC);
    }

    private static int indexOfNonDigit(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt < '0' || charAt > '9') {
                return i;
            }
            i++;
        }
        return str.length();
    }

    private static void padInt(StringBuilder sb, int i, int i2) {
        String num = Integer.toString(i);
        for (int length = i2 - num.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(num);
    }

    public static Date parse(String str, ParsePosition parsePosition) throws ParseException {
        String str2;
        int i;
        int i2;
        int i3;
        int i4;
        TimeZone timeZone;
        int i5;
        char charAt;
        String str3 = str;
        ParsePosition parsePosition2 = parsePosition;
        try {
            int index = parsePosition.getIndex();
            int i6 = index + 4;
            int parseInt = parseInt(str3, index, i6);
            if (checkOffset(str3, i6, Soundex.SILENT_MARKER)) {
                i6 = index + 5;
            }
            int i7 = i6 + 2;
            int parseInt2 = parseInt(str3, i6, i7);
            if (checkOffset(str3, i7, Soundex.SILENT_MARKER)) {
                i7 = i6 + 3;
            }
            int i8 = i7 + 2;
            int parseInt3 = parseInt(str3, i7, i8);
            boolean checkOffset = checkOffset(str3, i8, 'T');
            if (checkOffset || str.length() > i8) {
                if (checkOffset) {
                    int i9 = i7 + 5;
                    int parseInt4 = parseInt(str3, i7 + 3, i9);
                    if (checkOffset(str3, i9, ':')) {
                        i9 = i7 + 6;
                    }
                    int i10 = i9 + 2;
                    int parseInt5 = parseInt(str3, i9, i10);
                    if (checkOffset(str3, i10, ':')) {
                        i10 = i9 + 3;
                    }
                    if (str.length() <= i10 || (charAt = str3.charAt(i10)) == 'Z' || charAt == '+' || charAt == '-') {
                        i3 = parseInt5;
                        i2 = 0;
                        i = 0;
                        int i11 = parseInt4;
                        i8 = i10;
                        i4 = i11;
                    } else {
                        int i12 = i10 + 2;
                        i = parseInt(str3, i10, i12);
                        if (i > 59 && i < 63) {
                            i = 59;
                        }
                        if (checkOffset(str3, i12, '.')) {
                            int i13 = i10 + 3;
                            int indexOfNonDigit = indexOfNonDigit(str3, i10 + 4);
                            int min = Math.min(indexOfNonDigit, i10 + 6);
                            int parseInt6 = parseInt(str3, i13, min);
                            int i14 = min - i13;
                            if (i14 == 1) {
                                parseInt6 *= 100;
                            } else if (i14 == 2) {
                                parseInt6 *= 10;
                            }
                            i4 = parseInt4;
                            i8 = indexOfNonDigit;
                            i3 = parseInt5;
                            i2 = parseInt6;
                        } else {
                            i4 = parseInt4;
                            i8 = i12;
                            i3 = parseInt5;
                            i2 = 0;
                        }
                    }
                } else {
                    i4 = 0;
                    i3 = 0;
                    i2 = 0;
                    i = 0;
                }
                if (str.length() > i8) {
                    char charAt2 = str3.charAt(i8);
                    if (charAt2 == 'Z') {
                        timeZone = TIMEZONE_UTC;
                        i5 = i8 + 1;
                    } else {
                        if (charAt2 != '+') {
                            if (charAt2 != '-') {
                                throw new IndexOutOfBoundsException("Invalid time zone indicator '" + charAt2 + "'");
                            }
                        }
                        String substring = str3.substring(i8);
                        if (substring.length() < 5) {
                            substring = substring + "00";
                        }
                        i5 = i8 + substring.length();
                        if (!"+0000".equals(substring)) {
                            if (!"+00:00".equals(substring)) {
                                String str4 = TimeZones.GMT_ID + substring;
                                TimeZone timeZone2 = TimeZone.getTimeZone(str4);
                                String id = timeZone2.getID();
                                if (!id.equals(str4)) {
                                    if (!id.replace(AccountConstantKt.CODE_SEPARTOR, "").equals(str4)) {
                                        throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + str4 + " given, resolves to " + timeZone2.getID());
                                    }
                                }
                                timeZone = timeZone2;
                            }
                        }
                        timeZone = TIMEZONE_UTC;
                    }
                    GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone);
                    gregorianCalendar.setLenient(false);
                    gregorianCalendar.set(1, parseInt);
                    gregorianCalendar.set(2, parseInt2 - 1);
                    gregorianCalendar.set(5, parseInt3);
                    gregorianCalendar.set(11, i4);
                    gregorianCalendar.set(12, i3);
                    gregorianCalendar.set(13, i);
                    gregorianCalendar.set(14, i2);
                    parsePosition2.setIndex(i5);
                    return gregorianCalendar.getTime();
                }
                throw new IllegalArgumentException("No time zone indicator");
            }
            GregorianCalendar gregorianCalendar2 = new GregorianCalendar(parseInt, parseInt2 - 1, parseInt3);
            gregorianCalendar2.setLenient(false);
            parsePosition2.setIndex(i8);
            return gregorianCalendar2.getTime();
        } catch (IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException e) {
            if (str3 == null) {
                str2 = null;
            } else {
                str2 = '\"' + str3 + '\"';
            }
            String message = e.getMessage();
            if (message == null || message.isEmpty()) {
                message = "(" + e.getClass().getName() + ")";
            }
            ParseException parseException = new ParseException("Failed to parse date [" + str2 + "]: " + message, parsePosition.getIndex());
            parseException.initCause(e);
            throw parseException;
        }
    }

    private static int parseInt(String str, int i, int i2) throws NumberFormatException {
        int i3;
        int i4;
        if (i < 0 || i2 > str.length() || i > i2) {
            throw new NumberFormatException(str);
        }
        if (i < i2) {
            i4 = i + 1;
            int digit = Character.digit(str.charAt(i), 10);
            if (digit >= 0) {
                i3 = -digit;
            } else {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
        } else {
            i3 = 0;
            i4 = i;
        }
        while (i4 < i2) {
            int i5 = i4 + 1;
            int digit2 = Character.digit(str.charAt(i4), 10);
            if (digit2 >= 0) {
                i3 = (i3 * 10) - digit2;
                i4 = i5;
            } else {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
        }
        return -i3;
    }

    public static String format(Date date, boolean z) {
        return format(date, z, TIMEZONE_UTC);
    }

    public static String format(Date date, boolean z, TimeZone timeZone) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder sb = new StringBuilder(19 + (z ? 4 : 0) + (timeZone.getRawOffset() == 0 ? 1 : 6));
        padInt(sb, gregorianCalendar.get(1), 4);
        char c = Soundex.SILENT_MARKER;
        sb.append(Soundex.SILENT_MARKER);
        padInt(sb, gregorianCalendar.get(2) + 1, 2);
        sb.append(Soundex.SILENT_MARKER);
        padInt(sb, gregorianCalendar.get(5), 2);
        sb.append('T');
        padInt(sb, gregorianCalendar.get(11), 2);
        sb.append(':');
        padInt(sb, gregorianCalendar.get(12), 2);
        sb.append(':');
        padInt(sb, gregorianCalendar.get(13), 2);
        if (z) {
            sb.append('.');
            padInt(sb, gregorianCalendar.get(14), 3);
        }
        int offset = timeZone.getOffset(gregorianCalendar.getTimeInMillis());
        if (offset != 0) {
            int i = offset / 60000;
            int abs = Math.abs(i / 60);
            int abs2 = Math.abs(i % 60);
            if (offset >= 0) {
                c = '+';
            }
            sb.append(c);
            padInt(sb, abs, 2);
            sb.append(':');
            padInt(sb, abs2, 2);
        } else {
            sb.append('Z');
        }
        return sb.toString();
    }
}
