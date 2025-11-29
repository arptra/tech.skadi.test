package sdk.meizu.account.factor.authentication.sdk.data;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001d"}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/data/GeetestInitData;", "Landroid/os/Parcelable;", "success", "", "challenge", "", "gt", "(ILjava/lang/String;Ljava/lang/String;)V", "getChallenge", "()Ljava/lang/String;", "getGt", "getSuccess", "()I", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Parcelize
public final class GeetestInitData implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<GeetestInitData> CREATOR = new Creator();
    @NotNull
    private final String challenge;
    @NotNull
    private final String gt;
    private final int success;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<GeetestInitData> {
        @NotNull
        public final GeetestInitData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new GeetestInitData(parcel.readInt(), parcel.readString(), parcel.readString());
        }

        @NotNull
        public final GeetestInitData[] newArray(int i) {
            return new GeetestInitData[i];
        }
    }

    public GeetestInitData(int i, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "challenge");
        Intrinsics.checkNotNullParameter(str2, "gt");
        this.success = i;
        this.challenge = str;
        this.gt = str2;
    }

    public static /* synthetic */ GeetestInitData copy$default(GeetestInitData geetestInitData, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = geetestInitData.success;
        }
        if ((i2 & 2) != 0) {
            str = geetestInitData.challenge;
        }
        if ((i2 & 4) != 0) {
            str2 = geetestInitData.gt;
        }
        return geetestInitData.copy(i, str, str2);
    }

    public final int component1() {
        return this.success;
    }

    @NotNull
    public final String component2() {
        return this.challenge;
    }

    @NotNull
    public final String component3() {
        return this.gt;
    }

    @NotNull
    public final GeetestInitData copy(int i, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "challenge");
        Intrinsics.checkNotNullParameter(str2, "gt");
        return new GeetestInitData(i, str, str2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GeetestInitData)) {
            return false;
        }
        GeetestInitData geetestInitData = (GeetestInitData) obj;
        return this.success == geetestInitData.success && Intrinsics.areEqual((Object) this.challenge, (Object) geetestInitData.challenge) && Intrinsics.areEqual((Object) this.gt, (Object) geetestInitData.gt);
    }

    @NotNull
    public final String getChallenge() {
        return this.challenge;
    }

    @NotNull
    public final String getGt() {
        return this.gt;
    }

    public final int getSuccess() {
        return this.success;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.success) * 31) + this.challenge.hashCode()) * 31) + this.gt.hashCode();
    }

    @NotNull
    public String toString() {
        return "GeetestInitData(success=" + this.success + ", challenge=" + this.challenge + ", gt=" + this.gt + ')';
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.success);
        parcel.writeString(this.challenge);
        parcel.writeString(this.gt);
    }
}
