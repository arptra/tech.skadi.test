package com.upuphone.ar.fastrecord.phone.ui.viewmodel;

import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.fastrecord.phone.db.FastRecordDao;
import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordAppViewModel$getRecordIngItem$1", f = "FastRecordAppViewModel.kt", i = {}, l = {114}, m = "invokeSuspend", n = {}, s = {})
public final class FastRecordAppViewModel$getRecordIngItem$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<RecordEntity, Unit> $callBack;
    final /* synthetic */ long $recordingItemId;
    int label;
    final /* synthetic */ FastRecordAppViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordAppViewModel$getRecordIngItem$1(long j, FastRecordAppViewModel fastRecordAppViewModel, Function1<? super RecordEntity, Unit> function1, Continuation<? super FastRecordAppViewModel$getRecordIngItem$1> continuation) {
        super(2, continuation);
        this.$recordingItemId = j;
        this.this$0 = fastRecordAppViewModel;
        this.$callBack = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordAppViewModel$getRecordIngItem$1(this.$recordingItemId, this.this$0, this.$callBack, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FastRecordDao fastRecordDao = FastRecordManager.Companion.getInstance().fastRecordDao();
            long j = this.$recordingItemId;
            this.label = 1;
            obj = FastRecordDao.DefaultImpls.findRecordEntityById$default(fastRecordDao, j, (String) null, this, 2, (Object) null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        RecordEntity recordEntity = (RecordEntity) obj;
        if (recordEntity != null) {
            recordEntity.setRecordStatus(this.this$0.getRecordIngState());
        }
        this.$callBack.invoke(recordEntity);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordAppViewModel$getRecordIngItem$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
