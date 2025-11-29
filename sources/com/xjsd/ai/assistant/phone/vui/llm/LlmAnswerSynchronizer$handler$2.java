package com.xjsd.ai.assistant.phone.vui.llm;

import android.os.Handler;
import android.os.Message;
import com.upuphone.starrynet.payload.PayloadConstant;
import com.xjsd.ai.assistant.chatgpt.model.LlmResponse;
import com.xjsd.ai.assistant.common.Communicator;
import com.xjsd.ai.assistant.json.GsonUtils;
import com.xjsd.ai.assistant.log.ILog;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "com/xjsd/ai/assistant/phone/vui/llm/LlmAnswerSynchronizer$handler$2$1", "invoke", "()Lcom/xjsd/ai/assistant/phone/vui/llm/LlmAnswerSynchronizer$handler$2$1;"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class LlmAnswerSynchronizer$handler$2 extends Lambda implements Function0<AnonymousClass1> {
    public static final LlmAnswerSynchronizer$handler$2 INSTANCE = new LlmAnswerSynchronizer$handler$2();

    public LlmAnswerSynchronizer$handler$2() {
        super(0);
    }

    @NotNull
    public final AnonymousClass1 invoke() {
        LlmAnswerSynchronizer.d.start();
        return new Handler(LlmAnswerSynchronizer.d.getLooper()) {
            public void handleMessage(Message message) {
                Intrinsics.checkNotNullParameter(message, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
                int i = message.what;
                if (i == 100) {
                    Object unused = BuildersKt__BuildersKt.b((CoroutineContext) null, new LlmAnswerSynchronizer$handler$2$1$handleMessage$1(message, (Continuation<? super LlmAnswerSynchronizer$handler$2$1$handleMessage$1>) null), 1, (Object) null);
                } else if (i == 101) {
                    Object obj = message.obj;
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.xjsd.ai.assistant.chatgpt.model.LlmResponse");
                    LlmResponse llmResponse = (LlmResponse) obj;
                    if (!Intrinsics.areEqual((Object) llmResponse.getSessionId(), (Object) LlmAnswerSynchronizer.b) || !LlmAnswerSynchronizer.c) {
                        String e = GsonUtils.e(llmResponse);
                        ILog.a("LlmAnswerSynchronizer", "大模型回复被拦截->" + e);
                        return;
                    }
                    Communicator.b(122, llmResponse, new LlmAnswerSynchronizer$handler$2$1$handleMessage$2());
                }
            }
        };
    }
}
