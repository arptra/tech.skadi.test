package com.upuphone.starrynet.strategy.data;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.tracker.TrackerManager;
import com.upuphone.starrynet.core.ap.WiFiApInfo;
import com.upuphone.starrynet.core.p2p.bean.GoInfo;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.bean.StDiscoveryDevice;
import com.upuphone.starrynet.strategy.discovery.scanner.IDiscoveryListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

class StarryDeviceNotify extends HandlerThread {
    private static final int DELAY_TIME_CAL_DEVICE_HIT = 1000;
    private static final long DISCOVERY_TIMEOUT = 15000;
    private static final int MSG_ADD_AUTH_CALLBACK = 4;
    private static final int MSG_ADD_CONNECT_CALLBACK = 1;
    private static final int MSG_ADD_DISCOVERY_LISTENER = 0;
    private static final int MSG_ADD_INTERCEPTOR = 2;
    protected static final int MSG_AP_CREATED_OR_REMOVED = 36;
    protected static final int MSG_AUTH_DEVICE = 37;
    protected static final int MSG_AUTH_DEVICE_MESSAGE = 38;
    protected static final int MSG_BOND_STATE_CHANGE = 20;
    private static final int MSG_CAL_DEVICE_HIT = 3;
    protected static final int MSG_CONNECT_DEVICE = 30;
    protected static final int MSG_CONNECT_FAIL = 39;
    protected static final int MSG_DISCONNECT_DEVICE = 31;
    protected static final int MSG_DISCOVERY_DEVICE = 10;
    protected static final int MSG_GO_CREATED_OR_REMOVED = 35;
    private static final String TAG = "StarryDeviceNotify";
    /* access modifiers changed from: private */
    public final List<IAuthCallback> mAuthList = new ArrayList();
    private final List<String> mBleLinkedList = new CopyOnWriteArrayList();
    /* access modifiers changed from: private */
    public final List<IConnectCallback> mConnectList = new ArrayList();
    private final Map<String, Long> mDeviceHitMac = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public IDiscoveryConnectCallback mDiscoveryConnectCallback;
    /* access modifiers changed from: private */
    public final List<IDiscoveryListener> mDiscoveryList = new ArrayList();
    protected final Handler mHandler;
    /* access modifiers changed from: private */
    public final List<IDiscoveryInterceptor> mInterceptorList = new ArrayList();

    public class NotifyHandle extends Handler {
        public NotifyHandle(Looper looper) {
            super(looper);
        }

