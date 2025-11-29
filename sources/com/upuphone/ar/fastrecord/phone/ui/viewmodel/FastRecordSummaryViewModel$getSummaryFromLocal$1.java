package com.upuphone.ar.fastrecord.phone.ui.viewmodel;

import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.fastrecord.phone.db.FastRecordSummaryDao;
import com.upuphone.ar.fastrecord.phone.db.RecordSummaryEntity;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.bean.SummaryRequestBean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordSummaryViewModel$getSummaryFromLocal$1", f = "FastRecordSummaryViewModel.kt", i = {1}, l = {227, 236}, m = "invokeSuspend", n = {"mRecordSummaryEntity"}, s = {"L$1"})
public final class FastRecordSummaryViewModel$getSummaryFromLocal$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ FastRecordSummaryViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordSummaryViewModel$getSummaryFromLocal$1(FastRecordSummaryViewModel fastRecordSummaryViewModel, Continuation<? super FastRecordSummaryViewModel$getSummaryFromLocal$1> continuation) {
        super(2, continuation);
        this.this$0 = fastRecordSummaryViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordSummaryViewModel$getSummaryFromLocal$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        RecordSummaryEntity recordSummaryEntity;
        FastRecordSummaryViewModel fastRecordSummaryViewModel;
        FastRecordSummaryViewModel fastRecordSummaryViewModel2;
        RecordSummaryEntity recordSummaryEntity2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SummaryRequestBean requestBean = this.this$0.getRequestBean();
            if (requestBean != null) {
                fastRecordSummaryViewModel = this.this$0;
                FastRecordSummaryDao fastRecordSummaryDao = FastRecordManager.Companion.getInstance().fastRecordSummaryDao();
                Long recordId = requestBean.getRecordId();
                Intrinsics.checkNotNullExpressionValue(recordId, "getRecordId(...)");
                long longValue = recordId.longValue();
                this.L$0 = fastRecordSummaryViewModel;
                this.label = 1;
                obj = FastRecordSummaryDao.DefaultImpls.queryNoFinishByRecordId$default(fastRecordSummaryDao, longValue, false, this, 2, (Object) null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        } else if (i == 1) {
            fastRecordSummaryViewModel = (FastRecordSummaryViewModel) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            recordSummaryEntity2 = (RecordSummaryEntity) this.L$1;
            fastRecordSummaryViewModel2 = (FastRecordSummaryViewModel) this.L$0;
            ResultKt.throwOnFailure(obj);
            fastRecordSummaryViewModel = fastRecordSummaryViewModel2;
            recordSummaryEntity = recordSummaryEntity2;
            LogExt.logE("getSummaryFromLocal mRecordSummaryEntity after change data = " + recordSummaryEntity, "SummaryViewModel");
            fastRecordSummaryViewModel._mSummaryLiveData.postValue(recordSummaryEntity);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        recordSummaryEntity = (RecordSummaryEntity) obj;
        LogExt.logE("getSummaryFromLocal mRecordSummaryEntity is = " + recordSummaryEntity, "SummaryViewModel");
        if (recordSummaryEntity != null && recordSummaryEntity.isFinishDel()) {
            recordSummaryEntity.setContentTemp(recordSummaryEntity.getContent());
            recordSummaryEntity.setFinishDel(false);
            FastRecordSummaryDao fastRecordSummaryDao2 = FastRecordManager.Companion.getInstance().fastRecordSummaryDao();
            this.L$0 = fastRecordSummaryViewModel;
            this.L$1 = recordSummaryEntity;
            this.label = 2;
            if (fastRecordSummaryDao2.update(recordSummaryEntity, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            recordSummaryEntity2 = recordSummaryEntity;
            fastRecordSummaryViewModel2 = fastRecordSummaryViewModel;
            fastRecordSummaryViewModel = fastRecordSummaryViewModel2;
            recordSummaryEntity = recordSummaryEntity2;
        }
        LogExt.logE("getSummaryFromLocal mRecordSummaryEntity after change data = " + recordSummaryEntity, "SummaryViewModel");
        fastRecordSummaryViewModel._mSummaryLiveData.postValue(recordSummaryEntity);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordSummaryViewModel$getSummaryFromLocal$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
