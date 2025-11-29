package com.xjsd.xr.sapp.asr.dao;

import com.here.posclient.PositionEstimate;
import com.upuphone.runasone.constant.Constants;
import com.xjsd.xr.sapp.asr.utils.AsrExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b6\b\b\u0018\u00002\u00020\u0001BÍ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010\u001bJ\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u000eHÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u000eHÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0002\u0010%J\u0010\u0010>\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0002\u0010%J\u0010\u0010?\u001a\u0004\u0018\u00010\u0019HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010@\u001a\u0004\u0018\u00010\u0019HÆ\u0003¢\u0006\u0002\u0010!J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0007HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÜ\u0001\u0010I\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u000e2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÆ\u0001¢\u0006\u0002\u0010JJ\u0013\u0010K\u001a\u00020\u000e2\b\u0010L\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010M\u001a\u00020\u0016HÖ\u0001J\b\u0010N\u001a\u00020\u0003H\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b#\u0010!R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\n\n\u0002\u0010&\u001a\u0004\b$\u0010%R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001dR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001dR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001dR\u0011\u0010\u0012\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010-R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001dR\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\n\n\u0002\u0010&\u001a\u0004\b1\u0010%R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001dR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001dR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b4\u00105¨\u0006O"}, d2 = {"Lcom/xjsd/xr/sapp/asr/dao/AsrRequest;", "", "requestId", "", "event", "deviceId", "data", "Lcom/xjsd/xr/sapp/asr/dao/AsrRequestData;", "extend", "IotDeviceId", "accountId", "inputLanguageCode", "targetLanguageCode", "infiniteStreaming", "", "supplier", "appName", "recognizeId", "isNeedTts", "tts", "Lcom/xjsd/xr/sapp/asr/dao/TtsConfig;", "role", "", "concatenationStratey", "audioSize", "", "audioTotalDuration", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/xjsd/xr/sapp/asr/dao/AsrRequestData;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/xjsd/xr/sapp/asr/dao/TtsConfig;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;)V", "getIotDeviceId", "()Ljava/lang/String;", "getAccountId", "getAppName", "getAudioSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getAudioTotalDuration", "getConcatenationStratey", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getData", "()Lcom/xjsd/xr/sapp/asr/dao/AsrRequestData;", "getDeviceId", "getEvent", "getExtend", "getInfiniteStreaming", "()Z", "getInputLanguageCode", "getRecognizeId", "getRequestId", "getRole", "getSupplier", "getTargetLanguageCode", "getTts", "()Lcom/xjsd/xr/sapp/asr/dao/TtsConfig;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/xjsd/xr/sapp/asr/dao/AsrRequestData;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/xjsd/xr/sapp/asr/dao/TtsConfig;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;)Lcom/xjsd/xr/sapp/asr/dao/AsrRequest;", "equals", "other", "hashCode", "toString", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AsrRequest {
    @Nullable
    private final String IotDeviceId;
    @NotNull
    private final String accountId;
    @NotNull
    private final String appName;
    @Nullable
    private final Long audioSize;
    @Nullable
    private final Long audioTotalDuration;
    @Nullable
    private final Integer concatenationStratey;
    @NotNull
    private final AsrRequestData data;
    @NotNull
    private final String deviceId;
    @NotNull
    private final String event;
    @Nullable
    private final String extend;
    private final boolean infiniteStreaming;
    @NotNull
    private final String inputLanguageCode;
    private final boolean isNeedTts;
    @NotNull
    private final String recognizeId;
    @NotNull
    private final String requestId;
    @Nullable
    private final Integer role;
    @NotNull
    private final String supplier;
    @Nullable
    private final String targetLanguageCode;
    @Nullable
    private final TtsConfig tts;

    public AsrRequest(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull AsrRequestData asrRequestData, @Nullable String str4, @Nullable String str5, @NotNull String str6, @NotNull String str7, @Nullable String str8, boolean z, @NotNull String str9, @NotNull String str10, @NotNull String str11, boolean z2, @Nullable TtsConfig ttsConfig, @Nullable Integer num, @Nullable Integer num2, @Nullable Long l, @Nullable Long l2) {
        String str12 = str6;
        String str13 = str7;
        String str14 = str9;
        String str15 = str10;
        String str16 = str11;
        Intrinsics.checkNotNullParameter(str, "requestId");
        Intrinsics.checkNotNullParameter(str2, "event");
        Intrinsics.checkNotNullParameter(str3, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(asrRequestData, "data");
        Intrinsics.checkNotNullParameter(str12, "accountId");
        Intrinsics.checkNotNullParameter(str13, "inputLanguageCode");
        Intrinsics.checkNotNullParameter(str14, "supplier");
        Intrinsics.checkNotNullParameter(str15, "appName");
        Intrinsics.checkNotNullParameter(str16, "recognizeId");
        this.requestId = str;
        this.event = str2;
        this.deviceId = str3;
        this.data = asrRequestData;
        this.extend = str4;
        this.IotDeviceId = str5;
        this.accountId = str12;
        this.inputLanguageCode = str13;
        this.targetLanguageCode = str8;
        this.infiniteStreaming = z;
        this.supplier = str14;
        this.appName = str15;
        this.recognizeId = str16;
        this.isNeedTts = z2;
        this.tts = ttsConfig;
        this.role = num;
        this.concatenationStratey = num2;
        this.audioSize = l;
        this.audioTotalDuration = l2;
    }

    public static /* synthetic */ AsrRequest copy$default(AsrRequest asrRequest, String str, String str2, String str3, AsrRequestData asrRequestData, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, TtsConfig ttsConfig, Integer num, Integer num2, Long l, Long l2, int i, Object obj) {
        AsrRequest asrRequest2 = asrRequest;
        int i2 = i;
        return asrRequest.copy((i2 & 1) != 0 ? asrRequest2.requestId : str, (i2 & 2) != 0 ? asrRequest2.event : str2, (i2 & 4) != 0 ? asrRequest2.deviceId : str3, (i2 & 8) != 0 ? asrRequest2.data : asrRequestData, (i2 & 16) != 0 ? asrRequest2.extend : str4, (i2 & 32) != 0 ? asrRequest2.IotDeviceId : str5, (i2 & 64) != 0 ? asrRequest2.accountId : str6, (i2 & 128) != 0 ? asrRequest2.inputLanguageCode : str7, (i2 & 256) != 0 ? asrRequest2.targetLanguageCode : str8, (i2 & 512) != 0 ? asrRequest2.infiniteStreaming : z, (i2 & 1024) != 0 ? asrRequest2.supplier : str9, (i2 & 2048) != 0 ? asrRequest2.appName : str10, (i2 & 4096) != 0 ? asrRequest2.recognizeId : str11, (i2 & 8192) != 0 ? asrRequest2.isNeedTts : z2, (i2 & 16384) != 0 ? asrRequest2.tts : ttsConfig, (i2 & 32768) != 0 ? asrRequest2.role : num, (i2 & 65536) != 0 ? asrRequest2.concatenationStratey : num2, (i2 & 131072) != 0 ? asrRequest2.audioSize : l, (i2 & PositionEstimate.Value.BUILDING_NAME) != 0 ? asrRequest2.audioTotalDuration : l2);
    }

    @NotNull
    public final String component1() {
        return this.requestId;
    }

    public final boolean component10() {
        return this.infiniteStreaming;
    }

    @NotNull
    public final String component11() {
        return this.supplier;
    }

    @NotNull
    public final String component12() {
        return this.appName;
    }

    @NotNull
    public final String component13() {
        return this.recognizeId;
    }

    public final boolean component14() {
        return this.isNeedTts;
    }

    @Nullable
    public final TtsConfig component15() {
        return this.tts;
    }

    @Nullable
    public final Integer component16() {
        return this.role;
    }

    @Nullable
    public final Integer component17() {
        return this.concatenationStratey;
    }

    @Nullable
    public final Long component18() {
        return this.audioSize;
    }

    @Nullable
    public final Long component19() {
        return this.audioTotalDuration;
    }

    @NotNull
    public final String component2() {
        return this.event;
    }

    @NotNull
    public final String component3() {
        return this.deviceId;
    }

    @NotNull
    public final AsrRequestData component4() {
        return this.data;
    }

    @Nullable
    public final String component5() {
        return this.extend;
    }

    @Nullable
    public final String component6() {
        return this.IotDeviceId;
    }

    @NotNull
    public final String component7() {
        return this.accountId;
    }

    @NotNull
    public final String component8() {
        return this.inputLanguageCode;
    }

    @Nullable
    public final String component9() {
        return this.targetLanguageCode;
    }

    @NotNull
    public final AsrRequest copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull AsrRequestData asrRequestData, @Nullable String str4, @Nullable String str5, @NotNull String str6, @NotNull String str7, @Nullable String str8, boolean z, @NotNull String str9, @NotNull String str10, @NotNull String str11, boolean z2, @Nullable TtsConfig ttsConfig, @Nullable Integer num, @Nullable Integer num2, @Nullable Long l, @Nullable Long l2) {
        String str12 = str;
        Intrinsics.checkNotNullParameter(str12, "requestId");
        Intrinsics.checkNotNullParameter(str2, "event");
        Intrinsics.checkNotNullParameter(str3, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(asrRequestData, "data");
        Intrinsics.checkNotNullParameter(str6, "accountId");
        Intrinsics.checkNotNullParameter(str7, "inputLanguageCode");
        Intrinsics.checkNotNullParameter(str9, "supplier");
        Intrinsics.checkNotNullParameter(str10, "appName");
        Intrinsics.checkNotNullParameter(str11, "recognizeId");
        return new AsrRequest(str12, str2, str3, asrRequestData, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, ttsConfig, num, num2, l, l2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AsrRequest)) {
            return false;
        }
        AsrRequest asrRequest = (AsrRequest) obj;
        return Intrinsics.areEqual((Object) this.requestId, (Object) asrRequest.requestId) && Intrinsics.areEqual((Object) this.event, (Object) asrRequest.event) && Intrinsics.areEqual((Object) this.deviceId, (Object) asrRequest.deviceId) && Intrinsics.areEqual((Object) this.data, (Object) asrRequest.data) && Intrinsics.areEqual((Object) this.extend, (Object) asrRequest.extend) && Intrinsics.areEqual((Object) this.IotDeviceId, (Object) asrRequest.IotDeviceId) && Intrinsics.areEqual((Object) this.accountId, (Object) asrRequest.accountId) && Intrinsics.areEqual((Object) this.inputLanguageCode, (Object) asrRequest.inputLanguageCode) && Intrinsics.areEqual((Object) this.targetLanguageCode, (Object) asrRequest.targetLanguageCode) && this.infiniteStreaming == asrRequest.infiniteStreaming && Intrinsics.areEqual((Object) this.supplier, (Object) asrRequest.supplier) && Intrinsics.areEqual((Object) this.appName, (Object) asrRequest.appName) && Intrinsics.areEqual((Object) this.recognizeId, (Object) asrRequest.recognizeId) && this.isNeedTts == asrRequest.isNeedTts && Intrinsics.areEqual((Object) this.tts, (Object) asrRequest.tts) && Intrinsics.areEqual((Object) this.role, (Object) asrRequest.role) && Intrinsics.areEqual((Object) this.concatenationStratey, (Object) asrRequest.concatenationStratey) && Intrinsics.areEqual((Object) this.audioSize, (Object) asrRequest.audioSize) && Intrinsics.areEqual((Object) this.audioTotalDuration, (Object) asrRequest.audioTotalDuration);
    }

    @NotNull
    public final String getAccountId() {
        return this.accountId;
    }

    @NotNull
    public final String getAppName() {
        return this.appName;
    }

    @Nullable
    public final Long getAudioSize() {
        return this.audioSize;
    }

    @Nullable
    public final Long getAudioTotalDuration() {
        return this.audioTotalDuration;
    }

    @Nullable
    public final Integer getConcatenationStratey() {
        return this.concatenationStratey;
    }

    @NotNull
    public final AsrRequestData getData() {
        return this.data;
    }

    @NotNull
    public final String getDeviceId() {
        return this.deviceId;
    }

    @NotNull
    public final String getEvent() {
        return this.event;
    }

    @Nullable
    public final String getExtend() {
        return this.extend;
    }

    public final boolean getInfiniteStreaming() {
        return this.infiniteStreaming;
    }

    @NotNull
    public final String getInputLanguageCode() {
        return this.inputLanguageCode;
    }

    @Nullable
    public final String getIotDeviceId() {
        return this.IotDeviceId;
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
    public final Integer getRole() {
        return this.role;
    }

    @NotNull
    public final String getSupplier() {
        return this.supplier;
    }

    @Nullable
    public final String getTargetLanguageCode() {
        return this.targetLanguageCode;
    }

    @Nullable
    public final TtsConfig getTts() {
        return this.tts;
    }

    public int hashCode() {
        int hashCode = ((((((this.requestId.hashCode() * 31) + this.event.hashCode()) * 31) + this.deviceId.hashCode()) * 31) + this.data.hashCode()) * 31;
        String str = this.extend;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.IotDeviceId;
        int hashCode3 = (((((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.accountId.hashCode()) * 31) + this.inputLanguageCode.hashCode()) * 31;
        String str3 = this.targetLanguageCode;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        boolean z = this.infiniteStreaming;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int hashCode5 = (((((((hashCode4 + (z ? 1 : 0)) * 31) + this.supplier.hashCode()) * 31) + this.appName.hashCode()) * 31) + this.recognizeId.hashCode()) * 31;
        boolean z3 = this.isNeedTts;
        if (!z3) {
            z2 = z3;
        }
        int i2 = (hashCode5 + (z2 ? 1 : 0)) * 31;
        TtsConfig ttsConfig = this.tts;
        int hashCode6 = (i2 + (ttsConfig == null ? 0 : ttsConfig.hashCode())) * 31;
        Integer num = this.role;
        int hashCode7 = (hashCode6 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.concatenationStratey;
        int hashCode8 = (hashCode7 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Long l = this.audioSize;
        int hashCode9 = (hashCode8 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.audioTotalDuration;
        if (l2 != null) {
            i = l2.hashCode();
        }
        return hashCode9 + i;
    }

    public final boolean isNeedTts() {
        return this.isNeedTts;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AsrRequest{");
        sb.append("requestId=" + this.requestId);
        sb.append("|event=" + this.event);
        sb.append("|deviceId=" + AsrExtKt.mixSpecialData(this.deviceId));
        sb.append("|extend=" + this.extend);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("|IotDeviceId=");
        String str = this.IotDeviceId;
        sb2.append(str != null ? AsrExtKt.mixSpecialData(str) : null);
        sb.append(sb2.toString());
        sb.append("|accountId=" + AsrExtKt.mixSpecialData(this.accountId));
        sb.append("|inputLanguageCode=" + this.inputLanguageCode);
        sb.append("|targetLanguageCode=" + this.targetLanguageCode);
        sb.append("|infiniteStreaming=" + this.infiniteStreaming);
        sb.append("|supplier=" + this.supplier);
        sb.append("|appName=" + this.appName);
        sb.append("|recognizeId=" + this.recognizeId);
        sb.append("|role=" + this.role);
        sb.append("|concatenationStratey=" + this.concatenationStratey);
        sb.append("|audioSize=" + this.audioSize);
        sb.append("|audioTotalDuration=" + this.audioTotalDuration);
        sb.append(StringUtils.LF);
        sb.append("data=" + this.data);
        sb.append(StringUtils.LF);
        sb.append("isNeedTts=" + this.isNeedTts);
        sb.append("|tts=" + this.tts);
        sb.append("");
        sb.append("}");
        String sb3 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "toString(...)");
        return sb3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AsrRequest(java.lang.String r23, java.lang.String r24, java.lang.String r25, com.xjsd.xr.sapp.asr.dao.AsrRequestData r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, boolean r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, boolean r36, com.xjsd.xr.sapp.asr.dao.TtsConfig r37, java.lang.Integer r38, java.lang.Integer r39, java.lang.Long r40, java.lang.Long r41, int r42, kotlin.jvm.internal.DefaultConstructorMarker r43) {
        /*
            r22 = this;
            r0 = r42
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0021
            java.util.UUID r1 = java.util.UUID.randomUUID()
            java.lang.String r2 = r1.toString()
            java.lang.String r1 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)
            r6 = 4
            r7 = 0
            java.lang.String r3 = "-"
            java.lang.String r4 = ""
            r5 = 0
            java.lang.String r1 = kotlin.text.StringsKt.replace$default((java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r4, (boolean) r5, (int) r6, (java.lang.Object) r7)
            r3 = r1
            goto L_0x0023
        L_0x0021:
            r3 = r23
        L_0x0023:
            r1 = r0 & 2
            if (r1 == 0) goto L_0x002c
            java.lang.String r1 = "sync_audio_info"
            r4 = r1
            goto L_0x002e
        L_0x002c:
            r4 = r24
        L_0x002e:
            r1 = r0 & 16
            r2 = 0
            if (r1 == 0) goto L_0x0035
            r7 = r2
            goto L_0x0037
        L_0x0035:
            r7 = r27
        L_0x0037:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x003d
            r8 = r2
            goto L_0x003f
        L_0x003d:
            r8 = r28
        L_0x003f:
            r1 = r0 & 64
            java.lang.String r5 = ""
            if (r1 == 0) goto L_0x0047
            r9 = r5
            goto L_0x0049
        L_0x0047:
            r9 = r29
        L_0x0049:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x004f
            r11 = r2
            goto L_0x0051
        L_0x004f:
            r11 = r31
        L_0x0051:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0058
            r1 = 1
            r12 = r1
            goto L_0x005a
        L_0x0058:
            r12 = r32
        L_0x005a:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0062
            java.lang.String r1 = "microsoft"
            r13 = r1
            goto L_0x0064
        L_0x0062:
            r13 = r33
        L_0x0064:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x006a
            r14 = r5
            goto L_0x006c
        L_0x006a:
            r14 = r34
        L_0x006c:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x0072
            r15 = r5
            goto L_0x0074
        L_0x0072:
            r15 = r35
        L_0x0074:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x007c
            r1 = 0
            r16 = r1
            goto L_0x007e
        L_0x007c:
            r16 = r36
        L_0x007e:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x0085
            r17 = r2
            goto L_0x0087
        L_0x0085:
            r17 = r37
        L_0x0087:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0090
            r18 = r2
            goto L_0x0092
        L_0x0090:
            r18 = r38
        L_0x0092:
            r1 = 65536(0x10000, float:9.18355E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x009a
            r19 = r2
            goto L_0x009c
        L_0x009a:
            r19 = r39
        L_0x009c:
            r1 = 131072(0x20000, float:1.83671E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00a4
            r20 = r2
            goto L_0x00a6
        L_0x00a4:
            r20 = r40
        L_0x00a6:
            r1 = 262144(0x40000, float:3.67342E-40)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x00ae
            r21 = r2
            goto L_0x00b0
        L_0x00ae:
            r21 = r41
        L_0x00b0:
            r2 = r22
            r5 = r25
            r6 = r26
            r10 = r30
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.xr.sapp.asr.dao.AsrRequest.<init>(java.lang.String, java.lang.String, java.lang.String, com.xjsd.xr.sapp.asr.dao.AsrRequestData, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, java.lang.String, java.lang.String, java.lang.String, boolean, com.xjsd.xr.sapp.asr.dao.TtsConfig, java.lang.Integer, java.lang.Integer, java.lang.Long, java.lang.Long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
