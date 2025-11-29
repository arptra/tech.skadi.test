package io.netty.handler.proxy;

import com.honey.account.constant.AccountConstantKt;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.ChannelOutboundHandler;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.base64.Base64;
import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.util.AsciiString;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.ObjectUtil;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

public final class HttpProxyHandler extends ProxyHandler {
    private static final String AUTH_BASIC = "basic";
    private static final String PROTOCOL = "http";
    private final CharSequence authorization;
    private final HttpClientCodecWrapper codecWrapper;
    private final boolean ignoreDefaultPortsInConnectHostHeader;
    private HttpHeaders inboundHeaders;
    private final HttpHeaders outboundHeaders;
    private final String password;
    private HttpResponseStatus status;
    private final String username;

    public static final class HttpClientCodecWrapper implements ChannelInboundHandler, ChannelOutboundHandler {
        final HttpClientCodec codec;

        private HttpClientCodecWrapper() {
            this.codec = new HttpClientCodec();
        }

        public void bind(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, ChannelPromise channelPromise) throws Exception {
            this.codec.bind(channelHandlerContext, socketAddress, channelPromise);
        }

        public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
            this.codec.channelActive(channelHandlerContext);
        }

        public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
            this.codec.channelInactive(channelHandlerContext);
        }

        public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
            this.codec.channelRead(channelHandlerContext, obj);
        }

        public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
            this.codec.channelReadComplete(channelHandlerContext);
        }

        public void channelRegistered(ChannelHandlerContext channelHandlerContext) throws Exception {
            this.codec.channelRegistered(channelHandlerContext);
        }

        public void channelUnregistered(ChannelHandlerContext channelHandlerContext) throws Exception {
            this.codec.channelUnregistered(channelHandlerContext);
        }

        public void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext) throws Exception {
            this.codec.channelWritabilityChanged(channelHandlerContext);
        }

        public void close(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
            this.codec.close(channelHandlerContext, channelPromise);
        }

        public void connect(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) throws Exception {
            this.codec.connect(channelHandlerContext, socketAddress, socketAddress2, channelPromise);
        }

        public void deregister(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
            this.codec.deregister(channelHandlerContext, channelPromise);
        }

        public void disconnect(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
            this.codec.disconnect(channelHandlerContext, channelPromise);
        }

        public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception {
            this.codec.exceptionCaught(channelHandlerContext, th);
        }

        public void flush(ChannelHandlerContext channelHandlerContext) throws Exception {
            this.codec.flush(channelHandlerContext);
        }

        public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
            this.codec.handlerAdded(channelHandlerContext);
        }

        public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
            this.codec.handlerRemoved(channelHandlerContext);
        }

        public void read(ChannelHandlerContext channelHandlerContext) throws Exception {
            this.codec.read(channelHandlerContext);
        }

        public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
            this.codec.userEventTriggered(channelHandlerContext, obj);
        }

        public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
            this.codec.write(channelHandlerContext, obj, channelPromise);
        }
    }

    public static final class HttpProxyConnectException extends ProxyConnectException {
        private static final long serialVersionUID = -8824334609292146066L;
        private final HttpHeaders headers;

        public HttpProxyConnectException(String str, HttpHeaders httpHeaders) {
            super(str);
            this.headers = httpHeaders;
        }

        public HttpHeaders headers() {
            return this.headers;
        }
    }

    public HttpProxyHandler(SocketAddress socketAddress) {
        this(socketAddress, (HttpHeaders) null);
    }

    public void addCodec(ChannelHandlerContext channelHandlerContext) throws Exception {
        channelHandlerContext.pipeline().addBefore(channelHandlerContext.name(), (String) null, this.codecWrapper);
    }

    public String authScheme() {
        return this.authorization != null ? AUTH_BASIC : "none";
    }

    public boolean handleResponse(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        if (obj instanceof HttpResponse) {
            if (this.status == null) {
                HttpResponse httpResponse = (HttpResponse) obj;
                this.status = httpResponse.status();
                this.inboundHeaders = httpResponse.headers();
            } else {
                throw new HttpProxyConnectException(exceptionMessage("too many responses"), (HttpHeaders) null);
            }
        }
        boolean z = obj instanceof LastHttpContent;
        if (z) {
            HttpResponseStatus httpResponseStatus = this.status;
            if (httpResponseStatus == null) {
                throw new HttpProxyConnectException(exceptionMessage("missing response"), this.inboundHeaders);
            } else if (httpResponseStatus.code() != 200) {
                throw new HttpProxyConnectException(exceptionMessage("status: " + this.status), this.inboundHeaders);
            }
        }
        return z;
    }

    public Object newInitialMessage(ChannelHandlerContext channelHandlerContext) throws Exception {
        InetSocketAddress inetSocketAddress = (InetSocketAddress) destinationAddress();
        String formatHostnameForHttp = HttpUtil.formatHostnameForHttp(inetSocketAddress);
        int port = inetSocketAddress.getPort();
        String str = formatHostnameForHttp + AccountConstantKt.CODE_SEPARTOR + port;
        if (!this.ignoreDefaultPortsInConnectHostHeader || !(port == 80 || port == 443)) {
            formatHostnameForHttp = str;
        }
        DefaultFullHttpRequest defaultFullHttpRequest = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.CONNECT, str, Unpooled.EMPTY_BUFFER, false);
        defaultFullHttpRequest.headers().set((CharSequence) HttpHeaderNames.HOST, (Object) formatHostnameForHttp);
        if (this.authorization != null) {
            defaultFullHttpRequest.headers().set((CharSequence) HttpHeaderNames.PROXY_AUTHORIZATION, (Object) this.authorization);
        }
        if (this.outboundHeaders != null) {
            defaultFullHttpRequest.headers().add(this.outboundHeaders);
        }
        return defaultFullHttpRequest;
    }

    public String password() {
        return this.password;
    }

    public String protocol() {
        return "http";
    }

    public void removeDecoder(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.codecWrapper.codec.removeInboundHandler();
    }

    public void removeEncoder(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.codecWrapper.codec.removeOutboundHandler();
    }

    public String username() {
        return this.username;
    }

    public HttpProxyHandler(SocketAddress socketAddress, HttpHeaders httpHeaders) {
        this(socketAddress, httpHeaders, false);
    }

    public HttpProxyHandler(SocketAddress socketAddress, HttpHeaders httpHeaders, boolean z) {
        super(socketAddress);
        this.codecWrapper = new HttpClientCodecWrapper();
        this.username = null;
        this.password = null;
        this.authorization = null;
        this.outboundHeaders = httpHeaders;
        this.ignoreDefaultPortsInConnectHostHeader = z;
    }

    public HttpProxyHandler(SocketAddress socketAddress, String str, String str2) {
        this(socketAddress, str, str2, (HttpHeaders) null);
    }

    public HttpProxyHandler(SocketAddress socketAddress, String str, String str2, HttpHeaders httpHeaders) {
        this(socketAddress, str, str2, httpHeaders, false);
    }

    /* JADX INFO: finally extract failed */
    public HttpProxyHandler(SocketAddress socketAddress, String str, String str2, HttpHeaders httpHeaders, boolean z) {
        super(socketAddress);
        this.codecWrapper = new HttpClientCodecWrapper();
        this.username = (String) ObjectUtil.checkNotNull(str, "username");
        this.password = (String) ObjectUtil.checkNotNull(str2, AccountConstantKt.INTENT_PARAM_PASSWORD);
        ByteBuf copiedBuffer = Unpooled.copiedBuffer((CharSequence) str + ':' + str2, CharsetUtil.UTF_8);
        try {
            ByteBuf encode = Base64.encode(copiedBuffer, false);
            try {
                this.authorization = new AsciiString((CharSequence) "Basic " + encode.toString(CharsetUtil.US_ASCII));
                encode.release();
                this.outboundHeaders = httpHeaders;
                this.ignoreDefaultPortsInConnectHostHeader = z;
            } catch (Throwable th) {
                encode.release();
                throw th;
            }
        } finally {
            copiedBuffer.release();
        }
    }
}
