package com.xjsd.ai.assistant.phone;

import com.xjsd.ai.assistant.log.ILog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "exception", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.ai.assistant.phone.SuperLiteStateMonitor$monitorNavPrivacyAgreementState$4", f = "SuperLiteStateMonitor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SuperLiteStateMonitor$monitorNavPrivacyAgreementState$4 extends SuspendLambda implements Function3<FlowCollector<? super Boolean>, Throwable, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;

    public SuperLiteStateMonitor$monitorNavPrivacyAgreementState$4(Continuation<? super SuperLiteStateMonitor$monitorNavPrivacyAgreementState$4> continuation) {
        super(3, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ILog.h("SuperLiteStateMonitor", "monitorNavPrivacyAgreementState: 读取异常", (Throwable) this.L$0);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super Boolean> flowCollector, @NotNull Throwable th, @Nullable Continuation<? super Unit> continuation) {
        SuperLiteStateMonitor$monitorNavPrivacyAgreementState$4 superLiteStateMonitor$monitorNavPrivacyAgreementState$4 = new SuperLiteStateMonitor$monitorNavPrivacyAgreementState$4(continuation);
        superLiteStateMonitor$monitorNavPrivacyAgreementState$4.L$0 = th;
        return superLiteStateMonitor$monitorNavPrivacyAgreementState$4.invokeSuspend(Unit.INSTANCE);
    }
}
