package com.upuphone.runasone.ble;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.runasone.utils.BleLogger;
import com.upuphone.starrynet.core.ble.SystemActionObserver;
import java.util.UUID;

@SuppressLint({"MissingPermission"})
public class BleInternalSession extends BleRawSession implements Handler.Callback {
    private static final int MSG_MTU_REQUEST_TIMEOUT = 54;
    private static final int MSG_OPEN_NOTIFY_REQUEST_TIMEOUT = 55;
    private static final int MSG_READ_REQUEST_TIMEOUT = 53;
    private static final int MSG_WRITE_REQUEST_TIMEOUT = 52;
    private static final int MTU_SIZE_MAX = 512;
    private static final int MTU_SIZE_MIN = 23;
    private static final String TAG = "BleInternalSession";
    private final Handler bleHandler;
    private final BluetoothGatt bluetoothGatt;
    private SessionConfig config;
    private int currentMtu = 23;
    private final BleInternalDevice device;
    private MtuCallback mtuCallback;
    private OpenNotifyCallback openCallback;
    private ReadCallback readCallback;
    private SessionCallback sessionCallback;
    private WriteCallback writeCallback;

    public BleInternalSession(String str, BleInternalDevice bleInternalDevice, BluetoothGatt bluetoothGatt2, Looper looper) {
        super(str, UUID.randomUUID().toString());
        this.device = bleInternalDevice;
        this.bluetoothGatt = bluetoothGatt2;
        this.bleHandler = new Handler(looper, this);
    }

    private int commonCheck() {
        if (!BluetoothUtils.isBleSupported()) {
            return BleConstants.NOT_SUPPORT_BLE;
        }
        if (!SystemActionObserver.getInstance().isBtOn()) {
            return BleConstants.BLUETOOTH_DISABLED;
        }
        if (this.bluetoothGatt == null) {
            return BleConstants.GATT_NOT_EXIST;
        }
        return 0;
    }

    private BluetoothGattCharacteristic getCharacter(UUID uuid, UUID uuid2) {
        BluetoothGattService service;
        if (uuid == null || uuid2 == null || (service = this.bluetoothGatt.getService(uuid)) == null) {
            return null;
        }
        return service.getCharacteristic(uuid2);
    }

    public void disconnect() {
        int commonCheck = commonCheck();
        if (commonCheck > 0) {
            BleLogger.e(TAG, (Object) "disconnect error, code=" + commonCheck);
            return;
        }
        this.bluetoothGatt.disconnect();
    }

    public SessionCallback getSessionCallback() {
        return this.sessionCallback;
    }

    public boolean handleMessage(@NonNull Message message) {
        switch (message.what) {
            case 52:
                BleLogger.w(TAG, (Object) "write request timeout");
                WriteCallback writeCallback2 = this.writeCallback;
                if (writeCallback2 == null) {
                    return true;
                }
                writeCallback2.onWrite(BleConstants.GATT_REQUEST_TIMEOUT);
                this.writeCallback = null;
                return true;
            case 53:
                BleLogger.w(TAG, (Object) "read request timeout");
                ReadCallback readCallback2 = this.readCallback;
                if (readCallback2 == null) {
                    return true;
                }
                readCallback2.onRead(BleConstants.GATT_REQUEST_TIMEOUT, (byte[]) null);
                this.readCallback = null;
                return true;
            case 54:
                BleLogger.w(TAG, (Object) "mtu request timeout");
                MtuCallback mtuCallback2 = this.mtuCallback;
                if (mtuCallback2 == null) {
                    return true;
                }
                mtuCallback2.onMtuChange(BleConstants.GATT_REQUEST_TIMEOUT, -1);
                this.mtuCallback = null;
                return true;
            case 55:
                BleLogger.w(TAG, (Object) "open notify request timeout");
                OpenNotifyCallback openNotifyCallback = this.openCallback;
                if (openNotifyCallback == null) {
                    return true;
                }
                openNotifyCallback.onOpen(BleConstants.GATT_REQUEST_TIMEOUT);
                this.openCallback = null;
                return true;
            default:
                return true;
        }
    }

    public void init(SessionConfig sessionConfig, InitSessionCallback initSessionCallback) {
        this.config = sessionConfig;
        if (initSessionCallback != null) {
            initSessionCallback.onInit(0);
        }
    }

    public void onCharacteristicChanged(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        BleLogger.d(TAG, (Object) "onCharacteristicChanged, value len=" + bArr.length);
        SessionCallback sessionCallback2 = this.sessionCallback;
        if (sessionCallback2 != null) {
            sessionCallback2.onNotify(bluetoothGattCharacteristic.getUuid().toString(), bArr);
        } else {
            BleLogger.d(TAG, (Object) "onCharacteristicChanged sessionCallback is null");
        }
    }

