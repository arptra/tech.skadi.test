package io.netty.channel;

import io.netty.util.concurrent.AbstractEventExecutor;

public abstract class AbstractEventLoop extends AbstractEventExecutor implements EventLoop {
    public AbstractEventLoop() {
    }

    public AbstractEventLoop(EventLoopGroup eventLoopGroup) {
        super(eventLoopGroup);
    }

    public EventLoop next() {
        return (EventLoop) super.next();
    }

    public EventLoopGroup parent() {
        return (EventLoopGroup) super.parent();
    }
}
