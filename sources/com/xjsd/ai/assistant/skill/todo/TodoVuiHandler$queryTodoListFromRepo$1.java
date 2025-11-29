package com.xjsd.ai.assistant.skill.todo;

import java.util.Date;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.ai.assistant.skill.todo.TodoVuiHandler", f = "TodoVuiHandler.kt", i = {}, l = {409, 411, 413}, m = "queryTodoListFromRepo", n = {}, s = {})
public final class TodoVuiHandler$queryTodoListFromRepo$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TodoVuiHandler this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TodoVuiHandler$queryTodoListFromRepo$1(TodoVuiHandler todoVuiHandler, Continuation<? super TodoVuiHandler$queryTodoListFromRepo$1> continuation) {
        super(continuation);
        this.this$0 = todoVuiHandler;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.n((Date) null, (Date) null, this);
    }
}