    public void onCharacteristicRead(byte[] bArr, int i) {
        if (this.bleHandler.hasMessages(53)) {
            StringBuilder sb = new StringBuilder();
            sb.append("onCharacteristicRead, status=");
            sb.append(i);
            sb.append(",value len=");
            sb.append(bArr == null ? 0 : bArr.length);
            BleLogger.d(TAG, (Object) sb.toString());
            this.bleHandler.removeMessages(53);
            ReadCallback readCallback2 = this.readCallback;
            if (readCallback2 != null) {
                readCallback2.onRead(i, bArr);
                this.readCallback = null;
                return;
            }
            return;
        }
        BleLogger.d(TAG, (Object) "had happen timeout, onCharacteristicRead, status=" + i);
    }

    public void onCharacteristicWrite(int i) {
        if (this.bleHandler.hasMessages(52)) {
            BleLogger.d(TAG, (Object) "onCharacteristicWrite, status =" + i);
            this.bleHandler.removeMessages(52);
            WriteCallback writeCallback2 = this.writeCallback;
            if (writeCallback2 != null) {
                writeCallback2.onWrite(i);
                this.writeCallback = null;
                return;
            }
            return;
        }
        BleLogger.d(TAG, (Object) "had happen timeout, onCharacteristicWrite, status =" + i);
    }

    public void onDescriptorWrite(BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        if (this.bleHandler.hasMessages(55)) {
            BleLogger.d(TAG, (Object) "onDescriptorWrite, descriptor=" + bluetoothGattDescriptor.getUuid() + ",status =" + i);
            this.bleHandler.removeMessages(55);
            OpenNotifyCallback openNotifyCallback = this.openCallback;
            if (openNotifyCallback != null) {
                openNotifyCallback.onOpen(i);
                this.openCallback = null;
                return;
            }
            return;
        }
        BleLogger.d(TAG, (Object) "had happen timeout, onDescriptorWrite, descriptor=" + bluetoothGattDescriptor.getUuid() + ",status =" + i);
    }

    public void onMtuChanged(int i, int i2) {
        if (i2 == 0) {
            this.currentMtu = i - 3;
        }
        if (this.bleHandler.hasMessages(54)) {
            BleLogger.d(TAG, (Object) "onMtuChanged ,status=" + i2 + ",mtu=" + i);
            this.bleHandler.removeMessages(54);
            MtuCallback mtuCallback2 = this.mtuCallback;
            if (mtuCallback2 != null) {
                mtuCallback2.onMtuChange(i2, i);
                this.mtuCallback = null;
                return;
            }
            return;
        }
        BleLogger.w(TAG, (Object) "had happen timeout, onMtuChanged ,status=" + i2 + ",mtu=" + i);
    }

