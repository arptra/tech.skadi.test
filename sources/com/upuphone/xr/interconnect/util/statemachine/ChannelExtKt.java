package com.upuphone.xr.interconnect.util.statemachine;

import android.util.Log;
import com.upuphone.xr.interconnect.util.log.PrettyPrintExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelResult;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"sendOrErr", "", "E", "Lkotlinx/coroutines/channels/Channel;", "event", "(Lkotlinx/coroutines/channels/Channel;Ljava/lang/Object;)V", "Shared_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ChannelExtKt {
    public static final <E> void sendOrErr(@NotNull Channel<E> channel, E e) {
        Intrinsics.checkNotNullParameter(channel, "<this>");
        if (ChannelResult.i(channel.q(e))) {
            Log.e("ChannelExt", "Failed inserting " + e + " into " + PrettyPrintExtKt.stringify(channel) + ", it's highly possible that event processing has stopped.");
        }
    }
}
