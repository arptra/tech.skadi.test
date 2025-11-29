package com.upuphone.ar.translation.phone.vm;

import com.upuphone.ar.translation.ext.AnyExtKt;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.bean.IntelExtnTodo;
import com.upuphone.ar.translation.phone.vm.IntelExtnTodoViewModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.phone.vm.IntelExtnTodoViewModel$compareTodoForCalendar$1", f = "IntelExtnTodoViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class IntelExtnTodoViewModel$compareTodoForCalendar$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<IntelExtnTodo> $todoList;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ IntelExtnTodoViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IntelExtnTodoViewModel$compareTodoForCalendar$1(List<IntelExtnTodo> list, IntelExtnTodoViewModel intelExtnTodoViewModel, Continuation<? super IntelExtnTodoViewModel$compareTodoForCalendar$1> continuation) {
        super(2, continuation);
        this.$todoList = list;
        this.this$0 = intelExtnTodoViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IntelExtnTodoViewModel$compareTodoForCalendar$1 intelExtnTodoViewModel$compareTodoForCalendar$1 = new IntelExtnTodoViewModel$compareTodoForCalendar$1(this.$todoList, this.this$0, continuation);
        intelExtnTodoViewModel$compareTodoForCalendar$1.L$0 = obj;
        return intelExtnTodoViewModel$compareTodoForCalendar$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            int size = this.$todoList.size();
            LogExt.j("compareTodoForCalendar todoList=" + size, "IntelExtnTodoViewModel");
            ArrayList arrayList = new ArrayList();
            for (IntelExtnTodo next : this.$todoList) {
                IntelExtnTodoViewModel.CalendarEvent R = this.this$0.R(next);
                if (R != null) {
                    IntelExtnTodoViewModel intelExtnTodoViewModel = this.this$0;
                    if (R.a() == 0) {
                        IntelExtnTodo intelExtnTodo = (IntelExtnTodo) AnyExtKt.a(next, IntelExtnTodo.class);
                        intelExtnTodo.setItemType(0);
                        intelExtnTodo.setCalendarEventId(0);
                        intelExtnTodo.setCalendarId(0);
                        intelExtnTodo.setAddedSchedule(false);
                        IntelExtnTodoViewModel.a0(intelExtnTodoViewModel, intelExtnTodo, false, (Function0) null, 6, (Object) null);
                        arrayList.add(intelExtnTodo);
                    } else {
                        next.setItemType(0);
                        arrayList.add(next);
                    }
                } else {
                    next.setItemType(0);
                    arrayList.add(next);
                }
            }
            int size2 = arrayList.size();
            LogExt.j("getTodosByDb todoList=" + size2 + ", " + arrayList, "IntelExtnTodoViewModel");
            this.this$0.Q(arrayList);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((IntelExtnTodoViewModel$compareTodoForCalendar$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
