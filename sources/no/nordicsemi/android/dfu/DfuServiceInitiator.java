package no.nordicsemi.android.dfu;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.ParcelUuid;
import android.os.Parcelable;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.RequiresApi;
import com.jstyle.nordic_otas.nordic_otas_plugin.R;
import java.security.InvalidParameterException;
import java.util.UUID;

public final class DfuServiceInitiator {
    public static final int DEFAULT_MBR_SIZE = 4096;
    public static final int DEFAULT_PRN_VALUE = 12;
    public static final int SCOPE_APPLICATION = 2;
    public static final int SCOPE_SYSTEM_COMPONENTS = 1;
    private Parcelable[] buttonlessDfuWithBondSharingUuids;
    private Parcelable[] buttonlessDfuWithoutBondSharingUuids;
    private int currentMtu = 23;
    private final String deviceAddress;
    private String deviceName;
    private boolean disableNotification = false;
    private boolean disableResume = false;
    private boolean enableUnsafeExperimentalButtonlessDfu = false;
    private Parcelable[] experimentalButtonlessDfuUuids;
    private String filePath;
    private int fileResId;
    private int fileType = -1;
    private Uri fileUri;
    private boolean forceDfu = false;
    private String initFilePath;
    private int initFileResId;
    private Uri initFileUri;
    private boolean keepBond;
    private Parcelable[] legacyDfuUuids;
    private int mbrSize = 4096;
    private String mimeType;
    private int mtu = 517;
    private int numberOfPackets = 12;
    private int numberOfRetries = 0;
    private Boolean packetReceiptNotificationsEnabled;
    private boolean restoreBond;
    private Parcelable[] secureDfuUuids;
    private boolean startAsForegroundService = true;

    public DfuServiceInitiator(@NonNull String str) {
        this.deviceAddress = str;
    }

