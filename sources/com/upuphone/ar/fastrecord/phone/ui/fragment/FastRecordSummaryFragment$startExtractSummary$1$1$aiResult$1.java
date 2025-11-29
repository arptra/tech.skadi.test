package com.upuphone.ar.fastrecord.phone.ui.fragment;

import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.starrynet.RecordConnectManager;
import com.upuphone.xr.interconnect.entity.AIModelResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.fragment.FastRecordSummaryFragment$startExtractSummary$1$1$aiResult$1", f = "FastRecordSummaryFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FastRecordSummaryFragment$startExtractSummary$1$1$aiResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AIModelResult $result;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FastRecordSummaryFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordSummaryFragment$startExtractSummary$1$1$aiResult$1(AIModelResult aIModelResult, FastRecordSummaryFragment fastRecordSummaryFragment, Continuation<? super FastRecordSummaryFragment$startExtractSummary$1$1$aiResult$1> continuation) {
        super(2, continuation);
        this.$result = aIModelResult;
        this.this$0 = fastRecordSummaryFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FastRecordSummaryFragment$startExtractSummary$1$1$aiResult$1 fastRecordSummaryFragment$startExtractSummary$1$1$aiResult$1 = new FastRecordSummaryFragment$startExtractSummary$1$1$aiResult$1(this.$result, this.this$0, continuation);
        fastRecordSummaryFragment$startExtractSummary$1$1$aiResult$1.L$0 = obj;
        return fastRecordSummaryFragment$startExtractSummary$1$1$aiResult$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Unit unit;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            AIModelResult aIModelResult = this.$result;
            LogExt.logI("requestAIState result=" + aIModelResult + ", agreeType=1", "SummaryFragment");
            AIModelResult aIModelResult2 = this.$result;
            if (aIModelResult2 != null) {
                FastRecordSummaryFragment fastRecordSummaryFragment = this.this$0;
                if (Intrinsics.areEqual((Object) "1", (Object) String.valueOf(aIModelResult2.getState()))) {
                    fastRecordSummaryFragment.getExtractSummary();
                } else {
                    RecordConnectManager.Companion.getInstance().requestPermission();
                }
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                RecordConnectManager.Companion.getInstance().requestPermission();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordSummaryFragment$startExtractSummary$1$1$aiResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
