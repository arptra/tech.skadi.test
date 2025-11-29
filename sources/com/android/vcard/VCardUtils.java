package com.android.vcard;

import android.telephony.PhoneNumberUtils;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.Log;
import io.netty.util.internal.StringUtil;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class VCardUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final Map f2398a;
    public static final Set b;
    public static final Map c;
    public static final Map d;
    public static final Set e = new HashSet(Arrays.asList(new String[]{"MOBILE", "携帯電話", "携帯", "ケイタイ", "ｹｲﾀｲ"}));
    public static final Set f = new HashSet(Arrays.asList(new Character[]{'[', ']', '=', ':', '.', Character.valueOf(StringUtil.COMMA), ' '}));
    public static final int[] g = {58, 59, 44, 32};
    public static final int[] h = {59, 58};

    public static class DecoderException extends Exception {
        public DecoderException(String str) {
            super(str);
        }
    }

    public static class PhoneNumberUtilsPort {
        public static String a(String str, int i) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            PhoneNumberUtils.formatNumber(spannableStringBuilder, i);
            return spannableStringBuilder.toString();
        }
    }

    public static class QuotedPrintableCodecPort {

        /* renamed from: a  reason: collision with root package name */
        public static byte f2399a = 61;

        public static final byte[] a(byte[] bArr) {
            if (bArr == null) {
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i = 0;
            while (i < bArr.length) {
                byte b = bArr[i];
                if (b == f2399a) {
                    try {
                        int digit = Character.digit((char) bArr[i + 1], 16);
                        i += 2;
                        int digit2 = Character.digit((char) bArr[i], 16);
                        if (digit == -1 || digit2 == -1) {
                            throw new DecoderException("Invalid quoted-printable encoding");
                        }
                        byteArrayOutputStream.write((char) ((digit << 4) + digit2));
                    } catch (ArrayIndexOutOfBoundsException unused) {
                        throw new DecoderException("Invalid quoted-printable encoding");
                    }
                } else {
                    byteArrayOutputStream.write(b);
                }
                i++;
            }
            return byteArrayOutputStream.toByteArray();
        }
    }

    public static class TextUtilsPort {
        public static boolean a(char c) {
            return (' ' <= c && c <= '~') || c == 13 || c == 10;
        }

        public static boolean b(CharSequence charSequence) {
            int length = charSequence.length();
            for (int i = 0; i < length; i++) {
                if (!a(charSequence.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f2398a = hashMap;
        HashMap hashMap2 = new HashMap();
        c = hashMap2;
        hashMap.put(9, "CAR");
        hashMap2.put("CAR", 9);
        hashMap.put(6, "PAGER");
        hashMap2.put("PAGER", 6);
        hashMap.put(11, "ISDN");
        hashMap2.put("ISDN", 11);
        hashMap2.put("HOME", 1);
        hashMap2.put("WORK", 3);
        hashMap2.put("CELL", 2);
        hashMap2.put("OTHER", 7);
        hashMap2.put("CALLBACK", 8);
        hashMap2.put("COMPANY-MAIN", 10);
        hashMap2.put("RADIO", 14);
        hashMap2.put("TTY-TDD", 16);
        hashMap2.put("ASSISTANT", 19);
        hashMap2.put("VOICE", 7);
        HashSet hashSet = new HashSet();
        b = hashSet;
        hashSet.add("MODEM");
        hashSet.add("MSG");
        hashSet.add("BBS");
        hashSet.add("VIDEO");
        HashMap hashMap3 = new HashMap();
        d = hashMap3;
        hashMap3.put(0, "X-AIM");
        hashMap3.put(1, "X-MSN");
        hashMap3.put(2, "X-YAHOO");
        hashMap3.put(3, "X-SKYPE-USERNAME");
        hashMap3.put(5, "X-GOOGLE-TALK");
        hashMap3.put(6, "X-ICQ");
        hashMap3.put(7, "X-JABBER");
        hashMap3.put(4, "X-QQ");
        hashMap3.put(8, "X-NETMEETING");
    }

    public static boolean a(String str) {
        int length = str.length() % 3;
        if (str.length() < 2 || (length != 1 && length != 0)) {
            return false;
        }
        for (int i = 0; i < str.length(); i += 3) {
            if (str.charAt(i) != '=') {
                return false;
            }
        }
        return true;
    }

    public static List b(String str, int i) {
        String str2;
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            char charAt = str.charAt(i2);
            if (charAt == '\\' && i2 < length - 1) {
                int i3 = i2 + 1;
                char charAt2 = str.charAt(i3);
                if (VCardConfig.e(i)) {
                    str2 = VCardParserImpl_V40.K(charAt2);
                } else if (VCardConfig.d(i)) {
                    str2 = VCardParserImpl_V30.K(charAt2);
                } else {
                    if (!VCardConfig.c(i)) {
                        Log.w("vCard", "Unknown vCard type");
                    }
                    str2 = VCardParserImpl_V21.K(charAt2);
                }
                if (str2 != null) {
                    sb.append(str2);
                    i2 = i3;
                } else {
                    sb.append(charAt);
                }
            } else if (charAt == ';') {
                arrayList.add(sb.toString());
                sb = new StringBuilder();
            } else {
                sb.append(charAt);
            }
            i2++;
        }
        arrayList.add(sb.toString());
        return arrayList;
    }

    public static String c(int i, String str, String str2, String str3) {
        return d(i, str, str2, str3, (String) null, (String) null);
    }

    public static String d(int i, String str, String str2, String str3, String str4, String str5) {
        boolean z;
        StringBuilder sb = new StringBuilder();
        String[] n = n(i, str, str2, str3);
        if (!TextUtils.isEmpty(str4)) {
            sb.append(str4);
            z = false;
        } else {
            z = true;
        }
        for (String str6 : n) {
            if (!TextUtils.isEmpty(str6)) {
                if (z) {
                    z = false;
                } else {
                    sb.append(' ');
                }
                sb.append(str6);
            }
        }
        if (!TextUtils.isEmpty(str5)) {
            if (!z) {
                sb.append(' ');
            }
            sb.append(str5);
        }
        return sb.toString();
    }

    public static boolean e(Collection collection) {
        if (collection == null) {
            return true;
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!TextUtils.isEmpty(str) && !TextUtilsPort.b(str)) {
                return false;
            }
        }
        return true;
    }

    public static boolean f(String... strArr) {
        if (strArr == null) {
            return true;
        }
        return e(Arrays.asList(strArr));
    }

    public static boolean g(Collection collection) {
        if (collection == null) {
            return true;
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!TextUtils.isEmpty(str)) {
                int length = str.length();
                for (int i = 0; i < length; i = str.offsetByCodePoints(i, 1)) {
                    if (!Character.isWhitespace(str.codePointAt(i))) {
                        return false;
                    }
                }
                continue;
            }
        }
        return true;
    }

    public static boolean h(String... strArr) {
        if (strArr == null) {
            return true;
        }
        return g(Arrays.asList(strArr));
    }

    public static final String i(String str, String str2, String str3) {
        if (str2.equalsIgnoreCase(str3)) {
            return str;
        }
        ByteBuffer encode = Charset.forName(str2).encode(str);
        byte[] bArr = new byte[encode.remaining()];
        encode.get(bArr);
        try {
            return new String(bArr, str3);
        } catch (UnsupportedEncodingException unused) {
            Log.e("vCard", "Failed to encode: charset=" + str3);
            return null;
        }
    }

    public static int j(int i) {
        return VCardConfig.b(i) ? 2 : 1;
    }

    public static Object k(Collection collection, String str) {
        boolean z;
        if (str == null) {
            str = "";
        }
        boolean z2 = false;
        int i = -1;
        String str2 = null;
        if (collection != null) {
            Iterator it = collection.iterator();
            z = false;
            boolean z3 = false;
            while (it.hasNext()) {
                String str3 = (String) it.next();
                if (str3 != null) {
                    String upperCase = str3.toUpperCase();
                    if (upperCase.equals("PREF")) {
                        z3 = true;
                    } else if (upperCase.equals("FAX")) {
                        z = true;
                    } else {
                        if (upperCase.startsWith("X-") && i < 0) {
                            str3 = str3.substring(2);
                        }
                        if (str3.length() != 0) {
                            Integer num = (Integer) c.get(str3.toUpperCase());
                            if (num != null) {
                                int intValue = num.intValue();
                                int indexOf = str.indexOf("@");
                                if ((intValue == 6 && indexOf > 0 && indexOf < str.length() - 1) || i < 0 || i == 0 || i == 7) {
                                    i = num.intValue();
                                }
                            } else if (i < 0) {
                                i = 0;
                                str2 = str3;
                            }
                        }
                    }
                }
            }
            z2 = z3;
        } else {
            z = false;
        }
        if (i < 0) {
            i = z2 ? 12 : 1;
        }
        if (z) {
            if (i == 1) {
                i = 5;
            } else if (i == 3) {
                i = 4;
            } else if (i == 7) {
                i = 13;
            }
        }
        return i == 0 ? str2 : Integer.valueOf(i);
    }

    public static boolean l(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        int length = str.length();
        int i = 0;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            if (32 > codePointAt || codePointAt > 126 || f.contains(Character.valueOf((char) codePointAt))) {
                return false;
            }
            i = str.offsetByCodePoints(i, 1);
        }
        return true;
    }

    public static String m(String str, boolean z, String str2, String str3) {
        String[] strArr;
        byte[] bArr;
        int i;
        char charAt;
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            char charAt2 = str.charAt(i2);
            if (charAt2 == '=' && i2 < length - 1 && ((charAt = str.charAt(i)) == ' ' || charAt == 9)) {
                sb.append(charAt);
                i2++;
            } else {
                sb.append(charAt2);
            }
            i2++;
        }
        String sb2 = sb.toString();
        if (z) {
            strArr = sb2.split("\r\n");
        } else {
            StringBuilder sb3 = new StringBuilder();
            int length2 = sb2.length();
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            while (i3 < length2) {
                char charAt3 = sb2.charAt(i3);
                if (charAt3 == 10) {
                    arrayList.add(sb3.toString());
                    sb3 = new StringBuilder();
                } else if (charAt3 == 13) {
                    arrayList.add(sb3.toString());
                    sb3 = new StringBuilder();
                    if (i3 < length2 - 1) {
                        int i4 = i3 + 1;
                        if (sb2.charAt(i4) == 10) {
                            i3 = i4;
                        }
                    }
                } else {
                    sb3.append(charAt3);
                }
                i3++;
            }
            String sb4 = sb3.toString();
            if (sb4.length() > 0) {
                arrayList.add(sb4);
            }
            strArr = (String[]) arrayList.toArray(new String[0]);
        }
        StringBuilder sb5 = new StringBuilder();
        for (String str4 : strArr) {
            if (str4.endsWith("=")) {
                str4 = str4.substring(0, str4.length() - 1);
            }
            sb5.append(str4);
        }
        String sb6 = sb5.toString();
        if (TextUtils.isEmpty(sb6)) {
            Log.w("vCard", "Given raw string is empty.");
        }
        try {
            bArr = sb6.getBytes(str2);
        } catch (UnsupportedEncodingException unused) {
            Log.w("vCard", "Failed to decode: " + str2);
            bArr = sb6.getBytes();
        }
        try {
            bArr = QuotedPrintableCodecPort.a(bArr);
        } catch (DecoderException unused2) {
            Log.e("vCard", "DecoderException is thrown.");
        }
        try {
            return new String(bArr, str3);
        } catch (UnsupportedEncodingException unused3) {
            Log.e("vCard", "Failed to encode: charset=" + str3);
            return new String(bArr);
        }
    }

    public static String[] n(int i, String str, String str2, String str3) {
        String[] strArr = new String[3];
        int a2 = VCardConfig.a(i);
        if (a2 == 4) {
            strArr[0] = str2;
            strArr[1] = str3;
            strArr[2] = str;
        } else if (a2 != 8) {
            strArr[0] = str3;
            strArr[1] = str2;
            strArr[2] = str;
        } else if (!f(str) || !f(str3)) {
            strArr[0] = str;
            strArr[1] = str2;
            strArr[2] = str3;
        } else {
            strArr[0] = str3;
            strArr[1] = str2;
            strArr[2] = str;
        }
        return strArr;
    }

    public static String o(String str, int[] iArr) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        boolean z = false;
        for (int i = 0; i < length; i = str.offsetByCodePoints(i, 1)) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt >= 32 && codePointAt != 34) {
                sb.appendCodePoint(codePointAt);
                int length2 = iArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length2) {
                        break;
                    } else if (codePointAt == iArr[i2]) {
                        z = true;
                        break;
                    } else {
                        i2++;
                    }
                }
            }
        }
        String sb2 = sb.toString();
        if (sb2.isEmpty() || h(sb2)) {
            return "";
        }
        if (!z) {
            return sb2;
        }
        return '\"' + sb2 + '\"';
    }

    public static String p(String str) {
        return o(str, g);
    }

    public static String q(String str) {
        return o(str, h);
    }
}
