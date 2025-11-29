package io.netty.handler.codec.http.websocketx.extensions;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.CodecException;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.util.internal.ObjectUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class WebSocketClientExtensionHandler extends ChannelDuplexHandler {
    private final List<WebSocketClientExtensionHandshaker> extensionHandshakers;

    public WebSocketClientExtensionHandler(WebSocketClientExtensionHandshaker... webSocketClientExtensionHandshakerArr) {
        this.extensionHandshakers = Arrays.asList(ObjectUtil.checkNonEmpty((T[]) webSocketClientExtensionHandshakerArr, "extensionHandshakers"));
    }

    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        if (obj instanceof HttpResponse) {
            HttpResponse httpResponse = (HttpResponse) obj;
            if (WebSocketExtensionUtil.isWebsocketUpgrade(httpResponse.headers())) {
                String asString = httpResponse.headers().getAsString(HttpHeaderNames.SEC_WEBSOCKET_EXTENSIONS);
                if (asString != null) {
                    List<WebSocketExtensionData> extractExtensions = WebSocketExtensionUtil.extractExtensions(asString);
                    ArrayList<WebSocketClientExtension> arrayList = new ArrayList<>(extractExtensions.size());
                    int i = 0;
                    for (WebSocketExtensionData next : extractExtensions) {
                        Iterator<WebSocketClientExtensionHandshaker> it = this.extensionHandshakers.iterator();
                        WebSocketClientExtension webSocketClientExtension = null;
                        while (webSocketClientExtension == null && it.hasNext()) {
                            webSocketClientExtension = it.next().handshakeExtension(next);
                        }
                        if (webSocketClientExtension == null || (webSocketClientExtension.rsv() & i) != 0) {
                            throw new CodecException("invalid WebSocket Extension handshake for \"" + asString + '\"');
                        }
                        i |= webSocketClientExtension.rsv();
                        arrayList.add(webSocketClientExtension);
                    }
                    for (WebSocketClientExtension webSocketClientExtension2 : arrayList) {
                        WebSocketExtensionDecoder newExtensionDecoder = webSocketClientExtension2.newExtensionDecoder();
                        WebSocketExtensionEncoder newExtensionEncoder = webSocketClientExtension2.newExtensionEncoder();
                        channelHandlerContext.pipeline().addAfter(channelHandlerContext.name(), newExtensionDecoder.getClass().getName(), newExtensionDecoder);
                        channelHandlerContext.pipeline().addAfter(channelHandlerContext.name(), newExtensionEncoder.getClass().getName(), newExtensionEncoder);
                    }
                }
                channelHandlerContext.pipeline().remove(channelHandlerContext.name());
            }
        }
        super.channelRead(channelHandlerContext, obj);
    }

    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        if (obj instanceof HttpRequest) {
            HttpRequest httpRequest = (HttpRequest) obj;
            if (WebSocketExtensionUtil.isWebsocketUpgrade(httpRequest.headers())) {
                String asString = httpRequest.headers().getAsString(HttpHeaderNames.SEC_WEBSOCKET_EXTENSIONS);
                ArrayList arrayList = new ArrayList(this.extensionHandshakers.size());
                for (WebSocketClientExtensionHandshaker newRequestData : this.extensionHandshakers) {
                    arrayList.add(newRequestData.newRequestData());
                }
                httpRequest.headers().set((CharSequence) HttpHeaderNames.SEC_WEBSOCKET_EXTENSIONS, (Object) WebSocketExtensionUtil.computeMergeExtensionsHeaderValue(asString, arrayList));
            }
        }
        super.write(channelHandlerContext, obj, channelPromise);
    }
}
