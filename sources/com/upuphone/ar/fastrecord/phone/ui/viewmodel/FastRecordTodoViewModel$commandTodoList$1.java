package com.upuphone.ar.fastrecord.phone.ui.viewmodel;

import com.xjsd.xr.sapp.asr.dao.SmartExTodo;
import java.util.ArrayList;
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

@SourceDebugExtension({"SMAP\nFastRecordTodoViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordTodoViewModel.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordTodoViewModel$commandTodoList$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,698:1\n1864#2,3:699\n*S KotlinDebug\n*F\n+ 1 FastRecordTodoViewModel.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordTodoViewModel$commandTodoList$1\n*L\n117#1:699,3\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel$commandTodoList$1", f = "FastRecordTodoViewModel.kt", i = {1}, l = {116, 118}, m = "invokeSuspend", n = {"index$iv"}, s = {"I$0"})
public final class FastRecordTodoViewModel$commandTodoList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $requestId;
    final /* synthetic */ ArrayList<SmartExTodo.ToDo> $todoBeanList;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ FastRecordTodoViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordTodoViewModel$commandTodoList$1(FastRecordTodoViewModel fastRecordTodoViewModel, ArrayList<SmartExTodo.ToDo> arrayList, String str, Continuation<? super FastRecordTodoViewModel$commandTodoList$1> continuation) {
        super(2, continuation);
        this.this$0 = fastRecordTodoViewModel;
        this.$todoBeanList = arrayList;
        this.$requestId = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordTodoViewModel$commandTodoList$1(this.this$0, this.$todoBeanList, this.$requestId, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x015a  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r42) {
        /*
            r41 = this;
            r0 = r41
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 0
            r7 = 1
            r8 = 0
            if (r2 == 0) goto L_0x0033
            if (r2 == r7) goto L_0x002f
            if (r2 != r4) goto L_0x0027
            int r2 = r0.I$0
            java.lang.Object r7 = r0.L$2
            java.util.Iterator r7 = (java.util.Iterator) r7
            java.lang.Object r9 = r0.L$1
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r10 = r0.L$0
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel r10 = (com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel) r10
            kotlin.ResultKt.throwOnFailure(r42)
            goto L_0x0090
        L_0x0027:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x002f:
            kotlin.ResultKt.throwOnFailure(r42)
            goto L_0x0083
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r42)
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel r2 = r0.this$0
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.bean.SummaryRequestBean r2 = r2.getRequestBean()
            if (r2 == 0) goto L_0x0043
            java.lang.Long r2 = r2.getRecordId()
            goto L_0x0044
        L_0x0043:
            r2 = r8
        L_0x0044:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "commandTodoList deleteByRecognizeId id = "
            r9.append(r10)
            r9.append(r2)
            java.lang.String r2 = r9.toString()
            java.lang.String r9 = "TodoViewModel"
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r2, r9)
            com.upuphone.ar.fastrecord.phone.FastRecordManager$Companion r2 = com.upuphone.ar.fastrecord.phone.FastRecordManager.Companion
            com.upuphone.ar.fastrecord.phone.FastRecordManager r2 = r2.getInstance()
            com.upuphone.ar.fastrecord.phone.db.FastRecordTodoItemDao r2 = r2.fastRecordTodoItemDao()
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel r9 = r0.this$0
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.bean.SummaryRequestBean r9 = r9.getRequestBean()
            if (r9 == 0) goto L_0x0071
            java.lang.Long r9 = r9.getRecordId()
            goto L_0x0072
        L_0x0071:
            r9 = r8
        L_0x0072:
            if (r9 != 0) goto L_0x0076
            r9 = r5
            goto L_0x007a
        L_0x0076:
            long r9 = r9.longValue()
        L_0x007a:
            r0.label = r7
            java.lang.Object r2 = r2.deleteByRecordId(r9, r0)
            if (r2 != r1) goto L_0x0083
            return r1
        L_0x0083:
            java.util.ArrayList<com.xjsd.xr.sapp.asr.dao.SmartExTodo$ToDo> r2 = r0.$todoBeanList
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel r7 = r0.this$0
            java.lang.String r9 = r0.$requestId
            java.util.Iterator r2 = r2.iterator()
            r10 = r7
            r7 = r2
            r2 = r3
        L_0x0090:
            boolean r11 = r7.hasNext()
            if (r11 == 0) goto L_0x0141
            java.lang.Object r11 = r7.next()
            int r12 = r2 + 1
            if (r2 >= 0) goto L_0x00a1
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x00a1:
            com.xjsd.xr.sapp.asr.dao.SmartExTodo$ToDo r11 = (com.xjsd.xr.sapp.asr.dao.SmartExTodo.ToDo) r11
            com.upuphone.ar.fastrecord.phone.FastRecordManager$Companion r2 = com.upuphone.ar.fastrecord.phone.FastRecordManager.Companion
            com.upuphone.ar.fastrecord.phone.FastRecordManager r13 = r2.getInstance()
            com.upuphone.ar.fastrecord.phone.db.FastRecordTodoItemDao r13 = r13.fastRecordTodoItemDao()
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.bean.SummaryRequestBean r14 = r10.getRequestBean()
            if (r14 == 0) goto L_0x00b8
            java.lang.String r14 = r14.getRecognizeId()
            goto L_0x00b9
        L_0x00b8:
            r14 = r8
        L_0x00b9:
            java.lang.String r15 = ""
            if (r14 != 0) goto L_0x00c0
            r19 = r15
            goto L_0x00c2
        L_0x00c0:
            r19 = r14
        L_0x00c2:
            java.lang.String r22 = r11.getStartTime()
            java.lang.String r23 = r11.getEndTime()
            com.upuphone.ar.fastrecord.phone.FastRecordManager r2 = r2.getInstance()
            android.content.Context r2 = r2.appContext()
            int r14 = com.upuphone.ar.fastrecord.R.string.fr_extract_todo_title
            java.lang.String r2 = r2.getString(r14)
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r14.append(r2)
            r14.append(r12)
            java.lang.String r24 = r14.toString()
            java.lang.String r25 = r11.getContent()
            java.lang.String r26 = r11.getContent()
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.bean.SummaryRequestBean r2 = r10.getRequestBean()
            if (r2 == 0) goto L_0x00fa
            java.lang.Long r2 = r2.getRecordId()
            goto L_0x00fb
        L_0x00fa:
            r2 = r8
        L_0x00fb:
            if (r2 != 0) goto L_0x0100
            r20 = r5
            goto L_0x0106
        L_0x0100:
            long r16 = r2.longValue()
            r20 = r16
        L_0x0106:
            if (r9 != 0) goto L_0x010b
            r37 = r15
            goto L_0x010d
        L_0x010b:
            r37 = r9
        L_0x010d:
            com.upuphone.ar.fastrecord.phone.db.RecordTodoItemEntity r2 = new com.upuphone.ar.fastrecord.phone.db.RecordTodoItemEntity
            r16 = r2
            r39 = 143361(0x23001, float:2.00892E-40)
            r40 = 0
            r17 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r33 = 0
            r35 = 0
            r36 = 0
            r38 = 0
            r16.<init>(r17, r19, r20, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r33, r35, r36, r37, r38, r39, r40)
            r0.L$0 = r10
            r0.L$1 = r9
            r0.L$2 = r7
            r0.I$0 = r12
            r0.label = r4
            java.lang.Object r2 = r13.insert(r2, r0)
            if (r2 != r1) goto L_0x013e
            return r1
        L_0x013e:
            r2 = r12
            goto L_0x0090
        L_0x0141:
            com.upuphone.ar.fastrecord.phone.FastRecordManager$Companion r1 = com.upuphone.ar.fastrecord.phone.FastRecordManager.Companion
            com.upuphone.ar.fastrecord.phone.FastRecordManager r1 = r1.getInstance()
            com.upuphone.ar.fastrecord.phone.db.FastRecordTodoItemDao r1 = r1.fastRecordTodoItemDao()
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel r2 = r0.this$0
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.bean.SummaryRequestBean r2 = r2.getRequestBean()
            if (r2 == 0) goto L_0x0157
            java.lang.Long r8 = r2.getRecordId()
        L_0x0157:
            if (r8 != 0) goto L_0x015a
            goto L_0x015e
        L_0x015a:
            long r5 = r8.longValue()
        L_0x015e:
            r1.updateNeedRequestServer(r5, r3)
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel r0 = r0.this$0
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel$commandTodoList$1$2 r1 = com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel$commandTodoList$1.AnonymousClass2.INSTANCE
            r0.getTodoListFromLocal(r1)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel$commandTodoList$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordTodoViewModel$commandTodoList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
