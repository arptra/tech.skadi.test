package com.meizu.common.util;

import android.util.Log;
import android.widget.ListPopupWindow;
import java.lang.reflect.Method;

public class PopupWindowUtils {
    private static final String TAG = "PopupWindowUtils";
    private static Method adjustWindowPositionForMzMethod;
    private static Class clazz;
    private static Class popLayoutModeClazz;
    private static Class popUpClazz;
    private static Class popupLayoutModeClazz;
    private static Method setContentHeightMethod;
    private static Method setLayoutModeMethod;
    private static Method setPopupLayoutModeMethod;

    public static boolean adjustWindowPositionForMz(Object obj, boolean z) {
        if (!CommonUtils.isFlymeOS()) {
            return false;
        }
        try {
            if (popUpClazz == null) {
                popUpClazz = obj.getClass();
                Method declaredMethod = clazz.getDeclaredMethod("adjustWindowPositionForMz", new Class[]{Boolean.TYPE});
                adjustWindowPositionForMzMethod = declaredMethod;
                declaredMethod.setAccessible(true);
                adjustWindowPositionForMzMethod.invoke(obj, new Object[]{Boolean.valueOf(z)});
                return true;
            }
            Method method = adjustWindowPositionForMzMethod;
            if (method == null) {
                return false;
            }
            method.setAccessible(true);
            adjustWindowPositionForMzMethod.invoke(obj, new Object[]{Boolean.valueOf(z)});
            return true;
        } catch (Exception e) {
            Log.e(TAG, obj.getClass().getName() + "#adjustWindowPositionForMz fail to be invoked.Caused by:" + e.getMessage());
            return false;
        }
    }

    public static boolean setContentHeight(ListPopupWindow listPopupWindow, int i) {
        if (CommonUtils.isFlymeOS()) {
            try {
                if (clazz == null) {
                    Class<ListPopupWindow> cls = ListPopupWindow.class;
                    clazz = cls;
                    Method declaredMethod = cls.getDeclaredMethod("setContentHeight", new Class[]{Integer.TYPE});
                    setContentHeightMethod = declaredMethod;
                    declaredMethod.setAccessible(true);
                    setContentHeightMethod.invoke(listPopupWindow, new Object[]{Integer.valueOf(i)});
                    return true;
                }
                Method method = setContentHeightMethod;
                if (method != null) {
                    method.setAccessible(true);
                    setContentHeightMethod.invoke(listPopupWindow, new Object[]{Integer.valueOf(i)});
                    return true;
                }
            } catch (Exception e) {
                Log.e(TAG, "setContentHeight fail to be invoked.Caused by:" + e.getMessage());
                return false;
            }
        } else {
            listPopupWindow.setHeight(i);
        }
        return true;
    }

    public static boolean setLayoutMode(Object obj, int i) {
        if (!CommonUtils.isFlymeOS()) {
            return false;
        }
        try {
            if (popLayoutModeClazz == null) {
                popLayoutModeClazz = obj.getClass();
                Method declaredMethod = clazz.getDeclaredMethod("setLayoutMode", new Class[]{Integer.TYPE});
                setLayoutModeMethod = declaredMethod;
                declaredMethod.setAccessible(true);
                setLayoutModeMethod.invoke(obj, new Object[]{Integer.valueOf(i)});
                return true;
            }
            Method method = setLayoutModeMethod;
            if (method == null) {
                return false;
            }
            method.setAccessible(true);
            setLayoutModeMethod.invoke(obj, new Object[]{Integer.valueOf(i)});
            return false;
        } catch (Exception e) {
            Log.e(TAG, obj.getClass().getName() + "#setLayoutMode fail to be invoked.Caused by:" + e.getMessage());
            return false;
        }
    }

    public static boolean setPopupLayoutMode(Object obj, int i) {
        if (!CommonUtils.isFlymeOS()) {
            return false;
        }
        try {
            if (popLayoutModeClazz == null) {
                popLayoutModeClazz = obj.getClass();
                Method declaredMethod = clazz.getDeclaredMethod("setPopupLayoutMode", new Class[]{Integer.TYPE});
                setPopupLayoutModeMethod = declaredMethod;
                declaredMethod.setAccessible(true);
                setPopupLayoutModeMethod.invoke(obj, new Object[]{Integer.valueOf(i)});
                return true;
            } else if (setLayoutModeMethod == null) {
                return false;
            } else {
                setPopupLayoutModeMethod.setAccessible(true);
                setPopupLayoutModeMethod.invoke(obj, new Object[]{Integer.valueOf(i)});
                return true;
            }
        } catch (Exception e) {
            Log.e(TAG, "popupObject#setPopupLayoutMode fail to be invoked.Caused by:" + e.getMessage());
            return false;
        }
    }
}
