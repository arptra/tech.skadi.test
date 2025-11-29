package flyme.support.v7.util;

import androidx.fragment.app.FragmentManager;
import java.lang.reflect.Field;

public class ReflectUtils {
    public static Field mStateSavedField;
    public static Field mSupportStateSavedField;

    private static void checkStateSavedField(Object obj, boolean z) {
        if (z && mSupportStateSavedField != null) {
            return;
        }
        if (z || mStateSavedField == null) {
            Field field = null;
            try {
                field = obj.getClass().getDeclaredField("mStateSaved");
                field.setAccessible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (z) {
                mSupportStateSavedField = field;
            } else {
                mStateSavedField = field;
            }
        }
    }

    public static int getFragmentsStateSavedValue(Object obj) {
        Field field;
        boolean z = obj instanceof FragmentManager;
        checkStateSavedField(obj, z);
        if (z) {
            try {
                field = mSupportStateSavedField;
            } catch (Exception e) {
                e.printStackTrace();
                return -1;
            }
        } else {
            field = mStateSavedField;
        }
        return field.getBoolean(obj) ? 1 : 0;
    }

    public static void setFragmentsStateSavedValue(Object obj, boolean z) {
        Field field;
        boolean z2 = obj instanceof FragmentManager;
        checkStateSavedField(obj, z2);
        if (z2) {
            try {
                field = mSupportStateSavedField;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        } else {
            field = mStateSavedField;
        }
        field.setBoolean(obj, z);
    }
}
