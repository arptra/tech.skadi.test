package com.xjsd.xr.sapp.asr.dao;

import com.upuphone.runasone.constant.Constants;
import com.xjsd.xr.sapp.asr.constants.AsrConstants;
import com.xjsd.xr.sapp.asr.utils.AsrExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\b\u0010\u0014\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/xjsd/xr/sapp/asr/dao/SpeechEndAudio;", "", "deviceId", "", "event", "requestId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDeviceId", "()Ljava/lang/String;", "getEvent", "getRequestId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SpeechEndAudio {
    @NotNull
    private final String deviceId;
    @NotNull
    private final String event;
    @NotNull
    private final String requestId;

    public SpeechEndAudio(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(str2, "event");
        Intrinsics.checkNotNullParameter(str3, "requestId");
        this.deviceId = str;
        this.event = str2;
        this.requestId = str3;
    }

    public static /* synthetic */ SpeechEndAudio copy$default(SpeechEndAudio speechEndAudio, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = speechEndAudio.deviceId;
        }
        if ((i & 2) != 0) {
            str2 = speechEndAudio.event;
        }
        if ((i & 4) != 0) {
            str3 = speechEndAudio.requestId;
        }
        return speechEndAudio.copy(str, str2, str3);
    }

    @NotNull
    public final String component1() {
        return this.deviceId;
    }

    @NotNull
    public final String component2() {
        return this.event;
    }

    @NotNull
    public final String component3() {
        return this.requestId;
    }

    @NotNull
    public final SpeechEndAudio copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(str2, "event");
        Intrinsics.checkNotNullParameter(str3, "requestId");
        return new SpeechEndAudio(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SpeechEndAudio)) {
            return false;
        }
        SpeechEndAudio speechEndAudio = (SpeechEndAudio) obj;
        return Intrinsics.areEqual((Object) this.deviceId, (Object) speechEndAudio.deviceId) && Intrinsics.areEqual((Object) this.event, (Object) speechEndAudio.event) && Intrinsics.areEqual((Object) this.requestId, (Object) speechEndAudio.requestId);
    }

    @NotNull
    public final String getDeviceId() {
        return this.deviceId;
    }

    @NotNull
    public final String getEvent() {
        return this.event;
    }

    @NotNull
    public final String getRequestId() {
        return this.requestId;
    }

    public int hashCode() {
        return (((this.deviceId.hashCode() * 31) + this.event.hashCode()) * 31) + this.requestId.hashCode();
    }

    @NotNull
    public String toString() {
        return "SpeechEndAudio(deviceId='" + AsrExtKt.mixSpecialData(this.deviceId) + "', event='" + this.event + "', requestId='" + this.requestId + "')";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SpeechEndAudio(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? AsrConstants.END_AUDIO : str2, str3);
    }
}
