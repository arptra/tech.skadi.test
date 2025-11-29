package com.xjsd.xr.sapp.asr.dao;

import androidx.annotation.IntRange;
import com.google.gson.annotations.SerializedName;
import com.meizu.common.util.LunarCalendar;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001:\u0001(B]\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0003\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003Jc\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\bHÖ\u0001J\b\u0010'\u001a\u00020\u0003H\u0016R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006)"}, d2 = {"Lcom/xjsd/xr/sapp/asr/dao/TtsConfig;", "", "voiceId", "", "reqId", "text", "audioFormat", "returnFormat", "", "compressionRate", "language", "gender", "textType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAudioFormat", "()Ljava/lang/String;", "getCompressionRate", "()I", "getGender", "getLanguage", "getReqId", "getReturnFormat", "getText", "getTextType", "getVoiceId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "Builder", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TtsConfig {
    @NotNull
    private final String audioFormat;
    private final int compressionRate;
    @NotNull
    private final String gender;
    @NotNull
    private final String language;
    @SerializedName("reqid")
    @NotNull
    private final String reqId;
    private final int returnFormat;
    @NotNull
    private final String text;
    @NotNull
    private final String textType;
    @NotNull
    private final String voiceId;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0005\u001a\u00020\u00002\b\b\u0001\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/xjsd/xr/sapp/asr/dao/TtsConfig$Builder;", "", "()V", "audioFormat", "", "compressionRate", "", "gender", "language", "reqId", "returnFormat", "text", "textType", "voiceId", "build", "Lcom/xjsd/xr/sapp/asr/dao/TtsConfig;", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Builder {
        @NotNull
        private String audioFormat;
        @IntRange
        private int compressionRate;
        @NotNull
        private String gender;
        @NotNull
        private String language;
        @NotNull
        private String reqId;
        private int returnFormat;
        @NotNull
        private String text;
        @NotNull
        private String textType;
        @NotNull
        private String voiceId = "BV700_streaming";

        public Builder() {
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
            this.reqId = StringsKt.replace$default(uuid, LunarCalendar.DATE_SEPARATOR, "", false, 4, (Object) null);
            this.text = "";
            this.audioFormat = "ogg_opus";
            this.returnFormat = 1;
            this.compressionRate = 10;
            this.language = "cn";
            this.gender = "female";
            this.textType = "plain";
        }

        @NotNull
        public final Builder audioFormat(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "audioFormat");
            this.audioFormat = str;
            return this;
        }

        @NotNull
        public final TtsConfig build() {
            return new TtsConfig(this.voiceId, this.reqId, this.text, this.audioFormat, this.returnFormat, this.compressionRate, this.language, this.gender, this.textType);
        }

        @NotNull
        public final Builder compressionRate(@IntRange int i) {
            this.compressionRate = i;
            return this;
        }

        @NotNull
        public final Builder gender(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "gender");
            this.gender = str;
            return this;
        }

        @NotNull
        public final Builder language(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "language");
            this.language = str;
            return this;
        }

        @NotNull
        public final Builder reqId(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "reqId");
            this.reqId = str;
            return this;
        }

        @NotNull
        public final Builder returnFormat(int i) {
            this.returnFormat = i;
            return this;
        }

        @NotNull
        public final Builder text(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "text");
            this.text = str;
            return this;
        }

        @NotNull
        public final Builder textType(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "textType");
            this.textType = str;
            return this;
        }

        @NotNull
        public final Builder voiceId(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "voiceId");
            this.voiceId = str;
            return this;
        }
    }

    public TtsConfig(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, int i, @IntRange int i2, @NotNull String str5, @NotNull String str6, @NotNull String str7) {
        Intrinsics.checkNotNullParameter(str, "voiceId");
        Intrinsics.checkNotNullParameter(str2, "reqId");
        Intrinsics.checkNotNullParameter(str3, "text");
        Intrinsics.checkNotNullParameter(str4, "audioFormat");
        Intrinsics.checkNotNullParameter(str5, "language");
        Intrinsics.checkNotNullParameter(str6, "gender");
        Intrinsics.checkNotNullParameter(str7, "textType");
        this.voiceId = str;
        this.reqId = str2;
        this.text = str3;
        this.audioFormat = str4;
        this.returnFormat = i;
        this.compressionRate = i2;
        this.language = str5;
        this.gender = str6;
        this.textType = str7;
    }

    public static /* synthetic */ TtsConfig copy$default(TtsConfig ttsConfig, String str, String str2, String str3, String str4, int i, int i2, String str5, String str6, String str7, int i3, Object obj) {
        TtsConfig ttsConfig2 = ttsConfig;
        int i4 = i3;
        return ttsConfig.copy((i4 & 1) != 0 ? ttsConfig2.voiceId : str, (i4 & 2) != 0 ? ttsConfig2.reqId : str2, (i4 & 4) != 0 ? ttsConfig2.text : str3, (i4 & 8) != 0 ? ttsConfig2.audioFormat : str4, (i4 & 16) != 0 ? ttsConfig2.returnFormat : i, (i4 & 32) != 0 ? ttsConfig2.compressionRate : i2, (i4 & 64) != 0 ? ttsConfig2.language : str5, (i4 & 128) != 0 ? ttsConfig2.gender : str6, (i4 & 256) != 0 ? ttsConfig2.textType : str7);
    }

    @NotNull
    public final String component1() {
        return this.voiceId;
    }

    @NotNull
    public final String component2() {
        return this.reqId;
    }

    @NotNull
    public final String component3() {
        return this.text;
    }

    @NotNull
    public final String component4() {
        return this.audioFormat;
    }

    public final int component5() {
        return this.returnFormat;
    }

    public final int component6() {
        return this.compressionRate;
    }

    @NotNull
    public final String component7() {
        return this.language;
    }

    @NotNull
    public final String component8() {
        return this.gender;
    }

    @NotNull
    public final String component9() {
        return this.textType;
    }

    @NotNull
    public final TtsConfig copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, int i, @IntRange int i2, @NotNull String str5, @NotNull String str6, @NotNull String str7) {
        Intrinsics.checkNotNullParameter(str, "voiceId");
        Intrinsics.checkNotNullParameter(str2, "reqId");
        Intrinsics.checkNotNullParameter(str3, "text");
        Intrinsics.checkNotNullParameter(str4, "audioFormat");
        String str8 = str5;
        Intrinsics.checkNotNullParameter(str8, "language");
        String str9 = str6;
        Intrinsics.checkNotNullParameter(str9, "gender");
        String str10 = str7;
        Intrinsics.checkNotNullParameter(str10, "textType");
        return new TtsConfig(str, str2, str3, str4, i, i2, str8, str9, str10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TtsConfig)) {
            return false;
        }
        TtsConfig ttsConfig = (TtsConfig) obj;
        return Intrinsics.areEqual((Object) this.voiceId, (Object) ttsConfig.voiceId) && Intrinsics.areEqual((Object) this.reqId, (Object) ttsConfig.reqId) && Intrinsics.areEqual((Object) this.text, (Object) ttsConfig.text) && Intrinsics.areEqual((Object) this.audioFormat, (Object) ttsConfig.audioFormat) && this.returnFormat == ttsConfig.returnFormat && this.compressionRate == ttsConfig.compressionRate && Intrinsics.areEqual((Object) this.language, (Object) ttsConfig.language) && Intrinsics.areEqual((Object) this.gender, (Object) ttsConfig.gender) && Intrinsics.areEqual((Object) this.textType, (Object) ttsConfig.textType);
    }

    @NotNull
    public final String getAudioFormat() {
        return this.audioFormat;
    }

    public final int getCompressionRate() {
        return this.compressionRate;
    }

    @NotNull
    public final String getGender() {
        return this.gender;
    }

    @NotNull
    public final String getLanguage() {
        return this.language;
    }

    @NotNull
    public final String getReqId() {
        return this.reqId;
    }

    public final int getReturnFormat() {
        return this.returnFormat;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    @NotNull
    public final String getTextType() {
        return this.textType;
    }

    @NotNull
    public final String getVoiceId() {
        return this.voiceId;
    }

    public int hashCode() {
        return (((((((((((((((this.voiceId.hashCode() * 31) + this.reqId.hashCode()) * 31) + this.text.hashCode()) * 31) + this.audioFormat.hashCode()) * 31) + Integer.hashCode(this.returnFormat)) * 31) + Integer.hashCode(this.compressionRate)) * 31) + this.language.hashCode()) * 31) + this.gender.hashCode()) * 31) + this.textType.hashCode();
    }

    @NotNull
    public String toString() {
        return "TtsConfig(voiceId='" + this.voiceId + "', reqId='" + this.reqId + "', text='" + this.text + "', audioFormat='" + this.audioFormat + "', returnFormat=" + this.returnFormat + ", compressionRate=" + this.compressionRate + ", language='" + this.language + "', gender='" + this.gender + "', textType='" + this.textType + "')";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TtsConfig(java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, int r17, int r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, int r22, kotlin.jvm.internal.DefaultConstructorMarker r23) {
        /*
            r12 = this;
            r0 = r22
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000a
            java.lang.String r1 = "BV700_streaming"
            r3 = r1
            goto L_0x000b
        L_0x000a:
            r3 = r13
        L_0x000b:
            r1 = r0 & 2
            if (r1 == 0) goto L_0x002a
            java.util.UUID r1 = java.util.UUID.randomUUID()
            java.lang.String r4 = r1.toString()
            java.lang.String r1 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r1)
            r8 = 4
            r9 = 0
            java.lang.String r5 = "-"
            java.lang.String r6 = ""
            r7 = 0
            java.lang.String r1 = kotlin.text.StringsKt.replace$default((java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6, (boolean) r7, (int) r8, (java.lang.Object) r9)
            r4 = r1
            goto L_0x002b
        L_0x002a:
            r4 = r14
        L_0x002b:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0033
            java.lang.String r1 = "ogg_opus"
            r6 = r1
            goto L_0x0035
        L_0x0033:
            r6 = r16
        L_0x0035:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x003c
            r1 = 1
            r7 = r1
            goto L_0x003e
        L_0x003c:
            r7 = r17
        L_0x003e:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0046
            r1 = 10
            r8 = r1
            goto L_0x0048
        L_0x0046:
            r8 = r18
        L_0x0048:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0050
            java.lang.String r1 = "cn"
            r9 = r1
            goto L_0x0052
        L_0x0050:
            r9 = r19
        L_0x0052:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x005a
            java.lang.String r1 = "female"
            r10 = r1
            goto L_0x005c
        L_0x005a:
            r10 = r20
        L_0x005c:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0064
            java.lang.String r0 = "plain"
            r11 = r0
            goto L_0x0066
        L_0x0064:
            r11 = r21
        L_0x0066:
            r2 = r12
            r5 = r15
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.xr.sapp.asr.dao.TtsConfig.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
