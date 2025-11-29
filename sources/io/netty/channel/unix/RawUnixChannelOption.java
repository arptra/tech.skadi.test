package io.netty.channel.unix;

import io.netty.util.internal.ObjectUtil;
import java.nio.ByteBuffer;

public final class RawUnixChannelOption extends GenericUnixChannelOption<ByteBuffer> {
    private final int length;

    public RawUnixChannelOption(String str, int i, int i2, int i3) {
        super(str, i, i2);
        this.length = ObjectUtil.checkPositive(i3, "length");
    }

    public int length() {
        return this.length;
    }

    public void validate(ByteBuffer byteBuffer) {
        super.validate(byteBuffer);
        if (byteBuffer.remaining() != this.length) {
            throw new IllegalArgumentException("Length of value does not match. Expected " + this.length + ", but got " + byteBuffer.remaining());
        }
    }
}
