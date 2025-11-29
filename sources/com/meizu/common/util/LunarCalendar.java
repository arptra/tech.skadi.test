package com.meizu.common.util;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.alibaba.fastjson.asm.Opcodes;
import com.here.posclient.PositionEstimate;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.regex.Pattern;
import org.apache.commons.lang3.time.DateUtils;

public class LunarCalendar {
    private static final Pattern DATE_PATTERN = Pattern.compile(LUNAR_DATE_REGEXP);
    public static final String DATE_SEPARATOR = "-";
    private static final int[] DAYS_BEFORE_MONTH = {0, 31, 59, 90, 120, Opcodes.DCMPL, Opcodes.PUTFIELD, 212, 243, 273, 304, 334, 365};
    public static final String LUNAR_DATE_REGEXP = "(19|20)[0-9]{2}-((0)?[1-9]|1[012])-((0)?[1-9]|(1|2)[0-9]|30)$";
    private static final int[] LUNAR_INFO = {701770, 8697535, 306771, 677704, 5580477, 861776, 890180, 4631225, 354893, 634178, 2404022, 306762, 6966718, 675154, 861510, 6116026, 742478, 879171, 2714935, 613195, 7642049, 300884, 674632, 5973436, 435536, 447557, 4905656, 177741, 612162, 2398135, 300874, 6703934, 870993, 959814, 5690554, 372046, 177732, 3749688, 601675, 8165055, 824659, 870984, 7185723, 742735, 354885, 4894137, 154957, 601410, 2921910, 693578, 8080061, 445009, 742726, 5593787, 318030, 678723, 3484600, 338764, 9082175, 955730, 436808, 7001404, 701775, 308805, 4871993, 677709, 337474, 4100917, 890185, 7711422, 354897, 617798, 5549755, 306511, 675139, 5056183, 861515, 9261759, 742482, 748103, 6909244, 613200, 301893, 4869049, 674637, 11216322, 435540, 447561, 7002685, 702033, 612166, 5543867, 300879, 412484, 3581239, 959818, 8827583, 371795, 702023, 5846716, 601680, 824901, 5065400, 870988, 894273, 2468534, 354889, 8039869, 154962, 601415, 6067642, 693582, 739907, 4937015, 709962, 9788095, 309843, 678728, 6630332, 338768, 693061, 4672185, 436812, 709953, 2415286, 308810, 6969149, 675409, 861766, 6198074, 873293, 371267, 3585335, 617803, 11841215, 306515, 675144, 7153084, 861519, 873028, 6138424, 744012, 355649, 2403766, 301898, 8014782, 674641, 697670, 5984954, 447054, 711234, 3496759, 603979, 8689601, 300883, 412488, 6726972, 959823, 436804, 4896312, 699980, 601666, 3970869, 824905, 8211133, 870993, 894277, 5614266, 354894, 683331, 4533943, 339275, 9082303, 693587, 739911, 7034171, 709967, 350789, 4873528, 678732, 338754, 3838902, 430921, 7809469, 436817, 709958, 5561018, 308814, 677699, 4532024, 861770, 9343806, 873042, 895559, 6731067, 355663, 306757, 4869817, 675148, 857409, 2986677};
    public static final int MAX_YEAR = 2099;
    public static final int MIN_YEAR = 1899;
    private static final TimeZone TZ_UTC = TimeZone.getTimeZone("UTC");

    public static class DateParser {
        static final String[] FORAMTS = {"(19|20)[0-9]{2}S((0)?[1-9]|1[012])S((0)?[1-9]|(1|2)[0-9]|30|31)", "((0)?[1-9]|(1|2)[0-9]|30|31)S((0)?[1-9]|1[012])S(19|20)[0-9]{2}", "(19|20)[0-9]{2}S((0)?[1-9]|(1|2)[0-9]|30|31)S((0)?[1-9]|1[012])", "((0)?[1-9]|1[012])S((0)?[1-9]|(1|2)[0-9]|30|31)S(19|20)[0-9]{2}"};
        static final String PATTERN_DAY = "((0)?[1-9]|(1|2)[0-9]|30|31)";
        static final String PATTERN_MONTH = "((0)?[1-9]|1[012])";
        static final int PATTERN_TYPE_DD_MM_YYYY = 1;
        static final int PATTERN_TYPE_MM_DD_YYYY = 3;
        static final int PATTERN_TYPE_YYYY_DD_MM = 2;
        static final int PATTERN_TYPE_YYYY_MM_DD = 0;
        static final String PATTERN_YEAR = "(19|20)[0-9]{2}";
        static final String[] SEPARATOR = {LunarCalendar.DATE_SEPARATOR, "/", "."};
        private String mCurrentSeparator;
        private String mDateString;
        private int mFormatOrder = -1;

