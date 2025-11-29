package flyme.support.v7.widget;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.PopupWindow;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ListPopupWindow extends androidx.appcompat.widget.ListPopupWindow {
    public static final int FLYME_ANIMATION_AUTO_FIT = 0;
    public static final int FLYME_ANIMATION_CENTER_BOTTOM = 6;
    public static final int FLYME_ANIMATION_CENTER_TOP = 5;
    public static final int FLYME_ANIMATION_LEFT_BOTTOM = 2;
    public static final int FLYME_ANIMATION_LEFT_TOP = 1;
    public static final int FLYME_ANIMATION_RIGHT_BOTTOM = 4;
    public static final int FLYME_ANIMATION_RIGHT_TOP = 3;
    private static Method sApplyFlymeAnimation;
    private static Field smPopupField;
    PopupWindow mPopup;

    static {
        try {
            Field declaredField = androidx.appcompat.widget.ListPopupWindow.class.getDeclaredField("mPopup");
            smPopupField = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException unused) {
        }
        try {
            Method method = PopupWindow.class.getMethod("applyFlymeAnimation", new Class[]{Integer.TYPE});
            sApplyFlymeAnimation = method;
            method.setAccessible(true);
        } catch (NoSuchMethodException unused2) {
        }
    }

    public ListPopupWindow(@NonNull Context context) {
        this(context, (AttributeSet) null, R.attr.listPopupWindowStyle);
    }

    private void setPopupClipToScreenEnabled(boolean z) {
    }

    public void applyFlymeAnimation(int i) {
        Method method;
        PopupWindow popupWindow = this.mPopup;
        if (popupWindow != null && (method = sApplyFlymeAnimation) != null) {
            try {
                method.invoke(popupWindow, new Object[]{Integer.valueOf(i)});
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void setClipToScreenEnabled(boolean z) {
        setPopupClipToScreenEnabled(z);
    }

    public void setClippingEnabled(boolean z) {
        PopupWindow popupWindow = this.mPopup;
        if (popupWindow != null) {
            popupWindow.setClippingEnabled(z);
        }
    }

    public void show() {
        this.mPopup.setInputMethodMode(0);
        super.show();
        View view = (View) getListView().getParent();
        if (view != null) {
            view.setOutlineProvider(new ViewOutlineProvider() {
                public void getOutline(View view, Outline outline) {
                    float f;
                    Drawable background = ListPopupWindow.this.getBackground();
                    if (background != null) {
                        Outline outline2 = new Outline();
                        background.getOutline(outline2);
                        f = outline2.getRadius();
                    } else {
                        f = 0.0f;
                    }
                    outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), f);
                }
            });
            view.setClipToOutline(true);
        }
    }

    public ListPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        this(context, attributeSet, i, 0);
    }

    public ListPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        try {
            this.mPopup = (PopupWindow) smPopupField.get(this);
        } catch (Exception unused) {
        }
    }
}
