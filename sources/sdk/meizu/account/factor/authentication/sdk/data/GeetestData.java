package sdk.meizu.account.factor.authentication.sdk.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.meizu.account.factor.authentication.sdk.constant.NetworkParamsKt;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u001d"}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/data/GeetestData;", "Landroid/os/Parcelable;", "challenge", "", "validate", "seccode", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChallenge", "()Ljava/lang/String;", "getSeccode", "getValidate", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Parcelize
public final class GeetestData implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<GeetestData> CREATOR = new Creator();
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String TAG = "GeetestData";
    @NotNull
    private final String challenge;
    @NotNull
    private final String seccode;
    @NotNull
    private final String validate;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/data/GeetestData$Companion;", "", "()V", "TAG", "", "parseData", "Lsdk/meizu/account/factor/authentication/sdk/data/GeetestData;", "response", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final GeetestData parseData(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "response");
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString(NetworkParamsKt.REQUEST_PARAM_GEETEST_CHALLENGE);
                Intrinsics.checkNotNullExpressionValue(optString, "optString(...)");
                String optString2 = jSONObject.optString(NetworkParamsKt.REQUEST_PARAM_GEETEST_VALIDATE);
                Intrinsics.checkNotNullExpressionValue(optString2, "optString(...)");
                String optString3 = jSONObject.optString(NetworkParamsKt.REQUEST_PARAM_GEETEST_SECCODE);
                Intrinsics.checkNotNullExpressionValue(optString3, "optString(...)");
                return new GeetestData(optString, optString2, optString3);
            } catch (JSONException e) {
                Log.e("GeetestData", "parse data fail. ", e);
                return null;
            }
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<GeetestData> {
        @NotNull
        public final GeetestData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new GeetestData(parcel.readString(), parcel.readString(), parcel.readString());
        }

        @NotNull
        public final GeetestData[] newArray(int i) {
            return new GeetestData[i];
        }
    }

    public GeetestData(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "challenge");
        Intrinsics.checkNotNullParameter(str2, "validate");
        Intrinsics.checkNotNullParameter(str3, "seccode");
        this.challenge = str;
        this.validate = str2;
        this.seccode = str3;
    }

    public static /* synthetic */ GeetestData copy$default(GeetestData geetestData, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = geetestData.challenge;
        }
        if ((i & 2) != 0) {
            str2 = geetestData.validate;
        }
        if ((i & 4) != 0) {
            str3 = geetestData.seccode;
        }
        return geetestData.copy(str, str2, str3);
    }

    @NotNull
    public final String component1() {
        return this.challenge;
    }

    @NotNull
    public final String component2() {
        return this.validate;
    }

    @NotNull
    public final String component3() {
        return this.seccode;
    }

    @NotNull
    public final GeetestData copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "challenge");
        Intrinsics.checkNotNullParameter(str2, "validate");
        Intrinsics.checkNotNullParameter(str3, "seccode");
        return new GeetestData(str, str2, str3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GeetestData)) {
            return false;
        }
        GeetestData geetestData = (GeetestData) obj;
        return Intrinsics.areEqual((Object) this.challenge, (Object) geetestData.challenge) && Intrinsics.areEqual((Object) this.validate, (Object) geetestData.validate) && Intrinsics.areEqual((Object) this.seccode, (Object) geetestData.seccode);
    }

    @NotNull
    public final String getChallenge() {
        return this.challenge;
    }

    @NotNull
    public final String getSeccode() {
        return this.seccode;
    }

    @NotNull
    public final String getValidate() {
        return this.validate;
    }

    public int hashCode() {
        return (((this.challenge.hashCode() * 31) + this.validate.hashCode()) * 31) + this.seccode.hashCode();
    }

    @NotNull
    public String toString() {
        return "GeetestData(challenge=" + this.challenge + ", validate=" + this.validate + ", seccode=" + this.seccode + ')';
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.challenge);
        parcel.writeString(this.validate);
        parcel.writeString(this.seccode);
    }
}
