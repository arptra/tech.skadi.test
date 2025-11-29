package com.upuphone.starrynet.core.ble.channel;

import android.os.Handler;
import android.os.Looper;
import com.upuphone.starrynet.core.ble.BluetoothContextManager;
import com.upuphone.starrynet.core.ble.utils.BluetoothLog;
import java.util.concurrent.TimeoutException;

public final class Timer {
    private TimerCallback mCallback;
    private Handler mHandler = new Handler(BluetoothContextManager.getCoreBleLooper());

    public static abstract class TimerCallback implements Runnable {
        private String name;

        public TimerCallback(String str) {
            this.name = str;
        }

        public String getName() {
            return this.name;
        }

        public abstract void onTimerCallback() throws TimeoutException;

        public abstract void resetCallback();

        public final void run() {
            BluetoothLog.log("Timer", "%s: Timer expired!!!", this.name);
            try {
                onTimerCallback();
            } catch (TimeoutException e) {
                BluetoothLog.e(e);
            }
            resetCallback();
        }
    }

    private Timer() {
    }

    public static Timer newInstance() {
        return new Timer();
    }

    public synchronized String getName() {
        try {
        } catch (Throwable th) {
            throw th;
        }
        return isRunning() ? this.mCallback.getName() : "";
    }

    public synchronized boolean isRunning() {
        return this.mCallback != null;
    }

    public synchronized void resetCallback() {
        this.mCallback = null;
    }

    public synchronized void start(TimerCallback timerCallback, long j) {
        try {
            this.mHandler.removeCallbacksAndMessages((Object) null);
            Looper myLooper = Looper.myLooper();
            if (myLooper == null) {
                myLooper = BluetoothContextManager.getCoreBleLooper();
            }
            Handler handler = new Handler(myLooper);
            this.mHandler = handler;
            handler.postDelayed(timerCallback, j);
            this.mCallback = timerCallback;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void stop() {
        this.mHandler.removeCallbacksAndMessages((Object) null);
        this.mCallback = null;
    }
}
