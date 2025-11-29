package com.upuphone.ar.translation.phone.vm;

import com.upuphone.ar.translation.phone.bean.NoteBean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.phone.vm.IntelExtnTodoViewModel$getTodosByDb$1", f = "IntelExtnTodoViewModel.kt", i = {1}, l = {319, 341}, m = "invokeSuspend", n = {"todoList"}, s = {"L$0"})
public final class IntelExtnTodoViewModel$getTodosByDb$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isClearDeleteStatus;
    final /* synthetic */ NoteBean $noteBean;
    Object L$0;
    int label;
    final /* synthetic */ IntelExtnTodoViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IntelExtnTodoViewModel$getTodosByDb$1(NoteBean noteBean, IntelExtnTodoViewModel intelExtnTodoViewModel, boolean z, Continuation<? super IntelExtnTodoViewModel$getTodosByDb$1> continuation) {
        super(2, continuation);
        this.$noteBean = noteBean;
        this.this$0 = intelExtnTodoViewModel;
        this.$isClearDeleteStatus = z;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new IntelExtnTodoViewModel$getTodosByDb$1(this.$noteBean, this.this$0, this.$isClearDeleteStatus, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00b4  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 0
            java.lang.String r3 = "IntelExtnTodoViewModel"
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L_0x0025
            if (r1 == r5) goto L_0x0021
            if (r1 != r4) goto L_0x0019
            java.lang.Object r0 = r8.L$0
            java.util.List r0 = (java.util.List) r0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x006e
        L_0x0019:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0021:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0054
        L_0x0025:
            kotlin.ResultKt.throwOnFailure(r9)
            com.upuphone.ar.translation.phone.bean.NoteBean r9 = r8.$noteBean
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r6 = "getTodosByDb noteBean="
            r1.append(r6)
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            com.upuphone.ar.translation.ext.LogExt.j(r9, r3)
            kotlinx.coroutines.CoroutineDispatcher r9 = kotlinx.coroutines.Dispatchers.b()
            com.upuphone.ar.translation.phone.vm.IntelExtnTodoViewModel$getTodosByDb$1$todoList$1 r1 = new com.upuphone.ar.translation.phone.vm.IntelExtnTodoViewModel$getTodosByDb$1$todoList$1
            boolean r6 = r8.$isClearDeleteStatus
            com.upuphone.ar.translation.phone.bean.NoteBean r7 = r8.$noteBean
            r1.<init>(r6, r7, r2)
            r8.label = r5
            java.lang.Object r9 = kotlinx.coroutines.BuildersKt.g(r9, r1, r8)
            if (r9 != r0) goto L_0x0054
            return r0
        L_0x0054:
            java.util.List r9 = (java.util.List) r9
            kotlinx.coroutines.CoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.b()
            com.upuphone.ar.translation.phone.vm.IntelExtnTodoViewModel$getTodosByDb$1$realTodoSize$1 r5 = new com.upuphone.ar.translation.phone.vm.IntelExtnTodoViewModel$getTodosByDb$1$realTodoSize$1
            com.upuphone.ar.translation.phone.bean.NoteBean r6 = r8.$noteBean
            r5.<init>(r6, r2)
            r8.L$0 = r9
            r8.label = r4
            java.lang.Object r1 = kotlinx.coroutines.BuildersKt.g(r1, r5, r8)
            if (r1 != r0) goto L_0x006c
            return r0
        L_0x006c:
            r0 = r9
            r9 = r1
        L_0x006e:
            java.lang.Number r9 = (java.lang.Number) r9
            int r9 = r9.intValue()
            com.upuphone.ar.translation.phone.vm.IntelExtnTodoViewModel r1 = r8.this$0
            androidx.lifecycle.MutableLiveData r1 = r1.g
            java.lang.Integer r2 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r9)
            r1.setValue(r2)
            int r1 = r0.size()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "getTodosByDb todoList="
            r2.append(r4)
            r2.append(r1)
            java.lang.String r1 = ", realTodoSize="
            r2.append(r1)
            r2.append(r9)
            java.lang.String r9 = r2.toString()
            com.upuphone.ar.translation.ext.LogExt.j(r9, r3)
            boolean r9 = r0.isEmpty()
            if (r9 == 0) goto L_0x00b4
            com.upuphone.ar.translation.phone.vm.IntelExtnTodoViewModel r8 = r8.this$0
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            r8.Q(r9)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L_0x00b4:
            com.upuphone.ar.translation.phone.vm.IntelExtnTodoViewModel r9 = r8.this$0
            boolean r9 = r9.w()
            if (r9 == 0) goto L_0x00c2
            com.upuphone.ar.translation.phone.vm.IntelExtnTodoViewModel r8 = r8.this$0
            r8.x(r0)
            goto L_0x00cf
        L_0x00c2:
            com.upuphone.ar.translation.phone.vm.IntelExtnTodoViewModel r8 = r8.this$0
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            r9.addAll(r0)
            r8.Q(r9)
        L_0x00cf:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.translation.phone.vm.IntelExtnTodoViewModel$getTodosByDb$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((IntelExtnTodoViewModel$getTodosByDb$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
