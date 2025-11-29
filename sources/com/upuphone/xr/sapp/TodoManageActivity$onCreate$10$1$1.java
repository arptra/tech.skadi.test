package com.upuphone.xr.sapp;

import com.xjsd.ai.assistant.phone.vui.todo.TodoEntry;
import com.xjsd.ai.assistant.phone.vui.todo.TodoRepository;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nTodoManageActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TodoManageActivity.kt\ncom/upuphone/xr/sapp/TodoManageActivity$onCreate$10$1$1\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,306:1\n37#2,2:307\n*S KotlinDebug\n*F\n+ 1 TodoManageActivity.kt\ncom/upuphone/xr/sapp/TodoManageActivity$onCreate$10$1$1\n*L\n214#1:307,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.TodoManageActivity$onCreate$10$1$1", f = "TodoManageActivity.kt", i = {}, l = {214}, m = "invokeSuspend", n = {}, s = {})
public final class TodoManageActivity$onCreate$10$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<TodoEntry> $selectItems;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TodoManageActivity$onCreate$10$1$1(List<TodoEntry> list, Continuation<? super TodoManageActivity$onCreate$10$1$1> continuation) {
        super(2, continuation);
        this.$selectItems = list;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TodoManageActivity$onCreate$10$1$1(this.$selectItems, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            TodoRepository todoRepository = TodoRepository.f8656a;
            TodoEntry[] todoEntryArr = (TodoEntry[]) this.$selectItems.toArray(new TodoEntry[0]);
            this.label = 1;
            if (todoRepository.f((TodoEntry[]) Arrays.copyOf(todoEntryArr, todoEntryArr.length), this) == coroutine_suspended) {
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
        return ((TodoManageActivity$onCreate$10$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
