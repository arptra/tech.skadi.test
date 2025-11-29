package com.upuphone.ar.fastrecord.phone.utils;

import com.upuphone.ar.fastrecord.phone.datatrack.FastRecordDataTrackManager;
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
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.utils.RecordVoiceMergeUtil$mergePhoneVoice$1", f = "RecordVoiceMergeUtil.kt", i = {}, l = {128}, m = "invokeSuspend", n = {}, s = {})
public final class RecordVoiceMergeUtil$mergePhoneVoice$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $needShoWTip;
    final /* synthetic */ RecordEntity $record;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecordVoiceMergeUtil$mergePhoneVoice$1(RecordEntity recordEntity, boolean z, Continuation<? super RecordVoiceMergeUtil$mergePhoneVoice$1> continuation) {
        super(2, continuation);
        this.$record = recordEntity;
        this.$needShoWTip = z;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RecordVoiceMergeUtil$mergePhoneVoice$1(this.$record, this.$needShoWTip, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            RecordVoiceMergeUtil recordVoiceMergeUtil = RecordVoiceMergeUtil.INSTANCE;
            RecordEntity recordEntity = this.$record;
            boolean z = this.$needShoWTip;
            this.label = 1;
            if (recordVoiceMergeUtil.commandMergePhoneVoice(recordEntity, z, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        RecordVoiceMergeUtil.INSTANCE.commandMergeVoiceCallBack(this.$record);
        FastRecordDataTrackManager.reportRecordingDataTrack(this.$record.getTotalTime(), this.$record.getRecordId());
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RecordVoiceMergeUtil$mergePhoneVoice$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
