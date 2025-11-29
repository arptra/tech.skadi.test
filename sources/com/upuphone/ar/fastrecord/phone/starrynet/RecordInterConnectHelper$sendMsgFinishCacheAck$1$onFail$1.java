package com.upuphone.ar.fastrecord.phone.starrynet;

import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.starrynet.RecordInterConnectHelper$sendMsgFinishCacheAck$1$onFail$1", f = "RecordInterConnectHelper.kt", i = {}, l = {150}, m = "invokeSuspend", n = {}, s = {})
public final class RecordInterConnectHelper$sendMsgFinishCacheAck$1$onFail$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $msgId;
    final /* synthetic */ long $sendSize;
    int label;
    final /* synthetic */ RecordInterConnectHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecordInterConnectHelper$sendMsgFinishCacheAck$1$onFail$1(RecordInterConnectHelper recordInterConnectHelper, long j, long j2, Continuation<? super RecordInterConnectHelper$sendMsgFinishCacheAck$1$onFail$1> continuation) {
        super(2, continuation);
        this.this$0 = recordInterConnectHelper;
        this.$msgId = j;
        this.$sendSize = j2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RecordInterConnectHelper$sendMsgFinishCacheAck$1$onFail$1(this.this$0, this.$msgId, this.$sendSize, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.b(AssistantConstants.TIMEOUT_VAD_MUTE, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        LogExt.logE("delay sendMsgFinishCacheAck ", "FastRecordInterConnectHelper");
        this.this$0.sendMsgFinishCacheAck(this.$msgId, this.$sendSize, false);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RecordInterConnectHelper$sendMsgFinishCacheAck$1$onFail$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
