package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.base64.Base64;
import io.netty.handler.codec.base64.Base64Dialect;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpClientUpgradeHandler;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.collection.CharObjectMap;
import io.netty.util.internal.ObjectUtil;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Http2ClientUpgradeCodec implements HttpClientUpgradeHandler.UpgradeCodec {
    private static final List<CharSequence> UPGRADE_HEADERS = Collections.singletonList(Http2CodecUtil.HTTP_UPGRADE_SETTINGS_HEADER);
    private final Http2ConnectionHandler connectionHandler;
    private final String handlerName;
    private final ChannelHandler http2MultiplexHandler;
    private final ChannelHandler upgradeToHandler;

    public Http2ClientUpgradeCodec(Http2FrameCodec http2FrameCodec, ChannelHandler channelHandler) {
        this((String) null, http2FrameCodec, channelHandler);
    }

    private CharSequence getSettingsHeaderValue(ChannelHandlerContext channelHandlerContext) {
        Object obj;
        ByteBuf byteBuf = null;
        try {
            Http2Settings localSettings = this.connectionHandler.decoder().localSettings();
            ByteBuf buffer = channelHandlerContext.alloc().buffer(localSettings.size() * 6);
            try {
                for (CharObjectMap.PrimitiveEntry primitiveEntry : localSettings.entries()) {
                    buffer.writeChar(primitiveEntry.key());
                    buffer.writeInt(((Long) primitiveEntry.value()).intValue());
                }
                ByteBuf encode = Base64.encode(buffer, Base64Dialect.URL_SAFE);
                String byteBuf2 = encode.toString(CharsetUtil.UTF_8);
                ReferenceCountUtil.release(buffer);
                ReferenceCountUtil.release(encode);
                return byteBuf2;
            } catch (Throwable th) {
                th = th;
                byteBuf = buffer;
                obj = null;
                ReferenceCountUtil.release(byteBuf);
                ReferenceCountUtil.release(obj);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            obj = null;
            ReferenceCountUtil.release(byteBuf);
            ReferenceCountUtil.release(obj);
            throw th;
        }
    }

    public CharSequence protocol() {
        return Http2CodecUtil.HTTP_UPGRADE_PROTOCOL_NAME;
    }

    public Collection<CharSequence> setUpgradeHeaders(ChannelHandlerContext channelHandlerContext, HttpRequest httpRequest) {
        httpRequest.headers().set(Http2CodecUtil.HTTP_UPGRADE_SETTINGS_HEADER, (Object) getSettingsHeaderValue(channelHandlerContext));
        return UPGRADE_HEADERS;
    }

    public void upgradeTo(ChannelHandlerContext channelHandlerContext, FullHttpResponse fullHttpResponse) throws Exception {
        try {
            channelHandlerContext.pipeline().addAfter(channelHandlerContext.name(), this.handlerName, this.upgradeToHandler);
            if (this.http2MultiplexHandler != null) {
                channelHandlerContext.pipeline().addAfter(channelHandlerContext.pipeline().context((ChannelHandler) this.connectionHandler).name(), (String) null, this.http2MultiplexHandler);
            }
            this.connectionHandler.onHttpClientUpgrade();
        } catch (Http2Exception e) {
            channelHandlerContext.fireExceptionCaught(e);
            channelHandlerContext.close();
        }
    }

    public Http2ClientUpgradeCodec(String str, Http2FrameCodec http2FrameCodec, ChannelHandler channelHandler) {
        this(str, http2FrameCodec, channelHandler, (Http2MultiplexHandler) null);
    }

    public Http2ClientUpgradeCodec(Http2ConnectionHandler http2ConnectionHandler) {
        this((String) null, http2ConnectionHandler);
    }

    public Http2ClientUpgradeCodec(Http2ConnectionHandler http2ConnectionHandler, Http2MultiplexHandler http2MultiplexHandler2) {
        this((String) null, http2ConnectionHandler, http2MultiplexHandler2);
    }

    public Http2ClientUpgradeCodec(String str, Http2ConnectionHandler http2ConnectionHandler) {
        this(str, http2ConnectionHandler, http2ConnectionHandler, (Http2MultiplexHandler) null);
    }

    public Http2ClientUpgradeCodec(String str, Http2ConnectionHandler http2ConnectionHandler, Http2MultiplexHandler http2MultiplexHandler2) {
        this(str, http2ConnectionHandler, http2ConnectionHandler, http2MultiplexHandler2);
    }

    private Http2ClientUpgradeCodec(String str, Http2ConnectionHandler http2ConnectionHandler, ChannelHandler channelHandler, Http2MultiplexHandler http2MultiplexHandler2) {
        this.handlerName = str;
        this.connectionHandler = (Http2ConnectionHandler) ObjectUtil.checkNotNull(http2ConnectionHandler, "connectionHandler");
        this.upgradeToHandler = (ChannelHandler) ObjectUtil.checkNotNull(channelHandler, "upgradeToHandler");
        this.http2MultiplexHandler = http2MultiplexHandler2;
    }
}
