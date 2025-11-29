package com.upuphone.starrynet.strategy.service;

import android.annotation.SuppressLint;
import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHidDevice;
import android.bluetooth.BluetoothHidDeviceAppQosSettings;
import android.bluetooth.BluetoothHidDeviceAppSdpSettings;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import com.upuphone.starrynet.api.ICommonCallback;
import com.upuphone.starrynet.api.StErrorCode;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.api.hid.IKeyBoardWrapper;
import com.upuphone.starrynet.api.hid.IMouseWrapper;
import com.upuphone.starrynet.api.hid.ITouchPadWrapper;
import com.upuphone.starrynet.api.manager.IStarryHidManager;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.core.ble.SystemActionObserver;
import com.upuphone.starrynet.core.ble.utils.BluetoothUtils;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.hid.HidConsts;
import com.upuphone.starrynet.strategy.hid.KeyBoardWrapper;
import com.upuphone.starrynet.strategy.hid.MouseWrapper;
import com.upuphone.starrynet.strategy.hid.TouchPadWrapper;
import java.util.concurrent.Executors;

@SuppressLint({"MissingPermission"})
public class StarryHidManager implements IStarryHidManager {
    private static final String TAG = "StarryHidManager";
    private BluetoothAdapter mBtAdapter;
    private HidRegisterCallback mCallback;
    /* access modifiers changed from: private */
    public BluetoothHidDevice mHidDevice;
    /* access modifiers changed from: private */
    public BluetoothDevice mHost;
    /* access modifiers changed from: private */
    public boolean mInit;
    private KeyBoardWrapper mKeyBoardWrapper;
    /* access modifiers changed from: private */
    public MouseWrapper mMouseWrapper;
    /* access modifiers changed from: private */
    public byte mProtocol;
    private Context mService;
    private TouchPadWrapper mTouchPadWrapper;

    public class HidRegisterCallback extends BluetoothHidDevice.Callback {
        /* access modifiers changed from: private */
        public BluetoothDevice readyConnectDevice;

        private HidRegisterCallback() {
        }

        public void onAppStatusChanged(BluetoothDevice bluetoothDevice, boolean z) {
            super.onAppStatusChanged(bluetoothDevice, z);
            StLog.d(StarryHidManager.TAG, "onAppStatusChanged, registered =" + z);
            if (!z) {
                BluetoothDevice unused = StarryHidManager.this.mHost = null;
            } else if (bluetoothDevice != null) {
                BluetoothDevice bluetoothDevice2 = this.readyConnectDevice;
                if (bluetoothDevice2 != null && bluetoothDevice2.getAddress().equalsIgnoreCase(bluetoothDevice.getAddress())) {
                    StLog.d(StarryHidManager.TAG, "hid start connect plugged device, plugged device mac =%s, device name=%s", bluetoothDevice.getAddress(), bluetoothDevice.getName());
                    StarryHidManager.this.mHidDevice.connect(bluetoothDevice);
                } else if (this.readyConnectDevice != null) {
                    StLog.d(StarryHidManager.TAG, "hid start connect ready device 2");
                    StarryHidManager.this.mHidDevice.connect(this.readyConnectDevice);
                } else {
                    StLog.w(StarryHidManager.TAG, "pluggedDevice is not match ready connect device mac.");
                }
            } else if (this.readyConnectDevice != null) {
                StLog.d(StarryHidManager.TAG, "hid start connect ready device");
                StarryHidManager.this.mHidDevice.connect(this.readyConnectDevice);
            } else {
                StLog.w(StarryHidManager.TAG, "onAppStatusChanged ,no connect device!");
            }
        }

        public void onConnectionStateChanged(BluetoothDevice bluetoothDevice, int i) {
            super.onConnectionStateChanged(bluetoothDevice, i);
            StLog.d(StarryHidManager.TAG, "onConnectionStateChanged host device is %s null,state =%d", bluetoothDevice == null ? "" : "not", Integer.valueOf(i));
            if (i == 2) {
                BluetoothDevice unused = StarryHidManager.this.mHost = bluetoothDevice;
                StarryHidManager.this.notifyHostChanged(bluetoothDevice);
            } else if (i == 1) {
                StLog.d(StarryHidManager.TAG, "onConnectionStateChanged connecting...");
            } else {
                byte unused2 = StarryHidManager.this.mProtocol = (byte) 1;
                if (StarryHidManager.this.mMouseWrapper != null) {
                    StarryHidManager.this.mMouseWrapper.updateProtocol(StarryHidManager.this.mProtocol);
                }
            }
        }

