package com.meizu.flyme.policy.sdk.util;

import android.content.Context;
import android.view.ViewGroup;
import flyme.support.v7.util.ResourceUtils;

public class SmartBarPaddingUtil {
    private static int sActionBarHeight = -1;
    private static int sStatusBarHeight = -1;

    public static int getActionBarHeight(Context context) {
        if (sActionBarHeight < 0) {
            sActionBarHeight = ResourceUtils.getAppCompatActionBarHeight(context);
        }
        return sActionBarHeight;
    }

    public static int getActionBarStatusBarHeight(Context context) {
        return getActionBarHeight(context) + getStatusBarHeight(context);
    }

    public static int getStatusBarHeight(Context context) {
        if (sStatusBarHeight < 0) {
            sStatusBarHeight = ResourceUtils.getStatusBarHeight(context);
        }
        return sStatusBarHeight;
    }

    public static void setPaddingActionBar(Context context, ViewGroup viewGroup) {
        viewGroup.setClipToPadding(false);
        viewGroup.setPadding(viewGroup.getPaddingLeft(), viewGroup.getPaddingTop() + getActionBarStatusBarHeight(context), viewGroup.getPaddingRight(), viewGroup.getPaddingBottom());
    }
}
