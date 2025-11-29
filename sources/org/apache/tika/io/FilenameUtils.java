package org.apache.tika.io;

import com.alibaba.fastjson.parser.JSONLexer;
import com.honey.account.constant.AccountConstantKt;
import java.util.HashSet;
import kotlin.text.Typography;

public class FilenameUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f9655a;
    public static final HashSet b = new HashSet(38);

    static {
        char[] cArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, JSONLexer.EOI, 27, 28, 29, 30, 31, '?', ':', '*', Typography.less, Typography.greater, '|'};
        f9655a = cArr;
        for (char valueOf : cArr) {
            b.add(Character.valueOf(valueOf));
        }
    }

    public static String a(String str) {
        if (!(str == null || str.length() == 0)) {
            String substring = str.substring(Math.max(str.lastIndexOf(AccountConstantKt.CODE_SEPARTOR), Math.max(str.lastIndexOf("/"), str.lastIndexOf("\\"))) + 1);
            return (substring.equals("..") || substring.equals(".")) ? "" : substring;
        }
    }

    public static String b(String str) {
        String a2 = a(str);
        int lastIndexOf = a2.lastIndexOf(".");
        return (lastIndexOf <= -1 || a2.length() - lastIndexOf >= 6) ? "" : a2.substring(lastIndexOf);
    }
}
