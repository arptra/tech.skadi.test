package com.upuphone.starrynet.core.ble.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.upuphone.starrynet.common.StLog;

public class MessageHandlerThread extends HandlerThread {
    private static final int DUR_TIME = 7200000;
    private static final int MSG_EMPTY_MSG = 1;
    /* access modifiers changed from: private */
    public Handler mHandler;

    public MessageHandlerThread(String str) {
        super(str);
    }

    public void init() {
        AnonymousClass1 r0 = new Handler(getLooper()) {
            public void handleMessage(Message message) {
                MessageHandlerThread.this.mHandler.sendEmptyMessageDelayed(1, 7200000);
            }
        };
        this.mHandler = r0;
        r0.sendEmptyMessageDelayed(1, 7200000);
    }

    public void run() {
        try {
            if (Looper.myLooper() != null) {
                StLog.d("MessageHandlerThread", "looper is not when run start");
            } else {
                super.run();
            }
        } catch (Exception e) {
            StLog.e("MessageHandlerThread", "run exception", (Throwable) e);
            throw new RuntimeException(getName(), e);
        }
    }

    public synchronized void start() {
        super.start();
        init();
    }

    public MessageHandlerThread(String str, int i) {
        super(str, i);
    }
}
