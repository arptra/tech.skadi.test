package com.upuphone.starrynet.strategy.channel.simpleble;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.ArrayMap;
import androidx.annotation.NonNull;
import androidx.core.util.Consumer;
import com.honey.account.b7.b;
import com.upuphone.starrynet.api.StErrorCode;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.core.ble.client.BleClientCache;
import com.upuphone.starrynet.core.ble.client.BleConnectConfig;
import com.upuphone.starrynet.core.ble.client.BleConnectManager;
import com.upuphone.starrynet.core.ble.client.response.BleConnectResponse;
import com.upuphone.starrynet.core.ble.client.response.BleNotifyResponse;
import com.upuphone.starrynet.core.ble.event.BleEventBus;
import com.upuphone.starrynet.core.ble.event.EventReceiver;
import com.upuphone.starrynet.core.ble.event.ExternalClientConnectionChangeEvent;
import com.upuphone.starrynet.core.ble.event.RingConnectStateEvent;
import com.upuphone.starrynet.core.ble.utils.BluetoothUtils;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.channel.IChannelCallback;
import com.upuphone.starrynet.strategy.channel.IConnectChannel;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.discovery.RingReconnBackgroundScanManager;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public abstract class SimpleBleClientChannel implements IConnectChannel, EventReceiver {
    private static final int MSG_CHECK_READY_TIMEOUT = 1;
    private static final int STATE_BLE_CONNECTED = 1;
    private static final int STATE_BONDED = 4;
    private static final int STATE_HID_HOST_CONNECT = 2;
    private static final String TAG = "SimpleBleClientChannel";
    private RingReconnBackgroundScanManager mBackgroundScanner = RingReconnBackgroundScanManager.getInstance();
    protected IChannelCallback mChannelCallback;
    private Map<String, BluetoothDevice> mConnectedACLDevices = new HashMap();
    /* access modifiers changed from: private */
    public Map<String, Boolean> mConnectingDeviceMap = new HashMap();
    private Handler mHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(@NonNull Message message) {
            if (message.what == 1) {
                StLog.w(SimpleBleClientChannel.TAG, "handleMessage ,1 check ready timeout!");
                String str = (String) message.obj;
                StConnectDevice stConnectDevice = (StConnectDevice) SimpleBleClientChannel.this.mTempDevices.remove(str);
                if (SimpleBleClientChannel.this.mChannelCallback != null && stConnectDevice != null) {
                    StLog.w(SimpleBleClientChannel.TAG, "handleMessage ,2 check ready timeout!");
                    StarryDeviceManager.getInstance().connectFail(stConnectDevice.getDevice(), StErrorCode.CONNECT_STRATEGY_BLE_CONNECT_FAIL, 1);
                    BleConnectManager.getInstance().disconnect(str);
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public Map<String, StConnectDevice> mTempDevices = new HashMap();
    protected HashMap<UUID, List<UUID>> notifyMap = new HashMap<>();
    private Map<String, Integer> statesMap = new ArrayMap();

    public SimpleBleClientChannel() {
        BleEventBus.get().register(ExternalClientConnectionChangeEvent.class, this);
        BleEventBus.get().register(RingConnectStateEvent.class, this);
    }

    /* access modifiers changed from: private */
    public void checkNotify(StDevice stDevice) {
        Iterator<Map.Entry<UUID, List<UUID>>> it = this.notifyMap.entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry next = it.next();
            List list = (List) next.getValue();
            if (list.isEmpty()) {
                it.remove();
                checkNotify(stDevice);
                return;
            }
            UUID uuid = (UUID) list.remove(0);
            openNotify(stDevice, (UUID) next.getKey(), uuid, new b(this, stDevice, uuid));
            return;
        }
        onConnectResult(stDevice, 0, "connect success!");
    }

    @SuppressLint({"MissingPermission"})
    private void checkReady(String str) {
        Integer num = this.statesMap.get(str);
        if (num != null) {
            int intValue = num.intValue();
            if ((intValue & 2) <= 0) {
                StLog.d(TAG, "checkReady, hid host not connected, mac=" + str);
            } else if ((intValue & 1) <= 0) {
                StLog.d(TAG, "checkReady, ble not connected, mac=" + str);
            } else if ((intValue & 4) > 0) {
                StConnectDevice remove = this.mTempDevices.remove(str);
                IChannelCallback iChannelCallback = this.mChannelCallback;
                if (iChannelCallback != null && remove != null) {
                    iChannelCallback.onConnected(remove, this);
                    this.mBackgroundScanner.bondedInd(str);
                    StLog.d(TAG, "onConnected 1");
                    this.mHandler.removeMessages(1);
                }
            } else {
                BluetoothDevice remoteDevice = BluetoothUtils.getRemoteDevice(str);
                if (remoteDevice == null || remoteDevice.getBondState() != 12) {
                    StLog.d(TAG, "checkReady,  not in bonded, mac=" + str);
                    return;
                }
                StConnectDevice remove2 = this.mTempDevices.remove(str);
                if (this.mChannelCallback != null && remove2 != null) {
                    StLog.d(TAG, "onConnected 2");
                    this.mChannelCallback.onConnected(remove2, this);
                    this.mHandler.removeMessages(1);
                }
            }
        }
    }

    private boolean createOrRemoveBond(boolean z, BluetoothDevice bluetoothDevice) {
        try {
            BluetoothDevice.class.getMethod(z ? "createBond" : "removeBond", (Class[]) null).invoke(bluetoothDevice, (Object[]) null);
            return true;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return false;
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
            return false;
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            return false;
        }
    }

    private void handleRingConnectEvent(RingConnectStateEvent ringConnectStateEvent) {
        String bleMac = ringConnectStateEvent.getBleMac();
        Integer num = this.statesMap.get(bleMac);
        int i = 0;
        int intValue = num != null ? num.intValue() : 0;
        StLog.d(TAG, "handleRingConnectEvent ,ble mac=%s, state=%d", bleMac, Integer.valueOf(ringConnectStateEvent.getState()));
        switch (ringConnectStateEvent.getState()) {
            case 1:
                i = intValue | 4;
                break;
            case 2:
                if (ringConnectStateEvent.getDevice() != null) {
                    StLog.d(TAG, "acl connected,put bluetooth device");
                    this.mConnectedACLDevices.put(ringConnectStateEvent.getBleMac(), ringConnectStateEvent.device);
                    break;
                }
                break;
            case 3:
                StConnectDevice remove = this.mTempDevices.remove(bleMac);
                if (!(remove == null || this.mChannelCallback == null)) {
                    StarryDeviceManager.getInstance().connectFail(remove.getDevice(), StErrorCode.CONNECT_STRATEGY_BLE_CONNECT_FAIL, 1);
                    this.mHandler.removeMessages(1);
                }
                this.mConnectedACLDevices.remove(ringConnectStateEvent.getBleMac());
                i = -1;
                break;
            case 4:
                i = intValue | 2;
                break;
            case 5:
                i = intValue | 1;
                break;
            case 6:
                this.statesMap.clear();
                this.mConnectedACLDevices.clear();
                return;
            case 7:
                this.mBackgroundScanner.bondedInd(bleMac);
                break;
            case 8:
                this.mBackgroundScanner.unbindInd();
                break;
            case 9:
                this.mBackgroundScanner.connectInd(bleMac);
                break;
            case 10:
                this.mBackgroundScanner.disconnectLinkLoss();
                break;
            default:
                return;
        }
        i = intValue;
        if (i >= 0) {
            this.statesMap.put(bleMac, Integer.valueOf(i));
            checkReady(bleMac);
            return;
        }
        this.statesMap.remove(bleMac);
    }

    private boolean isConnecting(String str) {
        Boolean bool = this.mConnectingDeviceMap.get(str);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$checkNotify$0(StDevice stDevice, UUID uuid, Boolean bool) {
        if (bool.booleanValue()) {
            checkNotify(stDevice);
            return;
        }
        onConnectResult(stDevice, -9, "open notify " + uuid + " fail!");
    }

    /* access modifiers changed from: private */
    public void onConnectResult(StDevice stDevice, int i, String str) {
        if (i == 0) {
            StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(stDevice.getIdentifier());
            if (connectDevice == null) {
                connectDevice = new StConnectDevice();
                connectDevice.setDevice(stDevice);
            }
            connectDevice.setBleMac(stDevice.getBleMac());
            connectDevice.setDeviceType((byte) 4);
            this.mTempDevices.put(stDevice.getBleMac(), connectDevice);
            handleRingConnectEvent(new RingConnectStateEvent(stDevice.getBleMac(), 5));
            if (createBond(stDevice)) {
                StLog.d(TAG, "set bonding");
                StarryDeviceManager.getInstance().updateBondInfo(connectDevice, 3);
            }
            if (this.mTempDevices.get(stDevice.getBleMac()) != null) {
                Message obtainMessage = this.mHandler.obtainMessage(1, stDevice.getBleMac());
                StLog.d(TAG, "sendMessageDelay");
                this.mHandler.sendMessageDelayed(obtainMessage, 30000);
                return;
            }
            return;
        }
        StLog.i(TAG, "onConnectResult error " + str);
        StarryDeviceManager.getInstance().connectFail(stDevice, StErrorCode.CONNECT_STRATEGY_BLE_CONNECT_FAIL, 1);
    }

    private void openNotify(StDevice stDevice, UUID uuid, UUID uuid2, Consumer<Boolean> consumer) {
        final StDevice stDevice2 = stDevice;
        final UUID uuid3 = uuid;
        final UUID uuid4 = uuid2;
        final Consumer<Boolean> consumer2 = consumer;
        BleConnectManager.getInstance().notify(stDevice.getBleMac(), uuid, uuid2, new BleNotifyResponse() {
            public void onResponse(int i, Void voidR) {
                if (i == 0) {
                    StLog.d(SimpleBleClientChannel.TAG, "open notify(%s) success, service =%s, character = %s", stDevice2.getBleMac(), uuid3.toString(), uuid4.toString());
                } else {
                    StLog.w(SimpleBleClientChannel.TAG, "open notify(%s) fail, service =%s, character = %s", stDevice2.getBleMac(), uuid3.toString(), uuid4.toString());
                }
                Consumer consumer = consumer2;
                if (consumer != null) {
                    consumer.accept(Boolean.valueOf(i == 0));
                }
            }
        });
    }

    public int connect(StDevice stDevice) {
        if (stDevice == null) {
            StLog.w(TAG, "connect , device is null!");
            return StErrorCode.CONNECT_STRATEGY_BLE_CONNECT_PARAM_ERROR;
        }
        final StDevice clone = stDevice.clone();
        if (isConnecting(clone.getBleMac())) {
            StLog.w(TAG, "connectBle method isDoing ,so ignore this connect request!");
            return 0;
        } else if (BleClientCache.getInstance().isClientConnected(clone.getBleMac())) {
            StLog.w(TAG, "connectBle: device(%s) isConnected, so ignore this connect request!", clone.getBleMac());
            return 0;
        } else {
            BleClientCache.getInstance().markExternalDevice(clone.getBleMac(), true);
            this.mConnectingDeviceMap.put(clone.getBleMac(), Boolean.TRUE);
            BleConnectManager.getInstance().connect(getConnectConfig(clone), (BleConnectResponse) new BleConnectResponse() {
                public void onResponse(int i, Bundle bundle) {
                    SimpleBleClientChannel.this.mConnectingDeviceMap.remove(clone.getBleMac());
                    if (i == 0) {
                        StLog.d(SimpleBleClientChannel.TAG, "connect ble success");
                        SimpleBleClientChannel simpleBleClientChannel = SimpleBleClientChannel.this;
                        simpleBleClientChannel.notifyMap = simpleBleClientChannel.getNeedNotifyCharacterMap();
                        if (SimpleBleClientChannel.this.notifyMap.size() > 0) {
                            SimpleBleClientChannel.this.checkNotify(clone);
                            return;
                        }
                        StLog.d(SimpleBleClientChannel.TAG, "notify map size is 0");
                        SimpleBleClientChannel.this.onConnectResult(clone, 0, "connect success!");
                        return;
                    }
                    SimpleBleClientChannel simpleBleClientChannel2 = SimpleBleClientChannel.this;
                    StDevice stDevice = clone;
                    simpleBleClientChannel2.onConnectResult(stDevice, StErrorCode.CONNECT_STRATEGY_BLE_CONNECT_FAIL, "connect ble fail, code=" + i);
                }
            });
            return 0;
        }
    }

    @SuppressLint({"MissingPermission"})
    public boolean createBond(StDevice stDevice) {
        if (stDevice == null) {
            StLog.w(TAG, "createBond , StDevice is null, something may be wrong");
            return false;
        }
        BluetoothDevice remoteDevice = BluetoothUtils.getRemoteDevice(stDevice.getBleMac());
        if (remoteDevice == null) {
            StLog.w(TAG, "get remoteDevice by bleMac(%s) is null", stDevice.getBleMac());
            remoteDevice = this.mConnectedACLDevices.get(stDevice.getBleMac());
        }
        if (remoteDevice == null) {
            StLog.w(TAG, "createBond fail, cannot get bluetooth device object!!!");
            return false;
        } else if (remoteDevice.getBondState() != 12) {
            StLog.d(TAG, "start createBond");
            return createOrRemoveBond(true, remoteDevice);
        } else {
            StLog.w(TAG, "bluetooth device(%s,%s)  ,  bond state =%d", remoteDevice.getName(), remoteDevice.getAddress(), Integer.valueOf(remoteDevice.getBondState()));
            return false;
        }
    }

    public int disconnect(StDevice stDevice) {
        BleConnectManager.getInstance().disconnect(stDevice.getBleMac());
        return 0;
    }

    public abstract BleConnectConfig getConnectConfig(StDevice stDevice);

    public abstract HashMap<UUID, List<UUID>> getNeedNotifyCharacterMap();

    public int getProfile() {
        return 22;
    }

    public void onEvent(Object obj) {
        if (obj instanceof ExternalClientConnectionChangeEvent) {
            ExternalClientConnectionChangeEvent externalClientConnectionChangeEvent = (ExternalClientConnectionChangeEvent) obj;
            if (!externalClientConnectionChangeEvent.isConnected() && this.mChannelCallback != null) {
                StConnectDevice connectDeviceByBleMac = StarryDeviceManager.getInstance().getConnectDeviceByBleMac(externalClientConnectionChangeEvent.getMac());
                if (connectDeviceByBleMac == null) {
                    StLog.w(TAG, "onBleDisconnected device info is null");
                } else {
                    this.mChannelCallback.onDisconnected(connectDeviceByBleMac, this);
                }
            }
        } else if (obj instanceof RingConnectStateEvent) {
            handleRingConnectEvent((RingConnectStateEvent) obj);
        }
    }

    public void setCallback(IChannelCallback iChannelCallback) {
        this.mChannelCallback = iChannelCallback;
    }
}
