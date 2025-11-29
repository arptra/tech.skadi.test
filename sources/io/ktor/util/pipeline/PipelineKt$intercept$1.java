package io.ktor.util.pipeline;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nPipeline.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Pipeline.kt\nio/ktor/util/pipeline/PipelineKt$intercept$1\n*L\n1#1,503:1\n*E\n"})
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u0010\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001a\u00020\u0003H@"}, d2 = {"<anonymous>", "", "TSubject", "", "TContext", "Lio/ktor/util/pipeline/PipelineContext;", "subject"}, k = 3, mv = {1, 8, 0}, xi = 176)
@DebugMetadata(c = "io.ktor.util.pipeline.PipelineKt$intercept$1", f = "Pipeline.kt", i = {}, l = {494}, m = "invokeSuspend", n = {}, s = {})
public final class PipelineKt$intercept$1 extends SuspendLambda implements Function3<PipelineContext<? extends Object, Object>, Object, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<PipelineContext<Object, Object>, Object, Continuation<? super Unit>, Object> $block;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PipelineKt$intercept$1(Function3<? super PipelineContext<Object, Object>, Object, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super PipelineKt$intercept$1> continuation) {
        super(3, continuation);
        this.$block = function3;
    }

    @Nullable
    public final Object invoke(@NotNull PipelineContext<? extends Object, Object> pipelineContext, @NotNull Object obj, @Nullable Continuation<? super Unit> continuation) {
        PipelineKt$intercept$1 pipelineKt$intercept$1 = new PipelineKt$intercept$1(this.$block, continuation);
        pipelineKt$intercept$1.L$0 = pipelineContext;
        pipelineKt$intercept$1.L$1 = obj;
        return pipelineKt$intercept$1.invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PipelineContext pipelineContext = (PipelineContext) this.L$0;
            Object obj2 = this.L$1;
            Intrinsics.reifiedOperationMarker(3, "TSubject");
            if (!(obj2 instanceof Object)) {
                return Unit.INSTANCE;
            }
            if (!(pipelineContext instanceof PipelineContext)) {
                pipelineContext = null;
            }
            if (pipelineContext != null) {
                Function3<PipelineContext<Object, Object>, Object, Continuation<? super Unit>, Object> function3 = this.$block;
                this.L$0 = null;
                this.label = 1;
                if (function3.invoke(pipelineContext, obj2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
