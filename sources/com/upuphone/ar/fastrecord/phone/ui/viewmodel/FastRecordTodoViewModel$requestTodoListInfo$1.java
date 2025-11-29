package com.upuphone.ar.fastrecord.phone.ui.viewmodel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nFastRecordTodoViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordTodoViewModel.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordTodoViewModel$requestTodoListInfo$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,698:1\n1855#2,2:699\n1855#2,2:701\n1855#2,2:703\n*S KotlinDebug\n*F\n+ 1 FastRecordTodoViewModel.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordTodoViewModel$requestTodoListInfo$1\n*L\n492#1:699,2\n501#1:701,2\n510#1:703,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel$requestTodoListInfo$1", f = "FastRecordTodoViewModel.kt", i = {1}, l = {480, 505}, m = "invokeSuspend", n = {"showData"}, s = {"L$1"})
public final class FastRecordTodoViewModel$requestTodoListInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ FastRecordTodoViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordTodoViewModel$requestTodoListInfo$1(FastRecordTodoViewModel fastRecordTodoViewModel, Continuation<? super FastRecordTodoViewModel$requestTodoListInfo$1> continuation) {
        super(2, continuation);
        this.this$0 = fastRecordTodoViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordTodoViewModel$requestTodoListInfo$1(this.this$0, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x017e  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x019c  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            r2 = 2
            r3 = 1
            r4 = 0
            java.lang.String r5 = "TodoViewModel"
            if (r1 == 0) goto L_0x0032
            if (r1 == r3) goto L_0x002a
            if (r1 != r2) goto L_0x0022
            java.lang.Object r1 = r12.L$2
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r5 = r12.L$1
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            java.lang.Object r6 = r12.L$0
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel r6 = (com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel) r6
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00ff
        L_0x0022:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x002a:
            java.lang.Object r1 = r12.L$0
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel r1 = (com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel) r1
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0075
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r13)
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel r13 = r12.this$0
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.bean.SummaryRequestBean r13 = r13.getRequestBean()
            if (r13 == 0) goto L_0x01b1
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel r1 = r12.this$0
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "requestTodoListInfo data = "
            r6.append(r7)
            r6.append(r13)
            java.lang.String r6 = r6.toString()
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r6, r5)
            com.upuphone.ar.fastrecord.phone.FastRecordManager$Companion r6 = com.upuphone.ar.fastrecord.phone.FastRecordManager.Companion
            com.upuphone.ar.fastrecord.phone.FastRecordManager r6 = r6.getInstance()
            com.upuphone.ar.fastrecord.phone.db.FastRecordTodoItemDao r6 = r6.fastRecordTodoItemDao()
            java.lang.Long r13 = r13.getRecordId()
            java.lang.String r7 = "getRecordId(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r7)
            long r7 = r13.longValue()
            r12.L$0 = r1
            r12.label = r3
            java.lang.Object r13 = r6.queryByRecordId(r7, r12)
            if (r13 != r0) goto L_0x0075
            return r0
        L_0x0075:
            java.util.List r13 = (java.util.List) r13
            kotlin.jvm.internal.Ref$BooleanRef r6 = new kotlin.jvm.internal.Ref$BooleanRef
            r6.<init>()
            r6.element = r3
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            if (r13 == 0) goto L_0x00aa
            boolean r8 = r13.isEmpty()
            if (r8 == 0) goto L_0x008c
            goto L_0x00aa
        L_0x008c:
            java.lang.Object r8 = r13.get(r4)
            com.upuphone.ar.fastrecord.phone.db.RecordTodoItemEntity r8 = (com.upuphone.ar.fastrecord.phone.db.RecordTodoItemEntity) r8
            boolean r8 = r8.isNeedRequestServer()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "requestTodoListInfo isNeedRequestServer state = "
            r9.append(r10)
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r8, r5)
        L_0x00aa:
            if (r13 == 0) goto L_0x01a9
            boolean r8 = r13.isEmpty()
            if (r8 == 0) goto L_0x00b4
            goto L_0x01a9
        L_0x00b4:
            java.lang.Object r8 = r13.get(r4)
            com.upuphone.ar.fastrecord.phone.db.RecordTodoItemEntity r8 = (com.upuphone.ar.fastrecord.phone.db.RecordTodoItemEntity) r8
            boolean r8 = r8.isNeedRequestServer()
            if (r8 == 0) goto L_0x00c2
            goto L_0x01a9
        L_0x00c2:
            java.util.Iterator r8 = r13.iterator()
        L_0x00c6:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x00ef
            java.lang.Object r9 = r8.next()
            com.upuphone.ar.fastrecord.phone.db.RecordTodoItemEntity r9 = (com.upuphone.ar.fastrecord.phone.db.RecordTodoItemEntity) r9
            boolean r10 = r9.isFinishDel()
            if (r10 != 0) goto L_0x00c6
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "requestTodoListInfo is not finishDel data = "
            r10.append(r11)
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r9, r5)
            r6.element = r4
            goto L_0x00c6
        L_0x00ef:
            boolean r6 = r6.element
            if (r6 == 0) goto L_0x0134
            java.lang.String r6 = "requestTodoListInfo isAllDataFinishState"
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r6, r5)
            java.util.Iterator r13 = r13.iterator()
            r6 = r1
            r5 = r7
            r1 = r13
        L_0x00ff:
            boolean r13 = r1.hasNext()
            if (r13 == 0) goto L_0x0131
            java.lang.Object r13 = r1.next()
            com.upuphone.ar.fastrecord.phone.db.RecordTodoItemEntity r13 = (com.upuphone.ar.fastrecord.phone.db.RecordTodoItemEntity) r13
            r13.setFinishDel(r4)
            java.lang.String r7 = r13.getContent()
            r13.setContentTemp(r7)
            r5.add(r13)
            com.upuphone.ar.fastrecord.phone.FastRecordManager$Companion r7 = com.upuphone.ar.fastrecord.phone.FastRecordManager.Companion
            com.upuphone.ar.fastrecord.phone.FastRecordManager r7 = r7.getInstance()
            com.upuphone.ar.fastrecord.phone.db.FastRecordTodoItemDao r7 = r7.fastRecordTodoItemDao()
            r12.L$0 = r6
            r12.L$1 = r5
            r12.L$2 = r1
            r12.label = r2
            java.lang.Object r13 = r7.update(r13, r12)
            if (r13 != r0) goto L_0x00ff
            return r0
        L_0x0131:
            r7 = r5
            r1 = r6
            goto L_0x0167
        L_0x0134:
            java.lang.String r12 = "requestTodoListInfo isAllDataFinishState not"
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r12, r5)
            java.util.Iterator r12 = r13.iterator()
        L_0x013d:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x0167
            java.lang.Object r13 = r12.next()
            com.upuphone.ar.fastrecord.phone.db.RecordTodoItemEntity r13 = (com.upuphone.ar.fastrecord.phone.db.RecordTodoItemEntity) r13
            boolean r0 = r13.isFinishDel()
            if (r0 != 0) goto L_0x013d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "requestTodoListInfo is not finishDel show data = "
            r0.append(r2)
            r0.append(r13)
            java.lang.String r0 = r0.toString()
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r0, r5)
            r7.add(r13)
            goto L_0x013d
        L_0x0167:
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            com.upuphone.xr.sapp.context.SdkContext r13 = com.upuphone.xr.sapp.context.SdkContext.f6675a
            com.upuphone.xr.sapp.context.PermissionContext r13 = r13.f()
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel$Companion r0 = com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel.Companion
            java.lang.String[] r0 = r0.getCalendarPermissions()
            boolean r13 = r13.a(r0)
            if (r13 == 0) goto L_0x0183
            java.util.ArrayList r12 = r1.compareTodoForCalendar(r7)
            goto L_0x0186
        L_0x0183:
            r12.addAll(r7)
        L_0x0186:
            boolean r13 = r12.isEmpty()
            r13 = r13 ^ r3
            if (r13 == 0) goto L_0x019c
            androidx.lifecycle.MutableLiveData r13 = r1._mTodoResult
            java.lang.Integer r0 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            r13.postValue(r0)
            r1.todoDataNotify(r12)
            goto L_0x01b1
        L_0x019c:
            androidx.lifecycle.MutableLiveData r12 = r1._mTodoResult
            r13 = 3
            java.lang.Integer r13 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r13)
            r12.postValue(r13)
            goto L_0x01b1
        L_0x01a9:
            java.lang.String r12 = "requestTodoListInfo local data  todoList.isNullOrEmpty"
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r12, r5)
            r1.startAiToDoTask()
        L_0x01b1:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel$requestTodoListInfo$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordTodoViewModel$requestTodoListInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
