package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import com.upuphone.star.core.log.ULog;
import com.xjsd.ai.assistant.common.data.DataStoreUtils;
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
@DebugMetadata(c = "com.upuphone.xr.sapp.fragment.HearingAssistFragment$getOrigainStatus$1", f = "HearingAssistFragment.kt", i = {1}, l = {84, 86}, m = "invokeSuspend", n = {"isChatGptTTSPlay"}, s = {"Z$0"})
public final class HearingAssistFragment$getOrigainStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    boolean Z$0;
    int label;
    final /* synthetic */ HearingAssistFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HearingAssistFragment$getOrigainStatus$1(HearingAssistFragment hearingAssistFragment, Continuation<? super HearingAssistFragment$getOrigainStatus$1> continuation) {
        super(2, continuation);
        this.this$0 = hearingAssistFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new HearingAssistFragment$getOrigainStatus$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        boolean z;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            DataStoreUtils dataStoreUtils = DataStoreUtils.f8415a;
            Context m0 = this.this$0.m0();
            this.label = 1;
            obj = dataStoreUtils.l(m0, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            z = this.Z$0;
            ResultKt.throwOnFailure(obj);
            boolean booleanValue = ((Boolean) obj).booleanValue();
            ULog.Delegate delegate = ULog.f6446a;
            delegate.g("HearingAssistFragment", "getOrigainStatus  isChatGptTTSPlay=" + z + " isChatGptCardDisplay=" + booleanValue);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        boolean booleanValue2 = ((Boolean) obj).booleanValue();
        DataStoreUtils dataStoreUtils2 = DataStoreUtils.f8415a;
        Context m02 = this.this$0.m0();
        this.Z$0 = booleanValue2;
        this.label = 2;
        Object k = dataStoreUtils2.k(m02, this);
        if (k == coroutine_suspended) {
            return coroutine_suspended;
        }
        boolean z2 = booleanValue2;
        obj = k;
        z = z2;
        boolean booleanValue3 = ((Boolean) obj).booleanValue();
        ULog.Delegate delegate2 = ULog.f6446a;
        delegate2.g("HearingAssistFragment", "getOrigainStatus  isChatGptTTSPlay=" + z + " isChatGptCardDisplay=" + booleanValue3);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((HearingAssistFragment$getOrigainStatus$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
