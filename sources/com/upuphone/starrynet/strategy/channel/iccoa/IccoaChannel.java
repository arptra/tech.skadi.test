package com.upuphone.starrynet.strategy.channel.iccoa;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelUuid;
import com.upuphone.starrynet.api.StErrorCode;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.strategy.SysActionManager;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.protocol.iccoa.IccoaProtocolCallback;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class IccoaChannel implements IBleClientGattCallback {
    private static final int BLE_MTU_DEFAULT_VALUE = 510;
    private static final int BLE_PROCESS_TIMEOUT = 6000;
    private static final int BLE_RETRY_TIMES = 5;
    public static final ParcelUuid ICCOA_BLE_BASE_SERVICE_UUID = ParcelUuid.fromString("2abcc850-9935-4f8a-ba84-123456789100");
    public static final ParcelUuid ICCOA_BLE_CLIENT_WRITE_UUID = ParcelUuid.fromString("2abcc850-9935-4f8a-ba84-123456789101");
    public static final ParcelUuid ICCOA_BLE_SERVER_NOTIFY_UUID = ParcelUuid.fromString("2abcc850-9935-4f8a-ba84-123456789102");
    public static final int MSG_FROM_CLIENT = 1;
    public static final int MSG_FROM_SERVER = 0;
    public static final String TAG = "IccoaChannel";
    private boolean isMtuChanged = false;
    private boolean isServiceDiscovered = false;
    private final BleClientGattCallback mBleClientGattCallback;
    private final BleTimeoutHandler mBleTimeoutHandler;
    private final BluetoothAdapter mBluetoothAdapter;
    private volatile BluetoothGatt mBluetoothGatt;
    /* access modifiers changed from: private */
    public final IccoaProtocolCallback mCallback;
    private final Context mContext;
    private List<BluetoothGattCharacteristic> mGattCharacteristicList = new ArrayList();
    /* access modifiers changed from: private */
    public int mRetry;
    /* access modifiers changed from: private */
    public StDevice mRetryDevice;

    public class BleTimeoutHandler extends Handler {
        public BleTimeoutHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1 || i == 3 || i == 4 || i == 5) {
                IccoaChannel.this.closeGatt();
                if (IccoaChannel.this.mRetry > 0) {
                    IccoaChannel.access$110(IccoaChannel.this);
                    IccoaChannel iccoaChannel = IccoaChannel.this;
                    int unused = iccoaChannel.connectBle(iccoaChannel.mRetryDevice);
                    return;
                }
                IccoaChannel.this.mCallback.onConnectFail(message.what);
            }
        }
    }

    public IccoaChannel(IccoaProtocolCallback iccoaProtocolCallback, Context context) {
        this.mContext = context;
        SysActionManager.getInstance().registerSysAction(new SysActionManager.StateChangeSimpleCallback() {
            public void onBluetoothDisabled() {
                IccoaChannel.this.dealWithBluetoothDisabled();
            }
        });
        this.mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        this.mCallback = iccoaProtocolCallback;
        this.mBleClientGattCallback = new BleClientGattCallback(this);
        this.mBleTimeoutHandler = new BleTimeoutHandler(Looper.getMainLooper());
    }

    public static /* synthetic */ int access$110(IccoaChannel iccoaChannel) {
        int i = iccoaChannel.mRetry;
        iccoaChannel.mRetry = i - 1;
        return i;
    }

    /* access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    public void closeGatt() {
        if (this.mBluetoothGatt != null) {
            this.mBluetoothGatt.disconnect();
            this.mBluetoothGatt.close();
        }
    }

    /* access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    public int connectBle(StDevice stDevice) {
        if (stDevice == null) {
            StLog.d(TAG, "connect device is null");
            return StErrorCode.CONNECT_STRATEGY_BLE_PARAM_ERROR;
        }
        this.mRetryDevice = StarryDeviceManager.getInstance().getDiscoveryDevice(stDevice.getIdentifier());
        if (stDevice.getBleMac() == null) {
            StLog.d(TAG, "connect ble mac is null");
            return StErrorCode.CONNECT_STRATEGY_BLE_PARAM_ERROR;
        }
        startTimer(1, BLE_PROCESS_TIMEOUT, stDevice);
        try {
            this.mBluetoothGatt = this.mBluetoothAdapter.getRemoteDevice(stDevice.getBleMac()).connectGatt(this.mContext, false, this.mBleClientGattCallback, 2, 1);
            return StErrorCode.CONNECT_STRATEGY_BLE_CONNECTING;
        } catch (Exception unused) {
            StLog.e(TAG, "error ble mac");
            stopTimer(1);
            return StErrorCode.CONNECT_STRATEGY_BLE_CONNECT_FAIL;
        }
    }

    private void connectionReset() {
        this.isMtuChanged = false;
        this.isServiceDiscovered = false;
    }

    private BluetoothGattCharacteristic getDestBluetoothGattCharacteristic(UUID uuid) {
        List<BluetoothGattCharacteristic> list = this.mGattCharacteristicList;
        if (list == null || list.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("getDestBluetoothGattCharacteristic mGattCharacteristicList is empty ");
            sb.append(this.mGattCharacteristicList == null);
            StLog.w(TAG, sb.toString());
            return null;
        }
        for (BluetoothGattCharacteristic next : this.mGattCharacteristicList) {
            if (next.getUuid().equals(uuid)) {
                return next;
            }
        }
        return null;
    }

    @SuppressLint({"MissingPermission"})
    private void invokeSetLeConnectionPriority(int i) {
        if (this.mBluetoothGatt != null) {
            if (i == 0) {
                this.mBluetoothGatt.requestConnectionPriority(1);
                StLog.d(TAG, "set high speed mode");
            } else if (i == 1) {
                this.mBluetoothGatt.requestConnectionPriority(2);
                StLog.d(TAG, "set low speed mode");
            } else if (i == 2) {
                this.mBluetoothGatt.requestConnectionPriority(0);
                StLog.d(TAG, "set balance speed mode");
            }
        }
    }

    private boolean isCharacteristicNoRspWritable(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        return (bluetoothGattCharacteristic == null || (bluetoothGattCharacteristic.getProperties() & 4) == 0) ? false : true;
    }

    private boolean isCharacteristicNotifiable(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (bluetoothGattCharacteristic != null) {
            return ((bluetoothGattCharacteristic.getProperties() & 16) == 0 && (bluetoothGattCharacteristic.getProperties() & 32) == 0) ? false : true;
        }
        return false;
    }

    private boolean isCharacteristicWritable(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        return (bluetoothGattCharacteristic == null || ((bluetoothGattCharacteristic.getProperties() & 8) == 0 && (bluetoothGattCharacteristic.getProperties() & 4) == 0)) ? false : true;
    }

    private boolean isConnectionReady() {
        return this.isMtuChanged && this.isServiceDiscovered;
    }

    private boolean isDeviceBusy() {
        boolean z = false;
        try {
            z = ((Boolean) readField(this.mBluetoothGatt, "mDeviceBusy")).booleanValue();
            StLog.d(TAG, "isDeviceBusy:" + z);
            return z;
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
            return z;
        }
    }

    private void refreshGattCache(BluetoothGatt bluetoothGatt) {
        boolean z = false;
        if (bluetoothGatt != null) {
            try {
                Method method = BluetoothGatt.class.getMethod("refresh", (Class[]) null);
                method.setAccessible(true);
                z = ((Boolean) method.invoke(bluetoothGatt, (Object[]) null)).booleanValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        StLog.d(TAG, "refreshDeviceCache return %b", Boolean.valueOf(z));
    }

    private void startTimer(int i, int i2, StDevice stDevice) {
        if (this.mBleTimeoutHandler.hasMessages(i)) {
            this.mBleTimeoutHandler.removeMessages(i);
        }
        BleTimeoutHandler bleTimeoutHandler = this.mBleTimeoutHandler;
        bleTimeoutHandler.sendMessageDelayed(bleTimeoutHandler.obtainMessage(i, stDevice), (long) i2);
    }

    private void stopTimer(int i) {
        if (this.mBleTimeoutHandler.hasMessages(i)) {
            this.mBleTimeoutHandler.removeMessages(i);
        }
    }

    public int connect(StDevice stDevice) {
        StLog.d(TAG, "connect... device " + stDevice);
        this.mRetry = 5;
        return connectBle(stDevice);
    }

    public void dealWithBluetoothDisabled() {
        connectionReset();
        if (this.mBleTimeoutHandler.hasMessages(1)) {
            this.mBleTimeoutHandler.removeMessages(1);
            this.mCallback.onConnectFail(1);
        }
        if (this.mBleTimeoutHandler.hasMessages(3)) {
            this.mBleTimeoutHandler.removeMessages(3);
            this.mCallback.onConnectFail(3);
        }
        if (this.mBleTimeoutHandler.hasMessages(4)) {
            this.mBleTimeoutHandler.removeMessages(4);
            this.mCallback.onConnectFail(4);
        }
        if (this.mBleTimeoutHandler.hasMessages(5)) {
            this.mBleTimeoutHandler.removeMessages(5);
            this.mCallback.onConnectFail(5);
        }
        this.mRetry = 0;
    }

    @SuppressLint({"MissingPermission"})
    public boolean disconnect(StDevice stDevice) {
        if (stDevice == null || this.mBluetoothGatt == null) {
            return false;
        }
        StLog.d(TAG, "disconnect");
        this.mRetry = 0;
        this.mBluetoothGatt.disconnect();
        return true;
    }

    public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        onCharacteristicChangedImpl(bluetoothGatt, bluetoothGattCharacteristic, bArr);
    }

    @SuppressLint({"MissingPermission"})
    public void onCharacteristicChangedImpl(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        if (this.mBluetoothGatt == null) {
            StLog.d(TAG, "onCharacteristicChangedImpl, mBluetoothGatt is null");
        } else if (bluetoothGattCharacteristic == null) {
            StLog.d(TAG, "onCharacteristicChangedImpl characteristic is null");
            this.mBluetoothGatt.disconnect();
        } else if (bluetoothGatt == null) {
            StLog.d(TAG, "onCharacteristicChangedImpl gatt is null");
            this.mBluetoothGatt.disconnect();
        } else {
            BluetoothDevice device = bluetoothGatt.getDevice();
            if (device == null) {
                StLog.d(TAG, "onCharacteristicChangedImpl device is null");
                this.mBluetoothGatt.disconnect();
                return;
            }
            this.mCallback.onRecv(StarryDeviceManager.getInstance().getDeviceByBleMac(device.getAddress()), bArr, 0);
        }
    }

    public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        stopTimer(5);
    }

    @SuppressLint({"MissingPermission"})
    public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
        onConnectionStateChangeImpl(i2, i, bluetoothGatt);
    }

    @SuppressLint({"MissingPermission"})
    public void onConnectionStateChangeImpl(int i, int i2, BluetoothGatt bluetoothGatt) {
        if (i2 == 0 && i == 2) {
            StLog.d(TAG, "Ble Client Connected, discoverServices");
            stopTimer(1);
            startTimer(4, BLE_PROCESS_TIMEOUT, (StDevice) null);
            refreshGattCache(bluetoothGatt);
            if (!bluetoothGatt.discoverServices()) {
                StLog.d(TAG, "discoverServices fail");
                stopTimer(4);
                bluetoothGatt.disconnect();
            } else if (this.mBluetoothGatt == null) {
                this.mBluetoothGatt = bluetoothGatt;
            }
        } else if (i == 0) {
            StLog.d(TAG, "Ble Client DisConnected");
            connectionReset();
            if (i2 != 0 && this.mRetry > 0) {
                closeGatt();
                this.mRetry--;
                connectBle(this.mRetryDevice);
            } else if (this.mBluetoothGatt != null && this.mBluetoothGatt.getDevice() != null) {
                List<BluetoothGattCharacteristic> list = this.mGattCharacteristicList;
                if (list != null) {
                    list.clear();
                }
                refreshGattCache(this.mBluetoothGatt);
                this.mCallback.onDisConnected(this.mBluetoothGatt.getDevice().getAddress());
                this.mBluetoothGatt.close();
                this.mBluetoothGatt = null;
            }
        }
    }

    public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        if (bluetoothGatt != null && bluetoothGatt.getDevice() != null) {
            this.mCallback.onConnected(bluetoothGatt.getDevice().getAddress());
        }
    }

    public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
        onMtuChangedImpl(i, i2, bluetoothGatt);
    }

    @SuppressLint({"MissingPermission"})
    public void onMtuChangedImpl(int i, int i2, BluetoothGatt bluetoothGatt) {
        if (this.mBluetoothGatt == null) {
            StLog.d(TAG, " mBluetoothGatt is null");
            return;
        }
        this.isMtuChanged = true;
        stopTimer(3);
        openNotify(bluetoothGatt);
    }

    public void onServiceChanged(BluetoothGatt bluetoothGatt) {
        if (!this.mCallback.isBleAuthCompleted()) {
            openNotify(bluetoothGatt);
        } else {
            StLog.d(TAG, "service change, ble auth completed, ignore it.");
        }
    }

    @SuppressLint({"MissingPermission"})
    public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
        onServicesDiscoveredImpl(i, bluetoothGatt);
    }

    @SuppressLint({"MissingPermission"})
    public void onServicesDiscoveredImpl(int i, BluetoothGatt bluetoothGatt) {
        if (i == 0) {
            this.mRetry = 0;
            this.isServiceDiscovered = true;
            stopTimer(4);
            startTimer(3, BLE_PROCESS_TIMEOUT, (StDevice) null);
            if (!this.isMtuChanged) {
                requestMtu();
            } else {
                openNotify(bluetoothGatt);
            }
        } else {
            StLog.d(TAG, "onServicesDiscovered not found");
        }
    }

    @SuppressLint({"MissingPermission"})
    public void openNotify(BluetoothGatt bluetoothGatt) {
        if (!isConnectionReady()) {
            StLog.d(TAG, "cannot open notify, onServiceDiscovered =" + this.isServiceDiscovered + ",mtuChanged =" + this.isMtuChanged);
            return;
        }
        StLog.d(TAG, "openNotify");
        BluetoothGattService service = bluetoothGatt.getService(ICCOA_BLE_BASE_SERVICE_UUID.getUuid());
        if (service == null) {
            StLog.d(TAG, "open notify, cannot find bluetoothGattService");
            bluetoothGatt.disconnect();
            return;
        }
        this.mGattCharacteristicList = service.getCharacteristics();
        BluetoothGattCharacteristic destBluetoothGattCharacteristic = getDestBluetoothGattCharacteristic(ICCOA_BLE_CLIENT_WRITE_UUID.getUuid());
        BluetoothGattCharacteristic destBluetoothGattCharacteristic2 = getDestBluetoothGattCharacteristic(ICCOA_BLE_SERVER_NOTIFY_UUID.getUuid());
        boolean z = true;
        if (destBluetoothGattCharacteristic == null || destBluetoothGattCharacteristic2 == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("writeCharacter == null is ");
            sb.append(destBluetoothGattCharacteristic == null);
            sb.append(",notifyCharacter == null is ");
            if (destBluetoothGattCharacteristic2 != null) {
                z = false;
            }
            sb.append(z);
            StLog.w(TAG, sb.toString());
            bluetoothGatt.disconnect();
        } else if (!setCharacteristicNotification(true)) {
            StLog.d(TAG, "The Characteristics set notify fail");
            bluetoothGatt.disconnect();
        }
    }

    public Object readField(Object obj, String str) throws IllegalAccessException, NoSuchFieldException {
        Field declaredField = obj.getClass().getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    @SuppressLint({"MissingPermission"})
    public void requestMtu() {
        StLog.d(TAG, "requestMtu");
        if (this.mBluetoothGatt == null) {
            StLog.d(TAG, "mBluetoothGatt is null");
        } else if (!this.mBluetoothGatt.requestMtu(BLE_MTU_DEFAULT_VALUE)) {
            StLog.d(TAG, " requestMtu fail");
            stopTimer(3);
            this.mBluetoothGatt.disconnect();
        }
    }

    @SuppressLint({"MissingPermission"})
    public boolean sendData(byte[] bArr) {
        StLog.d(TAG, "sendData enter");
        BluetoothGattCharacteristic destBluetoothGattCharacteristic = getDestBluetoothGattCharacteristic(ICCOA_BLE_CLIENT_WRITE_UUID.getUuid());
        if (destBluetoothGattCharacteristic == null) {
            StLog.d(TAG, "sendData characteristic is null");
            return false;
        } else if (destBluetoothGattCharacteristic.getService() == null) {
            StLog.d(TAG, "service is null");
            return false;
        } else {
            invokeSetLeConnectionPriority(0);
            if (!isCharacteristicWritable(destBluetoothGattCharacteristic)) {
                StLog.d(TAG, "sendData characteristic permission 0 fail");
                return false;
            } else if (isDeviceBusy()) {
                StLog.d(TAG, "system is busy");
                return false;
            } else {
                destBluetoothGattCharacteristic.setValue(bArr);
                destBluetoothGattCharacteristic.setWriteType(2);
                if (this.mBluetoothGatt == null) {
                    StLog.d(TAG, "mBluetoothGatt is null");
                    return false;
                }
                startTimer(5, BLE_PROCESS_TIMEOUT, (StDevice) null);
                if (this.mBluetoothGatt.writeCharacteristic(destBluetoothGattCharacteristic)) {
                    return true;
                }
                StLog.d(TAG, "sendData failed");
                stopTimer(5);
                return false;
            }
        }
    }

    @SuppressLint({"MissingPermission"})
    public boolean setCharacteristicNotification(boolean z) {
        BluetoothGattCharacteristic destBluetoothGattCharacteristic = getDestBluetoothGattCharacteristic(ICCOA_BLE_SERVER_NOTIFY_UUID.getUuid());
        if (this.mBluetoothGatt == null) {
            StLog.d(TAG, "mBluetoothGatt is null");
            return false;
        } else if (destBluetoothGattCharacteristic == null) {
            StLog.d(TAG, "characteristic fail");
            this.mBluetoothGatt.disconnect();
            return false;
        } else if (!isCharacteristicNotifiable(destBluetoothGattCharacteristic)) {
            StLog.d(TAG, "isCharacteristicNotifyable fail");
            this.mBluetoothGatt.disconnect();
            return false;
        } else if (!this.mBluetoothGatt.setCharacteristicNotification(destBluetoothGattCharacteristic, z)) {
            StLog.d(TAG, "setCharacteristicNotification fail");
            this.mBluetoothGatt.disconnect();
            return false;
        } else if (this.mBluetoothGatt.getDevice() == null) {
            return true;
        } else {
            this.mCallback.onConnected(this.mBluetoothGatt.getDevice().getAddress());
            return true;
        }
    }
}
