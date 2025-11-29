package org.java_websocket;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.java_websocket.util.NamedThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractWebSocket extends WebSocketAdapter {
    public final Logger b = LoggerFactory.k(AbstractWebSocket.class);
    public boolean c;
    public boolean d;
    public ScheduledExecutorService e;
    public ScheduledFuture f;
    public long g = TimeUnit.SECONDS.toNanos(60);
    public boolean h = false;
    public final Object i = new Object();

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void A(int r6) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.i
            monitor-enter(r0)
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x001e }
            long r2 = (long) r6     // Catch:{ all -> 0x001e }
            long r1 = r1.toNanos(r2)     // Catch:{ all -> 0x001e }
            r5.g = r1     // Catch:{ all -> 0x001e }
            r3 = 0
            int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r6 > 0) goto L_0x0020
            org.slf4j.Logger r6 = r5.b     // Catch:{ all -> 0x001e }
            java.lang.String r1 = "Connection lost timer stopped"
            r6.trace(r1)     // Catch:{ all -> 0x001e }
            r5.u()     // Catch:{ all -> 0x001e }
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            return
        L_0x001e:
            r5 = move-exception
            goto L_0x005b
        L_0x0020:
            boolean r6 = r5.h     // Catch:{ all -> 0x001e }
            if (r6 == 0) goto L_0x0059
            org.slf4j.Logger r6 = r5.b     // Catch:{ all -> 0x001e }
            java.lang.String r1 = "Connection lost timer restarted"
            r6.trace(r1)     // Catch:{ all -> 0x001e }
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ Exception -> 0x004e }
            java.util.Collection r1 = r5.w()     // Catch:{ Exception -> 0x004e }
            r6.<init>(r1)     // Catch:{ Exception -> 0x004e }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ Exception -> 0x004e }
        L_0x0038:
            boolean r1 = r6.hasNext()     // Catch:{ Exception -> 0x004e }
            if (r1 == 0) goto L_0x0056
            java.lang.Object r1 = r6.next()     // Catch:{ Exception -> 0x004e }
            org.java_websocket.WebSocket r1 = (org.java_websocket.WebSocket) r1     // Catch:{ Exception -> 0x004e }
            boolean r2 = r1 instanceof org.java_websocket.WebSocketImpl     // Catch:{ Exception -> 0x004e }
            if (r2 == 0) goto L_0x0038
            org.java_websocket.WebSocketImpl r1 = (org.java_websocket.WebSocketImpl) r1     // Catch:{ Exception -> 0x004e }
            r1.M()     // Catch:{ Exception -> 0x004e }
            goto L_0x0038
        L_0x004e:
            r6 = move-exception
            org.slf4j.Logger r1 = r5.b     // Catch:{ all -> 0x001e }
            java.lang.String r2 = "Exception during connection lost restart"
            r1.error((java.lang.String) r2, (java.lang.Throwable) r6)     // Catch:{ all -> 0x001e }
        L_0x0056:
            r5.z()     // Catch:{ all -> 0x001e }
        L_0x0059:
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            return
        L_0x005b:
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.java_websocket.AbstractWebSocket.A(int):void");
    }

    public void B(boolean z) {
        this.d = z;
    }

    public void C(boolean z) {
        this.c = z;
    }

    public void D() {
        synchronized (this.i) {
            try {
                if (this.g <= 0) {
                    this.b.trace("Connection lost timer deactivated");
                    return;
                }
                this.b.trace("Connection lost timer started");
                this.h = true;
                z();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void E() {
        synchronized (this.i) {
            try {
                if (this.e == null) {
                    if (this.f != null) {
                    }
                }
                this.h = false;
                this.b.trace("Connection lost timer stopped");
                u();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void u() {
        ScheduledExecutorService scheduledExecutorService = this.e;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
            this.e = null;
        }
        ScheduledFuture scheduledFuture = this.f;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.f = null;
        }
    }

    public final void v(WebSocket webSocket, long j) {
        if (webSocket instanceof WebSocketImpl) {
            WebSocketImpl webSocketImpl = (WebSocketImpl) webSocket;
            if (webSocketImpl.t() < j) {
                this.b.trace("Closing connection due to no pong received: {}", (Object) webSocketImpl);
                webSocketImpl.q(1006, "The connection was closed because the other endpoint did not respond with a pong in time. For more information check: https://github.com/TooTallNate/Java-WebSocket/wiki/Lost-connection-detection");
            } else if (webSocketImpl.B()) {
                webSocketImpl.H();
            } else {
                this.b.trace("Trying to ping a non open connection: {}", (Object) webSocketImpl);
            }
        }
    }

    public abstract Collection w();

    public boolean x() {
        return this.d;
    }

    public boolean y() {
        return this.c;
    }

    public final void z() {
        u();
        this.e = Executors.newSingleThreadScheduledExecutor(new NamedThreadFactory("connectionLostChecker"));
        AnonymousClass1 r2 = new Runnable() {

            /* renamed from: a  reason: collision with root package name */
            public ArrayList f3386a = new ArrayList();

            public void run() {
                long nanoTime;
                this.f3386a.clear();
                try {
                    this.f3386a.addAll(AbstractWebSocket.this.w());
                    synchronized (AbstractWebSocket.this.i) {
                        nanoTime = (long) (((double) System.nanoTime()) - (((double) AbstractWebSocket.this.g) * 1.5d));
                    }
                    Iterator it = this.f3386a.iterator();
                    while (it.hasNext()) {
                        AbstractWebSocket.this.v((WebSocket) it.next(), nanoTime);
                    }
                } catch (Exception unused) {
                }
                this.f3386a.clear();
            }
        };
        ScheduledExecutorService scheduledExecutorService = this.e;
        long j = this.g;
        this.f = scheduledExecutorService.scheduleAtFixedRate(r2, j, j, TimeUnit.NANOSECONDS);
    }
}
