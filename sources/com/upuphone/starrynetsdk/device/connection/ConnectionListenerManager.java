package com.upuphone.starrynetsdk.device.connection;

import com.honey.account.m7.a;
import com.upuphone.hub.Hub;
import com.upuphone.runasone.core.api.device.IDeviceConnectCallback;
import com.upuphone.runasone.core.api.device.IDeviceManagerApiProxy;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.starrynetsdk.api.Camp;
import com.upuphone.starrynetsdk.api.ListenerManager;
import com.upuphone.starrynetsdk.api.SNSLog;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public final class ConnectionListenerManager extends ListenerManager {
    private static final String TAG = "ConnectionListenerManager";
    private final IDeviceManagerApiProxy api;
    private final ConnectionCallback connectionCallback;
    private boolean isCallbackRegistered;
    private final Map<String, Set<ConnectionListener>> listenerMap;

    public static final class ConnectionCallback implements IDeviceConnectCallback {
        private final Map<String, Set<ConnectionListener>> listenerMap;

        private Set<ConnectionListener> getTargetListeners(String str) {
            CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
            Set set = this.listenerMap.get((Object) null);
            Set set2 = this.listenerMap.get(str);
            if (set != null) {
                copyOnWriteArraySet.addAll(set);
            }
            if (set2 != null) {
                copyOnWriteArraySet.addAll(set2);
            }
            return copyOnWriteArraySet;
        }

        public void onAuth(StarryDevice starryDevice) {
            if (starryDevice == null) {
                SNSLog.d(ConnectionListenerManager.TAG, "onAuth: starryDevice is null");
                return;
            }
            String id = starryDevice.getId();
            SNSLog.d(ConnectionListenerManager.TAG, "onAuth: " + id);
            for (ConnectionListener onAuth : getTargetListeners(id)) {
                onAuth.onAuth(starryDevice);
            }
        }

        public void onAuthMessage(StarryDevice starryDevice, byte[] bArr, int i) {
            if (starryDevice == null) {
                SNSLog.d(ConnectionListenerManager.TAG, "onAuthMessage: starryDevice is null");
                return;
            }
            String id = starryDevice.getId();
            SNSLog.d(ConnectionListenerManager.TAG, "onAuthMessage: " + id + " >>> " + Arrays.toString(bArr) + ", authCode = " + i);
            for (ConnectionListener next : getTargetListeners(id)) {
                next.onAuthMessage(starryDevice, bArr);
                next.onAuthMessage(starryDevice, bArr, i);
            }
        }

        public void onBalanceConnectedChanged(StarryDevice starryDevice, boolean z) {
            if (starryDevice == null) {
                SNSLog.d(ConnectionListenerManager.TAG, "onBalanceConnectedChanged: starryDevice is null");
                return;
            }
            for (ConnectionListener onBalanceConnectedChanged : getTargetListeners(starryDevice.getId())) {
                onBalanceConnectedChanged.onBalanceConnectedChanged(starryDevice, z);
            }
        }

        public void onBondStateChanged(int i, int i2, StarryDevice starryDevice) {
            if (starryDevice == null) {
                SNSLog.d(ConnectionListenerManager.TAG, "onBondStateChanged: starryDevice is null");
                return;
            }
            String id = starryDevice.getId();
            SNSLog.d(ConnectionListenerManager.TAG, "onBondStateChange: " + id + ", " + i2 + " >>> " + i);
            for (ConnectionListener next : getTargetListeners(id)) {
                next.onBondStateChange(starryDevice, i);
                next.onBondStateChange(starryDevice, i2, i);
            }
        }

        public void onBrConnectedChanged(StarryDevice starryDevice, boolean z) {
            if (starryDevice == null) {
                SNSLog.d(ConnectionListenerManager.TAG, "onBrConnectedChanged: starryDevice is null");
                return;
            }
            for (ConnectionListener onBrConnectedChanged : getTargetListeners(starryDevice.getId())) {
                onBrConnectedChanged.onBrConnectedChanged(starryDevice, z);
            }
        }

        public void onConnectFail(int i, StarryDevice starryDevice, int i2) {
            if (starryDevice == null) {
                SNSLog.d(ConnectionListenerManager.TAG, "onConnectFail: starryDevice is null");
                return;
            }
            String id = starryDevice.getId();
            SNSLog.d(ConnectionListenerManager.TAG, "onConnectFail: " + id + " >>> " + i + " --- " + i2);
            for (ConnectionListener onConnectFail : getTargetListeners(id)) {
                onConnectFail.onConnectFail(i, starryDevice, i2);
            }
        }

        public void onConnectedChanged(StarryDevice starryDevice, int i, int i2) {
            if (starryDevice == null) {
                SNSLog.d(ConnectionListenerManager.TAG, "onConnectedChanged: starryDevice is null");
                return;
            }
            String id = starryDevice.getId();
            SNSLog.d(ConnectionListenerManager.TAG, "onConnectStateChange: " + id + " >>> " + i + " >>> " + i2);
            for (ConnectionListener next : getTargetListeners(id)) {
                if (DevicesConnector.getInstance().getCurDeviceState(id) >= 0) {
                    next.onConnectStateChange(starryDevice, i, i2);
                }
                next.onConnectStateChange(starryDevice, starryDevice.getStatus());
            }
        }

        private ConnectionCallback(Map<String, Set<ConnectionListener>> map) {
            this.listenerMap = map;
        }
    }

    public static class Holder {
        /* access modifiers changed from: private */
        public static final ConnectionListenerManager INSTANCE = new ConnectionListenerManager();

        private Holder() {
        }
    }

    private void doRegisterConnectionCallback(boolean z) {
        SNSLog.d(TAG, "doRegisterConnectionCallback from restore: " + z);
        if (this.isCallbackRegistered) {
            SNSLog.e(TAG, "ConnectionCallback already registered , unnecessary doRegisterConnectionCallback");
        } else if (this.listenerMap.isEmpty()) {
            SNSLog.e(TAG, "ListenerMap isEmpty , unnecessary doRegisterSendCallBack");
        } else if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable , doRegisterConnectionCallback failed.");
        } else {
            try {
                this.api.registerDeviceStatusListener((String) null, this.connectionCallback);
                this.isCallbackRegistered = true;
            } catch (RuntimeException e) {
                SNSLog.e(TAG, "doRegisterConnectionCallback failed.", e);
            }
        }
    }

    private void doUnregisterConnectionCallback() {
        SNSLog.d(TAG, "doUnregisterConnectionCallback");
        if (!this.listenerMap.isEmpty()) {
            SNSLog.e(TAG, "ListenerMap not empty , unnecessary doUnregisterConnectionCallback");
        } else if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable , doUnregisterConnectionCallback failed.");
        } else {
            try {
                this.api.unRegisterDeviceStatusListener((String) null);
                this.isCallbackRegistered = false;
            } catch (RuntimeException e) {
                SNSLog.e(TAG, "doRegisterConnectionCallback failed.", e);
            }
        }
    }

    public static ConnectionListenerManager getInstance() {
        return Holder.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Set lambda$registerConnectionListener$0(String str) {
        return new CopyOnWriteArraySet();
    }

    public void onInstalled(Hub hub) {
        super.onInstalled(hub);
        this.api.setHub(hub);
        doRegisterConnectionCallback(true);
    }

    public void onUninstalled() {
        super.onUninstalled();
        this.isCallbackRegistered = false;
    }

    public void postConnectedChanged(StarryDevice starryDevice) {
        int preDeviceState = DevicesConnector.getInstance().getPreDeviceState(starryDevice.getId());
        int curDeviceState = DevicesConnector.getInstance().getCurDeviceState(starryDevice.getId());
        if (preDeviceState < 0 || curDeviceState < 0) {
            this.connectionCallback.onConnectedChanged(starryDevice, 0, starryDevice.getStatus());
        } else {
            this.connectionCallback.onConnectedChanged(starryDevice, preDeviceState, curDeviceState);
        }
    }

    public void registerConnectionListener(String str, ConnectionListener connectionListener) {
        this.listenerMap.computeIfAbsent(str, new a()).add(connectionListener);
        doRegisterConnectionCallback(false);
    }

    public void unregisterConnectionListener(String str, ConnectionListener connectionListener) {
        Set set = this.listenerMap.get(str);
        if (set != null && !set.isEmpty()) {
            set.remove(connectionListener);
            if (set.isEmpty()) {
                this.listenerMap.remove(str);
            }
        }
        doUnregisterConnectionCallback();
    }

    private ConnectionListenerManager() {
        this.api = new IDeviceManagerApiProxy();
        HashMap hashMap = new HashMap();
        this.listenerMap = hashMap;
        this.connectionCallback = new ConnectionCallback(hashMap);
        Camp.getInstance().addSentry(this);
    }
}
