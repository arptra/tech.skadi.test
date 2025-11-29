package com.xjsd.ai.assistant.flutter.nlp;

import com.xjsd.ai.assistant.core.api.tts.TtsData;
import com.xjsd.ai.assistant.flutter.nlp.NlpPreprocessor;
import com.xjsd.ai.assistant.nlu.bean.NluResponse;
import com.xjsd.ai.assistant.template.TtsTemplate;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH@¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/xjsd/ai/assistant/flutter/nlp/PendingNlpProcessor;", "Lcom/xjsd/ai/assistant/flutter/nlp/NlpPreprocessor;", "<init>", "()V", "Lcom/xjsd/ai/assistant/core/api/tts/TtsData;", "ttsData", "", "onReceiveTtsData", "(Lcom/xjsd/ai/assistant/core/api/tts/TtsData;)V", "Lcom/xjsd/ai/assistant/nlu/bean/NluResponse;", "nluResponse", "k", "(Lcom/xjsd/ai/assistant/nlu/bean/NluResponse;)V", "", "b", "()Ljava/lang/String;", "i", "(Lcom/xjsd/ai/assistant/nlu/bean/NluResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/Channel;", "a", "Lkotlinx/coroutines/channels/Channel;", "notifyChannel", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class PendingNlpProcessor implements NlpPreprocessor {

    /* renamed from: a  reason: collision with root package name */
    public Channel f8489a = ChannelKt.b(0, (BufferOverflow) null, (Function1) null, 7, (Object) null);

    public PendingNlpProcessor() {
        EventBus.c().o(this);
    }

    public void a(NluResponse nluResponse) {
        NlpPreprocessor.DefaultImpls.i(this, nluResponse);
    }

    public String b() {
        return "";
    }

    public Object c(NluResponse nluResponse, Continuation continuation) {
        return NlpPreprocessor.DefaultImpls.e(this, nluResponse, continuation);
    }

    public void clean() {
        NlpPreprocessor.DefaultImpls.a(this);
    }

    public void d(NluResponse nluResponse, int i) {
        NlpPreprocessor.DefaultImpls.j(this, nluResponse, i);
    }

    public void e(NluResponse nluResponse, TtsTemplate ttsTemplate) {
        NlpPreprocessor.DefaultImpls.k(this, nluResponse, ttsTemplate);
    }

    public void f(String str, String str2) {
        NlpPreprocessor.DefaultImpls.d(this, str, str2);
    }

    public boolean g(NluResponse nluResponse) {
        return NlpPreprocessor.DefaultImpls.c(this, nluResponse);
    }

    public void h(NluResponse nluResponse, String str) {
        NlpPreprocessor.DefaultImpls.l(this, nluResponse, str);
    }

    public Object i(NluResponse nluResponse, Continuation continuation) {
        return nluResponse;
    }

    public final void k(NluResponse nluResponse) {
        Intrinsics.checkNotNullParameter(nluResponse, "nluResponse");
        Object unused = BuildersKt__BuildersKt.b((CoroutineContext) null, new PendingNlpProcessor$await$1(this, nluResponse, (Continuation<? super PendingNlpProcessor$await$1>) null), 1, (Object) null);
    }

    @Subscribe
    public final void onReceiveTtsData(@NotNull TtsData ttsData) {
        Intrinsics.checkNotNullParameter(ttsData, "ttsData");
        if (!this.f8489a.A()) {
            this.f8489a.q(ttsData);
        }
    }
}
