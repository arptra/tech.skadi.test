package com.upuphone.ar.fastrecord.phone.ui.viewmodel.ai;

import com.upuphone.ar.fastrecord.phone.db.RecordSummaryEntity;
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
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.ai.FastRecordAiSummaryOperator$insertSummary$1", f = "FastRecordAiSummaryOperator.kt", i = {}, l = {88, 90}, m = "invokeSuspend", n = {}, s = {})
public final class FastRecordAiSummaryOperator$insertSummary$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ RecordSummaryEntity $summaryEntity;
    int label;
    final /* synthetic */ FastRecordAiSummaryOperator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordAiSummaryOperator$insertSummary$1(RecordSummaryEntity recordSummaryEntity, FastRecordAiSummaryOperator fastRecordAiSummaryOperator, Continuation<? super FastRecordAiSummaryOperator$insertSummary$1> continuation) {
        super(2, continuation);
        this.$summaryEntity = recordSummaryEntity;
        this.this$0 = fastRecordAiSummaryOperator;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordAiSummaryOperator$insertSummary$1(this.$summaryEntity, this.this$0, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0083  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x001e
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x004f
        L_0x0012:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x001a:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x003a
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r7)
            com.upuphone.ar.fastrecord.phone.db.RecordSummaryEntity r7 = r6.$summaryEntity
            long r4 = r7.getRecordId()
            com.upuphone.ar.fastrecord.phone.FastRecordManager$Companion r7 = com.upuphone.ar.fastrecord.phone.FastRecordManager.Companion
            com.upuphone.ar.fastrecord.phone.FastRecordManager r7 = r7.getInstance()
            com.upuphone.ar.fastrecord.phone.db.FastRecordSummaryDao r7 = r7.fastRecordSummaryDao()
            r6.label = r3
            java.lang.Object r7 = r7.deleteByRecordId(r4, r6)
            if (r7 != r0) goto L_0x003a
            return r0
        L_0x003a:
            com.upuphone.ar.fastrecord.phone.FastRecordManager$Companion r7 = com.upuphone.ar.fastrecord.phone.FastRecordManager.Companion
            com.upuphone.ar.fastrecord.phone.FastRecordManager r7 = r7.getInstance()
            com.upuphone.ar.fastrecord.phone.db.FastRecordSummaryDao r7 = r7.fastRecordSummaryDao()
            com.upuphone.ar.fastrecord.phone.db.RecordSummaryEntity r1 = r6.$summaryEntity
            r6.label = r2
            java.lang.Object r7 = r7.insert(r1, r6)
            if (r7 != r0) goto L_0x004f
            return r0
        L_0x004f:
            com.upuphone.ar.fastrecord.phone.db.RecordSummaryEntity r7 = r6.$summaryEntity
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "insertSummary summaryEntity = "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            java.lang.String r0 = "FastRecordAiTodoOperator"
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r7, r0)
            com.upuphone.ar.fastrecord.phone.FastRecordManager$Companion r7 = com.upuphone.ar.fastrecord.phone.FastRecordManager.Companion
            com.upuphone.ar.fastrecord.phone.FastRecordManager r7 = r7.getInstance()
            com.upuphone.ar.fastrecord.phone.db.FastRecordSummaryDao r7 = r7.fastRecordSummaryDao()
            com.upuphone.ar.fastrecord.phone.db.RecordSummaryEntity r0 = r6.$summaryEntity
            long r0 = r0.getRecordId()
            r2 = 0
            r7.updateNeedRequestServer(r0, r2)
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.ai.FastRecordAiSummaryOperator r7 = r6.this$0
            kotlin.jvm.functions.Function1 r7 = r7.getAiResultSuccessCallback()
            if (r7 == 0) goto L_0x0098
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.ai.FastRecordAiSummaryOperator r6 = r6.this$0
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.bean.SummaryRequestBean r6 = r6.mSummaryRequestBean
            if (r6 == 0) goto L_0x0090
            java.lang.String r6 = r6.getRecognizeId()
            goto L_0x0091
        L_0x0090:
            r6 = 0
        L_0x0091:
            if (r6 != 0) goto L_0x0095
            java.lang.String r6 = ""
        L_0x0095:
            r7.invoke(r6)
        L_0x0098:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.ui.viewmodel.ai.FastRecordAiSummaryOperator$insertSummary$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordAiSummaryOperator$insertSummary$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
