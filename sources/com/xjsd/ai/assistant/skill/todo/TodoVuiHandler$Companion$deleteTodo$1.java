package com.xjsd.ai.assistant.skill.todo;

import com.xjsd.ai.assistant.phone.vui.todo.TodoEntry;
import com.xjsd.ai.assistant.skill.todo.TodoVuiHandler;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.ai.assistant.skill.todo.TodoVuiHandler$Companion", f = "TodoVuiHandler.kt", i = {}, l = {84}, m = "deleteTodo", n = {}, s = {})
public final class TodoVuiHandler$Companion$deleteTodo$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TodoVuiHandler.Companion this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TodoVuiHandler$Companion$deleteTodo$1(TodoVuiHandler.Companion companion, Continuation<? super TodoVuiHandler$Companion$deleteTodo$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c((TodoEntry) null, this);
    }
}
