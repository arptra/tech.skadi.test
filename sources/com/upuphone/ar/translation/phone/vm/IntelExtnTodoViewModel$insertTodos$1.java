package com.upuphone.ar.translation.phone.vm;

import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.bean.IntelExtnTodo;
import com.upuphone.ar.translation.phone.bean.NoteBean;
import com.upuphone.ar.translation.phone.helper.TranslatorDbHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.phone.vm.IntelExtnTodoViewModel$insertTodos$1", f = "IntelExtnTodoViewModel.kt", i = {}, l = {186, 190}, m = "invokeSuspend", n = {}, s = {})
public final class IntelExtnTodoViewModel$insertTodos$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ NoteBean $noteBean;
    final /* synthetic */ List<IntelExtnTodo> $todos;
    int label;
    final /* synthetic */ IntelExtnTodoViewModel this$0;

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.ar.translation.phone.vm.IntelExtnTodoViewModel$insertTodos$1$1", f = "IntelExtnTodoViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.ar.translation.phone.vm.IntelExtnTodoViewModel$insertTodos$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Long>>, Object> {
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(list, continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return TranslatorDbHelper.f6307a.b().a(list);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super List<Long>> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IntelExtnTodoViewModel$insertTodos$1(List<IntelExtnTodo> list, IntelExtnTodoViewModel intelExtnTodoViewModel, NoteBean noteBean, Continuation<? super IntelExtnTodoViewModel$insertTodos$1> continuation) {
        super(2, continuation);
        this.$todos = list;
        this.this$0 = intelExtnTodoViewModel;
        this.$noteBean = noteBean;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new IntelExtnTodoViewModel$insertTodos$1(this.$todos, this.this$0, this.$noteBean, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            int size = this.$todos.size();
            LogExt.j("insertTodos todos=" + size, "IntelExtnTodoViewModel");
            CoroutineDispatcher b = Dispatchers.b();
            final List<IntelExtnTodo> list = this.$todos;
            AnonymousClass1 r1 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
            this.label = 1;
            if (BuildersKt.g(b, r1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            List list2 = (List) obj;
            this.this$0.g.setValue(Boxing.boxInt(list2.size()));
            IntelExtnTodoViewModel intelExtnTodoViewModel = this.this$0;
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(list2);
            intelExtnTodoViewModel.Q(arrayList);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        CoroutineDispatcher b2 = Dispatchers.b();
        IntelExtnTodoViewModel$insertTodos$1$todoList$1 intelExtnTodoViewModel$insertTodos$1$todoList$1 = new IntelExtnTodoViewModel$insertTodos$1$todoList$1(this.$noteBean, (Continuation<? super IntelExtnTodoViewModel$insertTodos$1$todoList$1>) null);
        this.label = 2;
        obj = BuildersKt.g(b2, intelExtnTodoViewModel$insertTodos$1$todoList$1, this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        List list22 = (List) obj;
        this.this$0.g.setValue(Boxing.boxInt(list22.size()));
        IntelExtnTodoViewModel intelExtnTodoViewModel2 = this.this$0;
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(list22);
        intelExtnTodoViewModel2.Q(arrayList2);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((IntelExtnTodoViewModel$insertTodos$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
