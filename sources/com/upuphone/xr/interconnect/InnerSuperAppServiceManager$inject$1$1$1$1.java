package com.upuphone.xr.interconnect;

import com.upuphone.xr.interconnect.api.OperatorManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/upuphone/xr/interconnect/OperatorManagerCreateCallback;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class InnerSuperAppServiceManager$inject$1$1$1$1 extends Lambda implements Function1<OperatorManagerCreateCallback, Unit> {
    final /* synthetic */ OperatorManager $instance;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InnerSuperAppServiceManager$inject$1$1$1$1(OperatorManager operatorManager) {
        super(1);
        this.$instance = operatorManager;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((OperatorManagerCreateCallback) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull OperatorManagerCreateCallback operatorManagerCreateCallback) {
        Intrinsics.checkNotNullParameter(operatorManagerCreateCallback, "$this$threadSafeAlienCall");
        OperatorManager operatorManager = this.$instance;
        Intrinsics.checkNotNullExpressionValue(operatorManager, "instance");
        operatorManagerCreateCallback.onOperatorManagerCreated(operatorManager);
    }
}
