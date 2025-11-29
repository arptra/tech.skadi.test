package com.upuphone.ar.transcribe.phone.activity;

import androidx.fragment.app.FragmentActivity;
import com.upuphone.ar.transcribe.phone.db.entity.AiTodoEntity;
import com.upuphone.ar.transcribe.phone.vm.AiTodoViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.transcribe.phone.activity.AiToDoFragment$initViews$5$1", f = "AiToDoFragment.kt", i = {}, l = {157}, m = "invokeSuspend", n = {}, s = {})
public final class AiToDoFragment$initViews$5$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AiTodoEntity $todo;
    int label;
    final /* synthetic */ AiToDoFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AiToDoFragment$initViews$5$1(AiToDoFragment aiToDoFragment, AiTodoEntity aiTodoEntity, Continuation<? super AiToDoFragment$initViews$5$1> continuation) {
        super(2, continuation);
        this.this$0 = aiToDoFragment;
        this.$todo = aiTodoEntity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AiToDoFragment$initViews$5$1(this.this$0, this.$todo, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AiTodoViewModel access$getTodoViewModel = this.this$0.getTodoViewModel();
            FragmentActivity requireActivity = this.this$0.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
            AiTodoEntity aiTodoEntity = this.$todo;
            this.label = 1;
            if (access$getTodoViewModel.p(requireActivity, aiTodoEntity, this) == coroutine_suspended) {
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
        return ((AiToDoFragment$initViews$5$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
