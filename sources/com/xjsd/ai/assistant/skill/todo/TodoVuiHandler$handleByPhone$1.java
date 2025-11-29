package com.xjsd.ai.assistant.skill.todo;

import com.xjsd.ai.assistant.protocol.VuiModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.ai.assistant.skill.todo.TodoVuiHandler", f = "TodoVuiHandler.kt", i = {2, 5, 5}, l = {200, 206, 218, 224, 233, 245}, m = "handleByPhone", n = {"this", "this", "timeText"}, s = {"L$0", "L$0", "L$1"})
public final class TodoVuiHandler$handleByPhone$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TodoVuiHandler this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TodoVuiHandler$handleByPhone$1(TodoVuiHandler todoVuiHandler, Continuation<? super TodoVuiHandler$handleByPhone$1> continuation) {
        super(continuation);
        this.this$0 = todoVuiHandler;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.k((VuiModel) null, this);
    }
}