        public void onGetReport(BluetoothDevice bluetoothDevice, byte b, byte b2, int i) {
            super.onGetReport(bluetoothDevice, b, b2, i);
            StLog.d(StarryHidManager.TAG, "onGetReport, type=%d, id=%d, bufferSize=%d", Byte.valueOf(b), Byte.valueOf(b2), Integer.valueOf(i));
        }

        public void onInterruptData(BluetoothDevice bluetoothDevice, byte b, byte[] bArr) {
            super.onInterruptData(bluetoothDevice, b, bArr);
            StLog.d(StarryHidManager.TAG, "onInterruptData reportId =%d, data length =%d", Byte.valueOf(b), Integer.valueOf(bArr.length));
        }

        public void onSetProtocol(BluetoothDevice bluetoothDevice, byte b) {
            super.onSetProtocol(bluetoothDevice, b);
            StLog.d(StarryHidManager.TAG, "onSetProtocol, protocol =%d", Byte.valueOf(b));
            byte unused = StarryHidManager.this.mProtocol = b;
            if (StarryHidManager.this.mMouseWrapper != null) {
                StarryHidManager.this.mMouseWrapper.updateProtocol(StarryHidManager.this.mProtocol);
            }
        }

        public void onSetReport(BluetoothDevice bluetoothDevice, byte b, byte b2, byte[] bArr) {
            super.onSetReport(bluetoothDevice, b, b2, bArr);
            StLog.d(StarryHidManager.TAG, "onSetReport, type=%d, id=%d, data length=%d", Byte.valueOf(b), Byte.valueOf(b2), Integer.valueOf(bArr.length));
        }

        public void onVirtualCableUnplug(BluetoothDevice bluetoothDevice) {
            super.onVirtualCableUnplug(bluetoothDevice);
            StLog.d(StarryHidManager.TAG, "onVirtualCableUnplug");
            BluetoothDevice unused = StarryHidManager.this.mHost = null;
        }
    }

    public static class Holder {
        public static final StarryHidManager INSTANCE = new StarryHidManager();
    }

    public static StarryHidManager getInstance() {
        return Holder.INSTANCE;
    }

