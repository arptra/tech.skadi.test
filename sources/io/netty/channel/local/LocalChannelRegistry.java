package io.netty.channel.local;

import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import java.net.SocketAddress;
import java.util.concurrent.ConcurrentMap;

final class LocalChannelRegistry {
    private static final ConcurrentMap<LocalAddress, Channel> boundChannels = PlatformDependent.newConcurrentHashMap();

    private LocalChannelRegistry() {
    }

    public static Channel get(SocketAddress socketAddress) {
        return boundChannels.get(socketAddress);
    }

    public static LocalAddress register(Channel channel, LocalAddress localAddress, SocketAddress socketAddress) {
        if (localAddress != null) {
            throw new ChannelException("already bound");
        } else if (socketAddress instanceof LocalAddress) {
            LocalAddress localAddress2 = (LocalAddress) socketAddress;
            if (LocalAddress.ANY.equals(localAddress2)) {
                localAddress2 = new LocalAddress(channel);
            }
            Channel putIfAbsent = boundChannels.putIfAbsent(localAddress2, channel);
            if (putIfAbsent == null) {
                return localAddress2;
            }
            throw new ChannelException("address already in use by: " + putIfAbsent);
        } else {
            throw new ChannelException("unsupported address type: " + StringUtil.simpleClassName((Object) socketAddress));
        }
    }

    public static void unregister(LocalAddress localAddress) {
        boundChannels.remove(localAddress);
    }
}
