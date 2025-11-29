package flyme.support.v7.widget;

import android.graphics.Rect;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ViewUtils {
    private static final int INIT_STATE_FINISHED = 2;
    private static final int INIT_STATE_NONE = 0;
    private static final int INIT_STATE_RUNNING = 1;
    private static final String TAG = "ViewUtils";
    /* access modifiers changed from: private */
    public static Method sComputeFitSystemWindowsMethod;
    /* access modifiers changed from: private */
    public static int sInitState = 1;
    /* access modifiers changed from: private */
    public static Method sMakeOptionalFitsSystemWindowsMethod;

    public static class InitThread extends Thread {
        private InitThread() {
        }

        public void run() {
            if (ViewUtils.sMakeOptionalFitsSystemWindowsMethod == null) {
                ViewUtils.getMakeOptionalFitsSystemWindowsMethod();
            }
            if (ViewUtils.sComputeFitSystemWindowsMethod == null) {
                ViewUtils.getComputeFitSystemWindowsMethod();
            }
            int unused = ViewUtils.sInitState = 2;
        }
    }

    static {
        new InitThread().start();
    }

    private ViewUtils() {
    }

    public static boolean applyInsets(View view, Rect rect, boolean z, boolean z2, boolean z3, boolean z4) {
        int i;
        int i2;
        int i3;
        int i4;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        boolean z5 = false;
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return false;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (z && marginLayoutParams.leftMargin != (i4 = rect.left)) {
            marginLayoutParams.leftMargin = i4;
            z5 = true;
        }
        if (z2 && marginLayoutParams.topMargin != (i3 = rect.top)) {
            marginLayoutParams.topMargin = i3;
            z5 = true;
        }
        if (z3 && marginLayoutParams.rightMargin != (i2 = rect.right)) {
            marginLayoutParams.rightMargin = i2;
            z5 = true;
        }
        if (!z4 || marginLayoutParams.bottomMargin == (i = rect.bottom)) {
            return z5;
        }
        marginLayoutParams.bottomMargin = i;
        return true;
    }

    public static boolean applyInsetsWithPadding(View view, Rect rect, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5;
        int i;
        int i2;
        int i3;
        int i4;
        int paddingLeft = view.getPaddingLeft();
        int paddingTop = view.getPaddingTop();
        int paddingRight = view.getPaddingRight();
        int paddingBottom = view.getPaddingBottom();
        boolean z6 = true;
        if (!z || paddingLeft == (i4 = rect.left)) {
            z5 = false;
        } else {
            paddingLeft = i4;
            z5 = true;
        }
        if (z2 && paddingTop != (i3 = rect.top)) {
            paddingTop = i3;
            z5 = true;
        }
        if (z3 && paddingRight != (i2 = rect.right)) {
            paddingRight = i2;
            z5 = true;
        }
        if (!z4 || paddingBottom == (i = rect.bottom)) {
            z6 = z5;
        } else {
            paddingBottom = i;
        }
        if (z6) {
            view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
        return z6;
    }

    public static int combineMeasuredStates(int i, int i2) {
        return i | i2;
    }

    public static boolean computeFitSystemWindows(View view, Rect rect, Rect rect2) {
        Method method = sComputeFitSystemWindowsMethod;
        if (method == null) {
            return false;
        }
        try {
            return ((Boolean) method.invoke(view, new Object[]{rect, rect2})).booleanValue();
        } catch (Exception e) {
            Log.d(TAG, "Could not invoke computeFitSystemWindows", e);
            return false;
        }
    }

    /* access modifiers changed from: private */
    public static void getComputeFitSystemWindowsMethod() {
        Class<Rect> cls = Rect.class;
        try {
            Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", new Class[]{cls, cls});
            sComputeFitSystemWindowsMethod = declaredMethod;
            if (!declaredMethod.isAccessible()) {
                sComputeFitSystemWindowsMethod.setAccessible(true);
            }
        } catch (NoSuchMethodException unused) {
            Log.d(TAG, "Could not find method computeFitSystemWindows. Oh well.");
        }
    }

    /* access modifiers changed from: private */
    public static void getMakeOptionalFitsSystemWindowsMethod() {
        try {
            Method method = View.class.getMethod("makeOptionalFitsSystemWindows", (Class[]) null);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            sMakeOptionalFitsSystemWindowsMethod = method;
        } catch (NoSuchMethodException unused) {
            Log.d(TAG, "Could not find method makeOptionalFitsSystemWindows. Oh well...");
        }
    }

    public static void init() {
        if (sComputeFitSystemWindowsMethod == null || sMakeOptionalFitsSystemWindowsMethod == null) {
            int i = sInitState;
            if (i == 2 || i == 0) {
                new InitThread().start();
                sInitState = 1;
            }
        }
    }

    public static boolean isLayoutRtl(View view) {
        return ViewCompat.z(view) == 1;
    }

    public static void makeOptionalFitsSystemWindows(final View view) {
        try {
            Method method = sMakeOptionalFitsSystemWindowsMethod;
            if (method == null) {
                if (sInitState == 2) {
                    new InitThread().run();
                }
                new Handler().postAtFrontOfQueue(new Runnable() {
                    public void run() {
                        ViewUtils.makeOptionalFitsSystemWindows(view);
                    }
                });
                return;
            }
            method.invoke(view, (Object[]) null);
        } catch (InvocationTargetException e) {
            Log.d(TAG, "Could not invoke makeOptionalFitsSystemWindows", e.getTargetException());
        } catch (IllegalAccessException e2) {
            Log.d(TAG, "Could not invoke makeOptionalFitsSystemWindows", e2);
        }
    }
}
