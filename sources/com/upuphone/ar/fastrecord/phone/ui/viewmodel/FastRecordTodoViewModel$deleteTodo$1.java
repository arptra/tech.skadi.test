package com.upuphone.ar.fastrecord.phone.ui.viewmodel;

import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.fastrecord.phone.db.RecordTodoItemEntity;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
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
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel$deleteTodo$1", f = "FastRecordTodoViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FastRecordTodoViewModel$deleteTodo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ RecordTodoItemEntity $todo;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordTodoViewModel$deleteTodo$1(RecordTodoItemEntity recordTodoItemEntity, Continuation<? super FastRecordTodoViewModel$deleteTodo$1> continuation) {
        super(2, continuation);
        this.$todo = recordTodoItemEntity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordTodoViewModel$deleteTodo$1(this.$todo, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            RecordTodoItemEntity recordTodoItemEntity = this.$todo;
            LogExt.logE("updateFinishDelStateByTodoId todo = " + recordTodoItemEntity, "TodoViewModel");
            FastRecordManager.Companion.getInstance().fastRecordTodoItemDao().updateFinishDelStateByTodoId(this.$todo.getTodoItemId(), true);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordTodoViewModel$deleteTodo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
