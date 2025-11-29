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
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordSummaryViewModel$updateSummary$1", f = "FastRecordSummaryViewModel.kt", i = {}, l = {173, 178}, m = "invokeSuspend", n = {}, s = {})
public final class FastRecordSummaryViewModel$updateSummary$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $summary;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ FastRecordSummaryViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordSummaryViewModel$updateSummary$1(FastRecordSummaryViewModel fastRecordSummaryViewModel, String str, Continuation<? super FastRecordSummaryViewModel$updateSummary$1> continuation) {
        super(2, continuation);
        this.this$0 = fastRecordSummaryViewModel;
        this.$summary = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordSummaryViewModel$updateSummary$1(this.this$0, this.$summary, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        FastRecordSummaryViewModel fastRecordSummaryViewModel;
        FastRecordSummaryViewModel fastRecordSummaryViewModel2;
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SummaryRequestBean requestBean = this.this$0.getRequestBean();
            if (requestBean != null) {
                String str2 = this.$summary;
                FastRecordSummaryViewModel fastRecordSummaryViewModel3 = this.this$0;
                if (str2 == null || str2.length() == 0) {
                    LogExt.logE("updateSummary summary is null or empty.", "SummaryViewModel");
                    FastRecordSummaryDao fastRecordSummaryDao = FastRecordManager.Companion.getInstance().fastRecordSummaryDao();
                    Long recordId = requestBean.getRecordId();
                    Intrinsics.checkNotNullExpressionValue(recordId, "getRecordId(...)");
                    fastRecordSummaryDao.updateFinishDelState(recordId.longValue(), true, false);
                } else {
                    FastRecordSummaryDao fastRecordSummaryDao2 = FastRecordManager.Companion.getInstance().fastRecordSummaryDao();
                    Long recordId2 = requestBean.getRecordId();
                    Intrinsics.checkNotNullExpressionValue(recordId2, "getRecordId(...)");
                    long longValue = recordId2.longValue();
                    this.L$0 = str2;
                    this.L$1 = fastRecordSummaryViewModel3;
                    this.label = 1;
                    obj = fastRecordSummaryDao2.queryByRecordId(longValue, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str = str2;
                    fastRecordSummaryViewModel = fastRecordSummaryViewModel3;
                }
            }
            return Unit.INSTANCE;
        } else if (i == 1) {
            fastRecordSummaryViewModel = (FastRecordSummaryViewModel) this.L$1;
            str = (String) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            fastRecordSummaryViewModel2 = (FastRecordSummaryViewModel) this.L$0;
            ResultKt.throwOnFailure(obj);
            fastRecordSummaryViewModel = fastRecordSummaryViewModel2;
            fastRecordSummaryViewModel.getSummaryFromLocal();
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        RecordSummaryEntity recordSummaryEntity = (RecordSummaryEntity) obj;
        if (recordSummaryEntity != null) {
            LogExt.logE("updateSummary summary = " + str, "SummaryViewModel");
            recordSummaryEntity.setContentTemp(StringsKt.trim((CharSequence) str).toString());
            FastRecordSummaryDao fastRecordSummaryDao3 = FastRecordManager.Companion.getInstance().fastRecordSummaryDao();
            this.L$0 = fastRecordSummaryViewModel;
            this.L$1 = null;
            this.label = 2;
            if (fastRecordSummaryDao3.update(recordSummaryEntity, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            fastRecordSummaryViewModel2 = fastRecordSummaryViewModel;
            fastRecordSummaryViewModel = fastRecordSummaryViewModel2;
        }
        fastRecordSummaryViewModel.getSummaryFromLocal();
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordSummaryViewModel$updateSummary$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
