package com.upuphone.ar.transcribe.phone.vm;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.transcribe.phone.vm.AiTodoViewModel", f = "AiTodoViewModel.kt", i = {0, 0, 0, 0, 0, 0}, l = {207, 236}, m = "compareTodoForCalendar", n = {"this", "tempTodoList", "todo", "tempTodo", "index$iv", "index"}, s = {"L$0", "L$1", "L$3", "L$4", "I$0", "I$1"})
public final class AiTodoViewModel$compareTodoForCalendar$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AiTodoViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AiTodoViewModel$compareTodoForCalendar$1(AiTodoViewModel aiTodoViewModel, Continuation<? super AiTodoViewModel$compareTodoForCalendar$1> continuation) {
        super(continuation);
        this.this$0 = aiTodoViewModel;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.q((List) null, this);
    }
}
