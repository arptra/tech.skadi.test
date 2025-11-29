package com.upuphone.xr.interconnect.business.messenger;

import com.upuphone.xr.interconnect.common.IMessageSendListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/upuphone/xr/interconnect/common/IMessageSendListener;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class MessageTxProcessor$2$result$1$1$onFailure$1 extends Lambda implements Function1<IMessageSendListener, Unit> {
    final /* synthetic */ int $code;
    final /* synthetic */ int $identifier;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MessageTxProcessor$2$result$1$1$onFailure$1(int i, int i2) {
        super(1);
        this.$identifier = i;
        this.$code = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((IMessageSendListener) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull IMessageSendListener iMessageSendListener) {
        Intrinsics.checkNotNullParameter(iMessageSendListener, "$this$safeCall");
        iMessageSendListener.onFail(String.valueOf(this.$identifier), this.$code);
    }
}
