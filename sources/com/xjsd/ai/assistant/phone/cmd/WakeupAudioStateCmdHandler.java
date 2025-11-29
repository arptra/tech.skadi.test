package com.xjsd.ai.assistant.phone.cmd;

import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.xjmz.ai.voice.VoiceManager;
import com.xjsd.ai.assistant.audio.AudioDataUtil;
import com.xjsd.ai.assistant.common.handler.CmdHandler;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.helper.VrStateSynchronizer;
import com.xjsd.ai.assistant.phone.helper.WakeupVoiceStorage;
import com.xjsd.ai.assistant.protocol.Cmd;
import com.xjsd.ai.assistant.protocol.CmdCode;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00128\u0002XD¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/xjsd/ai/assistant/phone/cmd/WakeupAudioStateCmdHandler;", "Lcom/xjsd/ai/assistant/common/handler/CmdHandler;", "<init>", "()V", "", "getHandleCode", "()I", "Lcom/upuphone/xr/interconnect/entity/StarryNetMessage;", "message", "Lcom/xjsd/ai/assistant/protocol/Cmd;", "cmd", "", "handle", "(Lcom/upuphone/xr/interconnect/entity/StarryNetMessage;Lcom/xjsd/ai/assistant/protocol/Cmd;)V", "c", "", "d", "()Z", "", "a", "Ljava/lang/String;", "tag", "", "b", "J", "wakeupVoiceEngine", "Z", "isInit", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nWakeupAudioCmdHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WakeupAudioCmdHandler.kt\ncom/xjsd/ai/assistant/phone/cmd/WakeupAudioStateCmdHandler\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,124:1\n1855#2,2:125\n*S KotlinDebug\n*F\n+ 1 WakeupAudioCmdHandler.kt\ncom/xjsd/ai/assistant/phone/cmd/WakeupAudioStateCmdHandler\n*L\n111#1:125,2\n*E\n"})
public final class WakeupAudioStateCmdHandler implements CmdHandler {

    /* renamed from: a  reason: collision with root package name */
    public final String f8551a = "WakeupAudioStateCmdHandler";
    public long b;
    public volatile boolean c;

    public WakeupAudioStateCmdHandler() {
        c();
    }

    public final void c() {
        Job unused = BuildersKt__Builders_commonKt.d(GlobalScope.f3732a, (CoroutineContext) null, (CoroutineStart) null, new WakeupAudioStateCmdHandler$init$1(this, (Continuation<? super WakeupAudioStateCmdHandler$init$1>) null), 3, (Object) null);
    }

    public final boolean d() {
        List<float[]> list = WakeupVoiceStorage.get$default(WakeupVoiceStorage.INSTANCE, (String) null, 1, (Object) null);
        if (list.isEmpty()) {
            ILog.a(this.f8551a, "wakeup check is empty");
            return true;
        }
        if (!this.c) {
            c();
        }
        VoiceManager instance = VoiceManager.Companion.getInstance();
        float[] spkRecogGetEmb = instance.spkRecogGetEmb(this.b, WakeupAudioCmdHandlerKt.f8550a, WakeupAudioCmdHandlerKt.f8550a.length);
        String str = this.f8551a;
        ILog.a(str, "voice print: " + spkRecogGetEmb);
        for (float[] similarity : list) {
            float similarity2 = instance.similarity(similarity, spkRecogGetEmb, spkRecogGetEmb.length);
            String str2 = this.f8551a;
            ILog.a(str2, "limit: " + 0.4d + ", threshold: " + similarity2);
            if (((double) similarity2) >= 0.4d) {
                ILog.a(this.f8551a, "wakeup check success");
                return true;
            }
        }
        ILog.g(this.f8551a, "wakeup check not match");
        return false;
    }

    public int getHandleCode() {
        return CmdCode.CODE_WAKEUP_AUDIO_STATE;
    }

    public void handle(StarryNetMessage starryNetMessage, Cmd cmd) {
        Intrinsics.checkNotNullParameter(starryNetMessage, "message");
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        Object payload = cmd.getPayload();
        Intrinsics.checkNotNull(payload, "null cannot be cast to non-null type kotlin.Double");
        int doubleValue = (int) ((Double) payload).doubleValue();
        if (doubleValue == 0) {
            ILog.a(this.f8551a, "wakeup audio start");
            WakeupAudioCmdHandlerKt.f8550a = new byte[0];
            AudioDataUtil.g(true);
        } else if (doubleValue != 1) {
            String str = this.f8551a;
            Object payload2 = cmd.getPayload();
            ILog.a(str, "unsupported type: " + payload2);
        } else {
            ILog.a(this.f8551a, "wakeup audio end");
            byte[] a2 = WakeupAudioCmdHandlerKt.f8550a;
            byte[] copyOf = Arrays.copyOf(a2, a2.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            AudioDataUtil.c(copyOf);
            if (d()) {
                VrStateSynchronizer.b(11);
            } else {
                VrStateSynchronizer.b(12);
            }
            WakeupAudioCmdHandlerKt.f8550a = new byte[0];
            AudioDataUtil.h();
        }
    }
}
