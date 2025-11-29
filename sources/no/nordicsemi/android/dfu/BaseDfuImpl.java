package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import android.util.Log;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.UUID;
import no.nordicsemi.android.dfu.DfuCallback;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;
import no.nordicsemi.android.dfu.internal.scanner.BootloaderScannerFactory;
import org.apache.commons.codec.language.Soundex;

abstract class BaseDfuImpl implements DfuService {
    static final UUID CLIENT_CHARACTERISTIC_CONFIG = new UUID(45088566677504L, -9223371485494954757L);
    static final UUID GENERIC_ATTRIBUTE_SERVICE_UUID = new UUID(26392574038016L, -9223371485494954757L);
    /* access modifiers changed from: private */
    public static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
    static final int INDICATIONS = 2;
    private static final int MAX_PACKET_SIZE_DEFAULT = 20;
    static final int NOTIFICATIONS = 1;
    static final UUID SERVICE_CHANGED_UUID = new UUID(46200963207168L, -9223371485494954757L);
    private static final String TAG = "DfuImpl";
    boolean mAborted;
    byte[] mBuffer = new byte[20];
    boolean mConnected;
    /* access modifiers changed from: private */
    public int mCurrentMtu;
    int mError;
    int mFileType;
    InputStream mFirmwareStream;
    BluetoothGatt mGatt;
    int mImageSizeInBytes;
    int mInitPacketSizeInBytes;
    InputStream mInitPacketStream;
    final Object mLock = new Object();
    boolean mPaused;
    DfuProgressInfo mProgressInfo;
    byte[] mReceivedData = null;
    boolean mRequestCompleted;
    boolean mResetRequestSent;
    DfuBaseService mService;

    public class BaseBluetoothGattCallback extends DfuCallback.DfuGattCallback {
        public BaseBluetoothGattCallback() {
        }

        private String phyToString(int i) {
            if (i == 1) {
                return "LE 1M";
            }
            if (i == 2) {
                return "LE 2M";
            }
            if (i == 3) {
                return "LE Coded";
            }
            return "UNKNOWN (" + i + ")";
        }

        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            if (i == 0) {
                DfuBaseService dfuBaseService = BaseDfuImpl.this.mService;
                dfuBaseService.sendLogBroadcast(5, "Read Response received from " + bluetoothGattCharacteristic.getUuid() + ", value (0x): " + parse(bluetoothGattCharacteristic));
                BaseDfuImpl.this.mReceivedData = bluetoothGattCharacteristic.getValue();
                BaseDfuImpl.this.mRequestCompleted = true;
            } else {
                BaseDfuImpl baseDfuImpl = BaseDfuImpl.this;
                baseDfuImpl.loge("Characteristic read error: " + i);
                BaseDfuImpl.this.mError = i | 16384;
            }
            BaseDfuImpl.this.notifyLock();
        }

