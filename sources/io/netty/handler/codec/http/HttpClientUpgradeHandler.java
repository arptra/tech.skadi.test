package io.netty.handler.codec.http;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandler;
import io.netty.channel.ChannelPromise;
import io.netty.util.AsciiString;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.net.SocketAddress;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

public class HttpClientUpgradeHandler extends HttpObjectAggregator implements ChannelOutboundHandler {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final SourceCodec sourceCodec;
    private final UpgradeCodec upgradeCodec;
    private boolean upgradeRequested;

    public interface SourceCodec {
        void prepareUpgradeFrom(ChannelHandlerContext channelHandlerContext);

        void upgradeFrom(ChannelHandlerContext channelHandlerContext);
    }

    public interface UpgradeCodec {
        CharSequence protocol();

        Collection<CharSequence> setUpgradeHeaders(ChannelHandlerContext channelHandlerContext, HttpRequest httpRequest);

        void upgradeTo(ChannelHandlerContext channelHandlerContext, FullHttpResponse fullHttpResponse) throws Exception;
    }

    public enum UpgradeEvent {
        UPGRADE_ISSUED,
        UPGRADE_SUCCESSFUL,
        UPGRADE_REJECTED
    }

    public HttpClientUpgradeHandler(SourceCodec sourceCodec2, UpgradeCodec upgradeCodec2, int i) {
        super(i);
        this.sourceCodec = (SourceCodec) ObjectUtil.checkNotNull(sourceCodec2, "sourceCodec");
        this.upgradeCodec = (UpgradeCodec) ObjectUtil.checkNotNull(upgradeCodec2, "upgradeCodec");
    }

    private static void removeThisHandler(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.pipeline().remove(channelHandlerContext.name());
    }

    private void setUpgradeRequestHeaders(ChannelHandlerContext channelHandlerContext, HttpRequest httpRequest) {
        httpRequest.headers().set((CharSequence) HttpHeaderNames.UPGRADE, (Object) this.upgradeCodec.protocol());
        LinkedHashSet<CharSequence> linkedHashSet = new LinkedHashSet<>(2);
        linkedHashSet.addAll(this.upgradeCodec.setUpgradeHeaders(channelHandlerContext, httpRequest));
        StringBuilder sb = new StringBuilder();
        for (CharSequence append : linkedHashSet) {
            sb.append(append);
            sb.append(StringUtil.COMMA);
        }
        sb.append(HttpHeaderValues.UPGRADE);
        httpRequest.headers().add((CharSequence) HttpHeaderNames.CONNECTION, (Object) sb.toString());
    }

    public void bind(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.bind(socketAddress, channelPromise);
    }

    public void close(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.close(channelPromise);
    }

    public void connect(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.connect(socketAddress, socketAddress2, channelPromise);
    }

    public void deregister(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.deregister(channelPromise);
    }

    public void disconnect(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.disconnect(channelPromise);
    }

    public void flush(ChannelHandlerContext channelHandlerContext) throws Exception {
        channelHandlerContext.flush();
    }

    public void read(ChannelHandlerContext channelHandlerContext) throws Exception {
        channelHandlerContext.read();
    }

    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        if (!(obj instanceof HttpRequest)) {
            channelHandlerContext.write(obj, channelPromise);
        } else if (this.upgradeRequested) {
            channelPromise.setFailure(new IllegalStateException("Attempting to write HTTP request with upgrade in progress"));
        } else {
            this.upgradeRequested = true;
            setUpgradeRequestHeaders(channelHandlerContext, (HttpRequest) obj);
            channelHandlerContext.write(obj, channelPromise);
            channelHandlerContext.fireUserEventTriggered(UpgradeEvent.UPGRADE_ISSUED);
        }
    }

    public void decode(ChannelHandlerContext channelHandlerContext, HttpObject httpObject, List<Object> list) throws Exception {
        FullHttpResponse fullHttpResponse;
        FullHttpResponse fullHttpResponse2 = null;
        try {
            if (!this.upgradeRequested) {
                throw new IllegalStateException("Read HTTP response without requesting protocol switch");
            } else if (!(httpObject instanceof HttpResponse) || HttpResponseStatus.SWITCHING_PROTOCOLS.equals(((HttpResponse) httpObject).status())) {
                if (httpObject instanceof FullHttpResponse) {
                    fullHttpResponse = (FullHttpResponse) httpObject;
                    try {
                        fullHttpResponse.retain();
                        list.add(fullHttpResponse);
                    } catch (Throwable th) {
                        th = th;
                        fullHttpResponse2 = fullHttpResponse;
                        ReferenceCountUtil.release(fullHttpResponse2);
                        channelHandlerContext.fireExceptionCaught(th);
                        removeThisHandler(channelHandlerContext);
                    }
                } else {
                    super.decode(channelHandlerContext, httpObject, list);
                    if (!list.isEmpty()) {
                        fullHttpResponse = (FullHttpResponse) list.get(0);
                    } else {
                        return;
                    }
                }
                FullHttpResponse fullHttpResponse3 = fullHttpResponse;
                String str = fullHttpResponse3.headers().get((CharSequence) HttpHeaderNames.UPGRADE);
                if (str != null) {
                    if (!AsciiString.contentEqualsIgnoreCase(this.upgradeCodec.protocol(), str)) {
                        throw new IllegalStateException("Switching Protocols response with unexpected UPGRADE protocol: " + str);
                    }
                }
                this.sourceCodec.prepareUpgradeFrom(channelHandlerContext);
                this.upgradeCodec.upgradeTo(channelHandlerContext, fullHttpResponse3);
                channelHandlerContext.fireUserEventTriggered(UpgradeEvent.UPGRADE_SUCCESSFUL);
                this.sourceCodec.upgradeFrom(channelHandlerContext);
                fullHttpResponse3.release();
                list.clear();
                removeThisHandler(channelHandlerContext);
            } else {
                channelHandlerContext.fireUserEventTriggered(UpgradeEvent.UPGRADE_REJECTED);
                removeThisHandler(channelHandlerContext);
                channelHandlerContext.fireChannelRead(httpObject);
            }
        } catch (Throwable th2) {
            th = th2;
            ReferenceCountUtil.release(fullHttpResponse2);
            channelHandlerContext.fireExceptionCaught(th);
            removeThisHandler(channelHandlerContext);
        }
    }
}
