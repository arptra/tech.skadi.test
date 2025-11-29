package com.upuphone.ar.fastrecord.phone.ui.viewmodel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nFastRecordTodoViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordTodoViewModel.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordTodoViewModel$getTodoListFromLocal$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,698:1\n1855#2,2:699\n*S KotlinDebug\n*F\n+ 1 FastRecordTodoViewModel.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordTodoViewModel$getTodoListFromLocal$1\n*L\n552#1:699,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel$getTodoListFromLocal$1", f = "FastRecordTodoViewModel.kt", i = {0, 1, 1}, l = {549, 555, 578}, m = "invokeSuspend", n = {"it", "needDelList", "todoList"}, s = {"L$2", "L$2", "L$3"})
public final class FastRecordTodoViewModel$getTodoListFromLocal$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $callback;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ FastRecordTodoViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordTodoViewModel$getTodoListFromLocal$1(FastRecordTodoViewModel fastRecordTodoViewModel, Function0<Unit> function0, Continuation<? super FastRecordTodoViewModel$getTodoListFromLocal$1> continuation) {
        super(2, continuation);
        this.this$0 = fastRecordTodoViewModel;
        this.$callback = function0;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordTodoViewModel$getTodoListFromLocal$1(this.this$0, this.$callback, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0191 A[RETURN] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r20) {
        /*
            r19 = this;
            r7 = r19
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r7.label
            java.lang.String r9 = "TodoViewModel"
            r10 = 0
            r11 = 2
            r12 = 3
            r13 = 1
            if (r0 == 0) goto L_0x004f
            if (r0 == r13) goto L_0x003c
            if (r0 == r11) goto L_0x0023
            if (r0 != r12) goto L_0x001b
            kotlin.ResultKt.throwOnFailure(r20)
            goto L_0x0192
        L_0x001b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0023:
            java.lang.Object r0 = r7.L$4
            java.util.Iterator r0 = (java.util.Iterator) r0
            java.lang.Object r1 = r7.L$3
            java.util.List r1 = (java.util.List) r1
            java.lang.Object r2 = r7.L$2
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            java.lang.Object r3 = r7.L$1
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            java.lang.Object r4 = r7.L$0
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel r4 = (com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel) r4
            kotlin.ResultKt.throwOnFailure(r20)
            goto L_0x00d2
        L_0x003c:
            java.lang.Object r0 = r7.L$2
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.bean.SummaryRequestBean r0 = (com.upuphone.ar.fastrecord.phone.ui.viewmodel.bean.SummaryRequestBean) r0
            java.lang.Object r1 = r7.L$1
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            java.lang.Object r2 = r7.L$0
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel r2 = (com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel) r2
            kotlin.ResultKt.throwOnFailure(r20)
            r14 = r0
            r0 = r20
            goto L_0x0091
        L_0x004f:
            kotlin.ResultKt.throwOnFailure(r20)
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel r0 = r7.this$0
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.bean.SummaryRequestBean r14 = r0.getRequestBean()
            if (r14 == 0) goto L_0x0192
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel r15 = r7.this$0
            kotlin.jvm.functions.Function0<kotlin.Unit> r6 = r7.$callback
            com.upuphone.ar.fastrecord.phone.FastRecordManager$Companion r0 = com.upuphone.ar.fastrecord.phone.FastRecordManager.Companion
            com.upuphone.ar.fastrecord.phone.FastRecordManager r0 = r0.getInstance()
            com.upuphone.ar.fastrecord.phone.db.FastRecordTodoItemDao r0 = r0.fastRecordTodoItemDao()
            java.lang.Long r1 = r14.getRecordId()
            java.lang.String r2 = "getRecordId(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            long r1 = r1.longValue()
            r7.L$0 = r15
            r7.L$1 = r6
            r7.L$2 = r14
            r7.label = r13
            r3 = 0
            r5 = 2
            r16 = 0
            r4 = r19
            r17 = r6
            r6 = r16
            java.lang.Object r0 = com.upuphone.ar.fastrecord.phone.db.FastRecordTodoItemDao.DefaultImpls.queryAllNoFinishByRecordId$default(r0, r1, r3, r4, r5, r6)
            if (r0 != r8) goto L_0x008e
            return r8
        L_0x008e:
            r2 = r15
            r1 = r17
        L_0x0091:
            java.util.List r0 = (java.util.List) r0
            java.lang.Long r3 = r14.getRecordId()
            if (r0 == 0) goto L_0x00a2
            boolean r4 = r0.isEmpty()
            if (r4 == 0) goto L_0x00a0
            goto L_0x00a2
        L_0x00a0:
            r4 = r10
            goto L_0x00a3
        L_0x00a2:
            r4 = r13
        L_0x00a3:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "getTodoListFromLocal recordId = "
            r5.append(r6)
            r5.append(r3)
            java.lang.String r3 = ",todoList  isNullOrEmpty = "
            r5.append(r3)
            r5.append(r4)
            java.lang.String r3 = r5.toString()
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r3, r9)
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            if (r0 == 0) goto L_0x010c
            java.util.Iterator r4 = r0.iterator()
            r18 = r1
            r1 = r0
            r0 = r4
            r4 = r2
            r2 = r3
            r3 = r18
        L_0x00d2:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x0108
            java.lang.Object r5 = r0.next()
            com.upuphone.ar.fastrecord.phone.db.RecordTodoItemEntity r5 = (com.upuphone.ar.fastrecord.phone.db.RecordTodoItemEntity) r5
            java.lang.String r6 = r5.getContent()
            int r6 = r6.length()
            if (r6 != 0) goto L_0x00d2
            r2.add(r5)
            com.upuphone.ar.fastrecord.phone.FastRecordManager$Companion r6 = com.upuphone.ar.fastrecord.phone.FastRecordManager.Companion
            com.upuphone.ar.fastrecord.phone.FastRecordManager r6 = r6.getInstance()
            com.upuphone.ar.fastrecord.phone.db.FastRecordTodoItemDao r6 = r6.fastRecordTodoItemDao()
            r7.L$0 = r4
            r7.L$1 = r3
            r7.L$2 = r2
            r7.L$3 = r1
            r7.L$4 = r0
            r7.label = r11
            java.lang.Object r5 = r6.delete(r5, r7)
            if (r5 != r8) goto L_0x00d2
            return r8
        L_0x0108:
            r0 = r1
            r1 = r3
            r3 = r2
            r2 = r4
        L_0x010c:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            if (r0 == 0) goto L_0x0121
            r4.addAll(r0)
            java.util.Set r0 = kotlin.collections.CollectionsKt.toSet(r3)
            boolean r0 = r4.removeAll(r0)
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
        L_0x0121:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            com.upuphone.xr.sapp.context.SdkContext r3 = com.upuphone.xr.sapp.context.SdkContext.f6675a
            com.upuphone.xr.sapp.context.PermissionContext r3 = r3.f()
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel$Companion r5 = com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel.Companion
            java.lang.String[] r5 = r5.getCalendarPermissions()
            boolean r3 = r3.a(r5)
            if (r3 == 0) goto L_0x013d
            java.util.ArrayList r0 = r2.compareTodoForCalendar(r4)
            goto L_0x0140
        L_0x013d:
            r0.addAll(r4)
        L_0x0140:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "lastComPareList value = "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r3, r9)
            boolean r3 = r0.isEmpty()
            r3 = r3 ^ r13
            if (r3 == 0) goto L_0x016a
            androidx.lifecycle.MutableLiveData r3 = r2._mTodoResult
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r10)
            r3.postValue(r4)
            r2.todoDataNotify(r0)
            goto L_0x0175
        L_0x016a:
            androidx.lifecycle.MutableLiveData r0 = r2._mTodoResult
            java.lang.Integer r2 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r12)
            r0.postValue(r2)
        L_0x0175:
            kotlinx.coroutines.MainCoroutineDispatcher r0 = kotlinx.coroutines.Dispatchers.c()
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel$getTodoListFromLocal$1$1$3 r2 = new com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel$getTodoListFromLocal$1$1$3
            r3 = 0
            r2.<init>(r1, r3)
            r7.L$0 = r3
            r7.L$1 = r3
            r7.L$2 = r3
            r7.L$3 = r3
            r7.L$4 = r3
            r7.label = r12
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt.g(r0, r2, r7)
            if (r0 != r8) goto L_0x0192
            return r8
        L_0x0192:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel$getTodoListFromLocal$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordTodoViewModel$getTodoListFromLocal$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
