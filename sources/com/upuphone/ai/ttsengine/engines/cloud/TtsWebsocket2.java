package com.upuphone.ai.ttsengine.engines.cloud;

import com.upuphone.ai.ttsengine.base.utils.AILOG;
import com.upuphone.ai.ttsengine.engines.cloud.Status;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0003+,-J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ'\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nJ)\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0013\u0010\u0017J\u001f\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0018\u0010\u0019R#\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\b0\u001a8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010'\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006."}, d2 = {"Lcom/upuphone/ai/ttsengine/engines/cloud/TtsWebsocket2;", "Lokhttp3/WebSocketListener;", "Lokhttp3/WebSocket;", "webSocket", "", "code", "", "reason", "", "onClosed", "(Lokhttp3/WebSocket;ILjava/lang/String;)V", "onClosing", "", "t", "Lokhttp3/Response;", "response", "onFailure", "(Lokhttp3/WebSocket;Ljava/lang/Throwable;Lokhttp3/Response;)V", "text", "onMessage", "(Lokhttp3/WebSocket;Ljava/lang/String;)V", "Lokio/ByteString;", "bs", "(Lokhttp3/WebSocket;Lokio/ByteString;)V", "onOpen", "(Lokhttp3/WebSocket;Lokhttp3/Response;)V", "Lkotlin/Function1;", "Lcom/upuphone/ai/ttsengine/engines/cloud/Status;", "a", "Lkotlin/jvm/functions/Function1;", "getOnData", "()Lkotlin/jvm/functions/Function1;", "onData", "Lcom/upuphone/ai/ttsengine/base/utils/AILOG;", "b", "Lcom/upuphone/ai/ttsengine/base/utils/AILOG;", "aiLog", "c", "Ljava/lang/String;", "path", "d", "I", "dataIndex", "App", "TtsRequest", "User", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nTtsWebsocket2.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TtsWebsocket2.kt\ncom/upuphone/ai/ttsengine/engines/cloud/TtsWebsocket2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,183:1\n1#2:184\n*E\n"})
public final class TtsWebsocket2 extends WebSocketListener {

    /* renamed from: a  reason: collision with root package name */
    public final Function1 f5556a;
    public final AILOG b;
    public final String c;
    public int d;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/upuphone/ai/ttsengine/engines/cloud/TtsWebsocket2$App;", "", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
    public final class App {
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/upuphone/ai/ttsengine/engines/cloud/TtsWebsocket2$TtsRequest;", "", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
    public final class TtsRequest {
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/upuphone/ai/ttsengine/engines/cloud/TtsWebsocket2$User;", "", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
    public final class User {
    }

    public void onClosed(WebSocket webSocket, int i, String str) {
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(str, "reason");
        AILOG ailog = this.b;
        ailog.c("onClosed, code: " + i + ", reason: " + str, new Object[0]);
    }

