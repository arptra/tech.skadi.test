package com.xjsd.xr.sapp.asr.utils;

import com.xjsd.xr.sapp.asr.dao.AsrRequest;
import com.xjsd.xr.sapp.asr.dao.AsrResponse;
import com.xjsd.xr.sapp.asr.dao.AsrResponseData;
import com.xjsd.xr.sapp.asr.dao.AsrResult;
import com.xjsd.xr.sapp.asr.dao.Dst;
import com.xjsd.xr.sapp.asr.dao.ResultExt;
import com.xjsd.xr.sapp.asr.dao.Src;
import com.xjsd.xr.sapp.asr.dao.TtsData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0000\u001a\u0018\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0000\u001a\f\u0010\u0006\u001a\u00020\u0007*\u00020\u0002H\u0000¨\u0006\b"}, d2 = {"transcribed", "Lcom/xjsd/xr/sapp/asr/dao/AsrResult;", "Lcom/xjsd/xr/sapp/asr/dao/AsrResponse;", "asrRequest", "Lcom/xjsd/xr/sapp/asr/dao/AsrRequest;", "translation", "ttsData", "Lcom/xjsd/xr/sapp/asr/dao/TtsData;", "asr_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class AsrResultExtKt {
    @NotNull
    public static final AsrResult transcribed(@NotNull AsrResponse asrResponse, @Nullable AsrRequest asrRequest) {
        String str;
        Intrinsics.checkNotNullParameter(asrResponse, "<this>");
        boolean z = !asrResponse.getFinish();
        AsrResponseData data = asrResponse.getData();
        if (data == null || (str = data.getText()) == null) {
            str = "";
        }
        String str2 = str;
        boolean z2 = !asrResponse.getEnd();
        AsrResponseData data2 = asrResponse.getData();
        long j = 0;
        long startTime = data2 != null ? data2.getStartTime() : 0;
        AsrResponseData data3 = asrResponse.getData();
        if (data3 != null) {
            j = data3.getEndTime();
        }
        long j2 = j;
        AsrResponseData data4 = asrResponse.getData();
        int partIndex = data4 != null ? data4.getPartIndex() : 0;
        AsrResponseData data5 = asrResponse.getData();
        return new AsrResult(new Src(z ? 1 : 0, str2, z2 ? 1 : 0, startTime, j2, partIndex, data5 != null ? data5.getPartNum() : 0), (Dst) null, asrRequest != null ? new ResultExt(asrRequest.getRequestId(), asrRequest.getRecognizeId(), (Long) null, (Long) null, 12, (DefaultConstructorMarker) null) : null);
    }

    public static /* synthetic */ AsrResult transcribed$default(AsrResponse asrResponse, AsrRequest asrRequest, int i, Object obj) {
        if ((i & 1) != 0) {
            asrRequest = null;
        }
        return transcribed(asrResponse, asrRequest);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0015, code lost:
        r1 = r1.getTranslateText();
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.xjsd.xr.sapp.asr.dao.AsrResult translation(@org.jetbrains.annotations.NotNull com.xjsd.xr.sapp.asr.dao.AsrResponse r14, @org.jetbrains.annotations.Nullable com.xjsd.xr.sapp.asr.dao.AsrRequest r15) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            com.xjsd.xr.sapp.asr.dao.Dst r0 = new com.xjsd.xr.sapp.asr.dao.Dst
            boolean r1 = r14.getFinish()
            r2 = r1 ^ 1
            com.xjsd.xr.sapp.asr.dao.AsrResponseData r1 = r14.getData()
            java.lang.String r3 = ""
            if (r1 == 0) goto L_0x001e
            java.lang.String r1 = r1.getTranslateText()
            if (r1 != 0) goto L_0x001c
            goto L_0x001e
        L_0x001c:
            r4 = r1
            goto L_0x001f
        L_0x001e:
            r4 = r3
        L_0x001f:
            com.xjsd.xr.sapp.asr.dao.AsrResponseData r1 = r14.getData()
            if (r1 == 0) goto L_0x002e
            java.lang.String r1 = r1.getText()
            if (r1 != 0) goto L_0x002c
            goto L_0x002e
        L_0x002c:
            r5 = r1
            goto L_0x002f
        L_0x002e:
            r5 = r3
        L_0x002f:
            boolean r1 = r14.getEnd()
            r6 = r1 ^ 1
            com.xjsd.xr.sapp.asr.dao.AsrResponseData r1 = r14.getData()
            r7 = 0
            if (r1 == 0) goto L_0x0042
            long r9 = r1.getStartTime()
            goto L_0x0043
        L_0x0042:
            r9 = r7
        L_0x0043:
            com.xjsd.xr.sapp.asr.dao.AsrResponseData r1 = r14.getData()
            if (r1 == 0) goto L_0x004d
            long r7 = r1.getEndTime()
        L_0x004d:
            r11 = r7
            com.xjsd.xr.sapp.asr.dao.AsrResponseData r1 = r14.getData()
            r3 = 0
            if (r1 == 0) goto L_0x005b
            int r1 = r1.getPartIndex()
            r13 = r1
            goto L_0x005c
        L_0x005b:
            r13 = r3
        L_0x005c:
            com.xjsd.xr.sapp.asr.dao.AsrResponseData r14 = r14.getData()
            if (r14 == 0) goto L_0x0067
            int r14 = r14.getPartNum()
            goto L_0x0068
        L_0x0067:
            r14 = r3
        L_0x0068:
            r1 = r0
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r9
            r8 = r11
            r10 = r13
            r11 = r14
            r1.<init>(r2, r3, r4, r5, r6, r8, r10, r11)
            r14 = 0
            if (r15 == 0) goto L_0x008a
            com.xjsd.xr.sapp.asr.dao.ResultExt r8 = new com.xjsd.xr.sapp.asr.dao.ResultExt
            java.lang.String r2 = r15.getRequestId()
            java.lang.String r3 = r15.getRecognizeId()
            r6 = 12
            r7 = 0
            r4 = 0
            r5 = 0
            r1 = r8
            r1.<init>(r2, r3, r4, r5, r6, r7)
            goto L_0x008b
        L_0x008a:
            r8 = r14
        L_0x008b:
            com.xjsd.xr.sapp.asr.dao.AsrResult r15 = new com.xjsd.xr.sapp.asr.dao.AsrResult
            r15.<init>(r14, r0, r8)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.xr.sapp.asr.utils.AsrResultExtKt.translation(com.xjsd.xr.sapp.asr.dao.AsrResponse, com.xjsd.xr.sapp.asr.dao.AsrRequest):com.xjsd.xr.sapp.asr.dao.AsrResult");
    }

    public static /* synthetic */ AsrResult translation$default(AsrResponse asrResponse, AsrRequest asrRequest, int i, Object obj) {
        if ((i & 1) != 0) {
            asrRequest = null;
        }
        return translation(asrResponse, asrRequest);
    }

    @NotNull
    public static final TtsData ttsData(@NotNull AsrResponse asrResponse) {
        byte[] bArr;
        String data;
        Intrinsics.checkNotNullParameter(asrResponse, "<this>");
        AsrResponseData data2 = asrResponse.getData();
        if (data2 == null || (data = data2.getData()) == null || (bArr = AsrExtKt.hexToByteArray(data)) == null) {
            bArr = new byte[0];
        }
        AsrResponseData data3 = asrResponse.getData();
        return new TtsData(bArr, data3 != null ? data3.getTime() : 0);
    }
}
