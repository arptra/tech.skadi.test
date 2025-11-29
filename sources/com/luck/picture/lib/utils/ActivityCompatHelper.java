package com.luck.picture.lib.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import androidx.fragment.app.FragmentActivity;

public class ActivityCompatHelper {
    public static boolean a(Context context) {
        if (context instanceof Activity) {
            return !c((Activity) context);
        }
        if (context instanceof ContextWrapper) {
            ContextWrapper contextWrapper = (ContextWrapper) context;
            if (contextWrapper.getBaseContext() instanceof Activity) {
                return !c((Activity) contextWrapper.getBaseContext());
            }
        }
        return true;
    }

    public static boolean b(FragmentActivity fragmentActivity, String str) {
        return !c(fragmentActivity) && fragmentActivity.getSupportFragmentManager().p0(str) == null;
    }

    public static boolean c(Activity activity) {
        return activity == null || activity.isFinishing() || activity.isDestroyed();
    }
}
