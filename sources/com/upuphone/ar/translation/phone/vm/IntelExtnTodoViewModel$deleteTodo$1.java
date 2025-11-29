package com.upuphone.ar.translation.phone.vm;

import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.bean.IntelExtnTodo;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
@DebugMetadata(c = "com.upuphone.ar.translation.phone.vm.IntelExtnTodoViewModel$deleteTodo$1", f = "IntelExtnTodoViewModel.kt", i = {}, l = {287}, m = "invokeSuspend", n = {}, s = {})
public final class IntelExtnTodoViewModel$deleteTodo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IntelExtnTodo $intelExtnTodo;
    int label;
    final /* synthetic */ IntelExtnTodoViewModel this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.ar.translation.phone.vm.IntelExtnTodoViewModel$deleteTodo$1$1", f = "IntelExtnTodoViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.ar.translation.phone.vm.IntelExtnTodoViewModel$deleteTodo$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(intelExtnTodo2, continuation);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.upuphone.ar.translation.phone.bean.IntelExtnTodo[]} */
        /* JADX WARNING: Multi-variable type inference failed */
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r5) {
            /*
                r4 = this;
                kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r0 = r4.label
                if (r0 != 0) goto L_0x003d
                kotlin.ResultKt.throwOnFailure(r5)
                com.upuphone.ar.translation.phone.helper.TranslatorDbHelper r5 = com.upuphone.ar.translation.phone.helper.TranslatorDbHelper.f6307a
                com.upuphone.ar.translation.phone.dao.IntelExtnTodoDao r5 = r5.b()
                r0 = 1
                com.upuphone.ar.translation.phone.bean.IntelExtnTodo[] r1 = new com.upuphone.ar.translation.phone.bean.IntelExtnTodo[r0]
                com.upuphone.ar.translation.phone.bean.IntelExtnTodo r4 = r3
                java.lang.Class<com.upuphone.ar.translation.phone.bean.IntelExtnTodo> r2 = com.upuphone.ar.translation.phone.bean.IntelExtnTodo.class
                java.lang.Object r4 = com.upuphone.ar.translation.ext.AnyExtKt.a(r4, r2)
                r2 = r4
                com.upuphone.ar.translation.phone.bean.IntelExtnTodo r2 = (com.upuphone.ar.translation.phone.bean.IntelExtnTodo) r2
                r2.setDeleteStatus(r0)
                java.lang.String r0 = r2.getOriginalContent()
                boolean r3 = kotlin.text.StringsKt.isBlank(r0)
                if (r3 == 0) goto L_0x002f
                java.lang.String r0 = r2.getContent()
            L_0x002f:
                r2.setContent(r0)
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                r0 = 0
                r1[r0] = r4
                r5.f(r1)
                kotlin.Unit r4 = kotlin.Unit.INSTANCE
                return r4
            L_0x003d:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.translation.phone.vm.IntelExtnTodoViewModel$deleteTodo$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IntelExtnTodoViewModel$deleteTodo$1(IntelExtnTodo intelExtnTodo, IntelExtnTodoViewModel intelExtnTodoViewModel, Continuation<? super IntelExtnTodoViewModel$deleteTodo$1> continuation) {
        super(2, continuation);
        this.$intelExtnTodo = intelExtnTodo;
        this.this$0 = intelExtnTodoViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new IntelExtnTodoViewModel$deleteTodo$1(this.$intelExtnTodo, this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            IntelExtnTodo intelExtnTodo = this.$intelExtnTodo;
            LogExt.j("deleteTodo todo=" + intelExtnTodo, "IntelExtnTodoViewModel");
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
        List list = (List) this.this$0.d.getValue();
        if (list != null) {
            IntelExtnTodo intelExtnTodo3 = this.$intelExtnTodo;
            Iterator it = list.iterator();
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                int i3 = i2 + 1;
                if (intelExtnTodo3.getId() == ((IntelExtnTodo) it.next()).getId()) {
                    list.remove(i2);
                    break;
                }
                i2 = i3;
            }
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((IntelExtnTodoViewModel$deleteTodo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
