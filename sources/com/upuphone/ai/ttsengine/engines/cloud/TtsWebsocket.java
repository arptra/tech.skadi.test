package com.upuphone.ai.ttsengine.engines.cloud;

import com.upuphone.ai.ttsengine.base.utils.AILOG;
import com.upuphone.ai.ttsengine.engines.cloud.Status;
import com.xjsd.ai.assistant.net.ws.VirtualWebSocket;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0005\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001c\u0010\u001dR#\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001c\u0010&\u001a\n #*\u0004\u0018\u00010\"0\"8\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006'"}, d2 = {"Lcom/upuphone/ai/ttsengine/engines/cloud/TtsWebsocket;", "Lcom/xjsd/ai/assistant/net/ws/VirtualWebSocket;", "Lkotlin/Function1;", "Lcom/upuphone/ai/ttsengine/engines/cloud/Status;", "", "onData", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "", "getFunctionType", "()I", "", "getVirtualAppName", "()Ljava/lang/String;", "code", "onClose", "(I)V", "", "data", "([B)V", "Lcom/xjsd/ai/assistant/net/ws/protocol/EndToEndResponse;", "response", "onMsg", "(Lcom/xjsd/ai/assistant/net/ws/protocol/EndToEndResponse;)V", "onParse", "()V", "onResume", "hexString", "B", "(Ljava/lang/String;)[B", "a", "Lkotlin/jvm/functions/Function1;", "getOnData", "()Lkotlin/jvm/functions/Function1;", "Lcom/upuphone/ai/ttsengine/base/utils/AILOG;", "kotlin.jvm.PlatformType", "b", "Lcom/upuphone/ai/ttsengine/base/utils/AILOG;", "aiLog", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class TtsWebsocket extends VirtualWebSocket {

    /* renamed from: a  reason: collision with root package name */
    public final Function1 f5555a;
    public final AILOG b = AILOG.a("TtsWebsocket");

    public TtsWebsocket(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "onData");
        this.f5555a = function1;
    }

    public final byte[] B(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            String substring = str.substring(i2, i2 + 2);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            bArr[i] = (byte) Integer.parseInt(substring, CharsKt.checkRadix(16));
        }
        return bArr;
    }

    public int getFunctionType() {
        return 5;
    }

    public String getVirtualAppName() {
        return "com.upuphone.tts";
    }

    public void onClose(int i) {
        AILOG ailog = this.b;
        ailog.c("on closed: " + i, new Object[0]);
        this.f5555a.invoke(new Status.Error(i, "websocket closed"));
    }

    public void onData(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        AILOG ailog = this.b;
        int length = bArr.length;
        ailog.c("onData: " + length, new Object[0]);
        Function1 function1 = this.f5555a;
        Status.AudioData audioData = new Status.AudioData(-1, "mp3", "", (String) null, 8, (DefaultConstructorMarker) null);
        audioData.setAudioBytes(bArr);
        function1.invoke(audioData);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035 A[Catch:{ all -> 0x0028 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMsg(com.xjsd.ai.assistant.net.ws.protocol.EndToEndResponse r4) {
        /*
            r3 = this;
            java.lang.String r0 = "response"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0028 }
            java.lang.Class<com.upuphone.ai.ttsengine.engines.cloud.Status$AudioData> r0 = com.upuphone.ai.ttsengine.engines.cloud.Status.AudioData.class
            java.lang.Object r0 = r4.parsePayload(r0)     // Catch:{ all -> 0x0028 }
            com.upuphone.ai.ttsengine.engines.cloud.Status$AudioData r0 = (com.upuphone.ai.ttsengine.engines.cloud.Status.AudioData) r0     // Catch:{ all -> 0x0028 }
            java.lang.String r4 = r4.getRequestId()     // Catch:{ all -> 0x0028 }
            java.lang.String r1 = "getRequestId(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r1)     // Catch:{ all -> 0x0028 }
            r0.setRequestId(r4)     // Catch:{ all -> 0x0028 }
            java.lang.String r4 = r0.getEncoding()     // Catch:{ all -> 0x0028 }
            if (r4 == 0) goto L_0x002a
            int r4 = r4.length()     // Catch:{ all -> 0x0028 }
            if (r4 != 0) goto L_0x002f
            goto L_0x002a
        L_0x0028:
            r4 = move-exception
            goto L_0x0053
        L_0x002a:
            java.lang.String r4 = "mp3"
            r0.setEncoding(r4)     // Catch:{ all -> 0x0028 }
        L_0x002f:
            int r4 = r0.getSequence()     // Catch:{ all -> 0x0028 }
            if (r4 != 0) goto L_0x0039
            r4 = -1
            r0.setSequence(r4)     // Catch:{ all -> 0x0028 }
        L_0x0039:
            java.lang.String r4 = r0.getData()     // Catch:{ all -> 0x0028 }
            byte[] r4 = r3.B(r4)     // Catch:{ all -> 0x0028 }
            r0.setAudioBytes(r4)     // Catch:{ all -> 0x0028 }
            kotlin.jvm.functions.Function1 r4 = r3.f5555a     // Catch:{ all -> 0x0028 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch:{ all -> 0x0028 }
            r4.invoke(r0)     // Catch:{ all -> 0x0028 }
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0028 }
            java.lang.Object r4 = kotlin.Result.m20constructorimpl(r4)     // Catch:{ all -> 0x0028 }
            goto L_0x005d
        L_0x0053:
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r4 = kotlin.ResultKt.createFailure(r4)
            java.lang.Object r4 = kotlin.Result.m20constructorimpl(r4)
        L_0x005d:
            java.lang.Throwable r4 = kotlin.Result.m23exceptionOrNullimpl(r4)
            if (r4 == 0) goto L_0x0074
            kotlin.jvm.functions.Function1 r3 = r3.f5555a
            com.upuphone.ai.ttsengine.engines.cloud.Status$Error r0 = new com.upuphone.ai.ttsengine.engines.cloud.Status$Error
            r1 = -1111(0xfffffffffffffba9, float:NaN)
            java.lang.String r2 = "parse exception"
            r0.<init>(r1, r2)
            r3.invoke(r0)
            r4.printStackTrace()
        L_0x0074:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ai.ttsengine.engines.cloud.TtsWebsocket.onMsg(com.xjsd.ai.assistant.net.ws.protocol.EndToEndResponse):void");
    }

    public void onParse() {
    }

    public void onResume() {
    }
}