    public void openNotify(UUID uuid, OpenNotifyCallback openNotifyCallback) {
        int commonCheck = commonCheck();
        if (commonCheck > 0) {
            BleLogger.e(TAG, (Object) "openNotify error, code=" + commonCheck);
            openNotifyCallback.onOpen(commonCheck);
            return;
        }
        UUID serviceUUID = this.config.getServiceUUID();
        BluetoothGattCharacteristic character = getCharacter(serviceUUID, uuid);
        if (character == null) {
            BleLogger.e(TAG, (Object) "setCharacteristicNotification error, not exit character:" + serviceUUID + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA + uuid);
            openNotifyCallback.onOpen(BleConstants.GATT_NOT_EXIST_CHARACTER);
            return;
        }
        if ((character.getProperties() & 48) == 0) {
            BleLogger.e(TAG, (Object) "setCharacteristicNotification error, the character " + uuid + " not support read, it's properties =" + character.getProperties());
            openNotifyCallback.onOpen(BleConstants.GATT_CHARACTER_NOT_SUPPORT_NOTIFY);
        }
        if (!this.bluetoothGatt.setCharacteristicNotification(character, true)) {
            BleLogger.e(TAG, (Object) "setCharacteristicNotification fail, uuid=" + uuid);
            openNotifyCallback.onOpen(BleConstants.GATT_CHARACTER_NOTIFICATION_FAIL);
        }
        BluetoothGattDescriptor descriptor = character.getDescriptor(BleConstants.DESCRIPTOR_UUID);
        if (descriptor == null) {
            BleLogger.e(TAG, (Object) "Descriptor for notify is null!");
            openNotifyCallback.onOpen(0);
            return;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            if (this.bluetoothGatt.writeDescriptor(descriptor, BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE) != 0) {
                BleLogger.e(TAG, (Object) "writeDescriptor(T) for notify failed");
                openNotifyCallback.onOpen(BleConstants.GATT_CHARACTER_NOTIFY_DESCRIPTOR_FAIL);
                return;
            }
        } else if (!descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE)) {
            BleLogger.e(TAG, (Object) "setValue for notify descriptor failed!");
            openNotifyCallback.onOpen(BleConstants.GATT_CHARACTER_NOTIFY_DESCRIPTOR_FAIL);
            return;
        } else if (!this.bluetoothGatt.writeDescriptor(descriptor)) {
            BleLogger.e(TAG, (Object) "writeDescriptor(S) for notify failed");
            openNotifyCallback.onOpen(BleConstants.GATT_CHARACTER_NOTIFY_DESCRIPTOR_FAIL);
            return;
        }
        this.bleHandler.sendEmptyMessageDelayed(55, this.config.requestTimeout());
        this.openCallback = openNotifyCallback;
    }

    public void read(UUID uuid, ReadCallback readCallback2) {
        int commonCheck = commonCheck();
        if (commonCheck > 0) {
            BleLogger.e(TAG, (Object) "read error, code=" + commonCheck);
            readCallback2.onRead(commonCheck, (byte[]) null);
            return;
        }
        UUID serviceUUID = this.config.getServiceUUID();
        BluetoothGattCharacteristic character = getCharacter(serviceUUID, uuid);
        if (character == null) {
            BleLogger.e(TAG, (Object) "read error, not exit character:" + serviceUUID + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA + uuid);
            readCallback2.onRead(BleConstants.GATT_NOT_EXIST_CHARACTER, (byte[]) null);
        } else if ((character.getProperties() & 2) == 0) {
            BleLogger.e(TAG, (Object) "read error, the character " + uuid + " not support read, it's properties =" + character.getProperties());
            readCallback2.onRead(BleConstants.GATT_CHARACTER_NOT_SUPPORT_READ, (byte[]) null);
        } else {
            if (!this.bluetoothGatt.readCharacteristic(character)) {
                BleLogger.e(TAG, (Object) "read fail, uuid=" + uuid);
                readCallback2.onRead(BleConstants.GATT_CHARACTER_READ_FAIL, (byte[]) null);
            }
            this.bleHandler.sendEmptyMessageDelayed(53, this.config.requestTimeout());
            this.readCallback = readCallback2;
        }
    }

    public void release() {
        this.readCallback = null;
        this.writeCallback = null;
        this.mtuCallback = null;
        this.openCallback = null;
        this.sessionCallback = null;
    }

    public void setMtu(int i, MtuCallback mtuCallback2) {
        int commonCheck = commonCheck();
        if (commonCheck > 0) {
            BleLogger.e(TAG, (Object) "setMtu error, code=" + commonCheck);
            mtuCallback2.onMtuChange(commonCheck, 0);
        } else if (i > 512 || i < 23) {
            BleLogger.e(TAG, (Object) "mtu should belong to [23, 512], invalid mtu value:" + i);
            mtuCallback2.onMtuChange(BleConstants.INVALID_MTU_SIZE, 0);
        } else {
            if (!this.bluetoothGatt.requestMtu(i)) {
                mtuCallback2.onMtuChange(BleConstants.REQUEST_MTU_FAIL, i);
            }
            this.bleHandler.sendEmptyMessageDelayed(54, this.config.requestTimeout());
            this.mtuCallback = mtuCallback2;
        }
    }

    public void setSessionCallback(SessionCallback sessionCallback2) {
        this.sessionCallback = sessionCallback2;
    }

    public void write(UUID uuid, byte[] bArr, WriteCallback writeCallback2) {
        int commonCheck = commonCheck();
        if (commonCheck > 0) {
            BleLogger.e(TAG, (Object) "write error, code=" + commonCheck);
            writeCallback2.onWrite(commonCheck);
        } else if (bArr == null || bArr.length == 0) {
            writeCallback2.onWrite(BleConstants.WRITE_DATA_IS_EMPTY);
        } else if (bArr.length > this.currentMtu) {
            writeCallback2.onWrite(BleConstants.WRITE_DATA_LENGTH_OUT_OF_MTU_SIZE);
        } else {
            UUID serviceUUID = this.config.getServiceUUID();
            BluetoothGattCharacteristic character = getCharacter(serviceUUID, uuid);
            if (character == null) {
                BleLogger.e(TAG, (Object) "write error, not exit character:" + serviceUUID + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA + uuid);
                writeCallback2.onWrite(BleConstants.GATT_NOT_EXIST_CHARACTER);
            } else if ((character.getProperties() & 12) == 0) {
                BleLogger.e(TAG, (Object) "write error, the character " + uuid + " not support write, it's properties =" + character.getProperties());
                writeCallback2.onWrite(BleConstants.GATT_CHARACTER_NOT_SUPPORT_WRITE);
            } else {
                if (Build.VERSION.SDK_INT < 33) {
                    character.setValue(bArr);
                    if (!this.bluetoothGatt.writeCharacteristic(character)) {
                        BleLogger.e(TAG, (Object) "write error(S) failed");
                        writeCallback2.onWrite(BleConstants.GATT_CHARACTER_WRITE_FAIL);
                    }
                } else if (this.bluetoothGatt.writeCharacteristic(character, bArr, character.getWriteType()) != 0) {
                    BleLogger.e(TAG, (Object) "write error(T) failed");
                    writeCallback2.onWrite(BleConstants.GATT_CHARACTER_WRITE_FAIL);
                }
                this.bleHandler.sendEmptyMessageDelayed(52, this.config.requestTimeout());
                this.writeCallback = writeCallback2;
            }
        }
    }
}
