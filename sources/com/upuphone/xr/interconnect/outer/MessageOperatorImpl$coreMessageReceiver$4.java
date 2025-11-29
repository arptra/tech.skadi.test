package com.upuphone.xr.interconnect.outer;

import com.upuphone.xr.interconnect.common.IMessageReceiver;
import com.upuphone.xr.interconnect.common.IMessageTransport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public /* synthetic */ class MessageOperatorImpl$coreMessageReceiver$4 extends FunctionReferenceImpl implements Function2<IMessageTransport, IMessageReceiver, Unit> {
    public static final MessageOperatorImpl$coreMessageReceiver$4 INSTANCE = new MessageOperatorImpl$coreMessageReceiver$4();

    public MessageOperatorImpl$coreMessageReceiver$4() {
        super(2, IMessageTransport.class, "registerMessageReceiver", "registerMessageReceiver(Lcom/upuphone/xr/interconnect/common/IMessageReceiver;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((IMessageTransport) obj, (IMessageReceiver) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull IMessageTransport iMessageTransport, IMessageReceiver iMessageReceiver) {
        Intrinsics.checkNotNullParameter(iMessageTransport, "p0");
        iMessageTransport.registerMessageReceiver(iMessageReceiver);
    }
}
