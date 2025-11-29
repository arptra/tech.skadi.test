package com.upuphone.xr.sapp.adapter;

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

@SourceDebugExtension({"SMAP\nTodoListAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TodoListAdapter.kt\ncom/upuphone/xr/sapp/adapter/TodoListAdapter$onKeyboardHide$2\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,425:1\n37#2,2:426\n37#2,2:428\n*S KotlinDebug\n*F\n+ 1 TodoListAdapter.kt\ncom/upuphone/xr/sapp/adapter/TodoListAdapter$onKeyboardHide$2\n*L\n156#1:426,2\n159#1:428,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.adapter.TodoListAdapter$onKeyboardHide$2", f = "TodoListAdapter.kt", i = {}, l = {156, 159}, m = "invokeSuspend", n = {}, s = {})
public final class TodoListAdapter$onKeyboardHide$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<TodoEntry> $delete;
    final /* synthetic */ List<TodoEntry> $update;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TodoListAdapter$onKeyboardHide$2(List<TodoEntry> list, List<TodoEntry> list2, Continuation<? super TodoListAdapter$onKeyboardHide$2> continuation) {
        super(2, continuation);
        this.$update = list;
        this.$delete = list2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TodoListAdapter$onKeyboardHide$2(this.$update, this.$delete, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!this.$update.isEmpty()) {
                TodoRepository todoRepository = TodoRepository.f8656a;
                TodoEntry[] todoEntryArr = (TodoEntry[]) this.$update.toArray(new TodoEntry[0]);
                this.label = 1;
                if (todoRepository.o((TodoEntry[]) Arrays.copyOf(todoEntryArr, todoEntryArr.length), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (!this.$delete.isEmpty()) {
            TodoRepository todoRepository2 = TodoRepository.f8656a;
            TodoEntry[] todoEntryArr2 = (TodoEntry[]) this.$delete.toArray(new TodoEntry[0]);
            this.label = 2;
            if (todoRepository2.f((TodoEntry[]) Arrays.copyOf(todoEntryArr2, todoEntryArr2.length), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TodoListAdapter$onKeyboardHide$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
