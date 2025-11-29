package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.UUID;
import no.nordicsemi.android.dfu.BaseCustomDfuImpl;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.UnknownResponseException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;

class LegacyDfuImpl extends BaseCustomDfuImpl {
    static final UUID DEFAULT_DFU_CONTROL_POINT_UUID;
    static final UUID DEFAULT_DFU_PACKET_UUID;
    static final UUID DEFAULT_DFU_SERVICE_UUID;
    static final UUID DEFAULT_DFU_VERSION_UUID;
    static UUID DFU_CONTROL_POINT_UUID = null;
    static UUID DFU_PACKET_UUID = null;
    static UUID DFU_SERVICE_UUID = null;
    private static final int DFU_STATUS_SUCCESS = 1;
    static UUID DFU_VERSION_UUID = null;
    private static final byte[] OP_CODE_ACTIVATE_AND_RESET = {5};
    private static final int OP_CODE_ACTIVATE_AND_RESET_KEY = 5;
    private static final byte[] OP_CODE_INIT_DFU_PARAMS = {2};
    private static final byte[] OP_CODE_INIT_DFU_PARAMS_COMPLETE = {2, 1};
    private static final int OP_CODE_INIT_DFU_PARAMS_KEY = 2;
    private static final byte[] OP_CODE_INIT_DFU_PARAMS_START = {2, 0};
    private static final int OP_CODE_PACKET_RECEIPT_NOTIF_KEY = 17;
    private static final byte[] OP_CODE_PACKET_RECEIPT_NOTIF_REQ = {8, 0, 0};
    private static final int OP_CODE_PACKET_RECEIPT_NOTIF_REQ_KEY = 8;
    private static final byte[] OP_CODE_RECEIVE_FIRMWARE_IMAGE = {3};
    private static final int OP_CODE_RECEIVE_FIRMWARE_IMAGE_KEY = 3;
    private static final byte[] OP_CODE_RESET = {6};
    private static final int OP_CODE_RESET_KEY = 6;
    private static final int OP_CODE_RESPONSE_CODE_KEY = 16;
    private static final byte[] OP_CODE_START_DFU = {1, 0};
    private static final int OP_CODE_START_DFU_KEY = 1;
    private static final byte[] OP_CODE_START_DFU_V1 = {1};
    private static final byte[] OP_CODE_VALIDATE = {4};
    private static final int OP_CODE_VALIDATE_KEY = 4;
    private final LegacyBluetoothCallback mBluetoothCallback = new LegacyBluetoothCallback();
    private BluetoothGattCharacteristic mControlPointCharacteristic;
    /* access modifiers changed from: private */
    public boolean mImageSizeInProgress;
    private BluetoothGattCharacteristic mPacketCharacteristic;

    public class LegacyBluetoothCallback extends BaseCustomDfuImpl.BaseCustomBluetoothCallback {
        public LegacyBluetoothCallback() {
            super();
        }

        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            if (bluetoothGattCharacteristic.getIntValue(17, 0).intValue() == 17) {
                LegacyDfuImpl.this.mProgressInfo.setBytesReceived(bluetoothGattCharacteristic.getIntValue(20, 1).intValue());
                handlePacketReceiptNotification(bluetoothGatt, bluetoothGattCharacteristic);
            } else if (!LegacyDfuImpl.this.mRemoteErrorOccurred) {
                if (bluetoothGattCharacteristic.getIntValue(17, 2).intValue() != 1) {
                    LegacyDfuImpl.this.mRemoteErrorOccurred = true;
                }
                handleNotification(bluetoothGatt, bluetoothGattCharacteristic);
            }
            LegacyDfuImpl.this.notifyLock();
        }

