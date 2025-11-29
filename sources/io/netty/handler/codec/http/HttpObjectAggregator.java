package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.MessageAggregator;
import io.netty.util.AsciiString;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

public class HttpObjectAggregator extends MessageAggregator<HttpObject, HttpMessage, HttpContent, FullHttpMessage> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final FullHttpResponse CONTINUE;
    private static final FullHttpResponse EXPECTATION_FAILED;
    private static final FullHttpResponse TOO_LARGE;
    private static final FullHttpResponse TOO_LARGE_CLOSE;
    /* access modifiers changed from: private */
    public static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) HttpObjectAggregator.class);
    private final boolean closeOnExpectationFailed;

    public static abstract class AggregatedFullHttpMessage implements FullHttpMessage {
        private final ByteBuf content;
        protected final HttpMessage message;
        private HttpHeaders trailingHeaders;

        public AggregatedFullHttpMessage(HttpMessage httpMessage, ByteBuf byteBuf, HttpHeaders httpHeaders) {
            this.message = httpMessage;
            this.content = byteBuf;
            this.trailingHeaders = httpHeaders;
        }

        public ByteBuf content() {
            return this.content;
        }

        public abstract FullHttpMessage copy();

        public DecoderResult decoderResult() {
            return this.message.decoderResult();
        }

        public abstract FullHttpMessage duplicate();

        public DecoderResult getDecoderResult() {
            return this.message.decoderResult();
        }

        public HttpVersion getProtocolVersion() {
            return this.message.protocolVersion();
        }

        public HttpHeaders headers() {
            return this.message.headers();
        }

        public HttpVersion protocolVersion() {
            return this.message.protocolVersion();
        }

        public int refCnt() {
            return this.content.refCnt();
        }

        public boolean release() {
            return this.content.release();
        }

        public abstract FullHttpMessage retainedDuplicate();

        public void setDecoderResult(DecoderResult decoderResult) {
            this.message.setDecoderResult(decoderResult);
        }

        public void setTrailingHeaders(HttpHeaders httpHeaders) {
            this.trailingHeaders = httpHeaders;
        }

        public HttpHeaders trailingHeaders() {
            HttpHeaders httpHeaders = this.trailingHeaders;
            return httpHeaders == null ? EmptyHttpHeaders.INSTANCE : httpHeaders;
        }

        public boolean release(int i) {
            return this.content.release(i);
        }

        public FullHttpMessage setProtocolVersion(HttpVersion httpVersion) {
            this.message.setProtocolVersion(httpVersion);
            return this;
        }

        public FullHttpMessage retain() {
            this.content.retain();
            return this;
        }

        public FullHttpMessage touch(Object obj) {
            this.content.touch(obj);
            return this;
        }

        public FullHttpMessage retain(int i) {
            this.content.retain(i);
            return this;
        }

        public FullHttpMessage touch() {
            this.content.touch();
            return this;
        }
    }

    public static final class AggregatedFullHttpRequest extends AggregatedFullHttpMessage implements FullHttpRequest {
        public AggregatedFullHttpRequest(HttpRequest httpRequest, ByteBuf byteBuf, HttpHeaders httpHeaders) {
            super(httpRequest, byteBuf, httpHeaders);
        }

        public HttpMethod getMethod() {
            return ((HttpRequest) this.message).method();
        }

        public String getUri() {
            return ((HttpRequest) this.message).uri();
        }

        public HttpMethod method() {
            return getMethod();
        }

        public String toString() {
            return HttpMessageUtil.appendFullRequest(new StringBuilder(256), this).toString();
        }

        public String uri() {
            return getUri();
        }

        public FullHttpRequest setMethod(HttpMethod httpMethod) {
            ((HttpRequest) this.message).setMethod(httpMethod);
            return this;
        }

        public FullHttpRequest setUri(String str) {
            ((HttpRequest) this.message).setUri(str);
            return this;
        }

        public FullHttpRequest setProtocolVersion(HttpVersion httpVersion) {
            super.setProtocolVersion(httpVersion);
            return this;
        }

        public FullHttpRequest copy() {
            return replace(content().copy());
        }

        public FullHttpRequest duplicate() {
            return replace(content().duplicate());
        }

        public FullHttpRequest replace(ByteBuf byteBuf) {
            DefaultFullHttpRequest defaultFullHttpRequest = new DefaultFullHttpRequest(protocolVersion(), method(), uri(), byteBuf, headers().copy(), trailingHeaders().copy());
            defaultFullHttpRequest.setDecoderResult(decoderResult());
            return defaultFullHttpRequest;
        }

        public FullHttpRequest retainedDuplicate() {
            return replace(content().retainedDuplicate());
        }

        public FullHttpRequest retain(int i) {
            super.retain(i);
            return this;
        }

        public FullHttpRequest touch() {
            super.touch();
            return this;
        }

        public FullHttpRequest retain() {
            super.retain();
            return this;
        }

        public FullHttpRequest touch(Object obj) {
            super.touch(obj);
            return this;
        }
    }

    public static final class AggregatedFullHttpResponse extends AggregatedFullHttpMessage implements FullHttpResponse {
        public AggregatedFullHttpResponse(HttpResponse httpResponse, ByteBuf byteBuf, HttpHeaders httpHeaders) {
            super(httpResponse, byteBuf, httpHeaders);
        }

        public HttpResponseStatus getStatus() {
            return ((HttpResponse) this.message).status();
        }

        public HttpResponseStatus status() {
            return getStatus();
        }

        public String toString() {
            return HttpMessageUtil.appendFullResponse(new StringBuilder(256), this).toString();
        }

        public FullHttpResponse setStatus(HttpResponseStatus httpResponseStatus) {
            ((HttpResponse) this.message).setStatus(httpResponseStatus);
            return this;
        }

        public FullHttpResponse setProtocolVersion(HttpVersion httpVersion) {
            super.setProtocolVersion(httpVersion);
            return this;
        }

        public FullHttpResponse copy() {
            return replace(content().copy());
        }

        public FullHttpResponse duplicate() {
            return replace(content().duplicate());
        }

        public FullHttpResponse replace(ByteBuf byteBuf) {
            DefaultFullHttpResponse defaultFullHttpResponse = new DefaultFullHttpResponse(getProtocolVersion(), getStatus(), byteBuf, headers().copy(), trailingHeaders().copy());
            defaultFullHttpResponse.setDecoderResult(decoderResult());
            return defaultFullHttpResponse;
        }

        public FullHttpResponse retainedDuplicate() {
            return replace(content().retainedDuplicate());
        }

        public FullHttpResponse retain(int i) {
            super.retain(i);
            return this;
        }

        public FullHttpResponse touch(Object obj) {
            super.touch(obj);
            return this;
        }

        public FullHttpResponse retain() {
            super.retain();
            return this;
        }

        public FullHttpResponse touch() {
            super.touch();
            return this;
        }
    }

    static {
        HttpVersion httpVersion = HttpVersion.HTTP_1_1;
        HttpResponseStatus httpResponseStatus = HttpResponseStatus.CONTINUE;
        ByteBuf byteBuf = Unpooled.EMPTY_BUFFER;
        CONTINUE = new DefaultFullHttpResponse(httpVersion, httpResponseStatus, byteBuf);
        DefaultFullHttpResponse defaultFullHttpResponse = new DefaultFullHttpResponse(httpVersion, HttpResponseStatus.EXPECTATION_FAILED, byteBuf);
        EXPECTATION_FAILED = defaultFullHttpResponse;
        HttpResponseStatus httpResponseStatus2 = HttpResponseStatus.REQUEST_ENTITY_TOO_LARGE;
        DefaultFullHttpResponse defaultFullHttpResponse2 = new DefaultFullHttpResponse(httpVersion, httpResponseStatus2, byteBuf);
        TOO_LARGE_CLOSE = defaultFullHttpResponse2;
        DefaultFullHttpResponse defaultFullHttpResponse3 = new DefaultFullHttpResponse(httpVersion, httpResponseStatus2, byteBuf);
        TOO_LARGE = defaultFullHttpResponse3;
        HttpHeaders headers = defaultFullHttpResponse.headers();
        AsciiString asciiString = HttpHeaderNames.CONTENT_LENGTH;
        headers.set((CharSequence) asciiString, (Object) 0);
        defaultFullHttpResponse3.headers().set((CharSequence) asciiString, (Object) 0);
        defaultFullHttpResponse2.headers().set((CharSequence) asciiString, (Object) 0);
        defaultFullHttpResponse2.headers().set((CharSequence) HttpHeaderNames.CONNECTION, (Object) HttpHeaderValues.CLOSE);
    }

    public HttpObjectAggregator(int i) {
        this(i, false);
    }

    private static Object continueResponse(HttpMessage httpMessage, int i, ChannelPipeline channelPipeline) {
        if (HttpUtil.isUnsupportedExpectation(httpMessage)) {
            channelPipeline.fireUserEventTriggered(HttpExpectationFailedEvent.INSTANCE);
            return EXPECTATION_FAILED.retainedDuplicate();
        } else if (!HttpUtil.is100ContinueExpected(httpMessage)) {
            return null;
        } else {
            if (HttpUtil.getContentLength(httpMessage, -1) <= ((long) i)) {
                return CONTINUE.retainedDuplicate();
            }
            channelPipeline.fireUserEventTriggered(HttpExpectationFailedEvent.INSTANCE);
            return TOO_LARGE.retainedDuplicate();
        }
    }

    public boolean closeAfterContinueResponse(Object obj) {
        return this.closeOnExpectationFailed && ignoreContentAfterContinueResponse(obj);
    }

    public boolean ignoreContentAfterContinueResponse(Object obj) {
        if (obj instanceof HttpResponse) {
            return ((HttpResponse) obj).status().codeClass().equals(HttpStatusClass.CLIENT_ERROR);
        }
        return false;
    }

    public HttpObjectAggregator(int i, boolean z) {
        super(i);
        this.closeOnExpectationFailed = z;
    }

    public void aggregate(FullHttpMessage fullHttpMessage, HttpContent httpContent) throws Exception {
        if (httpContent instanceof LastHttpContent) {
            ((AggregatedFullHttpMessage) fullHttpMessage).setTrailingHeaders(((LastHttpContent) httpContent).trailingHeaders());
        }
    }

    public FullHttpMessage beginAggregation(HttpMessage httpMessage, ByteBuf byteBuf) throws Exception {
        HttpUtil.setTransferEncodingChunked(httpMessage, false);
        if (httpMessage instanceof HttpRequest) {
            return new AggregatedFullHttpRequest((HttpRequest) httpMessage, byteBuf, (HttpHeaders) null);
        }
        if (httpMessage instanceof HttpResponse) {
            return new AggregatedFullHttpResponse((HttpResponse) httpMessage, byteBuf, (HttpHeaders) null);
        }
        throw new Error();
    }

    public void finishAggregation(FullHttpMessage fullHttpMessage) throws Exception {
        if (!HttpUtil.isContentLengthSet(fullHttpMessage)) {
            fullHttpMessage.headers().set((CharSequence) HttpHeaderNames.CONTENT_LENGTH, (Object) String.valueOf(fullHttpMessage.content().readableBytes()));
        }
    }

    public void handleOversizedMessage(final ChannelHandlerContext channelHandlerContext, HttpMessage httpMessage) throws Exception {
        if (httpMessage instanceof HttpRequest) {
            if ((httpMessage instanceof FullHttpMessage) || (!HttpUtil.is100ContinueExpected(httpMessage) && !HttpUtil.isKeepAlive(httpMessage))) {
                channelHandlerContext.writeAndFlush(TOO_LARGE_CLOSE.retainedDuplicate()).addListener(new ChannelFutureListener() {
                    public void operationComplete(ChannelFuture channelFuture) throws Exception {
                        if (!channelFuture.isSuccess()) {
                            HttpObjectAggregator.logger.debug("Failed to send a 413 Request Entity Too Large.", channelFuture.cause());
                        }
                        channelHandlerContext.close();
                    }
                });
            } else {
                channelHandlerContext.writeAndFlush(TOO_LARGE.retainedDuplicate()).addListener(new ChannelFutureListener() {
                    public void operationComplete(ChannelFuture channelFuture) throws Exception {
                        if (!channelFuture.isSuccess()) {
                            HttpObjectAggregator.logger.debug("Failed to send a 413 Request Entity Too Large.", channelFuture.cause());
                            channelHandlerContext.close();
                        }
                    }
                });
            }
        } else if (httpMessage instanceof HttpResponse) {
            channelHandlerContext.close();
            throw new TooLongHttpContentException("Response entity too large: " + httpMessage);
        } else {
            throw new IllegalStateException();
        }
    }

    public boolean isAggregated(HttpObject httpObject) throws Exception {
        return httpObject instanceof FullHttpMessage;
    }

    public boolean isContentLengthInvalid(HttpMessage httpMessage, int i) {
        try {
            return HttpUtil.getContentLength(httpMessage, -1) > ((long) i);
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public boolean isContentMessage(HttpObject httpObject) throws Exception {
        return httpObject instanceof HttpContent;
    }

    public boolean isLastContentMessage(HttpContent httpContent) throws Exception {
        return httpContent instanceof LastHttpContent;
    }

    public boolean isStartMessage(HttpObject httpObject) throws Exception {
        return httpObject instanceof HttpMessage;
    }

    public Object newContinueResponse(HttpMessage httpMessage, int i, ChannelPipeline channelPipeline) {
        Object continueResponse = continueResponse(httpMessage, i, channelPipeline);
        if (continueResponse != null) {
            httpMessage.headers().remove((CharSequence) HttpHeaderNames.EXPECT);
        }
        return continueResponse;
    }
}
