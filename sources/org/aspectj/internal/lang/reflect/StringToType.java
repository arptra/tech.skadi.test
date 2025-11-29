package org.aspectj.internal.lang.reflect;

import com.meizu.common.widget.MzContactsContract;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.StringTokenizer;
import org.aspectj.lang.reflect.AjTypeSystem;

public class StringToType {
    public static Type[] commaSeparatedListToTypeArray(String str, Class cls) throws ClassNotFoundException {
        StringTokenizer stringTokenizer = new StringTokenizer(str, MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA);
        Type[] typeArr = new Type[stringTokenizer.countTokens()];
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            typeArr[i] = stringToType(stringTokenizer.nextToken().trim(), cls);
            i++;
        }
        return typeArr;
    }

    private static Type makeParameterizedType(String str, Class<?> cls) throws ClassNotFoundException {
        int indexOf = str.indexOf(60);
        final Class<?> cls2 = Class.forName(str.substring(0, indexOf), false, cls.getClassLoader());
        final Type[] commaSeparatedListToTypeArray = commaSeparatedListToTypeArray(str.substring(indexOf + 1, str.lastIndexOf(62)), cls);
        return new ParameterizedType() {
            public Type[] getActualTypeArguments() {
                return commaSeparatedListToTypeArray;
            }

            public Type getOwnerType() {
                return cls2.getEnclosingClass();
            }

            public Type getRawType() {
                return cls2;
            }
        };
    }

    public static Type stringToType(String str, Class cls) throws ClassNotFoundException {
        try {
            return !str.contains("<") ? AjTypeSystem.getAjType(Class.forName(str, false, cls.getClassLoader())) : makeParameterizedType(str, cls);
        } catch (ClassNotFoundException unused) {
            for (TypeVariable typeVariable : cls.getTypeParameters()) {
                if (typeVariable.getName().equals(str)) {
                    return typeVariable;
                }
            }
            throw new ClassNotFoundException(str);
        }
    }
}
