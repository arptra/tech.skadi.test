package com.upuphone.ar.fastrecord.phone.utils;

import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.fastrecord.phone.db.FastRecordDao;
import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import com.upuphone.ar.fastrecord.phone.starrynet.bean.glass.RecordGlassStatus;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.utils.RecordDataSaveUtil$saveRecordData$1", f = "RecordDataSaveUtil.kt", i = {}, l = {271}, m = "invokeSuspend", n = {}, s = {})
public final class RecordDataSaveUtil$saveRecordData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Integer, Unit> $callback;
    final /* synthetic */ RecordEntity $mRecordEntity;
    final /* synthetic */ RecordGlassStatus $mRecordGlassStatus;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecordDataSaveUtil$saveRecordData$1(RecordEntity recordEntity, Function1<? super Integer, Unit> function1, RecordGlassStatus recordGlassStatus, Continuation<? super RecordDataSaveUtil$saveRecordData$1> continuation) {
        super(2, continuation);
        this.$mRecordEntity = recordEntity;
        this.$callback = function1;
        this.$mRecordGlassStatus = recordGlassStatus;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RecordDataSaveUtil$saveRecordData$1(this.$mRecordEntity, this.$callback, this.$mRecordGlassStatus, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FastRecordDao fastRecordDao = FastRecordManager.Companion.getInstance().fastRecordDao();
            RecordEntity recordEntity = this.$mRecordEntity;
            this.label = 1;
            if (fastRecordDao.insert(recordEntity, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.$callback.invoke(Boxing.boxInt(this.$mRecordGlassStatus.getState()));
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RecordDataSaveUtil$saveRecordData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
