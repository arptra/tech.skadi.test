package io.netty.handler.codec.stomp;

import io.netty.handler.codec.DecoderResult;
import io.netty.util.internal.ObjectUtil;

public class DefaultStompHeadersSubframe implements StompHeadersSubframe {
    protected final StompCommand command;
    protected DecoderResult decoderResult;
    protected final DefaultStompHeaders headers;

    public DefaultStompHeadersSubframe(StompCommand stompCommand) {
        this(stompCommand, (DefaultStompHeaders) null);
    }

    public StompCommand command() {
        return this.command;
    }

    public DecoderResult decoderResult() {
        return this.decoderResult;
    }

    public StompHeaders headers() {
        return this.headers;
    }

    public void setDecoderResult(DecoderResult decoderResult2) {
        this.decoderResult = decoderResult2;
    }

    public String toString() {
        return "StompFrame{command=" + this.command + ", headers=" + this.headers + '}';
    }

    public DefaultStompHeadersSubframe(StompCommand stompCommand, DefaultStompHeaders defaultStompHeaders) {
        this.decoderResult = DecoderResult.SUCCESS;
        this.command = (StompCommand) ObjectUtil.checkNotNull(stompCommand, "command");
        this.headers = defaultStompHeaders == null ? new DefaultStompHeaders() : defaultStompHeaders;
    }
}
