package io.ktor.util.pipeline;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nPipeline.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Pipeline.kt\nio/ktor/util/pipeline/PipelineKt$execute$2\n*L\n1#1,503:1\n*E\n"})
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "TContext", ""}, k = 3, mv = {1, 8, 0}, xi = 176)
@DebugMetadata(c = "io.ktor.util.pipeline.PipelineKt$execute$2", f = "Pipeline.kt", i = {}, l = {478}, m = "invokeSuspend", n = {}, s = {})
public final class PipelineKt$execute$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Object $context;
    final /* synthetic */ Pipeline<Unit, Object> $this_execute;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PipelineKt$execute$2(Pipeline<Unit, Object> pipeline, Object obj, Continuation<? super PipelineKt$execute$2> continuation) {
        super(1, continuation);
        this.$this_execute = pipeline;
        this.$context = obj;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new PipelineKt$execute$2(this.$this_execute, this.$context, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Pipeline<Unit, Object> pipeline = this.$this_execute;
            Object obj2 = this.$context;
            Unit unit = Unit.INSTANCE;
            this.label = 1;
            if (pipeline.d(obj2, unit, this) == coroutine_suspended) {
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
    public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
        return ((PipelineKt$execute$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
