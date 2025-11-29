package androidx.core.widget;

import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

public final class PopupWindowCompat {

    @RequiresApi
    public static class Api23Impl {
        @DoNotInline
        public static boolean a(PopupWindow popupWindow) {
            return popupWindow.getOverlapAnchor();
        }

        @DoNotInline
        public static int b(PopupWindow popupWindow) {
            return popupWindow.getWindowLayoutType();
        }

        @DoNotInline
        public static void c(PopupWindow popupWindow, boolean z) {
            popupWindow.setOverlapAnchor(z);
        }

        @DoNotInline
        public static void d(PopupWindow popupWindow, int i) {
            popupWindow.setWindowLayoutType(i);
        }
    }

    public static boolean a(PopupWindow popupWindow) {
        return Api23Impl.a(popupWindow);
    }

    public static void b(PopupWindow popupWindow, boolean z) {
        Api23Impl.c(popupWindow, z);
    }

    public static void c(PopupWindow popupWindow, int i) {
        Api23Impl.d(popupWindow, i);
    }

    public static void d(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        popupWindow.showAsDropDown(view, i, i2, i3);
    }
}
