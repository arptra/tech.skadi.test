package com.upuphone.runasone.relay.lib.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.IBinder;
import com.upuphone.runasone.relay.StarryTag;
import com.upuphone.runasone.relay.api.IntentKey;
import com.upuphone.runasone.uupcast.CaptureType;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicInteger;

public class UtilUse {
    private static AtomicInteger msgId = new AtomicInteger(1);

    public static void bindService(final Context context, String str, String str2, byte[] bArr) throws Exception {
        Intent intent = new Intent();
        intent.setAction(str2);
        intent.setPackage(str);
        intent.putExtra(IntentKey.ACTIVITY.ACTION_KEY, bArr);
        context.bindService(intent, new ServiceConnection() {
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                context.unbindService(this);
            }

            public void onServiceDisconnected(ComponentName componentName) {
            }
        }, 1);
    }

    public static void fatherToChild(Object obj, Object obj2) {
        if (obj2.getClass().getSuperclass() != obj.getClass()) {
            System.err.println("child不是father的子类");
        }
        Class<?> cls = obj.getClass();
        for (Field field : cls.getDeclaredFields()) {
            field.getType();
            try {
                field.set(obj2, cls.getMethod("get" + upperHeadChar(field.getName()), (Class[]) null).invoke(obj, (Object[]) null));
            } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getDevAuc(String str, String str2, String str3) {
        return str + "%" + str2 + "%" + str3;
    }

    public static StarryTag getStarryTag(String str) {
        String[] split = str.split("%");
        return split.length == 2 ? new StarryTag(split[0], split[1], "") : new StarryTag(split[0], split[1], split[2]);
    }

    public static String getUniqueKey() {
        if (msgId.intValue() == Integer.MAX_VALUE) {
            msgId.set(1);
        }
        return msgId.incrementAndGet() + "";
    }

    public static int getUniqueKeyAir() {
        if (msgId.intValue() == Integer.MAX_VALUE) {
            msgId.set(1);
        }
        return msgId.incrementAndGet();
    }

    public static boolean isAppUniteCodeSame(String str, String str2) {
        return str2 == null || str2.length() == 0 || str2.equals(str);
    }

    public static boolean isStarryTagNull(StarryTag starryTag) {
        if (starryTag == null) {
            LogUtil.w("------StarryTag is Null------");
            return true;
        } else if (starryTag.getDeviceId() == null || starryTag.getDeviceId().length() == 0) {
            LogUtil.w("------DeviceId is Null------");
            return true;
        } else if (starryTag.getSendAppUniteCode() != null && starryTag.getSendAppUniteCode().length() != 0) {
            return false;
        } else {
            LogUtil.w("------SendAppUniteCode is Null------");
            return true;
        }
    }

    public static void openActivityWithParams(Context context, String str, String str2, byte[] bArr) throws Exception {
        Intent intent = new Intent(str2, Uri.parse("run_as_one://" + str));
        intent.addCategory("android.intent.category.RELAY_OPEN");
        intent.putExtra(IntentKey.ACTIVITY.ACTION_KEY, bArr);
        intent.setFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
        context.startActivity(intent);
    }

    public static void openApplication(Context context, String str, byte[] bArr) throws Exception {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (bArr != null) {
            launchIntentForPackage.putExtra(IntentKey.ACTIVITY.ACTION_KEY, bArr);
        }
        context.startActivity(launchIntentForPackage);
    }

    public static void startService(Context context, String str, String str2, String str3, byte[] bArr) throws Exception {
        ComponentName componentName = new ComponentName(str, str2);
        Intent intent = new Intent();
        intent.setComponent(componentName);
        intent.putExtra(IntentKey.ACTIVITY.ACTION_KEY, bArr);
        intent.setAction(str3);
        context.startForegroundService(intent);
    }

    private static String upperHeadChar(String str) {
        String substring = str.substring(0, 1);
        return substring.toUpperCase() + str.substring(1, str.length());
    }

    public static String getDevAuc(StarryTag starryTag) {
        return getDevAuc(starryTag.getDeviceId(), starryTag.getSendAppUniteCode(), starryTag.getReceiveAppUniteCode());
    }
}
