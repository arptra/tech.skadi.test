package io.netty.handler.codec.http;

import com.meizu.common.widget.MzContactsContract;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.MessageToMessageCodec;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public abstract class HttpContentEncoder extends MessageToMessageCodec<HttpRequest, HttpObject> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int CONTINUE_CODE = HttpResponseStatus.CONTINUE.code();
    private static final CharSequence ZERO_LENGTH_CONNECT = "CONNECT";
    private static final CharSequence ZERO_LENGTH_HEAD = "HEAD";
    private final Queue<CharSequence> acceptEncodingQueue = new ArrayDeque();
    private EmbeddedChannel encoder;
    private State state = State.AWAIT_HEADERS;

    /* renamed from: io.netty.handler.codec.http.HttpContentEncoder$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http$HttpContentEncoder$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                io.netty.handler.codec.http.HttpContentEncoder$State[] r0 = io.netty.handler.codec.http.HttpContentEncoder.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$netty$handler$codec$http$HttpContentEncoder$State = r0
                io.netty.handler.codec.http.HttpContentEncoder$State r1 = io.netty.handler.codec.http.HttpContentEncoder.State.AWAIT_HEADERS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$netty$handler$codec$http$HttpContentEncoder$State     // Catch:{ NoSuchFieldError -> 0x001d }
                io.netty.handler.codec.http.HttpContentEncoder$State r1 = io.netty.handler.codec.http.HttpContentEncoder.State.AWAIT_CONTENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$netty$handler$codec$http$HttpContentEncoder$State     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.netty.handler.codec.http.HttpContentEncoder$State r1 = io.netty.handler.codec.http.HttpContentEncoder.State.PASS_THROUGH     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http.HttpContentEncoder.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Result {
        private final EmbeddedChannel contentEncoder;
        private final String targetContentEncoding;

        public Result(String str, EmbeddedChannel embeddedChannel) {
            this.targetContentEncoding = (String) ObjectUtil.checkNotNull(str, "targetContentEncoding");
            this.contentEncoder = (EmbeddedChannel) ObjectUtil.checkNotNull(embeddedChannel, "contentEncoder");
        }

        public EmbeddedChannel contentEncoder() {
            return this.contentEncoder;
        }

        public String targetContentEncoding() {
            return this.targetContentEncoding;
        }
    }

    public enum State {
        PASS_THROUGH,
        AWAIT_HEADERS,
        AWAIT_CONTENT
    }

    private void cleanup() {
        EmbeddedChannel embeddedChannel = this.encoder;
        if (embeddedChannel != null) {
            embeddedChannel.finishAndReleaseAll();
            this.encoder = null;
        }
    }

    private void cleanupSafely(ChannelHandlerContext channelHandlerContext) {
        try {
            cleanup();
        } catch (Throwable th) {
            channelHandlerContext.fireExceptionCaught(th);
        }
    }

    private boolean encodeContent(HttpContent httpContent, List<Object> list) {
        encode(httpContent.content(), list);
        if (!(httpContent instanceof LastHttpContent)) {
            return false;
        }
        finishEncode(list);
        HttpHeaders trailingHeaders = ((LastHttpContent) httpContent).trailingHeaders();
        if (trailingHeaders.isEmpty()) {
            list.add(LastHttpContent.EMPTY_LAST_CONTENT);
            return true;
        }
        list.add(new ComposedLastHttpContent(trailingHeaders, DecoderResult.SUCCESS));
        return true;
    }

    private void encodeFullResponse(HttpResponse httpResponse, HttpContent httpContent, List<Object> list) {
        encodeContent(httpContent, list);
        if (HttpUtil.isContentLengthSet(httpResponse)) {
            int i = 0;
            for (int size = list.size(); size < list.size(); size++) {
                Object obj = list.get(size);
                if (obj instanceof HttpContent) {
                    i += ((HttpContent) obj).content().readableBytes();
                }
            }
            HttpUtil.setContentLength(httpResponse, (long) i);
            return;
        }
        httpResponse.headers().set((CharSequence) HttpHeaderNames.TRANSFER_ENCODING, (Object) HttpHeaderValues.CHUNKED);
    }

    private static void ensureContent(HttpObject httpObject) {
        if (!(httpObject instanceof HttpContent)) {
            throw new IllegalStateException("unexpected message type: " + httpObject.getClass().getName() + " (expected: " + HttpContent.class.getSimpleName() + ')');
        }
    }

    private static void ensureHeaders(HttpObject httpObject) {
        if (!(httpObject instanceof HttpResponse)) {
            throw new IllegalStateException("unexpected message type: " + httpObject.getClass().getName() + " (expected: " + HttpResponse.class.getSimpleName() + ')');
        }
    }

    private void fetchEncoderOutput(List<Object> list) {
        while (true) {
            ByteBuf byteBuf = (ByteBuf) this.encoder.readOutbound();
            if (byteBuf != null) {
                if (!byteBuf.isReadable()) {
                    byteBuf.release();
                } else {
                    list.add(new DefaultHttpContent(byteBuf));
                }
            } else {
                return;
            }
        }
    }

    private void finishEncode(List<Object> list) {
        if (this.encoder.finish()) {
            fetchEncoderOutput(list);
        }
        this.encoder = null;
    }

    private static boolean isPassthru(HttpVersion httpVersion, int i, CharSequence charSequence) {
        return i < 200 || i == 204 || i == 304 || charSequence == ZERO_LENGTH_HEAD || (charSequence == ZERO_LENGTH_CONNECT && i == 200) || httpVersion == HttpVersion.HTTP_1_0;
    }

    public boolean acceptOutboundMessage(Object obj) throws Exception {
        return (obj instanceof HttpContent) || (obj instanceof HttpResponse);
    }

    public abstract Result beginEncode(HttpResponse httpResponse, String str) throws Exception;

    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        cleanupSafely(channelHandlerContext);
        super.channelInactive(channelHandlerContext);
    }

    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        cleanupSafely(channelHandlerContext);
        super.handlerRemoved(channelHandlerContext);
    }

    public void decode(ChannelHandlerContext channelHandlerContext, HttpRequest httpRequest, List<Object> list) throws Exception {
        CharSequence charSequence;
        List<String> all = httpRequest.headers().getAll((CharSequence) HttpHeaderNames.ACCEPT_ENCODING);
        int size = all.size();
        if (size == 0) {
            charSequence = HttpContentDecoder.IDENTITY;
        } else if (size != 1) {
            charSequence = StringUtil.join(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA, all);
        } else {
            charSequence = all.get(0);
        }
        HttpMethod method = httpRequest.method();
        if (HttpMethod.HEAD.equals(method)) {
            charSequence = ZERO_LENGTH_HEAD;
        } else if (HttpMethod.CONNECT.equals(method)) {
            charSequence = ZERO_LENGTH_CONNECT;
        }
        this.acceptEncodingQueue.add(charSequence);
        list.add(ReferenceCountUtil.retain(httpRequest));
    }

    public void encode(ChannelHandlerContext channelHandlerContext, HttpObject httpObject, List<Object> list) throws Exception {
        CharSequence charSequence;
        boolean z = (httpObject instanceof HttpResponse) && (httpObject instanceof LastHttpContent);
        int i = AnonymousClass1.$SwitchMap$io$netty$handler$codec$http$HttpContentEncoder$State[this.state.ordinal()];
        if (i == 1) {
            ensureHeaders(httpObject);
            HttpResponse httpResponse = (HttpResponse) httpObject;
            int code = httpResponse.status().code();
            if (code == CONTINUE_CODE) {
                charSequence = null;
            } else {
                charSequence = this.acceptEncodingQueue.poll();
                if (charSequence == null) {
                    throw new IllegalStateException("cannot send more responses than requests");
                }
            }
            if (isPassthru(httpResponse.protocolVersion(), code, charSequence)) {
                if (z) {
                    list.add(ReferenceCountUtil.retain(httpResponse));
                    return;
                }
                list.add(ReferenceCountUtil.retain(httpResponse));
                this.state = State.PASS_THROUGH;
                return;
            } else if (!z || ((ByteBufHolder) httpResponse).content().isReadable()) {
                Result beginEncode = beginEncode(httpResponse, charSequence.toString());
                if (beginEncode != null) {
                    this.encoder = beginEncode.contentEncoder();
                    httpResponse.headers().set((CharSequence) HttpHeaderNames.CONTENT_ENCODING, (Object) beginEncode.targetContentEncoding());
                    if (z) {
                        DefaultHttpResponse defaultHttpResponse = new DefaultHttpResponse(httpResponse.protocolVersion(), httpResponse.status());
                        defaultHttpResponse.headers().set(httpResponse.headers());
                        list.add(defaultHttpResponse);
                        ensureContent(httpResponse);
                        encodeFullResponse(defaultHttpResponse, (HttpContent) httpResponse, list);
                        return;
                    }
                    httpResponse.headers().remove((CharSequence) HttpHeaderNames.CONTENT_LENGTH);
                    httpResponse.headers().set((CharSequence) HttpHeaderNames.TRANSFER_ENCODING, (Object) HttpHeaderValues.CHUNKED);
                    list.add(ReferenceCountUtil.retain(httpResponse));
                    this.state = State.AWAIT_CONTENT;
                    if (!(httpObject instanceof HttpContent)) {
                        return;
                    }
                } else if (z) {
                    list.add(ReferenceCountUtil.retain(httpResponse));
                    return;
                } else {
                    list.add(ReferenceCountUtil.retain(httpResponse));
                    this.state = State.PASS_THROUGH;
                    return;
                }
            } else {
                list.add(ReferenceCountUtil.retain(httpResponse));
                return;
            }
        } else if (i != 2) {
            if (i == 3) {
                ensureContent(httpObject);
                list.add(ReferenceCountUtil.retain(httpObject));
                if (httpObject instanceof LastHttpContent) {
                    this.state = State.AWAIT_HEADERS;
                    return;
                }
                return;
            }
            return;
        }
        ensureContent(httpObject);
        if (encodeContent((HttpContent) httpObject, list)) {
            this.state = State.AWAIT_HEADERS;
        }
    }

    private void encode(ByteBuf byteBuf, List<Object> list) {
        this.encoder.writeOutbound(byteBuf.retain());
        fetchEncoderOutput(list);
    }
}
