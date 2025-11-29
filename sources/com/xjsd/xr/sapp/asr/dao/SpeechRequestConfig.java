package com.xjsd.xr.sapp.asr.dao;

import com.upuphone.runasone.constant.Constants;
import com.xjsd.xr.sapp.asr.utils.AsrExtKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001#BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003JO\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\b\u0010\"\u001a\u00020\u0003H\u0016R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006$"}, d2 = {"Lcom/xjsd/xr/sapp/asr/dao/SpeechRequestConfig;", "", "webType", "", "deviceId", "iotDeviceId", "language", "supplier", "appName", "data", "Lcom/xjsd/xr/sapp/asr/dao/SpeechRequestConfig$RequestData;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/xjsd/xr/sapp/asr/dao/SpeechRequestConfig$RequestData;)V", "getAppName", "()Ljava/lang/String;", "getData", "()Lcom/xjsd/xr/sapp/asr/dao/SpeechRequestConfig$RequestData;", "getDeviceId", "getIotDeviceId", "getLanguage", "getSupplier", "getWebType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "RequestData", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SpeechRequestConfig {
    @NotNull
    private final String appName;
    @NotNull
    private final RequestData data;
    @NotNull
    private final String deviceId;
    @NotNull
    private final String iotDeviceId;
    @NotNull
    private final String language;
    @NotNull
    private final String supplier;
    @NotNull
    private final String webType;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\b\b\u0018\u00002\u00020\u0001BI\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003JM\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\b\u0010!\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010¨\u0006\""}, d2 = {"Lcom/xjsd/xr/sapp/asr/dao/SpeechRequestConfig$RequestData;", "", "audioType", "", "sampleRate", "", "channel", "sampleBytes", "hotWords", "", "enablePunctuation", "", "(Ljava/lang/String;IIILjava/util/List;Z)V", "getAudioType", "()Ljava/lang/String;", "getChannel", "()I", "getEnablePunctuation", "()Z", "getHotWords", "()Ljava/util/List;", "getSampleBytes", "getSampleRate", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
            throw new UnsupportedOperationException("Method not decompiled: com.xjsd.xr.sapp.asr.dao.SpeechRequestConfig.RequestData.<init>(java.lang.String, int, int, int, java.util.List, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }
    }

    public SpeechRequestConfig(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull RequestData requestData) {
        Intrinsics.checkNotNullParameter(str, "webType");
        Intrinsics.checkNotNullParameter(str2, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(str3, "iotDeviceId");
        Intrinsics.checkNotNullParameter(str4, "language");
        Intrinsics.checkNotNullParameter(str5, "supplier");
        Intrinsics.checkNotNullParameter(str6, "appName");
        Intrinsics.checkNotNullParameter(requestData, "data");
        this.webType = str;
        this.deviceId = str2;
        this.iotDeviceId = str3;
        this.language = str4;
        this.supplier = str5;
        this.appName = str6;
        this.data = requestData;
    }

    public static /* synthetic */ SpeechRequestConfig copy$default(SpeechRequestConfig speechRequestConfig, String str, String str2, String str3, String str4, String str5, String str6, RequestData requestData, int i, Object obj) {
        if ((i & 1) != 0) {
            str = speechRequestConfig.webType;
        }
        if ((i & 2) != 0) {
            str2 = speechRequestConfig.deviceId;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = speechRequestConfig.iotDeviceId;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = speechRequestConfig.language;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = speechRequestConfig.supplier;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = speechRequestConfig.appName;
        }
        String str11 = str6;
        if ((i & 64) != 0) {
            requestData = speechRequestConfig.data;
        }
        return speechRequestConfig.copy(str, str7, str8, str9, str10, str11, requestData);
    }

    @NotNull
    public final String component1() {
        return this.webType;
    }

    @NotNull
    public final String component2() {
        return this.deviceId;
    }

    @NotNull
    public final String component3() {
        return this.iotDeviceId;
    }

    @NotNull
    public final String component4() {
        return this.language;
    }

    @NotNull
    public final String component5() {
        return this.supplier;
    }

    @NotNull
    public final String component6() {
        return this.appName;
    }

    @NotNull
    public final RequestData component7() {
        return this.data;
    }

    @NotNull
    public final SpeechRequestConfig copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull RequestData requestData) {
        Intrinsics.checkNotNullParameter(str, "webType");
        Intrinsics.checkNotNullParameter(str2, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(str3, "iotDeviceId");
        Intrinsics.checkNotNullParameter(str4, "language");
        Intrinsics.checkNotNullParameter(str5, "supplier");
        Intrinsics.checkNotNullParameter(str6, "appName");
        Intrinsics.checkNotNullParameter(requestData, "data");
        return new SpeechRequestConfig(str, str2, str3, str4, str5, str6, requestData);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SpeechRequestConfig)) {
            return false;
        }
        SpeechRequestConfig speechRequestConfig = (SpeechRequestConfig) obj;
        return Intrinsics.areEqual((Object) this.webType, (Object) speechRequestConfig.webType) && Intrinsics.areEqual((Object) this.deviceId, (Object) speechRequestConfig.deviceId) && Intrinsics.areEqual((Object) this.iotDeviceId, (Object) speechRequestConfig.iotDeviceId) && Intrinsics.areEqual((Object) this.language, (Object) speechRequestConfig.language) && Intrinsics.areEqual((Object) this.supplier, (Object) speechRequestConfig.supplier) && Intrinsics.areEqual((Object) this.appName, (Object) speechRequestConfig.appName) && Intrinsics.areEqual((Object) this.data, (Object) speechRequestConfig.data);
    }

    @NotNull
    public final String getAppName() {
        return this.appName;
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
    public final String getIotDeviceId() {
        return this.iotDeviceId;
    }

    @NotNull
    public final String getLanguage() {
        return this.language;
    }

    @NotNull
    public final String getSupplier() {
        return this.supplier;
    }

    @NotNull
    public final String getWebType() {
        return this.webType;
    }

    public int hashCode() {
        return (((((((((((this.webType.hashCode() * 31) + this.deviceId.hashCode()) * 31) + this.iotDeviceId.hashCode()) * 31) + this.language.hashCode()) * 31) + this.supplier.hashCode()) * 31) + this.appName.hashCode()) * 31) + this.data.hashCode();
    }

    @NotNull
    public String toString() {
        return "SpeechRequestConfig(webType='" + this.webType + "', deviceId='" + AsrExtKt.mixSpecialData(this.deviceId) + "', iotDeviceId='" + AsrExtKt.mixSpecialData(this.iotDeviceId) + "', language='" + this.language + "', supplier='" + this.supplier + "', data=" + this.data + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SpeechRequestConfig(String str, String str2, String str3, String str4, String str5, String str6, RequestData requestData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i & 8) != 0 ? "en-GB" : str4, (i & 16) != 0 ? "google" : str5, (i & 32) != 0 ? "UNKNOWN" : str6, requestData);
    }
}
