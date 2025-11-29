package com.xjsd.xr.sapp.asr.dao;

import com.upuphone.starrynet.payload.PayloadConstant;
import io.netty.handler.codec.rtsp.RtspHeaders;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0002\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010$\u001a\u00020\rHÆ\u0003J\t\u0010%\u001a\u00020\rHÆ\u0003Jg\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\rHÆ\u0001J\u0013\u0010'\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\b\u0010+\u001a\u00020\u0003H\u0016R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006,"}, d2 = {"Lcom/xjsd/xr/sapp/asr/dao/AsrResponse;", "", "requestId", "", "event", "code", "msg", "time", "data", "Lcom/xjsd/xr/sapp/asr/dao/AsrResponseData;", "vadInfo", "Lcom/xjsd/xr/sapp/asr/dao/AsrResponseVad;", "finish", "", "end", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/xjsd/xr/sapp/asr/dao/AsrResponseData;Lcom/xjsd/xr/sapp/asr/dao/AsrResponseVad;ZZ)V", "getCode", "()Ljava/lang/String;", "getData", "()Lcom/xjsd/xr/sapp/asr/dao/AsrResponseData;", "getEnd", "()Z", "getEvent", "getFinish", "getMsg", "getRequestId", "getTime", "getVadInfo", "()Lcom/xjsd/xr/sapp/asr/dao/AsrResponseVad;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AsrResponse {
    @NotNull
    private final String code;
    @Nullable
    private final AsrResponseData data;
    private final boolean end;
    @NotNull
    private final String event;
    private final boolean finish;
    @NotNull
    private final String msg;
    @NotNull
    private final String requestId;
    @NotNull
    private final String time;
    @Nullable
    private final AsrResponseVad vadInfo;

    public AsrResponse(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @Nullable AsrResponseData asrResponseData, @Nullable AsrResponseVad asrResponseVad, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "requestId");
        Intrinsics.checkNotNullParameter(str2, "event");
        Intrinsics.checkNotNullParameter(str3, "code");
        Intrinsics.checkNotNullParameter(str4, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        Intrinsics.checkNotNullParameter(str5, RtspHeaders.Values.TIME);
        this.requestId = str;
        this.event = str2;
        this.code = str3;
        this.msg = str4;
        this.time = str5;
        this.data = asrResponseData;
        this.vadInfo = asrResponseVad;
        this.finish = z;
        this.end = z2;
    }

    public static /* synthetic */ AsrResponse copy$default(AsrResponse asrResponse, String str, String str2, String str3, String str4, String str5, AsrResponseData asrResponseData, AsrResponseVad asrResponseVad, boolean z, boolean z2, int i, Object obj) {
        AsrResponse asrResponse2 = asrResponse;
        int i2 = i;
        return asrResponse.copy((i2 & 1) != 0 ? asrResponse2.requestId : str, (i2 & 2) != 0 ? asrResponse2.event : str2, (i2 & 4) != 0 ? asrResponse2.code : str3, (i2 & 8) != 0 ? asrResponse2.msg : str4, (i2 & 16) != 0 ? asrResponse2.time : str5, (i2 & 32) != 0 ? asrResponse2.data : asrResponseData, (i2 & 64) != 0 ? asrResponse2.vadInfo : asrResponseVad, (i2 & 128) != 0 ? asrResponse2.finish : z, (i2 & 256) != 0 ? asrResponse2.end : z2);
    }

    @NotNull
    public final String component1() {
        return this.requestId;
    }

    @NotNull
    public final String component2() {
        return this.event;
    }

    @NotNull
    public final String component3() {
        return this.code;
    }

    @NotNull
    public final String component4() {
        return this.msg;
    }

    @NotNull
    public final String component5() {
        return this.time;
    }

    @Nullable
    public final AsrResponseData component6() {
        return this.data;
    }

    @Nullable
    public final AsrResponseVad component7() {
        return this.vadInfo;
    }

    public final boolean component8() {
        return this.finish;
    }

    public final boolean component9() {
        return this.end;
    }

    @NotNull
    public final AsrResponse copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @Nullable AsrResponseData asrResponseData, @Nullable AsrResponseVad asrResponseVad, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "requestId");
        Intrinsics.checkNotNullParameter(str2, "event");
        Intrinsics.checkNotNullParameter(str3, "code");
        Intrinsics.checkNotNullParameter(str4, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        String str6 = str5;
        Intrinsics.checkNotNullParameter(str6, RtspHeaders.Values.TIME);
        return new AsrResponse(str, str2, str3, str4, str6, asrResponseData, asrResponseVad, z, z2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AsrResponse)) {
            return false;
        }
        AsrResponse asrResponse = (AsrResponse) obj;
        return Intrinsics.areEqual((Object) this.requestId, (Object) asrResponse.requestId) && Intrinsics.areEqual((Object) this.event, (Object) asrResponse.event) && Intrinsics.areEqual((Object) this.code, (Object) asrResponse.code) && Intrinsics.areEqual((Object) this.msg, (Object) asrResponse.msg) && Intrinsics.areEqual((Object) this.time, (Object) asrResponse.time) && Intrinsics.areEqual((Object) this.data, (Object) asrResponse.data) && Intrinsics.areEqual((Object) this.vadInfo, (Object) asrResponse.vadInfo) && this.finish == asrResponse.finish && this.end == asrResponse.end;
    }

    @NotNull
    public final String getCode() {
        return this.code;
    }

    @Nullable
    public final AsrResponseData getData() {
        return this.data;
    }

    public final boolean getEnd() {
        return this.end;
    }

    @NotNull
    public final String getEvent() {
        return this.event;
    }

    public final boolean getFinish() {
        return this.finish;
    }

    @NotNull
    public final String getMsg() {
        return this.msg;
    }

    @NotNull
    public final String getRequestId() {
        return this.requestId;
    }

    @NotNull
    public final String getTime() {
        return this.time;
    }

    @Nullable
    public final AsrResponseVad getVadInfo() {
        return this.vadInfo;
    }

    public int hashCode() {
        int hashCode = ((((((((this.requestId.hashCode() * 31) + this.event.hashCode()) * 31) + this.code.hashCode()) * 31) + this.msg.hashCode()) * 31) + this.time.hashCode()) * 31;
        AsrResponseData asrResponseData = this.data;
        int i = 0;
        int hashCode2 = (hashCode + (asrResponseData == null ? 0 : asrResponseData.hashCode())) * 31;
        AsrResponseVad asrResponseVad = this.vadInfo;
        if (asrResponseVad != null) {
            i = asrResponseVad.hashCode();
        }
        int i2 = (hashCode2 + i) * 31;
        boolean z = this.finish;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i3 = (i2 + (z ? 1 : 0)) * 31;
        boolean z3 = this.end;
        if (!z3) {
            z2 = z3;
        }
        return i3 + (z2 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        return "AsrResponse(requestId='" + this.requestId + "', event='" + this.event + "', code='" + this.code + "', msg='" + this.msg + "', time='" + this.time + "', data=" + this.data + ", vadInfo=" + this.vadInfo + ", finish=" + this.finish + ", end=" + this.end + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AsrResponse(java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, com.xjsd.xr.sapp.asr.dao.AsrResponseData r19, com.xjsd.xr.sapp.asr.dao.AsrResponseVad r20, boolean r21, boolean r22, int r23, kotlin.jvm.internal.DefaultConstructorMarker r24) {
        /*
            r13 = this;
            r0 = r23
            r1 = r0 & 32
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r9 = r2
            goto L_0x000b
        L_0x0009:
            r9 = r19
        L_0x000b:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0011
            r10 = r2
            goto L_0x0013
        L_0x0011:
            r10 = r20
        L_0x0013:
            r1 = r0 & 128(0x80, float:1.794E-43)
            r2 = 0
            if (r1 == 0) goto L_0x001a
            r11 = r2
            goto L_0x001c
        L_0x001a:
            r11 = r21
        L_0x001c:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0022
            r12 = r2
            goto L_0x0024
        L_0x0022:
            r12 = r22
        L_0x0024:
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r7 = r17
            r8 = r18
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.xr.sapp.asr.dao.AsrResponse.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.xjsd.xr.sapp.asr.dao.AsrResponseData, com.xjsd.xr.sapp.asr.dao.AsrResponseVad, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
