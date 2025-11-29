package io.netty.channel.socket.nio;

import io.netty.channel.ChannelException;
import io.netty.channel.ChannelOption;
import io.netty.util.internal.SuppressJava6Requirement;
import java.io.IOException;
import java.net.SocketOption;
import java.net.StandardSocketOptions;
import java.nio.channels.Channel;
import java.nio.channels.NetworkChannel;
import java.nio.channels.ServerSocketChannel;
import java.util.ArrayList;
import java.util.Set;

@SuppressJava6Requirement(reason = "Usage explicit by the user")
public final class NioChannelOption<T> extends ChannelOption<T> {
    private final SocketOption<T> option;

    private NioChannelOption(SocketOption<T> socketOption) {
        super(socketOption.name());
        this.option = socketOption;
    }

    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public static <T> T getOption(Channel channel, NioChannelOption<T> nioChannelOption) {
        NetworkChannel networkChannel = (NetworkChannel) channel;
        if (!networkChannel.supportedOptions().contains(nioChannelOption.option)) {
            return null;
        }
        if ((networkChannel instanceof ServerSocketChannel) && nioChannelOption.option == StandardSocketOptions.IP_TOS) {
            return null;
        }
        try {
            return networkChannel.getOption(nioChannelOption.option);
        } catch (IOException e) {
            throw new ChannelException((Throwable) e);
        }
    }

    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public static ChannelOption[] getOptions(Channel channel) {
        NetworkChannel networkChannel = (NetworkChannel) channel;
        Set<SocketOption<?>> supportedOptions = networkChannel.supportedOptions();
        int i = 0;
        if (networkChannel instanceof ServerSocketChannel) {
            ArrayList arrayList = new ArrayList(supportedOptions.size());
            for (SocketOption next : supportedOptions) {
                if (next != StandardSocketOptions.IP_TOS) {
                    arrayList.add(new NioChannelOption(next));
                }
            }
            return (ChannelOption[]) arrayList.toArray(new ChannelOption[0]);
        }
        ChannelOption[] channelOptionArr = new ChannelOption[supportedOptions.size()];
        for (SocketOption<?> nioChannelOption : supportedOptions) {
            channelOptionArr[i] = new NioChannelOption(nioChannelOption);
            i++;
        }
        return channelOptionArr;
    }

    public static <T> ChannelOption<T> of(SocketOption<T> socketOption) {
        return new NioChannelOption(socketOption);
    }

    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public static <T> boolean setOption(Channel channel, NioChannelOption<T> nioChannelOption, T t) {
        NetworkChannel networkChannel = (NetworkChannel) channel;
        if (!networkChannel.supportedOptions().contains(nioChannelOption.option)) {
            return false;
        }
        if ((networkChannel instanceof ServerSocketChannel) && nioChannelOption.option == StandardSocketOptions.IP_TOS) {
            return false;
        }
        try {
            networkChannel.setOption(nioChannelOption.option, t);
            return true;
        } catch (IOException e) {
            throw new ChannelException((Throwable) e);
        }
    }
}
