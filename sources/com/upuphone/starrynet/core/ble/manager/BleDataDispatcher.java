package com.upuphone.starrynet.core.ble.manager;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.honey.account.constant.AccountConstantKt;
import com.honey.account.w6.a;
import com.upuphone.starrynet.core.ble.utils.BluetoothLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

public class BleDataDispatcher implements Handler.Callback {
    private static final boolean DETAIL_LOG = true;
    private static final int MSG_ADD_DATA = 202;
    private static final int MSG_DEAL_WITH_DATA = 200;
    private static final int MSG_WAIT_TIMEOUT = 201;
    private static final String TAG = "BleDataDispatcher";
    private static final int WAIT_DONE_INTERVAL = 5000;
    private String mBleMac;
    private Handler mDispatchHandler;
    private ConcurrentLinkedQueue<BleReceiveData> mQueue = new ConcurrentLinkedQueue<>();
    private Handler mReceiveHandler;
    private List<IBleDataReceiver> mReceivers = new CopyOnWriteArrayList();
    private boolean mWaitStickyDataDone = true;

    public BleDataDispatcher(String str, Looper looper, Looper looper2) {
        this.mBleMac = str;
        this.mReceiveHandler = new Handler(looper, this);
        this.mDispatchHandler = new Handler(looper2, this);
    }

    private void dispatchData() {
        boolean z;
        boolean z2;
        if (!this.mQueue.isEmpty() && !this.mReceivers.isEmpty()) {
            BleReceiveData peek = this.mQueue.peek();
            Iterator<IBleDataReceiver> it = this.mReceivers.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    z2 = false;
                    break;
                }
                IBleDataReceiver next = it.next();
                if (next.isClient() == peek.isClient() && next.getFocusUuid().equals(peek.getFromUUID())) {
                    z2 = true;
                    if (next.isSticky()) {
                        int isCtr = peek.isCtr();
                        log("dispatch sticky  packet, cmd = " + isCtr + ", mQueue size = " + this.mQueue.size(), new Object[0]);
                        if (isCtr < 0 || isCtr == 1 || isCtr == 3) {
                            next.receiveData(this.mQueue.poll());
                        } else if (this.mWaitStickyDataDone) {
                            this.mWaitStickyDataDone = false;
                            next.receiveData(this.mQueue.poll());
                            this.mDispatchHandler.sendEmptyMessageDelayed(201, 5000);
                        } else {
                            log("last ctr wait done, mQueue size =" + this.mQueue.size(), new Object[0]);
                            z = true;
                        }
                    } else if (this.mWaitStickyDataDone) {
                        log("dispatch short data, mQueue size = " + this.mQueue.size(), new Object[0]);
                        next.receiveData(this.mQueue.poll());
                    } else {
                        log("sticky data not ready, wait sometime. mQueue size=" + this.mQueue.size(), new Object[0]);
                        this.mDispatchHandler.sendEmptyMessageDelayed(201, 5000);
                        z = true;
                    }
                    z = false;
                }
            }
            if (!z2) {
                BluetoothLog.error(TAG, "receive data 0x" + peek.getFromUUID() + ":length=" + peek.getData().length + " not found dest receiver, remove it.", new Object[0]);
                this.mQueue.poll();
            }
            if (!z) {
                notifyDealWithData();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$stickyDoneWithData$0(boolean z, int i, byte[] bArr) {
        Iterator<IBleDataReceiver> it = this.mReceivers.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            IBleDataReceiver next = it.next();
            if (next.isClient() == z && next.isSticky()) {
                ((IBleMultiDataReceiver) next).onReceiveFullData(this.mBleMac, i, bArr);
                break;
            }
        }
        log("notify stickyDoneWithData, isClient=" + z + ", packageType =" + i + ", data length =" + bArr.length, new Object[0]);
        this.mWaitStickyDataDone = true;
        this.mDispatchHandler.removeMessages(201);
        notifyDealWithData();
    }

    private void log(String str, Object... objArr) {
        BluetoothLog.log(TAG, this.mBleMac + AccountConstantKt.CODE_SEPARTOR + str, objArr);
    }

    private void notifyDealWithData() {
        if (!this.mDispatchHandler.hasMessages(200)) {
            this.mDispatchHandler.sendEmptyMessage(200);
        }
    }

    public void addReceiver(IBleDataReceiver iBleDataReceiver) {
        if (!this.mReceivers.contains(iBleDataReceiver)) {
            this.mReceivers.add(iBleDataReceiver);
        }
    }

    public boolean handleMessage(@NonNull Message message) {
        int i = message.what;
        if (i == 202) {
            this.mQueue.offer((BleReceiveData) message.obj);
            notifyDealWithData();
        } else if (i == 200) {
            dispatchData();
            return true;
        } else if (i == 201) {
            this.mWaitStickyDataDone = true;
            log("wait timeout, continue dispatch data", new Object[0]);
            notifyDealWithData();
        }
        return false;
    }

    public void receiveBleData(BleReceiveData bleReceiveData) {
        this.mReceiveHandler.obtainMessage(202, bleReceiveData).sendToTarget();
    }

    public boolean removeReceiver(IBleDataReceiver iBleDataReceiver) {
        return this.mReceivers.remove(iBleDataReceiver);
    }

    public void reset() {
        this.mQueue.clear();
        log("reset ,ble mac=" + this.mBleMac, new Object[0]);
    }

    public void stickyDataDone() {
        this.mWaitStickyDataDone = true;
        this.mDispatchHandler.removeMessages(201);
        log("notify stickDataDone", new Object[0]);
        notifyDealWithData();
    }

    public void stickyDoneWithData(boolean z, int i, byte[] bArr) {
        this.mDispatchHandler.post(new a(this, z, i, bArr));
    }
}
