package com.upuphone.ar.translation.phone.vm;

import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.bean.IntelExtnTodo;
import com.upuphone.ar.translation.phone.helper.TranslatorDbHelper;
import java.util.Iterator;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.phone.vm.IntelExtnTodoViewModel$updateTodo$2", f = "IntelExtnTodoViewModel.kt", i = {}, l = {220}, m = "invokeSuspend", n = {}, s = {})
public final class IntelExtnTodoViewModel$updateTodo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IntelExtnTodo $intelExtnTodo;
    final /* synthetic */ boolean $isUpdateLocal;
    final /* synthetic */ Function0<Unit> $onLoadTodos;
    int label;
    final /* synthetic */ IntelExtnTodoViewModel this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.ar.translation.phone.vm.IntelExtnTodoViewModel$updateTodo$2$1", f = "IntelExtnTodoViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.ar.translation.phone.vm.IntelExtnTodoViewModel$updateTodo$2$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(intelExtnTodo2, continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                TranslatorDbHelper.f6307a.b().f(intelExtnTodo2);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IntelExtnTodoViewModel$updateTodo$2(IntelExtnTodo intelExtnTodo, IntelExtnTodoViewModel intelExtnTodoViewModel, Function0<Unit> function0, boolean z, Continuation<? super IntelExtnTodoViewModel$updateTodo$2> continuation) {
        super(2, continuation);
        this.$intelExtnTodo = intelExtnTodo;
        this.this$0 = intelExtnTodoViewModel;
        this.$onLoadTodos = function0;
        this.$isUpdateLocal = z;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new IntelExtnTodoViewModel$updateTodo$2(this.$intelExtnTodo, this.this$0, this.$onLoadTodos, this.$isUpdateLocal, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            IntelExtnTodo intelExtnTodo = this.$intelExtnTodo;
            LogExt.j("updateTodo todo=" + intelExtnTodo, "IntelExtnTodoViewModel");
            CoroutineDispatcher b = Dispatchers.b();
            final IntelExtnTodo intelExtnTodo2 = this.$intelExtnTodo;
            AnonymousClass1 r1 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
            this.label = 1;
            if (BuildersKt.g(b, r1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int i2 = 0;
        if (this.this$0.r) {
            this.$onLoadTodos.invoke();
            this.this$0.r = false;
        }
        if (!this.$isUpdateLocal) {
            return Unit.INSTANCE;
        }
        List list = (List) this.this$0.d.getValue();
        if (list != null) {
            IntelExtnTodo intelExtnTodo3 = this.$intelExtnTodo;
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                int i3 = i2 + 1;
                if (intelExtnTodo3.getId() == ((IntelExtnTodo) it.next()).getId()) {
                    list.set(i2, intelExtnTodo3);
                    break;
                }
                i2 = i3;
            }
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((IntelExtnTodoViewModel$updateTodo$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