    @RequiresApi
    public static void createDfuNotificationChannel(@NonNull Context context) {
        NotificationChannel notificationChannel = new NotificationChannel(DfuBaseService.NOTIFICATION_CHANNEL_DFU, context.getString(R.string.dfu_channel_name), 2);
        notificationChannel.setDescription(context.getString(R.string.dfu_channel_description));
        notificationChannel.setShowBadge(false);
        notificationChannel.setLockscreenVisibility(1);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (notificationManager != null) {
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    private DfuServiceInitiator init(@Nullable Uri uri, @Nullable String str, @RawRes int i) {
        if (!"application/zip".equals(this.mimeType)) {
            this.initFileUri = uri;
            this.initFilePath = str;
            this.initFileResId = i;
            return this;
        }
        throw new InvalidParameterException("Init file must be located inside the ZIP");
    }

    public DfuServiceInitiator disableMtuRequest() {
        this.mtu = 0;
        return this;
    }

    public DfuServiceInitiator disableResume() {
        this.disableResume = true;
        return this;
    }

    @Deprecated
    public DfuServiceInitiator setBinOrHex(@FileType int i, @NonNull Uri uri) {
        if (i != 0) {
            return init(uri, (String) null, 0, i, "application/octet-stream");
        }
        throw new UnsupportedOperationException("You must specify the file type");
    }

    public DfuServiceInitiator setCurrentMtu(@IntRange int i) {
        this.currentMtu = i;
        return this;
    }

    public DfuServiceInitiator setCustomUuidsForButtonlessDfuWithBondSharing(@Nullable UUID uuid, @Nullable UUID uuid2) {
        ParcelUuid parcelUuid = null;
        ParcelUuid parcelUuid2 = uuid != null ? new ParcelUuid(uuid) : null;
        if (uuid2 != null) {
            parcelUuid = new ParcelUuid(uuid2);
        }
        this.buttonlessDfuWithBondSharingUuids = new ParcelUuid[]{parcelUuid2, parcelUuid};
        return this;
    }

    public DfuServiceInitiator setCustomUuidsForButtonlessDfuWithoutBondSharing(@Nullable UUID uuid, @Nullable UUID uuid2) {
        ParcelUuid parcelUuid = null;
        ParcelUuid parcelUuid2 = uuid != null ? new ParcelUuid(uuid) : null;
        if (uuid2 != null) {
            parcelUuid = new ParcelUuid(uuid2);
        }
        this.buttonlessDfuWithoutBondSharingUuids = new ParcelUuid[]{parcelUuid2, parcelUuid};
        return this;
    }

    public DfuServiceInitiator setCustomUuidsForExperimentalButtonlessDfu(@Nullable UUID uuid, @Nullable UUID uuid2) {
        ParcelUuid parcelUuid = null;
        ParcelUuid parcelUuid2 = uuid != null ? new ParcelUuid(uuid) : null;
        if (uuid2 != null) {
            parcelUuid = new ParcelUuid(uuid2);
        }
        this.experimentalButtonlessDfuUuids = new ParcelUuid[]{parcelUuid2, parcelUuid};
        return this;
    }

    public DfuServiceInitiator setCustomUuidsForLegacyDfu(@Nullable UUID uuid, @Nullable UUID uuid2, @Nullable UUID uuid3, @Nullable UUID uuid4) {
        ParcelUuid parcelUuid = null;
        ParcelUuid parcelUuid2 = uuid != null ? new ParcelUuid(uuid) : null;
        ParcelUuid parcelUuid3 = uuid2 != null ? new ParcelUuid(uuid2) : null;
        ParcelUuid parcelUuid4 = uuid3 != null ? new ParcelUuid(uuid3) : null;
        if (uuid4 != null) {
            parcelUuid = new ParcelUuid(uuid4);
        }
        this.legacyDfuUuids = new ParcelUuid[]{parcelUuid2, parcelUuid3, parcelUuid4, parcelUuid};
        return this;
    }

    public DfuServiceInitiator setCustomUuidsForSecureDfu(@Nullable UUID uuid, @Nullable UUID uuid2, @Nullable UUID uuid3) {
        ParcelUuid parcelUuid = null;
        ParcelUuid parcelUuid2 = uuid != null ? new ParcelUuid(uuid) : null;
        ParcelUuid parcelUuid3 = uuid2 != null ? new ParcelUuid(uuid2) : null;
        if (uuid3 != null) {
            parcelUuid = new ParcelUuid(uuid3);
        }
        this.secureDfuUuids = new ParcelUuid[]{parcelUuid2, parcelUuid3, parcelUuid};
        return this;
    }

    public DfuServiceInitiator setDeviceName(@Nullable String str) {
        this.deviceName = str;
        return this;
    }

    public DfuServiceInitiator setDisableNotification(boolean z) {
        this.disableNotification = z;
        return this;
    }

    public DfuServiceInitiator setForceDfu(boolean z) {
        this.forceDfu = z;
        return this;
    }

    public DfuServiceInitiator setForeground(boolean z) {
        this.startAsForegroundService = z;
        return this;
    }

    @Deprecated
    public DfuServiceInitiator setInitFile(@NonNull Uri uri) {
        return init(uri, (String) null, 0);
    }

    public DfuServiceInitiator setKeepBond(boolean z) {
        this.keepBond = z;
        return this;
    }

    public DfuServiceInitiator setMbrSize(@IntRange int i) {
        this.mbrSize = i;
        return this;
    }

    public DfuServiceInitiator setMtu(@IntRange int i) {
        this.mtu = i;
        return this;
    }

    public DfuServiceInitiator setNumberOfRetries(@IntRange int i) {
        this.numberOfRetries = i;
        return this;
    }

    public DfuServiceInitiator setPacketsReceiptNotificationsEnabled(boolean z) {
        this.packetReceiptNotificationsEnabled = Boolean.valueOf(z);
        return this;
    }

    public DfuServiceInitiator setPacketsReceiptNotificationsValue(@IntRange int i) {
        if (i <= 0) {
            i = 12;
        }
        this.numberOfPackets = i;
        return this;
    }

    public DfuServiceInitiator setRestoreBond(boolean z) {
        this.restoreBond = z;
        return this;
    }

    public DfuServiceInitiator setScope(@DfuScope int i) {
        if ("application/zip".equals(this.mimeType)) {
            if (i == 2) {
                this.fileType = 4;
            } else if (i == 1) {
                this.fileType = 3;
            } else if (i == 3) {
                this.fileType = 0;
            } else {
                throw new UnsupportedOperationException("Unknown scope");
            }
            return this;
        }
        throw new UnsupportedOperationException("Scope can be set only for a ZIP file");
    }

    public DfuServiceInitiator setUnsafeExperimentalButtonlessServiceInSecureDfuEnabled(boolean z) {
        this.enableUnsafeExperimentalButtonlessDfu = z;
        return this;
    }

    public DfuServiceInitiator setZip(@NonNull Uri uri) {
        return init(uri, (String) null, 0, 0, "application/zip");
    }

    public DfuServiceController start(@NonNull Context context, @NonNull Class<? extends DfuBaseService> cls) {
        if (this.fileType != -1) {
            Intent intent = new Intent(context, cls);
            intent.putExtra(DfuBaseService.EXTRA_DEVICE_ADDRESS, this.deviceAddress);
            intent.putExtra(DfuBaseService.EXTRA_DEVICE_NAME, this.deviceName);
            intent.putExtra(DfuBaseService.EXTRA_DISABLE_NOTIFICATION, this.disableNotification);
            intent.putExtra(DfuBaseService.EXTRA_FOREGROUND_SERVICE, this.startAsForegroundService);
            intent.putExtra(DfuBaseService.EXTRA_FILE_MIME_TYPE, this.mimeType);
            intent.putExtra(DfuBaseService.EXTRA_FILE_TYPE, this.fileType);
            intent.putExtra(DfuBaseService.EXTRA_FILE_URI, this.fileUri);
            intent.putExtra(DfuBaseService.EXTRA_FILE_PATH, this.filePath);
            intent.putExtra(DfuBaseService.EXTRA_FILE_RES_ID, this.fileResId);
            intent.putExtra(DfuBaseService.EXTRA_INIT_FILE_URI, this.initFileUri);
            intent.putExtra(DfuBaseService.EXTRA_INIT_FILE_PATH, this.initFilePath);
            intent.putExtra(DfuBaseService.EXTRA_INIT_FILE_RES_ID, this.initFileResId);
            intent.putExtra(DfuBaseService.EXTRA_KEEP_BOND, this.keepBond);
            intent.putExtra(DfuBaseService.EXTRA_RESTORE_BOND, this.restoreBond);
            intent.putExtra(DfuBaseService.EXTRA_FORCE_DFU, this.forceDfu);
            intent.putExtra(DfuBaseService.EXTRA_DISABLE_RESUME, this.disableResume);
            intent.putExtra(DfuBaseService.EXTRA_MAX_DFU_ATTEMPTS, this.numberOfRetries);
            intent.putExtra(DfuBaseService.EXTRA_MBR_SIZE, this.mbrSize);
            int i = this.mtu;
            if (i > 0) {
                intent.putExtra(DfuBaseService.EXTRA_MTU, i);
            }
            intent.putExtra(DfuBaseService.EXTRA_CURRENT_MTU, this.currentMtu);
            intent.putExtra(DfuBaseService.EXTRA_UNSAFE_EXPERIMENTAL_BUTTONLESS_DFU, this.enableUnsafeExperimentalButtonlessDfu);
            Boolean bool = this.packetReceiptNotificationsEnabled;
            if (bool != null) {
                intent.putExtra(DfuBaseService.EXTRA_PACKET_RECEIPT_NOTIFICATIONS_ENABLED, bool);
                intent.putExtra(DfuBaseService.EXTRA_PACKET_RECEIPT_NOTIFICATIONS_VALUE, this.numberOfPackets);
            }
            Parcelable[] parcelableArr = this.legacyDfuUuids;
            if (parcelableArr != null) {
                intent.putExtra(DfuBaseService.EXTRA_CUSTOM_UUIDS_FOR_LEGACY_DFU, parcelableArr);
            }
            Parcelable[] parcelableArr2 = this.secureDfuUuids;
            if (parcelableArr2 != null) {
                intent.putExtra(DfuBaseService.EXTRA_CUSTOM_UUIDS_FOR_SECURE_DFU, parcelableArr2);
            }
            Parcelable[] parcelableArr3 = this.experimentalButtonlessDfuUuids;
            if (parcelableArr3 != null) {
                intent.putExtra(DfuBaseService.EXTRA_CUSTOM_UUIDS_FOR_EXPERIMENTAL_BUTTONLESS_DFU, parcelableArr3);
            }
            Parcelable[] parcelableArr4 = this.buttonlessDfuWithoutBondSharingUuids;
            if (parcelableArr4 != null) {
                intent.putExtra(DfuBaseService.EXTRA_CUSTOM_UUIDS_FOR_BUTTONLESS_DFU_WITHOUT_BOND_SHARING, parcelableArr4);
            }
            Parcelable[] parcelableArr5 = this.buttonlessDfuWithBondSharingUuids;
            if (parcelableArr5 != null) {
                intent.putExtra(DfuBaseService.EXTRA_CUSTOM_UUIDS_FOR_BUTTONLESS_DFU_WITH_BOND_SHARING, parcelableArr5);
            }
            if (this.startAsForegroundService) {
                context.startForegroundService(intent);
            } else {
                context.startService(intent);
            }
            return new DfuServiceController(context);
        }
        throw new UnsupportedOperationException("You must specify the firmware file before starting the service");
    }

    @Deprecated
    public DfuServiceInitiator setInitFile(@Nullable String str) {
        return init((Uri) null, str, 0);
    }

    public DfuServiceInitiator setZip(@NonNull String str) {
        return init((Uri) null, str, 0, 0, "application/zip");
    }

    @Deprecated
    public DfuServiceInitiator setBinOrHex(@FileType int i, @NonNull String str) {
        if (i != 0) {
            return init((Uri) null, str, 0, i, "application/octet-stream");
        }
        throw new UnsupportedOperationException("You must specify the file type");
    }

    @Deprecated
    public DfuServiceInitiator setInitFile(@RawRes int i) {
        return init((Uri) null, (String) null, i);
    }

    public DfuServiceInitiator setZip(@RawRes int i) {
        return init((Uri) null, (String) null, i, 0, "application/zip");
    }

    @Deprecated
    public DfuServiceInitiator setInitFile(@Nullable Uri uri, @Nullable String str) {
        return init(uri, str, 0);
    }

    public DfuServiceInitiator setZip(@Nullable Uri uri, @Nullable String str) {
        return init(uri, str, 0, 0, "application/zip");
    }

    @Deprecated
    public DfuServiceInitiator setBinOrHex(@FileType int i, @Nullable Uri uri, @Nullable String str) {
        if (i != 0) {
            return init(uri, str, 0, i, "application/octet-stream");
        }
        throw new UnsupportedOperationException("You must specify the file type");
    }

    private DfuServiceInitiator init(@Nullable Uri uri, @Nullable String str, @RawRes int i, @FileType int i2, @NonNull String str2) {
        this.fileUri = uri;
        this.filePath = str;
        this.fileResId = i;
        this.fileType = i2;
        this.mimeType = str2;
        if ("application/zip".equals(str2)) {
            this.initFileUri = null;
            this.initFilePath = null;
            this.initFileResId = 0;
        }
        return this;
    }

    @Deprecated
    public DfuServiceInitiator setBinOrHex(@FileType int i, @RawRes int i2) {
        if (i != 0) {
            return init((Uri) null, (String) null, i2, i, "application/octet-stream");
        }
        throw new UnsupportedOperationException("You must specify the file type");
    }
}