    private void initProfile(final BluetoothDevice bluetoothDevice, final byte b, final ICommonCallback iCommonCallback) {
        if (this.mInit) {
            StLog.w(TAG, "has registered, then return!");
            return;
        }
        this.mBtAdapter.getProfileProxy(this.mService, new BluetoothProfile.ServiceListener() {
            public void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
                StLog.d(StarryHidManager.TAG, "init Profile, onServiceConnected ,profile=%d", Integer.valueOf(i));
                if (i == 19) {
                    BluetoothHidDevice unused = StarryHidManager.this.mHidDevice = (BluetoothHidDevice) bluetoothProfile;
                    if (!StarryHidManager.this.registerApp(bluetoothDevice, b)) {
                        StLog.w(StarryHidManager.TAG, "registerApp fail");
                        ICommonCallback iCommonCallback = iCommonCallback;
                        if (iCommonCallback != null) {
                            iCommonCallback.onResult(StErrorCode.HID_REGISTER_APP_FAIL, "hid register app fail");
                        }
                    }
                }
            }

            public void onServiceDisconnected(int i) {
                StLog.w(StarryHidManager.TAG, "init Profile, onServiceDisconnected ,profile=%d", Integer.valueOf(i));
                if (i == 19) {
                    boolean unused = StarryHidManager.this.mInit = false;
                }
            }
        }, 19);
        this.mInit = true;
    }

    /* access modifiers changed from: private */
    public void notifyHostChanged(BluetoothDevice bluetoothDevice) {
        MouseWrapper mouseWrapper = this.mMouseWrapper;
        if (mouseWrapper != null) {
            mouseWrapper.updateHost(bluetoothDevice);
        }
        TouchPadWrapper touchPadWrapper = this.mTouchPadWrapper;
        if (touchPadWrapper != null) {
            touchPadWrapper.updateHost(bluetoothDevice);
        }
    }

    /* access modifiers changed from: private */
    public boolean registerApp(BluetoothDevice bluetoothDevice, byte b) {
        StLog.d(TAG, "start register app ,subclass =" + b);
        BluetoothHidDeviceAppSdpSettings bluetoothHidDeviceAppSdpSettings = new BluetoothHidDeviceAppSdpSettings(HidConsts.getName(b), HidConsts.getDescription(b), HidConsts.getProvider(b), (byte) -64, HidConsts.getDescriptor(b));
        BluetoothHidDeviceAppQosSettings bluetoothHidDeviceAppQosSettings = new BluetoothHidDeviceAppQosSettings(2, 200, 2, 200, 10000, 10000);
        BluetoothHidDeviceAppQosSettings bluetoothHidDeviceAppQosSettings2 = new BluetoothHidDeviceAppQosSettings(2, 900, 9, 900, 10000, 10000);
        BluetoothDevice unused = this.mCallback.readyConnectDevice = bluetoothDevice;
        return this.mHidDevice.registerApp(bluetoothHidDeviceAppSdpSettings, bluetoothHidDeviceAppQosSettings, bluetoothHidDeviceAppQosSettings2, Executors.newCachedThreadPool(), this.mCallback);
    }

    public void closeHid() {
        StLog.d(TAG, "closeHid, mInit=" + this.mInit);
        if (this.mInit) {
            BluetoothHidDevice bluetoothHidDevice = this.mHidDevice;
            if (bluetoothHidDevice != null) {
                bluetoothHidDevice.unregisterApp();
                this.mBtAdapter.closeProfileProxy(19, this.mHidDevice);
            }
            this.mMouseWrapper = null;
            this.mTouchPadWrapper = null;
            this.mInit = false;
        }
    }

    public IKeyBoardWrapper getKeyBoardWrapper() {
        if (this.mKeyBoardWrapper == null) {
            this.mKeyBoardWrapper = new KeyBoardWrapper(this.mHidDevice, this.mHost, this.mProtocol);
        }
        return this.mKeyBoardWrapper;
    }

    public IMouseWrapper getMouseWrapper() {
        if (this.mMouseWrapper == null) {
            this.mMouseWrapper = new MouseWrapper(this.mHidDevice, this.mHost, this.mProtocol);
        }
        return this.mMouseWrapper;
    }

    public ITouchPadWrapper getTouchPadWrapper() {
        if (this.mTouchPadWrapper == null) {
            this.mTouchPadWrapper = new TouchPadWrapper(this.mHidDevice, this.mHost);
        }
        return this.mTouchPadWrapper;
    }

    public void init(Context context) {
        this.mService = context;
        this.mBtAdapter = BluetoothAdapter.getDefaultAdapter();
    }

    public void openHid(byte[] bArr, byte b, ICommonCallback iCommonCallback) {
        StLog.d(TAG, "start open hid");
        if (!SystemActionObserver.getInstance().isBtOn()) {
            StLog.d(TAG, "openHid,but bluetooth switch not open!");
            if (iCommonCallback != null) {
                iCommonCallback.onResult(StErrorCode.DISCOVERY_STRATEGY_BLUETOOTH_OFF, "openHid: please open bluetooth switch, then try again!");
            }
        } else if (b == 5 || b == -64 || b == Byte.MIN_VALUE) {
            StDevice device = StarryDeviceManager.getInstance().getDevice(bArr);
            if (device == null) {
                StLog.w(TAG, "open hid, st device is null");
                return;
            }
            BluetoothDevice remoteDevice = BluetoothUtils.getRemoteDevice(device.getBleMac());
            for (BluetoothDevice next : this.mBtAdapter.getBondedDevices()) {
                if (next.getAddress().equalsIgnoreCase(device.getBrEdrMac())) {
                    StLog.d(TAG, "openHid, Found ble mac(%s) device in btAdapter bonded devices", next.getAddress());
                    remoteDevice = next;
                }
            }
            if (remoteDevice == null) {
                StLog.w(TAG, "open hid, bluetooth device is null");
            } else {
                initProfile(remoteDevice, b, iCommonCallback);
            }
        } else if (iCommonCallback != null) {
            iCommonCallback.onResult(StErrorCode.HID_NOT_SUPPORT_DEVICE_TYPE, "current support device type is 0x05, 0xC0,0x80");
        }
    }

    private StarryHidManager() {
        this.mInit = false;
        this.mHidDevice = null;
        this.mProtocol = 1;
        this.mCallback = new HidRegisterCallback();
    }

    public StarryHidManager(Service service) {
        this.mInit = false;
        this.mHidDevice = null;
        this.mProtocol = 1;
        this.mCallback = new HidRegisterCallback();
        this.mService = service;
        this.mBtAdapter = BluetoothAdapter.getDefaultAdapter();
    }
}
