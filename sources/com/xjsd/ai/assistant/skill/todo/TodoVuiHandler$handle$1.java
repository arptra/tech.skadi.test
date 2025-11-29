package com.xjsd.ai.assistant.skill.todo;

import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder;
import com.xjsd.ai.assistant.protocol.VuiModel;
import com.xjsd.ai.assistant.template.TtsGlobalTemplate;
import kotlin.Metadata;
import kotlin.Result;
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
@DebugMetadata(c = "com.xjsd.ai.assistant.skill.todo.TodoVuiHandler$handle$1", f = "TodoVuiHandler.kt", i = {}, l = {153}, m = "invokeSuspend", n = {}, s = {})
public final class TodoVuiHandler$handle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ VuiModel $model;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TodoVuiHandler this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TodoVuiHandler$handle$1(TodoVuiHandler todoVuiHandler, VuiModel vuiModel, Continuation<? super TodoVuiHandler$handle$1> continuation) {
        super(2, continuation);
        this.this$0 = todoVuiHandler;
        this.$model = vuiModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TodoVuiHandler$handle$1 todoVuiHandler$handle$1 = new TodoVuiHandler$handle$1(this.this$0, this.$model, continuation);
        todoVuiHandler$handle$1.L$0 = obj;
        return todoVuiHandler$handle$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            TodoVuiHandler todoVuiHandler = this.this$0;
            VuiModel vuiModel = this.$model;
            Result.Companion companion = Result.Companion;
            this.label = 1;
            if (todoVuiHandler.k(vuiModel, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.m20constructorimpl(ResultKt.createFailure(th));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        obj2 = Result.m20constructorimpl(Unit.INSTANCE);
        Throwable r4 = Result.m23exceptionOrNullimpl(obj2);
        if (r4 != null) {
            ILog.h("TodoVuiHandler", "handle: 处理待办异常", r4);
            new PhoneTtsPlayBuilder().e(TtsGlobalTemplate.GLOBAL01_P06).a().c();
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TodoVuiHandler$handle$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
