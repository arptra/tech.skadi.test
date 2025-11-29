package io.netty.handler.codec.http;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.AsciiString;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class HttpServerUpgradeHandler extends HttpObjectAggregator {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private boolean handlingUpgrade;
    private final SourceCodec sourceCodec;
    private final UpgradeCodecFactory upgradeCodecFactory;
    private final boolean validateHeaders;

    public interface SourceCodec {
        void upgradeFrom(ChannelHandlerContext channelHandlerContext);
    }

    public interface UpgradeCodec {
        boolean prepareUpgradeResponse(ChannelHandlerContext channelHandlerContext, FullHttpRequest fullHttpRequest, HttpHeaders httpHeaders);

        Collection<CharSequence> requiredUpgradeHeaders();

        void upgradeTo(ChannelHandlerContext channelHandlerContext, FullHttpRequest fullHttpRequest);
    }

    public interface UpgradeCodecFactory {
        UpgradeCodec newUpgradeCodec(CharSequence charSequence);
    }

    public static final class UpgradeEvent implements ReferenceCounted {
        private final CharSequence protocol;
        private final FullHttpRequest upgradeRequest;

        public UpgradeEvent(CharSequence charSequence, FullHttpRequest fullHttpRequest) {
            this.protocol = charSequence;
            this.upgradeRequest = fullHttpRequest;
        }

        public CharSequence protocol() {
            return this.protocol;
        }

        public int refCnt() {
            return this.upgradeRequest.refCnt();
        }

        public boolean release() {
            return this.upgradeRequest.release();
        }

        public String toString() {
            return "UpgradeEvent [protocol=" + this.protocol + ", upgradeRequest=" + this.upgradeRequest + ']';
        }

        public FullHttpRequest upgradeRequest() {
            return this.upgradeRequest;
        }

        public boolean release(int i) {
            return this.upgradeRequest.release(i);
        }

        public UpgradeEvent retain() {
            this.upgradeRequest.retain();
            return this;
        }

        public UpgradeEvent touch() {
            this.upgradeRequest.touch();
            return this;
        }

        public UpgradeEvent retain(int i) {
            this.upgradeRequest.retain(i);
            return this;
        }

        public UpgradeEvent touch(Object obj) {
            this.upgradeRequest.touch(obj);
            return this;
        }
    }

    public HttpServerUpgradeHandler(SourceCodec sourceCodec2, UpgradeCodecFactory upgradeCodecFactory2) {
        this(sourceCodec2, upgradeCodecFactory2, 0);
    }

    private FullHttpResponse createUpgradeResponse(CharSequence charSequence) {
        DefaultFullHttpResponse defaultFullHttpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.SWITCHING_PROTOCOLS, Unpooled.EMPTY_BUFFER, this.validateHeaders);
        defaultFullHttpResponse.headers().add((CharSequence) HttpHeaderNames.CONNECTION, (Object) HttpHeaderValues.UPGRADE);
        defaultFullHttpResponse.headers().add((CharSequence) HttpHeaderNames.UPGRADE, (Object) charSequence);
        return defaultFullHttpResponse;
    }

    private static List<CharSequence> splitHeader(CharSequence charSequence) {
        StringBuilder sb = new StringBuilder(charSequence.length());
        ArrayList arrayList = new ArrayList(4);
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (!Character.isWhitespace(charAt)) {
                if (charAt == ',') {
                    arrayList.add(sb.toString());
                    sb.setLength(0);
                } else {
                    sb.append(charAt);
                }
            }
        }
        if (sb.length() > 0) {
            arrayList.add(sb.toString());
        }
        return arrayList;
    }

    private boolean upgrade(ChannelHandlerContext channelHandlerContext, FullHttpRequest fullHttpRequest) {
        CharSequence charSequence;
        UpgradeCodec upgradeCodec;
        List<String> all;
        List<CharSequence> splitHeader = splitHeader(fullHttpRequest.headers().get((CharSequence) HttpHeaderNames.UPGRADE));
        int size = splitHeader.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                charSequence = null;
                upgradeCodec = null;
                break;
            }
            charSequence = splitHeader.get(i);
            upgradeCodec = this.upgradeCodecFactory.newUpgradeCodec(charSequence);
            if (upgradeCodec != null) {
                break;
            }
            i++;
        }
        if (!(upgradeCodec == null || (all = fullHttpRequest.headers().getAll((CharSequence) HttpHeaderNames.CONNECTION)) == null || all.isEmpty())) {
            StringBuilder sb = new StringBuilder(all.size() * 10);
            for (String append : all) {
                sb.append(append);
                sb.append(StringUtil.COMMA);
            }
            sb.setLength(sb.length() - 1);
            Collection<CharSequence> requiredUpgradeHeaders = upgradeCodec.requiredUpgradeHeaders();
            List<CharSequence> splitHeader2 = splitHeader(sb);
            if (AsciiString.containsContentEqualsIgnoreCase(splitHeader2, HttpHeaderNames.UPGRADE) && AsciiString.containsAllContentEqualsIgnoreCase(splitHeader2, requiredUpgradeHeaders)) {
                for (CharSequence contains : requiredUpgradeHeaders) {
                    if (!fullHttpRequest.headers().contains(contains)) {
                        return false;
                    }
                }
                FullHttpResponse createUpgradeResponse = createUpgradeResponse(charSequence);
                if (!upgradeCodec.prepareUpgradeResponse(channelHandlerContext, fullHttpRequest, createUpgradeResponse.headers())) {
                    return false;
                }
                UpgradeEvent upgradeEvent = new UpgradeEvent(charSequence, fullHttpRequest);
                try {
                    ChannelFuture writeAndFlush = channelHandlerContext.writeAndFlush(createUpgradeResponse);
                    this.sourceCodec.upgradeFrom(channelHandlerContext);
                    upgradeCodec.upgradeTo(channelHandlerContext, fullHttpRequest);
                    channelHandlerContext.pipeline().remove((ChannelHandler) this);
                    channelHandlerContext.fireUserEventTriggered(upgradeEvent.retain());
                    writeAndFlush.addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
                    return true;
                } finally {
                    upgradeEvent.release();
                }
            }
        }
        return false;
    }

    public boolean shouldHandleUpgradeRequest(HttpRequest httpRequest) {
        return true;
    }

    public HttpServerUpgradeHandler(SourceCodec sourceCodec2, UpgradeCodecFactory upgradeCodecFactory2, int i) {
        this(sourceCodec2, upgradeCodecFactory2, i, true);
    }

    public void decode(ChannelHandlerContext channelHandlerContext, HttpObject httpObject, List<Object> list) throws Exception {
        FullHttpRequest fullHttpRequest;
        if (!this.handlingUpgrade) {
            if (httpObject instanceof HttpRequest) {
                HttpRequest httpRequest = (HttpRequest) httpObject;
                if (!httpRequest.headers().contains((CharSequence) HttpHeaderNames.UPGRADE) || !shouldHandleUpgradeRequest(httpRequest)) {
                    ReferenceCountUtil.retain(httpObject);
                    channelHandlerContext.fireChannelRead(httpObject);
                    return;
                }
                this.handlingUpgrade = true;
            } else {
                ReferenceCountUtil.retain(httpObject);
                channelHandlerContext.fireChannelRead(httpObject);
                return;
            }
        }
        if (httpObject instanceof FullHttpRequest) {
            fullHttpRequest = (FullHttpRequest) httpObject;
            ReferenceCountUtil.retain(httpObject);
            list.add(httpObject);
        } else {
            super.decode(channelHandlerContext, httpObject, list);
            if (!list.isEmpty()) {
                this.handlingUpgrade = false;
                fullHttpRequest = (FullHttpRequest) list.get(0);
            } else {
                return;
            }
        }
        if (upgrade(channelHandlerContext, fullHttpRequest)) {
            list.clear();
        }
    }

    public HttpServerUpgradeHandler(SourceCodec sourceCodec2, UpgradeCodecFactory upgradeCodecFactory2, int i, boolean z) {
        super(i);
        this.sourceCodec = (SourceCodec) ObjectUtil.checkNotNull(sourceCodec2, "sourceCodec");
        this.upgradeCodecFactory = (UpgradeCodecFactory) ObjectUtil.checkNotNull(upgradeCodecFactory2, "upgradeCodecFactory");
        this.validateHeaders = z;
    }
}
