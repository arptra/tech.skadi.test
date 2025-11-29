package com.upuphone.starrynet.core.ble.manager;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;

public final class BleReceiveMsgManager implements Handler.Callback {
    private static final int MSG_RECEIVE_DATA = 100;
    private static final int MSG_STICKY_DATA_DONE = 101;
    private Map<String, BleDataDispatcher> dispatcherMap;
    private Handler mDispatchHandler;
    private Handler mReceiveHandler;

    public static class Holder {
        static final BleReceiveMsgManager INSTANCE = new BleReceiveMsgManager();
    }

    public static BleReceiveMsgManager getInstance() {
        return Holder.INSTANCE;
    }

    public boolean handleMessage(@NonNull Message message) {
        int i = message.what;
        if (i == 100) {
            BleReceiveData bleReceiveData = (BleReceiveData) message.obj;
            makeInstance(bleReceiveData.getRemoteBleMac()).receiveBleData(bleReceiveData);
            return true;
        } else if (i != 101) {
            return false;
        } else {
            makeInstance((String) message.obj).stickyDataDone();
            return true;
        }
    }

    public BleDataDispatcher makeInstance(String str) {
        BleDataDispatcher bleDataDispatcher = this.dispatcherMap.get(str);
        if (bleDataDispatcher != null) {
            return bleDataDispatcher;
        }
        BleDataDispatcher bleDataDispatcher2 = new BleDataDispatcher(str, this.mReceiveHandler.getLooper(), this.mDispatchHandler.getLooper());
        this.dispatcherMap.put(str, bleDataDispatcher2);
        return bleDataDispatcher2;
    }

    public void notifyStickyDataDone(String str) {
        this.mDispatchHandler.sendMessage(this.mDispatchHandler.obtainMessage(101, str));
    }

    public void receiveBleData(BleReceiveData bleReceiveData) {
        this.mReceiveHandler.sendMessage(this.mReceiveHandler.obtainMessage(100, bleReceiveData));
    }

    public void registerBleDataReceiver(String str, IBleDataReceiver iBleDataReceiver) {
        makeInstance(str).addReceiver(iBleDataReceiver);
    }

    public void resetDispatcher(String str) {
        makeInstance(str).reset();
    }

    public void unregisterBleDataReceiver(String str, IBleDataReceiver iBleDataReceiver) {
        makeInstance(str).removeReceiver(iBleDataReceiver);
    }

    private BleReceiveMsgManager() {
        this.dispatcherMap = new HashMap();
        HandlerThread handlerThread = new HandlerThread("BleReceiveData");
        handlerThread.start();
        HandlerThread handlerThread2 = new HandlerThread("BleDispatchData");
        handlerThread2.setPriority(8);
        handlerThread2.start();
        this.mReceiveHandler = new Handler(handlerThread.getLooper(), this);
        this.mDispatchHandler = new Handler(handlerThread2.getLooper(), this);
    }

    public void notifyStickyDataDone(boolean z, String str, int i, byte[] bArr) {
        final String str2 = str;
        final boolean z2 = z;
        final int i2 = i;
        final byte[] bArr2 = bArr;
        this.mDispatchHandler.post(new Runnable() {
            public void run() {
                BleReceiveMsgManager.this.makeInstance(str2).stickyDoneWithData(z2, i2, bArr2);
            }
        });
    }
}
