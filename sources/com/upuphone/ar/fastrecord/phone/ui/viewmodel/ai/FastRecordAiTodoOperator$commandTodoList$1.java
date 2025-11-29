package com.upuphone.ar.fastrecord.phone.ui.viewmodel.ai;

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

@SourceDebugExtension({"SMAP\nFastRecordAiTodoOperator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordAiTodoOperator.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/ai/FastRecordAiTodoOperator$commandTodoList$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,122:1\n1864#2,3:123\n*S KotlinDebug\n*F\n+ 1 FastRecordAiTodoOperator.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/ai/FastRecordAiTodoOperator$commandTodoList$1\n*L\n90#1:123,3\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.ai.FastRecordAiTodoOperator$commandTodoList$1", f = "FastRecordAiTodoOperator.kt", i = {1}, l = {89, 92}, m = "invokeSuspend", n = {"index$iv"}, s = {"I$0"})
public final class FastRecordAiTodoOperator$commandTodoList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $requestId;
    final /* synthetic */ ArrayList<SmartExTodo.ToDo> $todoBeanList;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ FastRecordAiTodoOperator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordAiTodoOperator$commandTodoList$1(FastRecordAiTodoOperator fastRecordAiTodoOperator, ArrayList<SmartExTodo.ToDo> arrayList, String str, Continuation<? super FastRecordAiTodoOperator$commandTodoList$1> continuation) {
        super(2, continuation);
        this.this$0 = fastRecordAiTodoOperator;
        this.$todoBeanList = arrayList;
        this.$requestId = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordAiTodoOperator$commandTodoList$1(this.this$0, this.$todoBeanList, this.$requestId, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0155 A[SYNTHETIC] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r43) {
        /*
            r42 = this;
            r0 = r42
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            java.lang.String r4 = "FastRecordAiTodoOperator"
            r5 = 2
            r8 = 1
            r9 = 0
            if (r2 == 0) goto L_0x0033
            if (r2 == r8) goto L_0x002f
            if (r2 != r5) goto L_0x0027
            int r2 = r0.I$0
            java.lang.Object r8 = r0.L$2
            java.util.Iterator r8 = (java.util.Iterator) r8
            java.lang.Object r10 = r0.L$1
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r11 = r0.L$0
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.ai.FastRecordAiTodoOperator r11 = (com.upuphone.ar.fastrecord.phone.ui.viewmodel.ai.FastRecordAiTodoOperator) r11
            kotlin.ResultKt.throwOnFailure(r43)
            goto L_0x008f
        L_0x0027:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x002f:
            kotlin.ResultKt.throwOnFailure(r43)
            goto L_0x0082
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r43)
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.ai.FastRecordAiTodoOperator r2 = r0.this$0
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.bean.SummaryRequestBean r2 = r2.mTodoRequestBean
            if (r2 == 0) goto L_0x0043
            java.lang.Long r2 = r2.getRecordId()
            goto L_0x0044
        L_0x0043:
            r2 = r9
        L_0x0044:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "commandTodoList deleteByRecognizeId id = "
            r10.append(r11)
            r10.append(r2)
            java.lang.String r2 = r10.toString()
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r2, r4)
            com.upuphone.ar.fastrecord.phone.FastRecordManager$Companion r2 = com.upuphone.ar.fastrecord.phone.FastRecordManager.Companion
            com.upuphone.ar.fastrecord.phone.FastRecordManager r2 = r2.getInstance()
            com.upuphone.ar.fastrecord.phone.db.FastRecordTodoItemDao r2 = r2.fastRecordTodoItemDao()
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.ai.FastRecordAiTodoOperator r10 = r0.this$0
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.bean.SummaryRequestBean r10 = r10.mTodoRequestBean
            if (r10 == 0) goto L_0x006f
            java.lang.Long r10 = r10.getRecordId()
            goto L_0x0070
        L_0x006f:
            r10 = r9
        L_0x0070:
            if (r10 != 0) goto L_0x0075
            r10 = 0
            goto L_0x0079
        L_0x0075:
            long r10 = r10.longValue()
        L_0x0079:
            r0.label = r8
            java.lang.Object r2 = r2.deleteByRecordId(r10, r0)
            if (r2 != r1) goto L_0x0082
            return r1
        L_0x0082:
            java.util.ArrayList<com.xjsd.xr.sapp.asr.dao.SmartExTodo$ToDo> r2 = r0.$todoBeanList
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.ai.FastRecordAiTodoOperator r8 = r0.this$0
            java.lang.String r10 = r0.$requestId
            java.util.Iterator r2 = r2.iterator()
            r11 = r8
            r8 = r2
            r2 = r3
        L_0x008f:
            boolean r12 = r8.hasNext()
            java.lang.String r13 = ""
            if (r12 == 0) goto L_0x0155
            java.lang.Object r12 = r8.next()
            int r14 = r2 + 1
            if (r2 >= 0) goto L_0x00a2
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x00a2:
            com.xjsd.xr.sapp.asr.dao.SmartExTodo$ToDo r12 = (com.xjsd.xr.sapp.asr.dao.SmartExTodo.ToDo) r12
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r15 = "forEachIndexed index toDo = "
            r2.append(r15)
            r2.append(r12)
            java.lang.String r2 = r2.toString()
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r2, r4)
            com.upuphone.ar.fastrecord.phone.FastRecordManager$Companion r2 = com.upuphone.ar.fastrecord.phone.FastRecordManager.Companion
            com.upuphone.ar.fastrecord.phone.FastRecordManager r15 = r2.getInstance()
            com.upuphone.ar.fastrecord.phone.db.FastRecordTodoItemDao r15 = r15.fastRecordTodoItemDao()
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.bean.SummaryRequestBean r16 = r11.mTodoRequestBean
            if (r16 == 0) goto L_0x00cd
            java.lang.String r16 = r16.getRecognizeId()
            goto L_0x00cf
        L_0x00cd:
            r16 = r9
        L_0x00cf:
            if (r16 != 0) goto L_0x00d4
            r20 = r13
            goto L_0x00d6
        L_0x00d4:
            r20 = r16
        L_0x00d6:
            java.lang.String r23 = r12.getStartTime()
            java.lang.String r24 = r12.getEndTime()
            com.upuphone.ar.fastrecord.phone.FastRecordManager r2 = r2.getInstance()
            android.content.Context r2 = r2.appContext()
            int r6 = com.upuphone.ar.fastrecord.R.string.fr_extract_todo_title
            java.lang.String r2 = r2.getString(r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r2)
            r6.append(r14)
            java.lang.String r25 = r6.toString()
            java.lang.String r26 = r12.getContent()
            java.lang.String r27 = r12.getContent()
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.bean.SummaryRequestBean r2 = r11.mTodoRequestBean
            if (r2 == 0) goto L_0x010e
            java.lang.Long r2 = r2.getRecordId()
            goto L_0x010f
        L_0x010e:
            r2 = r9
        L_0x010f:
            if (r2 != 0) goto L_0x0114
            r21 = 0
            goto L_0x011a
        L_0x0114:
            long r6 = r2.longValue()
            r21 = r6
        L_0x011a:
            if (r10 != 0) goto L_0x011f
            r38 = r13
            goto L_0x0121
        L_0x011f:
            r38 = r10
        L_0x0121:
            com.upuphone.ar.fastrecord.phone.db.RecordTodoItemEntity r2 = new com.upuphone.ar.fastrecord.phone.db.RecordTodoItemEntity
            r17 = r2
            r40 = 143361(0x23001, float:2.00892E-40)
            r41 = 0
            r18 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r34 = 0
            r36 = 0
            r37 = 0
            r39 = 0
            r17.<init>(r18, r20, r21, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r34, r36, r37, r38, r39, r40, r41)
            r0.L$0 = r11
            r0.L$1 = r10
            r0.L$2 = r8
            r0.I$0 = r14
            r0.label = r5
            java.lang.Object r2 = r15.insert(r2, r0)
            if (r2 != r1) goto L_0x0152
            return r1
        L_0x0152:
            r2 = r14
            goto L_0x008f
        L_0x0155:
            com.upuphone.ar.fastrecord.phone.FastRecordManager$Companion r1 = com.upuphone.ar.fastrecord.phone.FastRecordManager.Companion
            com.upuphone.ar.fastrecord.phone.FastRecordManager r1 = r1.getInstance()
            com.upuphone.ar.fastrecord.phone.db.FastRecordTodoItemDao r1 = r1.fastRecordTodoItemDao()
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.ai.FastRecordAiTodoOperator r2 = r0.this$0
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.bean.SummaryRequestBean r2 = r2.mTodoRequestBean
            if (r2 == 0) goto L_0x016c
            java.lang.Long r2 = r2.getRecordId()
            goto L_0x016d
        L_0x016c:
            r2 = r9
        L_0x016d:
            if (r2 != 0) goto L_0x0172
            r6 = 0
            goto L_0x0176
        L_0x0172:
            long r6 = r2.longValue()
        L_0x0176:
            r1.updateNeedRequestServer(r6, r3)
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.ai.FastRecordAiTodoOperator r1 = r0.this$0
            kotlin.jvm.functions.Function1 r1 = r1.getAiResultSuccessCallback()
            if (r1 == 0) goto L_0x0194
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.ai.FastRecordAiTodoOperator r0 = r0.this$0
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.bean.SummaryRequestBean r0 = r0.mTodoRequestBean
            if (r0 == 0) goto L_0x018d
            java.lang.String r9 = r0.getRecognizeId()
        L_0x018d:
            if (r9 != 0) goto L_0x0190
            goto L_0x0191
        L_0x0190:
            r13 = r9
        L_0x0191:
            r1.invoke(r13)
        L_0x0194:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.ui.viewmodel.ai.FastRecordAiTodoOperator$commandTodoList$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordAiTodoOperator$commandTodoList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
