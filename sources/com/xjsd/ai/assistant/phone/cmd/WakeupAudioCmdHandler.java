package com.xjsd.ai.assistant.phone.cmd;

import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.xjmz.ai.opus.OpusCodec;
import com.xjsd.ai.assistant.common.handler.CmdHandler;
import com.xjsd.ai.assistant.phone.vad.OpusDecoder;
import com.xjsd.ai.assistant.protocol.Cmd;
import com.xjsd.ai.assistant.protocol.CmdCode;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/xjsd/ai/assistant/phone/cmd/WakeupAudioCmdHandler;", "Lcom/xjsd/ai/assistant/common/handler/CmdHandler;", "<init>", "()V", "", "getHandleCode", "()I", "Lcom/upuphone/xr/interconnect/entity/StarryNetMessage;", "message", "Lcom/xjsd/ai/assistant/protocol/Cmd;", "cmd", "", "handle", "(Lcom/upuphone/xr/interconnect/entity/StarryNetMessage;Lcom/xjsd/ai/assistant/protocol/Cmd;)V", "Lcom/xjmz/ai/opus/OpusCodec;", "a", "Lcom/xjmz/ai/opus/OpusCodec;", "opusDecoder", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nWakeupAudioCmdHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WakeupAudioCmdHandler.kt\ncom/xjsd/ai/assistant/phone/cmd/WakeupAudioCmdHandler\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,124:1\n1#2:125\n*E\n"})
public final class WakeupAudioCmdHandler implements CmdHandler {

    /* renamed from: a  reason: collision with root package name */
    public OpusCodec f8549a;

    public int getHandleCode() {
        return CmdCode.CODE_WAKEUP_AUDIO;
    }

    public void handle(StarryNetMessage starryNetMessage, Cmd cmd) {
        Intrinsics.checkNotNullParameter(starryNetMessage, "message");
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        byte[] data = starryNetMessage.getData();
        int length = data.length;
        int i = 0;
        while (i < length) {
            byte[] bArr = new byte[2];
            System.arraycopy(data, i, bArr, 0, 2);
            int i2 = (bArr[1] & 255) | (bArr[0] << 8);
            byte[] bArr2 = new byte[i2];
            int i3 = i + 2;
            System.arraycopy(data, i3, bArr2, 0, i2);
            if (this.f8549a == null) {
                this.f8549a = OpusDecoder.b.a(i2);
            }
            OpusCodec opusCodec = this.f8549a;
            if (opusCodec != null) {
                byte[] copyOf = Arrays.copyOf(bArr2, i2);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
                byte[] decodeFrame = opusCodec.decodeFrame(copyOf);
                if (decodeFrame != null) {
                    WakeupAudioCmdHandlerKt.f8550a = ArraysKt.plus(WakeupAudioCmdHandlerKt.f8550a, decodeFrame);
                }
            }
            i = i3 + i2;
        }
    }
}
