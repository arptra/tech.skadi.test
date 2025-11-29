package com.upuphone.ar.transcribe.phone.repo;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/repo/AiResponseSensitive;", "", "requestId", "", "requestStatus", "riskDescription", "riskLevel", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getRequestId", "()Ljava/lang/String;", "getRequestStatus", "getRiskDescription", "getRiskLevel", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class AiResponseSensitive {
    @NotNull
    private final String requestId;
    @NotNull
    private final String requestStatus;
    @NotNull
    private final String riskDescription;
    @NotNull
    private final String riskLevel;

    public AiResponseSensitive(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "requestId");
        Intrinsics.checkNotNullParameter(str2, "requestStatus");
        Intrinsics.checkNotNullParameter(str3, "riskDescription");
        Intrinsics.checkNotNullParameter(str4, "riskLevel");
        this.requestId = str;
        this.requestStatus = str2;
        this.riskDescription = str3;
        this.riskLevel = str4;
    }

    public static /* synthetic */ AiResponseSensitive copy$default(AiResponseSensitive aiResponseSensitive, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = aiResponseSensitive.requestId;
        }
        if ((i & 2) != 0) {
            str2 = aiResponseSensitive.requestStatus;
        }
        if ((i & 4) != 0) {
            str3 = aiResponseSensitive.riskDescription;
        }
        if ((i & 8) != 0) {
            str4 = aiResponseSensitive.riskLevel;
        }
        return aiResponseSensitive.copy(str, str2, str3, str4);
    }

    @NotNull
    public final String component1() {
        return this.requestId;
    }

    @NotNull
    public final String component2() {
        return this.requestStatus;
    }

    @NotNull
    public final String component3() {
        return this.riskDescription;
    }

    @NotNull
    public final String component4() {
        return this.riskLevel;
    }

    @NotNull
    public final AiResponseSensitive copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "requestId");
        Intrinsics.checkNotNullParameter(str2, "requestStatus");
        Intrinsics.checkNotNullParameter(str3, "riskDescription");
        Intrinsics.checkNotNullParameter(str4, "riskLevel");
        return new AiResponseSensitive(str, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AiResponseSensitive)) {
            return false;
        }
        AiResponseSensitive aiResponseSensitive = (AiResponseSensitive) obj;
        return Intrinsics.areEqual((Object) this.requestId, (Object) aiResponseSensitive.requestId) && Intrinsics.areEqual((Object) this.requestStatus, (Object) aiResponseSensitive.requestStatus) && Intrinsics.areEqual((Object) this.riskDescription, (Object) aiResponseSensitive.riskDescription) && Intrinsics.areEqual((Object) this.riskLevel, (Object) aiResponseSensitive.riskLevel);
    }

    @NotNull
    public final String getRequestId() {
        return this.requestId;
    }

    @NotNull
    public final String getRequestStatus() {
        return this.requestStatus;
    }

    @NotNull
    public final String getRiskDescription() {
        return this.riskDescription;
    }

    @NotNull
    public final String getRiskLevel() {
        return this.riskLevel;
    }

    public int hashCode() {
        return (((((this.requestId.hashCode() * 31) + this.requestStatus.hashCode()) * 31) + this.riskDescription.hashCode()) * 31) + this.riskLevel.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.requestId;
        String str2 = this.requestStatus;
        String str3 = this.riskDescription;
        String str4 = this.riskLevel;
        return "AiResponseSensitive(requestId=" + str + ", requestStatus=" + str2 + ", riskDescription=" + str3 + ", riskLevel=" + str4 + ")";
    }
}
