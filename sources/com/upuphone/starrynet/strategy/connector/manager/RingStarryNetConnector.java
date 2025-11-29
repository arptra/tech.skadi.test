package com.upuphone.starrynet.strategy.connector.manager;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.util.Log;
import androidx.core.util.Consumer;
import com.upuphone.starrynet.api.StErrorCode;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.api.message.IMessageResponseListener;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.ByteUtils;
import com.upuphone.starrynet.common.utils.Utils;
import com.upuphone.starrynet.core.ble.BluetoothConstants;
import com.upuphone.starrynet.core.ble.client.BleClientCache;
import com.upuphone.starrynet.core.ble.client.BleConnectConfig;
import com.upuphone.starrynet.core.ble.client.BleConnectManager;
import com.upuphone.starrynet.core.ble.client.response.BleConnectResponse;
import com.upuphone.starrynet.core.ble.client.response.BleNotifyResponse;
import com.upuphone.starrynet.core.ble.event.BleEventBus;
import com.upuphone.starrynet.core.ble.event.CharacterChangedEvent;
import com.upuphone.starrynet.core.ble.event.EventReceiver;
import com.upuphone.starrynet.core.ble.event.ExternalClientConnectionChangeEvent;
import com.upuphone.starrynet.core.ble.utils.BluetoothUtils;
import com.upuphone.starrynet.core.ble.utils.UUIDUtils;
import com.upuphone.starrynet.payload.MessageUtil;
import com.upuphone.starrynet.payload.PayloadConstant;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.message.payload.PayloadMessage;
import com.upuphone.starrynet.strategy.message.payload.PayloadMessageManager;
import com.upuphone.starrynet.strategy.message.payload.handler.RingDataUtil;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

@SuppressLint({"MissingPermission"})
public class RingStarryNetConnector implements EventReceiver {
    public static final UUID RING_SERVICE_UUID = UUIDUtils.makeUUID(65296);
    public static final UUID RING_WRITE_NOTIFY_UUID = UUIDUtils.makeUUID(65297);
    private static final String TAG = "RingStarryNetConnector";
    /* access modifiers changed from: private */
    public boolean isConnecting = false;
    /* access modifiers changed from: private */
    public String mBleMac;
    private boolean mIsInit = false;

