package com.upuphone.ar.fastrecord.phone.ui.viewmodel.history;

import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.fastrecord.phone.db.FastRecordDao;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.xjsd.xr.sapp.asr.dao.ResultExt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordHistoryAsrOperator$saveRecordIngDataShortHandContent$1", f = "FastRecordHistoryAsrOperator.kt", i = {}, l = {842}, m = "invokeSuspend", n = {}, s = {})
public final class FastRecordHistoryAsrOperator$saveRecordIngDataShortHandContent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ResultExt $mResultExt;
    int label;
    final /* synthetic */ FastRecordHistoryAsrOperator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordHistoryAsrOperator$saveRecordIngDataShortHandContent$1(FastRecordHistoryAsrOperator fastRecordHistoryAsrOperator, ResultExt resultExt, Continuation<? super FastRecordHistoryAsrOperator$saveRecordIngDataShortHandContent$1> continuation) {
        super(2, continuation);
        this.this$0 = fastRecordHistoryAsrOperator;
        this.$mResultExt = resultExt;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordHistoryAsrOperator$saveRecordIngDataShortHandContent$1(this.this$0, this.$mResultExt, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            long access$getMRecordId$p = this.this$0.mRecordId;
            ResultExt resultExt = this.$mResultExt;
            LogExt.logW("update record content recordInfo.recordId = " + access$getMRecordId$p + ",mResultExt = " + resultExt, FastRecordHistoryAsrOperator.TAG);
            ResultExt resultExt2 = this.$mResultExt;
            if (resultExt2 != null) {
                FastRecordHistoryAsrOperator fastRecordHistoryAsrOperator = this.this$0;
                FastRecordDao fastRecordDao = FastRecordManager.Companion.getInstance().fastRecordDao();
                long access$getMRecordId$p2 = fastRecordHistoryAsrOperator.mRecordId;
                String requestId = resultExt2.getRequestId();
                String recognizeId = resultExt2.getRecognizeId();
                this.label = 1;
                if (fastRecordDao.updateRecordArsRequestInfo(access$getMRecordId$p2, requestId, recognizeId, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordHistoryAsrOperator$saveRecordIngDataShortHandContent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
