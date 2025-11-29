package com.upuphone.ar.fastrecord.phone.ui.viewmodel.history;

import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.fastrecord.phone.db.FastRecordVoiceWordDao;
import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
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
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordHistoryAsrOperatorManager$addAsrTask$1", f = "FastRecordHistoryAsrOperatorManager.kt", i = {}, l = {31}, m = "invokeSuspend", n = {}, s = {})
public final class FastRecordHistoryAsrOperatorManager$addAsrTask$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ RecordEntity $recordEntity;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordHistoryAsrOperatorManager$addAsrTask$1(RecordEntity recordEntity, Continuation<? super FastRecordHistoryAsrOperatorManager$addAsrTask$1> continuation) {
        super(2, continuation);
        this.$recordEntity = recordEntity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordHistoryAsrOperatorManager$addAsrTask$1(this.$recordEntity, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FastRecordVoiceWordDao fastRecordVoiceWordDao = FastRecordManager.Companion.getInstance().fastRecordVoiceWordDao();
            long recordId = this.$recordEntity.getRecordId();
            this.label = 1;
            if (fastRecordVoiceWordDao.deleteByRecordId(recordId, this) == coroutine_suspended) {
                return coroutine_suspended;
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
        return ((FastRecordHistoryAsrOperatorManager$addAsrTask$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