        public void onPacketCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            if (LegacyDfuImpl.this.mImageSizeInProgress) {
                DfuBaseService dfuBaseService = LegacyDfuImpl.this.mService;
                dfuBaseService.sendLogBroadcast(5, "Data written to " + bluetoothGattCharacteristic.getUuid() + ", value (0x): " + parse(bluetoothGattCharacteristic));
                boolean unused = LegacyDfuImpl.this.mImageSizeInProgress = false;
            }
        }
    }

    static {
        UUID uuid = new UUID(23296205844446L, 1523193452336828707L);
        DEFAULT_DFU_SERVICE_UUID = uuid;
        UUID uuid2 = new UUID(23300500811742L, 1523193452336828707L);
        DEFAULT_DFU_CONTROL_POINT_UUID = uuid2;
        UUID uuid3 = new UUID(23304795779038L, 1523193452336828707L);
        DEFAULT_DFU_PACKET_UUID = uuid3;
        UUID uuid4 = new UUID(23313385713630L, 1523193452336828707L);
        DEFAULT_DFU_VERSION_UUID = uuid4;
        DFU_SERVICE_UUID = uuid;
        DFU_CONTROL_POINT_UUID = uuid2;
        DFU_PACKET_UUID = uuid3;
        DFU_VERSION_UUID = uuid4;
    }

    public LegacyDfuImpl(@NonNull Intent intent, @NonNull DfuBaseService dfuBaseService) {
        super(intent, dfuBaseService);
    }

    private int getStatusCode(@Nullable byte[] bArr, int i) throws UnknownResponseException {
        byte b;
        if (bArr != null && bArr.length == 3 && bArr[0] == 16 && bArr[1] == i && (b = bArr[2]) >= 1 && b <= 6) {
            return b;
        }
        throw new UnknownResponseException("Invalid response received", bArr, 16, i);
    }

    private int readVersion(@Nullable BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (bluetoothGattCharacteristic != null) {
            return bluetoothGattCharacteristic.getIntValue(18, 0).intValue();
        }
        return 0;
    }

    private void resetAndRestart(@NonNull BluetoothGatt bluetoothGatt, @NonNull Intent intent) throws DfuException, DeviceDisconnectedException, UploadAbortedException {
        this.mService.sendLogBroadcast(15, "Last upload interrupted. Restarting device...");
        this.mProgressInfo.setProgress(-5);
        logi("Sending Reset command (Op Code = 6)");
        writeOpCode(this.mControlPointCharacteristic, OP_CODE_RESET);
        this.mService.sendLogBroadcast(10, "Reset request sent");
        this.mService.waitUntilDisconnected();
        this.mService.sendLogBroadcast(5, "Disconnected by the remote device");
        BluetoothGattService service = bluetoothGatt.getService(BaseDfuImpl.GENERIC_ATTRIBUTE_SERVICE_UUID);
        this.mService.refreshDeviceCache(bluetoothGatt, !((service == null || service.getCharacteristic(BaseDfuImpl.SERVICE_CHANGED_UUID) == null) ? false : true));
        this.mService.close(bluetoothGatt);
        logi("Restarting the service");
        Intent intent2 = new Intent();
        intent2.fillIn(intent, 24);
        restartService(intent2, false);
    }

    private void setNumberOfPackets(@NonNull byte[] bArr, int i) {
        bArr[1] = (byte) (i & 255);
        bArr[2] = (byte) ((i >> 8) & 255);
    }

    private void writeImageSize(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        this.mReceivedData = null;
        this.mError = 0;
        this.mImageSizeInProgress = true;
        bluetoothGattCharacteristic.setWriteType(1);
        bluetoothGattCharacteristic.setValue(new byte[4]);
        bluetoothGattCharacteristic.setValue(i, 20, 0);
        DfuBaseService dfuBaseService = this.mService;
        dfuBaseService.sendLogBroadcast(1, "Writing to characteristic " + bluetoothGattCharacteristic.getUuid());
        DfuBaseService dfuBaseService2 = this.mService;
        dfuBaseService2.sendLogBroadcast(0, "gatt.writeCharacteristic(" + bluetoothGattCharacteristic.getUuid() + ")");
        this.mGatt.writeCharacteristic(bluetoothGattCharacteristic);
        try {
            synchronized (this.mLock) {
                while (true) {
                    if (this.mImageSizeInProgress && this.mConnected && this.mError == 0) {
                        if (!this.mAborted) {
                            continue;
                            this.mLock.wait();
                        }
                    }
                    if (!this.mPaused) {
                        break;
                    }
                    this.mLock.wait();
                }
            }
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        } catch (Throwable th) {
            throw th;
        }
        if (this.mAborted) {
            throw new UploadAbortedException();
        } else if (!this.mConnected) {
            throw new DeviceDisconnectedException("Unable to write Image Size: device disconnected");
        } else if (this.mError != 0) {
            throw new DfuException("Unable to write Image Size", this.mError);
        }
    }

    private void writeOpCode(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, @NonNull byte[] bArr) throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        boolean z = false;
        byte b = bArr[0];
        if (b == 6 || b == 5) {
            z = true;
        }
        writeOpCode(bluetoothGattCharacteristic, bArr, z);
    }

    public UUID getControlPointCharacteristicUUID() {
        return DFU_CONTROL_POINT_UUID;
    }

    public UUID getDfuServiceUUID() {
        return DFU_SERVICE_UUID;
    }

    public UUID getPacketCharacteristicUUID() {
        return DFU_PACKET_UUID;
    }

    public boolean isClientCompatible(@NonNull Intent intent, @NonNull BluetoothGatt bluetoothGatt) {
        BluetoothGattCharacteristic characteristic;
        BluetoothGattService service = bluetoothGatt.getService(DFU_SERVICE_UUID);
        if (service == null || (characteristic = service.getCharacteristic(DFU_CONTROL_POINT_UUID)) == null || characteristic.getDescriptor(BaseDfuImpl.CLIENT_CHARACTERISTIC_CONFIG) == null) {
            return false;
        }
        this.mControlPointCharacteristic = characteristic;
        BluetoothGattCharacteristic characteristic2 = service.getCharacteristic(DFU_PACKET_UUID);
        this.mPacketCharacteristic = characteristic2;
        return characteristic2 != null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:101:?, code lost:
        r1.mService.sendLogBroadcast(1, "Sending only SD/BL");
        logi("Resending Start DFU command (Op Code = 1, Upload Mode = " + r2 + ")");
        writeOpCode(r1.mControlPointCharacteristic, r5);
        r5 = r1.mService;
        r5.sendLogBroadcast(10, "DFU Start sent (Op Code = 1, Upload Mode = " + r2 + ")");
        logi("Sending image size array to DFU Packet: [" + r3 + "b, " + r15 + "b, " + 0 + "b]");
        writeImageSize(r1.mPacketCharacteristic, r3, r15, 0);
        r5 = r1.mService;
        r5.sendLogBroadcast(10, "Firmware image size sent [" + r3 + "b, " + r15 + "b, " + 0 + "b]");
        r3 = readNotificationResponse();
        r7 = getStatusCode(r3, 1);
        r8 = r1.mService;
        r8.sendLogBroadcast(10, "Response received (Op Code = " + r3[1] + r4 + r7 + ")");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x031e, code lost:
        if (r7 == 2) goto L_0x0320;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:?, code lost:
        resetAndRestart(r11, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0323, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0324, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0325, code lost:
        r3 = r0;
        r4 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x032a, code lost:
        if (r7 != 1) goto L_0x0331;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0333, code lost:
        r4 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0338, code lost:
        throw new no.nordicsemi.android.dfu.internal.exception.RemoteDfuException(r4, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0339, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x033a, code lost:
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x033c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x033d, code lost:
        r4 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0340, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0341, code lost:
        r4 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0343, code lost:
        r4 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0344, code lost:
        throw r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0345, code lost:
        r4 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0346, code lost:
        throw r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0347, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0348, code lost:
        r25 = "Firmware image size sent (";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0350, code lost:
        if (r3.getErrorNumber() == 3) goto L_0x0352;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0353, code lost:
        if (r2 == 4) goto L_0x0355;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0355, code lost:
        r1.mRemoteErrorOccurred = false;
        logw("DFU target does not support DFU v.2");
        r1.mService.sendLogBroadcast(15, "DFU target does not support DFU v.2");
        r1.mService.sendLogBroadcast(1, "Switching to DFU v.1");
        logi("Resending Start DFU command (Op Code = 1)");
        writeOpCode(r1.mControlPointCharacteristic, OP_CODE_START_DFU_V1);
        r1.mService.sendLogBroadcast(10, "DFU Start sent (Op Code = 1)");
        logi("Sending application image size to DFU Packet: " + r1.mImageSizeInBytes + " bytes");
        writeImageSize(r1.mPacketCharacteristic, r1.mImageSizeInBytes);
        r2 = r1.mService;
        r2.sendLogBroadcast(10, r25 + r1.mImageSizeInBytes + " bytes)");
        r2 = readNotificationResponse();
        r5 = getStatusCode(r2, 1);
        r7 = r1.mService;
        r8 = new java.lang.StringBuilder();
        r8.append("Response received (Op Code = ");
        r8.append(r2[1]);
        r2 = r16;
        r8.append(r2);
        r8.append(r5);
        r8.append(")");
        r7.sendLogBroadcast(10, r8.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x03f1, code lost:
        if (r5 == 2) goto L_0x03f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x03f3, code lost:
        resetAndRestart(r11, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x03f6, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x03f7, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x03f8, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x03fc, code lost:
        if (r5 == 1) goto L_0x03fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x03fe, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x068d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x068e, code lost:
        r2 = r0;
        loge("Disconnected while sending data");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x0694, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x069a, code lost:
        throw new no.nordicsemi.android.dfu.internal.exception.RemoteDfuException(r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x069b, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x069c, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x069d, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x069e, code lost:
        r22 = "Reset request sent";
        r24 = "Sending Reset command (Op Code = 6)";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x0707, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x0708, code lost:
        r4 = "Reset request sent";
        r2 = "Sending Reset command (Op Code = 6)";
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x0736, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x0737, code lost:
        r4 = "Reset request sent";
        r2 = "Sending Reset command (Op Code = 6)";
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01dc, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x01e4, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x01ec, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01ed, code lost:
        r8 = r0;
        r10 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0200, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0203, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0204, code lost:
        r10 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0207, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0208, code lost:
        r6 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x020b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x020c, code lost:
        r6 = r29;
        r4 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0232, code lost:
        if (r17 <= 0) goto L_0x0343;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:?, code lost:
        r1.mRemoteErrorOccurred = false;
        r5 = r19;
        logw(r5);
        r1.mService.sendLogBroadcast(15, r5);
        r2 = r2 & -5;
        r1.mFileType = r2;
        r5 = OP_CODE_START_DFU;
        r5[1] = (byte) r2;
        r1.mProgressInfo.setTotalPart(2);
        ((no.nordicsemi.android.dfu.internal.ArchiveInputStream) r1.mFirmwareStream).setContentType(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0262, code lost:
        r17 = r10;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0345 A[Catch:{ RemoteDfuException -> 0x0339, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }] */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0352 A[Catch:{ DeviceDisconnectedException -> 0x068d, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0403 A[Catch:{ DeviceDisconnectedException -> 0x068d, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x04b7 A[Catch:{ DeviceDisconnectedException -> 0x068d, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x04c7 A[Catch:{ DeviceDisconnectedException -> 0x068d, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0595 A[Catch:{ DeviceDisconnectedException -> 0x068d, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x0685 A[Catch:{ DeviceDisconnectedException -> 0x068d, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x069c A[Catch:{ DeviceDisconnectedException -> 0x068d, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x069d A[ExcHandler: RemoteDfuException (e no.nordicsemi.android.dfu.internal.exception.RemoteDfuException), Splitter:B:6:0x006f] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01dc A[ExcHandler: UnknownResponseException (e no.nordicsemi.android.dfu.internal.exception.UnknownResponseException), PHI: r24 
      PHI: (r24v14 java.lang.String) = (r24v7 java.lang.String), (r24v7 java.lang.String), (r24v10 java.lang.String), (r24v10 java.lang.String), (r24v10 java.lang.String), (r24v10 java.lang.String), (r24v10 java.lang.String), (r24v10 java.lang.String), (r24v10 java.lang.String), (r24v10 java.lang.String), (r24v10 java.lang.String), (r24v10 java.lang.String), (r24v10 java.lang.String), (r24v15 java.lang.String), (r24v15 java.lang.String), (r24v15 java.lang.String), (r24v15 java.lang.String), (r24v15 java.lang.String), (r24v15 java.lang.String), (r24v15 java.lang.String), (r24v15 java.lang.String), (r24v15 java.lang.String), (r24v15 java.lang.String), (r24v15 java.lang.String) binds: [B:167:0x0526, B:169:0x0537, B:89:0x0229, B:130:0x034b, B:97:0x0239, B:98:?, B:100:0x0265, B:101:?, B:112:0x0331, B:113:?, B:115:0x0335, B:104:0x0320, B:105:?, B:45:0x0121, B:46:?, B:48:0x012c, B:49:?, B:51:0x01c1, B:52:?, B:67:0x01f8, B:68:?, B:70:0x01fc, B:56:0x01d8, B:57:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:89:0x0229] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01e4 A[ExcHandler: UploadAbortedException (e no.nordicsemi.android.dfu.internal.exception.UploadAbortedException), PHI: r24 
      PHI: (r24v13 java.lang.String) = (r24v7 java.lang.String), (r24v7 java.lang.String), (r24v10 java.lang.String), (r24v10 java.lang.String), (r24v10 java.lang.String), (r24v10 java.lang.String), (r24v10 java.lang.String), (r24v10 java.lang.String), (r24v10 java.lang.String), (r24v10 java.lang.String), (r24v10 java.lang.String), (r24v10 java.lang.String), (r24v10 java.lang.String), (r24v15 java.lang.String), (r24v15 java.lang.String), (r24v15 java.lang.String), (r24v15 java.lang.String), (r24v15 java.lang.String), (r24v15 java.lang.String), (r24v15 java.lang.String), (r24v15 java.lang.String), (r24v15 java.lang.String), (r24v15 java.lang.String), (r24v15 java.lang.String) binds: [B:167:0x0526, B:169:0x0537, B:89:0x0229, B:130:0x034b, B:97:0x0239, B:98:?, B:100:0x0265, B:101:?, B:112:0x0331, B:113:?, B:115:0x0335, B:104:0x0320, B:105:?, B:45:0x0121, B:46:?, B:48:0x012c, B:49:?, B:51:0x01c1, B:52:?, B:67:0x01f8, B:68:?, B:70:0x01fc, B:56:0x01d8, B:57:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:45:0x0121] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0232  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void performDfu(@androidx.annotation.NonNull android.content.Intent r29) throws no.nordicsemi.android.dfu.internal.exception.DfuException, no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException, no.nordicsemi.android.dfu.internal.exception.UploadAbortedException {
        /*
            r28 = this;
            r1 = r28
            r2 = r29
            java.lang.String r3 = "DFU target does not support (SD/BL)+App update"
            java.lang.String r4 = " Status = "
            java.lang.String r5 = "Firmware image size sent ("
            java.lang.String r6 = "b)"
            java.lang.String r7 = "DFU Start sent (Op Code = 1, Upload Mode = "
            java.lang.String r8 = "Starting DFU failed"
            java.lang.String r9 = "Reset request sent"
            java.lang.String r10 = "Sending Reset command (Op Code = 6)"
            java.lang.String r11 = ", Status = "
            java.lang.String r12 = "Response received (Op Code = "
            java.lang.String r13 = "b, "
            java.lang.String r14 = ")"
            java.lang.String r15 = "Legacy DFU bootloader found"
            r1.logw(r15)
            no.nordicsemi.android.dfu.DfuProgressInfo r15 = r1.mProgressInfo
            r16 = r11
            r11 = -2
            r15.setProgress(r11)
            no.nordicsemi.android.dfu.DfuBaseService r11 = r1.mService
            r15 = r3
            r2 = 1000(0x3e8, double:4.94E-321)
            r11.waitFor(r2)
            android.bluetooth.BluetoothGatt r11 = r1.mGatt
            java.util.UUID r2 = DFU_SERVICE_UUID
            android.bluetooth.BluetoothGattService r2 = r11.getService(r2)
            java.util.UUID r3 = DFU_VERSION_UUID
            android.bluetooth.BluetoothGattCharacteristic r2 = r2.getCharacteristic(r3)
            int r2 = r1.readVersion(r2)
            r3 = 5
            if (r2 < r3) goto L_0x006f
            java.io.InputStream r3 = r1.mInitPacketStream
            if (r3 != 0) goto L_0x006f
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Init packet not set for the DFU Bootloader version "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r1.logw(r2)
            no.nordicsemi.android.dfu.DfuBaseService r2 = r1.mService
            java.lang.String r3 = "The Init packet is required by this version DFU Bootloader"
            r4 = 20
            r2.sendLogBroadcast(r4, r3)
            no.nordicsemi.android.dfu.DfuBaseService r1 = r1.mService
            r2 = 4107(0x100b, float:5.755E-42)
            r1.terminateConnection(r11, r2)
            return
        L_0x006f:
            android.bluetooth.BluetoothGattCharacteristic r3 = r1.mControlPointCharacteristic     // Catch:{ UploadAbortedException -> 0x0736, UnknownResponseException -> 0x0707, RemoteDfuException -> 0x069d }
            r19 = r15
            r15 = 1
            r1.enableCCCD(r3, r15)     // Catch:{ UploadAbortedException -> 0x06a9, UnknownResponseException -> 0x06a4, RemoteDfuException -> 0x069d }
            no.nordicsemi.android.dfu.DfuBaseService r3 = r1.mService     // Catch:{ UploadAbortedException -> 0x06a9, UnknownResponseException -> 0x06a4, RemoteDfuException -> 0x069d }
            java.lang.String r15 = "Notifications enabled"
            r21 = r2
            r2 = 10
            r3.sendLogBroadcast(r2, r15)     // Catch:{ UploadAbortedException -> 0x06a9, UnknownResponseException -> 0x06a4, RemoteDfuException -> 0x069d }
            no.nordicsemi.android.dfu.DfuBaseService r2 = r1.mService     // Catch:{ UploadAbortedException -> 0x06a9, UnknownResponseException -> 0x06a4, RemoteDfuException -> 0x069d }
            r15 = r4
            r3 = 1000(0x3e8, double:4.94E-321)
            r2.waitFor(r3)     // Catch:{ UploadAbortedException -> 0x06a9, UnknownResponseException -> 0x06a4, RemoteDfuException -> 0x069d }
            int r2 = r1.mFileType     // Catch:{ UploadAbortedException -> 0x06a9, UnknownResponseException -> 0x06a4, RemoteDfuException -> 0x069d }
            r3 = r2 & 1
            if (r3 <= 0) goto L_0x00a7
            int r3 = r1.mImageSizeInBytes     // Catch:{ UploadAbortedException -> 0x00a1, UnknownResponseException -> 0x009b, RemoteDfuException -> 0x0093 }
            goto L_0x00a8
        L_0x0093:
            r0 = move-exception
            r2 = r0
            r22 = r9
            r24 = r10
            goto L_0x06ae
        L_0x009b:
            r0 = move-exception
            r3 = r0
            r4 = r9
            r2 = r10
            goto L_0x070b
        L_0x00a1:
            r0 = move-exception
            r3 = r0
            r4 = r9
            r2 = r10
            goto L_0x073a
        L_0x00a7:
            r3 = 0
        L_0x00a8:
            r4 = r2 & 2
            if (r4 <= 0) goto L_0x00af
            int r4 = r1.mImageSizeInBytes     // Catch:{ UploadAbortedException -> 0x00a1, UnknownResponseException -> 0x009b, RemoteDfuException -> 0x0093 }
            goto L_0x00b0
        L_0x00af:
            r4 = 0
        L_0x00b0:
            r17 = r2 & 4
            if (r17 <= 0) goto L_0x00bb
            r18 = r3
            int r3 = r1.mImageSizeInBytes     // Catch:{ UploadAbortedException -> 0x00a1, UnknownResponseException -> 0x009b, RemoteDfuException -> 0x0093 }
            r22 = r3
            goto L_0x00bf
        L_0x00bb:
            r18 = r3
            r22 = 0
        L_0x00bf:
            java.io.InputStream r3 = r1.mFirmwareStream     // Catch:{ UploadAbortedException -> 0x06a9, UnknownResponseException -> 0x06a4, RemoteDfuException -> 0x069d }
            r23 = r4
            boolean r4 = r3 instanceof no.nordicsemi.android.dfu.internal.ArchiveInputStream     // Catch:{ UploadAbortedException -> 0x06a9, UnknownResponseException -> 0x06a4, RemoteDfuException -> 0x069d }
            if (r4 == 0) goto L_0x0110
            no.nordicsemi.android.dfu.internal.ArchiveInputStream r3 = (no.nordicsemi.android.dfu.internal.ArchiveInputStream) r3     // Catch:{ UploadAbortedException -> 0x00a1, UnknownResponseException -> 0x009b, RemoteDfuException -> 0x0093 }
            boolean r4 = r3.isSecureDfuRequired()     // Catch:{ UploadAbortedException -> 0x00a1, UnknownResponseException -> 0x009b, RemoteDfuException -> 0x0093 }
            if (r4 == 0) goto L_0x00f6
            java.lang.String r2 = "Secure DFU is required to upload selected firmware"
            r1.loge(r2)     // Catch:{ UploadAbortedException -> 0x00a1, UnknownResponseException -> 0x009b, RemoteDfuException -> 0x0093 }
            no.nordicsemi.android.dfu.DfuBaseService r2 = r1.mService     // Catch:{ UploadAbortedException -> 0x00a1, UnknownResponseException -> 0x009b, RemoteDfuException -> 0x0093 }
            java.lang.String r3 = "The device does not support given firmware."
            r4 = 20
            r2.sendLogBroadcast(r4, r3)     // Catch:{ UploadAbortedException -> 0x00a1, UnknownResponseException -> 0x009b, RemoteDfuException -> 0x0093 }
            r1.logi(r10)     // Catch:{ UploadAbortedException -> 0x00a1, UnknownResponseException -> 0x009b, RemoteDfuException -> 0x0093 }
            android.bluetooth.BluetoothGattCharacteristic r2 = r1.mControlPointCharacteristic     // Catch:{ UploadAbortedException -> 0x00a1, UnknownResponseException -> 0x009b, RemoteDfuException -> 0x0093 }
            byte[] r3 = OP_CODE_RESET     // Catch:{ UploadAbortedException -> 0x00a1, UnknownResponseException -> 0x009b, RemoteDfuException -> 0x0093 }
            r1.writeOpCode(r2, r3)     // Catch:{ UploadAbortedException -> 0x00a1, UnknownResponseException -> 0x009b, RemoteDfuException -> 0x0093 }
            no.nordicsemi.android.dfu.DfuBaseService r2 = r1.mService     // Catch:{ UploadAbortedException -> 0x00a1, UnknownResponseException -> 0x009b, RemoteDfuException -> 0x0093 }
            r3 = 10
            r2.sendLogBroadcast(r3, r9)     // Catch:{ UploadAbortedException -> 0x00a1, UnknownResponseException -> 0x009b, RemoteDfuException -> 0x0093 }
            no.nordicsemi.android.dfu.DfuBaseService r2 = r1.mService     // Catch:{ UploadAbortedException -> 0x00a1, UnknownResponseException -> 0x009b, RemoteDfuException -> 0x0093 }
            r3 = 4099(0x1003, float:5.744E-42)
            r2.terminateConnection(r11, r3)     // Catch:{ UploadAbortedException -> 0x00a1, UnknownResponseException -> 0x009b, RemoteDfuException -> 0x0093 }
            return
        L_0x00f6:
            int r4 = r3.softDeviceImageSize()     // Catch:{ UploadAbortedException -> 0x00a1, UnknownResponseException -> 0x009b, RemoteDfuException -> 0x0093 }
            int r18 = r3.bootloaderImageSize()     // Catch:{ UploadAbortedException -> 0x00a1, UnknownResponseException -> 0x009b, RemoteDfuException -> 0x0093 }
            int r3 = r3.applicationImageSize()     // Catch:{ UploadAbortedException -> 0x00a1, UnknownResponseException -> 0x009b, RemoteDfuException -> 0x0093 }
            r22 = r9
            r26 = r4
            r4 = r3
            r3 = r26
            r27 = r18
            r18 = r15
            r15 = r27
            goto L_0x011a
        L_0x0110:
            r3 = r18
            r4 = r22
            r22 = r9
            r18 = r15
            r15 = r23
        L_0x011a:
            byte[] r9 = OP_CODE_START_DFU     // Catch:{ RemoteDfuException -> 0x0220, UploadAbortedException -> 0x021c, UnknownResponseException -> 0x0218 }
            r24 = r10
            byte r10 = (byte) r2
            r20 = 1
            r9[r20] = r10     // Catch:{ RemoteDfuException -> 0x0211, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ RemoteDfuException -> 0x0211, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r10.<init>()     // Catch:{ RemoteDfuException -> 0x0211, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r25 = r8
            java.lang.String r8 = "Sending Start DFU command (Op Code = 1, Upload Mode = "
            r10.append(r8)     // Catch:{ RemoteDfuException -> 0x020b, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r10.append(r2)     // Catch:{ RemoteDfuException -> 0x020b, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r10.append(r14)     // Catch:{ RemoteDfuException -> 0x020b, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            java.lang.String r8 = r10.toString()     // Catch:{ RemoteDfuException -> 0x020b, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r1.logi(r8)     // Catch:{ RemoteDfuException -> 0x020b, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            android.bluetooth.BluetoothGattCharacteristic r8 = r1.mControlPointCharacteristic     // Catch:{ RemoteDfuException -> 0x020b, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r1.writeOpCode(r8, r9)     // Catch:{ RemoteDfuException -> 0x020b, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            no.nordicsemi.android.dfu.DfuBaseService r8 = r1.mService     // Catch:{ RemoteDfuException -> 0x020b, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ RemoteDfuException -> 0x020b, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r9.<init>()     // Catch:{ RemoteDfuException -> 0x020b, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r9.append(r7)     // Catch:{ RemoteDfuException -> 0x020b, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r9.append(r2)     // Catch:{ RemoteDfuException -> 0x020b, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r9.append(r14)     // Catch:{ RemoteDfuException -> 0x020b, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            java.lang.String r9 = r9.toString()     // Catch:{ RemoteDfuException -> 0x020b, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r10 = 10
            r8.sendLogBroadcast(r10, r9)     // Catch:{ RemoteDfuException -> 0x020b, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ RemoteDfuException -> 0x020b, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r8.<init>()     // Catch:{ RemoteDfuException -> 0x020b, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            java.lang.String r9 = "Sending image size array to DFU Packet ("
            r8.append(r9)     // Catch:{ RemoteDfuException -> 0x020b, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r8.append(r3)     // Catch:{ RemoteDfuException -> 0x020b, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r8.append(r13)     // Catch:{ RemoteDfuException -> 0x020b, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r8.append(r15)     // Catch:{ RemoteDfuException -> 0x020b, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r8.append(r13)     // Catch:{ RemoteDfuException -> 0x020b, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r8.append(r4)     // Catch:{ RemoteDfuException -> 0x020b, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r8.append(r6)     // Catch:{ RemoteDfuException -> 0x020b, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            java.lang.String r8 = r8.toString()     // Catch:{ RemoteDfuException -> 0x020b, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r1.logi(r8)     // Catch:{ RemoteDfuException -> 0x020b, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            android.bluetooth.BluetoothGattCharacteristic r8 = r1.mPacketCharacteristic     // Catch:{ RemoteDfuException -> 0x020b, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r1.writeImageSize(r8, r3, r15, r4)     // Catch:{ RemoteDfuException -> 0x020b, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            no.nordicsemi.android.dfu.DfuBaseService r8 = r1.mService     // Catch:{ RemoteDfuException -> 0x020b, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ RemoteDfuException -> 0x020b, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r9.<init>()     // Catch:{ RemoteDfuException -> 0x020b, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r9.append(r5)     // Catch:{ RemoteDfuException -> 0x020b, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r9.append(r3)     // Catch:{ RemoteDfuException -> 0x020b, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r9.append(r13)     // Catch:{ RemoteDfuException -> 0x020b, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r9.append(r15)     // Catch:{ RemoteDfuException -> 0x020b, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r9.append(r13)     // Catch:{ RemoteDfuException -> 0x020b, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r9.append(r4)     // Catch:{ RemoteDfuException -> 0x020b, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r9.append(r6)     // Catch:{ RemoteDfuException -> 0x020b, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            java.lang.String r4 = r9.toString()     // Catch:{ RemoteDfuException -> 0x020b, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r6 = 10
            r8.sendLogBroadcast(r6, r4)     // Catch:{ RemoteDfuException -> 0x020b, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            byte[] r4 = r28.readNotificationResponse()     // Catch:{ RemoteDfuException -> 0x020b, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r6 = 1
            int r8 = r1.getStatusCode(r4, r6)     // Catch:{ RemoteDfuException -> 0x020b, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            no.nordicsemi.android.dfu.DfuBaseService r9 = r1.mService     // Catch:{ RemoteDfuException -> 0x020b, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ RemoteDfuException -> 0x020b, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r10.<init>()     // Catch:{ RemoteDfuException -> 0x020b, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r10.append(r12)     // Catch:{ RemoteDfuException -> 0x020b, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            byte r4 = r4[r6]     // Catch:{ RemoteDfuException -> 0x020b, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r10.append(r4)     // Catch:{ RemoteDfuException -> 0x020b, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r4 = r18
            r10.append(r4)     // Catch:{ RemoteDfuException -> 0x0207, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r10.append(r8)     // Catch:{ RemoteDfuException -> 0x0207, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r10.append(r14)     // Catch:{ RemoteDfuException -> 0x0207, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            java.lang.String r6 = r10.toString()     // Catch:{ RemoteDfuException -> 0x0207, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r10 = 10
            r9.sendLogBroadcast(r10, r6)     // Catch:{ RemoteDfuException -> 0x0207, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r6 = 2
            if (r8 != r6) goto L_0x01f1
            r6 = r29
            r1.resetAndRestart(r11, r6)     // Catch:{ RemoteDfuException -> 0x01ec, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            return
        L_0x01dc:
            r0 = move-exception
        L_0x01dd:
            r3 = r0
            r4 = r22
            r2 = r24
            goto L_0x070b
        L_0x01e4:
            r0 = move-exception
        L_0x01e5:
            r3 = r0
            r4 = r22
            r2 = r24
            goto L_0x073a
        L_0x01ec:
            r0 = move-exception
            r8 = r0
            r10 = r25
            goto L_0x0229
        L_0x01f1:
            r6 = r29
            r9 = 1
            if (r8 != r9) goto L_0x01f8
            goto L_0x032c
        L_0x01f8:
            no.nordicsemi.android.dfu.internal.exception.RemoteDfuException r9 = new no.nordicsemi.android.dfu.internal.exception.RemoteDfuException     // Catch:{ RemoteDfuException -> 0x0203, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r10 = r25
            r9.<init>(r10, r8)     // Catch:{ RemoteDfuException -> 0x0200, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            throw r9     // Catch:{ RemoteDfuException -> 0x0200, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
        L_0x0200:
            r0 = move-exception
        L_0x0201:
            r8 = r0
            goto L_0x0229
        L_0x0203:
            r0 = move-exception
        L_0x0204:
            r10 = r25
            goto L_0x0201
        L_0x0207:
            r0 = move-exception
            r6 = r29
            goto L_0x0204
        L_0x020b:
            r0 = move-exception
            r6 = r29
            r4 = r18
            goto L_0x0204
        L_0x0211:
            r0 = move-exception
            r6 = r29
            r10 = r8
            r4 = r18
            goto L_0x0201
        L_0x0218:
            r0 = move-exception
        L_0x0219:
            r24 = r10
            goto L_0x01dd
        L_0x021c:
            r0 = move-exception
        L_0x021d:
            r24 = r10
            goto L_0x01e5
        L_0x0220:
            r0 = move-exception
            r6 = r29
            r24 = r10
            r4 = r18
            r10 = r8
            goto L_0x0201
        L_0x0229:
            int r9 = r8.getErrorNumber()     // Catch:{ RemoteDfuException -> 0x0347, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r25 = r5
            r5 = 3
            if (r9 != r5) goto L_0x0345
            if (r17 <= 0) goto L_0x0343
            r5 = r2 & 3
            if (r5 <= 0) goto L_0x0343
            r5 = 0
            r1.mRemoteErrorOccurred = r5     // Catch:{ RemoteDfuException -> 0x0340, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r5 = r19
            r1.logw(r5)     // Catch:{ RemoteDfuException -> 0x0340, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            no.nordicsemi.android.dfu.DfuBaseService r8 = r1.mService     // Catch:{ RemoteDfuException -> 0x0340, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r9 = 15
            r8.sendLogBroadcast(r9, r5)     // Catch:{ RemoteDfuException -> 0x0340, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r2 = r2 & -5
            r1.mFileType = r2     // Catch:{ RemoteDfuException -> 0x0340, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            byte[] r5 = OP_CODE_START_DFU     // Catch:{ RemoteDfuException -> 0x0340, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            byte r8 = (byte) r2     // Catch:{ RemoteDfuException -> 0x0340, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r9 = 1
            r5[r9] = r8     // Catch:{ RemoteDfuException -> 0x0340, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            no.nordicsemi.android.dfu.DfuProgressInfo r8 = r1.mProgressInfo     // Catch:{ RemoteDfuException -> 0x0340, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r9 = 2
            r8.setTotalPart(r9)     // Catch:{ RemoteDfuException -> 0x0340, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            java.io.InputStream r8 = r1.mFirmwareStream     // Catch:{ RemoteDfuException -> 0x0340, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            no.nordicsemi.android.dfu.internal.ArchiveInputStream r8 = (no.nordicsemi.android.dfu.internal.ArchiveInputStream) r8     // Catch:{ RemoteDfuException -> 0x0340, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r8.setContentType(r2)     // Catch:{ RemoteDfuException -> 0x0340, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            no.nordicsemi.android.dfu.DfuBaseService r8 = r1.mService     // Catch:{ RemoteDfuException -> 0x0340, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            java.lang.String r9 = "Sending only SD/BL"
            r17 = r10
            r10 = 1
            r8.sendLogBroadcast(r10, r9)     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r8.<init>()     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            java.lang.String r9 = "Resending Start DFU command (Op Code = 1, Upload Mode = "
            r8.append(r9)     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r8.append(r2)     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r8.append(r14)     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            java.lang.String r8 = r8.toString()     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r1.logi(r8)     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            android.bluetooth.BluetoothGattCharacteristic r8 = r1.mControlPointCharacteristic     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r1.writeOpCode(r8, r5)     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            no.nordicsemi.android.dfu.DfuBaseService r5 = r1.mService     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r8.<init>()     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r8.append(r7)     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r8.append(r2)     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r8.append(r14)     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            java.lang.String r7 = r8.toString()     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r8 = 10
            r5.sendLogBroadcast(r8, r7)     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r5.<init>()     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            java.lang.String r7 = "Sending image size array to DFU Packet: ["
            r5.append(r7)     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r5.append(r3)     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r5.append(r13)     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r5.append(r15)     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r5.append(r13)     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r7 = 0
            r5.append(r7)     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            java.lang.String r7 = "b]"
            r5.append(r7)     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            java.lang.String r5 = r5.toString()     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r1.logi(r5)     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            android.bluetooth.BluetoothGattCharacteristic r5 = r1.mPacketCharacteristic     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r7 = 0
            r1.writeImageSize(r5, r3, r15, r7)     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            no.nordicsemi.android.dfu.DfuBaseService r5 = r1.mService     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r7.<init>()     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            java.lang.String r8 = "Firmware image size sent ["
            r7.append(r8)     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r7.append(r3)     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r7.append(r13)     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r7.append(r15)     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r7.append(r13)     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r3 = 0
            r7.append(r3)     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            java.lang.String r3 = "b]"
            r7.append(r3)     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            java.lang.String r3 = r7.toString()     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r7 = 10
            r5.sendLogBroadcast(r7, r3)     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            byte[] r3 = r28.readNotificationResponse()     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r5 = 1
            int r7 = r1.getStatusCode(r3, r5)     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            no.nordicsemi.android.dfu.DfuBaseService r8 = r1.mService     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r9.<init>()     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r9.append(r12)     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            byte r3 = r3[r5]     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r9.append(r3)     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r9.append(r4)     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r9.append(r7)     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r9.append(r14)     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            java.lang.String r3 = r9.toString()     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r4 = 10
            r8.sendLogBroadcast(r4, r3)     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r3 = 2
            if (r7 != r3) goto L_0x0329
            r1.resetAndRestart(r11, r6)     // Catch:{ RemoteDfuException -> 0x0324, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            return
        L_0x0324:
            r0 = move-exception
            r3 = r0
            r4 = r17
            goto L_0x034b
        L_0x0329:
            r3 = 1
            if (r7 != r3) goto L_0x0331
        L_0x032c:
            r2 = r16
            r3 = 1
            goto L_0x03ff
        L_0x0331:
            no.nordicsemi.android.dfu.internal.exception.RemoteDfuException r3 = new no.nordicsemi.android.dfu.internal.exception.RemoteDfuException     // Catch:{ RemoteDfuException -> 0x033c, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            r4 = r17
            r3.<init>(r4, r7)     // Catch:{ RemoteDfuException -> 0x0339, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
            throw r3     // Catch:{ RemoteDfuException -> 0x0339, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
        L_0x0339:
            r0 = move-exception
        L_0x033a:
            r3 = r0
            goto L_0x034b
        L_0x033c:
            r0 = move-exception
            r4 = r17
            goto L_0x033a
        L_0x0340:
            r0 = move-exception
        L_0x0341:
            r4 = r10
            goto L_0x033a
        L_0x0343:
            r4 = r10
            throw r8     // Catch:{ RemoteDfuException -> 0x0339, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
        L_0x0345:
            r4 = r10
            throw r8     // Catch:{ RemoteDfuException -> 0x0339, UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc }
        L_0x0347:
            r0 = move-exception
            r25 = r5
            goto L_0x0341
        L_0x034b:
            int r5 = r3.getErrorNumber()     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r7 = 3
            if (r5 != r7) goto L_0x069c
            r5 = 4
            if (r2 != r5) goto L_0x069b
            r2 = 0
            r1.mRemoteErrorOccurred = r2     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.String r2 = "DFU target does not support DFU v.2"
            r1.logw(r2)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            no.nordicsemi.android.dfu.DfuBaseService r2 = r1.mService     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.String r3 = "DFU target does not support DFU v.2"
            r5 = 15
            r2.sendLogBroadcast(r5, r3)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            no.nordicsemi.android.dfu.DfuBaseService r2 = r1.mService     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.String r3 = "Switching to DFU v.1"
            r5 = 1
            r2.sendLogBroadcast(r5, r3)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.String r2 = "Resending Start DFU command (Op Code = 1)"
            r1.logi(r2)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            android.bluetooth.BluetoothGattCharacteristic r2 = r1.mControlPointCharacteristic     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            byte[] r3 = OP_CODE_START_DFU_V1     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r1.writeOpCode(r2, r3)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            no.nordicsemi.android.dfu.DfuBaseService r2 = r1.mService     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.String r3 = "DFU Start sent (Op Code = 1)"
            r5 = 10
            r2.sendLogBroadcast(r5, r3)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r2.<init>()     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.String r3 = "Sending application image size to DFU Packet: "
            r2.append(r3)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            int r3 = r1.mImageSizeInBytes     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r2.append(r3)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.String r3 = " bytes"
            r2.append(r3)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.String r2 = r2.toString()     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r1.logi(r2)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            android.bluetooth.BluetoothGattCharacteristic r2 = r1.mPacketCharacteristic     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            int r3 = r1.mImageSizeInBytes     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r1.writeImageSize(r2, r3)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            no.nordicsemi.android.dfu.DfuBaseService r2 = r1.mService     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r3.<init>()     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r5 = r25
            r3.append(r5)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            int r5 = r1.mImageSizeInBytes     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r3.append(r5)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.String r5 = " bytes)"
            r3.append(r5)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.String r3 = r3.toString()     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r5 = 10
            r2.sendLogBroadcast(r5, r3)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            byte[] r2 = r28.readNotificationResponse()     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r3 = 1
            int r5 = r1.getStatusCode(r2, r3)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            no.nordicsemi.android.dfu.DfuBaseService r7 = r1.mService     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r8.<init>()     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r8.append(r12)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            byte r2 = r2[r3]     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r8.append(r2)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r2 = r16
            r8.append(r2)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r8.append(r5)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r8.append(r14)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.String r3 = r8.toString()     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r8 = 10
            r7.sendLogBroadcast(r8, r3)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r3 = 2
            if (r5 != r3) goto L_0x03fb
            r1.resetAndRestart(r11, r6)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            return
        L_0x03f7:
            r0 = move-exception
        L_0x03f8:
            r2 = r0
            goto L_0x06ae
        L_0x03fb:
            r3 = 1
            if (r5 != r3) goto L_0x0695
            r3 = 0
        L_0x03ff:
            java.io.InputStream r4 = r1.mInitPacketStream     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            if (r4 == 0) goto L_0x04b5
            no.nordicsemi.android.dfu.DfuBaseService r4 = r1.mService     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.String r5 = "Writing Initialize DFU Parameters..."
            r7 = 10
            r4.sendLogBroadcast(r7, r5)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            if (r3 == 0) goto L_0x0451
            java.lang.String r4 = "Sending the Initialize DFU Parameters START (Op Code = 2, Value = 0)"
            r1.logi(r4)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            android.bluetooth.BluetoothGattCharacteristic r4 = r1.mControlPointCharacteristic     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            byte[] r5 = OP_CODE_INIT_DFU_PARAMS_START     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r1.writeOpCode(r4, r5)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r4.<init>()     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.String r5 = "Sending "
            r4.append(r5)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            int r5 = r1.mInitPacketSizeInBytes     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r4.append(r5)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.String r5 = " bytes of init packet"
            r4.append(r5)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.String r4 = r4.toString()     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r1.logi(r4)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            android.bluetooth.BluetoothGattCharacteristic r4 = r1.mPacketCharacteristic     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r5 = 0
            r1.writeInitData(r4, r5)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.String r4 = "Sending the Initialize DFU Parameters COMPLETE (Op Code = 2, Value = 1)"
            r1.logi(r4)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            android.bluetooth.BluetoothGattCharacteristic r4 = r1.mControlPointCharacteristic     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            byte[] r5 = OP_CODE_INIT_DFU_PARAMS_COMPLETE     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r1.writeOpCode(r4, r5)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            no.nordicsemi.android.dfu.DfuBaseService r4 = r1.mService     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.String r5 = "Initialize DFU Parameters completed"
            r7 = 10
            r4.sendLogBroadcast(r7, r5)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            goto L_0x047e
        L_0x0451:
            java.lang.String r4 = "Sending the Initialize DFU Parameters (Op Code = 2)"
            r1.logi(r4)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            android.bluetooth.BluetoothGattCharacteristic r4 = r1.mControlPointCharacteristic     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            byte[] r5 = OP_CODE_INIT_DFU_PARAMS     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r1.writeOpCode(r4, r5)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r4.<init>()     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.String r5 = "Sending "
            r4.append(r5)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            int r5 = r1.mInitPacketSizeInBytes     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r4.append(r5)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.String r5 = " bytes of init packet"
            r4.append(r5)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.String r4 = r4.toString()     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r1.logi(r4)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            android.bluetooth.BluetoothGattCharacteristic r4 = r1.mPacketCharacteristic     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r5 = 0
            r1.writeInitData(r4, r5)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
        L_0x047e:
            byte[] r4 = r28.readNotificationResponse()     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r5 = 2
            int r7 = r1.getStatusCode(r4, r5)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            no.nordicsemi.android.dfu.DfuBaseService r5 = r1.mService     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r8.<init>()     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r8.append(r12)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r9 = 1
            byte r4 = r4[r9]     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r8.append(r4)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r8.append(r2)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r8.append(r7)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r8.append(r14)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.String r4 = r8.toString()     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r8 = 10
            r5.sendLogBroadcast(r8, r4)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r4 = 1
            if (r7 != r4) goto L_0x04ad
            goto L_0x04b5
        L_0x04ad:
            no.nordicsemi.android.dfu.internal.exception.RemoteDfuException r2 = new no.nordicsemi.android.dfu.internal.exception.RemoteDfuException     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.String r3 = "Device returned error after sending init packet"
            r2.<init>(r3, r7)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            throw r2     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
        L_0x04b5:
            if (r3 != 0) goto L_0x04c3
            int r3 = r1.mPacketsBeforeNotification     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            if (r3 <= 0) goto L_0x04c0
            r4 = 10
            if (r3 > r4) goto L_0x04c0
            goto L_0x04c3
        L_0x04c0:
            r3 = 10
            goto L_0x04c5
        L_0x04c3:
            int r3 = r1.mPacketsBeforeNotification     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
        L_0x04c5:
            if (r3 <= 0) goto L_0x0505
            r1.mPacketsBeforeNotification = r3     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r4.<init>()     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.String r5 = "Sending the number of packets before notifications (Op Code = 8, Value = "
            r4.append(r5)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r4.append(r3)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r4.append(r14)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.String r4 = r4.toString()     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r1.logi(r4)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            byte[] r4 = OP_CODE_PACKET_RECEIPT_NOTIF_REQ     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r1.setNumberOfPackets(r4, r3)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            android.bluetooth.BluetoothGattCharacteristic r5 = r1.mControlPointCharacteristic     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r1.writeOpCode(r5, r4)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            no.nordicsemi.android.dfu.DfuBaseService r4 = r1.mService     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r5.<init>()     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.String r7 = "Packet Receipt Notif Req (Op Code = 8) sent (Value = "
            r5.append(r7)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r5.append(r3)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r5.append(r14)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.String r3 = r5.toString()     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r5 = 10
            r4.sendLogBroadcast(r5, r3)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
        L_0x0505:
            java.lang.String r3 = "Sending Receive Firmware Image request (Op Code = 3)"
            r1.logi(r3)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            android.bluetooth.BluetoothGattCharacteristic r3 = r1.mControlPointCharacteristic     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            byte[] r4 = OP_CODE_RECEIVE_FIRMWARE_IMAGE     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r1.writeOpCode(r3, r4)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            no.nordicsemi.android.dfu.DfuBaseService r3 = r1.mService     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.String r4 = "Receive Firmware Image request sent"
            r5 = 10
            r3.sendLogBroadcast(r5, r4)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            long r3 = android.os.SystemClock.elapsedRealtime()     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            no.nordicsemi.android.dfu.DfuProgressInfo r5 = r1.mProgressInfo     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r7 = 0
            r5.setBytesSent(r7)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.String r5 = "Uploading firmware..."
            r1.logi(r5)     // Catch:{ DeviceDisconnectedException -> 0x068d }
            no.nordicsemi.android.dfu.DfuBaseService r5 = r1.mService     // Catch:{ DeviceDisconnectedException -> 0x068d }
            java.lang.String r7 = "Uploading firmware..."
            r8 = 10
            r5.sendLogBroadcast(r8, r7)     // Catch:{ DeviceDisconnectedException -> 0x068d }
            android.bluetooth.BluetoothGattCharacteristic r5 = r1.mPacketCharacteristic     // Catch:{ DeviceDisconnectedException -> 0x068d }
            r1.uploadFirmwareImage(r5)     // Catch:{ DeviceDisconnectedException -> 0x068d }
            long r7 = android.os.SystemClock.elapsedRealtime()     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            byte[] r5 = r28.readNotificationResponse()     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r9 = 3
            int r9 = r1.getStatusCode(r5, r9)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r10.<init>()     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r10.append(r12)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r13 = 0
            byte r15 = r5[r13]     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r10.append(r15)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.String r13 = ", Req Op Code = "
            r10.append(r13)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r13 = 1
            byte r15 = r5[r13]     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r10.append(r15)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r10.append(r2)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r13 = 2
            byte r15 = r5[r13]     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r10.append(r15)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r10.append(r14)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.String r10 = r10.toString()     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r1.logi(r10)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            no.nordicsemi.android.dfu.DfuBaseService r10 = r1.mService     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r13.<init>()     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r13.append(r12)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r15 = 1
            byte r5 = r5[r15]     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r13.append(r5)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r13.append(r2)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r13.append(r9)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r13.append(r14)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.String r5 = r13.toString()     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r13 = 10
            r10.sendLogBroadcast(r13, r5)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r5 = 1
            if (r9 != r5) goto L_0x0685
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r5.<init>()     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.String r9 = "Transfer of "
            r5.append(r9)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            no.nordicsemi.android.dfu.DfuProgressInfo r9 = r1.mProgressInfo     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            int r9 = r9.getBytesSent()     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r5.append(r9)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.String r9 = " bytes has taken "
            r5.append(r9)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            long r7 = r7 - r3
            r5.append(r7)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.String r3 = " ms"
            r5.append(r3)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.String r3 = r5.toString()     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r1.logi(r3)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            no.nordicsemi.android.dfu.DfuBaseService r3 = r1.mService     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r4.<init>()     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.String r5 = "Upload completed in "
            r4.append(r5)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r4.append(r7)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.String r5 = " ms"
            r4.append(r5)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.String r4 = r4.toString()     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r5 = 10
            r3.sendLogBroadcast(r5, r4)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.String r3 = "Sending Validate request (Op Code = 4)"
            r1.logi(r3)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            android.bluetooth.BluetoothGattCharacteristic r3 = r1.mControlPointCharacteristic     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            byte[] r4 = OP_CODE_VALIDATE     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r1.writeOpCode(r3, r4)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            no.nordicsemi.android.dfu.DfuBaseService r3 = r1.mService     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.String r4 = "Validate request sent"
            r5 = 10
            r3.sendLogBroadcast(r5, r4)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            byte[] r3 = r28.readNotificationResponse()     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r4 = 4
            int r4 = r1.getStatusCode(r3, r4)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r5.<init>()     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r5.append(r12)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r7 = 0
            byte r8 = r3[r7]     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r5.append(r8)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.String r7 = ", Req Op Code = "
            r5.append(r7)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r7 = 1
            byte r8 = r3[r7]     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r5.append(r8)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r5.append(r2)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r7 = 2
            byte r7 = r3[r7]     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r5.append(r7)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r5.append(r14)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.String r5 = r5.toString()     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r1.logi(r5)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            no.nordicsemi.android.dfu.DfuBaseService r5 = r1.mService     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r7.<init>()     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r7.append(r12)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r8 = 1
            byte r3 = r3[r8]     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r7.append(r3)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r7.append(r2)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r7.append(r4)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r7.append(r14)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.String r2 = r7.toString()     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r3 = 10
            r5.sendLogBroadcast(r3, r2)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r2 = 1
            if (r4 != r2) goto L_0x067d
            no.nordicsemi.android.dfu.DfuProgressInfo r3 = r1.mProgressInfo     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r4 = -5
            r3.setProgress(r4)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.String r3 = "Sending Activate and Reset request (Op Code = 5)"
            r1.logi(r3)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            android.bluetooth.BluetoothGattCharacteristic r3 = r1.mControlPointCharacteristic     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            byte[] r4 = OP_CODE_ACTIVATE_AND_RESET     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r1.writeOpCode(r3, r4)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            no.nordicsemi.android.dfu.DfuBaseService r3 = r1.mService     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.String r4 = "Activate and Reset request sent"
            r5 = 10
            r3.sendLogBroadcast(r5, r4)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            no.nordicsemi.android.dfu.DfuBaseService r3 = r1.mService     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r3.waitUntilDisconnected()     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            no.nordicsemi.android.dfu.DfuBaseService r3 = r1.mService     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.String r4 = "Disconnected by the remote device"
            r5 = 5
            r3.sendLogBroadcast(r5, r4)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r3 = r21
            if (r3 != r5) goto L_0x0677
            r15 = r2
            goto L_0x0678
        L_0x0677:
            r15 = 0
        L_0x0678:
            r1.finalize(r6, r15)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            goto L_0x0735
        L_0x067d:
            no.nordicsemi.android.dfu.internal.exception.RemoteDfuException r2 = new no.nordicsemi.android.dfu.internal.exception.RemoteDfuException     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.String r3 = "Device returned validation error"
            r2.<init>(r3, r4)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            throw r2     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
        L_0x0685:
            no.nordicsemi.android.dfu.internal.exception.RemoteDfuException r2 = new no.nordicsemi.android.dfu.internal.exception.RemoteDfuException     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            java.lang.String r3 = "Device returned error after sending file"
            r2.<init>(r3, r9)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            throw r2     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
        L_0x068d:
            r0 = move-exception
            r2 = r0
            java.lang.String r3 = "Disconnected while sending data"
            r1.loge(r3)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            throw r2     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
        L_0x0695:
            no.nordicsemi.android.dfu.internal.exception.RemoteDfuException r2 = new no.nordicsemi.android.dfu.internal.exception.RemoteDfuException     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            r2.<init>(r4, r5)     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
            throw r2     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
        L_0x069b:
            throw r3     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
        L_0x069c:
            throw r3     // Catch:{ UploadAbortedException -> 0x01e4, UnknownResponseException -> 0x01dc, RemoteDfuException -> 0x03f7 }
        L_0x069d:
            r0 = move-exception
            r22 = r9
            r24 = r10
            goto L_0x03f8
        L_0x06a4:
            r0 = move-exception
            r22 = r9
            goto L_0x0219
        L_0x06a9:
            r0 = move-exception
            r22 = r9
            goto L_0x021d
        L_0x06ae:
            int r3 = r2.getErrorNumber()
            r4 = r3 | 256(0x100, float:3.59E-43)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r2 = r2.getMessage()
            r5.append(r2)
            java.lang.String r2 = ": "
            r5.append(r2)
            java.lang.String r2 = no.nordicsemi.android.error.LegacyDfuError.parse(r4)
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            r1.loge(r2)
            no.nordicsemi.android.dfu.DfuBaseService r2 = r1.mService
            java.util.Locale r5 = java.util.Locale.US
            java.lang.String r4 = no.nordicsemi.android.error.LegacyDfuError.parse(r4)
            java.lang.Object[] r4 = new java.lang.Object[]{r4}
            java.lang.String r6 = "Remote DFU error: %s"
            java.lang.String r4 = java.lang.String.format(r5, r6, r4)
            r5 = 20
            r2.sendLogBroadcast(r5, r4)
            r2 = r24
            r1.logi(r2)
            android.bluetooth.BluetoothGattCharacteristic r2 = r1.mControlPointCharacteristic
            byte[] r4 = OP_CODE_RESET
            r1.writeOpCode(r2, r4)
            no.nordicsemi.android.dfu.DfuBaseService r2 = r1.mService
            r4 = r22
            r5 = 10
            r2.sendLogBroadcast(r5, r4)
            no.nordicsemi.android.dfu.DfuBaseService r1 = r1.mService
            r2 = r3 | 8448(0x2100, float:1.1838E-41)
            r1.terminateConnection(r11, r2)
            goto L_0x0735
        L_0x0707:
            r0 = move-exception
            r4 = r9
            r2 = r10
            r3 = r0
        L_0x070b:
            java.lang.String r5 = r3.getMessage()
            r1.loge(r5)
            no.nordicsemi.android.dfu.DfuBaseService r5 = r1.mService
            java.lang.String r3 = r3.getMessage()
            r6 = 20
            r5.sendLogBroadcast(r6, r3)
            r1.logi(r2)
            android.bluetooth.BluetoothGattCharacteristic r2 = r1.mControlPointCharacteristic
            byte[] r3 = OP_CODE_RESET
            r1.writeOpCode(r2, r3)
            no.nordicsemi.android.dfu.DfuBaseService r2 = r1.mService
            r3 = 10
            r2.sendLogBroadcast(r3, r4)
            no.nordicsemi.android.dfu.DfuBaseService r1 = r1.mService
            r2 = 4104(0x1008, float:5.751E-42)
            r1.terminateConnection(r11, r2)
        L_0x0735:
            return
        L_0x0736:
            r0 = move-exception
            r4 = r9
            r2 = r10
            r3 = r0
        L_0x073a:
            r1.logi(r2)
            r2 = 0
            r1.mAborted = r2
            android.bluetooth.BluetoothGattCharacteristic r2 = r1.mControlPointCharacteristic
            byte[] r5 = OP_CODE_RESET
            r1.writeOpCode(r2, r5)
            no.nordicsemi.android.dfu.DfuBaseService r1 = r1.mService
            r2 = 10
            r1.sendLogBroadcast(r2, r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.LegacyDfuImpl.performDfu(android.content.Intent):void");
    }

    public BaseCustomDfuImpl.BaseCustomBluetoothCallback getGattCallback() {
        return this.mBluetoothCallback;
    }

    private void writeImageSize(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, int i, int i2, int i3) throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        this.mReceivedData = null;
        this.mError = 0;
        this.mImageSizeInProgress = true;
        bluetoothGattCharacteristic.setWriteType(1);
        bluetoothGattCharacteristic.setValue(new byte[12]);
        bluetoothGattCharacteristic.setValue(i, 20, 0);
        bluetoothGattCharacteristic.setValue(i2, 20, 4);
        bluetoothGattCharacteristic.setValue(i3, 20, 8);
        DfuBaseService dfuBaseService = this.mService;
        dfuBaseService.sendLogBroadcast(1, "Writing to characteristic " + bluetoothGattCharacteristic.getUuid());
        DfuBaseService dfuBaseService2 = this.mService;
        dfuBaseService2.sendLogBroadcast(0, "gatt.writeCharacteristic(" + bluetoothGattCharacteristic.getUuid() + ")");
        this.mGatt.writeCharacteristic(bluetoothGattCharacteristic);
        try {
            synchronized (this.mLock) {
                while (true) {
                    if (this.mImageSizeInProgress && this.mConnected && this.mError == 0) {
                        if (!this.mAborted) {
                            continue;
                            this.mLock.wait();
                        }
                    }
                    if (!this.mPaused) {
                        break;
                    }
                    this.mLock.wait();
                }
            }
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        } catch (Throwable th) {
            throw th;
        }
        if (this.mAborted) {
            throw new UploadAbortedException();
        } else if (!this.mConnected) {
            throw new DeviceDisconnectedException("Unable to write Image Sizes: device disconnected");
        } else if (this.mError != 0) {
            throw new DfuException("Unable to write Image Sizes", this.mError);
        }
    }
}
