package com.xjsd.ai.assistant.phone.session.interceptor;

import com.xjsd.ai.assistant.phone.cmd.AudioDataTransCmdHandler;
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

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.ai.assistant.phone.session.interceptor.AudioDataInterceptor$onCreate$flow$1", f = "AudioDataInterceptor.kt", i = {}, l = {22}, m = "invokeSuspend", n = {}, s = {})
public final class AudioDataInterceptor$onCreate$flow$1 extends SuspendLambda implements Function2<ProducerScope<? super byte[]>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AudioDataInterceptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AudioDataInterceptor$onCreate$flow$1(AudioDataInterceptor audioDataInterceptor, Continuation<? super AudioDataInterceptor$onCreate$flow$1> continuation) {
        super(2, continuation);
        this.this$0 = audioDataInterceptor;
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0(ProducerScope producerScope, byte[] bArr) {
        Intrinsics.checkNotNull(bArr);
        producerScope.q(bArr);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        AudioDataInterceptor$onCreate$flow$1 audioDataInterceptor$onCreate$flow$1 = new AudioDataInterceptor$onCreate$flow$1(this.this$0, continuation);
        audioDataInterceptor$onCreate$flow$1.L$0 = obj;
        return audioDataInterceptor$onCreate$flow$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ProducerScope producerScope = (ProducerScope) this.L$0;
            this.this$0.d.b(new a(producerScope));
            final AudioDataInterceptor audioDataInterceptor = this.this$0;
            AnonymousClass2 r1 = new Function0<Unit>() {
                public final void invoke() {
                    audioDataInterceptor.d.b((AudioDataTransCmdHandler.OnDataListener) null);
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
    public final Object invoke(@NotNull ProducerScope<? super byte[]> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AudioDataInterceptor$onCreate$flow$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
