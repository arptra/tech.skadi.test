package com.meizu.common.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Vibrator;
import android.preference.PreferenceActivity;
import android.provider.Settings;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.widget.ThemeUtils;
import com.meizu.common.R;
import com.upuphone.starrynet.common.StarryNetConstant;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.apache.commons.lang3.BooleanUtils;

public class CommonUtils {
    private static final String CLASS_NAME_BUILD_EXT = "android.os.BuildExt";
    private static final String CLASS_NAME_FLYME_FEATURE = "flyme.config.FlymeFeature";
    private static final String FIELD_FINGERPRINT_KEY = "SHELL_FINGERPRINT_KEY";
    private static final String FIELD_IS_CURVED_SCREEN = "SHELL_IS_CURVED_SCREEN";
    private static final String HARDWARE_HAPTIC_FEEDBACK_INTENSITY = "hardware_haptic_feedback_intensity";
    public static final String HQ1_XINNENGYUAN_PKG = "com.meizu.theme.hongqi1xinnengyuan";
    public static final String HQ2_JIENENGCHE_PKG = "com.meizu.theme.hongqi2jienengche";
    public static final String HQ3_JINKUIHUA_PKG = "com.meizu.theme.hongqi3jinkuihua";
    private static final String METHOD_PRODUCT_INTERNATIONAL = "isProductInternational";
    private static final String TAG = "CommonUtils";
    private static final int VIBRATION_INTENSITY_OFF = 0;
    private static Boolean isFlymeOS;
    private static Boolean isFlymeOS4;
    private static Method mMethodGetString;
    private static Vibrator mVibrator;
    private static Class sBuildExtCls;
    private static Class sFlymeFeatureCls;
    private static Boolean sIsFlymeRom;
    private static Method sIsProductInternationalMethod;
    private static Field sShellFingerprintKeyField;
    private static Field sShellOsCurvedScreen;
    private static Class<?> scrollBarDrawableClass;
    private static Field scrollBarField;
    private static Field scrollCacheField;
    private static Class<?> scrollCacheFieldClass;
    private static Method setVerticalThumbDrawableMethod;
    private static Field shellHapticFeedBackMotor;
    private static Class<?> viewClass;

    public static boolean PreferenceActivity_setActionBarToTop(PreferenceActivity preferenceActivity, boolean z) {
        return false;
    }

    public static boolean TextView_setEmojiAlphaEnabled(TextView textView, boolean z) {
        if (!isFlymeOS()) {
            return false;
        }
        try {
            Class.forName("android.widget.TextView").getMethod("setEmojiAlphaEnabled", new Class[]{Boolean.TYPE}).invoke(textView, new Object[]{Boolean.valueOf(z)});
            return true;
        } catch (Exception unused) {
            Log.e(TAG, "TextView.setEmojiAlphaEnabled fail to be invoked!");
            return false;
        }
    }

    public static boolean TextView_startSelectionActionMode(TextView textView) {
        if (!isFlymeOS()) {
            return false;
        }
        try {
            return ((Boolean) Class.forName("android.widget.TextView").getMethod("startSelectionActionMode", (Class[]) null).invoke(textView, (Object[]) null)).booleanValue();
        } catch (Exception unused) {
            Log.e(TAG, "TextView.startSelectionActionMode fail to be invoked!");
            return false;
        }
    }

