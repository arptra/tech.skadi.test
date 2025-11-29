package com.upuphone.runasone.channel;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.annotation.NonNull;
import com.upuphone.runasone.utils.LogUtil;

public abstract class AbstractLooperWorker {
    private static final int EVENT_START_WORKER = 4097;
    /* access modifiers changed from: private */
    public boolean bStart = false;
    private HandlerThread handlerThread;
    private Handler workHandler;
    /* access modifiers changed from: private */
    public String workName;

    public abstract void looperHandler(Message message);

    public abstract void looperStarted();

    public void sendEmptyMessageDelayed(int i, long j) {
        Handler handler = this.workHandler;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(i, j);
        }
    }

    public void sendMessage(Message message) {
        Handler handler = this.workHandler;
        if (handler != null) {
            handler.sendMessage(message);
        }
    }

    public void startWorker(String str) {
        this.workName = str;
        LogUtil.d("<" + this.workName + "> loopWorker start, workHandler:" + this.workHandler);
        if (this.workHandler == null) {
            HandlerThread handlerThread2 = new HandlerThread(this.workName);
            this.handlerThread = handlerThread2;
            handlerThread2.start();
            Handler handler = new Handler(this.handlerThread.getLooper(), new Handler.Callback() {
                public boolean handleMessage(@NonNull Message message) {
                    if (message.what != 4097) {
                        AbstractLooperWorker.this.looperHandler(message);
                        return false;
                    } else if (AbstractLooperWorker.this.bStart) {
                        return false;
                    } else {
                        LogUtil.d("<" + AbstractLooperWorker.this.workName + "> looperStarted ----> ");
                        AbstractLooperWorker.this.looperStarted();
                        boolean unused = AbstractLooperWorker.this.bStart = true;
                        return false;
                    }
                }
            });
            this.workHandler = handler;
            handler.sendEmptyMessage(4097);
        }
    }

    public void stopWorker() {
        LogUtil.d("<" + this.workName + "> loopWorker stop");
        Handler handler = this.workHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.workHandler = null;
        }
        HandlerThread handlerThread2 = this.handlerThread;
        if (handlerThread2 != null) {
            handlerThread2.quitSafely();
            this.handlerThread = null;
        }
    }
}
