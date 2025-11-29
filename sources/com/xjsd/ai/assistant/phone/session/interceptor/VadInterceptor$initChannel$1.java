package com.xjsd.ai.assistant.phone.session.interceptor;

import com.xjsd.ai.assistant.phone.session.interceptor.VadInterceptor;
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
@DebugMetadata(c = "com.xjsd.ai.assistant.phone.session.interceptor.VadInterceptor$initChannel$1", f = "VadInterceptor.kt", i = {}, l = {118}, m = "invokeSuspend", n = {}, s = {})
public final class VadInterceptor$initChannel$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<VadInterceptor.VadResult> $flow;
    int label;
    final /* synthetic */ VadInterceptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VadInterceptor$initChannel$1(Flow<? extends VadInterceptor.VadResult> flow, VadInterceptor vadInterceptor, Continuation<? super VadInterceptor$initChannel$1> continuation) {
        super(2, continuation);
        this.$flow = flow;
        this.this$0 = vadInterceptor;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VadInterceptor$initChannel$1(this.$flow, this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow<VadInterceptor.VadResult> flow = this.$flow;
            final VadInterceptor vadInterceptor = this.this$0;
            AnonymousClass1 r1 = new FlowCollector() {
                /* renamed from: d */
                public final Object emit(VadInterceptor.VadResult vadResult, Continuation continuation) {
                    if (vadResult instanceof VadInterceptor.VadResult.State) {
                        Object p = vadInterceptor.v(((VadInterceptor.VadResult.State) vadResult).a(), continuation);
                        return p == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? p : Unit.INSTANCE;
                    } else if (vadResult instanceof VadInterceptor.VadResult.OfflineCmd) {
                        Object o = vadInterceptor.u(((VadInterceptor.VadResult.OfflineCmd) vadResult).a(), continuation);
                        return o == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? o : Unit.INSTANCE;
                    } else if (vadResult instanceof VadInterceptor.VadResult.OfflineAsr) {
                        Object n = vadInterceptor.t(((VadInterceptor.VadResult.OfflineAsr) vadResult).a(), continuation);
                        return n == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? n : Unit.INSTANCE;
                    } else if (!(vadResult instanceof VadInterceptor.VadResult.Detect)) {
                        return Unit.INSTANCE;
                    } else {
                        Object emit = vadInterceptor.j.emit(((VadInterceptor.VadResult.Detect) vadResult).a(), continuation);
                        return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
                    }
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
        return ((VadInterceptor$initChannel$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
