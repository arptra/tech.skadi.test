package com.xjsd.xr.sapp.asr.dao;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\nJ:\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\b\u0010\u001b\u001a\u00020\u0003H\u0016R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000f\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/xjsd/xr/sapp/asr/dao/ResultExt;", "", "requestId", "", "recognizeId", "consumeTime", "", "sendAudioTime", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V", "getConsumeTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getRecognizeId", "()Ljava/lang/String;", "getRequestId", "getSendAudioTime", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)Lcom/xjsd/xr/sapp/asr/dao/ResultExt;", "equals", "", "other", "hashCode", "", "toString", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ResultExt {
    @Nullable
    private final Long consumeTime;
    @NotNull
    private final String recognizeId;
    @NotNull
    private final String requestId;
    @Nullable
    private final Long sendAudioTime;

    public ResultExt(@NotNull String str, @NotNull String str2, @Nullable Long l, @Nullable Long l2) {
        Intrinsics.checkNotNullParameter(str, "requestId");
        Intrinsics.checkNotNullParameter(str2, "recognizeId");
        this.requestId = str;
        this.recognizeId = str2;
        this.consumeTime = l;
        this.sendAudioTime = l2;
    }

    public static /* synthetic */ ResultExt copy$default(ResultExt resultExt, String str, String str2, Long l, Long l2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = resultExt.requestId;
        }
        if ((i & 2) != 0) {
            str2 = resultExt.recognizeId;
        }
        if ((i & 4) != 0) {
            l = resultExt.consumeTime;
        }
        if ((i & 8) != 0) {
            l2 = resultExt.sendAudioTime;
        }
        return resultExt.copy(str, str2, l, l2);
    }

    @NotNull
    public final String component1() {
        return this.requestId;
    }

    @NotNull
    public final String component2() {
        return this.recognizeId;
    }

    @Nullable
    public final Long component3() {
        return this.consumeTime;
    }

    @Nullable
    public final Long component4() {
        return this.sendAudioTime;
    }

    @NotNull
    public final ResultExt copy(@NotNull String str, @NotNull String str2, @Nullable Long l, @Nullable Long l2) {
        Intrinsics.checkNotNullParameter(str, "requestId");
        Intrinsics.checkNotNullParameter(str2, "recognizeId");
        return new ResultExt(str, str2, l, l2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResultExt)) {
            return false;
        }
        ResultExt resultExt = (ResultExt) obj;
        return Intrinsics.areEqual((Object) this.requestId, (Object) resultExt.requestId) && Intrinsics.areEqual((Object) this.recognizeId, (Object) resultExt.recognizeId) && Intrinsics.areEqual((Object) this.consumeTime, (Object) resultExt.consumeTime) && Intrinsics.areEqual((Object) this.sendAudioTime, (Object) resultExt.sendAudioTime);
    }

    @Nullable
    public final Long getConsumeTime() {
        return this.consumeTime;
    }

    @NotNull
    public final String getRecognizeId() {
        return this.recognizeId;
    }

    @NotNull
    public final String getRequestId() {
        return this.requestId;
    }

    @Nullable
    public final Long getSendAudioTime() {
        return this.sendAudioTime;
    }

    public int hashCode() {
        int hashCode = ((this.requestId.hashCode() * 31) + this.recognizeId.hashCode()) * 31;
        Long l = this.consumeTime;
        int i = 0;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.sendAudioTime;
        if (l2 != null) {
            i = l2.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        return "ResultExt(requestId='" + this.requestId + "', recognizeId='" + this.recognizeId + "', consumeTime=" + this.consumeTime + ", sendAudioTime=" + this.sendAudioTime + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ResultExt(String str, String str2, Long l, Long l2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : l2);
    }
}
