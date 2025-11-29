package io.netty.channel.unix;

public abstract class GenericUnixChannelOption<T> extends UnixChannelOption<T> {
    private final int level;
    private final int optname;

    public GenericUnixChannelOption(String str, int i, int i2) {
        super(str);
        this.level = i;
        this.optname = i2;
    }

    public int level() {
        return this.level;
    }

    public int optname() {
        return this.optname;
    }
}