    public static void disableDarkMode(View view) {
        try {
            ReflectUtils.from((Class<?>) View.class).method("actInMzNightMode", Integer.TYPE).invoke(view, 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getApplyThemePackageName(Context context) {
        try {
            return Settings.System.getString(context.getContentResolver(), "current_apply_theme_pkg_name");
        } catch (Exception e) {
            Log.w(TAG, "has an error:" + e);
            return "";
        }
    }

    public static String getDeviceName() {
        String deviceName = getDeviceName("ro.product.flyme.model");
        return TextUtils.isEmpty(deviceName) ? getDeviceName("ro.vendor.product.flyme.model") : deviceName;
    }

    public static int getHQPrimaryColor(Context context) {
        String applyThemePackageName = getApplyThemePackageName(context);
        return HQ1_XINNENGYUAN_PKG.equals(applyThemePackageName) ? context.getColor(R.color.fd_sys_color_primary_hongqi) : HQ2_JIENENGCHE_PKG.equals(applyThemePackageName) ? context.getColor(R.color.fd_sys_color_primary_hongqi2) : HQ3_JINKUIHUA_PKG.equals(applyThemePackageName) ? context.getColor(R.color.fd_sys_color_primary_hongqi3) : ThemeUtils.c(context, R.attr.colorPrimary);
    }

    public static int getShowNavigationBarValue(Context context, int i) {
        return Settings.System.getInt(context.getContentResolver(), "mz_show_navigation_bar", i);
    }

    public static String getSystemProperties(String str) {
        Class<Build> cls = Build.class;
        try {
            if (mMethodGetString == null) {
                Method declaredMethod = cls.getDeclaredMethod("getString", new Class[]{String.class});
                mMethodGetString = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            return (String) mMethodGetString.invoke((Object) null, new Object[]{str});
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean hasFlymeFeature(Field field) {
        return hasFlymeFeature();
    }

    public static boolean hasFullDisplay() {
        boolean z;
        try {
            if (sFlymeFeatureCls == null) {
                sFlymeFeatureCls = Class.forName(CLASS_NAME_FLYME_FEATURE);
            }
            if (sShellFingerprintKeyField == null) {
                sShellFingerprintKeyField = sFlymeFeatureCls.getDeclaredField(FIELD_FINGERPRINT_KEY);
            }
            z = sShellFingerprintKeyField.getBoolean((Object) null);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
            z = true;
        }
        return true ^ z;
    }

    public static boolean isCurvedScreen() {
        try {
            if (sFlymeFeatureCls == null) {
                sFlymeFeatureCls = Class.forName(CLASS_NAME_FLYME_FEATURE);
            }
            if (sShellOsCurvedScreen == null) {
                sShellOsCurvedScreen = sFlymeFeatureCls.getDeclaredField(FIELD_IS_CURVED_SCREEN);
            }
            return sShellOsCurvedScreen.getBoolean((Object) null);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
            return true;
        }
    }

    public static boolean isFlymeOS() {
        try {
            Boolean bool = isFlymeOS;
            if (bool != null) {
                return bool.booleanValue();
            }
            if (isFlymeOS4()) {
                isFlymeOS = Boolean.TRUE;
            } else {
                isFlymeOS = Boolean.FALSE;
            }
            return isFlymeOS.booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isFlymeOS4() {
        try {
            Boolean bool = isFlymeOS4;
            if (bool != null) {
                return bool.booleanValue();
            }
            String str = Build.DISPLAY;
            String systemProperties = getSystemProperties(CommonConstants.BUILD_DESCRIPTION);
            if (!str.startsWith("Flyme OS 4")) {
                if (systemProperties == null || !systemProperties.matches(CommonConstants.IS_FLYME_OS_4_MATCH)) {
                    isFlymeOS4 = Boolean.FALSE;
                    return isFlymeOS4.booleanValue();
                }
            }
            isFlymeOS4 = Boolean.TRUE;
            return isFlymeOS4.booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isFlymeRom() {
        Class<String> cls = String.class;
        if (sIsFlymeRom == null) {
            try {
                String obj = Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{cls, cls}).invoke((Object) null, new Object[]{"ro.meizu.rom.config", StarryNetConstant.DEVICE_NAME_UNKNOWN}).toString();
                if (obj == null || !obj.equals(BooleanUtils.TRUE)) {
                    sIsFlymeRom = Boolean.FALSE;
                } else {
                    sIsFlymeRom = Boolean.TRUE;
                }
            } catch (Exception e) {
                Log.e(TAG, "CommonUtil.isFlymeRom() fail to be invoked!");
                e.printStackTrace();
                sIsFlymeRom = Boolean.FALSE;
            }
        }
        return sIsFlymeRom.booleanValue();
    }

    public static boolean isHongQiSystem() {
        return "fawhq".equals(getSystemProperties("ro.flyme.build.channel"));
    }

    public static boolean isHongQiTheme(String str) {
        return HQ1_XINNENGYUAN_PKG.equals(str) || HQ2_JIENENGCHE_PKG.equals(str) || HQ3_JINKUIHUA_PKG.equals(str);
    }

    public static boolean isProductInternational() {
        try {
            if (sBuildExtCls == null) {
                sBuildExtCls = Class.forName(CLASS_NAME_BUILD_EXT);
            }
            if (sIsProductInternationalMethod == null) {
                sIsProductInternationalMethod = sBuildExtCls.getDeclaredMethod(METHOD_PRODUCT_INTERNATIONAL, (Class[]) null);
            }
            return ((Boolean) sIsProductInternationalMethod.invoke(sBuildExtCls, (Object[]) null)).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isShowNavigationBar(Context context) {
        return getShowNavigationBarValue(context, (hasFullDisplay() || isProductInternational()) ? 1 : 0) == 1;
    }

    public static boolean setDarkStatusBarIcon(Window window, boolean z) {
        return false;
    }

    public static void setScrollBarThumbVertical(View view, int i) {
        try {
            if (viewClass == null) {
                viewClass = Class.forName("android.view.View");
            }
            if (scrollCacheField == null) {
                Field declaredField = viewClass.getDeclaredField("mScrollCache");
                scrollCacheField = declaredField;
                declaredField.setAccessible(true);
            }
            if (scrollCacheFieldClass == null) {
                scrollCacheFieldClass = Class.forName(scrollCacheField.get(view).getClass().getName());
            }
            if (scrollBarField == null) {
                Field declaredField2 = scrollCacheFieldClass.getDeclaredField("scrollBar");
                scrollBarField = declaredField2;
                declaredField2.setAccessible(true);
            }
            if (scrollBarDrawableClass == null) {
                scrollBarDrawableClass = Class.forName(scrollBarField.get(scrollCacheField.get(view)).getClass().getName());
            }
            if (setVerticalThumbDrawableMethod == null) {
                setVerticalThumbDrawableMethod = scrollBarDrawableClass.getMethod("setVerticalThumbDrawable", new Class[]{Drawable.class});
            }
            setVerticalThumbDrawableMethod.invoke(scrollBarField.get(scrollCacheField.get(view)), new Object[]{view.getContext().getResources().getDrawable(i)});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void shakeForFlymeFeature(View view) {
        shakeForFlymeFeature(view, 20120);
    }

    public SpannableStringBuilder createSpannableStringBuilder(CharSequence charSequence, int i, int i2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        if (charSequence != null) {
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(i, true), 0, charSequence.length(), 34);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i2), 0, charSequence.length(), 34);
        }
        return spannableStringBuilder;
    }

    public static boolean hasFlymeFeature() {
        try {
            if (shellHapticFeedBackMotor == null) {
                Class<?> cls = Class.forName(CLASS_NAME_FLYME_FEATURE);
                String deviceName = getDeviceName();
                if ("m2392".equalsIgnoreCase(deviceName)) {
                    shellHapticFeedBackMotor = cls.getDeclaredField("SUPPORT_AAC_RICHTAP");
                } else if ("m2172".equalsIgnoreCase(deviceName)) {
                    shellHapticFeedBackMotor = cls.getDeclaredField("USE_QCOM_VIBRATE");
                } else {
                    shellHapticFeedBackMotor = cls.getDeclaredField("SHELL_HAPTICFEEDBACK_MOTOR");
                }
            }
            return shellHapticFeedBackMotor.getBoolean((Object) null);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void shakeForFlymeFeature(View view, int i) {
        String deviceName = getDeviceName();
        if (hasFlymeFeature() || "m2392".equalsIgnoreCase(deviceName)) {
            view.performHapticFeedback(i);
        }
    }

    public static String getDeviceName(String str) {
        Class<String> cls = String.class;
        try {
            return (String) ReflectUtils.from("android.os.SystemProperties").method("get", cls, cls).invoke((Object) null, str, null);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
