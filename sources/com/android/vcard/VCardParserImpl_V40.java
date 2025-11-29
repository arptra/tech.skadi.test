package com.android.vcard;

import java.util.Set;
import org.apache.commons.lang3.StringUtils;

class VCardParserImpl_V40 extends VCardParserImpl_V30 {
    public static String K(char c) {
        return (c == 'n' || c == 'N') ? StringUtils.LF : String.valueOf(c);
    }

    public static String N(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        int i = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt != '\\' || i >= length - 1) {
                sb.append(charAt);
            } else {
                i++;
                char charAt2 = str.charAt(i);
                if (charAt2 == 'n' || charAt2 == 'N') {
                    sb.append(StringUtils.LF);
                } else {
                    sb.append(charAt2);
                }
            }
            i++;
        }
        return sb.toString();
    }

    public String C(String str) {
        return N(str);
    }

    public Set e() {
        return VCardParser_V40.b;
    }

    public int m() {
        return 2;
    }

    public String n() {
        return "4.0";
    }
}
