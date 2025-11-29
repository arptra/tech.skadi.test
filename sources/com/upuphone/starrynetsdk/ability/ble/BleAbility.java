package com.upuphone.starrynetsdk.ability.ble;

import androidx.annotation.Nullable;
import com.upuphone.hub.Hub;
import com.upuphone.hub.HubRemoteException;
import com.upuphone.hub.HubTargetException;
import com.upuphone.runasone.ble.ApiProxy;
import com.upuphone.runasone.ble.BleRawDevice;
import com.upuphone.runasone.ble.BleRawSession;
import com.upuphone.runasone.ble.ConnectConfig;
import com.upuphone.runasone.ble.DeviceCallback;
import com.upuphone.runasone.ble.InitSessionCallback;
import com.upuphone.runasone.ble.MtuCallback;
import com.upuphone.runasone.ble.OpenNotifyCallback;
import com.upuphone.runasone.ble.ReadCallback;
import com.upuphone.runasone.ble.SessionCallback;
import com.upuphone.runasone.ble.SessionConfig;
import com.upuphone.runasone.ble.WriteCallback;
import com.upuphone.starrynetsdk.api.Ability;
import com.upuphone.starrynetsdk.api.Camp;
import com.upuphone.starrynetsdk.api.ErrorCode;
import com.upuphone.starrynetsdk.api.SNSLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BleAbility extends Ability {
    private static final String TAG = "BleAbility";
    private final ApiProxy api = new ApiProxy();
    private String deviceId;
    /* access modifiers changed from: private */
    public BleDeviceListener deviceListener;
    /* access modifiers changed from: private */
    public BleSessionListener sessionListener;

    public BleAbility() {
        Camp.getInstance().addSentry(this);
    }

    public int connect(ConnectConfig connectConfig) {
        SNSLog.d(TAG, String.format("connect device %s.", new Object[]{this.deviceId}));
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable , connect failed.");
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            this.api.connect(this.deviceId, connectConfig);
            return 0;
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "connect failed.", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "connect failed.", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }

    public int disconnect() {
        SNSLog.d(TAG, String.format("disconnect device %s.", new Object[]{this.deviceId}));
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable , disconnect failed.");
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            this.api.disconnect(this.deviceId);
            return 0;
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "disconnect failed.", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "disconnect failed.", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }

    public List<BleDevice> getFoundDevices(@Nullable String str) {
        SNSLog.d(TAG, "getFoundDevices");
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,getFoundDevices failed.");
            return null;
        }
        try {
            ArrayList<BleRawDevice> foundDeviceList = this.api.getFoundDeviceList(str);
            ArrayList arrayList = new ArrayList();
            Iterator<BleRawDevice> it = foundDeviceList.iterator();
            while (it.hasNext()) {
                arrayList.add(BleDevice.wrap(it.next()));
            }
            return arrayList;
        } catch (HubRemoteException | HubTargetException e) {
            SNSLog.e(TAG, "getFoundDevices failed.", e);
            return null;
        }
    }

    public int initSession(SessionConfig sessionConfig, final BleInitSessionListener bleInitSessionListener) {
        SNSLog.d(TAG, "initSession, identifier = " + this.deviceId);
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,initSession failed.");
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            this.api.initSession(this.deviceId, sessionConfig, new InitSessionCallback() {
                public void onInit(int i) {
                    BleInitSessionListener bleInitSessionListener = bleInitSessionListener;
                    if (bleInitSessionListener != null) {
                        bleInitSessionListener.onInit(i);
                    }
                }
            });
            return 0;
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "initSession failed.", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "initSession failed.", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }

    public void onInstalled(Hub hub) {
        super.onInstalled(hub);
        this.api.setHub(hub);
        if (this.deviceListener != null) {
            SNSLog.d(TAG, String.format("registerDeviceListener from restore to device %s.", new Object[]{this.deviceId}));
            try {
                this.api.registerDeviceCallback(this.deviceId, new DeviceCallback() {
                    public void onConnected(BleRawSession bleRawSession) {
                        if (BleAbility.this.deviceListener != null) {
                            BleAbility.this.deviceListener.onConnected(BleSession.warp(bleRawSession));
                        }
                    }

                    public void onDisconnected(int i) {
                        if (BleAbility.this.deviceListener != null) {
                            BleAbility.this.deviceListener.onDisconnected(i);
                        }
                    }

                    public void onError(int i) {
                        if (BleAbility.this.deviceListener != null) {
                            BleAbility.this.deviceListener.onError(i);
                        }
                    }

                    public void onLose() {
                        if (BleAbility.this.deviceListener != null) {
                            BleAbility.this.deviceListener.onLose();
                        }
                    }
                });
            } catch (HubRemoteException | HubTargetException e) {
                SNSLog.e(TAG, "registerDeviceCallback failed.", e);
            }
        }
        if (this.sessionListener != null) {
            SNSLog.d(TAG, String.format("registerSessionListener from restore to device %s.", new Object[]{this.deviceId}));
            try {
                this.api.registerSessionCallback(this.deviceId, new SessionCallback() {
                    public void onNotify(String str, byte[] bArr) {
                        if (BleAbility.this.sessionListener != null) {
                            BleAbility.this.sessionListener.onNotify(str, bArr);
                        }
                    }
                });
            } catch (HubRemoteException | HubTargetException e2) {
                SNSLog.e(TAG, "registerSessionListener failed.", e2);
            }
        }
    }

    public int openNotify(String str, final BleOpenNotifyListener bleOpenNotifyListener) {
        SNSLog.d(TAG, "ble setMtu, identifier=" + this.deviceId);
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,setMtu failed.");
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            this.api.openNotify(this.deviceId, str, new OpenNotifyCallback() {
                public void onOpen(int i) {
                    BleOpenNotifyListener bleOpenNotifyListener = bleOpenNotifyListener;
                    if (bleOpenNotifyListener != null) {
                        bleOpenNotifyListener.onOpen(i);
                    }
                }
            });
            return 0;
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "openNotify failed.", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "openNotify failed.", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }

    public int read(String str, final BleReadListener bleReadListener) {
        SNSLog.d(TAG, "ble read data, identifier=" + this.deviceId);
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,ble read failed.");
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            this.api.read(this.deviceId, str, new ReadCallback() {
                public void onRead(int i, byte[] bArr) {
                    BleReadListener bleReadListener = bleReadListener;
                    if (bleReadListener != null) {
                        bleReadListener.onRead(i, bArr);
                    }
                }
            });
            return 0;
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "read failed.", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "read failed.", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }

    public void registerDeviceListener(final BleDeviceListener bleDeviceListener) {
        SNSLog.d(TAG, String.format("registerDeviceListener from user to device %s.", new Object[]{this.deviceId}));
        this.deviceListener = bleDeviceListener;
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable , registerDeviceListener failed.");
            return;
        }
        try {
            this.api.registerDeviceCallback(this.deviceId, new DeviceCallback() {
                public void onConnected(BleRawSession bleRawSession) {
                    if (bleDeviceListener != null) {
                        bleDeviceListener.onConnected(BleSession.warp(bleRawSession));
                    }
                }

                public void onDisconnected(int i) {
                    BleDeviceListener bleDeviceListener = bleDeviceListener;
                    if (bleDeviceListener != null) {
                        bleDeviceListener.onDisconnected(i);
                    }
                }

                public void onError(int i) {
                    BleDeviceListener bleDeviceListener = bleDeviceListener;
                    if (bleDeviceListener != null) {
                        bleDeviceListener.onError(i);
                    }
                }

                public void onLose() {
                    BleDeviceListener bleDeviceListener = bleDeviceListener;
                    if (bleDeviceListener != null) {
                        bleDeviceListener.onLose();
                    }
                }
            });
        } catch (HubRemoteException | HubTargetException e) {
            SNSLog.e(TAG, "registerDeviceCallback failed.", e);
        }
    }

    public void registerSessionListener(final BleSessionListener bleSessionListener) {
        SNSLog.d(TAG, String.format("registerSessionListener from user to device %s.", new Object[]{this.deviceId}));
        this.sessionListener = bleSessionListener;
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,registerSessionListener failed.");
            return;
        }
        try {
            this.api.registerSessionCallback(this.deviceId, new SessionCallback() {
                public void onNotify(String str, byte[] bArr) {
                    BleSessionListener bleSessionListener = bleSessionListener;
                    if (bleSessionListener != null) {
                        bleSessionListener.onNotify(str, bArr);
                    }
                }
            });
        } catch (HubRemoteException | HubTargetException e) {
            SNSLog.e(TAG, "registerSessionListener failed.", e);
        }
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public int setMtu(int i, final BleMtuListener bleMtuListener) {
        SNSLog.d(TAG, "ble setMtu, identifier=" + this.deviceId);
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,setMtu failed.");
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            this.api.setMtu(this.deviceId, i, new MtuCallback() {
                public void onMtuChange(int i, int i2) {
                    BleMtuListener bleMtuListener = bleMtuListener;
                    if (bleMtuListener != null) {
                        bleMtuListener.onMtuChange(i, i2);
                    }
                }
            });
            return 0;
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "setMtu failed.", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "setMtu failed.", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }

    public void unregisterDeviceListener() {
        SNSLog.d(TAG, String.format("unregisterDeviceListener from user to device %s.", new Object[]{this.deviceId}));
        this.deviceListener = null;
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable , unregisterDeviceListener failed.");
            return;
        }
        try {
            this.api.unregisterDeviceCallback(this.deviceId);
        } catch (HubRemoteException | HubTargetException e) {
            SNSLog.e(TAG, "unregisterDeviceCallback failed.", e);
        }
    }

    public void unregisterSessionListener() {
        SNSLog.d(TAG, String.format("unregisterSessionListener from user to device %s.", new Object[]{this.deviceId}));
        this.sessionListener = null;
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,unregisterSessionListener failed.");
            return;
        }
        try {
            this.api.unregisterSessionCallback(this.deviceId);
        } catch (HubRemoteException | HubTargetException e) {
            SNSLog.e(TAG, "unregisterSessionListener failed.", e);
        }
    }

    public int write(String str, byte[] bArr, final BleWriteListener bleWriteListener) {
        SNSLog.d(TAG, "write, identifier = " + this.deviceId);
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable , ble write failed.");
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            this.api.write(this.deviceId, str, bArr, new WriteCallback() {
                public void onWrite(int i) {
                    BleWriteListener bleWriteListener = bleWriteListener;
                    if (bleWriteListener != null) {
                        bleWriteListener.onWrite(i);
                    }
                }
            });
            return 0;
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "write failed.", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "write failed.", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }
}
