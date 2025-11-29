package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.UUID;
import no.nordicsemi.android.dfu.BaseCustomDfuImpl;
import no.nordicsemi.android.dfu.BaseDfuImpl;
import no.nordicsemi.android.dfu.internal.ArchiveInputStream;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.RemoteDfuException;
import no.nordicsemi.android.dfu.internal.exception.RemoteDfuExtendedErrorException;
import no.nordicsemi.android.dfu.internal.exception.UnknownResponseException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;
import no.nordicsemi.android.error.SecureDfuError;

class SecureDfuImpl extends BaseCustomDfuImpl {
    static final UUID DEFAULT_DFU_CONTROL_POINT_UUID;
    static final UUID DEFAULT_DFU_PACKET_UUID;
    static final UUID DEFAULT_DFU_SERVICE_UUID;
    static UUID DFU_CONTROL_POINT_UUID = null;
    static UUID DFU_PACKET_UUID = null;
    static UUID DFU_SERVICE_UUID = null;
    private static final int DFU_STATUS_SUCCESS = 1;
    private static final int MAX_ATTEMPTS = 3;
    private static final int OBJECT_COMMAND = 1;
    private static final int OBJECT_DATA = 2;
    private static final byte[] OP_CODE_CALCULATE_CHECKSUM = {3};
    private static final int OP_CODE_CALCULATE_CHECKSUM_KEY = 3;
    private static final byte[] OP_CODE_CREATE_COMMAND = {1, 1, 0, 0, 0, 0};
    private static final byte[] OP_CODE_CREATE_DATA = {1, 2, 0, 0, 0, 0};
    private static final int OP_CODE_CREATE_KEY = 1;
    private static final byte[] OP_CODE_EXECUTE = {4};
    private static final int OP_CODE_EXECUTE_KEY = 4;
    private static final byte[] OP_CODE_PACKET_RECEIPT_NOTIF_REQ = {2, 0, 0};
    private static final int OP_CODE_PACKET_RECEIPT_NOTIF_REQ_KEY = 2;
    private static final int OP_CODE_RESPONSE_CODE_KEY = 96;
    private static final byte[] OP_CODE_SELECT_OBJECT = {6, 0};
    private static final int OP_CODE_SELECT_OBJECT_KEY = 6;
    private final SecureBluetoothCallback mBluetoothCallback = new SecureBluetoothCallback();
    private BluetoothGattCharacteristic mControlPointCharacteristic;
    private BluetoothGattCharacteristic mPacketCharacteristic;

    public class ObjectChecksum {
        int CRC32;
        int offset;

        private ObjectChecksum() {
        }
    }

    public class ObjectInfo extends ObjectChecksum {
        int maxSize;

        private ObjectInfo() {
            super();
        }
    }

