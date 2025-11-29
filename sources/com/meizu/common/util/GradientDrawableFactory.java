package com.meizu.common.util;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import com.meizu.common.R;

public class GradientDrawableFactory {
    public static int getDarkerColor(int i) {
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        fArr[1] = fArr[1] + 0.05f;
        fArr[2] = fArr[2] - 0.1f;
        return Color.HSVToColor(fArr);
    }

    public static int getDisableColor(int i) {
        return Color.argb(76, Color.red(i), Color.green(i), Color.blue(i));
    }

    public static int getLighterColor(int i) {
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        fArr[1] = fArr[1] - 0.05f;
        fArr[2] = fArr[2] + 0.1f;
        return Color.HSVToColor(fArr);
    }

    public static int getPressedColor(int i) {
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        fArr[2] = fArr[2] - 0.1f;
        return Color.HSVToColor(fArr);
    }

    public static StateListDrawable getRectStateListDrawable(Context context, int i) {
        return getRectStateListDrawable(context, getLighterColor(i), i);
    }

    public static Drawable getStateListDrawable(Context context, int i) {
        return getStateListDrawable(context, i, i);
    }

    public static void makeRoundRect(GradientDrawable gradientDrawable, int i) {
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius((float) i);
    }

    public static StateListDrawable getRectStateListDrawable(Context context, int i, int i2) {
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.BL_TR;
        GradientDrawable gradientDrawable = new GradientDrawable(orientation, new int[]{i, i2});
        GradientDrawable gradientDrawable2 = new GradientDrawable(orientation, new int[]{getPressedColor(i), getPressedColor(i2)});
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, gradientDrawable2);
        stateListDrawable.addState(new int[]{16842910}, gradientDrawable2);
        stateListDrawable.addState(new int[0], gradientDrawable);
        return stateListDrawable;
    }

    public static Drawable getStateListDrawable(Context context, int i, boolean z) {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.mz_cir_btn_redius_small);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.mz_label_panel_bnt_boder);
        GradientDrawable gradientDrawable = new GradientDrawable();
        makeRoundRect(gradientDrawable, dimensionPixelSize);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(context.getResources().getColor(R.color.mz_search_button_pressed_color));
        makeRoundRect(gradientDrawable2, dimensionPixelSize);
        if (z) {
            int color = context.getResources().getColor(R.color.mz_search_button_boder_color);
            gradientDrawable.setStroke(dimensionPixelSize2, color);
            gradientDrawable2.setStroke(dimensionPixelSize2, color);
        } else {
            gradientDrawable.setStroke(dimensionPixelSize2, i);
            gradientDrawable2.setStroke(dimensionPixelSize2, i);
        }
        Drawable drawable = context.getResources().getDrawable(R.drawable.mz_btn_corner_disable);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842910, -16842919}, gradientDrawable);
        stateListDrawable.addState(new int[]{16842910, 16842919}, gradientDrawable2);
        stateListDrawable.addState(new int[]{-16842910}, drawable);
        stateListDrawable.addState(new int[0], gradientDrawable);
        return stateListDrawable;
    }

    public static Drawable getStateListDrawable(int i, int i2, int i3) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        makeRoundRect(gradientDrawable, i3);
        makeRoundRect(gradientDrawable2, i3);
        gradientDrawable.setColor(i);
        gradientDrawable2.setColor(i2);
        gradientDrawable2.setColorFilter(i, PorterDuff.Mode.DARKEN);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842910, -16842919}, gradientDrawable);
        stateListDrawable.addState(new int[]{16842910, 16842919}, gradientDrawable2);
        stateListDrawable.addState(new int[0], gradientDrawable);
        return stateListDrawable;
    }

    public static Drawable getStateListDrawable(Context context, int i, int i2) {
        return getStateListDrawable(context, i, i2, context.getResources().getDimensionPixelSize(R.dimen.mz_cir_btn_radius_normal));
    }

    public static Drawable getStateListDrawable(Context context, int i, int i2, int i3) {
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.BL_TR;
        GradientDrawable gradientDrawable = new GradientDrawable(orientation, new int[]{i, i2});
        makeRoundRect(gradientDrawable, i3);
        GradientDrawable gradientDrawable2 = new GradientDrawable(orientation, new int[]{getPressedColor(i), getPressedColor(i2)});
        makeRoundRect(gradientDrawable2, i3);
        Drawable drawable = context.getResources().getDrawable(R.drawable.mz_btn_corner_disable);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842910, -16842919}, gradientDrawable);
        stateListDrawable.addState(new int[]{16842910, 16842919}, gradientDrawable2);
        stateListDrawable.addState(new int[]{-16842910}, drawable);
        stateListDrawable.addState(new int[0], gradientDrawable);
        return stateListDrawable;
    }
}
