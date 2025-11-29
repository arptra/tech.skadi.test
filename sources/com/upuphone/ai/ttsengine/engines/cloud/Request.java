package com.upuphone.ai.ttsengine.engines.cloud;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b&\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0010J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0016J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\tHÆ\u0003J\t\u0010*\u001a\u00020\tHÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0001\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\tHÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0019\u0010\u0016R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014¨\u00064"}, d2 = {"Lcom/upuphone/ai/ttsengine/engines/cloud/Request;", "", "voiceId", "", "reqid", "text", "audioFormat", "textType", "silenceDuration", "", "ReturnFormat", "compressionRate", "method", "language", "gender", "inputWay", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getReturnFormat", "()I", "getAudioFormat", "()Ljava/lang/String;", "getCompressionRate", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getGender", "getInputWay", "getLanguage", "getMethod", "getReqid", "getSilenceDuration", "getText", "getTextType", "getVoiceId", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/upuphone/ai/ttsengine/engines/cloud/Request;", "equals", "", "other", "hashCode", "toString", "aar_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class Request {
    private final int ReturnFormat;
    @NotNull
    private final String audioFormat;
    @Nullable
    private final Integer compressionRate;
    @Nullable
    private final String gender;
    @Nullable
    private final Integer inputWay;
    @Nullable
    private final String language;
    @Nullable
    private final String method;
    @NotNull
    private final String reqid;
    private final int silenceDuration;
    @NotNull
    private final String text;
    @NotNull
    private final String textType;
    @NotNull
    private final String voiceId;

    public Request(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, int i, int i2, @Nullable Integer num, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable Integer num2) {
        Intrinsics.checkNotNullParameter(str, "voiceId");
        Intrinsics.checkNotNullParameter(str2, "reqid");
        Intrinsics.checkNotNullParameter(str3, "text");
        Intrinsics.checkNotNullParameter(str4, "audioFormat");
        Intrinsics.checkNotNullParameter(str5, "textType");
        this.voiceId = str;
        this.reqid = str2;
        this.text = str3;
        this.audioFormat = str4;
        this.textType = str5;
        this.silenceDuration = i;
        this.ReturnFormat = i2;
        this.compressionRate = num;
        this.method = str6;
        this.language = str7;
        this.gender = str8;
        this.inputWay = num2;
    }

    public static /* synthetic */ Request copy$default(Request request, String str, String str2, String str3, String str4, String str5, int i, int i2, Integer num, String str6, String str7, String str8, Integer num2, int i3, Object obj) {
        Request request2 = request;
        int i4 = i3;
        return request.copy((i4 & 1) != 0 ? request2.voiceId : str, (i4 & 2) != 0 ? request2.reqid : str2, (i4 & 4) != 0 ? request2.text : str3, (i4 & 8) != 0 ? request2.audioFormat : str4, (i4 & 16) != 0 ? request2.textType : str5, (i4 & 32) != 0 ? request2.silenceDuration : i, (i4 & 64) != 0 ? request2.ReturnFormat : i2, (i4 & 128) != 0 ? request2.compressionRate : num, (i4 & 256) != 0 ? request2.method : str6, (i4 & 512) != 0 ? request2.language : str7, (i4 & 1024) != 0 ? request2.gender : str8, (i4 & 2048) != 0 ? request2.inputWay : num2);
    }

    @NotNull
    public final String component1() {
        return this.voiceId;
    }

    @Nullable
    public final String component10() {
        return this.language;
    }

    @Nullable
    public final String component11() {
        return this.gender;
    }

    @Nullable
    public final Integer component12() {
        return this.inputWay;
    }

    @NotNull
    public final String component2() {
        return this.reqid;
    }

    @NotNull
    public final String component3() {
        return this.text;
    }

    @NotNull
    public final String component4() {
        return this.audioFormat;
    }

    @NotNull
    public final String component5() {
        return this.textType;
    }

    public final int component6() {
        return this.silenceDuration;
    }

    public final int component7() {
        return this.ReturnFormat;
    }

    @Nullable
    public final Integer component8() {
        return this.compressionRate;
    }

    @Nullable
    public final String component9() {
        return this.method;
    }

    @NotNull
    public final Request copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, int i, int i2, @Nullable Integer num, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable Integer num2) {
        Intrinsics.checkNotNullParameter(str, "voiceId");
        String str9 = str2;
        Intrinsics.checkNotNullParameter(str9, "reqid");
        String str10 = str3;
        Intrinsics.checkNotNullParameter(str10, "text");
        String str11 = str4;
        Intrinsics.checkNotNullParameter(str11, "audioFormat");
        String str12 = str5;
        Intrinsics.checkNotNullParameter(str12, "textType");
        return new Request(str, str9, str10, str11, str12, i, i2, num, str6, str7, str8, num2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Request)) {
            return false;
        }
        Request request = (Request) obj;
        return Intrinsics.areEqual((Object) this.voiceId, (Object) request.voiceId) && Intrinsics.areEqual((Object) this.reqid, (Object) request.reqid) && Intrinsics.areEqual((Object) this.text, (Object) request.text) && Intrinsics.areEqual((Object) this.audioFormat, (Object) request.audioFormat) && Intrinsics.areEqual((Object) this.textType, (Object) request.textType) && this.silenceDuration == request.silenceDuration && this.ReturnFormat == request.ReturnFormat && Intrinsics.areEqual((Object) this.compressionRate, (Object) request.compressionRate) && Intrinsics.areEqual((Object) this.method, (Object) request.method) && Intrinsics.areEqual((Object) this.language, (Object) request.language) && Intrinsics.areEqual((Object) this.gender, (Object) request.gender) && Intrinsics.areEqual((Object) this.inputWay, (Object) request.inputWay);
    }

    @NotNull
    public final String getAudioFormat() {
        return this.audioFormat;
    }

    @Nullable
    public final Integer getCompressionRate() {
        return this.compressionRate;
    }

    @Nullable
    public final String getGender() {
        return this.gender;
    }

    @Nullable
    public final Integer getInputWay() {
        return this.inputWay;
    }

    @Nullable
    public final String getLanguage() {
        return this.language;
    }

    @Nullable
    public final String getMethod() {
        return this.method;
    }

    @NotNull
    public final String getReqid() {
        return this.reqid;
    }

    public final int getReturnFormat() {
        return this.ReturnFormat;
    }

    public final int getSilenceDuration() {
        return this.silenceDuration;
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
        int hashCode = ((((((((((((this.voiceId.hashCode() * 31) + this.reqid.hashCode()) * 31) + this.text.hashCode()) * 31) + this.audioFormat.hashCode()) * 31) + this.textType.hashCode()) * 31) + Integer.hashCode(this.silenceDuration)) * 31) + Integer.hashCode(this.ReturnFormat)) * 31;
        Integer num = this.compressionRate;
        int i = 0;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.method;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.language;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.gender;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num2 = this.inputWay;
        if (num2 != null) {
            i = num2.hashCode();
        }
        return hashCode5 + i;
    }

    @NotNull
    public String toString() {
        String str = this.voiceId;
        String str2 = this.reqid;
        String str3 = this.text;
        String str4 = this.audioFormat;
        String str5 = this.textType;
        int i = this.silenceDuration;
        int i2 = this.ReturnFormat;
        Integer num = this.compressionRate;
        String str6 = this.method;
        String str7 = this.language;
        String str8 = this.gender;
        Integer num2 = this.inputWay;
        return "Request(voiceId=" + str + ", reqid=" + str2 + ", text=" + str3 + ", audioFormat=" + str4 + ", textType=" + str5 + ", silenceDuration=" + i + ", ReturnFormat=" + i2 + ", compressionRate=" + num + ", method=" + str6 + ", language=" + str7 + ", gender=" + str8 + ", inputWay=" + num2 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Request(java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, int r21, int r22, java.lang.Integer r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.Integer r27, int r28, kotlin.jvm.internal.DefaultConstructorMarker r29) {
        /*
            r15 = this;
            r0 = r28
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000a
            java.lang.String r1 = "BV700_streaming"
            r3 = r1
            goto L_0x000c
        L_0x000a:
            r3 = r16
        L_0x000c:
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0020
            java.util.UUID r1 = java.util.UUID.randomUUID()
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r4 = r1
            goto L_0x0022
        L_0x0020:
            r4 = r17
        L_0x0022:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x002a
            java.lang.String r1 = "mp3"
            r6 = r1
            goto L_0x002c
        L_0x002a:
            r6 = r19
        L_0x002c:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0034
            java.lang.String r1 = "plain"
            r7 = r1
            goto L_0x0036
        L_0x0034:
            r7 = r20
        L_0x0036:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x003e
            r1 = 125(0x7d, float:1.75E-43)
            r8 = r1
            goto L_0x0040
        L_0x003e:
            r8 = r21
        L_0x0040:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0047
            r1 = 1
            r9 = r1
            goto L_0x0049
        L_0x0047:
            r9 = r22
        L_0x0049:
            r1 = r0 & 128(0x80, float:1.794E-43)
            r2 = 0
            if (r1 == 0) goto L_0x0050
            r10 = r2
            goto L_0x0052
        L_0x0050:
            r10 = r23
        L_0x0052:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x005a
            java.lang.String r1 = "http"
            r11 = r1
            goto L_0x005c
        L_0x005a:
            r11 = r24
        L_0x005c:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0062
            r12 = r2
            goto L_0x0064
        L_0x0062:
            r12 = r25
        L_0x0064:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x006a
            r13 = r2
            goto L_0x006c
        L_0x006a:
            r13 = r26
        L_0x006c:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x0072
            r14 = r2
            goto L_0x0074
        L_0x0072:
            r14 = r27
        L_0x0074:
            r2 = r15
            r5 = r18
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ai.ttsengine.engines.cloud.Request.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
