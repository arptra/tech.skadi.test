package com.xjsd.ai.assistant.skill.todo;

import com.xjsd.ai.assistant.common.UnSupportFeatureManager;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.R;
import com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder;
import com.xjsd.ai.assistant.phone.vui.todo.TodoEntry;
import com.xjsd.ai.assistant.protocol.BusinessData;
import com.xjsd.ai.assistant.protocol.todo.TodoBusinessData;
import com.xjsd.ai.assistant.skill.todo.TodoVuiHandler;
import kotlin.Metadata;
import kotlin.Result;
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
@DebugMetadata(c = "com.xjsd.ai.assistant.skill.todo.TodoBusinessHandler$handle$1", f = "TodoBusinessHandler.kt", i = {}, l = {40, 45}, m = "invokeSuspend", n = {}, s = {})
public final class TodoBusinessHandler$handle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BusinessData $businessData;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TodoBusinessHandler$handle$1(BusinessData businessData, Continuation<? super TodoBusinessHandler$handle$1> continuation) {
        super(2, continuation);
        this.$businessData = businessData;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TodoBusinessHandler$handle$1 todoBusinessHandler$handle$1 = new TodoBusinessHandler$handle$1(this.$businessData, continuation);
        todoBusinessHandler$handle$1.L$0 = obj;
        return todoBusinessHandler$handle$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            BusinessData businessData = this.$businessData;
            Result.Companion companion = Result.Companion;
            TodoBusinessData todoBusinessData = (TodoBusinessData) businessData.parseData(TodoBusinessData.class);
            int type = todoBusinessData.getType();
            Class<TodoEntry> cls = TodoEntry.class;
            if (type == 4) {
                TodoEntry todoEntry = (TodoEntry) todoBusinessData.parse(cls);
                TodoVuiHandler.Companion companion2 = TodoVuiHandler.b;
                Intrinsics.checkNotNull(todoEntry);
                this.label = 1;
                if (companion2.c(todoEntry, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (type == 5) {
                TodoEntry todoEntry2 = (TodoEntry) todoBusinessData.parse(cls);
                TodoVuiHandler.Companion companion3 = TodoVuiHandler.b;
                Intrinsics.checkNotNull(todoEntry2);
                this.label = 2;
                if (companion3.e(todoEntry2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (type != 6) {
                UnSupportFeatureManager.f8414a.c();
            } else {
                TodoEntry todoEntry3 = (TodoEntry) todoBusinessData.parse(cls);
                TodoVuiHandler.Companion companion4 = TodoVuiHandler.b;
                Intrinsics.checkNotNull(todoEntry3);
                companion4.b(todoEntry3);
            }
        } else if (i == 1 || i == 2) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th) {
                Result.Companion companion5 = Result.Companion;
                obj2 = Result.m20constructorimpl(ResultKt.createFailure(th));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        obj2 = Result.m20constructorimpl(Unit.INSTANCE);
        Throwable r6 = Result.m23exceptionOrNullimpl(obj2);
        if (r6 != null) {
            ILog.g("TodoBusinessHandler", "handle: 异常->" + r6);
            new PhoneTtsPlayBuilder().d(R.string.tts_common_error_retry).a().c();
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TodoBusinessHandler$handle$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
