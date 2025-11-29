package com.xjsd.xr.sapp.asr.dao;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\b\u0010\u0016\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/xjsd/xr/sapp/asr/dao/SmartExSensitive;", "", "payload", "Lcom/xjsd/xr/sapp/asr/dao/SensitivePayload;", "requestId", "", "type", "(Lcom/xjsd/xr/sapp/asr/dao/SensitivePayload;Ljava/lang/String;Ljava/lang/String;)V", "getPayload", "()Lcom/xjsd/xr/sapp/asr/dao/SensitivePayload;", "getRequestId", "()Ljava/lang/String;", "getType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SmartExSensitive {
    @NotNull
    private final SensitivePayload payload;
    @NotNull
    private final String requestId;
    @NotNull
    private final String type;

    public SmartExSensitive(@NotNull SensitivePayload sensitivePayload, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(sensitivePayload, "payload");
        Intrinsics.checkNotNullParameter(str, "requestId");
        Intrinsics.checkNotNullParameter(str2, "type");
        this.payload = sensitivePayload;
        this.requestId = str;
        this.type = str2;
    }

    public static /* synthetic */ SmartExSensitive copy$default(SmartExSensitive smartExSensitive, SensitivePayload sensitivePayload, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            sensitivePayload = smartExSensitive.payload;
        }
        if ((i & 2) != 0) {
            str = smartExSensitive.requestId;
        }
        if ((i & 4) != 0) {
            str2 = smartExSensitive.type;
        }
        return smartExSensitive.copy(sensitivePayload, str, str2);
    }

    @NotNull
    public final SensitivePayload component1() {
        return this.payload;
    }

    @NotNull
    public final String component2() {
        return this.requestId;
    }

    @NotNull
    public final String component3() {
        return this.type;
    }

    @NotNull
    public final SmartExSensitive copy(@NotNull SensitivePayload sensitivePayload, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(sensitivePayload, "payload");
        Intrinsics.checkNotNullParameter(str, "requestId");
        Intrinsics.checkNotNullParameter(str2, "type");
        return new SmartExSensitive(sensitivePayload, str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SmartExSensitive)) {
            return false;
        }
        SmartExSensitive smartExSensitive = (SmartExSensitive) obj;
        return Intrinsics.areEqual((Object) this.payload, (Object) smartExSensitive.payload) && Intrinsics.areEqual((Object) this.requestId, (Object) smartExSensitive.requestId) && Intrinsics.areEqual((Object) this.type, (Object) smartExSensitive.type);
    }

    @NotNull
    public final SensitivePayload getPayload() {
        return this.payload;
    }

    @NotNull
    public final String getRequestId() {
        return this.requestId;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return (((this.payload.hashCode() * 31) + this.requestId.hashCode()) * 31) + this.type.hashCode();
    }

    @NotNull
    public String toString() {
        return "IntelExtnSensitive(payload=" + this.payload + ", requestId='" + this.requestId + "', type='" + this.type + "')";
    }
}
