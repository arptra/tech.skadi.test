package io.netty.handler.codec.socks;

import io.netty.buffer.ByteBuf;
import io.netty.util.internal.ObjectUtil;

public abstract class SocksMessage {
    private final SocksProtocolVersion protocolVersion = SocksProtocolVersion.SOCKS5;
    private final SocksMessageType type;

    public SocksMessage(SocksMessageType socksMessageType) {
        this.type = (SocksMessageType) ObjectUtil.checkNotNull(socksMessageType, "type");
    }

    @Deprecated
    public abstract void encodeAsByteBuf(ByteBuf byteBuf);

    public SocksProtocolVersion protocolVersion() {
        return this.protocolVersion;
    }

    public SocksMessageType type() {
        return this.type;
    }
}
