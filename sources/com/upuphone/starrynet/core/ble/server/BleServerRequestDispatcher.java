package com.upuphone.starrynet.core.ble.server;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import com.upuphone.starrynet.core.ble.BluetoothConstants;
import com.upuphone.starrynet.core.ble.BluetoothContextManager;
import com.upuphone.starrynet.core.ble.SystemActionObserver;
import com.upuphone.starrynet.core.ble.client.RuntimeChecker;
import com.upuphone.starrynet.core.ble.listener.ITryInterruptRequestCallback;
import com.upuphone.starrynet.core.ble.server.character.IGattCharacterService;
import com.upuphone.starrynet.core.ble.server.reponse.BleNotificationResponse;
import com.upuphone.starrynet.core.ble.server.reponse.BleServerResponser;
import com.upuphone.starrynet.core.ble.server.reponse.OpenServerResponse;
import com.upuphone.starrynet.core.ble.server.request.BatchNotificationRequest;
import com.upuphone.starrynet.core.ble.server.request.BleServerRequest;
import com.upuphone.starrynet.core.ble.server.request.NotificationRequest;
import com.upuphone.starrynet.core.ble.server.request.NotificationRequestAtOnce;
import com.upuphone.starrynet.core.ble.server.request.OpenServerRequest;
import com.upuphone.starrynet.core.ble.utils.BluetoothLog;
import com.upuphone.starrynet.core.ble.utils.BluetoothUtils;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class BleServerRequestDispatcher implements RuntimeChecker, Handler.Callback {
    private static final int MAX_REQUEST_COUNT = 100;
    private static final int MSG_SCHEDULE_NEXT = 18;
    private static final int REQUEST_INTERVAL = 50;
    private static final int SEND_DELAY = 6;
    private static final String TAG = "BleServerRequestDispatcher";
    private List<BleServerRequest> mBleHighLevelWorkList = new LinkedList();
    private boolean mBleSupport;
    /* access modifiers changed from: private */
    public List<BleServerRequest> mBleWorkList = new LinkedList();
    private BleServerRequest mCurrentRequest;
    private Handler mHandler = new Handler(BluetoothContextManager.getCoreBleLooper(), this);
    private long mLastRequestTime = -1;
    private IBleServer mServer;
    private long requestIndex = 0;

    public BleServerRequestDispatcher(GattServerConfig gattServerConfig) {
        this.mServer = new BleGattServer(BluetoothContextManager.getContext(), gattServerConfig, this);
        this.mBleSupport = BluetoothUtils.isBleSupported();
    }

    public static /* synthetic */ long access$004(BleServerRequestDispatcher bleServerRequestDispatcher) {
        long j = bleServerRequestDispatcher.requestIndex + 1;
        bleServerRequestDispatcher.requestIndex = j;
        return j;
    }

    private void addHighLevelNewRequest(BleServerRequest bleServerRequest) {
        checkRuntime();
        if (this.mBleHighLevelWorkList.size() < 100) {
            bleServerRequest.setRuntimeChecker(this);
            bleServerRequest.setBleServer(this.mServer);
            long j = this.requestIndex + 1;
            this.requestIndex = j;
            bleServerRequest.setRequestID(j);
            this.mBleHighLevelWorkList.add(bleServerRequest);
            BleServerRequest bleServerRequest2 = this.mCurrentRequest;
            if (bleServerRequest2 != null && (bleServerRequest2 instanceof BatchNotificationRequest)) {
                final BatchNotificationRequest batchNotificationRequest = (BatchNotificationRequest) bleServerRequest2;
                if (batchNotificationRequest.checkNeedInterrupt()) {
                    batchNotificationRequest.tryInterruptRequest(new ITryInterruptRequestCallback() {
                        public void onReady() {
                            BatchNotificationRequest interrupt = batchNotificationRequest.interrupt();
                            interrupt.setRequestID(BleServerRequestDispatcher.access$004(BleServerRequestDispatcher.this));
                            BleServerRequestDispatcher.this.mBleWorkList.add(0, interrupt);
                            batchNotificationRequest.triggerCompleted();
                        }
                    });
                }
            }
        } else {
            bleServerRequest.onResponse(-11);
        }
        if (this.mCurrentRequest == null) {
            scheduleNextRequest(6);
        }
    }

    private void addNewRequest(BleServerRequest bleServerRequest) {
        checkRuntime();
        if (this.mBleWorkList.size() < 100) {
            bleServerRequest.setRuntimeChecker(this);
            bleServerRequest.setBleServer(this.mServer);
            long j = this.requestIndex + 1;
            this.requestIndex = j;
            bleServerRequest.setRequestID(j);
            this.mBleWorkList.add(bleServerRequest);
        } else {
            bleServerRequest.onResponse(-11);
        }
        if (this.mCurrentRequest == null) {
            scheduleNextRequest(6);
        }
    }

    private boolean isHighLevelRequest(UUID uuid) {
        return BluetoothConstants.STARRY_NET_AIR_INTERNAL_MESSAGE_UUID.equals(uuid);
    }

    private void scheduleNextRequest(long j) {
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = this.mLastRequestTime;
        if (j2 < 0 || currentTimeMillis - j2 > 50) {
            j = 0;
        }
        this.mHandler.sendEmptyMessageDelayed(18, j);
    }

    public void addServices(IGattCharacterService iGattCharacterService) {
        this.mServer.addServices(iGattCharacterService);
    }

    public void checkRuntime() {
        if (Thread.currentThread() != this.mHandler.getLooper().getThread()) {
            BluetoothLog.error(TAG, "异常警告：checkRuntime current thread name =%s, dest thread name =%s", Thread.currentThread().getName(), this.mHandler.getLooper().getThread().getName());
        }
    }

    public void disconnect(String str) {
        sendNotification(str, BluetoothConstants.STARRY_NET_READ_CONFIG_UUID, new byte[]{1}, new BleNotificationResponse() {
            public void onResponse(int i, Void voidR) {
                BluetoothLog.log(BleServerRequestDispatcher.TAG, "disconnect response code =" + i, new Object[0]);
            }
        });
    }

    public boolean handleMessage(@NonNull Message message) {
        if (message.what != 18) {
            return true;
        }
        scheduleNextRequest();
        return true;
    }

    public boolean isCharacterNotify(String str, UUID uuid) {
        BluetoothLog.log(TAG, "isCharacterNotify uuid =%s", uuid);
        return this.mServer.isCharacterNotify(str, uuid);
    }

    public void onRequestCompleted(BleServerRequest bleServerRequest) {
        checkRuntime();
        if (bleServerRequest != this.mCurrentRequest) {
            BluetoothLog.error(TAG, "request not match", new Object[0]);
        }
        this.mCurrentRequest = null;
        this.mLastRequestTime = System.currentTimeMillis();
        scheduleNextRequest(6);
    }

    public void openServer(OpenServerResponse openServerResponse) {
        addHighLevelNewRequest(new OpenServerRequest(new BleServerResponser(openServerResponse)));
    }

    public void sendBatchNotification(String str, UUID uuid, List<byte[]> list, BleNotificationResponse bleNotificationResponse) {
        if (!isHighLevelRequest(uuid)) {
            addNewRequest(new BatchNotificationRequest(str, uuid, list, new BleServerResponser(bleNotificationResponse)));
        } else {
            addHighLevelNewRequest(new BatchNotificationRequest(str, uuid, list, new BleServerResponser(bleNotificationResponse)));
        }
    }

    public void sendNotification(String str, UUID uuid, byte[] bArr, BleNotificationResponse bleNotificationResponse) {
        if (!isHighLevelRequest(uuid)) {
            addNewRequest(new NotificationRequest(str, uuid, bArr, new BleServerResponser(bleNotificationResponse)));
        } else {
            addHighLevelNewRequest(new NotificationRequest(str, uuid, bArr, new BleServerResponser(bleNotificationResponse)));
        }
    }

    public void sendNotificationAtOnce(String str, UUID uuid, byte[] bArr, BleNotificationResponse bleNotificationResponse) {
        addHighLevelNewRequest(new NotificationRequestAtOnce(str, uuid, bArr, new BleServerResponser(bleNotificationResponse)));
    }

    private void scheduleNextRequest() {
        BleServerRequest bleServerRequest;
        BleServerRequest bleServerRequest2 = this.mCurrentRequest;
        if (bleServerRequest2 != null) {
            BluetoothLog.log(TAG, "scheduleNextRequest ,current request(%d) is going, return!", Long.valueOf(bleServerRequest2.getRequestID()));
            return;
        }
        List<BleServerRequest> list = this.mBleHighLevelWorkList;
        if (list == null || list.size() <= 0) {
            List<BleServerRequest> list2 = this.mBleWorkList;
            bleServerRequest = (list2 == null || list2.size() <= 0) ? null : this.mBleWorkList.remove(0);
        } else {
            bleServerRequest = this.mBleHighLevelWorkList.remove(0);
        }
        if (bleServerRequest != null) {
            this.mCurrentRequest = bleServerRequest;
            if (!this.mBleSupport) {
                bleServerRequest.onResponse(-4);
                onRequestCompleted(this.mCurrentRequest);
            } else if (!SystemActionObserver.getInstance().isBtOn()) {
                this.mCurrentRequest.onResponse(-5);
                onRequestCompleted(this.mCurrentRequest);
            } else {
                this.mCurrentRequest.process(this);
            }
        }
    }
}
