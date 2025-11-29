package com.upuphone.ar.fastrecord.phone.ui.viewmodel;

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
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordSummaryViewModel$getTodoAndSummaryData$1", f = "FastRecordSummaryViewModel.kt", i = {1}, l = {123, 125}, m = "invokeSuspend", n = {"mRecordSummaryEntity"}, s = {"L$0"})
public final class FastRecordSummaryViewModel$getTodoAndSummaryData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $recordId;
    Object L$0;
    int label;
    final /* synthetic */ FastRecordSummaryViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordSummaryViewModel$getTodoAndSummaryData$1(long j, FastRecordSummaryViewModel fastRecordSummaryViewModel, Continuation<? super FastRecordSummaryViewModel$getTodoAndSummaryData$1> continuation) {
        super(2, continuation);
        this.$recordId = j;
        this.this$0 = fastRecordSummaryViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordSummaryViewModel$getTodoAndSummaryData$1(this.$recordId, this.this$0, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00bb  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0022
            if (r1 == r3) goto L_0x001e
            if (r1 != r2) goto L_0x0016
            java.lang.Object r0 = r11.L$0
            com.upuphone.ar.fastrecord.phone.db.RecordSummaryEntity r0 = (com.upuphone.ar.fastrecord.phone.db.RecordSummaryEntity) r0
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x005d
        L_0x0016:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x003e
        L_0x0022:
            kotlin.ResultKt.throwOnFailure(r12)
            com.upuphone.ar.fastrecord.phone.FastRecordManager$Companion r12 = com.upuphone.ar.fastrecord.phone.FastRecordManager.Companion
            com.upuphone.ar.fastrecord.phone.FastRecordManager r12 = r12.getInstance()
            com.upuphone.ar.fastrecord.phone.db.FastRecordSummaryDao r4 = r12.fastRecordSummaryDao()
            long r5 = r11.$recordId
            r11.label = r3
            r7 = 0
            r9 = 2
            r10 = 0
            r8 = r11
            java.lang.Object r12 = com.upuphone.ar.fastrecord.phone.db.FastRecordSummaryDao.DefaultImpls.queryNoFinishByRecordId$default(r4, r5, r7, r8, r9, r10)
            if (r12 != r0) goto L_0x003e
            return r0
        L_0x003e:
            com.upuphone.ar.fastrecord.phone.db.RecordSummaryEntity r12 = (com.upuphone.ar.fastrecord.phone.db.RecordSummaryEntity) r12
            com.upuphone.ar.fastrecord.phone.FastRecordManager$Companion r1 = com.upuphone.ar.fastrecord.phone.FastRecordManager.Companion
            com.upuphone.ar.fastrecord.phone.FastRecordManager r1 = r1.getInstance()
            com.upuphone.ar.fastrecord.phone.db.FastRecordTodoItemDao r4 = r1.fastRecordTodoItemDao()
            long r5 = r11.$recordId
            r11.L$0 = r12
            r11.label = r2
            r7 = 0
            r9 = 2
            r10 = 0
            r8 = r11
            java.lang.Object r1 = com.upuphone.ar.fastrecord.phone.db.FastRecordTodoItemDao.DefaultImpls.queryAllNoFinishByRecordId$default(r4, r5, r7, r8, r9, r10)
            if (r1 != r0) goto L_0x005b
            return r0
        L_0x005b:
            r0 = r12
            r12 = r1
        L_0x005d:
            java.util.List r12 = (java.util.List) r12
            long r1 = r11.$recordId
            r4 = 0
            if (r0 == 0) goto L_0x0066
            r5 = r3
            goto L_0x0067
        L_0x0066:
            r5 = r4
        L_0x0067:
            if (r12 == 0) goto L_0x0072
            boolean r6 = r12.isEmpty()
            if (r6 == 0) goto L_0x0070
            goto L_0x0072
        L_0x0070:
            r6 = r4
            goto L_0x0073
        L_0x0072:
            r6 = r3
        L_0x0073:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "getTodoAndSummaryData recordId = "
            r7.append(r8)
            r7.append(r1)
            java.lang.String r1 = " mRecordSummaryEntity != null = "
            r7.append(r1)
            r7.append(r5)
            java.lang.String r1 = ",mTodoList.isNullOrEmpty() = "
            r7.append(r1)
            r7.append(r6)
            java.lang.String r1 = " "
            r7.append(r1)
            java.lang.String r1 = r7.toString()
            java.lang.String r2 = "SummaryViewModel"
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r1, r2)
            if (r0 == 0) goto L_0x00af
            java.lang.String r0 = r0.getContent()
            if (r0 == 0) goto L_0x00af
            int r0 = r0.length()
            if (r0 != 0) goto L_0x00ad
            goto L_0x00af
        L_0x00ad:
            r0 = r3
            goto L_0x00b0
        L_0x00af:
            r0 = r4
        L_0x00b0:
            if (r12 == 0) goto L_0x00bb
            boolean r12 = r12.isEmpty()
            if (r12 == 0) goto L_0x00b9
            goto L_0x00bb
        L_0x00b9:
            r12 = r4
            goto L_0x00bc
        L_0x00bb:
            r12 = r3
        L_0x00bc:
            r12 = r12 ^ r3
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordSummaryViewModel r11 = r11.this$0
            com.upuphone.ar.fastrecord.phone.utils.SingleLiveEvent r11 = r11._mCurIsFinishAiSummary
            if (r0 != 0) goto L_0x00c9
            if (r12 == 0) goto L_0x00c8
            goto L_0x00c9
        L_0x00c8:
            r3 = r4
        L_0x00c9:
            java.lang.Boolean r12 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            r11.postValue(r12)
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordSummaryViewModel$getTodoAndSummaryData$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordSummaryViewModel$getTodoAndSummaryData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
