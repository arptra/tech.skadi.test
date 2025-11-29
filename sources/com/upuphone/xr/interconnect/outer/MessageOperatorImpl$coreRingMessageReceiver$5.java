package com.upuphone.xr.interconnect.outer;

import com.upuphone.xr.interconnect.common.IMessageTransport;
import com.upuphone.xr.interconnect.common.IRingMessageReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public /* synthetic */ class MessageOperatorImpl$coreRingMessageReceiver$5 extends FunctionReferenceImpl implements Function2<IMessageTransport, IRingMessageReceiver, Unit> {
    public static final MessageOperatorImpl$coreRingMessageReceiver$5 INSTANCE = new MessageOperatorImpl$coreRingMessageReceiver$5();

    public MessageOperatorImpl$coreRingMessageReceiver$5() {
        super(2, IMessageTransport.class, "unregisterRingMessageReceiver", "unregisterRingMessageReceiver(Lcom/upuphone/xr/interconnect/common/IRingMessageReceiver;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((IMessageTransport) obj, (IRingMessageReceiver) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull IMessageTransport iMessageTransport, IRingMessageReceiver iRingMessageReceiver) {
        Intrinsics.checkNotNullParameter(iMessageTransport, "p0");
        iMessageTransport.unregisterRingMessageReceiver(iRingMessageReceiver);
    }
}
