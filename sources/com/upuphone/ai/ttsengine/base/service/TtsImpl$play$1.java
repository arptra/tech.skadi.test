package com.upuphone.ai.ttsengine.base.service;

import android.media.AudioAttributes;
import android.os.Bundle;
import com.upuphone.ai.ttsengine.base.ITtsAgent;
import com.upuphone.ai.ttsengine.base.ITtsStatusListener;
import com.upuphone.ai.ttsengine.base.utils.AILOG;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nTtsImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TtsImpl.kt\ncom/upuphone/ai/ttsengine/base/service/TtsImpl$play$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,325:1\n1855#2,2:326\n*S KotlinDebug\n*F\n+ 1 TtsImpl.kt\ncom/upuphone/ai/ttsengine/base/service/TtsImpl$play$1\n*L\n243#1:326,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ai.ttsengine.base.service.TtsImpl$play$1", f = "TtsImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TtsImpl$play$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AudioAttributes $audioAttributes;
    final /* synthetic */ Bundle $params;
    final /* synthetic */ int $queueMode;
    final /* synthetic */ List<String> $texts;
    final /* synthetic */ List<ITtsAgent> $ttsAgent;
    int label;
    final /* synthetic */ TtsImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TtsImpl$play$1(List<? extends ITtsAgent> list, TtsImpl ttsImpl, AudioAttributes audioAttributes, Bundle bundle, int i, List<String> list2, Continuation<? super TtsImpl$play$1> continuation) {
        super(2, continuation);
        this.$ttsAgent = list;
        this.this$0 = ttsImpl;
        this.$audioAttributes = audioAttributes;
        this.$params = bundle;
        this.$queueMode = i;
        this.$texts = list2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TtsImpl$play$1(this.$ttsAgent, this.this$0, this.$audioAttributes, this.$params, this.$queueMode, this.$texts, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            List<ITtsAgent> list = this.$ttsAgent;
            TtsImpl ttsImpl = this.this$0;
            AudioAttributes audioAttributes = this.$audioAttributes;
            Bundle bundle = this.$params;
            int i = this.$queueMode;
            List<String> list2 = this.$texts;
            for (ITtsAgent iTtsAgent : list) {
                AILOG a2 = ttsImpl.f5513a;
                boolean f = ttsImpl.h;
                a2.c("isStopped: " + f, new Object[0]);
                if (ttsImpl.h) {
                    ITtsStatusListener b = ttsImpl.c;
                    if (b != null) {
                        b.h(3);
                    }
                    return Unit.INSTANCE;
                }
                if (audioAttributes != null) {
                    iTtsAgent.setAudioAttributes(audioAttributes.getUsage(), audioAttributes.getContentType());
                } else {
                    iTtsAgent.setAudioAttributes(0, 0);
                }
                Intrinsics.checkNotNull(iTtsAgent);
                ttsImpl.q(iTtsAgent, bundle);
                ttsImpl.i = iTtsAgent.startSpeak(i == 3 ? list2 : new ArrayList<>(list2), i);
                if (ttsImpl.l()) {
                    if (i != 3) {
                        list2.clear();
                    }
                    return Unit.INSTANCE;
                }
            }
            ITtsStatusListener b2 = this.this$0.c;
            if (b2 != null) {
                b2.h(17);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TtsImpl$play$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
