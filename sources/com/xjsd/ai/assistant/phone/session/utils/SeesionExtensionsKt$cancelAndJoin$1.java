package com.xjsd.ai.assistant.phone.session.utils;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.ai.assistant.phone.session.utils.SeesionExtensionsKt$cancelAndJoin$1", f = "SeesionExtensions.kt", i = {}, l = {134}, m = "invokeSuspend", n = {}, s = {})
final class SeesionExtensionsKt$cancelAndJoin$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CoroutineScope $this_cancelAndJoin;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SeesionExtensionsKt$cancelAndJoin$1(CoroutineScope coroutineScope, Continuation<? super SeesionExtensionsKt$cancelAndJoin$1> continuation) {
        super(2, continuation);
        this.$this_cancelAndJoin = coroutineScope;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SeesionExtensionsKt$cancelAndJoin$1 seesionExtensionsKt$cancelAndJoin$1 = new SeesionExtensionsKt$cancelAndJoin$1(this.$this_cancelAndJoin, continuation);
        seesionExtensionsKt$cancelAndJoin$1.L$0 = obj;
        return seesionExtensionsKt$cancelAndJoin$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Job job = (Job) this.$this_cancelAndJoin.getCoroutineContext().get(Job.b0);
            if (job != null) {
                this.label = 1;
                if (JobKt.f(job, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + coroutineScope).toString());
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
        return ((SeesionExtensionsKt$cancelAndJoin$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
