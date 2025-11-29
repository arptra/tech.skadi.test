package com.upuphone.ar.translation.phone.vm;

import com.upuphone.ar.translation.phone.bean.IntelExtnTodo;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.phone.vm.IntelExtnShareViewModel$notifyShareTodos$1", f = "IntelExtnShareViewModel.kt", i = {}, l = {112}, m = "invokeSuspend", n = {}, s = {})
public final class IntelExtnShareViewModel$notifyShareTodos$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<IntelExtnTodo> $todoList;
    int label;
    final /* synthetic */ IntelExtnShareViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IntelExtnShareViewModel$notifyShareTodos$1(IntelExtnShareViewModel intelExtnShareViewModel, List<IntelExtnTodo> list, Continuation<? super IntelExtnShareViewModel$notifyShareTodos$1> continuation) {
        super(2, continuation);
        this.this$0 = intelExtnShareViewModel;
        this.$todoList = list;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new IntelExtnShareViewModel$notifyShareTodos$1(this.this$0, this.$todoList, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineDispatcher b = Dispatchers.b();
            IntelExtnShareViewModel$notifyShareTodos$1$todoText$1 intelExtnShareViewModel$notifyShareTodos$1$todoText$1 = new IntelExtnShareViewModel$notifyShareTodos$1$todoText$1(this.$todoList, (Continuation<? super IntelExtnShareViewModel$notifyShareTodos$1$todoText$1>) null);
            this.label = 1;
            obj = BuildersKt.g(b, intelExtnShareViewModel$notifyShareTodos$1$todoText$1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Intrinsics.checkNotNullExpressionValue(obj, "withContext(...)");
        this.this$0.e.setValue((String) obj);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((IntelExtnShareViewModel$notifyShareTodos$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
