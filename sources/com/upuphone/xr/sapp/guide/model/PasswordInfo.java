package com.upuphone.xr.sapp.guide.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001J\b\u0010\u001f\u001a\u00020\u0003H\u0016J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\f¨\u0006%"}, d2 = {"Lcom/upuphone/xr/sapp/guide/model/PasswordInfo;", "Landroid/os/Parcelable;", "mSid", "", "mPassword", "mState", "", "mIndex", "(Ljava/lang/String;Ljava/lang/String;II)V", "getMIndex", "()I", "setMIndex", "(I)V", "getMPassword", "()Ljava/lang/String;", "setMPassword", "(Ljava/lang/String;)V", "getMSid", "getMState", "setMState", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Parcelize
@Keep
public final class PasswordInfo implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<PasswordInfo> CREATOR = new Creator();
    private int mIndex;
    @NotNull
    private String mPassword;
    @NotNull
    private final String mSid;
    private int mState;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PasswordInfo> {
        /* renamed from: a */
        public final PasswordInfo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PasswordInfo(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt());
        }

        /* renamed from: b */
        public final PasswordInfo[] newArray(int i) {
            return new PasswordInfo[i];
        }
    }

    public PasswordInfo(@NotNull String str, @NotNull String str2, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "mSid");
        Intrinsics.checkNotNullParameter(str2, "mPassword");
        this.mSid = str;
        this.mPassword = str2;
        this.mState = i;
        this.mIndex = i2;
    }

    public static /* synthetic */ PasswordInfo copy$default(PasswordInfo passwordInfo, String str, String str2, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = passwordInfo.mSid;
        }
        if ((i3 & 2) != 0) {
            str2 = passwordInfo.mPassword;
        }
        if ((i3 & 4) != 0) {
            i = passwordInfo.mState;
        }
        if ((i3 & 8) != 0) {
            i2 = passwordInfo.mIndex;
        }
        return passwordInfo.copy(str, str2, i, i2);
    }

    @NotNull
    public final String component1() {
        return this.mSid;
    }

    @NotNull
    public final String component2() {
        return this.mPassword;
    }

    public final int component3() {
        return this.mState;
    }

    public final int component4() {
        return this.mIndex;
    }

    @NotNull
    public final PasswordInfo copy(@NotNull String str, @NotNull String str2, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "mSid");
        Intrinsics.checkNotNullParameter(str2, "mPassword");
        return new PasswordInfo(str, str2, i, i2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PasswordInfo)) {
            return false;
        }
        PasswordInfo passwordInfo = (PasswordInfo) obj;
        return Intrinsics.areEqual((Object) this.mSid, (Object) passwordInfo.mSid) && Intrinsics.areEqual((Object) this.mPassword, (Object) passwordInfo.mPassword) && this.mState == passwordInfo.mState && this.mIndex == passwordInfo.mIndex;
    }

    public final int getMIndex() {
        return this.mIndex;
    }

    @NotNull
    public final String getMPassword() {
        return this.mPassword;
    }

    @NotNull
    public final String getMSid() {
        return this.mSid;
    }

    public final int getMState() {
        return this.mState;
    }

    public int hashCode() {
        return (((((this.mSid.hashCode() * 31) + this.mPassword.hashCode()) * 31) + Integer.hashCode(this.mState)) * 31) + Integer.hashCode(this.mIndex);
    }

    public final void setMIndex(int i) {
        this.mIndex = i;
    }

    public final void setMPassword(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mPassword = str;
    }

    public final void setMState(int i) {
        this.mState = i;
    }

    @NotNull
    public String toString() {
        String str = this.mSid;
        String str2 = this.mPassword;
        int i = this.mState;
        int i2 = this.mIndex;
        return "PasswordInfo(mSid='" + str + "', mPassword='" + str2 + "', mState=" + i + ", mIndex=" + i2 + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.mSid);
        parcel.writeString(this.mPassword);
        parcel.writeInt(this.mState);
        parcel.writeInt(this.mIndex);
    }
}
