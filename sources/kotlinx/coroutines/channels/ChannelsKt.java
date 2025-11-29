package kotlinx.coroutines.channels;

import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"kotlinx/coroutines/channels/ChannelsKt__ChannelsKt", "kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt", "kotlinx/coroutines/channels/ChannelsKt__DeprecatedKt"}, k = 4, mv = {1, 8, 0}, xi = 48)
public final class ChannelsKt {
    public static final void b(ReceiveChannel receiveChannel, Throwable th) {
        ChannelsKt__Channels_commonKt.a(receiveChannel, th);
    }

    public static final Object s(ReceiveChannel receiveChannel, SendChannel sendChannel, Continuation continuation) {
        return ChannelsKt__DeprecatedKt.r(receiveChannel, sendChannel, continuation);
    }

    public static final Object t(ReceiveChannel receiveChannel, Collection collection, Continuation continuation) {
        return ChannelsKt__DeprecatedKt.s(receiveChannel, collection, continuation);
    }

    public static final Object u(ReceiveChannel receiveChannel, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.d(receiveChannel, continuation);
    }

    public static final Object v(ReceiveChannel receiveChannel, Map map, Continuation continuation) {
        return ChannelsKt__DeprecatedKt.t(receiveChannel, map, continuation);
    }

    public static final Object w(SendChannel sendChannel, Object obj) {
        return ChannelsKt__ChannelsKt.a(sendChannel, obj);
    }
}
