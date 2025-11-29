package com.upuphone.ar.fastrecord.phone.ui.viewmodel.history;

import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.fastrecord.phone.db.FastRecordVoiceWordDao;
import com.upuphone.ar.fastrecord.phone.db.RecordVoiceWordEntity;
import java.util.ArrayList;
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
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordDetailRecordHistoryViewModel$delAllNotEmptyData$2", f = "FastRecordDetailRecordHistoryViewModel.kt", i = {}, l = {469}, m = "invokeSuspend", n = {}, s = {})
public final class FastRecordDetailRecordHistoryViewModel$delAllNotEmptyData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ArrayList<RecordVoiceWordEntity> $needDelList;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordDetailRecordHistoryViewModel$delAllNotEmptyData$2(ArrayList<RecordVoiceWordEntity> arrayList, Continuation<? super FastRecordDetailRecordHistoryViewModel$delAllNotEmptyData$2> continuation) {
        super(2, continuation);
        this.$needDelList = arrayList;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordDetailRecordHistoryViewModel$delAllNotEmptyData$2(this.$needDelList, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FastRecordVoiceWordDao fastRecordVoiceWordDao = FastRecordManager.Companion.getInstance().fastRecordVoiceWordDao();
            ArrayList<RecordVoiceWordEntity> arrayList = this.$needDelList;
            this.label = 1;
            if (fastRecordVoiceWordDao.deleteItems(arrayList, this) == coroutine_suspended) {
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
        return ((FastRecordDetailRecordHistoryViewModel$delAllNotEmptyData$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
