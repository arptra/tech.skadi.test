package com.upuphone.starrynet.common.utils;

import android.os.HandlerThread;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.upuphone.starrynet.common.StLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class HandlerThreadUtil {
    private static final String TAG = "HandlerThreadUtil";
    private final Map<String, HandlerThread> mThreadMap;

    public static final class Holder {
        static final HandlerThreadUtil INSTANCE = new HandlerThreadUtil();

        private Holder() {
        }
    }

    public static HandlerThreadUtil getInstance() {
        return Holder.INSTANCE;
    }

    private boolean isThreadAlive(HandlerThread handlerThread) {
        return handlerThread != null && handlerThread.isAlive();
    }

    public Looper getLooper(@NonNull String str) {
        return getLooper(str, 0);
    }

    public boolean quitThread(@NonNull String str) {
        HandlerThread handlerThread = this.mThreadMap.get(str);
        if (handlerThread == null) {
            return false;
        }
        String str2 = TAG;
        StLog.d(str2, "quit thread:" + str);
        this.mThreadMap.remove(str);
        return handlerThread.quitSafely();
    }

    private HandlerThreadUtil() {
        this.mThreadMap = new ConcurrentHashMap();
    }

    public Looper getLooper(@NonNull String str, int i) {
        HandlerThread handlerThread = this.mThreadMap.get(str);
        if (isThreadAlive(handlerThread)) {
            return handlerThread.getLooper();
        }
        String str2 = TAG;
        StLog.d(str2, "create thread:" + str);
        HandlerThread handlerThread2 = new HandlerThread(str, i);
        this.mThreadMap.put(str, handlerThread2);
        handlerThread2.start();
        return handlerThread2.getLooper();
    }
}