    public void onClosing(WebSocket webSocket, int i, String str) {
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(str, "reason");
        this.b.c("onClosing", new Object[0]);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000f, code lost:
        r2 = r4.body();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onFailure(okhttp3.WebSocket r2, java.lang.Throwable r3, okhttp3.Response r4) {
        /*
            r1 = this;
            java.lang.String r0 = "webSocket"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r2 = "t"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r2)
            com.upuphone.ai.ttsengine.base.utils.AILOG r1 = r1.b
            if (r4 == 0) goto L_0x001a
            okhttp3.ResponseBody r2 = r4.body()
            if (r2 == 0) goto L_0x001a
            java.lang.String r2 = r2.string()
            goto L_0x001b
        L_0x001a:
            r2 = 0
        L_0x001b:
            java.lang.String r3 = r3.getMessage()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = "onFailure response: "
            r4.append(r0)
            r4.append(r2)
            java.lang.String r2 = ", t: "
            r4.append(r2)
            r4.append(r3)
            java.lang.String r2 = r4.toString()
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r1.c(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ai.ttsengine.engines.cloud.TtsWebsocket2.onFailure(okhttp3.WebSocket, java.lang.Throwable, okhttp3.Response):void");
    }

    public void onMessage(WebSocket webSocket, String str) {
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(str, "text");
        AILOG ailog = this.b;
        ailog.c("onMessage: " + str, new Object[0]);
    }

    public void onOpen(WebSocket webSocket, Response response) {
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(response, "response");
        this.b.c("onOpen", new Object[0]);
    }

    public void onMessage(WebSocket webSocket, ByteString byteString) {
        WebSocket webSocket2 = webSocket;
        Intrinsics.checkNotNullParameter(webSocket2, "webSocket");
        Intrinsics.checkNotNullParameter(byteString, "bs");
        ByteBuffer asByteBuffer = byteString.asByteBuffer();
        byte[] array = asByteBuffer.array();
        AILOG ailog = this.b;
        String arrays = Arrays.toString(array);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(...)");
        ailog.c("source bytes: " + arrays, new Object[0]);
        byte b2 = asByteBuffer.get(0) & 15;
        int i = (asByteBuffer.get(1) & 255) >> 4;
        byte b3 = asByteBuffer.get(1) & 15;
        AILOG ailog2 = this.b;
        ailog2.c("protocol version: " + ((asByteBuffer.get(0) & 255) >> 4) + ", header size: " + b2 + ", message type: " + i + ", specific flags: " + b3 + ", serialization method: " + ((asByteBuffer.get(2) & 255) >> 4) + ", message compression: " + (asByteBuffer.get(2) & 15) + ", reserved: " + (asByteBuffer.get(3) & 255), new Object[0]);
        asByteBuffer.position(b2 * 4);
        byte[] bArr = new byte[4];
        if (i != 11) {
            if (i != 15) {
                this.b.p("Received unknown response message type: {}", Integer.valueOf(i));
                return;
            }
            asByteBuffer.get(bArr, 0, 4);
            new BigInteger(bArr).intValue();
            asByteBuffer.get(bArr, 0, 4);
            int intValue = new BigInteger(bArr).intValue();
            byte[] bArr2 = new byte[intValue];
            asByteBuffer.get(bArr2, 0, intValue);
            Charset charset = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(charset, "UTF_8");
            new String(bArr2, charset);
        } else if (b3 == 0) {
            this.b.c("received audio-only response.", new Object[0]);
        } else {
            asByteBuffer.get(bArr, 0, 4);
            int intValue2 = new BigInteger(bArr).intValue();
            asByteBuffer.get(bArr, 0, 4);
            int intValue3 = new BigInteger(bArr).intValue();
            byte[] bArr3 = new byte[intValue3];
            asByteBuffer.get(bArr3, 0, intValue3);
            AILOG ailog3 = this.b;
            ailog3.c("sequenceNumber: " + intValue2 + ", payload size: " + intValue3, new Object[0]);
            AILOG ailog4 = this.b;
            String arrays2 = Arrays.toString(bArr3);
            Intrinsics.checkNotNullExpressionValue(arrays2, "toString(...)");
            ailog4.c("ogg opus payload: " + arrays2, new Object[0]);
            Function1 function1 = this.f5556a;
            byte[] copyOf = Arrays.copyOf(bArr3, intValue3);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            function1.invoke(new Status.AudioData(intValue2, "ogg_opus", copyOf.toString(), (String) null, 8, (DefaultConstructorMarker) null));
            if (intValue2 < 0) {
                webSocket2.close(0, "close cause finished");
            }
            Job unused = BuildersKt__Builders_commonKt.d(GlobalScope.f3732a, (CoroutineContext) null, (CoroutineStart) null, new TtsWebsocket2$onMessage$1(this, array, bArr3, intValue2, (Continuation<? super TtsWebsocket2$onMessage$1>) null), 3, (Object) null);
        }
    }
}
