package com.meizu.common.util;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import androidx.annotation.ColorRes;
import androidx.annotation.StyleRes;
import com.meizu.common.R;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class ResourceUtils {
    private static Field backgroundField = null;
    private static Class<?> cls = null;
    private static int mNightModeColor = -1;
    private static Integer sStatusBarHeight;
    private static Integer sStatusBarHeightResId;

    @SuppressLint({"NewApi"})
    public static void actionBarHomeAsUpOnScrolling(Activity activity, int i, int i2, boolean z, int i3, int i4, int i5) {
        if (activity != null) {
            Drawable drawable = activity.getResources().getDrawable(i);
            Drawable drawable2 = activity.getResources().getDrawable(i2);
            if (drawable != null && drawable2 != null) {
                if (i3 == i4) {
                    activity.getActionBar().setHomeAsUpIndicator(i);
                    return;
                }
                Drawable drawable3 = z ? drawable2 : drawable;
                activity.getActionBar().setHomeAsUpIndicator(drawable3);
                Rect rect = new Rect();
                drawable2.getPadding(rect);
                int intrinsicWidth = drawable.getIntrinsicWidth();
                float f = ((float) i3) / ((float) (i5 - i4));
                int intrinsicWidth2 = (int) ((((float) ((drawable2.getIntrinsicWidth() - rect.right) - intrinsicWidth)) * f) + ((float) intrinsicWidth));
                if (z) {
                    intrinsicWidth2 += rect.right;
                }
                TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(R.styleable.MZTheme);
                int i6 = obtainStyledAttributes.getInt(R.styleable.MZTheme_mzThemeColor, 3319271);
                obtainStyledAttributes.recycle();
                int gradualColor = getGradualColor(11053224, i6, f, 1);
                drawable3.setBounds(0, 0, intrinsicWidth2, drawable3.getIntrinsicHeight());
                drawable3.setColorFilter(new LightingColorFilter(0, gradualColor));
            }
        }
    }

    public static float dp2px(float f, Context context) {
        return TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public static int dp2pxOffset(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int getActionBarHeight(Context context) {
        TypedValue typedValue = new TypedValue();
        return context.getTheme().resolveAttribute(16843499, typedValue, true) ? TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics()) : context.getResources().getDimensionPixelSize(R.dimen.mz_action_bar_default_height);
    }

    public static ValueAnimator getBackgroundAnimation(final View view, int i, int i2) {
        int alpha = Color.alpha(i);
        if (alpha == 255 || alpha == 0) {
            i = Color.argb(20, Color.red(i), Color.green(i), Color.blue(i));
        }
        view.setHasTransientState(true);
        view.setBackgroundColor(i);
        ObjectAnimator ofInt = ObjectAnimator.ofInt(view, "backgroundColor", new int[]{i, i2});
        ofInt.setEvaluator(new ArgbEvaluator());
        ofInt.setDuration(1000);
        ofInt.setStartDelay(700);
        ofInt.addListener(new AnimatorListenerAdapter() {
            public void onAnimationCancel(Animator animator) {
                view.setBackgroundColor(0);
                view.setHasTransientState(false);
            }

            public void onAnimationEnd(Animator animator) {
                view.setBackgroundColor(0);
                view.setHasTransientState(false);
            }
        });
        return ofInt;
    }

    public static int getGradualColor(int i, int i2, float f, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int red = Color.red(i);
        int green = Color.green(i);
        int blue = Color.blue(i);
        int alpha = Color.alpha(i);
        int red2 = Color.red(i2);
        int green2 = Color.green(i2);
        int blue2 = Color.blue(i2);
        int alpha2 = Color.alpha(i2);
        if (i3 < 0) {
            i4 = Math.round(((float) red2) - (((float) (red2 - red)) * f));
            i7 = Math.round(((float) green2) - (((float) (green2 - green)) * f));
            i6 = Math.round(((float) blue2) - (((float) (blue2 - blue)) * f));
            i5 = Math.round(((float) alpha2) - (((float) (alpha2 - alpha)) * f));
        } else {
            i4 = Math.round(((float) red) + (((float) (red2 - red)) * f));
            i7 = Math.round(((float) green) + (((float) (green2 - green)) * f));
            i6 = Math.round(((float) blue) + (((float) (blue2 - blue)) * f));
            i5 = Math.round(((float) alpha) + (((float) (alpha2 - alpha)) * f));
        }
        return Color.argb(i5, i4, i7, i6);
    }

    public static int getIdentifier(Resources resources, String str, String str2, String str3) {
        if (!"android".equals(str3)) {
            return resources.getIdentifier(str, str2, str3);
        }
        return resources.getIdentifier("android:" + str2 + "/" + str, (String) null, (String) null);
    }

    public static int getIdentifierByAttrId(int i, Context context) {
        TypedValue obtainTypedValue = obtainTypedValue(i, context);
        if (obtainTypedValue == null) {
            return 0;
        }
        return obtainTypedValue.resourceId;
    }

    public static Integer getMzThemeColor(Context context) {
        int identifier = context.getResources().getIdentifier("mzThemeColor", "attr", context.getPackageName());
        if (identifier <= 0) {
            return null;
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{identifier});
        int color = obtainStyledAttributes.getColor(0, -1);
        obtainStyledAttributes.recycle();
        if (color == -1) {
            return null;
        }
        return Integer.valueOf(color);
    }

    public static int getNightModeColor(Context context) {
        try {
            if (mNightModeColor == -1) {
                mNightModeColor = context.getResources().getColor(Class.forName("com.flyme.internal.R$color").getField("mz_night_mode_popup_window_background").getInt((Object) null));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mNightModeColor;
    }

    public static int getStatusBarHeight(Context context) {
        try {
            if (sStatusBarHeightResId == null) {
                sStatusBarHeightResId = Integer.valueOf(getIdentifier(context.getResources(), "status_bar_height", "dimen", "android"));
            }
            return context.getResources().getDimensionPixelSize(sStatusBarHeightResId.intValue());
        } catch (Exception e) {
            Log.e("ResurceUtils", "get status bar height fail", e);
            return context.getResources().getDimensionPixelSize(R.dimen.status_bar_height);
        }
    }

    public static ArrayList<String> getStringArray(Context context, TypedArray typedArray, int i) {
        TypedValue typedValue = new TypedValue();
        if (!typedArray.getValue(i, typedValue)) {
            return null;
        }
        int i2 = typedValue.resourceId;
        if (i2 != 0) {
            TypedArray obtainTypedArray = context.getResources().obtainTypedArray(i2);
            int length = obtainTypedArray.length();
            ArrayList<String> arrayList = new ArrayList<>(length);
            for (int i3 = 0; i3 < length; i3++) {
                arrayList.add(obtainTypedArray.getString(i3));
            }
            obtainTypedArray.recycle();
            return arrayList;
        }
        throw new IllegalStateException("can't find the resourceId");
    }

    public static ColorStateList getThemeColorStateList(Context context, @ColorRes int i) {
        return context.getResources().getColorStateList(i, context.getTheme());
    }

    public static Context makeFlymeColorThemeContext(Context context, @StyleRes int i) {
        return (!(context instanceof ContextThemeWrapper) || getIdentifierByAttrId(R.attr.colorBrand, context) == 0) ? i != 0 ? new ContextThemeWrapper(context, i) : makeFlymeDefalutThemeContext(context) : context;
    }

    public static Context makeFlymeDefalutThemeContext(Context context) {
        if ((context instanceof ContextThemeWrapper) && getIdentifierByAttrId(R.attr.colorBrand, context) != 0) {
            return context;
        }
        int identifier = context.getResources().getIdentifier("Theme.Flyme.AppCompat.Light.Color.Blue", "style", context.getPackageName());
        if (identifier != 0) {
            return new ContextThemeWrapper(context, identifier);
        }
        Log.i("Common ResourceUtil", "can't find default style");
        return context;
    }

    private static TypedValue obtainTypedValue(int i, Context context) {
        TypedValue typedValue;
        Resources.Theme theme = context.getTheme();
        if (theme == null) {
            return null;
        }
        typedValue = new TypedValue();
        try {
            theme.resolveAttribute(i, typedValue, true);
            return typedValue;
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable unused) {
        }
        return typedValue;
    }

    public static float px2dip(Context context, float f) {
        return f / context.getResources().getDisplayMetrics().density;
    }

    public static int px2sp(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static float sp2px(float f, Context context) {
        return (float) ((int) ((f * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f));
    }

    public static void startBrightnessAnim(final Drawable drawable) {
        if (drawable == null) {
            return;
        }
        if (drawable instanceof ColorDrawable) {
            Log.i("error", "fade animation will not be useful to ColorDrawable because ColorDrawable has not implement method setColorFilter");
            return;
        }
        Rect bounds = drawable.getBounds();
        if (bounds == null || bounds.isEmpty()) {
            Log.i("error", "you should setBounds for drawable before start brightness anim");
            return;
        }
        final ColorMatrix colorMatrix = new ColorMatrix();
        ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{PropertyValuesHolder.ofKeyframe("", new Keyframe[]{Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.15f, 35.0f), Keyframe.ofFloat(1.0f, 0.0f)})});
        ofPropertyValuesHolder.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                colorMatrix.set(new float[]{1.0f, 0.0f, 0.0f, 0.0f, floatValue, 0.0f, 1.0f, 0.0f, 0.0f, floatValue, 0.0f, 0.0f, 1.0f, 0.0f, floatValue, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
                drawable.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
            }
        });
        ofPropertyValuesHolder.setDuration(550);
        ofPropertyValuesHolder.start();
    }
}
