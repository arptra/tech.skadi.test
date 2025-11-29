package io.netty.channel.pool;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoop;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.GlobalEventExecutor;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.util.Deque;
import java.util.concurrent.Callable;

public class SimpleChannelPool implements ChannelPool {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final AttributeKey<SimpleChannelPool> POOL_KEY = AttributeKey.newInstance("io.netty.channel.pool.SimpleChannelPool");
    private final Bootstrap bootstrap;
    private final Deque<Channel> deque;
    private final ChannelPoolHandler handler;
    private final ChannelHealthChecker healthCheck;
    private final boolean lastRecentUsed;
    private final boolean releaseHealthCheck;

    public static final class ChannelPoolFullException extends IllegalStateException {
        public Throwable fillInStackTrace() {
            return this;
        }

        private ChannelPoolFullException() {
            super("ChannelPool full");
        }
    }

    public SimpleChannelPool(Bootstrap bootstrap2, ChannelPoolHandler channelPoolHandler) {
        this(bootstrap2, channelPoolHandler, ChannelHealthChecker.ACTIVE);
    }

    private Future<Channel> acquireHealthyFromPoolOrNew(final Promise<Channel> promise) {
        try {
            final Channel pollChannel = pollChannel();
            if (pollChannel == null) {
                Bootstrap clone = this.bootstrap.clone();
                clone.attr(POOL_KEY, this);
                ChannelFuture connectChannel = connectChannel(clone);
                if (connectChannel.isDone()) {
                    notifyConnect(connectChannel, promise);
                } else {
                    connectChannel.addListener(new ChannelFutureListener() {
                        public void operationComplete(ChannelFuture channelFuture) throws Exception {
                            SimpleChannelPool.this.notifyConnect(channelFuture, promise);
                        }
                    });
                }
            } else {
                EventLoop eventLoop = pollChannel.eventLoop();
                if (eventLoop.inEventLoop()) {
                    doHealthCheck(pollChannel, promise);
                } else {
                    eventLoop.execute(new Runnable() {
                        public void run() {
                            SimpleChannelPool.this.doHealthCheck(pollChannel, promise);
                        }
                    });
                }
            }
        } catch (Throwable th) {
            promise.tryFailure(th);
        }
        return promise;
    }

    private void closeAndFail(Channel channel, Throwable th, Promise<?> promise) {
        if (channel != null) {
            try {
                closeChannel(channel);
            } catch (Throwable th2) {
                promise.tryFailure(th2);
            }
        }
        promise.tryFailure(th);
    }

    private void closeChannel(Channel channel) throws Exception {
        channel.attr(POOL_KEY).getAndSet(null);
        channel.close();
    }

    /* access modifiers changed from: private */
    public void doHealthCheck(final Channel channel, final Promise<Channel> promise) {
        try {
            Future<Boolean> isHealthy = this.healthCheck.isHealthy(channel);
            if (isHealthy.isDone()) {
                notifyHealthCheck(isHealthy, channel, promise);
            } else {
                isHealthy.addListener(new FutureListener<Boolean>() {
                    public void operationComplete(Future<Boolean> future) {
                        SimpleChannelPool.this.notifyHealthCheck(future, channel, promise);
                    }
                });
            }
        } catch (Throwable th) {
            closeAndFail(channel, th, promise);
        }
    }

