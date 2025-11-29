package com.upuphone.starrynet.core.ble.client;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.upuphone.starrynet.core.ble.BluetoothConstants;
import com.upuphone.starrynet.core.ble.SystemActionObserver;
import com.upuphone.starrynet.core.ble.client.request.BleBatchWriteRequest;
import com.upuphone.starrynet.core.ble.client.request.BleConnectRequest;
import com.upuphone.starrynet.core.ble.client.request.BleNotifyRequest;
import com.upuphone.starrynet.core.ble.client.request.BleReadRequest;
import com.upuphone.starrynet.core.ble.client.request.BleRequest;
import com.upuphone.starrynet.core.ble.client.request.BleRequestMtuRequest;
import com.upuphone.starrynet.core.ble.client.request.BleWriteAtOneRequest;
import com.upuphone.starrynet.core.ble.client.request.BleWriteNoRspRequest;
import com.upuphone.starrynet.core.ble.client.request.BleWriteRequest;
import com.upuphone.starrynet.core.ble.client.response.BleResponse;
import com.upuphone.starrynet.core.ble.client.response.BleResponser;
import com.upuphone.starrynet.core.ble.client.response.BleWriteNoRespResponse;
import com.upuphone.starrynet.core.ble.listener.ITryInterruptRequestCallback;
import com.upuphone.starrynet.core.ble.utils.BluetoothLog;
import com.upuphone.starrynet.core.ble.utils.BluetoothUtils;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class BleRequestDispatcher implements IBleRequestDispatcher, RuntimeChecker, Handler.Callback {
    private static final byte[] HEART_BEAT_DATA = {0, 0, 9, 16, 0};
    private static final int HEART_BEAT_INTERVAL = 3000;
    private static final int MAX_REQUEST_COUNT = 100;
    private static final int MSG_SCHEDULE_NEXT = 18;
    private static final int MSG_SEND_HEART_BEAT_DATA = 19;
    private static final int REQUEST_INTERVAL = 50;
    private static final String TAG = "BleRequestDispatcher";
    private String mAddress;
    private List<BleRequest> mBleHighLevelWorkList;
    private boolean mBleSupport;
    /* access modifiers changed from: private */
    public List<BleRequest> mBleWorkList;
    private BleRequest mCurrentRequest;
    /* access modifiers changed from: private */
    public Handler mHandler;
    private UUID mHeartBeatUUID = null;
    private long mLastRequestTime = -1;
    /* access modifiers changed from: private */
    public IBleWorker mWorker;
    private long requestIndex = 0;

    private BleRequestDispatcher(String str) {
        this.mAddress = str;
        this.mBleWorkList = new LinkedList();
        this.mBleHighLevelWorkList = new LinkedList();
        this.mHandler = new Handler(Looper.myLooper(), this);
        try {
            this.mWorker = new BleWorker(str, this);
        } catch (IllegalStateException e) {
            this.mWorker = null;
            BluetoothLog.e(e);
        }
        this.mBleSupport = BluetoothUtils.isBleSupported();
    }

    public static /* synthetic */ long access$204(BleRequestDispatcher bleRequestDispatcher) {
        long j = bleRequestDispatcher.requestIndex + 1;
        bleRequestDispatcher.requestIndex = j;
        return j;
    }

    private void addNewRequest(BleRequest bleRequest) {
        if (this.mWorker == null) {
            BluetoothLog.error(TAG, "addRequest,but mWorker is null", new Object[0]);
            bleRequest.onResponse(-16);
            return;
        }
        checkRuntime();
        if (this.mBleWorkList.size() < 100) {
            bleRequest.setRuntimeChecker(this);
            bleRequest.setAddress(this.mAddress);
            bleRequest.setWorker(this.mWorker);
            long j = this.requestIndex + 1;
            this.requestIndex = j;
            bleRequest.setRequestID(j);
            this.mBleWorkList.add(bleRequest);
        } else {
            bleRequest.onResponse(-11);
        }
        doNextRequest();
    }

    private void doNextRequest() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.mLastRequestTime;
        long j2 = 0;
        if (j >= 0 && currentTimeMillis - j <= 50) {
            j2 = 6;
        }
        this.mHandler.sendEmptyMessageDelayed(18, j2);
    }

    private boolean isHighLevelRequest(UUID uuid, UUID uuid2) {
        if (BluetoothConstants.STARRY_NET_SERVICE_UUID.equals(uuid)) {
            return BluetoothConstants.STARRY_NET_AIR_INTERNAL_MESSAGE_UUID.equals(uuid2);
        }
        return false;
    }

    public static BleRequestDispatcher newInstance(String str) {
        return new BleRequestDispatcher(str);
    }

    private void scheduleNextRequest() {
        BleRequest bleRequest;
        BleRequest bleRequest2 = this.mCurrentRequest;
        if (bleRequest2 != null) {
            BluetoothLog.log(TAG, "scheduleNextRequest ,current request(%d) is going, return!", Long.valueOf(bleRequest2.getRequestID()));
            return;
        }
        List<BleRequest> list = this.mBleHighLevelWorkList;
        if (list == null || list.size() <= 0) {
            List<BleRequest> list2 = this.mBleWorkList;
            bleRequest = (list2 == null || list2.size() <= 0) ? null : this.mBleWorkList.remove(0);
        } else {
            bleRequest = this.mBleHighLevelWorkList.remove(0);
        }
        if (bleRequest != null) {
            this.mCurrentRequest = bleRequest;
            if (!this.mBleSupport) {
                bleRequest.onResponse(-4);
                onRequestCompleted(this.mCurrentRequest);
            } else if (!SystemActionObserver.getInstance().isBtOn()) {
                this.mCurrentRequest.onResponse(-5);
                onRequestCompleted(this.mCurrentRequest);
            } else {
                this.mCurrentRequest.process(this);
            }
        }
    }

    public void addNewHighLevelRequest(BleRequest bleRequest) {
        if (this.mWorker == null) {
            BluetoothLog.error(TAG, "addRequest,but mWorker is null", new Object[0]);
            bleRequest.onResponse(-16);
            return;
        }
        checkRuntime();
        if (this.mBleHighLevelWorkList.size() < 100) {
            bleRequest.setRuntimeChecker(this);
            bleRequest.setAddress(this.mAddress);
            bleRequest.setWorker(this.mWorker);
            long j = this.requestIndex + 1;
            this.requestIndex = j;
            bleRequest.setRequestID(j);
            this.mBleHighLevelWorkList.add(bleRequest);
            BleRequest bleRequest2 = this.mCurrentRequest;
            if (bleRequest2 != null && (bleRequest2 instanceof BleBatchWriteRequest)) {
                final BleBatchWriteRequest bleBatchWriteRequest = (BleBatchWriteRequest) bleRequest2;
                if (bleBatchWriteRequest.checkNeedInterrupt()) {
                    bleBatchWriteRequest.tryInterruptRequest(new ITryInterruptRequestCallback() {
                        public void onReady() {
                            BleBatchWriteRequest interrupt = bleBatchWriteRequest.interrupt();
                            interrupt.setRequestID(BleRequestDispatcher.access$204(BleRequestDispatcher.this));
                            BleRequestDispatcher.this.mBleWorkList.add(0, interrupt);
                            bleBatchWriteRequest.triggerCompleted();
                        }
                    });
                }
            }
        } else {
            bleRequest.onResponse(-11);
        }
        doNextRequest();
    }

    public void cancelConnecting() {
        checkRuntime();
        BluetoothLog.log(TAG, "start process cancelConnecting", new Object[0]);
        BleRequest bleRequest = this.mCurrentRequest;
        if (bleRequest == null || !(bleRequest instanceof BleConnectRequest)) {
            BluetoothLog.log(TAG, "not in connecting state, no need to cancel.", new Object[0]);
            return;
        }
        bleRequest.cancel();
        this.mCurrentRequest = null;
        for (BleRequest cancel : this.mBleHighLevelWorkList) {
            cancel.cancel();
        }
        this.mBleHighLevelWorkList.clear();
        for (BleRequest cancel2 : this.mBleWorkList) {
            cancel2.cancel();
        }
        this.mBleWorkList.clear();
        IBleWorker iBleWorker = this.mWorker;
        if (iBleWorker != null) {
            iBleWorker.closeGatt();
        }
    }

    public void checkRuntime() {
        if (Thread.currentThread() != this.mHandler.getLooper().getThread()) {
            BluetoothLog.error(TAG, "异常警告：checkRuntime, thread context illegal, current thread name = " + Thread.currentThread().getName() + ",dest thread name=" + this.mHandler.getLooper().getThread().getName(), new Object[0]);
        }
    }

    public void connect(BleConnectConfig bleConnectConfig, BleResponser bleResponser) {
        addNewRequest(new BleConnectRequest(bleConnectConfig, bleResponser));
        UUID heartBeatUUID = bleConnectConfig.getHeartBeatUUID();
        this.mHeartBeatUUID = heartBeatUUID;
        if (heartBeatUUID != null) {
            if (this.mHandler.hasMessages(19)) {
                this.mHandler.removeMessages(19);
            }
            BluetoothLog.log(TAG, "connect trigger heartBeat uuid", new Object[0]);
            this.mHandler.sendEmptyMessageDelayed(19, 3000);
        }
    }

    public void destroy() {
        checkRuntime();
        BleRequest bleRequest = this.mCurrentRequest;
        if (bleRequest != null) {
            bleRequest.cancel();
            this.mCurrentRequest = null;
        }
        for (BleRequest cancel : this.mBleHighLevelWorkList) {
            cancel.cancel();
        }
        this.mBleHighLevelWorkList.clear();
        for (BleRequest cancel2 : this.mBleWorkList) {
            cancel2.cancel();
        }
        this.mBleWorkList.clear();
        IBleWorker iBleWorker = this.mWorker;
        if (iBleWorker != null) {
            iBleWorker.destroy();
        }
    }

    public void disconnect() {
        checkRuntime();
        BluetoothLog.log(TAG, "start process disconnect", new Object[0]);
        BleRequest bleRequest = this.mCurrentRequest;
        if (bleRequest != null) {
            bleRequest.cancel();
            this.mCurrentRequest = null;
        }
        for (BleRequest cancel : this.mBleHighLevelWorkList) {
            cancel.cancel();
        }
        this.mBleHighLevelWorkList.clear();
        for (BleRequest cancel2 : this.mBleWorkList) {
            cancel2.cancel();
        }
        this.mBleWorkList.clear();
        IBleWorker iBleWorker = this.mWorker;
        if (iBleWorker != null) {
            iBleWorker.closeGatt();
        }
    }

    public boolean handleMessage(@NonNull Message message) {
        int i = message.what;
        if (i == 18) {
            scheduleNextRequest();
        } else if (i == 19) {
            if (this.mHeartBeatUUID == null) {
                BluetoothLog.log(TAG, "", new Object[0]);
                return true;
            }
            this.mHandler.sendEmptyMessageDelayed(19, 3000);
            if (this.mCurrentRequest == null && this.mBleWorkList.isEmpty() && this.mBleHighLevelWorkList.isEmpty()) {
                addNewRequest(new BleWriteNoRspRequest(BluetoothConstants.STARRY_NET_SERVICE_UUID, this.mHeartBeatUUID, HEART_BEAT_DATA, BleResponser.newInstance(new BleWriteNoRespResponse() {
                    public void onResponse(int i, Void voidR) {
                        BluetoothLog.log(BleRequestDispatcher.TAG, "send heart beat data ,code =" + i, new Object[0]);
                        if (i != 0) {
                            int currentStatus = BleRequestDispatcher.this.mWorker.getCurrentStatus();
                            BluetoothLog.log(BleRequestDispatcher.TAG, "stop heart beat, status=" + currentStatus, new Object[0]);
                            if (currentStatus == 0) {
                                BleRequestDispatcher.this.mHandler.removeMessages(19);
                            }
                        }
                    }
                })));
            }
        }
        return true;
    }

    public void isCharacterExist(UUID uuid, UUID uuid2, BleResponse<Void> bleResponse) {
        IBleWorker iBleWorker = this.mWorker;
        if (iBleWorker == null) {
            BluetoothLog.error(TAG, "isCharacterExist,but mWorker is null,return!!!", new Object[0]);
            if (bleResponse != null) {
                bleResponse.onResponse(-16, null);
                return;
            }
            return;
        }
        iBleWorker.isCharacterExist(uuid, uuid2, bleResponse);
    }

    public void notify(UUID uuid, UUID uuid2, BleResponser bleResponser) {
        addNewHighLevelRequest(new BleNotifyRequest(uuid, uuid2, bleResponser));
    }

    public void onRequestCompleted(BleRequest bleRequest) {
        checkRuntime();
        if (bleRequest != this.mCurrentRequest) {
            BluetoothLog.error(TAG, "request not match", new Object[0]);
        }
        this.mCurrentRequest = null;
        this.mLastRequestTime = System.currentTimeMillis();
        doNextRequest();
    }

    public void read(UUID uuid, UUID uuid2, BleResponser bleResponser) {
        addNewRequest(new BleReadRequest(uuid, uuid2, bleResponser));
    }

    public void requestMtu(int i, BleResponser bleResponser) {
        addNewHighLevelRequest(new BleRequestMtuRequest(i, bleResponser));
    }

    public void write(UUID uuid, UUID uuid2, byte[] bArr, BleResponser bleResponser) {
        if (!isHighLevelRequest(uuid, uuid2)) {
            addNewRequest(new BleWriteRequest(uuid, uuid2, bArr, bleResponser));
        } else {
            addNewHighLevelRequest(new BleWriteRequest(uuid, uuid2, bArr, bleResponser));
        }
    }

    public void writeBatchNoRsp(UUID uuid, UUID uuid2, List<byte[]> list, BleResponser bleResponser) {
        if (!isHighLevelRequest(uuid, uuid2)) {
            addNewRequest(new BleBatchWriteRequest(uuid, uuid2, list, bleResponser));
        } else {
            addNewHighLevelRequest(new BleBatchWriteRequest(uuid, uuid2, list, bleResponser));
        }
    }

    public void writeNoRespAtOne(UUID uuid, UUID uuid2, byte[] bArr, BleResponser bleResponser) {
        addNewHighLevelRequest(new BleWriteAtOneRequest(uuid, uuid2, bArr, bleResponser));
    }

    public void writeNoRsp(UUID uuid, UUID uuid2, byte[] bArr, BleResponser bleResponser) {
        if (!isHighLevelRequest(uuid, uuid2)) {
            addNewRequest(new BleWriteNoRspRequest(uuid, uuid2, bArr, bleResponser));
        } else {
            addNewHighLevelRequest(new BleWriteNoRspRequest(uuid, uuid2, bArr, bleResponser));
        }
    }
}
