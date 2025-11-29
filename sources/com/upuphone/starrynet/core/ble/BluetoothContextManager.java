package com.upuphone.starrynet.core.ble;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public class BluetoothContextManager {
    public static boolean isReleaseBuildType;
    private static Context mContext;
    public static HandlerThread mCoreBleThread;
    private static Handler mHandler;

    public static Context getContext() {
        return mContext;
    }

    public static Looper getCoreBleLooper() {
        return mCoreBleThread.getLooper();
    }

    public static String getCurrentMethodName() {
        return Thread.currentThread().getStackTrace()[4].getMethodName();
    }

    public static boolean isReleaseBuild() {
        return isReleaseBuildType;
    }

    public static void post(Runnable runnable) {
        postDelayed(runnable, 0);
    }

    public static void postDelayed(Runnable runnable, long j) {
        if (mHandler == null) {
            mHandler = new Handler(mCoreBleThread.getLooper());
        }
        mHandler.postDelayed(runnable, j);
    }

    public static void setContext(Context context, boolean z) {
        mContext = context.getApplicationContext();
        isReleaseBuildType = z;
        SystemActionObserver.getInstance().init(context);
        HandlerThread handlerThread = new HandlerThread("CORE-BLE");
        mCoreBleThread = handlerThread;
        handlerThread.start();
    }

    public String getName() {
        return getClass().getSimpleName();
    }
}
