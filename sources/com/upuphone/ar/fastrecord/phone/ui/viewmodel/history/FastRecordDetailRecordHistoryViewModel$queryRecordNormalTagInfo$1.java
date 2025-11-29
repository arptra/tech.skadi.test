package com.upuphone.ar.fastrecord.phone.ui.viewmodel.history;

import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.fastrecord.phone.db.FastRecordPersonDao;
import com.upuphone.ar.fastrecord.phone.db.FastRecordTagDao;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import java.util.List;
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
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordDetailRecordHistoryViewModel$queryRecordNormalTagInfo$1", f = "FastRecordDetailRecordHistoryViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FastRecordDetailRecordHistoryViewModel$queryRecordNormalTagInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $recordId;
    int label;
    final /* synthetic */ FastRecordDetailRecordHistoryViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordDetailRecordHistoryViewModel$queryRecordNormalTagInfo$1(long j, FastRecordDetailRecordHistoryViewModel fastRecordDetailRecordHistoryViewModel, Continuation<? super FastRecordDetailRecordHistoryViewModel$queryRecordNormalTagInfo$1> continuation) {
        super(2, continuation);
        this.$recordId = j;
        this.this$0 = fastRecordDetailRecordHistoryViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordDetailRecordHistoryViewModel$queryRecordNormalTagInfo$1(this.$recordId, this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$recordId > 0) {
                FastRecordManager.Companion companion = FastRecordManager.Companion;
                List findNormalTagEntityByRecord$default = FastRecordTagDao.DefaultImpls.findNormalTagEntityByRecord$default(companion.getInstance().fastRecordTagDao(), this.$recordId, (String) null, 2, (Object) null);
                long j = this.$recordId;
                LogExt.logE("queryRecordInfo recordId = " + j + ",tagEntityList = " + findNormalTagEntityByRecord$default, "FastRecordDetailRecordHistoryViewModel");
                if (findNormalTagEntityByRecord$default != null) {
                    this.this$0._mCurRecordNormalContentTagEntityList.postValue(findNormalTagEntityByRecord$default);
                }
                List findAllNormalPersonByRecord$default = FastRecordPersonDao.DefaultImpls.findAllNormalPersonByRecord$default(companion.getInstance().fastRecordPersonDao(), this.$recordId, (String) null, 2, (Object) null);
                long j2 = this.$recordId;
                LogExt.logE("queryRecordInfo recordId = " + j2 + ",personEntityList = " + findAllNormalPersonByRecord$default, "FastRecordDetailRecordHistoryViewModel");
                if (findAllNormalPersonByRecord$default != null) {
                    this.this$0._mCurRecordNormalPersonTagEntityList.postValue(findAllNormalPersonByRecord$default);
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordDetailRecordHistoryViewModel$queryRecordNormalTagInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
