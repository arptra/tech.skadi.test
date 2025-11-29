package com.xjsd.ai.assistant.phone.session.interceptor;

import com.xjsd.ai.assistant.core.api.cache.CacheAbility;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.session.interceptor.VadInterceptor;
import com.xjsd.ai.assistant.phone.vad.OfflineAsrResult;
import com.xjsd.ai.assistant.phone.vad.VadAbility;
import com.xjsd.ai.assistant.phone.vad.VadEventListener;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import com.xjsd.ai.assistant.protocol.Scene;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/xjsd/ai/assistant/phone/session/interceptor/VadInterceptor$VadResult;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.ai.assistant.phone.session.interceptor.VadInterceptor$initChannel$flow$1", f = "VadInterceptor.kt", i = {}, l = {113}, m = "invokeSuspend", n = {}, s = {})
public final class VadInterceptor$initChannel$flow$1 extends SuspendLambda implements Function2<ProducerScope<? super VadInterceptor.VadResult>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ VadInterceptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VadInterceptor$initChannel$flow$1(VadInterceptor vadInterceptor, Continuation<? super VadInterceptor$initChannel$flow$1> continuation) {
        super(2, continuation);
        this.this$0 = vadInterceptor;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        VadInterceptor$initChannel$flow$1 vadInterceptor$initChannel$flow$1 = new VadInterceptor$initChannel$flow$1(this.this$0, continuation);
        vadInterceptor$initChannel$flow$1.L$0 = obj;
        return vadInterceptor$initChannel$flow$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final ProducerScope producerScope = (ProducerScope) this.L$0;
            VadAbility l = this.this$0.e;
            final VadInterceptor vadInterceptor = this.this$0;
            l.setVadEventListener(new VadEventListener() {
                public void a() {
                    ILog.a("VadInterceptor", "onVadEnd");
                    String str = (String) vadInterceptor.f.getCacheWithDefault(AssistantConstants.Key.SCENE_ID, Scene.NORMAL);
                    CacheAbility k = vadInterceptor.f;
                    Boolean bool = Boolean.FALSE;
                    Boolean bool2 = (Boolean) k.getCacheWithDefault("isNetworkAvailable", bool);
                    if (Intrinsics.areEqual((Object) Scene.GPT, (Object) str) || (Intrinsics.areEqual((Object) Scene.CALL, (Object) str) && Intrinsics.areEqual((Object) bool2, (Object) bool))) {
                        ILog.a("VadInterceptor", "GPT场景 或者 电话且离线场景，需要持续收音");
                        producerScope.q(new VadInterceptor.VadResult.State(3));
                        return;
                    }
                    producerScope.q(new VadInterceptor.VadResult.State(2));
                }

                public void b(byte[] bArr) {
                    Intrinsics.checkNotNullParameter(bArr, "data");
                    producerScope.q(new VadInterceptor.VadResult.Detect(bArr));
                }

                public void c() {
                    ILog.a("VadInterceptor", "onVadStart");
                    producerScope.q(new VadInterceptor.VadResult.State(1));
                }

                public void d(String str) {
                    Intrinsics.checkNotNullParameter(str, "text");
                    producerScope.q(new VadInterceptor.VadResult.OfflineCmd(str));
                }

                public void e(OfflineAsrResult offlineAsrResult) {
                    Intrinsics.checkNotNullParameter(offlineAsrResult, "result");
                    producerScope.q(new VadInterceptor.VadResult.OfflineAsr(offlineAsrResult));
                }

                public void f() {
                    ILog.a("VadInterceptor", "onVadMute");
                    producerScope.q(new VadInterceptor.VadResult.State(0));
                }
            });
            final VadInterceptor vadInterceptor2 = this.this$0;
            AnonymousClass2 r1 = new Function0<Unit>() {
                public final void invoke() {
                    vadInterceptor2.e.setVadEventListener((VadEventListener) null);
                }
            };
            this.label = 1;
            if (ProduceKt.a(producerScope, r1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull ProducerScope<? super VadInterceptor.VadResult> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((VadInterceptor$initChannel$flow$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
