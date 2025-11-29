package com.upuphone.xr.interconnect.business.messenger;

import com.upuphone.xr.interconnect.common.IMessageReceiver;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/upuphone/xr/interconnect/common/IMessageReceiver;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class IpcMessageDispatcher$dispatch$2$2$1 extends Lambda implements Function1<IMessageReceiver, Unit> {
    final /* synthetic */ StarryNetMessage $message;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IpcMessageDispatcher$dispatch$2$2$1(StarryNetMessage starryNetMessage) {
        super(1);
        this.$message = starryNetMessage;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((IMessageReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull IMessageReceiver iMessageReceiver) {
        Intrinsics.checkNotNullParameter(iMessageReceiver, "$this$safeAlienCall");
        iMessageReceiver.onMessageReceive(this.$message);
    }
}
