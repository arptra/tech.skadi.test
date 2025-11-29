package com.xjsd.ai.assistant.phone.vui.todo;

import android.content.Context;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import com.xjsd.ai.assistant.common.data.DataStoreUtilsKt;
import com.xjsd.ai.assistant.core.ContextHelper;
import com.xjsd.ai.assistant.log.ILog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nTodoRepository.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TodoRepository.kt\ncom/xjsd/ai/assistant/phone/vui/todo/TodoRepository$migrationData$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,126:1\n53#2:127\n55#2:131\n50#3:128\n55#3:130\n106#4:129\n*S KotlinDebug\n*F\n+ 1 TodoRepository.kt\ncom/xjsd/ai/assistant/phone/vui/todo/TodoRepository$migrationData$1\n*L\n68#1:127\n68#1:131\n68#1:128\n68#1:130\n68#1:129\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.ai.assistant.phone.vui.todo.TodoRepository$migrationData$1", f = "TodoRepository.kt", i = {}, l = {70}, m = "invokeSuspend", n = {}, s = {})
public final class TodoRepository$migrationData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public TodoRepository$migrationData$1(Continuation<? super TodoRepository$migrationData$1> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TodoRepository$migrationData$1(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Preferences.Key a2 = PreferencesKeys.a("migration_1_2");
            Context a3 = ContextHelper.a();
            Intrinsics.checkNotNullExpressionValue(a3, "getContext(...)");
            TodoRepository$migrationData$1$invokeSuspend$$inlined$map$1 todoRepository$migrationData$1$invokeSuspend$$inlined$map$1 = new TodoRepository$migrationData$1$invokeSuspend$$inlined$map$1(DataStoreUtilsKt.a(a3).getData(), a2);
            this.label = 1;
            obj = FlowKt.w(todoRepository$migrationData$1$invokeSuspend$$inlined$map$1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (((Boolean) obj).booleanValue() || Intrinsics.areEqual((Object) TodoRepository.b, (Object) "")) {
            ILog.a("TodoRepository", "migrationData: 数据已迁移");
        } else {
            TodoRepository todoRepository = TodoRepository.f8656a;
            int i2 = todoRepository.j().d().i(TodoRepository.b);
            ILog.a("TodoRepository", "migrationData: 迁移数据完成，影响条数->" + i2);
            todoRepository.n();
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TodoRepository$migrationData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
