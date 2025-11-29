package io.netty.handler.codec.http2;

public interface Http2SettingsReceivedConsumer {
    void consumeReceivedSettings(Http2Settings http2Settings);
}
