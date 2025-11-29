package io.netty.channel.kqueue;

import io.netty.channel.ChannelOption;
import io.netty.channel.unix.UnixChannelOption;

public final class KQueueChannelOption<T> extends UnixChannelOption<T> {
    public static final ChannelOption<Boolean> RCV_ALLOC_TRANSPORT_PROVIDES_GUESS;
    public static final ChannelOption<AcceptFilter> SO_ACCEPTFILTER;
    public static final ChannelOption<Integer> SO_SNDLOWAT;
    public static final ChannelOption<Boolean> TCP_NOPUSH;

    static {
        Class<KQueueChannelOption> cls = KQueueChannelOption.class;
        SO_SNDLOWAT = ChannelOption.valueOf(cls, "SO_SNDLOWAT");
        TCP_NOPUSH = ChannelOption.valueOf(cls, "TCP_NOPUSH");
        SO_ACCEPTFILTER = ChannelOption.valueOf(cls, "SO_ACCEPTFILTER");
        RCV_ALLOC_TRANSPORT_PROVIDES_GUESS = ChannelOption.valueOf(cls, "RCV_ALLOC_TRANSPORT_PROVIDES_GUESS");
    }

    private KQueueChannelOption() {
    }
}