        public DateParser(String str) {
            this.mDateString = str;
            recognitionFormat();
        }

        public int[] getDate() {
            String[] split = this.mDateString.split(this.mCurrentSeparator);
            int i = this.mFormatOrder;
            char c = 0;
            char c2 = 1;
            char c3 = 2;
            if (i != 0) {
                if (i == 1) {
                    c3 = 0;
                    c = 2;
                } else if (i == 2) {
                    c3 = 1;
                    c2 = 2;
                } else if (i == 3) {
                    c2 = 0;
                    c = 2;
                    c3 = 1;
                }
            }
            return new int[]{Integer.valueOf(split[c]).intValue(), Integer.valueOf(split[c2]).intValue(), Integer.valueOf(split[c3]).intValue()};
        }

        public void recognitionFormat() {
            String str = null;
            int i = 0;
            for (String str2 : SEPARATOR) {
                if (this.mDateString.contains(str2)) {
                    str = str2;
                }
            }
            if (!TextUtils.isEmpty(str)) {
                if (str.equals(".")) {
                    str = "\\.";
                }
                this.mCurrentSeparator = str;
                this.mFormatOrder = -1;
                while (true) {
                    String[] strArr = FORAMTS;
                    if (i >= strArr.length) {
                        break;
                    } else if (Pattern.compile(strArr[i].replace(ExifInterface.LATITUDE_SOUTH, str)).matcher(this.mDateString).matches()) {
                        this.mFormatOrder = i;
                        break;
                    } else {
                        i++;
                    }
                }
                if (this.mFormatOrder == -1) {
                    throw new IllegalArgumentException("Unsupported date format for string : " + this.mDateString + ", only support yyyyMMdd/ddMMyyyy/yyyyddMM");
                }
                return;
            }
            throw new IllegalArgumentException("Date separator must in '.' or '/' or '-'");
        }
    }

    private static int daysInLunarMonth(int i, int i2) {
        if (i < 1899) {
            i = 1899;
        }
        return (LUNAR_INFO[i - MIN_YEAR] & (PositionEstimate.Value.SITUATION >> i2)) == 0 ? 29 : 30;
    }

    private static int daysInLunarYear(int i) {
        int i2 = leapMonth(i) != 0 ? 377 : 348;
        int i3 = LUNAR_INFO[i - 1899] & 1048448;
        for (int i4 = PositionEstimate.Value.TIME_SINCE_BOOT; i4 > 7; i4 >>= 1) {
            if ((i3 & i4) != 0) {
                i2++;
            }
        }
        return i2;
    }

    public static final int daysInMonth(int i, int i2) {
        return daysInMonth(i, i2, false);
    }

    public static int leapMonth(int i) {
        if (i < 1899) {
            i = 1899;
        }
        int[] iArr = LUNAR_INFO;
        return (iArr[Math.min(iArr.length - 1, i - MIN_YEAR)] & 15728640) >> 20;
    }

