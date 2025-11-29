package com.upuphone.xr.sapp.guide.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001J\b\u0010\u001c\u001a\u00020\u0005H\u0016J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\""}, d2 = {"Lcom/upuphone/xr/sapp/guide/model/ConnectResult;", "Landroid/os/Parcelable;", "mResult", "", "mDeviceID", "", "mErrorCode", "", "(ZLjava/lang/String;I)V", "getMDeviceID", "()Ljava/lang/String;", "setMDeviceID", "(Ljava/lang/String;)V", "getMErrorCode", "()I", "setMErrorCode", "(I)V", "getMResult", "()Z", "component1", "component2", "component3", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Parcelize
@Keep
public final class ConnectResult implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<ConnectResult> CREATOR = new Creator();
    @NotNull
    private String mDeviceID;
    private int mErrorCode;
    private final boolean mResult;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ConnectResult> {
        /* renamed from: a */
        public final ConnectResult createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ConnectResult(parcel.readInt() != 0, parcel.readString(), parcel.readInt());
        }

        /* renamed from: b */
        public final ConnectResult[] newArray(int i) {
            return new ConnectResult[i];
        }
    }

    public ConnectResult(boolean z, @NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "mDeviceID");
        this.mResult = z;
        this.mDeviceID = str;
        this.mErrorCode = i;
    }

    public static /* synthetic */ ConnectResult copy$default(ConnectResult connectResult, boolean z, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = connectResult.mResult;
        }
        if ((i2 & 2) != 0) {
            str = connectResult.mDeviceID;
        }
        if ((i2 & 4) != 0) {
            i = connectResult.mErrorCode;
        }
        return connectResult.copy(z, str, i);
    }

    public final boolean component1() {
        return this.mResult;
    }

    @NotNull
    public final String component2() {
        return this.mDeviceID;
    }

    public final int component3() {
        return this.mErrorCode;
    }

    @NotNull
    public final ConnectResult copy(boolean z, @NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "mDeviceID");
        return new ConnectResult(z, str, i);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConnectResult)) {
            return false;
        }
        ConnectResult connectResult = (ConnectResult) obj;
        return this.mResult == connectResult.mResult && Intrinsics.areEqual((Object) this.mDeviceID, (Object) connectResult.mDeviceID) && this.mErrorCode == connectResult.mErrorCode;
    }

    @NotNull
    public final String getMDeviceID() {
        return this.mDeviceID;
    }

    public final int getMErrorCode() {
        return this.mErrorCode;
    }

    public final boolean getMResult() {
        return this.mResult;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.mResult) * 31) + this.mDeviceID.hashCode()) * 31) + Integer.hashCode(this.mErrorCode);
    }

    public final void setMDeviceID(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mDeviceID = str;
    }

    public final void setMErrorCode(int i) {
        this.mErrorCode = i;
    }

    @NotNull
    public String toString() {
        boolean z = this.mResult;
        String str = this.mDeviceID;
        int i = this.mErrorCode;
        return "ConnectResult(mResult=" + z + ", mDeviceID='" + str + "', mErrorCode=" + i + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.mResult ? 1 : 0);
        parcel.writeString(this.mDeviceID);
        parcel.writeInt(this.mErrorCode);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConnectResult(boolean z, String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, str, (i2 & 4) != 0 ? 0 : i);
    }
}
