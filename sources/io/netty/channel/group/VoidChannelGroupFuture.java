package io.netty.channel.group;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

final class VoidChannelGroupFuture implements ChannelGroupFuture {
    private static final Iterator<ChannelFuture> EMPTY = Collections.emptyList().iterator();
    private final ChannelGroup group;

    public VoidChannelGroupFuture(ChannelGroup channelGroup) {
        this.group = channelGroup;
    }

    private static RuntimeException reject() {
        return new IllegalStateException("void future");
    }

    public boolean cancel(boolean z) {
        return false;
    }

    public ChannelGroupException cause() {
        return null;
    }

    public ChannelFuture find(Channel channel) {
        return null;
    }

    public Void getNow() {
        return null;
    }

    public ChannelGroup group() {
        return this.group;
    }

    public boolean isCancellable() {
        return false;
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return false;
    }

    public boolean isPartialFailure() {
        return false;
    }

    public boolean isPartialSuccess() {
        return false;
    }

    public boolean isSuccess() {
        return false;
    }

    public Iterator<ChannelFuture> iterator() {
        return EMPTY;
    }

    public ChannelGroupFuture addListener(GenericFutureListener<? extends Future<? super Void>> genericFutureListener) {
        throw reject();
    }

    public ChannelGroupFuture addListeners(GenericFutureListener<? extends Future<? super Void>>... genericFutureListenerArr) {
        throw reject();
    }

    public ChannelGroupFuture await() {
        throw reject();
    }

    public ChannelGroupFuture awaitUninterruptibly() {
        throw reject();
    }

    public ChannelGroupFuture removeListener(GenericFutureListener<? extends Future<? super Void>> genericFutureListener) {
        throw reject();
    }

    public ChannelGroupFuture removeListeners(GenericFutureListener<? extends Future<? super Void>>... genericFutureListenerArr) {
        throw reject();
    }

    public ChannelGroupFuture sync() {
        throw reject();
    }

    public ChannelGroupFuture syncUninterruptibly() {
        throw reject();
    }

    public boolean await(long j, TimeUnit timeUnit) {
        throw reject();
    }

    public boolean awaitUninterruptibly(long j, TimeUnit timeUnit) {
        throw reject();
    }

    public Void get() {
        throw reject();
    }

    public boolean await(long j) {
        throw reject();
    }

    public boolean awaitUninterruptibly(long j) {
        throw reject();
    }

    public Void get(long j, TimeUnit timeUnit) {
        throw reject();
    }
}
