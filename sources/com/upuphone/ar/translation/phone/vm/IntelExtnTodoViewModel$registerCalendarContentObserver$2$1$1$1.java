package com.upuphone.ar.translation.phone.vm;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.phone.vm.IntelExtnTodoViewModel$registerCalendarContentObserver$2$1$1$1", f = "IntelExtnTodoViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class IntelExtnTodoViewModel$registerCalendarContentObserver$2$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ IntelExtnTodoViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IntelExtnTodoViewModel$registerCalendarContentObserver$2$1$1$1(IntelExtnTodoViewModel intelExtnTodoViewModel, Continuation<? super IntelExtnTodoViewModel$registerCalendarContentObserver$2$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = intelExtnTodoViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new IntelExtnTodoViewModel$registerCalendarContentObserver$2$1$1$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.h.setValue(Boxing.boxBoolean(true));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((IntelExtnTodoViewModel$registerCalendarContentObserver$2$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
