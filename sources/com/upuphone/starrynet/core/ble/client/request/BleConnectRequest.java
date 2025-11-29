package com.upuphone.starrynet.core.ble.client.request;

import android.os.Message;
import com.upuphone.starrynet.core.ble.client.BleClientCache;
import com.upuphone.starrynet.core.ble.client.BleConnectConfig;
import com.upuphone.starrynet.core.ble.client.listener.ServiceDiscoverListener;
import com.upuphone.starrynet.core.ble.client.response.BleResponser;
import com.upuphone.starrynet.core.ble.utils.BluetoothLog;
import com.xjsd.ai.assistant.protocol.AssistantConstants;

public class BleConnectRequest extends BleRequest implements ServiceDiscoverListener {
    private static final int CONNECT_TIMEOUT = 15000;
    private static final int DISCOVER_SERVICE_TIMEOUT = 10000;
    private static final int MSG_CONNECT = 1;
    private static final int MSG_CONNECT_TIMEOUT = 3;
    private static final int MSG_DISCOVER_SERVICE = 2;
    private static final int MSG_DISCOVER_SERVICE_TIMEOUT = 4;
    private static final int MSG_RETRY_DISCOVER_SERVICE = 5;
    private static final int RETRY_TIMES = 2;
    private int mConnectCount;
    private BleConnectConfig mConnectionConfig;
    private int mServiceDiscoverCount;

    public BleConnectRequest(BleConnectConfig bleConnectConfig, BleResponser bleResponser) {
        super(bleResponser);
        this.mConnectionConfig = bleConnectConfig;
    }

    private boolean doDiscoverService() {
        this.mServiceDiscoverCount++;
        return discoverService();
    }

    private boolean doOpenNewGatt(BleConnectConfig bleConnectConfig) {
        this.mConnectCount++;
        return openGatt(bleConnectConfig);
    }

    private void onConnectSuccess() {
        onRequestCompleted(0);
    }

    private void onServiceDiscoverFailed() {
        BluetoothLog.log("BleConnectRequest", "onServiceDiscoverFailed", new Object[0]);
        refreshDeviceCache();
        this.mHandler.sendEmptyMessageDelayed(5, AssistantConstants.TIMEOUT_VAD_MUTE);
    }

    private void processConnect() {
        this.mHandler.removeCallbacksAndMessages((Object) null);
        this.mServiceDiscoverCount = 0;
        int currentStatus = getCurrentStatus();
        if (currentStatus != 0) {
            if (currentStatus == 2) {
                processDiscoverService();
            } else if (currentStatus == 19) {
                onConnectSuccess();
            }
        } else if (!doOpenNewGatt(this.mConnectionConfig)) {
            onRequestCompleted(-6);
            closeGatt();
        } else {
            this.mHandler.sendEmptyMessageDelayed(3, 15000);
        }
    }

    private void processConnectTimeout() {
        log("connect timeout");
        onRequestCompleted(-6);
        closeGatt();
    }

    private void processDiscoverService() {
        BluetoothLog.log("BleConnectRequest", "processDiscoverService, status = %s", getStatusText());
        int currentStatus = getCurrentStatus();
        if (currentStatus == 0) {
            retryConnectIfNeeded();
        } else if (currentStatus != 2) {
            if (currentStatus == 19) {
                onConnectSuccess();
            }
        } else if (!doDiscoverService()) {
            onServiceDiscoverFailed();
        } else {
            this.mHandler.sendEmptyMessageDelayed(4, 10000);
        }
    }

    private void processDiscoverServiceTimeout() {
        log("service discover timeout");
        onRequestCompleted(-6);
        closeGatt();
    }

    private boolean retryConnectIfNeeded() {
        if (this.mConnectCount <= this.mConnectionConfig.getMaxRetryTimes()) {
            retryConnectLater();
            return true;
        }
        onRequestCompleted(-6);
        return false;
    }

    private void retryConnectLater() {
        log("retry connect later");
        this.mHandler.removeCallbacksAndMessages((Object) null);
        this.mHandler.sendEmptyMessageDelayed(1, 200);
    }

    private void retryDiscoverServiceIfNeeded() {
        if (this.mServiceDiscoverCount <= 2) {
            retryDiscoverServiceLater();
            return;
        }
        onRequestCompleted(-6);
        closeGatt();
    }

    private void retryDiscoverServiceLater() {
        log("retry discover service later");
        this.mHandler.removeCallbacksAndMessages((Object) null);
        this.mHandler.sendEmptyMessageDelayed(2, AssistantConstants.TIMEOUT_VAD_MUTE);
    }

    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            processConnect();
        } else if (i == 2) {
            processDiscoverService();
        } else if (i == 3) {
            processConnectTimeout();
        } else if (i == 4) {
            processDiscoverServiceTimeout();
        } else if (i == 5) {
            retryDiscoverServiceIfNeeded();
        }
        return super.handleMessage(message);
    }

    public boolean onConnectStatusChanged(boolean z) {
        checkRuntime();
        this.mHandler.removeMessages(3);
        if (z) {
            if (BleClientCache.getInstance().isExternalDevice(getAddress())) {
                this.mHandler.sendEmptyMessageDelayed(2, 500);
            } else {
                this.mHandler.sendEmptyMessageDelayed(2, 300);
            }
            return true;
        }
        this.mHandler.removeCallbacksAndMessages((Object) null);
        return !retryConnectIfNeeded();
    }

    public void onServicesDiscovered(int i) {
        checkRuntime();
        this.mHandler.removeMessages(4);
        if (i == 0) {
            onConnectSuccess();
        } else {
            onServiceDiscoverFailed();
        }
    }

    public void processRequest() {
        processConnect();
    }
}
