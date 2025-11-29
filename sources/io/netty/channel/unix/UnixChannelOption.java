package io.netty.channel.unix;

import io.netty.channel.ChannelOption;

public class UnixChannelOption<T> extends ChannelOption<T> {
    public static final ChannelOption<DomainSocketReadMode> DOMAIN_SOCKET_READ_MODE;
    public static final ChannelOption<Boolean> SO_REUSEPORT;

    static {
        Class<UnixChannelOption> cls = UnixChannelOption.class;
        SO_REUSEPORT = ChannelOption.valueOf(cls, "SO_REUSEPORT");
        DOMAIN_SOCKET_READ_MODE = ChannelOption.valueOf(cls, "DOMAIN_SOCKET_READ_MODE");
    }

    public UnixChannelOption() {
        super((String) null);
    }

    public UnixChannelOption(String str) {
        super(str);
    }
}
