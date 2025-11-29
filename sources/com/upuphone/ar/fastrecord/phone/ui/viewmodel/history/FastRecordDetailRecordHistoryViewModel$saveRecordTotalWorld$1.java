package com.upuphone.ar.fastrecord.phone.ui.viewmodel.history;

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
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordDetailRecordHistoryViewModel$saveRecordTotalWorld$1", f = "FastRecordDetailRecordHistoryViewModel.kt", i = {1, 1}, l = {393, 409}, m = "invokeSuspend", n = {"data", "originFinishAsrState"}, s = {"L$1", "Z$0"})
public final class FastRecordDetailRecordHistoryViewModel$saveRecordTotalWorld$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $recordId;
    final /* synthetic */ StringBuffer $stringBuffer;
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    final /* synthetic */ FastRecordDetailRecordHistoryViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordDetailRecordHistoryViewModel$saveRecordTotalWorld$1(long j, StringBuffer stringBuffer, FastRecordDetailRecordHistoryViewModel fastRecordDetailRecordHistoryViewModel, Continuation<? super FastRecordDetailRecordHistoryViewModel$saveRecordTotalWorld$1> continuation) {
        super(2, continuation);
        this.$recordId = j;
        this.$stringBuffer = stringBuffer;
        this.this$0 = fastRecordDetailRecordHistoryViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordDetailRecordHistoryViewModel$saveRecordTotalWorld$1(this.$recordId, this.$stringBuffer, this.this$0, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00ea  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            r2 = 2
            r3 = 1
            java.lang.String r4 = "FastRecordDetailRecordHistoryViewModel"
            if (r1 == 0) goto L_0x002b
            if (r1 == r3) goto L_0x0027
            if (r1 != r2) goto L_0x001f
            boolean r0 = r12.Z$0
            java.lang.Object r1 = r12.L$1
            com.upuphone.ar.fastrecord.phone.db.RecordEntity r1 = (com.upuphone.ar.fastrecord.phone.db.RecordEntity) r1
            java.lang.Object r12 = r12.L$0
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordDetailRecordHistoryViewModel r12 = (com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordDetailRecordHistoryViewModel) r12
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00db
        L_0x001f:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0027:
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0047
        L_0x002b:
            kotlin.ResultKt.throwOnFailure(r13)
            com.upuphone.ar.fastrecord.phone.FastRecordManager$Companion r13 = com.upuphone.ar.fastrecord.phone.FastRecordManager.Companion
            com.upuphone.ar.fastrecord.phone.FastRecordManager r13 = r13.getInstance()
            com.upuphone.ar.fastrecord.phone.db.FastRecordDao r5 = r13.fastRecordDao()
            long r6 = r12.$recordId
            r12.label = r3
            r8 = 0
            r10 = 2
            r11 = 0
            r9 = r12
            java.lang.Object r13 = com.upuphone.ar.fastrecord.phone.db.FastRecordDao.DefaultImpls.findRecordEntityById$default(r5, r6, r8, r9, r10, r11)
            if (r13 != r0) goto L_0x0047
            return r0
        L_0x0047:
            r1 = r13
            com.upuphone.ar.fastrecord.phone.db.RecordEntity r1 = (com.upuphone.ar.fastrecord.phone.db.RecordEntity) r1
            if (r1 == 0) goto L_0x0116
            java.lang.StringBuffer r13 = r12.$stringBuffer
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordDetailRecordHistoryViewModel r5 = r12.this$0
            java.lang.String r13 = r13.toString()
            java.lang.String r6 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r6)
            int r6 = r13.length()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "wordValue size == "
            r7.append(r8)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r6, r4)
            int r6 = r13.length()
            r7 = 1000(0x3e8, float:1.401E-42)
            r8 = 0
            if (r6 <= r7) goto L_0x008b
            r6 = 999(0x3e7, float:1.4E-42)
            java.lang.String r13 = r13.substring(r8, r6)
            java.lang.String r6 = "substring(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r6)
            r1.setShortHandText(r13)
            goto L_0x008e
        L_0x008b:
            r1.setShortHandText(r13)
        L_0x008e:
            boolean r13 = r1.isFinishAsr()
            r1.setFinishAsr(r3)
            r1.setEmptyRecord(r8)
            java.lang.String r3 = r1.getShortHandText()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "saveRecordTotalWorld update data = "
            r6.append(r7)
            r6.append(r1)
            java.lang.String r7 = " originFinishAsrState = "
            r6.append(r7)
            r6.append(r13)
            java.lang.String r7 = ",shortHandText = "
            r6.append(r7)
            r6.append(r3)
            java.lang.String r3 = r6.toString()
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r3, r4)
            com.upuphone.ar.fastrecord.phone.FastRecordManager$Companion r3 = com.upuphone.ar.fastrecord.phone.FastRecordManager.Companion
            com.upuphone.ar.fastrecord.phone.FastRecordManager r3 = r3.getInstance()
            com.upuphone.ar.fastrecord.phone.db.FastRecordDao r3 = r3.fastRecordDao()
            r12.L$0 = r5
            r12.L$1 = r1
            r12.Z$0 = r13
            r12.label = r2
            java.lang.Object r12 = r3.update(r1, r12)
            if (r12 != r0) goto L_0x00d9
            return r0
        L_0x00d9:
            r0 = r13
            r12 = r5
        L_0x00db:
            if (r0 != 0) goto L_0x00ea
            java.lang.String r13 = "saveRecordTotalWorld _mCurFastRecordLiveData postValue"
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r13, r4)
            androidx.lifecycle.MutableLiveData r12 = r12._mCurFastRecordLiveData
            r12.postValue(r1)
            goto L_0x0116
        L_0x00ea:
            java.lang.String r13 = r1.getShortHandText()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "saveRecordTotalWorld _mCurFastRecordLiveData update shortHandText = "
            r0.append(r2)
            r0.append(r13)
            java.lang.String r13 = r0.toString()
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r13, r4)
            androidx.lifecycle.MutableLiveData r12 = r12._mCurFastRecordLiveData
            java.lang.Object r12 = r12.getValue()
            com.upuphone.ar.fastrecord.phone.db.RecordEntity r12 = (com.upuphone.ar.fastrecord.phone.db.RecordEntity) r12
            if (r12 != 0) goto L_0x010f
            goto L_0x0116
        L_0x010f:
            java.lang.String r13 = r1.getShortHandText()
            r12.setShortHandText(r13)
        L_0x0116:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordDetailRecordHistoryViewModel$saveRecordTotalWorld$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordDetailRecordHistoryViewModel$saveRecordTotalWorld$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
