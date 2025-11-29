package io.netty.handler.codec.http.websocketx.extensions;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.util.internal.ObjectUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class WebSocketServerExtensionHandler extends ChannelDuplexHandler {
    private final List<WebSocketServerExtensionHandshaker> extensionHandshakers;
    /* access modifiers changed from: private */
    public List<WebSocketServerExtension> validExtensions;

    public WebSocketServerExtensionHandler(WebSocketServerExtensionHandshaker... webSocketServerExtensionHandshakerArr) {
        this.extensionHandshakers = Arrays.asList(ObjectUtil.checkNonEmpty((T[]) webSocketServerExtensionHandshakerArr, "extensionHandshakers"));
    }

    private void handlePotentialUpgrade(final ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise, HttpResponse httpResponse) {
        HttpHeaders headers = httpResponse.headers();
        if (WebSocketExtensionUtil.isWebsocketUpgrade(headers)) {
            if (this.validExtensions != null) {
                String asString = headers.getAsString(HttpHeaderNames.SEC_WEBSOCKET_EXTENSIONS);
                ArrayList arrayList = new ArrayList(this.extensionHandshakers.size());
                for (WebSocketServerExtension newReponseData : this.validExtensions) {
                    arrayList.add(newReponseData.newReponseData());
                }
                String computeMergeExtensionsHeaderValue = WebSocketExtensionUtil.computeMergeExtensionsHeaderValue(asString, arrayList);
                channelPromise.addListener(new ChannelFutureListener() {
                    public void operationComplete(ChannelFuture channelFuture) {
                        if (channelFuture.isSuccess()) {
                            for (WebSocketServerExtension webSocketServerExtension : WebSocketServerExtensionHandler.this.validExtensions) {
                                WebSocketExtensionDecoder newExtensionDecoder = webSocketServerExtension.newExtensionDecoder();
                                WebSocketExtensionEncoder newExtensionEncoder = webSocketServerExtension.newExtensionEncoder();
                                String name = channelHandlerContext.name();
                                channelHandlerContext.pipeline().addAfter(name, newExtensionDecoder.getClass().getName(), newExtensionDecoder).addAfter(name, newExtensionEncoder.getClass().getName(), newExtensionEncoder);
                            }
                        }
                    }
                });
                if (computeMergeExtensionsHeaderValue != null) {
                    headers.set((CharSequence) HttpHeaderNames.SEC_WEBSOCKET_EXTENSIONS, (Object) computeMergeExtensionsHeaderValue);
                }
            }
            channelPromise.addListener(new ChannelFutureListener() {
                public void operationComplete(ChannelFuture channelFuture) {
                    if (channelFuture.isSuccess()) {
                        channelHandlerContext.pipeline().remove((ChannelHandler) WebSocketServerExtensionHandler.this);
                    }
                }
            });
        }
    }

    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        String asString;
        if (obj instanceof HttpRequest) {
            HttpRequest httpRequest = (HttpRequest) obj;
            if (WebSocketExtensionUtil.isWebsocketUpgrade(httpRequest.headers()) && (asString = httpRequest.headers().getAsString(HttpHeaderNames.SEC_WEBSOCKET_EXTENSIONS)) != null) {
                int i = 0;
                for (WebSocketExtensionData next : WebSocketExtensionUtil.extractExtensions(asString)) {
                    Iterator<WebSocketServerExtensionHandshaker> it = this.extensionHandshakers.iterator();
                    WebSocketServerExtension webSocketServerExtension = null;
                    while (webSocketServerExtension == null && it.hasNext()) {
                        webSocketServerExtension = it.next().handshakeExtension(next);
                    }
                    if (webSocketServerExtension != null && (webSocketServerExtension.rsv() & i) == 0) {
                        if (this.validExtensions == null) {
                            this.validExtensions = new ArrayList(1);
                        }
                        i |= webSocketServerExtension.rsv();
                        this.validExtensions.add(webSocketServerExtension);
                    }
                }
            }
        }
        super.channelRead(channelHandlerContext, obj);
    }

    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        if (obj instanceof HttpResponse) {
            HttpResponse httpResponse = (HttpResponse) obj;
            if (HttpResponseStatus.SWITCHING_PROTOCOLS.equals(httpResponse.status())) {
                handlePotentialUpgrade(channelHandlerContext, channelPromise, httpResponse);
            }
        }
        super.write(channelHandlerContext, obj, channelPromise);
    }
}
