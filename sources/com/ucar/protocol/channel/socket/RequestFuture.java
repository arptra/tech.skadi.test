package com.ucar.protocol.channel.socket;

import android.os.SystemClock;
import com.google.common.util.concurrent.AbstractFuture;
import com.ucar.protocol.UCarMessage;
import com.ucar.protocol.channel.FutureCallback;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class RequestFuture<ResT> extends AbstractFuture<ResT> implements Delayed {

    /* renamed from: a  reason: collision with root package name */
    public final FutureCallback f9646a;
    public final long b;
    public final long c;
    public final int d;

    public RequestFuture(FutureCallback futureCallback, int i) {
        this(futureCallback, 3000, i);
    }

    /* renamed from: a */
    public int compareTo(Delayed delayed) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return (int) (getDelay(timeUnit) - delayed.getDelay(timeUnit));
    }

    public void b(Exception exc) {
        FutureCallback futureCallback = this.f9646a;
        if (futureCallback != null) {
            futureCallback.c(exc);
        }
        setException(exc);
    }

    public int d() {
        return this.d;
    }

    public long f() {
        return this.c;
    }

    public void g(UCarMessage uCarMessage) {
        FutureCallback futureCallback = this.f9646a;
        if (futureCallback != null) {
            Object b2 = futureCallback.b(uCarMessage);
            if (!isCancelled()) {
                set(b2);
                this.f9646a.a(b2);
            }
            if (!(b2 instanceof DefaultFutureCallback) && uCarMessage != null) {
                uCarMessage.u();
            }
        }
    }

    public long getDelay(TimeUnit timeUnit) {
        long j = this.c;
        if (j == 0) {
            return 0;
        }
        return timeUnit.convert((this.b + j) - SystemClock.uptimeMillis(), TimeUnit.MILLISECONDS);
    }

    public String toString() {
        return "RequestFuture{start=" + this.b + ", timeoutMs=" + this.c + ", requestId=" + this.d + '}';
    }

    public RequestFuture(FutureCallback futureCallback, long j, int i) {
        this.b = SystemClock.uptimeMillis();
        this.f9646a = futureCallback;
        this.c = j;
        this.d = i;
    }
}
