package com.upuphone.ar.fastrecord.phone.ui.viewmodel;

import com.upuphone.ar.fastrecord.phone.http.HttpRequestManger;
import com.xjsd.xr.sapp.asr.dao.SensitivePayload;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordSummaryViewModel$startAiSummaryTask$1$1$onSummarySensitive$1", f = "FastRecordSummaryViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FastRecordSummaryViewModel$startAiSummaryTask$1$1$onSummarySensitive$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SensitivePayload $sensitive;
    int label;
    final /* synthetic */ FastRecordSummaryViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordSummaryViewModel$startAiSummaryTask$1$1$onSummarySensitive$1(SensitivePayload sensitivePayload, FastRecordSummaryViewModel fastRecordSummaryViewModel, Continuation<? super FastRecordSummaryViewModel$startAiSummaryTask$1$1$onSummarySensitive$1> continuation) {
        super(2, continuation);
        this.$sensitive = sensitivePayload;
        this.this$0 = fastRecordSummaryViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordSummaryViewModel$startAiSummaryTask$1$1$onSummarySensitive$1(this.$sensitive, this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            SensitivePayload sensitivePayload = this.$sensitive;
            if (sensitivePayload == null) {
                this.this$0._mSummaryResult.postValue(Boxing.boxInt(2));
                return Unit.INSTANCE;
            }
            if (Intrinsics.areEqual((Object) sensitivePayload.getRiskLevel(), (Object) "LOCKED")) {
                this.this$0._mSummaryLockedLiveData.postValue(this.$sensitive.getRiskDescription());
            } else if (HttpRequestManger.INSTANCE.isRequestSensitive(this.$sensitive.getSensitiveType())) {
                this.this$0._mSummarySensitiveLiveData.postValue(this.$sensitive.getSensitiveType());
            } else {
                this.this$0._mSummaryResult.postValue(Boxing.boxInt(2));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordSummaryViewModel$startAiSummaryTask$1$1$onSummarySensitive$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
