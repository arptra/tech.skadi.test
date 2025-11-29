package sdk.meizu.account.factor.authentication.sdk.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\u000f¨\u0006 "}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/data/AnswerType;", "Landroid/os/Parcelable;", "Lsdk/meizu/account/factor/authentication/sdk/data/ValidateBasic;", "desc", "", "question", "", "secret", "(Ljava/lang/String;ILjava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "getQuestion", "()I", "getSecret", "setSecret", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Parcelize
public final class AnswerType implements Parcelable, ValidateBasic {
    @NotNull
    public static final Parcelable.Creator<AnswerType> CREATOR = new Creator();
    @SerializedName("desc")
    @NotNull
    private final String desc;
    @SerializedName("value")
    private final int question;
    @NotNull
    private String secret;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AnswerType> {
        @NotNull
        public final AnswerType createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AnswerType(parcel.readString(), parcel.readInt(), parcel.readString());
        }

        @NotNull
        public final AnswerType[] newArray(int i) {
            return new AnswerType[i];
        }
    }

    public AnswerType(@NotNull String str, int i, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "desc");
        Intrinsics.checkNotNullParameter(str2, "secret");
        this.desc = str;
        this.question = i;
        this.secret = str2;
    }

    public static /* synthetic */ AnswerType copy$default(AnswerType answerType, String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = answerType.desc;
        }
        if ((i2 & 2) != 0) {
            i = answerType.question;
        }
        if ((i2 & 4) != 0) {
            str2 = answerType.secret;
        }
        return answerType.copy(str, i, str2);
    }

    @NotNull
    public final String component1() {
        return this.desc;
    }

    public final int component2() {
        return this.question;
    }

    @NotNull
    public final String component3() {
        return this.secret;
    }

    @NotNull
    public final AnswerType copy(@NotNull String str, int i, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "desc");
        Intrinsics.checkNotNullParameter(str2, "secret");
        return new AnswerType(str, i, str2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AnswerType)) {
            return false;
        }
        AnswerType answerType = (AnswerType) obj;
        return Intrinsics.areEqual((Object) this.desc, (Object) answerType.desc) && this.question == answerType.question && Intrinsics.areEqual((Object) this.secret, (Object) answerType.secret);
    }

    @NotNull
    public final String getDesc() {
        return this.desc;
    }

    public final int getQuestion() {
        return this.question;
    }

    @NotNull
    public final String getSecret() {
        return this.secret;
    }

    public int hashCode() {
        return (((this.desc.hashCode() * 31) + Integer.hashCode(this.question)) * 31) + this.secret.hashCode();
    }

    public final void setSecret(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.secret = str;
    }

    @NotNull
    public String toString() {
        return "AnswerType(desc=" + this.desc + ", question=" + this.question + ", secret=" + this.secret + ')';
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.desc);
        parcel.writeInt(this.question);
        parcel.writeString(this.secret);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AnswerType(String str, int i, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, (i2 & 4) != 0 ? "" : str2);
    }
}
