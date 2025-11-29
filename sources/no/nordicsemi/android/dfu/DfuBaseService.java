package no.nordicsemi.android.dfu;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.IntentService;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.jstyle.nordic_otas.nordic_otas_plugin.R;
import com.upuphone.runasone.uupcast.CaptureType;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import no.nordicsemi.android.dfu.DfuProgressInfo;
import no.nordicsemi.android.dfu.internal.ArchiveInputStream;
import no.nordicsemi.android.dfu.internal.HexInputStream;

public abstract class DfuBaseService extends IntentService implements DfuProgressInfo.ProgressListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int ACTION_ABORT = 2;
    public static final int ACTION_PAUSE = 0;
    public static final int ACTION_RESUME = 1;
    public static final String BROADCAST_ACTION = "no.nordicsemi.android.dfu.broadcast.BROADCAST_ACTION";
    public static final String BROADCAST_ERROR = "no.nordicsemi.android.dfu.broadcast.BROADCAST_ERROR";
    public static final String BROADCAST_LOG = "no.nordicsemi.android.dfu.broadcast.BROADCAST_LOG";
    public static final String BROADCAST_PROGRESS = "no.nordicsemi.android.dfu.broadcast.BROADCAST_PROGRESS";
    static boolean DEBUG = false;
    public static final int ERROR_BLUETOOTH_DISABLED = 4106;
    public static final int ERROR_CONNECTION_MASK = 16384;
    public static final int ERROR_CONNECTION_STATE_MASK = 32768;
    public static final int ERROR_CRC_ERROR = 4109;
    public static final int ERROR_DEVICE_DISCONNECTED = 4096;
    public static final int ERROR_DEVICE_NOT_BONDED = 4110;
    public static final int ERROR_FILE_ERROR = 4098;
    public static final int ERROR_FILE_INVALID = 4099;
    public static final int ERROR_FILE_IO_EXCEPTION = 4100;
    public static final int ERROR_FILE_NOT_FOUND = 4097;
    public static final int ERROR_FILE_SIZE_INVALID = 4108;
    public static final int ERROR_FILE_TYPE_UNSUPPORTED = 4105;
    public static final int ERROR_INIT_PACKET_REQUIRED = 4107;
    public static final int ERROR_INVALID_RESPONSE = 4104;
    public static final int ERROR_MASK = 4096;
    public static final int ERROR_REMOTE_MASK = 8192;
    public static final int ERROR_REMOTE_TYPE_LEGACY = 256;
    public static final int ERROR_REMOTE_TYPE_SECURE = 512;
    public static final int ERROR_REMOTE_TYPE_SECURE_BUTTONLESS = 2048;
    public static final int ERROR_REMOTE_TYPE_SECURE_EXTENDED = 1024;
    public static final int ERROR_SERVICE_DISCOVERY_NOT_STARTED = 4101;
    public static final int ERROR_SERVICE_NOT_FOUND = 4102;
    public static final int ERROR_TYPE_COMMUNICATION = 2;
    public static final int ERROR_TYPE_COMMUNICATION_STATE = 1;
    public static final int ERROR_TYPE_DFU_REMOTE = 3;
    public static final int ERROR_TYPE_OTHER = 0;
    public static final String EXTRA_ACTION = "no.nordicsemi.android.dfu.extra.EXTRA_ACTION";
    public static final String EXTRA_AVG_SPEED_B_PER_MS = "no.nordicsemi.android.dfu.extra.EXTRA_AVG_SPEED_B_PER_MS";
    public static final String EXTRA_CURRENT_MTU = "no.nordicsemi.android.dfu.extra.EXTRA_CURRENT_MTU";
    public static final String EXTRA_CUSTOM_UUIDS_FOR_BUTTONLESS_DFU_WITHOUT_BOND_SHARING = "no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_BUTTONLESS_DFU_WITHOUT_BOND_SHARING";
    public static final String EXTRA_CUSTOM_UUIDS_FOR_BUTTONLESS_DFU_WITH_BOND_SHARING = "no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_BUTTONLESS_DFU_WITH_BOND_SHARING";
    public static final String EXTRA_CUSTOM_UUIDS_FOR_EXPERIMENTAL_BUTTONLESS_DFU = "no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_EXPERIMENTAL_BUTTONLESS_DFU";
    public static final String EXTRA_CUSTOM_UUIDS_FOR_LEGACY_DFU = "no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_LEGACY_DFU";
    public static final String EXTRA_CUSTOM_UUIDS_FOR_SECURE_DFU = "no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_SECURE_DFU";
    public static final String EXTRA_DATA = "no.nordicsemi.android.dfu.extra.EXTRA_DATA";
    public static final String EXTRA_DEVICE_ADDRESS = "no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_ADDRESS";
    public static final String EXTRA_DEVICE_NAME = "no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_NAME";
    static final String EXTRA_DFU_ATTEMPT = "no.nordicsemi.android.dfu.extra.EXTRA_DFU_ATTEMPT";
    public static final String EXTRA_DISABLE_NOTIFICATION = "no.nordicsemi.android.dfu.extra.EXTRA_DISABLE_NOTIFICATION";
    public static final String EXTRA_DISABLE_RESUME = "no.nordicsemi.android.dfu.extra.EXTRA_DISABLE_RESUME";
    public static final String EXTRA_ERROR_TYPE = "no.nordicsemi.android.dfu.extra.EXTRA_ERROR_TYPE";
    public static final String EXTRA_FILE_MIME_TYPE = "no.nordicsemi.android.dfu.extra.EXTRA_MIME_TYPE";
    public static final String EXTRA_FILE_PATH = "no.nordicsemi.android.dfu.extra.EXTRA_FILE_PATH";
    public static final String EXTRA_FILE_RES_ID = "no.nordicsemi.android.dfu.extra.EXTRA_FILE_RES_ID";
    public static final String EXTRA_FILE_TYPE = "no.nordicsemi.android.dfu.extra.EXTRA_FILE_TYPE";
    public static final String EXTRA_FILE_URI = "no.nordicsemi.android.dfu.extra.EXTRA_FILE_URI";
    public static final String EXTRA_FORCE_DFU = "no.nordicsemi.android.dfu.extra.EXTRA_FORCE_DFU";
    public static final String EXTRA_FOREGROUND_SERVICE = "no.nordicsemi.android.dfu.extra.EXTRA_FOREGROUND_SERVICE";
    public static final String EXTRA_INIT_FILE_PATH = "no.nordicsemi.android.dfu.extra.EXTRA_INIT_FILE_PATH";
    public static final String EXTRA_INIT_FILE_RES_ID = "no.nordicsemi.android.dfu.extra.EXTRA_INIT_FILE_RES_ID";
    public static final String EXTRA_INIT_FILE_URI = "no.nordicsemi.android.dfu.extra.EXTRA_INIT_FILE_URI";
    public static final String EXTRA_KEEP_BOND = "no.nordicsemi.android.dfu.extra.EXTRA_KEEP_BOND";
    public static final String EXTRA_LOG_LEVEL = "no.nordicsemi.android.dfu.extra.EXTRA_LOG_LEVEL";
    public static final String EXTRA_LOG_MESSAGE = "no.nordicsemi.android.dfu.extra.EXTRA_LOG_INFO";
    public static final String EXTRA_MAX_DFU_ATTEMPTS = "no.nordicsemi.android.dfu.extra.EXTRA_MAX_DFU_ATTEMPTS";
    public static final String EXTRA_MBR_SIZE = "no.nordicsemi.android.dfu.extra.EXTRA_MBR_SIZE";
    public static final String EXTRA_MTU = "no.nordicsemi.android.dfu.extra.EXTRA_MTU";
    public static final String EXTRA_PACKET_RECEIPT_NOTIFICATIONS_ENABLED = "no.nordicsemi.android.dfu.extra.EXTRA_PRN_ENABLED";
    public static final String EXTRA_PACKET_RECEIPT_NOTIFICATIONS_VALUE = "no.nordicsemi.android.dfu.extra.EXTRA_PRN_VALUE";
    public static final String EXTRA_PARTS_TOTAL = "no.nordicsemi.android.dfu.extra.EXTRA_PARTS_TOTAL";
    public static final String EXTRA_PART_CURRENT = "no.nordicsemi.android.dfu.extra.EXTRA_PART_CURRENT";
    public static final String EXTRA_PROGRESS = "no.nordicsemi.android.dfu.extra.EXTRA_PROGRESS";
    private static final String EXTRA_RECONNECTION_ATTEMPT = "no.nordicsemi.android.dfu.extra.EXTRA_RECONNECTION_ATTEMPT";
    public static final String EXTRA_RESTORE_BOND = "no.nordicsemi.android.dfu.extra.EXTRA_RESTORE_BOND";
    public static final String EXTRA_SPEED_B_PER_MS = "no.nordicsemi.android.dfu.extra.EXTRA_SPEED_B_PER_MS";
    public static final String EXTRA_UNSAFE_EXPERIMENTAL_BUTTONLESS_DFU = "no.nordicsemi.android.dfu.extra.EXTRA_UNSAFE_EXPERIMENTAL_BUTTONLESS_DFU";
    public static final int LOG_LEVEL_APPLICATION = 10;
    public static final int LOG_LEVEL_DEBUG = 0;
    public static final int LOG_LEVEL_ERROR = 20;
    public static final int LOG_LEVEL_INFO = 5;
    public static final int LOG_LEVEL_VERBOSE = 1;
    public static final int LOG_LEVEL_WARNING = 15;
    public static final String MIME_TYPE_OCTET_STREAM = "application/octet-stream";
    public static final String MIME_TYPE_ZIP = "application/zip";
    public static final String NOTIFICATION_CHANNEL_DFU = "dfu";
    public static final int NOTIFICATION_ID = 283;
    public static final int PROGRESS_ABORTED = -7;
    public static final int PROGRESS_COMPLETED = -6;
    public static final int PROGRESS_CONNECTING = -1;
    public static final int PROGRESS_DISCONNECTING = -5;
    public static final int PROGRESS_ENABLING_DFU_MODE = -3;
    public static final int PROGRESS_STARTING = -2;
    public static final int PROGRESS_VALIDATING = -4;
    protected static final int STATE_CLOSED = -5;
    protected static final int STATE_CONNECTED = -2;
    protected static final int STATE_CONNECTED_AND_READY = -3;
    protected static final int STATE_CONNECTING = -1;
    protected static final int STATE_DISCONNECTED = 0;
    protected static final int STATE_DISCONNECTING = -4;
    private static final String TAG = "DfuBaseService";
    public static final int TYPE_APPLICATION = 4;
    public static final int TYPE_AUTO = 0;
    public static final int TYPE_BOOTLOADER = 2;
    public static final int TYPE_SOFT_DEVICE = 1;
    /* access modifiers changed from: private */
    public boolean mAborted;
    private BluetoothAdapter mBluetoothAdapter;
    private final BroadcastReceiver mBluetoothStateBroadcastReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10);
            int intExtra2 = intent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", 12);
            DfuBaseService dfuBaseService = DfuBaseService.this;
            dfuBaseService.logw("Action received: android.bluetooth.adapter.action.STATE_CHANGED [state: " + intExtra + ", previous state: " + intExtra2 + "]");
            if (intExtra2 != 12) {
                return;
            }
            if (intExtra == 13 || intExtra == 10) {
                DfuBaseService.this.sendLogBroadcast(15, "Bluetooth adapter disabled");
                DfuBaseService dfuBaseService2 = DfuBaseService.this;
                dfuBaseService2.mConnectionState = 0;
                if (dfuBaseService2.mDfuServiceImpl != null) {
                    DfuBaseService.this.mDfuServiceImpl.getGattCallback().onDisconnected();
                }
            }
        }
    };
    private final BroadcastReceiver mBondStateBroadcastReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            int intExtra;
            BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            if (bluetoothDevice != null && bluetoothDevice.getAddress().equals(DfuBaseService.this.mDeviceAddress) && (intExtra = intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", -1)) != 11 && DfuBaseService.this.mDfuServiceImpl != null) {
                DfuBaseService.this.mDfuServiceImpl.onBondStateChanged(intExtra);
            }
        }
    };
    protected int mConnectionState;
    private final BroadcastReceiver mConnectionStateBroadcastReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            if (bluetoothDevice != null && bluetoothDevice.getAddress().equals(DfuBaseService.this.mDeviceAddress)) {
                String action = intent.getAction();
                DfuBaseService dfuBaseService = DfuBaseService.this;
                dfuBaseService.logi("Action received: " + action);
                DfuBaseService dfuBaseService2 = DfuBaseService.this;
                dfuBaseService2.sendLogBroadcast(0, "[Broadcast] Action received: " + action);
            }
        }
    };
    /* access modifiers changed from: private */
    public String mDeviceAddress;
    private String mDeviceName;
    private final BroadcastReceiver mDfuActionReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            int intExtra = intent.getIntExtra(DfuBaseService.EXTRA_ACTION, 0);
            DfuBaseService dfuBaseService = DfuBaseService.this;
            dfuBaseService.logi("User action received: " + intExtra);
            if (intExtra == 0) {
                DfuBaseService.this.sendLogBroadcast(15, "[Broadcast] Pause action received");
                if (DfuBaseService.this.mDfuServiceImpl != null) {
                    DfuBaseService.this.mDfuServiceImpl.pause();
                }
            } else if (intExtra == 1) {
                DfuBaseService.this.sendLogBroadcast(15, "[Broadcast] Resume action received");
                if (DfuBaseService.this.mDfuServiceImpl != null) {
                    DfuBaseService.this.mDfuServiceImpl.resume();
                }
            } else if (intExtra == 2) {
                DfuBaseService.this.sendLogBroadcast(15, "[Broadcast] Abort action received");
                boolean unused = DfuBaseService.this.mAborted = true;
                if (DfuBaseService.this.mDfuServiceImpl != null) {
                    DfuBaseService.this.mDfuServiceImpl.abort();
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public DfuCallback mDfuServiceImpl;
    private boolean mDisableNotification;
    /* access modifiers changed from: private */
    public int mError;
    private InputStream mFirmwareInputStream;
    private final BluetoothGattCallback mGattCallback = new BluetoothGattCallback() {
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            if (DfuBaseService.this.mDfuServiceImpl != null) {
                DfuBaseService.this.mDfuServiceImpl.getGattCallback().onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
            }
        }

        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            if (DfuBaseService.this.mDfuServiceImpl != null) {
                DfuBaseService.this.mDfuServiceImpl.getGattCallback().onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i);
            }
        }

        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            if (DfuBaseService.this.mDfuServiceImpl != null) {
                DfuBaseService.this.mDfuServiceImpl.getGattCallback().onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
            }
        }

        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            if (i != 0) {
                if (i == 8 || i == 19) {
                    DfuBaseService dfuBaseService = DfuBaseService.this;
                    dfuBaseService.logw("Target device disconnected with status: " + i);
                } else {
                    DfuBaseService dfuBaseService2 = DfuBaseService.this;
                    dfuBaseService2.loge("Connection state change error: " + i + " newState: " + i2);
                }
                int unused = DfuBaseService.this.mError = i | 32768;
                if (i2 == 0) {
                    DfuBaseService dfuBaseService3 = DfuBaseService.this;
                    dfuBaseService3.mConnectionState = 0;
                    if (dfuBaseService3.mDfuServiceImpl != null) {
                        DfuBaseService.this.mDfuServiceImpl.getGattCallback().onDisconnected();
                    }
                }
            } else if (i2 == 2) {
                DfuBaseService.this.logi("Connected to GATT server");
                DfuBaseService dfuBaseService4 = DfuBaseService.this;
                dfuBaseService4.sendLogBroadcast(5, "Connected to " + DfuBaseService.this.mDeviceAddress);
                DfuBaseService.this.mConnectionState = -2;
                if (bluetoothGatt.getDevice().getBondState() == 12) {
                    DfuBaseService.this.logi("Waiting 1600 ms for a possible Service Changed indication...");
                    DfuBaseService.this.waitFor(1600);
                }
                DfuBaseService.this.sendLogBroadcast(1, "Discovering services...");
                DfuBaseService.this.sendLogBroadcast(0, "gatt.discoverServices()");
                boolean discoverServices = bluetoothGatt.discoverServices();
                DfuBaseService dfuBaseService5 = DfuBaseService.this;
                StringBuilder sb = new StringBuilder();
                sb.append("Attempting to start service discovery... ");
                sb.append(discoverServices ? "succeed" : "failed");
                dfuBaseService5.logi(sb.toString());
                if (!discoverServices) {
                    int unused2 = DfuBaseService.this.mError = DfuBaseService.ERROR_SERVICE_DISCOVERY_NOT_STARTED;
                } else {
                    return;
                }
            } else if (i2 == 0) {
                DfuBaseService.this.logi("Disconnected from GATT server");
                DfuBaseService dfuBaseService6 = DfuBaseService.this;
                dfuBaseService6.mConnectionState = 0;
                if (dfuBaseService6.mDfuServiceImpl != null) {
                    DfuBaseService.this.mDfuServiceImpl.getGattCallback().onDisconnected();
                }
            }
            synchronized (DfuBaseService.this.mLock) {
                DfuBaseService.this.mLock.notifyAll();
            }
        }

        public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            if (DfuBaseService.this.mDfuServiceImpl != null) {
                DfuBaseService.this.mDfuServiceImpl.getGattCallback().onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i);
            }
        }

        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            if (DfuBaseService.this.mDfuServiceImpl != null) {
                DfuBaseService.this.mDfuServiceImpl.getGattCallback().onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i);
            }
        }

        @SuppressLint({"NewApi"})
        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
            if (DfuBaseService.this.mDfuServiceImpl != null) {
                DfuBaseService.this.mDfuServiceImpl.getGattCallback().onMtuChanged(bluetoothGatt, i, i2);
            }
        }

        @SuppressLint({"NewApi"})
        public void onPhyUpdate(BluetoothGatt bluetoothGatt, int i, int i2, int i3) {
            if (DfuBaseService.this.mDfuServiceImpl != null) {
                DfuBaseService.this.mDfuServiceImpl.getGattCallback().onPhyUpdate(bluetoothGatt, i, i2, i3);
            }
        }

        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            if (i == 0) {
                DfuBaseService.this.logi("Services discovered");
                DfuBaseService.this.mConnectionState = -3;
            } else {
                DfuBaseService dfuBaseService = DfuBaseService.this;
                dfuBaseService.loge("Service discovery error: " + i);
                int unused = DfuBaseService.this.mError = i | 16384;
            }
            synchronized (DfuBaseService.this.mLock) {
                DfuBaseService.this.mLock.notifyAll();
            }
        }
    };
    private InputStream mInitFileInputStream;
    private long mLastNotificationTime;
    private int mLastProgress = -1;
    /* access modifiers changed from: private */
    public final Object mLock = new Object();
    DfuProgressInfo mProgressInfo;

    public DfuBaseService() {
        super(TAG);
    }

    private boolean initialize() {
        BluetoothManager bluetoothManager = (BluetoothManager) getSystemService("bluetooth");
        if (bluetoothManager == null) {
            loge("Unable to initialize BluetoothManager.");
            return false;
        }
        BluetoothAdapter adapter = bluetoothManager.getAdapter();
        this.mBluetoothAdapter = adapter;
        if (adapter != null) {
            return true;
        }
        loge("Unable to obtain a BluetoothAdapter.");
        return false;
    }

    /* access modifiers changed from: private */
    public void loge(String str) {
        Log.e(TAG, str);
    }

    /* access modifiers changed from: private */
    public void logi(String str) {
        if (DEBUG) {
            Log.i(TAG, str);
        }
    }

    /* access modifiers changed from: private */
    public void logw(String str) {
        if (DEBUG) {
            Log.w(TAG, str);
        }
    }

    private static IntentFilter makeDfuActionIntentFilter() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BROADCAST_ACTION);
        return intentFilter;
    }

    private InputStream openInputStream(@NonNull String str, String str2, int i, int i2) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(str);
        if ("application/zip".equals(str2)) {
            return new ArchiveInputStream(fileInputStream, i, i2);
        }
        return str.toLowerCase(Locale.US).endsWith("hex") ? new HexInputStream((InputStream) fileInputStream, i) : fileInputStream;
    }

    private void sendErrorBroadcast(int i) {
        Intent intent = new Intent(BROADCAST_ERROR);
        if ((i & 16384) > 0) {
            intent.putExtra(EXTRA_DATA, i & -16385);
            intent.putExtra(EXTRA_ERROR_TYPE, 2);
        } else if ((32768 & i) > 0) {
            intent.putExtra(EXTRA_DATA, i & -32769);
            intent.putExtra(EXTRA_ERROR_TYPE, 1);
        } else if ((i & 8192) > 0) {
            intent.putExtra(EXTRA_DATA, i & -8193);
            intent.putExtra(EXTRA_ERROR_TYPE, 3);
        } else {
            intent.putExtra(EXTRA_DATA, i);
            intent.putExtra(EXTRA_ERROR_TYPE, 0);
        }
        intent.putExtra(EXTRA_DEVICE_ADDRESS, this.mDeviceAddress);
        LocalBroadcastManager.b(this).d(intent);
    }

    private void sendProgressBroadcast(DfuProgressInfo dfuProgressInfo) {
        Intent intent = new Intent(BROADCAST_PROGRESS);
        intent.putExtra(EXTRA_DATA, dfuProgressInfo.getProgress());
        intent.putExtra(EXTRA_DEVICE_ADDRESS, this.mDeviceAddress);
        intent.putExtra(EXTRA_PART_CURRENT, dfuProgressInfo.getCurrentPart());
        intent.putExtra(EXTRA_PARTS_TOTAL, dfuProgressInfo.getTotalParts());
        intent.putExtra(EXTRA_SPEED_B_PER_MS, dfuProgressInfo.getSpeed());
        intent.putExtra(EXTRA_AVG_SPEED_B_PER_MS, dfuProgressInfo.getAverageSpeed());
        LocalBroadcastManager.b(this).d(intent);
    }

    private void startForeground() {
        int i = Build.VERSION.SDK_INT;
        NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_DFU, NOTIFICATION_CHANNEL_DFU, 0);
        notificationChannel.setLightColor(-16776961);
        notificationChannel.setLockscreenVisibility(0);
        ((NotificationManager) getSystemService("notification")).createNotificationChannel(notificationChannel);
        NotificationCompat.Builder A = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_DFU).H(17301640).n(getString(R.string.dfu_status_foreground_title)).m(getString(R.string.dfu_status_foreground_content)).j(-7829368).C(-1).A(true);
        Class<? extends Activity> notificationTarget = getNotificationTarget();
        if (notificationTarget != null) {
            Intent intent = new Intent(this, notificationTarget);
            intent.addFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
            intent.putExtra(EXTRA_DEVICE_ADDRESS, this.mDeviceAddress);
            intent.putExtra(EXTRA_DEVICE_NAME, this.mDeviceName);
            A.l(PendingIntent.getActivity(this, 0, intent, i >= 31 ? CaptureType.CAPTURE_TYPE_ICCOA : CaptureType.CAPTURE_VIRTUAL_DISPLAY_ENABLE_MAGIC_WINDOW));
        } else {
            logw("getNotificationTarget() should not return null if the service is to be started as a foreground service");
        }
        updateForegroundNotification(A);
        if (i >= 34) {
            startForeground(NOTIFICATION_ID, A.c(), 16);
        } else {
            startForeground(NOTIFICATION_ID, A.c());
        }
    }

    public void close(@NonNull BluetoothGatt bluetoothGatt) {
        logi("Cleaning up...");
        sendLogBroadcast(0, "gatt.close()");
        bluetoothGatt.close();
        this.mConnectionState = -5;
    }

    public BluetoothGatt connect(@NonNull String str) {
        if (!this.mBluetoothAdapter.isEnabled()) {
            return null;
        }
        this.mConnectionState = -1;
        logi("Connecting to the device...");
        BluetoothDevice remoteDevice = this.mBluetoothAdapter.getRemoteDevice(str);
        sendLogBroadcast(0, "gatt = device.connectGatt(autoConnect = false)");
        BluetoothGatt connectGatt = remoteDevice.connectGatt(this, false, this.mGattCallback);
        try {
            synchronized (this.mLock) {
                while (true) {
                    int i = this.mConnectionState;
                    if ((i == -1 || i == -2) && this.mError == 0) {
                        this.mLock.wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        } catch (Throwable th) {
            throw th;
        }
        return connectGatt;
    }

    public void disconnect(@NonNull BluetoothGatt bluetoothGatt) {
        if (this.mConnectionState != 0) {
            sendLogBroadcast(1, "Disconnecting...");
            this.mProgressInfo.setProgress(-5);
            this.mConnectionState = -4;
            logi("Disconnecting from the device...");
            sendLogBroadcast(0, "gatt.disconnect()");
            bluetoothGatt.disconnect();
            waitUntilDisconnected();
            sendLogBroadcast(5, "Disconnected");
        }
    }

    @Nullable
    public abstract Class<? extends Activity> getNotificationTarget();

    public boolean isDebug() {
        return false;
    }

    public void onCreate() {
        super.onCreate();
        DEBUG = isDebug();
        initialize();
        LocalBroadcastManager b = LocalBroadcastManager.b(this);
        IntentFilter makeDfuActionIntentFilter = makeDfuActionIntentFilter();
        b.c(this.mDfuActionReceiver, makeDfuActionIntentFilter);
        if (Build.VERSION.SDK_INT >= 34) {
            registerReceiver(this.mDfuActionReceiver, makeDfuActionIntentFilter, 4);
        } else {
            registerReceiver(this.mDfuActionReceiver, makeDfuActionIntentFilter);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
        intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECT_REQUESTED");
        intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        registerReceiver(this.mConnectionStateBroadcastReceiver, intentFilter);
        registerReceiver(this.mBondStateBroadcastReceiver, new IntentFilter("android.bluetooth.device.action.BOND_STATE_CHANGED"));
        registerReceiver(this.mBluetoothStateBroadcastReceiver, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
    }

    public void onDestroy() {
        super.onDestroy();
        DfuCallback dfuCallback = this.mDfuServiceImpl;
        if (dfuCallback != null) {
            dfuCallback.abort();
        }
        LocalBroadcastManager.b(this).e(this.mDfuActionReceiver);
        unregisterReceiver(this.mDfuActionReceiver);
        unregisterReceiver(this.mConnectionStateBroadcastReceiver);
        unregisterReceiver(this.mBondStateBroadcastReceiver);
        unregisterReceiver(this.mBluetoothStateBroadcastReceiver);
        try {
            InputStream inputStream = this.mFirmwareInputStream;
            if (inputStream != null) {
                inputStream.close();
            }
            InputStream inputStream2 = this.mInitFileInputStream;
            if (inputStream2 != null) {
                inputStream2.close();
            }
        } catch (IOException unused) {
        } catch (Throwable th) {
            this.mFirmwareInputStream = null;
            this.mInitFileInputStream = null;
            throw th;
        }
        this.mFirmwareInputStream = null;
        this.mInitFileInputStream = null;
        logi("DFU service destroyed");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:213:0x03dd, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x03de, code lost:
        r3 = r0;
        r2 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x03ed, code lost:
        r2 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x03ff, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x0400, code lost:
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x0402, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x0403, code lost:
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:0x040a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:0x040b, code lost:
        r14 = 20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x040d, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x040e, code lost:
        r14 = 20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:0x0424, code lost:
        r4 = r4 & -32769;
        sendLogBroadcast(r14, java.lang.String.format(java.util.Locale.US, "Error (0x%02X): %s", new java.lang.Object[]{java.lang.Integer.valueOf(r4), no.nordicsemi.android.error.GattError.parseConnectionError(r4)}));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:248:0x043e, code lost:
        r4 = r4 & -16385;
        sendLogBroadcast(r14, java.lang.String.format(java.util.Locale.US, "Error (0x%02X): %s", new java.lang.Object[]{java.lang.Integer.valueOf(r4), no.nordicsemi.android.error.GattError.parse(r4)}));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:0x0465, code lost:
        if (r2 != null) goto L_0x0467;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:252:?, code lost:
        r2.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:257:0x048a, code lost:
        r5 = new java.lang.StringBuilder();
        r5.append("Restarting the service (");
        r3 = r3 + 1;
        r5.append(r3);
        r5.append(" /");
        r5.append(r4);
        r5.append(")");
        logi(r5.toString());
        r4 = new android.content.Intent();
        r4.fillIn(r8, 24);
        r4.putExtra(EXTRA_DFU_ATTEMPT, r3);
        startService(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:258:0x04bf, code lost:
        if (r2 != null) goto L_0x04c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:260:?, code lost:
        r2.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:261:0x04c4, code lost:
        if (r12 != false) goto L_0x04c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:262:0x04c6, code lost:
        stopForeground(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:265:?, code lost:
        report(4096);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:266:0x04cf, code lost:
        if (r2 != null) goto L_0x04d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:270:0x04e3, code lost:
        if (r2 != null) goto L_0x0467;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:331:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:332:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0102, code lost:
        if (r2 < 0) goto L_0x0111;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x010f, code lost:
        if (r2 < 0) goto L_0x0111;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x021c A[Catch:{ SecurityException -> 0x0150, FileNotFoundException -> 0x014a, SizeValidationException -> 0x0144, IOException -> 0x013e, Exception -> 0x0138 }] */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0238  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x024e A[SYNTHETIC, Splitter:B:145:0x024e] */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x0261  */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x03dd A[ExcHandler: all (r0v12 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:202:0x03bb] */
    /* JADX WARNING: Removed duplicated region for block: B:222:? A[ExcHandler: UploadAbortedException (unused no.nordicsemi.android.dfu.internal.exception.UploadAbortedException), SYNTHETIC, Splitter:B:202:0x03bb] */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x0424 A[Catch:{ all -> 0x0410 }] */
    /* JADX WARNING: Removed duplicated region for block: B:248:0x043e A[Catch:{ all -> 0x0410 }] */
    /* JADX WARNING: Removed duplicated region for block: B:257:0x048a A[Catch:{ all -> 0x0410 }] */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x04ca  */
    /* JADX WARNING: Removed duplicated region for block: B:272:0x04e8  */
    /* JADX WARNING: Removed duplicated region for block: B:274:0x04ee A[SYNTHETIC, Splitter:B:274:0x04ee] */
    /* JADX WARNING: Removed duplicated region for block: B:289:0x0530  */
    /* JADX WARNING: Removed duplicated region for block: B:294:0x0558  */
    /* JADX WARNING: Removed duplicated region for block: B:299:0x056d  */
    /* JADX WARNING: Removed duplicated region for block: B:304:0x0582  */
    /* JADX WARNING: Removed duplicated region for block: B:309:0x0597  */
    /* JADX WARNING: Removed duplicated region for block: B:334:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:336:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:338:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:340:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:342:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:344:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onHandleIntent(android.content.Intent r25) {
        /*
            r24 = this;
            r1 = r24
            r8 = r25
            java.lang.String r2 = "Bluetooth adapter disabled"
            java.lang.String r3 = "no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_ADDRESS"
            java.lang.String r3 = r8.getStringExtra(r3)
            java.lang.String r4 = "no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_NAME"
            java.lang.String r4 = r8.getStringExtra(r4)
            java.lang.String r5 = "no.nordicsemi.android.dfu.extra.EXTRA_DISABLE_NOTIFICATION"
            r9 = 0
            boolean r10 = r8.getBooleanExtra(r5, r9)
            java.lang.String r5 = "no.nordicsemi.android.dfu.extra.EXTRA_FOREGROUND_SERVICE"
            r11 = 1
            boolean r12 = r8.getBooleanExtra(r5, r11)
            java.lang.String r5 = "no.nordicsemi.android.dfu.extra.EXTRA_FILE_PATH"
            java.lang.String r5 = r8.getStringExtra(r5)
            java.lang.String r6 = "no.nordicsemi.android.dfu.extra.EXTRA_FILE_URI"
            android.os.Parcelable r6 = r8.getParcelableExtra(r6)
            android.net.Uri r6 = (android.net.Uri) r6
            java.lang.String r7 = "no.nordicsemi.android.dfu.extra.EXTRA_FILE_RES_ID"
            int r7 = r8.getIntExtra(r7, r9)
            java.lang.String r13 = "no.nordicsemi.android.dfu.extra.EXTRA_INIT_FILE_PATH"
            java.lang.String r13 = r8.getStringExtra(r13)
            java.lang.String r14 = "no.nordicsemi.android.dfu.extra.EXTRA_INIT_FILE_URI"
            android.os.Parcelable r14 = r8.getParcelableExtra(r14)
            android.net.Uri r14 = (android.net.Uri) r14
            java.lang.String r15 = "no.nordicsemi.android.dfu.extra.EXTRA_INIT_FILE_RES_ID"
            int r15 = r8.getIntExtra(r15, r9)
            java.lang.String r11 = "no.nordicsemi.android.dfu.extra.EXTRA_FILE_TYPE"
            int r11 = r8.getIntExtra(r11, r9)
            if (r5 == 0) goto L_0x0063
            if (r11 != 0) goto L_0x0063
            java.util.Locale r11 = java.util.Locale.US
            java.lang.String r11 = r5.toLowerCase(r11)
            java.lang.String r9 = "zip"
            boolean r9 = r11.endsWith(r9)
            if (r9 == 0) goto L_0x0062
            r11 = 0
            goto L_0x0063
        L_0x0062:
            r11 = 4
        L_0x0063:
            java.lang.String r9 = "no.nordicsemi.android.dfu.extra.EXTRA_MIME_TYPE"
            java.lang.String r9 = r8.getStringExtra(r9)
            r17 = r2
            java.lang.String r2 = "application/octet-stream"
            r18 = r15
            java.lang.String r15 = "application/zip"
            if (r9 == 0) goto L_0x0074
            goto L_0x0079
        L_0x0074:
            if (r11 != 0) goto L_0x0078
            r9 = r15
            goto L_0x0079
        L_0x0078:
            r9 = r2
        L_0x0079:
            if (r3 == 0) goto L_0x05b3
            if (r5 != 0) goto L_0x0083
            if (r6 != 0) goto L_0x0083
            if (r7 != 0) goto L_0x0083
            goto L_0x05b3
        L_0x0083:
            r19 = r11 & -8
            r20 = r13
            if (r19 > 0) goto L_0x05a1
            boolean r19 = r15.equals(r9)
            if (r19 != 0) goto L_0x0097
            boolean r19 = r2.equals(r9)
            if (r19 != 0) goto L_0x0097
            goto L_0x05a1
        L_0x0097:
            boolean r2 = r2.equals(r9)
            r13 = 2
            if (r2 == 0) goto L_0x00b6
            r2 = 1
            if (r11 == r2) goto L_0x00b6
            if (r11 == r13) goto L_0x00b6
            r2 = 4
            if (r11 == r2) goto L_0x00b6
            java.lang.String r2 = "Unable to determine file type"
            r1.logw(r2)
            r3 = 15
            r1.sendLogBroadcast(r3, r2)
            r2 = 4105(0x1009, float:5.752E-42)
            r1.report(r2)
            return
        L_0x00b6:
            if (r10 != 0) goto L_0x00c7
            java.lang.Class r2 = r24.getNotificationTarget()
            if (r2 == 0) goto L_0x00bf
            goto L_0x00c7
        L_0x00bf:
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "getNotificationTarget() must not return null if notifications are enabled"
            r1.<init>(r2)
            throw r1
        L_0x00c7:
            if (r12 != 0) goto L_0x00ce
            java.lang.String r2 = "Foreground service disabled. Android Oreo or newer may kill a background service few moments after user closes the application.\nConsider enabling foreground service using DfuServiceInitiator#setForeground(boolean)"
            r1.logw(r2)
        L_0x00ce:
            no.nordicsemi.android.dfu.UuidHelper.assignCustomUuids(r25)
            if (r12 == 0) goto L_0x00db
            java.lang.String r2 = "Starting DFU service in foreground"
            r1.logi(r2)
            r24.startForeground()
        L_0x00db:
            r1.mDeviceAddress = r3
            r1.mDeviceName = r4
            r1.mDisableNotification = r10
            r2 = 0
            r1.mConnectionState = r2
            r1.mError = r2
            android.content.SharedPreferences r2 = android.preference.PreferenceManager.getDefaultSharedPreferences(r24)
            java.lang.String r4 = "settings_mbr_size"
            boolean r21 = r2.contains(r4)
            r13 = 4096(0x1000, float:5.74E-42)
            if (r21 == 0) goto L_0x0107
            r21 = r3
            java.lang.String r3 = java.lang.String.valueOf(r13)
            java.lang.String r2 = r2.getString(r4, r3)
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ NumberFormatException -> 0x0105 }
            if (r2 >= 0) goto L_0x0112
            goto L_0x0111
        L_0x0105:
            r2 = r13
            goto L_0x0112
        L_0x0107:
            r21 = r3
            java.lang.String r2 = "no.nordicsemi.android.dfu.extra.EXTRA_MBR_SIZE"
            int r2 = r8.getIntExtra(r2, r13)
            if (r2 >= 0) goto L_0x0112
        L_0x0111:
            r2 = 0
        L_0x0112:
            java.lang.String r3 = "DFU service started"
            r4 = 1
            r1.sendLogBroadcast(r4, r3)
            java.io.InputStream r3 = r1.mFirmwareInputStream
            java.io.InputStream r13 = r1.mInitFileInputStream
            if (r3 != 0) goto L_0x0121
            r22 = r4
            goto L_0x0123
        L_0x0121:
            r22 = 0
        L_0x0123:
            if (r22 == 0) goto L_0x0199
            java.lang.String r4 = "Opening file..."
            r23 = r3
            r3 = 1
            r1.sendLogBroadcast(r3, r4)     // Catch:{ SecurityException -> 0x0150, FileNotFoundException -> 0x014a, SizeValidationException -> 0x0144, IOException -> 0x013e, Exception -> 0x0138 }
            if (r6 == 0) goto L_0x0156
            java.io.InputStream r3 = r1.openInputStream((android.net.Uri) r6, (java.lang.String) r9, (int) r2, (int) r11)     // Catch:{ SecurityException -> 0x0150, FileNotFoundException -> 0x014a, SizeValidationException -> 0x0144, IOException -> 0x013e, Exception -> 0x0138 }
            goto L_0x0166
        L_0x0134:
            r0 = move-exception
            r2 = r0
            goto L_0x059b
        L_0x0138:
            r0 = move-exception
            r2 = r0
            r14 = 20
            goto L_0x050c
        L_0x013e:
            r0 = move-exception
            r2 = r0
            r14 = 20
            goto L_0x0534
        L_0x0144:
            r0 = move-exception
            r2 = r0
            r14 = 20
            goto L_0x055c
        L_0x014a:
            r0 = move-exception
            r2 = r0
            r14 = 20
            goto L_0x0571
        L_0x0150:
            r0 = move-exception
            r2 = r0
            r14 = 20
            goto L_0x0586
        L_0x0156:
            if (r5 == 0) goto L_0x015d
            java.io.InputStream r3 = r1.openInputStream((java.lang.String) r5, (java.lang.String) r9, (int) r2, (int) r11)     // Catch:{ SecurityException -> 0x0150, FileNotFoundException -> 0x014a, SizeValidationException -> 0x0144, IOException -> 0x013e, Exception -> 0x0138 }
            goto L_0x0166
        L_0x015d:
            if (r7 <= 0) goto L_0x0164
            java.io.InputStream r3 = r1.openInputStream((int) r7, (java.lang.String) r9, (int) r2, (int) r11)     // Catch:{ SecurityException -> 0x0150, FileNotFoundException -> 0x014a, SizeValidationException -> 0x0144, IOException -> 0x013e, Exception -> 0x0138 }
            goto L_0x0166
        L_0x0164:
            r3 = r23
        L_0x0166:
            if (r14 == 0) goto L_0x0171
            android.content.ContentResolver r2 = r24.getContentResolver()     // Catch:{ SecurityException -> 0x0150, FileNotFoundException -> 0x014a, SizeValidationException -> 0x0144, IOException -> 0x013e, Exception -> 0x0138 }
            java.io.InputStream r13 = r2.openInputStream(r14)     // Catch:{ SecurityException -> 0x0150, FileNotFoundException -> 0x014a, SizeValidationException -> 0x0144, IOException -> 0x013e, Exception -> 0x0138 }
            goto L_0x0187
        L_0x0171:
            if (r20 == 0) goto L_0x017b
            java.io.FileInputStream r13 = new java.io.FileInputStream     // Catch:{ SecurityException -> 0x0150, FileNotFoundException -> 0x014a, SizeValidationException -> 0x0144, IOException -> 0x013e, Exception -> 0x0138 }
            r2 = r20
            r13.<init>(r2)     // Catch:{ SecurityException -> 0x0150, FileNotFoundException -> 0x014a, SizeValidationException -> 0x0144, IOException -> 0x013e, Exception -> 0x0138 }
            goto L_0x0187
        L_0x017b:
            if (r18 <= 0) goto L_0x0187
            android.content.res.Resources r2 = r24.getResources()     // Catch:{ SecurityException -> 0x0150, FileNotFoundException -> 0x014a, SizeValidationException -> 0x0144, IOException -> 0x013e, Exception -> 0x0138 }
            r4 = r18
            java.io.InputStream r13 = r2.openRawResource(r4)     // Catch:{ SecurityException -> 0x0150, FileNotFoundException -> 0x014a, SizeValidationException -> 0x0144, IOException -> 0x013e, Exception -> 0x0138 }
        L_0x0187:
            int r2 = r3.available()     // Catch:{ SecurityException -> 0x0150, FileNotFoundException -> 0x014a, SizeValidationException -> 0x0144, IOException -> 0x013e, Exception -> 0x0138 }
            r4 = 4
            int r2 = r2 % r4
            if (r2 != 0) goto L_0x0191
            r6 = r3
            goto L_0x019d
        L_0x0191:
            no.nordicsemi.android.dfu.internal.exception.SizeValidationException r2 = new no.nordicsemi.android.dfu.internal.exception.SizeValidationException     // Catch:{ SecurityException -> 0x0150, FileNotFoundException -> 0x014a, SizeValidationException -> 0x0144, IOException -> 0x013e, Exception -> 0x0138 }
            java.lang.String r3 = "The new firmware is not word-aligned."
            r2.<init>(r3)     // Catch:{ SecurityException -> 0x0150, FileNotFoundException -> 0x014a, SizeValidationException -> 0x0144, IOException -> 0x013e, Exception -> 0x0138 }
            throw r2     // Catch:{ SecurityException -> 0x0150, FileNotFoundException -> 0x014a, SizeValidationException -> 0x0144, IOException -> 0x013e, Exception -> 0x0138 }
        L_0x0199:
            r23 = r3
            r6 = r23
        L_0x019d:
            boolean r2 = r15.equals(r9)     // Catch:{ SecurityException -> 0x0506, FileNotFoundException -> 0x0501, SizeValidationException -> 0x04fc, IOException -> 0x04f7, Exception -> 0x04f2 }
            if (r2 == 0) goto L_0x0218
            r2 = r6
            no.nordicsemi.android.dfu.internal.ArchiveInputStream r2 = (no.nordicsemi.android.dfu.internal.ArchiveInputStream) r2     // Catch:{ SecurityException -> 0x0150, FileNotFoundException -> 0x014a, SizeValidationException -> 0x0144, IOException -> 0x013e, Exception -> 0x0138 }
            if (r11 != 0) goto L_0x01ad
            int r3 = r2.getContentType()     // Catch:{ SecurityException -> 0x0150, FileNotFoundException -> 0x014a, SizeValidationException -> 0x0144, IOException -> 0x013e, Exception -> 0x0138 }
            goto L_0x01b1
        L_0x01ad:
            int r3 = r2.setContentType(r11)     // Catch:{ SecurityException -> 0x0150, FileNotFoundException -> 0x014a, SizeValidationException -> 0x0144, IOException -> 0x013e, Exception -> 0x0138 }
        L_0x01b1:
            r4 = r3 & 4
            if (r4 <= 0) goto L_0x01c6
            int r4 = r2.applicationImageSize()     // Catch:{ SecurityException -> 0x0150, FileNotFoundException -> 0x014a, SizeValidationException -> 0x0144, IOException -> 0x013e, Exception -> 0x0138 }
            r5 = 4
            int r4 = r4 % r5
            if (r4 != 0) goto L_0x01be
            goto L_0x01c6
        L_0x01be:
            no.nordicsemi.android.dfu.internal.exception.SizeValidationException r2 = new no.nordicsemi.android.dfu.internal.exception.SizeValidationException     // Catch:{ SecurityException -> 0x0150, FileNotFoundException -> 0x014a, SizeValidationException -> 0x0144, IOException -> 0x013e, Exception -> 0x0138 }
            java.lang.String r3 = "Application firmware is not word-aligned."
            r2.<init>(r3)     // Catch:{ SecurityException -> 0x0150, FileNotFoundException -> 0x014a, SizeValidationException -> 0x0144, IOException -> 0x013e, Exception -> 0x0138 }
            throw r2     // Catch:{ SecurityException -> 0x0150, FileNotFoundException -> 0x014a, SizeValidationException -> 0x0144, IOException -> 0x013e, Exception -> 0x0138 }
        L_0x01c6:
            r4 = r3 & 2
            if (r4 <= 0) goto L_0x01db
            int r4 = r2.bootloaderImageSize()     // Catch:{ SecurityException -> 0x0150, FileNotFoundException -> 0x014a, SizeValidationException -> 0x0144, IOException -> 0x013e, Exception -> 0x0138 }
            r5 = 4
            int r4 = r4 % r5
            if (r4 != 0) goto L_0x01d3
            goto L_0x01db
        L_0x01d3:
            no.nordicsemi.android.dfu.internal.exception.SizeValidationException r2 = new no.nordicsemi.android.dfu.internal.exception.SizeValidationException     // Catch:{ SecurityException -> 0x0150, FileNotFoundException -> 0x014a, SizeValidationException -> 0x0144, IOException -> 0x013e, Exception -> 0x0138 }
            java.lang.String r3 = "Bootloader firmware is not word-aligned."
            r2.<init>(r3)     // Catch:{ SecurityException -> 0x0150, FileNotFoundException -> 0x014a, SizeValidationException -> 0x0144, IOException -> 0x013e, Exception -> 0x0138 }
            throw r2     // Catch:{ SecurityException -> 0x0150, FileNotFoundException -> 0x014a, SizeValidationException -> 0x0144, IOException -> 0x013e, Exception -> 0x0138 }
        L_0x01db:
            r4 = r3 & 1
            if (r4 <= 0) goto L_0x01e7
            int r4 = r2.softDeviceImageSize()     // Catch:{ SecurityException -> 0x0150, FileNotFoundException -> 0x014a, SizeValidationException -> 0x0144, IOException -> 0x013e, Exception -> 0x0138 }
            r5 = 4
            int r4 = r4 % r5
            if (r4 != 0) goto L_0x01e9
        L_0x01e7:
            r4 = 4
            goto L_0x01f1
        L_0x01e9:
            no.nordicsemi.android.dfu.internal.exception.SizeValidationException r2 = new no.nordicsemi.android.dfu.internal.exception.SizeValidationException     // Catch:{ SecurityException -> 0x0150, FileNotFoundException -> 0x014a, SizeValidationException -> 0x0144, IOException -> 0x013e, Exception -> 0x0138 }
            java.lang.String r3 = "Soft Device firmware is not word-aligned."
            r2.<init>(r3)     // Catch:{ SecurityException -> 0x0150, FileNotFoundException -> 0x014a, SizeValidationException -> 0x0144, IOException -> 0x013e, Exception -> 0x0138 }
            throw r2     // Catch:{ SecurityException -> 0x0150, FileNotFoundException -> 0x014a, SizeValidationException -> 0x0144, IOException -> 0x013e, Exception -> 0x0138 }
        L_0x01f1:
            if (r3 != r4) goto L_0x0205
            byte[] r4 = r2.getApplicationInit()     // Catch:{ SecurityException -> 0x0150, FileNotFoundException -> 0x014a, SizeValidationException -> 0x0144, IOException -> 0x013e, Exception -> 0x0138 }
            if (r4 == 0) goto L_0x0215
            java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream     // Catch:{ SecurityException -> 0x0150, FileNotFoundException -> 0x014a, SizeValidationException -> 0x0144, IOException -> 0x013e, Exception -> 0x0138 }
            byte[] r2 = r2.getApplicationInit()     // Catch:{ SecurityException -> 0x0150, FileNotFoundException -> 0x014a, SizeValidationException -> 0x0144, IOException -> 0x013e, Exception -> 0x0138 }
            r4.<init>(r2)     // Catch:{ SecurityException -> 0x0150, FileNotFoundException -> 0x014a, SizeValidationException -> 0x0144, IOException -> 0x013e, Exception -> 0x0138 }
        L_0x0202:
            r5 = r3
            r7 = r4
            goto L_0x021a
        L_0x0205:
            byte[] r4 = r2.getSystemInit()     // Catch:{ SecurityException -> 0x0150, FileNotFoundException -> 0x014a, SizeValidationException -> 0x0144, IOException -> 0x013e, Exception -> 0x0138 }
            if (r4 == 0) goto L_0x0215
            java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream     // Catch:{ SecurityException -> 0x0150, FileNotFoundException -> 0x014a, SizeValidationException -> 0x0144, IOException -> 0x013e, Exception -> 0x0138 }
            byte[] r2 = r2.getSystemInit()     // Catch:{ SecurityException -> 0x0150, FileNotFoundException -> 0x014a, SizeValidationException -> 0x0144, IOException -> 0x013e, Exception -> 0x0138 }
            r4.<init>(r2)     // Catch:{ SecurityException -> 0x0150, FileNotFoundException -> 0x014a, SizeValidationException -> 0x0144, IOException -> 0x013e, Exception -> 0x0138 }
            goto L_0x0202
        L_0x0215:
            r5 = r3
        L_0x0216:
            r7 = r13
            goto L_0x021a
        L_0x0218:
            r5 = r11
            goto L_0x0216
        L_0x021a:
            if (r22 == 0) goto L_0x022c
            int r2 = r6.available()     // Catch:{ SecurityException -> 0x0150, FileNotFoundException -> 0x014a, SizeValidationException -> 0x0144, IOException -> 0x013e, Exception -> 0x0138 }
            r6.mark(r2)     // Catch:{ SecurityException -> 0x0150, FileNotFoundException -> 0x014a, SizeValidationException -> 0x0144, IOException -> 0x013e, Exception -> 0x0138 }
            if (r7 == 0) goto L_0x022c
            int r2 = r7.available()     // Catch:{ SecurityException -> 0x0150, FileNotFoundException -> 0x014a, SizeValidationException -> 0x0144, IOException -> 0x013e, Exception -> 0x0138 }
            r7.mark(r2)     // Catch:{ SecurityException -> 0x0150, FileNotFoundException -> 0x014a, SizeValidationException -> 0x0144, IOException -> 0x013e, Exception -> 0x0138 }
        L_0x022c:
            r1.mFirmwareInputStream = r6     // Catch:{ SecurityException -> 0x0506, FileNotFoundException -> 0x0501, SizeValidationException -> 0x04fc, IOException -> 0x04f7, Exception -> 0x04f2 }
            r1.mInitFileInputStream = r7     // Catch:{ SecurityException -> 0x0506, FileNotFoundException -> 0x0501, SizeValidationException -> 0x04fc, IOException -> 0x04f7, Exception -> 0x04f2 }
            java.lang.String r2 = "Firmware file opened successfully"
            r3 = 5
            r1.sendLogBroadcast(r3, r2)     // Catch:{ SecurityException -> 0x0506, FileNotFoundException -> 0x0501, SizeValidationException -> 0x04fc, IOException -> 0x04f7, Exception -> 0x04f2 }
            if (r22 != 0) goto L_0x0240
            r13 = 1000(0x3e8, double:4.94E-321)
            r1.waitFor(r13)     // Catch:{ all -> 0x0134 }
            r1.waitFor(r13)     // Catch:{ all -> 0x0134 }
        L_0x0240:
            no.nordicsemi.android.dfu.DfuProgressInfo r2 = new no.nordicsemi.android.dfu.DfuProgressInfo     // Catch:{ all -> 0x0134 }
            r2.<init>(r1)     // Catch:{ all -> 0x0134 }
            r1.mProgressInfo = r2     // Catch:{ all -> 0x0134 }
            boolean r2 = r1.mAborted     // Catch:{ all -> 0x0134 }
            r9 = -7
            java.lang.String r11 = "Upload aborted"
            if (r2 == 0) goto L_0x0261
            r1.logw(r11)     // Catch:{ all -> 0x0134 }
            r2 = 15
            r1.sendLogBroadcast(r2, r11)     // Catch:{ all -> 0x0134 }
            no.nordicsemi.android.dfu.DfuProgressInfo r2 = r1.mProgressInfo     // Catch:{ all -> 0x0134 }
            r2.setProgress(r9)     // Catch:{ all -> 0x0134 }
            if (r12 == 0) goto L_0x0260
            r1.stopForeground(r10)
        L_0x0260:
            return
        L_0x0261:
            java.lang.String r2 = "Connecting to DFU target..."
            r4 = 1
            r1.sendLogBroadcast(r4, r2)     // Catch:{ all -> 0x0134 }
            no.nordicsemi.android.dfu.DfuProgressInfo r2 = r1.mProgressInfo     // Catch:{ all -> 0x0134 }
            r4 = -1
            r2.setProgress(r4)     // Catch:{ all -> 0x0134 }
            long r13 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0134 }
            r2 = r21
            android.bluetooth.BluetoothGatt r15 = r1.connect(r2)     // Catch:{ all -> 0x0134 }
            long r20 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0134 }
            if (r15 != 0) goto L_0x0292
            r4 = r17
            r1.loge(r4)     // Catch:{ all -> 0x0134 }
            r2 = 20
            r1.sendLogBroadcast(r2, r4)     // Catch:{ all -> 0x0134 }
            r2 = 4106(0x100a, float:5.754E-42)
            r1.report(r2)     // Catch:{ all -> 0x0134 }
            if (r12 == 0) goto L_0x0291
            r1.stopForeground(r10)
        L_0x0291:
            return
        L_0x0292:
            int r4 = r1.mError     // Catch:{ all -> 0x0134 }
            r16 = -32769(0xffffffffffff7fff, float:NaN)
            r17 = 32768(0x8000, float:4.5918E-41)
            java.lang.String r3 = "no.nordicsemi.android.dfu.extra.EXTRA_RECONNECTION_ATTEMPT"
            if (r4 <= 0) goto L_0x0372
            r5 = r4 & r17
            java.lang.String r6 = "Connection failed (0x%02X): %s"
            if (r5 <= 0) goto L_0x0300
            r4 = r4 & r16
            r5 = 133(0x85, float:1.86E-43)
            if (r4 != r5) goto L_0x02d3
            r16 = 25000(0x61a8, double:1.23516E-319)
            long r13 = r13 + r16
            int r5 = (r20 > r13 ? 1 : (r20 == r13 ? 0 : -1))
            if (r5 <= 0) goto L_0x02d3
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0134 }
            r4.<init>()     // Catch:{ all -> 0x0134 }
            java.lang.String r5 = "Device not reachable. Check if the device with address "
            r4.append(r5)     // Catch:{ all -> 0x0134 }
            r4.append(r2)     // Catch:{ all -> 0x0134 }
            java.lang.String r2 = " is in range, is advertising and is connectable"
            r4.append(r2)     // Catch:{ all -> 0x0134 }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x0134 }
            r1.loge(r2)     // Catch:{ all -> 0x0134 }
            java.lang.String r2 = "Error 133: Connection timeout"
            r4 = 20
            r1.sendLogBroadcast(r4, r2)     // Catch:{ all -> 0x0134 }
            goto L_0x02fe
        L_0x02d3:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0134 }
            r2.<init>()     // Catch:{ all -> 0x0134 }
            java.lang.String r5 = "An error occurred while connecting to the device:"
            r2.append(r5)     // Catch:{ all -> 0x0134 }
            r2.append(r4)     // Catch:{ all -> 0x0134 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0134 }
            r1.loge(r2)     // Catch:{ all -> 0x0134 }
            java.util.Locale r2 = java.util.Locale.US     // Catch:{ all -> 0x0134 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0134 }
            java.lang.String r4 = no.nordicsemi.android.error.GattError.parseConnectionError(r4)     // Catch:{ all -> 0x0134 }
            java.lang.Object[] r4 = new java.lang.Object[]{r5, r4}     // Catch:{ all -> 0x0134 }
            java.lang.String r2 = java.lang.String.format(r2, r6, r4)     // Catch:{ all -> 0x0134 }
            r4 = 20
            r1.sendLogBroadcast(r4, r2)     // Catch:{ all -> 0x0134 }
        L_0x02fe:
            r2 = 0
            goto L_0x032e
        L_0x0300:
            r2 = r4 & -16385(0xffffffffffffbfff, float:NaN)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0134 }
            r4.<init>()     // Catch:{ all -> 0x0134 }
            java.lang.String r5 = "An error occurred during discovering services:"
            r4.append(r5)     // Catch:{ all -> 0x0134 }
            r4.append(r2)     // Catch:{ all -> 0x0134 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0134 }
            r1.loge(r4)     // Catch:{ all -> 0x0134 }
            java.util.Locale r4 = java.util.Locale.US     // Catch:{ all -> 0x0134 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0134 }
            java.lang.String r2 = no.nordicsemi.android.error.GattError.parse(r2)     // Catch:{ all -> 0x0134 }
            java.lang.Object[] r2 = new java.lang.Object[]{r5, r2}     // Catch:{ all -> 0x0134 }
            java.lang.String r2 = java.lang.String.format(r4, r6, r2)     // Catch:{ all -> 0x0134 }
            r4 = 20
            r1.sendLogBroadcast(r4, r2)     // Catch:{ all -> 0x0134 }
            goto L_0x02fe
        L_0x032e:
            int r2 = r8.getIntExtra(r3, r2)     // Catch:{ all -> 0x0134 }
            r4 = 2
            if (r2 >= r4) goto L_0x0367
            java.lang.String r4 = "Retrying..."
            r5 = 15
            r1.sendLogBroadcast(r5, r4)     // Catch:{ all -> 0x0134 }
            int r4 = r1.mConnectionState     // Catch:{ all -> 0x0134 }
            if (r4 == 0) goto L_0x0343
            r1.disconnect(r15)     // Catch:{ all -> 0x0134 }
        L_0x0343:
            r4 = 1
            r1.refreshDeviceCache(r15, r4)     // Catch:{ all -> 0x0134 }
            r1.close(r15)     // Catch:{ all -> 0x0134 }
            java.lang.String r4 = "Restarting the service"
            r1.logi(r4)     // Catch:{ all -> 0x0134 }
            android.content.Intent r4 = new android.content.Intent     // Catch:{ all -> 0x0134 }
            r4.<init>()     // Catch:{ all -> 0x0134 }
            r5 = 24
            r4.fillIn(r8, r5)     // Catch:{ all -> 0x0134 }
            r5 = 1
            int r2 = r2 + r5
            r4.putExtra(r3, r2)     // Catch:{ all -> 0x0134 }
            r1.startService(r4)     // Catch:{ all -> 0x0134 }
            if (r12 == 0) goto L_0x0366
            r1.stopForeground(r10)
        L_0x0366:
            return
        L_0x0367:
            int r2 = r1.mError     // Catch:{ all -> 0x0134 }
            r1.terminateConnection(r15, r2)     // Catch:{ all -> 0x0134 }
            if (r12 == 0) goto L_0x0371
            r1.stopForeground(r10)
        L_0x0371:
            return
        L_0x0372:
            int r2 = r1.mConnectionState     // Catch:{ all -> 0x0134 }
            if (r2 != 0) goto L_0x0388
            java.lang.String r2 = "Disconnected"
            r4 = 20
            r1.sendLogBroadcast(r4, r2)     // Catch:{ all -> 0x0134 }
            r2 = 4096(0x1000, float:5.74E-42)
            r1.terminateConnection(r15, r2)     // Catch:{ all -> 0x0134 }
            if (r12 == 0) goto L_0x0387
            r1.stopForeground(r10)
        L_0x0387:
            return
        L_0x0388:
            r4 = 20
            boolean r2 = r1.mAborted     // Catch:{ all -> 0x0134 }
            if (r2 == 0) goto L_0x03a5
            r1.logw(r11)     // Catch:{ all -> 0x0134 }
            r2 = 15
            r1.sendLogBroadcast(r2, r11)     // Catch:{ all -> 0x0134 }
            r2 = 0
            r1.terminateConnection(r15, r2)     // Catch:{ all -> 0x0134 }
            no.nordicsemi.android.dfu.DfuProgressInfo r2 = r1.mProgressInfo     // Catch:{ all -> 0x0134 }
            r2.setProgress(r9)     // Catch:{ all -> 0x0134 }
            if (r12 == 0) goto L_0x03a4
            r1.stopForeground(r10)
        L_0x03a4:
            return
        L_0x03a5:
            java.lang.String r2 = "Services discovered"
            r13 = 5
            r1.sendLogBroadcast(r13, r2)     // Catch:{ all -> 0x0134 }
            r2 = 0
            r8.putExtra(r3, r2)     // Catch:{ all -> 0x0134 }
            r2 = 0
            no.nordicsemi.android.dfu.DfuServiceProvider r3 = new no.nordicsemi.android.dfu.DfuServiceProvider     // Catch:{ UploadAbortedException -> 0x04d2, DeviceDisconnectedException -> 0x0418, DfuException -> 0x0414 }
            r3.<init>()     // Catch:{ UploadAbortedException -> 0x04d2, DeviceDisconnectedException -> 0x0418, DfuException -> 0x0414 }
            r1.mDfuServiceImpl = r3     // Catch:{ UploadAbortedException -> 0x04d2, DeviceDisconnectedException -> 0x0418, DfuException -> 0x0414 }
            no.nordicsemi.android.dfu.DfuService r13 = r3.getServiceImpl(r8, r1, r15)     // Catch:{ UploadAbortedException -> 0x04d2, DeviceDisconnectedException -> 0x0418, DfuException -> 0x0414 }
            r1.mDfuServiceImpl = r13     // Catch:{ UploadAbortedException -> 0x03ed, DeviceDisconnectedException -> 0x040d, DfuException -> 0x040a, all -> 0x03dd }
            if (r13 != 0) goto L_0x03f0
            java.lang.String r2 = "DfuBaseService"
            java.lang.String r3 = "DFU Service not found."
            android.util.Log.w(r2, r3)     // Catch:{ UploadAbortedException -> 0x03ed, DeviceDisconnectedException -> 0x03e7, DfuException -> 0x03e2, all -> 0x03dd }
            java.lang.String r2 = "DFU Service not found"
            r3 = 15
            r1.sendLogBroadcast(r3, r2)     // Catch:{ UploadAbortedException -> 0x03ed, DeviceDisconnectedException -> 0x03e7, DfuException -> 0x03e2, all -> 0x03dd }
            r2 = 4102(0x1006, float:5.748E-42)
            r1.terminateConnection(r15, r2)     // Catch:{ UploadAbortedException -> 0x03ed, DeviceDisconnectedException -> 0x03e7, DfuException -> 0x03e2, all -> 0x03dd }
            if (r13 == 0) goto L_0x03d7
            r13.release()     // Catch:{ all -> 0x0134 }
        L_0x03d7:
            if (r12 == 0) goto L_0x03dc
            r1.stopForeground(r10)
        L_0x03dc:
            return
        L_0x03dd:
            r0 = move-exception
            r3 = r0
            r2 = r13
            goto L_0x04ec
        L_0x03e2:
            r0 = move-exception
            r3 = r0
            r14 = r4
        L_0x03e5:
            r2 = r13
            goto L_0x041c
        L_0x03e7:
            r0 = move-exception
            r3 = r0
            r14 = r4
        L_0x03ea:
            r2 = r13
            goto L_0x046c
        L_0x03ed:
            r2 = r13
            goto L_0x04d2
        L_0x03f0:
            r2 = r13
            r3 = r25
            r14 = r4
            r4 = r15
            boolean r2 = r2.initialize(r3, r4, r5, r6, r7)     // Catch:{ UploadAbortedException -> 0x03ed, DeviceDisconnectedException -> 0x0402, DfuException -> 0x03ff, all -> 0x03dd }
            if (r2 == 0) goto L_0x0405
            r13.performDfu(r8)     // Catch:{ UploadAbortedException -> 0x03ed, DeviceDisconnectedException -> 0x0402, DfuException -> 0x03ff, all -> 0x03dd }
            goto L_0x0405
        L_0x03ff:
            r0 = move-exception
        L_0x0400:
            r3 = r0
            goto L_0x03e5
        L_0x0402:
            r0 = move-exception
        L_0x0403:
            r3 = r0
            goto L_0x03ea
        L_0x0405:
            r13.release()     // Catch:{ all -> 0x0134 }
            goto L_0x04e6
        L_0x040a:
            r0 = move-exception
            r14 = r4
            goto L_0x0400
        L_0x040d:
            r0 = move-exception
            r14 = r4
            goto L_0x0403
        L_0x0410:
            r0 = move-exception
            r3 = r0
            goto L_0x04ec
        L_0x0414:
            r0 = move-exception
            r14 = r4
            r3 = r0
            goto L_0x041c
        L_0x0418:
            r0 = move-exception
            r14 = r4
            r3 = r0
            goto L_0x046c
        L_0x041c:
            int r4 = r3.getErrorNumber()     // Catch:{ all -> 0x0410 }
            r5 = r4 & r17
            if (r5 <= 0) goto L_0x043e
            r4 = r4 & r16
            java.util.Locale r5 = java.util.Locale.US     // Catch:{ all -> 0x0410 }
            java.lang.String r6 = "Error (0x%02X): %s"
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0410 }
            java.lang.String r4 = no.nordicsemi.android.error.GattError.parseConnectionError(r4)     // Catch:{ all -> 0x0410 }
            java.lang.Object[] r4 = new java.lang.Object[]{r7, r4}     // Catch:{ all -> 0x0410 }
            java.lang.String r4 = java.lang.String.format(r5, r6, r4)     // Catch:{ all -> 0x0410 }
            r1.sendLogBroadcast(r14, r4)     // Catch:{ all -> 0x0410 }
            goto L_0x0457
        L_0x043e:
            r4 = r4 & -16385(0xffffffffffffbfff, float:NaN)
            java.util.Locale r5 = java.util.Locale.US     // Catch:{ all -> 0x0410 }
            java.lang.String r6 = "Error (0x%02X): %s"
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0410 }
            java.lang.String r4 = no.nordicsemi.android.error.GattError.parse(r4)     // Catch:{ all -> 0x0410 }
            java.lang.Object[] r4 = new java.lang.Object[]{r7, r4}     // Catch:{ all -> 0x0410 }
            java.lang.String r4 = java.lang.String.format(r5, r6, r4)     // Catch:{ all -> 0x0410 }
            r1.sendLogBroadcast(r14, r4)     // Catch:{ all -> 0x0410 }
        L_0x0457:
            java.lang.String r4 = r3.getMessage()     // Catch:{ all -> 0x0410 }
            r1.loge(r4)     // Catch:{ all -> 0x0410 }
            int r3 = r3.getErrorNumber()     // Catch:{ all -> 0x0410 }
            r1.terminateConnection(r15, r3)     // Catch:{ all -> 0x0410 }
            if (r2 == 0) goto L_0x04e6
        L_0x0467:
            r2.release()     // Catch:{ all -> 0x0134 }
            goto L_0x04e6
        L_0x046c:
            java.lang.String r4 = "Device has disconnected"
            r1.sendLogBroadcast(r14, r4)     // Catch:{ all -> 0x0410 }
            java.lang.String r3 = r3.getMessage()     // Catch:{ all -> 0x0410 }
            r1.loge(r3)     // Catch:{ all -> 0x0410 }
            r1.close(r15)     // Catch:{ all -> 0x0410 }
            java.lang.String r3 = "no.nordicsemi.android.dfu.extra.EXTRA_DFU_ATTEMPT"
            r4 = 0
            int r3 = r8.getIntExtra(r3, r4)     // Catch:{ all -> 0x0410 }
            java.lang.String r5 = "no.nordicsemi.android.dfu.extra.EXTRA_MAX_DFU_ATTEMPTS"
            int r4 = r8.getIntExtra(r5, r4)     // Catch:{ all -> 0x0410 }
            if (r3 >= r4) goto L_0x04ca
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0410 }
            r5.<init>()     // Catch:{ all -> 0x0410 }
            java.lang.String r6 = "Restarting the service ("
            r5.append(r6)     // Catch:{ all -> 0x0410 }
            r6 = 1
            int r3 = r3 + r6
            r5.append(r3)     // Catch:{ all -> 0x0410 }
            java.lang.String r6 = " /"
            r5.append(r6)     // Catch:{ all -> 0x0410 }
            r5.append(r4)     // Catch:{ all -> 0x0410 }
            java.lang.String r4 = ")"
            r5.append(r4)     // Catch:{ all -> 0x0410 }
            java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x0410 }
            r1.logi(r4)     // Catch:{ all -> 0x0410 }
            android.content.Intent r4 = new android.content.Intent     // Catch:{ all -> 0x0410 }
            r4.<init>()     // Catch:{ all -> 0x0410 }
            r5 = 24
            r4.fillIn(r8, r5)     // Catch:{ all -> 0x0410 }
            java.lang.String r5 = "no.nordicsemi.android.dfu.extra.EXTRA_DFU_ATTEMPT"
            r4.putExtra(r5, r3)     // Catch:{ all -> 0x0410 }
            r1.startService(r4)     // Catch:{ all -> 0x0410 }
            if (r2 == 0) goto L_0x04c4
            r2.release()     // Catch:{ all -> 0x0134 }
        L_0x04c4:
            if (r12 == 0) goto L_0x04c9
            r1.stopForeground(r10)
        L_0x04c9:
            return
        L_0x04ca:
            r3 = 4096(0x1000, float:5.74E-42)
            r1.report(r3)     // Catch:{ all -> 0x0410 }
            if (r2 == 0) goto L_0x04e6
            goto L_0x0467
        L_0x04d2:
            r1.logw(r11)     // Catch:{ all -> 0x0410 }
            r3 = 15
            r1.sendLogBroadcast(r3, r11)     // Catch:{ all -> 0x0410 }
            r3 = 0
            r1.terminateConnection(r15, r3)     // Catch:{ all -> 0x0410 }
            no.nordicsemi.android.dfu.DfuProgressInfo r3 = r1.mProgressInfo     // Catch:{ all -> 0x0410 }
            r3.setProgress(r9)     // Catch:{ all -> 0x0410 }
            if (r2 == 0) goto L_0x04e6
            goto L_0x0467
        L_0x04e6:
            if (r12 == 0) goto L_0x04eb
            r1.stopForeground(r10)
        L_0x04eb:
            return
        L_0x04ec:
            if (r2 == 0) goto L_0x04f1
            r2.release()     // Catch:{ all -> 0x0134 }
        L_0x04f1:
            throw r3     // Catch:{ all -> 0x0134 }
        L_0x04f2:
            r0 = move-exception
            r14 = 20
            r2 = r0
            goto L_0x050c
        L_0x04f7:
            r0 = move-exception
            r14 = 20
            r2 = r0
            goto L_0x0534
        L_0x04fc:
            r0 = move-exception
            r14 = 20
            r2 = r0
            goto L_0x055c
        L_0x0501:
            r0 = move-exception
            r14 = 20
            r2 = r0
            goto L_0x0571
        L_0x0506:
            r0 = move-exception
            r14 = 20
            r2 = r0
            goto L_0x0586
        L_0x050c:
            java.lang.String r3 = "An exception occurred while opening files. Did you set the firmware file?"
            r1.loge(r3, r2)     // Catch:{ all -> 0x0134 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0134 }
            r3.<init>()     // Catch:{ all -> 0x0134 }
            java.lang.String r4 = "Opening file failed: "
            r3.append(r4)     // Catch:{ all -> 0x0134 }
            java.lang.String r2 = r2.getLocalizedMessage()     // Catch:{ all -> 0x0134 }
            r3.append(r2)     // Catch:{ all -> 0x0134 }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0134 }
            r1.sendLogBroadcast(r14, r2)     // Catch:{ all -> 0x0134 }
            r2 = 4098(0x1002, float:5.743E-42)
            r1.report(r2)     // Catch:{ all -> 0x0134 }
            if (r12 == 0) goto L_0x0533
            r1.stopForeground(r10)
        L_0x0533:
            return
        L_0x0534:
            java.lang.String r3 = "An exception occurred while calculating file size"
            r1.loge(r3, r2)     // Catch:{ all -> 0x0134 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0134 }
            r3.<init>()     // Catch:{ all -> 0x0134 }
            java.lang.String r4 = "Opening file failed: "
            r3.append(r4)     // Catch:{ all -> 0x0134 }
            java.lang.String r2 = r2.getLocalizedMessage()     // Catch:{ all -> 0x0134 }
            r3.append(r2)     // Catch:{ all -> 0x0134 }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0134 }
            r1.sendLogBroadcast(r14, r2)     // Catch:{ all -> 0x0134 }
            r2 = 4098(0x1002, float:5.743E-42)
            r1.report(r2)     // Catch:{ all -> 0x0134 }
            if (r12 == 0) goto L_0x055b
            r1.stopForeground(r10)
        L_0x055b:
            return
        L_0x055c:
            java.lang.String r3 = "Firmware not word-aligned"
            r1.loge(r3, r2)     // Catch:{ all -> 0x0134 }
            java.lang.String r2 = "Opening file failed: Firmware size must be word-aligned"
            r1.sendLogBroadcast(r14, r2)     // Catch:{ all -> 0x0134 }
            r2 = 4108(0x100c, float:5.757E-42)
            r1.report(r2)     // Catch:{ all -> 0x0134 }
            if (r12 == 0) goto L_0x0570
            r1.stopForeground(r10)
        L_0x0570:
            return
        L_0x0571:
            java.lang.String r3 = "An exception occurred while opening file"
            r1.loge(r3, r2)     // Catch:{ all -> 0x0134 }
            java.lang.String r2 = "Opening file failed: File not found"
            r1.sendLogBroadcast(r14, r2)     // Catch:{ all -> 0x0134 }
            r2 = 4097(0x1001, float:5.741E-42)
            r1.report(r2)     // Catch:{ all -> 0x0134 }
            if (r12 == 0) goto L_0x0585
            r1.stopForeground(r10)
        L_0x0585:
            return
        L_0x0586:
            java.lang.String r3 = "A security exception occurred while opening file"
            r1.loge(r3, r2)     // Catch:{ all -> 0x0134 }
            java.lang.String r2 = "Opening file failed: Permission required"
            r1.sendLogBroadcast(r14, r2)     // Catch:{ all -> 0x0134 }
            r2 = 4097(0x1001, float:5.741E-42)
            r1.report(r2)     // Catch:{ all -> 0x0134 }
            if (r12 == 0) goto L_0x059a
            r1.stopForeground(r10)
        L_0x059a:
            return
        L_0x059b:
            if (r12 == 0) goto L_0x05a0
            r1.stopForeground(r10)
        L_0x05a0:
            throw r2
        L_0x05a1:
            java.lang.String r2 = "File type or file mime-type not supported"
            r1.logw(r2)
            java.lang.String r2 = "File type or file mime-type not supported"
            r3 = 15
            r1.sendLogBroadcast(r3, r2)
            r2 = 4105(0x1009, float:5.752E-42)
            r1.report(r2)
            return
        L_0x05b3:
            java.lang.String r2 = "Device Address of firmware location are empty. Hint: use DfuServiceInitiator to start DFU"
            r1.loge(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.DfuBaseService.onHandleIntent(android.content.Intent):void");
    }

    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        if (notificationManager != null) {
            notificationManager.cancel(NOTIFICATION_ID);
        }
        stopSelf();
    }

    public void refreshDeviceCache(@NonNull BluetoothGatt bluetoothGatt, boolean z) {
        if (z || bluetoothGatt.getDevice().getBondState() == 10) {
            sendLogBroadcast(0, "gatt.refresh() (hidden)");
            try {
                boolean booleanValue = ((Boolean) bluetoothGatt.getClass().getMethod("refresh", (Class[]) null).invoke(bluetoothGatt, (Object[]) null)).booleanValue();
                logi("Refreshing result: " + booleanValue);
            } catch (Exception e) {
                loge("An exception occurred while refreshing device", e);
                sendLogBroadcast(15, "Refreshing failed");
            }
        }
    }

    public void report(int i) {
        Log.i("test", "DfuBaseService Error:" + i);
        sendErrorBroadcast(i);
        if (!this.mDisableNotification) {
            String str = this.mDeviceAddress;
            String str2 = this.mDeviceName;
            if (str2 == null) {
                str2 = getString(R.string.dfu_unknown_name);
            }
            NotificationCompat.Builder f = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_DFU).H(17301640).B(true).j(-65536).A(false).n(getString(R.string.dfu_status_error)).H(17301641).m(getString(R.string.dfu_status_error_msg)).f(true);
            Intent intent = new Intent(this, getNotificationTarget());
            intent.addFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
            intent.putExtra(EXTRA_DEVICE_ADDRESS, str);
            intent.putExtra(EXTRA_DEVICE_NAME, str2);
            intent.putExtra(EXTRA_PROGRESS, i);
            f.l(PendingIntent.getActivity(this, 0, intent, Build.VERSION.SDK_INT >= 31 ? CaptureType.CAPTURE_TYPE_ICCOA : CaptureType.CAPTURE_VIRTUAL_DISPLAY_ENABLE_MAGIC_WINDOW));
            updateErrorNotification(f);
            NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
            if (notificationManager != null) {
                notificationManager.notify(NOTIFICATION_ID, f.c());
            }
        }
    }

    public void sendLogBroadcast(int i, String str) {
        Intent intent = new Intent(BROADCAST_LOG);
        intent.putExtra(EXTRA_LOG_MESSAGE, "[DFU] " + str);
        intent.putExtra(EXTRA_LOG_LEVEL, i);
        intent.putExtra(EXTRA_DEVICE_ADDRESS, this.mDeviceAddress);
        LocalBroadcastManager.b(this).d(intent);
    }

    public void terminateConnection(@NonNull BluetoothGatt bluetoothGatt, int i) {
        if (this.mConnectionState != 0) {
            disconnect(bluetoothGatt);
        }
        refreshDeviceCache(bluetoothGatt, false);
        close(bluetoothGatt);
        waitFor(600);
        if (i != 0) {
            report(i);
        }
    }

    public void updateErrorNotification(@NonNull NotificationCompat.Builder builder) {
    }

    public void updateForegroundNotification(@NonNull NotificationCompat.Builder builder) {
    }

    public void updateProgressNotification() {
        DfuProgressInfo dfuProgressInfo = this.mProgressInfo;
        int progress = dfuProgressInfo.getProgress();
        if (this.mLastProgress != progress) {
            this.mLastProgress = progress;
            sendProgressBroadcast(dfuProgressInfo);
            if (!this.mDisableNotification) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime - this.mLastNotificationTime >= 250 || -6 == progress || -7 == progress) {
                    this.mLastNotificationTime = elapsedRealtime;
                    String str = this.mDeviceAddress;
                    String str2 = this.mDeviceName;
                    if (str2 == null) {
                        str2 = getString(R.string.dfu_unknown_name);
                    }
                    NotificationCompat.Builder B = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_DFU).H(17301640).B(true);
                    B.j(-7829368);
                    switch (progress) {
                        case -7:
                            B.A(false).n(getString(R.string.dfu_status_aborted)).H(17301641).m(getString(R.string.dfu_status_aborted_msg)).f(true);
                            break;
                        case -6:
                            B.A(false).n(getString(R.string.dfu_status_completed)).H(17301641).m(getString(R.string.dfu_status_completed_msg)).f(true).j(-16730086);
                            break;
                        case -5:
                            B.A(true).n(getString(R.string.dfu_status_disconnecting)).m(getString(R.string.dfu_status_disconnecting_msg, new Object[]{str2})).D(100, 0, true);
                            break;
                        case -4:
                            B.A(true).n(getString(R.string.dfu_status_validating)).m(getString(R.string.dfu_status_validating_msg)).D(100, 0, true);
                            break;
                        case -3:
                            B.A(true).n(getString(R.string.dfu_status_switching_to_dfu)).m(getString(R.string.dfu_status_switching_to_dfu_msg)).D(100, 0, true);
                            break;
                        case -2:
                            B.A(true).n(getString(R.string.dfu_status_starting)).m(getString(R.string.dfu_status_starting_msg)).D(100, 0, true);
                            break;
                        case -1:
                            B.A(true).n(getString(R.string.dfu_status_connecting)).m(getString(R.string.dfu_status_connecting_msg, new Object[]{str2})).D(100, 0, true);
                            break;
                        default:
                            B.A(true).n(dfuProgressInfo.getTotalParts() == 1 ? getString(R.string.dfu_status_uploading) : getString(R.string.dfu_status_uploading_part, new Object[]{Integer.valueOf(dfuProgressInfo.getCurrentPart()), Integer.valueOf(dfuProgressInfo.getTotalParts())})).m(getString(R.string.dfu_status_uploading_msg, new Object[]{str2})).D(100, progress, false);
                            break;
                    }
                    Intent intent = new Intent(this, getNotificationTarget());
                    intent.addFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
                    intent.putExtra(EXTRA_DEVICE_ADDRESS, str);
                    intent.putExtra(EXTRA_DEVICE_NAME, str2);
                    intent.putExtra(EXTRA_PROGRESS, progress);
                    B.l(PendingIntent.getActivity(this, 0, intent, Build.VERSION.SDK_INT >= 31 ? CaptureType.CAPTURE_TYPE_ICCOA : CaptureType.CAPTURE_VIRTUAL_DISPLAY_ENABLE_MAGIC_WINDOW));
                    updateProgressNotification(B, progress);
                    NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
                    if (notificationManager != null) {
                        notificationManager.notify(NOTIFICATION_ID, B.c());
                    }
                }
            }
        }
    }

    public void waitFor(long j) {
        synchronized (this.mLock) {
            try {
                sendLogBroadcast(0, "wait(" + j + ")");
                this.mLock.wait(j);
            } catch (InterruptedException e) {
                loge("Sleeping interrupted", e);
            }
        }
    }

    public void waitUntilDisconnected() {
        try {
            synchronized (this.mLock) {
                while (this.mConnectionState != 0 && this.mError == 0) {
                    this.mLock.wait();
                }
            }
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        } catch (Throwable th) {
            throw th;
        }
    }

    private void loge(String str, Throwable th) {
        Log.e(TAG, str, th);
    }

    private InputStream openInputStream(@NonNull Uri uri, String str, int i, int i2) throws IOException {
        InputStream openInputStream = getContentResolver().openInputStream(uri);
        if ("application/zip".equals(str)) {
            return new ArchiveInputStream(openInputStream, i, i2);
        }
        Cursor query = getContentResolver().query(uri, new String[]{"_display_name"}, (String) null, (String[]) null, (String) null);
        try {
            if (query.moveToNext() && query.getString(0).toLowerCase(Locale.US).endsWith("hex")) {
                return new HexInputStream(openInputStream, i);
            }
            query.close();
            return openInputStream;
        } finally {
            query.close();
        }
    }

    private InputStream openInputStream(int i, String str, int i2, int i3) throws IOException {
        InputStream openRawResource = getResources().openRawResource(i);
        if ("application/zip".equals(str)) {
            return new ArchiveInputStream(openRawResource, i2, i3);
        }
        openRawResource.mark(2);
        int read = openRawResource.read();
        openRawResource.reset();
        return read == 58 ? new HexInputStream(openRawResource, i2) : openRawResource;
    }

    public void updateProgressNotification(@NonNull NotificationCompat.Builder builder, int i) {
        if (i != -7 && i != -6) {
            Intent intent = new Intent(BROADCAST_ACTION);
            intent.putExtra(EXTRA_ACTION, 2);
            builder.a(R.drawable.ic_action_notify_cancel, getString(R.string.dfu_action_abort), PendingIntent.getBroadcast(this, 1, intent, Build.VERSION.SDK_INT >= 31 ? CaptureType.CAPTURE_TYPE_ICCOA : CaptureType.CAPTURE_VIRTUAL_DISPLAY_ENABLE_MAGIC_WINDOW));
        }
    }
}
