package com.upuphone.xr.sapp.entity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0013\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u001bHÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\u0019\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001bHÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\bR\u0014\u0010\u0015\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\b¨\u0006&"}, d2 = {"Lcom/upuphone/xr/sapp/entity/PolicyInfo;", "Landroid/os/Parcelable;", "reported", "", "agree", "", "(ZLjava/lang/String;)V", "getAgree", "()Ljava/lang/String;", "setAgree", "(Ljava/lang/String;)V", "ppPolicyUrl", "getPpPolicyUrl", "ppPolicyVersion", "getPpPolicyVersion", "getReported", "()Z", "setReported", "(Z)V", "upPolicyUrl", "getUpPolicyUrl", "upPolicyVersion", "getUpPolicyVersion", "component1", "component2", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Parcelize
@Keep
public final class PolicyInfo implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<PolicyInfo> CREATOR = new Creator();
    @NotNull
    private String agree;
    @NotNull
    private final String ppPolicyUrl = "";
    @NotNull
    private final String ppPolicyVersion = "";
    private boolean reported;
    @NotNull
    private final String upPolicyUrl = "";
    @NotNull
    private final String upPolicyVersion = "";

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PolicyInfo> {
        @NotNull
        public final PolicyInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PolicyInfo(parcel.readInt() != 0, parcel.readString());
        }

        @NotNull
        public final PolicyInfo[] newArray(int i) {
            return new PolicyInfo[i];
        }
    }

    public PolicyInfo(boolean z, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "agree");
        this.reported = z;
        this.agree = str;
    }

    public static /* synthetic */ PolicyInfo copy$default(PolicyInfo policyInfo, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = policyInfo.reported;
        }
        if ((i & 2) != 0) {
            str = policyInfo.agree;
        }
        return policyInfo.copy(z, str);
    }

    public final boolean component1() {
        return this.reported;
    }

    @NotNull
    public final String component2() {
        return this.agree;
    }

    @NotNull
    public final PolicyInfo copy(boolean z, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "agree");
        return new PolicyInfo(z, str);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PolicyInfo)) {
            return false;
        }
        PolicyInfo policyInfo = (PolicyInfo) obj;
        return this.reported == policyInfo.reported && Intrinsics.areEqual((Object) this.agree, (Object) policyInfo.agree);
    }

    @NotNull
    public final String getAgree() {
        return this.agree;
    }

    @NotNull
    public final String getPpPolicyUrl() {
        return this.ppPolicyUrl;
    }

    @NotNull
    public final String getPpPolicyVersion() {
        return this.ppPolicyVersion;
    }

    public final boolean getReported() {
        return this.reported;
    }

    @NotNull
    public final String getUpPolicyUrl() {
        return this.upPolicyUrl;
    }

    @NotNull
    public final String getUpPolicyVersion() {
        return this.upPolicyVersion;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.reported) * 31) + this.agree.hashCode();
    }

    public final void setAgree(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.agree = str;
    }

    public final void setReported(boolean z) {
        this.reported = z;
    }

    @NotNull
    public String toString() {
        boolean z = this.reported;
        String str = this.agree;
        return "PolicyInfo(reported=" + z + ", agree=" + str + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.reported ? 1 : 0);
        parcel.writeString(this.agree);
    }
}
