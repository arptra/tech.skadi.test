package io.netty.channel.udt;

import io.netty.channel.ChannelOption;

@Deprecated
public final class UdtChannelOption<T> extends ChannelOption<T> {
    public static final ChannelOption<Integer> PROTOCOL_RECEIVE_BUFFER_SIZE;
    public static final ChannelOption<Integer> PROTOCOL_SEND_BUFFER_SIZE;
    public static final ChannelOption<Integer> SYSTEM_RECEIVE_BUFFER_SIZE;
    public static final ChannelOption<Integer> SYSTEM_SEND_BUFFER_SIZE;

    static {
        Class<UdtChannelOption> cls = UdtChannelOption.class;
        PROTOCOL_RECEIVE_BUFFER_SIZE = ChannelOption.valueOf(cls, "PROTOCOL_RECEIVE_BUFFER_SIZE");
        PROTOCOL_SEND_BUFFER_SIZE = ChannelOption.valueOf(cls, "PROTOCOL_SEND_BUFFER_SIZE");
        SYSTEM_RECEIVE_BUFFER_SIZE = ChannelOption.valueOf(cls, "SYSTEM_RECEIVE_BUFFER_SIZE");
        SYSTEM_SEND_BUFFER_SIZE = ChannelOption.valueOf(cls, "SYSTEM_SEND_BUFFER_SIZE");
    }

    private UdtChannelOption() {
        super((String) null);
    }
}
