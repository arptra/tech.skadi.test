package com.meizu.flyme.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import com.here.odnp.config.OdnpConfigStatic;

public class ContextBuilder {
    public static Context build(Context context, boolean z, boolean z2) {
        Configuration configuration = new Configuration(context.getResources().getConfiguration());
        if (z) {
            configuration.densityDpi = getSystemProperties("persist.sys.density", getSystemProperties("ro.sf.lcd_density", OdnpConfigStatic.UPLOAD_LOW_PRIORITY_DURATION_MINUTES).intValue()).intValue();
        }
        if (z2) {
            configuration.fontScale = 1.0f;
        }
        Context createConfigurationContext = context.createConfigurationContext(configuration);
        if (context instanceof Activity) {
            createConfigurationContext.setTheme(getThemeId((Activity) context, 0).intValue());
        }
        return createConfigurationContext;
    }

    public static Integer getSystemProperties(String str, int i) throws IllegalArgumentException {
        try {
            Class<?> forName = ReflectionCache.build().forName("android.os.SystemProperties");
            return (Integer) ReflectionCache.build().getMethod(forName, "getInt", String.class, Integer.TYPE).invoke(forName, new Object[]{str, Integer.valueOf(i)});
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception unused) {
            return Integer.valueOf(i);
        }
    }

    public static Integer getThemeId(Activity activity, int i) throws IllegalArgumentException {
        try {
            return (Integer) ReflectionCache.build().getMethod(Activity.class, "getThemeResId", new Class[0]).invoke(activity, (Object[]) null);
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception unused) {
            return Integer.valueOf(i);
        }
    }
}