        public void handleMessage(@NonNull Message message) {
            StLog.df(StarryDeviceNotify.TAG, "msg = " + message.what);
            int i = message.what;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            StarryDeviceNotify.this.calDeviceHit();
                        } else if (i != 4) {
                            if (i == 10) {
                                StarryDeviceNotify.this.onDisCovered((StDiscoveryDevice) message.obj);
                            } else if (i == 20) {
                                StarryDeviceNotify.this.onBondStateChange(message.arg1, message.arg2, (StConnectDevice) message.obj);
                            } else if (i == 30) {
                                StarryDeviceNotify.this.onConnected((StConnectDevice) message.obj, message.arg1);
                            } else if (i != 31) {
                                switch (i) {
                                    case 35:
                                        if (message.arg1 == 1) {
                                            StarryDeviceNotify.this.onGoCreated((GoInfo) message.obj);
                                            return;
                                        } else {
                                            StarryDeviceNotify.this.onGoRemoved();
                                            return;
                                        }
                                    case 36:
                                        if (message.arg1 == 1) {
                                            StarryDeviceNotify.this.onApCreated((WiFiApInfo) message.obj);
                                            return;
                                        } else {
                                            StarryDeviceNotify.this.onApRemoved();
                                            return;
                                        }
                                    case 37:
                                        StarryDeviceNotify.this.onAuth((StDevice) message.obj);
                                        return;
                                    case 38:
                                        StarryDeviceNotify.this.onAuthMessage((AuthMessage) message.obj);
                                        return;
                                    case 39:
                                        for (IConnectCallback onConnectFail : StarryDeviceNotify.this.mConnectList) {
                                            onConnectFail.onConnectFail((StDevice) message.obj, message.arg1, message.arg2);
                                        }
                                        int i2 = message.arg2;
                                        if ((i2 == 8 || i2 == 1) && StarryDeviceNotify.this.mDiscoveryConnectCallback != null) {
                                            StarryDeviceNotify.this.mDiscoveryConnectCallback.onConnectFail((StDevice) message.obj, message.arg1, message.arg2);
                                            return;
                                        }
                                        return;
                                    default:
                                        return;
                                }
                            } else {
                                StarryDeviceNotify.this.onDisconnected((StConnectDevice) message.obj, message.arg1);
                            }
                        } else if (message.arg1 == 1) {
                            StarryDeviceNotify.this.mAuthList.add((IAuthCallback) message.obj);
                        } else {
                            StarryDeviceNotify.this.mAuthList.remove((IAuthCallback) message.obj);
                        }
                    } else if (message.arg1 == 1) {
                        StarryDeviceNotify.this.mInterceptorList.add((IDiscoveryInterceptor) message.obj);
                    } else {
                        StarryDeviceNotify.this.mInterceptorList.remove((IDiscoveryInterceptor) message.obj);
                    }
                } else if (message.arg1 == 1) {
                    StarryDeviceNotify.this.mConnectList.add((IConnectCallback) message.obj);
                } else {
                    StarryDeviceNotify.this.mConnectList.remove((IConnectCallback) message.obj);
                }
            } else if (message.arg1 == 1) {
                StarryDeviceNotify.this.mDiscoveryList.add((IDiscoveryListener) message.obj);
            } else {
                StarryDeviceNotify.this.mDiscoveryList.remove((IDiscoveryListener) message.obj);
            }
        }
    }

    public StarryDeviceNotify() {
        super(TAG);
        start();
        this.mHandler = new NotifyHandle(getLooper());
    }

    /* access modifiers changed from: private */
    public void onApCreated(WiFiApInfo wiFiApInfo) {
        for (IConnectCallback onApCreated : this.mConnectList) {
            onApCreated.onApCreated(wiFiApInfo);
        }
    }

    /* access modifiers changed from: private */
    public void onApRemoved() {
        for (IConnectCallback onApRemoved : this.mConnectList) {
            onApRemoved.onApRemoved();
        }
    }

    /* access modifiers changed from: private */
    public void onAuth(StDevice stDevice) {
        for (IAuthCallback onAuth : this.mAuthList) {
            onAuth.onAuth(stDevice);
        }
    }

    /* access modifiers changed from: private */
    public void onAuthMessage(AuthMessage authMessage) {
        for (IAuthCallback onAuthMessage : this.mAuthList) {
            onAuthMessage.onAuthMessage(authMessage.getDevice(), authMessage.getData());
        }
    }

    /* access modifiers changed from: private */
    public void onBondStateChange(int i, int i2, StConnectDevice stConnectDevice) {
        IDiscoveryConnectCallback iDiscoveryConnectCallback;
        if (!(stConnectDevice.getTerminalType() == 5 || (iDiscoveryConnectCallback = this.mDiscoveryConnectCallback) == null)) {
            iDiscoveryConnectCallback.onBondStateChanged(stConnectDevice, i2, i);
        }
        for (IConnectCallback onBondStateChanged : this.mConnectList) {
            onBondStateChanged.onBondStateChanged(stConnectDevice, i2, i);
        }
    }

    /* access modifiers changed from: private */
    public void onConnected(StConnectDevice stConnectDevice, int i) {
        IDiscoveryConnectCallback iDiscoveryConnectCallback;
        trackConnected(stConnectDevice, i);
        for (IConnectCallback onConnected : this.mConnectList) {
            onConnected.onConnected(stConnectDevice, i);
        }
        if (stConnectDevice.getTerminalType() != 5 || StarryNetData.getInstance().getOwnDevice().getTerminalType() != 2) {
            if ((i == 1 || i == 2) && (iDiscoveryConnectCallback = this.mDiscoveryConnectCallback) != null) {
                iDiscoveryConnectCallback.onBleConnected(stConnectDevice.getBleMac(), false);
            }
        }
    }

    /* access modifiers changed from: private */
    public void onDisCovered(StDiscoveryDevice stDiscoveryDevice) {
        for (IDiscoveryInterceptor onDiscovery : this.mInterceptorList) {
            if (onDiscovery.onDiscovery(stDiscoveryDevice)) {
                return;
            }
        }
        for (IDiscoveryListener onDiscovered : this.mDiscoveryList) {
            onDiscovered.onDiscovered(stDiscoveryDevice);
        }
    }

    /* access modifiers changed from: private */
    public void onDisconnected(StConnectDevice stConnectDevice, int i) {
        for (IConnectCallback onDisconnected : this.mConnectList) {
            onDisconnected.onDisconnected(stConnectDevice, i);
        }
    }

    /* access modifiers changed from: private */
    public void onGoCreated(GoInfo goInfo) {
        for (IConnectCallback onP2pGoCreated : this.mConnectList) {
            onP2pGoCreated.onP2pGoCreated(goInfo);
        }
    }

    /* access modifiers changed from: private */
    public void onGoRemoved() {
        for (IConnectCallback onP2pGoRemoved : this.mConnectList) {
            onP2pGoRemoved.onP2pGoRemoved();
        }
    }

    private void trackConnectFail(StDevice stDevice, int i, int i2) {
        if (stDevice.getTerminalType() != 5) {
            if (i2 == 1 || i2 == 8) {
                TrackerManager.getInstance().getBluetoothConnectionTracker().result(stDevice.getTerminalType(), stDevice.getIdentifier2String(), i, String.valueOf(i)).peerModelID(stDevice.getModelID()).startReport();
            }
        }
    }

    private void trackConnected(StConnectDevice stConnectDevice, int i) {
        if (i == 1 || i == 2) {
            TrackerManager.getInstance().getBluetoothConnectionTracker().bleConnected(stConnectDevice.getTerminalType(), stConnectDevice.getIdentifier2String(), stConnectDevice.getModelID());
        } else if (i == 64) {
            TrackerManager.getInstance().getBluetoothConnectionTracker().btConnected(stConnectDevice.getTerminalType(), stConnectDevice.getIdentifier2String(), stConnectDevice.getModelID());
        }
    }

    public void addAuthCallback(IAuthCallback iAuthCallback) {
        Message.obtain(this.mHandler, 4, 1, 0, iAuthCallback).sendToTarget();
    }

    public void addConnectCallback(IConnectCallback iConnectCallback) {
        Message.obtain(this.mHandler, 1, 1, 0, iConnectCallback).sendToTarget();
    }

    public void addDelayLoseDevice(String str) {
        StLog.d(TAG, "addDelayLoseDevice, id = " + str);
        if (!TextUtils.isEmpty(str)) {
            this.mDeviceHitMac.remove(str);
        }
    }

    public void addDiscoveryInterceptor(IDiscoveryInterceptor iDiscoveryInterceptor) {
        Message.obtain(this.mHandler, 2, 1, 0, iDiscoveryInterceptor).sendToTarget();
    }

    public void addDiscoveryListener(IDiscoveryListener iDiscoveryListener) {
        Message.obtain(this.mHandler, 0, 1, 0, iDiscoveryListener).sendToTarget();
    }

    public void apCreated(WiFiApInfo wiFiApInfo) {
        Message obtain = Message.obtain(this.mHandler, 36);
        obtain.obj = wiFiApInfo;
        obtain.arg1 = 1;
        obtain.sendToTarget();
    }

    public void authDevice(StDevice stDevice) {
        Message obtain = Message.obtain(this.mHandler, 37);
        obtain.obj = stDevice;
        obtain.sendToTarget();
    }

    public void authDeviceMessage(StDevice stDevice, byte[] bArr) {
        Message obtain = Message.obtain(this.mHandler, 38);
        obtain.obj = new AuthMessage(stDevice, bArr);
        obtain.sendToTarget();
    }

    public void bleConnectForDiscovery(String str, boolean z) {
        if (!z) {
            this.mBleLinkedList.remove(str);
        } else if (!this.mBleLinkedList.contains(str)) {
            this.mBleLinkedList.add(str);
        }
        IDiscoveryConnectCallback iDiscoveryConnectCallback = this.mDiscoveryConnectCallback;
        if (iDiscoveryConnectCallback != null) {
            if (z) {
                iDiscoveryConnectCallback.onBleConnected(str, true);
            } else {
                iDiscoveryConnectCallback.onBleDisconnected(str);
            }
        }
    }

    public void calDeviceHit() {
        this.mHandler.removeMessages(3);
        long currentTimeMillis = System.currentTimeMillis();
        for (Map.Entry next : this.mDeviceHitMac.entrySet()) {
            Long l = (Long) next.getValue();
            String str = (String) next.getKey();
            if (currentTimeMillis - (l == null ? 0 : l.longValue()) > 15000) {
                StLog.v(TAG, "id:" + str + ",setMills:" + l);
                this.mDeviceHitMac.remove(str);
                onLose(str);
            }
        }
        if (this.mDeviceHitMac.size() > 0) {
            this.mHandler.sendEmptyMessageDelayed(3, 1000);
        }
    }

    public void connectFail(StDevice stDevice, int i, int i2) {
        if (stDevice == null) {
            StLog.i(TAG, "connectFail device is null");
            return;
        }
        trackConnectFail(stDevice, i, i2);
        Message obtain = Message.obtain(this.mHandler, 39);
        obtain.obj = stDevice;
        obtain.arg1 = i;
        obtain.arg2 = i2;
        obtain.sendToTarget();
    }

    public void goCreated(GoInfo goInfo) {
        Message obtain = Message.obtain(this.mHandler, 35);
        obtain.obj = goInfo;
        obtain.arg1 = 1;
        obtain.sendToTarget();
    }

    public void goRemoved() {
        Message.obtain(this.mHandler, 35).sendToTarget();
    }

    public boolean isBleLinked(String str) {
        return this.mBleLinkedList.contains(str);
    }

    public void notifyBondChange(StConnectDevice stConnectDevice, int i, int i2) {
        if (i != 0 || ((!stConnectDevice.isBleConnected() && !stConnectDevice.isP2pConnected()) || stConnectDevice.getDeviceType() != 1)) {
            Message obtain = Message.obtain(this.mHandler, 20);
            obtain.arg1 = i2;
            obtain.arg2 = i;
            obtain.obj = stConnectDevice;
            obtain.sendToTarget();
        }
    }

    public void onLose(String str) {
    }

    public void p2pConnectForDiscovery(StConnectDevice stConnectDevice, boolean z) {
        if (z) {
            this.mDiscoveryConnectCallback.onP2pGoConnected(stConnectDevice);
        } else {
            this.mDiscoveryConnectCallback.onP2pGoDisconnected(stConnectDevice);
        }
    }

    public void putDeviceHitMac(StDiscoveryDevice stDiscoveryDevice) {
        if (stDiscoveryDevice.getDeviceType() != 3 || stDiscoveryDevice.getDiscoveryType() != 16) {
            if (this.mDeviceHitMac.size() == 0) {
                this.mHandler.sendEmptyMessageDelayed(3, 1000);
            }
            this.mDeviceHitMac.put(stDiscoveryDevice.getIdentifier2String(), Long.valueOf(System.currentTimeMillis()));
        }
    }

    public void removeAuthCallback(IAuthCallback iAuthCallback) {
        Message.obtain(this.mHandler, 4, iAuthCallback).sendToTarget();
    }

    public void removeConnectCallback(IConnectCallback iConnectCallback) {
        Message.obtain(this.mHandler, 0, iConnectCallback).sendToTarget();
    }

    public void removeDelayLoseDevice(String str) {
        StLog.d(TAG, "removeDelayLoseDevice, id = " + str);
        if (!TextUtils.isEmpty(str) && !this.mDeviceHitMac.containsKey(str)) {
            onLose(str);
        }
    }

    public void removeDiscoveryInterceptor(IDiscoveryInterceptor iDiscoveryInterceptor) {
        Message.obtain(this.mHandler, 2, iDiscoveryInterceptor).sendToTarget();
    }

    public void removeDiscoveryListener(IDiscoveryListener iDiscoveryListener) {
        Message.obtain(this.mHandler, 0, iDiscoveryListener).sendToTarget();
    }

    public void setDiscoveryConnectCallback(IDiscoveryConnectCallback iDiscoveryConnectCallback) {
        this.mDiscoveryConnectCallback = iDiscoveryConnectCallback;
    }

    public void onLose(StDiscoveryDevice stDiscoveryDevice) {
        boolean z;
        byte discoveryType = stDiscoveryDevice.getDiscoveryType();
        if ((discoveryType & 1) == 0 || (discoveryType & 16) == 0) {
            StLog.d(TAG, "onLose = " + stDiscoveryDevice);
            z = false;
        } else {
            stDiscoveryDevice.setDiscType((byte) 16);
            StLog.d(TAG, "refound = " + stDiscoveryDevice);
            z = true;
        }
        for (IDiscoveryListener next : this.mDiscoveryList) {
            if (z) {
                StarryDeviceManager.getInstance().discoveryDevice(stDiscoveryDevice);
            } else {
                next.onLost(stDiscoveryDevice);
            }
        }
    }
}
