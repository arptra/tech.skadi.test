package com.share.connect.utils;

import android.util.ArrayMap;
import com.easy.logger.EasyLog;

public class DebugTools {

    /* renamed from: a  reason: collision with root package name */
    public static final ArrayMap f9917a = new ArrayMap();

    public static void a(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        ArrayMap arrayMap = f9917a;
        synchronized (arrayMap) {
            try {
                if (arrayMap.containsKey(str)) {
                    Object remove = arrayMap.remove(str);
                    if (remove != null) {
                        EasyLog.a("DebugTools", "Event: " + str + " cost " + (currentTimeMillis - ((Long) remove).longValue()) + " ms.");
                    }
                } else {
                    EasyLog.i("DebugTools", "Event: " + str + " not exist.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void b(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        EasyLog.a("DebugTools", "Event: " + str + " start.");
        ArrayMap arrayMap = f9917a;
        synchronized (arrayMap) {
            arrayMap.put(str, Long.valueOf(currentTimeMillis));
        }
    }
}
