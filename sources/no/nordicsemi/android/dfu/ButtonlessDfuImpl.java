package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Intent;
import androidx.annotation.NonNull;
import no.nordicsemi.android.dfu.internal.exception.UnknownResponseException;

abstract class ButtonlessDfuImpl extends BaseButtonlessDfuImpl {
    private static final int DFU_STATUS_SUCCESS = 1;
    private static final byte[] OP_CODE_ENTER_BOOTLOADER = {1};
    private static final int OP_CODE_ENTER_BOOTLOADER_KEY = 1;
    private static final int OP_CODE_RESPONSE_CODE_KEY = 32;

    public ButtonlessDfuImpl(@NonNull Intent intent, @NonNull DfuBaseService dfuBaseService) {
        super(intent, dfuBaseService);
    }

    private int getStatusCode(byte[] bArr, int i) throws UnknownResponseException {
        byte b;
        if (bArr != null && bArr.length >= 3 && bArr[0] == 32 && bArr[1] == i && ((b = bArr[2]) == 1 || b == 2 || b == 4)) {
            return b;
        }
        throw new UnknownResponseException("Invalid response received", bArr, 32, i);
    }

    public abstract BluetoothGattCharacteristic getButtonlessDfuCharacteristic();

    public abstract int getResponseType();

    /* JADX WARNING: Can't wrap try/catch for region: R(2:11|12) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r5 = r12.mReceivedData;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x007d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void performDfu(@androidx.annotation.NonNull android.content.Intent r13) throws no.nordicsemi.android.dfu.internal.exception.DfuException, no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException, no.nordicsemi.android.dfu.internal.exception.UploadAbortedException {
        /*
            r12 = this;
            java.lang.String r0 = ")"
            java.lang.String r1 = ", Status = "
            java.lang.String r2 = "Response received (Op Code = "
            no.nordicsemi.android.dfu.DfuProgressInfo r3 = r12.mProgressInfo
            r4 = -2
            r3.setProgress(r4)
            no.nordicsemi.android.dfu.DfuBaseService r3 = r12.mService
            r4 = 1000(0x3e8, double:4.94E-321)
            r3.waitFor(r4)
            android.bluetooth.BluetoothGatt r3 = r12.mGatt
            no.nordicsemi.android.dfu.DfuBaseService r6 = r12.mService
            r7 = 15
            java.lang.String r8 = "Application with buttonless update found"
            r6.sendLogBroadcast(r7, r8)
            no.nordicsemi.android.dfu.DfuBaseService r6 = r12.mService
            java.lang.String r7 = "Jumping to the DFU Bootloader..."
            r8 = 1
            r6.sendLogBroadcast(r8, r7)
            android.bluetooth.BluetoothGattCharacteristic r6 = r12.getButtonlessDfuCharacteristic()
            int r7 = r12.getResponseType()
            int r9 = r12.getResponseType()
            r12.enableCCCD(r6, r9)
            no.nordicsemi.android.dfu.DfuBaseService r9 = r12.mService
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r11 = 2
            if (r7 != r11) goto L_0x0042
            java.lang.String r7 = "Indications"
            goto L_0x0044
        L_0x0042:
            java.lang.String r7 = "Notifications"
        L_0x0044:
            r10.append(r7)
            java.lang.String r7 = " enabled"
            r10.append(r7)
            java.lang.String r7 = r10.toString()
            r10 = 10
            r9.sendLogBroadcast(r10, r7)
            no.nordicsemi.android.dfu.DfuBaseService r7 = r12.mService
            r7.waitFor(r4)
            r4 = 20
            no.nordicsemi.android.dfu.DfuProgressInfo r5 = r12.mProgressInfo     // Catch:{ UnknownResponseException -> 0x007a, RemoteDfuException -> 0x0078 }
            r7 = -3
            r5.setProgress(r7)     // Catch:{ UnknownResponseException -> 0x007a, RemoteDfuException -> 0x0078 }
            java.lang.String r5 = "Sending Enter Bootloader (Op Code = 1)"
            r12.logi(r5)     // Catch:{ UnknownResponseException -> 0x007a, RemoteDfuException -> 0x0078 }
            byte[] r5 = OP_CODE_ENTER_BOOTLOADER     // Catch:{ UnknownResponseException -> 0x007a, RemoteDfuException -> 0x0078 }
            r12.writeOpCode(r6, r5, r8)     // Catch:{ UnknownResponseException -> 0x007a, RemoteDfuException -> 0x0078 }
            no.nordicsemi.android.dfu.DfuBaseService r5 = r12.mService     // Catch:{ UnknownResponseException -> 0x007a, RemoteDfuException -> 0x0078 }
            java.lang.String r6 = "Enter bootloader sent (Op Code = 1)"
            r5.sendLogBroadcast(r10, r6)     // Catch:{ UnknownResponseException -> 0x007a, RemoteDfuException -> 0x0078 }
            byte[] r5 = r12.readNotificationResponse()     // Catch:{ DeviceDisconnectedException -> 0x007d }
            goto L_0x007f
        L_0x0078:
            r13 = move-exception
            goto L_0x00e7
        L_0x007a:
            r13 = move-exception
            goto L_0x0111
        L_0x007d:
            byte[] r5 = r12.mReceivedData     // Catch:{ UnknownResponseException -> 0x007a, RemoteDfuException -> 0x0078 }
        L_0x007f:
            if (r5 == 0) goto L_0x00d1
            int r6 = r12.getStatusCode(r5, r8)     // Catch:{ UnknownResponseException -> 0x007a, RemoteDfuException -> 0x0078 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ UnknownResponseException -> 0x007a, RemoteDfuException -> 0x0078 }
            r7.<init>()     // Catch:{ UnknownResponseException -> 0x007a, RemoteDfuException -> 0x0078 }
            r7.append(r2)     // Catch:{ UnknownResponseException -> 0x007a, RemoteDfuException -> 0x0078 }
            byte r9 = r5[r8]     // Catch:{ UnknownResponseException -> 0x007a, RemoteDfuException -> 0x0078 }
            r7.append(r9)     // Catch:{ UnknownResponseException -> 0x007a, RemoteDfuException -> 0x0078 }
            r7.append(r1)     // Catch:{ UnknownResponseException -> 0x007a, RemoteDfuException -> 0x0078 }
            r7.append(r6)     // Catch:{ UnknownResponseException -> 0x007a, RemoteDfuException -> 0x0078 }
            r7.append(r0)     // Catch:{ UnknownResponseException -> 0x007a, RemoteDfuException -> 0x0078 }
            java.lang.String r7 = r7.toString()     // Catch:{ UnknownResponseException -> 0x007a, RemoteDfuException -> 0x0078 }
            r12.logi(r7)     // Catch:{ UnknownResponseException -> 0x007a, RemoteDfuException -> 0x0078 }
            no.nordicsemi.android.dfu.DfuBaseService r7 = r12.mService     // Catch:{ UnknownResponseException -> 0x007a, RemoteDfuException -> 0x0078 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ UnknownResponseException -> 0x007a, RemoteDfuException -> 0x0078 }
            r9.<init>()     // Catch:{ UnknownResponseException -> 0x007a, RemoteDfuException -> 0x0078 }
            r9.append(r2)     // Catch:{ UnknownResponseException -> 0x007a, RemoteDfuException -> 0x0078 }
            byte r2 = r5[r8]     // Catch:{ UnknownResponseException -> 0x007a, RemoteDfuException -> 0x0078 }
            r9.append(r2)     // Catch:{ UnknownResponseException -> 0x007a, RemoteDfuException -> 0x0078 }
            r9.append(r1)     // Catch:{ UnknownResponseException -> 0x007a, RemoteDfuException -> 0x0078 }
            r9.append(r6)     // Catch:{ UnknownResponseException -> 0x007a, RemoteDfuException -> 0x0078 }
            r9.append(r0)     // Catch:{ UnknownResponseException -> 0x007a, RemoteDfuException -> 0x0078 }
            java.lang.String r0 = r9.toString()     // Catch:{ UnknownResponseException -> 0x007a, RemoteDfuException -> 0x0078 }
            r7.sendLogBroadcast(r10, r0)     // Catch:{ UnknownResponseException -> 0x007a, RemoteDfuException -> 0x0078 }
            if (r6 != r8) goto L_0x00c9
            no.nordicsemi.android.dfu.DfuBaseService r0 = r12.mService     // Catch:{ UnknownResponseException -> 0x007a, RemoteDfuException -> 0x0078 }
            r0.waitUntilDisconnected()     // Catch:{ UnknownResponseException -> 0x007a, RemoteDfuException -> 0x0078 }
            goto L_0x00d6
        L_0x00c9:
            no.nordicsemi.android.dfu.internal.exception.RemoteDfuException r13 = new no.nordicsemi.android.dfu.internal.exception.RemoteDfuException     // Catch:{ UnknownResponseException -> 0x007a, RemoteDfuException -> 0x0078 }
            java.lang.String r0 = "Device returned error after sending Enter Bootloader"
            r13.<init>(r0, r6)     // Catch:{ UnknownResponseException -> 0x007a, RemoteDfuException -> 0x0078 }
            throw r13     // Catch:{ UnknownResponseException -> 0x007a, RemoteDfuException -> 0x0078 }
        L_0x00d1:
            java.lang.String r0 = "Device disconnected before receiving notification"
            r12.logi(r0)     // Catch:{ UnknownResponseException -> 0x007a, RemoteDfuException -> 0x0078 }
        L_0x00d6:
            no.nordicsemi.android.dfu.DfuBaseService r0 = r12.mService     // Catch:{ UnknownResponseException -> 0x007a, RemoteDfuException -> 0x0078 }
            java.lang.String r1 = "Disconnected by the remote device"
            r2 = 5
            r0.sendLogBroadcast(r2, r1)     // Catch:{ UnknownResponseException -> 0x007a, RemoteDfuException -> 0x0078 }
            boolean r0 = r12.shouldScanForBootloader()     // Catch:{ UnknownResponseException -> 0x007a, RemoteDfuException -> 0x0078 }
            r1 = 0
            r12.finalize(r13, r1, r0)     // Catch:{ UnknownResponseException -> 0x007a, RemoteDfuException -> 0x0078 }
            goto L_0x0128
        L_0x00e7:
            int r0 = r13.getErrorNumber()
            r1 = r0 | 2048(0x800, float:2.87E-42)
            java.lang.String r13 = r13.getMessage()
            r12.loge(r13)
            no.nordicsemi.android.dfu.DfuBaseService r13 = r12.mService
            java.util.Locale r2 = java.util.Locale.US
            java.lang.String r1 = no.nordicsemi.android.error.SecureDfuError.parseButtonlessError(r1)
            java.lang.Object[] r1 = new java.lang.Object[]{r1}
            java.lang.String r5 = "Remote DFU error: %s"
            java.lang.String r1 = java.lang.String.format(r2, r5, r1)
            r13.sendLogBroadcast(r4, r1)
            no.nordicsemi.android.dfu.DfuBaseService r12 = r12.mService
            r13 = r0 | 10240(0x2800, float:1.4349E-41)
            r12.terminateConnection(r3, r13)
            goto L_0x0128
        L_0x0111:
            java.lang.String r0 = r13.getMessage()
            r12.loge(r0)
            no.nordicsemi.android.dfu.DfuBaseService r0 = r12.mService
            java.lang.String r13 = r13.getMessage()
            r0.sendLogBroadcast(r4, r13)
            no.nordicsemi.android.dfu.DfuBaseService r12 = r12.mService
            r13 = 4104(0x1008, float:5.751E-42)
            r12.terminateConnection(r3, r13)
        L_0x0128:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.ButtonlessDfuImpl.performDfu(android.content.Intent):void");
    }

    public abstract boolean shouldScanForBootloader();
}
