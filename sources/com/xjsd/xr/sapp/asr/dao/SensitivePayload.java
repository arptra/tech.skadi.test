package com.xjsd.xr.sapp.asr.dao;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\b\u0010\u001a\u001a\u00020\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/xjsd/xr/sapp/asr/dao/SensitivePayload;", "", "sensitiveType", "", "requestId", "requestStatus", "riskDescription", "riskLevel", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getRequestId", "()Ljava/lang/String;", "getRequestStatus", "getRiskDescription", "getRiskLevel", "getSensitiveType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SensitivePayload {
    @NotNull
    private final String requestId;
    @NotNull
    private final String requestStatus;
    @NotNull
    private final String riskDescription;
    @NotNull
    private final String riskLevel;
    @NotNull
    private final String sensitiveType;

    public SensitivePayload() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ SensitivePayload copy$default(SensitivePayload sensitivePayload, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sensitivePayload.sensitiveType;
        }
        if ((i & 2) != 0) {
            str2 = sensitivePayload.requestId;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = sensitivePayload.requestStatus;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = sensitivePayload.riskDescription;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = sensitivePayload.riskLevel;
        }
        return sensitivePayload.copy(str, str6, str7, str8, str5);
    }

    @NotNull
    public final String component1() {
        return this.sensitiveType;
    }

    @NotNull
    public final String component2() {
        return this.requestId;
    }

    @NotNull
    public final String component3() {
        return this.requestStatus;
    }

    @NotNull
    public final String component4() {
        return this.riskDescription;
    }

    @NotNull
    public final String component5() {
        return this.riskLevel;
    }

    @NotNull
    public final SensitivePayload copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, "sensitiveType");
        Intrinsics.checkNotNullParameter(str2, "requestId");
        Intrinsics.checkNotNullParameter(str3, "requestStatus");
        Intrinsics.checkNotNullParameter(str4, "riskDescription");
        Intrinsics.checkNotNullParameter(str5, "riskLevel");
        return new SensitivePayload(str, str2, str3, str4, str5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SensitivePayload)) {
            return false;
        }
        SensitivePayload sensitivePayload = (SensitivePayload) obj;
        return Intrinsics.areEqual((Object) this.sensitiveType, (Object) sensitivePayload.sensitiveType) && Intrinsics.areEqual((Object) this.requestId, (Object) sensitivePayload.requestId) && Intrinsics.areEqual((Object) this.requestStatus, (Object) sensitivePayload.requestStatus) && Intrinsics.areEqual((Object) this.riskDescription, (Object) sensitivePayload.riskDescription) && Intrinsics.areEqual((Object) this.riskLevel, (Object) sensitivePayload.riskLevel);
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

    @NotNull
    public final String getSensitiveType() {
        return this.sensitiveType;
    }

    public int hashCode() {
        return (((((((this.sensitiveType.hashCode() * 31) + this.requestId.hashCode()) * 31) + this.requestStatus.hashCode()) * 31) + this.riskDescription.hashCode()) * 31) + this.riskLevel.hashCode();
    }

    @NotNull
    public String toString() {
        return "SensitivePayload(sensitiveType='" + this.sensitiveType + "', requestId='" + this.requestId + "', requestStatus='" + this.requestStatus + "', riskDescription='" + this.riskDescription + "', riskLevel='" + this.riskLevel + "')";
    }

    public SensitivePayload(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, "sensitiveType");
        Intrinsics.checkNotNullParameter(str2, "requestId");
        Intrinsics.checkNotNullParameter(str3, "requestStatus");
        Intrinsics.checkNotNullParameter(str4, "riskDescription");
        Intrinsics.checkNotNullParameter(str5, "riskLevel");
        this.sensitiveType = str;
        this.requestId = str2;
        this.requestStatus = str3;
        this.riskDescription = str4;
        this.riskLevel = str5;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SensitivePayload(java.lang.String r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            if (r10 == 0) goto L_0x0006
            java.lang.String r4 = "sensitive_request"
        L_0x0006:
            r10 = r9 & 2
            java.lang.String r0 = ""
            if (r10 == 0) goto L_0x000e
            r10 = r0
            goto L_0x000f
        L_0x000e:
            r10 = r5
        L_0x000f:
            r5 = r9 & 4
            if (r5 == 0) goto L_0x0015
            r1 = r0
            goto L_0x0016
        L_0x0015:
            r1 = r6
        L_0x0016:
            r5 = r9 & 8
            if (r5 == 0) goto L_0x001c
            r2 = r0
            goto L_0x001d
        L_0x001c:
            r2 = r7
        L_0x001d:
            r5 = r9 & 16
            if (r5 == 0) goto L_0x0022
            goto L_0x0023
        L_0x0022:
            r0 = r8
        L_0x0023:
            r5 = r3
            r6 = r4
            r7 = r10
            r8 = r1
            r9 = r2
            r10 = r0
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.xr.sapp.asr.dao.SensitivePayload.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
