package com.upuphone.xr.sapp.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.upuphone.star.core.log.ULog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jg\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\u0006\u0010)\u001a\u00020$J\u0006\u0010*\u001a\u00020\u0003J\t\u0010+\u001a\u00020$HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001J\u0019\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020$HÖ\u0001R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0014R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000e¨\u00062"}, d2 = {"Lcom/upuphone/xr/sapp/entity/DeviceInfo;", "Landroid/os/Parcelable;", "name", "", "brand", "serialNo", "model", "wifiMac", "btAddr", "totalStorage", "availableStorage", "romVersion", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAvailableStorage", "()Ljava/lang/String;", "getBrand", "getBtAddr", "getModel", "getName", "setName", "(Ljava/lang/String;)V", "getRomVersion", "getSerialNo", "getTotalStorage", "getWifiMac", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "", "other", "", "getProgress", "getUsedStorageTx", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Parcelize
@Keep
public final class DeviceInfo implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<DeviceInfo> CREATOR = new Creator();
    @SerializedName("available_storage")
    @NotNull
    private final String availableStorage;
    @SerializedName("brand")
    @NotNull
    private final String brand;
    @SerializedName("bluetooth_addr")
    @NotNull
    private final String btAddr;
    @SerializedName("system_mode")
    @NotNull
    private final String model;
    @SerializedName("device_name")
    @NotNull
    private String name;
    @SerializedName("rom_version")
    @Nullable
    private final String romVersion;
    @SerializedName("serial_number")
    @Nullable
    private final String serialNo;
    @SerializedName("total_storage")
    @NotNull
    private final String totalStorage;
    @SerializedName("wifi_mac")
    @NotNull
    private final String wifiMac;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DeviceInfo> {
        @NotNull
        public final DeviceInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DeviceInfo(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @NotNull
        public final DeviceInfo[] newArray(int i) {
            return new DeviceInfo[i];
        }
    }

    public DeviceInfo(@NotNull String str, @NotNull String str2, @Nullable String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @Nullable String str9) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "brand");
        Intrinsics.checkNotNullParameter(str4, "model");
        Intrinsics.checkNotNullParameter(str5, "wifiMac");
        Intrinsics.checkNotNullParameter(str6, "btAddr");
        Intrinsics.checkNotNullParameter(str7, "totalStorage");
        Intrinsics.checkNotNullParameter(str8, "availableStorage");
        this.name = str;
        this.brand = str2;
        this.serialNo = str3;
        this.model = str4;
        this.wifiMac = str5;
        this.btAddr = str6;
        this.totalStorage = str7;
        this.availableStorage = str8;
        this.romVersion = str9;
    }

    public static /* synthetic */ DeviceInfo copy$default(DeviceInfo deviceInfo, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, Object obj) {
        DeviceInfo deviceInfo2 = deviceInfo;
        int i2 = i;
        return deviceInfo.copy((i2 & 1) != 0 ? deviceInfo2.name : str, (i2 & 2) != 0 ? deviceInfo2.brand : str2, (i2 & 4) != 0 ? deviceInfo2.serialNo : str3, (i2 & 8) != 0 ? deviceInfo2.model : str4, (i2 & 16) != 0 ? deviceInfo2.wifiMac : str5, (i2 & 32) != 0 ? deviceInfo2.btAddr : str6, (i2 & 64) != 0 ? deviceInfo2.totalStorage : str7, (i2 & 128) != 0 ? deviceInfo2.availableStorage : str8, (i2 & 256) != 0 ? deviceInfo2.romVersion : str9);
    }

    @NotNull
    public final String component1() {
        return this.name;
    }

    @NotNull
    public final String component2() {
        return this.brand;
    }

    @Nullable
    public final String component3() {
        return this.serialNo;
    }

    @NotNull
    public final String component4() {
        return this.model;
    }

    @NotNull
    public final String component5() {
        return this.wifiMac;
    }

    @NotNull
    public final String component6() {
        return this.btAddr;
    }

    @NotNull
    public final String component7() {
        return this.totalStorage;
    }

    @NotNull
    public final String component8() {
        return this.availableStorage;
    }

    @Nullable
    public final String component9() {
        return this.romVersion;
    }

    @NotNull
    public final DeviceInfo copy(@NotNull String str, @NotNull String str2, @Nullable String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @Nullable String str9) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "brand");
        Intrinsics.checkNotNullParameter(str4, "model");
        String str10 = str5;
        Intrinsics.checkNotNullParameter(str10, "wifiMac");
        String str11 = str6;
        Intrinsics.checkNotNullParameter(str11, "btAddr");
        String str12 = str7;
        Intrinsics.checkNotNullParameter(str12, "totalStorage");
        String str13 = str8;
        Intrinsics.checkNotNullParameter(str13, "availableStorage");
        return new DeviceInfo(str, str2, str3, str4, str10, str11, str12, str13, str9);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceInfo)) {
            return false;
        }
        DeviceInfo deviceInfo = (DeviceInfo) obj;
        return Intrinsics.areEqual((Object) this.name, (Object) deviceInfo.name) && Intrinsics.areEqual((Object) this.brand, (Object) deviceInfo.brand) && Intrinsics.areEqual((Object) this.serialNo, (Object) deviceInfo.serialNo) && Intrinsics.areEqual((Object) this.model, (Object) deviceInfo.model) && Intrinsics.areEqual((Object) this.wifiMac, (Object) deviceInfo.wifiMac) && Intrinsics.areEqual((Object) this.btAddr, (Object) deviceInfo.btAddr) && Intrinsics.areEqual((Object) this.totalStorage, (Object) deviceInfo.totalStorage) && Intrinsics.areEqual((Object) this.availableStorage, (Object) deviceInfo.availableStorage) && Intrinsics.areEqual((Object) this.romVersion, (Object) deviceInfo.romVersion);
    }

    @NotNull
    public final String getAvailableStorage() {
        return this.availableStorage;
    }

    @NotNull
    public final String getBrand() {
        return this.brand;
    }

    @NotNull
    public final String getBtAddr() {
        return this.btAddr;
    }

    @NotNull
    public final String getModel() {
        return this.model;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final int getProgress() {
        String replace = StringsKt.replace(this.totalStorage, "GB", "", true);
        String replace2 = StringsKt.replace(this.availableStorage, "GB", "", true);
        if (TextUtils.isEmpty(replace) || TextUtils.isEmpty(replace2)) {
            return 0;
        }
        try {
            float parseFloat = Float.parseFloat(replace);
            float parseFloat2 = Float.parseFloat(replace2);
            if (parseFloat == 0.0f) {
                return 0;
            }
            return (int) (((parseFloat - parseFloat2) * ((float) 100)) / parseFloat);
        } catch (NumberFormatException e) {
            ULog.f6446a.c("AboutGlassFragment", e.getMessage());
            return 0;
        }
    }

    @Nullable
    public final String getRomVersion() {
        return this.romVersion;
    }

    @Nullable
    public final String getSerialNo() {
        return this.serialNo;
    }

    @NotNull
    public final String getTotalStorage() {
        return this.totalStorage;
    }

    @NotNull
    public final String getUsedStorageTx() {
        String replace = StringsKt.replace(this.totalStorage, "GB", "", true);
        String replace2 = StringsKt.replace(this.availableStorage, "GB", "", true);
        if (TextUtils.isEmpty(replace) || TextUtils.isEmpty(replace2)) {
            return "0GB";
        }
        try {
            float parseFloat = Float.parseFloat(replace);
            float parseFloat2 = Float.parseFloat(replace2);
            if (parseFloat == 0.0f) {
                String str = this.totalStorage;
                return "0GB/" + str;
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(parseFloat - parseFloat2)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            String str2 = this.totalStorage;
            return format + "GB/" + str2;
        } catch (NumberFormatException e) {
            ULog.f6446a.c("AboutGlassFragment", e.getMessage());
            String str3 = this.totalStorage;
            return "0GB/" + str3;
        }
    }

    @NotNull
    public final String getWifiMac() {
        return this.wifiMac;
    }

    public int hashCode() {
        int hashCode = ((this.name.hashCode() * 31) + this.brand.hashCode()) * 31;
        String str = this.serialNo;
        int i = 0;
        int hashCode2 = (((((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.model.hashCode()) * 31) + this.wifiMac.hashCode()) * 31) + this.btAddr.hashCode()) * 31) + this.totalStorage.hashCode()) * 31) + this.availableStorage.hashCode()) * 31;
        String str2 = this.romVersion;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public final void setName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    @NotNull
    public String toString() {
        String str = this.name;
        String str2 = this.brand;
        String str3 = this.serialNo;
        String str4 = this.model;
        String str5 = this.wifiMac;
        String str6 = this.btAddr;
        String str7 = this.totalStorage;
        String str8 = this.availableStorage;
        String str9 = this.romVersion;
        return "DeviceInfo(name=" + str + ", brand=" + str2 + ", serialNo=" + str3 + ", model=" + str4 + ", wifiMac=" + str5 + ", btAddr=" + str6 + ", totalStorage=" + str7 + ", availableStorage=" + str8 + ", romVersion=" + str9 + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.name);
        parcel.writeString(this.brand);
        parcel.writeString(this.serialNo);
        parcel.writeString(this.model);
        parcel.writeString(this.wifiMac);
        parcel.writeString(this.btAddr);
        parcel.writeString(this.totalStorage);
        parcel.writeString(this.availableStorage);
        parcel.writeString(this.romVersion);
    }
}
