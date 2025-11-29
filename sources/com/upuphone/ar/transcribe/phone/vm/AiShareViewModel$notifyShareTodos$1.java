package com.upuphone.ar.transcribe.phone.vm;

import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.ar.transcribe.phone.db.entity.AiTodoEntity;
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
@DebugMetadata(c = "com.upuphone.ar.transcribe.phone.vm.AiShareViewModel$notifyShareTodos$1", f = "AiShareViewModel.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {})
public final class AiShareViewModel$notifyShareTodos$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<AiTodoEntity> $todoList;
    int label;
    final /* synthetic */ AiShareViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AiShareViewModel$notifyShareTodos$1(List<AiTodoEntity> list, AiShareViewModel aiShareViewModel, Continuation<? super AiShareViewModel$notifyShareTodos$1> continuation) {
        super(2, continuation);
        this.$todoList = list;
        this.this$0 = aiShareViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AiShareViewModel$notifyShareTodos$1(this.$todoList, this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            int size = this.$todoList.size();
            LogExt.d("load todo size: " + size, "AiShareViewModel");
            CoroutineDispatcher b = Dispatchers.b();
            AiShareViewModel$notifyShareTodos$1$todoText$1 aiShareViewModel$notifyShareTodos$1$todoText$1 = new AiShareViewModel$notifyShareTodos$1$todoText$1(this.$todoList, (Continuation<? super AiShareViewModel$notifyShareTodos$1$todoText$1>) null);
            this.label = 1;
            obj = BuildersKt.g(b, aiShareViewModel$notifyShareTodos$1$todoText$1, this);
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
        return ((AiShareViewModel$notifyShareTodos$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
