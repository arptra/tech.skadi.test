package io.netty.handler.codec.socks;

import io.netty.util.internal.ObjectUtil;

public abstract class SocksResponse extends SocksMessage {
    private final SocksResponseType responseType;

    public SocksResponse(SocksResponseType socksResponseType) {
        super(SocksMessageType.RESPONSE);
        this.responseType = (SocksResponseType) ObjectUtil.checkNotNull(socksResponseType, "responseType");
    }

    public SocksResponseType responseType() {
        return this.responseType;
    }
}
