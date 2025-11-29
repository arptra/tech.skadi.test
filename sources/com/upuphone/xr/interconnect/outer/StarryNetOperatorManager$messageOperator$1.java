package com.upuphone.xr.interconnect.outer;

import com.upuphone.xr.interconnect.common.IMessageTransport;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/upuphone/xr/interconnect/common/IMessageTransport;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class StarryNetOperatorManager$messageOperator$1 extends Lambda implements Function0<IMessageTransport> {
    final /* synthetic */ StarryNetOperatorManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StarryNetOperatorManager$messageOperator$1(StarryNetOperatorManager starryNetOperatorManager) {
        super(0);
        this.this$0 = starryNetOperatorManager;
    }

    @Nullable
    public final IMessageTransport invoke() {
        return this.this$0.provider.getMessageTransporter();
    }
}
