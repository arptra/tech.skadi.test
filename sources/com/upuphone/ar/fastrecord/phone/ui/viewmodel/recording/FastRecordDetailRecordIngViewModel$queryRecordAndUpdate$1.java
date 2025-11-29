package com.upuphone.ar.fastrecord.phone.ui.viewmodel.recording;

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
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.recording.FastRecordDetailRecordIngViewModel$queryRecordAndUpdate$1", f = "FastRecordDetailRecordIngViewModel.kt", i = {1}, l = {30, 32}, m = "invokeSuspend", n = {"record"}, s = {"L$0"})
public final class FastRecordDetailRecordIngViewModel$queryRecordAndUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $recordId;
    Object L$0;
    int label;
    final /* synthetic */ FastRecordDetailRecordIngViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordDetailRecordIngViewModel$queryRecordAndUpdate$1(long j, FastRecordDetailRecordIngViewModel fastRecordDetailRecordIngViewModel, Continuation<? super FastRecordDetailRecordIngViewModel$queryRecordAndUpdate$1> continuation) {
        super(2, continuation);
        this.$recordId = j;
        this.this$0 = fastRecordDetailRecordIngViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordDetailRecordIngViewModel$queryRecordAndUpdate$1(this.$recordId, this.this$0, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x006a  */
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
            com.upuphone.ar.fastrecord.phone.db.RecordEntity r0 = (com.upuphone.ar.fastrecord.phone.db.RecordEntity) r0
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0061
        L_0x0016:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0046
        L_0x0022:
            kotlin.ResultKt.throwOnFailure(r12)
            long r4 = r11.$recordId
            r6 = 0
            int r12 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r12 <= 0) goto L_0x0087
            com.upuphone.ar.fastrecord.phone.FastRecordManager$Companion r12 = com.upuphone.ar.fastrecord.phone.FastRecordManager.Companion
            com.upuphone.ar.fastrecord.phone.FastRecordManager r12 = r12.getInstance()
            com.upuphone.ar.fastrecord.phone.db.FastRecordDao r4 = r12.fastRecordDao()
            long r5 = r11.$recordId
            r11.label = r3
            r7 = 0
            r9 = 2
            r10 = 0
            r8 = r11
            java.lang.Object r12 = com.upuphone.ar.fastrecord.phone.db.FastRecordDao.DefaultImpls.findRecordEntityById$default(r4, r5, r7, r8, r9, r10)
            if (r12 != r0) goto L_0x0046
            return r0
        L_0x0046:
            com.upuphone.ar.fastrecord.phone.db.RecordEntity r12 = (com.upuphone.ar.fastrecord.phone.db.RecordEntity) r12
            com.upuphone.ar.fastrecord.phone.FastRecordManager$Companion r1 = com.upuphone.ar.fastrecord.phone.FastRecordManager.Companion
            com.upuphone.ar.fastrecord.phone.FastRecordManager r1 = r1.getInstance()
            com.upuphone.ar.fastrecord.phone.db.FastRecordDao r1 = r1.fastRecordDao()
            long r3 = r11.$recordId
            r11.L$0 = r12
            r11.label = r2
            r2 = 0
            java.lang.Object r1 = r1.updateRecordIsNewRecordItemState(r3, r2, r11)
            if (r1 != r0) goto L_0x0060
            return r0
        L_0x0060:
            r0 = r12
        L_0x0061:
            java.lang.String r12 = "getRecordData info from db"
            java.lang.String r1 = "FastRecordDetailRecordIngViewModel"
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r12, r1)
            if (r0 == 0) goto L_0x0087
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.recording.FastRecordDetailRecordIngViewModel r11 = r11.this$0
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r2 = "getRecordData info = "
            r12.append(r2)
            r12.append(r0)
            java.lang.String r12 = r12.toString()
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r12, r1)
            androidx.lifecycle.MutableLiveData r11 = r11._mCurFastRecordLiveData
            r11.postValue(r0)
        L_0x0087:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.ui.viewmodel.recording.FastRecordDetailRecordIngViewModel$queryRecordAndUpdate$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordDetailRecordIngViewModel$queryRecordAndUpdate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
