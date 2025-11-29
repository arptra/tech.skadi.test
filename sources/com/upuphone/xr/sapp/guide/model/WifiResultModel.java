package com.upuphone.xr.sapp.guide.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0016\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001J\b\u0010\u001c\u001a\u00020\u0003H\u0016J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0007HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\""}, d2 = {"Lcom/upuphone/xr/sapp/guide/model/WifiResultModel;", "Landroid/os/Parcelable;", "mSsid", "", "mBssid", "mSetChange", "mState", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getMBssid", "()Ljava/lang/String;", "getMSetChange", "getMSsid", "getMState", "()I", "setMState", "(I)V", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Parcelize
@Keep
public final class WifiResultModel implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<WifiResultModel> CREATOR = new Creator();
    @SerializedName("bssid")
    @NotNull
    private final String mBssid;
    @SerializedName("change")
    @NotNull
    private final String mSetChange;
    @SerializedName("ssid")
    @NotNull
    private final String mSsid;
    @SerializedName("state")
    private int mState;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<WifiResultModel> {
        /* renamed from: a */
        public final WifiResultModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new WifiResultModel(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt());
        }

        /* renamed from: b */
        public final WifiResultModel[] newArray(int i) {
            return new WifiResultModel[i];
        }
    }

    public WifiResultModel(@NotNull String str, @NotNull String str2, @NotNull String str3, int i) {
        Intrinsics.checkNotNullParameter(str, "mSsid");
        Intrinsics.checkNotNullParameter(str2, "mBssid");
        Intrinsics.checkNotNullParameter(str3, "mSetChange");
        this.mSsid = str;
        this.mBssid = str2;
        this.mSetChange = str3;
        this.mState = i;
    }

    public static /* synthetic */ WifiResultModel copy$default(WifiResultModel wifiResultModel, String str, String str2, String str3, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = wifiResultModel.mSsid;
        }
        if ((i2 & 2) != 0) {
            str2 = wifiResultModel.mBssid;
        }
        if ((i2 & 4) != 0) {
            str3 = wifiResultModel.mSetChange;
        }
        if ((i2 & 8) != 0) {
            i = wifiResultModel.mState;
        }
        return wifiResultModel.copy(str, str2, str3, i);
    }

    @NotNull
    public final String component1() {
        return this.mSsid;
    }

    @NotNull
    public final String component2() {
        return this.mBssid;
    }

    @NotNull
    public final String component3() {
        return this.mSetChange;
    }

    public final int component4() {
        return this.mState;
    }

    @NotNull
    public final WifiResultModel copy(@NotNull String str, @NotNull String str2, @NotNull String str3, int i) {
        Intrinsics.checkNotNullParameter(str, "mSsid");
        Intrinsics.checkNotNullParameter(str2, "mBssid");
        Intrinsics.checkNotNullParameter(str3, "mSetChange");
        return new WifiResultModel(str, str2, str3, i);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WifiResultModel)) {
            return false;
        }
        WifiResultModel wifiResultModel = (WifiResultModel) obj;
        return Intrinsics.areEqual((Object) this.mSsid, (Object) wifiResultModel.mSsid) && Intrinsics.areEqual((Object) this.mBssid, (Object) wifiResultModel.mBssid) && Intrinsics.areEqual((Object) this.mSetChange, (Object) wifiResultModel.mSetChange) && this.mState == wifiResultModel.mState;
    }

    @NotNull
    public final String getMBssid() {
        return this.mBssid;
    }

    @NotNull
    public final String getMSetChange() {
        return this.mSetChange;
    }

    @NotNull
    public final String getMSsid() {
        return this.mSsid;
    }

    public final int getMState() {
        return this.mState;
    }

    public int hashCode() {
        return (((((this.mSsid.hashCode() * 31) + this.mBssid.hashCode()) * 31) + this.mSetChange.hashCode()) * 31) + Integer.hashCode(this.mState);
    }

    public final void setMState(int i) {
        this.mState = i;
    }

    @NotNull
    public String toString() {
        String str = this.mSsid;
        String str2 = this.mBssid;
        String str3 = this.mSetChange;
        int i = this.mState;
        return "WifiResultModel(mSsid='" + str + "', mBssid='" + str2 + "', mSetChange='" + str3 + "', mState=" + i + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.mSsid);
        parcel.writeString(this.mBssid);
        parcel.writeString(this.mSetChange);
        parcel.writeInt(this.mState);
    }
}
