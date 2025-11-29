package com.upuphone.ar.fastrecord.phone.utils;

import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
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
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.utils.RecordDataSaveUtil$updateRecordEntityStatus$1", f = "RecordDataSaveUtil.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class RecordDataSaveUtil$updateRecordEntityStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $recordId;
    final /* synthetic */ int $status;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecordDataSaveUtil$updateRecordEntityStatus$1(long j, int i, Continuation<? super RecordDataSaveUtil$updateRecordEntityStatus$1> continuation) {
        super(2, continuation);
        this.$recordId = j;
        this.$status = i;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RecordDataSaveUtil$updateRecordEntityStatus$1(this.$recordId, this.$status, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            long j = this.$recordId;
            int i = this.$status;
            LogExt.logE("updateRecordEntityFinishStatus recordId = " + j + " status=" + i + ",change to finish", RecordDataSaveUtil.TAG);
            FastRecordManager.Companion.getInstance().fastRecordDao().updateRecordIngState(this.$recordId, this.$status);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RecordDataSaveUtil$updateRecordEntityStatus$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
