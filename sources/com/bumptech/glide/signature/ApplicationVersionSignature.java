package com.bumptech.glide.signature;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.bumptech.glide.load.Key;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class ApplicationVersionSignature {

    /* renamed from: a  reason: collision with root package name */
    public static final ConcurrentMap f2734a = new ConcurrentHashMap();

    public static PackageInfo a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("AppVersionSignature", "Cannot resolve info for" + context.getPackageName(), e);
            return null;
        }
    }

    public static String b(PackageInfo packageInfo) {
        return packageInfo != null ? String.valueOf(packageInfo.versionCode) : UUID.randomUUID().toString();
    }

    public static Key c(Context context) {
        String packageName = context.getPackageName();
        ConcurrentMap concurrentMap = f2734a;
        Key key = (Key) concurrentMap.get(packageName);
        if (key != null) {
            return key;
        }
        Key d = d(context);
        Key key2 = (Key) concurrentMap.putIfAbsent(packageName, d);
        return key2 == null ? d : key2;
    }

    public static Key d(Context context) {
        return new ObjectKey(b(a(context)));
    }
}
