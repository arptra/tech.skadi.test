package com.upuphone.ai.ttsengine.engines.cloud;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001Bc\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003Ji\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0007HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006("}, d2 = {"Lcom/upuphone/ai/ttsengine/engines/cloud/RequestConfig;", "", "reqid", "", "text", "text_type", "silence_duration", "", "operation", "with_frontend", "frontend_type", "with_timestamp", "pure_english_opt", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFrontend_type", "()Ljava/lang/String;", "getOperation", "getPure_english_opt", "getReqid", "getSilence_duration", "()I", "getText", "getText_type", "getWith_frontend", "getWith_timestamp", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "aar_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class RequestConfig {
    @Nullable
    private final String frontend_type;
    @NotNull
    private final String operation;
    @NotNull
    private final String pure_english_opt;
    @NotNull
    private final String reqid;
    private final int silence_duration;
    @NotNull
    private final String text;
    @NotNull
    private final String text_type;
    @Nullable
    private final String with_frontend;
    @Nullable
    private final String with_timestamp;

    public RequestConfig(@NotNull String str, @NotNull String str2, @NotNull String str3, int i, @NotNull String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @NotNull String str8) {
        Intrinsics.checkNotNullParameter(str, "reqid");
        Intrinsics.checkNotNullParameter(str2, "text");
        Intrinsics.checkNotNullParameter(str3, "text_type");
        Intrinsics.checkNotNullParameter(str4, "operation");
        Intrinsics.checkNotNullParameter(str8, "pure_english_opt");
        this.reqid = str;
        this.text = str2;
        this.text_type = str3;
        this.silence_duration = i;
        this.operation = str4;
        this.with_frontend = str5;
        this.frontend_type = str6;
        this.with_timestamp = str7;
        this.pure_english_opt = str8;
    }

    public static /* synthetic */ RequestConfig copy$default(RequestConfig requestConfig, String str, String str2, String str3, int i, String str4, String str5, String str6, String str7, String str8, int i2, Object obj) {
        RequestConfig requestConfig2 = requestConfig;
        int i3 = i2;
        return requestConfig.copy((i3 & 1) != 0 ? requestConfig2.reqid : str, (i3 & 2) != 0 ? requestConfig2.text : str2, (i3 & 4) != 0 ? requestConfig2.text_type : str3, (i3 & 8) != 0 ? requestConfig2.silence_duration : i, (i3 & 16) != 0 ? requestConfig2.operation : str4, (i3 & 32) != 0 ? requestConfig2.with_frontend : str5, (i3 & 64) != 0 ? requestConfig2.frontend_type : str6, (i3 & 128) != 0 ? requestConfig2.with_timestamp : str7, (i3 & 256) != 0 ? requestConfig2.pure_english_opt : str8);
    }

    @NotNull
    public final String component1() {
        return this.reqid;
    }

    @NotNull
    public final String component2() {
        return this.text;
    }

    @NotNull
    public final String component3() {
        return this.text_type;
    }

    public final int component4() {
        return this.silence_duration;
    }

    @NotNull
    public final String component5() {
        return this.operation;
    }

    @Nullable
    public final String component6() {
        return this.with_frontend;
    }

    @Nullable
    public final String component7() {
        return this.frontend_type;
    }

    @Nullable
    public final String component8() {
        return this.with_timestamp;
    }

    @NotNull
    public final String component9() {
        return this.pure_english_opt;
    }

    @NotNull
    public final RequestConfig copy(@NotNull String str, @NotNull String str2, @NotNull String str3, int i, @NotNull String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @NotNull String str8) {
        Intrinsics.checkNotNullParameter(str, "reqid");
        Intrinsics.checkNotNullParameter(str2, "text");
        Intrinsics.checkNotNullParameter(str3, "text_type");
        String str9 = str4;
        Intrinsics.checkNotNullParameter(str9, "operation");
        String str10 = str8;
        Intrinsics.checkNotNullParameter(str10, "pure_english_opt");
        return new RequestConfig(str, str2, str3, i, str9, str5, str6, str7, str10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RequestConfig)) {
            return false;
        }
        RequestConfig requestConfig = (RequestConfig) obj;
        return Intrinsics.areEqual((Object) this.reqid, (Object) requestConfig.reqid) && Intrinsics.areEqual((Object) this.text, (Object) requestConfig.text) && Intrinsics.areEqual((Object) this.text_type, (Object) requestConfig.text_type) && this.silence_duration == requestConfig.silence_duration && Intrinsics.areEqual((Object) this.operation, (Object) requestConfig.operation) && Intrinsics.areEqual((Object) this.with_frontend, (Object) requestConfig.with_frontend) && Intrinsics.areEqual((Object) this.frontend_type, (Object) requestConfig.frontend_type) && Intrinsics.areEqual((Object) this.with_timestamp, (Object) requestConfig.with_timestamp) && Intrinsics.areEqual((Object) this.pure_english_opt, (Object) requestConfig.pure_english_opt);
    }

    @Nullable
    public final String getFrontend_type() {
        return this.frontend_type;
    }

    @NotNull
    public final String getOperation() {
        return this.operation;
    }

    @NotNull
    public final String getPure_english_opt() {
        return this.pure_english_opt;
    }

    @NotNull
    public final String getReqid() {
        return this.reqid;
    }

    public final int getSilence_duration() {
        return this.silence_duration;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    @NotNull
    public final String getText_type() {
        return this.text_type;
    }

    @Nullable
    public final String getWith_frontend() {
        return this.with_frontend;
    }

    @Nullable
    public final String getWith_timestamp() {
        return this.with_timestamp;
    }

    public int hashCode() {
        int hashCode = ((((((((this.reqid.hashCode() * 31) + this.text.hashCode()) * 31) + this.text_type.hashCode()) * 31) + Integer.hashCode(this.silence_duration)) * 31) + this.operation.hashCode()) * 31;
        String str = this.with_frontend;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.frontend_type;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.with_timestamp;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return ((hashCode3 + i) * 31) + this.pure_english_opt.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.reqid;
        String str2 = this.text;
        String str3 = this.text_type;
        int i = this.silence_duration;
        String str4 = this.operation;
        String str5 = this.with_frontend;
        String str6 = this.frontend_type;
        String str7 = this.with_timestamp;
        String str8 = this.pure_english_opt;
        return "RequestConfig(reqid=" + str + ", text=" + str2 + ", text_type=" + str3 + ", silence_duration=" + i + ", operation=" + str4 + ", with_frontend=" + str5 + ", frontend_type=" + str6 + ", with_timestamp=" + str7 + ", pure_english_opt=" + str8 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RequestConfig(java.lang.String r14, java.lang.String r15, java.lang.String r16, int r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, int r23, kotlin.jvm.internal.DefaultConstructorMarker r24) {
        /*
            r13 = this;
            r0 = r23
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0016
            java.util.UUID r1 = java.util.UUID.randomUUID()
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r4 = r1
            goto L_0x0017
        L_0x0016:
            r4 = r14
        L_0x0017:
            r1 = r0 & 4
            if (r1 == 0) goto L_0x001f
            java.lang.String r1 = "plain"
            r6 = r1
            goto L_0x0021
        L_0x001f:
            r6 = r16
        L_0x0021:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0029
            r1 = 125(0x7d, float:1.75E-43)
            r7 = r1
            goto L_0x002b
        L_0x0029:
            r7 = r17
        L_0x002b:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0033
            java.lang.String r1 = "submit"
            r8 = r1
            goto L_0x0035
        L_0x0033:
            r8 = r18
        L_0x0035:
            r1 = r0 & 32
            r2 = 0
            if (r1 == 0) goto L_0x003c
            r9 = r2
            goto L_0x003e
        L_0x003c:
            r9 = r19
        L_0x003e:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0044
            r10 = r2
            goto L_0x0046
        L_0x0044:
            r10 = r20
        L_0x0046:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x004c
            r11 = r2
            goto L_0x004e
        L_0x004c:
            r11 = r21
        L_0x004e:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0056
            java.lang.String r0 = "1"
            r12 = r0
            goto L_0x0058
        L_0x0056:
            r12 = r22
        L_0x0058:
            r3 = r13
            r5 = r15
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ai.ttsengine.engines.cloud.RequestConfig.<init>(java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
