package com.xjsd.ai.assistant.phone.session.interceptor;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.ai.assistant.phone.session.interceptor.AudioDataInterceptor$onCreate$1", f = "AudioDataInterceptor.kt", i = {}, l = {27}, m = "invokeSuspend", n = {}, s = {})
public final class AudioDataInterceptor$onCreate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<byte[]> $flow;
    int label;
    final /* synthetic */ AudioDataInterceptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AudioDataInterceptor$onCreate$1(Flow<byte[]> flow, AudioDataInterceptor audioDataInterceptor, Continuation<? super AudioDataInterceptor$onCreate$1> continuation) {
        super(2, continuation);
        this.$flow = flow;
        this.this$0 = audioDataInterceptor;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AudioDataInterceptor$onCreate$1(this.$flow, this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow<byte[]> flow = this.$flow;
            final AudioDataInterceptor audioDataInterceptor = this.this$0;
            AnonymousClass1 r1 = new FlowCollector() {
                /* renamed from: d */
                public final Object emit(byte[] bArr, Continuation continuation) {
                    Object emit = audioDataInterceptor.e.emit(bArr, continuation);
                    return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
                }
            };
            this.label = 1;
            if (flow.collect(r1, this) == coroutine_suspended) {
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
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AudioDataInterceptor$onCreate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
