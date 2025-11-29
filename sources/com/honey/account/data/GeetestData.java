package com.honey.account.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.honey.account.constant.AccountConstantKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0016HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006#"}, d2 = {"Lcom/honey/account/data/GeetestData;", "Landroid/os/Parcelable;", "captchaId", "", "lotNumber", "passToken", "genTime", "captchaOutput", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCaptchaId", "()Ljava/lang/String;", "getCaptchaOutput", "getGenTime", "getLotNumber", "getPassToken", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Parcelize
public final class GeetestData implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<GeetestData> CREATOR = new Creator();
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String TAG = "GeetestData";
    @NotNull
    private final String captchaId;
    @NotNull
    private final String captchaOutput;
    @NotNull
    private final String genTime;
    @NotNull
    private final String lotNumber;
    @NotNull
    private final String passToken;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/honey/account/data/GeetestData$Companion;", "", "()V", "TAG", "", "parseData", "Lcom/honey/account/data/GeetestData;", "response", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final GeetestData parseData(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "response");
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString(AccountConstantKt.GEETEST_CAPTCHA_ID);
                Intrinsics.checkNotNullExpressionValue(optString, "optString(...)");
                String optString2 = jSONObject.optString(AccountConstantKt.GEETEST_LOT_NUMBER);
                Intrinsics.checkNotNullExpressionValue(optString2, "optString(...)");
                String optString3 = jSONObject.optString(AccountConstantKt.GEETEST_PASS_TOKEN);
                Intrinsics.checkNotNullExpressionValue(optString3, "optString(...)");
                String optString4 = jSONObject.optString(AccountConstantKt.GEETEST_GEN_TIME);
                Intrinsics.checkNotNullExpressionValue(optString4, "optString(...)");
                String optString5 = jSONObject.optString(AccountConstantKt.GEETEST_CAPTCHA_OUTPUT);
                Intrinsics.checkNotNullExpressionValue(optString5, "optString(...)");
                return new GeetestData(optString, optString2, optString3, optString4, optString5);
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
            return new GeetestData(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @NotNull
        public final GeetestData[] newArray(int i) {
            return new GeetestData[i];
        }
    }

    public GeetestData(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, "captchaId");
        Intrinsics.checkNotNullParameter(str2, "lotNumber");
        Intrinsics.checkNotNullParameter(str3, "passToken");
        Intrinsics.checkNotNullParameter(str4, "genTime");
        Intrinsics.checkNotNullParameter(str5, "captchaOutput");
        this.captchaId = str;
        this.lotNumber = str2;
        this.passToken = str3;
        this.genTime = str4;
        this.captchaOutput = str5;
    }

    public static /* synthetic */ GeetestData copy$default(GeetestData geetestData, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = geetestData.captchaId;
        }
        if ((i & 2) != 0) {
            str2 = geetestData.lotNumber;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = geetestData.passToken;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = geetestData.genTime;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = geetestData.captchaOutput;
        }
        return geetestData.copy(str, str6, str7, str8, str5);
    }

    @NotNull
    public final String component1() {
        return this.captchaId;
    }

    @NotNull
    public final String component2() {
        return this.lotNumber;
    }

    @NotNull
    public final String component3() {
        return this.passToken;
    }

    @NotNull
    public final String component4() {
        return this.genTime;
    }

    @NotNull
    public final String component5() {
        return this.captchaOutput;
    }

    @NotNull
    public final GeetestData copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, "captchaId");
        Intrinsics.checkNotNullParameter(str2, "lotNumber");
        Intrinsics.checkNotNullParameter(str3, "passToken");
        Intrinsics.checkNotNullParameter(str4, "genTime");
        Intrinsics.checkNotNullParameter(str5, "captchaOutput");
        return new GeetestData(str, str2, str3, str4, str5);
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
        return Intrinsics.areEqual((Object) this.captchaId, (Object) geetestData.captchaId) && Intrinsics.areEqual((Object) this.lotNumber, (Object) geetestData.lotNumber) && Intrinsics.areEqual((Object) this.passToken, (Object) geetestData.passToken) && Intrinsics.areEqual((Object) this.genTime, (Object) geetestData.genTime) && Intrinsics.areEqual((Object) this.captchaOutput, (Object) geetestData.captchaOutput);
    }

    @NotNull
    public final String getCaptchaId() {
        return this.captchaId;
    }

    @NotNull
    public final String getCaptchaOutput() {
        return this.captchaOutput;
    }

    @NotNull
    public final String getGenTime() {
        return this.genTime;
    }

    @NotNull
    public final String getLotNumber() {
        return this.lotNumber;
    }

    @NotNull
    public final String getPassToken() {
        return this.passToken;
    }

    public int hashCode() {
        return (((((((this.captchaId.hashCode() * 31) + this.lotNumber.hashCode()) * 31) + this.passToken.hashCode()) * 31) + this.genTime.hashCode()) * 31) + this.captchaOutput.hashCode();
    }

    @NotNull
    public String toString() {
        return "GeetestData(captchaId=" + this.captchaId + ", lotNumber=" + this.lotNumber + ", passToken=" + this.passToken + ", genTime=" + this.genTime + ", captchaOutput=" + this.captchaOutput + ')';
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.captchaId);
        parcel.writeString(this.lotNumber);
        parcel.writeString(this.passToken);
        parcel.writeString(this.genTime);
        parcel.writeString(this.captchaOutput);
    }
}
