package io.netty.channel;

import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.TypeParameterMatcher;

public abstract class SimpleUserEventChannelHandler<I> extends ChannelInboundHandlerAdapter {
    private final boolean autoRelease;
    private final TypeParameterMatcher matcher;

    public SimpleUserEventChannelHandler() {
        this(true);
    }

    public boolean acceptEvent(Object obj) throws Exception {
        return this.matcher.match(obj);
    }

    public abstract void eventReceived(ChannelHandlerContext channelHandlerContext, I i) throws Exception;

    public final void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        boolean z = true;
        try {
            if (acceptEvent(obj)) {
                eventReceived(channelHandlerContext, obj);
            } else {
                z = false;
                channelHandlerContext.fireUserEventTriggered(obj);
            }
        } finally {
            if (this.autoRelease && z) {
                ReferenceCountUtil.release(obj);
            }
        }
    }

    public SimpleUserEventChannelHandler(boolean z) {
        this.matcher = TypeParameterMatcher.find(this, SimpleUserEventChannelHandler.class, "I");
        this.autoRelease = z;
    }

    public SimpleUserEventChannelHandler(Class<? extends I> cls) {
        this(cls, true);
    }

    public SimpleUserEventChannelHandler(Class<? extends I> cls, boolean z) {
        this.matcher = TypeParameterMatcher.get(cls);
        this.autoRelease = z;
    }
}
