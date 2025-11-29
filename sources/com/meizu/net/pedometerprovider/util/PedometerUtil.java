package com.meizu.net.pedometerprovider.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import com.meizu.net.pedometerprovider.R;
import com.meizu.net.pedometerprovider.util.Constants;
import java.util.List;
import java.util.regex.Pattern;

public class PedometerUtil {
    public static final String ACTION_ADD_SHORTCUT = "com.android.launcher.action.INSTALL_SHORTCUT";
    public static final String ACTION_DELETE_SHORTCUT = "com.meizu.flyme.launcher.action.UNINSTALL_SHORTCUT";
    private static final int CODE_01 = 1;
    private static final String FLYME_ACCOUNT_ACTION = "com.meizu.account.ACCOUNTCENTER";
    private static final String MAP_NAME = "com.meizu.net.map";
    public static final String PACKAGE_NAME = "com.meizu.net.pedometer";
    public static String PEDO_SHUTCUT_NAME = "魅族计步";
    private static final String PNAME = "com.meizu.net.pedometer";
    public static final String SHORTCUT_ACTION = "com.meizu.net.pedometer.action_main_page";
    public static final String SHORTCUT_CLASS_NAME = "com.meizu.net.pedometer.ui.PedometerMainActivity";
    public static final String WALLET_PNAME = "com.meizu.flyme.wallet";
    private static final int WALLET_VCODE = 300;
    private static Boolean sIsSupportPedo;