    public class SecureBluetoothCallback extends BaseCustomDfuImpl.BaseCustomBluetoothCallback {
        public SecureBluetoothCallback() {
            super();
        }

        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            if (bluetoothGattCharacteristic.getValue() == null || bluetoothGattCharacteristic.getValue().length < 3) {
                SecureDfuImpl secureDfuImpl = SecureDfuImpl.this;
                secureDfuImpl.loge("Empty response: " + parse(bluetoothGattCharacteristic));
                SecureDfuImpl secureDfuImpl2 = SecureDfuImpl.this;
                secureDfuImpl2.mError = DfuBaseService.ERROR_INVALID_RESPONSE;
                secureDfuImpl2.notifyLock();
                return;
            }
            if (bluetoothGattCharacteristic.getIntValue(17, 0).intValue() != 96) {
                SecureDfuImpl secureDfuImpl3 = SecureDfuImpl.this;
                secureDfuImpl3.loge("Invalid response: " + parse(bluetoothGattCharacteristic));
                SecureDfuImpl.this.mError = DfuBaseService.ERROR_INVALID_RESPONSE;
            } else if (bluetoothGattCharacteristic.getIntValue(17, 1).intValue() == 3) {
                int intValue = bluetoothGattCharacteristic.getIntValue(20, 3).intValue();
                if (((int) (((ArchiveInputStream) SecureDfuImpl.this.mFirmwareStream).getCrc32() & 4294967295L)) == bluetoothGattCharacteristic.getIntValue(20, 7).intValue()) {
                    SecureDfuImpl.this.mProgressInfo.setBytesReceived(intValue);
                } else {
                    SecureDfuImpl secureDfuImpl4 = SecureDfuImpl.this;
                    if (secureDfuImpl4.mFirmwareUploadInProgress) {
                        secureDfuImpl4.mFirmwareUploadInProgress = false;
                        secureDfuImpl4.notifyLock();
                        return;
                    }
                }
                handlePacketReceiptNotification(bluetoothGatt, bluetoothGattCharacteristic);
            } else if (!SecureDfuImpl.this.mRemoteErrorOccurred) {
                if (bluetoothGattCharacteristic.getIntValue(17, 2).intValue() != 1) {
                    SecureDfuImpl.this.mRemoteErrorOccurred = true;
                }
                handleNotification(bluetoothGatt, bluetoothGattCharacteristic);
            }
            SecureDfuImpl.this.notifyLock();
        }
    }

    static {
        UUID uuid = new UUID(279658205548544L, -9223371485494954757L);
        DEFAULT_DFU_SERVICE_UUID = uuid;
        UUID uuid2 = new UUID(-8157989241631715488L, -6937650605005804976L);
        DEFAULT_DFU_CONTROL_POINT_UUID = uuid2;
        UUID uuid3 = new UUID(-8157989237336748192L, -6937650605005804976L);
        DEFAULT_DFU_PACKET_UUID = uuid3;
        DFU_SERVICE_UUID = uuid;
        DFU_CONTROL_POINT_UUID = uuid2;
        DFU_PACKET_UUID = uuid3;
    }

    public SecureDfuImpl(@NonNull Intent intent, @NonNull DfuBaseService dfuBaseService) {
        super(intent, dfuBaseService);
    }

    private int getStatusCode(byte[] bArr, int i) throws UnknownResponseException {
        byte b;
        if (bArr != null && bArr.length >= 3 && bArr[0] == 96 && bArr[1] == i && ((b = bArr[2]) == 1 || b == 2 || b == 3 || b == 4 || b == 5 || b == 7 || b == 8 || b == 10 || b == 11)) {
            return b;
        }
        throw new UnknownResponseException("Invalid response received", bArr, 96, i);
    }

    private ObjectChecksum readChecksum() throws DeviceDisconnectedException, DfuException, UploadAbortedException, RemoteDfuException, UnknownResponseException {
        if (this.mConnected) {
            writeOpCode(this.mControlPointCharacteristic, OP_CODE_CALCULATE_CHECKSUM);
            byte[] readNotificationResponse = readNotificationResponse();
            int statusCode = getStatusCode(readNotificationResponse, 3);
            if (statusCode == 11) {
                throw new RemoteDfuExtendedErrorException("Receiving Checksum failed", readNotificationResponse[3]);
            } else if (statusCode == 1) {
                ObjectChecksum objectChecksum = new ObjectChecksum();
                objectChecksum.offset = unsignedBytesToInt(readNotificationResponse, 3);
                objectChecksum.CRC32 = unsignedBytesToInt(readNotificationResponse, 7);
                return objectChecksum;
            } else {
                throw new RemoteDfuException("Receiving Checksum failed", statusCode);
            }
        } else {
            throw new DeviceDisconnectedException("Unable to read Checksum: device disconnected");
        }
    }

    private ObjectInfo selectObject(int i) throws DeviceDisconnectedException, DfuException, UploadAbortedException, RemoteDfuException, UnknownResponseException {
        if (this.mConnected) {
            byte[] bArr = OP_CODE_SELECT_OBJECT;
            bArr[1] = (byte) i;
            writeOpCode(this.mControlPointCharacteristic, bArr);
            byte[] readNotificationResponse = readNotificationResponse();
            int statusCode = getStatusCode(readNotificationResponse, 6);
            if (statusCode == 11) {
                throw new RemoteDfuExtendedErrorException("Selecting object failed", readNotificationResponse[3]);
            } else if (statusCode == 1) {
                ObjectInfo objectInfo = new ObjectInfo();
                objectInfo.maxSize = unsignedBytesToInt(readNotificationResponse, 3);
                objectInfo.offset = unsignedBytesToInt(readNotificationResponse, 7);
                objectInfo.CRC32 = unsignedBytesToInt(readNotificationResponse, 11);
                return objectInfo;
            } else {
                throw new RemoteDfuException("Selecting object failed", statusCode);
            }
        } else {
            throw new DeviceDisconnectedException("Unable to read object info: device disconnected");
        }
    }

    private void sendFirmware(BluetoothGatt bluetoothGatt) throws RemoteDfuException, DeviceDisconnectedException, DfuException, UploadAbortedException, UnknownResponseException {
        String str;
        int i;
        boolean z;
        boolean z2;
        boolean z3;
        BluetoothGatt bluetoothGatt2 = bluetoothGatt;
        int i2 = this.mPacketsBeforeNotification;
        if (i2 > 0) {
            setPacketReceiptNotifications(i2);
            this.mService.sendLogBroadcast(10, "Packet Receipt Notif Req (Op Code = 2) sent (Value = " + i2 + ")");
        }
        logi("Setting object to Data (Op Code = 6, Type = 2)");
        ObjectInfo selectObject = selectObject(2);
        Locale locale = Locale.US;
        logi(String.format(locale, "Data object info received (Max size = %d, Offset = %d, CRC = %08X)", new Object[]{Integer.valueOf(selectObject.maxSize), Integer.valueOf(selectObject.offset), Integer.valueOf(selectObject.CRC32)}));
        this.mService.sendLogBroadcast(10, String.format(locale, "Data object info received (Max size = %d, Offset = %d, CRC = %08X)", new Object[]{Integer.valueOf(selectObject.maxSize), Integer.valueOf(selectObject.offset), Integer.valueOf(selectObject.CRC32)}));
        this.mProgressInfo.setMaxObjectSizeInBytes(selectObject.maxSize);
        int i3 = this.mImageSizeInBytes;
        int i4 = selectObject.maxSize;
        int i5 = ((i3 + i4) - 1) / i4;
        int i6 = selectObject.offset;
        if (i6 > 0) {
            try {
                i = i6 / i4;
                int i7 = i4 * i;
                int i8 = i6 - i7;
                if (i8 == 0) {
                    i7 -= i4;
                } else {
                    i4 = i8;
                }
                int i9 = i7;
                if (i9 > 0) {
                    this.mFirmwareStream.read(new byte[i9]);
                    this.mFirmwareStream.mark(selectObject.maxSize);
                }
                this.mFirmwareStream.read(new byte[i4]);
                str = ")";
                if (((int) (((ArchiveInputStream) this.mFirmwareStream).getCrc32() & 4294967295L)) == selectObject.CRC32) {
                    logi(selectObject.offset + " bytes of data sent before, CRC match");
                    this.mService.sendLogBroadcast(10, selectObject.offset + " bytes of data sent before, CRC match");
                    this.mProgressInfo.setBytesSent(selectObject.offset);
                    this.mProgressInfo.setBytesReceived(selectObject.offset);
                    if (i4 != selectObject.maxSize || selectObject.offset >= this.mImageSizeInBytes) {
                        z = true;
                    } else {
                        logi("Executing data object (Op Code = 4)");
                        writeExecute();
                        this.mService.sendLogBroadcast(10, "Data object executed");
                    }
                } else {
                    logi(selectObject.offset + " bytes sent before, CRC does not match");
                    this.mService.sendLogBroadcast(15, selectObject.offset + " bytes sent before, CRC does not match");
                    this.mProgressInfo.setBytesSent(i9);
                    this.mProgressInfo.setBytesReceived(i9);
                    selectObject.offset = selectObject.offset - i4;
                    selectObject.CRC32 = 0;
                    this.mFirmwareStream.reset();
                    logi("Resuming from byte " + selectObject.offset + "...");
                    this.mService.sendLogBroadcast(10, "Resuming from byte " + selectObject.offset + "...");
                }
                z = false;
            } catch (Exception e) {
                loge("Error while reading firmware stream", e);
                this.mService.terminateConnection(bluetoothGatt2, DfuBaseService.ERROR_FILE_IO_EXCEPTION);
                return;
            }
        } else {
            str = ")";
            this.mProgressInfo.setBytesSent(0);
            z = false;
            i = 0;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() + 400;
        if (selectObject.offset < this.mImageSizeInBytes) {
            int i10 = 1;
            while (this.mProgressInfo.getAvailableObjectSizeIsBytes() > 0) {
                if (!z) {
                    int availableObjectSizeIsBytes = this.mProgressInfo.getAvailableObjectSizeIsBytes();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Creating Data object (Op Code = 1, Type = 2, Size = ");
                    sb.append(availableObjectSizeIsBytes);
                    sb.append(") (");
                    int i11 = i + 1;
                    sb.append(i11);
                    sb.append("/");
                    sb.append(i5);
                    boolean z4 = z;
                    sb.append(str);
                    logi(sb.toString());
                    writeCreateRequest(2, availableObjectSizeIsBytes);
                    this.mService.sendLogBroadcast(10, "Data object (" + i11 + "/" + i5 + ") created");
                    if (i == 0) {
                        this.mService.waitFor(400);
                    }
                    this.mService.sendLogBroadcast(10, "Uploading firmware...");
                    z2 = z4;
                } else {
                    this.mService.sendLogBroadcast(10, "Resuming uploading firmware...");
                    z2 = false;
                }
                try {
                    logi("Uploading firmware...");
                    uploadFirmwareImage(this.mPacketCharacteristic);
                    logi("Sending Calculate Checksum command (Op Code = 3)");
                    ObjectChecksum readChecksum = readChecksum();
                    Locale locale2 = Locale.US;
                    logi(String.format(locale2, "Checksum received (Offset = %d, CRC = %08X)", new Object[]{Integer.valueOf(readChecksum.offset), Integer.valueOf(readChecksum.CRC32)}));
                    boolean z5 = z2;
                    this.mService.sendLogBroadcast(10, String.format(locale2, "Checksum received (Offset = %d, CRC = %08X)", new Object[]{Integer.valueOf(readChecksum.offset), Integer.valueOf(readChecksum.CRC32)}));
                    int bytesSent = this.mProgressInfo.getBytesSent() - readChecksum.offset;
                    if (bytesSent > 0) {
                        logw(bytesSent + " bytes were lost!");
                        this.mService.sendLogBroadcast(15, bytesSent + " bytes were lost");
                        try {
                            int i12 = selectObject.maxSize - bytesSent;
                            logi("loseSize:" + i12);
                            if (i12 > 0) {
                                this.mFirmwareStream.reset();
                                this.mFirmwareStream.read(new byte[(selectObject.maxSize - bytesSent)]);
                                this.mProgressInfo.setBytesSent(readChecksum.offset);
                            } else {
                                this.mService.terminateConnection(bluetoothGatt2, DfuBaseService.ERROR_FILE_IO_EXCEPTION);
                                this.mService.report(8712);
                            }
                            int i13 = this.mPacketsBeforeNotification;
                            if (i13 == 0 || i13 > 1) {
                                this.mPacketsBeforeNotification = 1;
                                setPacketReceiptNotifications(1);
                                this.mService.sendLogBroadcast(10, "Packet Receipt Notif Req (Op Code = 2) sent (Value = 1)");
                            }
                        } catch (Exception e2) {
                            loge("Error while reading firmware stream", e2);
                            this.mService.terminateConnection(bluetoothGatt2, DfuBaseService.ERROR_FILE_IO_EXCEPTION);
                            this.mService.report(8712);
                            return;
                        }
                    }
                    int crc32 = (int) (((ArchiveInputStream) this.mFirmwareStream).getCrc32() & 4294967295L);
                    if (crc32 != readChecksum.CRC32) {
                        String format = String.format(locale2, "CRC does not match! Expected %08X but found %08X.", new Object[]{Integer.valueOf(crc32), Integer.valueOf(readChecksum.CRC32)});
                        if (i10 < 3) {
                            i10++;
                            String str2 = format + String.format(locale2, " Retrying...(%d/%d)", new Object[]{Integer.valueOf(i10), 3});
                            logi(str2);
                            this.mService.sendLogBroadcast(15, str2);
                            try {
                                this.mFirmwareStream.reset();
                                this.mProgressInfo.setBytesSent(((ArchiveInputStream) this.mFirmwareStream).getBytesRead());
                                z3 = z5;
                            } catch (IOException e3) {
                                loge("Error while resetting the firmware stream", e3);
                                this.mService.terminateConnection(bluetoothGatt2, DfuBaseService.ERROR_FILE_IO_EXCEPTION);
                                return;
                            }
                        } else {
                            loge(format);
                            this.mService.sendLogBroadcast(20, format);
                            this.mService.terminateConnection(bluetoothGatt2, DfuBaseService.ERROR_CRC_ERROR);
                            return;
                        }
                    } else if (bytesSent > 0) {
                        z3 = true;
                    } else {
                        logi("Executing data object (Op Code = 4)");
                        writeExecute(this.mProgressInfo.isComplete());
                        this.mService.sendLogBroadcast(10, "Data object executed");
                        i++;
                        this.mFirmwareStream.mark(0);
                        i10 = 1;
                        z3 = z5;
                    }
                } catch (DeviceDisconnectedException e4) {
                    loge("Disconnected while sending data");
                    throw e4;
                }
            }
        } else {
            logi("Executing data object (Op Code = 4)");
            writeExecute(true);
            this.mService.sendLogBroadcast(10, "Data object executed");
        }
        long elapsedRealtime2 = SystemClock.elapsedRealtime();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Transfer of ");
        sb2.append(this.mProgressInfo.getBytesSent() - selectObject.offset);
        sb2.append(" bytes has taken ");
        long j = elapsedRealtime2 - elapsedRealtime;
        sb2.append(j);
        sb2.append(" ms");
        logi(sb2.toString());
        this.mService.sendLogBroadcast(10, "Upload completed in " + j + " ms");
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x010b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void sendInitPacket(@androidx.annotation.NonNull android.bluetooth.BluetoothGatt r19, boolean r20) throws no.nordicsemi.android.dfu.internal.exception.RemoteDfuException, no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException, no.nordicsemi.android.dfu.internal.exception.DfuException, no.nordicsemi.android.dfu.internal.exception.UploadAbortedException, no.nordicsemi.android.dfu.internal.exception.UnknownResponseException {
        /*
            r18 = this;
            r1 = r18
            r2 = r19
            java.util.zip.CRC32 r3 = new java.util.zip.CRC32
            r3.<init>()
            java.lang.String r0 = "Setting object to Command (Op Code = 6, Type = 1)"
            r1.logi(r0)
            r4 = 1
            no.nordicsemi.android.dfu.SecureDfuImpl$ObjectInfo r5 = r1.selectObject(r4)
            java.util.Locale r0 = java.util.Locale.US
            int r6 = r5.maxSize
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            int r7 = r5.offset
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            int r8 = r5.CRC32
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            java.lang.Object[] r6 = new java.lang.Object[]{r6, r7, r8}
            java.lang.String r7 = "Command object info received (Max size = %d, Offset = %d, CRC = %08X)"
            java.lang.String r6 = java.lang.String.format(r0, r7, r6)
            r1.logi(r6)
            no.nordicsemi.android.dfu.DfuBaseService r6 = r1.mService
            int r8 = r5.maxSize
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            int r9 = r5.offset
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            int r10 = r5.CRC32
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            java.lang.Object[] r8 = new java.lang.Object[]{r8, r9, r10}
            java.lang.String r0 = java.lang.String.format(r0, r7, r8)
            r7 = 10
            r6.sendLogBroadcast(r7, r0)
            int r0 = r1.mInitPacketSizeInBytes
            r6 = 4100(0x1004, float:5.745E-42)
            java.lang.String r8 = "Error while resetting the init packet stream"
            r9 = 4294967295(0xffffffff, double:2.1219957905E-314)
            r11 = 0
            if (r20 == 0) goto L_0x0107
            int r12 = r5.offset
            if (r12 <= 0) goto L_0x0107
            if (r12 > r0) goto L_0x0107
            byte[] r0 = new byte[r12]     // Catch:{ IOException -> 0x009d }
            java.io.InputStream r12 = r1.mInitPacketStream     // Catch:{ IOException -> 0x009d }
            r12.read(r0)     // Catch:{ IOException -> 0x009d }
            r3.update(r0)     // Catch:{ IOException -> 0x009d }
            long r12 = r3.getValue()     // Catch:{ IOException -> 0x009d }
            long r12 = r12 & r9
            int r0 = (int) r12     // Catch:{ IOException -> 0x009d }
            int r12 = r5.CRC32     // Catch:{ IOException -> 0x009d }
            if (r12 != r0) goto L_0x00cc
            java.lang.String r0 = "Init packet CRC is the same"
            r1.logi(r0)     // Catch:{ IOException -> 0x009d }
            int r0 = r5.offset     // Catch:{ IOException -> 0x009d }
            int r12 = r1.mInitPacketSizeInBytes     // Catch:{ IOException -> 0x009d }
            if (r0 != r12) goto L_0x00a2
            java.lang.String r0 = "-> Whole Init packet was sent before"
            r1.logi(r0)     // Catch:{ IOException -> 0x009d }
            no.nordicsemi.android.dfu.DfuBaseService r0 = r1.mService     // Catch:{ IOException -> 0x0098 }
            java.lang.String r12 = "Received CRC match Init packet"
            r0.sendLogBroadcast(r7, r12)     // Catch:{ IOException -> 0x0098 }
            r0 = r4
            r12 = r11
            goto L_0x0109
        L_0x0098:
            r0 = move-exception
            r13 = r0
            r0 = r4
            r12 = r11
            goto L_0x00d7
        L_0x009d:
            r0 = move-exception
            r13 = r0
            r0 = r11
            r12 = r0
            goto L_0x00d7
        L_0x00a2:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x009d }
            r0.<init>()     // Catch:{ IOException -> 0x009d }
            java.lang.String r12 = "-> "
            r0.append(r12)     // Catch:{ IOException -> 0x009d }
            int r12 = r5.offset     // Catch:{ IOException -> 0x009d }
            r0.append(r12)     // Catch:{ IOException -> 0x009d }
            java.lang.String r12 = " bytes of Init packet were sent before"
            r0.append(r12)     // Catch:{ IOException -> 0x009d }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x009d }
            r1.logi(r0)     // Catch:{ IOException -> 0x009d }
            no.nordicsemi.android.dfu.DfuBaseService r0 = r1.mService     // Catch:{ IOException -> 0x00c7 }
            java.lang.String r12 = "Resuming sending Init packet..."
            r0.sendLogBroadcast(r7, r12)     // Catch:{ IOException -> 0x00c7 }
            r12 = r4
            r0 = r11
            goto L_0x0109
        L_0x00c7:
            r0 = move-exception
            r13 = r0
            r12 = r4
            r0 = r11
            goto L_0x00d7
        L_0x00cc:
            java.io.InputStream r0 = r1.mInitPacketStream     // Catch:{ IOException -> 0x009d }
            r0.reset()     // Catch:{ IOException -> 0x009d }
            r3.reset()     // Catch:{ IOException -> 0x009d }
            r5.offset = r11     // Catch:{ IOException -> 0x009d }
            goto L_0x0107
        L_0x00d7:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = "Error while reading "
            r14.append(r15)
            int r15 = r5.offset
            r14.append(r15)
            java.lang.String r15 = " bytes from the init packet stream"
            r14.append(r15)
            java.lang.String r14 = r14.toString()
            r1.loge(r14, r13)
            java.io.InputStream r13 = r1.mInitPacketStream     // Catch:{ IOException -> 0x00fd }
            r13.reset()     // Catch:{ IOException -> 0x00fd }
            r3.reset()     // Catch:{ IOException -> 0x00fd }
            r5.offset = r11     // Catch:{ IOException -> 0x00fd }
            goto L_0x0109
        L_0x00fd:
            r0 = move-exception
            r1.loge(r8, r0)
            no.nordicsemi.android.dfu.DfuBaseService r0 = r1.mService
            r0.terminateConnection(r2, r6)
            return
        L_0x0107:
            r0 = r11
            r12 = r0
        L_0x0109:
            if (r0 != 0) goto L_0x0240
            r1.setPacketReceiptNotifications(r11)
            no.nordicsemi.android.dfu.DfuBaseService r0 = r1.mService
            java.lang.String r13 = "Packet Receipt Notif disabled (Op Code = 2, Value = 0)"
            r0.sendLogBroadcast(r7, r13)
            r0 = r4
        L_0x0116:
            r13 = 3
            if (r0 > r13) goto L_0x0240
            java.lang.String r14 = ")"
            if (r12 != 0) goto L_0x0142
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r15 = "Creating Init packet object (Op Code = 1, Type = 1, Size = "
            r12.append(r15)
            int r15 = r1.mInitPacketSizeInBytes
            r12.append(r15)
            r12.append(r14)
            java.lang.String r12 = r12.toString()
            r1.logi(r12)
            int r12 = r1.mInitPacketSizeInBytes
            r1.writeCreateRequest(r4, r12)
            no.nordicsemi.android.dfu.DfuBaseService r12 = r1.mService
            java.lang.String r15 = "Command object created"
            r12.sendLogBroadcast(r7, r15)
        L_0x0142:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ DeviceDisconnectedException -> 0x0239 }
            r12.<init>()     // Catch:{ DeviceDisconnectedException -> 0x0239 }
            java.lang.String r15 = "Sending "
            r12.append(r15)     // Catch:{ DeviceDisconnectedException -> 0x0239 }
            int r15 = r1.mInitPacketSizeInBytes     // Catch:{ DeviceDisconnectedException -> 0x0239 }
            int r4 = r5.offset     // Catch:{ DeviceDisconnectedException -> 0x0239 }
            int r15 = r15 - r4
            r12.append(r15)     // Catch:{ DeviceDisconnectedException -> 0x0239 }
            java.lang.String r4 = " bytes of init packet..."
            r12.append(r4)     // Catch:{ DeviceDisconnectedException -> 0x0239 }
            java.lang.String r4 = r12.toString()     // Catch:{ DeviceDisconnectedException -> 0x0239 }
            r1.logi(r4)     // Catch:{ DeviceDisconnectedException -> 0x0239 }
            android.bluetooth.BluetoothGattCharacteristic r4 = r1.mPacketCharacteristic     // Catch:{ DeviceDisconnectedException -> 0x0239 }
            r1.writeInitData(r4, r3)     // Catch:{ DeviceDisconnectedException -> 0x0239 }
            long r16 = r3.getValue()
            long r11 = r16 & r9
            int r11 = (int) r11
            no.nordicsemi.android.dfu.DfuBaseService r12 = r1.mService
            java.util.Locale r15 = java.util.Locale.US
            java.lang.Integer r16 = java.lang.Integer.valueOf(r11)
            java.lang.Object[] r4 = new java.lang.Object[]{r16}
            java.lang.String r9 = "Command object sent (CRC = %08X)"
            java.lang.String r4 = java.lang.String.format(r15, r9, r4)
            r12.sendLogBroadcast(r7, r4)
            java.lang.String r4 = "Sending Calculate Checksum command (Op Code = 3)"
            r1.logi(r4)
            no.nordicsemi.android.dfu.SecureDfuImpl$ObjectChecksum r4 = r18.readChecksum()
            no.nordicsemi.android.dfu.DfuBaseService r9 = r1.mService
            int r10 = r4.offset
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            int r12 = r4.CRC32
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            java.lang.Object[] r10 = new java.lang.Object[]{r10, r12}
            java.lang.String r12 = "Checksum received (Offset = %d, CRC = %08X)"
            java.lang.String r10 = java.lang.String.format(r15, r12, r10)
            r9.sendLogBroadcast(r7, r10)
            int r9 = r4.offset
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            int r10 = r4.CRC32
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            java.lang.Object[] r9 = new java.lang.Object[]{r9, r10}
            java.lang.String r9 = java.lang.String.format(r15, r12, r9)
            r1.logi(r9)
            int r4 = r4.CRC32
            if (r11 != r4) goto L_0x01c2
            goto L_0x0240
        L_0x01c2:
            if (r0 >= r13) goto L_0x0225
            int r0 = r0 + 1
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r9 = "CRC does not match! Retrying...("
            r4.append(r9)
            r4.append(r0)
            java.lang.String r10 = "/"
            r4.append(r10)
            r4.append(r13)
            r4.append(r14)
            java.lang.String r4 = r4.toString()
            r1.logi(r4)
            no.nordicsemi.android.dfu.DfuBaseService r4 = r1.mService
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r9)
            r11.append(r0)
            r11.append(r10)
            r11.append(r13)
            r11.append(r14)
            java.lang.String r9 = r11.toString()
            r10 = 15
            r4.sendLogBroadcast(r10, r9)
            r4 = 0
            r5.offset = r4     // Catch:{ IOException -> 0x021b }
            r5.CRC32 = r4     // Catch:{ IOException -> 0x021b }
            java.io.InputStream r9 = r1.mInitPacketStream     // Catch:{ IOException -> 0x021b }
            r9.reset()     // Catch:{ IOException -> 0x021b }
            r3.reset()     // Catch:{ IOException -> 0x021b }
            r11 = r4
            r12 = r11
            r4 = 1
            r9 = 4294967295(0xffffffff, double:2.1219957905E-314)
            goto L_0x0116
        L_0x021b:
            r0 = move-exception
            r1.loge(r8, r0)
            no.nordicsemi.android.dfu.DfuBaseService r0 = r1.mService
            r0.terminateConnection(r2, r6)
            return
        L_0x0225:
            java.lang.String r0 = "CRC does not match!"
            r1.loge(r0)
            no.nordicsemi.android.dfu.DfuBaseService r3 = r1.mService
            r4 = 20
            r3.sendLogBroadcast(r4, r0)
            no.nordicsemi.android.dfu.DfuBaseService r0 = r1.mService
            r1 = 4109(0x100d, float:5.758E-42)
            r0.terminateConnection(r2, r1)
            return
        L_0x0239:
            r0 = move-exception
            java.lang.String r2 = "Disconnected while sending init packet"
            r1.loge(r2)
            throw r0
        L_0x0240:
            java.lang.String r0 = "Executing init packet (Op Code = 4)"
            r1.logi(r0)
            r18.writeExecute()
            no.nordicsemi.android.dfu.DfuBaseService r0 = r1.mService
            java.lang.String r1 = "Command object executed"
            r0.sendLogBroadcast(r7, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.SecureDfuImpl.sendInitPacket(android.bluetooth.BluetoothGatt, boolean):void");
    }

    private void setNumberOfPackets(@NonNull byte[] bArr, int i) {
        bArr[1] = (byte) (i & 255);
        bArr[2] = (byte) ((i >> 8) & 255);
    }

    private void setObjectSize(@NonNull byte[] bArr, int i) {
        bArr[2] = (byte) (i & 255);
        bArr[3] = (byte) ((i >> 8) & 255);
        bArr[4] = (byte) ((i >> 16) & 255);
        bArr[5] = (byte) ((i >> 24) & 255);
    }

    private void setPacketReceiptNotifications(int i) throws DfuException, DeviceDisconnectedException, UploadAbortedException, UnknownResponseException, RemoteDfuException {
        if (this.mConnected) {
            logi("Sending the number of packets before notifications (Op Code = 2, Value = " + i + ")");
            byte[] bArr = OP_CODE_PACKET_RECEIPT_NOTIF_REQ;
            setNumberOfPackets(bArr, i);
            writeOpCode(this.mControlPointCharacteristic, bArr);
            byte[] readNotificationResponse = readNotificationResponse();
            int statusCode = getStatusCode(readNotificationResponse, 2);
            if (statusCode == 11) {
                throw new RemoteDfuExtendedErrorException("Sending the number of packets failed", readNotificationResponse[3]);
            } else if (statusCode != 1) {
                throw new RemoteDfuException("Sending the number of packets failed", statusCode);
            }
        } else {
            throw new DeviceDisconnectedException("Unable to read Checksum: device disconnected");
        }
    }

    private int unsignedBytesToInt(@NonNull byte[] bArr, int i) {
        return (bArr[i] & 255) + ((bArr[i + 1] & 255) << 8) + ((bArr[i + 2] & 255) << 16) + ((bArr[i + 3] & 255) << 24);
    }

    private void writeCreateRequest(int i, int i2) throws DeviceDisconnectedException, DfuException, UploadAbortedException, RemoteDfuException, UnknownResponseException {
        if (this.mConnected) {
            byte[] bArr = i == 1 ? OP_CODE_CREATE_COMMAND : OP_CODE_CREATE_DATA;
            setObjectSize(bArr, i2);
            writeOpCode(this.mControlPointCharacteristic, bArr);
            byte[] readNotificationResponse = readNotificationResponse();
            int statusCode = getStatusCode(readNotificationResponse, 1);
            if (statusCode == 11) {
                throw new RemoteDfuExtendedErrorException("Creating Command object failed", readNotificationResponse[3]);
            } else if (statusCode != 1) {
                throw new RemoteDfuException("Creating Command object failed", statusCode);
            }
        } else {
            throw new DeviceDisconnectedException("Unable to create object: device disconnected");
        }
    }

    private void writeExecute() throws DfuException, DeviceDisconnectedException, UploadAbortedException, UnknownResponseException, RemoteDfuException {
        if (this.mConnected) {
            writeOpCode(this.mControlPointCharacteristic, OP_CODE_EXECUTE);
            byte[] readNotificationResponse = readNotificationResponse();
            int statusCode = getStatusCode(readNotificationResponse, 4);
            loge("writeExecute status:" + statusCode);
            if (statusCode == 11) {
                throw new RemoteDfuExtendedErrorException("Executing object failed", readNotificationResponse[3]);
            } else if (statusCode != 1) {
                throw new RemoteDfuException("Executing object failed", statusCode);
            }
        } else {
            throw new DeviceDisconnectedException("Unable to read Checksum: device disconnected");
        }
    }

    private void writeOpCode(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, @NonNull byte[] bArr) throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        writeOpCode(bluetoothGattCharacteristic, bArr, false);
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

    public boolean initialize(@NonNull Intent intent, @NonNull BluetoothGatt bluetoothGatt, @FileType int i, @NonNull InputStream inputStream, @Nullable InputStream inputStream2) throws DfuException, DeviceDisconnectedException, UploadAbortedException {
        if (inputStream2 != null) {
            return super.initialize(intent, bluetoothGatt, i, inputStream, inputStream2);
        }
        this.mService.sendLogBroadcast(20, "The Init packet is required by this version DFU Bootloader");
        this.mService.terminateConnection(bluetoothGatt, DfuBaseService.ERROR_INIT_PACKET_REQUIRED);
        return false;
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

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0063, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0066, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0169, code lost:
        loge(r10.getMessage());
        r9.mService.sendLogBroadcast(20, r10.getMessage());
        r9.mService.terminateConnection(r1, no.nordicsemi.android.dfu.DfuBaseService.ERROR_INVALID_RESPONSE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0181, code lost:
        throw r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0063 A[Catch:{ RemoteDfuException -> 0x0074, UploadAbortedException -> 0x0066, UnknownResponseException -> 0x0063, UploadAbortedException -> 0x0066, UnknownResponseException -> 0x0063, RemoteDfuException -> 0x0061 }, ExcHandler: UnknownResponseException (r10v1 'e' no.nordicsemi.android.dfu.internal.exception.UnknownResponseException A[CUSTOM_DECLARE, Catch:{  }]), Splitter:B:4:0x003d] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0066 A[Catch:{ RemoteDfuException -> 0x0074, UploadAbortedException -> 0x0066, UnknownResponseException -> 0x0063, UploadAbortedException -> 0x0066, UnknownResponseException -> 0x0063, RemoteDfuException -> 0x0061 }, ExcHandler: UploadAbortedException (r9v1 'e' no.nordicsemi.android.dfu.internal.exception.UploadAbortedException A[CUSTOM_DECLARE, Catch:{  }]), Splitter:B:4:0x003d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void performDfu(@androidx.annotation.NonNull android.content.Intent r10) throws no.nordicsemi.android.dfu.internal.exception.DfuException, no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException, no.nordicsemi.android.dfu.internal.exception.UploadAbortedException {
        /*
            r9 = this;
            java.lang.String r0 = "no.nordicsemi.android.dfu.extra.EXTRA_DISABLE_RESUME"
            java.lang.String r1 = "Secure DFU bootloader found"
            r9.logw(r1)
            no.nordicsemi.android.dfu.DfuProgressInfo r1 = r9.mProgressInfo
            r2 = -2
            r1.setProgress(r2)
            no.nordicsemi.android.dfu.DfuBaseService r1 = r9.mService
            r2 = 1000(0x3e8, double:4.94E-321)
            r1.waitFor(r2)
            android.bluetooth.BluetoothGatt r1 = r9.mGatt
            java.lang.String r4 = "no.nordicsemi.android.dfu.extra.EXTRA_MTU"
            boolean r5 = r10.hasExtra(r4)
            if (r5 == 0) goto L_0x003b
            r5 = 517(0x205, float:7.24E-43)
            int r4 = r10.getIntExtra(r4, r5)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Requesting MTU = "
            r5.append(r6)
            r5.append(r4)
            java.lang.String r5 = r5.toString()
            r9.logi(r5)
            r9.requestMtu(r4)
        L_0x003b:
            r4 = 20
            android.bluetooth.BluetoothGattCharacteristic r5 = r9.mControlPointCharacteristic     // Catch:{ UploadAbortedException -> 0x0066, UnknownResponseException -> 0x0063, RemoteDfuException -> 0x0061 }
            r6 = 1
            r9.enableCCCD(r5, r6)     // Catch:{ UploadAbortedException -> 0x0066, UnknownResponseException -> 0x0063, RemoteDfuException -> 0x0061 }
            no.nordicsemi.android.dfu.DfuBaseService r5 = r9.mService     // Catch:{ UploadAbortedException -> 0x0066, UnknownResponseException -> 0x0063, RemoteDfuException -> 0x0061 }
            java.lang.String r7 = "Notifications enabled"
            r8 = 10
            r5.sendLogBroadcast(r8, r7)     // Catch:{ UploadAbortedException -> 0x0066, UnknownResponseException -> 0x0063, RemoteDfuException -> 0x0061 }
            no.nordicsemi.android.dfu.DfuBaseService r5 = r9.mService     // Catch:{ UploadAbortedException -> 0x0066, UnknownResponseException -> 0x0063, RemoteDfuException -> 0x0061 }
            r5.waitFor(r2)     // Catch:{ UploadAbortedException -> 0x0066, UnknownResponseException -> 0x0063, RemoteDfuException -> 0x0061 }
            boolean r2 = r10.hasExtra(r0)     // Catch:{ UploadAbortedException -> 0x0066, UnknownResponseException -> 0x0063, RemoteDfuException -> 0x0061 }
            r3 = 0
            if (r2 == 0) goto L_0x0069
            boolean r0 = r10.getBooleanExtra(r0, r3)     // Catch:{ UploadAbortedException -> 0x0066, UnknownResponseException -> 0x0063, RemoteDfuException -> 0x0061 }
            if (r0 != 0) goto L_0x005f
            goto L_0x0069
        L_0x005f:
            r6 = r3
            goto L_0x0069
        L_0x0061:
            r10 = move-exception
            goto L_0x00d0
        L_0x0063:
            r10 = move-exception
            goto L_0x0169
        L_0x0066:
            r9 = move-exception
            goto L_0x0181
        L_0x0069:
            if (r6 != 0) goto L_0x0070
            java.lang.String r0 = "Resume feature disabled. Performing fresh DFU"
            r9.logi(r0)     // Catch:{ UploadAbortedException -> 0x0066, UnknownResponseException -> 0x0063, RemoteDfuException -> 0x0061 }
        L_0x0070:
            r9.sendInitPacket(r1, r6)     // Catch:{ RemoteDfuException -> 0x0074, UploadAbortedException -> 0x0066, UnknownResponseException -> 0x0063 }
            goto L_0x00b4
        L_0x0074:
            r0 = move-exception
            no.nordicsemi.android.dfu.DfuProgressInfo r2 = r9.mProgressInfo     // Catch:{ UploadAbortedException -> 0x0066, UnknownResponseException -> 0x0063, RemoteDfuException -> 0x0061 }
            boolean r2 = r2.isLastPart()     // Catch:{ UploadAbortedException -> 0x0066, UnknownResponseException -> 0x0063, RemoteDfuException -> 0x0061 }
            if (r2 != 0) goto L_0x00cf
            r9.mRemoteErrorOccurred = r3     // Catch:{ UploadAbortedException -> 0x0066, UnknownResponseException -> 0x0063, RemoteDfuException -> 0x0061 }
            java.lang.String r0 = "Sending SD+BL failed. Trying to send App only"
            r9.logw(r0)     // Catch:{ UploadAbortedException -> 0x0066, UnknownResponseException -> 0x0063, RemoteDfuException -> 0x0061 }
            no.nordicsemi.android.dfu.DfuBaseService r0 = r9.mService     // Catch:{ UploadAbortedException -> 0x0066, UnknownResponseException -> 0x0063, RemoteDfuException -> 0x0061 }
            java.lang.String r2 = "Invalid system components. Trying to send application"
            r5 = 15
            r0.sendLogBroadcast(r5, r2)     // Catch:{ UploadAbortedException -> 0x0066, UnknownResponseException -> 0x0063, RemoteDfuException -> 0x0061 }
            r0 = 4
            r9.mFileType = r0     // Catch:{ UploadAbortedException -> 0x0066, UnknownResponseException -> 0x0063, RemoteDfuException -> 0x0061 }
            java.io.InputStream r2 = r9.mFirmwareStream     // Catch:{ UploadAbortedException -> 0x0066, UnknownResponseException -> 0x0063, RemoteDfuException -> 0x0061 }
            no.nordicsemi.android.dfu.internal.ArchiveInputStream r2 = (no.nordicsemi.android.dfu.internal.ArchiveInputStream) r2     // Catch:{ UploadAbortedException -> 0x0066, UnknownResponseException -> 0x0063, RemoteDfuException -> 0x0061 }
            r2.setContentType(r0)     // Catch:{ UploadAbortedException -> 0x0066, UnknownResponseException -> 0x0063, RemoteDfuException -> 0x0061 }
            byte[] r0 = r2.getApplicationInit()     // Catch:{ UploadAbortedException -> 0x0066, UnknownResponseException -> 0x0063, RemoteDfuException -> 0x0061 }
            java.io.ByteArrayInputStream r5 = new java.io.ByteArrayInputStream     // Catch:{ UploadAbortedException -> 0x0066, UnknownResponseException -> 0x0063, RemoteDfuException -> 0x0061 }
            r5.<init>(r0)     // Catch:{ UploadAbortedException -> 0x0066, UnknownResponseException -> 0x0063, RemoteDfuException -> 0x0061 }
            r9.mInitPacketStream = r5     // Catch:{ UploadAbortedException -> 0x0066, UnknownResponseException -> 0x0063, RemoteDfuException -> 0x0061 }
            int r0 = r0.length     // Catch:{ UploadAbortedException -> 0x0066, UnknownResponseException -> 0x0063, RemoteDfuException -> 0x0061 }
            r9.mInitPacketSizeInBytes = r0     // Catch:{ UploadAbortedException -> 0x0066, UnknownResponseException -> 0x0063, RemoteDfuException -> 0x0061 }
            int r0 = r2.applicationImageSize()     // Catch:{ UploadAbortedException -> 0x0066, UnknownResponseException -> 0x0063, RemoteDfuException -> 0x0061 }
            r9.mImageSizeInBytes = r0     // Catch:{ UploadAbortedException -> 0x0066, UnknownResponseException -> 0x0063, RemoteDfuException -> 0x0061 }
            no.nordicsemi.android.dfu.DfuProgressInfo r2 = r9.mProgressInfo     // Catch:{ UploadAbortedException -> 0x0066, UnknownResponseException -> 0x0063, RemoteDfuException -> 0x0061 }
            r5 = 2
            r2.init(r0, r5, r5)     // Catch:{ UploadAbortedException -> 0x0066, UnknownResponseException -> 0x0063, RemoteDfuException -> 0x0061 }
            r9.sendInitPacket(r1, r3)     // Catch:{ UploadAbortedException -> 0x0066, UnknownResponseException -> 0x0063, RemoteDfuException -> 0x0061 }
        L_0x00b4:
            r9.sendFirmware(r1)     // Catch:{ UploadAbortedException -> 0x0066, UnknownResponseException -> 0x0063, RemoteDfuException -> 0x0061 }
            no.nordicsemi.android.dfu.DfuProgressInfo r0 = r9.mProgressInfo     // Catch:{ UploadAbortedException -> 0x0066, UnknownResponseException -> 0x0063, RemoteDfuException -> 0x0061 }
            r2 = -5
            r0.setProgress(r2)     // Catch:{ UploadAbortedException -> 0x0066, UnknownResponseException -> 0x0063, RemoteDfuException -> 0x0061 }
            no.nordicsemi.android.dfu.DfuBaseService r0 = r9.mService     // Catch:{ UploadAbortedException -> 0x0066, UnknownResponseException -> 0x0063, RemoteDfuException -> 0x0061 }
            r0.waitUntilDisconnected()     // Catch:{ UploadAbortedException -> 0x0066, UnknownResponseException -> 0x0063, RemoteDfuException -> 0x0061 }
            no.nordicsemi.android.dfu.DfuBaseService r0 = r9.mService     // Catch:{ UploadAbortedException -> 0x0066, UnknownResponseException -> 0x0063, RemoteDfuException -> 0x0061 }
            java.lang.String r2 = "Disconnected by the remote device"
            r5 = 5
            r0.sendLogBroadcast(r5, r2)     // Catch:{ UploadAbortedException -> 0x0066, UnknownResponseException -> 0x0063, RemoteDfuException -> 0x0061 }
            r9.finalize(r10, r3)     // Catch:{ UploadAbortedException -> 0x0066, UnknownResponseException -> 0x0063, RemoteDfuException -> 0x0061 }
            goto L_0x0180
        L_0x00cf:
            throw r0     // Catch:{ UploadAbortedException -> 0x0066, UnknownResponseException -> 0x0063, RemoteDfuException -> 0x0061 }
        L_0x00d0:
            int r0 = r10.getErrorNumber()
            r2 = r0 | 512(0x200, float:7.175E-43)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = r10.getMessage()
            r3.append(r5)
            java.lang.String r5 = ": "
            r3.append(r5)
            java.lang.String r5 = no.nordicsemi.android.error.SecureDfuError.parse(r2)
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            r9.loge(r3)
            no.nordicsemi.android.dfu.DfuBaseService r3 = r9.mService
            java.util.Locale r5 = java.util.Locale.US
            java.lang.String r2 = no.nordicsemi.android.error.SecureDfuError.parse(r2)
            java.lang.Object[] r2 = new java.lang.Object[]{r2}
            java.lang.String r6 = "Remote DFU error: %s"
            java.lang.String r2 = java.lang.String.format(r5, r6, r2)
            r3.sendLogBroadcast(r4, r2)
            boolean r2 = r10 instanceof no.nordicsemi.android.dfu.internal.exception.RemoteDfuExtendedErrorException
            if (r2 == 0) goto L_0x0161
            no.nordicsemi.android.dfu.internal.exception.RemoteDfuExtendedErrorException r10 = (no.nordicsemi.android.dfu.internal.exception.RemoteDfuExtendedErrorException) r10
            int r0 = r10.getExtendedErrorNumber()
            r2 = r0 | 1024(0x400, float:1.435E-42)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "Extended Error details: "
            r3.append(r5)
            java.lang.String r5 = no.nordicsemi.android.error.SecureDfuError.parseExtendedError(r2)
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            r9.loge(r3)
            no.nordicsemi.android.dfu.DfuBaseService r3 = r9.mService
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Details: "
            r5.append(r6)
            java.lang.String r2 = no.nordicsemi.android.error.SecureDfuError.parseExtendedError(r2)
            r5.append(r2)
            java.lang.String r2 = " (Code = "
            r5.append(r2)
            int r10 = r10.getExtendedErrorNumber()
            r5.append(r10)
            java.lang.String r10 = ")"
            r5.append(r10)
            java.lang.String r10 = r5.toString()
            r3.sendLogBroadcast(r4, r10)
            no.nordicsemi.android.dfu.DfuBaseService r9 = r9.mService
            r10 = r0 | 9216(0x2400, float:1.2914E-41)
            r9.terminateConnection(r1, r10)
            goto L_0x0180
        L_0x0161:
            no.nordicsemi.android.dfu.DfuBaseService r9 = r9.mService
            r10 = r0 | 8704(0x2200, float:1.2197E-41)
            r9.terminateConnection(r1, r10)
            goto L_0x0180
        L_0x0169:
            java.lang.String r0 = r10.getMessage()
            r9.loge(r0)
            no.nordicsemi.android.dfu.DfuBaseService r0 = r9.mService
            java.lang.String r10 = r10.getMessage()
            r0.sendLogBroadcast(r4, r10)
            no.nordicsemi.android.dfu.DfuBaseService r9 = r9.mService
            r10 = 4104(0x1008, float:5.751E-42)
            r9.terminateConnection(r1, r10)
        L_0x0180:
            return
        L_0x0181:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.SecureDfuImpl.performDfu(android.content.Intent):void");
    }

    public BaseDfuImpl.BaseBluetoothGattCallback getGattCallback() {
        return this.mBluetoothCallback;
    }

    private void writeExecute(boolean z) throws DfuException, DeviceDisconnectedException, UploadAbortedException, UnknownResponseException, RemoteDfuException {
        try {
            writeExecute();
        } catch (RemoteDfuException e) {
            if (!z || e.getErrorNumber() != 5) {
                throw e;
            }
            logw(e.getMessage() + ": " + SecureDfuError.parse(517));
            if (this.mFileType == 1) {
                logw("Are you sure your new SoftDevice is API compatible with the updated one? If not, update the bootloader as well");
            }
            this.mService.sendLogBroadcast(15, String.format(Locale.US, "Remote DFU error: %s. SD busy? Retrying...", new Object[]{SecureDfuError.parse(517)}));
            logi("SD busy? Retrying...");
            logi("Executing data object (Op Code = 4)");
            writeExecute();
        }
    }
}
