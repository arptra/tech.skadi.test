package no.nordicsemi.android.dfu;

import android.content.Intent;
import android.os.ParcelUuid;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.util.UUID;

class UuidHelper {
    public static void assignCustomUuids(@NonNull Intent intent) {
        Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra(DfuBaseService.EXTRA_CUSTOM_UUIDS_FOR_LEGACY_DFU);
        if (parcelableArrayExtra == null || parcelableArrayExtra.length != 4) {
            UUID uuid = LegacyDfuImpl.DEFAULT_DFU_SERVICE_UUID;
            LegacyDfuImpl.DFU_SERVICE_UUID = uuid;
            UUID uuid2 = LegacyDfuImpl.DEFAULT_DFU_CONTROL_POINT_UUID;
            LegacyDfuImpl.DFU_CONTROL_POINT_UUID = uuid2;
            LegacyDfuImpl.DFU_PACKET_UUID = LegacyDfuImpl.DEFAULT_DFU_PACKET_UUID;
            UUID uuid3 = LegacyDfuImpl.DEFAULT_DFU_VERSION_UUID;
            LegacyDfuImpl.DFU_VERSION_UUID = uuid3;
            LegacyButtonlessDfuImpl.DFU_SERVICE_UUID = uuid;
            LegacyButtonlessDfuImpl.DFU_CONTROL_POINT_UUID = uuid2;
            LegacyButtonlessDfuImpl.DFU_VERSION_UUID = uuid3;
        } else {
            Parcelable parcelable = parcelableArrayExtra[0];
            LegacyDfuImpl.DFU_SERVICE_UUID = parcelable != null ? ((ParcelUuid) parcelable).getUuid() : LegacyDfuImpl.DEFAULT_DFU_SERVICE_UUID;
            Parcelable parcelable2 = parcelableArrayExtra[1];
            LegacyDfuImpl.DFU_CONTROL_POINT_UUID = parcelable2 != null ? ((ParcelUuid) parcelable2).getUuid() : LegacyDfuImpl.DEFAULT_DFU_CONTROL_POINT_UUID;
            Parcelable parcelable3 = parcelableArrayExtra[2];
            LegacyDfuImpl.DFU_PACKET_UUID = parcelable3 != null ? ((ParcelUuid) parcelable3).getUuid() : LegacyDfuImpl.DEFAULT_DFU_PACKET_UUID;
            Parcelable parcelable4 = parcelableArrayExtra[3];
            LegacyDfuImpl.DFU_VERSION_UUID = parcelable4 != null ? ((ParcelUuid) parcelable4).getUuid() : LegacyDfuImpl.DEFAULT_DFU_VERSION_UUID;
            LegacyButtonlessDfuImpl.DFU_SERVICE_UUID = LegacyDfuImpl.DFU_SERVICE_UUID;
            LegacyButtonlessDfuImpl.DFU_CONTROL_POINT_UUID = LegacyDfuImpl.DFU_CONTROL_POINT_UUID;
            LegacyButtonlessDfuImpl.DFU_VERSION_UUID = LegacyDfuImpl.DFU_VERSION_UUID;
        }
        Parcelable[] parcelableArrayExtra2 = intent.getParcelableArrayExtra(DfuBaseService.EXTRA_CUSTOM_UUIDS_FOR_SECURE_DFU);
        if (parcelableArrayExtra2 == null || parcelableArrayExtra2.length != 3) {
            SecureDfuImpl.DFU_SERVICE_UUID = SecureDfuImpl.DEFAULT_DFU_SERVICE_UUID;
            SecureDfuImpl.DFU_CONTROL_POINT_UUID = SecureDfuImpl.DEFAULT_DFU_CONTROL_POINT_UUID;
            SecureDfuImpl.DFU_PACKET_UUID = SecureDfuImpl.DEFAULT_DFU_PACKET_UUID;
        } else {
            Parcelable parcelable5 = parcelableArrayExtra2[0];
            SecureDfuImpl.DFU_SERVICE_UUID = parcelable5 != null ? ((ParcelUuid) parcelable5).getUuid() : SecureDfuImpl.DEFAULT_DFU_SERVICE_UUID;
            Parcelable parcelable6 = parcelableArrayExtra2[1];
            SecureDfuImpl.DFU_CONTROL_POINT_UUID = parcelable6 != null ? ((ParcelUuid) parcelable6).getUuid() : SecureDfuImpl.DEFAULT_DFU_CONTROL_POINT_UUID;
            Parcelable parcelable7 = parcelableArrayExtra2[2];
            SecureDfuImpl.DFU_PACKET_UUID = parcelable7 != null ? ((ParcelUuid) parcelable7).getUuid() : SecureDfuImpl.DEFAULT_DFU_PACKET_UUID;
        }
        Parcelable[] parcelableArrayExtra3 = intent.getParcelableArrayExtra(DfuBaseService.EXTRA_CUSTOM_UUIDS_FOR_EXPERIMENTAL_BUTTONLESS_DFU);
        if (parcelableArrayExtra3 == null || parcelableArrayExtra3.length != 2) {
            ExperimentalButtonlessDfuImpl.EXPERIMENTAL_BUTTONLESS_DFU_SERVICE_UUID = ExperimentalButtonlessDfuImpl.DEFAULT_EXPERIMENTAL_BUTTONLESS_DFU_SERVICE_UUID;
            ExperimentalButtonlessDfuImpl.EXPERIMENTAL_BUTTONLESS_DFU_UUID = ExperimentalButtonlessDfuImpl.DEFAULT_EXPERIMENTAL_BUTTONLESS_DFU_UUID;
        } else {
            Parcelable parcelable8 = parcelableArrayExtra3[0];
            ExperimentalButtonlessDfuImpl.EXPERIMENTAL_BUTTONLESS_DFU_SERVICE_UUID = parcelable8 != null ? ((ParcelUuid) parcelable8).getUuid() : ExperimentalButtonlessDfuImpl.DEFAULT_EXPERIMENTAL_BUTTONLESS_DFU_SERVICE_UUID;
            Parcelable parcelable9 = parcelableArrayExtra3[1];
            ExperimentalButtonlessDfuImpl.EXPERIMENTAL_BUTTONLESS_DFU_UUID = parcelable9 != null ? ((ParcelUuid) parcelable9).getUuid() : ExperimentalButtonlessDfuImpl.DEFAULT_EXPERIMENTAL_BUTTONLESS_DFU_UUID;
        }
        Parcelable[] parcelableArrayExtra4 = intent.getParcelableArrayExtra(DfuBaseService.EXTRA_CUSTOM_UUIDS_FOR_BUTTONLESS_DFU_WITHOUT_BOND_SHARING);
        if (parcelableArrayExtra4 == null || parcelableArrayExtra4.length != 2) {
            ButtonlessDfuWithoutBondSharingImpl.BUTTONLESS_DFU_SERVICE_UUID = ButtonlessDfuWithoutBondSharingImpl.DEFAULT_BUTTONLESS_DFU_SERVICE_UUID;
            ButtonlessDfuWithoutBondSharingImpl.BUTTONLESS_DFU_UUID = ButtonlessDfuWithoutBondSharingImpl.DEFAULT_BUTTONLESS_DFU_UUID;
        } else {
            Parcelable parcelable10 = parcelableArrayExtra4[0];
            ButtonlessDfuWithoutBondSharingImpl.BUTTONLESS_DFU_SERVICE_UUID = parcelable10 != null ? ((ParcelUuid) parcelable10).getUuid() : ButtonlessDfuWithoutBondSharingImpl.DEFAULT_BUTTONLESS_DFU_SERVICE_UUID;
            Parcelable parcelable11 = parcelableArrayExtra4[1];
            ButtonlessDfuWithoutBondSharingImpl.BUTTONLESS_DFU_UUID = parcelable11 != null ? ((ParcelUuid) parcelable11).getUuid() : ButtonlessDfuWithoutBondSharingImpl.DEFAULT_BUTTONLESS_DFU_UUID;
        }
        Parcelable[] parcelableArrayExtra5 = intent.getParcelableArrayExtra(DfuBaseService.EXTRA_CUSTOM_UUIDS_FOR_BUTTONLESS_DFU_WITH_BOND_SHARING);
        if (parcelableArrayExtra5 == null || parcelableArrayExtra5.length != 2) {
            ButtonlessDfuWithBondSharingImpl.BUTTONLESS_DFU_SERVICE_UUID = ButtonlessDfuWithBondSharingImpl.DEFAULT_BUTTONLESS_DFU_SERVICE_UUID;
            ButtonlessDfuWithBondSharingImpl.BUTTONLESS_DFU_UUID = ButtonlessDfuWithBondSharingImpl.DEFAULT_BUTTONLESS_DFU_UUID;
            return;
        }
        Parcelable parcelable12 = parcelableArrayExtra5[0];
        ButtonlessDfuWithBondSharingImpl.BUTTONLESS_DFU_SERVICE_UUID = parcelable12 != null ? ((ParcelUuid) parcelable12).getUuid() : ButtonlessDfuWithBondSharingImpl.DEFAULT_BUTTONLESS_DFU_SERVICE_UUID;
        Parcelable parcelable13 = parcelableArrayExtra5[1];
        ButtonlessDfuWithBondSharingImpl.BUTTONLESS_DFU_UUID = parcelable13 != null ? ((ParcelUuid) parcelable13).getUuid() : ButtonlessDfuWithBondSharingImpl.DEFAULT_BUTTONLESS_DFU_UUID;
    }
}
