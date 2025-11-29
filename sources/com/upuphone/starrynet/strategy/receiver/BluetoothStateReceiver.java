package com.upuphone.starrynet.strategy.receiver;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHidHost;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.UserHandle;
import android.text.TextUtils;
import androidx.core.util.Pair;
import com.upuphone.runasone.uupcast.CaptureType;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.core.ble.client.BleClientCache;
import com.upuphone.starrynet.core.ble.client.BleConnectManager;
import com.upuphone.starrynet.core.ble.event.BleEventBus;
import com.upuphone.starrynet.core.ble.event.DisconnectRingEvent;
import com.upuphone.starrynet.core.ble.event.EventReceiver;
import com.upuphone.starrynet.core.ble.event.MYVURingEvent;
import com.upuphone.starrynet.core.ble.event.RingConnectStateEvent;
import com.upuphone.starrynet.core.ble.utils.BluetoothUtils;
import com.upuphone.starrynet.core.bredr.BrEdrDeviceManager;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"MissingPermission"})
public class BluetoothStateReceiver extends BroadcastReceiver implements EventReceiver {
    private static final String ACTION_CHECK_PAIRING_REQUEST = "com.upuphone.bluetooth.device.ACTION_CHECK_PAIRING_REQUEST";
    private static final String TAG = "BluetoothStateReceiver";
    /* access modifiers changed from: private */
    public BluetoothHidHost mHidHost = null;
    /* access modifiers changed from: private */
    public boolean mInitHidHost = false;
    /* access modifiers changed from: private */
    public ProfileListener mServiceListener = new ProfileListener();
    private Pair<Long, StDevice> mWaitConnectDevice;

    public class ProfileListener implements BluetoothProfile.ServiceListener {
        private BluetoothProfile.ServiceListener mListener;

        private ProfileListener() {
        }

        public void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
            StLog.d(BluetoothStateReceiver.TAG, "openHidHostIfNeed onServiceConnected profile=" + i);
            if (i == 4) {
                BluetoothHidHost unused = BluetoothStateReceiver.this.mHidHost = (BluetoothHidHost) bluetoothProfile;
                BluetoothProfile.ServiceListener serviceListener = this.mListener;
                if (serviceListener != null) {
                    serviceListener.onServiceConnected(i, bluetoothProfile);
                } else {
                    BluetoothStateReceiver.this.autoConnectBondedRingDevice();
                }
            }
        }

        public void onServiceDisconnected(int i) {
            BluetoothProfile.ServiceListener serviceListener;
            StLog.d(BluetoothStateReceiver.TAG, "onServiceDisconnected profile=" + i);
            if (i == 4 && (serviceListener = this.mListener) != null) {
                serviceListener.onServiceDisconnected(i);
            }
        }

