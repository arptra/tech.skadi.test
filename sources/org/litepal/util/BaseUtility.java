package org.litepal.util;

import android.text.TextUtils;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Locale;
import org.litepal.LitePalApplication;
import org.litepal.exceptions.LitePalSupportException;
import org.litepal.parser.LitePalAttr;
import org.litepal.util.Const;

public class BaseUtility {
    private BaseUtility() {
    }

    public static String capitalize(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.substring(0, 1).toUpperCase(Locale.US) + str.substring(1);
        } else if (str == null) {
            return null;
        } else {
            return "";
        }
    }

    public static String changeCase(String str) {
        if (str == null) {
            return null;
        }
        String cases = LitePalAttr.getInstance().getCases();
        return Const.Config.CASES_KEEP.equals(cases) ? str : Const.Config.CASES_UPPER.equals(cases) ? str.toUpperCase(Locale.US) : str.toLowerCase(Locale.US);
    }

    public static void checkConditionsCorrect(String... strArr) {
        int length;
        if (strArr != null && (length = strArr.length) > 0 && length != count(strArr[0], "?") + 1) {
            throw new LitePalSupportException(LitePalSupportException.UPDATE_CONDITIONS_EXCEPTION);
        }
    }

    public static boolean containsIgnoreCases(Collection<String> collection, String str) {
        if (collection == null) {
            return false;
        }
        if (str == null) {
            return collection.contains((Object) null);
        }
        for (String equalsIgnoreCase : collection) {
            if (str.equalsIgnoreCase(equalsIgnoreCase)) {
                return true;
            }
        }
        return false;
    }

    public static int count(String str, String str2) {
        int i = 0;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            int indexOf = str.indexOf(str2);
            while (indexOf != -1) {
                i++;
                str = str.substring(indexOf + str2.length());
                indexOf = str.indexOf(str2);
            }
        }
        return i;
    }

    public static boolean isClassAndMethodExist(String str, String str2) {
        try {
            for (Method name : Class.forName(str).getMethods()) {
                if (str2.equals(name.getName())) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isFieldTypeSupported(String str) {
        return "boolean".equals(str) || "java.lang.Boolean".equals(str) || "float".equals(str) || "java.lang.Float".equals(str) || "double".equals(str) || "java.lang.Double".equals(str) || "int".equals(str) || "java.lang.Integer".equals(str) || "long".equals(str) || "java.lang.Long".equals(str) || "short".equals(str) || "java.lang.Short".equals(str) || "char".equals(str) || "java.lang.Character".equals(str) || "java.lang.String".equals(str) || "java.util.Date".equals(str);
    }

    public static boolean isGenericTypeSupported(String str) {
        return "java.lang.String".equals(str) || "java.lang.Integer".equals(str) || "java.lang.Float".equals(str) || "java.lang.Double".equals(str) || "java.lang.Long".equals(str) || "java.lang.Short".equals(str) || "java.lang.Boolean".equals(str) || "java.lang.Character".equals(str);
    }

    public static boolean isLitePalXMLExists() {
        try {
            String[] list = LitePalApplication.getContext().getAssets().list("");
            if (list != null && list.length > 0) {
                for (String equalsIgnoreCase : list) {
                    if (Const.Config.CONFIGURATION_FILE_NAME.equalsIgnoreCase(equalsIgnoreCase)) {
                        return true;
                    }
                }
            }
        } catch (IOException unused) {
        }
        return false;
    }
}
