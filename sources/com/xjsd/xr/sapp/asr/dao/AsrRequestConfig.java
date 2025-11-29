package com.xjsd.xr.sapp.asr.dao;

import com.upuphone.runasone.constant.Constants;
import com.xjsd.xr.sapp.asr.constants.AsrConstants;
import com.xjsd.xr.sapp.asr.utils.AsrExtKt;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b+\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001:\u0003EFGB\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0017J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u00103\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u00104\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00105\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u0010\u001cJ\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u000bHÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\rHÆ\u0003J°\u0001\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÆ\u0001¢\u0006\u0002\u0010?J\u0013\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010C\u001a\u00020\u0012HÖ\u0001J\b\u0010D\u001a\u00020\u0003H\u0016R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001e\u0010\u001cR\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0019R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010!\u001a\u0004\b)\u0010 R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0019R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0019R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0019¨\u0006H"}, d2 = {"Lcom/xjsd/xr/sapp/asr/dao/AsrRequestConfig;", "", "webType", "", "srcLang", "dstLang", "deviceId", "iotDeviceId", "supplier", "appName", "data", "Lcom/xjsd/xr/sapp/asr/dao/AsrRequestConfig$RequestData;", "recognizeData", "Lcom/xjsd/xr/sapp/asr/dao/AsrRequestConfig$RecognizeData;", "accountId", "tts", "Lcom/xjsd/xr/sapp/asr/dao/TtsConfig;", "role", "", "concatenationStratey", "audioSize", "", "audioTotalDuration", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/xjsd/xr/sapp/asr/dao/AsrRequestConfig$RequestData;Lcom/xjsd/xr/sapp/asr/dao/AsrRequestConfig$RecognizeData;Ljava/lang/String;Lcom/xjsd/xr/sapp/asr/dao/TtsConfig;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;)V", "getAccountId", "()Ljava/lang/String;", "getAppName", "getAudioSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getAudioTotalDuration", "getConcatenationStratey", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getData", "()Lcom/xjsd/xr/sapp/asr/dao/AsrRequestConfig$RequestData;", "getDeviceId", "getDstLang", "getIotDeviceId", "getRecognizeData", "()Lcom/xjsd/xr/sapp/asr/dao/AsrRequestConfig$RecognizeData;", "getRole", "getSrcLang", "getSupplier", "getTts", "()Lcom/xjsd/xr/sapp/asr/dao/TtsConfig;", "getWebType", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/xjsd/xr/sapp/asr/dao/AsrRequestConfig$RequestData;Lcom/xjsd/xr/sapp/asr/dao/AsrRequestConfig$RecognizeData;Ljava/lang/String;Lcom/xjsd/xr/sapp/asr/dao/TtsConfig;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;)Lcom/xjsd/xr/sapp/asr/dao/AsrRequestConfig;", "equals", "", "other", "hashCode", "toString", "Builder", "RecognizeData", "RequestData", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AsrRequestConfig {
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
    private final RequestData data;
    @NotNull
    private final String deviceId;
    @NotNull
    private final String dstLang;
    @NotNull
    private final String iotDeviceId;
    @Nullable
    private final RecognizeData recognizeData;
    @Nullable
    private final Integer role;
    @NotNull
    private final String srcLang;
    @NotNull
    private final String supplier;
    @Nullable
    private final TtsConfig tts;
    @NotNull
    private final String webType;

    @SourceDebugExtension({"SMAP\nAsrRequestConfig.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AsrRequestConfig.kt\ncom/xjsd/xr/sapp/asr/dao/AsrRequestConfig$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,382:1\n1#2:383\n*E\n"})
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u0015\u0010\u0006\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u001aJ\u0015\u0010\t\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u001aJ\u0006\u0010\u001b\u001a\u00020\u001cJ\u0015\u0010\n\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u001dJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0004J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0004J\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0015\u0010\u0014\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u001dJ\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0004J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0004J\u0010\u0010\u0017\u001a\u00020\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0010\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\t\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\u0015\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/xjsd/xr/sapp/asr/dao/AsrRequestConfig$Builder;", "", "()V", "accountId", "", "appName", "audioSize", "", "Ljava/lang/Long;", "audioTotalDuration", "concatenationStratey", "", "Ljava/lang/Integer;", "data", "Lcom/xjsd/xr/sapp/asr/dao/AsrRequestConfig$RequestData;", "deviceId", "dstLang", "iotDeviceId", "recognizeData", "Lcom/xjsd/xr/sapp/asr/dao/AsrRequestConfig$RecognizeData;", "role", "srcLang", "supplier", "tts", "Lcom/xjsd/xr/sapp/asr/dao/TtsConfig;", "webType", "(Ljava/lang/Long;)Lcom/xjsd/xr/sapp/asr/dao/AsrRequestConfig$Builder;", "build", "Lcom/xjsd/xr/sapp/asr/dao/AsrRequestConfig;", "(Ljava/lang/Integer;)Lcom/xjsd/xr/sapp/asr/dao/AsrRequestConfig$Builder;", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Builder {
        @NotNull
        private String accountId = "";
        @NotNull
        private String appName = "";
        @Nullable
        private Long audioSize;
        @Nullable
        private Long audioTotalDuration;
        @Nullable
        private Integer concatenationStratey;
        @Nullable
        private RequestData data;
        @NotNull
        private String deviceId = "";
        @NotNull
        private String dstLang = "";
        @NotNull
        private String iotDeviceId = "";
        @Nullable
        private RecognizeData recognizeData;
        @Nullable
        private Integer role;
        @NotNull
        private String srcLang = "";
        @NotNull
        private String supplier = AsrConstants.ASR_MICROSOFT;
        @Nullable
        private TtsConfig tts;
        @NotNull
        private String webType = "";

        @NotNull
        public final Builder accountId(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "accountId");
            this.accountId = str;
            return this;
        }

        @NotNull
        public final Builder appName(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "appName");
            this.appName = str;
            return this;
        }

        @NotNull
        public final Builder audioSize(@Nullable Long l) {
            this.audioSize = l;
            return this;
        }

        @NotNull
        public final Builder audioTotalDuration(@Nullable Long l) {
            this.audioTotalDuration = l;
            return this;
        }

        @NotNull
        public final AsrRequestConfig build() {
            if (!(!StringsKt.isBlank(this.srcLang))) {
                throw new IllegalStateException("srcLang is blank".toString());
            } else if (!(!StringsKt.isBlank(this.dstLang))) {
                throw new IllegalStateException("dstLang is blank".toString());
            } else if (!StringsKt.isBlank(this.appName)) {
                String str = this.webType;
                String str2 = this.srcLang;
                String str3 = this.dstLang;
                String str4 = this.deviceId;
                String str5 = this.iotDeviceId;
                String str6 = this.supplier;
                String str7 = this.appName;
                RequestData requestData = this.data;
                if (requestData != null) {
                    return new AsrRequestConfig(str, str2, str3, str4, str5, str6, str7, requestData, this.recognizeData, this.accountId, this.tts, this.role, this.concatenationStratey, this.audioSize, this.audioTotalDuration);
                }
                throw new IllegalStateException("data == null".toString());
            } else {
                throw new IllegalStateException("appName is blank".toString());
            }
        }

        @NotNull
        public final Builder concatenationStratey(@Nullable Integer num) {
            this.concatenationStratey = num;
            return this;
        }

        @NotNull
        public final Builder data(@NotNull RequestData requestData) {
            Intrinsics.checkNotNullParameter(requestData, "data");
            this.data = requestData;
            return this;
        }

        @NotNull
        public final Builder deviceId(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
            this.deviceId = str;
            return this;
        }

        @NotNull
        public final Builder dstLang(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "dstLang");
            this.dstLang = str;
            return this;
        }

        @NotNull
        public final Builder iotDeviceId(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "iotDeviceId");
            this.iotDeviceId = str;
            return this;
        }

        @NotNull
        public final Builder recognizeData(@Nullable RecognizeData recognizeData2) {
            this.recognizeData = recognizeData2;
            return this;
        }

        @NotNull
        public final Builder role(@Nullable Integer num) {
            this.role = num;
            return this;
        }

        @NotNull
        public final Builder srcLang(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "srcLang");
            this.srcLang = str;
            return this;
        }

        @NotNull
        public final Builder supplier(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "supplier");
            this.supplier = str;
            return this;
        }

        @NotNull
        public final Builder tts(@Nullable TtsConfig ttsConfig) {
            this.tts = ttsConfig;
            return this;
        }

        @NotNull
        @Deprecated(message = "已经废弃，使用UnifiedAsrHelper进行Asr已经无需传入", replaceWith = @ReplaceWith(expression = "UnifiedAsrHelper", imports = {}))
        public final Builder webType(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "webType");
            this.webType = str;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\b\b\u0018\u00002\u00020\u0001BI\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003JM\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\b\u0010!\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010¨\u0006\""}, d2 = {"Lcom/xjsd/xr/sapp/asr/dao/AsrRequestConfig$RequestData;", "", "audioType", "", "sampleRate", "", "channel", "sampleBytes", "hotWords", "", "enablePunctuation", "", "(Ljava/lang/String;IIILjava/util/List;Z)V", "getAudioType", "()Ljava/lang/String;", "getChannel", "()I", "getEnablePunctuation", "()Z", "getHotWords", "()Ljava/util/List;", "getSampleBytes", "getSampleRate", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RequestData {
        @NotNull
        private final String audioType;
        private final int channel;
        private final boolean enablePunctuation;
        @Nullable
        private final List<String> hotWords;
        private final int sampleBytes;
        private final int sampleRate;

        public RequestData() {
            this((String) null, 0, 0, 0, (List) null, false, 63, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ RequestData copy$default(RequestData requestData, String str, int i, int i2, int i3, List<String> list, boolean z, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                str = requestData.audioType;
            }
            if ((i4 & 2) != 0) {
                i = requestData.sampleRate;
            }
            int i5 = i;
            if ((i4 & 4) != 0) {
                i2 = requestData.channel;
            }
            int i6 = i2;
            if ((i4 & 8) != 0) {
                i3 = requestData.sampleBytes;
            }
            int i7 = i3;
            if ((i4 & 16) != 0) {
                list = requestData.hotWords;
            }
            List<String> list2 = list;
            if ((i4 & 32) != 0) {
                z = requestData.enablePunctuation;
            }
            return requestData.copy(str, i5, i6, i7, list2, z);
        }

        @NotNull
        public final String component1() {
            return this.audioType;
        }

        public final int component2() {
            return this.sampleRate;
        }

        public final int component3() {
            return this.channel;
        }

        public final int component4() {
            return this.sampleBytes;
        }

        @Nullable
        public final List<String> component5() {
            return this.hotWords;
        }

        public final boolean component6() {
            return this.enablePunctuation;
        }

        @NotNull
        public final RequestData copy(@NotNull String str, int i, int i2, int i3, @Nullable List<String> list, boolean z) {
            Intrinsics.checkNotNullParameter(str, "audioType");
            return new RequestData(str, i, i2, i3, list, z);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RequestData)) {
                return false;
            }
            RequestData requestData = (RequestData) obj;
            return Intrinsics.areEqual((Object) this.audioType, (Object) requestData.audioType) && this.sampleRate == requestData.sampleRate && this.channel == requestData.channel && this.sampleBytes == requestData.sampleBytes && Intrinsics.areEqual((Object) this.hotWords, (Object) requestData.hotWords) && this.enablePunctuation == requestData.enablePunctuation;
        }

        @NotNull
        public final String getAudioType() {
            return this.audioType;
        }

        public final int getChannel() {
            return this.channel;
        }

        public final boolean getEnablePunctuation() {
            return this.enablePunctuation;
        }

        @Nullable
        public final List<String> getHotWords() {
            return this.hotWords;
        }

        public final int getSampleBytes() {
            return this.sampleBytes;
        }

        public final int getSampleRate() {
            return this.sampleRate;
        }

        public int hashCode() {
            int hashCode = ((((((this.audioType.hashCode() * 31) + Integer.hashCode(this.sampleRate)) * 31) + Integer.hashCode(this.channel)) * 31) + Integer.hashCode(this.sampleBytes)) * 31;
            List<String> list = this.hotWords;
            int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
            boolean z = this.enablePunctuation;
            if (z) {
                z = true;
            }
            return hashCode2 + (z ? 1 : 0);
        }

        @NotNull
        public String toString() {
            return "RequestData(audioType='" + this.audioType + "', sampleRate=" + this.sampleRate + ", channel=" + this.channel + ", sampleBytes=" + this.sampleBytes + ", hotWords=" + this.hotWords + ", enablePunctuation=" + this.enablePunctuation + ')';
        }

        public RequestData(@NotNull String str, int i, int i2, int i3, @Nullable List<String> list, boolean z) {
            Intrinsics.checkNotNullParameter(str, "audioType");
            this.audioType = str;
            this.sampleRate = i;
            this.channel = i2;
            this.sampleBytes = i3;
            this.hotWords = list;
            this.enablePunctuation = z;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ RequestData(java.lang.String r5, int r6, int r7, int r8, java.util.List r9, boolean r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
            /*
                r4 = this;
                r12 = r11 & 1
                if (r12 == 0) goto L_0x0006
                java.lang.String r5 = "opus"
            L_0x0006:
                r12 = r11 & 2
                if (r12 == 0) goto L_0x000c
                r6 = 16000(0x3e80, float:2.2421E-41)
            L_0x000c:
                r12 = r6
                r6 = r11 & 4
                r0 = 1
                if (r6 == 0) goto L_0x0014
                r1 = r0
                goto L_0x0015
            L_0x0014:
                r1 = r7
            L_0x0015:
                r6 = r11 & 8
                if (r6 == 0) goto L_0x001a
                r8 = 2
            L_0x001a:
                r2 = r8
                r6 = r11 & 16
                if (r6 == 0) goto L_0x0020
                r9 = 0
            L_0x0020:
                r3 = r9
                r6 = r11 & 32
                if (r6 == 0) goto L_0x0026
                goto L_0x0027
            L_0x0026:
                r0 = r10
            L_0x0027:
                r6 = r4
                r7 = r5
                r8 = r12
                r9 = r1
                r10 = r2
                r11 = r3
                r12 = r0
                r6.<init>(r7, r8, r9, r10, r11, r12)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xjsd.xr.sapp.asr.dao.AsrRequestConfig.RequestData.<init>(java.lang.String, int, int, int, java.util.List, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }
    }

    public AsrRequestConfig(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull RequestData requestData, @Nullable RecognizeData recognizeData2, @NotNull String str8, @Nullable TtsConfig ttsConfig, @Nullable Integer num, @Nullable Integer num2, @Nullable Long l, @Nullable Long l2) {
        String str9 = str5;
        String str10 = str6;
        String str11 = str7;
        RequestData requestData2 = requestData;
        String str12 = str8;
        Intrinsics.checkNotNullParameter(str, "webType");
        Intrinsics.checkNotNullParameter(str2, "srcLang");
        Intrinsics.checkNotNullParameter(str3, "dstLang");
        Intrinsics.checkNotNullParameter(str4, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(str9, "iotDeviceId");
        Intrinsics.checkNotNullParameter(str10, "supplier");
        Intrinsics.checkNotNullParameter(str11, "appName");
        Intrinsics.checkNotNullParameter(requestData2, "data");
        Intrinsics.checkNotNullParameter(str12, "accountId");
        this.webType = str;
        this.srcLang = str2;
        this.dstLang = str3;
        this.deviceId = str4;
        this.iotDeviceId = str9;
        this.supplier = str10;
        this.appName = str11;
        this.data = requestData2;
        this.recognizeData = recognizeData2;
        this.accountId = str12;
        this.tts = ttsConfig;
        this.role = num;
        this.concatenationStratey = num2;
        this.audioSize = l;
        this.audioTotalDuration = l2;
    }

    public static /* synthetic */ AsrRequestConfig copy$default(AsrRequestConfig asrRequestConfig, String str, String str2, String str3, String str4, String str5, String str6, String str7, RequestData requestData, RecognizeData recognizeData2, String str8, TtsConfig ttsConfig, Integer num, Integer num2, Long l, Long l2, int i, Object obj) {
        AsrRequestConfig asrRequestConfig2 = asrRequestConfig;
        int i2 = i;
        return asrRequestConfig.copy((i2 & 1) != 0 ? asrRequestConfig2.webType : str, (i2 & 2) != 0 ? asrRequestConfig2.srcLang : str2, (i2 & 4) != 0 ? asrRequestConfig2.dstLang : str3, (i2 & 8) != 0 ? asrRequestConfig2.deviceId : str4, (i2 & 16) != 0 ? asrRequestConfig2.iotDeviceId : str5, (i2 & 32) != 0 ? asrRequestConfig2.supplier : str6, (i2 & 64) != 0 ? asrRequestConfig2.appName : str7, (i2 & 128) != 0 ? asrRequestConfig2.data : requestData, (i2 & 256) != 0 ? asrRequestConfig2.recognizeData : recognizeData2, (i2 & 512) != 0 ? asrRequestConfig2.accountId : str8, (i2 & 1024) != 0 ? asrRequestConfig2.tts : ttsConfig, (i2 & 2048) != 0 ? asrRequestConfig2.role : num, (i2 & 4096) != 0 ? asrRequestConfig2.concatenationStratey : num2, (i2 & 8192) != 0 ? asrRequestConfig2.audioSize : l, (i2 & 16384) != 0 ? asrRequestConfig2.audioTotalDuration : l2);
    }

    @NotNull
    public final String component1() {
        return this.webType;
    }

    @NotNull
    public final String component10() {
        return this.accountId;
    }

    @Nullable
    public final TtsConfig component11() {
        return this.tts;
    }

    @Nullable
    public final Integer component12() {
        return this.role;
    }

    @Nullable
    public final Integer component13() {
        return this.concatenationStratey;
    }

    @Nullable
    public final Long component14() {
        return this.audioSize;
    }

    @Nullable
    public final Long component15() {
        return this.audioTotalDuration;
    }

    @NotNull
    public final String component2() {
        return this.srcLang;
    }

    @NotNull
    public final String component3() {
        return this.dstLang;
    }

    @NotNull
    public final String component4() {
        return this.deviceId;
    }

    @NotNull
    public final String component5() {
        return this.iotDeviceId;
    }

    @NotNull
    public final String component6() {
        return this.supplier;
    }

    @NotNull
    public final String component7() {
        return this.appName;
    }

    @NotNull
    public final RequestData component8() {
        return this.data;
    }

    @Nullable
    public final RecognizeData component9() {
        return this.recognizeData;
    }

    @NotNull
    public final AsrRequestConfig copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull RequestData requestData, @Nullable RecognizeData recognizeData2, @NotNull String str8, @Nullable TtsConfig ttsConfig, @Nullable Integer num, @Nullable Integer num2, @Nullable Long l, @Nullable Long l2) {
        String str9 = str;
        Intrinsics.checkNotNullParameter(str9, "webType");
        String str10 = str2;
        Intrinsics.checkNotNullParameter(str10, "srcLang");
        String str11 = str3;
        Intrinsics.checkNotNullParameter(str11, "dstLang");
        String str12 = str4;
        Intrinsics.checkNotNullParameter(str12, Constants.DEVICE_ID);
        String str13 = str5;
        Intrinsics.checkNotNullParameter(str13, "iotDeviceId");
        String str14 = str6;
        Intrinsics.checkNotNullParameter(str14, "supplier");
        String str15 = str7;
        Intrinsics.checkNotNullParameter(str15, "appName");
        RequestData requestData2 = requestData;
        Intrinsics.checkNotNullParameter(requestData2, "data");
        String str16 = str8;
        Intrinsics.checkNotNullParameter(str16, "accountId");
        return new AsrRequestConfig(str9, str10, str11, str12, str13, str14, str15, requestData2, recognizeData2, str16, ttsConfig, num, num2, l, l2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AsrRequestConfig)) {
            return false;
        }
        AsrRequestConfig asrRequestConfig = (AsrRequestConfig) obj;
        return Intrinsics.areEqual((Object) this.webType, (Object) asrRequestConfig.webType) && Intrinsics.areEqual((Object) this.srcLang, (Object) asrRequestConfig.srcLang) && Intrinsics.areEqual((Object) this.dstLang, (Object) asrRequestConfig.dstLang) && Intrinsics.areEqual((Object) this.deviceId, (Object) asrRequestConfig.deviceId) && Intrinsics.areEqual((Object) this.iotDeviceId, (Object) asrRequestConfig.iotDeviceId) && Intrinsics.areEqual((Object) this.supplier, (Object) asrRequestConfig.supplier) && Intrinsics.areEqual((Object) this.appName, (Object) asrRequestConfig.appName) && Intrinsics.areEqual((Object) this.data, (Object) asrRequestConfig.data) && Intrinsics.areEqual((Object) this.recognizeData, (Object) asrRequestConfig.recognizeData) && Intrinsics.areEqual((Object) this.accountId, (Object) asrRequestConfig.accountId) && Intrinsics.areEqual((Object) this.tts, (Object) asrRequestConfig.tts) && Intrinsics.areEqual((Object) this.role, (Object) asrRequestConfig.role) && Intrinsics.areEqual((Object) this.concatenationStratey, (Object) asrRequestConfig.concatenationStratey) && Intrinsics.areEqual((Object) this.audioSize, (Object) asrRequestConfig.audioSize) && Intrinsics.areEqual((Object) this.audioTotalDuration, (Object) asrRequestConfig.audioTotalDuration);
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
    public final RequestData getData() {
        return this.data;
    }

    @NotNull
    public final String getDeviceId() {
        return this.deviceId;
    }

    @NotNull
    public final String getDstLang() {
        return this.dstLang;
    }

    @NotNull
    public final String getIotDeviceId() {
        return this.iotDeviceId;
    }

    @Nullable
    public final RecognizeData getRecognizeData() {
        return this.recognizeData;
    }

    @Nullable
    public final Integer getRole() {
        return this.role;
    }

    @NotNull
    public final String getSrcLang() {
        return this.srcLang;
    }

    @NotNull
    public final String getSupplier() {
        return this.supplier;
    }

    @Nullable
    public final TtsConfig getTts() {
        return this.tts;
    }

    @NotNull
    public final String getWebType() {
        return this.webType;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((this.webType.hashCode() * 31) + this.srcLang.hashCode()) * 31) + this.dstLang.hashCode()) * 31) + this.deviceId.hashCode()) * 31) + this.iotDeviceId.hashCode()) * 31) + this.supplier.hashCode()) * 31) + this.appName.hashCode()) * 31) + this.data.hashCode()) * 31;
        RecognizeData recognizeData2 = this.recognizeData;
        int i = 0;
        int hashCode2 = (((hashCode + (recognizeData2 == null ? 0 : recognizeData2.hashCode())) * 31) + this.accountId.hashCode()) * 31;
        TtsConfig ttsConfig = this.tts;
        int hashCode3 = (hashCode2 + (ttsConfig == null ? 0 : ttsConfig.hashCode())) * 31;
        Integer num = this.role;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.concatenationStratey;
        int hashCode5 = (hashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Long l = this.audioSize;
        int hashCode6 = (hashCode5 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.audioTotalDuration;
        if (l2 != null) {
            i = l2.hashCode();
        }
        return hashCode6 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AsrRequestConfig{");
        sb.append("webType=" + this.webType);
        sb.append("|srcLang=" + this.srcLang);
        sb.append("|dstLang=" + this.dstLang);
        sb.append("|deviceId=" + AsrExtKt.mixSpecialData(this.deviceId));
        sb.append("|iotDeviceId=" + AsrExtKt.mixSpecialData(this.iotDeviceId));
        sb.append("|supplier=" + this.supplier);
        sb.append("|appName=" + this.appName);
        sb.append("|accountId=" + AsrExtKt.mixSpecialData(this.accountId));
        sb.append("|role=" + this.role);
        sb.append("|concatenationStratey=" + this.concatenationStratey);
        sb.append("|audioSize=" + this.audioSize);
        sb.append("|audioTotalDuration=" + this.audioTotalDuration);
        sb.append(StringUtils.LF);
        sb.append("data=" + this.data);
        sb.append(StringUtils.LF);
        sb.append("recognizeData=" + this.recognizeData);
        sb.append(StringUtils.LF);
        sb.append("tts=" + this.tts);
        sb.append("}");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001\u001dB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\b\u0010\u001c\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/xjsd/xr/sapp/asr/dao/AsrRequestConfig$RecognizeData;", "", "account", "", "deviceId", "appName", "recordId", "createTime", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getAccount", "()Ljava/lang/String;", "getAppName", "getCreateTime", "()J", "getDeviceId", "getRecordId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "Builder", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RecognizeData {
        @NotNull
        private final String account;
        @NotNull
        private final String appName;
        private final long createTime;
        @NotNull
        private final String deviceId;
        @NotNull
        private final String recordId;

        @SourceDebugExtension({"SMAP\nAsrRequestConfig.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AsrRequestConfig.kt\ncom/xjsd/xr/sapp/asr/dao/AsrRequestConfig$RecognizeData$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,382:1\n1#2:383\n*E\n"})
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/xjsd/xr/sapp/asr/dao/AsrRequestConfig$RecognizeData$Builder;", "", "()V", "account", "", "appName", "createTime", "", "deviceId", "recordId", "build", "Lcom/xjsd/xr/sapp/asr/dao/AsrRequestConfig$RecognizeData;", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Builder {
            @NotNull
            private String account = "";
            @NotNull
            private String appName = "";
            private long createTime = System.currentTimeMillis();
            @NotNull
            private String deviceId = "";
            @NotNull
            private String recordId = "";

            public static /* synthetic */ Builder createTime$default(Builder builder, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = System.currentTimeMillis();
                }
                return builder.createTime(j);
            }

            @NotNull
            public final Builder account(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "account");
                this.account = str;
                return this;
            }

            @NotNull
            public final Builder appName(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "appName");
                this.appName = str;
                return this;
            }

            @NotNull
            public final RecognizeData build() {
                if (!(!StringsKt.isBlank(this.appName))) {
                    throw new IllegalStateException("appName is blank".toString());
                } else if (!StringsKt.isBlank(this.recordId)) {
                    return new RecognizeData(this.account, this.deviceId, this.appName, this.recordId, this.createTime);
                } else {
                    throw new IllegalStateException("recordId is blank".toString());
                }
            }

            @NotNull
            public final Builder createTime(long j) {
                this.createTime = j;
                return this;
            }

            @NotNull
            public final Builder deviceId(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
                this.deviceId = str;
                return this;
            }

            @NotNull
            public final Builder recordId(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "recordId");
                this.recordId = str;
                return this;
            }
        }

        public RecognizeData(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, long j) {
            Intrinsics.checkNotNullParameter(str, "account");
            Intrinsics.checkNotNullParameter(str2, Constants.DEVICE_ID);
            Intrinsics.checkNotNullParameter(str3, "appName");
            Intrinsics.checkNotNullParameter(str4, "recordId");
            this.account = str;
            this.deviceId = str2;
            this.appName = str3;
            this.recordId = str4;
            this.createTime = j;
        }

        public static /* synthetic */ RecognizeData copy$default(RecognizeData recognizeData, String str, String str2, String str3, String str4, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                str = recognizeData.account;
            }
            if ((i & 2) != 0) {
                str2 = recognizeData.deviceId;
            }
            String str5 = str2;
            if ((i & 4) != 0) {
                str3 = recognizeData.appName;
            }
            String str6 = str3;
            if ((i & 8) != 0) {
                str4 = recognizeData.recordId;
            }
            String str7 = str4;
            if ((i & 16) != 0) {
                j = recognizeData.createTime;
            }
            return recognizeData.copy(str, str5, str6, str7, j);
        }

        @NotNull
        public final String component1() {
            return this.account;
        }

        @NotNull
        public final String component2() {
            return this.deviceId;
        }

        @NotNull
        public final String component3() {
            return this.appName;
        }

        @NotNull
        public final String component4() {
            return this.recordId;
        }

        public final long component5() {
            return this.createTime;
        }

        @NotNull
        public final RecognizeData copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, long j) {
            Intrinsics.checkNotNullParameter(str, "account");
            Intrinsics.checkNotNullParameter(str2, Constants.DEVICE_ID);
            Intrinsics.checkNotNullParameter(str3, "appName");
            Intrinsics.checkNotNullParameter(str4, "recordId");
            return new RecognizeData(str, str2, str3, str4, j);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RecognizeData)) {
                return false;
            }
            RecognizeData recognizeData = (RecognizeData) obj;
            return Intrinsics.areEqual((Object) this.account, (Object) recognizeData.account) && Intrinsics.areEqual((Object) this.deviceId, (Object) recognizeData.deviceId) && Intrinsics.areEqual((Object) this.appName, (Object) recognizeData.appName) && Intrinsics.areEqual((Object) this.recordId, (Object) recognizeData.recordId) && this.createTime == recognizeData.createTime;
        }

        @NotNull
        public final String getAccount() {
            return this.account;
        }

        @NotNull
        public final String getAppName() {
            return this.appName;
        }

        public final long getCreateTime() {
            return this.createTime;
        }

        @NotNull
        public final String getDeviceId() {
            return this.deviceId;
        }

        @NotNull
        public final String getRecordId() {
            return this.recordId;
        }

        public int hashCode() {
            return (((((((this.account.hashCode() * 31) + this.deviceId.hashCode()) * 31) + this.appName.hashCode()) * 31) + this.recordId.hashCode()) * 31) + Long.hashCode(this.createTime);
        }

        @NotNull
        public String toString() {
            return "RecognizeData(account='" + AsrExtKt.mixSpecialData(this.account) + "', deviceId='" + AsrExtKt.mixSpecialData(this.deviceId) + "', appName='" + this.appName + "', recordId='" + this.recordId + "', createTime=" + this.createTime + ')';
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ RecognizeData(String str, String str2, String str3, String str4, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, str4, (i & 16) != 0 ? System.currentTimeMillis() : j);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AsrRequestConfig(java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, com.xjsd.xr.sapp.asr.dao.AsrRequestConfig.RequestData r26, com.xjsd.xr.sapp.asr.dao.AsrRequestConfig.RecognizeData r27, java.lang.String r28, com.xjsd.xr.sapp.asr.dao.TtsConfig r29, java.lang.Integer r30, java.lang.Integer r31, java.lang.Long r32, java.lang.Long r33, int r34, kotlin.jvm.internal.DefaultConstructorMarker r35) {
        /*
            r18 = this;
            r0 = r34
            r1 = r0 & 32
            if (r1 == 0) goto L_0x000a
            java.lang.String r1 = "microsoft"
            r8 = r1
            goto L_0x000c
        L_0x000a:
            r8 = r24
        L_0x000c:
            r1 = r0 & 256(0x100, float:3.59E-43)
            r2 = 0
            if (r1 == 0) goto L_0x0013
            r11 = r2
            goto L_0x0015
        L_0x0013:
            r11 = r27
        L_0x0015:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x001b
            r13 = r2
            goto L_0x001d
        L_0x001b:
            r13 = r29
        L_0x001d:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0023
            r14 = r2
            goto L_0x0025
        L_0x0023:
            r14 = r30
        L_0x0025:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x002b
            r15 = r2
            goto L_0x002d
        L_0x002b:
            r15 = r31
        L_0x002d:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x0034
            r16 = r2
            goto L_0x0036
        L_0x0034:
            r16 = r32
        L_0x0036:
            r0 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x003d
            r17 = r2
            goto L_0x003f
        L_0x003d:
            r17 = r33
        L_0x003f:
            r2 = r18
            r3 = r19
            r4 = r20
            r5 = r21
            r6 = r22
            r7 = r23
            r9 = r25
            r10 = r26
            r12 = r28
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.xr.sapp.asr.dao.AsrRequestConfig.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.xjsd.xr.sapp.asr.dao.AsrRequestConfig$RequestData, com.xjsd.xr.sapp.asr.dao.AsrRequestConfig$RecognizeData, java.lang.String, com.xjsd.xr.sapp.asr.dao.TtsConfig, java.lang.Integer, java.lang.Integer, java.lang.Long, java.lang.Long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