        public void setServiceListener(BluetoothProfile.ServiceListener serviceListener) {
            this.mListener = serviceListener;
        }
    }

    public BluetoothStateReceiver() {
        initHidHost((BluetoothProfile.ServiceListener) null);
        BleEventBus.get().register(DisconnectRingEvent.class, this);
    }

    /* access modifiers changed from: private */
    public void autoConnectBondedRingDevice() {
        BluetoothDevice remoteDevice;
        List<StConnectDevice> bondInfoByTerminal = StarryDeviceManager.getInstance().getBondInfoByTerminal(5);
        if (bondInfoByTerminal != null && !bondInfoByTerminal.isEmpty() && (remoteDevice = BluetoothUtils.getRemoteDevice(bondInfoByTerminal.get(0).getBleMac())) != null) {
            StLog.d(TAG, "autoConnectBondedRingDevice");
            connectHidHostIfNeed(remoteDevice);
        }
    }

    /* access modifiers changed from: private */
    public boolean checkHidHostConnected(BluetoothDevice bluetoothDevice) {
        BluetoothHidHost bluetoothHidHost = this.mHidHost;
        boolean z = false;
        if (bluetoothHidHost != null && bluetoothHidHost.getConnectionState(bluetoothDevice) == 2) {
            z = true;
        }
        StLog.d(TAG, "checkHidHostConnected =" + z);
        return z;
    }

    private StConnectDevice checkIfRingDevice(String str) {
        StConnectDevice connectDeviceByBleMac = StarryDeviceManager.getInstance().getConnectDeviceByBleMac(str);
        if (connectDeviceByBleMac == null || connectDeviceByBleMac.getTerminalType() != 5 || !connectDeviceByBleMac.getModelID().equals(StarryNetData.MODEL_ID_RING_1)) {
            return null;
        }
        return connectDeviceByBleMac;
    }

    private void checkPairingRequest(Context context, Intent intent) {
        if (!StarryNetData.getInstance().isAR()) {
            StLog.d(TAG, "only ar device need check pair request");
            return;
        }
        BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        StConnectDevice curIosDevice = StarryDeviceManager.getInstance().getCurIosDevice();
        StLog.d(TAG, "checkPairingRequest ,ios device =" + curIosDevice + ",bt device =" + bluetoothDevice.getAddress());
        if (curIosDevice == null || !curIosDevice.isPreConnect()) {
            StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(bluetoothDevice);
            if (connectDevice == null) {
                StLog.w(TAG, "checkPairingRequest bondInfo is null ,pair device name =" + bluetoothDevice.getName());
            } else if (connectDevice.getTerminalType() == 4 && connectDevice.getBleBondStatus() == 0) {
                StLog.d(TAG, "third device , confirm false");
                bluetoothDevice.setPairingConfirmation(false);
                connectDevice.setCancelConfirm(true);
                BrEdrDeviceManager.cancelBondProcess(bluetoothDevice);
                return;
            }
            sendPinIntent2Launcher(context, bluetoothDevice, intent.getIntExtra("android.bluetooth.device.extra.PAIRING_KEY", 0));
            return;
        }
        String name = bluetoothDevice.getName();
        StLog.d(TAG, "checkPairingRequest, in ios pre connect, ios device name =%s, bt device name=%s", curIosDevice.getDeviceName(), name);
        if (curIosDevice.getDeviceName().equals(name)) {
            sendPinIntent2Launcher(context, bluetoothDevice, intent.getIntExtra("android.bluetooth.device.extra.PAIRING_KEY", 0));
            return;
        }
        bluetoothDevice.setPairingConfirmation(false);
        BrEdrDeviceManager.cancelBondProcess(bluetoothDevice);
    }

    /* access modifiers changed from: private */
    public void connectBleIfNeed(BluetoothDevice bluetoothDevice) {
        String address = bluetoothDevice.getAddress();
        if (BleClientCache.getInstance().isClientConnected(address)) {
            StLog.d(TAG, "connectBleIfNeed, check ring client had connected ,then return !");
            return;
        }
        StDevice deviceByBleMac = StarryDeviceManager.getInstance().getDeviceByBleMac(address);
        if (deviceByBleMac == null) {
            StConnectDevice checkIfRingDevice = checkIfRingDevice(address);
            deviceByBleMac = checkIfRingDevice == null ? null : checkIfRingDevice.getDevice();
        }
        if (deviceByBleMac == null) {
            StLog.w(TAG, "cannot find StDevice by mac(%s - %s) ", bluetoothDevice.getName(), address);
            return;
        }
        StLog.d(TAG, "connectBleIfNeed");
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null) {
            StLog.w(TAG, "adapter is null!");
        } else if (defaultAdapter.getState() == 11) {
            StLog.w(TAG, "蓝牙正在打开中，等待蓝牙完全打开再连, 大概需要等待2.5s");
            this.mWaitConnectDevice = new Pair<>(Long.valueOf(System.currentTimeMillis()), deviceByBleMac);
        } else {
            this.mWaitConnectDevice = null;
            StarryNetData.getInstance().getConnectManager().connectBle(deviceByBleMac);
        }
    }

    private void connectHidHostIfNeed(final BluetoothDevice bluetoothDevice) {
        StLog.d(TAG, "connectHidHostIfNeed mInitHidHost=" + this.mInitHidHost + ", mHidHost=" + this.mHidHost);
        if (!this.mInitHidHost || this.mHidHost == null) {
            initHidHost(new BluetoothProfile.ServiceListener() {
                public void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
                    if (!BluetoothStateReceiver.this.mInitHidHost || BluetoothStateReceiver.this.mHidHost == null) {
                        StLog.w(BluetoothStateReceiver.TAG, "after init HidHost again, mInitHidHost =" + BluetoothStateReceiver.this.mInitHidHost + ",mHidHost=" + BluetoothStateReceiver.this.mHidHost);
                    } else if (BluetoothStateReceiver.this.checkHidHostConnected(bluetoothDevice)) {
                        BluetoothStateReceiver.this.connectBleIfNeed(bluetoothDevice);
                    } else {
                        BluetoothStateReceiver.this.mHidHost.connect(bluetoothDevice);
                    }
                    BluetoothStateReceiver.this.mServiceListener.setServiceListener((BluetoothProfile.ServiceListener) null);
                }

                public void onServiceDisconnected(int i) {
                    BluetoothStateReceiver.this.mServiceListener.setServiceListener((BluetoothProfile.ServiceListener) null);
                }
            });
        } else if (checkHidHostConnected(bluetoothDevice)) {
            connectBleIfNeed(bluetoothDevice);
        } else {
            this.mHidHost.connect(bluetoothDevice);
        }
    }

    private void disconnectRing(DisconnectRingEvent disconnectRingEvent) {
        String bleMac = disconnectRingEvent.getBleMac();
        if (!TextUtils.isEmpty(bleMac)) {
            BluetoothDevice remoteDevice = BluetoothUtils.getRemoteDevice(bleMac);
            if (!this.mInitHidHost || this.mHidHost == null) {
                StLog.e(TAG, "disconnect hid host fail,  mInitHidHost =" + this.mInitHidHost + ", mHidHost=" + this.mHidHost);
            } else {
                StLog.d(TAG, "start disconnect hid host");
                this.mHidHost.disconnect(remoteDevice);
            }
            BleConnectManager.getInstance().disconnect(bleMac);
        }
    }

    private void initHidHost(BluetoothProfile.ServiceListener serviceListener) {
        if (this.mInitHidHost) {
            StLog.d(TAG, "initHidHost had init hid host,return");
            return;
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        this.mServiceListener.setServiceListener(serviceListener);
        this.mInitHidHost = defaultAdapter.getProfileProxy(StarryNetData.getInstance().getApplicationContext(), this.mServiceListener, 4);
    }

    private void openHidHostIfNeed(final BluetoothDevice bluetoothDevice) {
        StLog.d(TAG, "openHidHostIfNeed");
        BluetoothAdapter.getDefaultAdapter().getProfileProxy(StarryNetData.getInstance().getApplicationContext(), new BluetoothProfile.ServiceListener() {
            public void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
                StLog.d(BluetoothStateReceiver.TAG, "openHidHostIfNeed onServiceConnected profile=" + i);
                if (i == 4) {
                    BluetoothHidHost bluetoothHidHost = (BluetoothHidHost) bluetoothProfile;
                    List connectedDevices = bluetoothHidHost.getConnectedDevices();
                    boolean z = false;
                    if (connectedDevices != null && !connectedDevices.isEmpty()) {
                        Iterator it = connectedDevices.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            BluetoothDevice bluetoothDevice = (BluetoothDevice) it.next();
                            if (bluetoothDevice.getName().equals(bluetoothDevice.getName()) && bluetoothDevice.getAddress().equals(bluetoothDevice.getAddress())) {
                                z = true;
                                break;
                            }
                        }
                        StLog.d(BluetoothStateReceiver.TAG, "hid host connected devices size =" + connectedDevices.size());
                    }
                    if (!z) {
                        StLog.d(BluetoothStateReceiver.TAG, "hid host connect device");
                        bluetoothHidHost.connect(bluetoothDevice);
                        return;
                    }
                    BluetoothStateReceiver.this.connectBleIfNeed(bluetoothDevice);
                }
            }

            public void onServiceDisconnected(int i) {
                StLog.d(BluetoothStateReceiver.TAG, "invokeDisconnect onServiceDisconnected profile=" + i);
            }
        }, 4);
    }

    public static void registerReceiver(Context context, BluetoothStateReceiver bluetoothStateReceiver) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
        intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.input.profile.action.CONNECTION_STATE_CHANGED");
        intentFilter.addAction(ACTION_CHECK_PAIRING_REQUEST);
        StLog.d(TAG, "registerReceiver");
        BluetoothUtils.registerBleStateReceiver(bluetoothStateReceiver, intentFilter);
    }

    private void sendPinIntent2Launcher(Context context, BluetoothDevice bluetoothDevice, int i) {
        Intent intent = new Intent("android.bluetooth.device.action.PAIRING_REQUEST");
        intent.putExtra("android.bluetooth.device.extra.DEVICE", bluetoothDevice);
        if (i != 0) {
            intent.putExtra("android.bluetooth.device.extra.PAIRING_KEY", i);
            StLog.d(TAG, "sendPinIntent2Launcher, pin=" + i);
        }
        bluetoothDevice.setPairingConfirmation(true);
        intent.setFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
        intent.setPackage("com.upuphone.star.launcher");
        StLog.d(TAG, "sendPinIntent2Launcher");
        context.sendBroadcastAsUser(intent, UserHandle.getUserHandleForUid(-1));
    }

    public void onEvent(Object obj) {
        if (obj instanceof DisconnectRingEvent) {
            disconnectRing((DisconnectRingEvent) obj);
        }
    }

    public void onReceive(Context context, Intent intent) {
        StConnectDevice connectDevice;
        String action = intent.getAction();
        if ("android.bluetooth.device.action.BOND_STATE_CHANGED".equals(action)) {
            BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            String name = bluetoothDevice.getName();
            String address = bluetoothDevice.getAddress();
            switch (intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", -1)) {
                case 10:
                    BleEventBus.get().post(new MYVURingEvent(address, 2, bluetoothDevice));
                    StConnectDevice curBondInfo = StarryDeviceManager.getInstance().getCurBondInfo();
                    if (curBondInfo != null && curBondInfo.getTerminalType() == 4 && curBondInfo.getBrEdrMac().equals(address)) {
                        StarryDeviceManager.getInstance().updateBondInfo(curBondInfo, 0);
                    }
                    StConnectDevice checkIfRingDevice = checkIfRingDevice(address);
                    if (checkIfRingDevice != null) {
                        BleEventBus.get().post(new RingConnectStateEvent(address, 8));
                        StLog.d(TAG, "%s(%s) BOND_NONE 删除配对", name, address);
                        StarryDeviceManager.getInstance().updateBondInfo(checkIfRingDevice, 0);
                        return;
                    }
                    StLog.w(TAG, "%s(%s) BOND_NONE 删除配对,StConnectDevice is null or not ring-device ", name, address);
                    return;
                case 11:
                    BleEventBus.get().post(new MYVURingEvent(address, 7, bluetoothDevice));
                    StLog.d(TAG, "%s(%s) BOND_BONDING 正在配对", name, address);
                    if (StarryNetData.getInstance().isAR() && (connectDevice = StarryDeviceManager.getInstance().getConnectDevice(bluetoothDevice)) != null) {
                        StLog.d(TAG, " bonding ,reset cancel confirm");
                        connectDevice.setCancelConfirm(false);
                        return;
                    }
                    return;
                case 12:
                    BleEventBus.get().post(new MYVURingEvent(address, 1, bluetoothDevice));
                    StConnectDevice checkIfRingDevice2 = checkIfRingDevice(address);
                    BleEventBus.get().post(new RingConnectStateEvent(address, 1));
                    if (checkIfRingDevice2 != null) {
                        StLog.d(TAG, "%s(%s) BOND_BONDED 配对成功", name, address);
                        StarryDeviceManager.getInstance().updateBondInfo(checkIfRingDevice2, 4);
                        connectHidHostIfNeed(bluetoothDevice);
                        return;
                    }
                    StLog.w(TAG, "%s(%s) BOND_BONDED 配对成功,StConnectDevice is null or not ring-device", name, address);
                    return;
                default:
                    return;
            }
        } else if (action.equals("android.bluetooth.device.action.ACL_CONNECTED")) {
            BluetoothDevice bluetoothDevice2 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            String name2 = bluetoothDevice2.getName();
            String address2 = bluetoothDevice2.getAddress();
            BleEventBus.get().post(new MYVURingEvent(address2, 3, bluetoothDevice2));
            BleEventBus.get().post(new RingConnectStateEvent(address2, 2, bluetoothDevice2));
            if (checkIfRingDevice(address2) != null) {
                BleEventBus.get().post(new RingConnectStateEvent(address2, 9));
                StLog.d(TAG, "bluetooth device(%s:%s) ACL connected", name2, address2);
                if (bluetoothDevice2.getBondState() != 12) {
                    StLog.d(TAG, "checked ring device is ACL connected, but not in bonded state, then ignore it!");
                } else {
                    connectHidHostIfNeed(bluetoothDevice2);
                }
            } else {
                StLog.w(TAG, "bluetooth device(%s:%s) ACL connected. StConnectDevice is null or not ring-device", name2, address2);
            }
        } else if (action.equals("android.bluetooth.device.action.ACL_DISCONNECTED")) {
            BluetoothDevice bluetoothDevice3 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            String name3 = bluetoothDevice3.getName();
            String address3 = bluetoothDevice3.getAddress();
            BleEventBus.get().post(new MYVURingEvent(address3, 4, bluetoothDevice3));
            BleEventBus.get().post(new RingConnectStateEvent(address3, 3));
            StConnectDevice checkIfRingDevice3 = checkIfRingDevice(address3);
            if (checkIfRingDevice3 != null) {
                BleEventBus.get().post(new RingConnectStateEvent(address3, 10));
                StLog.d(TAG, "bluetooth device(%s:%s) ACL disconnected", name3, address3);
                StarryDeviceManager.getInstance().deviceDisconnected(checkIfRingDevice3, 2);
                return;
            }
            StLog.w(TAG, "bluetooth device(%s:%s) ACL disconnected, stConnectDevice is null or not ring-device", name3, address3);
        } else if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(action)) {
            int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 0);
            if (intExtra == 12) {
                Pair<Long, StDevice> pair = this.mWaitConnectDevice;
                if (pair != null) {
                    if (System.currentTimeMillis() - ((Long) pair.f847a).longValue() < 5000) {
                        StLog.d(TAG, "check bt is on ,start ble connect for ring.");
                        StarryNetData.getInstance().getConnectManager().connectBle((StDevice) this.mWaitConnectDevice.b);
                    }
                    this.mWaitConnectDevice = null;
                }
            } else if (intExtra == 10) {
                this.mWaitConnectDevice = null;
                BleEventBus.get().post(new RingConnectStateEvent("None", 6));
            }
        } else if ("android.bluetooth.input.profile.action.CONNECTION_STATE_CHANGED".equals(action)) {
            BluetoothDevice bluetoothDevice4 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            int intExtra2 = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
            StLog.d(TAG, " hid host connection state changed. ,device name " + bluetoothDevice4.getName() + ",state = " + intExtra2);
            StConnectDevice checkIfRingDevice4 = checkIfRingDevice(bluetoothDevice4.getAddress());
            if (intExtra2 == 2) {
                BleEventBus.get().post(new RingConnectStateEvent(bluetoothDevice4.getAddress(), 4));
                if (checkIfRingDevice4 != null) {
                    connectBleIfNeed(bluetoothDevice4);
                    return;
                }
                StLog.w(TAG, "hid host connection state changed, but StConnectDevice is null");
                BleEventBus.get().post(new MYVURingEvent(bluetoothDevice4.getAddress(), 5, bluetoothDevice4));
            } else if (intExtra2 == 0 && checkIfRingDevice4 == null) {
                BleEventBus.get().post(new MYVURingEvent(bluetoothDevice4.getAddress(), 6, bluetoothDevice4));
            }
        } else if (ACTION_CHECK_PAIRING_REQUEST.equals(action)) {
            checkPairingRequest(context, intent);
        }
    }
}
