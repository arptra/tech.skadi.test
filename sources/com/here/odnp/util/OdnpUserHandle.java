package com.here.odnp.util;

import android.os.UserHandle;
import java.lang.reflect.Field;

public class OdnpUserHandle {
    public static final UserHandle CURRENT = getUserHandleField("CURRENT");
    public static final UserHandle OWNER = getUserHandleField("OWNER");
    private static final String TAG = "odnp.util.OdnpUserHandle";
    public static final int USER_CURRENT = getIntField("USER_CURRENT", -2);
    public static final int USER_OWNER = getIntField("USER_CURRENT", 0);

    private OdnpUserHandle() {
    }

    public static UserHandle createUserHandle(int i) {
        try {
            return UserHandle.class.getDeclaredConstructor(new Class[]{Integer.TYPE}).newInstance(new Object[]{Integer.valueOf(i)});
        } catch (Exception unused) {
            return null;
        }
    }

    public static int getCallingUserId() {
        try {
            return ((Integer) UserHandle.class.getMethod("getCallingUserId", (Class[]) null).invoke((Object) null, (Object[]) null)).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    private static int getIntField(String str, int i) {
        try {
            Field declaredField = UserHandle.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            return ((Integer) declaredField.get((Object) null)).intValue();
        } catch (Exception unused) {
            return i;
        }
    }

    private static UserHandle getUserHandleField(String str) {
        try {
            Field declaredField = UserHandle.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            return (UserHandle) declaredField.get((Object) null);
        } catch (Exception unused) {
            return null;
        }
    }
}
