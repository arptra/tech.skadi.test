package io.netty.channel.rxtx;

import io.netty.channel.ChannelOption;
import io.netty.channel.rxtx.RxtxChannelConfig;

@Deprecated
public final class RxtxChannelOption<T> extends ChannelOption<T> {
    public static final ChannelOption<Integer> BAUD_RATE;
    public static final ChannelOption<RxtxChannelConfig.Databits> DATA_BITS;
    public static final ChannelOption<Boolean> DTR;
    public static final ChannelOption<RxtxChannelConfig.Paritybit> PARITY_BIT;
    public static final ChannelOption<Integer> READ_TIMEOUT;
    public static final ChannelOption<Boolean> RTS;
    public static final ChannelOption<RxtxChannelConfig.Stopbits> STOP_BITS;
    public static final ChannelOption<Integer> WAIT_TIME;

    static {
        Class<RxtxChannelOption> cls = RxtxChannelOption.class;
        BAUD_RATE = ChannelOption.valueOf(cls, "BAUD_RATE");
        DTR = ChannelOption.valueOf(cls, "DTR");
        RTS = ChannelOption.valueOf(cls, "RTS");
        STOP_BITS = ChannelOption.valueOf(cls, "STOP_BITS");
        DATA_BITS = ChannelOption.valueOf(cls, "DATA_BITS");
        PARITY_BIT = ChannelOption.valueOf(cls, "PARITY_BIT");
        WAIT_TIME = ChannelOption.valueOf(cls, "WAIT_TIME");
        READ_TIMEOUT = ChannelOption.valueOf(cls, "READ_TIMEOUT");
    }

    private RxtxChannelOption() {
        super((String) null);
    }
}
