package org.apache.commons.codec.language;

import androidx.exifinterface.media.ExifInterface;
import java.util.Locale;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

public class MatchRatingApproachEncoder implements StringEncoder {
    private static final String[] DOUBLE_CONSONANT = {"BB", "CC", "DD", "FF", "GG", "HH", "JJ", "KK", "LL", "MM", "NN", "PP", "QQ", "RR", "SS", "TT", "VV", "WW", "XX", "YY", "ZZ"};
    private static final int ELEVEN = 11;
    private static final String EMPTY = "";
    private static final int FIVE = 5;
    private static final int FOUR = 4;
    private static final int ONE = 1;
    private static final String PLAIN_ASCII = "AaEeIiOoUuAaEeIiOoUuYyAaEeIiOoUuYyAaOoNnAaEeIiOoUuYyAaCcOoUu";
    private static final int SEVEN = 7;
    private static final int SIX = 6;
    private static final String SPACE = " ";
    private static final int THREE = 3;
    private static final int TWELVE = 12;
    private static final int TWO = 2;
    private static final String UNICODE = "ÀàÈèÌìÒòÙùÁáÉéÍíÓóÚúÝýÂâÊêÎîÔôÛûŶŷÃãÕõÑñÄäËëÏïÖöÜüŸÿÅåÇçŐőŰű";

    public String cleanName(String str) {
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        String[] strArr = {"\\-", "[&]", "\\'", "\\.", "[\\,]"};
        for (int i = 0; i < 5; i++) {
            upperCase = upperCase.replaceAll(strArr[i], "");
        }
        return removeAccents(upperCase).replaceAll("\\s+", "");
    }

    public final Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return encode((String) obj);
        }
        throw new EncoderException("Parameter supplied to Match Rating Approach encoder is not of type java.lang.String");
    }

    public String getFirst3Last3(String str) {
        int length = str.length();
        if (length <= 6) {
            return str;
        }
        String substring = str.substring(0, 3);
        String substring2 = str.substring(length - 3, length);
        return substring + substring2;
    }

    public int getMinRating(int i) {
        if (i <= 4) {
            return 5;
        }
        if (i <= 7) {
            return 4;
        }
        if (i <= 11) {
            return 3;
        }
        return i == 12 ? 2 : 1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0069, code lost:
        r1 = getMinRating(java.lang.Math.abs(r5.length() + r6.length()));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isEncodeEquals(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            r0 = 0
            if (r5 == 0) goto L_0x0081
            java.lang.String r1 = ""
            boolean r2 = r1.equalsIgnoreCase(r5)
            if (r2 != 0) goto L_0x0081
            java.lang.String r2 = " "
            boolean r3 = r2.equalsIgnoreCase(r5)
            if (r3 == 0) goto L_0x0014
            goto L_0x0081
        L_0x0014:
            if (r6 == 0) goto L_0x0081
            boolean r1 = r1.equalsIgnoreCase(r6)
            if (r1 != 0) goto L_0x0081
            boolean r1 = r2.equalsIgnoreCase(r6)
            if (r1 == 0) goto L_0x0023
            goto L_0x0081
        L_0x0023:
            int r1 = r5.length()
            r2 = 1
            if (r1 == r2) goto L_0x0081
            int r1 = r6.length()
            if (r1 != r2) goto L_0x0031
            goto L_0x0081
        L_0x0031:
            boolean r1 = r5.equalsIgnoreCase(r6)
            if (r1 == 0) goto L_0x0038
            return r2
        L_0x0038:
            java.lang.String r5 = r4.cleanName(r5)
            java.lang.String r6 = r4.cleanName(r6)
            java.lang.String r5 = r4.removeVowels(r5)
            java.lang.String r6 = r4.removeVowels(r6)
            java.lang.String r5 = r4.removeDoubleConsonants(r5)
            java.lang.String r6 = r4.removeDoubleConsonants(r6)
            java.lang.String r5 = r4.getFirst3Last3(r5)
            java.lang.String r6 = r4.getFirst3Last3(r6)
            int r1 = r5.length()
            int r3 = r6.length()
            int r1 = r1 - r3
            int r1 = java.lang.Math.abs(r1)
            r3 = 3
            if (r1 < r3) goto L_0x0069
            return r0
        L_0x0069:
            int r1 = r5.length()
            int r3 = r6.length()
            int r1 = r1 + r3
            int r1 = java.lang.Math.abs(r1)
            int r1 = r4.getMinRating(r1)
            int r4 = r4.leftToRightThenRightToLeftProcessing(r5, r6)
            if (r4 < r1) goto L_0x0081
            r0 = r2
        L_0x0081:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.language.MatchRatingApproachEncoder.isEncodeEquals(java.lang.String, java.lang.String):boolean");
    }

    public boolean isVowel(String str) {
        return str.equalsIgnoreCase(ExifInterface.LONGITUDE_EAST) || str.equalsIgnoreCase(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS) || str.equalsIgnoreCase("O") || str.equalsIgnoreCase("I") || str.equalsIgnoreCase("U");
    }

    public int leftToRightThenRightToLeftProcessing(String str, String str2) {
        char[] charArray = str.toCharArray();
        char[] charArray2 = str2.toCharArray();
        int length = str.length() - 1;
        int length2 = str2.length() - 1;
        int i = 0;
        while (i < charArray.length && i <= length2) {
            int i2 = i + 1;
            String substring = str.substring(i, i2);
            int i3 = length - i;
            String substring2 = str.substring(i3, i3 + 1);
            String substring3 = str2.substring(i, i2);
            int i4 = length2 - i;
            String substring4 = str2.substring(i4, i4 + 1);
            if (substring.equals(substring3)) {
                charArray[i] = ' ';
                charArray2[i] = ' ';
            }
            if (substring2.equals(substring4)) {
                charArray[i3] = ' ';
                charArray2[i4] = ' ';
            }
            i = i2;
        }
        String replaceAll = new String(charArray).replaceAll("\\s+", "");
        String replaceAll2 = new String(charArray2).replaceAll("\\s+", "");
        return replaceAll.length() > replaceAll2.length() ? Math.abs(6 - replaceAll.length()) : Math.abs(6 - replaceAll2.length());
    }

    public String removeAccents(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            int indexOf = UNICODE.indexOf(charAt);
            if (indexOf > -1) {
                sb.append(PLAIN_ASCII.charAt(indexOf));
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    public String removeDoubleConsonants(String str) {
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        for (String str2 : DOUBLE_CONSONANT) {
            if (upperCase.contains(str2)) {
                upperCase = upperCase.replace(str2, str2.substring(0, 1));
            }
        }
        return upperCase;
    }

    public String removeVowels(String str) {
        String substring = str.substring(0, 1);
        String replaceAll = str.replaceAll(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "").replaceAll(ExifInterface.LONGITUDE_EAST, "").replaceAll("I", "").replaceAll("O", "").replaceAll("U", "").replaceAll("\\s{2,}\\b", " ");
        if (!isVowel(substring)) {
            return replaceAll;
        }
        return substring + replaceAll;
    }

    public final String encode(String str) {
        if (str == null || "".equalsIgnoreCase(str) || " ".equalsIgnoreCase(str) || str.length() == 1) {
            return "";
        }
        return getFirst3Last3(removeDoubleConsonants(removeVowels(cleanName(str))));
    }
}