        public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            if (i != 0) {
                BaseDfuImpl baseDfuImpl = BaseDfuImpl.this;
                baseDfuImpl.loge("Descriptor read error: " + i);
                BaseDfuImpl.this.mError = i | 16384;
            } else if (BaseDfuImpl.CLIENT_CHARACTERISTIC_CONFIG.equals(bluetoothGattDescriptor.getUuid())) {
                DfuBaseService dfuBaseService = BaseDfuImpl.this.mService;
                dfuBaseService.sendLogBroadcast(5, "Read Response received from descr." + bluetoothGattDescriptor.getCharacteristic().getUuid() + ", value (0x): " + parse(bluetoothGattDescriptor));
                if (BaseDfuImpl.SERVICE_CHANGED_UUID.equals(bluetoothGattDescriptor.getCharacteristic().getUuid())) {
                    BaseDfuImpl.this.mRequestCompleted = true;
                } else {
                    BaseDfuImpl.this.loge("Unknown descriptor read");
                }
            }
            BaseDfuImpl.this.notifyLock();
        }

        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            if (i != 0) {
                BaseDfuImpl baseDfuImpl = BaseDfuImpl.this;
                baseDfuImpl.loge("Descriptor write error: " + i);
                BaseDfuImpl.this.mError = i | 16384;
            } else if (BaseDfuImpl.CLIENT_CHARACTERISTIC_CONFIG.equals(bluetoothGattDescriptor.getUuid())) {
                DfuBaseService dfuBaseService = BaseDfuImpl.this.mService;
                dfuBaseService.sendLogBroadcast(5, "Data written to descr." + bluetoothGattDescriptor.getCharacteristic().getUuid() + ", value (0x): " + parse(bluetoothGattDescriptor));
                if (BaseDfuImpl.SERVICE_CHANGED_UUID.equals(bluetoothGattDescriptor.getCharacteristic().getUuid())) {
                    DfuBaseService dfuBaseService2 = BaseDfuImpl.this.mService;
                    dfuBaseService2.sendLogBroadcast(1, "Indications enabled for " + bluetoothGattDescriptor.getCharacteristic().getUuid());
                } else {
                    DfuBaseService dfuBaseService3 = BaseDfuImpl.this.mService;
                    dfuBaseService3.sendLogBroadcast(1, "Notifications enabled for " + bluetoothGattDescriptor.getCharacteristic().getUuid());
                }
            }
            BaseDfuImpl.this.notifyLock();
        }

        public void onDisconnected() {
            BaseDfuImpl baseDfuImpl = BaseDfuImpl.this;
            baseDfuImpl.mConnected = false;
            baseDfuImpl.notifyLock();
        }

        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
            if (i2 == 0) {
                BaseDfuImpl.this.mService.sendLogBroadcast(5, "MTU changed to: " + i);
                int i3 = i + -3;
                BaseDfuImpl baseDfuImpl = BaseDfuImpl.this;
                if (i3 > baseDfuImpl.mBuffer.length) {
                    baseDfuImpl.mBuffer = new byte[i3];
                }
                baseDfuImpl.logi("MTU changed to: " + i);
            } else {
                BaseDfuImpl.this.logw("Changing MTU failed: " + i2 + " (mtu: " + i + ")");
                if (i2 == 4 && BaseDfuImpl.this.mCurrentMtu > 23) {
                    int access$000 = BaseDfuImpl.this.mCurrentMtu - 3;
                    BaseDfuImpl baseDfuImpl2 = BaseDfuImpl.this;
                    if (access$000 > baseDfuImpl2.mBuffer.length) {
                        baseDfuImpl2.mBuffer = new byte[(baseDfuImpl2.mCurrentMtu - 3)];
                        BaseDfuImpl.this.logi("MTU restored to: " + BaseDfuImpl.this.mCurrentMtu);
                    }
                }
            }
            BaseDfuImpl baseDfuImpl3 = BaseDfuImpl.this;
            baseDfuImpl3.mRequestCompleted = true;
            baseDfuImpl3.notifyLock();
        }

        public void onPhyUpdate(BluetoothGatt bluetoothGatt, int i, int i2, int i3) {
            if (i3 == 0) {
                DfuBaseService dfuBaseService = BaseDfuImpl.this.mService;
                dfuBaseService.sendLogBroadcast(5, "PHY updated (TX: " + phyToString(i) + ", RX: " + phyToString(i2) + ")");
                BaseDfuImpl baseDfuImpl = BaseDfuImpl.this;
                baseDfuImpl.logi("PHY updated (TX: " + phyToString(i) + ", RX: " + phyToString(i2) + ")");
                return;
            }
            BaseDfuImpl baseDfuImpl2 = BaseDfuImpl.this;
            baseDfuImpl2.logw("Updating PHY failed: " + i3 + " (txPhy: " + i + ", rxPhy: " + i2 + ")");
        }

        public String parse(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            return parse(bluetoothGattCharacteristic.getValue());
        }

        public String parse(BluetoothGattDescriptor bluetoothGattDescriptor) {
            return parse(bluetoothGattDescriptor.getValue());
        }

        private String parse(byte[] bArr) {
            int length;
            if (bArr == null || (length = bArr.length) == 0) {
                return "";
            }
            char[] cArr = new char[((length * 3) - 1)];
            for (int i = 0; i < length; i++) {
                byte b = bArr[i];
                int i2 = i * 3;
                cArr[i2] = BaseDfuImpl.HEX_ARRAY[(b & 255) >>> 4];
                cArr[i2 + 1] = BaseDfuImpl.HEX_ARRAY[b & 15];
                if (i != length - 1) {
                    cArr[i2 + 2] = Soundex.SILENT_MARKER;
                }
            }
            return new String(cArr);
        }
    }

    public BaseDfuImpl(@NonNull Intent intent, @NonNull DfuBaseService dfuBaseService) {
        this.mService = dfuBaseService;
        this.mProgressInfo = dfuBaseService.mProgressInfo;
        this.mConnected = true;
    }

    private boolean createBondApi18(@NonNull BluetoothDevice bluetoothDevice) {
        try {
            Method method = bluetoothDevice.getClass().getMethod("createBond", (Class[]) null);
            this.mService.sendLogBroadcast(0, "gatt.getDevice().createBond() (hidden)");
            return ((Boolean) method.invoke(bluetoothDevice, (Object[]) null)).booleanValue();
        } catch (Exception e) {
            Log.w(TAG, "An exception occurred while creating bond", e);
            return false;
        }
    }

    private boolean isServiceChangedCCCDEnabled() throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        BluetoothGattCharacteristic characteristic;
        BluetoothGattDescriptor descriptor;
        if (!this.mConnected) {
            throw new DeviceDisconnectedException("Unable to read Service Changed CCCD: device disconnected");
        } else if (!this.mAborted) {
            BluetoothGatt bluetoothGatt = this.mGatt;
            BluetoothGattService service = bluetoothGatt.getService(GENERIC_ATTRIBUTE_SERVICE_UUID);
            if (service == null || (characteristic = service.getCharacteristic(SERVICE_CHANGED_UUID)) == null || (descriptor = characteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIG)) == null) {
                return false;
            }
            this.mRequestCompleted = false;
            this.mError = 0;
            logi("Reading Service Changed CCCD value...");
            this.mService.sendLogBroadcast(1, "Reading Service Changed CCCD value...");
            DfuBaseService dfuBaseService = this.mService;
            dfuBaseService.sendLogBroadcast(0, "gatt.readDescriptor(" + descriptor.getUuid() + ")");
            bluetoothGatt.readDescriptor(descriptor);
            try {
                synchronized (this.mLock) {
                    while (true) {
                        if (!this.mRequestCompleted && this.mConnected) {
                            if (this.mError == 0) {
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
            if (!this.mConnected) {
                throw new DeviceDisconnectedException("Unable to read Service Changed CCCD: device disconnected");
            } else if (this.mError != 0) {
                throw new DfuException("Unable to read Service Changed CCCD", this.mError);
            } else if (descriptor.getValue() == null || descriptor.getValue().length != 2) {
                return false;
            } else {
                byte b = descriptor.getValue()[0];
                byte[] bArr = BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
                return b == bArr[0] && descriptor.getValue()[1] == bArr[1];
            }
        } else {
            throw new UploadAbortedException();
        }
    }

    public void abort() {
        this.mPaused = false;
        this.mAborted = true;
        notifyLock();
    }

    public boolean createBond() {
        BluetoothDevice device = this.mGatt.getDevice();
        if (device.getBondState() == 12) {
            return true;
        }
        this.mRequestCompleted = false;
        this.mService.sendLogBroadcast(1, "Starting pairing...");
        this.mService.sendLogBroadcast(0, "gatt.getDevice().createBond()");
        boolean createBond = device.createBond();
        try {
            synchronized (this.mLock) {
                while (!this.mRequestCompleted && !this.mAborted) {
                    this.mLock.wait();
                }
            }
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        } catch (Throwable th) {
            throw th;
        }
        return createBond;
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x0106 A[Catch:{ all -> 0x00de, InterruptedException -> 0x010e }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0108 A[Catch:{ all -> 0x00de, InterruptedException -> 0x010e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void enableCCCD(@androidx.annotation.NonNull android.bluetooth.BluetoothGattCharacteristic r11, int r12) throws no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException, no.nordicsemi.android.dfu.internal.exception.DfuException, no.nordicsemi.android.dfu.internal.exception.UploadAbortedException {
        /*
            r10 = this;
            android.bluetooth.BluetoothGatt r0 = r10.mGatt
            r1 = 1
            if (r12 != r1) goto L_0x0008
            java.lang.String r2 = "notifications"
            goto L_0x000a
        L_0x0008:
            java.lang.String r2 = "indications"
        L_0x000a:
            boolean r3 = r10.mConnected
            if (r3 == 0) goto L_0x015d
            boolean r3 = r10.mAborted
            if (r3 != 0) goto L_0x0157
            r3 = 0
            r10.mReceivedData = r3
            r3 = 0
            r10.mError = r3
            java.util.UUID r4 = CLIENT_CHARACTERISTIC_CONFIG
            android.bluetooth.BluetoothGattDescriptor r4 = r11.getDescriptor(r4)
            byte[] r5 = r4.getValue()
            r6 = 2
            if (r5 == 0) goto L_0x003e
            byte[] r5 = r4.getValue()
            int r5 = r5.length
            if (r5 != r6) goto L_0x003e
            byte[] r5 = r4.getValue()
            byte r5 = r5[r3]
            if (r5 <= 0) goto L_0x003e
            byte[] r5 = r4.getValue()
            byte r5 = r5[r1]
            if (r5 != 0) goto L_0x003e
            r5 = r1
            goto L_0x003f
        L_0x003e:
            r5 = r3
        L_0x003f:
            if (r5 == 0) goto L_0x0042
            return
        L_0x0042:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Enabling "
            r7.append(r8)
            r7.append(r2)
            java.lang.String r8 = "..."
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            r10.logi(r7)
            no.nordicsemi.android.dfu.DfuBaseService r7 = r10.mService
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Enabling "
            r8.append(r9)
            r8.append(r2)
            java.lang.String r9 = " for "
            r8.append(r9)
            java.util.UUID r9 = r11.getUuid()
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r7.sendLogBroadcast(r1, r8)
            no.nordicsemi.android.dfu.DfuBaseService r7 = r10.mService
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "gatt.setCharacteristicNotification("
            r8.append(r9)
            java.util.UUID r9 = r11.getUuid()
            r8.append(r9)
            java.lang.String r9 = ", true)"
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r7.sendLogBroadcast(r3, r8)
            r0.setCharacteristicNotification(r11, r1)
            if (r12 != r1) goto L_0x00a4
            byte[] r11 = android.bluetooth.BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE
            goto L_0x00a6
        L_0x00a4:
            byte[] r11 = android.bluetooth.BluetoothGattDescriptor.ENABLE_INDICATION_VALUE
        L_0x00a6:
            r4.setValue(r11)
            no.nordicsemi.android.dfu.DfuBaseService r11 = r10.mService
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "gatt.writeDescriptor("
            r7.append(r8)
            java.util.UUID r8 = r4.getUuid()
            r7.append(r8)
            if (r12 != r1) goto L_0x00c1
            java.lang.String r12 = ", value=0x01-00)"
            goto L_0x00c3
        L_0x00c1:
            java.lang.String r12 = ", value=0x02-00)"
        L_0x00c3:
            r7.append(r12)
            java.lang.String r12 = r7.toString()
            r11.sendLogBroadcast(r3, r12)
            r0.writeDescriptor(r4)
            java.lang.Object r11 = r10.mLock     // Catch:{ InterruptedException -> 0x010e }
            monitor-enter(r11)     // Catch:{ InterruptedException -> 0x010e }
        L_0x00d3:
            if (r5 != 0) goto L_0x00e0
            boolean r12 = r10.mConnected     // Catch:{ all -> 0x00de }
            if (r12 == 0) goto L_0x00e0
            int r12 = r10.mError     // Catch:{ all -> 0x00de }
            if (r12 == 0) goto L_0x00e4
            goto L_0x00e0
        L_0x00de:
            r12 = move-exception
            goto L_0x010c
        L_0x00e0:
            boolean r12 = r10.mPaused     // Catch:{ all -> 0x00de }
            if (r12 == 0) goto L_0x010a
        L_0x00e4:
            java.lang.Object r12 = r10.mLock     // Catch:{ all -> 0x00de }
            r12.wait()     // Catch:{ all -> 0x00de }
            byte[] r12 = r4.getValue()     // Catch:{ all -> 0x00de }
            if (r12 == 0) goto L_0x0108
            byte[] r12 = r4.getValue()     // Catch:{ all -> 0x00de }
            int r12 = r12.length     // Catch:{ all -> 0x00de }
            if (r12 != r6) goto L_0x0108
            byte[] r12 = r4.getValue()     // Catch:{ all -> 0x00de }
            byte r12 = r12[r3]     // Catch:{ all -> 0x00de }
            if (r12 <= 0) goto L_0x0108
            byte[] r12 = r4.getValue()     // Catch:{ all -> 0x00de }
            byte r12 = r12[r1]     // Catch:{ all -> 0x00de }
            if (r12 != 0) goto L_0x0108
            r5 = r1
            goto L_0x00d3
        L_0x0108:
            r5 = r3
            goto L_0x00d3
        L_0x010a:
            monitor-exit(r11)     // Catch:{ all -> 0x00de }
            goto L_0x0114
        L_0x010c:
            monitor-exit(r11)     // Catch:{ all -> 0x00de }
            throw r12     // Catch:{ InterruptedException -> 0x010e }
        L_0x010e:
            r11 = move-exception
            java.lang.String r12 = "Sleeping interrupted"
            r10.loge(r12, r11)
        L_0x0114:
            boolean r11 = r10.mConnected
            if (r11 == 0) goto L_0x013b
            int r11 = r10.mError
            if (r11 != 0) goto L_0x011d
            return
        L_0x011d:
            no.nordicsemi.android.dfu.internal.exception.DfuException r11 = new no.nordicsemi.android.dfu.internal.exception.DfuException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r0 = "Unable to set "
            r12.append(r0)
            r12.append(r2)
            java.lang.String r0 = " state"
            r12.append(r0)
            java.lang.String r12 = r12.toString()
            int r10 = r10.mError
            r11.<init>(r12, r10)
            throw r11
        L_0x013b:
            no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException r10 = new no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "Unable to set "
            r11.append(r12)
            r11.append(r2)
            java.lang.String r12 = " state: device disconnected"
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        L_0x0157:
            no.nordicsemi.android.dfu.internal.exception.UploadAbortedException r10 = new no.nordicsemi.android.dfu.internal.exception.UploadAbortedException
            r10.<init>()
            throw r10
        L_0x015d:
            no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException r10 = new no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "Unable to set "
            r11.append(r12)
            r11.append(r2)
            java.lang.String r12 = " state: device disconnected"
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.BaseDfuImpl.enableCCCD(android.bluetooth.BluetoothGattCharacteristic, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0062 A[Catch:{ Exception -> 0x0074 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x009d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean initialize(@androidx.annotation.NonNull android.content.Intent r6, @androidx.annotation.NonNull android.bluetooth.BluetoothGatt r7, int r8, @androidx.annotation.NonNull java.io.InputStream r9, @androidx.annotation.Nullable java.io.InputStream r10) throws no.nordicsemi.android.dfu.internal.exception.DfuException, no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException, no.nordicsemi.android.dfu.internal.exception.UploadAbortedException {
        /*
            r5 = this;
            r5.mGatt = r7
            r5.mFileType = r8
            r5.mFirmwareStream = r9
            r5.mInitPacketStream = r10
            java.lang.String r0 = "no.nordicsemi.android.dfu.extra.EXTRA_PART_CURRENT"
            r1 = 1
            int r0 = r6.getIntExtra(r0, r1)
            java.lang.String r2 = "no.nordicsemi.android.dfu.extra.EXTRA_PARTS_TOTAL"
            int r2 = r6.getIntExtra(r2, r1)
            java.lang.String r3 = "no.nordicsemi.android.dfu.extra.EXTRA_CURRENT_MTU"
            r4 = 23
            int r6 = r6.getIntExtra(r3, r4)
            r5.mCurrentMtu = r6
            r6 = 4
            r3 = 15
            r4 = 2
            if (r8 <= r6) goto L_0x003f
            java.lang.String r6 = "DFU target does not support (SD/BL)+App update, splitting into 2 parts"
            r5.logw(r6)
            no.nordicsemi.android.dfu.DfuBaseService r6 = r5.mService
            java.lang.String r8 = "Sending system components"
            r6.sendLogBroadcast(r3, r8)
            int r6 = r5.mFileType
            r6 = r6 & -5
            r5.mFileType = r6
            java.io.InputStream r8 = r5.mFirmwareStream
            no.nordicsemi.android.dfu.internal.ArchiveInputStream r8 = (no.nordicsemi.android.dfu.internal.ArchiveInputStream) r8
            r8.setContentType(r6)
            r2 = r4
        L_0x003f:
            if (r0 != r4) goto L_0x0048
            no.nordicsemi.android.dfu.DfuBaseService r6 = r5.mService
            java.lang.String r8 = "Sending application"
            r6.sendLogBroadcast(r3, r8)
        L_0x0048:
            r6 = 0
            if (r10 == 0) goto L_0x0059
            boolean r8 = r10.markSupported()     // Catch:{ Exception -> 0x0059 }
            if (r8 == 0) goto L_0x0054
            r10.reset()     // Catch:{ Exception -> 0x0059 }
        L_0x0054:
            int r8 = r10.available()     // Catch:{ Exception -> 0x0059 }
            goto L_0x005a
        L_0x0059:
            r8 = r6
        L_0x005a:
            r5.mInitPacketSizeInBytes = r8
            boolean r8 = r9.markSupported()     // Catch:{ Exception -> 0x0074 }
            if (r8 == 0) goto L_0x0070
            boolean r8 = r9 instanceof no.nordicsemi.android.dfu.internal.ArchiveInputStream     // Catch:{ Exception -> 0x0074 }
            if (r8 == 0) goto L_0x006d
            r8 = r9
            no.nordicsemi.android.dfu.internal.ArchiveInputStream r8 = (no.nordicsemi.android.dfu.internal.ArchiveInputStream) r8     // Catch:{ Exception -> 0x0074 }
            r8.fullReset()     // Catch:{ Exception -> 0x0074 }
            goto L_0x0070
        L_0x006d:
            r9.reset()     // Catch:{ Exception -> 0x0074 }
        L_0x0070:
            int r6 = r9.available()     // Catch:{ Exception -> 0x0074 }
        L_0x0074:
            r5.mImageSizeInBytes = r6
            no.nordicsemi.android.dfu.DfuProgressInfo r8 = r5.mProgressInfo
            r8.init(r6, r0, r2)
            android.bluetooth.BluetoothDevice r6 = r7.getDevice()
            int r6 = r6.getBondState()
            r8 = 12
            if (r6 != r8) goto L_0x00a9
            java.util.UUID r6 = GENERIC_ATTRIBUTE_SERVICE_UUID
            android.bluetooth.BluetoothGattService r6 = r7.getService(r6)
            if (r6 == 0) goto L_0x00a9
            java.util.UUID r7 = SERVICE_CHANGED_UUID
            android.bluetooth.BluetoothGattCharacteristic r6 = r6.getCharacteristic(r7)
            if (r6 == 0) goto L_0x00a9
            boolean r7 = r5.isServiceChangedCCCDEnabled()
            if (r7 != 0) goto L_0x00a0
            r5.enableCCCD(r6, r4)
        L_0x00a0:
            no.nordicsemi.android.dfu.DfuBaseService r5 = r5.mService
            r6 = 10
            java.lang.String r7 = "Service Changed indications enabled"
            r5.sendLogBroadcast(r6, r7)
        L_0x00a9:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.BaseDfuImpl.initialize(android.content.Intent, android.bluetooth.BluetoothGatt, int, java.io.InputStream, java.io.InputStream):boolean");
    }

    public boolean isBonded() {
        return this.mGatt.getDevice().getBondState() == 12;
    }

    public void loge(String str) {
        Log.e(TAG, str);
    }

    public void logi(String str) {
        if (DfuBaseService.DEBUG) {
            Log.i(TAG, str);
        }
    }

    public void logw(String str) {
        if (DfuBaseService.DEBUG) {
            Log.w(TAG, str);
        }
    }

    public void notifyLock() {
        synchronized (this.mLock) {
            this.mLock.notifyAll();
        }
    }

    public void onBondStateChanged(int i) {
        this.mRequestCompleted = true;
        notifyLock();
    }

    public String parse(@Nullable byte[] bArr) {
        int length;
        if (bArr == null || (length = bArr.length) == 0) {
            return "";
        }
        char[] cArr = new char[((length * 3) - 1)];
        for (int i = 0; i < length; i++) {
            byte b = bArr[i];
            int i2 = i * 3;
            char[] cArr2 = HEX_ARRAY;
            cArr[i2] = cArr2[(b & 255) >>> 4];
            cArr[i2 + 1] = cArr2[b & 15];
            if (i != length - 1) {
                cArr[i2 + 2] = Soundex.SILENT_MARKER;
            }
        }
        return new String(cArr);
    }

    public void pause() {
        this.mPaused = true;
    }

    public byte[] readNotificationResponse() throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        try {
            synchronized (this.mLock) {
                while (true) {
                    if (this.mReceivedData == null && this.mConnected && this.mError == 0) {
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
            throw new DeviceDisconnectedException("Unable to write Op Code: device disconnected");
        } else if (this.mError == 0) {
            return this.mReceivedData;
        } else {
            logi("Unable to write Op Code 2222222");
            throw new DfuException("Unable to write Op Code", this.mError);
        }
    }

    public void release() {
        this.mService = null;
    }

    public boolean removeBond() {
        BluetoothDevice device = this.mGatt.getDevice();
        if (device.getBondState() == 10) {
            return true;
        }
        this.mService.sendLogBroadcast(1, "Removing bond information...");
        boolean z = false;
        try {
            Method method = device.getClass().getMethod("removeBond", (Class[]) null);
            this.mRequestCompleted = false;
            this.mService.sendLogBroadcast(0, "gatt.getDevice().removeBond() (hidden)");
            z = ((Boolean) method.invoke(device, (Object[]) null)).booleanValue();
            try {
                synchronized (this.mLock) {
                    while (!this.mRequestCompleted && !this.mAborted) {
                        this.mLock.wait();
                    }
                }
            } catch (InterruptedException e) {
                loge("Sleeping interrupted", e);
            } catch (Throwable th) {
                throw th;
            }
        } catch (Exception e2) {
            Log.w(TAG, "An exception occurred while removing bond information", e2);
        }
        return z;
    }

    @RequiresApi
    public void requestMtu(@IntRange int i) throws DeviceDisconnectedException, UploadAbortedException {
        if (!this.mAborted) {
            this.mRequestCompleted = false;
            this.mService.sendLogBroadcast(1, "Requesting new MTU...");
            DfuBaseService dfuBaseService = this.mService;
            dfuBaseService.sendLogBroadcast(0, "gatt.requestMtu(" + i + ")");
            if (this.mGatt.requestMtu(i)) {
                try {
                    synchronized (this.mLock) {
                        while (true) {
                            if (!this.mRequestCompleted && this.mConnected) {
                                if (this.mError == 0) {
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
                if (!this.mConnected) {
                    throw new DeviceDisconnectedException("Unable to read Service Changed CCCD: device disconnected");
                }
                return;
            }
            return;
        }
        throw new UploadAbortedException();
    }

    public void restartService(@NonNull Intent intent, boolean z) {
        String str;
        if (z) {
            this.mService.sendLogBroadcast(1, "Scanning for the DFU Bootloader...");
            str = BootloaderScannerFactory.getScanner().searchFor(this.mGatt.getDevice().getAddress());
            logi("Scanning for new address finished with: " + str);
            if (str != null) {
                DfuBaseService dfuBaseService = this.mService;
                dfuBaseService.sendLogBroadcast(5, "DFU Bootloader found with address " + str);
            } else {
                this.mService.sendLogBroadcast(5, "DFU Bootloader not found. Trying the same address...");
            }
        } else {
            str = null;
        }
        if (str != null) {
            intent.putExtra(DfuBaseService.EXTRA_DEVICE_ADDRESS, str);
        }
        intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DFU_ATTEMPT", 0);
        this.mService.startService(intent);
    }

    public void resume() {
        this.mPaused = false;
        notifyLock();
    }

    public void waitIfPaused() {
        try {
            synchronized (this.mLock) {
                while (this.mPaused) {
                    this.mLock.wait();
                }
            }
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void writeOpCode(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, @NonNull byte[] bArr, boolean z) throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        if (!this.mAborted) {
            this.mReceivedData = null;
            this.mError = 0;
            this.mRequestCompleted = false;
            this.mResetRequestSent = z;
            bluetoothGattCharacteristic.setWriteType(2);
            bluetoothGattCharacteristic.setValue(bArr);
            DfuBaseService dfuBaseService = this.mService;
            dfuBaseService.sendLogBroadcast(1, "Writing to characteristic " + bluetoothGattCharacteristic.getUuid());
            DfuBaseService dfuBaseService2 = this.mService;
            dfuBaseService2.sendLogBroadcast(0, "gatt.writeCharacteristic(" + bluetoothGattCharacteristic.getUuid() + ")");
            this.mGatt.writeCharacteristic(bluetoothGattCharacteristic);
            try {
                synchronized (this.mLock) {
                    while (true) {
                        if (!this.mRequestCompleted && this.mConnected) {
                            if (this.mError == 0) {
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
            boolean z2 = this.mResetRequestSent;
            if (!z2 && !this.mConnected) {
                this.mService.report(4096);
                throw new DeviceDisconnectedException("Unable to write Op Code " + bArr[0] + ": device disconnected");
            } else if (!z2 && this.mError != 0) {
                this.mService.report(DfuBaseService.ERROR_FILE_ERROR);
                throw new DfuException("Unable to write Op Code " + bArr[0], this.mError);
            }
        } else {
            throw new UploadAbortedException();
        }
    }

    public void loge(String str, Throwable th) {
        Log.e(TAG, str, th);
    }
}