    /* access modifiers changed from: private */
    public void createOrRemoveBond(boolean z, BluetoothDevice bluetoothDevice) {
        try {
            BluetoothDevice.class.getMethod(z ? "createBond" : "removeBond", (Class[]) null).invoke(bluetoothDevice, (Object[]) null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        }
    }

    private void init() {
        if (!this.mIsInit) {
            this.mIsInit = true;
            BleEventBus.get().register(ExternalClientConnectionChangeEvent.class, this);
        }
    }

    /* access modifiers changed from: private */
    public void log(String str, Object... objArr) {
        StLog.d(TAG, str, objArr);
    }

    /* access modifiers changed from: private */
    public void logWarning(String str, Object... objArr) {
        StLog.w(TAG, str, objArr);
    }

    /* access modifiers changed from: private */
    public void openBatteryNotify() {
        BleConnectManager.getInstance().notify(this.mBleMac, BluetoothConstants.BATTERY_SERVICE, BluetoothConstants.BATTERY_LEVEL_CHARACTER, new BleNotifyResponse() {
            public void onResponse(int i, Void voidR) {
                if (i == 0) {
                    RingStarryNetConnector.this.log("openBatteryNotify success", new Object[0]);
                } else {
                    RingStarryNetConnector.this.logWarning("open battery notify fail, code =%d", Integer.valueOf(i));
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void openNotify(final StDevice stDevice) {
        BleConnectManager.getInstance().notify(this.mBleMac, RING_SERVICE_UUID, RING_WRITE_NOTIFY_UUID, new BleNotifyResponse() {
            public void onResponse(int i, Void voidR) {
                if (i == 0) {
                    RingStarryNetConnector.this.log("open ring notify success", new Object[0]);
                    StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(stDevice.getIdentifier());
                    if (connectDevice == null) {
                        connectDevice = new StConnectDevice();
                        connectDevice.setDevice(stDevice);
                    }
                    connectDevice.setBleMac(RingStarryNetConnector.this.mBleMac);
                    StarryDeviceManager.getInstance().deviceConnected(connectDevice, 2);
                    RingStarryNetConnector.this.createBond(stDevice);
                    RingStarryNetConnector.this.openBatteryNotify();
                    return;
                }
                StarryDeviceManager.getInstance().connectFail(stDevice, StErrorCode.CONNECT_STRATEGY_BLE_CONNECT_FAIL, 1);
                RingStarryNetConnector.this.logWarning("open ring notify fail, code =%d", Integer.valueOf(i));
            }
        });
    }

    private void startOta() {
        Log.d(TAG, "start ota");
        PayloadMessageManager.getInstance().sendMessage(new PayloadMessage(this.mBleMac, MessageUtil.buildProtocolMessage2Bytes(1, 3, PayloadConstant.PARAMS_KEY_STR_OTA_FILE_URL, "sjdl"), 1, RING_SERVICE_UUID, RING_WRITE_NOTIFY_UUID, new IMessageResponseListener() {
            public void onFail(int i, String str) {
                Log.d(RingStarryNetConnector.TAG, String.format("onFail code=%d, msg =%s", new Object[]{Integer.valueOf(i), str}));
            }

            public void onSuccess() {
                Log.d(RingStarryNetConnector.TAG, "ota onSuccess");
            }
        }));
    }

    public void connectBle(final StDevice stDevice) {
        init();
        if (this.isConnecting) {
            StLog.w(TAG, "connectBle method isDoing ,so ignore this connect request!");
        } else if (BleClientCache.getInstance().isClientConnected(stDevice.getBleMac())) {
            StLog.w(TAG, "connectBle: device(%s) isConnected, so ignore this connect request!", stDevice.getBleMac());
        } else {
            BleClientCache.getInstance().markExternalDevice(stDevice.getBleMac(), true);
            this.isConnecting = true;
            BleConnectConfig bleConnectConfig = new BleConnectConfig(stDevice.getBleMac());
            bleConnectConfig.openHighSpeed(false);
            bleConnectConfig.checkDestCharacterUUID(PayloadConstant.STARRY_NET_PAYLOAD_RING_CHARACTER_UUID);
            BleConnectManager.getInstance().connect(bleConnectConfig, (BleConnectResponse) new BleConnectResponse() {
                public void onResponse(int i, Bundle bundle) {
                    boolean unused = RingStarryNetConnector.this.isConnecting = false;
                    if (i == 0) {
                        RingStarryNetConnector.this.log("connect ring success.", new Object[0]);
                        String unused2 = RingStarryNetConnector.this.mBleMac = stDevice.getBleMac();
                        RingStarryNetConnector.this.openNotify(stDevice);
                        return;
                    }
                    StarryDeviceManager.getInstance().connectFail(stDevice, StErrorCode.CONNECT_STRATEGY_BLE_CONNECT_FAIL, 1);
                    RingStarryNetConnector.this.logWarning("connect ring fail, ble mac=%s, code=%d", stDevice.getBleMac(), Integer.valueOf(i));
                }
            });
        }
    }

    public void createBond(StDevice stDevice) {
        if (stDevice == null) {
            StLog.w(TAG, "createBond , StDevice is null, something may be wrong");
            return;
        }
        BluetoothDevice remoteDevice = BluetoothUtils.getRemoteDevice(stDevice.getBleMac());
        if (remoteDevice == null || remoteDevice.getBondState() == 12) {
            StLog.w(TAG, "bluetooth device(%s,%s)  in bond_bonded state ,so no need to create bond!", stDevice.getDeviceName(), stDevice.getBleMac());
        } else {
            createOrRemoveBond(true, remoteDevice);
        }
    }

    public void disconnectBle(StDevice stDevice) {
        this.mIsInit = false;
        BleEventBus.get().unregister(CharacterChangedEvent.class, this);
        BleConnectManager.getInstance().disconnect(stDevice.getBleMac());
    }

    public void onEvent(Object obj) {
        if (obj instanceof ExternalClientConnectionChangeEvent) {
            ExternalClientConnectionChangeEvent externalClientConnectionChangeEvent = (ExternalClientConnectionChangeEvent) obj;
            if (!externalClientConnectionChangeEvent.isConnected() && externalClientConnectionChangeEvent.getMac().equalsIgnoreCase(this.mBleMac)) {
                StConnectDevice connectDeviceByBleMac = StarryDeviceManager.getInstance().getConnectDeviceByBleMac(this.mBleMac);
                StLog.d(TAG, "receive ExternalClientConnectionChangeEvent, stConnect Device =" + connectDeviceByBleMac);
                if (connectDeviceByBleMac != null) {
                    StarryDeviceManager.getInstance().deviceDisconnected(connectDeviceByBleMac, 2);
                } else {
                    StLog.w(TAG, "receive %s disconnected event, but cannot find StConnectDevice obj by ble mac.", this.mBleMac);
                }
            }
        }
    }

    public void removeBond(StDevice stDevice) {
        if (stDevice == null) {
            StLog.w(TAG, "removeBond , StDevice is null, something may be wrong");
            return;
        }
        final BluetoothDevice remoteDevice = BluetoothUtils.getRemoteDevice(stDevice.getBleMac());
        if (remoteDevice.getBondState() == 12) {
            PayloadMessageManager.getInstance().sendInternalMessage(stDevice.getBleMac(), 1, (byte) 38, RingDataUtil.notifyReadyRemoveBond(Utils.getBytesFromAddress(this.mBleMac)), new Consumer<byte[]>() {
                public void accept(byte[] bArr) {
                    if (bArr != null) {
                        StLog.d(RingStarryNetConnector.TAG, "receive notify data =" + ByteUtils.byteToString(bArr));
                    }
                    RingStarryNetConnector.this.createOrRemoveBond(false, remoteDevice);
                }
            });
            return;
        }
        StLog.w(TAG, "bluetooth device(%s,%s) not in bond_bonded state ,so no need to remove bond!", stDevice.getDeviceName(), stDevice.getBleMac());
    }
}
