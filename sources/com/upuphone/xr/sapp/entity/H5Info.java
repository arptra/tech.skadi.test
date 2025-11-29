package com.upuphone.xr.sapp.entity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\b\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\b¨\u0006\u001e"}, d2 = {"Lcom/upuphone/xr/sapp/entity/H5Info;", "Landroid/os/Parcelable;", "deviceType", "", "pageType", "deviceModel", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDeviceModel", "()Ljava/lang/String;", "getDeviceType", "setDeviceType", "(Ljava/lang/String;)V", "getPageType", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Parcelize
@Keep
public final class H5Info implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<H5Info> CREATOR = new Creator();
    @NotNull
    private final String deviceModel;
    @NotNull
    private String deviceType;
    @NotNull
    private final String pageType;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<H5Info> {
        @NotNull
        public final H5Info createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new H5Info(parcel.readString(), parcel.readString(), parcel.readString());
        }

        @NotNull
        public final H5Info[] newArray(int i) {
            return new H5Info[i];
        }
    }

    public H5Info(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "deviceType");
        Intrinsics.checkNotNullParameter(str2, "pageType");
        Intrinsics.checkNotNullParameter(str3, "deviceModel");
        this.deviceType = str;
        this.pageType = str2;
        this.deviceModel = str3;
    }

    public static /* synthetic */ H5Info copy$default(H5Info h5Info, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = h5Info.deviceType;
        }
        if ((i & 2) != 0) {
            str2 = h5Info.pageType;
        }
        if ((i & 4) != 0) {
            str3 = h5Info.deviceModel;
        }
        return h5Info.copy(str, str2, str3);
    }

    @NotNull
    public final String component1() {
        return this.deviceType;
    }

    @NotNull
    public final String component2() {
        return this.pageType;
    }

    @NotNull
    public final String component3() {
        return this.deviceModel;
    }

    @NotNull
    public final H5Info copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "deviceType");
        Intrinsics.checkNotNullParameter(str2, "pageType");
        Intrinsics.checkNotNullParameter(str3, "deviceModel");
        return new H5Info(str, str2, str3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof H5Info)) {
            return false;
        }
        H5Info h5Info = (H5Info) obj;
        return Intrinsics.areEqual((Object) this.deviceType, (Object) h5Info.deviceType) && Intrinsics.areEqual((Object) this.pageType, (Object) h5Info.pageType) && Intrinsics.areEqual((Object) this.deviceModel, (Object) h5Info.deviceModel);
    }

    @NotNull
    public final String getDeviceModel() {
        return this.deviceModel;
    }

    @NotNull
    public final String getDeviceType() {
        return this.deviceType;
    }

    @NotNull
    public final String getPageType() {
        return this.pageType;
    }

    public int hashCode() {
        return (((this.deviceType.hashCode() * 31) + this.pageType.hashCode()) * 31) + this.deviceModel.hashCode();
    }

    public final void setDeviceType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.deviceType = str;
    }

    @NotNull
    public String toString() {
        String str = this.deviceType;
        String str2 = this.pageType;
        String str3 = this.deviceModel;
        return "H5Info(deviceType='" + str + "', pageType='" + str2 + "', deviceModel='" + str3 + "')";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.deviceType);
        parcel.writeString(this.pageType);
        parcel.writeString(this.deviceModel);
    }
}
