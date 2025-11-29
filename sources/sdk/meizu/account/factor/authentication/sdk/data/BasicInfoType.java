package sdk.meizu.account.factor.authentication.sdk.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u000eHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000eHÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u001a"}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/data/BasicInfoType;", "Landroid/os/Parcelable;", "Lsdk/meizu/account/factor/authentication/sdk/data/ValidateBasic;", "validateType", "", "validateAccount", "(Ljava/lang/String;Ljava/lang/String;)V", "getValidateAccount", "()Ljava/lang/String;", "getValidateType", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Parcelize
public final class BasicInfoType implements Parcelable, ValidateBasic {
    @NotNull
    public static final Parcelable.Creator<BasicInfoType> CREATOR = new Creator();
    @SerializedName("validateAccount")
    @NotNull
    private final String validateAccount;
    @SerializedName("validateType")
    @NotNull
    private final String validateType;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<BasicInfoType> {
        @NotNull
        public final BasicInfoType createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new BasicInfoType(parcel.readString(), parcel.readString());
        }

        @NotNull
        public final BasicInfoType[] newArray(int i) {
            return new BasicInfoType[i];
        }
    }

    public BasicInfoType(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "validateType");
        Intrinsics.checkNotNullParameter(str2, "validateAccount");
        this.validateType = str;
        this.validateAccount = str2;
    }

    public static /* synthetic */ BasicInfoType copy$default(BasicInfoType basicInfoType, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = basicInfoType.validateType;
        }
        if ((i & 2) != 0) {
            str2 = basicInfoType.validateAccount;
        }
        return basicInfoType.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.validateType;
    }

    @NotNull
    public final String component2() {
        return this.validateAccount;
    }

    @NotNull
    public final BasicInfoType copy(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "validateType");
        Intrinsics.checkNotNullParameter(str2, "validateAccount");
        return new BasicInfoType(str, str2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BasicInfoType)) {
            return false;
        }
        BasicInfoType basicInfoType = (BasicInfoType) obj;
        return Intrinsics.areEqual((Object) this.validateType, (Object) basicInfoType.validateType) && Intrinsics.areEqual((Object) this.validateAccount, (Object) basicInfoType.validateAccount);
    }

    @NotNull
    public final String getValidateAccount() {
        return this.validateAccount;
    }

    @NotNull
    public final String getValidateType() {
        return this.validateType;
    }

    public int hashCode() {
        return (this.validateType.hashCode() * 31) + this.validateAccount.hashCode();
    }

    @NotNull
    public String toString() {
        return "BasicInfoType(validateType=" + this.validateType + ", validateAccount=" + this.validateAccount + ')';
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.validateType);
        parcel.writeString(this.validateAccount);
    }
}