    private void doHealthCheckOnRelease(final Channel channel, final Promise<Void> promise) throws Exception {
        final Future<Boolean> isHealthy = this.healthCheck.isHealthy(channel);
        if (isHealthy.isDone()) {
            releaseAndOfferIfHealthy(channel, promise, isHealthy);
        } else {
            isHealthy.addListener(new FutureListener<Boolean>() {
                public void operationComplete(Future<Boolean> future) throws Exception {
                    SimpleChannelPool.this.releaseAndOfferIfHealthy(channel, promise, isHealthy);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void doReleaseChannel(Channel channel, Promise<Void> promise) {
        try {
            if (channel.attr(POOL_KEY).getAndSet(null) != this) {
                closeAndFail(channel, new IllegalArgumentException("Channel " + channel + " was not acquired from this ChannelPool"), promise);
            } else if (this.releaseHealthCheck) {
                doHealthCheckOnRelease(channel, promise);
            } else {
                releaseAndOffer(channel, promise);
            }
        } catch (Throwable th) {
            closeAndFail(channel, th, promise);
        }
    }

    /* access modifiers changed from: private */
    public void notifyConnect(ChannelFuture channelFuture, Promise<Channel> promise) {
        try {
            if (channelFuture.isSuccess()) {
                Channel channel = channelFuture.channel();
                this.handler.channelAcquired(channel);
                if (!promise.trySuccess(channel)) {
                    release(channel);
                    return;
                }
                return;
            }
            promise.tryFailure(channelFuture.cause());
        } catch (Throwable th) {
            closeAndFail((Channel) null, th, promise);
        }
    }

    /* access modifiers changed from: private */
    public void notifyHealthCheck(Future<Boolean> future, Channel channel, Promise<Channel> promise) {
        try {
            if (!future.isSuccess() || !future.getNow().booleanValue()) {
                closeChannel(channel);
                acquireHealthyFromPoolOrNew(promise);
                return;
            }
            channel.attr(POOL_KEY).set(this);
            this.handler.channelAcquired(channel);
            promise.setSuccess(channel);
        } catch (Throwable th) {
            closeAndFail(channel, th, promise);
        }
    }

    private void releaseAndOffer(Channel channel, Promise<Void> promise) throws Exception {
        if (offerChannel(channel)) {
            this.handler.channelReleased(channel);
            promise.setSuccess(null);
            return;
        }
        closeAndFail(channel, new ChannelPoolFullException(), promise);
    }

    /* access modifiers changed from: private */
    public void releaseAndOfferIfHealthy(Channel channel, Promise<Void> promise, Future<Boolean> future) {
        try {
            if (future.getNow().booleanValue()) {
                releaseAndOffer(channel, promise);
                return;
            }
            this.handler.channelReleased(channel);
            promise.setSuccess(null);
        } catch (Throwable th) {
            closeAndFail(channel, th, promise);
        }
    }

    public final Future<Channel> acquire() {
        return acquire(this.bootstrap.config().group().next().newPromise());
    }

    public Bootstrap bootstrap() {
        return this.bootstrap;
    }

    public void close() {
        while (true) {
            Channel pollChannel = pollChannel();
            if (pollChannel != null) {
                pollChannel.close().awaitUninterruptibly();
            } else {
                return;
            }
        }
    }

    public Future<Void> closeAsync() {
        return GlobalEventExecutor.INSTANCE.submit(new Callable<Void>() {
            public Void call() throws Exception {
                SimpleChannelPool.this.close();
                return null;
            }
        });
    }

    public ChannelFuture connectChannel(Bootstrap bootstrap2) {
        return bootstrap2.connect();
    }

    public ChannelPoolHandler handler() {
        return this.handler;
    }

    public ChannelHealthChecker healthChecker() {
        return this.healthCheck;
    }

    public boolean offerChannel(Channel channel) {
        return this.deque.offer(channel);
    }

    public Channel pollChannel() {
        boolean z = this.lastRecentUsed;
        Deque deque2 = this.deque;
        return (Channel) (z ? deque2.pollLast() : deque2.pollFirst());
    }

    public final Future<Void> release(Channel channel) {
        return release(channel, channel.eventLoop().newPromise());
    }

    public boolean releaseHealthCheck() {
        return this.releaseHealthCheck;
    }

    public SimpleChannelPool(Bootstrap bootstrap2, ChannelPoolHandler channelPoolHandler, ChannelHealthChecker channelHealthChecker) {
        this(bootstrap2, channelPoolHandler, channelHealthChecker, true);
    }

    public Future<Channel> acquire(Promise<Channel> promise) {
        return acquireHealthyFromPoolOrNew((Promise) ObjectUtil.checkNotNull(promise, "promise"));
    }

    public Future<Void> release(final Channel channel, final Promise<Void> promise) {
        try {
            ObjectUtil.checkNotNull(channel, "channel");
            ObjectUtil.checkNotNull(promise, "promise");
            EventLoop eventLoop = channel.eventLoop();
            if (eventLoop.inEventLoop()) {
                doReleaseChannel(channel, promise);
            } else {
                eventLoop.execute(new Runnable() {
                    public void run() {
                        SimpleChannelPool.this.doReleaseChannel(channel, promise);
                    }
                });
            }
        } catch (Throwable th) {
            closeAndFail(channel, th, promise);
        }
        return promise;
    }

    public SimpleChannelPool(Bootstrap bootstrap2, ChannelPoolHandler channelPoolHandler, ChannelHealthChecker channelHealthChecker, boolean z) {
        this(bootstrap2, channelPoolHandler, channelHealthChecker, z, true);
    }

    public SimpleChannelPool(Bootstrap bootstrap2, final ChannelPoolHandler channelPoolHandler, ChannelHealthChecker channelHealthChecker, boolean z, boolean z2) {
        this.deque = PlatformDependent.newConcurrentDeque();
        this.handler = (ChannelPoolHandler) ObjectUtil.checkNotNull(channelPoolHandler, "handler");
        this.healthCheck = (ChannelHealthChecker) ObjectUtil.checkNotNull(channelHealthChecker, "healthCheck");
        this.releaseHealthCheck = z;
        Bootstrap clone = ((Bootstrap) ObjectUtil.checkNotNull(bootstrap2, "bootstrap")).clone();
        this.bootstrap = clone;
        clone.handler(new ChannelInitializer<Channel>() {
            static final /* synthetic */ boolean $assertionsDisabled = false;

            public void initChannel(Channel channel) throws Exception {
                channelPoolHandler.channelCreated(channel);
            }
        });
        this.lastRecentUsed = z2;
    }
}
