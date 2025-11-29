package com.upuphone.ar.fastrecord.phone.ui.activity;

import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordHistoryAsrOperatorManager;
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
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordHistoryDetailActivity$reStartAsr$1", f = "FastRecordHistoryDetailActivity.kt", i = {}, l = {162}, m = "invokeSuspend", n = {}, s = {})
public final class FastRecordHistoryDetailActivity$reStartAsr$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FastRecordHistoryDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordHistoryDetailActivity$reStartAsr$1(FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity, Continuation<? super FastRecordHistoryDetailActivity$reStartAsr$1> continuation) {
        super(2, continuation);
        this.this$0 = fastRecordHistoryDetailActivity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordHistoryDetailActivity$reStartAsr$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.b(1000, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        RecordEntity curRecordEntity = this.this$0.getViewModel().getCurRecordEntity();
        if (curRecordEntity != null) {
            FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity = this.this$0;
            LogExt.logE("restart restart,entity info = " + curRecordEntity, "FastRecordHistoryDetailActivity");
            FastRecordHistoryAsrOperatorManager.INSTANCE.restart(curRecordEntity, fastRecordHistoryDetailActivity.asrCallbackInterface);
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordHistoryDetailActivity$reStartAsr$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
