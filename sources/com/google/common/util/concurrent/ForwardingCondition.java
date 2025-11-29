package com.google.common.util.concurrent;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

abstract class ForwardingCondition implements Condition {
    public void await() throws InterruptedException {
        delegate().await();
    }

    public long awaitNanos(long j) throws InterruptedException {
        return delegate().awaitNanos(j);
    }

    public void awaitUninterruptibly() {
        delegate().awaitUninterruptibly();
    }

    public boolean awaitUntil(Date date) throws InterruptedException {
        return delegate().awaitUntil(date);
    }

    public abstract Condition delegate();

    public void signal() {
        delegate().signal();
    }

    public void signalAll() {
        delegate().signalAll();
    }

    public boolean await(long j, TimeUnit timeUnit) throws InterruptedException {
        return delegate().await(j, timeUnit);
    }
}
