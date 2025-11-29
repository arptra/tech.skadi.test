package com.here.services.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.here.posclient.Status;
import com.meizu.common.widget.MzContactsContract;

public class PositioningError implements Parcelable {
    public static final Parcelable.Creator<PositioningError> CREATOR = new Parcelable.Creator<PositioningError>() {
        public PositioningError createFromParcel(Parcel parcel) {
            return new PositioningError(parcel.readInt(), parcel.readInt());
        }

        public PositioningError[] newArray(int i) {
            return new PositioningError[i];
        }
    };
    public static final int ERROR_OFFLINE_CELL_NOT_FOUND_ERROR = 16;
    public static final int ERROR_OFFLINE_WLAN_NOT_FOUND_ERROR = 32;
    public static final int ERROR_ONLINE_ERROR = 64;
    public static final int ERROR_SCAN_CELL_EMPTY = 8;
    public static final int ERROR_SCAN_CELL_ERROR = 4;
    public static final int ERROR_SCAN_WLAN_EMPTY = 2;
    public static final int ERROR_SCAN_WLAN_ERROR = 1;
    public static final int ERROR_UNKNOWN = 0;
    public static final int INFO_CLEAR_VALUES = 256;
    public static final int INFO_CONNECTION_NOT_AVAILABLE = 2048;
    public static final int INFO_DEGRADED_MEASUREMENT_QUALITY = 4096;
    public static final int INFO_DEVICE_NOT_SUPPORTED = 512;
    public static final int INFO_HDGNSS_POSITION_NOT_AVAILABLE = 16384;
    public static final int INFO_INSUFFICIENT_MEASUREMENT_QUALITY = 32768;
    public static final int INFO_OS_VERSION_NOT_SUPPORTED = 1024;
    public static final int INFO_URBAN_AREA = 8192;
    public static final int STATUS_GENERAL_ERROR = 1;
    public static final int STATUS_NOTFOUND_ERROR = 4;
    public static final int STATUS_OK = 0;
    public final int errorDetails;
    public final int posClientStatus;
    public final int status;

    /* renamed from: com.here.services.common.PositioningError$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$here$posclient$Status;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.here.posclient.Status[] r0 = com.here.posclient.Status.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$here$posclient$Status = r0
                com.here.posclient.Status r1 = com.here.posclient.Status.Ok     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$here$posclient$Status     // Catch:{ NoSuchFieldError -> 0x001d }
                com.here.posclient.Status r1 = com.here.posclient.Status.NotFoundError     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.here.services.common.PositioningError.AnonymousClass2.<clinit>():void");
        }
    }

    public PositioningError(Status status2, int i) {
        this.posClientStatus = status2.toInt();
        this.status = convertStatus(status2);
        this.errorDetails = i;
    }

    private static int convertStatus(Status status2) {
        int i = AnonymousClass2.$SwitchMap$com$here$posclient$Status[status2.ordinal()];
        if (i != 1) {
            return i != 2 ? 1 : 4;
        }
        return 0;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "PositioningError[" + "posClientStatus:" + this.posClientStatus + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML + "status:" + this.status + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML + "details:" + String.format("0x%x", new Object[]{Integer.valueOf(this.errorDetails)}) + "]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.posClientStatus);
        parcel.writeInt(this.errorDetails);
    }

    public PositioningError(Status status2) {
        this(status2, 0);
    }

    public PositioningError(int i, int i2) {
        this(Status.fromInt(i), i2);
    }
}
