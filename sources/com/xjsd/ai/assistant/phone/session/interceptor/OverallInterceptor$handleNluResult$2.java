package com.xjsd.ai.assistant.phone.session.interceptor;

import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.nlu.bean.NluResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.ai.assistant.phone.session.interceptor.OverallInterceptor$handleNluResult$2", f = "OverallInterceptor.kt", i = {}, l = {785}, m = "invokeSuspend", n = {}, s = {})
public final class OverallInterceptor$handleNluResult$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ NluResponse $nluResponse;
    int label;
    final /* synthetic */ OverallInterceptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OverallInterceptor$handleNluResult$2(OverallInterceptor overallInterceptor, NluResponse nluResponse, Continuation<? super OverallInterceptor$handleNluResult$2> continuation) {
        super(2, continuation);
        this.this$0 = overallInterceptor;
        this.$nluResponse = nluResponse;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new OverallInterceptor$handleNluResult$2(this.this$0, this.$nluResponse, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            OverallInterceptor overallInterceptor = this.this$0;
            NluResponse nluResponse = this.$nluResponse;
            this.label = 1;
            if (overallInterceptor.W(nluResponse, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception e) {
                ILog.h("OverallInterceptor", "handleNluResult: error", e);
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((OverallInterceptor$handleNluResult$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
