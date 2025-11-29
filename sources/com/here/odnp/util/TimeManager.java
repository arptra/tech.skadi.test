package com.here.odnp.util;

public class TimeManager {
    private static final String TAG = "odnp.util.TimeManager";
    private static ITimeManager mTimeManager;

    private TimeManager() {
    }

    public static long currentTimeMillis() {
        return getTimeManager().currentTimeMillis();
    }

    private static synchronized ITimeManager getTimeManager() {
        ITimeManager iTimeManager;
        synchronized (TimeManager.class) {
            try {
                if (mTimeManager == null) {
                    setTimeManager(new PlatformTimeManager());
                }
                iTimeManager = mTimeManager;
            } catch (Throwable th) {
                throw th;
            }
        }
        return iTimeManager;
    }

    public static synchronized void setTimeManager(ITimeManager iTimeManager) {
        synchronized (TimeManager.class) {
            Log.i(TAG, "setTimeManager", new Object[0]);
            mTimeManager = iTimeManager;
        }
    }

    public static long timeSinceBoot() {
        return getTimeManager().timeSinceBoot();
    }

    public static long uptimeMillis() {
        return getTimeManager().uptimeMillis();
    }
}
