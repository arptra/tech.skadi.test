package com.meizu.net.pedometerprovider.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

public class IntentUtil {
    public static final String ACTION_OPENWEB = "com.meizu.net.map_action_openWeb";
    public static final String ACTION_OPENWEB_NOBAR = "com.meizu.net.map_action_openWebNoBar";
    public static final String ACTION_START_SERVICE = "com.meizu.net.pedometer.start_service";
    public static final String ACTION_START_STEP = "com.meizu.net.pedometer.start_step";
    public static final String ACTION_STOP_STEP = "com.meizu.net.pedometer.stop_step";
    public static final String ACTION_STOP_UPDATE_WIDGET = "com.meizu.net.pedometer.stop_update_widget";
    public static final String ACTION_WAKEUP_SERVICE = "com.meizu.net.pedometer.wakeup_service";
    public static final String ACTIVITY_TITLE = "web_title";
    public static final String FULL_SCREEN = "full_screen";
    public static final String WEB_URL = "web_url";
    public static final String WINDOW_TYPE = "window_type";
    public static final int WINDOW_TYPE_FULLSCREEN = 2;
    public static final int WINDOW_TYPE_NORMAL = 0;
    public static final int WINDOW_TYPE_STBAR = 1;

    public static Intent createBusIntent(String str, String str2, int i) {
        Intent intent = new Intent(ACTION_OPENWEB);
        intent.putExtra(WEB_URL, str);
        intent.setClassName("com.meizu.net.map", "com.meizu.net.map.WebActivity");
        intent.putExtra(WINDOW_TYPE, i);
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra(ACTIVITY_TITLE, str2);
        }
        return intent;
    }

    public static void jumpLink(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str2));
                if (str == null) {
                    str = "com.meizu.media.life";
                }
                intent.putExtra("source", Constants.MZMAP_PACKAGE);
                intent.setPackage(str);
                intent.addCategory("android.intent.category.DEFAULT");
                context.startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void oPenWebActivity(Context context, String str, String str2, int i) {
        context.startActivity(createBusIntent(str, str2, i));
    }

    public static void openWeb(Context context, String str, String str2, int i) {
        if (i == 1) {
            oPenWebActivity(context, str, str2, 0);
        } else if (i == 0) {
            oPenWebActivity(context, str, str2, 2);
        } else {
            oPenWebActivity(context, str, str2, 1);
        }
    }

    public static void starService(Context context) {
        Intent intent = new Intent(ACTION_START_SERVICE);
        intent.setPackage(PedometerUtil.PACKAGE_NAME);
        context.startService(intent);
    }

    public static void startStepSensor(Context context) {
        Intent intent = new Intent(ACTION_START_STEP);
        intent.setPackage(PedometerUtil.PACKAGE_NAME);
        context.sendBroadcast(intent);
    }

    public static void stopService(Context context) {
        Intent intent = new Intent(ACTION_STOP_STEP);
        intent.setPackage(PedometerUtil.PACKAGE_NAME);
        context.startService(intent);
    }

    public static void stopStep(Context context) {
        Intent intent = new Intent(ACTION_STOP_STEP);
        intent.setPackage(PedometerUtil.PACKAGE_NAME);
        context.sendBroadcast(intent);
    }
}
