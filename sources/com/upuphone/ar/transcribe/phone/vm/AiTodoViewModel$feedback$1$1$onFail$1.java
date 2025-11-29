package com.upuphone.ar.transcribe.phone.vm;

import com.upuphone.ar.transcribe.phone.vm.TodoData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.transcribe.phone.vm.AiTodoViewModel$feedback$1$1$onFail$1", f = "AiTodoViewModel.kt", i = {}, l = {120}, m = "invokeSuspend", n = {}, s = {})
public final class AiTodoViewModel$feedback$1$1$onFail$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AiTodoViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AiTodoViewModel$feedback$1$1$onFail$1(AiTodoViewModel aiTodoViewModel, Continuation<? super AiTodoViewModel$feedback$1$1$onFail$1> continuation) {
        super(2, continuation);
        this.this$0 = aiTodoViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AiTodoViewModel$feedback$1$1$onFail$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MutableSharedFlow l = this.this$0.e;
            TodoData.ReportStatus reportStatus = new TodoData.ReportStatus(false);
            this.label = 1;
            if (l.emit(reportStatus, this) == coroutine_suspended) {
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
        return ((AiTodoViewModel$feedback$1$1$onFail$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
