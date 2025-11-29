package org.apache.tika.utils;

import java.util.Iterator;
import java.util.List;

public class StringUtils {
    public static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean b(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static String c(String str, List list) {
        if (list.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            String str2 = (String) it.next();
            int i2 = i + 1;
            if (i > 0) {
                sb.append(str);
            }
            sb.append(str2);
            i = i2;
        }
        return sb.toString();
    }
}
