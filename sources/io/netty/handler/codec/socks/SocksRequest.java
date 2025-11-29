package io.netty.handler.codec.socks;

import io.netty.util.internal.ObjectUtil;

public abstract class SocksRequest extends SocksMessage {
    private final SocksRequestType requestType;

    public SocksRequest(SocksRequestType socksRequestType) {
        super(SocksMessageType.REQUEST);
        this.requestType = (SocksRequestType) ObjectUtil.checkNotNull(socksRequestType, "requestType");
    }

    public SocksRequestType requestType() {
        return this.requestType;
    }
}
