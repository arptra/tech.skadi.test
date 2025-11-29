package com.xjsd.ai.assistant.phone.vui.llm;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.xjsd.ai.assistant.chatgpt.model.LlmResponse;
import com.xjsd.ai.assistant.protocol.VuiModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001e\u001a\u00020\u00198BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/xjsd/ai/assistant/phone/vui/llm/LlmAnswerSynchronizer;", "", "<init>", "()V", "Lcom/xjsd/ai/assistant/protocol/VuiModel;", "vuiModel", "", "h", "(Lcom/xjsd/ai/assistant/protocol/VuiModel;)V", "Lcom/xjsd/ai/assistant/chatgpt/model/LlmResponse;", "llmResponse", "f", "(Lcom/xjsd/ai/assistant/chatgpt/model/LlmResponse;)V", "", "b", "Ljava/lang/String;", "syncSessionId", "", "c", "Z", "protocolAuthed", "Landroid/os/HandlerThread;", "d", "Landroid/os/HandlerThread;", "dispatcher", "Landroid/os/Handler;", "e", "Lkotlin/Lazy;", "g", "()Landroid/os/Handler;", "handler", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class LlmAnswerSynchronizer {

    /* renamed from: a  reason: collision with root package name */
    public static final LlmAnswerSynchronizer f8634a = new LlmAnswerSynchronizer();
    public static String b = "";
    public static boolean c;
    public static final HandlerThread d = new HandlerThread("llm-answer-sync");
    public static final Lazy e = LazyKt.lazy(LlmAnswerSynchronizer$handler$2.INSTANCE);

    public final void f(LlmResponse llmResponse) {
        Intrinsics.checkNotNullParameter(llmResponse, "llmResponse");
        Message obtainMessage = g().obtainMessage();
        Intrinsics.checkNotNullExpressionValue(obtainMessage, "obtainMessage(...)");
        obtainMessage.what = 101;
        obtainMessage.obj = llmResponse;
        g().sendMessage(obtainMessage);
    }

    public final Handler g() {
        return (Handler) e.getValue();
    }

    public final void h(VuiModel vuiModel) {
        Intrinsics.checkNotNullParameter(vuiModel, "vuiModel");
        Message obtainMessage = g().obtainMessage();
        Intrinsics.checkNotNullExpressionValue(obtainMessage, "obtainMessage(...)");
        obtainMessage.what = 100;
        obtainMessage.obj = vuiModel;
        g().sendMessage(obtainMessage);
    }
}