    public static void addPedoShortcut(Context context) {
        Context applicationContext = context.getApplicationContext();
        Intent intent = new Intent(ACTION_ADD_SHORTCUT);
        intent.putExtra("duplicate", false);
        intent.putExtra("android.intent.extra.shortcut.NAME", PEDO_SHUTCUT_NAME);
        intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(applicationContext, R.drawable.pedo_icon));
        intent.putExtra("android.intent.extra.shortcut.INTENT", createPedoIntent());
        applicationContext.sendBroadcast(intent);
    }

    public static boolean checkPedoExist(Context context) {
        if (getPedoVcode(context) >= 0) {
            return true;
        }
        startPedoMStore(context);
        return false;
    }

    public static float convertStep2Distance(int i) {
        return ((float) i) * 0.68f;
    }

    private static Intent createPedoIntent() {
        Intent intent = new Intent("com.meizu.net.pedometer.action_main_page");
        intent.setClassName("com.meizu.net.pedometer", SHORTCUT_CLASS_NAME);
        intent.putExtra(Constants.Action.ACTION_MAIN_PAGE_FLAG, Constants.PEDOMETER_MAINPAGE_LAUNCHER);
        return intent;
    }

    public static void deletePedoShortcut(Context context) {
        Context applicationContext = context.getApplicationContext();
        Intent intent = new Intent(ACTION_DELETE_SHORTCUT);
        intent.putExtra("android.intent.extra.shortcut.NAME", PEDO_SHUTCUT_NAME);
        intent.putExtra("android.intent.extra.shortcut.INTENT", createPedoIntent());
        applicationContext.sendBroadcast(intent);
    }

    public static String getAuthorityFromPermission(Context context) {
        Context applicationContext = context.getApplicationContext();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        PackageManager packageManager = applicationContext.getPackageManager();
        ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
        if (resolveActivity == null) {
            return null;
        }
        ActivityInfo activityInfo = resolveActivity.activityInfo;
        List<ProviderInfo> queryContentProviders = packageManager.queryContentProviders(activityInfo.packageName, activityInfo.applicationInfo.uid, 8);
        if (queryContentProviders != null) {
            for (int i = 0; i < queryContentProviders.size(); i++) {
                ProviderInfo providerInfo = queryContentProviders.get(i);
                String str = providerInfo.readPermission;
                if (str != null && Pattern.matches(".*launcher.*READ_SETTINGS", str)) {
                    return providerInfo.authority;
                }
            }
        }
        return null;
    }

    private static int getMzMapVcode(Context context) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(MAP_NAME, 16384);
        } catch (Exception e) {
            e.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo != null) {
            return packageInfo.versionCode;
        }
        return -1;
    }

    private static int getMzPedoVcode(Context context) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo("com.meizu.net.pedometer", 16384);
        } catch (Exception e) {
            e.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo != null) {
            return packageInfo.versionCode;
        }
        return -1;
    }

    public static int getPedoVcode(Context context) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo("com.meizu.net.pedometer", 16384);
        } catch (Exception e) {
            e.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo != null) {
            return packageInfo.versionCode;
        }
        return -1;
    }

    public static int getWalletVcode(Context context) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(WALLET_PNAME, 16384);
        } catch (Exception e) {
            e.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo != null) {
            return packageInfo.versionCode;
        }
        return -1;
    }

    public static boolean hasPedoShortcut(Context context) {
        Context applicationContext = context.getApplicationContext();
        String authorityFromPermission = getAuthorityFromPermission(applicationContext);
        if (authorityFromPermission == null) {
            return false;
        }
        try {
            Uri parse = Uri.parse("content://" + authorityFromPermission + "/favorites?notify=true");
            Cursor query = applicationContext.getContentResolver().query(parse, (String[]) null, "intent like ?", new String[]{"%component=com.meizu.net.pedometer/" + ".ui.PedometerMainActivity" + ";%"}, (String) null);
            if (query != null) {
                boolean z = query.getCount() > 0;
                query.close();
                return z;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isPedoSupport(Context context) {
        if (sIsSupportPedo == null) {
            sIsSupportPedo = Boolean.valueOf(isSensorOpen(context));
        }
        return sIsSupportPedo.booleanValue();
    }

    public static boolean isSensorOpen(Context context) {
        return ((SensorManager) context.getApplicationContext().getSystemService("sensor")).getDefaultSensor(19) != null;
    }

    public static void openWallet(Context context, String str) {
        if (getWalletVcode(context) < 300) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(String.format("market://details?id=%s", new Object[]{WALLET_PNAME})));
            intent.setPackage("com.meizu.mstore");
            intent.putExtra("source_apkname", context.getPackageName());
            intent.putExtra("source_info", "/insurance/step");
            try {
                context.startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void startFlymeCount(Context context) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(FLYME_ACCOUNT_ACTION);
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
        if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
            try {
                context.startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void startPedoCalendar(Context context) {
        if (context != null && getMzPedoVcode(context) >= 1) {
            context.startActivity(new Intent(Constants.Action.ACTION_PEDO_CALENDAR));
        }
    }

    private static void startPedoMStore(Context context) {
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(String.format("market://details?id=%s", new Object[]{"com.meizu.net.pedometer"}))));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void startPedoMainPage(Context context, String str) {
        if (context != null && getMzPedoVcode(context) >= 1) {
            Intent intent = new Intent("com.meizu.net.pedometer.action_main_page");
            intent.putExtra(Constants.Action.ACTION_MAIN_PAGE_FLAG, str);
            if (context instanceof Activity) {
                intent.putExtra(Constants.Action.ACTION_TASK_ID_FROM_WALLET, ((Activity) context).getTaskId());
            }
            context.startActivity(intent);
        }
    }

    public static void startPedoPersonalCenter(Context context) {
        if (context != null && getMzPedoVcode(context) >= 1) {
            context.startActivity(new Intent(Constants.Action.ACTION_PEDO_PERSONAL_CENTER));
        }
    }

    public static void startPedoPersonalGuidePage(Activity activity) {
        if (activity != null && getMzPedoVcode(activity) >= 1) {
            Intent intent = new Intent(Constants.Action.ACTION_PEDO_PERSONAL_GUIDE);
            Bundle bundle = new Bundle();
            bundle.putParcelable("intent", activity.getIntent());
            intent.putExtras(bundle);
            activity.startActivity(intent);
        }
    }

    public static void startShareActivity(Context context, String str, int i, int i2, int i3, int i4, String str2, String str3) {
        if (context != null && getMzPedoVcode(context) >= 1) {
            Intent intent = new Intent(Constants.Action.ACTION_SHARE_STEPS);
            intent.putExtra(Constants.Action.PEDOMETER_SHARE_STEPS_WHOSE, str);
            intent.putExtra(Constants.Action.PEDOMETER_SHARE_STEPS_DAYS, i);
            intent.putExtra(Constants.Action.PEDOMETER_SHARE_STEPS_DATE, i2);
            intent.putExtra(Constants.Action.PEDOMETER_SHARE_STEPS_REAL, i3);
            intent.putExtra(Constants.Action.PEDOMETER_SHARE_STEPS_TARGET, i4);
            intent.putExtra(Constants.Action.PEDOMETER_SHARE_STEPS_DISTANCE, str2);
            intent.putExtra(Constants.Action.PEDOMETER_SHARE_STEPS_CALORIE, str3);
            context.startActivity(intent);
        }
    }
}
