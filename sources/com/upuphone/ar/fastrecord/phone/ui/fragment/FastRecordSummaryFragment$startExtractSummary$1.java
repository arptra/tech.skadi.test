package com.upuphone.ar.fastrecord.phone.ui.fragment;

import androidx.lifecycle.LifecycleOwnerKt;
import com.upuphone.ar.fastrecord.phone.starrynet.RecordConnectManager;
import com.upuphone.xr.interconnect.common.IAIModelResult;
import com.upuphone.xr.interconnect.entity.AIModelResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.fragment.FastRecordSummaryFragment$startExtractSummary$1", f = "FastRecordSummaryFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FastRecordSummaryFragment$startExtractSummary$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FastRecordSummaryFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordSummaryFragment$startExtractSummary$1(FastRecordSummaryFragment fastRecordSummaryFragment, Continuation<? super FastRecordSummaryFragment$startExtractSummary$1> continuation) {
        super(2, continuation);
        this.this$0 = fastRecordSummaryFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordSummaryFragment$startExtractSummary$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            RecordConnectManager instance = RecordConnectManager.Companion.getInstance();
            final FastRecordSummaryFragment fastRecordSummaryFragment = this.this$0;
            instance.requestAIState(new IAIModelResult.Stub() {
                public void aiResult(@Nullable AIModelResult aIModelResult) {
                    Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(fastRecordSummaryFragment), (CoroutineContext) null, (CoroutineStart) null, new FastRecordSummaryFragment$startExtractSummary$1$1$aiResult$1(aIModelResult, fastRecordSummaryFragment, (Continuation<? super FastRecordSummaryFragment$startExtractSummary$1$1$aiResult$1>) null), 3, (Object) null);
                }
            });
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordSummaryFragment$startExtractSummary$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
