package io.netty.channel;

import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.TypeParameterMatcher;

public abstract class SimpleChannelInboundHandler<I> extends ChannelInboundHandlerAdapter {
    private final boolean autoRelease;
    private final TypeParameterMatcher matcher;

    public SimpleChannelInboundHandler() {
        this(true);
    }

    public boolean acceptInboundMessage(Object obj) throws Exception {
        return this.matcher.match(obj);
    }

    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        boolean z = true;
        try {
            if (acceptInboundMessage(obj)) {
                channelRead0(channelHandlerContext, obj);
            } else {
                z = false;
                channelHandlerContext.fireChannelRead(obj);
            }
        } finally {
            if (this.autoRelease && z) {
                ReferenceCountUtil.release(obj);
            }
        }
    }

    public abstract void channelRead0(ChannelHandlerContext channelHandlerContext, I i) throws Exception;

    public SimpleChannelInboundHandler(boolean z) {
        this.matcher = TypeParameterMatcher.find(this, SimpleChannelInboundHandler.class, "I");
        this.autoRelease = z;
    }

    public SimpleChannelInboundHandler(Class<? extends I> cls) {
        this(cls, true);
    }

    public SimpleChannelInboundHandler(Class<? extends I> cls, boolean z) {
        this.matcher = TypeParameterMatcher.get(cls);
        this.autoRelease = z;
    }
}
