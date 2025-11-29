package com.upuphone.ar.transcribe.phone.vm;

import com.upuphone.ar.transcribe.phone.db.entity.AiTodoEntity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.transcribe.phone.vm.AiTodoViewModel", f = "AiTodoViewModel.kt", i = {0}, l = {321, 323}, m = "addEventToCalendar", n = {"this"}, s = {"L$0"})
public final class AiTodoViewModel$addEventToCalendar$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AiTodoViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AiTodoViewModel$addEventToCalendar$1(AiTodoViewModel aiTodoViewModel, Continuation<? super AiTodoViewModel$addEventToCalendar$1> continuation) {
        super(continuation);
        this.this$0 = aiTodoViewModel;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.n((AiTodoEntity) null, this);
    }
}