    public static final int[] lunarToSolar(int i, int i2, int i3, boolean z) {
        int i4;
        if (i < 1899) {
            i = 1899;
        } else if (i > 2099) {
            i = 2099;
        }
        if (i2 < 1) {
            i2 = 1;
        } else if (i2 > 12) {
            i2 = 12;
        }
        if (i3 < 1) {
            i3 = 1;
        } else if (i3 > 30) {
            i3 = 30;
        }
        if (i < 1899 || i > 2099 || i2 < 1 || i2 > 12 || i3 < 1 || i3 > 30) {
            throw new IllegalArgumentException("Illegal lunar date, must be like that:\n\tyear : 1900~2099\n\tmonth : 1~12\n\tday : 1~30\n\terror date:" + i + " " + i2 + " " + i3);
        }
        int i5 = i - 1899;
        int i6 = LUNAR_INFO[i5];
        int i7 = i6 & 31;
        int i8 = i7 - 1;
        if (i5 != 1) {
            i7 = i8;
        }
        if (((i6 & 96) >> 5) == 2) {
            i7 += 31;
        }
        for (int i9 = 1; i9 < i2; i9++) {
            i4 = ((PositionEstimate.Value.TIME_SINCE_BOOT >> (i9 + -1)) & LUNAR_INFO[i5]) == 0 ? i4 + 29 : i4 + 30;
        }
        int i10 = i4 + i3;
        int i11 = LUNAR_INFO[i5];
        int i12 = (15728640 & i11) >> 20;
        if (i12 != 0 && (i2 > i12 || (i2 == i12 && z))) {
            i10 = ((PositionEstimate.Value.TIME_SINCE_BOOT >> (i2 - 1)) & i11) == 0 ? i10 + 29 : i10 + 30;
        }
        if (i10 > 366 || (i % 4 != 0 && i10 > 365)) {
            i++;
            i10 = i % 4 == 1 ? i10 - 366 : i10 - 365;
        }
        int[] iArr = new int[3];
        int i13 = 1;
        while (true) {
            if (i13 >= 13) {
                break;
            }
            int[] iArr2 = DAYS_BEFORE_MONTH;
            int i14 = iArr2[i13];
            int i15 = i % 4;
            if (i15 == 0 && i13 > 2) {
                i14++;
            }
            if (i15 == 0 && i13 == 2 && i14 + 1 == i10) {
                iArr[1] = i13;
                iArr[2] = i10 - 31;
                break;
            } else if (i14 >= i10) {
                iArr[1] = i13;
                int i16 = iArr2[i13 - 1];
                int i17 = (i15 != 0 || i13 <= 2) ? i16 : i16 + 1;
                if (i10 > i17) {
                    iArr[2] = i10 - i17;
                } else if (i10 != i17) {
                    iArr[2] = i10;
                } else if (i15 == 0 && i13 == 2) {
                    iArr[2] = (iArr2[i13] - i16) + 1;
                } else {
                    iArr[2] = iArr2[i13] - i16;
                }
            } else {
                i13++;
            }
        }
        iArr[0] = i;
        return iArr;
    }

    public static int[] parseDate(String str) {
        return parseDate(str, false);
    }

    public static int[] parseLunarDate(String str) {
        return parseDate(str);
    }

    public static final int[] solarToLunar(int i, int i2, int i3) {
        int i4 = MIN_YEAR;
        GregorianCalendar gregorianCalendar = new GregorianCalendar(MIN_YEAR, 1, 10);
        TimeZone timeZone = TZ_UTC;
        gregorianCalendar.setTimeZone(timeZone);
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar(i, i2 - 1, i3);
        gregorianCalendar2.setTimeZone(timeZone);
        int time = (int) ((gregorianCalendar2.getTime().getTime() - gregorianCalendar.getTime().getTime()) / DateUtils.MILLIS_PER_DAY);
        int i5 = 0;
        int i6 = 0;
        while (i4 <= 2099 && time > 0) {
            i6 = daysInLunarYear(i4);
            time -= i6;
            i4++;
        }
        if (time < 0) {
            time += i6;
            i4--;
        }
        int leapMonth = leapMonth(i4);
        int i7 = 0;
        int i8 = 1;
        while (i8 <= 13 && time > 0) {
            i7 = daysInLunarMonth(i4, i8);
            time -= i7;
            i8++;
        }
        if (time < 0) {
            time += i7;
            i8--;
        }
        if (leapMonth != 0 && i8 > leapMonth && i8 - 1 == leapMonth) {
            i5 = 1;
        }
        return new int[]{i4, i8, time + 1, i5};
    }

    public static final boolean validateDateFormat(String str) {
        return DATE_PATTERN.matcher(str).matches();
    }

    public static final int daysInMonth(int i, int i2, boolean z) {
        int leapMonth = leapMonth(i);
        int i3 = (leapMonth == 0 || i2 <= leapMonth) ? 0 : 1;
        if (!z) {
            return daysInLunarMonth(i, i2 + i3);
        }
        if (leapMonth == 0 || leapMonth != i2) {
            return 0;
        }
        return daysInLunarMonth(i, i2 + 1);
    }

    public static int[] parseDate(String str, boolean z) {
        DateParser dateParser = new DateParser(str);
        if (!z || dateParser.getDate()[2] != 31) {
            return dateParser.getDate();
        }
        throw new IllegalArgumentException("错误的农历日期数据：" + str + ", 农历没有三十一");
    }
}
